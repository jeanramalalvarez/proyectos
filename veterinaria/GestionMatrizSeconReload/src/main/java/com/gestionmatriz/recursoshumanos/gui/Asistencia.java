/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Asistencia.java
 *
 * Created on 16-abr-2012, 9:05:50
 */
package com.gestionmatriz.recursoshumanos.gui;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXComboBox;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXTable;

import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.PartTime;
import com.gestionmatriz.recursoshumanos.bean.Permisos;
import com.gestionmatriz.recursoshumanos.opciones.Opciones;
import com.gestionmatriz.recursoshumanos.reportes.Ireport;
import com.gestionmatriz.reutilizable.gui.LectorHuella;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import com.gestionmatriz.util.ValidarCamposNulos;

/**
 *
 * @author zholo
 */
public class Asistencia extends javax.swing.JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(Asistencia.class); 
    private SpinnerNumberModel farRequested =
            new SpinnerNumberModel(DPFPVerification.MEDIUM_SECURITY_FAR, 1, DPFPVerification.PROBABILITY_ONE, 100);
    private List<Empresa> listaEmpresa;
    private List<com.gestionmatriz.recursoshumanos.bean.Asistencia> listaAsistencia;
    private List<com.gestionmatriz.recursoshumanos.bean.Permisos> listaPermisos;
    private List<PartTime> listaPartTime;
    private com.gestionmatriz.recursoshumanos.bean.Personal objPersona;
    private Principal gui1;
    private Principal gui;
    private Marcado frmMarcado;
    private LectorHuella frmLectorHuella;
    private Ireport ireport = new Ireport();
    private com.gestionmatriz.recursoshumanos.bean.Contrato objContrato;

    public Asistencia(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        PopupAsistencia = new javax.swing.JPopupMenu();
        mnuILimpiarFrm = new javax.swing.JMenuItem();
        pnlEscritorioAsistencia = new javax.swing.JDesktopPane();
        pnlOpcionesAsistencia = new javax.swing.JPanel();
        btnAsistencia = new org.jdesktop.swingx.JXButton();
        jXButton2 = new org.jdesktop.swingx.JXButton();
        jXButton3 = new org.jdesktop.swingx.JXButton();
        jXButton4 = new org.jdesktop.swingx.JXButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlAsistencia = new javax.swing.JPanel();
        pnlPermisos = new javax.swing.JPanel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        cboMotivoPermisos = new org.jdesktop.swingx.JXComboBox();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        btnIdentificarPersona = new org.jdesktop.swingx.JXButton();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        lblNombreTrabajadorPermisos = new org.jdesktop.swingx.JXLabel();
        lblDepartamentoPermisos = new org.jdesktop.swingx.JXLabel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        dtpFechaPermisos = new org.jdesktop.swingx.JXDatePicker();
        lblHoraSalida = new org.jdesktop.swingx.JXLabel();
        lblHoraRegreso = new org.jdesktop.swingx.JXLabel();
        btnEnviarSolicitudPermisos = new org.jdesktop.swingx.JXButton();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        lblEstadoPermiso = new org.jdesktop.swingx.JXLabel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservaciones = new org.jdesktop.swingx.JXTextArea();
        rbtMotivoPersonalPermiso = new javax.swing.JRadioButton();
        rbtMotivoTrabajoPermiso = new javax.swing.JRadioButton();
        cboHoraSalida = new org.jdesktop.swingx.JXComboBox();
        cboMinutosSalida = new org.jdesktop.swingx.JXComboBox();
        cboHoraRegreso = new org.jdesktop.swingx.JXComboBox();
        cboMinutoRegreso = new org.jdesktop.swingx.JXComboBox();
        pnlConsultar = new javax.swing.JPanel();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        cboConsultarConsultas = new org.jdesktop.swingx.JXComboBox();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        jXLabel14 = new org.jdesktop.swingx.JXLabel();
        dtpFechaInicioConsultas = new org.jdesktop.swingx.JXDatePicker();
        dtpFechaFinalConsultas = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListarPermisosConsultas = new org.jdesktop.swingx.JXTable();
        btnBuscarConsultas = new org.jdesktop.swingx.JXButton();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        cboEmpresa = new org.jdesktop.swingx.JXComboBox();
        btnReporte = new org.jdesktop.swingx.JXButton();
        btnReporteTrabajador = new org.jdesktop.swingx.JXButton();
        jXButton1 = new org.jdesktop.swingx.JXButton();
        pnlInformación = new javax.swing.JPanel();
        pnlMedioTiempo = new javax.swing.JPanel();
        lblNombreTrabajadorPartTime = new org.jdesktop.swingx.JXLabel();
        lblDepartamentoPartTime = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        btnIdentificarPartTime = new org.jdesktop.swingx.JXButton();
        btnIngresoPartTime = new org.jdesktop.swingx.JXButton();
        btnSalidaPartTime = new org.jdesktop.swingx.JXButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPartTime = new org.jdesktop.swingx.JXTable();

        mnuILimpiarFrm.setText("Limpiar");
        mnuILimpiarFrm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuILimpiarFrmActionPerformed(evt);
            }
        });
        PopupAsistencia.add(mnuILimpiarFrm);

        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIONAR ASISTENCIA");
        setPreferredSize(new java.awt.Dimension(813, 436));

        pnlOpcionesAsistencia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "OPCIONES DEL SISTEMA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), java.awt.Color.black)); // NOI18N

        btnAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/asistencia.png"))); // NOI18N
        btnAsistencia.setText("Asistencia");
        btnAsistencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });

        jXButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/permisos.png"))); // NOI18N
        jXButton2.setText("Permisos");
        jXButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton2ActionPerformed(evt);
            }
        });

        jXButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/consultas.png"))); // NOI18N
        jXButton3.setText("Consultas");
        jXButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton3ActionPerformed(evt);
            }
        });

        jXButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/informacion.png"))); // NOI18N
        jXButton4.setText("Información");
        jXButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesAsistenciaLayout = new javax.swing.GroupLayout(pnlOpcionesAsistencia);
        pnlOpcionesAsistencia.setLayout(pnlOpcionesAsistenciaLayout);
        pnlOpcionesAsistenciaLayout.setHorizontalGroup(
            pnlOpcionesAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesAsistenciaLayout.createSequentialGroup()
                .addGroup(pnlOpcionesAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(jXButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlOpcionesAsistenciaLayout.setVerticalGroup(
            pnlOpcionesAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesAsistenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jXButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpcionesAsistencia.setBounds(10, 10, 170, 390);
        pnlEscritorioAsistencia.add(pnlOpcionesAsistencia, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlAsistencia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "ASISTENCIA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout pnlAsistenciaLayout = new javax.swing.GroupLayout(pnlAsistencia);
        pnlAsistencia.setLayout(pnlAsistenciaLayout);
        pnlAsistenciaLayout.setHorizontalGroup(
            pnlAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );
        pnlAsistenciaLayout.setVerticalGroup(
            pnlAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Asistencia", pnlAsistencia);

        pnlPermisos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PAPELETA DE SALIDAS DEL PERSONAL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlPermisos.setComponentPopupMenu(PopupAsistencia);
        pnlPermisos.setLayout(null);

        jXLabel2.setText("Motivo:");
        pnlPermisos.add(jXLabel2);
        jXLabel2.setBounds(15, 139, 70, 15);
        pnlPermisos.add(cboMotivoPermisos);
        cboMotivoPermisos.setBounds(301, 136, 270, 17);

        jXLabel3.setText("Nombre: ");
        pnlPermisos.add(jXLabel3);
        jXLabel3.setBounds(15, 31, 70, 15);

        btnIdentificarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/identificacion.png"))); // NOI18N
        btnIdentificarPersona.setText("Identificación");
        btnIdentificarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdentificarPersonaActionPerformed(evt);
            }
        });
        pnlPermisos.add(btnIdentificarPersona);
        btnIdentificarPersona.setBounds(319, 27, 140, 23);

        jXLabel4.setText("Departamento:");
        pnlPermisos.add(jXLabel4);
        jXLabel4.setBounds(15, 62, 90, 15);

        lblNombreTrabajadorPermisos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlPermisos.add(lblNombreTrabajadorPermisos);
        lblNombreTrabajadorPermisos.setBounds(106, 30, 200, 20);

        lblDepartamentoPermisos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlPermisos.add(lblDepartamentoPermisos);
        lblDepartamentoPermisos.setBounds(106, 61, 200, 20);

        jXLabel7.setText("Fecha:");
        pnlPermisos.add(jXLabel7);
        jXLabel7.setBounds(15, 99, 70, 15);
        pnlPermisos.add(dtpFechaPermisos);
        dtpFechaPermisos.setBounds(106, 95, 132, 25);

        lblHoraSalida.setText("Hora de salida:");
        pnlPermisos.add(lblHoraSalida);
        lblHoraSalida.setBounds(15, 244, 90, 15);

        lblHoraRegreso.setText("Hora de Retorno:");
        pnlPermisos.add(lblHoraRegreso);
        lblHoraRegreso.setBounds(207, 244, 99, 15);

        btnEnviarSolicitudPermisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/enviosolicitud.png"))); // NOI18N
        btnEnviarSolicitudPermisos.setText("Enviar Solicitud");
        btnEnviarSolicitudPermisos.setPreferredSize(new java.awt.Dimension(129, 23));
        btnEnviarSolicitudPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarSolicitudPermisosActionPerformed(evt);
            }
        });
        pnlPermisos.add(btnEnviarSolicitudPermisos);
        btnEnviarSolicitudPermisos.setBounds(260, 280, 170, 23);

        jXLabel10.setText("Estado de la Solicitud:");
        pnlPermisos.add(jXLabel10);
        jXLabel10.setBounds(10, 330, 150, 15);

        lblEstadoPermiso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlPermisos.add(lblEstadoPermiso);
        lblEstadoPermiso.setBounds(150, 330, 280, 20);

        jXLabel1.setText("Especificar:");
        pnlPermisos.add(jXLabel1);
        jXLabel1.setBounds(15, 176, 70, 15);

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtObservaciones);

        pnlPermisos.add(jScrollPane2);
        jScrollPane2.setBounds(105, 176, 326, 47);

        buttonGroup1.add(rbtMotivoPersonalPermiso);
        rbtMotivoPersonalPermiso.setSelected(true);
        rbtMotivoPersonalPermiso.setText("Personal");
        rbtMotivoPersonalPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtMotivoPersonalPermisoActionPerformed(evt);
            }
        });
        pnlPermisos.add(rbtMotivoPersonalPermiso);
        rbtMotivoPersonalPermiso.setBounds(110, 130, 90, 22);

        buttonGroup1.add(rbtMotivoTrabajoPermiso);
        rbtMotivoTrabajoPermiso.setText("Trabajo");
        rbtMotivoTrabajoPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtMotivoTrabajoPermisoActionPerformed(evt);
            }
        });
        pnlPermisos.add(rbtMotivoTrabajoPermiso);
        rbtMotivoTrabajoPermiso.setBounds(200, 130, 100, 22);

        cboHoraSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHoraSalidaActionPerformed(evt);
            }
        });
        pnlPermisos.add(cboHoraSalida);
        cboHoraSalida.setBounds(110, 240, 40, 17);

        cboMinutosSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMinutosSalidaActionPerformed(evt);
            }
        });
        pnlPermisos.add(cboMinutosSalida);
        cboMinutosSalida.setBounds(160, 240, 40, 17);

        cboHoraRegreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHoraRegresoActionPerformed(evt);
            }
        });
        pnlPermisos.add(cboHoraRegreso);
        cboHoraRegreso.setBounds(300, 240, 40, 17);
        pnlPermisos.add(cboMinutoRegreso);
        cboMinutoRegreso.setBounds(350, 240, 50, 17);

        jTabbedPane1.addTab("Permisos", pnlPermisos);

        pnlConsultar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "CONSULTAR ASISTENCIA Y PERMISOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlConsultar.setComponentPopupMenu(PopupAsistencia);
        pnlConsultar.setLayout(null);

        jXLabel12.setText("Consultar:");
        pnlConsultar.add(jXLabel12);
        jXLabel12.setBounds(15, 30, 80, 15);

        cboConsultarConsultas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ASISTENCIAS", "PERMISOS" }));
        pnlConsultar.add(cboConsultarConsultas);
        cboConsultarConsultas.setBounds(118, 27, 140, 17);

        jXLabel13.setText("Fecha Inicio:");
        pnlConsultar.add(jXLabel13);
        jXLabel13.setBounds(15, 62, 100, 15);

        jXLabel14.setText("Fecha Final:");
        pnlConsultar.add(jXLabel14);
        jXLabel14.setBounds(290, 60, 80, 15);
        pnlConsultar.add(dtpFechaInicioConsultas);
        dtpFechaInicioConsultas.setBounds(118, 58, 140, 25);
        pnlConsultar.add(dtpFechaFinalConsultas);
        dtpFechaFinalConsultas.setBounds(380, 60, 170, 25);

        tblListarPermisosConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblListarPermisosConsultas);
        tblListarPermisosConsultas.setColumnControlVisible(true);

        pnlConsultar.add(jScrollPane1);
        jScrollPane1.setBounds(15, 146, 580, 200);

        btnBuscarConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarConsultas.setText("Buscar");
        btnBuscarConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarConsultasActionPerformed(evt);
            }
        });
        pnlConsultar.add(btnBuscarConsultas);
        btnBuscarConsultas.setBounds(230, 120, 100, 23);

        jXLabel6.setText("Empresa: ");
        pnlConsultar.add(jXLabel6);
        jXLabel6.setBounds(290, 30, 70, 20);
        pnlConsultar.add(cboEmpresa);
        cboEmpresa.setBounds(380, 30, 220, 17);

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/vistaprevia.png"))); // NOI18N
        btnReporte.setText("Ver Reporte");
        btnReporte.setPreferredSize(new java.awt.Dimension(149, 29));
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        pnlConsultar.add(btnReporte);
        btnReporte.setBounds(410, 90, 181, 23);

        btnReporteTrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/reportetrabajador.png"))); // NOI18N
        btnReporteTrabajador.setText("Reporte por trabajador");
        btnReporteTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteTrabajadorActionPerformed(evt);
            }
        });
        pnlConsultar.add(btnReporteTrabajador);
        btnReporteTrabajador.setBounds(10, 90, 200, 23);

        jXButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/reportelocales.png"))); // NOI18N
        jXButton1.setText("Reporte por locales");
        jXButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton1ActionPerformed(evt);
            }
        });
        pnlConsultar.add(jXButton1);
        jXButton1.setBounds(220, 90, 181, 23);

        jTabbedPane1.addTab("Consultas", pnlConsultar);

        javax.swing.GroupLayout pnlInformaciónLayout = new javax.swing.GroupLayout(pnlInformación);
        pnlInformación.setLayout(pnlInformaciónLayout);
        pnlInformaciónLayout.setHorizontalGroup(
            pnlInformaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        pnlInformaciónLayout.setVerticalGroup(
            pnlInformaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Información", pnlInformación);

        pnlMedioTiempo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "MARCACIÓN POR MEDIO TIEMPO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        lblNombreTrabajadorPartTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDepartamentoPartTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jXLabel5.setText("Departamento:");

        jXLabel8.setText("Nombre: ");

        btnIdentificarPartTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/identificacion.png"))); // NOI18N
        btnIdentificarPartTime.setText("Identificación");
        btnIdentificarPartTime.setPreferredSize(new java.awt.Dimension(121, 23));
        btnIdentificarPartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdentificarPartTimeActionPerformed(evt);
            }
        });

        btnIngresoPartTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/ingreso.png"))); // NOI18N
        btnIngresoPartTime.setText("Ingreso");
        btnIngresoPartTime.setEnabled(false);
        btnIngresoPartTime.setPreferredSize(new java.awt.Dimension(93, 23));
        btnIngresoPartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoPartTimeActionPerformed(evt);
            }
        });

        btnSalidaPartTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/salirmini.png"))); // NOI18N
        btnSalidaPartTime.setText("Salida");
        btnSalidaPartTime.setEnabled(false);
        btnSalidaPartTime.setPreferredSize(new java.awt.Dimension(85, 23));
        btnSalidaPartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaPartTimeActionPerformed(evt);
            }
        });

        tblPartTime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblPartTime);

        javax.swing.GroupLayout pnlMedioTiempoLayout = new javax.swing.GroupLayout(pnlMedioTiempo);
        pnlMedioTiempo.setLayout(pnlMedioTiempoLayout);
        pnlMedioTiempoLayout.setHorizontalGroup(
            pnlMedioTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMedioTiempoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMedioTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMedioTiempoLayout.createSequentialGroup()
                        .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(pnlMedioTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreTrabajadorPartTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDepartamentoPartTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMedioTiempoLayout.createSequentialGroup()
                                .addComponent(btnIngresoPartTime, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalidaPartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIdentificarPartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182))
                    .addGroup(pnlMedioTiempoLayout.createSequentialGroup()
                        .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlMedioTiempoLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(39, 39, 39))))
        );
        pnlMedioTiempoLayout.setVerticalGroup(
            pnlMedioTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMedioTiempoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlMedioTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreTrabajadorPartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIdentificarPartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlMedioTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDepartamentoPartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMedioTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresoPartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalidaPartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jTabbedPane1.addTab("Part Time", pnlMedioTiempo);

        jTabbedPane1.setBounds(179, 10, 630, 390);
        pnlEscritorioAsistencia.add(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTabbedPane1.setEnabledAt(0, false);
        //jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(3, false);

        getContentPane().add(pnlEscritorioAsistencia, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarEmpresa() {

        cboEmpresa.removeAllItems();
        Object objTitle = ".::Seleccione una Empresa::.";

        cboEmpresa.addItem(objTitle);
        try {
            listaEmpresa = PaqueteBusinessDelegate.
                    getContratoService().listarEmpresa();
            Object item;
            for (Empresa empresa : listaEmpresa) {
                item = empresa.getStr_razonSocial();
                cboEmpresa.addItem(item);
            }
        } catch (SQLException ex) {
            log.error("Error al cargar empresas: " + ex.getMessage());
        }

    }

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

private void btnEnviarSolicitudPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarSolicitudPermisosActionPerformed

    if (!ValidarLblTrabajador()) {
        return;
    }
    if (!ValidarFecha()) {
        return;
    }
    if (!ValidarMotivoPermiso()) {
        return;
    }


    Permisos objPermiso = new Permisos();

    objPermiso.setObjPersona(gui.getObjPersonalHuella());
    objPermiso.setInt_idPersona(Util.stringTOint(gui.getObjPersonalHuella().
            getStr_codigo().substring(1, gui.getObjPersonalHuella().getStr_codigo().length())));
    objPermiso.setDte_fecha(Util.getFecha("yyyy-MM-dd", dtpFechaPermisos.getDate()));
    String motivo;

    if (rbtMotivoPersonalPermiso.isSelected()) {
        motivo = rbtMotivoPersonalPermiso.getText();
    } else {
        motivo = rbtMotivoTrabajoPermiso.getText();
    }

    motivo += " " + cboMotivoPermisos.getSelectedItem().toString();

    objPermiso.setStr_motivo(motivo);
    objPermiso.setStr_observacion("(" + lblDepartamentoPermisos.getText() + ") " + txtObservaciones.getText());
    objPermiso.setTm_horaSalida(cboHoraSalida.getSelectedItem().toString().concat(":").
            concat(cboMinutosSalida.getSelectedItem().toString()));
    objPermiso.setTm_horaLlegada(cboHoraRegreso.getSelectedItem().toString().concat(":").
            concat(cboMinutoRegreso.getSelectedItem().toString()));


    if (PaqueteBusinessDelegate.getPermisosService().registrarPermiso(objPermiso)) {
        Mensaje.mensaje(this, "Permiso Registrado Exitosamente Para: ".
                concat(gui.getObjPersonalHuella().getStr_nombres().concat(" ").
                concat(gui.getObjPersonalHuella().getStr_apePaterno()).concat(" ").
                concat(gui.getObjPersonalHuella().getStr_apeMaterno())), Mensaje.TITULO_ME, Mensaje.INFORMACION);

        lblEstadoPermiso.setText(Util.ACTIVO);
    } else {
        Mensaje.mensaje(this, "No se Pudo Registrar su Permiso", Mensaje.TITULO_ME, Mensaje.ERROR);
    }
}//GEN-LAST:event_btnEnviarSolicitudPermisosActionPerformed

private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed
    Util.hiloProgressBar(1, gui);
    frmMarcado = new Marcado(gui, farRequested.getNumber().intValue());
    Util.hiloProgressBar(0, gui);
    frmMarcado.setVisible(true);
}//GEN-LAST:event_btnAsistenciaActionPerformed

private void btnBuscarConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarConsultasActionPerformed




    int idSeleccionado = cboConsultarConsultas.getSelectedIndex();
    int indexEmpresa = cboEmpresa.getSelectedIndex();

    if (indexEmpresa <= 0) {
        Mensaje.mensaje(this, "Seleccione una Empresa", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    int idEmpresa = listaEmpresa.get(cboEmpresa.getSelectedIndex() - 1).getInt_idEmpresa();

    String fechaInicial = Util.getFecha("yyyy-MM-dd", dtpFechaInicioConsultas.getDate());
    String fechaFinal = Util.getFecha("yyyy-MM-dd", dtpFechaFinalConsultas.getDate());


    if (idSeleccionado == 0) {


        if (!ValidarFechaConsultar()) {
            return;
        }


        cagarTable(tblListarPermisosConsultas, PaqueteBusinessDelegate.getAsistenciaService().
                consultarAsistencia(fechaInicial, fechaFinal, idEmpresa));

    } else {


        if (Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getAPROBARPERMISO())) {
            cagarTable(tblListarPermisosConsultas, PaqueteBusinessDelegate.getPermisosService().listaPermisos(fechaInicial, fechaFinal));
        } else {
            gui.loadLectorHuella();

            cagarTablePermisos(tblListarPermisosConsultas, PaqueteBusinessDelegate.getPermisosService().listaPermisosXPersona(
                    gui.getObjPersonalHuella().getInt_idPersona()));

        }

    }

}//GEN-LAST:event_btnBuscarConsultasActionPerformed

//public void setObjPersona(com.gestionmatriz.recursoshumanos.bean.Personal objPersona){
//    this.objPersona=objPersona;
//    lblNombreTrabajadorPermisos.setText(this.objPersona.getStr_nombres().concat(" ").concat(this.objPersona.getStr_apePaterno().concat(
//            " ").concat(this.objPersona.getStr_apeMaterno())));
//    
//    lblDepartamentoPermisos.setText(PaqueteBusinessDelegate.getContratoService().buscarCargoXIDPersona(this.objPersona.getInt_idPersona()));
//}
private void btnIdentificarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdentificarPersonaActionPerformed


//    frmLectorHuella=new LectorHuella(gui,farRequested.getNumber().intValue(),this);
//    
//    frmLectorHuella.setVisible(true);

    gui.loadLectorHuella();

    if (gui.getObjPersonalHuella() == null) {
        return;
    }

    lblNombreTrabajadorPermisos.setText(gui.getObjPersonalHuella().getStr_nombres().
            concat(" ").concat(gui.getObjPersonalHuella().getStr_apePaterno()).
            concat(" ").concat(gui.getObjPersonalHuella().getStr_apeMaterno()));

    lblDepartamentoPermisos.setText(PaqueteBusinessDelegate.getContratoService().
            buscarCargoXIDPersona(Util.stringTOint(gui.getObjPersonalHuella().
            getStr_codigo().substring(1, gui.getObjPersonalHuella().getStr_codigo().length()))));

}//GEN-LAST:event_btnIdentificarPersonaActionPerformed

