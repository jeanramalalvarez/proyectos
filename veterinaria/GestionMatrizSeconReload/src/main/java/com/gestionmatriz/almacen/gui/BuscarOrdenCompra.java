/*
 * BuscarOrdenCompra.java
 *
 * Created on 23-abr-2012, 18:04:51
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.almacen.bean.OrdenCompra;
import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.bean.TipoObligacion;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.util.Util;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXComboBox;

/**
 *
 * @author YESM
 */
public class BuscarOrdenCompra extends javax.swing.JDialog {

	private static final Logger log=Logger.getLogger(BuscarOrdenCompra.class);
    private Principal gui;
    private Empresa objEmpresa;
    private List<OrdenCompra> listaOrdenCompra = new ArrayList<>();
    private List<Proveedor> listaProveedores;
    private List<Local> listaLocal;
    private List<TipoObligacion> listaTipoObligacion;
    private com.gestionmatriz.almacen.gui.OrdenCompra frmOrdenCompra;
    private com.gestionmatriz.almacen.gui.RecepcionMercaderia frmRecepcionMercaderia;
    private com.gestionmatriz.almacen.gui.ConformidadCompra frmConformidadCompra;
    private int puntero;

    public BuscarOrdenCompra(Principal gui, List<OrdenCompra> listaOrdenCompra, Empresa objE, com.gestionmatriz.almacen.gui.OrdenCompra frmOrdenCompra) {
        super(gui, true);
        this.gui = gui;
        this.objEmpresa = objE;
        this.listaOrdenCompra = listaOrdenCompra;
        this.frmOrdenCompra = frmOrdenCompra;
        initComponents();
        cargarDatos();
    }

    public BuscarOrdenCompra(Principal gui, List<OrdenCompra> listaOrdenCompra, RecepcionMercaderia frmRecepcionMercaderia, int puntero) {
        super(gui, true);
        this.gui = gui;
        this.listaOrdenCompra = listaOrdenCompra;
        this.frmRecepcionMercaderia = frmRecepcionMercaderia;
        this.puntero = puntero;
        initComponents();
        cargarDatos();

    }

    public BuscarOrdenCompra(Principal gui, List<OrdenCompra> listaOrdenCompra, com.gestionmatriz.almacen.gui.ConformidadCompra frmConformidadCompra, int puntero) {
        super(gui, true);
        this.gui = gui;
        this.listaOrdenCompra = listaOrdenCompra;
        this.frmConformidadCompra = frmConformidadCompra;
        this.puntero = puntero;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFiltro = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtNumeroOrdenCompra = new org.jdesktop.swingx.JXTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        cboProveedor = new org.jdesktop.swingx.JXComboBox();
        cboTransportista = new org.jdesktop.swingx.JXComboBox();
        cboViaTransporte = new org.jdesktop.swingx.JXComboBox();
        cboCondicionPago = new org.jdesktop.swingx.JXComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaOrdenCompra = new org.jdesktop.swingx.JXTable();
        btnSalir = new org.jdesktop.swingx.JXButton();
        btnBuscar = new org.jdesktop.swingx.JXButton();

        setResizable(false);

        pnlFiltro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jXLabel1.setText("Nro Orden Compra:");

        txtNumeroOrdenCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroOrdenCompraKeyPressed(evt);
            }
        });

        jXLabel2.setText("Proveedor:");

        jXLabel3.setText("Transportista:");

        jXLabel5.setText("Via Transporte:");

        jXLabel6.setText("Condicion Pago:");

        javax.swing.GroupLayout pnlFiltroLayout = new javax.swing.GroupLayout(pnlFiltro);
        pnlFiltro.setLayout(pnlFiltroLayout);
        pnlFiltroLayout.setHorizontalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jXLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                        .addComponent(jXLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTransportista, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboCondicionPago, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboViaTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlFiltroLayout.setVerticalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFiltroLayout.createSequentialGroup()
                        .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboViaTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboCondicionPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFiltroLayout.createSequentialGroup()
                        .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTransportista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbListaOrdenCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Proveedor", "Transportista", "Almacen", "Via Transporte", "Condicion pago", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbListaOrdenCompra.setColumnControlVisible(true);
        tbListaOrdenCompra.setEditable(false);
        tbListaOrdenCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListaOrdenCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListaOrdenCompra);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/salirmini.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setPreferredSize(new java.awt.Dimension(77, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    this.setVisible(false);
}//GEN-LAST:event_btnSalirActionPerformed

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    buscarOrdenCompra();
    
    //    listaOrdenCompra = new ArrayList<>();
//
//    try {
//        String numeroOC = txtNumeroOrdenCompra.getText().toUpperCase().trim();
//        String proveedor;
//        String transportista;
//        String viaTransporte;
//        String condicionPago;
//
//        if ((cboProveedor.getSelectedIndex() - 1) == -1) {
//            proveedor = "";
//        } else {
//            proveedor = "" + listaProveedores.get(cboProveedor.getSelectedIndex() - 1).getInt_idProveedor();
//        }
//
//        if ((cboTransportista.getSelectedIndex() - 1) == -1) {
//            transportista = "";
//        } else {
//            transportista = "" + listaProveedores.get(cboTransportista.getSelectedIndex() - 1).getInt_idProveedor();
//        }
//
//        if ((cboViaTransporte.getSelectedIndex() - 1) == -1) {
//            viaTransporte = "";
//        } else {
//            viaTransporte = "" + cboViaTransporte.getSelectedItem();
//        }
//
//        if ((cboCondicionPago.getSelectedIndex() - 1) == -1) {
//            condicionPago = "";
//        } else {
//            condicionPago = "" + cboCondicionPago.getSelectedIndex();
//        }
//
//        if (puntero == 1) {
//            listaOrdenCompra = PaqueteBusinessDelegate.getOrdenCompraService().
//                    buscarOrdenCompra(numeroOC, proveedor, transportista, viaTransporte, condicionPago);
//        } else {
//            List<OrdenCompra> listaOrdenCompraTemp = new ArrayList<>();
//            listaOrdenCompraTemp = PaqueteBusinessDelegate.getOrdenCompraService().
//                    buscarOrdenCompra(numeroOC, proveedor, transportista, viaTransporte, condicionPago);
//
//            if (puntero == 2) {
//                for (OrdenCompra objOCTemp : listaOrdenCompraTemp) {
//                    if (objOCTemp.getStr_estado().equals(Util.PENDIENTE) || objOCTemp.getStr_estado().equals(Util.CERRADO)) {
//                        listaOrdenCompra.add(objOCTemp);
//                    }
//                }
//            } else {
//                for (OrdenCompra objOCTemp : listaOrdenCompraTemp) {
//                    if (objOCTemp.getStr_estado().equals(Util.ACTIVO)) {
//                        listaOrdenCompra.add(objOCTemp);
//                    }
//                }
//            }
//
//        }
//
//        cargarTabla(listaOrdenCompra);
//    } catch (Exception ex) {
//        log.error("Error en Busqueda: " + ex.getMessage());
//    }
}//GEN-LAST:event_btnBuscarActionPerformed

