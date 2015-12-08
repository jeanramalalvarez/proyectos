/*
 * ConsultarContrato.java
 *
 * Created on 09-jun-2012, 9:30:51
 */
package com.gestionmatriz.recursoshumanos.gui;

import com.gestionmatriz.util.Util;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.Personal;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JDialog;

import org.apache.log4j.Logger;

/**
 *
 * @author YESM
 */
public class ConsultarContrato extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(ConsultarContrato.class); 
    private List<Empresa> listaEmpresa;
    private List<Personal> listaPersona;
    public static int indexEmpresa;
    public static String indexPersona;
    public static String indexEstado;    
    private Principal gui;

    public ConsultarContrato(Principal gui) {
        super(gui, true);
        this.gui = gui;
        initComponents();
        cargarDataGUI();
        cargarComboEstado();
        setLocationRelativeTo(null);
    }

    
    private void initComponents() {

        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        cboEmpresa = new org.jdesktop.swingx.JXComboBox();
        cboPersona = new org.jdesktop.swingx.JXComboBox();
        cboEstado = new org.jdesktop.swingx.JXComboBox();
        btnBuscar = new org.jdesktop.swingx.JXButton();
        btnCancelar = new org.jdesktop.swingx.JXButton();

        setTitle("Busqueda de Contratos");

        jXLabel1.setText("Empresa: ");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));

        jXLabel2.setText("Empleado: ");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));

        jXLabel3.setText("Estado: ");
        jXLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));

        cboEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmpresaActionPerformed(evt);
            }
        });

        cboPersona.setEditable(true);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setMaximumSize(new java.awt.Dimension(89, 23));
        btnBuscar.setMinimumSize(new java.awt.Dimension(89, 23));
        btnBuscar.setPreferredSize(new java.awt.Dimension(89, 23));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/eliminar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(99, 23));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboPersona, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(cboEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(cboEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    setVisible(false);
}//GEN-LAST:event_btnCancelarActionPerformed

private void cboEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmpresaActionPerformed
    int indice = cboEmpresa.getSelectedIndex();
    if (indice >= 1) {
        listaPersona = PaqueteBusinessDelegate.getContratoService().
                listaPersonasXEmpresa(listaEmpresa.get(indice - 1).getInt_idEmpresa());

        cboPersona.removeAllItems();
        cboPersona.addItem(".::Seleccione Empleado::.");
        for (Personal personal : listaPersona) {
            cboPersona.addItem(personal.getStr_nombres().concat(" ").
                    concat(personal.getStr_apePaterno()).concat(" ").
                    concat(personal.getStr_apeMaterno()));
        }
        cboPersona.requestFocus();
    }
}//GEN-LAST:event_cboEmpresaActionPerformed

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    indexEmpresa = listaEmpresa.get(cboEmpresa.getSelectedIndex() - 1).getInt_idEmpresa();
    indexPersona = listaPersona.get(cboPersona.getSelectedIndex() - 1).getStr_codigo();
    indexEstado = cboEstado.getSelectedItem().toString();
    
    setVisible(false);
}//GEN-LAST:event_btnBuscarActionPerformed

    public void setVisible(boolean b) {
        super.setVisible(b);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscar;
    private org.jdesktop.swingx.JXButton btnCancelar;
    private org.jdesktop.swingx.JXComboBox cboEmpresa;
    private org.jdesktop.swingx.JXComboBox cboEstado;
    private org.jdesktop.swingx.JXComboBox cboPersona;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    // End of variables declaration//GEN-END:variables

    private void cargarDataGUI() {
        try {
            //Cargamos empresas
            listaEmpresa = PaqueteBusinessDelegate.getContratoService().listarEmpresa();
            Object obj = ".::Seleccione una Empresa::.";

            cboEmpresa.removeAllItems();
            cboEmpresa.addItem(obj);

            for (Empresa empresa : listaEmpresa) {
                cboEmpresa.addItem(empresa.getStr_razonSocial());
            }

        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        }
    }
    
    private void cargarComboEstado() {
        cboEstado.removeAllItems();
        cboEstado.addItem(Util.ACTIVO);
        cboEstado.addItem(Util.INACTIVO);
    }
}
