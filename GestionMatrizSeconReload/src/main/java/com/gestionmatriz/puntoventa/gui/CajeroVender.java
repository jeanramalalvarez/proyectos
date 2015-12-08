/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.Caja;
import com.gestionmatriz.puntoventa.bean.FlujoCaja;
import com.gestionmatriz.puntoventa.bean.ImprimirVenta;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.recursoshumanos.bean.Config;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Impresora;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import com.gestionmatriz.util.ValidarCamposNulos;
import java.math.BigInteger;

/**
 *
 * @author cesareo
 */
public class CajeroVender extends javax.swing.JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final Logger log=Logger.getLogger(CajeroVender.class);  
    private Principal gui;
    private Caja objCaja;
    private Ventas objVentas;
    private FlujoCaja objFlujoCaja = null;
    private Cajero frmCajero;

    public CajeroVender(Principal gui, Caja objCaja, Ventas objVentas, Cajero frmCajero) {
        super(gui, true);
        this.gui = gui;
        this.objCaja = objCaja;
        this.objVentas = objVentas;
        this.frmCajero = frmCajero;
        initComponents();
        rbtEfectivo.setSelected(true);
        cargarDatos();
        this.setTitle(gui.getTitle()+"-"+"Modulo de Cobro");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        txtDocumento = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        txtPaga = new javax.swing.JTextField();
        txtVuelto = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtRucDni = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNroDocumento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new org.jdesktop.swingx.JXTable();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        rbtEfectivo = new javax.swing.JRadioButton();
        rbtTarjeta = new javax.swing.JRadioButton();
        rbtCredito = new javax.swing.JRadioButton();
        rbtCheque = new javax.swing.JRadioButton();
        rbtOtros = new javax.swing.JRadioButton();
        txtTipoTarjeta = new org.jdesktop.swingx.JXTextField();
        txtTipoCredito = new org.jdesktop.swingx.JXTextField();
        txtTipoCheque = new org.jdesktop.swingx.JXTextField();
        txtTipoOtros = new org.jdesktop.swingx.JXTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Cliente:");

        jLabel2.setText("Documento:");

        jLabel3.setText("Monto:");

        jLabel4.setText("Paga:");

        jLabel5.setText("Vuelto:");

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        txtCliente.setEditable(false);

        txtDocumento.setEditable(false);

        txtMonto.setEditable(false);
        txtMonto.setBackground(new java.awt.Color(0, 0, 0));
        txtMonto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMonto.setForeground(new java.awt.Color(255, 102, 0));
        txtMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMonto.setOpaque(false);

        txtPaga.setBackground(new java.awt.Color(0, 0, 0));
        txtPaga.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPaga.setForeground(new java.awt.Color(255, 102, 0));
        txtPaga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPaga.setOpaque(false);
        txtPaga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPagaKeyPressed(evt);
            }
        });

        txtVuelto.setEditable(false);
        txtVuelto.setBackground(new java.awt.Color(0, 0, 0));
        txtVuelto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtVuelto.setForeground(new java.awt.Color(255, 102, 0));
        txtVuelto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtVuelto.setOpaque(false);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/eliminar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("RUC / DNI:");

        txtRucDni.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setText("[ENTER para precalcular]");

        jLabel8.setText("Nro documento:");

        txtNroDocumento.setEditable(false);

        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vendedor", "Producto", "Cantidad", "Precio", "SubTotal", "IGV", "Descuento", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalle.setColumnControlVisible(true);
        tblDetalle.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        tblDetalle.setRowHeight(30);
        jScrollPane1.setViewportView(tblDetalle);
        if (tblDetalle.getColumnModel().getColumnCount() > 0) {
            tblDetalle.getColumnModel().getColumn(1).setResizable(false);
            tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tipo de Pago"));

        buttonGroup1.add(rbtEfectivo);
        rbtEfectivo.setText("EFECTIVO");

        buttonGroup1.add(rbtTarjeta);
        rbtTarjeta.setText("TARJETA");
        rbtTarjeta.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtTarjetaStateChanged(evt);
            }
        });

        buttonGroup1.add(rbtCredito);
        rbtCredito.setText("CREDITO");
        rbtCredito.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtCreditoStateChanged(evt);
            }
        });

        buttonGroup1.add(rbtCheque);
        rbtCheque.setText("CHEQUE");
        rbtCheque.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtChequeStateChanged(evt);
            }
        });

        buttonGroup1.add(rbtOtros);
        rbtOtros.setText("OTROS");
        rbtOtros.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtOtrosStateChanged(evt);
            }
        });

        txtTipoTarjeta.setEditable(false);

        txtTipoCredito.setEditable(false);

        txtTipoCheque.setEditable(false);

        txtTipoOtros.setEditable(false);

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtEfectivo)
                            .addComponent(rbtTarjeta))
                        .addGap(53, 53, 53)
                        .addComponent(txtTipoTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(rbtOtros)
                        .addGap(67, 67, 67)
                        .addComponent(txtTipoOtros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtCredito)
                            .addComponent(rbtCheque))
                        .addGap(57, 57, 57)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTipoCheque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTipoCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtEfectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(rbtTarjeta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtCredito)
                            .addComponent(txtTipoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtCheque)
                            .addComponent(txtTipoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtTipoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtOtros)
                    .addComponent(txtTipoOtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(txtRucDni))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDocumento)
                                        .addGap(28, 28, 28))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                            .addComponent(txtNroDocumento, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtVuelto, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPaga, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtRucDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPagaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            calcularVuelto();
        }
    }//GEN-LAST:event_txtPagaKeyPressed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getVENDER_REALIZAR())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        JTextField[] txts = {txtPaga};
        if (!ValidarCamposNulos.validar(txts)) {
            Mensaje.mensaje(this, "Los campos resaltados son obligatorios", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtPaga.requestFocus();
            return;
        }

        if (!calcularVuelto()) {
            Mensaje.mensaje(this, "Calcular vuelto - Presionar ENTER", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtPaga.requestFocus();
            return;
        }

        String tipoVenta=(rbtEfectivo.isSelected() == true) ? "EFECTIVO"
            : (rbtCheque.isSelected() == true) ? "CHEQUE"
            : (rbtCredito.isSelected() == true) ? "CREDITO"
            : (rbtTarjeta.isSelected() == true) ? "TARJETA" : "OTROS";
        
        String comprobante=(rbtCheque.isSelected() == true) ? txtTipoCheque.getText()
            : (rbtCredito.isSelected() == true) ? txtTipoCredito.getText()
            : (rbtTarjeta.isSelected() == true) ? txtTipoTarjeta.getText() : txtTipoOtros.getText();
        
        objFlujoCaja = new FlujoCaja();

        objFlujoCaja.setObjLocal(objVentas.getObjLocal());
        objFlujoCaja.setObjCaja(objCaja);
        objFlujoCaja.setDbl_cantidadSoles(new BigDecimal(Util.redondeo(objVentas.getDbTotal(), 2)));
        objFlujoCaja.setDbl_cantidadTotalSoles(new BigDecimal(Util.redondeo(objVentas.getDbTotal(),2)));
        objFlujoCaja.setStr_motivo(Util.VENTACAJA);
        objFlujoCaja.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());
        String [] arrDocumentos = PaqueteBusinessDelegate.getFlujoCajaService().registrarFlujoCaja(objFlujoCaja,
                objVentas.getStr_numeroDocumento(), txtNroDocumento.getText().trim(),tipoVenta,comprobante);
        if (arrDocumentos!=null && arrDocumentos.length>0) {
            //Aqui se hará la impresión----
            if(txtNroDocumento.getText().trim().startsWith("B")){
                imprimirBoleta(arrDocumentos);
            }else {
                imprimirFactura(arrDocumentos);
            }
            
            
            Mensaje.mensaje(this, "Venta satisfactoria", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        } else {
            Mensaje.mensaje(this, "Error al registrar Venta", Mensaje.TITULO_ME, Mensaje.ERROR);
        }

        this.setVisible(false);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

private void rbtOtrosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbtOtrosStateChanged

    if(rbtOtros.isSelected()==true){
       txtTipoOtros.setEditable(true);
   }else{
       txtTipoOtros.setEditable(false);
   }
}//GEN-LAST:event_rbtOtrosStateChanged

private void rbtTarjetaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbtTarjetaStateChanged

    if(rbtTarjeta.isSelected()==true){
       txtTipoTarjeta.setEditable(true);
   }else{
       txtTipoTarjeta.setEditable(false);
   }
    
}//GEN-LAST:event_rbtTarjetaStateChanged

