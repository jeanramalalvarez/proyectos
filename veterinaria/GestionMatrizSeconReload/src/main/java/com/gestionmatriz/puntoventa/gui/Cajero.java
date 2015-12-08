/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXTable;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.Caja;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

/**
 *
 * @author cesareo
 */
public class Cajero extends javax.swing.JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(Cajero.class);  
	private Principal gui;
    private List<Ventas> listaVenta;

    public Cajero(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenta = new org.jdesktop.swingx.JXTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUC / DNI", "Cliente", "Documento", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
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
        tblVenta.setColumnControlVisible(true);
        tblVenta.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        tblVenta.setRowHeight(30);
        tblVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVentaMouseClicked(evt);
            }
        });
        tblVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblVentaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblVenta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVentaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getVENDER_DOCUMENTO())) {
                Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
                return;
            }
            
            List<Caja> listaCaja = new ArrayList<>();
            listaCaja = PaqueteBusinessDelegate.getFlujoCajaService().getCaja(gui.getLocal().getInt_idLocal(), gui.getBarraEstado().getUsuario());

            if (listaCaja.isEmpty()) {
                Mensaje.mensaje(this, "Debe Aperturar Caja", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                return;
            }

            if (tblVenta.getRowCount() > 0) {
                vender(listaCaja.get(0));
                cargarDatos();
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            efe5();
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getSUPRIMIR_DOCUMENTO())) {
                Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
                return;
            }
            
            Object objConfirmacion = Mensaje.confirmar(this, "Desea eliminar esta Venta?", "Mensaje Confirmación", Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);
            if (objConfirmacion.equals(Mensaje.YES_OPTION)) {
                if (PaqueteBusinessDelegate.getVentasService().eliminarVenta(getObjVenta())) {
                    Mensaje.mensaje(this, "Venta eliminada", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                    efe5();
                } else {
                    Mensaje.mensaje(this, "Error al eliminar Venta", Mensaje.TITULO_ME, Mensaje.ERROR);
                }
            }
        }
    }//GEN-LAST:event_tblVentaKeyPressed

    private void tblVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentaMouseClicked
        if (evt.getClickCount() == 2) {
            if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getVENDER_DOCUMENTO())) {
                Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
                return;
            }
            
            List<Caja> listaCaja = new ArrayList<>();
            listaCaja = PaqueteBusinessDelegate.getFlujoCajaService().getCaja(gui.getLocal().getInt_idLocal(), gui.getBarraEstado().getUsuario());

            if (listaCaja.isEmpty()) {
                Mensaje.mensaje(this, "Debe Aperturar Caja", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                return;
            }

            if (tblVenta.getRowCount() > 0) {
                vender(listaCaja.get(0));
                cargarDatos();
            }
        }
    }//GEN-LAST:event_tblVentaMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable tblVenta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
    }
    
    private void efe5() {
        try {
            ConexionSql.cerrarConexionAll(ConexionSql.getConexion());
        } catch (Exception e) {
            log.error("Error al cerrar conexión: " + e.getMessage());
        }

        cargarDatos();
    }

    private void cargarDatos() {
        this.setTitle(gui.getTitle().concat("Modulo: [Cobrar Ventas]"));
        listaVenta = PaqueteBusinessDelegate.getFlujoCajaService().
                listarVenta(String.valueOf(gui.getLocal().getInt_idLocal()), Util.SINPAGO, "", 1);
        cargarTabla(tblVenta, listaVenta);
        tblVenta.setSortable(false);
    }

    private Ventas getObjVenta() {
        int indice = tblVenta.getSelectedRow();
        return listaVenta.get(indice);
    }

    private void vender(Caja objCaja) {
        try {
            Util.hiloProgressBar(1, gui);
            CajeroVender frmCajeroVender = new CajeroVender(gui, objCaja, getObjVenta(), this);
            Util.hiloProgressBar(0, gui);
            frmCajeroVender.setVisible(true);
        } catch (Exception ex) {
            log.error("ERROR: "+ex.getMessage());
        }
    }

    private void cargarTabla(JXTable tabla, List<Ventas> listaV) {
        Object[] filaTabla = new Object[4];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (Ventas objV : listaV) {
            filaTabla[0] = objV.getObjCliente().getStr_rucdni();
            filaTabla[1] = objV.getObjCliente().getStr_razonSocial();
            filaTabla[2] = objV.getStr_numeroDocumento();
            filaTabla[3] = objV.getDbTotal();
            modelo.addRow(filaTabla);
        }

        tabla.setModel(modelo);
    }
}
