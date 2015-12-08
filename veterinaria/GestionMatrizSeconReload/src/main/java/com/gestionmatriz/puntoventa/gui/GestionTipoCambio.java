/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXTable;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.TipoCambio;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;

/**
 *
 * @author cesareo
 */
public class GestionTipoCambio extends javax.swing.JInternalFrame {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(GestionTipoCambio.class);  
	private Principal gui;
    private TipoCambio objTipoCambio = null;
    private List<TipoCambio> listaTipoCambio = new ArrayList<>();

    public GestionTipoCambio(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable2 = new org.jdesktop.swingx.JXTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCompraDolar = new javax.swing.JTextField();
        txtVentaDolar = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtFechaActual = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTipoCambio = new org.jdesktop.swingx.JXTable();

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jXTable1);

        jXTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jXTable2);

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN -  TIPO DE CAMBIO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Compra Dolar:");

        jLabel2.setText("Venta Dolar:");
        jLabel2.setToolTipText("");

        txtCompraDolar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCompraDolarKeyPressed(evt);
            }
        });

        txtVentaDolar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtVentaDolarKeyPressed(evt);
            }
        });

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        btnRegistrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRegistrarKeyPressed(evt);
            }
        });

        jLabel3.setText("Fecha servidor:");

        txtFechaActual.setEditable(false);

        tblTipoCambio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha día", "Precio Compra", "Precio Venta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTipoCambio.setColumnControlVisible(true);
        jScrollPane3.setViewportView(tblTipoCambio);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFechaActual, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtVentaDolar)
                            .addComponent(txtCompraDolar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCompraDolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtVentaDolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        registrarTipoCambio();
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void registrarTipoCambio(){
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getINGRESA_TIPOCAMBIO())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        if (!getBigDecimal(txtCompraDolar.getText(), txtVentaDolar.getText())) {
            Mensaje.mensaje(this, "Ingresar sólo números en Nuevo Sol y Dolar", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        if (PaqueteBusinessDelegate.getTipoCambioService().verificarTipoCambio(txtFechaActual.getText())) {
            Mensaje.mensaje(this, "Ya existe Tipo de Cambio del Día - No puede volver a registrar", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            return;
        }
        
        objTipoCambio = new TipoCambio();
        
        objTipoCambio.setDbl_precioCompraDolar(new BigDecimal(txtCompraDolar.getText()));
        objTipoCambio.setDbl_precioVentaDolar(new BigDecimal(txtVentaDolar.getText()));
        objTipoCambio.setStr_fechaDia(txtFechaActual.getText());
        objTipoCambio.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());
        
        if (PaqueteBusinessDelegate.getTipoCambioService().registrarTipoCambio(objTipoCambio)) {
            Mensaje.mensaje(this, "Registro correcto", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            limpiarDatos();
            listaTipoCambio = PaqueteBusinessDelegate.getTipoCambioService().listarTipoCambio();
            cargarTabla(tblTipoCambio, listaTipoCambio);
        } else {
            Mensaje.mensaje(this, "Error al registrar", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }
    
    
    private void txtCompraDolarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompraDolarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtVentaDolar.requestFocus();
        }
    }//GEN-LAST:event_txtCompraDolarKeyPressed

    private void txtVentaDolarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVentaDolarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
        }
    }//GEN-LAST:event_txtVentaDolarKeyPressed

private void btnRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            registrarTipoCambio();
        }
}//GEN-LAST:event_btnRegistrarKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXTable jXTable1;
    private org.jdesktop.swingx.JXTable jXTable2;
    private org.jdesktop.swingx.JXTable tblTipoCambio;
    private javax.swing.JTextField txtCompraDolar;
    private javax.swing.JTextField txtFechaActual;
    private javax.swing.JTextField txtVentaDolar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
        objTipoCambio = new TipoCambio();
    }
    
    private void cargarDatos() {
        txtCompraDolar.requestFocus();
        txtFechaActual.setText(PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql().substring(0, 10));
        listaTipoCambio = PaqueteBusinessDelegate.getTipoCambioService().listarTipoCambio();
        cargarTabla(tblTipoCambio, listaTipoCambio);
    }
    
    private boolean getBigDecimal(String numero, String numero2) {
        try {
            BigDecimal dblNumero = new BigDecimal(numero);
            BigDecimal dblNumero2 = new BigDecimal(numero2);
        } catch (NumberFormatException nfe) {
            log.error("Error nfe: " + nfe.getMessage());
            return false;
        } catch (Exception e) {
            log.error("Error e: " + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    private void limpiarDatos() {
        txtCompraDolar.setText("");
        txtVentaDolar.setText("");
        txtFechaActual.setText(PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql().substring(0, 10));
        txtCompraDolar.requestFocus();
        objTipoCambio = null;
    }
    
    private void cargarTabla(JXTable tabla, List<TipoCambio> listaTC) {
        Object[] filaTabla = new Object[3];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (TipoCambio objTC : listaTC) {
            filaTabla[0] = objTC.getStr_fechaDia();
            filaTabla[1] = objTC.getDbl_precioCompraDolar();
            filaTabla[2] = objTC.getDbl_precioVentaDolar();
            modelo.addRow(filaTabla);
        }

        tabla.setModel(modelo);
    }
    
}
