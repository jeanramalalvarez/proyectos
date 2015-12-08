/*
 * NotaCredito.java
 *
 * Created on 23-may-2012, 13:40:23
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.table.TableColumn;

/**
 *
 * @author zholo
 */
public class NotaCredito extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NotaCredito() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlEmpresaNotaCredito = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtsDatos = new org.jdesktop.swingx.JXTextArea();
        lblFoto = new org.jdesktop.swingx.JXLabel();
        pnlRucNotaCredito = new org.jdesktop.swingx.JXPanel();
        lblRucBoleta = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        pnlClienteVendedorNotaCredito = new org.jdesktop.swingx.JXPanel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        txtClienteNotaCredito = new org.jdesktop.swingx.JXTextField();
        txtRucClienteNotaCredito = new org.jdesktop.swingx.JXTextField();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        txtPorConsiguienteNotaCredito = new org.jdesktop.swingx.JXTextField();
        txtFechaEmisionNotaCredito = new org.jdesktop.swingx.JXTextField();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        txtFechaFactura = new org.jdesktop.swingx.JXTextField();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        txtNroPedidoOC = new org.jdesktop.swingx.JXTextField();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        txtGuia = new org.jdesktop.swingx.JXTextField();
        txtComprobantePago = new org.jdesktop.swingx.JXTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleNotaCredito = new org.jdesktop.swingx.JXTable();
        txtSubTotalBoleta = new org.jdesktop.swingx.JXTextField();
        txtDescuentoBoleta = new org.jdesktop.swingx.JXTextField();
        txtTotalBoleta = new org.jdesktop.swingx.JXTextField();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        jXLabel14 = new org.jdesktop.swingx.JXLabel();
        pnlRecepcionNotaCredito = new org.jdesktop.swingx.JXPanel();
        jXLabel15 = new org.jdesktop.swingx.JXLabel();
        txtNombresReceptor = new org.jdesktop.swingx.JXTextField();
        jXLabel16 = new org.jdesktop.swingx.JXLabel();
        txtDniReceptor = new org.jdesktop.swingx.JXTextField();
        jXLabel17 = new org.jdesktop.swingx.JXLabel();
        txtFechaRecepción = new org.jdesktop.swingx.JXTextField();
        pnlMotivosNotaCredito = new org.jdesktop.swingx.JXPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jXTextField1 = new org.jdesktop.swingx.JXTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlEmpresaNotaCredito.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlEmpresaNotaCredito.setLayout(null);

        jXLabel1.setText("MATERIALES DE CONSTRUCCION Y FERRETERIA EN GENERAL");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 0, 8));
        jXLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jXLabel1.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);
        pnlEmpresaNotaCredito.add(jXLabel1);
        jXLabel1.setBounds(177, 12, 241, 10);
        jXLabel1.setVerticalAlignment(JLabel.CENTER);

        jXLabel2.setText("Comercial Iquitos S.A.");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 2, 16));
        jXLabel2.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);
        pnlEmpresaNotaCredito.add(jXLabel2);
        jXLabel2.setBounds(177, 28, 241, 36);

        txtsDatos.setBackground(new java.awt.Color(240, 240, 240));
        txtsDatos.setBorder(null);
        txtsDatos.setColumns(15);
        txtsDatos.setEditable(false);
        txtsDatos.setRows(5);
        txtsDatos.setText("TIENDA PRINCIPAL: JR. PROSPERO 624 - 628 LORETO - MAYNAS - IQUITOS\n\t          TELF: 600015   TELEFAX:  235317  RPM: #222172\nSUCURSAL              : AV. GRAU 1138  LORETO\t- MAYNAS - IQUITOS  TELF: 266169  RPM: #774057\nSUCURSAL              : CAL SAMANEZ OCAMPO 805 LORETO - MAYNAS - IQUITOS TELF: 232548 RPM: #774054\nEMAIL                        : venta.comisa@gmail.com");
        txtsDatos.setFont(new java.awt.Font("Arial", 0, 8));
        txtsDatos.setOpaque(false);
        pnlEmpresaNotaCredito.add(txtsDatos);
        txtsDatos.setBounds(11, 70, 407, 50);

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlEmpresaNotaCredito.add(lblFoto);
        lblFoto.setBounds(10, 10, 150, 50);

        pnlRucNotaCredito.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblRucBoleta.setBackground(new java.awt.Color(0, 0, 0));
        lblRucBoleta.setText("R.U.C.  N° ");
        lblRucBoleta.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblRucBoleta.setForeground( new Color(255,255,255));

        jXLabel3.setText("NOTA DE CREDITO");
        jXLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jXLabel3.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        javax.swing.GroupLayout pnlRucNotaCreditoLayout = new javax.swing.GroupLayout(pnlRucNotaCredito);
        pnlRucNotaCredito.setLayout(pnlRucNotaCreditoLayout);
        pnlRucNotaCreditoLayout.setHorizontalGroup(
            pnlRucNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRucNotaCreditoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lblRucBoleta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        );
        pnlRucNotaCreditoLayout.setVerticalGroup(
            pnlRucNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRucNotaCreditoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRucBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pnlClienteVendedorNotaCredito.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jXLabel4.setText("SEÑORES :");
        jXLabel4.setFont(new java.awt.Font("Tahoma", 0, 10));

        jXLabel5.setText("R.U.C. :");
        jXLabel5.setFont(new java.awt.Font("Tahoma", 0, 10));

        txtClienteNotaCredito.setFont(new java.awt.Font("Tahoma", 0, 9));

        txtRucClienteNotaCredito.setFont(new java.awt.Font("Tahoma", 0, 9));

        jXLabel6.setText("POR CONSIGUIENTE :");
        jXLabel6.setFont(new java.awt.Font("Tahoma", 0, 10));

        jXLabel7.setText("FECHA EMISION :");
        jXLabel7.setFont(new java.awt.Font("Tahoma", 0, 10));

        txtPorConsiguienteNotaCredito.setFont(new java.awt.Font("Tahoma", 0, 9));

        txtFechaEmisionNotaCredito.setEditable(false);
        txtFechaEmisionNotaCredito.setFont(new java.awt.Font("Tahoma", 0, 9));

        jXLabel8.setText("DOC. QUE MODIFICA :");
        jXLabel8.setFont(new java.awt.Font("Tahoma", 0, 10));

        txtFechaFactura.setFont(new java.awt.Font("Tahoma", 0, 9));

        jXLabel9.setText("DENOMINACIÓN");
        jXLabel9.setFont(new java.awt.Font("Tahoma", 0, 10));

        txtNroPedidoOC.setFont(new java.awt.Font("Tahoma", 0, 9));

        jXLabel10.setText("N°");
        jXLabel10.setFont(new java.awt.Font("Tahoma", 0, 10));

        jXLabel11.setText("FECHA DE EMISION C. PAGO QUE MODIFICA :");
        jXLabel11.setFont(new java.awt.Font("Tahoma", 0, 10));

        txtGuia.setFont(new java.awt.Font("Tahoma", 0, 9));

        txtComprobantePago.setFont(new java.awt.Font("Tahoma", 0, 9));

        javax.swing.GroupLayout pnlClienteVendedorNotaCreditoLayout = new javax.swing.GroupLayout(pnlClienteVendedorNotaCredito);
        pnlClienteVendedorNotaCredito.setLayout(pnlClienteVendedorNotaCreditoLayout);
        pnlClienteVendedorNotaCreditoLayout.setHorizontalGroup(
            pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                            .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtClienteNotaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                            .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPorConsiguienteNotaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                        .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFechaEmisionNotaCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRucClienteNotaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNroPedidoOC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtComprobantePago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGuia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(txtFechaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlClienteVendedorNotaCreditoLayout.setVerticalGroup(
            pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtFechaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtClienteNotaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                        .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2))
                                .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNroPedidoOC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtRucClienteNotaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaEmisionNotaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtComprobantePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlClienteVendedorNotaCreditoLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(pnlClienteVendedorNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPorConsiguienteNotaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblDetalleNotaCredito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "CANT.", "DESCRIPCION", "P. UNIT.", "VALOR VENTA O SERVICIO PRESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.math.BigDecimal.class, java.lang.String.class, java.math.BigDecimal.class, java.math.BigDecimal.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDetalleNotaCredito);
        TableColumn colCodigo= tblDetalleNotaCredito.getColumn("CODIGO");
        colCodigo.setPreferredWidth(30);
        colCodigo.setResizable(false);
        TableColumn colCant= tblDetalleNotaCredito.getColumn("CANT.");
        colCant.setPreferredWidth(15);
        colCant.setResizable(false);
        TableColumn coldescripcion= tblDetalleNotaCredito.getColumn("DESCRIPCION");
        coldescripcion.setPreferredWidth(320);
        coldescripcion.setResizable(false);
        TableColumn colPUnit= tblDetalleNotaCredito.getColumn("P. UNIT.");
        colPUnit.setPreferredWidth(20);
        colPUnit.setResizable(false);
        TableColumn colTotal= tblDetalleNotaCredito.getColumn("VALOR VENTA O SERVICIO PRESTADO");
        colTotal.setPreferredWidth(30);
        colTotal.setResizable(false);

        jXLabel12.setText("TOTAL");
        jXLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jXLabel13.setText("SUB-TOTAL");
        jXLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jXLabel14.setText("I.G.V.");
        jXLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        pnlRecepcionNotaCredito.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recepción de la nota de crédito", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 0, 10))); // NOI18N

        jXLabel15.setText("Apellidos y nombres de quien recibe la nota de crédito");
        jXLabel15.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        txtNombresReceptor.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtNombresReceptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresReceptorActionPerformed(evt);
            }
        });

        jXLabel16.setText("D.N.I.");
        jXLabel16.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        txtDniReceptor.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jXLabel17.setText("fecha Recepción ");
        jXLabel17.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        txtFechaRecepción.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        javax.swing.GroupLayout pnlRecepcionNotaCreditoLayout = new javax.swing.GroupLayout(pnlRecepcionNotaCredito);
        pnlRecepcionNotaCredito.setLayout(pnlRecepcionNotaCreditoLayout);
        pnlRecepcionNotaCreditoLayout.setHorizontalGroup(
            pnlRecepcionNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecepcionNotaCreditoLayout.createSequentialGroup()
                .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDniReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFechaRecepción, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
            .addComponent(txtNombresReceptor, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
            .addComponent(jXLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        );
        pnlRecepcionNotaCreditoLayout.setVerticalGroup(
            pnlRecepcionNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecepcionNotaCreditoLayout.createSequentialGroup()
                .addComponent(jXLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombresReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(pnlRecepcionNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDniReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaRecepción, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlMotivosNotaCredito.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Motivo de la Emisión de la Nota de Crédito", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 0, 10))); // NOI18N

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jRadioButton1.setText("Anulación");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jRadioButton2.setText("Bonificación");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jRadioButton3.setText("Descuentos");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jRadioButton4.setText("Devoluciones");

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jRadioButton5.setText("Otros Específicar");

        jXTextField1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        javax.swing.GroupLayout pnlMotivosNotaCreditoLayout = new javax.swing.GroupLayout(pnlMotivosNotaCredito);
        pnlMotivosNotaCredito.setLayout(pnlMotivosNotaCreditoLayout);
        pnlMotivosNotaCreditoLayout.setHorizontalGroup(
            pnlMotivosNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMotivosNotaCreditoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlMotivosNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3)
                    .addGroup(pnlMotivosNotaCreditoLayout.createSequentialGroup()
                        .addGroup(pnlMotivosNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1))
                        .addGap(18, 18, 18)
                        .addGroup(pnlMotivosNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton4)
                            .addComponent(jXTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        pnlMotivosNotaCreditoLayout.setVerticalGroup(
            pnlMotivosNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMotivosNotaCreditoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMotivosNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMotivosNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMotivosNotaCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlClienteVendedorNotaCredito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(pnlEmpresaNotaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlRucNotaCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(pnlMotivosNotaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlRecepcionNotaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jXLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtSubTotalBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescuentoBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRucNotaCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEmpresaNotaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlClienteVendedorNotaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnlRecepcionNotaCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlMotivosNotaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubTotalBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescuentoBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtNombresReceptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresReceptorActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtNombresReceptorActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
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
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private org.jdesktop.swingx.JXTextField jXTextField1;
    private org.jdesktop.swingx.JXLabel lblFoto;
    private org.jdesktop.swingx.JXLabel lblRucBoleta;
    private org.jdesktop.swingx.JXPanel pnlClienteVendedorNotaCredito;
    private org.jdesktop.swingx.JXPanel pnlEmpresaNotaCredito;
    private org.jdesktop.swingx.JXPanel pnlMotivosNotaCredito;
    private org.jdesktop.swingx.JXPanel pnlRecepcionNotaCredito;
    private org.jdesktop.swingx.JXPanel pnlRucNotaCredito;
    private org.jdesktop.swingx.JXTable tblDetalleNotaCredito;
    private org.jdesktop.swingx.JXTextField txtClienteNotaCredito;
    private org.jdesktop.swingx.JXTextField txtComprobantePago;
    private org.jdesktop.swingx.JXTextField txtDescuentoBoleta;
    private org.jdesktop.swingx.JXTextField txtDniReceptor;
    private org.jdesktop.swingx.JXTextField txtFechaEmisionNotaCredito;
    private org.jdesktop.swingx.JXTextField txtFechaFactura;
    private org.jdesktop.swingx.JXTextField txtFechaRecepción;
    private org.jdesktop.swingx.JXTextField txtGuia;
    private org.jdesktop.swingx.JXTextField txtNombresReceptor;
    private org.jdesktop.swingx.JXTextField txtNroPedidoOC;
    private org.jdesktop.swingx.JXTextField txtPorConsiguienteNotaCredito;
    private org.jdesktop.swingx.JXTextField txtRucClienteNotaCredito;
    private org.jdesktop.swingx.JXTextField txtSubTotalBoleta;
    private org.jdesktop.swingx.JXTextField txtTotalBoleta;
    private org.jdesktop.swingx.JXTextArea txtsDatos;
    // End of variables declaration//GEN-END:variables
}
