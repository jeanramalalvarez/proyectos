/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.Cliente;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

/**
 *
 * @author cesareo
 */
public class PreVenta extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal gui;
    private Cliente objCliente = null;
    private Venta guiVenta;

    public PreVenta(Principal gui, Venta guiVenta) {
        super(gui, true);
        this.gui = gui;
        this.guiVenta = guiVenta;
        initComponents();
        cargarDatos();
        setLocationRelativeTo(null);
        recalcularTotal();
    }

    
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnEnviar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        rbnBoleta = new javax.swing.JRadioButton();
        rbnFactura = new javax.swing.JRadioButton();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtRucDNI = new javax.swing.JTextField();
        txtClienteResponsable = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        txtSubTotal = new org.jdesktop.swingx.JXTextField();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtDescuento = new org.jdesktop.swingx.JXTextField();
        txtIGV = new org.jdesktop.swingx.JXTextField();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        txtTotal = new org.jdesktop.swingx.JXTextField();
        btnEnviar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        btnEnviar.setText("Vender (F9)");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        btnEnviar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbnBoletaKeyPressed(evt);
            }
        });

        btnCancelar.setText("Regresar (F12)");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbnBoletaKeyPressed(evt);
            }
        });

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Documento"));

        buttonGroup1.add(rbnBoleta);
        rbnBoleta.setText("BOLETA");
        rbnBoleta.setNextFocusableComponent(rbnFactura);
        rbnBoleta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbnBoletaKeyPressed(evt);
            }
        });

        buttonGroup1.add(rbnFactura);
        rbnFactura.setText("FACTURA");
        rbnFactura.setNextFocusableComponent(btnBuscar);
        rbnFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbnFacturaMouseClicked(evt);
            }
        });
        rbnFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbnBoletaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbnBoleta)
                .addGap(29, 29, 29)
                .addComponent(rbnFactura)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rbnBoleta)
                .addComponent(rbnFactura))
        );

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));

        jLabel1.setText("Cliente:");

        txtCliente.setEditable(false);
        txtCliente.setFocusable(false);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar (F4)");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbnBoletaKeyPressed(evt);
            }
        });

        jLabel2.setText("RUC / DNI: ");

        txtRucDNI.setEditable(false);
        txtRucDNI.setFocusable(false);

        txtClienteResponsable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClienteResponsableKeyPressed(evt);
            }
        });

        jLabel3.setText("Cliente: ");

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtClienteResponsable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(txtRucDNI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRucDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClienteResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jXPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Venta"));

        txtSubTotal.setBackground(new java.awt.Color(0, 0, 0));
        txtSubTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        txtSubTotal.setEditable(false);
        txtSubTotal.setForeground(new java.awt.Color(255, 102, 0));
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubTotal.setFocusable(false);
        txtSubTotal.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        jXLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jXLabel1.setText("SubTotal: ");

        jXLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jXLabel2.setText("Descuento (-):");

        txtDescuento.setBackground(new java.awt.Color(0, 0, 0));
        txtDescuento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        txtDescuento.setEditable(false);
        txtDescuento.setForeground(new java.awt.Color(255, 102, 0));
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescuento.setFocusable(false);
        txtDescuento.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        txtIGV.setBackground(new java.awt.Color(0, 0, 0));
        txtIGV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        txtIGV.setEditable(false);
        txtIGV.setForeground(new java.awt.Color(255, 102, 0));
        txtIGV.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIGV.setFocusable(false);
        txtIGV.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        jXLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jXLabel3.setText("IGV (+): ");

        jXLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jXLabel4.setText("Total");

        txtTotal.setBackground(new java.awt.Color(0, 0, 0));
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        txtTotal.setEditable(false);
        txtTotal.setForeground(new java.awt.Color(255, 102, 0));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setFocusable(false);
        txtTotal.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(txtIGV, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnEnviar1.setText("Proforma (F7)");
        btnEnviar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviar1ActionPerformed(evt);
            }
        });
        btnEnviar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEnviar1rbnBoletaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jXPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addComponent(btnEnviar1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                            .addGap(111, 111, 111))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEnviar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        cargarBusquedaCliente();
    }//GEN-LAST:event_btnBuscarActionPerformed