private void rbtMotivoPersonalPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtMotivoPersonalPermisoActionPerformed

    if (rbtMotivoPersonalPermiso.isSelected()) {
        String[] motivo = {".::Seleccione una Opción::.", "ESSALUD", "TRAMITE", "ESTUDIOS", "CAPACITACIONES", "OTROS"};
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(motivo);
        cboMotivoPermisos.setModel(modelo);
    }
}//GEN-LAST:event_rbtMotivoPersonalPermisoActionPerformed

private void rbtMotivoTrabajoPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtMotivoTrabajoPermisoActionPerformed
    if (rbtMotivoTrabajoPermiso.isSelected()) {
        String[] motivo = {".::Seleccione una Opción::.", "BANCOS - SUNAT - ADUANAS", "MTPS - MUNICIPIO",
            "COMPRAS - COTIZACIÓN", "NOTARIA - SUNARP", "PUERTO - AEROPUERTO", "TIENDAS", "REFRIGERIO"};
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(motivo);
        cboMotivoPermisos.setModel(modelo);
    }
}//GEN-LAST:event_rbtMotivoTrabajoPermisoActionPerformed

private void cboHoraSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHoraSalidaActionPerformed
    validarHoraSalida();
}//GEN-LAST:event_cboHoraSalidaActionPerformed

    private void validarHoraSalida() {
        int hora = Util.stringTOint(cboHoraSalida.getSelectedItem().toString());

        if (hora < 23) {
            hora++;
        }

        String str_hora = String.valueOf(hora);

        if (hora < 10) {
            str_hora = "0".concat(String.valueOf(hora));
        } else {
            str_hora = (String.valueOf(hora));
        }

        cboHoraRegreso.setSelectedItem(str_hora);
    }
