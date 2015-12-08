/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ModificarContrasenia.java
 *
 * Created on 26-may-2012, 9:23:59
 */
package com.gestionmatriz.seguridad.gui;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.gestionmatriz.config.services.KeyService_I;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.seguridad.bean.Usuario;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.util.EncriptionSource;
import com.gestionmatriz.util.FunctionByte;
import com.gestionmatriz.util.Mensaje;

/**
 *
 * @author zholo
 */
public class ModificarContrasenia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(ModificarContrasenia.class);
	private Principal frmPrincipal;
    private Logeo logueo;
    private Usuario objUsuario;
    private Principal principal;
    private int puntero;
    private KeyService_I objKey_I;
    private Empresa objEmpresa;
    private Local objLocal;

    public ModificarContrasenia(Logeo logueo, Usuario objUsuario, int puntero,
            Empresa objEmpresa, Local objLocal) {
        this.logueo = logueo;
        this.objUsuario = objUsuario;
        this.puntero = puntero;//si es 0 viene del logeo si es 1 viene del menu sistema
        initComponents();
        txtUsuario.setText(logueo.getUsuario().toUpperCase());
        this.txtPasswordActual.requestFocus();
        this.objLocal = objLocal;
        this.objEmpresa = objEmpresa;
    }

    public ModificarContrasenia(Principal principal, int puntero) {
        this.puntero = puntero;//si es 0 viene del logeo si es 1 viene del menu sistema
//       this.objUsuario=objUsuario;
        this.principal = principal;
        initComponents();
        txtUsuario.setText(principal.getBarraEstado().getUsuario().toUpperCase());
    }

    
    private void initComponents() {

        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        btnAceptar = new org.jdesktop.swingx.JXButton();
        btnCancelar = new org.jdesktop.swingx.JXButton();
        txtUsuario = new org.jdesktop.swingx.JXTextField();
        txtPasswordActual = new javax.swing.JPasswordField();
        txtNuevoPassword = new javax.swing.JPasswordField();
        txtConfirmarPassword = new javax.swing.JPasswordField();
        pnlTitulo = new org.jdesktop.swingx.JXTitledPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Contraseña");
        getContentPane().setLayout(null);

        jXPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jXLabel1.setText("Usuario :");
        jXLabel1.setFont(new java.awt.Font("Consolas", 1, 12));

        jXLabel2.setText("Contraseña Actual :");
        jXLabel2.setFont(new java.awt.Font("Consolas", 1, 12));

        jXLabel3.setText("Nueva Contraseña :");
        jXLabel3.setFont(new java.awt.Font("Consolas", 1, 12));

        jXLabel4.setText("Confirmar  Contraseña :");
        jXLabel4.setFont(new java.awt.Font("Consolas", 1, 12));

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

        txtUsuario.setEditable(false);
        txtUsuario.setOpaque(false);

        txtPasswordActual.setFont(new java.awt.Font("Consolas", 1, 12));

        txtNuevoPassword.setFont(new java.awt.Font("Consolas", 1, 12));

        txtConfirmarPassword.setFont(new java.awt.Font("Consolas", 1, 12));

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txtPasswordActual, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtNuevoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jXPanel1Layout.createSequentialGroup()
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXPanel1Layout.createSequentialGroup()
                                    .addGap(170, 170, 170)
                                    .addComponent(txtConfirmarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(31, 31, 31))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPasswordActual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNuevoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtConfirmarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        getContentPane().add(jXPanel1);
        jXPanel1.setBounds(0, 40, 380, 170);
        setUndecorated(true);

        pnlTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlTitulo.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        pnlTitulo.setTitle("Modificar Contraseña");
        getContentPane().add(pnlTitulo);
        pnlTitulo.setBounds(0, 0, 380, 34);

        pack();
    }// </editor-fold>                        

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    if (puntero == 0) {
        Object objConfirmacion = Mensaje.confirmar(this, "Desea Salir del Sistema", "Mensaje Confirmación",
                Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);

        if (objConfirmacion.equals(Mensaje.YES_OPTION)) {
            try {
                ConexionSql.cerrarConexionAll(ConexionSql.getConexion());
                System.exit(0);
            } catch (SQLException ex) {
                log.error("Error al Cerra Conexion a la BD: " + ex.getMessage());
                System.exit(0);
            }
        }
    } else {
        this.dispose();
    }
}//GEN-LAST:event_btnCancelarActionPerformed

