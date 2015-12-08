/*
 * Logeo.java
 *
 * Created on 08-jun-2012, 14:15:20
 */
package com.gestionmatriz.seguridad.gui;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.seguridad.bean.Usuario;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.util.ComboUtil;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import org.apache.log4j.Logger;

/**
 *
 * @author cesareo
 */
public class Logeo extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal frmPrincipal;
    private ModificarContrasenia frmModificarContrasenia;
    public Empresa objEmpresaI;
    private List<Empresa> listaEmpresa;
    private List<Local> listaLocal;
    private Empresa objEmpresa;
    private static final Logger log=Logger.getLogger(Logeo.class);

    public Logeo() {
        log.info("Logeo()[");
        initComponents();
        cargarComboEmpresa();
        log.info("Logeo()]");
    }

    private void initComponents() {

        defaultUserNameStore1 = new org.jdesktop.swingx.auth.DefaultUserNameStore();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        lblUsuario = new org.jdesktop.swingx.JXLabel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        txtUsuarioLogeo = new org.jdesktop.swingx.JXTextField();
        cboEmpresa = new org.jdesktop.swingx.JXComboBox();
        cboLocal = new org.jdesktop.swingx.JXComboBox();
        txtContraseniaLogeo = new javax.swing.JPasswordField();
        btnIngresarLogeo = new org.jdesktop.swingx.JXButton();
        btnCancelar = new org.jdesktop.swingx.JXButton();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jXPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXPanel1.setLayout(null);

        lblUsuario.setText("Usuario");
        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jXPanel1.add(lblUsuario);
        lblUsuario.setBounds(10, 10, 110, 15);

        jXLabel1.setText("Contraseña");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jXPanel1.add(jXLabel1);
        jXLabel1.setBounds(10, 40, 120, 15);

        jXLabel2.setText("Empresa");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jXPanel1.add(jXLabel2);
        jXLabel2.setBounds(10, 70, 110, 15);

        jXLabel3.setText("Local");
        jXLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jXPanel1.add(jXLabel3);
        jXLabel3.setBounds(10, 100, 110, 15);

        txtUsuarioLogeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioLogeoActionPerformed(evt);
            }
        });
        jXPanel1.add(txtUsuarioLogeo);
        txtUsuarioLogeo.setBounds(140, 10, 190, 24);

        cboEmpresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboEmpresaItemStateChanged(evt);
            }
        });
        cboEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboEmpresaKeyPressed(evt);
            }
        });
        jXPanel1.add(cboEmpresa);
        cboEmpresa.setBounds(140, 70, 190, 20);

        cboLocal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboLocalKeyPressed(evt);
            }
        });
        jXPanel1.add(cboLocal);
        cboLocal.setBounds(140, 100, 190, 20);

        txtContraseniaLogeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseniaLogeoActionPerformed(evt);
            }
        });
        jXPanel1.add(txtContraseniaLogeo);
        txtContraseniaLogeo.setBounds(140, 40, 190, 24);

        btnIngresarLogeo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/aceptar.png"))); // NOI18N
        btnIngresarLogeo.setText("Ingresar");
        btnIngresarLogeo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIngresarLogeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarLogeoActionPerformed(evt);
            }
        });
        jXPanel1.add(btnIngresarLogeo);
        btnIngresarLogeo.setBounds(180, 130, 130, 30);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/eliminar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jXPanel1.add(btnCancelar);
        btnCancelar.setBounds(50, 130, 130, 30);

        getContentPane().add(jXPanel1, java.awt.BorderLayout.CENTER);
        getContentPane().add(jXTitledPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>                        

private void txtUsuarioLogeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioLogeoActionPerformed
    if (txtUsuarioLogeo.getText().length() != 0) {
        txtContraseniaLogeo.requestFocus();
    }
}//GEN-LAST:event_txtUsuarioLogeoActionPerformed

private void txtContraseniaLogeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseniaLogeoActionPerformed
    if (new String(txtContraseniaLogeo.getPassword()).length() != 0) {
        cboEmpresa.requestFocus();
    }
}//GEN-LAST:event_txtContraseniaLogeoActionPerformed

private void btnIngresarLogeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarLogeoActionPerformed
    if (txtUsuarioLogeo.getText().length() == 0) {
        Mensaje.mensaje(this, "Debe ingresar un usuario", "Mensaje de Ayuda", Mensaje.INFORMACION);
        txtUsuarioLogeo.requestFocus();
    } else if (new String(txtContraseniaLogeo.getPassword()).length() == 0) {
        Mensaje.mensaje(this, "Debe ingresar una Contraseña", "Mensaje de Ayuda", Mensaje.INFORMACION);
        txtContraseniaLogeo.requestFocus();
    } else if (cboEmpresa.getSelectedIndex() <= 0) {
        Mensaje.mensaje(this, "Debe seleccionar Empresa", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        cboEmpresa.requestFocus();
    } else if (cboLocal.getSelectedIndex() <= 0) {
        Mensaje.mensaje(this, "Debe seleccionar Local", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        cboLocal.requestFocus();
    } else {
        ingresar();
    }
}//GEN-LAST:event_btnIngresarLogeoActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    Object objConfirmacion = Mensaje.confirmar(this, "Desea Salir del Sistema", "Mensaje Confirmación",
            Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);

    if (objConfirmacion.equals(Mensaje.YES_OPTION)) {
        try {
            ConexionSql.cerrarConexionAll(ConexionSql.getConexion());
            System.exit(0);
        } catch (SQLException ex) {
            log.error(ex);
            System.exit(0);
        }
    }
}//GEN-LAST:event_btnCancelarActionPerformed

