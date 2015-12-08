/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Marcado.java
 *
 * Created on 28-abr-2012, 16:36:12
 */
package com.gestionmatriz.recursoshumanos.gui;

import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.ui.swing.DPFPVerificationControl;
import com.digitalpersona.onetouch.ui.swing.DPFPVerificationEvent;
import com.digitalpersona.onetouch.ui.swing.DPFPVerificationListener;
import com.digitalpersona.onetouch.ui.swing.DPFPVerificationVetoException;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornadaContrato;
import com.gestionmatriz.recursoshumanos.servicio.MarcadoUsuario;
import com.gestionmatriz.util.Util;

import java.awt.Image;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import org.apache.log4j.Logger;

/**
 *
 * @author zholo
 */
public class Marcado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(Marcado.class);
//    private EnumMap<DPFPFingerIndex, DPFPTemplate> templates;
    private int farRequested;
    private int farAchieved;
    private DPFPVerificationControl verificationControl;
    private boolean matched;
    public static final String FAR_PROPERTY = "FAR";
    public static final String MATCHED_PROPERTY = "Matched";
    private HorarioJornadaContrato objHorarioJornadaContrato;
    private MarcadoUsuario frmMarcadoUsuario;
    private Principal gui;

    public HorarioJornadaContrato getObjHorarioJornadaContrato() {
        return objHorarioJornadaContrato;
    }

    public void setObjHorarioJornadaContrato(HorarioJornadaContrato objHorarioJornadaContrato) {
        this.objHorarioJornadaContrato = objHorarioJornadaContrato;
    }
    
    /**
     * Creates new form Marcado
     */
    public Marcado(Principal gui, int farRequested) {
        super(gui, true);
        this.gui=gui;
        initComponents();


//		this.templates = templates;
        this.farRequested = farRequested;

        setTitle("Fingerprint Verification");
        setResizable(false);

        verificationControl = new DPFPVerificationControl();
        verificationControl.addVerificationListener(new DPFPVerificationListener() {
            public void captureCompleted(DPFPVerificationEvent e) throws DPFPVerificationVetoException {
                DPFPFeatureSet fs = e.getFeatureSet();
//                            System.out.println("Paso dedo");

//				final DPFPVerification verification = 
//					DPFPGlobal.getVerificationFactory().createVerification(Marcado.this.farRequested);
                e.setStopCapture(false);	// we want to continue capture until the dialog is closed
//				int bestFAR = DPFPVerification.PROBABILITY_ONE;
//				boolean hasMatch = false;
//				for (DPFPTemplate template : Marcado.this.templates.values()) {
//					final DPFPVerificationResult result = verification.verify(e.getFeatureSet(), template);
//					e.setMatched(result.isVerified());		// report matching status
//					bestFAR = Math.min(bestFAR, result.getFalseAcceptRate());
//					if (e.getMatched()) {
//						hasMatch = true;
//						break;
//					}
//				}

//                                com.gestionmatriz.recursoshumanos.bean.Personal objPersonal=
//                                        PaqueteBusinessDelegate.getAsistenciaService().registrarAsistencia(e);
                HorarioJornadaContrato objHorarioJornadaContrato =
                        PaqueteBusinessDelegate.getAsistenciaService().registrarAsistencia(e, chbRefrigerio.isSelected());
                String str_fecha = PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql();

                if (objHorarioJornadaContrato == null) {
                    txtDetalleMarcado.setText("NO SE PUDO REGISTRAR LA ASISTENCIA, LOS POSIBLES MOTIVOS PUEDEN SER: \n"
                            + "********************************************************\n"
                            + "• Esta fuera del rango de marcado.\n"
                            + "• No cuenta con asistencia para el día de hoy.\n"
                            + "• No se Encuetra Registrado en el sistema.\n\n"
                            + "********************************************************\n"
                            + "► Para mayor información comuníquese con el área de Sistemas.");
                    lblFoto.setIcon(null);
                    return;
                }

                txtDetalleMarcado.setText("\nEmpleado: "
                        + objHorarioJornadaContrato.getObjContrato().getObjPersona().getStr_nombres() + " "
                        + objHorarioJornadaContrato.getObjContrato().getObjPersona().getStr_apePaterno() + " "
                        + objHorarioJornadaContrato.getObjContrato().getObjPersona().getStr_apeMaterno()
                        + "\n\nDia: " + Util.getNombreDia(Util.diaSemana(Util.StringTODate(str_fecha)) - 1)
                        + "\n\nHorario a Marcar: "
                        + objHorarioJornadaContrato.getObjListHorarioJornada().get(0).getObjJornada().getTme_HoraInicio().concat(" - ")
                        + objHorarioJornadaContrato.getObjListHorarioJornada().get(0).getObjJornada().getTme_horaFin()
                        + "\n\nHora Marcación: " + str_fecha
                        + "\n\nEstado: ");
//				setMatched(hasMatch);
//				setFAR(bestFAR);
                try {
                    if (objHorarioJornadaContrato.getObjContrato().getObjPersona().getImgRead() != null) {
                        Image foto = com.gestionmatriz.util.Util.ConvertirImagen(
                                objHorarioJornadaContrato.getObjContrato().getObjPersona().getImgRead());

                        ImageIcon iconofoto = new ImageIcon(foto);

                        Icon fotoIncono = com.gestionmatriz.util.Util.reducirFoto(
                                iconofoto, lblFoto.getWidth(), lblFoto.getHeight());

                        lblFoto.setIcon(fotoIncono);

                    }
                } catch (IOException ex) {
                    log.error("Error: " + ex.getMessage());
                }

            }
        });
        pack();


        setLocationRelativeTo(null);

    }

    public int getFAR() {
        return farAchieved;
    }

    protected void setFAR(int far) {
        final int old = getFAR();
        farAchieved = far;
        firePropertyChange(FAR_PROPERTY, old, getFAR());
    }

    public boolean getMatched() {
        return matched;
    }

    protected void setMatched(boolean matched) {
        final boolean old = getMatched();
        this.matched = matched;
        firePropertyChange(MATCHED_PROPERTY, old, getMatched());
    }

    /**
     * Shows or hides this component depending on the value of parameter
     * <code>b</code>.
     *
     * @param b if <code>true</code>, shows this component; otherwise, hides
     * this component
     * @see #isVisible
     * @since JDK1.1
     */
    public void setVisible(boolean b) {
        if (b) {
            matched = false;
            verificationControl.start();
        } else {
            if (!matched) {
                verificationControl.stop();
            }
        }
        super.setVisible(b);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        lblFoto = new org.jdesktop.swingx.JXLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXEditorPane1 = new org.jdesktop.swingx.JXEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetalleMarcado = new org.jdesktop.swingx.JXEditorPane();
        chbRefrigerio = new javax.swing.JCheckBox();
        btnMarcadoXUsuario = new org.jdesktop.swingx.JXButton();

        jCheckBox1.setText("jCheckBox1");

        setTitle("Marcado");
        setIconImage(null);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jXTitledPanel1.setTitle(" Marcado de Asistencia");
        jXTitledPanel1.setTitleFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18));

        jXPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jXPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/sombra.png"))); // NOI18N
        lblFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblFoto.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        jXEditorPane1.setBackground(new java.awt.Color(255, 255, 204));
        jXEditorPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jXEditorPane1.setEditable(false);
        jXEditorPane1.setText("1) Coloque  su dedo sobre el lector.\n2) Espere  a que su foto se muestre en la parte superior izquierda.\n3) Retire su dedo del lector.\n4) Verifique los datos de marcado se asistencia en la parte superior derecha\n");
        jScrollPane1.setViewportView(jXEditorPane1);

        txtDetalleMarcado.setBackground(new java.awt.Color(204, 255, 204));
        txtDetalleMarcado.setEditable(false);
        txtDetalleMarcado.setText("\nEmpleado: \n\nDia: \n\nHorario a Marcar:\n\nHora Marcación:\n\nEstado: ");
        jScrollPane2.setViewportView(txtDetalleMarcado);

        chbRefrigerio.setText("Marcado por Refrigerio");
        chbRefrigerio.setOpaque(false);

        btnMarcadoXUsuario.setText("Marcado Por Usuario");
        btnMarcadoXUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcadoXUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(btnMarcadoXUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                        .addComponent(chbRefrigerio))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chbRefrigerio)
                    .addComponent(btnMarcadoXUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
            .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXTitledPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnMarcadoXUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcadoXUsuarioActionPerformed
// TODO add your handling code here:
    
    if (frmMarcadoUsuario==null)
        frmMarcadoUsuario=new MarcadoUsuario(gui, this,chbRefrigerio.isSelected());
    
    frmMarcadoUsuario.setTipoMarcado(chbRefrigerio.isSelected());
    frmMarcadoUsuario.setVisible(true);
    
    if (objHorarioJornadaContrato!=null)
    {
        String str_fecha = PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql();
        txtDetalleMarcado.setText("\nEmpleado: "
                        + objHorarioJornadaContrato.getObjContrato().getObjPersona().getStr_nombres() + " "
                        + objHorarioJornadaContrato.getObjContrato().getObjPersona().getStr_apePaterno() + " "
                        + objHorarioJornadaContrato.getObjContrato().getObjPersona().getStr_apeMaterno()
                        + "\n\nDia: " + Util.getNombreDia(Util.diaSemana(Util.StringTODate(str_fecha)) - 1)
                        + "\n\nHorario a Marcar: "
                        + objHorarioJornadaContrato.getObjListHorarioJornada().get(0).getObjJornada().getTme_HoraInicio().concat(" - ")
                        + objHorarioJornadaContrato.getObjListHorarioJornada().get(0).getObjJornada().getTme_horaFin()
                        + "\n\nHora Marcación: " + str_fecha
                        + "\n\nEstado: ");
        
        
    }
    else
    {
        txtDetalleMarcado.setText("NO SE PUDO REGISTRAR LA ASISTENCIA, LOS POSIBLES MOTIVOS PUEDEN SER: \n"
                            + "********************************************************\n"
                            + "• Esta fuera del rango de marcado.\n"
                            + "• No cuenta con asistencia para el día de hoy.\n"
                            + "• No se Encuetra Registrado en el sistema.\n\n"
                            + "********************************************************\n"
                            + "► Para mayor información comuníquese con el área de Sistemas.");
                    lblFoto.setIcon(null);
                    return;
    }
}//GEN-LAST:event_btnMarcadoXUsuarioActionPerformed
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Marcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Marcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Marcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Marcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new Marcado().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnMarcadoXUsuario;
    private javax.swing.JCheckBox chbRefrigerio;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXEditorPane jXEditorPane1;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private org.jdesktop.swingx.JXLabel lblFoto;
    private org.jdesktop.swingx.JXEditorPane txtDetalleMarcado;
    // End of variables declaration//GEN-END:variables
}
