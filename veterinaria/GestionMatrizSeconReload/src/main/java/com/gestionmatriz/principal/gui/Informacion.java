/*
 * BuscarPersona.java
 *
 * Created on 23-abr-2012, 18:04:51
 */
package com.gestionmatriz.principal.gui;

import java.awt.Frame;

import javax.swing.JDialog;
/**
 *
 * @author YESM
 */
public class Informacion extends JDialog {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Frame gui;    
    private int puntero = -1;

    public Informacion(Frame gui) {
        super(gui, true);
        this.gui = gui;
        initComponents();
        this.setTitle(gui.getTitle() + " - INFORMACIÓN DEL SISTEMA");
        this.setSize(575, 350);
        setLocationRelativeTo(null);
    }
    

    private void initComponents() {

        btnSalir = new org.jdesktop.swingx.JXButton();
        pnlSistema = new org.jdesktop.swingx.JXPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSistema = new org.jdesktop.swingx.JXTextArea();

        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/salirmini.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setPreferredSize(new java.awt.Dimension(77, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(230, 240, 110, 23);

        pnlSistema.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Acerca del Sistema", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlSistema.setOpaque(false);

        txtSistema.setColumns(20);
        txtSistema.setEditable(false);
        txtSistema.setRows(7);
        txtSistema.setText("Sistema de Gestión: \t       \tMatriz \nVersion: \t\t\t1.0\nTipo de Licencia: \t\tPermanente\nLicenciado para: \t\tCOMERCIAL IQUITOS S.A.\nDesarrollado por: \t\tJAR CONSULTING S.R.L.\n\t\t      \n\t\t      © DERECHOS RESERVADOS\n  \t\t      JAR CONSULTING S.R.L.\t\n\t\n");
        txtSistema.setOpaque(false);
        jScrollPane1.setViewportView(txtSistema);

        javax.swing.GroupLayout pnlSistemaLayout = new javax.swing.GroupLayout(pnlSistema);
        pnlSistema.setLayout(pnlSistemaLayout);
        pnlSistemaLayout.setHorizontalGroup(
            pnlSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSistemaLayout.setVerticalGroup(
            pnlSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSistemaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlSistema);
        pnlSistema.setBounds(10, 10, 550, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    this.setVisible(false);
}//GEN-LAST:event_btnSalirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXPanel pnlSistema;
    private org.jdesktop.swingx.JXTextArea txtSistema;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }
}
