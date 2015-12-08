/*
 * OrdenCompraProvProd.java
 *
 * Created on 03-jul-2012, 16:21:45
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompra;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cesareo
 */
public class OrdenCompraProvProd extends javax.swing.JDialog {

    private Principal gui;
    private GestionPrecio frmGestionPrecio;
    private Proveedor objProveedor;
    protected static List<ProveedorProductoOrdenCompra> listaProvProdOrdenCompra = new ArrayList<>();
    protected static boolean check = false;
    private int puntero = 0;

    public OrdenCompraProvProd(Principal gui, Proveedor objProveedor) {
        super(gui, true);
        this.gui = gui;
        this.objProveedor = objProveedor;
        initComponents();
        cargarDatos();
        setLocationRelativeTo(null);
    }

    public OrdenCompraProvProd(Principal gui, Proveedor objProveedor, GestionPrecio frmGestionPrecio, int puntero) {
        super(gui, true);
        this.gui = gui;
        this.objProveedor = objProveedor;
        this.frmGestionPrecio = frmGestionPrecio;
        this.puntero = puntero;
        initComponents();
        cargarDatos();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new org.jdesktop.swingx.JXPanel();
        lblProveedor = new org.jdesktop.swingx.JXLabel();
        txtProveedor = new org.jdesktop.swingx.JXTextField();
        txtRuc = new org.jdesktop.swingx.JXTextField();
        lblRuc = new org.jdesktop.swingx.JXLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        btnAceptar = new org.jdesktop.swingx.JXButton();
        btnCancelar = new org.jdesktop.swingx.JXButton();
        jLabel1 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnl1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblProveedor.setText("Proveedor:");

        lblRuc.setText("RUC:");

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Fabricante", "Familia", "Und medida", "Medida rotación", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducto.setColumnControlVisible(true);
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducto);

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

        jLabel1.setText("Producto:");

        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl1Layout.createSequentialGroup()
                                .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                                .addComponent(lblRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    setVisible(false);
}//GEN-LAST:event_btnCancelarActionPerformed

private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
    List<ProveedorProductoOrdenCompra> listaProvProdOrdenCompraTemp = new ArrayList<>();
    boolean b;

    if (this.listaProvProdOrdenCompra == null || this.listaProvProdOrdenCompra.isEmpty()) {
        Mensaje.mensaje(this, "No se encontró Productos del Proveedor", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        return;
    }

    for (int i = 0; i <= tblProducto.getRowCount() - 1; i++) {
        b = Boolean.parseBoolean(tblProducto.getValueAt(i, 6).toString());
        if (b == true) {
            if (!verificarProductoAgregado(this.listaProvProdOrdenCompra.get(i))) {
                listaProvProdOrdenCompraTemp.add(this.listaProvProdOrdenCompra.get(i));
            }
            check = true;
        }
    }

    if (!check) {
        Mensaje.mensaje(this, "Seleccionar Productos", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else {
        this.listaProvProdOrdenCompra = listaProvProdOrdenCompraTemp;
        setVisible(false);
    }
}//GEN-LAST:event_btnAceptarActionPerformed

private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
    if (puntero == 1) {
        frmGestionPrecio.cargarDatosBusquedaProducto(PPOCSeleccionado());
        this.setVisible(false);
    }
}//GEN-LAST:event_tblProductoMouseClicked

    private void txtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String nombre = txtProducto.getText().trim();
            cargarTabla(nombre);
        }
    }//GEN-LAST:event_txtProductoKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAceptar;
    private org.jdesktop.swingx.JXButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel lblProveedor;
    private org.jdesktop.swingx.JXLabel lblRuc;
    private org.jdesktop.swingx.JXPanel pnl1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtProducto;
    private org.jdesktop.swingx.JXTextField txtProveedor;
    private org.jdesktop.swingx.JXTextField txtRuc;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
        txtProveedor.setEditable(false);
        txtProveedor.setText(objProveedor.getStr_razonSocial());
        txtRuc.setEditable(false);
        txtRuc.setText(objProveedor.getStr_ruc());
        txtProducto.requestFocus();
        tblProducto.setSortable(false);
        
        if (puntero == 1) {
            btnAceptar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnAceptar.setVisible(false);
            btnCancelar.setVisible(false);

            tblProducto.getColumnModel().getColumn(6).setMaxWidth(0);
            tblProducto.getColumnModel().getColumn(6).setMinWidth(0);
            tblProducto.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
            tblProducto.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        }
    }

    private void cargarTabla(String producto) {
        Object[] filaTabla = new Object[7];
        DefaultTableModel modelo = (DefaultTableModel) tblProducto.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        listaProvProdOrdenCompra = new ArrayList<>();
        listaProvProdOrdenCompra = PaqueteBusinessDelegate.getOrdenCompraService().
                listarProveedorProducto(String.valueOf(objProveedor.getInt_idProveedor()), "%%", Util.ACTIVO, producto);
        int i = 0;

        for (Object a : listaProvProdOrdenCompra) {
            if (a instanceof ProveedorProductoOrdenCompra) {
                filaTabla[0] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getStr_codigoInterno();
                filaTabla[1] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getStr_nombreProducto();
                filaTabla[2] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getStr_fabricante();
                filaTabla[3] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getObjFamilia().getStr_nombre();
                filaTabla[4] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getObjUnidadMedida().getStr_nombreUM();
                filaTabla[5] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getObjMedidaRotacion().getStr_nombreMR();
                filaTabla[6] = false;
                modelo.addRow(filaTabla);
            }
            i++;
        }

        tblProducto.setModel(modelo);
    }

    private boolean verificarProductoAgregado(ProveedorProductoOrdenCompra objPPOC) {
        if (OrdenCompra.listaProveedorProductoOrdenCompra.isEmpty()) {
            return false;
        }

        for (int i = 0; i < OrdenCompra.listaProveedorProductoOrdenCompra.size(); i++) {
            if (OrdenCompra.listaProveedorProductoOrdenCompra.get(i).getObjProducto().getStr_codigoInterno().
                    equals(objPPOC.getObjProducto().getStr_codigoInterno())) {
                return true;
            }
        }

        return false;
    }

    public ProveedorProductoOrdenCompra PPOCSeleccionado() {
        int indice = tblProducto.getSelectedRow();
        return listaProvProdOrdenCompra.get(indice);
    }
}
