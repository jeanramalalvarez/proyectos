/*
 * OrdenCompraPrevio.java
 *
 * Created on 30-jun-2012, 9:54:08
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

/**
 *
 * @author cesareo
 */
public class OrdenCompraPrevio extends javax.swing.JDialog {

	private static final Logger log=Logger.getLogger(GestionPrecioOferta.class);
    private Principal gui;
    private List<Empresa> listaEmpresa;
    private Empresa objEmpresa;
    private OrdenCompra frmOrdenCompra;
    private String NOC;

    public OrdenCompraPrevio(Principal gui) {
        super(gui, true);
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

    
    private void initComponents() {

        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        lblNombreEmpresa = new org.jdesktop.swingx.JXLabel();
        cboEmpresa = new org.jdesktop.swingx.JXComboBox();
        btnAceptar = new org.jdesktop.swingx.JXButton();
        btnCancelar = new org.jdesktop.swingx.JXButton();
        lblNumeroOC = new org.jdesktop.swingx.JXLabel();
        txtNumeroOC = new org.jdesktop.swingx.JXTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orden de Compra");
        setResizable(false);

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar Empresa"));

        lblNombreEmpresa.setText("Empresa:");

        cboEmpresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboEmpresaItemStateChanged(evt);
            }
        });

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/eliminar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblNumeroOC.setText("Número Orden Compra:");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroOC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroOC, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addComponent(cboEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroOC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroOC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
    if (cboEmpresa.getSelectedIndex() == 0) {
        Mensaje.mensaje(this, "Seleccionar una empresa", Mensaje.TITULO_ME, Mensaje.INFORMACION);
    } else {
        objEmpresa = listaEmpresa.get(cboEmpresa.getSelectedIndex() - 1);
        Util.hiloProgressBar(1, gui);
        if (frmOrdenCompra == null || frmOrdenCompra.isClosed()) {           
//      Prueba temporal cambiar al final
            NOC=txtNumeroOC.getText();
            
            frmOrdenCompra = new OrdenCompra(gui, objEmpresa, NOC);
            frmOrdenCompra.setVisible(true);
            gui.addFrm(frmOrdenCompra);
            gui.enforcar(frmOrdenCompra);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmOrdenCompra);
//            frmOrdenCompra.setLocation(frmOrdenCompra.getWidth(), frmOrdenCompra.getHeight()+10);
        }
        Util.hiloProgressBar(0, gui);
        this.setVisible(false);
    }
}//GEN-LAST:event_btnAceptarActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    this.setVisible(false);
}//GEN-LAST:event_btnCancelarActionPerformed

    private void cboEmpresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboEmpresaItemStateChanged
        btnAceptar.requestFocus();
    }//GEN-LAST:event_cboEmpresaItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAceptar;
    private org.jdesktop.swingx.JXButton btnCancelar;
    private org.jdesktop.swingx.JXComboBox cboEmpresa;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXLabel lblNombreEmpresa;
    private org.jdesktop.swingx.JXLabel lblNumeroOC;
    private org.jdesktop.swingx.JXTextField txtNumeroOC;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
        cargarEmpresa();
        NOC = generarNumeroOrdenCompra();
        txtNumeroOC.setText(NOC);
        txtNumeroOC.setEditable(false);
        cboEmpresa.requestFocus();
        setLocationRelativeTo(null);
        this.cboEmpresa.setSelectedItem(this.gui.getEmpresa().getStr_razonSocial());
    }

    private void cargarEmpresa() {
        try {
            listaEmpresa = PaqueteBusinessDelegate.getOrdenCompraService().listarEmpresa();

            cboEmpresa.removeAllItems();
            cboEmpresa.addItem(".::Seleccionar Empresa::.");

            for (Empresa empresa : listaEmpresa) {
                cboEmpresa.addItem(empresa.getStr_razonSocial());
            }
        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        }
    }

    protected static String generarNumeroOrdenCompra() {
        String[] arrSplit;
        String noc = "";
        int i;
        String OrdenCompraUltimoID = PaqueteBusinessDelegate.getOrdenCompraService().listarOCUltimoID();

        if (OrdenCompraUltimoID.equals("")) {
            noc = "OC-".concat("100");
        } else {
            arrSplit = OrdenCompraUltimoID.split("-");
            i = Util.stringTOint(arrSplit[1]) + 1;
            noc = "OC-".concat(String.valueOf(i));
        }

        return noc;
    }
}
