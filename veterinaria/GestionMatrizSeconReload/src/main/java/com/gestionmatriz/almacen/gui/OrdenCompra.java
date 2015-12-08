/*
 * OrdenCompra.java
 *
 * Created on 07-jun-2012, 11:08:46
 */
package com.gestionmatriz.almacen.gui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXComboBox;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXTable;

import com.gestionmatriz.almacen.bean.CronogramaPagos;
import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompra;
import com.gestionmatriz.almacen.bean.TipoObligacion;
import com.gestionmatriz.almacen.opciones.Opciones;
import com.gestionmatriz.almacen.reportes.Ireport;
import com.gestionmatriz.config.bean.Otros;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import java.beans.PropertyVetoException;

/**
 *
 * @author zholo
 */
public class OrdenCompra extends javax.swing.JInternalFrame {

    /**
	 * 
	 */
	private static final Logger log=Logger.getLogger(GestionPrecioOferta.class);
	private static final long serialVersionUID = 1L;
	private Principal gui;
    private Empresa objEmpresa;
    private String NOC;
    private List<Local> listaLocal;
    private List<TipoObligacion> listaTipoObligacion;
    private com.gestionmatriz.almacen.bean.OrdenCompra objOrdenCompra;
    private com.gestionmatriz.almacen.bean.OrdenCompra objOrdenCompraNuevo;
    private Proveedor objProveedor;
    private Proveedor objTransportista;
    private OrdenCompraProvProd frmOrdenCompraProvProd;
    protected static List<ProveedorProductoOrdenCompra> listaProveedorProductoOrdenCompra = new ArrayList<>();
    private Otros objOtros;
    private String NumeroOrdenCompra;
    private List<CronogramaPagos> listaCronogramaPagos = new ArrayList<>();
    private int reprogramarLetras = 0;
    private String fechaServidor = "";
    private BigDecimal dbl_igv=PaqueteBusinessDelegate.getConfigBDService().getIGV(); 
//    private boolean buscarOCCondicionPago = false;

