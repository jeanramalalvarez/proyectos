/*
 * GestionPrecio.java
 *
 * Created on 19-ago-2012, 11:41:05
 */
package com.gestionmatriz.almacen.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXTable;

import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompra;
import com.gestionmatriz.almacen.bean.ProveedorProductoUnidadMedida;
import com.gestionmatriz.almacen.bean.UnidadMedida;
import com.gestionmatriz.almacen.opciones.Opciones;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import com.gestionmatriz.util.ValidarCamposNulos;
import org.apache.log4j.Logger;
/**
 *
 * @author cesareo
 */
public class GestionPrecio extends javax.swing.JInternalFrame {
    
	private static final Logger log=Logger.getLogger(GestionPrecio.class);
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal gui;
    private Proveedor objProveedor = null;
    private ProveedorProductoOrdenCompra objPPOC = null;
    private ProveedorProductoUnidadMedida objPPUM = null;
    private List<UnidadMedida> listaUnidadMedida = new ArrayList<>();
    private List<ProveedorProductoUnidadMedida> listaPPUM = new ArrayList<>();
    private OrdenCompraProvProd frmOrdenCompraProvProd;

    public GestionPrecio(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrecio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        txtCostoCompra = new javax.swing.JTextField();
        txtUnidadCompra = new javax.swing.JTextField();
        txtUnidadesContenidas = new javax.swing.JTextField();
        txtPrecioXUC = new javax.swing.JTextField();
        txtCostoTrasladoXUC = new javax.swing.JTextField();
        cboUnidadVenta = new javax.swing.JComboBox();
        txtPrecioFinal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrecio = new org.jdesktop.swingx.JXTable();
        btnBuscarProducto = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        btnBuscarProveedor = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN PRECIO");

        pnlPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Producto:");

        jLabel2.setText("Costo Compra:");

        jLabel3.setText("Unidad Compra:");

        jLabel4.setText("Unidad Venta:");

        jLabel5.setText("Unidades contenidas:");

        jLabel6.setText("Precio por unidad contenida:");

        jLabel7.setText("Costo Traslado por unidad contenida:");

        jLabel8.setText("Precio Final:");

        txtNombreProducto.setEditable(false);

        txtCostoCompra.setEditable(false);

        txtUnidadCompra.setEditable(false);

        txtUnidadesContenidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUnidadesContenidasKeyPressed(evt);
            }
        });

        txtPrecioXUC.setEditable(false);

        txtCostoTrasladoXUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCostoTrasladoXUCKeyPressed(evt);
            }
        });

        cboUnidadVenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboUnidadVenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboUnidadVentaItemStateChanged(evt);
            }
        });

        txtPrecioFinal.setEditable(false);
        txtPrecioFinal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtPrecioFinal.setForeground(new java.awt.Color(190, 0, 0));

        tblPrecio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Unidad Compra", "Costo Compra", "Unidad Venta", "Precio Final", "Ganancia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.math.BigDecimal.class, java.lang.String.class, java.math.BigDecimal.class, java.math.BigDecimal.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPrecio.setColumnControlVisible(true);
        jScrollPane1.setViewportView(tblPrecio);

        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel9.setText("Proveedor:");

        txtProveedor.setEditable(false);

        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarProveedor.setText("Buscar");
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setText("[ENTER para precalcular]");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setText("[ENTER para precalcular]");

        javax.swing.GroupLayout pnlPrecioLayout = new javax.swing.GroupLayout(pnlPrecio);
        pnlPrecio.setLayout(pnlPrecioLayout);
        pnlPrecioLayout.setHorizontalGroup(
            pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrecioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrecioLayout.createSequentialGroup()
                        .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPrecioLayout.createSequentialGroup()
                                .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCostoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUnidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboUnidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlPrecioLayout.createSequentialGroup()
                                        .addComponent(txtUnidadesContenidas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10))
                                    .addComponent(txtPrecioXUC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlPrecioLayout.createSequentialGroup()
                                        .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnlPrecioLayout.createSequentialGroup()
                                                .addComponent(txtCostoTrasladoXUC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnlPrecioLayout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrecioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlPrecioLayout.setVerticalGroup(
            pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrecioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCostoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUnidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboUnidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUnidadesContenidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecioXUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCostoTrasladoXUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
    if (objProveedor == null) {
        Mensaje.mensaje(this, "Buscar Datos Proveedor", Mensaje.TITULO_ME, Mensaje.ERROR);
        btnBuscarProveedor.requestFocus();
        return;
    }
    
    Util.hiloProgressBar(1, gui);
    frmOrdenCompraProvProd = new OrdenCompraProvProd(gui, objProveedor, this, 1);
    Util.hiloProgressBar(0, gui);
    frmOrdenCompraProvProd.setVisible(true);
    cboUnidadVenta.requestFocus();
}//GEN-LAST:event_btnBuscarProductoActionPerformed

private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
   
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREGISTRARPRECIO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    
    if (objProveedor == null) {
        Mensaje.mensaje(this, "Buscar Datos Proveedor", Mensaje.TITULO_ME, Mensaje.ERROR);
        btnBuscarProveedor.requestFocus();
        return;
    }
    
    if (objPPOC == null) {
        Mensaje.mensaje(this, "Debe buscar un Producto", Mensaje.TITULO_ME, Mensaje.ERROR);
        btnBuscarProducto.requestFocus();
        return;
    }
    
    if (cboUnidadVenta.getSelectedIndex() == 0) {
        Mensaje.mensaje(this, "Seleccionar Unidad Venta", Mensaje.TITULO_ME, Mensaje.ERROR);
        cboUnidadVenta.requestFocus();
        return;
    }
    
    JTextField[] txts = {txtUnidadesContenidas, txtCostoTrasladoXUC};
    if (!ValidarCamposNulos.validar(txts)) {
        Mensaje.mensaje(this, "Los campos resaltados son importantes", Mensaje.TITULO_ME, Mensaje.ERROR);
        txtUnidadesContenidas.requestFocus();
        return;
    }
    
    if (!txtUnidadesContenidas()) {
        return;
    }
    
    if (!txtCostoTrasladoXUC()) {
        return;
    }
    
    objPPUM = new ProveedorProductoUnidadMedida();
    objPPUM.setObjProveedor(objProveedor);
    objPPUM.setObjProducto(objPPOC.getObjProducto());
    objPPUM.setObjUnidadMedidaVenta(listaUnidadMedida.get(cboUnidadVenta.getSelectedIndex() - 1));
    objPPUM.setStr_UnidadMedidaCompra(objPPOC.getObjProducto().getObjUnidadMedida().getStr_nombreUM());
    objPPUM.setDbl_costoCompra(objPPOC.getDbl_precio());
    objPPUM.setDbl_unidadesContenidas(new BigDecimal(txtUnidadesContenidas.getText()));
    objPPUM.setDbl_precioUnidadContenida(new BigDecimal(txtPrecioXUC.getText()));
    objPPUM.setDbl_costoTraslado(new BigDecimal(txtCostoTrasladoXUC.getText()));
    objPPUM.setDbl_precioFinal(new BigDecimal(txtPrecioFinal.getText()));
    objPPUM.setDbl_precioOferta(BigDecimal.ZERO);
    objPPUM.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());
    
    if (PaqueteBusinessDelegate.getProveedorProductoUnidadMedidaService().verificarProducto(objPPUM)) {
        Object objConfirmacion = Mensaje.confirmar(this, "Producto ya tiene Precio por: "
                + objPPUM.getObjUnidadMedidaVenta().getStr_nombreUM() + " , ¿Desea modificar?",
                "Mensaje Confirmación", Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);
        if (objConfirmacion.equals(Mensaje.YES_OPTION)) {
            if (PaqueteBusinessDelegate.getProveedorProductoUnidadMedidaService().modificarPPUM(objPPUM)) {
                Mensaje.mensaje(this, "Precio modificado correctamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                limpiarDatos();
                listaPPUM = PaqueteBusinessDelegate.getProveedorProductoUnidadMedidaService().listarPPUM();
                cargarTabla(tblPrecio, listaPPUM);
            } else {
                Mensaje.mensaje(this, "Error al modificar Precio", Mensaje.TITULO_ME, Mensaje.ERROR);
            }
            return;
        } else {
            return;
        }
    }
    
    if (PaqueteBusinessDelegate.getProveedorProductoUnidadMedidaService().registrarPPUM(objPPUM)) {
        Mensaje.mensaje(this, "Precio registrado correctamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        limpiarDatos();
        listaPPUM = PaqueteBusinessDelegate.getProveedorProductoUnidadMedidaService().listarPPUM();
        cargarTabla(tblPrecio, listaPPUM);
    } else {
        Mensaje.mensaje(this, "Error al registrar Precio", Mensaje.TITULO_ME, Mensaje.ERROR);
    }
}//GEN-LAST:event_btnRegistrarActionPerformed

private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
    try {
        List<Proveedor> listaProveedor = PaqueteBusinessDelegate.getProveedorService().
                buscarProveedor("%%", "%%");

        if (listaProveedor.isEmpty()) {
            Mensaje.mensaje(this, "No exiten Proveedores", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        } else if (listaProveedor.size() == 1) {
            cargarDatosBusquedaProveedor(listaProveedor.get(0));
        } else if (listaProveedor.size() > 1) {
            Util.hiloProgressBar(1, gui);
            BuscarProveedor frmBuscarProveedor = new BuscarProveedor(gui, listaProveedor, this, 3);
            Util.hiloProgressBar(0, gui);
            frmBuscarProveedor.cargarPanelBusquedaProveedor(listaProveedor);
            frmBuscarProveedor.setVisible(true);
        }
    } catch (Exception ex) {
        log.error("ERROR: "+ex.getMessage());
    }
}//GEN-LAST:event_btnBuscarProveedorActionPerformed

private void txtUnidadesContenidasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidadesContenidasKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        txtUnidadesContenidas();
    }
}//GEN-LAST:event_txtUnidadesContenidasKeyPressed

