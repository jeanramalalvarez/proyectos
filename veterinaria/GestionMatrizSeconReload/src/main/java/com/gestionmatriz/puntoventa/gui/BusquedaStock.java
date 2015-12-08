/*
 * BusquedaStock.java
 *
 * Created on 23-ago-2012, 17:50:34
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.event.KeyEvent;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.bean.UnidadMedida;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.ConsultaStock;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.util.Util;

/**
 *
 * @author YESM
 */
public class BusquedaStock extends javax.swing.JDialog {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(BusquedaStock.class);  
    private Principal gui;
    private Venta guiVenta;
    private PrecargaProducto jdPrecarga;
    private GuiaRemision frmGuiaRemision;

    public BusquedaStock(Principal gui, Venta guiVenta) {
        super(gui);
        this.gui = gui;
        this.guiVenta = guiVenta;
        initComponents();
        CargaInicial();
        setLocationRelativeTo(null);
    }

    public BusquedaStock(Principal gui, GuiaRemision frmGuiaRemision) {
        super(gui, true);
        this.gui = gui;
        this.frmGuiaRemision = frmGuiaRemision;
        initComponents();
        CargaInicial();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        txtProducto = new org.jdesktop.swingx.JXTextField();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalleStock = new com.gestionmatriz.util.Tabla();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);
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

        jXLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel6.setText("Producto/Servicio: ");

        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoKeyTyped(evt);
            }
        });

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Precios Por Producto"));

        tbDetalleStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto/Servicio", "Fabricante", "Cod Proveedor", "Proveedor", "CUM", "Nombre UM", "Precio", "Stock", "UC", "R T", "DP", "Codigo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDetalleStock.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        tbDetalleStock.setRowHeight(30);
        tbDetalleStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetalleStockKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbDetalleStockKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetalleStock);
        tbDetalleStock.getColumn(11).setPreferredWidth(30);
        tbDetalleStock.getColumn(10).setPreferredWidth(30);
        tbDetalleStock.getColumn(9).setPreferredWidth(30);
        tbDetalleStock.getColumn(8).setPreferredWidth(30);
        tbDetalleStock.getColumn(7).setPreferredWidth(30);
        tbDetalleStock.getColumn(6).setPreferredWidth(50);
        tbDetalleStock.getColumn(5).setPreferredWidth(0);
        tbDetalleStock.getColumn(4).setPreferredWidth(10);
        tbDetalleStock.getColumn(3).setPreferredWidth(0);
        tbDetalleStock.getColumn(2).setPreferredWidth(50);
        tbDetalleStock.getColumn(0).setPreferredWidth(0);
        tbDetalleStock.getColumn(1).setPreferredWidth(250);

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Opciones"));

        jXLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel5.setText("[ENTER]=Cargar Producto/Servicio");

        jXLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel8.setText("F12=Salir");

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jXPanel1.getAccessibleContext().setAccessibleName("Precios Por Producto/Servicio");

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    evento(evt);
}//GEN-LAST:event_formKeyPressed

private void txtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyPressed
    listar(txtProducto.getText());
    evento(evt);
}//GEN-LAST:event_txtProductoKeyPressed

private void txtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyReleased
    evento(evt);
}//GEN-LAST:event_txtProductoKeyReleased

private void txtProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyTyped
    evento(evt);
}//GEN-LAST:event_txtProductoKeyTyped

private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    evento(evt);
}//GEN-LAST:event_formKeyReleased

private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
    evento(evt);
}//GEN-LAST:event_formKeyTyped

private void tbDetalleStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleStockKeyPressed
    evento(evt);
}//GEN-LAST:event_tbDetalleStockKeyPressed

