/*
 * ConformidadCompra.java
 *
 * Created on 07-jun-2012, 11:09:08
 */
package com.gestionmatriz.almacen.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXTable;

import com.gestionmatriz.almacen.bean.OrdenCompra;
import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompraFacturaCompra;
import com.gestionmatriz.almacen.opciones.Opciones;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import java.math.BigInteger;

/**
 *
 * @author zholo
 */
public class ConformidadCompra extends javax.swing.JInternalFrame {

	private static final Logger log=Logger.getLogger(ConformidadCompra.class);
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal gui;
    private OrdenCompra objOrdenCompra;
    private List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC = new ArrayList<>();
    private List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC2 = new ArrayList<>();
//    private int cantidadesVerificadas = 1;
//    private int cantidadesIguales = 1;
    private int i = 0;
    private int puntero;

    public ConformidadCompra(Principal gui, OrdenCompra objOC, List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC, int pun) {
        this.gui = gui;
        this.objOrdenCompra = objOC;
        this.listaPPOCFC = listaPPOCFC;
        this.puntero = pun;
        initComponents();
        cargarDatos();
    }

    public ConformidadCompra(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXTextField1 = new org.jdesktop.swingx.JXTextField();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        txtProveedor = new org.jdesktop.swingx.JXTextField();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        txtRucProvee = new org.jdesktop.swingx.JXTextField();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        txtDireccionProvee = new org.jdesktop.swingx.JXTextField();
        txtCodigoProvee = new org.jdesktop.swingx.JXTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtOrdenCompra = new org.jdesktop.swingx.JXTextField();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        txtMontoTotalCompra = new org.jdesktop.swingx.JXTextField();
        btnBuscarOrdenCompra = new org.jdesktop.swingx.JXButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConformidad = new org.jdesktop.swingx.JXTable();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblObservaciones = new org.jdesktop.swingx.JXTable();
        btnGrabar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnlOpciones1 = new org.jdesktop.swingx.JXPanel();
        btnRegistrar = new org.jdesktop.swingx.JXButton();
        btnBuscar = new org.jdesktop.swingx.JXButton();
        btnModificar = new org.jdesktop.swingx.JXButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONFORMIDAD DE COMPRA");

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Conformidad de Adquisición", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXLabel1.setText("Número de Conformidad :");

        jXTextField1.setEditable(false);

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del Proveedor"));

        jXLabel3.setText("Proveedor :");

        txtProveedor.setEditable(false);

        jXLabel4.setText("R.U.C. :");

        txtRucProvee.setEditable(false);

        jXLabel5.setText("Dirección :");

        jXLabel6.setText("Código :");

        txtDireccionProvee.setEditable(false);

        txtCodigoProvee.setEditable(false);

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDireccionProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigoProvee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRucProvee, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRucProvee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionProvee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoProvee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXLabel2.setText("Orden de Compra N° :");

        txtOrdenCompra.setEditable(false);

        jXLabel9.setText("Monto Total de la compra :");

        txtMontoTotalCompra.setEditable(false);

        btnBuscarOrdenCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarOrdenCompra.setText("Buscar");
        btnBuscarOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarOrdenCompraActionPerformed(evt);
            }
        });

        tblConformidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Factura", "Guía", "Fecha Recepción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblConformidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConformidadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblConformidad);

        jXLabel7.setText("Documentos asociados a la Orden de Compra:");

        jXLabel8.setText("Detalle de observaciones");

        tblObservaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad recibida", "OK", "Falla Proveedor", "Falla Transportista", "Falla Otros", "Observacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblObservaciones.setColumnControlVisible(true);
        tblObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblObservacionesKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblObservaciones);

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        jLabel1.setText("Por cada Documento Asociado grabar sus Observaciones");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jXTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(btnBuscarOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMontoTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(jXLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                        .addGap(375, 375, 375))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(btnGrabar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMontoTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrabar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpciones1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Opciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/registrar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpciones1Layout = new javax.swing.GroupLayout(pnlOpciones1);
        pnlOpciones1.setLayout(pnlOpciones1Layout);
        pnlOpciones1Layout.setHorizontalGroup(
            pnlOpciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpciones1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlOpciones1Layout.setVerticalGroup(
            pnlOpciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpciones1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOpciones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlOpciones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 330, Short.MAX_VALUE))
                    .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCONFORMIDADCOMPRA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    if (objOrdenCompra == null) {
        Mensaje.mensaje(this, "Buscar Orden de Compra", Mensaje.TITULO_ME, Mensaje.ERROR);
        btnBuscarOrdenCompra.requestFocus();
        return;
    }

    if (i == 0) {
        Mensaje.mensaje(this, "Seleccionar documento a llenar en la primera tabla", Mensaje.TITULO_ME, Mensaje.ERROR);
        tblConformidad.requestFocus();
        return;
    }

    if (/*(cantidadesVerificadas == 1) && (cantidadesIguales == 1) && */(!verificarDatosTabla())) {
//        Mensaje.mensaje(this, "Verificar datos ingresados - Presionar Enter en la tabla Observaciones", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    if (PaqueteBusinessDelegate.getConformidadService().registrarConformidad(listaPPOCFC2)) {
        Mensaje.mensaje(this, "Conformidad registrada", Mensaje.TITULO_ME, Mensaje.INFORMACION);
    } else {
        Mensaje.mensaje(this, "Error al registrar", Mensaje.TITULO_ME, Mensaje.ERROR);
    }
}//GEN-LAST:event_btnRegistrarActionPerformed

private void tblConformidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConformidadMouseClicked
    grabarTablaObservacion();
}//GEN-LAST:event_tblConformidadMouseClicked