private void cboMinutosSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMinutosSalidaActionPerformed
    String minuto = (cboMinutosSalida.getSelectedItem().toString());

    cboMinutoRegreso.setSelectedItem(minuto);
}//GEN-LAST:event_cboMinutosSalidaActionPerformed

private void cboHoraRegresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHoraRegresoActionPerformed


    int horaRegreso = Util.stringTOint(cboHoraRegreso.getSelectedItem().toString());
    int horaSalida = Util.stringTOint(cboHoraSalida.getSelectedItem().toString());

    if (horaRegreso < horaSalida) {
        Mensaje.mensaje(this, "Hora de Regreso no Puede ser Menor a la Hora de Salida", Mensaje.TITULO_ME, Mensaje.ERROR);
        validarHoraSalida();
    }


//    String minuto=(cboMinutosSalida.getSelectedItem().toString());
//    
//    cboMinutoRegreso.setSelectedItem(minuto);

}//GEN-LAST:event_cboHoraRegresoActionPerformed

private void mnuILimpiarFrmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuILimpiarFrmActionPerformed
    limpiarFRM();
}//GEN-LAST:event_mnuILimpiarFrmActionPerformed

private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
    int idSeleccionado = cboConsultarConsultas.getSelectedIndex();
    int indexEmpresa = cboEmpresa.getSelectedIndex();

    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREPORTEASISTENCIA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    if (idSeleccionado == 0) {
        String fechaInicial = Util.getFecha("yyyy-MM-dd", dtpFechaInicioConsultas.getDate());
        String fechaFinal = Util.getFecha("yyyy-MM-dd", dtpFechaFinalConsultas.getDate());

        if (indexEmpresa <= 0) {
            Mensaje.mensaje(this, "Seleccione una Empresa", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }

        int idEmpresa = listaEmpresa.get(cboEmpresa.getSelectedIndex() - 1).getInt_idEmpresa();

        ireport.verAsistenciaXEmpresaFecha(idEmpresa, fechaInicial, fechaFinal, "Asistencia");

    } else {
    }
}//GEN-LAST:event_btnReporteActionPerformed

