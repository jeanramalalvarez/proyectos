/*
 * BuscaProformas.java
 *
 * Created on 10-sep-2012, 17:32:59
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.puntoventa.reportes.Ireport;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

/**
 *
 * @author YESM
 */
public class BuscaProformas extends javax.swing.JDialog {

    /**
    * 
    */
	private static final long serialVersionUID = 1L;
	private Principal gui;

    public BuscaProformas(Principal gui) {
        super(gui, true);
        this.gui = gui;
        initComponents();
        cargarDatos();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtCliente = new org.jdesktop.swingx.JXTextField();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProformas = new com.gestionmatriz.util.Tabla();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtSubTotal = new org.jdesktop.swingx.JXTextField();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        txtDescuento = new org.jdesktop.swingx.JXTextField();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        txtIGV = new org.jdesktop.swingx.JXTextField();
        txtTotal = new org.jdesktop.swingx.JXTextField();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetalleVenta = new com.gestionmatriz.util.Tabla();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jXLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel1.setText("Cliente: ");

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });
        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClienteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteKeyTyped(evt);
            }
        });

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Lista Proformas"));

        tbProformas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Proforma", "RUC", "Razon Social", "Sub Total", "IGV", "Descuento", "Total", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProformas.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tbProformas.setRowHeight(30);
        tbProformas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbProformasMousePressed(evt);
            }
        });
        tbProformas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbProformasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbProformasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbProformas);

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detalle Proforma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 51)));

        jXLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jXLabel2.setText("SubTotal: ");

        txtSubTotal.setEditable(false);
        txtSubTotal.setBackground(new java.awt.Color(0, 0, 0));
        txtSubTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        txtSubTotal.setForeground(new java.awt.Color(255, 102, 0));
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubTotal.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        jXLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jXLabel3.setText("Descuento (-):");

        txtDescuento.setEditable(false);
        txtDescuento.setBackground(new java.awt.Color(0, 0, 0));
        txtDescuento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        txtDescuento.setForeground(new java.awt.Color(255, 102, 0));
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescuento.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        jXLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jXLabel4.setText("IGV (+): ");

        txtIGV.setEditable(false);
        txtIGV.setBackground(new java.awt.Color(0, 0, 0));
        txtIGV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        txtIGV.setForeground(new java.awt.Color(255, 102, 0));
        txtIGV.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIGV.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(0, 0, 0));
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        txtTotal.setForeground(new java.awt.Color(255, 102, 0));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        jXLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jXLabel5.setText("Total");

        tbDetalleVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "U M", "Stock", "Precio", "Cantidad", "Afecto", "Desc %", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDetalleVenta.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        tbDetalleVenta.setRowHeight(30);
        tbDetalleVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetalleVentaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbDetalleVentaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbDetalleVentaKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tbDetalleVenta);
        tbDetalleVenta.getColumn(0).setPreferredWidth(1);
        tbDetalleVenta.getColumn(1).setPreferredWidth(200);
        tbDetalleVenta.getColumn(2).setPreferredWidth(10);
        tbDetalleVenta.getColumn(3).setPreferredWidth(10);
        tbDetalleVenta.getColumn(4).setPreferredWidth(10);
        tbDetalleVenta.getColumn(5).setPreferredWidth(10);
        tbDetalleVenta.getColumn(6).setPreferredWidth(10);
        tbDetalleVenta.getColumn(7).setPreferredWidth(10);

        jXLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel6.setText("F6=Imprimir Proforma");

        jXLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel9.setText("F12=SALIR");

        /*jXLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel7.setText("F10=Eliminar Proforma");*/

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIGV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jXPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
            .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jXPanel2Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(150, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
                    .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void tbDetalleVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleVentaKeyPressed
    evento(evt);
}//GEN-LAST:event_tbDetalleVentaKeyPressed

private void tbDetalleVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleVentaKeyReleased
    evento(evt);
}//GEN-LAST:event_tbDetalleVentaKeyReleased

private void tbDetalleVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleVentaKeyTyped
    evento(evt);
}//GEN-LAST:event_tbDetalleVentaKeyTyped

private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
}//GEN-LAST:event_txtClienteActionPerformed

private void txtClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyPressed
    listar();
}//GEN-LAST:event_txtClienteKeyPressed

private void txtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyTyped
    evento(evt);
}//GEN-LAST:event_txtClienteKeyTyped

private void tbProformasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProformasMousePressed
    cargarDetalle();
}//GEN-LAST:event_tbProformasMousePressed

