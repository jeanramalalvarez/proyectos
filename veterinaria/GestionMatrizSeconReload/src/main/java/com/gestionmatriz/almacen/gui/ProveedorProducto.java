/*
 * ProveedorProducto.java
 *
 * Created on 27-jun-2012, 10:02:29
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.opciones.Opciones;
import com.gestionmatriz.almacen.reportes.Ireport;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import com.gestionmatriz.util.ValidarCamposNulos;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jarcon
 */
public class ProveedorProducto extends javax.swing.JInternalFrame {

    private List<Proveedor> listaProveedores;
    private Proveedor objProveedor;
    private Principal gui;
    private List<Producto> listaProductos;
    private Producto objProducto;
    private List<com.gestionmatriz.almacen.bean.ProveedorProducto> listaProveedorProducto = new ArrayList<>();
    private List<com.gestionmatriz.almacen.bean.ProveedorProducto> selectProveedorProducto = new ArrayList<>();
    private com.gestionmatriz.almacen.bean.ProveedorProducto objProveedorProducto;
    private DefaultTableModel modelo;
    private Ireport ireport= new Ireport();
    
    public ProveedorProducto(Principal gui) {
        this.gui = gui;
        initComponents();
        tblProductoProve.setSortable(false);
        tblProductosAsignados.setSortable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popLimpiarProd = new javax.swing.JPopupMenu();
        mniLimpiarProd = new javax.swing.JMenuItem();
        popLimpiarProve = new javax.swing.JPopupMenu();
        mniLimpiarProve = new javax.swing.JMenuItem();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductoProve = new org.jdesktop.swingx.JXTable();
        btnAsignarProductos = new org.jdesktop.swingx.JXButton();
        pnlProducto = new org.jdesktop.swingx.JXPanel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtCodInternoProd = new org.jdesktop.swingx.JXTextField();
        btnBuscarProducto = new org.jdesktop.swingx.JXButton();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        txtNombreProd = new org.jdesktop.swingx.JXTextField();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        txtFabricanteProd = new org.jdesktop.swingx.JXTextField();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        txtFamiliaProd = new org.jdesktop.swingx.JXTextField();
        txtUnidMedidaProd = new org.jdesktop.swingx.JXTextField();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        txtReintegroProd = new org.jdesktop.swingx.JXTextField();
        btnAgregar = new org.jdesktop.swingx.JXButton();
        btnQuitar = new org.jdesktop.swingx.JXButton();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtRucProve = new org.jdesktop.swingx.JXTextField();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        btnBuscarProveedor = new org.jdesktop.swingx.JXButton();
        txtRazonSocial = new org.jdesktop.swingx.JXTextField();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        txtDireccionProve = new org.jdesktop.swingx.JXTextField();
        jXButton1 = new org.jdesktop.swingx.JXButton();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductosAsignados = new org.jdesktop.swingx.JXTable();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        txtRazonSocialQuitar = new org.jdesktop.swingx.JXTextField();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        btnQuitarProducto = new org.jdesktop.swingx.JXButton();

        mniLimpiarProd.setText("Limpiar");
        mniLimpiarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLimpiarProdActionPerformed(evt);
            }
        });
        popLimpiarProd.add(mniLimpiarProd);

        mniLimpiarProve.setText("Limpiar Proveedor");
        mniLimpiarProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLimpiarProveActionPerformed(evt);
            }
        });
        popLimpiarProve.add(mniLimpiarProve);

        setClosable(true);
        setIconifiable(true);
        setTitle("ASIGNAR PRODUCTOS A PROVEEDORES");

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Asignar Productos a Proveedores", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblProductoProve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProductoProve.setColumnControlVisible(true);
        jScrollPane1.setViewportView(tblProductoProve);

        btnAsignarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/asignarproducto.png"))); // NOI18N
        btnAsignarProductos.setText("Asignar Productos");
        btnAsignarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarProductosActionPerformed(evt);
            }
        });

        pnlProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del Producto"));
        pnlProducto.setComponentPopupMenu(popLimpiarProd);

        jXLabel2.setText("Cod. Interno :");

        txtCodInternoProd.setEditable(false);

        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarProducto.setText("Buscar Producto");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        jXLabel4.setText("Producto :");

        txtNombreProd.setEditable(false);

        jXLabel5.setText("Fabricante :");

        txtFabricanteProd.setEditable(false);

        jXLabel6.setText("Unidad Medida :");

        jXLabel7.setText("Familia :");

        txtFamiliaProd.setEditable(false);

        txtUnidMedidaProd.setEditable(false);

        jXLabel8.setText("Reintegro :");

        txtReintegroProd.setEditable(false);

        javax.swing.GroupLayout pnlProductoLayout = new javax.swing.GroupLayout(pnlProducto);
        pnlProducto.setLayout(pnlProductoLayout);
        pnlProductoLayout.setHorizontalGroup(
            pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUnidMedidaProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFabricanteProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodInternoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlProductoLayout.createSequentialGroup()
                        .addGroup(pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtReintegroProd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFamiliaProd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombreProd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        pnlProductoLayout.setVerticalGroup(
            pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductoLayout.createSequentialGroup()
                .addGroup(pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodInternoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFabricanteProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFamiliaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnidMedidaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReintegroProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar a la Lista");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/quitar.png"))); // NOI18N
        btnQuitar.setText("Quitar de la Lista");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del Proveedor"));
        jXPanel2.setComponentPopupMenu(popLimpiarProve);

        jXLabel1.setText("R.U.C :");

        txtRucProve.setEditable(false);

        jXLabel3.setText("Razón Social :");

        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarProveedor.setText("Buscar Proveedor");
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        txtRazonSocial.setEditable(false);

        jXLabel9.setText("Dirección :");

        txtDireccionProve.setEditable(false);

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRucProve, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDireccionProve, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                        .addGap(395, 395, 395))))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRucProve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionProve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/vistaprevia.png"))); // NOI18N
        jXButton1.setText("Reporte Productos Por Proveedor");
        jXButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
            .addComponent(jXPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                        .addComponent(jXButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAsignarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsignarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Productos Asignados al Proveedor", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblProductosAsignados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProductosAsignados.setColumnControlVisible(true);
        jScrollPane2.setViewportView(tblProductosAsignados);

        jXLabel10.setText("Proveedor :");

        txtRazonSocialQuitar.setEditable(false);

        jXLabel11.setText("Lista de Productos asignados al proveedor seleccionado:");

        btnQuitarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/eliminar.png"))); // NOI18N
        btnQuitarProducto.setText("Quitar Producto");
        btnQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                        .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRazonSocialQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnQuitarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonSocialQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuitarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
    try {
        List<com.gestionmatriz.almacen.bean.Proveedor> listaProveedores =
                PaqueteBusinessDelegate.getProveedorService().
                buscarProveedor("%" + txtRucProve.getText().trim() + "%", "%" + txtRazonSocial.getText().trim() + "%");

//        System.out.println("lista---"+listaProveedores.size());
        if (listaProveedores.size() == 1) {
            for (com.gestionmatriz.almacen.bean.Proveedor objProve : listaProveedores) {
                cargarDatosBusquedaPersona(objProve);
                this.objProveedor = objProve;
            }
        } else if (listaProveedores.size() > 1) {
            com.gestionmatriz.util.Util.hiloProgressBar(1, gui);
            BuscarProveedor frmBuscarProveedor = new BuscarProveedor(gui, listaProveedores, this, 0);
            com.gestionmatriz.util.Util.hiloProgressBar(0, gui);
            frmBuscarProveedor.cargarPanelBusquedaProveedor(listaProveedores);
            frmBuscarProveedor.setVisible(true);
        }

    } catch (Exception ex) {
        Logger.getLogger(ProveedorProducto.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_btnBuscarProveedorActionPerformed

private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
    try {
        List<Producto> listaProductos = PaqueteBusinessDelegate.getProductoService().
                buscarProducto(txtCodInternoProd.getText().trim(), txtNombreProd.getText().trim(),
                txtFamiliaProd.getText().trim(), txtReintegroProd.getText().trim(), "");

        if (listaProductos.size() == 1) {
            for (Producto objProd : listaProductos) {
                cargarDatosBusquedaProducto(objProd);
                this.objProducto = objProd;
            }
        } else if (listaProductos.size() > 1) {
            Util.hiloProgressBar(1, gui);
            BuscarProducto frmBuscarProducto = new BuscarProducto(gui, listaProductos, this, 0);
            Util.hiloProgressBar(0, gui);
            frmBuscarProducto.cargarPanelBusquedaProducto(listaProductos);
            frmBuscarProducto.setVisible(true);
        }
    } catch (Exception ex) {
        Logger.getLogger(ProveedorProducto.class.getName()).log(Level.SEVERE, null, ex);
    }

}//GEN-LAST:event_btnBuscarProductoActionPerformed

private void mniLimpiarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLimpiarProdActionPerformed
    limpiarProd();
}//GEN-LAST:event_mniLimpiarProdActionPerformed

private void mniLimpiarProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLimpiarProveActionPerformed
    limpiarProvee();
}//GEN-LAST:event_mniLimpiarProveActionPerformed

private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    if (txtRucProve.getText().equalsIgnoreCase("") == true) {
        Mensaje.mensaje(this, "Debe buscar y selecionar un proveedor", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    if (txtCodInternoProd.getText().equalsIgnoreCase("") == true) {
        Mensaje.mensaje(this, "Debe buscar y selecionar un producto", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    objProveedorProducto = new com.gestionmatriz.almacen.bean.ProveedorProducto();
    objProveedorProducto.setObjProducto(objProducto);
    objProveedorProducto.setObjProveedor(objProveedor);
//    objProveedorProducto.setInt_idProducto(objProducto.getInt_idProducto());
//    objProveedorProducto.setInt_idProveedor(objProveedor.getInt_idProveedor());

    selectProveedorProducto = PaqueteBusinessDelegate.getProveedorProductoService().
            listarProveeProd("" + objProveedorProducto.getObjProveedor().getInt_idProveedor(),
            "" + objProveedorProducto.getObjProducto().getInt_idProducto(), Util.ACTIVO);

    if (selectProveedorProducto.isEmpty() == true) {
        listaProveedorProducto.add(objProveedorProducto);
        cargarTabla(listaProveedorProducto);
        limpiarProd();
        tblProductoProve.setBackground(Color.WHITE);
    } else {
        Mensaje.mensaje(this, "Producto ya fue asignado al Proveedor actual", Mensaje.TITULO_ME, Mensaje.ERROR);
        limpiarProd();
    }
}//GEN-LAST:event_btnAgregarActionPerformed

private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
    if (listaProveedorProducto.isEmpty() == true) {
        Mensaje.mensaje(this, "No hay elementos para quitar", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    int indice = tblProductoProve.getSelectedRow();

    listaProveedorProducto.remove(indice);
    cargarTabla(listaProveedorProducto);
}//GEN-LAST:event_btnQuitarActionPerformed

private void btnAsignarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarProductosActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getASIGNARPRODUCTOPROVEEDOR())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (ValidarCamposNulos.validarTablaVacia(tblProductoProve) == true) {
        String usuarioCreador = gui.getBarraEstado().getUsuario();
//        selectProveedorProducto=PaqueteBusinessDelegate.getProveedorProductoService().listarProveeProd(, title, title)

        if (PaqueteBusinessDelegate.getProveedorProductoService().registrarProveedorProducto(listaProveedorProducto, usuarioCreador)) {
            Mensaje.mensaje(this, "Registro de datos correcto", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            limpiarProd();
            listaProveedorProducto.clear();
            limpiarTabla();
            
            selectProveedorProducto = PaqueteBusinessDelegate.getProveedorProductoService().
                    listarProveeProd("" + objProveedor.getInt_idProveedor(), "%%", Util.ACTIVO);

            cargarTablaProductos(selectProveedorProducto);
        }
    } else {
        Mensaje.mensaje(this, "Debe asignar productos a la lista", Mensaje.TITULO_ME, Mensaje.ERROR);
    }
}//GEN-LAST:event_btnAsignarProductosActionPerformed

private void btnQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProductoActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getASIGNARPRODUCTOPROVEEDOR())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (ValidarCamposNulos.validarTablaVacia(tblProductosAsignados) == true) {
        String usuarioModificar = gui.getBarraEstado().getUsuario();

        int indice = tblProductosAsignados.getSelectedRow();
//        System.out.println("indice ---:"+indice);
//        System.out.println("arreglo----:"+selectProveedorProducto.size());
//        
//        System.out.println("idProveedor---:"+selectProveedorProducto.get(indice).getInt_idProveedor());
//        System.out.println("idProducto--:"+selectProveedorProducto.get(indice).getInt_idProducto());
        if (PaqueteBusinessDelegate.getProveedorProductoService().
                modificarProveedorProducto(selectProveedorProducto.get(indice).getInt_idProveedor(),
                selectProveedorProducto.get(indice).getInt_idProducto(),
                usuarioModificar, Util.INACTIVO) == true) {
            Mensaje.mensaje(this, "Se quitó el producto correctamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);

            selectProveedorProducto = PaqueteBusinessDelegate.getProveedorProductoService().
                    listarProveeProd("" + objProveedor.getInt_idProveedor(), "%%", Util.ACTIVO);
//            System.out.println("arreglo despues de quitar---:" + selectProveedorProducto.size());
            cargarTablaProductos(selectProveedorProducto);
        }
    } else {
        Mensaje.mensaje(this, "Debe buscar un proveedor", Mensaje.TITULO_ME, Mensaje.ERROR);
    }

}//GEN-LAST:event_btnQuitarProductoActionPerformed

private void jXButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton1ActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREPORTEPROVEEDORPRODUCTO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if(txtRazonSocial.getText().equals("")){
        ireport.productoXProveedor("%%");
    }else{
        
        ireport.productoXProveedor((""+objProveedor.getInt_idProveedor()).trim());
    }
       
}//GEN-LAST:event_jXButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAgregar;
    private org.jdesktop.swingx.JXButton btnAsignarProductos;
    private org.jdesktop.swingx.JXButton btnBuscarProducto;
    private org.jdesktop.swingx.JXButton btnBuscarProveedor;
    private org.jdesktop.swingx.JXButton btnQuitar;
    private org.jdesktop.swingx.JXButton btnQuitarProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXButton jXButton1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel10;
    private org.jdesktop.swingx.JXLabel jXLabel11;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private javax.swing.JMenuItem mniLimpiarProd;
    private javax.swing.JMenuItem mniLimpiarProve;
    private org.jdesktop.swingx.JXPanel pnlProducto;
    private javax.swing.JPopupMenu popLimpiarProd;
    private javax.swing.JPopupMenu popLimpiarProve;
    private org.jdesktop.swingx.JXTable tblProductoProve;
    private org.jdesktop.swingx.JXTable tblProductosAsignados;
    private org.jdesktop.swingx.JXTextField txtCodInternoProd;
    private org.jdesktop.swingx.JXTextField txtDireccionProve;
    private org.jdesktop.swingx.JXTextField txtFabricanteProd;
    private org.jdesktop.swingx.JXTextField txtFamiliaProd;
    private org.jdesktop.swingx.JXTextField txtNombreProd;
    private org.jdesktop.swingx.JXTextField txtRazonSocial;
    private org.jdesktop.swingx.JXTextField txtRazonSocialQuitar;
    private org.jdesktop.swingx.JXTextField txtReintegroProd;
    private org.jdesktop.swingx.JXTextField txtRucProve;
    private org.jdesktop.swingx.JXTextField txtUnidMedidaProd;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void dispose() {
//        try {
        gui.getBarraEstado().cerraVentana();
//            setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
//            this.setClosed(true);
//        } catch (PropertyVetoException ex) {
//            log.error("Error al Intentar Cerrar Ventana Persona: "+ex.getMessage());
//        }
    }

    private void cargarDatosBusquedaPersona(Proveedor objProve) {
        txtRucProve.setText(objProve.getStr_ruc());
        txtRazonSocial.setText(objProve.getStr_razonSocial());
        txtDireccionProve.setText(objProve.getStr_direccion());
        txtRazonSocialQuitar.setText(objProve.getStr_razonSocial());
        selectProveedorProducto = PaqueteBusinessDelegate.getProveedorProductoService().
                listarProveeProd("" + objProve.getInt_idProveedor(), "%%", Util.ACTIVO);
        cargarTablaProductos(selectProveedorProducto);

        objProveedor = objProve;
    }

    void cargarDatosBusquedaProveedor(Proveedor proveedorSeleccionado) {
        txtRucProve.setText(proveedorSeleccionado.getStr_ruc());
        txtRazonSocial.setText(proveedorSeleccionado.getStr_razonSocial());
        txtDireccionProve.setText(proveedorSeleccionado.getStr_direccion());
        txtRazonSocialQuitar.setText(proveedorSeleccionado.getStr_razonSocial());
        selectProveedorProducto = PaqueteBusinessDelegate.getProveedorProductoService().
                listarProveeProd("" + proveedorSeleccionado.getInt_idProveedor(), "%%", Util.ACTIVO);

        cargarTablaProductos(selectProveedorProducto);
        objProveedor = proveedorSeleccionado;
    }

    public void cargarDatosBusquedaProducto(Producto objProd) {

        txtCodInternoProd.setText(objProd.getStr_codigoInterno());
        txtNombreProd.setText(objProd.getStr_nombreProducto());
        txtFabricanteProd.setText(objProd.getStr_fabricante());
        txtFamiliaProd.setText(objProd.getObjFamilia().getStr_nombre());
        txtUnidMedidaProd.setText(objProd.getObjUnidadMedida().getStr_nombreUM());
        txtReintegroProd.setText(objProd.getStr_reintegroTributario());

        objProducto = objProd;

    }

    public void limpiarProd() {
        txtCodInternoProd.setText("");
        txtNombreProd.setText("");
        txtFabricanteProd.setText("");
        txtFamiliaProd.setText("");
        txtUnidMedidaProd.setText("");
        txtReintegroProd.setText("");
    }

    public void limpiarProvee() {
        txtRucProve.setText("");
        txtRazonSocial.setText("");
        txtDireccionProve.setText("");

    }

    private void cargarTabla(List<com.gestionmatriz.almacen.bean.ProveedorProducto> listaProveedorProducto) {
        String[] titulo = {"R.U.C.", "Proveedor", "Cod. Producto", "Producto", "Familia", "U. Medida"};
        String[][] data = new String[listaProveedorProducto.size()][6];
        int i = 0;

        for (com.gestionmatriz.almacen.bean.ProveedorProducto p : listaProveedorProducto) {


            data[i][0] = p.getObjProveedor().getStr_ruc();//objProveedor.getStr_ruc();
            data[i][1] = p.getObjProveedor().getStr_razonSocial();//objProveedor.getStr_razonSocial();
            data[i][2] = p.getObjProducto().getStr_codigoInterno();//objProducto.getStr_codigoInterno();
            data[i][3] = p.getObjProducto().getStr_nombreProducto();//objProducto.getStr_nombreProducto();
            data[i][4] = p.getObjProducto().getObjFamilia().getStr_nombre();
            data[i][5] = p.getObjProducto().getObjUnidadMedida().getStr_nombreUM();

            i++;
        }

        DefaultTableModel modelo = new DefaultTableModel(data, titulo);
        tblProductoProve.setModel(modelo);
    }

    private void cargarTablaProductos(List<com.gestionmatriz.almacen.bean.ProveedorProducto> selectProveedorProducto) {
        String[] titulo = {"Cod. Producto", "Producto", "Familia"};
        String[][] data = new String[selectProveedorProducto.size()][3];
        int i = 0;

        for (com.gestionmatriz.almacen.bean.ProveedorProducto p : selectProveedorProducto) {
            data[i][0] = p.getObjProducto().getStr_codigoInterno();//objProducto.getStr_codigoInterno();
            data[i][1] = p.getObjProducto().getStr_nombreProducto();//objProducto.getStr_nombreProducto();
            data[i][2] = p.getObjProducto().getObjFamilia().getStr_nombre();
            i++;
        }

        DefaultTableModel modelo = new DefaultTableModel(data, titulo);
        tblProductosAsignados.setModel(modelo);
    }

    public void limpiarTabla() {

        modelo = new DefaultTableModel();
        tblProductoProve.setModel(modelo);

    }

    public void limpiarTablaProductos() {
        modelo = new DefaultTableModel();
        tblProductosAsignados.setModel(modelo);
    }
}