private void btnReporteTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteTrabajadorActionPerformed
    int index = cboEmpresa.getSelectedIndex();
    //System.out.println("index :"+index);



    if (index <= 0) {
        Mensaje.mensaje(this, "Seleccione una Empresa", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    } else {
        int idEmpresa = listaEmpresa.get(cboEmpresa.getSelectedIndex() - 1).getInt_idEmpresa();

        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREPORTEASISTENCIA())) {
            //        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            //        return;


            //System.out.println("idEmpresa :"+idEmpresa);
            Util.hiloProgressBar(1, gui);

//                System.out.println(gui.getCodigoPersona());
            BuscarAsistencia frmBuscarAsistencia = new BuscarAsistencia(gui1, idEmpresa, gui.getCodigoPersona());

            Util.hiloProgressBar(0, gui);
            //frmBuscarAsistencia.cargarComboTrabajadores(idEmpresa);
            frmBuscarAsistencia.setVisible(true);
            return;
        }

        //int idEmpresa = listaEmpresa.get(cboEmpresa.getSelectedIndex() - 1).getInt_idEmpresa();
        //System.out.println("idEmpresa :"+idEmpresa);
        Util.hiloProgressBar(1, gui);
        BuscarAsistencia frmBuscarAsistencia = new BuscarAsistencia(gui1, idEmpresa);
        Util.hiloProgressBar(0, gui);
        frmBuscarAsistencia.cargarComboTrabajadores(idEmpresa);
        frmBuscarAsistencia.setVisible(true);
    }
}//GEN-LAST:event_btnReporteTrabajadorActionPerformed

