/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GestionPlanContable.java
 *
 * Created on 06-nov-2012, 10:49:33
 */
package com.gestionmatriz.contabilidad.gui;

import com.gestionmatriz.almacen.gui.ConformidadCompra;
import com.gestionmatriz.contabilidad.bean.Cuentas;
import com.gestionmatriz.contabilidad.bean.Elemento;
import com.gestionmatriz.contabilidad.bean.SubCuentas;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

/**
 *
 * @author zholo
 */
public class GestionPlanContable extends javax.swing.JInternalFrame {
	
	private static final Logger log=Logger.getLogger(GestionPlanContable.class);
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GestionPlanContable(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarListaElementos();
    }

    private void initComponents() {

        popElementos = new javax.swing.JPopupMenu();
        mniEliminar = new javax.swing.JMenuItem();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtNroelemento = new org.jdesktop.swingx.JXTextField();
        txtDescripElemento = new org.jdesktop.swingx.JXTextField();
        btnGuardarElemento = new org.jdesktop.swingx.JXButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstElemento = new org.jdesktop.swingx.JXList();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        cboElemento = new org.jdesktop.swingx.JXComboBox();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        txtNroCuenta = new org.jdesktop.swingx.JXTextField();
        txtDescripcionCuenta = new org.jdesktop.swingx.JXTextField();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        btnGuardarCta = new org.jdesktop.swingx.JXButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCuentas = new org.jdesktop.swingx.JXTable();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        txtCtaDebe = new org.jdesktop.swingx.JXTextField();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        txtCtaHaber = new org.jdesktop.swingx.JXTextField();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        cboTipo = new org.jdesktop.swingx.JXComboBox();
        cboAnalisis = new org.jdesktop.swingx.JXComboBox();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        cboCuenta = new org.jdesktop.swingx.JXComboBox();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        txtSubCuenta = new org.jdesktop.swingx.JXTextField();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        txtDescripcionSubCuentas = new org.jdesktop.swingx.JXTextField();
        btnGuardarSubCuenta = new org.jdesktop.swingx.JXButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSubCuentas = new org.jdesktop.swingx.JXTable();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        txtCtaDebeSubcuenta = new org.jdesktop.swingx.JXTextField();
        jXLabel14 = new org.jdesktop.swingx.JXLabel();
        txtCtaHaberSubcuenta = new org.jdesktop.swingx.JXTextField();
        jXLabel15 = new org.jdesktop.swingx.JXLabel();
        cboAnalisisSubcuentas = new org.jdesktop.swingx.JXComboBox();
        cboTipoSubCuentas = new org.jdesktop.swingx.JXComboBox();
        jXLabel16 = new org.jdesktop.swingx.JXLabel();

        mniEliminar.setText("Eliminar");
        mniEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEliminarActionPerformed(evt);
            }
        });
        popElementos.add(mniEliminar);

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTION PLAN CONTABLE");

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Elementos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXLabel1.setText("Nro Elemento :");

        jXLabel2.setText("Descripcion :");

        btnGuardarElemento.setText("Guardar");
        btnGuardarElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarElementoActionPerformed(evt);
            }
        });

        lstElemento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstElemento.setComponentPopupMenu(popElementos);
        lstElemento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lstElemento.setName("Lista de Elementos"); // NOI18N
        lstElemento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstElementoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstElemento);

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jXPanel1Layout.createSequentialGroup()
                            .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNroelemento, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnGuardarElemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jXPanel1Layout.createSequentialGroup()
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDescripElemento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroelemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarElemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripElemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
        );

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Cuentas"));

        jXLabel3.setText("Elemento :");

        jXLabel4.setText("Nro Cuenta :");

        jXLabel5.setText("Descripcion :");

        btnGuardarCta.setText("Guardar");
        btnGuardarCta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCtaActionPerformed(evt);
            }
        });

        tblCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cuenta", "Descripción", "Cta. Debe", "Cta. Haber", "Tipo", "Analisis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCuentas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblCuentas.getTableHeader().setReorderingAllowed(false);
        tblCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCuentasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblCuentas);

        jXLabel9.setText("Cta. Debe:");

        jXLabel10.setText("Cta. Haber:");

        jXLabel11.setText("Tipo :");

        jXLabel12.setText("Analisis : ");

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboElemento, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(txtDescripcionCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(btnGuardarCta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCtaDebe, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCtaHaber, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboElemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCtaDebe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCtaHaber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarCta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
        );

        jXPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "SubCuentas"));

        jXLabel6.setText("Cuenta :");

        jXLabel7.setText("SubCuenta :");

        jXLabel8.setText("Descripcion :");

        btnGuardarSubCuenta.setText("Guardar");
        btnGuardarSubCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSubCuentaActionPerformed(evt);
            }
        });

        tblSubCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cuenta", "Descripción", "Cta. Debe", "Cta. Haber", "Tipo", "Analisis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblSubCuentas);

        jXLabel13.setText("Cta. Debe:");

        jXLabel14.setText("Cta. Haber:");

        jXLabel15.setText("Analisis : ");

        jXLabel16.setText("Tipo :");

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(cboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCtaDebeSubcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(txtSubCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescripcionSubCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboTipoSubCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(btnGuardarSubCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(txtCtaHaberSubcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jXLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboAnalisisSubcuentas, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jXPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCtaDebeSubcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCtaHaberSubcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAnalisisSubcuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionSubCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarSubCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipoSubCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(207, Short.MAX_VALUE))
            .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jXPanel3Layout.createSequentialGroup()
                    .addContainerGap(66, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lstElementoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstElementoMouseClicked
    int indice = lstElemento.getSelectedIndex();

    if (indice < 0) {
        return;
    }

    listaCuentas = PaqueteBusinessDelegate.getCuentasService().
            listarCuentas(listaElementos.get(indice).getInt_idElemento());

    cargarTabla(listaCuentas);
}//GEN-LAST:event_lstElementoMouseClicked

private void tblCuentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuentasMousePressed
    int indice = tblCuentas.getSelectedRow();

    if (indice < 0) {
    	log.info("indice---:" + indice);
        return;
    }
//    System.out.println("indice---:"+indice);
//    System.out.println("id cuenta--"+listaCuentas.get(indice).getInt_idCuentas());
    listaSubCuentas = PaqueteBusinessDelegate.getSubCuentasService().
            listarSubCuentas(listaCuentas.get(indice).getInt_idCuentas());

    cargarTablaSubCuentas(listaSubCuentas);
}//GEN-LAST:event_tblCuentasMousePressed

private void btnGuardarElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarElementoActionPerformed
    Elemento objElemento = new Elemento();
    objElemento.setStr_elemento("Elemento " + txtNroelemento.getText());
    objElemento.setStr_descripcion(txtDescripElemento.getText());
    objElemento.setStr_estado(Util.ACTIVO);
    objElemento.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());

    for (Elemento e : listaElementos) {
        if (e.getStr_elemento().equalsIgnoreCase(objElemento.getStr_elemento())) {
            Mensaje.mensaje("El Elemento nro " + txtNroelemento.getText() + " ya Existe", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtDescripElemento.setText("");
            txtNroelemento.setText("");
            return;
        }
    }

    if (PaqueteBusinessDelegate.getElementoService().registrarElemnto(objElemento) == true) {
        cargarListaElementos();
        txtDescripElemento.setText("");
        txtNroelemento.setText("");
    }
}//GEN-LAST:event_btnGuardarElementoActionPerformed

private void mniEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEliminarActionPerformed
    int indice = lstElemento.getSelectedIndex();

    Elemento objElemento = new Elemento();
    objElemento.setInt_idElemento(listaElementos.get(indice).getInt_idElemento());
    objElemento.setStr_estado(Util.INACTIVO);
    objElemento.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());

    if (PaqueteBusinessDelegate.getElementoService().actualizarElemento(objElemento)) {
        Mensaje.mensaje("Elemento Eliminado", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        cargarListaElementos();
    }
}//GEN-LAST:event_mniEliminarActionPerformed

