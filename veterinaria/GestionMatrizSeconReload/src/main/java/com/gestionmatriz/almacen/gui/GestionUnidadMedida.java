/*
 * GestionFamilias.java
 *
 * Created on 09-jun-2012, 10:17:23
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.almacen.bean.UnidadMedida;
import com.gestionmatriz.almacen.opciones.Opciones;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zholo
 */
public class GestionUnidadMedida extends javax.swing.JInternalFrame {

    private Principal gui;
    private UnidadMedida objUM = null;
    
    public GestionUnidadMedida(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtNombreUM = new org.jdesktop.swingx.JXTextField();
        txtCodigoUM = new org.jdesktop.swingx.JXTextField();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        txtDescUM = new org.jdesktop.swingx.JXTextField();
        pnlOpciones = new org.jdesktop.swingx.JXPanel();
        btnRegistrarUM = new org.jdesktop.swingx.JXButton();
        btnBuscarUM = new org.jdesktop.swingx.JXButton();
        btnModificarUM = new org.jdesktop.swingx.JXButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTION UNIDAD MEDIDA");
        setPreferredSize(new java.awt.Dimension(518, 260));

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Gestión de Unidad de Medida", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jXPanel1.setPreferredSize(new java.awt.Dimension(450, 125));

        jXLabel1.setText("Nombre :");

        jXLabel2.setText("Descripción :");

        jXLabel3.setText("Código Unidad Medida:");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)))
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCodigoUM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombreUM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescUM, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigoUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtNombreUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pnlOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Opciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlOpciones.setPreferredSize(new java.awt.Dimension(420, 66));

        btnRegistrarUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrarUM.setText("Registrar");
        btnRegistrarUM.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnRegistrarUM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUMActionPerformed(evt);
            }
        });

        btnBuscarUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarUM.setText("Buscar");
        btnBuscarUM.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnBuscarUM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUMActionPerformed(evt);
            }
        });

        btnModificarUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/modificar.png"))); // NOI18N
        btnModificarUM.setText("Modificar");
        btnModificarUM.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnModificarUM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrarUM, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarUM, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarUM, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarUM, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarUM, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarUM, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnRegistrarUMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUMActionPerformed
    
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREGISTRARUNIDADMEDIDA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if(txtNombreUM.getText().trim().length() <= 0) {
        txtNombreUM.setBackground(Color.PINK);
        Mensaje.mensaje(this, "Los campos resaltados son Obligatorios", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else if (PaqueteBusinessDelegate.getUnidadMedidaService().
            verificarNombre(txtNombreUM.getText()).equalsIgnoreCase(txtNombreUM.getText())) {
        Mensaje.mensaje(this, "Unidad de Medida ya existe, ingresar otro", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else {
        txtNombreUM.setBackground(Color.WHITE);
        objUM = new UnidadMedida();

        objUM.setStr_nombreUM(txtNombreUM.getText().toUpperCase());
        objUM.setStr_descripcionUM(txtDescUM.getText().toUpperCase());
        objUM.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());
        objUM.setStr_estado(Util.ACTIVO);

        if (PaqueteBusinessDelegate.getUnidadMedidaService().registrarUM(objUM)) {
            Mensaje.mensaje(this, "Unidad de Medida registrada correctamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            Limpiar();
        } else {
            Mensaje.mensaje(this, "No se pudo registrar la Unidad de Medida", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }
}//GEN-LAST:event_btnRegistrarUMActionPerformed

private void btnBuscarUMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUMActionPerformed
    try {
        List<UnidadMedida> listaUM = PaqueteBusinessDelegate.getUnidadMedidaService().
                listarUnidadMedida("%" + txtCodigoUM.getText().trim() + "%",
                "%" + txtNombreUM.getText().trim() + "%");

        if (listaUM.isEmpty()) {
            Mensaje.mensaje(this, "No existen Unidades de Medidas", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        } else if (listaUM.size() == 1) {
            cargarDatosBusquedaUnidadMedida(listaUM.get(0));
        } else if (listaUM.size() > 1) {
            Util.hiloProgressBar(1, gui);
            BuscarUnidadMedida frmBuscarUM = new BuscarUnidadMedida(gui, listaUM, this);
            Util.hiloProgressBar(0, gui);
            frmBuscarUM.cargarPanelBusquedaUM(listaUM);
            frmBuscarUM.setVisible(true);
        }
    } catch (Exception ex) {
        Logger.getLogger(GestionUnidadMedida.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_btnBuscarUMActionPerformed

private void btnModificarUMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUMActionPerformed
   
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getMODIFICARUNIDADMEDIDA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    
    if(txtNombreUM.getText().trim().length() <= 0) {
        txtNombreUM.setBackground(Color.PINK);
        Mensaje.mensaje(this, "Los campos resaltados son Obligatorios", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else {
        objUM.setStr_nombreUM(txtNombreUM.getText().toUpperCase());
        objUM.setStr_descripcionUM(txtDescUM.getText().toUpperCase());
        objUM.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());

        if (PaqueteBusinessDelegate.getUnidadMedidaService().modificarUM(objUM)) {
            Mensaje.mensaje(this, "Unidad de Medida modificada correctamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            Limpiar();
        } else {
            Mensaje.mensaje(this, "No se pudo modificar la Unidad de Medida", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }
}//GEN-LAST:event_btnModificarUMActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscarUM;
    private org.jdesktop.swingx.JXButton btnModificarUM;
    private org.jdesktop.swingx.JXButton btnRegistrarUM;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel pnlOpciones;
    private org.jdesktop.swingx.JXTextField txtCodigoUM;
    private org.jdesktop.swingx.JXTextField txtDescUM;
    private org.jdesktop.swingx.JXTextField txtNombreUM;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
        this.objUM = new UnidadMedida();
    }

    private void Limpiar() {
        txtCodigoUM.setText("");
        txtNombreUM.setText("");
        txtDescUM.setText("");
        txtNombreUM.requestFocus();
        btnRegistrarUM.setEnabled(true);
        btnModificarUM.setEnabled(false);
        this.objUM = null;
    }

    protected void cargarDatosBusquedaUnidadMedida(UnidadMedida objUM) {
        txtCodigoUM.setText(objUM.getStr_codigoUM());
        txtNombreUM.setText(objUM.getStr_nombreUM());
        txtDescUM.setText(objUM.getStr_descripcionUM());
        btnRegistrarUM.setEnabled(false);
        btnModificarUM.setEnabled(true);
        this.objUM = objUM;
    }
    
    private void cargarDatos() {
        txtCodigoUM.setEditable(false);
        btnModificarUM.setEnabled(false);
    }
    
}