private void jXButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton1ActionPerformed
    int idSeleccionado = cboConsultarConsultas.getSelectedIndex();
    int indexEmpresa = cboEmpresa.getSelectedIndex();

    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getREPORTEASISTENCIA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    if (idSeleccionado == 0) {
        String fechaInicial = Util.getFecha("yyyy-MM-dd", dtpFechaInicioConsultas.getDate());
        String fechaFinal = Util.getFecha("yyyy-MM-dd", dtpFechaFinalConsultas.getDate());

        if (indexEmpresa <= 0) {
            Mensaje.mensaje(this, "Seleccione una Empresa", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }

        int idEmpresa = listaEmpresa.get(cboEmpresa.getSelectedIndex() - 1).getInt_idEmpresa();

        ireport.verAsistenciaLocales(idEmpresa, fechaInicial, fechaFinal, "ReporteLocales");

    } else {
    }
}//GEN-LAST:event_jXButton1ActionPerformed

    private void cboMotivoPermisosActionPerformed(java.awt.event.ActionEvent evt) {

        mostrarOcultarRefrigerio(true);

        if (rbtMotivoTrabajoPermiso.isSelected()) {
            int indice = cboMotivoPermisos.getSelectedIndex();
            //System.out.println("Indice: "+indice);
            if (indice == 7) {
                mostrarOcultarRefrigerio(false);
            }


        }
    }

