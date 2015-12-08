/*
 * BoletaVenta.java
 *
 * Created on 22-may-2012, 7:50:05
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.TableColumn;

import org.apache.log4j.Logger;

import com.gestionmatriz.almacen.gui.ConformidadCompra;

/**
 *
 * @author zholo
 */
public class BoletaVenta extends javax.swing.JFrame {

	private static final Logger log=Logger.getLogger(BoletaVenta.class);
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BoletaVenta() {
        initComponents();
        cargarFotoEmpresa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEmpresaBoleta = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtsDatos = new org.jdesktop.swingx.JXTextArea();
        lblFoto = new org.jdesktop.swingx.JXLabel();
        pnlRuc = new org.jdesktop.swingx.JXPanel();
        lblRucBoleta = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        pnlClienteVendeddor = new org.jdesktop.swingx.JXPanel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        txtClienteBoleta = new org.jdesktop.swingx.JXTextField();
        txtDirecccionClienteBoleta = new org.jdesktop.swingx.JXTextField();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        txtVendedorBoleta = new org.jdesktop.swingx.JXTextField();
        txtDniBoleta = new org.jdesktop.swingx.JXTextField();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        txtFechaBoleta = new org.jdesktop.swingx.JXTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleBoletaVenta = new org.jdesktop.swingx.JXTable();
        txtSubTotalBoleta = new org.jdesktop.swingx.JXTextField();
        txtDescuentoBoleta = new org.jdesktop.swingx.JXTextField();
        txtTotalBoleta = new org.jdesktop.swingx.JXTextField();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        pnlOpcionesBoleta = new org.jdesktop.swingx.JXPanel();
        btnEmitirBoleta = new org.jdesktop.swingx.JXButton();
        btnCancelarBoleta = new org.jdesktop.swingx.JXButton();
        btnEntregarBoleta = new org.jdesktop.swingx.JXButton();
        btnAnularBoleta = new org.jdesktop.swingx.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BOLETA DE VENTA");
        setResizable(false);

        pnlEmpresaBoleta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlEmpresaBoleta.setLayout(null);

        jXLabel1.setText("MATERIALES DE CONSTRUCCION Y FERRETERIA EN GENERAL");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jXLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jXLabel1.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);
        pnlEmpresaBoleta.add(jXLabel1);
        jXLabel1.setBounds(177, 12, 241, 10);
        jXLabel1.setVerticalAlignment(JLabel.CENTER);

