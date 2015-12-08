/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXTable;

import com.gestionmatriz.almacen.bean.ProveedorProductoUnidadMedida;
import com.gestionmatriz.almacen.opciones.Opciones;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

/**
 *
 * @author cesareo
 */
public class GestionPrecioOferta extends javax.swing.JInternalFrame {

	private static final Logger log=Logger.getLogger(GestionPrecioOferta.class);
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal gui;
    private ProveedorProductoUnidadMedida objPPUM = null;
    private List<ProveedorProductoUnidadMedida> listaPPUM = new ArrayList<>();
    private List<ProveedorProductoUnidadMedida> listaPPUMOferta = new ArrayList<>();
    
    public GestionPrecioOferta(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtPrecioOferta = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPreciosOfertas = new org.jdesktop.swingx.JXTable();
        btnQuitarOferta = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE OFERTA DE PRECIO");

        pnl1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Producto:");

        jLabel2.setText("Precio Venta:");

        jLabel3.setText("Precio Oferta:");

        txtProducto.setEditable(false);

        txtPrecioVenta.setEditable(false);

        txtPrecioOferta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioOfertaKeyPressed(evt);
            }
        });

        btnBuscar.setText("...");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        tblPreciosOfertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Producto", "Precio Venta", "Precio Oferta", "Diferencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.math.BigDecimal.class, java.math.BigDecimal.class, java.math.BigDecimal.class
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
        tblPreciosOfertas.setColumnControlVisible(true);
        jScrollPane1.setViewportView(tblPreciosOfertas);

        btnQuitarOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/eliminar.png"))); // NOI18N
        btnQuitarOferta.setText("Quitar oferta");
        btnQuitarOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarOfertaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37)
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnl1Layout.createSequentialGroup()
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnQuitarOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtPrecioOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl1Layout.createSequentialGroup()
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecioOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            List<ProveedorProductoUnidadMedida> listaPPUM = PaqueteBusinessDelegate.getProveedorProductoUnidadMedidaService().listarPPUM();

            if (listaPPUM.isEmpty()) {
                Mensaje.mensaje(this, "No existen productos con precio", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            } else if (listaPPUM.size() == 1) {
                cargarDatosBusquedaProducto(listaPPUM.get(0));
            } else if (listaPPUM.size() > 1) {
                Util.hiloProgressBar(1, gui);
                BuscarProducto frmBuscarProducto = new BuscarProducto(gui, listaPPUM, this, 2);
                Util.hiloProgressBar(0, gui);
                frmBuscarProducto.cargarPanelBusquedaPPUM(listaPPUM);
                frmBuscarProducto.setVisible(true);
            }
        } catch (Exception ex) {
            log.error("ERROR: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREGISTRARPRECIO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
        
        if (objPPUM == null) {
            Mensaje.mensaje(this, "Debe buscar un producto", Mensaje.TITULO_ME, Mensaje.ERROR);
            btnBuscar.requestFocus();
            return;
        }
        
        if (!txtPrecioOferta()) {
            return;
        }
        
        objPPUM.setDbl_precioOferta(new BigDecimal(txtPrecioOferta.getText()));
        objPPUM.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());
        
        if (PaqueteBusinessDelegate.getProveedorProductoUnidadMedidaService().registrarPPUM(objPPUM)) {
            Mensaje.mensaje(this, "Producto con Oferta", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            limpiar();
        } else {
            Mensaje.mensaje(this, "Error al registrar Oferta", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtPrecioOfertaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioOfertaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPrecioOferta();
        }
    }//GEN-LAST:event_txtPrecioOfertaKeyPressed

    private void btnQuitarOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarOfertaActionPerformed
        if (objPPUM == null) {
            Mensaje.mensaje(this, "Debe buscar un producto", Mensaje.TITULO_ME, Mensaje.ERROR);
            btnBuscar.requestFocus();
            return;
        }
        
        objPPUM.setDbl_precioOferta(BigDecimal.ZERO);
        objPPUM.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());
        
        if (PaqueteBusinessDelegate.getProveedorProductoUnidadMedidaService().quitarOferta(objPPUM)) {
            Mensaje.mensaje(this, "Producto con Oferta", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            limpiar();
        } else {
            Mensaje.mensaje(this, "Error al registrar Oferta", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }//GEN-LAST:event_btnQuitarOfertaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnQuitarOferta;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl1;
    private org.jdesktop.swingx.JXTable tblPreciosOfertas;
    private javax.swing.JTextField txtPrecioOferta;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
        objPPUM = new ProveedorProductoUnidadMedida();
    }

    protected void cargarDatosBusquedaProducto(ProveedorProductoUnidadMedida objPPUM) {
        if (objPPUM != null) {
            txtProducto.setText(objPPUM.getObjProducto().getStr_nombreProducto());
            txtPrecioVenta.setText(String.valueOf(objPPUM.getDbl_precioFinal()));
            txtPrecioOferta.requestFocus();
            this.objPPUM = objPPUM;
        } else {
            Mensaje.mensaje(this, "No se encontro producto", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        }
    }
    
    private void cargarDatos() {
        btnBuscar.requestFocus();
        listaPPUM = PaqueteBusinessDelegate.getProveedorProductoUnidadMedidaService().listarPPUM();
        listaPPUMOferta = listarPrecioOferta(listaPPUM);
        tblPreciosOfertas.setSortable(false);
        cargarTabla(tblPreciosOfertas, listaPPUMOferta);
    }
    
    private List<ProveedorProductoUnidadMedida> listarPrecioOferta(List<ProveedorProductoUnidadMedida> listaPPUM) {
        List<ProveedorProductoUnidadMedida> lista = new ArrayList<>();
        
        for (ProveedorProductoUnidadMedida objPPUM : listaPPUM) {
            if (objPPUM.getDbl_precioOferta().compareTo(BigDecimal.ZERO) != 0) {
                lista.add(objPPUM);
            }
        }
        
        return lista;
    }
    
    private void cargarTabla(JXTable tabla, List<ProveedorProductoUnidadMedida> listaPPUM) {
        Object[] filaTabla = new Object[5];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (ProveedorProductoUnidadMedida objPPUM : listaPPUM) {
            if (verificarProducto(objPPUM.getObjProducto().getStr_codigoInterno(), modelo)) {
                filaTabla[0] = objPPUM.getObjProducto().getStr_codigoInterno();
                filaTabla[1] = objPPUM.getObjProducto().getStr_nombreProducto();
                filaTabla[2] = objPPUM.getDbl_precioFinal();
                filaTabla[3] = objPPUM.getDbl_precioOferta();
                filaTabla[4] = (objPPUM.getDbl_precioFinal().subtract(objPPUM.getDbl_precioOferta()));
                modelo.addRow(filaTabla);
            }
        }

        tabla.setModel(modelo);
    }
    
    private boolean verificarProducto(String codigo, DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (codigo.equals(modelo.getValueAt(i, 0).toString())) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean txtPrecioOferta() {
        boolean respuesta = false;
        
        if (objPPUM != null) {
            BigDecimal precioOferta = BigDecimal.ZERO;

            try {
                precioOferta = new BigDecimal(txtPrecioOferta.getText());
                txtPrecioOferta.setText(Util.redondeo(precioOferta, 2));
                btnRegistrar.requestFocus();
                respuesta = true;
            } catch (NumberFormatException nfe) {
                log.error("Error nfe: " + nfe.getMessage());
                Mensaje.mensaje(this, "Ingresar sólo números", Mensaje.TITULO_ME, Mensaje.ERROR);
                txtPrecioOferta.selectAll();
                txtPrecioOferta.requestFocus();
                respuesta = false;
            } catch (Exception e) {
                log.error("Error e: " + e.getMessage());
                respuesta = false;
            }
        } else {
            Mensaje.mensaje(this, "Debe buscar un Producto", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
        
        return respuesta;
    }
    
    private void limpiar() {
        txtProducto.setText("");
        txtPrecioVenta.setText("");
        txtPrecioOferta.setText("");
        objPPUM = null;
        cargarDatos();
    }
}
