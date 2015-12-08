/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.gui;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.puntoventa.bean.Cliente;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

/**
 *
 * @author cesareo
 */
public class BuscarCliente extends javax.swing.JDialog {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(BuscarCliente.class);  
    private Frame gui;
    private GestionCliente frmGestionCliente;
    private PreVenta frmPreVenta;
    private List<Cliente> listaCliente;

    public BuscarCliente(Frame gui, List<Cliente> listaCliente, GestionCliente frmGestionCliente) {
        super(gui, true);
        this.gui = gui;
        this.listaCliente = listaCliente;
        this.frmGestionCliente = frmGestionCliente;
        initComponents();
        cargarDatos();
    }

    public BuscarCliente(Frame gui, List<Cliente> listaCliente, PreVenta frmPreVenta) {
        super(gui, true);
        this.gui = gui;
        this.listaCliente = listaCliente;
        this.frmPreVenta = frmPreVenta;
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
        txtRazonSocial = new javax.swing.JTextField();
        txtRucDni = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new org.jdesktop.swingx.JXTable();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Razón Social:");

        jLabel2.setText("RUC / DNI:");

        jLabel3.setText("Dirección:");

        jLabel4.setText("Teléfono:");

        txtRucDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucDniKeyPressed(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Razón Social", "RUC / DNI", "Dirección", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.setColumnControlVisible(true);
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        tblCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblClienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblClienteKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRucDni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRucDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            buscar();
        } catch (Exception ex) {
            log.error("Error en Busqueda: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        evento();
    }//GEN-LAST:event_tblClienteMouseClicked

    private void tblClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblClienteKeyReleased
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            evento();
//        }
    }//GEN-LAST:event_tblClienteKeyReleased

    private void tblClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblClienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evento();
        }
    }//GEN-LAST:event_tblClienteKeyPressed

    private void txtRucDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucDniKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                buscar();
            } catch (Exception ex) {
                log.error("Error en Busqueda: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtRucDniKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable tblCliente;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRucDni;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
        this.setTitle(gui.getTitle() + " - Buscar Cliente");
        tblCliente.requestFocus();
//        this.setSize(575, 450);
        setLocationRelativeTo(null);
    }

    private void evento() {

        if (frmGestionCliente == null) {
            frmPreVenta.cargarDatosBusquedaCliente(clienteSeleccionado());
            this.setVisible(false);
            return;
        }
        frmGestionCliente.cargarDatosBusquedaCliente(clienteSeleccionado());
        this.setVisible(false);
    }

    private void cargarTabla(List<Cliente> listaCliente) {
        Object[] filaTabla = new Object[4];
        DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (Cliente objC : listaCliente) {
            filaTabla[0] = objC.getStr_razonSocial();
            filaTabla[1] = objC.getStr_rucdni();
            filaTabla[2] = objC.getStr_direccion();
            filaTabla[3] = objC.getStr_telefono();
            modelo.addRow(filaTabla);
        }

        tblCliente.setModel(modelo);
    }

    protected void cargarPanelBusquedaCliente(List<Cliente> listaCliente) {
        cargarTabla(listaCliente);
    }

    protected Cliente clienteSeleccionado() {
        int indice = tblCliente.getSelectedRow();
        return listaCliente.get(indice);
    }

    private void buscar() {
        listaCliente = PaqueteBusinessDelegate.getClienteService().
                listarCliente(txtRazonSocial.getText(), txtRucDni.getText(),
                txtDireccion.getText(), txtTelefono.getText());

        cargarTabla(listaCliente);
    }
}
