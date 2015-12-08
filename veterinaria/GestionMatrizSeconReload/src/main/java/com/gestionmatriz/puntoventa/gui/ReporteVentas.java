/*
 * ReporteVentas.java
 *
 * Created on 29-ago-2012, 17:12:53
 */
package com.gestionmatriz.puntoventa.gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.RegistroVenta;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.puntoventa.reportes.Ireport;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

/**
 *
 * @author jarcon
 */
public class ReporteVentas extends javax.swing.JInternalFrame {

	private static final Logger log=Logger.getLogger(ReporteVentas.class);
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal gui;
    private List<Local> listaLocal = new ArrayList<>();
    private List<Personal> listaPersonal = new ArrayList<>();
    private Ireport ireport = new Ireport();

    public ReporteVentas(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarComboLocal();
        cargarComboVendedor();
        cargarComboTiendaRegistro();
        this.btnRegistroVentaSunat.setVisible(false);
    }

    private void cargarComboLocal() {
        cboTienda.removeAllItems();
        cboTienda.addItem(".::Seleccionar Local::.");
        listaLocal = PaqueteBusinessDelegate.getContratoService().buscarLocal(gui.getEmpresa().getInt_idEmpresa());

        for (Local local : listaLocal) {
            cboTienda.addItem(local.getStr_direccion());
        }
    }

    private void cargarComboVendedor() {
        cboVendedor.removeAllItems();
        cboVendedor.addItem(".::Seleccionar Vendedor::.");
        listaPersonal = PaqueteBusinessDelegate.getVentasService().listarVendedores(("" + gui.getEmpresa().getInt_idEmpresa()).trim());

        for (Personal p : listaPersonal) {
            cboVendedor.addItem(p.getStr_apePaterno() + " " + p.getStr_apeMaterno() + " " + p.getStr_nombres());
        }
    }
    