public void buscarOrdenCompra(){
    listaOrdenCompra = new ArrayList<>();

    try {
        String numeroOC = txtNumeroOrdenCompra.getText().toUpperCase().trim();
        String proveedor;
        String transportista;
        String viaTransporte;
        String condicionPago;

        if ((cboProveedor.getSelectedIndex() - 1) == -1) {
            proveedor = "";
        } else {
            proveedor = "" + listaProveedores.get(cboProveedor.getSelectedIndex() - 1).getInt_idProveedor();
        }

        if ((cboTransportista.getSelectedIndex() - 1) == -1) {
            transportista = "";
        } else {
            transportista = "" + listaProveedores.get(cboTransportista.getSelectedIndex() - 1).getInt_idProveedor();
        }

        if ((cboViaTransporte.getSelectedIndex() - 1) == -1) {
            viaTransporte = "";
        } else {
            viaTransporte = "" + cboViaTransporte.getSelectedItem();
        }

        if ((cboCondicionPago.getSelectedIndex() - 1) == -1) {
            condicionPago = "";
        } else {
            condicionPago = "" + cboCondicionPago.getSelectedIndex();
        }

        if (puntero == 1) {
            listaOrdenCompra = PaqueteBusinessDelegate.getOrdenCompraService().
                    buscarOrdenCompra(numeroOC, proveedor, transportista, viaTransporte, condicionPago);
        } else {
            List<OrdenCompra> listaOrdenCompraTemp = new ArrayList<>();
            listaOrdenCompraTemp = PaqueteBusinessDelegate.getOrdenCompraService().
                    buscarOrdenCompra(numeroOC, proveedor, transportista, viaTransporte, condicionPago);

            if (puntero == 2) {
                for (OrdenCompra objOCTemp : listaOrdenCompraTemp) {
                    if (objOCTemp.getStr_estado().equals(Util.PENDIENTE) || objOCTemp.getStr_estado().equals(Util.CERRADO)) {
                        listaOrdenCompra.add(objOCTemp);
                    }
                }
            } else {
                for (OrdenCompra objOCTemp : listaOrdenCompraTemp) {
                    if (objOCTemp.getStr_estado().equals(Util.ACTIVO)) {
                        listaOrdenCompra.add(objOCTemp);
                    }
                }
            }

        }

        cargarTabla(listaOrdenCompra);
    } catch (Exception ex) {
        log.error("Error en Busqueda: " + ex.getMessage());
    }

}
private void tbListaOrdenCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListaOrdenCompraMouseClicked
    if (puntero == 1) {
        frmRecepcionMercaderia.cargarDatosBusquedaOrdenCompra(ordenCompraSeleccionado());
        this.setVisible(false);
    } else if (puntero == 2) {
        frmConformidadCompra.cargarDatosBusquedaOrdenCompra(ordenCompraSeleccionado());
        this.setVisible(false);
    } else {
        frmOrdenCompra.cargarDatosBusquedaOrdenCompra(ordenCompraSeleccionado());
        this.setVisible(false);
    }
}//GEN-LAST:event_tbListaOrdenCompraMouseClicked

