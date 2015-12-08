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

import org.apache.log4j.Logger;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.Caja;
import com.gestionmatriz.puntoventa.bean.FlujoCaja;
import com.gestionmatriz.puntoventa.bean.TipoCambio;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.recursoshumanos.bean.Config;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.ComboUtil;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import com.gestionmatriz.util.ValidarCamposNulos;

/**
 *
 * @author cesareo
 */
public class AperturaCaja extends javax.swing.JInternalFrame {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(AperturaCaja.class);  
    private Principal gui;
    private List<Caja> listaCaja = new ArrayList<>();
    private List<com.gestionmatriz.puntoventa.bean.Impresora> listaImpresora = 
            new ArrayList<>();
    private FlujoCaja objFlujoCaja = null;

    public AperturaCaja(Principal gui) {
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
        txtCantSoles = new javax.swing.JTextField();
        txtCantDolares = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboCaja = new javax.swing.JComboBox();
        btnRegistrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboImpresora = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("APERTURA CAJA");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Cantidad soles (S/.):");

        jLabel2.setText("Cantidad dolares ($):");

        txtCantSoles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantSolesKeyPressed(evt);
            }
        });

        txtCantDolares.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantDolaresKeyPressed(evt);
            }
        });

        jLabel3.setText("Cantidad Total (S/.):");

        txtCantTotal.setEditable(false);

        jLabel4.setText("Caja:");

        cboCaja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboCaja.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCajaItemStateChanged(evt);
            }
        });

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("[ENTER para precalcular]");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("[ENTER para precalcular]");

        jLabel7.setText("Ticketera: ");

        cboImpresora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCantDolares, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCantSoles, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboImpresora, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                                .addComponent(cboCaja, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCantSoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCantDolares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getAPERTURAR_CAJA())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        if (!verificarCaja()) {
            return;
        }
        
        if (cboCaja.getSelectedIndex() == 0) {
            Mensaje.mensaje(this, "Seleccionar Caja", Mensaje.TITULO_ME, Mensaje.ERROR);
            cboCaja.requestFocus();
            return;
        }
        
        if (this.gui.getListaConfig().get(0).getTipoImpresion().equals(Config.TICKETERA) && cboImpresora.getSelectedIndex()==0){
            Mensaje.mensaje(this, "Seleccionar Ticketera", Mensaje.TITULO_ME, Mensaje.ERROR);
            cboImpresora.requestFocus();
            return;
        }
        
        JTextField[] txts = {txtCantSoles, txtCantDolares,txtCantTotal};
        if (!ValidarCamposNulos.validar(txts)) {
            Mensaje.mensaje(this, "Los campos resaltados son importantes", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtCantSoles.requestFocus();
            return;
        }

        if (!txtCantSoles()) {
            return;
        }

        if (!txtCantDolares()) {
            return;
        }

        objFlujoCaja = new FlujoCaja();
        objFlujoCaja.setObjLocal(gui.getLocal());
        objFlujoCaja.setObjCaja(buscarCaja(cboCaja.getSelectedItem().toString()));
        objFlujoCaja.setDbl_cantidadSoles(new BigDecimal(txtCantSoles.getText()));
        objFlujoCaja.setDbl_cantidadDolares(new BigDecimal(txtCantDolares.getText()));
        objFlujoCaja.setDbl_cantidadTotalSoles(new BigDecimal(txtCantTotal.getText()));
        objFlujoCaja.setStr_motivo(Util.APERTURACAJA);
        objFlujoCaja.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());
        objFlujoCaja.setStr_numeroSerie(cboImpresora.getSelectedIndex()==0?"":this.listaImpresora.get(cboImpresora.getSelectedIndex()-1).getStr_NumeroSerie());
        
        if ((PaqueteBusinessDelegate.getFlujoCajaService().registrarFlujoCaja(objFlujoCaja,"", "","",""))[0].equals("true")) {
            Mensaje.mensaje(this, "Registro correcto", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            String numeroSerie = PaqueteBusinessDelegate.getFlujoCajaService().getNumeroSerieImpresora(this.gui.getLocal().getInt_idLocal());
            if (numeroSerie!=null && !numeroSerie.isEmpty()){
                    this.gui.setStrFormatoTicket(this.gui.getStrFormatoTicket().replace("{{N/S}}", numeroSerie));
            }
            limpiarDatos();
        } else {
            Mensaje.mensaje(this, "Error al registrar", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cboCajaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCajaItemStateChanged
        txtCantSoles.selectAll();
        txtCantSoles.requestFocus();
    }//GEN-LAST:event_cboCajaItemStateChanged

    private void txtCantSolesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantSolesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtCantSoles()) {
                return;
            }
        }
    }//GEN-LAST:event_txtCantSolesKeyPressed

    private void txtCantDolaresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantDolaresKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtCantDolares()) {
                return;
            }

            calcularPrecioTotal();
        }
    }//GEN-LAST:event_txtCantDolaresKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox cboCaja;
    private javax.swing.JComboBox cboImpresora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCantDolares;
    private javax.swing.JTextField txtCantSoles;
    private javax.swing.JTextField txtCantTotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
        objFlujoCaja = new FlujoCaja();
    }

    private void cargarDatos() {
        if (!verificarCaja()) {
            return;
        }
        
        cargarComboCaja();
        com.gestionmatriz.puntoventa.bean.Impresora objImpresora = 
                new com.gestionmatriz.puntoventa.bean.Impresora() ;
        objImpresora.setStr_marca("");
        objImpresora.setStr_modelo("");
        objImpresora.setObjLocal(new Local((this.gui.getLocal().getInt_idLocal())));
        objImpresora.setStrNumeroSerie("");
        objImpresora.setStr_estado(Util.ACTIVO);
        this.listaImpresora = 
                PaqueteBusinessDelegate.getImpresoraService().
                        listarImpresora(objImpresora);
        this.cboImpresora = ComboUtil.getListaImpresoras(cboImpresora,this.listaImpresora);
        txtCantSoles.setText("0");
        txtCantDolares.setText("0");
    }

    private void cargarComboCaja() {
        cboCaja.removeAllItems();
        cboCaja.addItem(".::Seleccionar Caja::.");
        listaCaja = PaqueteBusinessDelegate.getFlujoCajaService().listarCaja(gui.getLocal().getInt_idLocal());

        for (Caja objC : listaCaja) {
            cboCaja.addItem(objC.getStr_nombre());
        }
    }
    
    private Caja buscarCaja(String nombre) {
        for (Caja caja : listaCaja) {
            if (caja.getStr_nombre().equals(nombre)) {
                return caja;
            }
        }
        
        return null;
    }

    private boolean txtCantSoles() {
        boolean respuesta = false;

        try {
            BigDecimal cantidadSoles =new  BigDecimal(txtCantSoles.getText());

            if (cantidadSoles.compareTo(BigDecimal.ZERO) == -1) {
                txtCantSoles.selectAll();
                txtCantSoles.requestFocus();
                Mensaje.mensaje(this, "Ingresar números positivos", Mensaje.TITULO_ME, Mensaje.ERROR);
            } else {
                txtCantDolares.selectAll();
                txtCantDolares.requestFocus();
                respuesta = true;
            }
        } catch (NumberFormatException nfe) {
            log.error("Error nfe: " + nfe.getMessage());
            Mensaje.mensaje(this, "Ingresar sólo números", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtCantSoles.selectAll();
            txtCantSoles.requestFocus();
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
            BigDecimal cantidadDolares = new BigDecimal(txtCantDolares.getText());

            if (cantidadDolares.compareTo(BigDecimal.ZERO) == -1) {
                txtCantDolares.selectAll();
                txtCantDolares.requestFocus();
                Mensaje.mensaje(this, "Ingresar números positivos", Mensaje.TITULO_ME, Mensaje.ERROR);
            } else {
                btnRegistrar.requestFocus();
                respuesta = true;
            }
        } catch (NumberFormatException nfe) {
            log.error("Error nfe: " + nfe.getMessage());
            Mensaje.mensaje(this, "Ingresar sólo números", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtCantDolares.selectAll();
            txtCantDolares.requestFocus();
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
        BigDecimal cantSoles = new BigDecimal(txtCantSoles.getText());
        BigDecimal cantDolares = new BigDecimal(txtCantDolares.getText());
        BigDecimal cantTotal = BigDecimal.ZERO;

        if (objTC != null) {
            cantTotal = (cantDolares .multiply(objTC.getDbl_precioCompraDolar()) ).add(cantSoles) ;
            txtCantTotal.setText(String.valueOf(cantTotal));
        } else {
            Mensaje.mensaje(this, "Falta registrar Tipo de Cambio del Día", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtCantDolares.setText("0");
            txtCantDolares.selectAll();
            txtCantDolares.requestFocus();
        }
    }

    private void limpiarDatos() {
        objFlujoCaja = null;
        cargarComboCaja();
        txtCantSoles.setText("");
        txtCantDolares.setText("");
        txtCantTotal.setText("");
        cboCaja.requestFocus();
    }
    
    private boolean verificarCaja() {
        List<Caja> LC = new ArrayList<>();
        LC = PaqueteBusinessDelegate.getFlujoCajaService().getCaja(gui.getLocal().getInt_idLocal(), gui.getBarraEstado().getUsuario());
        
        if (!LC.isEmpty()) {
            cboCaja.removeAllItems();
            cboCaja.setEnabled(false);
            txtCantSoles.setEditable(false);
            txtCantDolares.setEditable(false);
            btnRegistrar.setEnabled(false);
            Mensaje.mensaje(this, "Usted ya tiene aperturada: " + LC.get(0).getStr_nombre(), Mensaje.TITULO_ME, Mensaje.INFORMACION);
            return false;
        }
        
        return true;
    }
}