private void rbnFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbnFacturaMouseClicked
    if (txtRucDNI.getText().length() != 11) {
        rbnBoleta.setSelected(true);
    }
}//GEN-LAST:event_rbnFacturaMouseClicked

private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    evento(evt);
}//GEN-LAST:event_formKeyPressed

private void rbnBoletaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbnBoletaKeyPressed
    evento(evt);
}//GEN-LAST:event_rbnBoletaKeyPressed

private void txtClienteResponsableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteResponsableKeyPressed
    evento(evt);
}//GEN-LAST:event_txtClienteResponsableKeyPressed

private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
    realizarVenta();
}//GEN-LAST:event_btnEnviarActionPerformed

private void btnEnviar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviar1ActionPerformed
    realizarProforma();
}//GEN-LAST:event_btnEnviar1ActionPerformed

private void btnEnviar1rbnBoletaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEnviar1rbnBoletaKeyPressed
}//GEN-LAST:event_btnEnviar1rbnBoletaKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    }//GEN-LAST:event_btnCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnEnviar1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private javax.swing.JRadioButton rbnBoleta;
    private javax.swing.JRadioButton rbnFactura;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtClienteResponsable;
    private org.jdesktop.swingx.JXTextField txtDescuento;
    private org.jdesktop.swingx.JXTextField txtIGV;
    private javax.swing.JTextField txtRucDNI;
    private org.jdesktop.swingx.JXTextField txtSubTotal;
    private org.jdesktop.swingx.JXTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    protected void cargarDatosBusquedaCliente(Cliente objC) {
        txtCliente.setText(objC.getStr_razonSocial());
        txtRucDNI.setText(objC.getStr_rucdni());
        txtClienteResponsable.setText(objC.getStr_razonSocial());
        cargarTipoDocumento();
        this.objCliente = objC;
    }

    private void cargarDatos() {
        this.setTitle(gui.getTitle().concat(" - Pre Venta"));
        rbnBoleta.setSelected(true);
    }

    private void recalcularTotal() {
        BigDecimal dblSubTotal = BigDecimal.ZERO;
        BigDecimal dblIgv = BigDecimal.ZERO;
        BigDecimal dblDescuento = BigDecimal.ZERO;

        Ventas objVentas = null;
        for (Object object : guiVenta.getListaVenta()) {

            objVentas = (Ventas) object;
            dblSubTotal =dblSubTotal.add(objVentas.getDbSubtotal()) ;
            dblIgv =dblIgv.add(objVentas.getDbIGV()) ;
            dblDescuento =dblDescuento.add(objVentas.getDbdescuento()) ;

        }

        txtSubTotal.setText(Util.redondeo((dblSubTotal), 2));
        txtIGV.setText(Util.redondeo((dblIgv), 2));
        txtDescuento.setText(Util.redondeo((dblDescuento), 2));
        txtTotal.setText(Util.redondeo((dblSubTotal.add(dblIgv).subtract(dblDescuento)), 2));
    }

    private void cargarTipoDocumento() {
        if (txtRucDNI.getText().length() == 8) {
            rbnBoleta.setSelected(true);
        } else {
            rbnFactura.setSelected(true);
        }
    }

    private void evento(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            cargarBusquedaCliente();
        } else if (evt.getKeyCode() == KeyEvent.VK_F12) {
            cerrar();
        } else if (evt.getKeyCode() == KeyEvent.VK_F9) {
            realizarVenta();
        } else if (evt.getKeyCode() == KeyEvent.VK_F7) {
            realizarProforma();
        }
    }

    private void cargarBusquedaCliente() {
        try {
            List<Cliente> listaCliente = PaqueteBusinessDelegate.getClienteService().
                    listarCliente("", "", "", "");

            if (listaCliente.isEmpty()) {
                Mensaje.mensaje(this, "No existen Clientes", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            } else if (listaCliente.size() == 1) {
                cargarDatosBusquedaCliente(listaCliente.get(0));
            } else if (listaCliente.size() > 1) {
//                Util.hiloProgressBar(1, gui);
                BuscarCliente frmBuscarCliente = new BuscarCliente(gui, listaCliente, this);
//                Util.hiloProgressBar(0, gui);
                frmBuscarCliente.cargarPanelBusquedaCliente(listaCliente);
                frmBuscarCliente.setVisible(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(PreVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cerrar() {
        this.setVisible(false);
        recalcularTotal();
    }

    private void realizarVenta() {
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getPREVENTA_VENDER())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        Object objRespuesta = Mensaje.confirmar(gui, "Desea Efectuar la Venta", Mensaje.TITULO_ME, Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);

        if (objRespuesta.equals(Mensaje.NO_OPTION)) {
            return;
        }

        Ventas objVentas;
        String documento = Util.BOLETA;

        if (rbnFactura.isSelected()) {
            documento = Util.FACTURA;
        }

        for (Object object : guiVenta.getListaVenta()) {
            objVentas = (Ventas) object;
            objVentas.setDbTotal(
                    Util.stringTOBigDecimal(
                    Util.redondeo(objVentas.getDbSubtotal().add(objVentas.getDbIGV()).subtract(objVentas.getDbdescuento()), 2)));
            objVentas.setObjLocal(gui.getLocal());
            objVentas.setStr_usuario(gui.getBarraEstado().getUsuario());
            objVentas.setStr_clienteResponsable(txtClienteResponsable.getText());
            objVentas.setObjCliente(objCliente);
            objVentas.setStr_numeroDocumento(documento);
            objVentas.setDbCantidad(objVentas.getDbCantidad().divide(objVentas.getDbUnidadesContenidas()) );
        }


        if (PaqueteBusinessDelegate.getVentasService().registrarVenta(guiVenta.getListaVenta(), 1,null)) {
            Mensaje.mensaje(gui, "Se Efectuo la Venta Con exito", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            guiVenta.getListaVenta().clear();
            this.objCliente = null;
            guiVenta.getTbDetalleVenta().listar(null);
            guiVenta.realizarCalculo();
        } else {
            Mensaje.mensaje(gui, "No se pudo efectura la Venda", Mensaje.TITULO_ME, Mensaje.ERROR);
        }

        this.setVisible(false);
    }

    private void realizarProforma() {
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getPREVENTA_REALIZAR_PROFORMA())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        Object objRespuesta = Mensaje.confirmar(gui, "Desea Crear la Proforma", Mensaje.TITULO_ME, Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);

        if (objRespuesta.equals(Mensaje.NO_OPTION)) {
            return;
        }

        Ventas objVentas;
        String documento = Util.BOLETA;

        if (rbnFactura.isSelected()) {
            documento = Util.FACTURA;
        }

        for (Object object : guiVenta.getListaVenta()) {
            objVentas = (Ventas) object;
            objVentas.setDbTotal(
                    Util.stringTOBigDecimal(
                    Util.redondeo(objVentas.getDbSubtotal().add(objVentas.getDbIGV()).subtract(objVentas.getDbdescuento()), 2)));
            objVentas.setObjLocal(gui.getLocal());
            objVentas.setStr_usuario(gui.getBarraEstado().getUsuario());
            objVentas.setStr_clienteResponsable(txtClienteResponsable.getText());
            objVentas.setObjCliente(objCliente);
            objVentas.setStr_numeroDocumento(documento);
            objVentas.setDbCantidad(objVentas.getDbCantidad().divide(objVentas.getDbUnidadesContenidas()) );
        }


        if (PaqueteBusinessDelegate.getVentasService().registrarVenta(guiVenta.getListaVenta(), 0,this.gui.getEmpresa().getStr_razonSocial().concat(" - ").concat(
        		this.gui.getEmpresa().getStr_ruc()).concat(" (").concat(
        		this.gui.getLocal().getStr_nombre().concat(")")))) {
            Mensaje.mensaje(gui, "Se Efectuo la Proforma Con Exito", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            guiVenta.getListaVenta().clear();
            this.objCliente = null;
            guiVenta.getTbDetalleVenta().listar(null);
            guiVenta.realizarCalculo();

//            Ireport ireport = new Ireport();  el reporte se llama desde el mysqldao...por fallas tecnicas
//            
//            ireport.Proforma(documento, gui.getEmpresa().getStr_razonSocial(), "Proforma");

        } else {
            Mensaje.mensaje(gui, "No se pudo efectura la Proforma", Mensaje.TITULO_ME, Mensaje.ERROR);
        }

        this.setVisible(false);
    }

    private void cargarPreImpresion() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