private void txtNumeroOrdenCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroOrdenCompraKeyPressed
   
    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        buscarOrdenCompra();
    }
    
}//GEN-LAST:event_txtNumeroOrdenCompraKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscar;
    private org.jdesktop.swingx.JXButton btnSalir;
    private org.jdesktop.swingx.JXComboBox cboCondicionPago;
    private org.jdesktop.swingx.JXComboBox cboProveedor;
    private org.jdesktop.swingx.JXComboBox cboTransportista;
    private org.jdesktop.swingx.JXComboBox cboViaTransporte;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXPanel pnlFiltro;
    private org.jdesktop.swingx.JXTable tbListaOrdenCompra;
    private org.jdesktop.swingx.JXTextField txtNumeroOrdenCompra;
    // End of variables declaration//GEN-END:variables

    public void setVisible(boolean b) {
        super.setVisible(b);
    }

    private void cargarDatos() {
        tbListaOrdenCompra.setSortable(false);
        this.setTitle(gui.getTitle() + " - Buscar Orden de Compra");
        this.setSize(635, 450);
        cargarProveedorTransportista(cboProveedor, 1);
        cargarProveedorTransportista(cboTransportista, 2);
        viaTransporte(cboViaTransporte);
        condicionPago(cboCondicionPago);
        this.setSize(800, 500);
        setLocationRelativeTo(null);
    }

    private void cargarProveedorTransportista(JXComboBox cbo, int i) {
        listaProveedores = PaqueteBusinessDelegate.getProveedorService().buscarProveedor("%%", "%%");
        cbo.removeAllItems();

        if (i == 1) {
            cbo.addItem(".::Seleccionar Proveedor::.");
        } else if (i == 2) {
            cbo.addItem(".::Seleccionar Transportista::.");
        }

        for (Proveedor objP : listaProveedores) {
            cbo.addItem(objP.getStr_razonSocial());
        }
    }

    protected OrdenCompra ordenCompraSeleccionado() {
        int indice = tbListaOrdenCompra.getSelectedRow();
        return listaOrdenCompra.get(indice);
    }

    private void cargarTabla(List<OrdenCompra> listaOC) {
        Object[] filaTabla = new Object[7];
        DefaultTableModel modelo = (DefaultTableModel) tbListaOrdenCompra.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (OrdenCompra OC : listaOC) {
            filaTabla[0] = OC.getStr_numeroOC();
            filaTabla[1] = OC.getObjProveedor().getStr_razonSocial();
            filaTabla[2] = OC.getObjTransportista().getStr_razonSocial();
            filaTabla[3] = OC.getObjLocal().getStr_nombre();
            filaTabla[4] = OC.getStr_viaTransporte();
            filaTabla[5] = OC.getObjTipoObligacion().getStr_nombreTO();
            filaTabla[6] = OC.getStr_estado();
            modelo.addRow(filaTabla);
        }

        tbListaOrdenCompra.setModel(modelo);
    }

    protected void cargarPanelBusquedaOrdenCompra(List<OrdenCompra> listaOC) {
        cargarTabla(listaOC);
    }

    private void viaTransporte(JXComboBox cbo) {
        cbo.removeAllItems();
        cbo.addItem(".::Seleccionar una Vía de Transporte::.");
        cbo.addItem("FLUVIAL");
        cbo.addItem("AÉREO");
        cbo.addItem("TERRESTRE");
    }

    private void condicionPago(JXComboBox cbo) {
        listaTipoObligacion = PaqueteBusinessDelegate.getOrdenCompraService().buscarTipoObligacion();
        cbo.removeAllItems();
        cbo.addItem(".::Seleccionar Condición de Pago::.");

        for (TipoObligacion objTO : listaTipoObligacion) {
            cbo.addItem(objTO.getStr_nombreTO());
        }
    }
}