private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

    String actualPass = new String(txtPasswordActual.getPassword());
    String nuevoPass = new String(txtNuevoPassword.getPassword());
    String repetirPass = new String(txtConfirmarPassword.getPassword());
    String descPass = "";
    if (puntero == 1) {
        objUsuario = PaqueteBusinessDelegate.getUsuarioService().
                consultarIdUsuario(txtUsuario.getText());

        EncriptionSource objEncriptador = new EncriptionSource();
        try {
            //Atributos para la desencriptacion
            objKey_I = PaqueteBusinessDelegate.getKeyService();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        byte[] llave = FunctionByte.hex2byte(objKey_I.getKey().getKey());

        descPass = objEncriptador.Decrypt(llave, FunctionByte.hex2byte(objUsuario.getStr_contrasenia()));

    }


    if (actualPass.equals("")) {
        Mensaje.mensaje(this, "Debe Ingresar la Contraseña Actual", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    if (nuevoPass.equals("")) {
        Mensaje.mensaje(this, "Debe Ingresar la Nueva Contraseña", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    if (repetirPass.equals("")) {
        Mensaje.mensaje(this, "Debe Confirmar la Contraseña", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (puntero == 0) {
        if (!actualPass.equals(logueo.getPassword())) {
            Mensaje.mensaje(this, "Contraseña Actual no es Correcta", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
    }
    if (puntero == 1) {

        if (!actualPass.equals(descPass)) {
            Mensaje.mensaje(this, "Contraseña Actual no es Correcta", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }

    }


    if (!nuevoPass.equals(repetirPass)) {
        Mensaje.mensaje(this, "Nueva Contraseña no se Confirmo Correctamente", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (puntero == 0) {
        if (!PaqueteBusinessDelegate.getUsuarioService().modificarcontrasenia(objUsuario.getInt_idUsuario(), nuevoPass)) {
            Mensaje.mensaje(this, "No se Pudo Modificar la Contraseña", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        } else {
            Mensaje.mensaje(this, "Se Modificó con Exito la Contraseña", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        }


        try {
            //Carga el panel principal
            frmPrincipal = new Principal(objUsuario.getInt_idUsuario(),this.objEmpresa,this.objLocal);
            frmPrincipal.setLocationRelativeTo(null);
            frmPrincipal.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
            //                    this.setVisible(false);
            this.dispose();
            frmPrincipal.setIconImage(new ImageIcon(getClass().getResource("/com/gestionmatriz/icon/principal.png")).getImage());
            frmPrincipal.setVisible(true);

            Connection cnn = ConexionSql.getConexion();

            frmPrincipal.setBarra(objUsuario.getStr_usuario(),
                    cnn.getMetaData().getDatabaseProductName()
                    + " " + cnn.getMetaData().getDatabaseProductVersion()
                    + "(" + cnn.getCatalog() + ")");

            if (!PaqueteBusinessDelegate.getUsuarioService().insertLogeo(objUsuario.getStr_usuario())) {
                Mensaje.mensaje(this,
                        "Ocurrió un Problema al Registrar su Ingreso, El Sistema se Cerrara",
                        Mensaje.TITULO_ME, Mensaje.ERROR);
                System.exit(0);
            }

        } catch (SQLException ex) {
            log.error("Error al Intentar Ingresar al Sistema: " + ex.getMessage());
        }
    } else {


        if (!PaqueteBusinessDelegate.getUsuarioService().modificarcontrasenia(objUsuario.getInt_idUsuario(), nuevoPass)) {
            Mensaje.mensaje(this, "No se Pudo Modificar la Contraseña",
                    Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        } else {
            Mensaje.mensaje(this, "Se Modificó con Exito la Contraseña",
                    Mensaje.TITULO_ME, Mensaje.INFORMACION);
            this.dispose();
        }

    }

}//GEN-LAST:event_btnAceptarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAceptar;
    private org.jdesktop.swingx.JXButton btnCancelar;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXTitledPanel pnlTitulo;
    private javax.swing.JPasswordField txtConfirmarPassword;
    private javax.swing.JPasswordField txtNuevoPassword;
    private javax.swing.JPasswordField txtPasswordActual;
    private org.jdesktop.swingx.JXTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public Empresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(Empresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public Local getObjLocal() {
        return objLocal;
    }

    public void setObjLocal(Local objLocal) {
        this.objLocal = objLocal;
    }
    
    
    
}
