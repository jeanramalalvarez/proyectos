/*
 * FacturaVenta.java
 *
 * Created on 22-may-2012, 13:58:17
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

/**
 *
 * @author zholo
 */
public class FacturaVenta extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FacturaVenta() {
        initComponents();
        cargarFotoEmpresa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEmpresaFactura = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtsDatos = new org.jdesktop.swingx.JXTextArea();
        lblFoto = new org.jdesktop.swingx.JXLabel();
        pnlRuc = new org.jdesktop.swingx.JXPanel();
        lblRucBoleta = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        pnlOpcionesBoleta = new org.jdesktop.swingx.JXPanel();
        btnEmitirBoleta = new org.jdesktop.swingx.JXButton();
        btnCancelarBoleta = new org.jdesktop.swingx.JXButton();
        btnEntregarBoleta = new org.jdesktop.swingx.JXButton();
        btnAnularBoleta = new org.jdesktop.swingx.JXButton();
        pnlClienteVendedorFactura = new org.jdesktop.swingx.JXPanel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        txtClienteFactura = new org.jdesktop.swingx.JXTextField();
        txtDirecccionClienteFactura = new org.jdesktop.swingx.JXTextField();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        txtVendedorFactura = new org.jdesktop.swingx.JXTextField();
        txtRucClienteFactura = new org.jdesktop.swingx.JXTextField();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        txtFechaFactura = new org.jdesktop.swingx.JXTextField();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        txtNroPedidoOC = new org.jdesktop.swingx.JXTextField();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        txtGuia = new org.jdesktop.swingx.JXTextField();
        txtComprobantePago = new org.jdesktop.swingx.JXTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleFactura = new org.jdesktop.swingx.JXTable();
        txtTotalBruto = new org.jdesktop.swingx.JXTextField();
        txtDescuento = new org.jdesktop.swingx.JXTextField();
        txtPR_CDescuento = new org.jdesktop.swingx.JXTextField();
        txtValorVenta = new org.jdesktop.swingx.JXTextField();
        txtExonerado = new org.jdesktop.swingx.JXTextField();
        txtIgv = new org.jdesktop.swingx.JXTextField();
        txtTotalVenta = new org.jdesktop.swingx.JXTextField();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        jXLabel15 = new org.jdesktop.swingx.JXLabel();
        jXLabel16 = new org.jdesktop.swingx.JXLabel();
        jXLabel17 = new org.jdesktop.swingx.JXLabel();
        jXLabel18 = new org.jdesktop.swingx.JXLabel();
        jXLabel19 = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlEmpresaFactura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlEmpresaFactura.setLayout(null);

