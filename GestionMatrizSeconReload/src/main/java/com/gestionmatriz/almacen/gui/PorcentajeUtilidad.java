/*
 * PorcentajeUtilidad.java
 *
 * Created on 19-ago-2012, 11:46:19
 */
package com.gestionmatriz.almacen.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXTable;

import com.gestionmatriz.almacen.bean.MedidaRotacion;
import com.gestionmatriz.almacen.opciones.Opciones;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import com.gestionmatriz.util.ValidarCamposNulos;

/**
 *
 * @author cesareo
 */
public class PorcentajeUtilidad extends javax.swing.JInternalFrame {

	private static final Logger log=Logger.getLogger(GestionPrecioOferta.class);
    private Principal gui;
    private List<MedidaRotacion> listaMR = new ArrayList<>();
    private MedidaRotacion objMR = null;
    
    public PorcentajeUtilidad(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboMedidaRotacion = new javax.swing.JComboBox();
        txtUtilidad = new javax.swing.JTextField();
        txtAdicional = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedidaRotacion = new org.jdesktop.swingx.JXTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        btnModificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN MEDIDA ROTACIÓN");

        pnlPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder("Mantenimiento porcentaje utilidad"));

        jLabel1.setText("Medida rotación:");

        jLabel2.setText("Utilidad:");

        jLabel3.setText("Adicional:");

        cboMedidaRotacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMedidaRotacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMedidaRotacionItemStateChanged(evt);
            }
        });

        txtUtilidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUtilidadKeyPressed(evt);
            }
        });

        txtAdicional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdicionalKeyPressed(evt);
            }
        });

        tblMedidaRotacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Medida rotación", "% utilidad", "% adicional", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.math.BigDecimal.class, java.math.BigDecimal.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMedidaRotacion.setColumnControlVisible(true);
        jScrollPane1.setViewportView(tblMedidaRotacion);

        txaDescripcion.setColumns(20);
        txaDescripcion.setRows(5);
        jScrollPane2.setViewportView(txaDescripcion);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel4.setText("%");

        jLabel5.setText("%");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("[ENTER para precalcular]");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setText("[ENTER para precalcular]");

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(41, 41, 41)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(txtUtilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel6))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(txtAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel7))
                            .addComponent(cboMedidaRotacion, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 130, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboMedidaRotacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUtilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cboMedidaRotacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMedidaRotacionItemStateChanged
    if ((listaMR.size() > 0) && (cboMedidaRotacion.getSelectedIndex() > 0)) {
        txtUtilidad.setText(String.valueOf(listaMR.get(cboMedidaRotacion.getSelectedIndex() - 1).getDbl_utilidad()));
        txtAdicional.setText(String.valueOf(listaMR.get(cboMedidaRotacion.getSelectedIndex() - 1).getDbl_adicional()));
        txaDescripcion.setText(listaMR.get(cboMedidaRotacion.getSelectedIndex() - 1).getStr_descripcionMR());
        txtUtilidad.requestFocus();
        
        objMR = new MedidaRotacion();
        objMR.setInt_idMedidaRotacion(listaMR.get(cboMedidaRotacion.getSelectedIndex() - 1).getInt_idMedidaRotacion());
        objMR.setStr_codigoMR(listaMR.get(cboMedidaRotacion.getSelectedIndex() - 1).getStr_codigoMR());
    }
}//GEN-LAST:event_cboMedidaRotacionItemStateChanged

private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getMODIFICARMEDIDAROTACION())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (cboMedidaRotacion.getSelectedIndex() == 0) {
        Mensaje.mensaje(this, "Seleccionar Medida de Rotación", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    JTextField[] txts = {txtUtilidad, txtAdicional};
    
    if (!ValidarCamposNulos.validar(txts)) {
        Mensaje.mensaje(this, "Los campos resaltados son importantes", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (!getBigDecimal(txtUtilidad.getText(), txtAdicional.getText())) {
        Mensaje.mensaje(this, "Ingresar sólo números en % Utilidad y % Adicional", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    objMR.setStr_nombreMR(cboMedidaRotacion.getSelectedItem().toString());
    objMR.setDbl_utilidad(new BigDecimal(txtUtilidad.getText()));
    objMR.setDbl_adicional(new BigDecimal(txtAdicional.getText()));
    
    if (txaDescripcion.getText().equals("")) {
        objMR.setStr_descripcionMR("");
    } else {
        objMR.setStr_descripcionMR(txaDescripcion.getText());
    }
    
    objMR.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());
    
    if (PaqueteBusinessDelegate.getMedidaRotacionService().modificarMR(objMR)) {
        Mensaje.mensaje(this, "Registro Correcto", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        listaMR = PaqueteBusinessDelegate.getMedidaRotacionService().listarMR();
        limpiarDatos();
        cargarTabla(tblMedidaRotacion, listaMR);
    } else {
        Mensaje.mensaje(this, "Error al registrar", Mensaje.TITULO_ME, Mensaje.ERROR);
    }
}//GEN-LAST:event_btnModificarActionPerformed

    private void txtUtilidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUtilidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtAdicional.requestFocus();
        }
    }//GEN-LAST:event_txtUtilidadKeyPressed

    private void txtAdicionalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdicionalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txaDescripcion.requestFocus();
        }
    }//GEN-LAST:event_txtAdicionalKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cboMedidaRotacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlPrincipal;
    private org.jdesktop.swingx.JXTable tblMedidaRotacion;
    private javax.swing.JTextArea txaDescripcion;
    private javax.swing.JTextField txtAdicional;
    private javax.swing.JTextField txtUtilidad;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
        objMR = new MedidaRotacion();
    }

    private void cargarDatos() {
        cargarCombo();
        tblMedidaRotacion.setSortable(false);
        cargarTabla(tblMedidaRotacion, listaMR);
    }
    
    private void cargarCombo() {
        listaMR = PaqueteBusinessDelegate.getMedidaRotacionService().listarMR();
        cboMedidaRotacion.removeAllItems();
        cboMedidaRotacion.addItem(".::Seleccionar Medida de Rotación::.");
        
        if (listaMR.size() > 0) {
            for (MedidaRotacion objMR : listaMR) {
                cboMedidaRotacion.addItem(objMR.getStr_nombreMR());
            }
        } else if (listaMR.isEmpty()) {
            cboMedidaRotacion.addItem(Util.MENOR);
            cboMedidaRotacion.addItem(Util.MEDIA);
            cboMedidaRotacion.addItem(Util.MAYOR);
        }
    }
    
    private void cargarTabla(JXTable tabla, List<MedidaRotacion> lista) {
        Object[] filaTabla = new Object[5];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (MedidaRotacion objMR : lista) {
            filaTabla[0] = objMR.getStr_codigoMR();
            filaTabla[1] = objMR.getStr_nombreMR();
            filaTabla[2] = objMR.getDbl_utilidad();
            filaTabla[3] = objMR.getDbl_adicional();
            filaTabla[4] = objMR.getStr_descripcionMR();
            modelo.addRow(filaTabla);
        }

        tabla.setModel(modelo);
    }
    
    private void limpiarDatos() {
        cargarCombo();
        txtUtilidad.setText("");
        txtAdicional.setText("");
        txaDescripcion.setText("");
        objMR = null;
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
    
}
