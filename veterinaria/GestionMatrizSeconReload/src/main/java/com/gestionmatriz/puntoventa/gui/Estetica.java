/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PrecargaProducto.java
 *
 * Created on 23-ago-2012, 17:13:20
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.ConsultaStock;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;

/**
 *
 * @author YESM
 */
public class Estetica extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(Estetica.class); 
    private Principal  gui;
    ConsultaStock objConsultaStock;
    private Venta guiVenta;
    
    public Estetica(Principal gui,Venta guiVenta) {
        super(gui);
        this.gui=gui;
        this.guiVenta=guiVenta;
        initComponents();
        this.setTitle(""+gui.getTitle().concat(" - ").concat(" - [Modulo: Precarga Producto]"));
        setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        txtUbicacionBano = new org.jdesktop.swingx.JXTextField();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        cboPersonalBano = new javax.swing.JComboBox();
        cboTipoBano = new javax.swing.JComboBox();
        cboTipoMedicamento = new javax.swing.JComboBox();
        cboTamanoPaciente = new javax.swing.JComboBox();
        btnBuscarUbicacionBano = new javax.swing.JButton();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        chkLlamarBano = new javax.swing.JCheckBox();
        dtpFechaProximoBano = new org.jdesktop.swingx.JXDatePicker();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        txtRecogerBano = new org.jdesktop.swingx.JXTextField();
        txtTiempoBano = new org.jdesktop.swingx.JXTextField();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        chkBano = new javax.swing.JCheckBox();
        chkBano2 = new javax.swing.JCheckBox();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        jXLabel14 = new org.jdesktop.swingx.JXLabel();
        txtUbicacionBano1 = new org.jdesktop.swingx.JXTextField();
        jXLabel15 = new org.jdesktop.swingx.JXLabel();
        cboPersonalBano1 = new javax.swing.JComboBox();
        cboTipoBano1 = new javax.swing.JComboBox();
        btnBuscarUbicacionBano1 = new javax.swing.JButton();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        jXLabel16 = new org.jdesktop.swingx.JXLabel();
        chkLlamarBano1 = new javax.swing.JCheckBox();
        dtpFechaProximoCorte = new org.jdesktop.swingx.JXDatePicker();
        jXLabel17 = new org.jdesktop.swingx.JXLabel();
        jXLabel18 = new org.jdesktop.swingx.JXLabel();
        txtRecogerBano1 = new org.jdesktop.swingx.JXTextField();
        txtTiempoBano1 = new org.jdesktop.swingx.JXTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();

        jLabel1.setText("jLabel1");

        setType(java.awt.Window.Type.UTILITY);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Baño"));

        jXLabel1.setText("Tipo: ");
        jXLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel2.setText("Tipo Medicamento: ");
        jXLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel3.setText("Tamaño Paciente: ");
        jXLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel4.setText("Ubicación: ");
        jXLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtUbicacionBano.setEditable(false);
        txtUbicacionBano.setForeground(new java.awt.Color(255, 153, 0));
        txtUbicacionBano.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel5.setText("Personal: ");
        jXLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        cboPersonalBano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Medicado" }));

        cboTipoBano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Medicado" }));

        cboTipoMedicamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Medicado" }));

        cboTamanoPaciente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Pequeño", "Mediano", "Grande" }));

        btnBuscarUbicacionBano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarUbicacionBano.setText("Buscar");
        btnBuscarUbicacionBano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUbicacionBanoActionPerformed(evt);
            }
        });
        btnBuscarUbicacionBano.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarUbicacionBanorbnBoletaKeyPressed(evt);
            }
        });

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Proximo Baño"));

        jXLabel10.setText("Fecha: ");
        jXLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        chkLlamarBano.setText("Llamar");
        chkLlamarBano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLlamarBanoActionPerformed(evt);
            }
        });

        dtpFechaProximoBano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtpFechaProximoBanoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtpFechaProximoBano, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(chkLlamarBano)
                .addGap(0, 116, Short.MAX_VALUE))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkLlamarBano)
                    .addComponent(dtpFechaProximoBano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jXLabel6.setText("Recoger: ");
        jXLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel7.setText("Tiempo(Min.): ");
        jXLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtRecogerBano.setForeground(new java.awt.Color(255, 153, 0));
        txtRecogerBano.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtTiempoBano.setForeground(new java.awt.Color(255, 153, 0));
        txtTiempoBano.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboTipoMedicamento, 0, 153, Short.MAX_VALUE)
                    .addComponent(cboTipoBano, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboTamanoPaciente, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboPersonalBano, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUbicacionBano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarUbicacionBano)
                        .addGap(63, 63, 63))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTiempoBano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRecogerBano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipoBano, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTiempoBano, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTipoMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRecogerBano, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTamanoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUbicacionBano, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarUbicacionBano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPersonalBano, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jXLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel12.setText("[ESC]=REGRESAR");

        jXLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel11.setText("[F9]=CARGAR SERVICIO");

        chkBano.setText("Baño");
        chkBano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBanoActionPerformed(evt);
            }
        });

        chkBano2.setText("Peluqueria");
        chkBano2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBano2ActionPerformed(evt);
            }
        });

        jXPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Peluqueria"));

        jXLabel8.setText("Tipo: ");
        jXLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel9.setText("Descripcion: ");
        jXLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel14.setText("Ubicación: ");
        jXLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtUbicacionBano1.setEditable(false);
        txtUbicacionBano1.setForeground(new java.awt.Color(255, 153, 0));
        txtUbicacionBano1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel15.setText("Personal: ");
        jXLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        cboPersonalBano1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Medicado" }));

        cboTipoBano1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Medicado" }));

        btnBuscarUbicacionBano1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarUbicacionBano1.setText("Buscar");
        btnBuscarUbicacionBano1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUbicacionBano1ActionPerformed(evt);
            }
        });
        btnBuscarUbicacionBano1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarUbicacionBano1rbnBoletaKeyPressed(evt);
            }
        });

        jXPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Proximo Corte"));

        jXLabel16.setText("Fecha: ");
        jXLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        chkLlamarBano1.setText("Llamar");
        chkLlamarBano1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLlamarBano1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel4Layout = new javax.swing.GroupLayout(jXPanel4);
        jXPanel4.setLayout(jXPanel4Layout);
        jXPanel4Layout.setHorizontalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtpFechaProximoCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(chkLlamarBano1)
                .addGap(0, 116, Short.MAX_VALUE))
        );
        jXPanel4Layout.setVerticalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkLlamarBano1)
                    .addComponent(dtpFechaProximoCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jXLabel17.setText("Recoger: ");
        jXLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel18.setText("Tiempo(Min.): ");
        jXLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtRecogerBano1.setForeground(new java.awt.Color(255, 153, 0));
        txtRecogerBano1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtTiempoBano1.setForeground(new java.awt.Color(255, 153, 0));
        txtTiempoBano1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtDescripcion.setColumns(10);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jXLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTipoBano1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboPersonalBano1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUbicacionBano1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarUbicacionBano1))
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTiempoBano1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(txtRecogerBano1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipoBano1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTiempoBano1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRecogerBano1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUbicacionBano1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarUbicacionBano1))))
                .addGap(8, 8, 8)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPersonalBano1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jXPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(chkBano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkBano2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkBano)
                    .addComponent(chkBano2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        chkBano.getAccessibleContext().setAccessibleName("Bano");

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    evento(evt);
}//GEN-LAST:event_formKeyReleased