    public OrdenCompra(Principal gui, Empresa objEmpresa, String NOC) {
        this.gui = gui;
        this.objEmpresa = objEmpresa;
        this.NOC = NOC;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pupLimpiarProveedor = new javax.swing.JPopupMenu();
        mnuItemLimpiarProveedor = new javax.swing.JMenuItem();
        pupLimpiarTransportista = new javax.swing.JPopupMenu();
        mnuItemLimpiarTransportista = new javax.swing.JMenuItem();
        pupLimpiarAlmacen = new javax.swing.JPopupMenu();
        mnuItemLimpiarAlmacen = new javax.swing.JMenuItem();
        bgOperacion = new javax.swing.ButtonGroup();
        pupLimpiarTodo = new javax.swing.JPopupMenu();
        mnuItemLimpiarTodo = new javax.swing.JMenuItem();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        lblNombreEmpresa = new org.jdesktop.swingx.JXLabel();
        lblRucEmpresa = new org.jdesktop.swingx.JXLabel();
        lblLogoEmpresa = new org.jdesktop.swingx.JXLabel();
        lblOrdenCompra = new org.jdesktop.swingx.JXLabel();
        txtNumeroOrdenCompra = new org.jdesktop.swingx.JXTextField();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        txtProveedorRazonSocial = new org.jdesktop.swingx.JXTextField();
        btnBuscarProveedor = new org.jdesktop.swingx.JXButton();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        txtProveedorRuc = new org.jdesktop.swingx.JXTextField();
        txtProveedorDireccion = new org.jdesktop.swingx.JXTextField();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        txtProveedorTelefono = new org.jdesktop.swingx.JXTextField();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        txtTransportistaRazonSocial = new org.jdesktop.swingx.JXTextField();
        btnBuscarTransportista = new org.jdesktop.swingx.JXButton();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        txtTransportistaRuc = new org.jdesktop.swingx.JXTextField();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        txtTransportistaDireccion = new org.jdesktop.swingx.JXTextField();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        txtTransportistaTelefono = new org.jdesktop.swingx.JXTextField();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        cboTransportistaViaTransp = new org.jdesktop.swingx.JXComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jXLabel20 = new org.jdesktop.swingx.JXLabel();
        txtPrecioBruto = new org.jdesktop.swingx.JXTextField();
        jXLabel21 = new org.jdesktop.swingx.JXLabel();
        txtPrecioTotal = new org.jdesktop.swingx.JXTextField();
        jXLabel22 = new org.jdesktop.swingx.JXLabel();
        txtDsctoTotal = new org.jdesktop.swingx.JXTextField();
        jXLabel23 = new org.jdesktop.swingx.JXLabel();
        txtValorVenta = new org.jdesktop.swingx.JXTextField();
        jXLabel24 = new org.jdesktop.swingx.JXLabel();
        txtIGVRecuperado = new org.jdesktop.swingx.JXTextField();
        jXLabel25 = new org.jdesktop.swingx.JXLabel();
        txtPeso = new org.jdesktop.swingx.JXTextField();
        btnBuscarProd = new org.jdesktop.swingx.JXButton();
        btnEliminarProd = new org.jdesktop.swingx.JXButton();
        lblIGV = new org.jdesktop.swingx.JXLabel();
        txtIGV = new org.jdesktop.swingx.JXTextField();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        rbnDolar = new javax.swing.JRadioButton();
        rbnNuevoSol = new javax.swing.JRadioButton();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        jXLabel14 = new org.jdesktop.swingx.JXLabel();
        cboAlmacen = new org.jdesktop.swingx.JXComboBox();
        jXLabel15 = new org.jdesktop.swingx.JXLabel();
        txtDireccionAlmacen = new org.jdesktop.swingx.JXTextField();
        jXLabel16 = new org.jdesktop.swingx.JXLabel();
        txtTelefonoAlmacen = new org.jdesktop.swingx.JXTextField();
        jXLabel17 = new org.jdesktop.swingx.JXLabel();
        cboCondPagoAlmacen = new org.jdesktop.swingx.JXComboBox();
        jXLabel18 = new org.jdesktop.swingx.JXLabel();
        dtp_fechaEntrega = new org.jdesktop.swingx.JXDatePicker();
        jXLabel19 = new org.jdesktop.swingx.JXLabel();
        dtp_fechaValidez = new org.jdesktop.swingx.JXDatePicker();
        pnlOpciones = new org.jdesktop.swingx.JXPanel();
        btnRegistrarOrdenCompra = new org.jdesktop.swingx.JXButton();
        btnBuscarOrdenCompra = new org.jdesktop.swingx.JXButton();
        btnModificarOrdenCompra = new org.jdesktop.swingx.JXButton();
        btnImprimir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        mnuItemLimpiarProveedor.setText("Limpiar datos Proveedor"); // NOI18N
        mnuItemLimpiarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemLimpiarProveedorActionPerformed(evt);
            }
        });
        pupLimpiarProveedor.add(mnuItemLimpiarProveedor);

        mnuItemLimpiarTransportista.setText("Limpiar datos Transportista"); // NOI18N
        mnuItemLimpiarTransportista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemLimpiarTransportistaActionPerformed(evt);
            }
        });
        pupLimpiarTransportista.add(mnuItemLimpiarTransportista);

        mnuItemLimpiarAlmacen.setText("Limpiar datos Almacen"); // NOI18N
        mnuItemLimpiarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemLimpiarAlmacenActionPerformed(evt);
            }
        });
        pupLimpiarAlmacen.add(mnuItemLimpiarAlmacen);

        mnuItemLimpiarTodo.setText("Limpiar Todo");
        mnuItemLimpiarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemLimpiarTodoActionPerformed(evt);
            }
        });
        pupLimpiarTodo.add(mnuItemLimpiarTodo);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("ORDEN DE COMPRA"); // NOI18N

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Orden de Compra", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jXPanel1.setLayout(null);

        lblNombreEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblNombreEmpresa.setText("Empresa"); // NOI18N
        lblNombreEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jXPanel1.add(lblNombreEmpresa);
        lblNombreEmpresa.setBounds(190, 20, 236, 16);

        lblRucEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblRucEmpresa.setText("RUC"); // NOI18N
        lblRucEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jXPanel1.add(lblRucEmpresa);
        lblRucEmpresa.setBounds(190, 40, 185, 16);

        lblLogoEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXPanel1.add(lblLogoEmpresa);
        lblLogoEmpresa.setBounds(15, 16, 160, 40);

        lblOrdenCompra.setText("Nro de Orden :"); // NOI18N
        lblOrdenCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jXPanel1.add(lblOrdenCompra);
        lblOrdenCompra.setBounds(440, 20, 90, 14);

        txtNumeroOrdenCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jXPanel1.add(txtNumeroOrdenCompra);
        txtNumeroOrdenCompra.setBounds(545, 16, 81, 20);

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos Proveedor"));
        jXPanel2.setComponentPopupMenu(pupLimpiarProveedor);

        jXLabel5.setText("Proveedor :"); // NOI18N

        btnBuscarProveedor.setText("..."); // NOI18N
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        jXLabel6.setText("R.U.C :"); // NOI18N

        jXLabel7.setText("Dirección :"); // NOI18N

        jXLabel8.setText("Telefono :"); // NOI18N

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProveedorRazonSocial, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtProveedorRuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProveedorTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProveedorDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProveedorDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProveedorRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProveedorRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProveedorTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jXPanel1.add(jXPanel2);
        jXPanel2.setBounds(10, 60, 720, 80);

        jXPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos Transportista"));
        jXPanel3.setComponentPopupMenu(pupLimpiarTransportista);
        jXPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXLabel9.setText("Transportista :"); // NOI18N
        jXPanel3.add(jXLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jXPanel3.add(txtTransportistaRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 17, 200, -1));

        btnBuscarTransportista.setText("..."); // NOI18N
        btnBuscarTransportista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTransportistaActionPerformed(evt);
            }
        });
        jXPanel3.add(btnBuscarTransportista, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 16, 30, -1));

        jXLabel10.setText("R.U.C :"); // NOI18N
        jXPanel3.add(jXLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 49, -1));
        jXPanel3.add(txtTransportistaRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 17, 285, -1));

        jXLabel11.setText("Dirección :"); // NOI18N
        jXPanel3.add(jXLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 71, -1));
        jXPanel3.add(txtTransportistaDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 250, -1));

        jXLabel12.setText("Telefono :"); // NOI18N
        jXPanel3.add(jXLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));
        jXPanel3.add(txtTransportistaTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 285, -1));

        jXLabel13.setText("Vía Transp :"); // NOI18N
        jXPanel3.add(jXLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 71, -1));
        jXPanel3.add(cboTransportistaViaTransp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 250, -1));

        jXPanel1.add(jXPanel3);
        jXPanel3.setBounds(10, 140, 720, 110);

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "E", "Código", "Nombre", "Fabricante", "Unidad Medida", "CANTIDAD", "PRECIO", "DSCTO %", "PESO (KG)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducto.setColumnControlVisible(true);
        tblProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblProductoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducto);

        jXPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 280, 720, 113);

        jXLabel20.setText("Precio Bruto :"); // NOI18N
        jXPanel1.add(jXLabel20);
        jXLabel20.setBounds(10, 400, 100, 14);
        jXPanel1.add(txtPrecioBruto);
        txtPrecioBruto.setBounds(100, 400, 100, 20);

        jXLabel21.setText("Precio Total :"); // NOI18N
        jXPanel1.add(jXLabel21);
        jXLabel21.setBounds(210, 400, 80, 14);
        jXPanel1.add(txtPrecioTotal);
        txtPrecioTotal.setBounds(300, 400, 100, 20);

        jXLabel22.setText("Dscto Total :"); // NOI18N
        jXPanel1.add(jXLabel22);
        jXLabel22.setBounds(410, 400, 70, 14);
        jXPanel1.add(txtDsctoTotal);
        txtDsctoTotal.setBounds(490, 400, 100, 20);

        jXLabel23.setText("Valor de Venta :"); // NOI18N
        jXPanel1.add(jXLabel23);
        jXLabel23.setBounds(10, 430, 90, 14);
        jXPanel1.add(txtValorVenta);
        txtValorVenta.setBounds(100, 430, 100, 20);

        jXLabel24.setText("IGV Recup :"); // NOI18N
        jXPanel1.add(jXLabel24);
        jXLabel24.setBounds(410, 430, 60, 14);
        jXPanel1.add(txtIGVRecuperado);
        txtIGVRecuperado.setBounds(490, 430, 100, 20);

        jXLabel25.setText("Peso :"); // NOI18N
        jXPanel1.add(jXLabel25);
        jXLabel25.setBounds(600, 400, 50, 14);
        jXPanel1.add(txtPeso);
        txtPeso.setBounds(640, 400, 90, 20);

        btnBuscarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarProd.setText("B P"); // NOI18N
        btnBuscarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdActionPerformed(evt);
            }
        });
        jXPanel1.add(btnBuscarProd);
        btnBuscarProd.setBounds(560, 250, 80, 23);

        btnEliminarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/eliminar.png"))); // NOI18N
        btnEliminarProd.setText("E P"); // NOI18N
        btnEliminarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProdActionPerformed(evt);
            }
        });
        jXPanel1.add(btnEliminarProd);
        btnEliminarProd.setBounds(650, 250, 80, 23);

        lblIGV.setText("IGV (00.00 %) :"); // NOI18N
        lblIGV.setToolTipText(""); // NOI18N
        jXPanel1.add(lblIGV);
        lblIGV.setBounds(210, 430, 100, 14);
        jXPanel1.add(txtIGV);
        txtIGV.setBounds(300, 430, 100, 20);

        jXLabel1.setText("Operación en:");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jXPanel1.add(jXLabel1);
        jXLabel1.setBounds(440, 40, 90, 20);

        bgOperacion.add(rbnDolar);
        rbnDolar.setText("Dolar");
        jXPanel1.add(rbnDolar);
        rbnDolar.setBounds(530, 40, 70, 23);

        bgOperacion.add(rbnNuevoSol);
        rbnNuevoSol.setText("Nuevo Sol");
        jXPanel1.add(rbnNuevoSol);
        rbnNuevoSol.setBounds(600, 40, 110, 23);

        jXPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos de Llegada Almacén "));
        jXPanel4.setComponentPopupMenu(pupLimpiarAlmacen);
        jXPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXLabel14.setText("Destino Final :"); // NOI18N
        jXPanel4.add(jXLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        cboAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAlmacenActionPerformed(evt);
            }
        });
        jXPanel4.add(cboAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 219, -1));

        jXLabel15.setText("Dirección :"); // NOI18N
        jXPanel4.add(jXLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        txtDireccionAlmacen.setEditable(false);
        jXPanel4.add(txtDireccionAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 219, -1));

        jXLabel16.setText("Telefono :"); // NOI18N
        jXPanel4.add(jXLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 19, -1, -1));

        txtTelefonoAlmacen.setEditable(false);
        jXPanel4.add(txtTelefonoAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 16, 185, -1));

        jXLabel17.setText("Cond. Pago :"); // NOI18N
        jXPanel4.add(jXLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 45, -1, -1));

        cboCondPagoAlmacen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCondPagoAlmacenItemStateChanged(evt);
            }
        });
        jXPanel4.add(cboCondPagoAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 42, 185, -1));

        jXLabel18.setText("Fecha Entrega :"); // NOI18N
        jXPanel4.add(jXLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        dtp_fechaEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtp_fechaEntregaActionPerformed(evt);
            }
        });
        jXPanel4.add(dtp_fechaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 219, -1));

        jXLabel19.setText("Validez de O/C:"); // NOI18N
        jXPanel4.add(jXLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        dtp_fechaValidez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtp_fechaValidezActionPerformed(evt);
            }
        });
        jXPanel4.add(dtp_fechaValidez, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 185, -1));

        jXPanel1.add(jXPanel4);
        jXPanel4.setBounds(10, 450, 720, 120);

        pnlOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Opciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnRegistrarOrdenCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrarOrdenCompra.setText("Registrar"); // NOI18N
        btnRegistrarOrdenCompra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrarOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarOrdenCompraActionPerformed(evt);
            }
        });

        btnBuscarOrdenCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarOrdenCompra.setText("Buscar"); // NOI18N
        btnBuscarOrdenCompra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscarOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarOrdenCompraActionPerformed(evt);
            }
        });

        btnModificarOrdenCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/modificar.png"))); // NOI18N
        btnModificarOrdenCompra.setText("Modificar"); // NOI18N
        btnModificarOrdenCompra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificarOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarOrdenCompraActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificarOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 220, Short.MAX_VALUE))
                    .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnRegistrarOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarOrdenCompraActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getGENERARORDENCOMPRA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    
    JComboBox[] cbos = {cboTransportistaViaTransp, cboAlmacen, cboCondPagoAlmacen};
    JXDatePicker[] dtps = {dtp_fechaEntrega, dtp_fechaValidez};
    JTextField[] txts = {txtPrecioBruto, txtPrecioTotal, txtDsctoTotal, txtValorVenta,
        txtIGV, txtIGVRecuperado, txtPeso};

    if (objProveedor == null) {
        Mensaje.mensaje(this, "Buscar Datos Proveedor", Mensaje.TITULO_ME, Mensaje.ERROR);
        btnBuscarProveedor.requestFocus();
        return;
    }
    if (objTransportista == null) {
        Mensaje.mensaje(this, "Buscar Datos Transportista", Mensaje.TITULO_ME, Mensaje.ERROR);
        btnBuscarTransportista.requestFocus();
        return;
    }
    if (!com.gestionmatriz.util.ValidarCamposNulos.validarCombos(cbos)) {
        Mensaje.mensaje(this, "Los campos resaltados son importantes", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (!com.gestionmatriz.util.ValidarCamposNulos.validarDatePicker(dtps)) {
        Mensaje.mensaje(this, "Las fechas son importantes", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (!com.gestionmatriz.util.ValidarCamposNulos.validarDosFechas(dtp_fechaEntrega, dtp_fechaValidez)) {
        Mensaje.mensaje(this, "Fecha de Validez debe ser mayor o igual que Fecha de Entrega", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (!com.gestionmatriz.util.ValidarCamposNulos.validar(txts)) {
        editarTxt(true);
        Mensaje.mensaje(this, "Los campos resaltados son importantes - Agregar productos a la tabla", Mensaje.TITULO_ME, Mensaje.ERROR);
        btnBuscarProd.requestFocus();
        editarTxt(false);
        return;
    }
    if (!verificarDatosTabla()) {
        Mensaje.mensaje(this, "Verificar datos en la tabla", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (cboCondPagoAlmacen.getSelectedItem().toString().equalsIgnoreCase(com.gestionmatriz.util.Util.LETRAS)
            && listaCronogramaPagos.isEmpty()) {
        Mensaje.mensaje(this, "Falta llenar Letras", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else {
        calculosTotales();
        objOrdenCompra = new com.gestionmatriz.almacen.bean.OrdenCompra();
        objOrdenCompra.setStr_numeroOC(NumeroOrdenCompra);
        objOrdenCompra.setStr_viaTransporte(cboTransportistaViaTransp.getItemAt(cboTransportistaViaTransp.getSelectedIndex()).toString());
        objOrdenCompra.setObjTipoObligacion(listaTipoObligacion.get(cboCondPagoAlmacen.getSelectedIndex() - 1));
        objOrdenCompra.setDbl_precioBruto(new BigDecimal(txtPrecioBruto.getText()));
        objOrdenCompra.setDbl_precioTotal(new BigDecimal(txtPrecioTotal.getText()));
        objOrdenCompra.setDbl_descuentoTotal(new BigDecimal(txtDsctoTotal.getText()));
        objOrdenCompra.setDbl_valorVenta(new BigDecimal(txtValorVenta.getText()));
        objOrdenCompra.setDbl_igv(new BigDecimal(txtIGV.getText()));
        objOrdenCompra.setDbl_igvRecuperado(new BigDecimal(txtIGVRecuperado.getText()));
        objOrdenCompra.setDbl_pesoTotal(new BigDecimal(txtPeso.getText()));
        objOrdenCompra.setStr_fechaEntrega(com.gestionmatriz.util.Util.getFecha("yyyy-MM-dd", dtp_fechaEntrega.getDate()));
        objOrdenCompra.setStr_fechaValidez(com.gestionmatriz.util.Util.getFecha("yyyy-MM-dd", dtp_fechaValidez.getDate()));

        if (rbnNuevoSol.isSelected()) {
            objOrdenCompra.setStr_Operacion(com.gestionmatriz.util.Util.SOLES);
        } else if (rbnDolar.isSelected()) {
            objOrdenCompra.setStr_Operacion(com.gestionmatriz.util.Util.DOLARES);
        }

        objOrdenCompra.setStr_estado(com.gestionmatriz.util.Util.ACTIVO);
        objOrdenCompra.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());

        objOrdenCompra.setObjProveedor(objProveedor);

        objOrdenCompra.setObjTransportista(objTransportista);

        objOrdenCompra.setObjLocal(listaLocal.get(cboAlmacen.getSelectedIndex() - 1));

        objOrdenCompra.setObjEmpresa(objEmpresa);

        if (PaqueteBusinessDelegate.getOrdenCompraService().registrarOC(objOrdenCompra,
                listarPPOC(), new BigDecimal(txtPrecioTotal.getText()), listaCronogramaPagos)) {
            Mensaje.mensaje(this, "Orden de Compra registrada", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            limpiarTodo();
        } else {
            Mensaje.mensaje(this, "No se pudo registrar Orden de Compra", Mensaje.TITULO_ME, Mensaje.ERROR);
            limpiarTodo();
        }
    }
}//GEN-LAST:event_btnRegistrarOrdenCompraActionPerformed

private void cboAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAlmacenActionPerformed
    cargarDatosAlmacen();
}//GEN-LAST:event_cboAlmacenActionPerformed

private void btnBuscarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdActionPerformed
    if (objProveedor == null) {
        Mensaje.mensaje(this, "Buscar Datos Proveedor", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        btnBuscarProveedor.requestFocus();
        return;
    }
    
    com.gestionmatriz.util.Util.hiloProgressBar(1, gui);
    frmOrdenCompraProvProd = new OrdenCompraProvProd(gui, objProveedor);
    com.gestionmatriz.util.Util.hiloProgressBar(0, gui);
    frmOrdenCompraProvProd.setVisible(true);
    List<ProveedorProductoOrdenCompra> listaPPOCTemp = new ArrayList<>();

    if (frmOrdenCompraProvProd.check) {
        listaPPOCTemp = frmOrdenCompraProvProd.listaProvProdOrdenCompra;

        for (ProveedorProductoOrdenCompra objPPOC : listaPPOCTemp) {
            listaProveedorProductoOrdenCompra.add(objPPOC);
        }

        cargarTabla(tblProducto, listaPPOCTemp, 1);
        calculosTotales();
        frmOrdenCompraProvProd.check = false;
    }
}//GEN-LAST:event_btnBuscarProdActionPerformed

private void btnEliminarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProdActionPerformed
    eliminarFilaTabla(tblProducto);
    calculosTotales();
}//GEN-LAST:event_btnEliminarProdActionPerformed

private void tblProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductoKeyPressed
    //if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
    llenarCeldasVacias();
    calculosTotales();
    //}
}//GEN-LAST:event_tblProductoKeyPressed

private void btnBuscarOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarOrdenCompraActionPerformed
    try {
        String OC = txtNumeroOrdenCompra.getText().trim();

        //cts buscar
        List<com.gestionmatriz.almacen.bean.OrdenCompra> listaOrdenCompraTemp = new ArrayList<>();
        List<com.gestionmatriz.almacen.bean.OrdenCompra> listaOrdenCompra = new ArrayList<>();
        listaOrdenCompraTemp = PaqueteBusinessDelegate.getOrdenCompraService().
                buscarOrdenCompra(OC, "", "", "", "");

        for (com.gestionmatriz.almacen.bean.OrdenCompra objOCTemp : listaOrdenCompraTemp) {
            if (objOCTemp.getStr_estado().equals(com.gestionmatriz.util.Util.ACTIVO)) {
                listaOrdenCompra.add(objOCTemp);
            }
        }
        
        if (listaOrdenCompra.isEmpty()) {
            Mensaje.mensaje(this, "No existe Orden de Compra: " + OC, Mensaje.TITULO_ME, Mensaje.INFORMACION);
            txtNumeroOrdenCompra.requestFocus();
            txtNumeroOrdenCompra.selectAll();
        } else if (listaOrdenCompra.size() == 1) {
            cargarDatosBusquedaOrdenCompra(listaOrdenCompra.get(0));
            btnRegistrarOrdenCompra.setEnabled(false);
            btnModificarOrdenCompra.setEnabled(true);
            btnImprimir.setEnabled(true);
        } else if (listaOrdenCompra.size() > 1) {
            com.gestionmatriz.util.Util.hiloProgressBar(1, gui);
            BuscarOrdenCompra frmBuscarOrdenCompra = new BuscarOrdenCompra(gui, listaOrdenCompra, this.objEmpresa, this);
            com.gestionmatriz.util.Util.hiloProgressBar(0, gui);
            frmBuscarOrdenCompra.cargarPanelBusquedaOrdenCompra(listaOrdenCompra);
            frmBuscarOrdenCompra.setVisible(true);
            btnRegistrarOrdenCompra.setEnabled(false);
            btnModificarOrdenCompra.setEnabled(true);
            btnImprimir.setEnabled(true);
        }
    } catch (Exception ex) {
    	log.error("ERROR: "+ex.getMessage());
    }
}//GEN-LAST:event_btnBuscarOrdenCompraActionPerformed

private void btnModificarOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarOrdenCompraActionPerformed
   
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getAPROBARORDDENCOMPRA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    
    JComboBox[] cbos = {cboTransportistaViaTransp, cboAlmacen, cboCondPagoAlmacen};
    JXDatePicker[] dtps = {dtp_fechaEntrega, dtp_fechaValidez};
    JTextField[] txts = {txtPrecioBruto, txtPrecioTotal, txtDsctoTotal, txtValorVenta,
        txtIGV, txtIGVRecuperado, txtPeso};

    if (objProveedor == null) {
        Mensaje.mensaje(this, "Buscar Datos Proveedor", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        btnBuscarProveedor.requestFocus();
        return;
    }
    if (objTransportista == null) {
        Mensaje.mensaje(this, "Buscar Datos Transportista", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        btnBuscarTransportista.requestFocus();
        return;
    }
    if (!com.gestionmatriz.util.ValidarCamposNulos.validarCombos(cbos)) {
        Mensaje.mensaje(this, "Los campos resaltados son importantes", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        return;
    }
    if (!com.gestionmatriz.util.ValidarCamposNulos.validarDatePicker(dtps)) {
        Mensaje.mensaje(this, "Las fechas son importantes", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        return;
    }
    if (!com.gestionmatriz.util.ValidarCamposNulos.validarDosFechas(dtp_fechaEntrega, dtp_fechaValidez)) {
        Mensaje.mensaje(this, "Fecha de Validez debe ser mayor o igual que Fecha de Entrega", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (!com.gestionmatriz.util.ValidarCamposNulos.validar(txts)) {
        editarTxt(true);
        Mensaje.mensaje(this, "Los campos resaltados son importantes - Agregar productos a la tabla", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        btnBuscarProd.requestFocus();
        editarTxt(false);
        return;
    }
    if (!verificarDatosTabla()) {
        Mensaje.mensaje(this, "Verificar datos en la tabla", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        return;
    }
    if (cboCondPagoAlmacen.getSelectedItem().toString().equalsIgnoreCase(com.gestionmatriz.util.Util.LETRAS)
            && listaCronogramaPagos.isEmpty()) {
        Mensaje.mensaje(this, "Falta llenar Letras", Mensaje.TITULO_ME, Mensaje.INFORMACION);
    } else {
        calculosTotales();
        objOrdenCompra.setStr_estado(com.gestionmatriz.util.Util.INACTIVO);
        objOrdenCompra.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());

        objOrdenCompraNuevo = new com.gestionmatriz.almacen.bean.OrdenCompra();

        objOrdenCompraNuevo.setStr_numeroOC(objOrdenCompra.getStr_numeroOC());
        objOrdenCompraNuevo.setStr_viaTransporte(cboTransportistaViaTransp.getItemAt(cboTransportistaViaTransp.getSelectedIndex()).toString());
        objOrdenCompraNuevo.setObjTipoObligacion(listaTipoObligacion.get(cboCondPagoAlmacen.getSelectedIndex() - 1));
        objOrdenCompraNuevo.setDbl_precioBruto(new BigDecimal(txtPrecioBruto.getText()));
        objOrdenCompraNuevo.setDbl_precioTotal(new BigDecimal(txtPrecioTotal.getText()));
        objOrdenCompraNuevo.setDbl_descuentoTotal(new BigDecimal(txtDsctoTotal.getText()));
        objOrdenCompraNuevo.setDbl_valorVenta(new BigDecimal(txtValorVenta.getText()));
        objOrdenCompraNuevo.setDbl_igv(new BigDecimal(txtIGV.getText()));
        objOrdenCompraNuevo.setDbl_igvRecuperado(new BigDecimal(txtIGVRecuperado.getText()));
        objOrdenCompraNuevo.setDbl_pesoTotal(new BigDecimal(txtPeso.getText()));
        objOrdenCompraNuevo.setStr_fechaEntrega(com.gestionmatriz.util.Util.getFecha("yyyy-MM-dd", dtp_fechaEntrega.getDate()));
        objOrdenCompraNuevo.setStr_fechaValidez(com.gestionmatriz.util.Util.getFecha("yyyy-MM-dd", dtp_fechaValidez.getDate()));

        if (rbnNuevoSol.isSelected()) {
            objOrdenCompraNuevo.setStr_Operacion(com.gestionmatriz.util.Util.SOLES);
        } else if (rbnDolar.isSelected()) {
            objOrdenCompraNuevo.setStr_Operacion(com.gestionmatriz.util.Util.DOLARES);
        }

        objOrdenCompraNuevo.setStr_estado(com.gestionmatriz.util.Util.ACTIVO);
        objOrdenCompraNuevo.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());

        objOrdenCompraNuevo.setObjProveedor(objProveedor);

        objOrdenCompraNuevo.setObjTransportista(objTransportista);

        objOrdenCompraNuevo.setObjLocal(listaLocal.get(cboAlmacen.getSelectedIndex() - 1));

        if (PaqueteBusinessDelegate.getOrdenCompraService().modificarOC(objOrdenCompra,
                objOrdenCompraNuevo, listarPPOC(), new BigDecimal(txtPrecioTotal.getText()),
                listaCronogramaPagos)) {
            Mensaje.mensaje(this, "Orden de Compra modificada", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            limpiarTodo();
            btnRegistrarOrdenCompra.setEnabled(true);
            btnModificarOrdenCompra.setEnabled(false);
            btnImprimir.setEnabled(false);
        } else {
            Mensaje.mensaje(this, "No se pudo modificar Orden de Compra", Mensaje.TITULO_ME, Mensaje.ERROR);
            limpiarTodo();
        }
    }
}//GEN-LAST:event_btnModificarOrdenCompraActionPerformed

private void mnuItemLimpiarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemLimpiarProveedorActionPerformed
    limpiarProveedor();
}//GEN-LAST:event_mnuItemLimpiarProveedorActionPerformed

private void mnuItemLimpiarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemLimpiarAlmacenActionPerformed
    limpiarAlmacen();
}//GEN-LAST:event_mnuItemLimpiarAlmacenActionPerformed

private void mnuItemLimpiarTransportistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemLimpiarTransportistaActionPerformed
    limpiarTransportista();
}//GEN-LAST:event_mnuItemLimpiarTransportistaActionPerformed

private void mnuItemLimpiarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemLimpiarTodoActionPerformed
    limpiarTodo();
}//GEN-LAST:event_mnuItemLimpiarTodoActionPerformed

private void cboCondPagoAlmacenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCondPagoAlmacenItemStateChanged
	if (cboCondPagoAlmacen.getSelectedItem()==null){
        return;
    }
    if (cboCondPagoAlmacen.getSelectedItem().toString().equals(com.gestionmatriz.util.Util.LETRAS)) {
        if (reprogramarLetras == 1) {
            Object objConfirmacion = Mensaje.confirmar(this, "Desea Reprogramar Letras", "Mensaje Confirmación",
            Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);

            if (objConfirmacion.equals(Mensaje.YES_OPTION)) {
                listaCronogramaPagos = new ArrayList<>();
            }
        }
        
        if (listaCronogramaPagos.isEmpty()) {
            JTextField[] txts = {txtPrecioBruto, txtPrecioTotal, txtDsctoTotal, txtValorVenta,
                txtIGV, txtIGVRecuperado, txtPeso};
            int intNumeroLetras = 0;

            if (objProveedor == null) {
                Mensaje.mensaje(this, "Buscar Datos Proveedor", Mensaje.TITULO_ME, Mensaje.ERROR);
                cboCondPagoAlmacen.setSelectedIndex(0);
                btnBuscarProveedor.requestFocus();
                return;
            }
            if (!com.gestionmatriz.util.ValidarCamposNulos.validar(txts)) {
                Mensaje.mensaje(this, "Agregar productos a la tabla", Mensaje.TITULO_ME, Mensaje.ERROR);
                cboCondPagoAlmacen.setSelectedIndex(0);
                btnBuscarProd.requestFocus();
                return;
            }
            if (!verificarDatosTabla()) {
                Mensaje.mensaje(this, "Verificar datos en la tabla", Mensaje.TITULO_ME, Mensaje.ERROR);
                cboCondPagoAlmacen.setSelectedIndex(0);
                return;
            }

            String numeroLetras = Mensaje.leerEntrada(gui, "¿Cuántas LETRAS desea programar?",
                    Mensaje.TITULO_ME, Mensaje.PREGUNTA);

            if (numeroLetras == null) {
                return;
            }

            try {
                intNumeroLetras = Integer.parseInt(numeroLetras);
            } catch (NumberFormatException nfe) {
                log.error("Error: " + nfe.getMessage());
                Mensaje.mensaje(this, "Ingresar sólo números", Mensaje.TITULO_ME, Mensaje.ERROR);
                cboCondPagoAlmacen.setSelectedIndex(0);
                return;
            } catch (Exception e) {
                log.error("Error: " + e.getMessage());
                return;
            }

            com.gestionmatriz.util.Util.hiloProgressBar(1, gui);
            ProgramarLetras frmProgramarLetras = new ProgramarLetras(gui, intNumeroLetras,
                    new BigDecimal(txtPrecioTotal.getText()), objProveedor, 1);
            com.gestionmatriz.util.Util.hiloProgressBar(0, gui);
            frmProgramarLetras.setVisible(true);
            listaCronogramaPagos = new ArrayList<>();

            this.listaCronogramaPagos = frmProgramarLetras.listaCronogramaPagos;
            reprogramarLetras = 1;
//            cboCondPagoAlmacen.setSelectedIndex(0);
        }
    }
}//GEN-LAST:event_cboCondPagoAlmacenItemStateChanged

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        Ireport ir = new Ireport();
        ir.imprimirOrdenCompra(objOrdenCompra.getStr_numeroOC());
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void dtp_fechaEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtp_fechaEntregaActionPerformed
        if (dtp_fechaEntrega.getDate().before(com.gestionmatriz.util.Util.StringTODate(fechaServidor))) {
            Mensaje.mensaje(this, "Fecha inválida, menor a la actual", Mensaje.TITULO_ME, Mensaje.ERROR);
            dtp_fechaEntrega.setDate(com.gestionmatriz.util.Util.StringTODate(fechaServidor));
        }
    }//GEN-LAST:event_dtp_fechaEntregaActionPerformed

    private void dtp_fechaValidezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtp_fechaValidezActionPerformed
        if (dtp_fechaValidez.getDate().before(com.gestionmatriz.util.Util.StringTODate(fechaServidor))) {
            Mensaje.mensaje(this, "Fecha inválida, menor a la actual", Mensaje.TITULO_ME, Mensaje.ERROR);
            dtp_fechaValidez.setDate(com.gestionmatriz.util.Util.StringTODate(fechaServidor));
        }
    }//GEN-LAST:event_dtp_fechaValidezActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        try {
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            log.error(ex);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        txtProveedorRazonSocial.setEditable(false);
        txtProveedorRuc.setEditable(false);
        txtProveedorDireccion.setEditable(false);
        txtProveedorTelefono.setEditable(false);
        buscarDatosProveedorTransportista(1, txtProveedorRuc.getText(), txtProveedorRazonSocial.getText());
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void btnBuscarTransportistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTransportistaActionPerformed
        txtTransportistaRazonSocial.setEditable(false);
        txtTransportistaRuc.setEditable(false);
        txtTransportistaDireccion.setEditable(false);
        txtTransportistaTelefono.setEditable(false);
        buscarDatosProveedorTransportista(2, txtTransportistaRuc.getText(), txtTransportistaRazonSocial.getText());
    }//GEN-LAST:event_btnBuscarTransportistaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgOperacion;
    private org.jdesktop.swingx.JXButton btnBuscarOrdenCompra;
    private org.jdesktop.swingx.JXButton btnBuscarProd;
    private org.jdesktop.swingx.JXButton btnBuscarProveedor;
    private org.jdesktop.swingx.JXButton btnBuscarTransportista;
    private org.jdesktop.swingx.JXButton btnEliminarProd;
    private javax.swing.JButton btnImprimir;
    private org.jdesktop.swingx.JXButton btnModificarOrdenCompra;
    private org.jdesktop.swingx.JXButton btnRegistrarOrdenCompra;
    private javax.swing.JButton btnSalir;
    private org.jdesktop.swingx.JXComboBox cboAlmacen;
    private org.jdesktop.swingx.JXComboBox cboCondPagoAlmacen;
    private org.jdesktop.swingx.JXComboBox cboTransportistaViaTransp;
    private org.jdesktop.swingx.JXDatePicker dtp_fechaEntrega;
    private org.jdesktop.swingx.JXDatePicker dtp_fechaValidez;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel10;
    private org.jdesktop.swingx.JXLabel jXLabel11;
    private org.jdesktop.swingx.JXLabel jXLabel12;
    private org.jdesktop.swingx.JXLabel jXLabel13;
    private org.jdesktop.swingx.JXLabel jXLabel14;
    private org.jdesktop.swingx.JXLabel jXLabel15;
    private org.jdesktop.swingx.JXLabel jXLabel16;
    private org.jdesktop.swingx.JXLabel jXLabel17;
    private org.jdesktop.swingx.JXLabel jXLabel18;
    private org.jdesktop.swingx.JXLabel jXLabel19;
    private org.jdesktop.swingx.JXLabel jXLabel20;
    private org.jdesktop.swingx.JXLabel jXLabel21;
    private org.jdesktop.swingx.JXLabel jXLabel22;
    private org.jdesktop.swingx.JXLabel jXLabel23;
    private org.jdesktop.swingx.JXLabel jXLabel24;
    private org.jdesktop.swingx.JXLabel jXLabel25;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    private org.jdesktop.swingx.JXLabel lblIGV;
    private org.jdesktop.swingx.JXLabel lblLogoEmpresa;
    private org.jdesktop.swingx.JXLabel lblNombreEmpresa;
    private org.jdesktop.swingx.JXLabel lblOrdenCompra;
    private org.jdesktop.swingx.JXLabel lblRucEmpresa;
    private javax.swing.JMenuItem mnuItemLimpiarAlmacen;
    private javax.swing.JMenuItem mnuItemLimpiarProveedor;
    private javax.swing.JMenuItem mnuItemLimpiarTodo;
    private javax.swing.JMenuItem mnuItemLimpiarTransportista;
    private org.jdesktop.swingx.JXPanel pnlOpciones;
    private javax.swing.JPopupMenu pupLimpiarAlmacen;
    private javax.swing.JPopupMenu pupLimpiarProveedor;
    private javax.swing.JPopupMenu pupLimpiarTodo;
    private javax.swing.JPopupMenu pupLimpiarTransportista;
    private javax.swing.JRadioButton rbnDolar;
    private javax.swing.JRadioButton rbnNuevoSol;
    private org.jdesktop.swingx.JXTable tblProducto;
    private org.jdesktop.swingx.JXTextField txtDireccionAlmacen;
    private org.jdesktop.swingx.JXTextField txtDsctoTotal;
    private org.jdesktop.swingx.JXTextField txtIGV;
    private org.jdesktop.swingx.JXTextField txtIGVRecuperado;
    private org.jdesktop.swingx.JXTextField txtNumeroOrdenCompra;
    private org.jdesktop.swingx.JXTextField txtPeso;
    private org.jdesktop.swingx.JXTextField txtPrecioBruto;
    private org.jdesktop.swingx.JXTextField txtPrecioTotal;
    private org.jdesktop.swingx.JXTextField txtProveedorDireccion;
    private org.jdesktop.swingx.JXTextField txtProveedorRazonSocial;
    private org.jdesktop.swingx.JXTextField txtProveedorRuc;
    private org.jdesktop.swingx.JXTextField txtProveedorTelefono;
    private org.jdesktop.swingx.JXTextField txtTelefonoAlmacen;
    private org.jdesktop.swingx.JXTextField txtTransportistaDireccion;
    private org.jdesktop.swingx.JXTextField txtTransportistaRazonSocial;
    private org.jdesktop.swingx.JXTextField txtTransportistaRuc;
    private org.jdesktop.swingx.JXTextField txtTransportistaTelefono;
    private org.jdesktop.swingx.JXTextField txtValorVenta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        listaProveedorProductoOrdenCompra.clear();
        listaProveedorProductoOrdenCompra = new ArrayList<>();
        listaCronogramaPagos = new ArrayList<>();
        gui.getBarraEstado().cerraVentana();
    }
    
    private void limpiarTodo() {
//        NumeroOrdenCompra = OrdenCompraPrevio.generarNumeroOrdenCompra();
//        this.title = "ORDEN DE COMPRA: ".concat(NumeroOrdenCompra);
        
        limpiarProveedor();
        limpiarTransportista();
        
        DefaultTableModel modelo = (DefaultTableModel) tblProducto.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        txtPrecioBruto.setText("");
        txtPrecioTotal.setText("");
        txtDsctoTotal.setText("");
        txtValorVenta.setText("");
        txtIGV.setText("");
        txtIGVRecuperado.setText("");
        txtPeso.setText("");
        
        limpiarAlmacen();
        
        listaProveedorProductoOrdenCompra.clear();
        listaProveedorProductoOrdenCompra = new ArrayList<>();
        listaCronogramaPagos = new ArrayList<>();
    }

    private void limpiarProveedor() {
        txtProveedorRazonSocial.setText("");
        txtProveedorDireccion.setText("");
        txtProveedorRuc.setText("");
        txtProveedorTelefono.setText("");
    }

    private void limpiarTransportista() {
        txtTransportistaRazonSocial.setText("");
        txtTransportistaDireccion.setText("");
        txtTransportistaRuc.setText("");
        txtTransportistaTelefono.setText("");
        viaTransporte(cboTransportistaViaTransp);
    }

    private void limpiarAlmacen() {
        cargarAlmacen(cboAlmacen);
        txtDireccionAlmacen.setText("");
        dtp_fechaEntrega.setDate(null);
        dtp_fechaValidez.setDate(null);
        txtTelefonoAlmacen.setText("");
        condicionPago(cboCondPagoAlmacen);
    }

    private void cargarFotoEmpresa() {
            
            ImageIcon image = new ImageIcon(getClass().getResource("/com/gestionmatriz/icon/jpg_logo_empresa.jpg"));
            Icon fotoIcono = com.gestionmatriz.util.Util.reducirFoto(
                    image, lblLogoEmpresa.getWidth(), lblLogoEmpresa.getHeight());
            lblLogoEmpresa.setIcon(fotoIcono);

    }

    private void cargarDatos() {
        cargarFotoEmpresa();
        lblNombreEmpresa.setText(lblNombreEmpresa.getText().concat("   : " + objEmpresa.getStr_razonSocial()));
        lblRucEmpresa.setText(lblRucEmpresa.getText().concat("           : " + objEmpresa.getStr_ruc()));
        this.title = "ORDEN DE COMPRA: ".concat(NOC);
        txtNumeroOrdenCompra.setText(NOC);
        txtNumeroOrdenCompra.selectAll();
        NumeroOrdenCompra = NOC;
        rbnNuevoSol.setSelected(true);
        tblProducto.setSortable(false);
        btnModificarOrdenCompra.setEnabled(false);
        btnImprimir.setEnabled(false);

        viaTransporte(cboTransportistaViaTransp);
        cargarAlmacen(cboAlmacen);
        condicionPago(cboCondPagoAlmacen);

        fechaServidor = PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql().substring(0, 10);
        objOtros = PaqueteBusinessDelegate.getOtrosService().getOtros();
        lblIGV.setText("IGV (" + PaqueteBusinessDelegate.getConfigBDService().getIGV() + " %) :");

        editarTxt(false);
    }

    private void editarTxt(boolean b) {
        txtPrecioBruto.setEditable(b);
        txtPrecioTotal.setEditable(b);
        txtDsctoTotal.setEditable(b);
        txtValorVenta.setEditable(b);
        txtIGV.setEditable(b);
        txtIGVRecuperado.setEditable(b);
        txtPeso.setEditable(b);
    }

    protected void viaTransporte(JXComboBox cbo) {
        cbo.removeAllItems();
        cbo.addItem(".::Seleccionar una Vía de Transporte::.");
        cbo.addItem("FLUVIAL");
        cbo.addItem("AÉREO");
        cbo.addItem("TERRESTRE");
    }

    protected void cargarAlmacen(JXComboBox cbo) {
        listaLocal = PaqueteBusinessDelegate.getOrdenCompraService().
                buscarLocal("" + objEmpresa.getInt_idEmpresa());

        cbo.removeAllItems();
        cbo.addItem(".::Seleccionar Almacen::.");
        for (Local local : listaLocal) {
            cbo.addItem(local.getStr_nombre());
        }
    }

    protected void condicionPago(JXComboBox cbo) {
        listaTipoObligacion = PaqueteBusinessDelegate.getOrdenCompraService().
                buscarTipoObligacion();

        cbo.removeAllItems();
        cbo.addItem(".::Seleccionar Condición de Pago::.");
        for (TipoObligacion objTO : listaTipoObligacion) {
            cbo.addItem(objTO.getStr_nombreTO());
        }
    }

    private void cargarDatosAlmacen() {
        if (cboAlmacen.getSelectedIndex() > 0) {
            txtDireccionAlmacen.setText(listaLocal.get(cboAlmacen.getSelectedIndex() - 1).getStr_direccion());
            txtTelefonoAlmacen.setText(listaLocal.get(cboAlmacen.getSelectedIndex() - 1).getStr_telefono());
        }
    }

    protected void cargarDatosBusquedaProveedor(Proveedor objProveedor, int i) {
        if (i == 1) {
            txtProveedorRazonSocial.setText(objProveedor.getStr_razonSocial());
            txtProveedorRuc.setText(objProveedor.getStr_ruc());
            txtProveedorDireccion.setText(objProveedor.getStr_direccion());
            txtProveedorTelefono.setText(objProveedor.getStr_telefono());
            this.objProveedor = objProveedor;
        } else if (i == 2) {
            txtTransportistaRazonSocial.setText(objProveedor.getStr_razonSocial());
            txtTransportistaRuc.setText(objProveedor.getStr_ruc());
            txtTransportistaDireccion.setText(objProveedor.getStr_direccion());
            txtTransportistaTelefono.setText(objProveedor.getStr_telefono());
            this.objTransportista = objProveedor;
        }
    }

    private void buscarDatosProveedorTransportista(int i, String ruc, String nombre) {
        try {
            List<Proveedor> listaProveedores = PaqueteBusinessDelegate.getProveedorService().
                    buscarProveedor("%" + ruc.trim() + "%", "%" + nombre.trim() + "%");

            if (listaProveedores.size() == 1) {
                for (Proveedor objProve : listaProveedores) {
                    cargarDatosBusquedaProveedor(objProve, i);
                }
            } else if (listaProveedores.size() > 1) {
                com.gestionmatriz.util.Util.hiloProgressBar(1, gui);
                BuscarProveedor frmBuscarProveedor = new BuscarProveedor(gui, listaProveedores, this, 1, i);
                com.gestionmatriz.util.Util.hiloProgressBar(0, gui);
                frmBuscarProveedor.cargarPanelBusquedaProveedor(listaProveedores);
                frmBuscarProveedor.setVisible(true);
            }
        } catch (Exception ex) {
        	log.error("ERROR: "+ex.getMessage());
        }
    }

    private void cargarTabla(JXTable tabla, List lista, int d) {
        Object[] filaTabla = new Object[9];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int i = 0;

        if (d == 1) {
            for (Object a : lista) {
                if (a instanceof ProveedorProductoOrdenCompra) {
                    filaTabla[0] = false;
                    filaTabla[1] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getStr_codigoInterno();
                    filaTabla[2] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getStr_nombreProducto();
                    filaTabla[3] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getStr_fabricante();
                    filaTabla[4] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getObjUnidadMedida().getStr_nombreUM();
                    filaTabla[5] = 0;
                    filaTabla[6] = ((ProveedorProductoOrdenCompra) a).getDbl_precio();
                    filaTabla[7] = ((ProveedorProductoOrdenCompra) a).getDbl_descuento();
                    filaTabla[8] = ((ProveedorProductoOrdenCompra) a).getDbl_peso();
                    modelo.addRow(filaTabla);
                }
                i++;
            }
        } else if (d == 2) {
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }

            for (Object a : lista) {
                if (a instanceof ProveedorProductoOrdenCompra) {
                    filaTabla[0] = false;
                    filaTabla[1] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getStr_codigoInterno();
                    filaTabla[2] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getStr_nombreProducto();
                    filaTabla[3] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getStr_fabricante();
                    filaTabla[4] = ((ProveedorProductoOrdenCompra) a).getObjProducto().getObjUnidadMedida().getStr_nombreUM();
                    filaTabla[5] = ((ProveedorProductoOrdenCompra) a).getDbl_cantidad();
                    filaTabla[6] = ((ProveedorProductoOrdenCompra) a).getDbl_precio();
                    filaTabla[7] = ((ProveedorProductoOrdenCompra) a).getDbl_descuento();
                    filaTabla[8] = ((ProveedorProductoOrdenCompra) a).getDbl_peso();
                    modelo.addRow(filaTabla);
                }
                i++;
            }
        }
        
        tabla.setModel(modelo);
    }

    private void eliminarFilaTabla(JXTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int i = 0;
        boolean checkSeleccion = false;

        if (tabla.getRowCount() == 0) {
            Mensaje.mensaje(this, "No hay filas a eliminar", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            return;
        }

        for (int j = 0; j < tabla.getRowCount(); j++) {
            boolean b1 = Boolean.parseBoolean(tabla.getValueAt(j, 0).toString());
            if (b1) {
                checkSeleccion = true;
            }
        }

        if (!checkSeleccion) {
            Mensaje.mensaje(this, "Seleccionar Productos a eliminar", Mensaje.TITULO_ME, Mensaje.ERROR);
        } else {
            while (modelo.getRowCount() > 0) {
                boolean b2 = Boolean.parseBoolean(tabla.getValueAt(i, 0).toString());
                if (b2) {
                    String codigoInternoProducto = tabla.getValueAt(i, 1).toString();

                    for (int k = 0; k < listaProveedorProductoOrdenCompra.size(); k++) {
                        if (listaProveedorProductoOrdenCompra.get(k).getObjProducto().
                                getStr_codigoInterno().equalsIgnoreCase(codigoInternoProducto)) {
                            listaProveedorProductoOrdenCompra.remove(k);
                        }
                    }

                    modelo.removeRow(i);
                    i--;
                }
                i++;
            }
        }
    }

    private void calculosTotales() {
        BigDecimal cantidad = BigDecimal.ZERO, precioBruto = BigDecimal.ZERO, cantXprecBrut = BigDecimal.ZERO, descuento = BigDecimal.ZERO, cantXprecTota = BigDecimal.ZERO,
                cXpDscto = BigDecimal.ZERO, dsctoTotal = BigDecimal.ZERO, valorIGV = BigDecimal.ZERO, IGV = BigDecimal.ZERO, IGVTotal = BigDecimal.ZERO,
                IGVRecup = BigDecimal.ZERO, peso = BigDecimal.ZERO, pesoTotal = BigDecimal.ZERO, valorVenta = BigDecimal.ZERO;
        String dscto = "";

        valorIGV = dbl_igv;
        //valorIGV = 0.19;

        if (tblProducto.getRowCount() == 0) {
            Mensaje.mensaje(this, "No hay productos a calcular", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            return;
        }/* else {
        for (int i = 0; i <= tblProducto.getRowCount() - 1; i++) {
        if (tblProducto.getValueAt(i, 4).toString().equals("")) {
        Mensaje.mensaje(this, "Falta llenar campo(s) en CANTIDAD", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        return;
        } else if (tblProducto.getValueAt(i, 5).toString().equals("")) {
        Mensaje.mensaje(this, "Falta llenar campo(s) en PRECIO", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        return;
        } else if (tblProducto.getValueAt(i, 7).toString().equals("")) {
        Mensaje.mensaje(this, "Falta llenar campo(s) en PESO", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        return;
        }
        }
        }*/

        for (int i = 0; i < tblProducto.getRowCount(); i++) {
            cantidad = new BigDecimal(tblProducto.getValueAt(i, 5).toString());
            precioBruto = new BigDecimal(tblProducto.getValueAt(i, 6).toString());
            cantXprecBrut = cantXprecBrut.add(cantidad .multiply(precioBruto)) ;

            dscto = tblProducto.getValueAt(i, 7).toString();
            if (!dscto.equals("")) {
                descuento = new BigDecimal(dscto);
                cXpDscto = cantidad .multiply(precioBruto .multiply(BigDecimal.ONE.subtract(descuento.divide(new BigDecimal(100)))));
                cantXprecTota =cantXprecTota.add(cXpDscto) ;
            } else {
                cXpDscto = cantidad.multiply(precioBruto) ;
                cantXprecTota = cantXprecTota.add(cXpDscto);
            }

            IGV = cXpDscto .multiply(valorIGV) ;
            IGVTotal =IGVTotal.add(IGV)  ;

            if (listaProveedorProductoOrdenCompra.get(i).getObjProducto().getStr_reintegroTributario().equalsIgnoreCase("SI")) {
                IGVRecup =IGVRecup.add(IGV) ;
            } /*else {
                IGVRecup += 0;
            }*/

            valorVenta = valorVenta.add(cXpDscto.subtract(IGV));

            peso = new BigDecimal(tblProducto.getValueAt(i, 8).toString());
            pesoTotal = pesoTotal.add(peso .multiply(cantidad) );
        }

        dsctoTotal = cantXprecBrut.subtract(cantXprecTota)  ;

        txtPrecioBruto.setText(com.gestionmatriz.util.Util.redondeo(cantXprecBrut, 2));
        txtPrecioTotal.setText(com.gestionmatriz.util.Util.redondeo(cantXprecTota, 2));
        txtDsctoTotal.setText(com.gestionmatriz.util.Util.redondeo(dsctoTotal, 2));
        txtValorVenta.setText(com.gestionmatriz.util.Util.redondeo(valorVenta, 2));
        txtIGV.setText(com.gestionmatriz.util.Util.redondeo(IGVTotal, 2));
        txtIGVRecuperado.setText(com.gestionmatriz.util.Util.redondeo(IGVRecup, 2));
        txtPeso.setText(com.gestionmatriz.util.Util.redondeo(pesoTotal, 2));
    }

    private void llenarCeldasVacias() {
        for (int i = 0; i < tblProducto.getRowCount(); i++) {
            if (tblProducto.getValueAt(i, 5) == null) {
                tblProducto.setValueAt(0, i, 5);
            }
            if (tblProducto.getValueAt(i, 6) == null) {
                tblProducto.setValueAt(0, i, 6);
            }
            if (tblProducto.getValueAt(i, 7) == null) {
                tblProducto.setValueAt(0, i, 7);
            }
            if (tblProducto.getValueAt(i, 8) == null) {
                tblProducto.setValueAt(0, i, 8);
            }
        }
    }

    private boolean verificarDatosTabla() {
        for (int i = 0; i < tblProducto.getRowCount(); i++) {
            if (new BigDecimal(tblProducto.getValueAt(i, 5).toString()).compareTo(BigDecimal.ZERO)<=0
                    || new BigDecimal(tblProducto.getValueAt(i, 6).toString()) .compareTo(BigDecimal.ZERO)<=0
                    || new BigDecimal(tblProducto.getValueAt(i, 8).toString()) .compareTo(BigDecimal.ZERO)<=0) {
                return false;
            }
        }

        return true;
    }

    private List<ProveedorProductoOrdenCompra> listarPPOC() {
        List<ProveedorProductoOrdenCompra> listaPPOC = new ArrayList<>();
        ProveedorProductoOrdenCompra objPPOC = null;

        for (int i = 0; i < tblProducto.getRowCount(); i++) {
            objPPOC = new ProveedorProductoOrdenCompra();
            objPPOC.setObjProveedor(listaProveedorProductoOrdenCompra.get(i).getObjProveedor());
            objPPOC.setObjProducto(listaProveedorProductoOrdenCompra.get(i).getObjProducto());
            objPPOC.setDbl_cantidad(new BigDecimal(tblProducto.getValueAt(i, 5).toString()));
            objPPOC.setDbl_precio(new BigDecimal(tblProducto.getValueAt(i, 6).toString()));
            objPPOC.setDbl_descuento(new BigDecimal(tblProducto.getValueAt(i, 7).toString()));
            objPPOC.setDbl_peso(new BigDecimal(tblProducto.getValueAt(i, 8).toString()));
            listaPPOC.add(objPPOC);
        }

        return listaPPOC;
    }

    protected void cargarDatosBusquedaOrdenCompra(com.gestionmatriz.almacen.bean.OrdenCompra OCSeleccionado) {
        txtNumeroOrdenCompra.setText(OCSeleccionado.getStr_numeroOC());

        if (OCSeleccionado.getStr_Operacion().equalsIgnoreCase(com.gestionmatriz.util.Util.SOLES)) {
            rbnNuevoSol.setSelected(true);
        } else if (OCSeleccionado.getStr_Operacion().equalsIgnoreCase(com.gestionmatriz.util.Util.DOLARES)) {
            rbnDolar.setSelected(true);
        }

        cargarDatosBusquedaProveedor(OCSeleccionado.getObjProveedor(), 1);

        cargarDatosBusquedaProveedor(OCSeleccionado.getObjTransportista(), 2);
        cboTransportistaViaTransp.setSelectedItem(OCSeleccionado.getStr_viaTransporte());

        cboAlmacen.setSelectedItem(OCSeleccionado.getObjLocal().getStr_nombre());
        cboCondPagoAlmacen.setSelectedItem(OCSeleccionado.getObjTipoObligacion().getStr_nombreTO());
        dtp_fechaEntrega.setDate(null);
        dtp_fechaValidez.setDate(null);

        cargarTablaDetalle(OCSeleccionado.getInt_idOrdenCompra());

        calculosTotales();

        objOrdenCompra = new com.gestionmatriz.almacen.bean.OrdenCompra();
        this.objOrdenCompra = OCSeleccionado;
    }

    private void cargarTablaDetalle(int idOrdenCompra) {
        List<ProveedorProductoOrdenCompra> listaPPOCTemp = new ArrayList<>();
        listaProveedorProductoOrdenCompra = new ArrayList<>();
        
        listaPPOCTemp = PaqueteBusinessDelegate.getOrdenCompraService().listarPPOC(idOrdenCompra);

        for (ProveedorProductoOrdenCompra objPPOCTemp : listaPPOCTemp) {
            if (objPPOCTemp.getStr_estado().equals(com.gestionmatriz.util.Util.ACTIVO)) {
                listaProveedorProductoOrdenCompra.add(objPPOCTemp);
            }
        }
        
        cargarTabla(tblProducto, listaProveedorProductoOrdenCompra, 2);
    }
}
