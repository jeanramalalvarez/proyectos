/*
 * GestionProveedor.java
 *
 * Created on 12-jun-2012, 14:53:27
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.opciones.Opciones;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Impresora;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import com.gestionmatriz.util.ValidarCamposNulos;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.swingx.JXTextField;

/**
 *
 * @author zholo
 */
public class GestionProveedor extends javax.swing.JInternalFrame {
    
    public Impresora imp;
        
    public GestionProveedor(Principal gui) {
        this.gui = gui;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popLimpiar = new javax.swing.JPopupMenu();
        mniLimpiar = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        mniCopiarRuc = new javax.swing.JMenuItem();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        txtRazonSocialProv = new org.jdesktop.swingx.JXTextField();
        txtNombreComercialProv = new org.jdesktop.swingx.JXTextField();
        txtRucProv = new org.jdesktop.swingx.JXTextField();
        txtDireccionProv = new org.jdesktop.swingx.JXTextField();
        txtEmailProv = new org.jdesktop.swingx.JXTextField();
        txtTelefonoProv = new org.jdesktop.swingx.JXTextField();
        txtRepresentanteProv = new org.jdesktop.swingx.JXTextField();
        txtBancoProv = new org.jdesktop.swingx.JXTextField();
        txtCtaBancaria1 = new org.jdesktop.swingx.JXTextField();
        txtCtaBancaria2 = new org.jdesktop.swingx.JXTextField();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        txtFaxProve = new org.jdesktop.swingx.JXTextField();
        pnlOpciones = new org.jdesktop.swingx.JXPanel();
        btnRegistrarProducto = new org.jdesktop.swingx.JXButton();
        btnBuscarProducto = new org.jdesktop.swingx.JXButton();
        btnModificarProducto = new org.jdesktop.swingx.JXButton();
        btnModificarProducto1 = new org.jdesktop.swingx.JXButton();

        mniLimpiar.setText("Limpiar");
        mniLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLimpiarActionPerformed(evt);
            }
        });
        popLimpiar.add(mniLimpiar);

        mniCopiarRuc.setText("Copiar Ruc");
        jPopupMenu1.add(mniCopiarRuc);

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTION DE PROVEEDORES");
        setComponentPopupMenu(popLimpiar);

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del Proveedor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXLabel1.setText("Razón Social :");

        jXLabel2.setText("Nombre Comercial :");

        jXLabel3.setText("R.U.C. :");

        jXLabel4.setText("Dirección :");

        jXLabel5.setText("E-mail :");

        jXLabel6.setText("Telefono :");

        jXLabel7.setText("Representante Legal :");

        jXLabel8.setText("Banco :");

        jXLabel9.setText("Cta Bancaria Principal :");

        jXLabel10.setText("Cta Bancaria Alternativa:");

        txtRucProv.setComponentPopupMenu(jPopupMenu1);
        txtRucProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucProvKeyTyped(evt);
            }
        });

        jXLabel11.setText("Fax :");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRazonSocialProv, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(txtNombreComercialProv, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(txtDireccionProv, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(txtEmailProv, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(txtRucProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTelefonoProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFaxProve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCtaBancaria2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRepresentanteProv, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(txtBancoProv, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(txtCtaBancaria1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonSocialProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreComercialProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRucProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFaxProve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRepresentanteProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBancoProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCtaBancaria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCtaBancaria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Opciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrarProducto.setText("Registrar");
        btnRegistrarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProductoActionPerformed(evt);
            }
        });
        pnlOpciones.add(btnRegistrarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 27, 169, 51));

        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        pnlOpciones.add(btnBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 84, 169, 49));

        btnModificarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/modificar.png"))); // NOI18N
        btnModificarProducto.setText("Modificar");
        btnModificarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProductoActionPerformed(evt);
            }
        });
        pnlOpciones.add(btnModificarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 139, 169, 52));

        btnModificarProducto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/asignarproducto.png"))); // NOI18N
        btnModificarProducto1.setText("Asignar Productos");
        btnModificarProducto1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProducto1ActionPerformed(evt);
            }
        });
        pnlOpciones.add(btnModificarProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 197, -1, 52));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(popLimpiar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProductoActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREGISTRARPROVEEDOR())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (txtRucProv.getText().length() != 11) {
        Mensaje.mensaje(this, "El RUC Ingresado no Cuenta con 11 Digitos", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    JXTextField txts[] = {txtRucProv, txtRazonSocialProv};
    if (ValidarCamposNulos.validar(txts)) {
        objProveedor = new Proveedor();
        objProveedor.setStr_razonSocial(txtRazonSocialProv.getText());
        objProveedor.setStr_nombreComercial(txtNombreComercialProv.getText());
        objProveedor.setStr_ruc(txtRucProv.getText());
        objProveedor.setStr_direccion(txtDireccionProv.getText());
        objProveedor.setStr_email(txtEmailProv.getText());
        objProveedor.setStr_telefono(txtTelefonoProv.getText());
        objProveedor.setStr_fax(txtFaxProve.getText());
        objProveedor.setStr_representanteLegal(txtRepresentanteProv.getText());
        objProveedor.setStr_banco(txtBancoProv.getText());
        objProveedor.setStr_ctaPrincipal(txtCtaBancaria1.getText());
        objProveedor.setStr_ctaAlternativa(txtCtaBancaria2.getText());
        objProveedor.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());



        if (PaqueteBusinessDelegate.getProveedorService().registrarProveedor(objProveedor) == true) {
            Mensaje.mensaje(this, "Proveedor registrado correctamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            Limpiar();
        } else {
            Mensaje.mensaje(this, "No se pudo registrar al proveedor", Mensaje.TITULO_ME, Mensaje.ERROR);
        }

    } else {
        Mensaje.mensaje(this, "Los campos resaltados son Obligatorios", Mensaje.TITULO_ME, Mensaje.ERROR);
    }
}//GEN-LAST:event_btnRegistrarProductoActionPerformed

private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
    try {
        List<Proveedor> listaProveedores =
                PaqueteBusinessDelegate.getProveedorService().
                buscarProveedor("%" + txtRucProv.getText().trim() + "%", "%" + txtRazonSocialProv.getText().trim() + "%");

        if (listaProveedores.size() == 1) {
            for (Proveedor objProve : listaProveedores) {
                cargarDatosBusquedaProveedor(objProve);
                this.objProveedor = objProve;
            }
        } else if (listaProveedores.size() > 1) {
            com.gestionmatriz.util.Util.hiloProgressBar(1, gui);
            BuscarProveedor frmBuscarProveedor = new BuscarProveedor(gui, listaProveedores, this);
            com.gestionmatriz.util.Util.hiloProgressBar(0, gui);
            frmBuscarProveedor.cargarPanelBusquedaProveedor(listaProveedores);
            frmBuscarProveedor.setVisible(true);
        }
    } catch (Exception ex) {
        Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_btnBuscarProductoActionPerformed

private void mniLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLimpiarActionPerformed
    Limpiar();
}//GEN-LAST:event_mniLimpiarActionPerformed

private void btnModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductoActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getMODIFICARPROVEEDOR())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    //        System.out.println("idProveedor---:"+objProveedor.getInt_idProveedor());
//    objProveedor=new Proveedor();
//        objProveedor
    if (txtRucProv.getText().length() != 11) {
        Mensaje.mensaje(this, "El RUC Ingresado no Cuenta con 11 Digitos", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    JXTextField txts[] = {txtRucProv, txtRazonSocialProv};
    if (ValidarCamposNulos.validar(txts)) {
        objProveedor.setStr_razonSocial(txtRazonSocialProv.getText());
        objProveedor.setStr_nombreComercial(txtNombreComercialProv.getText());
        objProveedor.setStr_ruc(txtRucProv.getText());
        objProveedor.setStr_direccion(txtDireccionProv.getText());
        objProveedor.setStr_email(txtEmailProv.getText());
        objProveedor.setStr_telefono(txtTelefonoProv.getText());
        objProveedor.setStr_fax(txtFaxProve.getText());
        objProveedor.setStr_representanteLegal(txtRepresentanteProv.getText());
        objProveedor.setStr_banco(txtBancoProv.getText());
        objProveedor.setStr_ctaPrincipal(txtCtaBancaria1.getText());
        objProveedor.setStr_ctaAlternativa(txtCtaBancaria2.getText());
        objProveedor.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());



        if (PaqueteBusinessDelegate.getProveedorService().modificarProveedor(objProveedor) == true) {
            Mensaje.mensaje(this, "Proveedor modificado correctamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            Limpiar();
        } else {
            Mensaje.mensaje(this, "No se pudo modificar al proveedor", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    } else {
        Mensaje.mensaje(this, "Los campos resaltados son Obligatorios", Mensaje.TITULO_ME, Mensaje.ERROR);
    }
}//GEN-LAST:event_btnModificarProductoActionPerformed

private void txtRucProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucProvKeyTyped

    char c = evt.getKeyChar();
    if (!(Character.isDigit(c)
            || (c == KeyEvent.VK_BACK_SPACE)
            || (c == KeyEvent.VK_DELETE)
            || (c == KeyEvent.VK_C)
            || (c == KeyEvent.CTRL_MASK))
            || txtRucProv.getText().trim().length() == 11) {
        Mensaje.mensaje(this, "Error: \n"
                + "•\tNo puede ingresar letras.\n "
                + "•\tSolo puede ingresar 11 dígitos para el RUC.",
                Mensaje.TITULO_ME, Mensaje.ERROR);
        getToolkit().beep();
        evt.consume();
    }

}//GEN-LAST:event_txtRucProvKeyTyped

private void btnModificarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProducto1ActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getASIGNARPRODUCTOPROVEEDOR())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    Util.hiloProgressBar(1, gui);
    if (frmProveedorProd == null || frmProveedorProd.isClosed()) {
        frmProveedorProd = new ProveedorProducto(gui);
        frmProveedorProd.setVisible(true);
        gui.addFrm(frmProveedorProd);
        gui.enforcar(frmProveedorProd);
        gui.getBarraEstado().nuevaVentanas();
        com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmProveedorProd);
    }
    Util.hiloProgressBar(0, gui);
}//GEN-LAST:event_btnModificarProducto1ActionPerformed

    public void Limpiar() {
        txtRazonSocialProv.setText("");
        txtNombreComercialProv.setText("");
        txtRucProv.setText("");
        txtDireccionProv.setText("");
        txtEmailProv.setText("");
        txtTelefonoProv.setText("");
        txtFaxProve.setText("");
        txtRepresentanteProv.setText("");
        txtBancoProv.setText("");
        txtCtaBancaria1.setText("");
        txtCtaBancaria2.setText("");

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscarProducto;
    private org.jdesktop.swingx.JXButton btnModificarProducto;
    private org.jdesktop.swingx.JXButton btnModificarProducto1;
    private org.jdesktop.swingx.JXButton btnRegistrarProducto;
    private javax.swing.JPopupMenu jPopupMenu1;
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
    private javax.swing.JMenuItem mniCopiarRuc;
    private javax.swing.JMenuItem mniLimpiar;
    private org.jdesktop.swingx.JXPanel pnlOpciones;
    private javax.swing.JPopupMenu popLimpiar;
    private org.jdesktop.swingx.JXTextField txtBancoProv;
    private org.jdesktop.swingx.JXTextField txtCtaBancaria1;
    private org.jdesktop.swingx.JXTextField txtCtaBancaria2;
    private org.jdesktop.swingx.JXTextField txtDireccionProv;
    private org.jdesktop.swingx.JXTextField txtEmailProv;
    private org.jdesktop.swingx.JXTextField txtFaxProve;
    private org.jdesktop.swingx.JXTextField txtNombreComercialProv;
    private org.jdesktop.swingx.JXTextField txtRazonSocialProv;
    private org.jdesktop.swingx.JXTextField txtRepresentanteProv;
    private org.jdesktop.swingx.JXTextField txtRucProv;
    private org.jdesktop.swingx.JXTextField txtTelefonoProv;
    // End of variables declaration//GEN-END:variables
    private Proveedor objProveedor;
    private Principal gui;
    private ProveedorProducto frmProveedorProd;

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

    protected void cargarDatosBusquedaProveedor(Proveedor objProveedor) {
//        System.out.println("cargardatos proveedor---:"+objProveedor.getInt_idProveedor());
        txtRazonSocialProv.setText(objProveedor.getStr_razonSocial());
        txtNombreComercialProv.setText(objProveedor.getStr_nombreComercial());
        txtRucProv.setText(objProveedor.getStr_ruc());
        txtDireccionProv.setText(objProveedor.getStr_direccion());
        txtEmailProv.setText(objProveedor.getStr_email());
        txtTelefonoProv.setText(objProveedor.getStr_telefono());
        txtFaxProve.setText(objProveedor.getStr_fax());
        txtRepresentanteProv.setText(objProveedor.getStr_representanteLegal());
        txtBancoProv.setText(objProveedor.getStr_banco());
        txtCtaBancaria1.setText(objProveedor.getStr_ctaPrincipal());
        txtCtaBancaria2.setText(objProveedor.getStr_ctaAlternativa());

        this.objProveedor = objProveedor;
    }
}
