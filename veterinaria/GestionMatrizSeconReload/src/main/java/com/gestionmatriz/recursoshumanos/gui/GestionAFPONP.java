/*
 * GestionAFPONP.java
 *
 * Created on 20-nov-2012, 9:32:45
 */
package com.gestionmatriz.recursoshumanos.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



import org.apache.log4j.Logger;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.Pension;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

/**
 *
 * @author cesareots
 */
public class GestionAFPONP extends javax.swing.JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(GestionAFPONP.class);
	private Principal gui;
    private Pension objPension = null;
    private List<Pension> listaPension = new ArrayList<>();
    private String nombre = "";
    private int idPension = 0;

    public GestionAFPONP(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboPensiones = new javax.swing.JComboBox();
        txtPensiones = new javax.swing.JTextField();
        txtSeguro = new javax.swing.JTextField();
        txtComision = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN AFP-ONP");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Sistema pensión:");

        jLabel2.setText("Pensiones:");

        jLabel3.setText("Seguro:");

        jLabel4.setText("Comisión:");

        jLabel5.setText("% total:");

        cboPensiones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPensiones.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPensionesItemStateChanged(evt);
            }
        });

        txtPensiones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPensionesKeyReleased(evt);
            }
        });

        txtSeguro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSeguroKeyReleased(evt);
            }
        });

        txtComision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComisionKeyReleased(evt);
            }
        });

        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalKeyReleased(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel6.setText("[Sólo llenar para ONP]");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel7.setText("[ENTER]");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel8.setText("[ENTER]");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel9.setText("[ENTER]");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtComision, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboPensiones, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPensiones, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboPensiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPensiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
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
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Object objConfirmacion = null;

        if (btnEditar.getText().equals("Editar")) {
            if (nombre.substring(0, 3).equals(Util.AFP)) {
                if (!calcularPension()) {
                    Mensaje.mensaje(this, "Calcular pensión - Presionar ENTER", Mensaje.TITULO_ME, Mensaje.ERROR);
                    return;
                }

                if (!calcularSeguro()) {
                    Mensaje.mensaje(this, "Calcular seguro - Presionar ENTER", Mensaje.TITULO_ME, Mensaje.ERROR);
                    return;
                }

                if (!calcularComision()) {
                    Mensaje.mensaje(this, "Calcular comisión - Presionar ENTER", Mensaje.TITULO_ME, Mensaje.ERROR);
                    return;
                }
            } else if (nombre.substring(0, 3).equals(Util.ONP)) {
                if (!calcularTotal()) {
                    Mensaje.mensaje(this, "Calcular total - Presionar ENTER", Mensaje.TITULO_ME, Mensaje.ERROR);
                    return;
                }
            }

            objConfirmacion = Mensaje.confirmar(this, "¿Desea modificar Sistema Pensión?",
                    "Mensaje Confirmación", Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);

            if (objConfirmacion.equals(Mensaje.YES_OPTION)) {
                objPension = new Pension();
                objPension.setInt_idPension(idPension);
                objPension.setStr_nombre(cboPensiones.getSelectedItem().toString().toUpperCase().trim());

                if (nombre.substring(0, 3).equals(Util.AFP)) {
                    objPension.setDbl_pension(new BigDecimal(txtPensiones.getText().trim()));
                    objPension.setDbl_seguro(new BigDecimal(txtSeguro.getText().trim()));
                    objPension.setDbl_comision(new BigDecimal(txtComision.getText().trim()));

                } else if (nombre.substring(0, 3).equals(Util.ONP)) {
                    objPension.setDbl_pension(BigDecimal.ZERO);
                    objPension.setDbl_seguro(BigDecimal.ZERO);
                    objPension.setDbl_comision(BigDecimal.ZERO);
                }

                objPension.setDbl_total(new BigDecimal(txtTotal.getText().trim()));
                objPension.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());

                if (PaqueteBusinessDelegate.getPensionService().modificarPension(objPension)) {
                    Mensaje.mensaje(this, "Se modificó Sistema Pensión", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                    limpiar();
                } else {
                    Mensaje.mensaje(this, "Error al modificar Pensión", Mensaje.TITULO_ME, Mensaje.ERROR);
                }
            }
        } else if (btnEditar.getText().equals("Guardar")) {
            if (nombre.substring(0, 3).equals(Util.AFP)) {
                if (!calcularPension()) {
                    Mensaje.mensaje(this, "Calcular pensión - Presionar ENTER", Mensaje.TITULO_ME, Mensaje.ERROR);
                    return;
                }

                if (!calcularSeguro()) {
                    Mensaje.mensaje(this, "Calcular seguro - Presionar ENTER", Mensaje.TITULO_ME, Mensaje.ERROR);
                    return;
                }

                if (!calcularComision()) {
                    Mensaje.mensaje(this, "Calcular comisión - Presionar ENTER", Mensaje.TITULO_ME, Mensaje.ERROR);
                    return;
                }
            } else if (nombre.substring(0, 3).equals(Util.ONP)) {
                if (!calcularTotal()) {
                    Mensaje.mensaje(this, "Calcular total - Presionar ENTER", Mensaje.TITULO_ME, Mensaje.ERROR);
                    return;
                }
            }

            objConfirmacion = Mensaje.confirmar(this, "¿Desea registrar Sistema Pensión?",
                    "Mensaje Confirmación", Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);

            if (objConfirmacion.equals(Mensaje.YES_OPTION)) {
                objPension = new Pension();
                objPension.setStr_nombre(cboPensiones.getSelectedItem().toString());

                if (nombre.substring(0, 3).equals(Util.AFP)) {
                    objPension.setDbl_pension(new BigDecimal(txtPensiones.getText().trim()));
                    objPension.setDbl_seguro(new BigDecimal(txtSeguro.getText().trim()));
                    objPension.setDbl_comision(new BigDecimal(txtComision.getText().trim()));

                } else if (nombre.substring(0, 3).equals(Util.ONP)) {
                    objPension.setDbl_pension(BigDecimal.ZERO);
                    objPension.setDbl_seguro(BigDecimal.ZERO);
                    objPension.setDbl_comision(BigDecimal.ZERO);
                }

                objPension.setDbl_total(new BigDecimal(txtTotal.getText().trim()));
                objPension.setStr_estado(Util.ACTIVO);
                objPension.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());

                if (PaqueteBusinessDelegate.getPensionService().registrarPension(objPension)) {
                    Mensaje.mensaje(this, "Se registró el nuevo Sistema Pensión", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                    limpiar();
                } else {
                    Mensaje.mensaje(this, "Error al registrar Pensión", Mensaje.TITULO_ME, Mensaje.ERROR);
                }
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try {
            btnNuevo.setEnabled(false);
            btnEditar.setText("Guardar");
            Pensiones frmPensiones = new Pensiones(gui, this);
            frmPensiones.setVisible(true);
        } catch (Exception e) {
            log.error("ERROR: "+e.getMessage());
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtPensionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPensionesKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)) {
            calcularPension();
        }
    }//GEN-LAST:event_txtPensionesKeyReleased

    private void txtSeguroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSeguroKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)) {
            calcularSeguro();
        }
    }//GEN-LAST:event_txtSeguroKeyReleased

    private void txtComisionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComisionKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)) {
            calcularComision();
        }
    }//GEN-LAST:event_txtComisionKeyReleased

    private void txtTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)) {
            calcularTotal();
        }
    }//GEN-LAST:event_txtTotalKeyReleased

    private void cboPensionesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPensionesItemStateChanged
        if (cboPensiones.getSelectedIndex() > 0) {
            nombre = String.valueOf(listaPension.get(cboPensiones.getSelectedIndex() - 1).getStr_nombre());
            txtPensiones.setText(String.valueOf(listaPension.get(cboPensiones.getSelectedIndex() - 1).getDbl_pension()));
            txtSeguro.setText(String.valueOf(listaPension.get(cboPensiones.getSelectedIndex() - 1).getDbl_seguro()));
            txtComision.setText(String.valueOf(listaPension.get(cboPensiones.getSelectedIndex() - 1).getDbl_comision()));
            txtTotal.setText(String.valueOf(listaPension.get(cboPensiones.getSelectedIndex() - 1).getDbl_total()));
            btnEditar.setEnabled(true);
            cboPensiones.setEditable(true);
            idPension = listaPension.get(cboPensiones.getSelectedIndex() - 1).getInt_idPension();
            txtEdit(nombre);
        }
    }//GEN-LAST:event_cboPensionesItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cboPensiones;
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
    private javax.swing.JTextField txtComision;
    private javax.swing.JTextField txtPensiones;
    private javax.swing.JTextField txtSeguro;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        super.dispose();
        gui.getBarraEstado().cerraVentana();
    }

    private void cargarDatos() {
        cargarSistemaPensiones();
        txtPensiones.setEditable(false);
        txtSeguro.setEditable(false);
        txtComision.setEditable(false);
        txtTotal.setEditable(false);
        btnEditar.setEnabled(false);
    }

    private void cargarSistemaPensiones() {
        listaPension = PaqueteBusinessDelegate.getPensionService().listaPension();
        cboPensiones.removeAllItems();
        cboPensiones.addItem(".::Seleccionar Sistema Pensión::.");

        for (Pension objP : listaPension) {
            cboPensiones.addItem(objP.getStr_nombre());
        }
    }

    protected void cargarNombre(String nombre) {
        this.nombre = nombre;
        cboPensiones.removeAllItems();
        cboPensiones.addItem(nombre);
        btnEditar.setEnabled(true);
        txtEdit(nombre);
    }

    private void txtEdit(String nombre) {
        if (nombre.substring(0, 3).equals(Util.AFP)) {
            txtPensiones.setEditable(true);
            txtSeguro.setEditable(true);
            txtComision.setEditable(true);
            txtTotal.setEditable(false);
            txtPensiones.selectAll();
            txtPensiones.requestFocus();
        } else if (nombre.substring(0, 3).equals(Util.ONP)) {
            txtPensiones.setEditable(false);
            txtSeguro.setEditable(false);
            txtComision.setEditable(false);
            txtTotal.setEditable(true);
            txtTotal.selectAll();
            txtTotal.requestFocus();
        }
    }

    protected void volver() {
        btnNuevo.setEnabled(true);
        btnEditar.setText("Editar");
    }

    private boolean calcularPension() {
        boolean respuesta = false;

        try {
            BigDecimal pension = new BigDecimal(txtPensiones.getText().trim());
            txtSeguro.selectAll();
            txtSeguro.requestFocus();
            respuesta = true;
        } catch (NumberFormatException nfe) {
            log.error("Error nfe: ".concat(nfe.getMessage()));
            Mensaje.mensaje(this, "Ingresar sólo números", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtPensiones.selectAll();
            txtPensiones.requestFocus();
            respuesta = false;
        } catch (Exception e) {
            log.error("Error e: ".concat(e.getMessage()));
            respuesta = false;
        }

        return respuesta;
    }

    private boolean calcularSeguro() {
        boolean respuesta = false;

        try {
            BigDecimal seguro = new BigDecimal(txtSeguro.getText().trim());
            txtComision.selectAll();
            txtComision.requestFocus();
            respuesta = true;
        } catch (NumberFormatException nfe) {
            log.error("Error nfe: " + nfe.getMessage());
            Mensaje.mensaje(this, "Ingresar sólo números", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtSeguro.selectAll();
            txtSeguro.requestFocus();
            respuesta = false;
        } catch (Exception e) {
            log.error("Error e: " + e.getMessage());
            respuesta = false;
        }

        return respuesta;
    }

    private boolean calcularComision() {
        boolean respuesta = false;

        try {
            BigDecimal comision = new BigDecimal(txtComision.getText().trim());
            respuesta = true;

            if (!calcularTotal()) {
                respuesta = false;
            }
        } catch (NumberFormatException nfe) {
            log.error("Error nfe: ".concat(nfe.getMessage()));
            Mensaje.mensaje(this, "Ingresar sólo números", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtComision.selectAll();
            txtComision.requestFocus();
            respuesta = false;
        } catch (Exception e) {
            log.error("Error e: ".concat(e.getMessage()));
            respuesta = false;
        }

        return respuesta;
    }

    private boolean calcularTotal() {
        boolean respuesta = false;
        BigDecimal total = BigDecimal.ZERO;

        try {
            if (nombre.substring(0, 3).equals(Util.AFP)) {
                BigDecimal pension = new BigDecimal(txtPensiones.getText().trim());
                BigDecimal seguro = new BigDecimal(txtSeguro.getText().trim());
                BigDecimal comision = new  BigDecimal(txtComision.getText().trim());
                total = pension.add(seguro).add(comision) ;
            } else if (nombre.substring(0, 3).equals(Util.ONP)) {
                total = new BigDecimal(txtTotal.getText().trim());
            }

            txtTotal.setText(String.valueOf(total));
            btnEditar.requestFocus();
            respuesta = true;
        } catch (NumberFormatException nfe) {
            log.error("Error nfe: " + nfe.getMessage());
            Mensaje.mensaje(this, "Ingresar sólo números", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtTotal.selectAll();
            txtTotal.requestFocus();
            respuesta = false;
        } catch (Exception e) {
            log.error("Error e: " + e.getMessage());
            respuesta = false;
        }

        return respuesta;
    }

    private void limpiar() {
        txtPensiones.setText("");
        txtSeguro.setText("");
        txtComision.setText("");
        txtTotal.setText("");
        txtPensiones.setEditable(false);
        txtSeguro.setEditable(false);
        txtComision.setEditable(false);
        txtTotal.setEditable(false);
        btnEditar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnEditar.setText("Editar");
        cboPensiones.setEditable(false);
        this.objPension = null;
        this.nombre = "";
        cargarSistemaPensiones();
    }
}