private void tbProformasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProformasKeyPressed
   
}//GEN-LAST:event_tbProformasKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        listar();
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

    private void tbProformasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProformasKeyReleased
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_F6) {
        /*enviarFacturacionProforma();*/
        pdfProforma();
    } else {
        cargarDetalle();
    }
    }//GEN-LAST:event_tbProformasKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private com.gestionmatriz.util.Tabla tbDetalleVenta;
    private com.gestionmatriz.util.Tabla tbProformas;
    private org.jdesktop.swingx.JXTextField txtCliente;
    private org.jdesktop.swingx.JXTextField txtDescuento;
    private org.jdesktop.swingx.JXTextField txtIGV;
    private org.jdesktop.swingx.JXTextField txtSubTotal;
    private org.jdesktop.swingx.JXTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
        this.setTitle("" + gui.getTitle().concat("").concat(" - [Modulo: Busqueda Proformas]"));
        listar();
    }

    private void listar() {
        tbProformas.listar(PaqueteBusinessDelegate.getVentasService().listaProformasXCliente(gui.getLocal().getInt_idLocal(), txtCliente.getText(),txtCliente.getText()));
    }

    private void cargarDetalle() {
        int fila = tbProformas.getSelectedRow();
       if (fila>=0){
        	String strProforma = tbProformas.getValueAt(fila, 0).toString();

            tbDetalleVenta.listar(PaqueteBusinessDelegate.getVentasService().listaDetalleProforma(gui.getLocal().getInt_idLocal(), strProforma));

            txtSubTotal.setText(Util.redondeo(new BigDecimal(tbProformas.getValueAt(fila, 3).toString()), 2) );
            txtDescuento.setText(Util.redondeo(new BigDecimal(tbProformas.getValueAt(fila, 5).toString()),2));
            txtIGV.setText(Util.redondeo(new BigDecimal(tbProformas.getValueAt(fila, 4).toString()),2));
            txtTotal.setText(Util.redondeo(new BigDecimal(tbProformas.getValueAt(fila, 6).toString()),2));

        }
       }
    private void enviarFacturacionProforma() {
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getENVIAR_FACTURACION_PROFORMA())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        if (validarProforma()) {
            Mensaje.mensaje(gui, "Existen Restricciones en la proforma, no se podra hacer efectiva", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }

        int fila = tbProformas.getSelectedRow();
        String documento = tbProformas.getValueAt(fila, 0).toString();
        String msg = "Desea Enviar a Caja la Proforma";
        int obj = Mensaje.confirmar(gui, msg, Mensaje.TITULO_ME, Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);

        if (obj == Mensaje.NO_OPTION) {
            return;
        }
        if (PaqueteBusinessDelegate.getVentasService().enviarProformaVentas(documento, gui.getLocal().getInt_idLocal())) {
            Mensaje.mensaje(gui, "Se Realizo la Venta con Exito", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        } else {
            Mensaje.mensaje(gui, "No se Pudo Efectura la Venta", Mensaje.TITULO_ME, Mensaje.ERROR);
        }

        tbProformas.listar(null);
        tbDetalleVenta.listar(null);
    }

    private boolean validarProforma() {
        String stock, cantidad;
        BigDecimal intStock, intCantidad;

        for (int i = 0; i < tbDetalleVenta.getRowCount(); i++) {
            stock = tbDetalleVenta.getValueAt(i, 3).toString().replaceAll("<html><font color=\"#188E5B\">", "").replace("<html><font color=\"#FF0000\">", "").
                    replaceAll("</font></html>", "").replaceAll("<b>", "").replaceAll("</b>", "");
            cantidad = tbDetalleVenta.getValueAt(i, 5).toString().replaceAll("<html><font color=\"#188E5B\">", "").replaceAll("<html><font color=\"#FF0000\">", "").
                    replaceAll("</font></html>", "").replaceAll("<b>", "").replaceAll("</b>", "");

            intStock = Util.stringTOBigDecimal(stock);
            intCantidad = Util.stringTOBigDecimal(cantidad);

            if (intStock.compareTo(intCantidad) ==-1 ) {
                return true;
            }
        }

        return false;
    }

    private void evento(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            salir();
        }
    }

    private void salir() {
        int objRes = Mensaje.confirmar(gui, "Desea Salir de Buscar Proforma", Mensaje.TITULO_ME, Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);

        if (objRes != Mensaje.YES_OPTION) {
            return;
        }

        this.dispose();
    }

    private void pdfProforma() {
        int fila = tbProformas.getSelectedRow();
        if (fila>=0){
           String documento = tbProformas.getValueAt(fila, 0).toString();
            Ireport ireport = new Ireport();
            ireport.Proforma(documento, this.gui.getEmpresa().getStr_razonSocial().concat(" - ").concat(this.gui.getEmpresa().getStr_ruc()).concat(" (").concat(
            		this.gui.getLocal().getStr_nombre().concat(")")));
        }else{
            Mensaje.mensaje(this, "Debe seleccionar una proforma", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            return;
        }
        this.setVisible(false);
        Mensaje.mensaje(this, "Se generó la proforma satisfactoriamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);
    }
}
