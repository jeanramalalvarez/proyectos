/*
 * GuiaRemision.java
 *
 * Created on 24-may-2012, 8:49:22
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jdesktop.swingx.JXTable;

import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.bean.ProveedorProducto;
import com.gestionmatriz.almacen.gui.BuscarLocal;
import com.gestionmatriz.almacen.gui.BuscarProveedor;
import com.gestionmatriz.almacen.gui.TraspasoMercaderia;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.ConsultaStock;
import com.gestionmatriz.puntoventa.bean.DetalleGuiaRemision;
import com.gestionmatriz.puntoventa.bean.ImprimirGuia;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.puntoventa.reportes.Ireport;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.seguridad.gui.Logeo;
import com.gestionmatriz.util.Impresora;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

/**
 *
 * @author zholo
 */
public class GuiaRemision extends javax.swing.JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Empresa objEmpresa;
    private Principal gui;
    private Local objLocal;
    private List<com.gestionmatriz.almacen.bean.ProveedorProducto> listaProveeProdu = new ArrayList<>();
    private ConsultaStock objConsultaStock;
    List<ConsultaStock> listaStock = new ArrayList<>();

    public Local getObjLocal() {
        return objLocal;
    }

    public void setObjLocal(Local objLocal) {
        this.objLocal = objLocal;
    }
    private Logeo frmLogeo;
    private com.gestionmatriz.almacen.bean.Producto objProducto;
    private List<Producto> listaProductos = new ArrayList<>();
    private TraspasoMercaderia frmTraspasoMercaderia;
    private List<DetalleGuiaRemision> listaDetalleGuia = new ArrayList<>();
    private List<com.gestionmatriz.puntoventa.bean.GuiaRemision> listaGuiaRemision;
    private DefaultTableModel modelo;
    //=PaqueteBusinessDelegate.getGuiaRemisionService().buscarGuias("%%","%%");

    public GuiaRemision(Principal gui) {
        this.gui = gui;
        initComponents();
        setLocal();
        obtenerFecha();
        setRuc();
        cargarPartida();
//        setNumeroGuia();
        rbtTraspaso.setSelected(true);
        setearFecha();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnuQuitarProducto = new javax.swing.JMenuItem();
        pnlRucGuia = new org.jdesktop.swingx.JXPanel();
        lblRucGuia = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtNumeroGuia = new org.jdesktop.swingx.JXTextField();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        dtpFchIniTralsadoGuia = new org.jdesktop.swingx.JXDatePicker();
        pnlDomicilioPartidaGuia = new org.jdesktop.swingx.JXPanel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        txtDireccionPartidaGuia = new org.jdesktop.swingx.JXTextField();
        txtDistritoPartidaGuia = new org.jdesktop.swingx.JXTextField();
        txtProvinciaPartidaGuia = new org.jdesktop.swingx.JXTextField();
        txtDepartamentoPartidaGuia = new org.jdesktop.swingx.JXTextField();
        pnlDomicilioLlegadaGuia = new org.jdesktop.swingx.JXPanel();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        txtDireccionLlegadaGuia1 = new org.jdesktop.swingx.JXTextField();
        txtDistritoLlegadaGuia = new org.jdesktop.swingx.JXTextField();
        txtProvinciaLlegadaGuia = new org.jdesktop.swingx.JXTextField();
        txtDepartamentoLlegadaGuia = new org.jdesktop.swingx.JXTextField();
        btnBuscarLocal = new org.jdesktop.swingx.JXButton();
        pnlDestinatarioGuia = new org.jdesktop.swingx.JXPanel();
        jXLabel14 = new org.jdesktop.swingx.JXLabel();
        jXLabel15 = new org.jdesktop.swingx.JXLabel();
        jXLabel17 = new org.jdesktop.swingx.JXLabel();
        txtDestinatario = new org.jdesktop.swingx.JXTextField();
        txtDireccionDestinatario = new org.jdesktop.swingx.JXTextField();
        txtRucDestinatario = new org.jdesktop.swingx.JXTextField();
        pnlUnidTransporteGuia = new org.jdesktop.swingx.JXPanel();
        jXLabel16 = new org.jdesktop.swingx.JXLabel();
        jXLabel18 = new org.jdesktop.swingx.JXLabel();
        jXLabel19 = new org.jdesktop.swingx.JXLabel();
        txtMarcaPlaca = new org.jdesktop.swingx.JXTextField();
        txtLicenciaConducir = new org.jdesktop.swingx.JXTextField();
        txtCertiInscripcion = new org.jdesktop.swingx.JXTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleGuia = new org.jdesktop.swingx.JXTable();
        pnlTransportista = new org.jdesktop.swingx.JXPanel();
        jXLabel20 = new org.jdesktop.swingx.JXLabel();
        jXLabel21 = new org.jdesktop.swingx.JXLabel();
        txtTransportistaNombre = new org.jdesktop.swingx.JXTextField();
        txtTransportistaRuc = new org.jdesktop.swingx.JXTextField();
        btnBuscartrans = new org.jdesktop.swingx.JXButton();
        pnlMotivoTraslado = new org.jdesktop.swingx.JXPanel();
        rbtVenta = new javax.swing.JRadioButton();
        rbtCompra = new javax.swing.JRadioButton();
        rbtConsignacion = new javax.swing.JRadioButton();
        rbtEmisorItinerante = new javax.swing.JRadioButton();
        rbtDevolucion = new javax.swing.JRadioButton();
        rbtImportacion = new javax.swing.JRadioButton();
        rbtExportacion = new javax.swing.JRadioButton();
        rbtTraspaso = new javax.swing.JRadioButton();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel22 = new org.jdesktop.swingx.JXLabel();
        jXLabel23 = new org.jdesktop.swingx.JXLabel();
        cboComprobante = new org.jdesktop.swingx.JXComboBox();
        txtNumeroComprobante = new org.jdesktop.swingx.JXTextField();
        txtFechaEmisionGuia = new org.jdesktop.swingx.JXTextField();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        btnRegistrar = new org.jdesktop.swingx.JXButton();
        btnTraspaso = new org.jdesktop.swingx.JXButton();
        btnBuscarProducto = new org.jdesktop.swingx.JXButton();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        btnImprimirGuia = new org.jdesktop.swingx.JXButton();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtImprimir = new org.jdesktop.swingx.JXTextField();

        mnuQuitarProducto.setText("Quitar Producto");
        mnuQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuQuitarProductoActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnuQuitarProducto);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("GUÍA REMISIÓN");

        pnlRucGuia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblRucGuia.setBackground(new java.awt.Color(0, 0, 0));
        lblRucGuia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRucGuia.setForeground( new Color(255,255,255));

        jXLabel3.setText("GUÍA REMISIÓN-REMITENTE");
        jXLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jXLabel3.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        jXLabel1.setText("N°");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout pnlRucGuiaLayout = new javax.swing.GroupLayout(pnlRucGuia);
        pnlRucGuia.setLayout(pnlRucGuiaLayout);
        pnlRucGuiaLayout.setHorizontalGroup(
            pnlRucGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRucGuiaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRucGuia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumeroGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlRucGuiaLayout.setVerticalGroup(
            pnlRucGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRucGuiaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlRucGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRucGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnlRucGuiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRucGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumeroGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jXLabel4.setText("Fecha de Emisión");

        jXLabel5.setText("Fecha inicio Traslado");

        dtpFchIniTralsadoGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtpFchIniTralsadoGuiaActionPerformed(evt);
            }
        });

        pnlDomicilioPartidaGuia.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Domicilio de Partida", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXLabel6.setText("Dirección");
        jXLabel6.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        jXLabel7.setText("Distrito:");
        jXLabel7.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        jXLabel8.setText("Prov.");
        jXLabel8.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        jXLabel9.setText("Dpto.");
        jXLabel9.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        txtDireccionPartidaGuia.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtDistritoPartidaGuia.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtProvinciaPartidaGuia.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtDepartamentoPartidaGuia.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        javax.swing.GroupLayout pnlDomicilioPartidaGuiaLayout = new javax.swing.GroupLayout(pnlDomicilioPartidaGuia);
        pnlDomicilioPartidaGuia.setLayout(pnlDomicilioPartidaGuiaLayout);
        pnlDomicilioPartidaGuiaLayout.setHorizontalGroup(
            pnlDomicilioPartidaGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDomicilioPartidaGuiaLayout.createSequentialGroup()
                .addGroup(pnlDomicilioPartidaGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDomicilioPartidaGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDomicilioPartidaGuiaLayout.createSequentialGroup()
                        .addComponent(txtDistritoPartidaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProvinciaPartidaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDepartamentoPartidaGuia, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                    .addComponent(txtDireccionPartidaGuia, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDomicilioPartidaGuiaLayout.setVerticalGroup(
            pnlDomicilioPartidaGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDomicilioPartidaGuiaLayout.createSequentialGroup()
                .addGroup(pnlDomicilioPartidaGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionPartidaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDomicilioPartidaGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProvinciaPartidaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepartamentoPartidaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDistritoPartidaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlDomicilioLlegadaGuia.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Domicilio de Llegada", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXLabel10.setText("Dirección");
        jXLabel10.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        jXLabel11.setText("Distrito:");
        jXLabel11.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        jXLabel12.setText("Prov.");
        jXLabel12.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        jXLabel13.setText("Dpto.");
        jXLabel13.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        txtDireccionLlegadaGuia1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtDistritoLlegadaGuia.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtProvinciaLlegadaGuia.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtDepartamentoLlegadaGuia.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        btnBuscarLocal.setText("...");
        btnBuscarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLocalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDomicilioLlegadaGuiaLayout = new javax.swing.GroupLayout(pnlDomicilioLlegadaGuia);
        pnlDomicilioLlegadaGuia.setLayout(pnlDomicilioLlegadaGuiaLayout);
        pnlDomicilioLlegadaGuiaLayout.setHorizontalGroup(
            pnlDomicilioLlegadaGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDomicilioLlegadaGuiaLayout.createSequentialGroup()
                .addGroup(pnlDomicilioLlegadaGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDomicilioLlegadaGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDomicilioLlegadaGuiaLayout.createSequentialGroup()
                        .addComponent(txtDistritoLlegadaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProvinciaLlegadaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDepartamentoLlegadaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDomicilioLlegadaGuiaLayout.createSequentialGroup()
                        .addComponent(txtDireccionLlegadaGuia1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDomicilioLlegadaGuiaLayout.setVerticalGroup(
            pnlDomicilioLlegadaGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDomicilioLlegadaGuiaLayout.createSequentialGroup()
                .addGroup(pnlDomicilioLlegadaGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionLlegadaGuia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDomicilioLlegadaGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDistritoLlegadaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProvinciaLlegadaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepartamentoLlegadaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlDestinatarioGuia.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Destinatario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXLabel14.setText("Señores");
        jXLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jXLabel15.setText("Dirección :");
        jXLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jXLabel17.setText("R.U.C. :");
        jXLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtDestinatario.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtDireccionDestinatario.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtRucDestinatario.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        javax.swing.GroupLayout pnlDestinatarioGuiaLayout = new javax.swing.GroupLayout(pnlDestinatarioGuia);
        pnlDestinatarioGuia.setLayout(pnlDestinatarioGuiaLayout);
        pnlDestinatarioGuiaLayout.setHorizontalGroup(
            pnlDestinatarioGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDestinatarioGuiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDestinatarioGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDestinatarioGuiaLayout.createSequentialGroup()
                        .addComponent(jXLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(pnlDestinatarioGuiaLayout.createSequentialGroup()
                        .addGroup(pnlDestinatarioGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlDestinatarioGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccionDestinatario, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(txtDestinatario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(txtRucDestinatario, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDestinatarioGuiaLayout.setVerticalGroup(
            pnlDestinatarioGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDestinatarioGuiaLayout.createSequentialGroup()
                .addGroup(pnlDestinatarioGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDestinatarioGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRucDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDestinatarioGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlUnidTransporteGuia.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Unidad de Transporte/Conductor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXLabel16.setText("Vehiculo Marca y Placa");
        jXLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jXLabel18.setText("Licencia de Conducir ");
        jXLabel18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jXLabel19.setText("Certificado de inscripción");
        jXLabel19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtMarcaPlaca.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtLicenciaConducir.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtCertiInscripcion.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        javax.swing.GroupLayout pnlUnidTransporteGuiaLayout = new javax.swing.GroupLayout(pnlUnidTransporteGuia);
        pnlUnidTransporteGuia.setLayout(pnlUnidTransporteGuiaLayout);
        pnlUnidTransporteGuiaLayout.setHorizontalGroup(
            pnlUnidTransporteGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUnidTransporteGuiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUnidTransporteGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUnidTransporteGuiaLayout.createSequentialGroup()
                        .addComponent(jXLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(pnlUnidTransporteGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jXLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jXLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlUnidTransporteGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMarcaPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtLicenciaConducir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCertiInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlUnidTransporteGuiaLayout.setVerticalGroup(
            pnlUnidTransporteGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUnidTransporteGuiaLayout.createSequentialGroup()
                .addGroup(pnlUnidTransporteGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarcaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUnidTransporteGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCertiInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUnidTransporteGuiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLicenciaConducir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblDetalleGuia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "CANT.", "DESCRIPCION", "PESO", "COSTO TRASLADO", "STOCK"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalleGuia.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblDetalleGuia);
        TableColumn colCodigo= tblDetalleGuia.getColumn("CODIGO");
        colCodigo.setPreferredWidth(30);
        colCodigo.setResizable(false);
        TableColumn colCant= tblDetalleGuia.getColumn("CANT.");
        colCant.setPreferredWidth(15);
        colCant.setResizable(false);
        TableColumn coldescripcion= tblDetalleGuia.getColumn("DESCRIPCION");
        coldescripcion.setPreferredWidth(320);
        coldescripcion.setResizable(false);
        TableColumn colPUnit= tblDetalleGuia.getColumn("PESO");
        colPUnit.setPreferredWidth(20);
        colPUnit.setResizable(false);
        TableColumn colTotal= tblDetalleGuia.getColumn("COSTO TRASLADO");
        colTotal.setPreferredWidth(50);
        colTotal.setResizable(false);

        pnlTransportista.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Transportista", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXLabel20.setText("Nombre :");

        jXLabel21.setText("R.U.C. :");

        btnBuscartrans.setText("...");
        btnBuscartrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscartransActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTransportistaLayout = new javax.swing.GroupLayout(pnlTransportista);
        pnlTransportista.setLayout(pnlTransportistaLayout);
        pnlTransportistaLayout.setHorizontalGroup(
            pnlTransportistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTransportistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTransportistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTransportistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTransportistaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTransportistaLayout.createSequentialGroup()
                        .addComponent(txtTransportistaRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscartrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlTransportistaLayout.setVerticalGroup(
            pnlTransportistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTransportistaLayout.createSequentialGroup()
                .addGroup(pnlTransportistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTransportistaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTransportistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTransportistaRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscartrans, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlMotivoTraslado.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Motivo Traslado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        buttonGroup1.add(rbtVenta);
        rbtVenta.setText("Venta");

        buttonGroup1.add(rbtCompra);
        rbtCompra.setText("Compra");

        buttonGroup1.add(rbtConsignacion);
        rbtConsignacion.setText("Consignación");

        buttonGroup1.add(rbtEmisorItinerante);
        rbtEmisorItinerante.setText("Emisor Itinerante");

        buttonGroup1.add(rbtDevolucion);
        rbtDevolucion.setText("Devolución");

        buttonGroup1.add(rbtImportacion);
        rbtImportacion.setText("Importación");

        buttonGroup1.add(rbtExportacion);
        rbtExportacion.setText("Exportación");

        buttonGroup1.add(rbtTraspaso);
        rbtTraspaso.setText("Traspaso interno");
        rbtTraspaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtTraspasoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMotivoTrasladoLayout = new javax.swing.GroupLayout(pnlMotivoTraslado);
        pnlMotivoTraslado.setLayout(pnlMotivoTrasladoLayout);
        pnlMotivoTrasladoLayout.setHorizontalGroup(
            pnlMotivoTrasladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMotivoTrasladoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMotivoTrasladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMotivoTrasladoLayout.createSequentialGroup()
                        .addComponent(rbtVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtEmisorItinerante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtExportacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtConsignacion))
                    .addGroup(pnlMotivoTrasladoLayout.createSequentialGroup()
                        .addComponent(rbtCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtImportacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtDevolucion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtTraspaso)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMotivoTrasladoLayout.setVerticalGroup(
            pnlMotivoTrasladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMotivoTrasladoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMotivoTrasladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtExportacion, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtConsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtEmisorItinerante, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMotivoTrasladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtImportacion, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtTraspaso, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Comprobante de Pago", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXLabel22.setText("Tipo :");

        jXLabel23.setText("N° :");

        cboComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".:Seleccionar:.", "Boleta", "Factura", "Ticket", "Interno" }));

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtFechaEmisionGuia.setEditable(false);

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Opciones"));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnTraspaso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/enviosolicitud.png"))); // NOI18N
        btnTraspaso.setText("Generar Traspaso");
        btnTraspaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraspasoActionPerformed(evt);
            }
        });

        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarProducto.setText("Buscar Producto");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        jXPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Impresión"));

        btnImprimirGuia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/imprimir.png"))); // NOI18N
        btnImprimirGuia.setText("Imprimir");
        btnImprimirGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirGuiaActionPerformed(evt);
            }
        });

        jXLabel2.setText("Ingrese el Número de Guia");

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnImprimirGuia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(txtImprimir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImprimirGuia, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btnTraspaso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTraspaso, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlMotivoTraslado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dtpFchIniTralsadoGuia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFechaEmisionGuia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(129, 129, 129))
                    .addComponent(pnlRucGuia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTransportista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDestinatarioGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlUnidTransporteGuia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDomicilioPartidaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDomicilioLlegadaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlRucGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dtpFchIniTralsadoGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFechaEmisionGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(pnlMotivoTraslado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pnlDomicilioPartidaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDomicilioLlegadaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pnlDestinatarioGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlUnidTransporteGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlTransportista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setNumeroGuia() {
        txtNumeroGuia.setText(generarNumeroGuia());
        txtImprimir.setText(generarNumeroGuia().substring(0, generarNumeroGuia().lastIndexOf("-") + 1));
    }

    private void setLocal() {
        objLocal = gui.getLocal();
    }

    private void limpiar() {
        txtCertiInscripcion.setText("");
        txtDepartamentoLlegadaGuia.setText("");
        txtDepartamentoPartidaGuia.setText("");
        txtDestinatario.setText("");
        txtDireccionDestinatario.setText("");
        txtDireccionLlegadaGuia1.setText("");
        txtDireccionPartidaGuia.setText("");
        txtDistritoLlegadaGuia.setText("");
        txtDistritoPartidaGuia.setText("");
//    txtFechaEmisionGuia.setText("");
        txtLicenciaConducir.setText("");
        txtMarcaPlaca.setText("");
        txtNumeroComprobante.setText("");
        txtProvinciaLlegadaGuia.setText("");
        txtProvinciaPartidaGuia.setText("");
        txtRucDestinatario.setText("");
        txtTransportistaNombre.setText("");
        txtTransportistaRuc.setText("");
        modelo = new DefaultTableModel();

        tblDetalleGuia.setModel(modelo);
        cargarPartida();
        setNumeroGuia();

    }

    private void setearFecha() {

//        System.out.println("fecha--:"+PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql().substring(0, 10));
        Date fecha = Util.StringTODate(PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql().substring(0, 10));
        dtpFchIniTralsadoGuia.setDate(fecha);

    }

    private String generarNumeroGuia() {
        String codLocal = objLocal.getStr_codLocalGuia();
        int correlativo = -1;
        String arr[] = null;
        String numeroGuia = null;
        listaGuiaRemision = PaqueteBusinessDelegate.getGuiaRemisionService().buscarGuias("%%", "%%", "%%");

        if (listaGuiaRemision.isEmpty()) {
            correlativo = 1;

        } else {
            for (int i = 0; i < listaGuiaRemision.size(); i++) {
//            System.out.println("localPartida--:"+listaGuiaRemision.get(i).getStr_localPartida());   
//            System.out.println("local--:"+objLocal.getStr_nombre());
                if (listaGuiaRemision.get(i).getStr_localPartida().
                        equalsIgnoreCase(objLocal.getStr_nombre())) {
//             System.out.println("locales Iguales");
                    arr = listaGuiaRemision.get(i).getStr_nroGuia().split("-");
//              System.out.println("correlativo---: "+correlativo);
//              System.out.println("ultima guia--:"+Util.stringTOint(arr[2]));
                    if (correlativo <= Util.stringTOint(arr[2])) {
                        correlativo = Util.stringTOint(arr[2]) + 1;
//                    System.out.println("se iguala el correlativo al numero de la guia +1--:"+correlativo);
                        numeroGuia = "GR-" + codLocal + "-" + correlativo;
                        return numeroGuia;
                    }
                } else {
                    correlativo = 1;
//                  System.out.println("dios sabe por que entro aquí");
                }
            }
        }
//    System.out.println("codLocal---"+codLocal);
//    System.out.println("correlativo---:"+correlativo);
        numeroGuia = "GR-" + codLocal + "-" + correlativo;

        return numeroGuia;
    }

private void rbtTraspasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtTraspasoActionPerformed
    if (rbtTraspaso.isSelected()) {
        objEmpresa = gui.getEmpresa();
//        objLocal=;
        txtDireccionPartidaGuia.setText(objLocal.getStr_direccion() + " -.- " + objLocal.getStr_nombre());
        txtDepartamentoPartidaGuia.setText(objLocal.getStr_departamento());
        txtDistritoPartidaGuia.setText(objLocal.getStr_distrito());
        txtProvinciaPartidaGuia.setText(objLocal.getStr_provincia());

    }
}//GEN-LAST:event_rbtTraspasoActionPerformed
    private void cargarPartida() {
        txtDireccionPartidaGuia.setText(objLocal.getStr_direccion() + " -.- " + objLocal.getStr_nombre());
        txtDepartamentoPartidaGuia.setText(objLocal.getStr_departamento());
        txtDistritoPartidaGuia.setText(objLocal.getStr_distrito());
        txtProvinciaPartidaGuia.setText(objLocal.getStr_provincia());
    }

    public void cargarLocalLlegada(com.gestionmatriz.recursoshumanos.bean.Local objLoc) {
//    System.out.println("obj ----"+objLoc.getStr_nombre());
        txtDireccionLlegadaGuia1.setText((objLoc.getStr_direccion() + "-.-" + objLoc.getStr_nombre()).trim());
        txtDepartamentoLlegadaGuia.setText(objLoc.getStr_departamento());
        txtDistritoLlegadaGuia.setText(objLoc.getStr_distrito());
        txtProvinciaLlegadaGuia.setText(objLoc.getStr_provincia());
    }

private void btnBuscarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLocalActionPerformed
    BuscarLocal frmBuscarLocal;
    Util.hiloProgressBar(1, gui);
    if (rbtTraspaso.isSelected() == true) {
        frmBuscarLocal = new BuscarLocal(gui, this, 1);
    } else {
        frmBuscarLocal = new BuscarLocal(gui, this, -1);
    }
    Util.hiloProgressBar(0, gui);
    frmBuscarLocal.setVisible(true);

}//GEN-LAST:event_btnBuscarLocalActionPerformed

private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
//    List<Producto> listaProductos = PaqueteBusinessDelegate.getProductoService().
//            buscarProducto("%%", "%%", "%%", "%%", "%%");

    List<ConsultaStock> listaConsultarStock = new ArrayList<>();

    Util.hiloProgressBar(1, gui);
    BusquedaStock frmBusquedaStock = new BusquedaStock(gui, this);
//    BuscarProducto frmBuscarProducto = new BuscarProducto(gui, listaProductos, this, 1);
    Util.hiloProgressBar(0, gui);
//    frmBusquedaStock.cargarPanelBusqueda(listaConsultarStock);
    frmBusquedaStock.setVisible(true);



}//GEN-LAST:event_btnBuscarProductoActionPerformed

private void btnBuscartransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscartransActionPerformed

    List<com.gestionmatriz.almacen.bean.Proveedor> listaProveedores =
            PaqueteBusinessDelegate.getProveedorService().
            buscarProveedor("%" + txtTransportistaRuc.getText().trim() + "%", "%%");

//        System.out.println("lista---"+listaProveedores.size());
    if (listaProveedores.size() == 1) {
        for (com.gestionmatriz.almacen.bean.Proveedor objProve : listaProveedores) {
            cargarDatosBusquedaProveedor(objProve);
//                this.objProveedor = objProve;
        }
    } else if (listaProveedores.size() > 1) {
        com.gestionmatriz.util.Util.hiloProgressBar(1, gui);
        BuscarProveedor frmBuscarProveedor = new BuscarProveedor(gui, listaProveedores, this, 2);
        com.gestionmatriz.util.Util.hiloProgressBar(0, gui);
        frmBuscarProveedor.cargarPanelBusquedaProveedor(listaProveedores);
        frmBuscarProveedor.setVisible(true);
    }


}//GEN-LAST:event_btnBuscartransActionPerformed

private void btnTraspasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraspasoActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getGUIA_GENERAR_TRASPASO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    Util.hiloProgressBar(1, gui);
    if (frmTraspasoMercaderia == null || frmTraspasoMercaderia.isClosed()) {
        frmTraspasoMercaderia = new TraspasoMercaderia(gui);
        frmTraspasoMercaderia.setVisible(true);
        gui.addFrm(frmTraspasoMercaderia);
        gui.enforcar(frmTraspasoMercaderia);
        gui.getBarraEstado().nuevaVentanas();
        Util.setCentrarJInternalFrame(frmTraspasoMercaderia);
    }
    Util.hiloProgressBar(0, gui);


}//GEN-LAST:event_btnTraspasoActionPerformed

private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getGUIA_REGISTRAR())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    if (txtNumeroGuia.getText().equalsIgnoreCase("")) {
        Mensaje.mensaje(this, "Debe Ingresar un número de guía", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (txtDireccionPartidaGuia.getText().equalsIgnoreCase("")) {
        Mensaje.mensaje(this, "Debe Existir una dirección de salida", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (txtDireccionLlegadaGuia1.getText().equalsIgnoreCase("")) {
        Mensaje.mensaje(this, "Debe Existir una dirección de llegada", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (dtpFchIniTralsadoGuia.getDate() == null) {
        Mensaje.mensaje(this, "Debe Seleccionar una fecha para el trapaso", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (rbtTraspaso.isSelected() == false) {
        if (cboComprobante.getSelectedIndex() == 0) {
            Mensaje.mensaje(this, "Debe Seleccionar un tipo de comprobante", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
    }

    if (tblDetalleGuia.getRowCount() <= 0) {
        Mensaje.mensaje(this, "Debe seleccionar productos para la guia", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        return;
    }
    if (validarFechaTraspaso() == false) {
        Mensaje.mensaje(this, "La fecha de traslado no puede ser menor a la fecha de emisión de la Guía", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }



    com.gestionmatriz.puntoventa.bean.GuiaRemision objGuiaRemision =
            new com.gestionmatriz.puntoventa.bean.GuiaRemision();

    String motivo = (rbtTraspaso.isSelected() == true) ? "Traspaso"
            : (rbtCompra.isSelected() == true) ? "Compra"
            : (rbtConsignacion.isSelected() == true) ? "Consignacion"
            : (rbtExportacion.isSelected() == true) ? "Exportacion"
            : (rbtImportacion.isSelected() == true) ? "Importacion"
            : (rbtVenta.isSelected() == true) ? "Venta" : "Itinerante";

    objGuiaRemision.setStr_nroGuia(txtNumeroGuia.getText());
    objGuiaRemision.setDte_fechaTraslado(Util.getFecha("yyyy-MM-dd", dtpFchIniTralsadoGuia.getDate()));
    objGuiaRemision.setStr_motivoTraslado(motivo);
    objGuiaRemision.setStr_domicilioPartida(txtDireccionPartidaGuia.getText() + "-.-" + txtDistritoPartidaGuia.getText() + " -.- "
            + txtProvinciaPartidaGuia.getText() + " -.- " + txtDepartamentoPartidaGuia.getText());
    objGuiaRemision.setStr_domicilioLlegada(txtDireccionLlegadaGuia1.getText() + " -.- " + txtDistritoLlegadaGuia.getText() + " -.- "
            + txtProvinciaLlegadaGuia.getText() + " -.- " + txtDepartamentoLlegadaGuia.getText());
    objGuiaRemision.setStr_placaMarcaVehiculo(txtMarcaPlaca.getText());
    objGuiaRemision.setStr_inscripcionVehiculo(txtCertiInscripcion.getText());
    objGuiaRemision.setStr_brevete(txtLicenciaConducir.getText());
    objGuiaRemision.setStr_destinatarioNombre(txtDestinatario.getText());
    objGuiaRemision.setStr_destinatarioRuc(txtRucDestinatario.getText());
    objGuiaRemision.setStr_destinatarioDireccion(txtDireccionDestinatario.getText());
    objGuiaRemision.setStr_comprobante(cboComprobante.getSelectedItem().toString());
    objGuiaRemision.setStr_nroComprobante(txtNumeroComprobante.getText());
    objGuiaRemision.setStr_estado(Util.ACTIVO);
    objGuiaRemision.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());
    objGuiaRemision.setStr_localPartida(objLocal.getStr_nombre());
    objGuiaRemision.setStr_rucTranportista(txtTransportistaRuc.getText());
    objGuiaRemision.setStr_nombreTransportista(txtTransportistaNombre.getText());

//    System.out.println("Lista--:"+listaStock.size());
//    System.out.println("tabla--:"+tblDetalleGuia.getRowCount());
    for (int i = 0; i < tblDetalleGuia.getRowCount(); i++) {

        if (tblDetalleGuia.getValueAt(i, 1) == null || tblDetalleGuia.getValueAt(i, 3) == null
                || tblDetalleGuia.getValueAt(i, 4) == null) {
            Mensaje.mensaje(this, "No puede dejar campos vacios", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;

        }
        BigDecimal cantidad = new BigDecimal(tblDetalleGuia.getValueAt(i, 1).toString());
//        System.out.println("i---:"+i);
        if (listaStock.get(i).getDbl_stock().compareTo(cantidad) ==-1) {
            Mensaje.mensaje(this, "La cantidad no puede superar el stock diponible", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        if (cantidad.compareTo(BigDecimal.ZERO) <= 0) {

            Mensaje.mensaje(this, "La cantidad no puede ser negativa ni cero", Mensaje.TITULO_ME, Mensaje.ERROR);
            tblDetalleGuia.setValueAt(1, i, 1);
            return;
        }
    }


//      String proveedor = "";
        DetalleGuiaRemision objDetalleGuia ;
        List<DetalleGuiaRemision> lstDetalleGuia = new ArrayList<>();
        
        for (int i = 0; i < listaDetalleGuia.size(); i++) {
            objDetalleGuia = new DetalleGuiaRemision();
            objDetalleGuia.setInt_idProducto(listaDetalleGuia.get(i).getObjProducto().getInt_idProducto());
            BigDecimal cant =new  BigDecimal(tblDetalleGuia.getValueAt(i, 1).toString());
            objDetalleGuia.setDbl_cantdadProducto(cant .divide(listaDetalleGuia.get(i).getObjConsultaStock().getDlb_stockXCompra()) );
            objDetalleGuia.setStr_descripcionProducto(listaDetalleGuia.get(i).getObjProducto().getStr_nombreProducto());
            objDetalleGuia.setDbl_peso(new BigDecimal(tblDetalleGuia.getValueAt(i, 3).toString()));
            objDetalleGuia.setDbl_costoTraspaso(new BigDecimal(tblDetalleGuia.getValueAt(i, 4).toString()));
            objDetalleGuia.setStr_estado(Util.ACTIVO);
            objDetalleGuia.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());
            objDetalleGuia.setInt_idProveedor(listaDetalleGuia.get(i).getInt_idProveedor());
            lstDetalleGuia.add(objDetalleGuia);
        }
        
    if (PaqueteBusinessDelegate.getGuiaRemisionService().
            registrarGuiaRemision(objGuiaRemision,lstDetalleGuia) == true) {

      
        Mensaje.mensaje(this, "Se registro la Guía correctamente", Mensaje.TITULO_ME, Mensaje.INFORMACION);


        limpiar();
        listaProductos.clear();
    } else {
        Mensaje.mensaje(this, "Error al registrar la Guía", Mensaje.TITULO_ME, Mensaje.ERROR);
    }


}//GEN-LAST:event_btnRegistrarActionPerformed

private void mnuQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuQuitarProductoActionPerformed
    int index = tblDetalleGuia.getSelectedRow();

    if (index < 0) {
        return;
    }
    listaDetalleGuia.remove(index);
    cargarTabla(tblDetalleGuia, listaDetalleGuia);

}//GEN-LAST:event_mnuQuitarProductoActionPerformed

private void btnImprimirGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirGuiaActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getGUIA_IMPRIMIR())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    Ireport ireport = new Ireport();
    ireport.imprmirGuia(txtImprimir.getText());
}//GEN-LAST:event_btnImprimirGuiaActionPerformed

private void dtpFchIniTralsadoGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtpFchIniTralsadoGuiaActionPerformed
    String fecha=Util.getFecha("dd-MM-yyyy", dtpFchIniTralsadoGuia.getDate());
    txtFechaEmisionGuia.setText(fecha);
}//GEN-LAST:event_dtpFchIniTralsadoGuiaActionPerformed

    private void obtenerFecha() {
        txtFechaEmisionGuia.setText(PaqueteBusinessDelegate.getUtilMysqlServices().
                getFechaMysql().substring(0, 10));
    }

    private void setRuc() {
        objEmpresa = gui.getEmpresa();
        lblRucGuia.setText("R.U.C.  N° : " + objEmpresa.getStr_ruc());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscarLocal;
    private org.jdesktop.swingx.JXButton btnBuscarProducto;
    private org.jdesktop.swingx.JXButton btnBuscartrans;
    private org.jdesktop.swingx.JXButton btnImprimirGuia;
    private org.jdesktop.swingx.JXButton btnRegistrar;
    private org.jdesktop.swingx.JXButton btnTraspaso;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXComboBox cboComprobante;
    private org.jdesktop.swingx.JXDatePicker dtpFchIniTralsadoGuia;
    private javax.swing.JPopupMenu jPopupMenu1;
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
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel20;
    private org.jdesktop.swingx.JXLabel jXLabel21;
    private org.jdesktop.swingx.JXLabel jXLabel22;
    private org.jdesktop.swingx.JXLabel jXLabel23;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXLabel lblRucGuia;
    private javax.swing.JMenuItem mnuQuitarProducto;
    private org.jdesktop.swingx.JXPanel pnlDestinatarioGuia;
    private org.jdesktop.swingx.JXPanel pnlDomicilioLlegadaGuia;
    private org.jdesktop.swingx.JXPanel pnlDomicilioPartidaGuia;
    private org.jdesktop.swingx.JXPanel pnlMotivoTraslado;
    private org.jdesktop.swingx.JXPanel pnlRucGuia;
    private org.jdesktop.swingx.JXPanel pnlTransportista;
    private org.jdesktop.swingx.JXPanel pnlUnidTransporteGuia;
    private javax.swing.JRadioButton rbtCompra;
    private javax.swing.JRadioButton rbtConsignacion;
    private javax.swing.JRadioButton rbtDevolucion;
    private javax.swing.JRadioButton rbtEmisorItinerante;
    private javax.swing.JRadioButton rbtExportacion;
    private javax.swing.JRadioButton rbtImportacion;
    private javax.swing.JRadioButton rbtTraspaso;
    private javax.swing.JRadioButton rbtVenta;
    private org.jdesktop.swingx.JXTable tblDetalleGuia;
    private org.jdesktop.swingx.JXTextField txtCertiInscripcion;
    private org.jdesktop.swingx.JXTextField txtDepartamentoLlegadaGuia;
    private org.jdesktop.swingx.JXTextField txtDepartamentoPartidaGuia;
    private org.jdesktop.swingx.JXTextField txtDestinatario;
    private org.jdesktop.swingx.JXTextField txtDireccionDestinatario;
    private org.jdesktop.swingx.JXTextField txtDireccionLlegadaGuia1;
    private org.jdesktop.swingx.JXTextField txtDireccionPartidaGuia;
    private org.jdesktop.swingx.JXTextField txtDistritoLlegadaGuia;
    private org.jdesktop.swingx.JXTextField txtDistritoPartidaGuia;
    private org.jdesktop.swingx.JXTextField txtFechaEmisionGuia;
    private org.jdesktop.swingx.JXTextField txtImprimir;
    private org.jdesktop.swingx.JXTextField txtLicenciaConducir;
    private org.jdesktop.swingx.JXTextField txtMarcaPlaca;
    private org.jdesktop.swingx.JXTextField txtNumeroComprobante;
    private org.jdesktop.swingx.JXTextField txtNumeroGuia;
    private org.jdesktop.swingx.JXTextField txtProvinciaLlegadaGuia;
    private org.jdesktop.swingx.JXTextField txtProvinciaPartidaGuia;
    private org.jdesktop.swingx.JXTextField txtRucDestinatario;
    private org.jdesktop.swingx.JXTextField txtTransportistaNombre;
    private org.jdesktop.swingx.JXTextField txtTransportistaRuc;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
//        try {
        gui.getBarraEstado().cerraVentana();
//            setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
//            this.setClosed(true);
//        } catch (PropertyVetoException ex) {
//            log.error("Error al Intentar Cerrar Ventana Persona: "+ex.getMessage());
//        }
    }

    public void cargarDatosBusquedaProducto(Producto p) {
        DetalleGuiaRemision objDetalleGuia = new DetalleGuiaRemision();

        for (int i = 0; i < listaDetalleGuia.size(); i++) {
            if (listaDetalleGuia.get(i).getInt_idProducto() == p.getInt_idProducto()) {
                Mensaje.mensaje(this, "Producto ya está asignado", Mensaje.TITULO_ME, Mensaje.ERROR);
//                btnBuscarProductoActionPerformed(null);
                return;
            }
        }

        objDetalleGuia.setInt_idProducto(p.getInt_idProducto());
        objDetalleGuia.setStr_descripcionProducto(p.getStr_descripcion());
        objDetalleGuia.setObjProducto(p);
        listaDetalleGuia.add(objDetalleGuia);
        cargarTabla(tblDetalleGuia, listaDetalleGuia);
    }

    public void cargarTabla(JXTable tabla, List lista) {
        Object[] filaTabla = new Object[6];
        modelo = (DefaultTableModel) tabla.getModel();
        int i = 0;

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (Object a : lista) {
            if (a instanceof DetalleGuiaRemision) {
//                boolean b = ((((ProveedorProductoOrdenCompraFacturaCompra) a).getStr_estado().equals("CERRADO")) ? true : false);
                filaTabla[0] = ((DetalleGuiaRemision) a).getObjProducto().getStr_codigoInterno();
                filaTabla[1] = 1;//((Producto) a).getObjProveedorProductoOrdenCompra().getObjProducto().getStr_nombreProducto();
                filaTabla[2] = ((DetalleGuiaRemision) a).getObjProducto().getStr_nombreProducto();
                filaTabla[3] = 0;//((Producto) a).getObjProveedorProductoOrdenCompra().getInt_cantidad();
                filaTabla[4] = 0;//((Producto) a).getInt_cantidadRecibida();
                filaTabla[5] = ((DetalleGuiaRemision) a).getObjConsultaStock().getDbl_stock();

                modelo.addRow(filaTabla);
            }

            i++;
        }

        tabla.setModel(modelo);
    }

    public void cargarDatosBusquedaProveedor(Proveedor objProve) {

        txtTransportistaNombre.setText(objProve.getStr_razonSocial());
        txtTransportistaRuc.setText(objProve.getStr_ruc());
    }

    public void recibirProveedorProducto(List<ProveedorProducto> proveeProd) {
        listaProveeProdu = proveeProd;
    }

    public boolean validarFechaTraspaso() {
        boolean b = true;
        Date fchEmisio = Util.StringTODate(txtFechaEmisionGuia.getText());

        if (dtpFchIniTralsadoGuia.getDate().before(fchEmisio)) {
            b = false;
            dtpFchIniTralsadoGuia.setDate(fchEmisio);
        }

        return b;
    }

    void cargarDatos(ConsultaStock objConsultaStock) {
        DetalleGuiaRemision objDetalleGuia = new DetalleGuiaRemision();
//        listaStock=new ArrayList<>();
        for (int i = 0; i < listaDetalleGuia.size(); i++) {
            if (listaDetalleGuia.get(i).getInt_idProducto() == objConsultaStock.getObjProducto().getInt_idProducto()) {
                Mensaje.mensaje(this, "Producto ya está asignado", Mensaje.TITULO_ME, Mensaje.ERROR);
//                btnBuscarProductoActionPerformed(null);
                return;
            }
        }

        objDetalleGuia.setInt_idProducto(objConsultaStock.getObjProducto().getInt_idProducto());
        objDetalleGuia.setStr_descripcionProducto(objConsultaStock.getObjProducto().getStr_nombreProducto());
        objDetalleGuia.setObjProducto(objConsultaStock.getObjProducto());
        objDetalleGuia.setInt_idProveedor(("" + objConsultaStock.getObjProveedor().getInt_idProveedor()).trim());
//        this.objConsultaStock=objConsultaStock;
        objDetalleGuia.setObjConsultaStock(objConsultaStock);
        listaStock.add(objConsultaStock);
        listaDetalleGuia.add(objDetalleGuia);
        cargarTabla(tblDetalleGuia, listaDetalleGuia);
    }
    
    
    public void imprimirGuia(){
        List<ImprimirGuia> listaImprimirGuia =
                PaqueteBusinessDelegate.getGuiaRemisionService().imprimirGuia("");
        
        Impresora imp=new Impresora();
//        
//        String []fechas={listaImprimirGuia.get(1).getDte_fechaEmision(),listaImprimirGuia.get(1).getDte_fechaInicioTraslado()};
//        String []domicilioPartLlega={}
//        
//        imp.imprimirGuiaRemision(fechas, domicilioPartLlega, destinatario, vehiculo, prod, trasnportista, Comprobante, motivo);
    }
}