private void rbtCreditoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbtCreditoStateChanged
    
    if(rbtCredito.isSelected()==true){
       txtTipoCredito.setEditable(true);
   }else{
       txtTipoCredito.setEditable(false);
   }
}//GEN-LAST:event_rbtCreditoStateChanged

private void rbtChequeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbtChequeStateChanged

    if(rbtCheque.isSelected()==true){
       txtTipoCheque.setEditable(true);
   }else{
       txtTipoCheque.setEditable(false);
   }
}//GEN-LAST:event_rbtChequeStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private javax.swing.JRadioButton rbtCheque;
    private javax.swing.JRadioButton rbtCredito;
    private javax.swing.JRadioButton rbtEfectivo;
    private javax.swing.JRadioButton rbtOtros;
    private javax.swing.JRadioButton rbtTarjeta;
    private org.jdesktop.swingx.JXTable tblDetalle;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNroDocumento;
    private javax.swing.JTextField txtPaga;
    private javax.swing.JTextField txtRucDni;
    private org.jdesktop.swingx.JXTextField txtTipoCheque;
    private org.jdesktop.swingx.JXTextField txtTipoCredito;
    private org.jdesktop.swingx.JXTextField txtTipoOtros;
    private org.jdesktop.swingx.JXTextField txtTipoTarjeta;
    private javax.swing.JTextField txtVuelto;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
        txtRucDni.setText(objVentas.getObjCliente().getStr_rucdni());
        txtCliente.setText(objVentas.getObjCliente().getStr_razonSocial());
        txtDocumento.setText(objVentas.getStr_numeroDocumento());
        txtMonto.setText(String.valueOf(Util.redondeo(objVentas.getDbTotal(), 2) ));
        txtPaga.requestFocus();
        setLocationRelativeTo(null);

        String arr[] = objVentas.getStr_numeroDocumento().split("-");
         
        
       
        
        List<Ventas> listaVentaDetalle = new ArrayList<>();
        listaVentaDetalle = PaqueteBusinessDelegate.getFlujoCajaService().
                listarVenta(String.valueOf(gui.getLocal().getInt_idLocal()), Util.SINPAGO, objVentas.getStr_numeroDocumento(), 2);
        cargarTabla(listaVentaDetalle);
        
        int cantidadDocumentos;
        if (!this.gui.getListaConfig().get(0).getTipoImpresion().equals(Config.TICKETERA)){
            //Determinar la cantidad de productos por documentos
            cantidadDocumentos=(listaVentaDetalle.size()/10);
            log.info("Cantidad: "+cantidadDocumentos);

            if(listaVentaDetalle.size()%10!=0)
               cantidadDocumentos++;
        }else{
            cantidadDocumentos = 1;
        }
        
        
        log.info("Cantidad: "+cantidadDocumentos);
        