private void cboEmpresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboEmpresaItemStateChanged
    if (cboEmpresa.getSelectedIndex() > 0) {
        objEmpresa = listaEmpresa.get(cboEmpresa.getSelectedIndex() - 1);
        objEmpresaI = objEmpresa;
        cargarComboLocal(objEmpresa.getInt_idEmpresa());
    }
}//GEN-LAST:event_cboEmpresaItemStateChanged

private void cboEmpresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboEmpresaKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        cboLocal.requestFocus();
    }
}//GEN-LAST:event_cboEmpresaKeyPressed

private void cboLocalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboLocalKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        ingresar();
    }
}//GEN-LAST:event_cboLocalKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnCancelar;
    private org.jdesktop.swingx.JXButton btnIngresarLogeo;
    private org.jdesktop.swingx.JXComboBox cboEmpresa;
    private org.jdesktop.swingx.JXComboBox cboLocal;
    private org.jdesktop.swingx.auth.DefaultUserNameStore defaultUserNameStore1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private org.jdesktop.swingx.JXLabel lblUsuario;
    private javax.swing.JPasswordField txtContraseniaLogeo;
    private org.jdesktop.swingx.JXTextField txtUsuarioLogeo;
    // End of variables declaration//GEN-END:variables

    private void ingresar() {
        try {
            Usuario objUsuario = PaqueteBusinessDelegate.getUsuarioService().
                    validarUsuario(getUsuario(), getPassword());

            if (objUsuario != null) {
                int puntero = PaqueteBusinessDelegate.getUsuarioService().
                        logeoInicial(objUsuario.getStr_usuario());
                
                if (puntero != -1) {
                    //Carga el panel principal
                    frmPrincipal = new Principal(objUsuario.getInt_idUsuario(),
                            listaEmpresa.get(cboEmpresa.getSelectedIndex() - 1),
                            listaLocal.get(cboLocal.getSelectedIndex() - 1));
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
                    frmPrincipal.setCodigoPersona(Util.stringTOint(objUsuario.getStr_codigoPersona().trim().substring(1)));
                    frmPrincipal.setTitle("Sistema Matriz ".concat(("Usuario: [" + frmPrincipal.getBarraEstado().getUsuario().concat("]-")).concat(" Local: [").concat(frmPrincipal.getLocal().getStr_direccion().concat("]"))));
                    if (!PaqueteBusinessDelegate.getUsuarioService().insertLogeo(objUsuario.getStr_usuario())) {
                        Mensaje.mensaje(this, "Ocurrió un Problema al Registrar su Ingreso, El Sistema se Cerrara", Mensaje.TITULO_ME, Mensaje.ERROR);
                        System.exit(0);
                    }
                    //Oculta el logueo
                } else {
                    frmModificarContrasenia = new ModificarContrasenia(this, objUsuario, 0,
                    listaEmpresa.get(cboEmpresa.getSelectedIndex() - 1),
                            listaLocal.get(cboLocal.getSelectedIndex() - 1));
                    frmModificarContrasenia.setLocationRelativeTo(null);
                    frmModificarContrasenia.setSize(383, 211);
//                    frmModificarContrasenia.setExtendedState(frmModificarContrasenia.MAXIMIZED_BOTH);
//                    this.setVisible(false);
                    this.dispose();
                    frmModificarContrasenia.setIconImage(new ImageIcon(getClass().getResource("/com/gestionmatriz/icon/principal.png")).getImage());
                    frmModificarContrasenia.setVisible(true);
                    
                }
            } else {
                Mensaje.mensaje(this, "Usuario o Contraseña Incorrecta", Mensaje.TITULO_ME, Mensaje.ERROR);
            }
        } catch (SQLException ex) {
            log.error(ex);
        }
        catch(Exception e){
            e.printStackTrace();
            log.error(e);
        }
    }

    //Metodo de lecctura de datos ingresados...
    public String getUsuario() {
        return txtUsuarioLogeo.getText().trim();
    }

    public String getPassword() {
        return new String(txtContraseniaLogeo.getPassword()).trim();
    }

    private void cargarComboEmpresa() {
        cboEmpresa.removeAllItems();
        cboEmpresa.addItem(".::Seleccionar Empresa::.");
        listaEmpresa = new ArrayList<>();

        try {
            listaEmpresa = PaqueteBusinessDelegate.getContratoService().listarEmpresa();
            for (Empresa empresa : listaEmpresa) {
                cboEmpresa.addItem(empresa.getStr_razonSocial());
            }
        } catch (SQLException ex) {
            log.error(ex);
        }
    }

    private void cargarComboLocal(int int_idEmpresa) {
        /*cboLocal.removeAllItems();
        cboLocal.addItem(".::Seleccionar Local::.");
        listaLocal = PaqueteBusinessDelegate.getContratoService().buscarLocal(int_idEmpresa);
        if (listaLocal!=null && !listaLocal.isEmpty()){
            for (Local local : listaLocal) {
                cboLocal.addItem(local.getStr_direccion());
            }
        }*/
        listaLocal = PaqueteBusinessDelegate.getContratoService().buscarLocal(int_idEmpresa);
        cboLocal = ComboUtil.getListaLocales(cboLocal, listaLocal);
    }
}
