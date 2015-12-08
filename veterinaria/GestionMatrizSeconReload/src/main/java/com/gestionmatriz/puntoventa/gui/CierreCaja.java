/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.Caja;
import com.gestionmatriz.puntoventa.bean.FlujoCaja;
import com.gestionmatriz.puntoventa.bean.TipoCambio;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import com.gestionmatriz.util.ValidarCamposNulos;

/**
 *
 * @author cesareo
 */
public class CierreCaja extends javax.swing.JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(CierreCaja.class);  
    private Principal gui;
    private List<Caja> listaCaja = new ArrayList<>();
    private FlujoCaja objFlujoCaja = null;
    private int diferenciaD = 0;

    public CierreCaja(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

   
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidadSistema = new javax.swing.JTextField();
        txtCantidadCajaSoles = new javax.swing.JTextField();
        txtDiferencia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCantidadCajaDolares = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantidadCajaTotal = new javax.swing.JTextField();
        txtCaja = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("CIERRE CAJA");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Caja:");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setText("Cantidad Sistema (S/.):");

        jLabel3.setText("Cantidad Caja (S/.):");

        jLabel4.setText("Diferencia (S/.):");

        txtCantidadSistema.setEditable(false);

        txtCantidadCajaSoles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadCajaSolesKeyPressed(evt);
            }
        });

        txtDiferencia.setEditable(false);
        txtDiferencia.setFont(new java.awt.Font("Tahoma", 1, 11));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel6.setText("[ENTER para precalcular]");

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel7.setText("Cantidad Caja ($):");

        txtCantidadCajaDolares.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadCajaDolaresKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel8.setText("[ENTER para precalcular]");

        jLabel5.setText("Cantidad Total Caja (S/.):");

        txtCantidadCajaTotal.setEditable(false);

        txtCaja.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel9.setText("d");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCantidadCajaSoles, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidadCajaDolares, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidadCajaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidadSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCantidadSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidadCajaSoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCantidadCajaDolares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidadCajaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCERRAR_CAJA())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        JTextField[] txts = {txtCantidadCajaSoles, txtCantidadCajaDolares};
        if (!ValidarCamposNulos.validar(txts)) {
            Mensaje.mensaje(this, "Los campos resaltados son importantes", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtCantidadCajaSoles.requestFocus();
            return;
        }

        if (!txtCantSoles()) {
            return;
        }

        if (!txtCantDolares()) {
            return;
        }
        
        if (diferenciaD == 0) {
            objFlujoCaja = new FlujoCaja();
            objFlujoCaja.setObjLocal(gui.getLocal());
            objFlujoCaja.setObjCaja(listaCaja.get(0));
            objFlujoCaja.setDbl_cantidadSoles(new BigDecimal(txtCantidadCajaSoles.getText()));
            objFlujoCaja.setDbl_cantidadDolares(new BigDecimal(txtCantidadCajaDolares.getText()));
            objFlujoCaja.setDbl_cantidadTotalSoles(new BigDecimal(txtCantidadCajaTotal.getText()));
            objFlujoCaja.setDbl_cantidadDiferencia(new BigDecimal(txtDiferencia.getText()));
            objFlujoCaja.setStr_motivo(Util.CIERRECAJA);
            objFlujoCaja.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());

            if (PaqueteBusinessDelegate.getFlujoCajaService().cerrarCaja(objFlujoCaja)) {
                Mensaje.mensaje(this, "Cierre de Caja correcto", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                limpiarDatos();
            } else {
                Mensaje.mensaje(this, "Error al cerrar Caja", Mensaje.TITULO_ME, Mensaje.ERROR);
            }
        } else if (diferenciaD != 0) {
            Object objConfirmacion = Mensaje.confirmar(this, "Caja no cuadra, ¿Desea continuar?", "Mensaje Confirmación", Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);
            if (objConfirmacion.equals(Mensaje.YES_OPTION)) {
                objFlujoCaja = new FlujoCaja();
                objFlujoCaja.setObjLocal(gui.getLocal());
                objFlujoCaja.setObjCaja(listaCaja.get(0));
                objFlujoCaja.setDbl_cantidadSoles(new BigDecimal(txtCantidadCajaSoles.getText()));
                objFlujoCaja.setDbl_cantidadDolares(new BigDecimal(txtCantidadCajaDolares.getText()));
                objFlujoCaja.setDbl_cantidadTotalSoles(new BigDecimal(txtCantidadCajaTotal.getText()));
                objFlujoCaja.setDbl_cantidadDiferencia(new BigDecimal(txtDiferencia.getText()));
                objFlujoCaja.setStr_motivo(Util.CIERRECAJA);
                objFlujoCaja.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());

                if (PaqueteBusinessDelegate.getFlujoCajaService().cerrarCaja(objFlujoCaja)) {
                    Mensaje.mensaje(this, "Cierre de Caja correcto", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                    limpiarDatos();
                } else {
                    Mensaje.mensaje(this, "Error al cerrar Caja", Mensaje.TITULO_ME, Mensaje.ERROR);
                }
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtCantidadCajaSolesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadCajaSolesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtCantSoles()) {
                return;
            }
        }
    }//GEN-LAST:event_txtCantidadCajaSolesKeyPressed

    private void txtCantidadCajaDolaresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadCajaDolaresKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtCantDolares()) {
                return;
            }

            calcularPrecioTotal();
            calcularDiferencia();
        }
    }//GEN-LAST:event_txtCantidadCajaDolaresKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCaja;
    private javax.swing.JTextField txtCantidadCajaDolares;
    private javax.swing.JTextField txtCantidadCajaSoles;
    private javax.swing.JTextField txtCantidadCajaTotal;
    private javax.swing.JTextField txtCantidadSistema;
    private javax.swing.JTextField txtDiferencia;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
        objFlujoCaja = new FlujoCaja();
    }

    private void cargarDatos() {
        cargarCaja();
        txtCantidadCajaSoles.setText("0");
        txtCantidadCajaDolares.setText("0");
        txtCantidadCajaSoles.selectAll();
        txtCantidadCajaSoles.requestFocus();
        jLabel9.setText("");
    }

    private void cargarCaja() {
        listaCaja = PaqueteBusinessDelegate.getFlujoCajaService().getCaja(gui.getLocal().getInt_idLocal(), gui.getBarraEstado().getUsuario());

        if (listaCaja.isEmpty()) {
            Mensaje.mensaje(this, "Debe Aperturar Caja", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            txtCantidadCajaSoles.setEditable(false);
            txtCantidadCajaDolares.setEditable(false);
            btnRegistrar.setEnabled(false);
            return;
        }

        FlujoCaja objFC = new FlujoCaja();
        objFC.setObjLocal(gui.getLocal());
        objFC.setObjCaja(listaCaja.get(0));

        txtCaja.setText(listaCaja.get(0).getStr_nombre());
        txtCantidadSistema.setText(Util.redondeo(PaqueteBusinessDelegate.getFlujoCajaService().cantidadXLocalYCaja(objFC), 2));
    }

    private boolean txtCantSoles() {
        boolean respuesta = false;

        try {
            BigDecimal cantidadCajaSoles = new BigDecimal(txtCantidadCajaSoles.getText());

            if (cantidadCajaSoles.compareTo(BigDecimal.ZERO) ==-1) {
                txtCantidadCajaSoles.selectAll();
                txtCantidadCajaSoles.requestFocus();
                Mensaje.mensaje(this, "Ingresar números positivos", Mensaje.TITULO_ME, Mensaje.ERROR);
            } else {
                txtCantidadCajaDolares.selectAll();
                txtCantidadCajaDolares.requestFocus();
                respuesta = true;
            }
        } catch (NumberFormatException nfe) {
            log.error("Error nfe: " + nfe.getMessage());
            Mensaje.mensaje(this, "Ingresar sólo números", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtCantidadCajaSoles.selectAll();
            txtCantidadCajaSoles.requestFocus();
            respuesta = false;
        } catch (Exception e) {
            log.error("Error e: " + e.getMessage());
            respuesta = false;
        }

        return respuesta;
    }

    private boolean txtCantDolares() {
        boolean respuesta = false;

        try {
            BigDecimal cantidadCajaDolares = new BigDecimal(txtCantidadCajaDolares.getText());

            if (cantidadCajaDolares.compareTo(BigDecimal.ZERO) ==-1) {
                txtCantidadCajaDolares.selectAll();
                txtCantidadCajaDolares.requestFocus();
                Mensaje.mensaje(this, "Ingresar números positivos", Mensaje.TITULO_ME, Mensaje.ERROR);
            } else {
                respuesta = true;
            }
        } catch (NumberFormatException nfe) {
            log.error("Error nfe: " + nfe.getMessage());
            Mensaje.mensaje(this, "Ingresar sólo números", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtCantidadCajaDolares.selectAll();
            txtCantidadCajaDolares.requestFocus();
            respuesta = false;
        } catch (Exception e) {
            log.error("Error e: " + e.getMessage());
            respuesta = false;
        }

        return respuesta;
    }

    private void calcularPrecioTotal() {
        String fechaDia = PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql().substring(0, 10);
        TipoCambio objTC = PaqueteBusinessDelegate.getTipoCambioService().obtenerTipoCambio(fechaDia);
        BigDecimal cantSoles = new BigDecimal(txtCantidadCajaSoles.getText());
        BigDecimal cantDolares = new BigDecimal(txtCantidadCajaDolares.getText());
        BigDecimal cantTotal = BigDecimal.ZERO;

        if (objTC != null) {
            cantTotal = (cantDolares.multiply(objTC.getDbl_precioCompraDolar())).add(cantSoles) ;
            txtCantidadCajaTotal.setText(Util.redondeo(cantTotal, 2));
        } else {
            Mensaje.mensaje(this, "Falta registrar Tipo de Cambio del Día", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtCantidadCajaDolares.setText("0");
            txtCantidadCajaDolares.selectAll();
            txtCantidadCajaDolares.requestFocus();
        }
    }

    private void calcularDiferencia() {
        BigDecimal diferencia = new BigDecimal(txtCantidadCajaTotal.getText()).subtract(new BigDecimal(txtCantidadSistema.getText())) ;

        if (diferencia .compareTo(BigDecimal.ZERO) ==-1) {
            txtDiferencia.setForeground(Color.red);
            jLabel9.setText("FALTA DINERO");
            jLabel9.setForeground(Color.red);
            diferenciaD = -1;
        } else if (diferencia.compareTo(BigDecimal.ZERO) == 0) {
            txtDiferencia.setForeground(Color.blue);
            jLabel9.setText("");
            diferenciaD = 0;
        } else {
            txtDiferencia.setForeground(Color.blue);
            jLabel9.setText("EXCESO DE DINERO");
            jLabel9.setForeground(Color.blue);
            diferenciaD = 1;
        }

        txtDiferencia.setText(Util.redondeo(diferencia, 2));
        btnRegistrar.requestFocus();
    }

    private void limpiarDatos() {
        objFlujoCaja = null;
        txtCaja.setText("");
        txtCantidadSistema.setText("");
        txtCantidadCajaSoles.setText("");
        txtCantidadCajaDolares.setText("");
        txtCantidadCajaTotal.setText("");
        txtDiferencia.setText("");
        txtCantidadCajaSoles.requestFocus();
    }
}