private void cboUnidadVentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboUnidadVentaItemStateChanged
//    if ((objPPOC != null) && (objPPOC.getObjProducto().getObjUnidadMedida().getStr_nombreUM().equals(cboUnidadVenta.getSelectedItem().toString()))) {
//        txtUnidadesContenidas.setText("1");
//        txtUnidadesContenidas.selectAll();
//    }
    
    txtUnidadesContenidas.requestFocus();
}//GEN-LAST:event_cboUnidadVentaItemStateChanged

private void txtCostoTrasladoXUCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoTrasladoXUCKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        txtCostoTrasladoXUC();
    }
}//GEN-LAST:event_txtCostoTrasladoXUCKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox cboUnidadVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlPrecio;
    private org.jdesktop.swingx.JXTable tblPrecio;
    private javax.swing.JTextField txtCostoCompra;
    private javax.swing.JTextField txtCostoTrasladoXUC;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioFinal;
    private javax.swing.JTextField txtPrecioXUC;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtUnidadCompra;
    private javax.swing.JTextField txtUnidadesContenidas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
        objProveedor = new Proveedor();
        objPPOC = new ProveedorProductoOrdenCompra();
    }

    protected void cargarDatosBusquedaProducto(ProveedorProductoOrdenCompra objPPOC) {
        txtNombreProducto.setText(objPPOC.getObjProducto().getStr_nombreProducto());
        txtCostoCompra.setText(String.valueOf(objPPOC.getDbl_precio()));
        txtUnidadCompra.setText(objPPOC.getObjProducto().getObjUnidadMedida().getStr_nombreUM());
        this.objPPOC = new ProveedorProductoOrdenCompra();
        this.objPPOC = objPPOC;
    }
    
    protected void cargarDatosBusquedaProveedor(Proveedor objProveedor) {
        txtProveedor.setText(objProveedor.getStr_razonSocial());
        btnBuscarProducto.requestFocus();
        this.objProveedor = new Proveedor();
        this.objProveedor = objProveedor;
    }
    
    private void cargarDatos() {
        cargarCombo();
        listaPPUM = PaqueteBusinessDelegate.getProveedorProductoUnidadMedidaService().listarPPUM();
        tblPrecio.setSortable(false);
        cargarTabla(tblPrecio, listaPPUM);
    }
    
    private void cargarCombo() {
        listaUnidadMedida = PaqueteBusinessDelegate.getUnidadMedidaService().listarUnidadMedida("%%", "%%");
        cboUnidadVenta.removeAllItems();
        cboUnidadVenta.addItem(".::Seleccionar Unidad de Medida::.");
        
        for (UnidadMedida objUM : listaUnidadMedida) {
            cboUnidadVenta.addItem(objUM.getStr_nombreUM());
        }
    }
    
    private void limpiarDatos() {
        objProveedor = null;
        objPPOC = null;
        objPPUM = null;
        
        txtProveedor.setText("");
        txtNombreProducto.setText("");
        txtCostoCompra.setText("");
        txtUnidadCompra.setText("");
        cargarCombo();
        txtUnidadesContenidas.setText("");
        txtPrecioXUC.setText("");
        txtCostoTrasladoXUC.setText("");
        txtPrecioFinal.setText("");
        btnBuscarProveedor.requestFocus();
    }
    
    private void cargarTabla(JXTable tabla, List<ProveedorProductoUnidadMedida> listaPPUM) {
        Object[] filaTabla = new Object[7];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (ProveedorProductoUnidadMedida objPPUM : listaPPUM) {
            if (verificarProducto(objPPUM.getObjProducto().getStr_codigoInterno(), modelo)) {
                filaTabla[0] = objPPUM.getObjProducto().getStr_codigoInterno();
                filaTabla[1] = objPPUM.getObjProducto().getStr_nombreProducto();
                filaTabla[2] = objPPUM.getStr_UnidadMedidaCompra();
                filaTabla[3] = objPPUM.getDbl_precioUnidadContenida();
                filaTabla[4] = objPPUM.getObjUnidadMedidaVenta().getStr_nombreUM();
                filaTabla[5] = objPPUM.getDbl_precioFinal();
                filaTabla[6] = (objPPUM.getDbl_precioFinal().subtract(objPPUM.getDbl_precioUnidadContenida()));
                modelo.addRow(filaTabla);
            }
        }

        tabla.setModel(modelo);
    }
    
    private boolean verificarProducto(String codigo, DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (codigo.equals(modelo.getValueAt(i, 0).toString())) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean txtUnidadesContenidas() {
        boolean respuesta = false;
        
        if (objPPOC != null) {
            BigDecimal unidadesContenidas = BigDecimal.ZERO;
            BigDecimal precioXUC = BigDecimal.ZERO;

            try {
                unidadesContenidas = new BigDecimal(txtUnidadesContenidas.getText());
                precioXUC = objPPOC.getDbl_precio().divide(unidadesContenidas) ;
                txtPrecioXUC.setText(Util.redondeo(precioXUC, 2));
                txtCostoTrasladoXUC.requestFocus();
                respuesta = true;
            } catch (NumberFormatException nfe) {
                log.error("Error nfe: " + nfe.getMessage());
                Mensaje.mensaje(this, "Ingresar sólo números", Mensaje.TITULO_ME, Mensaje.ERROR);
                txtUnidadesContenidas.selectAll();
                txtUnidadesContenidas.requestFocus();
                respuesta = false;
            } catch (Exception e) {
                log.error("Error e: " + e.getMessage());
                respuesta = false;
            }
        } else {
            Mensaje.mensaje(this, "Debe buscar un Producto", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
        
        return respuesta;
    }
    
    private boolean txtCostoTrasladoXUC() {
        boolean respuesta = false;
        
        if (objPPOC != null) {
            BigDecimal costoTrasladoXUC = BigDecimal.ZERO;
            BigDecimal utilidad = BigDecimal.ONE.add((objPPOC.getObjProducto().getObjMedidaRotacion().getDbl_utilidad().divide(new BigDecimal(100)) ));
            BigDecimal precioFinal = BigDecimal.ZERO;
            BigDecimal porcentajeAdicional = new BigDecimal(1.05);

            try {
                costoTrasladoXUC = new BigDecimal(txtCostoTrasladoXUC.getText());
                precioFinal = ((new BigDecimal(txtPrecioXUC.getText()).multiply(utilidad)).add(costoTrasladoXUC)).multiply(porcentajeAdicional) ;
                txtPrecioFinal.setText(Util.redondeo(precioFinal, 2));
                btnRegistrar.requestFocus();
                respuesta = true;
            } catch (NumberFormatException nfe) {
                log.error("Error nfe: " + nfe.getMessage());
                Mensaje.mensaje(this, "Ingresar sólo números", Mensaje.TITULO_ME, Mensaje.ERROR);
                txtCostoTrasladoXUC.selectAll();
                txtCostoTrasladoXUC.requestFocus();
                respuesta = false;
            }
            catch (Exception e) {
                log.error("Error e: " + e.getMessage());
                respuesta = false;
            }
        } else {
            Mensaje.mensaje(this, "Debe buscar un Producto", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
        
        return respuesta;
    }
    
}