        jXLabel1.setText("MATERIALES DE CONSTRUCCION Y FERRETERIA EN GENERAL");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jXLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jXLabel1.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);
        pnlEmpresaFactura.add(jXLabel1);
        jXLabel1.setBounds(177, 12, 241, 10);
        jXLabel1.setVerticalAlignment(JLabel.CENTER);

        jXLabel2.setText("Comercial Iquitos S.A.");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jXLabel2.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);
        pnlEmpresaFactura.add(jXLabel2);
        jXLabel2.setBounds(177, 28, 241, 36);

        txtsDatos.setEditable(false);
        txtsDatos.setBackground(new java.awt.Color(240, 240, 240));
        txtsDatos.setBorder(null);
        txtsDatos.setColumns(15);
        txtsDatos.setRows(5);
        txtsDatos.setText("TIENDA PRINCIPAL: JR. PROSPERO 624 - 628 LORETO - MAYNAS - IQUITOS\n\t          TELF: 600015   TELEFAX:  235317  RPM: #222172\nSUCURSAL              : AV. GRAU 1138  LORETO\t- MAYNAS - IQUITOS  TELF: 266169  RPM: #774057\nSUCURSAL              : CAL SAMANEZ OCAMPO 805 LORETO - MAYNAS - IQUITOS TELF: 232548 RPM: #774054\nEMAIL                        : venta.comisa@gmail.com");
        txtsDatos.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        txtsDatos.setOpaque(false);
        pnlEmpresaFactura.add(txtsDatos);
        txtsDatos.setBounds(11, 70, 407, 50);

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlEmpresaFactura.add(lblFoto);
        lblFoto.setBounds(10, 10, 150, 50);

        pnlRuc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblRucBoleta.setText("R.U.C.  N° ");
        lblRucBoleta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jXLabel3.setText("FACTURA");
        jXLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jXLabel3.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        javax.swing.GroupLayout pnlRucLayout = new javax.swing.GroupLayout(pnlRuc);
        pnlRuc.setLayout(pnlRucLayout);
        pnlRucLayout.setHorizontalGroup(
            pnlRucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRucLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(lblRucBoleta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlRucLayout.setVerticalGroup(
            pnlRucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRucLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRucBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlOpcionesBoleta.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Opciones"));

        btnEmitirBoleta.setText(" Emitir Factura");
        btnEmitirBoleta.setToolTipText("Enviar factura a caja (Solo Vendedor)");
        btnEmitirBoleta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmitirBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirBoletaActionPerformed(evt);
            }
        });

        btnCancelarBoleta.setText("Factura Pagada");
        btnCancelarBoleta.setToolTipText("Enviar a almacen (Solo Cajero(a))");
        btnCancelarBoleta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelarBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarBoletaActionPerformed(evt);
            }
        });

        btnEntregarBoleta.setText("Factura Entregada");
        btnEntregarBoleta.setToolTipText("Despacho de Productos del Almacen (Solo Almacenero)");
        btnEntregarBoleta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEntregarBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregarBoletaActionPerformed(evt);
            }
        });

        btnAnularBoleta.setText("Anular Factura");
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
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pnlClienteVendedorFactura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jXLabel4.setText("SEÑORES :");
        jXLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jXLabel5.setText("DIRECCION :");
        jXLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtClienteFactura.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtDirecccionClienteFactura.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jXLabel6.setText("VENDEDOR :");
        jXLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jXLabel7.setText("R.U.C. :");
        jXLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtVendedorFactura.setEditable(false);
        txtVendedorFactura.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        txtVendedorFactura.setOpaque(false);

        txtRucClienteFactura.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jXLabel8.setText("FECHA :");
        jXLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtFechaFactura.setEditable(false);
        txtFechaFactura.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        txtFechaFactura.setOpaque(false);

        jXLabel9.setText("N° PEDIDO O/C :");

        txtNroPedidoOC.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jXLabel10.setText("GUIA :");

        jXLabel11.setText("C. PAGO :");

        txtGuia.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtComprobantePago.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        javax.swing.GroupLayout pnlClienteVendedorFacturaLayout = new javax.swing.GroupLayout(pnlClienteVendedorFactura);
        pnlClienteVendedorFactura.setLayout(pnlClienteVendedorFacturaLayout);
        pnlClienteVendedorFacturaLayout.setHorizontalGroup(
            pnlClienteVendedorFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteVendedorFacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteVendedorFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteVendedorFacturaLayout.createSequentialGroup()
                        .addGroup(pnlClienteVendedorFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlClienteVendedorFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jXLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jXLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                            .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlClienteVendedorFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlClienteVendedorFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDirecccionClienteFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtClienteFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                            .addComponent(txtRucClienteFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlClienteVendedorFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlClienteVendedorFacturaLayout.createSequentialGroup()
                        .addComponent(jXLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVendedorFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addGroup(pnlClienteVendedorFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtComprobantePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNroPedidoOC, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(txtFechaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGuia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlClienteVendedorFacturaLayout.setVerticalGroup(
            pnlClienteVendedorFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteVendedorFacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteVendedorFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClienteFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlClienteVendedorFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDirecccionClienteFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroPedidoOC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlClienteVendedorFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRucClienteFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlClienteVendedorFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVendedorFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComprobantePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "CANT.", "DESCRIPCION", "P. UNIT.", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.math.BigDecimal.class, java.lang.String.class, java.math.BigDecimal.class, java.math.BigDecimal.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDetalleFactura);
        TableColumn colCodigo= tblDetalleFactura.getColumn("CODIGO");
        colCodigo.setPreferredWidth(30);
        colCodigo.setResizable(false);
        TableColumn colCant= tblDetalleFactura.getColumn("CANT.");
        colCant.setPreferredWidth(15);
        colCant.setResizable(false);
        TableColumn coldescripcion= tblDetalleFactura.getColumn("DESCRIPCION");
        coldescripcion.setPreferredWidth(320);
        coldescripcion.setResizable(false);
        TableColumn colPUnit= tblDetalleFactura.getColumn("P. UNIT.");
        colPUnit.setPreferredWidth(20);
        colPUnit.setResizable(false);
        TableColumn colTotal= tblDetalleFactura.getColumn("TOTAL");
        colTotal.setPreferredWidth(30);
        colTotal.setResizable(false);

        jXLabel12.setText("TOTAL BRUTO");

        jXLabel13.setText("DESCUENTO");

        jXLabel15.setText("PR. C/DSCTO");

        jXLabel16.setText("VALOR VENTA");

        jXLabel17.setText("EXONERADO");

        jXLabel18.setText("I.G.V.");

        jXLabel19.setText("TOTAL VENTA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlEmpresaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlRuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlClienteVendedorFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotalBruto, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(txtPR_CDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtValorVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtExonerado, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIgv, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotalVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOpcionesBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlOpcionesBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlRuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlEmpresaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlClienteVendedorFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExonerado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPR_CDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
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
    private org.jdesktop.swingx.JXLabel jXLabel15;
    private org.jdesktop.swingx.JXLabel jXLabel16;
    private org.jdesktop.swingx.JXLabel jXLabel17;
    private org.jdesktop.swingx.JXLabel jXLabel18;
    private org.jdesktop.swingx.JXLabel jXLabel19;
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
    private org.jdesktop.swingx.JXPanel pnlClienteVendedorFactura;
    private org.jdesktop.swingx.JXPanel pnlEmpresaFactura;
    private org.jdesktop.swingx.JXPanel pnlOpcionesBoleta;
    private org.jdesktop.swingx.JXPanel pnlRuc;
    private org.jdesktop.swingx.JXTable tblDetalleFactura;
    private org.jdesktop.swingx.JXTextField txtClienteFactura;
    private org.jdesktop.swingx.JXTextField txtComprobantePago;
    private org.jdesktop.swingx.JXTextField txtDescuento;
    private org.jdesktop.swingx.JXTextField txtDirecccionClienteFactura;
    private org.jdesktop.swingx.JXTextField txtExonerado;
    private org.jdesktop.swingx.JXTextField txtFechaFactura;
    private org.jdesktop.swingx.JXTextField txtGuia;
    private org.jdesktop.swingx.JXTextField txtIgv;
    private org.jdesktop.swingx.JXTextField txtNroPedidoOC;
    private org.jdesktop.swingx.JXTextField txtPR_CDescuento;
    private org.jdesktop.swingx.JXTextField txtRucClienteFactura;
    private org.jdesktop.swingx.JXTextField txtTotalBruto;
    private org.jdesktop.swingx.JXTextField txtTotalVenta;
    private org.jdesktop.swingx.JXTextField txtValorVenta;
    private org.jdesktop.swingx.JXTextField txtVendedorFactura;
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
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