        jXLabel2.setText("Comercial Iquitos S.A.");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jXLabel2.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);
        pnlEmpresaBoleta.add(jXLabel2);
        jXLabel2.setBounds(177, 28, 241, 36);

        txtsDatos.setBackground(new java.awt.Color(240, 240, 240));
        txtsDatos.setBorder(null);
        txtsDatos.setColumns(15);
        txtsDatos.setEditable(false);
        txtsDatos.setRows(5);
        txtsDatos.setText("TIENDA PRINCIPAL: JR. PROSPERO 624 - 628 LORETO - MAYNAS - IQUITOS\n\t          TELF: 600015   TELEFAX:  235317  RPM: #222172\nSUCURSAL              : AV. GRAU 1138  LORETO\t- MAYNAS - IQUITOS  TELF: 266169  RPM: #774057\nSUCURSAL              : CAL SAMANEZ OCAMPO 805 LORETO - MAYNAS - IQUITOS TELF: 232548 RPM: #774054\nEMAIL                        : venta.comisa@gmail.com");
        txtsDatos.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        txtsDatos.setOpaque(false);
        pnlEmpresaBoleta.add(txtsDatos);
        txtsDatos.setBounds(11, 70, 407, 50);

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlEmpresaBoleta.add(lblFoto);
        lblFoto.setBounds(10, 10, 150, 50);

        pnlRuc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblRucBoleta.setText("R.U.C.  N° ");
        lblRucBoleta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jXLabel3.setText("BOLETA DE VENTA");
        jXLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jXLabel3.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        javax.swing.GroupLayout pnlRucLayout = new javax.swing.GroupLayout(pnlRuc);
        pnlRuc.setLayout(pnlRucLayout);
        pnlRucLayout.setHorizontalGroup(
            pnlRucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRucLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(lblRucBoleta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlRucLayout.setVerticalGroup(
            pnlRucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRucLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRucBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pnlClienteVendeddor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jXLabel4.setText("SEÑORES :");
        jXLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jXLabel5.setText("DIRECCION :");
        jXLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtClienteBoleta.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtDirecccionClienteBoleta.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jXLabel6.setText("VENDEDOR :");
        jXLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jXLabel7.setText("D.N.I. :");
        jXLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtVendedorBoleta.setEditable(false);
        txtVendedorBoleta.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        txtVendedorBoleta.setOpaque(false);

        txtDniBoleta.setEditable(false);
        txtDniBoleta.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        txtDniBoleta.setOpaque(false);

        jXLabel8.setText("fecha :");
        jXLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtFechaBoleta.setEditable(false);
        txtFechaBoleta.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        txtFechaBoleta.setOpaque(false);

        javax.swing.GroupLayout pnlClienteVendeddorLayout = new javax.swing.GroupLayout(pnlClienteVendeddor);
        pnlClienteVendeddor.setLayout(pnlClienteVendeddorLayout);
        pnlClienteVendeddorLayout.setHorizontalGroup(
            pnlClienteVendeddorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteVendeddorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteVendeddorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlClienteVendeddorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDirecccionClienteBoleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteBoleta, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlClienteVendeddorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlClienteVendeddorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteVendeddorLayout.createSequentialGroup()
                        .addComponent(txtDniBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaBoleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtVendedorBoleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlClienteVendeddorLayout.setVerticalGroup(
            pnlClienteVendeddorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteVendeddorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteVendeddorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClienteBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVendedorBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlClienteVendeddorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDirecccionClienteBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDniBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblDetalleBoletaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "CANT.", "UNID.", "DESCRIPCION", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.math.BigDecimal.class, java.lang.String.class, java.lang.String.class, java.math.BigDecimal.class
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
        tblDetalleBoletaVenta.setEditable(false);
        tblDetalleBoletaVenta.setShowGrid(false);
        jScrollPane1.setViewportView(tblDetalleBoletaVenta);
        TableColumn colCodigo= tblDetalleBoletaVenta.getColumn("CODIGO");
        colCodigo.setPreferredWidth(30);
        colCodigo.setResizable(false);
        TableColumn colCant= tblDetalleBoletaVenta.getColumn("CANT.");
        colCant.setPreferredWidth(12);
        colCant.setResizable(false);
        TableColumn colUnid= tblDetalleBoletaVenta.getColumn("UNID.");
        colUnid.setPreferredWidth(20);
        colUnid.setResizable(false);
        TableColumn colDesc= tblDetalleBoletaVenta.getColumn("DESCRIPCION");
        colDesc.setPreferredWidth(320);
        colDesc.setResizable(false);
        TableColumn colTotal= tblDetalleBoletaVenta.getColumn("TOTAL");
        colTotal.setPreferredWidth(20);
        colTotal.setResizable(false);

        jXLabel9.setText("SUB-TOTAL");

        jXLabel10.setText("DESCUENTO");

        jXLabel11.setText("TOTAL");

        jXLabel12.setText("\"BIENES TRANSFERIDOS EN LA AMAZONIA PARA SER CONSUMIDOS EN LA MISMA\"");
        jXLabel12.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jXLabel12.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        jXLabel13.setText("\"SALIDA LA MERCANCIA NO HAY LUGAR A RECLAMOS\"");
        jXLabel13.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jXLabel13.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        pnlOpcionesBoleta.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Opciones"));

        btnEmitirBoleta.setText(" Emitir Boleta");
        btnEmitirBoleta.setToolTipText("Enviar boleta a caja (Solo Vendedor)");
        btnEmitirBoleta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmitirBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirBoletaActionPerformed(evt);
            }
        });

        btnCancelarBoleta.setText("Boleta Pagada");
        btnCancelarBoleta.setToolTipText("Enviar a almacen (Solo Cajero(a))");
        btnCancelarBoleta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelarBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarBoletaActionPerformed(evt);
            }
        });

        btnEntregarBoleta.setText("Boleta Entregada");
        btnEntregarBoleta.setToolTipText("Despacho de Productos del Almacen (Solo Almacenero)");
        btnEntregarBoleta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEntregarBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregarBoletaActionPerformed(evt);
            }
        });

        btnAnularBoleta.setText("Anular Boleta");
        btnAnularBoleta.setToolTipText("Solo Jefe de Tienda");
        btnAnularBoleta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAnularBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularBoletaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesBoletaLayout = new javax.swing.GroupLayout(pnlOpcionesBoleta);
        pnlOpcionesBoleta.setLayout(pnlOpcionesBoletaLayout);
        pnlOpcionesBoletaLayout.setHorizontalGroup(
            pnlOpcionesBoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpcionesBoletaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcionesBoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAnularBoleta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEntregarBoleta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarBoleta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmitirBoleta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlOpcionesBoletaLayout.setVerticalGroup(
            pnlOpcionesBoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesBoletaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEmitirBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEntregarBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnularBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnlEmpresaBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlClienteVendeddor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(txtSubTotalBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(txtDescuentoBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(508, 508, 508)
                                .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(txtTotalBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOpcionesBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlOpcionesBoleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlRuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlEmpresaBoleta, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlClienteVendeddor, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSubTotalBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescuentoBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTotalBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmitirBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirBoletaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmitirBoletaActionPerformed

    private void btnCancelarBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarBoletaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarBoletaActionPerformed

    private void btnEntregarBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregarBoletaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntregarBoletaActionPerformed

    private void btnAnularBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularBoletaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnularBoletaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAnularBoleta;
    private org.jdesktop.swingx.JXButton btnCancelarBoleta;
    private org.jdesktop.swingx.JXButton btnEmitirBoleta;
    private org.jdesktop.swingx.JXButton btnEntregarBoleta;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel10;
    private org.jdesktop.swingx.JXLabel jXLabel11;
    private org.jdesktop.swingx.JXLabel jXLabel12;
    private org.jdesktop.swingx.JXLabel jXLabel13;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private org.jdesktop.swingx.JXLabel lblFoto;
    private org.jdesktop.swingx.JXLabel lblRucBoleta;
    private org.jdesktop.swingx.JXPanel pnlClienteVendeddor;
    private org.jdesktop.swingx.JXPanel pnlEmpresaBoleta;
    private org.jdesktop.swingx.JXPanel pnlOpcionesBoleta;
    private org.jdesktop.swingx.JXPanel pnlRuc;
    private org.jdesktop.swingx.JXTable tblDetalleBoletaVenta;
    private org.jdesktop.swingx.JXTextField txtClienteBoleta;
    private org.jdesktop.swingx.JXTextField txtDescuentoBoleta;
    private org.jdesktop.swingx.JXTextField txtDirecccionClienteBoleta;
    private org.jdesktop.swingx.JXTextField txtDniBoleta;
    private org.jdesktop.swingx.JXTextField txtFechaBoleta;
    private org.jdesktop.swingx.JXTextField txtSubTotalBoleta;
    private org.jdesktop.swingx.JXTextField txtTotalBoleta;
    private org.jdesktop.swingx.JXTextField txtVendedorBoleta;
    private org.jdesktop.swingx.JXTextArea txtsDatos;
    // End of variables declaration//GEN-END:variables

    private void cargarFotoEmpresa() {
        try {
            Process p = Runtime.getRuntime().exec(com.gestionmatriz.config.util.Util.getRutaAutentificate());
            URL url = new URL("file:" + File.separator + File.separator + "192.168.1.101" + File.separator + "Reportes" + File.separator + "jpg_logo_comisa.JPG");
            BufferedImage _image = ImageIO.read(url);
            ImageIcon image = new ImageIcon(_image);
            Icon fotoIncono = com.gestionmatriz.util.Util.reducirFoto(image, lblFoto.getWidth(), lblFoto.getHeight());
            lblFoto.setIcon(fotoIncono);
        } catch (MalformedURLException ex) {
            log.error(ex.getMessage());
        } catch (IOException ex) {
        	log.error(ex.getMessage());
        }
    }
}
