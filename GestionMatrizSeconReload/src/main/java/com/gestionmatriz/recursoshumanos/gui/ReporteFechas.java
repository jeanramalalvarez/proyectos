/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReporteFechas.java
 *
 * Created on 14-may-2012, 11:23:19
 */
package com.gestionmatriz.recursoshumanos.gui;

import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.opciones.Opciones;
import com.gestionmatriz.recursoshumanos.reportes.Ireport;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import com.gestionmatriz.util.ValidarCamposNulos;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author zholo
 */
public class ReporteFechas extends javax.swing.JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates new form ReporteFechas */
    public ReporteFechas(Principal gui) {
        this.gui=gui;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        cboReportes = new org.jdesktop.swingx.JXComboBox();
        dtpFechaIni = new org.jdesktop.swingx.JXDatePicker();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        dtpFechaFin = new org.jdesktop.swingx.JXDatePicker();
        btnGenerarReporteFechas = new org.jdesktop.swingx.JXButton();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        txtAsuntoMemo = new org.jdesktop.swingx.JXTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("REPORTES POR FECHAS");

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Reportes por Fechas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXLabel1.setText("Elegir Reporte");

        cboReportes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".::Seleccione una Opción::.", "Permisos", "Memorandum" }));
        cboReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        dtpFechaIni.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jXLabel2.setText("Fecha Inicial");

        jXLabel3.setText("Fecha Final");

        dtpFechaFin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnGenerarReporteFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/vistaprevia.png"))); // NOI18N
        btnGenerarReporteFechas.setText("Generar Reporte");
        btnGenerarReporteFechas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarReporteFechas.setPreferredSize(new java.awt.Dimension(137, 23));
        btnGenerarReporteFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteFechasActionPerformed(evt);
            }
        });

        jXLabel4.setText("Asunto Memorandum:");

        txtAsuntoMemo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dtpFechaIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addComponent(jXLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addGap(59, 59, 59))
                            .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAsuntoMemo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dtpFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                        .addComponent(btnGenerarReporteFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225))))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAsuntoMemo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dtpFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dtpFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerarReporteFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGenerarReporteFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteFechasActionPerformed
    JXDatePicker[]dtps={
    dtpFechaFin,
    dtpFechaIni
    };
    if(ValidarCamposNulos.validarDatePicker(dtps)==true){
        String fechaIni=Util.getFecha("yyyy-MM-dd", dtpFechaIni.getDate());
        String fechaFin=Util.getFecha("yyyy-MM-dd", dtpFechaFin.getDate());
        String asunto="%"+txtAsuntoMemo.getText()+"%";
        if(cboReportes.getSelectedItem().toString().
                        equalsIgnoreCase("Memorandum")&&!asunto.equalsIgnoreCase("")){
                        
            if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREPORTEMEMORANDUM())){
                Mensaje.mensaje(this,"Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
                return;
            }
               ireport.verMMemorandumFecha(fechaIni, fechaFin, asunto, "MemorandumFecha");
                    
        }else if(cboReportes.getSelectedItem().toString().
                        equalsIgnoreCase("Permisos")){
            
            if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREPORTEPERMISOS())){
                Mensaje.mensaje(this,"Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
                return;
            }
            
               ireport.verPermisoFechas(fechaIni, fechaFin, "PermisoFechas");
        }else{
            Mensaje.mensaje(this, "Debe Seleccionar una opción", Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
        }
    }else{
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
    }
}//GEN-LAST:event_btnGenerarReporteFechasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnGenerarReporteFechas;
    private org.jdesktop.swingx.JXComboBox cboReportes;
    private org.jdesktop.swingx.JXDatePicker dtpFechaFin;
    private org.jdesktop.swingx.JXDatePicker dtpFechaIni;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXTextField txtAsuntoMemo;
    // End of variables declaration//GEN-END:variables

    private Principal gui;
     private Ireport ireport= new Ireport();
     
     @Override
    public void dispose() {
//        try {
            gui.getBarraEstado().cerraVentana();
//            setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
//            this.setClosed(true);
//        } catch (PropertyVetoException ex) {
//            log.error("Error al Intentar Cerrar Ventana Persona: "+ex.getMessage());
//        }
    }
}