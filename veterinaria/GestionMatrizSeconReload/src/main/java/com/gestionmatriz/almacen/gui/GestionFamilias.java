/*
 * GestionFamilias.java
 *
 * Created on 09-jun-2012, 10:17:23
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.almacen.bean.Familia;
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
public class GestionFamilias extends javax.swing.JInternalFrame {
    
    private Principal gui;
    private Familia objFamilia = null;

    public GestionFamilias(Principal gui) {
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
        txtNombreFamilia = new org.jdesktop.swingx.JXTextField();
        txtCodigoFamilia = new org.jdesktop.swingx.JXTextField();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        txtDescFamilia = new org.jdesktop.swingx.JXTextField();
        pnlOpciones = new org.jdesktop.swingx.JXPanel();
        btnRegistrarFamilia = new org.jdesktop.swingx.JXButton();
        btnBuscarFamilia = new org.jdesktop.swingx.JXButton();
        btnModificarFamilia = new org.jdesktop.swingx.JXButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTION FAMILIAS");
        setPreferredSize(new java.awt.Dimension(519, 255));

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Gestión de Familias", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXLabel1.setText("Nombre :");

        jXLabel2.setText("Descripción :");

        jXLabel3.setText("Código Familia :");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCodigoFamilia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombreFamilia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                    .addComponent(txtDescFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Opciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnRegistrarFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrarFamilia.setText("Registrar");
        btnRegistrarFamilia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrarFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarFamiliaActionPerformed(evt);
            }
        });

        btnBuscarFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarFamilia.setText("Buscar");
        btnBuscarFamilia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscarFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFamiliaActionPerformed(evt);
            }
        });

        btnModificarFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/modificar.png"))); // NOI18N
        btnModificarFamilia.setText("Modificar");
        btnModificarFamilia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificarFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarFamiliaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpcionesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnRegistrarFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscarFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnRegistrarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarFamiliaActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREGISTRARFAMILIA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    
    if(txtNombreFamilia.getText().trim().length() <= 0) {
        txtNombreFamilia.setBackground(Color.PINK);
        Mensaje.mensaje(this, "Los campos resaltados son Obligatorios", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else if (PaqueteBusinessDelegate.getFamiliaService().
            verificarNombre(txtNombreFamilia.getText()).equalsIgnoreCase(txtNombreFamilia.getText())) {
        Mensaje.mensaje(this, "Familia ya existe, ingresar otro", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else {
        txtNombreFamilia.setBackground(Color.WHITE);
        objFamilia = new Familia();

        objFamilia.setStr_nombre(txtNombreFamilia.getText().toUpperCase());
        objFamilia.setStr_descripcion(txtDescFamilia.getText().toUpperCase());
        objFamilia.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());
        objFamilia.setStr_estado(Util.ACTIVO);

        if (PaqueteBusinessDelegate.getFamiliaService().registrarFamilia(objFamilia)) {
            Mensaje.mensaje(this, "Familia registrada correctamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            Limpiar();
        } else {
            Mensaje.mensaje(this, "No se pudo registrar la Familia", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }
}//GEN-LAST:event_btnRegistrarFamiliaActionPerformed

private void btnBuscarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFamiliaActionPerformed
    try {
        List<Familia> listaFamilias = PaqueteBusinessDelegate.getFamiliaService().
                listarFamilia("%" + txtCodigoFamilia.getText().trim() + "%",
                "%" + txtNombreFamilia.getText().trim() + "%");

        if (listaFamilias.isEmpty()) {
            Mensaje.mensaje(this, "No existen Familias", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        } else if (listaFamilias.size() == 1) {
            cargarDatosBusquedaFamilia(listaFamilias.get(0));
        } else if (listaFamilias.size() > 1) {
            Util.hiloProgressBar(1, gui);
            BuscarFamilia frmBuscarFamilia = new BuscarFamilia(gui, listaFamilias, this);
            Util.hiloProgressBar(0, gui);
            frmBuscarFamilia.cargarPanelBusquedaFamilias(listaFamilias);
            frmBuscarFamilia.setVisible(true);
        }
    } catch (Exception ex) {
        Logger.getLogger(GestionFamilias.class.getName()).log(Level.SEVERE, null, ex);
    }

}//GEN-LAST:event_btnBuscarFamiliaActionPerformed

private void btnModificarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarFamiliaActionPerformed
    
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getMODIFICARFAMILIA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    
    
    if(txtNombreFamilia.getText().trim().length() <= 0) {
        txtNombreFamilia.setBackground(Color.PINK);
        Mensaje.mensaje(this, "Los campos resaltados son Obligatorios", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else {
        objFamilia.setStr_nombre(txtNombreFamilia.getText().toUpperCase());
        objFamilia.setStr_descripcion(txtDescFamilia.getText().toUpperCase());
        objFamilia.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());

        if (PaqueteBusinessDelegate.getFamiliaService().modificarFamilia(objFamilia)) {
            Mensaje.mensaje(this, "Familia modificada correctamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            Limpiar();
        } else {
            Mensaje.mensaje(this, "No se pudo modificar la Familia", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }

}//GEN-LAST:event_btnModificarFamiliaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscarFamilia;
    private org.jdesktop.swingx.JXButton btnModificarFamilia;
    private org.jdesktop.swingx.JXButton btnRegistrarFamilia;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel pnlOpciones;
    private org.jdesktop.swingx.JXTextField txtCodigoFamilia;
    private org.jdesktop.swingx.JXTextField txtDescFamilia;
    private org.jdesktop.swingx.JXTextField txtNombreFamilia;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
    }

    private void Limpiar() {
        txtCodigoFamilia.setText("");
        txtNombreFamilia.setText("");
        txtDescFamilia.setText("");
        txtNombreFamilia.requestFocus();
        btnRegistrarFamilia.setEnabled(true);
        btnModificarFamilia.setEnabled(false);
        this.objFamilia = null;
    }

    protected void cargarDatosBusquedaFamilia(Familia objFamilia) {
        txtCodigoFamilia.setText(objFamilia.getStr_codigoFamilia());
        txtNombreFamilia.setText(objFamilia.getStr_nombre());
        txtDescFamilia.setText(objFamilia.getStr_descripcion());
        btnRegistrarFamilia.setEnabled(false);
        btnModificarFamilia.setEnabled(true);
        this.objFamilia = objFamilia;
    }
    
    private void cargarDatos() {
        txtCodigoFamilia.setEditable(false);
        btnModificarFamilia.setEnabled(false);
    }
    
}
