/*
 * GestionProductos.java
 *
 * Created on 09-jun-2012, 10:11:21
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.almacen.bean.Familia;
import com.gestionmatriz.almacen.bean.MedidaRotacion;
import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.UnidadMedida;
import com.gestionmatriz.almacen.opciones.Opciones;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


/**
 *
 * @author zholo
 */
public class GestionProductos extends javax.swing.JInternalFrame {

	private static final Logger log=Logger.getLogger(GestionPrecioOferta.class);
    private Principal gui;
    private List<Familia> listaFamilia = new ArrayList<>();
    private List<UnidadMedida> listaUnidadMedida = new ArrayList<>();
    private List<MedidaRotacion> listaMedidaRotacion = new ArrayList<>();
    private Producto objProducto = null;
    private Familia objFamilia;
    private UnidadMedida objUnidadMedida;
    private MedidaRotacion objMedidaRotacion;
    private ProveedorProducto frmProveedorProducto;

    public GestionProductos(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlOpciones = new org.jdesktop.swingx.JXPanel();
        btnRegistrarProducto = new org.jdesktop.swingx.JXButton();
        btnBuscarProducto = new org.jdesktop.swingx.JXButton();
        btnModificarProducto = new org.jdesktop.swingx.JXButton();
        btnAsignarProveedor = new org.jdesktop.swingx.JXButton();
        pnlDatosProducto = new org.jdesktop.swingx.JXPanel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        txtCodigoInterno = new org.jdesktop.swingx.JXTextField();
        txtNombreProducto = new org.jdesktop.swingx.JXTextField();
        txtDescripcionProducto = new org.jdesktop.swingx.JXTextField();
        txtFabricante = new org.jdesktop.swingx.JXTextField();
        cboFamilia = new org.jdesktop.swingx.JXComboBox();
        jXLabel16 = new org.jdesktop.swingx.JXLabel();
        jXLabel17 = new org.jdesktop.swingx.JXLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        cboUnidadMedida = new org.jdesktop.swingx.JXComboBox();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        rbtnMenor = new javax.swing.JRadioButton();
        rbtnMedia = new javax.swing.JRadioButton();
        rbtnMayor = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTION PRODUCTOS");

        pnlOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Opciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnRegistrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrarProducto.setText("Registrar");
        btnRegistrarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrarProducto.setNextFocusableComponent(btnBuscarProducto);
        btnRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProductoActionPerformed(evt);
            }
        });

        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscarProducto.setNextFocusableComponent(btnModificarProducto);
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        btnModificarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/modificar.png"))); // NOI18N
        btnModificarProducto.setText("Modificar");
        btnModificarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificarProducto.setNextFocusableComponent(btnAsignarProveedor);
        btnModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProductoActionPerformed(evt);
            }
        });

        btnAsignarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/asignarproveedor.png"))); // NOI18N
        btnAsignarProveedor.setText("Asignar Proveedor");
        btnAsignarProveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAsignarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAsignarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegistrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnRegistrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnAsignarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDatosProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del Producto", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlDatosProducto.setPreferredSize(new java.awt.Dimension(650, 293));

        jXLabel2.setText("Código Interno :");

        jXLabel3.setText("Nombre :");

        jXLabel4.setText("Descripción :");

        jXLabel5.setText("Familia :");

        jXLabel6.setText("Fabricante :");

        txtCodigoInterno.setNextFocusableComponent(jCheckBox2);

        txtNombreProducto.setNextFocusableComponent(txtDescripcionProducto);

        txtDescripcionProducto.setNextFocusableComponent(cboFamilia);

        txtFabricante.setNextFocusableComponent(cboUnidadMedida);

        cboFamilia.setNextFocusableComponent(txtFabricante);

        jXLabel16.setText("Unidad Medida :");

        jXLabel17.setText("Reintegro Tributario :");

        jCheckBox1.setText("SI");
        jCheckBox1.setNextFocusableComponent(jPanel1);

        cboUnidadMedida.setNextFocusableComponent(jCheckBox1);

        jXLabel1.setText("Medida Rotación:");

        jCheckBox2.setText("Autogenerado");
        jCheckBox2.setNextFocusableComponent(txtNombreProducto);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setNextFocusableComponent(btnRegistrarProducto);
        jPanel1.setLayout(null);

        buttonGroup1.add(rbtnMenor);
        rbtnMenor.setText("Menor");
        jPanel1.add(rbtnMenor);
        rbtnMenor.setBounds(8, 9, 70, 23);

        buttonGroup1.add(rbtnMedia);
        rbtnMedia.setText("Media");
        jPanel1.add(rbtnMedia);
        rbtnMedia.setBounds(90, 10, 70, 23);

        buttonGroup1.add(rbtnMayor);
        rbtnMayor.setText("Mayor");
        jPanel1.add(rbtnMayor);
        rbtnMayor.setBounds(160, 10, 70, 23);

        javax.swing.GroupLayout pnlDatosProductoLayout = new javax.swing.GroupLayout(pnlDatosProducto);
        pnlDatosProducto.setLayout(pnlDatosProductoLayout);
        pnlDatosProductoLayout.setHorizontalGroup(
            pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosProductoLayout.createSequentialGroup()
                .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosProductoLayout.createSequentialGroup()
                        .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosProductoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlDatosProductoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDatosProductoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDatosProductoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)
                        .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosProductoLayout.createSequentialGroup()
                                .addComponent(txtCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox2))
                            .addComponent(cboUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDatosProductoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDatosProductoLayout.createSequentialGroup()
                                .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jXLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jXLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox1))))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        pnlDatosProductoLayout.setVerticalGroup(
            pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosProductoLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlDatosProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(pnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDatosProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(pnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductoActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getMODIFICARPRODUCTO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (txtNombreProducto.getText().trim().length() <= 0) {
        txtNombreProducto.setBackground(Color.PINK);
        Mensaje.mensaje(this, "Los campos resaltados son Obligatorios", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else if (cboFamilia.getSelectedIndex() == 0) {
        Mensaje.mensaje(this, "Seleccionar una Familia", Mensaje.TITULO_ME, Mensaje.INFORMACION);
    } else if (cboUnidadMedida.getSelectedIndex() == 0) {
        Mensaje.mensaje(this, "Seleccionar una Unidad de Medida", Mensaje.TITULO_ME, Mensaje.INFORMACION);
    } else {
        txtNombreProducto.setBackground(Color.WHITE);

        objProducto.setStr_codigoInterno(txtCodigoInterno.getText().toUpperCase().trim());
        objProducto.setStr_nombreProducto(txtNombreProducto.getText().toUpperCase().trim());
        objProducto.setStr_descripcion(txtDescripcionProducto.getText().toUpperCase().trim());

        objFamilia = new Familia();
        objFamilia.setInt_idFamilia(listaFamilia.get(cboFamilia.getSelectedIndex() - 1).getInt_idFamilia());
        objProducto.setObjFamilia(objFamilia);

        objProducto.setStr_fabricante(txtFabricante.getText().toUpperCase().trim());
        objMedidaRotacion = new MedidaRotacion();
        if (rbtnMenor.isSelected()) {
            objMedidaRotacion.setInt_idMedidaRotacion(buscarMedidaRotacion(Util.MENOR));
        } else if (rbtnMedia.isSelected()) {
            objMedidaRotacion.setInt_idMedidaRotacion(buscarMedidaRotacion(Util.MEDIA));
        } else if (rbtnMayor.isSelected()) {
            objMedidaRotacion.setInt_idMedidaRotacion(buscarMedidaRotacion(Util.MAYOR));
        }
        objProducto.setObjMedidaRotacion(objMedidaRotacion);
        objUnidadMedida = new UnidadMedida();
        objUnidadMedida.setInt_idUnidadMedida(listaUnidadMedida.get(cboUnidadMedida.getSelectedIndex() - 1).getInt_idUnidadMedida());
        objProducto.setObjUnidadMedida(objUnidadMedida);

        if (jCheckBox1.isSelected()) {
            objProducto.setStr_reintegroTributario("SI");
        } else {
            objProducto.setStr_reintegroTributario("NO");
        }

        objProducto.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());

        if (PaqueteBusinessDelegate.getProductoService().modificarProducto(objProducto)) {
            Mensaje.mensaje(this, "Prodcuto modificado correctamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            Limpiar();
            btnRegistrarProducto.setEnabled(true);
            btnModificarProducto.setEnabled(false);
        } else {
            Mensaje.mensaje(this, "No se pudo modificar el prodcuto", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }
}//GEN-LAST:event_btnModificarProductoActionPerformed

private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
    try {
        List<Producto> listaProductos = PaqueteBusinessDelegate.getProductoService().
                buscarProducto(txtCodigoInterno.getText().trim(), txtNombreProducto.getText().trim(), "", "", "");

        if (listaProductos.isEmpty()) {
            Mensaje.mensaje(this, "No existen productos", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        } else if (listaProductos.size() == 1) {
            cargarDatosBusquedaProducto(listaProductos.get(0));
            btnRegistrarProducto.setEnabled(false);
            btnModificarProducto.setEnabled(true);
        } else if (listaProductos.size() > 1) {
            Util.hiloProgressBar(1, gui);
            BuscarProducto frmBuscarProducto = new BuscarProducto(gui, listaProductos, this);
            Util.hiloProgressBar(0, gui);
            frmBuscarProducto.cargarPanelBusquedaProducto(listaProductos);
            frmBuscarProducto.setVisible(true);
            btnRegistrarProducto.setEnabled(false);
            btnModificarProducto.setEnabled(true);
        }
    } catch (Exception ex) {
    	log.error("ERROR: "+ex.getMessage());
    }
}//GEN-LAST:event_btnBuscarProductoActionPerformed

private void btnRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProductoActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREGISTRARPRODUCTO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    String codigo = "";

    if (txtNombreProducto.getText().trim().length() <= 0) {
        txtNombreProducto.setBackground(Color.PINK);
        Mensaje.mensaje(this, "Los campos resaltados son Obligatorios", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else if (cboFamilia.getSelectedIndex() == 0) {
        Mensaje.mensaje(this, "Seleccionar una Familia", Mensaje.TITULO_ME, Mensaje.INFORMACION);
    } else if (cboUnidadMedida.getSelectedIndex() == 0) {
        Mensaje.mensaje(this, "Seleccionar una Unidad de Medida", Mensaje.TITULO_ME, Mensaje.INFORMACION);
    } else if (PaqueteBusinessDelegate.getProductoService().
            verificarNombre(txtNombreProducto.getText().trim()).equalsIgnoreCase(txtNombreProducto.getText().trim())) {
        Mensaje.mensaje(this, "Producto ya existe, ingresar otro", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else {
        if (!jCheckBox2.isSelected()) {
            codigo = txtCodigoInterno.getText().toUpperCase().trim();
            
            if (PaqueteBusinessDelegate.getProductoService().verificarCodigo(codigo).equalsIgnoreCase(codigo)) {
                Mensaje.mensaje(this, "CODIGO ya existe, ingresar otro", Mensaje.TITULO_ME, Mensaje.ERROR);
                return;
            }
        }
        
        txtNombreProducto.setBackground(Color.WHITE);
        objProducto = new Producto();
        objFamilia = new Familia();
        objMedidaRotacion = new MedidaRotacion();
        objUnidadMedida = new UnidadMedida();

        objProducto.setStr_codigoInterno(codigo);
        objProducto.setStr_nombreProducto(txtNombreProducto.getText().toUpperCase().trim());
        objProducto.setStr_descripcion(txtDescripcionProducto.getText().toUpperCase().trim());

        objFamilia.setInt_idFamilia(listaFamilia.get(cboFamilia.getSelectedIndex() - 1).getInt_idFamilia());
        objProducto.setObjFamilia(objFamilia);

        objProducto.setStr_fabricante(txtFabricante.getText().toUpperCase().trim());

        objMedidaRotacion = new MedidaRotacion();
        if (rbtnMenor.isSelected()) {
            objMedidaRotacion.setInt_idMedidaRotacion(buscarMedidaRotacion(Util.MENOR));
        } else if (rbtnMedia.isSelected()) {
            objMedidaRotacion.setInt_idMedidaRotacion(buscarMedidaRotacion(Util.MEDIA));
        } else if (rbtnMayor.isSelected()) {
            objMedidaRotacion.setInt_idMedidaRotacion(buscarMedidaRotacion(Util.MAYOR));
        }
        objProducto.setObjMedidaRotacion(objMedidaRotacion);

        objUnidadMedida.setInt_idUnidadMedida(listaUnidadMedida.get(cboUnidadMedida.getSelectedIndex() - 1).getInt_idUnidadMedida());
        objProducto.setObjUnidadMedida(objUnidadMedida);

        if (jCheckBox1.isSelected()) {
            objProducto.setStr_reintegroTributario("SI");
        } else {
            objProducto.setStr_reintegroTributario("NO");
        }

        objProducto.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());
        objProducto.setStr_estado(Util.ACTIVO);

        if (PaqueteBusinessDelegate.getProductoService().registrarProducto(objProducto)) {
            Mensaje.mensaje(this, "Producto registrado correctamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            Limpiar();
        } else {
            Mensaje.mensaje(this, "No se pudo registrar el Producto", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }
}//GEN-LAST:event_btnRegistrarProductoActionPerformed

private void btnAsignarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarProveedorActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getASIGNARPRODUCTOPROVEEDOR())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    Util.hiloProgressBar(1, gui);
    if (frmProveedorProducto == null || frmProveedorProducto.isClosed()) {
        frmProveedorProducto = new ProveedorProducto(gui);
        frmProveedorProducto.setVisible(true);
        gui.addFrm(frmProveedorProducto);
        gui.enforcar(frmProveedorProducto);
        gui.getBarraEstado().nuevaVentanas();
        com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmProveedorProducto);
    }
    Util.hiloProgressBar(0, gui);
}//GEN-LAST:event_btnAsignarProveedorActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (jCheckBox2.isSelected()) {
            txtCodigoInterno.setEditable(false);
        } else if (!jCheckBox2.isSelected()) {
            txtCodigoInterno.setEditable(true);
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAsignarProveedor;
    private org.jdesktop.swingx.JXButton btnBuscarProducto;
    private org.jdesktop.swingx.JXButton btnModificarProducto;
    private org.jdesktop.swingx.JXButton btnRegistrarProducto;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXComboBox cboFamilia;
    private org.jdesktop.swingx.JXComboBox cboUnidadMedida;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel16;
    private org.jdesktop.swingx.JXLabel jXLabel17;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXPanel pnlDatosProducto;
    private org.jdesktop.swingx.JXPanel pnlOpciones;
    private javax.swing.JRadioButton rbtnMayor;
    private javax.swing.JRadioButton rbtnMedia;
    private javax.swing.JRadioButton rbtnMenor;
    private org.jdesktop.swingx.JXTextField txtCodigoInterno;
    private org.jdesktop.swingx.JXTextField txtDescripcionProducto;
    private org.jdesktop.swingx.JXTextField txtFabricante;
    private org.jdesktop.swingx.JXTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
        objProducto = new Producto();
    }

    private void cargarDatos() {
        jCheckBox2.setSelected(false);
        btnModificarProducto.setEnabled(false);
        cargarUnidadMedida();
        cargarFamilia();
        cargarMedidaRotacion();
        rbtn();
    }

    private void cargarMedidaRotacion() {
        listaMedidaRotacion = PaqueteBusinessDelegate.getMedidaRotacionService().listarMR();
    }

    private int buscarMedidaRotacion(String nombre) {
        for (MedidaRotacion objMR : listaMedidaRotacion) {
            if (objMR.getStr_nombreMR().equals(nombre)) {
                return objMR.getInt_idMedidaRotacion();
            }
        }

        return 0;
    }

    private void cargarFamilia() {
        cboFamilia.removeAllItems();
        Object objTitulo = ".::Seleccionar una familia::.";
        cboFamilia.addItem(objTitulo);

        try {
            listaFamilia = PaqueteBusinessDelegate.getFamiliaService().listarFamilia("%%", "%%");
            Object item;
            for (Familia objF : listaFamilia) {
                item = objF.getStr_nombre();
                cboFamilia.addItem(item);
            }
        } catch (SQLException ex) {
            log.error("Error al cargar familia: " + ex.getMessage());
        }
    }

    private void cargarUnidadMedida() {
        listaUnidadMedida = PaqueteBusinessDelegate.getUnidadMedidaService().listarUnidadMedida("%%", "%%");
        cboUnidadMedida.removeAllItems();
        cboUnidadMedida.addItem(".::Seleccionar unidad de medida::.");

        for (UnidadMedida objUM : listaUnidadMedida) {
            cboUnidadMedida.addItem(objUM.getStr_nombreUM());
        }
    }

    private void rbtn() {
        rbtnMenor.setSelected(true);
    }

    private void Limpiar() {
        txtCodigoInterno.setText("");
        txtNombreProducto.setText("");
        txtDescripcionProducto.setText("");
        cargarFamilia();
        txtFabricante.setText("");
        rbtn();
        cargarUnidadMedida();
        jCheckBox1.setSelected(false);
        txtCodigoInterno.requestFocus();
        objProducto = null;
    }

    protected void cargarDatosBusquedaProducto(Producto productoSeleccionado) {
        txtCodigoInterno.setText(productoSeleccionado.getStr_codigoInterno());
        txtNombreProducto.setText(productoSeleccionado.getStr_nombreProducto());
        txtDescripcionProducto.setText(productoSeleccionado.getStr_descripcion());
        cboFamilia.setSelectedItem(productoSeleccionado.getObjFamilia().getStr_nombre());
        txtFabricante.setText(productoSeleccionado.getStr_fabricante());

        if (productoSeleccionado.getObjMedidaRotacion().getStr_nombreMR().equals(Util.MENOR)) {
            rbtnMenor.setSelected(true);
        } else if (productoSeleccionado.getObjMedidaRotacion().getStr_nombreMR().equals(Util.MEDIA)) {
            rbtnMedia.setSelected(true);
        } else if (productoSeleccionado.getObjMedidaRotacion().getStr_nombreMR().equals(Util.MAYOR)) {
            rbtnMayor.setSelected(true);
        }

        cboUnidadMedida.setSelectedItem(productoSeleccionado.getObjUnidadMedida().getStr_nombreUM());

        if (productoSeleccionado.getStr_reintegroTributario().equalsIgnoreCase("SI")) {
            jCheckBox1.setSelected(true);
        } else {
            jCheckBox1.setSelected(false);
        }

        this.objProducto = productoSeleccionado;
    }
}