private void btnIdentificarPartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdentificarPartTimeActionPerformed

    gui.loadLectorHuella();

    if (gui.getObjPersonalHuella() == null) {
        return;
    }

    lblNombreTrabajadorPartTime.setText(gui.getObjPersonalHuella().getStr_nombres().
            concat(" ").concat(gui.getObjPersonalHuella().getStr_apePaterno()).
            concat(" ").concat(gui.getObjPersonalHuella().getStr_apeMaterno()));

    lblDepartamentoPartTime.setText(PaqueteBusinessDelegate.getContratoService().
            buscarCargoXIDPersona(Util.stringTOint(gui.getObjPersonalHuella().
            getStr_codigo().substring(1, gui.getObjPersonalHuella().getStr_codigo().length()))));


    int idPersona = Util.stringTOint(gui.getObjPersonalHuella().getStr_codigo().substring(1));
    int idContrato = PaqueteBusinessDelegate.getContratoService().idContrato(idPersona);
    int idAsistencia = PaqueteBusinessDelegate.getAsistenciaService().idAsistencia(idContrato);
    if (idAsistencia != -1) {
        listaPartTime = PaqueteBusinessDelegate.getAsistenciaService().consultaPartTime(idAsistencia);
        if (listaPartTime.isEmpty()) {
            btnIngresoPartTime.setEnabled(true);
        } else if (listaPartTime.size() == 1) {
            cargarTablaPartTime(tblPartTime, listaPartTime);
            btnSalidaPartTime.setEnabled(true);
        } else {
            Mensaje.mensaje(this, "ya tiene una marcación registrada", Mensaje.TITULO_ME, Mensaje.ERROR);
            cargarTablaPartTime(tblPartTime, listaPartTime);
            btnIngresoPartTime.setEnabled(false);
            btnSalidaPartTime.setEnabled(false);

        }
    } else {
        Mensaje.mensaje(this, "No Puede Marcar Medio Tiempo", Mensaje.TITULO_ME, Mensaje.ERROR);

    }



}//GEN-LAST:event_btnIdentificarPartTimeActionPerformed

private void btnIngresoPartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoPartTimeActionPerformed
    String iniFin = "I";
    marcacionPartTime(iniFin);
    cargarTablaPartTime(tblPartTime, listaPartTime);
}//GEN-LAST:event_btnIngresoPartTimeActionPerformed

    private void marcacionPartTime(String iniFin) {
        int idPersona = Util.stringTOint(gui.getObjPersonalHuella().getStr_codigo().substring(1));
        int idContrato = PaqueteBusinessDelegate.getContratoService().idContrato(idPersona);

        if (PaqueteBusinessDelegate.getAsistenciaService().registroPartTime(idContrato, Util.ACTIVO, iniFin) == true) {
            Mensaje.mensaje(this, "Marcación Correcta", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            if (iniFin.equals("I")) {
                btnSalidaPartTime.setEnabled(true);
                btnIngresoPartTime.setEnabled(false);
            } else {
                btnSalidaPartTime.setEnabled(false);
                btnIngresoPartTime.setEnabled(true);
            }

        } else {
            Mensaje.mensaje(this, "Error en Marcación", Mensaje.TITULO_ME, Mensaje.ERROR);
        }


    }

private void btnSalidaPartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaPartTimeActionPerformed
    String iniFin = "S";
    marcacionPartTime(iniFin);
    cargarTablaPartTime(tblPartTime, listaPartTime);
}//GEN-LAST:event_btnSalidaPartTimeActionPerformed

private void jXButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton2ActionPerformed
    jTabbedPane1.setSelectedIndex(1);
}//GEN-LAST:event_jXButton2ActionPerformed

private void jXButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton3ActionPerformed
    jTabbedPane1.setSelectedIndex(2);
}//GEN-LAST:event_jXButton3ActionPerformed

