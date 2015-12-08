/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuscarAsistencia.java
 *
 * Created on 09-may-2012, 10:22:33
 */
package com.gestionmatriz.recursoshumanos.gui;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.recursoshumanos.reportes.Ireport;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import com.gestionmatriz.util.ValidarCamposNulos;
import java.awt.Frame;
import java.util.List;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author zholo
 */
public class BuscarAsistencia extends javax.swing.JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Frame gui;
    private final int idEmpresa;
    private final  Ireport ireport=new Ireport();
    private List<com.gestionmatriz.recursoshumanos.bean.Personal>lista;
            

    public BuscarAsistencia(Frame gui,int idEmpresa) {
        super(gui,true);
        this.gui=gui;
        this.idEmpresa=idEmpresa;
        initComponents(); 
        setLocationRelativeTo(null);
        cboTrabajadores.setEnabled(true);
        
    }

    public BuscarAsistencia(Frame gui,int idEmpresa,int idPersona) {
        
        super(gui,true);
        this.gui=gui;
        this.idEmpresa=idEmpresa;
        initComponents(); 
        setLocationRelativeTo(null);
        int i=0;
        
        cargarComboTrabajadores(idEmpresa);
        
        for (com.gestionmatriz.recursoshumanos.bean.Personal personal : lista) {
           
            if (idPersona==Util.stringTOint(
                personal.getStr_codigo().substring(1)))
            {
                cboTrabajadores.setSelectedIndex(i+1);
                break;
            }
            i++;
        }
        
        cboTrabajadores.setEnabled(false);
    }
    
    
    
    
   public void cargarComboTrabajadores(int idEmpresa){
    
       lista=PaqueteBusinessDelegate.getPersonalService().
            BuscarPersonaXEmpresa(idEmpresa);
            
    cboTrabajadores.addItem(".::Seleccionar un trabajador::.");
        for (com.gestionmatriz.recursoshumanos.bean.Personal personal : lista) {
            
            cboTrabajadores.addItem(personal.getStr_codigo()+" - "+personal.getStr_apePaterno()+" "+
                    personal.getStr_apeMaterno()+" "+personal.getStr_nombres());
        }    
    
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBuscarAsistencia = new org.jdesktop.swingx.JXPanel();
        cboTrabajadores = new org.jdesktop.swingx.JXComboBox();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        dtpFechaInicioConsultastrabajador = new org.jdesktop.swingx.JXDatePicker();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        jXLabel14 = new org.jdesktop.swingx.JXLabel();
        dtpFechaFinalConsultasTrabajadores = new org.jdesktop.swingx.JXDatePicker();
        btnVerReporteTrabajdor = new org.jdesktop.swingx.JXButton();
        btnVerDescansoTrabajador = new org.jdesktop.swingx.JXButton();
        btnReportePartTime = new org.jdesktop.swingx.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlBuscarAsistencia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Asistencia por Trabajador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlBuscarAsistencia.setLayout(null);

        cboTrabajadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlBuscarAsistencia.add(cboTrabajadores);
        cboTrabajadores.setBounds(276, 30, 370, 20);

        jXLabel1.setText("Seleccione un Trabajador de la lista: ");
        pnlBuscarAsistencia.add(jXLabel1);
        jXLabel1.setBounds(40, 30, 226, 20);

        dtpFechaInicioConsultastrabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlBuscarAsistencia.add(dtpFechaInicioConsultastrabajador);
        dtpFechaInicioConsultastrabajador.setBounds(120, 80, 130, 22);

        jXLabel13.setText("Fecha Inicio:");
        pnlBuscarAsistencia.add(jXLabel13);
        jXLabel13.setBounds(40, 80, 70, 14);

        jXLabel14.setText("Fecha Final:");
        pnlBuscarAsistencia.add(jXLabel14);
        jXLabel14.setBounds(300, 80, 70, 14);

        dtpFechaFinalConsultasTrabajadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlBuscarAsistencia.add(dtpFechaFinalConsultasTrabajadores);
        dtpFechaFinalConsultasTrabajadores.setBounds(380, 80, 130, 22);

        btnVerReporteTrabajdor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/vistaprevia.png"))); // NOI18N
        btnVerReporteTrabajdor.setText("Crear reporte de asistencia");
        btnVerReporteTrabajdor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerReporteTrabajdor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReporteTrabajdorActionPerformed(evt);
            }
        });
        pnlBuscarAsistencia.add(btnVerReporteTrabajdor);
        btnVerReporteTrabajdor.setBounds(20, 120, 210, 30);

        btnVerDescansoTrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/vistaprevia.png"))); // NOI18N
        btnVerDescansoTrabajador.setText("Crear reporte de descansos");
        btnVerDescansoTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDescansoTrabajadorActionPerformed(evt);
            }
        });
        pnlBuscarAsistencia.add(btnVerDescansoTrabajador);
        btnVerDescansoTrabajador.setBounds(240, 120, 200, 30);

        btnReportePartTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/vistaprevia.png"))); // NOI18N
        btnReportePartTime.setText("Crear reporte PartTime");
        btnReportePartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportePartTimeActionPerformed(evt);
            }
        });
        pnlBuscarAsistencia.add(btnReportePartTime);
        btnReportePartTime.setBounds(450, 120, 200, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBuscarAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBuscarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnVerReporteTrabajdorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReporteTrabajdorActionPerformed
    JXDatePicker[]dtps={
    dtpFechaFinalConsultasTrabajadores,
    dtpFechaInicioConsultastrabajador
    };
    
    if(cboTrabajadores.getSelectedIndex()<=0){
        Mensaje.mensaje(this,"Debe seleccionar un trabajador", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if(ValidarCamposNulos.validarDatePicker(dtps)==true){
            String str_Codigo=null;
            for (com.gestionmatriz.recursoshumanos.bean.Personal personal : lista) {
                str_Codigo=lista.get(cboTrabajadores.getSelectedIndex()-1).getStr_codigo();
            }
//            System.out.println("Codigo--:"+str_Codigo);

            if(str_Codigo==null){
                Mensaje.mensaje(this,"Debe seleccionar un trabajador de la lista",Mensaje.TITULO_ME, Mensaje.ERROR);
            }else{

                String fechaInicial=Util.getFecha("yyyy-MM-dd", dtpFechaInicioConsultastrabajador.getDate());
                String fechaFinal=Util.getFecha("yyyy-MM-dd", dtpFechaFinalConsultasTrabajadores.getDate());
//                System.out.println("fi--:"+fechaInicial);
//                System.out.println("fF--:"+fechaFinal);//AsistenciaTrabajador
                ireport.verAsistenciaXTrabajadorFecha(str_Codigo, fechaInicial, fechaFinal, "AsistenciaTrabajador");
                this.setVisible(false);
            }
   }else{
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
    }
}//GEN-LAST:event_btnVerReporteTrabajdorActionPerformed

private void btnVerDescansoTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDescansoTrabajadorActionPerformed
JXDatePicker[]dtps={
    dtpFechaFinalConsultasTrabajadores,
    dtpFechaInicioConsultastrabajador
    };
    
    if(cboTrabajadores.getSelectedIndex()<=0){
        Mensaje.mensaje(this,"Debe seleccionar un trabajador", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if(ValidarCamposNulos.validarDatePicker(dtps)==true){
            String str_Codigo=null;
            for (com.gestionmatriz.recursoshumanos.bean.Personal personal : lista) {
                str_Codigo=lista.get(cboTrabajadores.getSelectedIndex()-1).getStr_codigo();
            }
           // System.out.println("Codigo--:"+str_Codigo);

            if(str_Codigo==null){
                Mensaje.mensaje(this,"Debe seleccionar un trabajador de la lista",Mensaje.TITULO_ME, Mensaje.ERROR);
            }else{

                String fechaInicial=Util.getFecha("yyyy-MM-dd", dtpFechaInicioConsultastrabajador.getDate());
                String fechaFinal=Util.getFecha("yyyy-MM-dd", dtpFechaFinalConsultasTrabajadores.getDate());
                int idPersona= Integer.parseInt(str_Codigo.substring(1));
                //System.out.println("idPersona---:"+idPersona);
                ireport.verDescansoXTrabajadorFecha(idPersona, fechaInicial, fechaFinal, "DescansoTrabajador");
                this.setVisible(false);
            }
   }else{
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
    }
}//GEN-LAST:event_btnVerDescansoTrabajadorActionPerformed

private void btnReportePartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportePartTimeActionPerformed
    JXDatePicker[]dtps={
    dtpFechaFinalConsultasTrabajadores,
    dtpFechaInicioConsultastrabajador
    };
    
    if(cboTrabajadores.getSelectedIndex()<=0){
        Mensaje.mensaje(this,"Debe seleccionar un trabajador", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if(ValidarCamposNulos.validarDatePicker(dtps)==true){
            String str_Codigo=null;
            for (com.gestionmatriz.recursoshumanos.bean.Personal personal : lista) {
                str_Codigo=lista.get(cboTrabajadores.getSelectedIndex()-1).getStr_codigo();
            }
           
            
            if(str_Codigo==null){
                Mensaje.mensaje(this,"Debe seleccionar un trabajador de la lista",Mensaje.TITULO_ME, Mensaje.ERROR);
            }else{

                String fechaInicial=Util.getFecha("yyyy-MM-dd", dtpFechaInicioConsultastrabajador.getDate());
                String fechaFinal=Util.getFecha("yyyy-MM-dd", dtpFechaFinalConsultasTrabajadores.getDate());
                int idPersona= Integer.parseInt(str_Codigo.substring(1));
                int idContrato=PaqueteBusinessDelegate.getContratoService().idContrato(idPersona);
                
                ireport.verReportePartTime(idContrato, fechaInicial, fechaFinal, "PartTime");
                this.setVisible(false);
            }
   }else{
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
    }    
    
    
}//GEN-LAST:event_btnReportePartTimeActionPerformed






//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(BuscarAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BuscarAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BuscarAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BuscarAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                BuscarAsistencia dialog = new BuscarAsistencia(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnReportePartTime;
    private org.jdesktop.swingx.JXButton btnVerDescansoTrabajador;
    private org.jdesktop.swingx.JXButton btnVerReporteTrabajdor;
    private org.jdesktop.swingx.JXComboBox cboTrabajadores;
    private org.jdesktop.swingx.JXDatePicker dtpFechaFinalConsultasTrabajadores;
    private org.jdesktop.swingx.JXDatePicker dtpFechaInicioConsultastrabajador;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel13;
    private org.jdesktop.swingx.JXLabel jXLabel14;
    private org.jdesktop.swingx.JXPanel pnlBuscarAsistencia;
    // End of variables declaration//GEN-END:variables

    public void setVisible(boolean b) {
        super.setVisible(b);
 
    }
}