private void tbDetalleStockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleStockKeyReleased
    evento(evt);
}//GEN-LAST:event_tbDetalleStockKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private com.gestionmatriz.util.Tabla tbDetalleStock;
    private org.jdesktop.swingx.JXTextField txtProducto;
    // End of variables declaration//GEN-END:variables

    private void CargaInicial() {
        this.setTitle("" + gui.getTitle().concat("").concat(" - [Modulo: Precio por Producto/Servicio]"));
    }

    private void evento(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE || evt.getKeyCode() == KeyEvent.VK_F12) {
            cerraVenta();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cargarProducto();
        }
    }

    private void cerraVenta() {
        this.setVisible(false);
        guiVenta.getTbDetalleVenta().setFocusable(true);
        guiVenta.getTbDetalleVenta().requestFocus();
    }

    private void listar(String producto) {
        log.info("Listando Busqueda de Stock");
        tbDetalleStock.listar(PaqueteBusinessDelegate.getVentasService().buscarStock(gui.getLocal().getInt_idLocal(), producto));
    }

    private void cargarProducto() {
        if (tbDetalleStock.getRowCount() < 1) {
            return;
        }

        int fila = tbDetalleStock.getSelectedRow();
        ConsultaStock objConsultaStock = new ConsultaStock();
        Producto objProducto = new Producto();

        objProducto.setInt_idProducto(
                com.gestionmatriz.util.Util.stringTOint(
                tbDetalleStock.getValueAt(fila, 0).toString()));
        objProducto.setStr_codigoInterno(tbDetalleStock.getValueAt(fila, 12).toString());
        objProducto.setStr_nombreProducto(tbDetalleStock.getValueAt(fila, 1).toString());
        objProducto.setStr_fabricante(tbDetalleStock.getValueAt(fila, 2).toString());

        boolean reintegro = (boolean) tbDetalleStock.getValueAt(fila, 10);

        if (reintegro) {
            objProducto.setStr_reintegroTributario("SI");
        } else {
            objProducto.setStr_reintegroTributario("NO");
        }

        objConsultaStock.setObjProducto(objProducto);
        Proveedor objProveedor = new Proveedor();

        objProveedor.setInt_idProveedor(com.gestionmatriz.util.Util.stringTOint(
                tbDetalleStock.getValueAt(fila, 3).toString()));

        objProveedor.setStr_razonSocial(tbDetalleStock.getValueAt(fila, 4).toString());

        objConsultaStock.setObjProveedor(objProveedor);

        UnidadMedida objMedida = new UnidadMedida();
        objMedida.setInt_idUnidadMedida(com.gestionmatriz.util.Util.stringTOint(
                tbDetalleStock.getValueAt(fila, 5).toString()));
        objMedida.setStr_nombreUM(tbDetalleStock.getValueAt(fila, 6).toString());

        objConsultaStock.setObjUnidadMedida(objMedida);

        objConsultaStock.setDbl_precio(com.gestionmatriz.util.Util.stringTOBigDecimal(
                tbDetalleStock.getValueAt(fila, 7).toString()));

        objConsultaStock.setDbl_stock(com.gestionmatriz.util.Util.stringTOBigDecimal(
                tbDetalleStock.getValueAt(fila, 8).toString()));

        objConsultaStock.setDlb_stockXCompra(com.gestionmatriz.util.Util.stringTOBigDecimal(
                tbDetalleStock.getValueAt(fila, 9).toString()));

        objConsultaStock.setDbl_DescuentoPermitido(Util.stringTOBigDecimal(
                tbDetalleStock.getValueAt(fila, 11).toString()));

        if (guiVenta == null) {
            frmGuiaRemision.cargarDatos(objConsultaStock);
        } else {
            if (jdPrecarga == null) {
                jdPrecarga = new PrecargaProducto(gui, guiVenta);
            }
            jdPrecarga.setVisible(true);
            jdPrecarga.requestFocus();
            jdPrecarga.cargarData(objConsultaStock);
        }

        this.setVisible(false);
    }

    public void setVisible(boolean b) {
        if (b) {
            txtProducto.requestFocus();
        }

        super.setVisible(b);
        try {
            ConexionSql.cerrarConexionAll(ConexionSql.getConexion());
        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        }
        listar("");
    }
}