    public void cargarComboTiendaRegistro(){
        cboTiendaRegistro.removeAllItems();
        cboTiendaRegistro.addItem(".::Seleccionar Local::.");
        listaLocal = PaqueteBusinessDelegate.getContratoService().buscarLocal(gui.getEmpresa().getInt_idEmpresa());

        for (Local local : listaLocal) {
            cboTiendaRegistro.addItem(local.getInt_idLocal()+"-"+local.getStr_nombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        cboVendedor = new org.jdesktop.swingx.JXComboBox();
        btnVendedorFecha = new org.jdesktop.swingx.JXButton();
        dtpFechaInicial = new org.jdesktop.swingx.JXDatePicker();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        dtpFechaFinal = new org.jdesktop.swingx.JXDatePicker();
        btnTodoVendedoresFecha = new org.jdesktop.swingx.JXButton();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        dtpFechaInicialTiendas = new org.jdesktop.swingx.JXDatePicker();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        cboTienda = new org.jdesktop.swingx.JXComboBox();
        dtpFechaFinalTiendas = new org.jdesktop.swingx.JXDatePicker();
        btnTiendaFechas = new org.jdesktop.swingx.JXButton();
        btntodoTiendaFechas = new org.jdesktop.swingx.JXButton();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        btnFacturasFechas1 = new org.jdesktop.swingx.JXButton();
        btnTotalesDia = new org.jdesktop.swingx.JXButton();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        dtpFechaInicialGraficos = new org.jdesktop.swingx.JXDatePicker();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        dtpFechaFinalGraficos = new org.jdesktop.swingx.JXDatePicker();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        btnVentasDia = new org.jdesktop.swingx.JXButton();
        btnEvoluvionFechas = new org.jdesktop.swingx.JXButton();
        jPanel1 = new javax.swing.JPanel();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        dtpFechaInicialRegistro = new org.jdesktop.swingx.JXDatePicker();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        dtpFechaFinalRegistro = new org.jdesktop.swingx.JXDatePicker();
        jButton1 = new javax.swing.JButton();
        cboTiendaRegistro = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnRegistroVentaSunat = new javax.swing.JButton();
        btnRegistroVentaTienda = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("REPORTE DE VENTAS");

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Reporte de ventas por vendedor"));
        jXPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXLabel1.setText("Vendedor :");
        jXPanel1.add(jXLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 31, -1, -1));
        jXPanel1.add(cboVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 28, 297, -1));

        btnVendedorFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png"))); // NOI18N
        btnVendedorFecha.setText("Reporte por vendedor y fechas");
        btnVendedorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendedorFechaActionPerformed(evt);
            }
        });
        jXPanel1.add(btnVendedorFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 27, 240, 23));
        jXPanel1.add(dtpFechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 61, 110, -1));

        jXLabel2.setText("Fecha Inicial :");
        jXPanel1.add(jXLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 65, -1, -1));

        jXLabel3.setText("Fecha Final :");
        jXPanel1.add(jXLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 65, -1, -1));
        jXPanel1.add(dtpFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 61, 110, -1));

        btnTodoVendedoresFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png"))); // NOI18N
        btnTodoVendedoresFecha.setText("Todos los vendores por fechas");
        btnTodoVendedoresFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodoVendedoresFechaActionPerformed(evt);
            }
        });
        jXPanel1.add(btnTodoVendedoresFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 61, 238, 23));

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Reporte de ventas por tiendas"));
        jXPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXLabel4.setText("Fecha Inicial :");
        jXPanel2.add(jXLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        jXPanel2.add(dtpFechaInicialTiendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 110, -1));

        jXLabel5.setText("Tienda :");
        jXPanel2.add(jXLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 17, -1, -1));
        jXPanel2.add(cboTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 17, 301, -1));
        jXPanel2.add(dtpFechaFinalTiendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 110, -1));

        btnTiendaFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png"))); // NOI18N
        btnTiendaFechas.setText("Boletas por tienda y fechas");
        btnTiendaFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiendaFechasActionPerformed(evt);
            }
        });
        jXPanel2.add(btnTiendaFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 46, 244, 23));

        btntodoTiendaFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png"))); // NOI18N
        btntodoTiendaFechas.setText("Todas las tiendas  por fechas");
        btntodoTiendaFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntodoTiendaFechasActionPerformed(evt);
            }
        });
        jXPanel2.add(btntodoTiendaFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 78, 244, 23));

        jXLabel6.setText("Fecha Final :");
        jXPanel2.add(jXLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        btnFacturasFechas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png"))); // NOI18N
        btnFacturasFechas1.setText("Facturas por tienda y fechas");
        btnFacturasFechas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturasFechas1ActionPerformed(evt);
            }
        });
        jXPanel2.add(btnFacturasFechas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 16, 244, 23));

        btnTotalesDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png"))); // NOI18N
        btnTotalesDia.setText("Totales por dia");
        btnTotalesDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalesDiaActionPerformed(evt);
            }
        });
        jXPanel2.add(btnTotalesDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 107, 244, 23));

        jXPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Reportes Graficos de ventas"));
        jXPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXLabel7.setText("Fecha Inicial :");
        jXPanel3.add(jXLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 58, -1, -1));
        jXPanel3.add(dtpFechaInicialGraficos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 110, -1));

        jXLabel8.setText("Fecha Final :");
        jXPanel3.add(jXLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 58, -1, -1));
        jXPanel3.add(dtpFechaFinalGraficos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 110, -1));

        jXLabel9.setText("Se recomienda que el rango de fechas no sea muy amplio, recuerde que son reportes gráficos.");
        jXPanel3.add(jXLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 22, -1, -1));

        btnVentasDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png"))); // NOI18N
        btnVentasDia.setText("Reporte de ventas diarias por tiendas");
        btnVentasDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasDiaActionPerformed(evt);
            }
        });
        jXPanel3.add(btnVentasDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 80, 260, 23));

        btnEvoluvionFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png"))); // NOI18N
        btnEvoluvionFechas.setText("Evolución de ventas por fechas");
        btnEvoluvionFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvoluvionFechasActionPerformed(evt);
            }
        });
        jXPanel3.add(btnEvoluvionFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 50, 260, 23));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Registro de Ventas"));

        jXLabel10.setText("Fecha Inicial :");

        jXLabel11.setText("Fecha Final :");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png"))); // NOI18N
        jButton1.setText("Registro de venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tienda :");

        btnRegistroVentaSunat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png"))); // NOI18N
        btnRegistroVentaSunat.setText("Registro de venta Sunat");
        btnRegistroVentaSunat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroVentaSunatActionPerformed(evt);
            }
        });

        btnRegistroVentaTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png"))); // NOI18N
        btnRegistroVentaTienda.setText("Registro de venta Tienda");
        btnRegistroVentaTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroVentaTiendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dtpFechaInicialRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtpFechaFinalRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboTiendaRegistro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistroVentaSunat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistroVentaTienda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtpFechaFinalRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtpFechaInicialRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTiendaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegistroVentaTienda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistroVentaSunat)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnVendedorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendedorFechaActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREPORTE_VENTAS_VENDEDOR())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    if (cboVendedor.getSelectedIndex() == 0) {
        Mensaje.mensaje(this, "Debe seleccionar un vendedor", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (dtpFechaInicial.getDate() == null || dtpFechaFinal.getDate() == null) {
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (dtpFechaInicial.getDate().after(dtpFechaFinal.getDate())) {
        Mensaje.mensaje(this, "Fecha inicial no puede ser mayor que la fecha final", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    String usuario = listaPersonal.get(cboVendedor.getSelectedIndex() - 1).getStr_codigo().concat(listaPersonal.get(cboVendedor.getSelectedIndex() - 1).getStr_apePaterno());
    ireport.ventasUsuario(usuario, Util.getFecha("yyyy-MM-dd", dtpFechaInicial.getDate()), Util.getFecha("yyyy-MM-dd", dtpFechaFinal.getDate()));
}//GEN-LAST:event_btnVendedorFechaActionPerformed

private void btnTodoVendedoresFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodoVendedoresFechaActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREPORTE_VENTAS_VENDEDOR_FECHAS())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicial.getDate() == null || dtpFechaFinal.getDate() == null) {
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicial.getDate().after(dtpFechaFinal.getDate())) {
        Mensaje.mensaje(this, "Fecha inicial no puede ser mayor que la fecha final", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    ireport.ventasUsuario("%", Util.getFecha("yyyy-MM-dd", dtpFechaInicial.getDate()), Util.getFecha("yyyy-MM-dd", dtpFechaFinal.getDate()));
}//GEN-LAST:event_btnTodoVendedoresFechaActionPerformed

private void btnTiendaFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiendaFechasActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREPORTE_VENTAS_BOLETA_TIENDA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (cboTienda.getSelectedIndex() == 0) {
        Mensaje.mensaje(this, "Debe seleccionar un Local", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialTiendas.getDate() == null || dtpFechaFinalTiendas.getDate() == null) {
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialTiendas.getDate().after(dtpFechaFinalTiendas.getDate())) {
        Mensaje.mensaje(this, "Fecha inicial no puede ser mayor que la fecha final", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    String local = ("" + listaLocal.get(cboTienda.getSelectedIndex() - 1).getInt_idLocal()).trim();
    String doc = PaqueteBusinessDelegate.getVentasService().prefijoXlocalxTipoDocumento(Integer.parseInt(local), Util.CODIGO_BOLETA);
    log.info(doc);
       /* switch (local) {
            case "1":
                doc="B-010-";
                break;
            case "2":
                doc="B-013-";
                break;
            default:
                doc="B-011-";
                break;
        }*/
    ireport.ventasTienda(local, Util.getFecha("yyyy-MM-dd", dtpFechaInicialTiendas.getDate()),
            Util.getFecha("yyyy-MM-dd", dtpFechaFinalTiendas.getDate()), doc);
}//GEN-LAST:event_btnTiendaFechasActionPerformed

private void btntodoTiendaFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntodoTiendaFechasActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREPORTE_VENTAS_GLOBAL())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialTiendas.getDate() == null || dtpFechaFinalTiendas.getDate() == null) {
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialTiendas.getDate().after(dtpFechaFinalTiendas.getDate())) {
        Mensaje.mensaje(this, "Fecha inicial no puede ser mayor que la fecha final", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    ireport.ventasTienda("%", Util.getFecha("yyyy-MM-dd", dtpFechaInicialTiendas.getDate()),
            Util.getFecha("yyyy-MM-dd", dtpFechaFinalTiendas.getDate()),  "");
}//GEN-LAST:event_btntodoTiendaFechasActionPerformed

private void btnVentasDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasDiaActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREPORTE_VENTAS_GRAFICO_POR_TIENDA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialGraficos.getDate() == null || dtpFechaFinalGraficos.getDate() == null) {
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialGraficos.getDate().after(dtpFechaFinalGraficos.getDate())) {
        Mensaje.mensaje(this, "Fecha inicial no puede ser mayor que la fecha final", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    ireport.GraficoVentaTiendaDia(Util.getFecha("yyyy-MM-dd", dtpFechaInicialGraficos.getDate()),
            Util.getFecha("yyyy-MM-dd", dtpFechaFinalGraficos.getDate()));
}//GEN-LAST:event_btnVentasDiaActionPerformed

private void btnEvoluvionFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvoluvionFechasActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREPORTE_VENTAS_GRAFICO_EVOLUCION())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialGraficos.getDate() == null || dtpFechaFinalGraficos.getDate() == null) {
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialGraficos.getDate().after(dtpFechaFinalGraficos.getDate())) {
        Mensaje.mensaje(this, "Fecha inicial no puede ser mayor que la fecha final", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    ireport.VentaFechasLineas(Util.getFecha("yyyy-MM-dd", dtpFechaInicialGraficos.getDate()),
            Util.getFecha("yyyy-MM-dd", dtpFechaFinalGraficos.getDate()));
}//GEN-LAST:event_btnEvoluvionFechasActionPerformed

private void btnFacturasFechas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturasFechas1ActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREPORTE_VENTAS_FACTURA_TIENDA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (cboTienda.getSelectedIndex() == 0) {
        Mensaje.mensaje(this, "Debe seleccionar un Local", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialTiendas.getDate() == null || dtpFechaFinalTiendas.getDate() == null) {
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialTiendas.getDate().after(dtpFechaFinalTiendas.getDate())) {
        Mensaje.mensaje(this, "Fecha inicial no puede ser mayor que la fecha final", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    String local = ("" + listaLocal.get(cboTienda.getSelectedIndex() - 1).getInt_idLocal()).trim();
    String doc = PaqueteBusinessDelegate.getVentasService().prefijoXlocalxTipoDocumento(Integer.parseInt(local), Util.CODIGO_FACTURA);
        /*switch (local) {
            case "1":
                doc="F-010-";
                break;
            case "2":
                doc="F-013-";
                break;
            default:
                doc="F-011-";
                break;
        }*/
    ireport.ventasTienda(local, Util.getFecha("yyyy-MM-dd", dtpFechaInicialTiendas.getDate()),
            Util.getFecha("yyyy-MM-dd", dtpFechaFinalTiendas.getDate()),  doc);
}//GEN-LAST:event_btnFacturasFechas1ActionPerformed

private void btnTotalesDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalesDiaActionPerformed
    
    
    if (cboTienda.getSelectedIndex() == 0) {
        Mensaje.mensaje(this, "Debe seleccionar un Local", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialTiendas.getDate() == null || dtpFechaFinalTiendas.getDate() == null) {
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialTiendas.getDate().after(dtpFechaFinalTiendas.getDate())) {
        Mensaje.mensaje(this, "Fecha inicial no puede ser mayor que la fecha final", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    String local = ("" + listaLocal.get(cboTienda.getSelectedIndex() - 1).getInt_idLocal()).trim();
    
    int idLocal=Integer.parseInt(local);
   
    ireport.TotalesDia(Util.getFecha("yyyy-MM-dd", dtpFechaInicialTiendas.getDate()),
            Util.getFecha("yyyy-MM-dd", dtpFechaFinalTiendas.getDate()),idLocal);
}//GEN-LAST:event_btnTotalesDiaActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    /*if (cboTiendaRegistro.getSelectedIndex() == 0) {
        Mensaje.mensaje(this, "Debe seleccionar un Local", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }*/
    
    if (dtpFechaInicialRegistro.getDate() == null || dtpFechaFinalRegistro.getDate() == null) {
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialRegistro.getDate().after(dtpFechaFinalRegistro.getDate())) {
        Mensaje.mensaje(this, "Fecha inicial no puede ser mayor que la fecha final", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    String fechaInicial =Util.getFecha("yyyy-MM-dd", dtpFechaInicialRegistro.getDate());
    //String fechaFinal =Util.getFecha("yyyy-MM-dd", dtpFechaInicialRegistro.getDate());
    
    String mesFinal=(fechaInicial.substring(5, 7).equals("01"))?"Enero":
            fechaInicial.substring(5, 7).equals("02")?"Febrero":
            fechaInicial.substring(5, 7).equals("03")?"Marzo":
            fechaInicial.substring(5, 7).equals("04")?"Abril":
            fechaInicial.substring(5, 7).equals("05")?"Mayo":
            fechaInicial.substring(5, 7).equals("06")?"Junio":
            fechaInicial.substring(5, 7).equals("07")?"Julio":
            fechaInicial.substring(5, 7).equals("08")?"Agosto":
            fechaInicial.substring(5, 7).equals("09")?"Septiembre":
            fechaInicial.substring(5, 7).equals("10")?"Octubre":
            fechaInicial.substring(5, 7).equals("11")?"Noviembre":"Diciembre";
    
    String mesInicialTitulo = (fechaInicial.substring(5, 7).equals("01"))?"Enero":
        fechaInicial.substring(5, 7).equals("02")?"Febrero":
        fechaInicial.substring(5, 7).equals("03")?"Marzo":
        fechaInicial.substring(5, 7).equals("04")?"Abril":
        fechaInicial.substring(5, 7).equals("05")?"Mayo":
        fechaInicial.substring(5, 7).equals("06")?"Junio":
        fechaInicial.substring(5, 7).equals("07")?"Julio":
        fechaInicial.substring(5, 7).equals("08")?"Agosto":
        fechaInicial.substring(5, 7).equals("09")?"Septiembre":
        fechaInicial.substring(5, 7).equals("10")?"Octubre":
        fechaInicial.substring(5, 7).equals("11")?"Noviembre":"Diciembre";;
    
    String mesFinalTitulo=mesFinal.concat(" de "+fechaInicial.substring(0, 4));
    log.info("mes--"+fechaInicial);
    log.info("mes final --"+fechaInicial.substring(6, 8));
    log.info("fecha---"+mesFinalTitulo);
    
    //String local = ("" + listaLocal.get(cboTiendaRegistro.getSelectedIndex() - 1).getStr_nombre()).trim();
    
    /*int idLocal = (listaLocal.get(cboTiendaRegistro.getSelectedIndex() - 1).getInt_idLocal());*/
   
    ireport.RegistroVentas(Util.getFecha("yyyy-MM-dd", dtpFechaInicialRegistro.getDate()),
            Util.getFecha("yyyy-MM-dd", dtpFechaFinalRegistro.getDate()),mesInicialTitulo,mesFinalTitulo,this.gui.getEmpresa().getStr_ruc());
    
}//GEN-LAST:event_jButton1ActionPerformed

private void btnRegistroVentaSunatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroVentaSunatActionPerformed

    if (dtpFechaInicialRegistro.getDate() == null || dtpFechaFinalRegistro.getDate() == null) {
        Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (dtpFechaInicialRegistro.getDate().after(dtpFechaFinalRegistro.getDate())) {
        Mensaje.mensaje(this, "Fecha inicial no puede ser mayor que la fecha final", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    listaRegistroVenta=PaqueteBusinessDelegate.getRegistroVentaService().
            listarRegistroVenta(Util.getFecha("yyyy-MM-dd", dtpFechaInicialRegistro.getDate()),
            Util.getFecha("yyyy-MM-dd", dtpFechaFinalRegistro.getDate()));
    String f=Util.getFecha("yyyyMM", dtpFechaInicialRegistro.getDate());
    String sFichero = "LE20103845913"+f+"00"+"140100"+"00"+"1111"+".txt";
    File fichero = new File(sFichero);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
            PrintWriter wr = new PrintWriter(bw);  
            String cabecera="Periodo |"
                    + "Codigo único de Operación               |"
                    + "Fecha de emisión |"
                    + "Fecha de Pago |"
                    + "Tipo Comprobante |"
                    + "Número Serie C. Pago |"
                    + "Número Comprobante   |"
                    + "Importe total diario |"
                    + "Tipo Doc. Identidad Cliente |"
                    + "Número Doc. Identidad Cliente |"
                    + "Nombres o Razón Social                                     |"
                    + "Valor facturado exportación |"
                    + "Base imponible de la operación grabada |"
                    + "Importe total operación exonerada |"
                    + "Importe total operadión inafecta |"
                    + "ISC            |"
                    + "IGV y/o IPM    |"
                    + "Base imponible operacion gravada con IVAP |"
                    + "IVAP           |"
                    + "Otro tributos y cargos que no forman parte de la base imponible |"
                    + "Importe total comprobante de pago |"
                    + "Tipo de cambio |"
                    + "Fecha emision documento original que se modifica |"
                    + "Tipo de documento original que se modifica |"
                    + "Número serie de documento original que se modifica |"
                    + "Numero documento original que se modifica |"
                    + "Estado del Comprobante |";
            wr.println(cabecera);
            
            wr.println(rayita(cabecera.length(), "="));
            
            String periodo="";
//            String rayita= "";
            String registro="";
            for (RegistroVenta r : listaRegistroVenta) {
                periodo = r.getStr_fechaEmision().replace("-", "").substring(0, 8);               
                registro=periodo+"|"+
                        r.getStr_idVenta()+espacios(40, r.getStr_idVenta().length())+"|"+
                        Util.getFecha("dd/MM/yyyy",Util.StringTODate(r.getStr_fechaEmision()))+espacios("Fecha de emisión ".length(), 10)+"|"+
                        Util.getFecha("dd/MM/yyyy",Util.StringTODate(r.getStr_fechaPago()) )+espacios("Fecha de Pago ".length(), 10)+"|"+
                        ((r.getStr_tipoComprobante().startsWith("B"))?"03":(r.getStr_tipoComprobante().startsWith("F"))?"01":"07")+espacios("Tipo Comprobante ".length(), 2)+"|"+
                        r.getStr_nroSerieDoc()+espacios("Número Serie C. Pago ".length(), r.getStr_nroSerieDoc().length())+"|"+
                        r.getStr_correlativoDoc()+espacios("Número Comprobante   ".length(), r.getStr_correlativoDoc().length())+"|"+
                        boletaDiario(Util.getFecha("dd/MM/yyyy",Util.StringTODate(r.getStr_fechaEmision())))+espacios("Importe total diario ".length(), boletaDiario(Util.getFecha("dd/MM/yyyy",Util.StringTODate(r.getStr_fechaEmision()))).length())+"|"+
                        ((r.getStr_tipoComprobante().startsWith("B"))?"0":"6")+espacios("Tipo Doc. Identidad Cliente ".length(), 1)+"|"+
                        ((r.getStr_tipoComprobante().startsWith("F"))?r.getStr_nroDocIdendidadCliente():"-")+espacios("Número Doc. Identidad Cliente ".length(),((r.getStr_tipoComprobante().startsWith("F"))?r.getStr_nroDocIdendidadCliente():"-").length())+"|"+
                        ((r.getStr_tipoComprobante().startsWith("F"))?r.getStr_razonSocial():r.getStr_nombreCliente())+espacios("Nombres o Razón Social                                     ".length(), ((r.getStr_tipoComprobante().startsWith("F"))?r.getStr_razonSocial():r.getStr_nombreCliente()).length())+"|"+
                        "0.00"+espacios("Valor facturado exportación ".length(), 4)+"|"+
                        r.getStr_baseImponibleOperacion()+espacios("Base imponible de la operación grabada ".length(), r.getStr_baseImponibleOperacion().length())+"|"+
                        r.getStr_importeTotalOpeExonerado()+espacios("Importe total operación exonerada ".length(), r.getStr_importeTotalOpeExonerado().length())+"|"+
                        r.getStr_importeTotalOpeInafecta()+espacios("Importe total operadión inafecta ".length(), r.getStr_importeTotalOpeInafecta().length())+"|"+
                        "0.00"+espacios("ISC            ".length(), 4)+"|"+
                        "0.00"+espacios("IGV y/o IPM    ".length(), 4)+"|"+
                        "0.00"+espacios("Base imponible operacion gravada con IVAP ".length(), 4)+"|"+
                        "0.00"+espacios("IVAP           ".length(), 4)+"|"+
                        "0.00"+espacios("Otro tributos y cargos que no forman parte de la base imponible ".length(), 4)+"|"+
                        r.getStr_importeTotalDoc()+espacios("Importe total comprobante de pago ".length(), r.getStr_importeTotalDoc().length())+"|"+
                        "0.000"+espacios("Tipo de cambio ".length(), 5)+"|"+
                        ((r.getStr_tipoVenta().equals("CREDITO") && r.getStr_estadoDoc().equals("PAGADO"))?Util.getFecha("dd/MM/yyyy",Util.StringTODate(r.getStr_fechaEmision())):"01/01/0001")+espacios("Fecha emision documento original que se modifica ".length(), 10)+"|"+
                        ((r.getStr_tipoVenta().equals("CREDITO") && r.getStr_estadoDoc().equals("PAGADO"))?"07":"00")+espacios("Tipo de documento original que se modifica ".length(), 2)+"|"+
                        ((r.getStr_tipoVenta().equals("CREDITO") && r.getStr_estadoDoc().equals("PAGADO"))?r.getStr_nroSerieDoc():"-")+espacios("Número serie de documento original que se modifica ".length(), ((r.getStr_tipoVenta().equals("CREDITO") && r.getStr_estadoDoc().equals("PAGADO"))?r.getStr_nroSerieDoc():"-").length())+"|"+
                        ((r.getStr_tipoVenta().equals("CREDITO") && r.getStr_estadoDoc().equals("PAGADO"))?r.getStr_correlativoDoc():"-")+espacios("Numero documento original que se modifica ".length(), ((r.getStr_tipoVenta().equals("CREDITO") && r.getStr_estadoDoc().equals("PAGADO"))?r.getStr_correlativoDoc():"-").length())+"|"+
                        ((r.getStr_estadoDoc().equals("ANULADO"))?"2":"1")+espacios("Estado del Comprobante ".length(), 1)+"|";
                       
                wr.println(registro);
                wr.println(rayita(registro.length(), "-"));
                
            }
            
            wr.println();
        wr.close();
        bw.close();
        
        } catch (IOException ex) {
            ex.getMessage();
        }       
}//GEN-LAST:event_btnRegistroVentaSunatActionPerformed

    private void btnRegistroVentaTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroVentaTiendaActionPerformed
        if (cboTiendaRegistro.getSelectedIndex() == 0) {
            Mensaje.mensaje(this, "Debe seleccionar un Local", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
    
        if (dtpFechaInicialRegistro.getDate() == null || dtpFechaFinalRegistro.getDate() == null) {
            Mensaje.mensaje(this, "Debe seleccionar un rango de fechas", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }

        if (dtpFechaInicialRegistro.getDate().after(dtpFechaFinalRegistro.getDate())) {
            Mensaje.mensaje(this, "Fecha inicial no puede ser mayor que la fecha final", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }

        String fechaInicial =Util.getFecha("yyyy-MM-dd", dtpFechaInicialRegistro.getDate());
        //String fechaFinal =Util.getFecha("yyyy-MM-dd", dtpFechaInicialRegistro.getDate());

        String mesFinal=(fechaInicial.substring(5, 7).equals("01"))?"Enero":
                fechaInicial.substring(5, 7).equals("02")?"Febrero":
                fechaInicial.substring(5, 7).equals("03")?"Marzo":
                fechaInicial.substring(5, 7).equals("04")?"Abril":
                fechaInicial.substring(5, 7).equals("05")?"Mayo":
                fechaInicial.substring(5, 7).equals("06")?"Junio":
                fechaInicial.substring(5, 7).equals("07")?"Julio":
                fechaInicial.substring(5, 7).equals("08")?"Agosto":
                fechaInicial.substring(5, 7).equals("09")?"Septiembre":
                fechaInicial.substring(5, 7).equals("10")?"Octubre":
                fechaInicial.substring(5, 7).equals("11")?"Noviembre":"Diciembre";

        String mesInicialTitulo = (fechaInicial.substring(5, 7).equals("01"))?"Enero":
            fechaInicial.substring(5, 7).equals("02")?"Febrero":
            fechaInicial.substring(5, 7).equals("03")?"Marzo":
            fechaInicial.substring(5, 7).equals("04")?"Abril":
            fechaInicial.substring(5, 7).equals("05")?"Mayo":
            fechaInicial.substring(5, 7).equals("06")?"Junio":
            fechaInicial.substring(5, 7).equals("07")?"Julio":
            fechaInicial.substring(5, 7).equals("08")?"Agosto":
            fechaInicial.substring(5, 7).equals("09")?"Septiembre":
            fechaInicial.substring(5, 7).equals("10")?"Octubre":
            fechaInicial.substring(5, 7).equals("11")?"Noviembre":"Diciembre";;

        String mesFinalTitulo=mesFinal.concat(" de "+fechaInicial.substring(0, 4));
        log.info("mes--"+fechaInicial);
        log.info("mes final --"+fechaInicial.substring(6, 8));
        log.info("fecha---"+mesFinalTitulo);

        String local = ("" + listaLocal.get(cboTiendaRegistro.getSelectedIndex() - 1).getStr_nombre()).trim();

        int idLocal = (listaLocal.get(cboTiendaRegistro.getSelectedIndex() - 1).getInt_idLocal());

        ireport.RegistroVentasTienda(Util.getFecha("yyyy-MM-dd", dtpFechaInicialRegistro.getDate()),
                Util.getFecha("yyyy-MM-dd", dtpFechaFinalRegistro.getDate()), local,idLocal,mesInicialTitulo,mesFinalTitulo,this.gui.getEmpresa().getStr_ruc());
    }//GEN-LAST:event_btnRegistroVentaTiendaActionPerformed
public String boletaDiario(String fecha){
    BigDecimal suma=BigDecimal.ZERO;
//        Date fechaControl= Util.StringTODate(fecha);
        for (RegistroVenta r : listaRegistroVenta) {
            if(Util.getFecha("dd/MM/yyyy",Util.StringTODate(r.getStr_fechaEmision())).equals(fecha) 
                    && r.getStr_estadoDoc().equals("PAGADO") && !r.getStr_tipoVenta().equals("CREDITO")){
                suma=suma.add(new BigDecimal(r.getStr_importeTotalDoc()));
            }
        }
        BigDecimal finalValue = ( suma.multiply(new BigDecimal(100.00))).divide(new BigDecimal(100.00));
    return ""+finalValue+"0";
} 

public String espacios(int cantidad, int cadena){
    String espacios="";
        for (int i = 0; i < (cantidad-cadena); i++) {
            espacios+=" ";
        }
    return espacios;
}

public String rayita(int tamaño,String caracter){
    String linea="";
    for (int i = 0; i <= tamaño; i++) {
               linea+=caracter;
    }
    return linea;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnEvoluvionFechas;
    private org.jdesktop.swingx.JXButton btnFacturasFechas1;
    private javax.swing.JButton btnRegistroVentaSunat;
    private javax.swing.JButton btnRegistroVentaTienda;
    private org.jdesktop.swingx.JXButton btnTiendaFechas;
    private org.jdesktop.swingx.JXButton btnTodoVendedoresFecha;
    private org.jdesktop.swingx.JXButton btnTotalesDia;
    private org.jdesktop.swingx.JXButton btnVendedorFecha;
    private org.jdesktop.swingx.JXButton btnVentasDia;
    private org.jdesktop.swingx.JXButton btntodoTiendaFechas;
    private org.jdesktop.swingx.JXComboBox cboTienda;
    private javax.swing.JComboBox cboTiendaRegistro;
    private org.jdesktop.swingx.JXComboBox cboVendedor;
    private org.jdesktop.swingx.JXDatePicker dtpFechaFinal;
    private org.jdesktop.swingx.JXDatePicker dtpFechaFinalGraficos;
    private org.jdesktop.swingx.JXDatePicker dtpFechaFinalRegistro;
    private org.jdesktop.swingx.JXDatePicker dtpFechaFinalTiendas;
    private org.jdesktop.swingx.JXDatePicker dtpFechaInicial;
    private org.jdesktop.swingx.JXDatePicker dtpFechaInicialGraficos;
    private org.jdesktop.swingx.JXDatePicker dtpFechaInicialRegistro;
    private org.jdesktop.swingx.JXDatePicker dtpFechaInicialTiendas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel10;
    private org.jdesktop.swingx.JXLabel jXLabel11;
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
    // End of variables declaration//GEN-END:variables

    private List<RegistroVenta>listaRegistroVenta= new ArrayList<>();
}