private void tblObservacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblObservacionesKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        if (!verificarDatosTabla()) {
            return;
        }
    }
}//GEN-LAST:event_tblObservacionesKeyPressed

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
}//GEN-LAST:event_btnBuscarActionPerformed

private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
}//GEN-LAST:event_btnModificarActionPerformed

private void btnBuscarOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarOrdenCompraActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCONFORMIDADCOMPRA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    List<OrdenCompra> listaOrdenCompraTemp = new ArrayList<>();
    List<OrdenCompra> listaOrdenCompra = new ArrayList<>();

    try {
        listaOrdenCompraTemp = PaqueteBusinessDelegate.getOrdenCompraService().buscarOrdenCompra("", "", "", "", "");

        for (OrdenCompra objOCTemp : listaOrdenCompraTemp) {
            if ((objOCTemp.getStr_estado().equals(Util.PENDIENTE))
                    || (objOCTemp.getStr_estado().equals(Util.CERRADO))) {
                listaOrdenCompra.add(objOCTemp);
            }
        }
        
        if (listaOrdenCompra.isEmpty()) {
            Mensaje.mensaje(this, "No existen Ordenes de Compra: ", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        } else if (listaOrdenCompra.size() == 1) {
            limpiarTablas(tblConformidad);
            limpiarTablas(tblObservaciones);
            cargarDatosBusquedaOrdenCompra(listaOrdenCompra.get(0));
        } else if (listaOrdenCompra.size() > 1) {
            limpiarTablas(tblConformidad);
            limpiarTablas(tblObservaciones);
            Util.hiloProgressBar(1, gui);
            BuscarOrdenCompra frmBuscarOrdenCompra = new BuscarOrdenCompra(gui, listaOrdenCompra, this, 2);
            Util.hiloProgressBar(0, gui);
            frmBuscarOrdenCompra.cargarPanelBusquedaOrdenCompra(listaOrdenCompra);
            frmBuscarOrdenCompra.setVisible(true);
        }
    } catch (Exception ex) {
        log.error("ERROR: "+ex.getMessage());
    }
}//GEN-LAST:event_btnBuscarOrdenCompraActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        grabarTablaObservacion();
    }//GEN-LAST:event_btnGrabarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscar;
    private org.jdesktop.swingx.JXButton btnBuscarOrdenCompra;
    private javax.swing.JButton btnGrabar;
    private org.jdesktop.swingx.JXButton btnModificar;
    private org.jdesktop.swingx.JXButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXTextField jXTextField1;
    private org.jdesktop.swingx.JXPanel pnlOpciones1;
    private org.jdesktop.swingx.JXTable tblConformidad;
    private org.jdesktop.swingx.JXTable tblObservaciones;
    private org.jdesktop.swingx.JXTextField txtCodigoProvee;
    private org.jdesktop.swingx.JXTextField txtDireccionProvee;
    private org.jdesktop.swingx.JXTextField txtMontoTotalCompra;
    private org.jdesktop.swingx.JXTextField txtOrdenCompra;
    private org.jdesktop.swingx.JXTextField txtProveedor;
    private org.jdesktop.swingx.JXTextField txtRucProvee;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
        objOrdenCompra = new OrdenCompra();
        listaPPOCFC = new ArrayList<>();
        listaPPOCFC2 = new ArrayList<>();
    }

    private void cargarDatos() {
        btnModificar.setEnabled(false);
        tblConformidad.setSortable(false);
        tblObservaciones.setSortable(false);

        if (puntero == 1) {
            cargarDatosBusquedaOrdenCompra(objOrdenCompra);
            cargarTabla(tblConformidad, listaPPOCFC, 1, "", null);
        }
    }

    protected void cargarDatosBusquedaOrdenCompra(OrdenCompra objOC) {
        txtProveedor.setText(objOC.getObjProveedor().getStr_razonSocial());
        txtDireccionProvee.setText(objOC.getObjProveedor().getStr_direccion());
        txtRucProvee.setText(objOC.getObjProveedor().getStr_ruc());
        txtCodigoProvee.setText("" + objOC.getObjProveedor().getInt_idProveedor());
        txtOrdenCompra.setText(objOC.getStr_numeroOC());
        txtMontoTotalCompra.setText("" + objOC.getDbl_precioTotal());

        listaPPOCFC = PaqueteBusinessDelegate.getRecepcionMercaderiaService().
                listarPPOCFC(objOC.getInt_idOrdenCompra());
        cargarTabla(tblConformidad, listaPPOCFC, 1, "", null);

        objOrdenCompra = objOC;
    }

    private void cargarTabla(JXTable tabla, List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC,
            int d, String numeroFactura, List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC2) {
        if (d == 1) {
            Object[] filaTabla = new Object[3];
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }

            for (ProveedorProductoOrdenCompraFacturaCompra objPPOCFC : listaPPOCFC) {
                if (!verificarNF(objPPOCFC.getStr_numeroFactura(), modelo)) {
                    filaTabla[0] = objPPOCFC.getStr_numeroFactura();
                    modelo.addRow(filaTabla);
                }
            }

            tabla.setModel(modelo);
        } else if (d == 2) {
            Object[] filaTabla = new Object[7];
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            ProveedorProductoOrdenCompraFacturaCompra objPPOCFCTemp;

            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }

            for (int i = 0; i < listaPPOCFC.size(); i++) {
                if (listaPPOCFC.get(i).getStr_numeroFactura().equals(numeroFactura)) {
                    filaTabla[0] = listaPPOCFC.get(i).getObjProveedorProductoOrdenCompra().getObjProducto().getStr_nombreProducto();

                    objPPOCFCTemp = buscarPPOCFC(listaPPOCFC.get(i).getObjProveedorProductoOrdenCompra().
                            getObjProducto().getStr_nombreProducto(), listaPPOCFC2);

                    if (objPPOCFCTemp == null) {
                        filaTabla[1] = listaPPOCFC.get(i).getDbl_cantidadRecibida();
                        filaTabla[2] = listaPPOCFC.get(i).getDbl_conformidadOK();
                        filaTabla[3] = listaPPOCFC.get(i).getDbl_conformidadFallaProveedor();
                        filaTabla[4] = listaPPOCFC.get(i).getDbl_conformidadFallaTransportista();
                        filaTabla[5] = listaPPOCFC.get(i).getDbl_conformidadFallaOtro();
                        filaTabla[6] = listaPPOCFC.get(i).getStr_conformidadObservacion();
                    } else {
                        filaTabla[1] = objPPOCFCTemp.getDbl_cantidadRecibida();
                        filaTabla[2] = objPPOCFCTemp.getDbl_conformidadOK();
                        filaTabla[3] = objPPOCFCTemp.getDbl_conformidadFallaProveedor();
                        filaTabla[4] = objPPOCFCTemp.getDbl_conformidadFallaTransportista();
                        filaTabla[5] = objPPOCFCTemp.getDbl_conformidadFallaOtro();
                        filaTabla[6] = objPPOCFCTemp.getStr_conformidadObservacion();
                    }

                    modelo.addRow(filaTabla);
                }
            }

            tabla.setModel(modelo);
        }
    }

    private void limpiarTablas(JXTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    private String numeroFactura() {
        int indice = tblConformidad.getSelectedRow();
        return tblConformidad.getValueAt(indice, 0).toString();
    }

    private boolean verificarNF(String numeroFactura, DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (numeroFactura.equals(modelo.getValueAt(i, 0).toString())) {
                return true;
            }
        }

        return false;
    }

    private ProveedorProductoOrdenCompraFacturaCompra buscarPPOCFC(String nomProducto,
            List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC) {
        for (ProveedorProductoOrdenCompraFacturaCompra objPPOCFC : listaPPOCFC) {
            if (objPPOCFC.getObjProveedorProductoOrdenCompra().getObjProducto().
                    getStr_nombreProducto().equals(nomProducto)) {
                return objPPOCFC;
            }
        }

        return null;
    }

    private List<ProveedorProductoOrdenCompraFacturaCompra> verificarObjeto(
            List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC,
            ProveedorProductoOrdenCompraFacturaCompra objPPOCFC) {
        for (ProveedorProductoOrdenCompraFacturaCompra objPPOCFCTemp : listaPPOCFC) {
            if (objPPOCFCTemp.getObjProveedorProductoOrdenCompra().getObjProducto().getStr_nombreProducto().
                    equals(objPPOCFC.getObjProveedorProductoOrdenCompra().getObjProducto().getStr_nombreProducto())) {
                return listaPPOCFC;
            } else if (!csm(objPPOCFC, listaPPOCFC)) {
                listaPPOCFC.add(objPPOCFC);
                return listaPPOCFC;
            }
        }

        if (listaPPOCFC.isEmpty()) {
            listaPPOCFC.add(objPPOCFC);
            return listaPPOCFC;
        }

        return null;
    }

    private boolean csm(ProveedorProductoOrdenCompraFacturaCompra objPPOCFC,
            List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC) {
        for (ProveedorProductoOrdenCompraFacturaCompra objCSM : listaPPOCFC) {
            if (objCSM.getObjProveedorProductoOrdenCompra().getObjProducto().getStr_nombreProducto().
                    equals(objPPOCFC.getObjProveedorProductoOrdenCompra().getObjProducto().getStr_nombreProducto())) {
                return true;
            }
        }

        return false;
    }

    private boolean verificarDatosTabla() {
        for (int i = 0; i < tblObservaciones.getRowCount(); i++) {
            BigDecimal sumaCantidades = BigDecimal.ZERO;
            sumaCantidades = sumaCantidades.add((new BigDecimal(tblObservaciones.getValueAt(i, 2).toString())));
            sumaCantidades = sumaCantidades.add( new BigDecimal(tblObservaciones.getValueAt(i, 3).toString()));
            sumaCantidades = sumaCantidades.add( new BigDecimal(tblObservaciones.getValueAt(i, 4).toString()));
            sumaCantidades = sumaCantidades.add( new BigDecimal(tblObservaciones.getValueAt(i, 5).toString()));

            if (sumaCantidades.compareTo((new BigDecimal(tblObservaciones.getValueAt(i, 1).toString())))==1) {
                Mensaje.mensaje(this, "Cantidades ingresadas SOBREPASAN a Cantidad Recibida", Mensaje.TITULO_ME, Mensaje.ERROR);
                return false;
            }

            if (sumaCantidades.compareTo(new BigDecimal(tblObservaciones.getValueAt(i, 1).toString()))==-1) {
                Mensaje.mensaje(this, "Cantidades ingresadas MENORES a Cantidad Recibida", Mensaje.TITULO_ME, Mensaje.ERROR);
                return false;
            }

            if (tblObservaciones.getValueAt(i, 6) == null) {
                Mensaje.mensaje(this, "Llenar campo Observacion", Mensaje.TITULO_ME, Mensaje.ERROR);
                return false;
            }
        }

        return true;
    }

    private void grabarTablaObservacion() {
        ProveedorProductoOrdenCompraFacturaCompra objPPOCFC = null;
        BigDecimal CO = BigDecimal.ZERO, CFP = BigDecimal.ZERO, CFT = BigDecimal.ZERO, CFO = BigDecimal.ZERO;
        String CObs = "";
        
        for (int i = 0; i < tblObservaciones.getRowCount(); i++) {
            objPPOCFC = new ProveedorProductoOrdenCompraFacturaCompra();
            objPPOCFC = buscarPPOCFC(tblObservaciones.getValueAt(i, 0).toString(), listaPPOCFC);

            CO = new BigDecimal(tblObservaciones.getValueAt(i, 2)!=null?tblObservaciones.getValueAt(i, 2).toString():"0");
            CFP = new BigDecimal(tblObservaciones.getValueAt(i, 3)!=null?tblObservaciones.getValueAt(i, 3).toString():"0");
            CFT = new BigDecimal(tblObservaciones.getValueAt(i, 4)!=null?tblObservaciones.getValueAt(i, 4).toString():"0");
            CFO = new BigDecimal(tblObservaciones.getValueAt(i, 5)!=null?tblObservaciones.getValueAt(i, 5).toString():"0");
            if (tblObservaciones.getValueAt(i, 6) == null) {
                CObs = "";
            } else {
                CObs = tblObservaciones.getValueAt(i, 6).toString();
            }
            objPPOCFC.setDbl_conformidadOK(CO);
            objPPOCFC.setDbl_conformidadFallaProveedor(CFP);
            objPPOCFC.setDbl_conformidadFallaTransportista(CFT);
            objPPOCFC.setDbl_conformidadFallaOtro(CFO);
            objPPOCFC.setStr_conformidadObservacion(CObs);
            if ((objPPOCFC.getDbl_cantidadRecibida() == objPPOCFC.getObjProveedorProductoOrdenCompra().getDbl_cantidad())
                    && ((CO.add(CFP).add(CFT).add(CFO)).compareTo(objPPOCFC.getDbl_cantidadRecibida())==0)) {
                objPPOCFC.setStr_conformidadEstado(Util.CERRADO);
            } else {
                objPPOCFC.setStr_conformidadEstado(Util.PENDIENTE);
            }
            objPPOCFC.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());
            listaPPOCFC2 = verificarObjeto(listaPPOCFC2, objPPOCFC);
        }

        cargarTabla(tblObservaciones, listaPPOCFC, 2, numeroFactura(), listaPPOCFC2);

        i = 1;
    }
}
