/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.List;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

/**
 *
 * @author cesareots
 */
public class Correlativo extends javax.swing.JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal gui;

    public Correlativo(Principal gui) {
        this.gui = gui;
        initComponents();
        cargar(false);
    }

    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarDocumento = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDetalle = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNro1 = new javax.swing.JTextField();
        txtNro2 = new javax.swing.JTextField();
        txtNro3 = new javax.swing.JTextField();
        btnGrabar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("CONFIGURACIÓN DE CORRELATIVOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar documento"));

        jLabel1.setText("N° Documento");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtAreaDetalle.setColumns(20);
        txtAreaDetalle.setRows(5);
        jScrollPane1.setViewportView(txtAreaDetalle);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Correción de documento"));

        jLabel2.setText("N° Documento");

        txtNro1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNro1KeyReleased(evt);
            }
        });

        txtNro2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNro2KeyReleased(evt);
            }
        });

        txtNro3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNro3KeyReleased(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNro1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNro2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNro3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGrabar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNro3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrabar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        List<Object> listaConsulta = PaqueteBusinessDelegate.getVentasService().
                consultaVentaXDocumento(txtBuscarDocumento.getText().trim(), gui.getLocal().getInt_idLocal());
        Ventas objVentas = null;

        if (listaConsulta.size() > 0) {
            objVentas = (Ventas) listaConsulta.get(0);

            txtAreaDetalle.setText("");
            imprimirFor("=", 70);
            imprimir("Cliente: \t" + objVentas.getObjCliente().getStr_razonSocial() + "\n");
            imprimir("Ruc/DNI: \t" + objVentas.getObjCliente().getStr_rucdni() + "\n");
            imprimir("Dirección: \t" + objVentas.getObjCliente().getStr_direccion() + "\n");
            imprimir("N° Documento: \t" + objVentas.getStr_numeroDocumento() + "\n");
            imprimir("Fecha: \t" + objVentas.getStr_fechaRegistro() + "\n");
            imprimir("Vendedor: \t" + objVentas.getStr_usuario() + "\n");

            imprimirFor("=", 70);
            imprimirFor("_", 70);
            imprimir("Codigo\tCantidad\tDescripcion\t\t\tSub-Total\n");
            imprimirFor("_", 70);

            BigDecimal subTotal = BigDecimal.ZERO	;
            BigDecimal descuento = BigDecimal.ZERO;

            for (Object object : listaConsulta) {
                objVentas = (Ventas) object;
                imprimir(objVentas.getObjProducto().getStr_codigoInterno() + "\t"
                        + objVentas.getDbCantidad() + "\t"
                        + Util.arreglarCadena(objVentas.getObjProducto().getStr_nombreProducto()) + "\t"
                        + objVentas.getDbSubtotal() + "\n");
                subTotal=subTotal.add( objVentas.getDbSubtotal());
                descuento = descuento.add(objVentas.getDbdescuento());
            }

            imprimirFor("_", 70);
            imprimir("\t\t\t\tSub total:\t" + Util.redondeo(subTotal, 2) + "\n");
            imprimir("\t\t\t\tDescuento:\t" + Util.redondeo(descuento, 2) + "\n");
            imprimir("\t\t\t\t___________________\n");
            imprimir("\t\t\t\tTotal:    \t" + Util.redondeo((subTotal.subtract(descuento)), 2));

            activarPostBuscar();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtNro1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNro1KeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)) {
            txtNro1.setText(txtNro1.getText().toUpperCase().trim());
            txtNro2.selectAll();
            txtNro2.requestFocus();
        }
    }//GEN-LAST:event_txtNro1KeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        String documento = txtNro1.getText().toUpperCase().trim().
                concat("-" + txtNro2.getText().toUpperCase().trim()).
                concat("-" + txtNro3.getText().toUpperCase().trim());
        
        List<Object> listaConsulta = PaqueteBusinessDelegate.getVentasService().
                consultaVentaXDocumento(documento, gui.getLocal().getInt_idLocal());

        if (listaConsulta.size() > 0) {
            Mensaje.mensaje(this, "Documento ingresado ya existe", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            txtNro1.selectAll();
            txtNro1.requestFocus();
            return;
        }
        
        

        limpiar();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void txtNro2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNro2KeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)) {
            txtNro3.selectAll();
            txtNro3.requestFocus();
        }
    }//GEN-LAST:event_txtNro2KeyReleased

    private void txtNro3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNro3KeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)) {
            btnGrabar.requestFocus();
        }
    }//GEN-LAST:event_txtNro3KeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaDetalle;
    private javax.swing.JTextField txtBuscarDocumento;
    private javax.swing.JTextField txtNro1;
    private javax.swing.JTextField txtNro2;
    private javax.swing.JTextField txtNro3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        super.dispose();
        gui.getBarraEstado().cerraVentana();
    }

    private void cargar(boolean b) {
        txtNro1.setEditable(b);
        txtNro2.setEditable(b);
        txtNro3.setEditable(b);
        btnGrabar.setEnabled(b);
    }

    private void imprimir(String str) {
        txtAreaDetalle.append(str);
    }

    private void imprimirFor(String str, int limite) {
        for (int i = 0; i < limite; i++) {
            imprimir(str);
        }
        
        imprimir("\n");
    }

    private void limpiar() {
        txtBuscarDocumento.setText("");
        txtAreaDetalle.setText("");
        txtNro1.setText("");
        txtNro2.setText("");
        txtNro3.setText("");
        txtBuscarDocumento.setEditable(true);
        btnBuscar.setEnabled(true);
        cargar(false);
    }

    private void activarPostBuscar() {
        txtBuscarDocumento.setEditable(false);
        btnBuscar.setEnabled(false);
        cargar(true);
        txtNro1.requestFocus();
    }
}
