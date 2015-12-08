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

import com.gestionmatriz.almacen.bean.Almacen;
import com.gestionmatriz.almacen.bean.TipoMovimiento;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.Caja;
import com.gestionmatriz.puntoventa.bean.FlujoCaja;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.recursoshumanos.bean.Config;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

/**
 *
 * @author cesareo
 */
public class AnularBolFac extends javax.swing.JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal gui;
    private List<Ventas> listaVenta = new ArrayList<>();

    public AnularBolFac(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        btnAnular = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalleDoc = new org.jdesktop.swingx.JXTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("ANULAR DOCUMENTOS DE VENTA");

        pnl1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Numero documento:");

        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyPressed(evt);
            }
        });

        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblDetalleDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vendedor", "Producto", "Cantidad", "Precio", "Descuento", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.math.BigDecimal.class, java.math.BigDecimal.class, java.math.BigDecimal.class, java.math.BigDecimal.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalleDoc.setColumnControlVisible(true);
        jScrollPane2.setViewportView(tblDetalleDoc);

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(0, 341, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscar();
        }
    }//GEN-LAST:event_txtDocumentoKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getANULAR_DOCUMENTOVENTA())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        if (!listaVenta.isEmpty()) {
            List<Caja> listaCaja = new ArrayList<>();
            listaCaja = PaqueteBusinessDelegate.getFlujoCajaService().getCaja(gui.getLocal().getInt_idLocal(), gui.getBarraEstado().getUsuario());

            if (listaCaja.isEmpty()) {
                Mensaje.mensaje(this, "Debe Aperturar Caja", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                return;
            }

            Object objConfirmacion = Mensaje.confirmar(this, "Se anulara el documento",
                    "Mensaje Confirmación", Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);
            if (objConfirmacion.equals(Mensaje.YES_OPTION)) {
                FlujoCaja objFC = new FlujoCaja();
                objFC.setObjLocal(gui.getLocal());
                objFC.setObjCaja(listaCaja.get(0));
                objFC.setDbl_cantidadSoles(cantidadPrecio(listaVenta));
                objFC.setDbl_cantidadTotalSoles(cantidadPrecio(listaVenta));
                objFC.setStr_motivo(Util.VENTACAJA);
                objFC.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());
                if (this.gui.getListaConfig().get(0).getTipoImpresion().equals(Config.TICKETERA)){
                    objFC.setStr_numeroSerie(PaqueteBusinessDelegate.getFlujoCajaService().
                            getNumeroSerieImpresora(this.gui.getLocal().getInt_idLocal()));
                }else{
                    objFC.setStr_numeroSerie("");
                }
                
                
//                System.out.println("nro docuemnto---"+listaVenta.get(0).getStr_numeroDocumento());
                objFC.setStr_nroDocumento(listaVenta.get(0).getStr_numeroDocumento());
                

                if (PaqueteBusinessDelegate.getVentasService().anularDocVenta(listaVenta.get(0), objFC, productoAlmacen())) {
                    Mensaje.mensaje(this, "Documento anulado", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                    limpiarDatos();
                } else {
                    Mensaje.mensaje(this, "Error al anular documento", Mensaje.TITULO_ME, Mensaje.ERROR);
                }
            }
        }
    }//GEN-LAST:event_btnAnularActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnl1;
    private org.jdesktop.swingx.JXTable tblDetalleDoc;
    private javax.swing.JTextField txtDocumento;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
        tblDetalleDoc.setSortable(false);
        this.setTitle(gui.getTitle().concat("Modulo: [Anular Documentos de Venta]"));
    }

    private void buscar() {
        listaVenta = PaqueteBusinessDelegate.getFlujoCajaService().listarVentaAnular(txtDocumento.getText().trim());
        cargarTabla(listaVenta);
        btnAnular.requestFocus();
    }

    private void cargarTabla(List<Ventas> lista) {
        Object[] filaTabla = new Object[6];
        DefaultTableModel modelo = (DefaultTableModel) tblDetalleDoc.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (Ventas objV : lista) {
            filaTabla[0] = objV.getStr_usuario();
            filaTabla[1] = objV.getObjProducto().getStr_nombreProducto();
            filaTabla[2] = (objV.getDbCantidad().multiply(objV.getDbUnidadesContenidas()));
            filaTabla[3] = objV.getDbPrecio();
            filaTabla[4] = objV.getDbdescuento();
            filaTabla[5] = objV.getDbTotal();
            modelo.addRow(filaTabla);
        }

        tblDetalleDoc.setModel(modelo);
    }

    private void limpiarDatos() {
        txtDocumento.setText("");
        txtDocumento.requestFocus();

        DefaultTableModel modelo = (DefaultTableModel) tblDetalleDoc.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    private BigDecimal cantidadPrecio(List<Ventas> lista) {
        BigDecimal cantidad = BigDecimal.ZERO;

        for (Ventas ventas : lista) {
            cantidad =cantidad.add(ventas.getDbTotal()) ;
        }

        cantidad = cantidad.multiply(new BigDecimal(-1)) ;
        return cantidad;
    }

    private List<Almacen> productoAlmacen() {
        List<Almacen> lista = new ArrayList<>();
        Almacen objAlmacen = null;
        TipoMovimiento objTM = new TipoMovimiento();
        objTM.setInt_idTipoMovimiento(Util.INGRESOXDEVOLUCION);

        for (Ventas ventas : listaVenta) {
            objAlmacen = new Almacen();
            objAlmacen.setObjProveedor(ventas.getObjProveedor());
            objAlmacen.setObjProducto(ventas.getObjProducto());
            objAlmacen.setObjLocal(ventas.getObjLocal());
            objAlmacen.setObjTipoMovimiento(objTM);
            objAlmacen.setStr_documento(txtDocumento.getText().trim());
            objAlmacen.setDbl_cantidad(ventas.getDbCantidad());
            objAlmacen.setDbl_precio(ventas.getDbPrecio());
            objAlmacen.setDbl_igv(ventas.getDbIGV());
            objAlmacen.setDbl_subTotal(ventas.getDbSubtotal());
            objAlmacen.setDbl_descuento(ventas.getDbdescuento());
//            objAlmacen.setStr_fechaDocumento(Util.getFecha("yyyy-MM-dd", null));
            objAlmacen.setStr_estado(Util.ACTIVO);
            objAlmacen.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());

            lista.add(objAlmacen);
        }

        return lista;
    }
}
