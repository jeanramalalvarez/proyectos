/*
 * RecepcionMercaderia.java
 *
 * Created on 04-jul-2012, 15:10:14
 */
package com.gestionmatriz.almacen.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jdesktop.swingx.JXTable;

import com.gestionmatriz.almacen.bean.Almacen;
import com.gestionmatriz.almacen.bean.OrdenCompra;
import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompraFacturaCompra;
import com.gestionmatriz.almacen.bean.TipoMovimiento;
import com.gestionmatriz.almacen.opciones.Opciones;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.FormatoFecha;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

/**
 *
 * @author jarcon
 */
public class RecepcionMercaderia extends javax.swing.JInternalFrame {

    private Principal gui;
    private List<Local> listaLocal;
    private List<ProveedorProductoOrdenCompraFacturaCompra> listaDetalleOC = new ArrayList<>();
    private List<Almacen> listaAlmacen = new ArrayList<>();
    private List<TipoMovimiento> listaTipoMovimiento = new ArrayList<>();
    private OrdenCompra objOrdenCompraI;
    private ConformidadCompra frmConformidadCompra;

    public RecepcionMercaderia(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
//        Util.setCentrarJInternalFrame(this);
//        this.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtNroOrdenCompra = new org.jdesktop.swingx.JXTextField();
        btnBuscarOrdenCompra = new org.jdesktop.swingx.JXButton();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtFechaEmision = new org.jdesktop.swingx.JXTextField();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        cboLocales = new org.jdesktop.swingx.JXComboBox();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        txtFechaRecepcion = new org.jdesktop.swingx.JXTextField();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        txtProveedor = new org.jdesktop.swingx.JXTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecepcion = new org.jdesktop.swingx.JXTable();
        btnRegistrar = new org.jdesktop.swingx.JXButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("RECEPCIÓN DE MERCADERÍA"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Recepción de Mercadería", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jXPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos de la orden de compra"));
        jXPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXLabel1.setText("Orden de Compra Nro :"); // NOI18N
        jXPanel2.add(jXLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, -1, -1));

        txtNroOrdenCompra.setEditable(false);
        jXPanel2.add(txtNroOrdenCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 160, -1));

        btnBuscarOrdenCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarOrdenCompra.setText("Buscar Orden"); // NOI18N
        btnBuscarOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarOrdenCompraActionPerformed(evt);
            }
        });
        jXPanel2.add(btnBuscarOrdenCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 136, 23));

        jXLabel2.setText("Emitida :"); // NOI18N
        jXPanel2.add(jXLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        txtFechaEmision.setEditable(false);
        jXPanel2.add(txtFechaEmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 170, -1));

        jXPanel1.add(jXPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, 840, 50));

        jXPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos de Recepción"));
        jXPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXLabel3.setText("Establecimiento :"); // NOI18N
        jXPanel3.add(jXLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 19, -1, -1));
        jXPanel3.add(cboLocales, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 16, 298, -1));

        jXLabel4.setText("Fecha Recepción :"); // NOI18N
        jXPanel3.add(jXLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 71, -1, -1));

        txtFechaRecepcion.setEditable(false);
        jXPanel3.add(txtFechaRecepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 68, 300, -1));

        jXLabel6.setText("Proveedor :"); // NOI18N
        jXPanel3.add(jXLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 45, 81, -1));

        txtProveedor.setEditable(false);
        jXPanel3.add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 42, 300, -1));

        tblRecepcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Fabricante", "Cantidad", "Cant. Recibida", "Recepción cerrada", "Número Factura", "Fecha Factura", "Cant. Restante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRecepcion.setColumnControlVisible(true);
        tblRecepcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRecepcionMouseClicked(evt);
            }
        });
        tblRecepcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblRecepcionKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblRecepcion);

        jXPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 106, 830, 240));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrar.setText("Registrar"); // NOI18N
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jXPanel3.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 155, -1));

        jXPanel1.add(jXPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 74, 840, 350));

        getContentPane().add(jXPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 435));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    listaAlmacen = new ArrayList<>();
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREGISTRARRECEPCIONMERCADERIA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (listaDetalleOC.isEmpty()) {
        Mensaje.mensaje(this, "No hay productos para confirmar - Buscar Orden de Compra", Mensaje.TITULO_ME, Mensaje.ERROR);
        btnBuscarOrdenCompra.requestFocus();
        return;
    }
    
    if (!verificarDatosTabla()) {
        Mensaje.mensaje(this, "Verificar datos en la tabla", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    int idLocalRecibido = cboLocales.getSelectedIndex();
    
    BigDecimal subStopIntro ;

    for (int i = 0; i < tblRecepcion.getRowCount(); i++) {
        subStopIntro = (new BigDecimal(tblRecepcion.getValueAt(i, 3).toString())).subtract(
        new BigDecimal(tblRecepcion.getValueAt(i, 8).toString()));
        if (new BigDecimal(tblRecepcion.getValueAt(i, 3).toString()).compareTo(
                 new BigDecimal(tblRecepcion.getValueAt(i, 4).toString()))==-1) {
            Mensaje.mensaje(this, "Cantidad Recibida debe ser menor o igual a la cantidad comprada", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        /*} else if (!(new BigDecimal(tblRecepcion.getValueAt(i, 8).toString()).compareTo(BigDecimal.ZERO)==1)){
            Mensaje.mensaje(this, "Cantidad Recibida debe ser menor o igual a la cantidad comprada", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;*/   
        } else if ((subStopIntro.compareTo(new BigDecimal(tblRecepcion.getValueAt(i, 4).toString()))==1) /*|| 
                (new BigDecimal(tblRecepcion.getValueAt(i, 4).toString())).compareTo(subStopIntro)==0*/){
            Mensaje.mensaje(this, "No se puede ingresar una cantidad menor a la ya existente", Mensaje.TITULO_ME, Mensaje.ERROR);
            return ;
        }
        else if ((new BigDecimal(tblRecepcion.getValueAt(i, 4).toString()).compareTo(BigDecimal.ZERO) == 1)
                && (tblRecepcion.getValueAt(i, 6) != null)
                && (tblRecepcion.getValueAt(i, 7) != null)) {
            if ((listaDetalleOC.get(i).getStr_estado().equals(Util.ACTIVO)) || (listaDetalleOC.get(i).getStr_estado().equals(Util.PENDIENTE))) {
                Almacen objAlmacen = new Almacen();
                Local objLocal = new Local();
                TipoMovimiento objTipoMovimiento = new TipoMovimiento();

                objAlmacen.setObjProveedor(listaDetalleOC.get(i).getObjProveedorProductoOrdenCompra().getObjProveedor());
                objAlmacen.setObjProducto(listaDetalleOC.get(i).getObjProveedorProductoOrdenCompra().getObjProducto());
                objLocal.setInt_idLocal(listaLocal.get(cboLocales.getSelectedIndex() - 1).getInt_idLocal());
                objAlmacen.setObjLocal(objLocal);
                for (TipoMovimiento objTM : listaTipoMovimiento) {
                    if (objTM.getInt_idTipoMovimiento() == Util.INGRESOXCOMPRA) {
                        objTipoMovimiento.setInt_idTipoMovimiento(Util.INGRESOXCOMPRA);
                    }
                }
                objAlmacen.setObjTipoMovimiento(objTipoMovimiento);
                objAlmacen.setStr_documento(tblRecepcion.getValueAt(i, 6).toString());
                objAlmacen.setDbl_cantidad(new BigDecimal(tblRecepcion.getValueAt(i, 4).toString()));
                objAlmacen.setStr_fechaDocumento(tblRecepcion.getValueAt(i, 7).toString());
                objAlmacen.setStr_estado(Util.ACTIVO);
                objAlmacen.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());

                listaAlmacen.add(objAlmacen);
            }
            
            listaDetalleOC.get(i).setDbl_cantidadRecibida(new BigDecimal(tblRecepcion.getValueAt(i, 4).toString()));
            listaDetalleOC.get(i).setStr_numeroFactura(tblRecepcion.getValueAt(i, 6).toString());
            listaDetalleOC.get(i).setInt_idLocalRecibido(idLocalRecibido);
//            listaDetalleOC.get(i).setStr_fechaDocumento(Util.getFecha("yyyy-MM-dd", Util.StringTODate(tblRecepcion.getValueAt(i, 7).toString())));
            listaDetalleOC.get(i).setStr_fechaDocumento(tblRecepcion.getValueAt(i, 7).toString());
            
            if (new BigDecimal(tblRecepcion.getValueAt(i, 3).toString()).compareTo(new BigDecimal(tblRecepcion.getValueAt(i, 4).toString()))==1) {
                listaDetalleOC.get(i).setStr_estado(Util.PENDIENTE);
            } else if (new BigDecimal(tblRecepcion.getValueAt(i, 3).toString()).compareTo(new BigDecimal(tblRecepcion.getValueAt(i, 4).toString()))
                == 0) {
                listaDetalleOC.get(i).setStr_estado(Util.CERRADO);
            }
            
            listaDetalleOC.get(i).setStr_usuarioModificador(gui.getBarraEstado().getUsuario());
        } else {
            listaDetalleOC.get(i).setDbl_cantidadRecibida(BigDecimal.ZERO);
            listaDetalleOC.get(i).setStr_numeroFactura("");
            listaDetalleOC.get(i).setStr_estado(Util.ACTIVO);
            listaDetalleOC.get(i).setStr_usuarioModificador(gui.getBarraEstado().getUsuario());
        }
    }
    
    objOrdenCompraI.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());

    if (PaqueteBusinessDelegate.getRecepcionMercaderiaService().
            registrarRecepcionMercaderia(listaDetalleOC, objOrdenCompraI)) {
        Mensaje.mensaje(this, "Mercadería recepcionada correctamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        cargarTabla(tblRecepcion, listaDetalleOC);
        
        if (PaqueteBusinessDelegate.getAlmacenService().registrarAlmacen(listaAlmacen)) {
            Mensaje.mensaje(this, "Ingreso a Almacén correcto", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        } else {
            Mensaje.mensaje(this, "Error al ingresar producto(s) a Almacén", Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    } else {
        Mensaje.mensaje(this, "Error en recepcion de mercadería", Mensaje.TITULO_ME, Mensaje.ERROR);
    }
}//GEN-LAST:event_btnRegistrarActionPerformed
/**/
    private void tblRecepcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblRecepcionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            for (int i = 0; i < tblRecepcion.getRowCount(); i++) {
                if (tblRecepcion.getValueAt(i, 7) == null) {
                    //                    Mensaje.mensaje(this, "Ingresar fecha con formato: dd-MM-yyyy", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                } else {

                }
            }
        }
    }//GEN-LAST:event_tblRecepcionKeyPressed

    private void tblRecepcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRecepcionMouseClicked
        tblRecepcion.setValueAt(txtFechaRecepcion.getText(), tblRecepcion.getSelectedRow(), 7);
    }//GEN-LAST:event_tblRecepcionMouseClicked

    private void btnBuscarOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarOrdenCompraActionPerformed
        try {
            List<OrdenCompra> listaOrdenCompra = PaqueteBusinessDelegate.getOrdenCompraService().
            buscarOrdenCompra("", "", "", "", "");

            if (listaOrdenCompra.isEmpty()) {
                Mensaje.mensaje(this, "No existe Orden de Compra: ", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            } else if (listaOrdenCompra.size() == 1) {
                cargarDatosBusquedaOrdenCompra(listaOrdenCompra.get(0));
            } else if (listaOrdenCompra.size() > 1) {
                Util.hiloProgressBar(1, gui);
                BuscarOrdenCompra frmBuscarOrdenCompra = new BuscarOrdenCompra(gui, listaOrdenCompra, this, 1);
                Util.hiloProgressBar(0, gui);
                frmBuscarOrdenCompra.cargarPanelBusquedaOrdenCompra(listaOrdenCompra);
                frmBuscarOrdenCompra.setVisible(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(RecepcionMercaderia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarOrdenCompraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscarOrdenCompra;
    private org.jdesktop.swingx.JXButton btnRegistrar;
    private org.jdesktop.swingx.JXComboBox cboLocales;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXTable tblRecepcion;
    private org.jdesktop.swingx.JXTextField txtFechaEmision;
    private org.jdesktop.swingx.JXTextField txtFechaRecepcion;
    private org.jdesktop.swingx.JXTextField txtNroOrdenCompra;
    private org.jdesktop.swingx.JXTextField txtProveedor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
        listaDetalleOC = new ArrayList<>();
        listaAlmacen = new ArrayList<>();
        objOrdenCompraI = new OrdenCompra();
    }
    
    private void cargarDatos() {
        cargarCombo();
        cboLocales.setEnabled(false);
        txtFechaRecepcion.setText(PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql().substring(0, 10));
//        cargarFecha();
        listaTipoMovimiento = PaqueteBusinessDelegate.getRecepcionMercaderiaService().listarTipoMovimiento();
        tblRecepcion.setSortable(false);
    }

    private void cargarCombo() {
        listaLocal = PaqueteBusinessDelegate.getOrdenCompraService().buscarLocal("%%");
        cboLocales.removeAllItems();
        cboLocales.addItem(".::Seleccionar Almacén::.");
        
        for (Local local : listaLocal) {
            cboLocales.addItem(local.getObjEmpresa().getStr_razonSocial() + " - " + local.getStr_nombre());
        }
    }

    private void cargarTabla(JXTable tabla, List lista) {
        Object[] filaTabla = new Object[9];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int i = 0;

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (Object a : lista) {
            if (a instanceof ProveedorProductoOrdenCompraFacturaCompra) {
                boolean b = ((((ProveedorProductoOrdenCompraFacturaCompra) a).getStr_estado().equals("CERRADO")) ? true : false);
                filaTabla[0] = ((ProveedorProductoOrdenCompraFacturaCompra) a).getObjProveedorProductoOrdenCompra().getObjProducto().getStr_codigoInterno();
                filaTabla[1] = ((ProveedorProductoOrdenCompraFacturaCompra) a).getObjProveedorProductoOrdenCompra().getObjProducto().getStr_nombreProducto();
                filaTabla[2] = ((ProveedorProductoOrdenCompraFacturaCompra) a).getObjProveedorProductoOrdenCompra().getObjProducto().getStr_fabricante();
                filaTabla[3] = ((ProveedorProductoOrdenCompraFacturaCompra) a).getObjProveedorProductoOrdenCompra().getDbl_cantidad();
                filaTabla[4] = ((ProveedorProductoOrdenCompraFacturaCompra) a).getDbl_cantidadRecibida();
                filaTabla[5] = b;
                filaTabla[6] = ((ProveedorProductoOrdenCompraFacturaCompra) a).getStr_numeroFactura();
                filaTabla[7] = ((ProveedorProductoOrdenCompraFacturaCompra) a).getStr_fechaDocumento();
                filaTabla[8] = new BigDecimal(filaTabla[3].toString()).subtract(filaTabla[4]!=null?new BigDecimal(filaTabla[4].toString()):BigDecimal.ZERO);
                modelo.addRow(filaTabla);
            }
            i++;
        }

        tabla.setModel(modelo);
    }

    protected void cargarDatosBusquedaOrdenCompra(OrdenCompra objOrdenCompra) {
        txtNroOrdenCompra.setText(objOrdenCompra.getStr_numeroOC());
        txtFechaEmision.setText(objOrdenCompra.getStr_fechaValidez());
        txtProveedor.setText(objOrdenCompra.getObjProveedor().getStr_razonSocial()
                + " - " + objOrdenCompra.getObjProveedor().getStr_ruc());
        
        listaDetalleOC = PaqueteBusinessDelegate.getRecepcionMercaderiaService().
                listarPPOCFC(objOrdenCompra.getInt_idOrdenCompra());
        cargarTabla(tblRecepcion, listaDetalleOC);
        
        cboLocales.setSelectedIndex(listaDetalleOC.get(0).getInt_idLocalRecibido());
        
        if (objOrdenCompra.getStr_estado().equals(Util.CERRADO)) {
            btnRegistrar.setEnabled(false);
        } else {
            btnRegistrar.setEnabled(true);
        }
        
        objOrdenCompraI = objOrdenCompra;
    }
    
    private void cargarFecha() {
//        String fechaServidor = (PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql()).substring(0, 10);
//        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
//        Date fecha = null;
//
//        try {
//            fecha = formatoDelTexto.parse(fechaServidor);
//        } catch (ParseException ex) {
//            System.out.println("Excepcion: " + ex.getMessage());
//        }
//
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        Calendar c1 = Calendar.getInstance();
//        c1.setTime(fecha);
//
////        int dias = Integer.parseInt(tblLetras.getValueAt(i, 3).toString());
//        c1.add(Calendar.DATE, 0);
//        tblRecepcion.setValueAt(formato.format(c1.getTime()), 0, 7);
        
        try {
            TableColumn estadoColumna = tblRecepcion.getColumnModel().getColumn(7);
            FormatoFecha ff = new FormatoFecha();
            JFormattedTextField textField = new JFormattedTextField(ff);
            textField.setValue(new Date());
            
//            textField.setValue(Util.StringTODate(PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql()));
            estadoColumna.setCellEditor(new DefaultCellEditor(textField));
        } catch (ParseException ex) {
            Logger.getLogger(RecepcionMercaderia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean verificarDatosTabla() {
        for (int i = 0; i < tblRecepcion.getRowCount(); i++) {
            if (tblRecepcion.getValueAt(i, 4)==null || new BigDecimal(tblRecepcion.getValueAt(i, 4).toString()).compareTo(BigDecimal.ZERO) < 0
                    || tblRecepcion.getValueAt(i, 6) == null || tblRecepcion.getValueAt(i, 6).toString().trim().equals("")
                    || tblRecepcion.getValueAt(i, 7) == null || tblRecepcion.getValueAt(i, 7).toString().trim().equals("")) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean verificarFecha(String valor) {
        if (valor.equals("")) {
            
        } else {
            
        }
        
        return false;
    }
}