private void jXButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton4ActionPerformed
}//GEN-LAST:event_jXButton4ActionPerformed

    private void mostrarOcultarRefrigerio(boolean b) {
//            lblHoraSalida.setVisible(b);
//            lblHoraRegreso.setVisible(b);
//            cboHoraSalida.setVisible(b);
//            cboMinutosSalida.setVisible(b);
//            
//            cboHoraRegreso.setVisible(b);
//            cboMinutoRegreso.setVisible(b);
//            txtObservaciones.setVisible(b);
//            jScrollPane2.setVisible(b);
    }

    private void cagarTable(JXTable tabla, List lista) {

        int idSeleccionado = cboConsultarConsultas.getSelectedIndex();

        if (idSeleccionado == 0) {
            String[] objTitulo = {"Apell Paterno", "Apell Materno", "Nombre", "Local", "Horario", "Fecha Marcado", "Hora Ingreso", "Estado"};
            String[][] objData = new String[lista.size()][8];


            int i = 0;
            for (Object a : lista) {
                if (a instanceof com.gestionmatriz.recursoshumanos.bean.Asistencia) {
                    objData[i][0] = ((com.gestionmatriz.recursoshumanos.bean.Asistencia) a).getObjContrato().getObjPersona().getStr_apePaterno();
                    objData[i][1] = ((com.gestionmatriz.recursoshumanos.bean.Asistencia) a).getObjContrato().getObjPersona().getStr_apeMaterno();
                    objData[i][2] = ((com.gestionmatriz.recursoshumanos.bean.Asistencia) a).getObjContrato().getObjPersona().getStr_nombres();
                    objData[i][3] = ((com.gestionmatriz.recursoshumanos.bean.Asistencia) a).getStr_direccion();
                    objData[i][4] = ((com.gestionmatriz.recursoshumanos.bean.Asistencia) a).getStr_horario();
                    objData[i][5] = ((com.gestionmatriz.recursoshumanos.bean.Asistencia) a).getStr_fechaMarcado();
                    objData[i][6] = ((com.gestionmatriz.recursoshumanos.bean.Asistencia) a).getStr_horaIngreso();
                    objData[i][7] = ((com.gestionmatriz.recursoshumanos.bean.Asistencia) a).getStr_estadoMarcado();
                }

                i++;
            }

            DefaultTableModel modelo = new DefaultTableModel(objData, objTitulo);
            tabla.setModel(modelo);
            this.listaAsistencia = lista;
        } else if (idSeleccionado == 1) {
            String[] objTitulo = {"Nombre", "F. Solicitada", "Motivo", "H S Solicitada", "H LL Solicitada", "Observaciones", "H Salida", "H Llegada", "Fecha Solicitud", "Estado", "ACCIÓN"};
            String[][] objData = new String[lista.size()][11];


            int i = 0;
            for (Object a : lista) {
                if (a instanceof com.gestionmatriz.recursoshumanos.bean.Permisos) {
                    objData[i][0] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getObjPersona().getStr_nombres()
                            .concat(" " + ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getObjPersona().getStr_apePaterno())
                            .concat(" " + ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getObjPersona().getStr_apeMaterno());
                    objData[i][1] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getDte_fecha();
                    objData[i][2] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getStr_motivo();
                    objData[i][3] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getTm_horaSalida();
                    objData[i][4] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getTm_horaLlegada();
                    objData[i][5] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getStr_observacion();
                    objData[i][6] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getTm_horaMarcadoSalida();
                    objData[i][7] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getTm_horaMarcadoLlegada();
                    objData[i][8] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getDte_fechaRegistro();
                    objData[i][9] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getStr_estado();
                }

                i++;
            }

            DefaultTableModel modelo = new DefaultTableModel(objData, objTitulo);
            tabla.setModel(modelo);
            this.listaPermisos = lista;

            TableColumn estadoColumna = tabla.getColumnModel().getColumn(10);
            final JComboBox comboEstado = new JComboBox();
            comboEstado.addItem(Util.ACTIVO);
            comboEstado.addItem(Util.APROBADO);
            comboEstado.addItem(Util.DESAPROBADO);
            comboEstado.addItem(Util.INACTIVO);
            comboEstado.addItem(Util.HISTORICO);
            comboEstado.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (comboEstado.getSelectedIndex() != -1) {

//                          System.out.println("CBO: "+comboEstado.getSelectedItem().toString());
//                          System.out.println("Row: "+tblListarPermisosConsultas.getSelectedRow());
                        int idPermiso = listaPermisos.get(tblListarPermisosConsultas.getSelectedRow()).getInt_idPermisos();

                        if (PaqueteBusinessDelegate.getPermisosService().actualizarEstadoPermiso(idPermiso, comboEstado.getSelectedItem().toString(), gui.getBarraEstado().getUsuario())) {
                            Mensaje.mensaje("Se Realizó Exitosamente la Modificación del Permiso", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                        } else {
                            Mensaje.mensaje("No se Pudo Modificar el Permiso", Mensaje.TITULO_ME, Mensaje.ERROR);
                        }
                    }

                }
            });
            estadoColumna.setCellEditor(new DefaultCellEditor(comboEstado));

        } else {
            Mensaje.mensaje(this, "Su búsqueda no tuvo resultados", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        }


    }

    public boolean ValidarLblTrabajador() {
        boolean valor = true;

        JXLabel[] lbls = {
            lblNombreTrabajadorPermisos,
            lblDepartamentoPermisos};
        if (ValidarCamposNulos.validarLabelSeteada(lbls) == false) {
            Mensaje.mensaje(this, "Debe identificarse (Presione el boton 'Identificación')",
                    Mensaje.TITULO_ME, Mensaje.ERROR);
            valor = false;
        }
        return valor;
    }

    public boolean ValidarFecha() {
        boolean valor = true;

        JXDatePicker[] dtps = {
            dtpFechaPermisos};
        if (ValidarCamposNulos.validarDatePicker(dtps) == false) {
            Mensaje.mensaje(this, "Debe seleccionar una fecha",
                    Mensaje.TITULO_ME, Mensaje.ERROR);
            valor = false;
        }
        return valor;
    }

    public boolean ValidarMotivoPermiso() {
        boolean valor = true;

        JXComboBox[] cbos = {
            cboMotivoPermisos};
        if (ValidarCamposNulos.validarCombos(cbos) == false) {
            Mensaje.mensaje(this, "Debe seleccionar un motivo para el permiso",
                    Mensaje.TITULO_ME, Mensaje.ERROR);
            valor = false;
        }
        return valor;
    }

