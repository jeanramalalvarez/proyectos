/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.gui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.Cliente;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import com.gestionmatriz.util.ValidarCamposNulos;

/**
 *
 * @author cesareo
 */
public class GestionCliente extends javax.swing.JInternalFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal gui;
    private Cliente objCliente = null;

    public GestionCliente(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
        this.setTitle("" + gui.getTitle().concat(" - ").concat(" - [Modulo: Cliente]"));
    }

   
    private void initComponents() {

        pupLimpiar = new javax.swing.JPopupMenu();
        mnuLimpiar = new javax.swing.JMenuItem();
        pnlDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        txtRucDni = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        pnlOpciones = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnInactivar = new javax.swing.JButton();

        mnuLimpiar.setText("Limpiar");
        mnuLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLimpiarActionPerformed(evt);
            }
        });
        pupLimpiar.add(mnuLimpiar);

        setClosable(true);
        setIconifiable(true);

        pnlDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));
        pnlDatos.setComponentPopupMenu(pupLimpiar);

        jLabel1.setText("Razón social:");

        jLabel2.setText("RUC / DNI:");

        jLabel3.setText("Dirección:");

        jLabel4.setText("Teléfono:");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRucDni, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRucDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pnlOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnInactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/inactivo.png"))); // NOI18N
        btnInactivar.setText("Inactivar");
        btnInactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInactivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCLIENTE_REGISTRAR())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        JTextField[] txts = {txtRazonSocial, txtRucDni};
        if (!ValidarCamposNulos.validar(txts)) {
            Mensaje.mensaje(this, "Los campos resaltados son importantes", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtRazonSocial.requestFocus();
            return;
        }
        
        if (!validarRucDni(txtRucDni.getText())) {
            Mensaje.mensaje(this, "Ingresar solo 8 u 11 caracteres", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtRucDni.selectAll();
            txtRucDni.requestFocus();
            return;
        }
        
        objCliente = new Cliente();
        
        objCliente.setStr_razonSocial(txtRazonSocial.getText().toUpperCase());
        objCliente.setStr_rucdni(txtRucDni.getText());
        objCliente.setStr_direccion(txtDireccion.getText().toUpperCase());
        objCliente.setStr_telefono(txtTelefono.getText());
        objCliente.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());
        
        if (PaqueteBusinessDelegate.getClienteService().registrarCliente(objCliente)) {
            Mensaje.mensaje(this, "Cliente registrado", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            limpiarDatos();
        } else {
            Mensaje.mensaje(this, "Error al registrar Cliente", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            List<Cliente> listaCliente = PaqueteBusinessDelegate.getClienteService().
                    listarCliente(txtRazonSocial.getText(), txtRucDni.getText(), txtDireccion.getText(), txtTelefono.getText());

            if (listaCliente.isEmpty()) {
                Mensaje.mensaje(this, "No existen Clientes", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            } else if (listaCliente.size() == 1) {
                cargarDatosBusquedaCliente(listaCliente.get(0));
            } else if (listaCliente.size() > 1) {
                Util.hiloProgressBar(1, gui);
                BuscarCliente frmBuscarCliente = new BuscarCliente(gui, listaCliente, this);
                Util.hiloProgressBar(0, gui);
                frmBuscarCliente.cargarPanelBusquedaCliente(listaCliente);
                frmBuscarCliente.setVisible(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(GestionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCLIENTE_MODIFICAR())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        JTextField[] txts = {txtRazonSocial, txtRucDni};
        if (!ValidarCamposNulos.validar(txts)) {
            Mensaje.mensaje(this, "Los campos resaltados son importantes", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtRazonSocial.requestFocus();
            return;
        }
        
        objCliente.setStr_razonSocial(txtRazonSocial.getText().toUpperCase());
        objCliente.setStr_rucdni(txtRucDni.getText());
        objCliente.setStr_direccion(txtDireccion.getText().toUpperCase());
        objCliente.setStr_telefono(txtTelefono.getText());
        objCliente.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());
        
        if (PaqueteBusinessDelegate.getClienteService().modificarCliente(objCliente)) {
            Mensaje.mensaje(this, "Cliente modificado", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            limpiarDatos();
        } else {
            Mensaje.mensaje(this, "Error al modificar Cliente", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnInactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInactivarActionPerformed
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCLIENTE_INACTIVAR())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        objCliente.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());
        
        if (PaqueteBusinessDelegate.getClienteService().inactivarCliente(objCliente)) {
            Mensaje.mensaje(this, "Cliente desactivado", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            limpiarDatos();
        } else {
            Mensaje.mensaje(this, "Error al desactivar Cliente", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }//GEN-LAST:event_btnInactivarActionPerformed

    private void mnuLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLimpiarActionPerformed
        limpiarDatos();
    }//GEN-LAST:event_mnuLimpiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnInactivar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem mnuLimpiar;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPopupMenu pupLimpiar;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRucDni;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
        objCliente = new Cliente();
    }

    private void limpiarDatos() {
        objCliente = null;
        txtRazonSocial.setText("");
        txtRucDni.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtRazonSocial.requestFocus();
        cargarDatos();
    }

    protected void cargarDatosBusquedaCliente(Cliente objC) {
        txtRazonSocial.setText(objC.getStr_razonSocial());
        txtRucDni.setText(objC.getStr_rucdni());
        txtDireccion.setText(objC.getStr_direccion());
        txtTelefono.setText(objC.getStr_telefono());
        txtRazonSocial.selectAll();
        txtRazonSocial.requestFocus();
        btnRegistrar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnInactivar.setEnabled(true);
        
        this.objCliente = objC;
    }
    
    private void cargarDatos() {
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnInactivar.setEnabled(false);
    }
    
    private boolean validarRucDni(String rucdni) {
        boolean respuesta = false;
        
        if (rucdni.length() == 8 || rucdni.length() == 11) {
            respuesta = true;
        }
        
        return respuesta;
    }
}