//        System.out.println("local : "+objVentas.getObjLocal().getInt_idLocal()+"  tD :"+arr[2].trim());
         txtNroDocumento.setText(PaqueteBusinessDelegate.getVentasService().
                consultaSiguinteCorrelativo(objVentas.getObjLocal().getInt_idLocal(), arr[2].trim()));
       
//         System.out.println("consulta : "+PaqueteBusinessDelegate.getVentasService().
//                consultaSiguinteCorrelativo(objVentas.getObjLocal().getInt_idLocal(), arr[2].trim()));
        String documento=txtNroDocumento.getText();
        String statico=txtNroDocumento.getText().split("/")[0];
//        System.out.println("estatico : "+statico);
        statico=statico.split("-")[0].concat("-").concat(statico.split("-")[1]).concat("-");
        

        if (cantidadDocumentos>1){
             for (int i=1;i<cantidadDocumentos;i++){
                
                if (i<cantidadDocumentos)
                    documento+=";";
                
                documento+=statico.concat(String.valueOf( Util.stringTOint(
                        txtNroDocumento.getText().split("/")[0].split("-")[2])+i)).
                        concat("/").concat(txtNroDocumento.getText().split("/")[1]);

              
                log.info("NRO: "+documento);
            }
            txtNroDocumento.setText(documento);
        }
      
            
        
         
    }
    
    private void cargarTabla(List<Ventas> lista) {
        Object[] filaTabla = new Object[8];
        DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        for (Ventas objV : lista) {
            filaTabla[0] = objV.getStr_usuario();
            filaTabla[1] = objV.getObjProducto().getStr_nombreProducto();
            filaTabla[2] = (objV.getDbCantidad() .multiply(objV.getDbUnidadesContenidas()) );
            filaTabla[3] = objV.getDbPrecio();
            filaTabla[4] = objV.getDbSubtotal();
            filaTabla[5] = objV.getDbIGV();
            filaTabla[6] = objV.getDbdescuento();
            filaTabla[7] = objV.getDbTotal();
            modelo.addRow(filaTabla);
        }

        tblDetalle.setModel(modelo);
    }

    private boolean calcularVuelto() {
        boolean respuesta = false;
        
        try {
            BigDecimal paga = new BigDecimal(txtPaga.getText());
            if (paga .compareTo(objVentas.getDbTotal())==-1 ) {
                Mensaje.mensaje(this, "Paga debe ser mayor al monto", Mensaje.TITULO_ME, Mensaje.ERROR);
                txtPaga.selectAll();
                return respuesta;
            }
            txtVuelto.setText(String.valueOf(Util.redondeo(paga.subtract(new BigDecimal(Util.redondeo(objVentas.getDbTotal(), 2)) ) , 2)));
            btnAceptar.requestFocus();
            respuesta = true;
        } catch (NumberFormatException nfe) {
            log.error("Error nfe: " + nfe.getMessage());
            Mensaje.mensaje(this, "Ingresar sólo números", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtPaga.selectAll();
            txtPaga.requestFocus();
            respuesta = false;
        } catch (Exception e) {
            log.error("Error e: " + e.getMessage());
            respuesta = false;
        }

        return respuesta;
    }

    private void imprimirBoleta(String [] arrDocumentos){
        
        if (this.gui.getListaConfig().get(0).getTipoImpresion().equals(Config.MATRICIAL)){
            printBoletaMatricial(arrDocumentos);
        }else{
            printBoletaTicketera(arrDocumentos);
        }
        
          
    }    

    private void imprimirFactura(String [] arrDocumentos){
        
         if (this.gui.getListaConfig().get(0).getTipoImpresion().equals(Config.MATRICIAL)){
            printFacturaMatricial(arrDocumentos);
        }else{
            printFacturaTicketera(arrDocumentos);
        }
    }

    private void printFacturaMatricial(String [] arrDocumentos){
         String []arr = arrDocumentos;
        
        for (int x = 0; x < arr.length; x++) {
              List<ImprimirVenta> listaImprimir=new ArrayList<>();  
              
              listaImprimir=PaqueteBusinessDelegate.getVentasService().
                    listaVenta(arr[x].split("/")[0]);
              
              String Cabecera[]={listaImprimir.get(0).getStr_rasonSocial(),
                listaImprimir.get(0).getStr_direccion(),
                listaImprimir.get(0).getFch_fecha(),
                listaImprimir.get(0).getStr_ruc(),
                "-",
                listaImprimir.get(0).getStr_vendedor(),
                "-",
                "-"};
              
              String [][] prod=new String[listaImprimir.size()][5];
              
              for (int i = 0; i < listaImprimir.size(); i++) {            
                    prod[i][0]=listaImprimir.get(i).getStr_codigo();
                    prod[i][1]=""+listaImprimir.get(i).getDbl_cantidad();
                    prod[i][2]=listaImprimir.get(i).getStr_producto();//""+listaImprimir.get(i).getStr_unidadMedida();
                    prod[i][3]=""+listaImprimir.get(i).getDbl_precioUnit();
                    prod[i][4]=""+listaImprimir.get(i).getDbl_subTotal();
            }
              
             String [] totales={""+listaImprimir.get(0).getDbl_sumaSubTotal(),
                                ""+listaImprimir.get(0).getDbl_sumaDescuento(),
                                "-",
                                ""+listaImprimir.get(0).getDbl_sumaSubTotal(),
                                "-",
                                ""+listaImprimir.get(0).getDbl_sumaIGV(),
                                ""+listaImprimir.get(0).getDbl_sumaTotal()}; 
             
              Impresora.imprimirFactura(Cabecera, prod, listaImprimir.size(), totales);
        }
        
        
        
//        String Cabecera[]={"Jar Consulting S.R.L.","Lejos, muy lejos","fecha","20541181041","pedido","vendedor","guia","condi Pago"};
//         
//         String prod[][]={{"F00001","300","Descripcion","preio","300"},
//                            {"F1SDA1","300","vamos a la cuyada","precio","300"},
//                            {"","","","",""}};
//         
//         String totales[]={"1","2","3","4","5","6","600.20"};
    }
            
    private void printBoletaMatricial(String [] arrDocumentos) {
        String []arr=/*txtNroDocumento.getText().trim().split(";")*/
                arrDocumentos;
       
        for (int x = 0; x < arr.length; x++) {
            
            List<ImprimirVenta> listaImprimir=new ArrayList<>();      
            listaImprimir=PaqueteBusinessDelegate.getVentasService().
                    listaVenta(arr[x].split("/")[0]);
           String [] fila1={listaImprimir.get(0).getStr_nombre(),
               listaImprimir.get(0).getStr_vendedor(),
               listaImprimir.get(0).getFch_fecha()};

           String [] fila2={listaImprimir.get(0).getStr_direccion(),
                listaImprimir.get(0).getStr_ruc()};

           String [][] prod=new String[listaImprimir.size()][5];

            for (int i = 0; i < listaImprimir.size(); i++) {            
                    prod[i][0]=listaImprimir.get(i).getStr_codigo();
                    prod[i][1]=""+listaImprimir.get(i).getDbl_cantidad();
                    prod[i][2]=""+listaImprimir.get(i).getStr_unidadMedida();
                    prod[i][3]=listaImprimir.get(i).getStr_producto();
                    prod[i][4]=""+listaImprimir.get(i).getDbl_subTotal();
            }

            String [] totales={""+listaImprimir.get(0).getDbl_sumaSubTotal(),
                                ""+listaImprimir.get(0).getDbl_sumaDescuento(),
                                ""+listaImprimir.get(0).getDbl_sumaIGV(),
                                ""+listaImprimir.get(0).getDbl_sumaTotal()};

            Impresora.imprimirBoleta(fila1, fila2,prod,listaImprimir.size(),totales );
                
        }
    }

    private void printBoletaTicketera(String[] arrDocumentos) {
      String []arr=/*txtNroDocumento.getText().trim().split(";")*/arrDocumentos;
       ImprimirVenta imprimirVenta = new ImprimirVenta();
       imprimirVenta.setDbl_efectivo(new BigDecimal(txtPaga.getText().trim()));
       imprimirVenta.setDbl_vuelto(new BigDecimal (txtVuelto.getText().trim()));
        for (int x = 0; x < arr.length; x++) {
            List<ImprimirVenta> listaImprimir=new ArrayList<>();      
            listaImprimir=PaqueteBusinessDelegate.getVentasService().
                    listaVenta(arr[x].split("/")[0]);
            new Impresora().imprimirBoletaTicket(imprimirVenta,listaImprimir,arr[x],this.gui.getEmpresa(),this.gui.getLocal(),this.gui.getStrFormatoTicket());
        }
    }
    
     private void printFacturaTicketera(String[] arrDocumentos) {
      String []arr=/*txtNroDocumento.getText().trim().split(";")*/arrDocumentos;
       ImprimirVenta imprimirVenta = new ImprimirVenta();
       imprimirVenta.setDbl_efectivo(new BigDecimal(txtPaga.getText().trim()));
       imprimirVenta.setDbl_vuelto(new BigDecimal (txtVuelto.getText().trim()));
        for (int x = 0; x < arr.length; x++) {
            List<ImprimirVenta> listaImprimir=new ArrayList<>();      
            listaImprimir=PaqueteBusinessDelegate.getVentasService().
                    listaVenta(arr[x].split("/")[0]);
            new Impresora().imprimirFacturaTicket(imprimirVenta,listaImprimir,arr[x],this.gui.getEmpresa(),this.gui.getLocal(),this.gui.getStrFormatoTicket());
        }
    }
}