private void btnGuardarCtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCtaActionPerformed

    //Pendiente de terminar

    Cuentas objCuentas = new Cuentas();
    objCuentas.setInt_idElemento(HEIGHT);
    objCuentas.setInt_nroCuenta(Integer.parseInt(txtNroCuenta.getText()));
    objCuentas.setStr_descripcion(txtDescripcionCuenta.getText());
    objCuentas.setStr_debe(txtCtaDebe.getText());
    objCuentas.setStr_haber(txtCtaHaber.getText());
    objCuentas.setStr_tipo("");
    objCuentas.setStr_analisis("");
    objCuentas.setStr_estado(Util.ACTIVO);
    objCuentas.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());

    PaqueteBusinessDelegate.getCuentasService().registrarCuenta(objCuentas);

}//GEN-LAST:event_btnGuardarCtaActionPerformed

    private void btnGuardarSubCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSubCuentaActionPerformed
        
    }//GEN-LAST:event_btnGuardarSubCuentaActionPerformed

    private void cargarTabla(List<Cuentas> listaCuentas) {
        Object[] filaTabla = new Object[6];
        DefaultTableModel modelo = (DefaultTableModel) tblCuentas.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (Cuentas objC : listaCuentas) {
            filaTabla[0] = objC.getInt_nroCuenta();
            filaTabla[1] = objC.getStr_descripcion();
            filaTabla[2] = objC.getStr_debe();
            filaTabla[3] = objC.getStr_haber();
            filaTabla[4] = objC.getStr_tipo();
            filaTabla[5] = objC.getStr_analisis();

            modelo.addRow(filaTabla);
        }

        tblCuentas.setModel(modelo);

    }

    private void cargarTablaSubCuentas(List<SubCuentas> listaSubCuentas) {
        Object[] filaTabla = new Object[6];
        DefaultTableModel modelo1 = (DefaultTableModel) tblSubCuentas.getModel();
//        System.out.println("CargarTablaSubCuentas");
        while (modelo1.getRowCount() > 0) {
            modelo1.removeRow(0);
        }

        for (SubCuentas objC : listaSubCuentas) {
            filaTabla[0] = objC.getInt_nroSubcuentas();
            filaTabla[1] = objC.getStr_descripcion();
            filaTabla[2] = objC.getStr_debe();
            filaTabla[3] = objC.getStr_haber();
            filaTabla[4] = objC.getStr_tipo();
            filaTabla[5] = objC.getStr_analisis();

            modelo1.addRow(filaTabla);
        }

        tblSubCuentas.setModel(modelo1);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnGuardarCta;
    private org.jdesktop.swingx.JXButton btnGuardarElemento;
    private org.jdesktop.swingx.JXButton btnGuardarSubCuenta;
    private org.jdesktop.swingx.JXComboBox cboAnalisis;
    private org.jdesktop.swingx.JXComboBox cboAnalisisSubcuentas;
    private org.jdesktop.swingx.JXComboBox cboCuenta;
    private org.jdesktop.swingx.JXComboBox cboElemento;
    private org.jdesktop.swingx.JXComboBox cboTipo;
    private org.jdesktop.swingx.JXComboBox cboTipoSubCuentas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel10;
    private org.jdesktop.swingx.JXLabel jXLabel11;
    private org.jdesktop.swingx.JXLabel jXLabel12;
    private org.jdesktop.swingx.JXLabel jXLabel13;
    private org.jdesktop.swingx.JXLabel jXLabel14;
    private org.jdesktop.swingx.JXLabel jXLabel15;
    private org.jdesktop.swingx.JXLabel jXLabel16;
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
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXList lstElemento;
    private javax.swing.JMenuItem mniEliminar;
    private javax.swing.JPopupMenu popElementos;
    private org.jdesktop.swingx.JXTable tblCuentas;
    private org.jdesktop.swingx.JXTable tblSubCuentas;
    private org.jdesktop.swingx.JXTextField txtCtaDebe;
    private org.jdesktop.swingx.JXTextField txtCtaDebeSubcuenta;
    private org.jdesktop.swingx.JXTextField txtCtaHaber;
    private org.jdesktop.swingx.JXTextField txtCtaHaberSubcuenta;
    private org.jdesktop.swingx.JXTextField txtDescripElemento;
    private org.jdesktop.swingx.JXTextField txtDescripcionCuenta;
    private org.jdesktop.swingx.JXTextField txtDescripcionSubCuentas;
    private org.jdesktop.swingx.JXTextField txtNroCuenta;
    private org.jdesktop.swingx.JXTextField txtNroelemento;
    private org.jdesktop.swingx.JXTextField txtSubCuenta;
    // End of variables declaration//GEN-END:variables
    private Principal gui;
    DefaultListModel modelElementos;
    List<Elemento> listaElementos;
    List<Cuentas> listaCuentas;
    List<SubCuentas> listaSubCuentas;

    public void cargarListaElementos() {
        int i = 0;
        modelElementos = new DefaultListModel();
        Object rol;
        listaElementos = PaqueteBusinessDelegate.getElementoService().listarElementos();
        
        for (Elemento f : listaElementos) {
            rol = f.getStr_elemento() + " - " + f.getStr_descripcion();
            modelElementos.add(i, rol);
            i++;
        }

        lstElemento.setModel(modelElementos);
    }
}