//public boolean ValidarHoras(){
//    boolean valor=true;
//    
//    JTextField []txts={
//        txtHoraSalidaPermisos,
//        txtHoraRetornoPermisos};
//        if(ValidarCamposNulos.validar(txts) ==false){
//            Mensaje.mensaje(this, "Debe ingresar las horas de salida y retorno",
//                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
//            valor=false;
//        }
//    return valor;
//}
    public boolean ValidarMotivoConsulta() {
        boolean valor = true;

        JXComboBox[] cbos = {
            cboConsultarConsultas};
        if (ValidarCamposNulos.validarCombos(cbos) == false) {
            Mensaje.mensaje(this, "Debe seleccionar un motivo para la búsqueda",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }

    public boolean ValidarFechaConsultar() {
        boolean valor = true;

        JXDatePicker[] dtps = {
            dtpFechaInicioConsultas,
            dtpFechaFinalConsultas};
        if (ValidarCamposNulos.validarDatePicker(dtps) == false) {
            Mensaje.mensaje(this, "Debe seleccionar un rango de fechas",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }

    private void limpiarFRM() {
        lblNombreTrabajadorPermisos.setText("");
        lblDepartamentoPermisos.setText("");
        dtpFechaPermisos.setDate(new Date());
        rbtMotivoPersonalPermiso.setSelected(true);
        txtObservaciones.setText("");
        btnIdentificarPersona.requestFocus();
        lblEstadoPermiso.setText("");
        gui.setObjPersonalHuella(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu PopupAsistencia;
    private org.jdesktop.swingx.JXButton btnAsistencia;
    private org.jdesktop.swingx.JXButton btnBuscarConsultas;
    private org.jdesktop.swingx.JXButton btnEnviarSolicitudPermisos;
    private org.jdesktop.swingx.JXButton btnIdentificarPartTime;
    private org.jdesktop.swingx.JXButton btnIdentificarPersona;
    private org.jdesktop.swingx.JXButton btnIngresoPartTime;
    private org.jdesktop.swingx.JXButton btnReporte;
    private org.jdesktop.swingx.JXButton btnReporteTrabajador;
    private org.jdesktop.swingx.JXButton btnSalidaPartTime;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXComboBox cboConsultarConsultas;
    private org.jdesktop.swingx.JXComboBox cboEmpresa;
    private org.jdesktop.swingx.JXComboBox cboHoraRegreso;
    private org.jdesktop.swingx.JXComboBox cboHoraSalida;
    private org.jdesktop.swingx.JXComboBox cboMinutoRegreso;
    private org.jdesktop.swingx.JXComboBox cboMinutosSalida;
    private org.jdesktop.swingx.JXComboBox cboMotivoPermisos;
    private org.jdesktop.swingx.JXDatePicker dtpFechaFinalConsultas;
    private org.jdesktop.swingx.JXDatePicker dtpFechaInicioConsultas;
    private org.jdesktop.swingx.JXDatePicker dtpFechaPermisos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.jdesktop.swingx.JXButton jXButton1;
    private org.jdesktop.swingx.JXButton jXButton2;
    private org.jdesktop.swingx.JXButton jXButton3;
    private org.jdesktop.swingx.JXButton jXButton4;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel10;
    private org.jdesktop.swingx.JXLabel jXLabel12;
    private org.jdesktop.swingx.JXLabel jXLabel13;
    private org.jdesktop.swingx.JXLabel jXLabel14;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel lblDepartamentoPartTime;
    private org.jdesktop.swingx.JXLabel lblDepartamentoPermisos;
    private org.jdesktop.swingx.JXLabel lblEstadoPermiso;
    private org.jdesktop.swingx.JXLabel lblHoraRegreso;
    private org.jdesktop.swingx.JXLabel lblHoraSalida;
    private org.jdesktop.swingx.JXLabel lblNombreTrabajadorPartTime;
    private org.jdesktop.swingx.JXLabel lblNombreTrabajadorPermisos;
    private javax.swing.JMenuItem mnuILimpiarFrm;
    private javax.swing.JPanel pnlAsistencia;
    private javax.swing.JPanel pnlConsultar;
    private javax.swing.JDesktopPane pnlEscritorioAsistencia;
    private javax.swing.JPanel pnlInformación;
    private javax.swing.JPanel pnlMedioTiempo;
    private javax.swing.JPanel pnlOpcionesAsistencia;
    private javax.swing.JPanel pnlPermisos;
    private javax.swing.JRadioButton rbtMotivoPersonalPermiso;
    private javax.swing.JRadioButton rbtMotivoTrabajoPermiso;
    private org.jdesktop.swingx.JXTable tblListarPermisosConsultas;
    private org.jdesktop.swingx.JXTable tblPartTime;
    private org.jdesktop.swingx.JXTextArea txtObservaciones;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
        tblListarPermisosConsultas.setSortable(false);
        tblPartTime.setSortable(false);
        cargarEmpresa();
        dtpFechaInicioConsultas.setDate(new Date());
        dtpFechaFinalConsultas.setDate(new Date());
        cargarCombos();
    }
    
    private void cargarCombos() {
        cboHoraSalida.removeAllItems();
        cboMinutosSalida.removeAllItems();
        cboHoraRegreso.removeAllItems();
        cboMinutoRegreso.removeAllItems();
        for (int i = 0; i <= 59; i++) {
            if (i <= 23) {
                if (i < 10) {
                    cboHoraSalida.addItem("0".concat(String.valueOf(i)));
                    cboHoraRegreso.addItem("0".concat(String.valueOf(i)));
                } else {
                    cboHoraSalida.addItem(String.valueOf(i));
                    cboHoraRegreso.addItem(String.valueOf(i));
                }

            }

            if (i < 10) {
                cboMinutosSalida.addItem("0".concat(String.valueOf(i)));
                cboMinutoRegreso.addItem("0".concat(String.valueOf(i)));
            } else {
                cboMinutosSalida.addItem(String.valueOf(i));
                cboMinutoRegreso.addItem(String.valueOf(i));
            }


        }
    }

    private void cagarTablePermisos(JXTable tabla, List<Permisos> lista) {
        String[] objTitulo = {"Nombre", "F. Solicitada", "Motivo", "H S Solicitada", "H LL Solicitada", "Observaciones", "H Salida", "H Llegada", "Fecha Solicitud", "Estado"};
        String[][] objData = new String[lista.size()][10];


        int i = 0;
        for (Object a : lista) {
            if (a instanceof com.gestionmatriz.recursoshumanos.bean.Permisos) {
                objData[i][0] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getObjPersona().getStr_nombres()
                        .concat(" " + ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getObjPersona().getStr_apePaterno())
                        .concat(" " + ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getObjPersona().getStr_apeMaterno());
                objData[i][1] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getDte_fecha();
                objData[i][2] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getStr_motivo();
                objData[i][3] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getTm_horaSalida();
                objData[i][4] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getTm_horaLlegada();
                objData[i][5] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getStr_observacion();
                objData[i][6] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getTm_horaMarcadoSalida();
                objData[i][7] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getTm_horaMarcadoLlegada();
                objData[i][8] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getDte_fechaRegistro();
                objData[i][9] = ((com.gestionmatriz.recursoshumanos.bean.Permisos) a).getStr_estado();
            }

            i++;
        }

        DefaultTableModel modelo = new DefaultTableModel(objData, objTitulo);
        tabla.setModel(modelo);
        this.listaPermisos = lista;

    }

    private void cargarTablaPartTime(JXTable tabla, List<PartTime> lista) {
        String[] objTitulo = {"Fecha y Hora de marcado", "Tipo"};
        String[][] objData = new String[lista.size()][2];


        int i = 0;
        for (Object a : lista) {
            if (a instanceof com.gestionmatriz.recursoshumanos.bean.PartTime) {
                objData[i][0] = ((com.gestionmatriz.recursoshumanos.bean.PartTime) a).getDte_marcacion();
                objData[i][1] = (((com.gestionmatriz.recursoshumanos.bean.PartTime) a).getStr_iniFin().equals("I") ? "Ingreso" : "Salida");
            }
            i++;
        }

        DefaultTableModel modelo = new DefaultTableModel(objData, objTitulo);
        tabla.setModel(modelo);
        this.listaPartTime = lista;
    }
}