private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    evento(evt);
}//GEN-LAST:event_formKeyPressed

    private void btnBuscarUbicacionBanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUbicacionBanoActionPerformed
        //cargarBusquedaCliente();
    }//GEN-LAST:event_btnBuscarUbicacionBanoActionPerformed

    private void btnBuscarUbicacionBanorbnBoletaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarUbicacionBanorbnBoletaKeyPressed
        evento(evt);
    }//GEN-LAST:event_btnBuscarUbicacionBanorbnBoletaKeyPressed

    private void chkBanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBanoActionPerformed

    private void chkLlamarBanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLlamarBanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkLlamarBanoActionPerformed

    private void chkBano2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBano2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBano2ActionPerformed

    private void btnBuscarUbicacionBano1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUbicacionBano1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarUbicacionBano1ActionPerformed

    private void btnBuscarUbicacionBano1rbnBoletaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarUbicacionBano1rbnBoletaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarUbicacionBano1rbnBoletaKeyPressed

    private void chkLlamarBano1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLlamarBano1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkLlamarBano1ActionPerformed

    private void dtpFechaProximoBanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtpFechaProximoBanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtpFechaProximoBanoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarUbicacionBano;
    private javax.swing.JButton btnBuscarUbicacionBano1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboPersonalBano;
    private javax.swing.JComboBox cboPersonalBano1;
    private javax.swing.JComboBox cboTamanoPaciente;
    private javax.swing.JComboBox cboTipoBano;
    private javax.swing.JComboBox cboTipoBano1;
    private javax.swing.JComboBox cboTipoMedicamento;
    private javax.swing.JCheckBox chkBano;
    private javax.swing.JCheckBox chkBano2;
    private javax.swing.JCheckBox chkLlamarBano;
    private javax.swing.JCheckBox chkLlamarBano1;
    private org.jdesktop.swingx.JXDatePicker dtpFechaProximoBano;
    private org.jdesktop.swingx.JXDatePicker dtpFechaProximoCorte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel10;
    private org.jdesktop.swingx.JXLabel jXLabel11;
    private org.jdesktop.swingx.JXLabel jXLabel12;
    private org.jdesktop.swingx.JXLabel jXLabel14;
    private org.jdesktop.swingx.JXLabel jXLabel15;
    private org.jdesktop.swingx.JXLabel jXLabel16;
    private org.jdesktop.swingx.JXLabel jXLabel17;
    private org.jdesktop.swingx.JXLabel jXLabel18;
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
    private org.jdesktop.swingx.JXPanel jXPanel4;
    private javax.swing.JTextArea txtDescripcion;
    private org.jdesktop.swingx.JXTextField txtRecogerBano;
    private org.jdesktop.swingx.JXTextField txtRecogerBano1;
    private org.jdesktop.swingx.JXTextField txtTiempoBano;
    private org.jdesktop.swingx.JXTextField txtTiempoBano1;
    private org.jdesktop.swingx.JXTextField txtUbicacionBano;
    private org.jdesktop.swingx.JXTextField txtUbicacionBano1;
    // End of variables declaration//GEN-END:variables

    public void cargarData(ConsultaStock objConsultaStock) {
        this.objConsultaStock=objConsultaStock;
        
    }

    private void evento(KeyEvent evt) {
        
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            salirPrecargaProducto();
        }
        else if (evt.getKeyCode()==KeyEvent.VK_F9){
            if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCARGAR_PRODUCTO())) {
                Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
                return;
            }
            
            cargarProductoVenta();
        }
    }

    private void salirPrecargaProducto() {
        
       this.setVisible(false);
        guiVenta.getTbDetalleVenta().setFocusable(true);
        guiVenta.requestFocus();
    }
    
    
    public void setVisible(boolean b){
        super.setVisible(b);
//        if (!b)
//            guiVenta.requestFocus();
//        
//        txtCantidad.requestFocus();
    }

    private void cargarProductoVenta() {
        BigDecimal porIGV = PaqueteBusinessDelegate.getConfigBDService().getIGV();
        if (validarDuplicado()){
            
            Mensaje.mensaje
                    (gui, "Producto ya se encuentra agregado a la lista de pedido", Mensaje.TITULO_ME, Mensaje.ERROR);

            guiVenta.requestFocus();
            this.setVisible(false);
            
            return;
        }
        
        Ventas objVentas=new Ventas();
        
        
        

            
        objVentas.setObjProveedor(this.objConsultaStock.getObjProveedor());
        objVentas.setObjProducto(this.objConsultaStock.getObjProducto());

        objVentas.setDbPrecio(this.objConsultaStock.getDbl_precio());
        objVentas.setDbStock(this.objConsultaStock.getDbl_stock());
        objVentas.setObjUnidadMedida(this.objConsultaStock.getObjUnidadMedida());
        objVentas.setDbUnidadesContenidas(this.objConsultaStock.getDlb_stockXCompra());
        
        guiVenta.getListaVenta().add(objVentas);
        guiVenta.getTbDetalleVenta().listar(guiVenta.getListaVenta());
        guiVenta.realizarCalculo();
        this.setVisible(false);
        guiVenta.requestFocus();
    }
    
    private boolean validarDuplicado(){
        Ventas objVentas;

        for (Object obj:guiVenta.getListaVenta()){
            objVentas=(Ventas) obj;
            if (objConsultaStock.getObjProducto().getInt_idProducto()==
                    objVentas.getObjProducto().getInt_idProducto())
                return true;
        }
        
        return false;
    }
}
