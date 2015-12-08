/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Contrato.java
 *
 * Created on 12-abr-2012, 16:49:33
 */
package com.gestionmatriz.recursoshumanos.gui;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornada;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornadaContrato;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.recursoshumanos.bean.TipoContrato;
import com.gestionmatriz.recursoshumanos.dao.MysqlContratoDAO;
import com.gestionmatriz.recursoshumanos.opciones.Opciones;
import com.gestionmatriz.recursoshumanos.reportes.Ireport;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.ValidarCamposNulos;
import com.gestionmatriz.util.Util;

import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author zholo
 */
public class Contrato extends javax.swing.JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(Contrato.class); 
    public Contrato(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarComboEmpresa();
        cargarComboTipoContrato();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupListaContratos = new javax.swing.JPopupMenu();
        mnuListar = new javax.swing.JMenuItem();
        mnuBuscarContrato = new javax.swing.JMenuItem();
        mnuVerContrato = new javax.swing.JMenuItem();
        mnuModificarHorario = new javax.swing.JMenuItem();
        mnuModificarLocal = new javax.swing.JMenuItem();
        popupVerContrato = new javax.swing.JPopupMenu();
        mnuVerContratoCancel = new javax.swing.JMenuItem();
        popupVerContratoRenov = new javax.swing.JPopupMenu();
        mnuVerContratoReno = new javax.swing.JMenuItem();
        pnlGestionarContratos = new javax.swing.JTabbedPane();
        pnlNuevoContrato = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        cboEmpresaContrato = new org.jdesktop.swingx.JXComboBox();
        lblRazonSocialContrato = new org.jdesktop.swingx.JXLabel();
        lblRucEmpresaContrato = new org.jdesktop.swingx.JXLabel();
        lblDireccionEmpresaContrato = new org.jdesktop.swingx.JXLabel();
        lblRepresentanteEmpresaContrato = new org.jdesktop.swingx.JXLabel();
        lblDniRepresentanteContrato = new org.jdesktop.swingx.JXLabel();
        txtTrabajdorContrato = new org.jdesktop.swingx.JXTextField();
        btnBuscarDniContrato = new org.jdesktop.swingx.JXButton();
        btnBusquedaAvazadaContrato = new org.jdesktop.swingx.JXButton();
        lblNombreTrabajadorContrato = new org.jdesktop.swingx.JXLabel();
        lblDniTrabajadorContrato = new org.jdesktop.swingx.JXLabel();
        lblDomicilioTrabajadorContrato = new org.jdesktop.swingx.JXLabel();
        lblHorarioContrato = new org.jdesktop.swingx.JXLabel();
        btnBuscarHorario = new org.jdesktop.swingx.JXButton();
        cboTipoContrato = new org.jdesktop.swingx.JXComboBox();
        dtpFechaInicioContrato = new org.jdesktop.swingx.JXDatePicker();
        dtpFechaFinContrato = new org.jdesktop.swingx.JXDatePicker();
        txtSueldoContrato = new org.jdesktop.swingx.JXTextField();
        btnSalirNuevoContrato = new org.jdesktop.swingx.JXButton();
        btnCancelarNuevoContrato = new org.jdesktop.swingx.JXButton();
        btnGuardarContratos = new org.jdesktop.swingx.JXButton();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        cboLocal = new org.jdesktop.swingx.JXComboBox();
        pnlRenovarContrato = new javax.swing.JPanel();
        lblHorarioRenovarContrato = new org.jdesktop.swingx.JXLabel();
        jXLabel18 = new org.jdesktop.swingx.JXLabel();
        btnBuscarHorarioRenovarContrato = new org.jdesktop.swingx.JXButton();
        jXLabel19 = new org.jdesktop.swingx.JXLabel();
        cboTipoContratoRenovarContrato = new org.jdesktop.swingx.JXComboBox();
        jXLabel20 = new org.jdesktop.swingx.JXLabel();
        dtpFechaInicioRenovarContrato = new org.jdesktop.swingx.JXDatePicker();
        jXLabel21 = new org.jdesktop.swingx.JXLabel();
        txtSueldoRenovarContrato = new org.jdesktop.swingx.JXTextField();
        jXLabel22 = new org.jdesktop.swingx.JXLabel();
        dtpFechaFinRenovarContrato = new org.jdesktop.swingx.JXDatePicker();
        btnVistaPreviaRenovarContrato = new org.jdesktop.swingx.JXButton();
        btnGuardarRenovarContratos = new org.jdesktop.swingx.JXButton();
        btnCancelarRenovarContrato = new org.jdesktop.swingx.JXButton();
        btnSalirRenovarContrato = new org.jdesktop.swingx.JXButton();
        jXLabel16 = new org.jdesktop.swingx.JXLabel();
        txtBuscarContratoRenovar = new org.jdesktop.swingx.JXTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTablaRenovarContrato = new org.jdesktop.swingx.JXTable();
        jXLabel23 = new org.jdesktop.swingx.JXLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel17 = new org.jdesktop.swingx.JXLabel();
        txtBuscarContratoCancelar = new org.jdesktop.swingx.JXTextField();
        jXLabel24 = new org.jdesktop.swingx.JXLabel();
        btnFinalizarContratoCancelarContrato = new org.jdesktop.swingx.JXButton();
        btnCancelarContrato = new org.jdesktop.swingx.JXButton();
        btnSalirCancelarContrato = new org.jdesktop.swingx.JXButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTablaCancelarContrato = new org.jdesktop.swingx.JXTable();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        cboMotivoCancelar = new org.jdesktop.swingx.JXComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacionesCancelar = new org.jdesktop.swingx.JXTextArea();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        pnlListaContratos = new org.jdesktop.swingx.JXPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbListaContratos = new org.jdesktop.swingx.JXTable();

        mnuListar.setText("Listar todos los contratos");
        mnuListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarActionPerformed(evt);
            }
        });
        popupListaContratos.add(mnuListar);

        mnuBuscarContrato.setText("Bucar contrato");
        mnuBuscarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBuscarContratoActionPerformed(evt);
            }
        });
        popupListaContratos.add(mnuBuscarContrato);

        mnuVerContrato.setText("Ver contrato");
        mnuVerContrato.setName(""); // NOI18N
        mnuVerContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVerContratoActionPerformed(evt);
            }
        });
        popupListaContratos.add(mnuVerContrato);

        mnuModificarHorario.setText("Modificar horario");
        mnuModificarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModificarHorarioActionPerformed(evt);
            }
        });
        popupListaContratos.add(mnuModificarHorario);

        mnuModificarLocal.setText("Modificar local");
        mnuModificarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModificarLocalActionPerformed(evt);
            }
        });
        popupListaContratos.add(mnuModificarLocal);

        mnuVerContratoCancel.setText("Ver Contrato");
        mnuVerContratoCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVerContratoCancelActionPerformed(evt);
            }
        });
        popupVerContrato.add(mnuVerContratoCancel);

        mnuVerContratoReno.setText("Ver Contrato");
        mnuVerContratoReno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVerContratoRenoActionPerformed(evt);
            }
        });
        popupVerContratoRenov.add(mnuVerContratoReno);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("GESTIONAR CONTRATOS");
        setPreferredSize(new java.awt.Dimension(764, 550));

        pnlGestionarContratos.setMaximumSize(new java.awt.Dimension(748, 972));

        pnlNuevoContrato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NUEVO CONTRATO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXLabel1.setText("Empresa:");

        jXLabel2.setText("DNI Trabajador:");

        jXLabel3.setText("Horario de trabajo:");

        jXLabel4.setText("Tipo de Contrato:");

        jXLabel5.setText("Fecha de Inicio:");

        jXLabel6.setText("Fecha de Fin:");

        jXLabel7.setText("Sueldo:");

        cboEmpresaContrato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar una Opción", "COMISA", "LAMOSA", "SEGERPIN" }));
        cboEmpresaContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmpresaContratoActionPerformed(evt);
            }
        });

        lblRazonSocialContrato.setBackground(new java.awt.Color(255, 255, 225));
        lblRazonSocialContrato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblRazonSocialContrato.setOpaque(true);

        lblRucEmpresaContrato.setBackground(new java.awt.Color(255, 255, 225));
        lblRucEmpresaContrato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblRucEmpresaContrato.setOpaque(true);

        lblDireccionEmpresaContrato.setBackground(new java.awt.Color(255, 255, 225));
        lblDireccionEmpresaContrato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDireccionEmpresaContrato.setOpaque(true);

        lblRepresentanteEmpresaContrato.setBackground(java.awt.SystemColor.info);
        lblRepresentanteEmpresaContrato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblRepresentanteEmpresaContrato.setOpaque(true);

        lblDniRepresentanteContrato.setBackground(java.awt.SystemColor.info);
        lblDniRepresentanteContrato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDniRepresentanteContrato.setOpaque(true);

        txtTrabajdorContrato.setBackground(java.awt.SystemColor.info);
        txtTrabajdorContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrabajdorContratoActionPerformed(evt);
            }
        });
        txtTrabajdorContrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTrabajdorContratoKeyTyped(evt);
            }
        });

        btnBuscarDniContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarDniContrato.setText("Buscar Por DNI");
        btnBuscarDniContrato.setPreferredSize(new java.awt.Dimension(153, 23));
        btnBuscarDniContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDniContratoActionPerformed(evt);
            }
        });

        btnBusquedaAvazadaContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBusquedaAvazadaContrato.setText("Búsqueda avanzada");
        btnBusquedaAvazadaContrato.setPreferredSize(new java.awt.Dimension(153, 23));
        btnBusquedaAvazadaContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaAvazadaContratoActionPerformed(evt);
            }
        });

        lblNombreTrabajadorContrato.setBackground(java.awt.SystemColor.info);
        lblNombreTrabajadorContrato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblNombreTrabajadorContrato.setOpaque(true);

        lblDniTrabajadorContrato.setBackground(java.awt.SystemColor.info);
        lblDniTrabajadorContrato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDniTrabajadorContrato.setOpaque(true);

        lblDomicilioTrabajadorContrato.setBackground(java.awt.SystemColor.info);
        lblDomicilioTrabajadorContrato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDomicilioTrabajadorContrato.setOpaque(true);

        lblHorarioContrato.setBackground(java.awt.SystemColor.info);
        lblHorarioContrato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblHorarioContrato.setOpaque(true);

        btnBuscarHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/horasistema.png"))); // NOI18N
        btnBuscarHorario.setText("Generar Horario");
        btnBuscarHorario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscarHorario.setPreferredSize(new java.awt.Dimension(153, 23));
        btnBuscarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHorarioActionPerformed(evt);
            }
        });

        cboTipoContrato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar una Opción", "Cajero", "Vendedor", "Jefe Tienda", "Almacenero" }));
        cboTipoContrato.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTipoContratoItemStateChanged(evt);
            }
        });
        cboTipoContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoContratoActionPerformed(evt);
            }
        });

        dtpFechaInicioContrato.setBackground(java.awt.SystemColor.info);

        dtpFechaFinContrato.setBackground(java.awt.SystemColor.info);

        txtSueldoContrato.setBackground(java.awt.SystemColor.info);
        txtSueldoContrato.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSueldoContrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoContratoKeyTyped(evt);
            }
        });

        btnSalirNuevoContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/eliminar.png"))); // NOI18N
        btnSalirNuevoContrato.setText("Salir");
        btnSalirNuevoContrato.setPreferredSize(new java.awt.Dimension(116, 23));
        btnSalirNuevoContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirNuevoContratoActionPerformed(evt);
            }
        });

        btnCancelarNuevoContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/limpiar.png"))); // NOI18N
        btnCancelarNuevoContrato.setText("Limpiar");
        btnCancelarNuevoContrato.setPreferredSize(new java.awt.Dimension(116, 23));
        btnCancelarNuevoContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarNuevoContratoActionPerformed(evt);
            }
        });

        btnGuardarContratos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/guardarblue.png"))); // NOI18N
        btnGuardarContratos.setText("Guardar");
        btnGuardarContratos.setPreferredSize(new java.awt.Dimension(116, 23));
        btnGuardarContratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarContratosActionPerformed(evt);
            }
        });

        jXLabel10.setText("Local: ");

        javax.swing.GroupLayout pnlNuevoContratoLayout = new javax.swing.GroupLayout(pnlNuevoContrato);
        pnlNuevoContrato.setLayout(pnlNuevoContratoLayout);
        pnlNuevoContratoLayout.setHorizontalGroup(
            pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuevoContratoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNuevoContratoLayout.createSequentialGroup()
                        .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlNuevoContratoLayout.createSequentialGroup()
                                .addComponent(lblRazonSocialContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRucEmpresaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDireccionEmpresaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblRepresentanteEmpresaContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlNuevoContratoLayout.createSequentialGroup()
                                .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlNuevoContratoLayout.createSequentialGroup()
                                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTrabajdorContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlNuevoContratoLayout.createSequentialGroup()
                                        .addComponent(lblNombreTrabajadorContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblDniTrabajadorContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlNuevoContratoLayout.createSequentialGroup()
                                        .addComponent(btnBuscarDniContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBusquedaAvazadaContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblDomicilioTrabajadorContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDniRepresentanteContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNuevoContratoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardarContratos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarNuevoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalirNuevoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNuevoContratoLayout.createSequentialGroup()
                        .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNuevoContratoLayout.createSequentialGroup()
                                .addComponent(lblHorarioContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlNuevoContratoLayout.createSequentialGroup()
                                .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtSueldoContrato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dtpFechaInicioContrato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dtpFechaFinContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(177, 189, Short.MAX_VALUE))
                    .addGroup(pnlNuevoContratoLayout.createSequentialGroup()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(cboEmpresaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlNuevoContratoLayout.setVerticalGroup(
            pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuevoContratoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEmpresaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRazonSocialContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRucEmpresaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccionEmpresaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRepresentanteEmpresaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDniRepresentanteContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrabajdorContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarDniContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusquedaAvazadaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreTrabajadorContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDniTrabajadorContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDomicilioTrabajadorContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHorarioContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpFechaInicioContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpFechaFinContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSueldoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(pnlNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalirNuevoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarNuevoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarContratos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(647, Short.MAX_VALUE))
        );

        pnlGestionarContratos.addTab("Nuevo Contrato", pnlNuevoContrato);

        pnlRenovarContrato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RENOVAR CONTRATO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        lblHorarioRenovarContrato.setBackground(java.awt.SystemColor.info);
        lblHorarioRenovarContrato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblHorarioRenovarContrato.setOpaque(true);

        jXLabel18.setText("Horario de trabajo:");

        btnBuscarHorarioRenovarContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarHorarioRenovarContrato.setText("Buscar Horario");
        btnBuscarHorarioRenovarContrato.setMaximumSize(new java.awt.Dimension(140, 29));
        btnBuscarHorarioRenovarContrato.setPreferredSize(new java.awt.Dimension(140, 23));
        btnBuscarHorarioRenovarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHorarioRenovarContratoActionPerformed(evt);
            }
        });

        jXLabel19.setText("Tipo de Contrato:");

        cboTipoContratoRenovarContrato.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTipoContratoRenovarContratoItemStateChanged(evt);
            }
        });
        cboTipoContratoRenovarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoContratoRenovarContratoActionPerformed(evt);
            }
        });

        jXLabel20.setText("Fecha de Inicio:");

        jXLabel21.setText("Sueldo:");

        jXLabel22.setText("Fecha de Fin:");

        btnVistaPreviaRenovarContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/vistaprevia.png"))); // NOI18N
        btnVistaPreviaRenovarContrato.setText("Vista Previa");
        btnVistaPreviaRenovarContrato.setPreferredSize(new java.awt.Dimension(126, 23));
        btnVistaPreviaRenovarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVistaPreviaRenovarContratoActionPerformed(evt);
            }
        });

        btnGuardarRenovarContratos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/guardarblue.png"))); // NOI18N
        btnGuardarRenovarContratos.setText("Guardar");
        btnGuardarRenovarContratos.setPreferredSize(new java.awt.Dimension(116, 23));
        btnGuardarRenovarContratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRenovarContratosActionPerformed(evt);
            }
        });

        btnCancelarRenovarContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/eliminar.png"))); // NOI18N
        btnCancelarRenovarContrato.setText("Cancelar");
        btnCancelarRenovarContrato.setPreferredSize(new java.awt.Dimension(116, 23));
        btnCancelarRenovarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRenovarContratoActionPerformed(evt);
            }
        });

        btnSalirRenovarContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/salirmini.png"))); // NOI18N
        btnSalirRenovarContrato.setText("Salir");
        btnSalirRenovarContrato.setPreferredSize(new java.awt.Dimension(116, 23));
        btnSalirRenovarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirRenovarContratoActionPerformed(evt);
            }
        });

        jXLabel16.setText("Escriba el DNI del trabador para buscar el contrato");

        txtBuscarContratoRenovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarContratoRenovarActionPerformed(evt);
            }
        });

        tblTablaRenovarContrato.setBackground(new java.awt.Color(255, 255, 225));
        tblTablaRenovarContrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empresa(Empleador)", "DNI Trabajador (Empleado)", "Trabajdor", "Tipo de Contrato", "Fecha Inicio", "Fecha de Fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTablaRenovarContrato.setComponentPopupMenu(popupVerContratoRenov);
        tblTablaRenovarContrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaRenovarContratoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTablaRenovarContrato);
        tblTablaRenovarContrato.setColumnControlVisible(true);

        jXLabel23.setText("Seleccione un contrato de la lista para cargar los datos en la parte inferior");

        javax.swing.GroupLayout pnlRenovarContratoLayout = new javax.swing.GroupLayout(pnlRenovarContrato);
        pnlRenovarContrato.setLayout(pnlRenovarContratoLayout);
        pnlRenovarContratoLayout.setHorizontalGroup(
            pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRenovarContratoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRenovarContratoLayout.createSequentialGroup()
                        .addGroup(pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRenovarContratoLayout.createSequentialGroup()
                                .addGroup(pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jXLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jXLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jXLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jXLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboTipoContratoRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlRenovarContratoLayout.createSequentialGroup()
                                        .addGroup(pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtSueldoRenovarContrato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dtpFechaInicioRenovarContrato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jXLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(dtpFechaFinRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlRenovarContratoLayout.createSequentialGroup()
                                        .addComponent(lblHorarioRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscarHorarioRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jXLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(187, 187, 187))
                    .addGroup(pnlRenovarContratoLayout.createSequentialGroup()
                        .addGroup(pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRenovarContratoLayout.createSequentialGroup()
                                .addComponent(jXLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarContratoRenovar, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRenovarContratoLayout.createSequentialGroup()
                                .addComponent(btnVistaPreviaRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardarRenovarContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalirRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        pnlRenovarContratoLayout.setVerticalGroup(
            pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRenovarContratoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarContratoRenovar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jXLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHorarioRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarHorarioRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipoContratoRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpFechaInicioRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpFechaFinRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSueldoRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRenovarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalirRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarRenovarContratos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVistaPreviaRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(547, Short.MAX_VALUE))
        );

        pnlGestionarContratos.addTab("Renovar Contrato", pnlRenovarContrato);

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CANCELAR CONTRATO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXLabel17.setText("Escriba el DNI del trabador para buscar el contrato");

        txtBuscarContratoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarContratoCancelarActionPerformed(evt);
            }
        });

        jXLabel24.setText("Seleccione un contrato de la lista para ver los detalles, luego presione \"Finalizar Contrato\"");

        btnFinalizarContratoCancelarContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/fincontrato.png"))); // NOI18N
        btnFinalizarContratoCancelarContrato.setText("Finalizar Contrato");
        btnFinalizarContratoCancelarContrato.setPreferredSize(new java.awt.Dimension(141, 23));
        btnFinalizarContratoCancelarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarContratoCancelarContratoActionPerformed(evt);
            }
        });

        btnCancelarContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/eliminar.png"))); // NOI18N
        btnCancelarContrato.setText("Cancelar");
        btnCancelarContrato.setPreferredSize(new java.awt.Dimension(141, 23));
        btnCancelarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarContratoActionPerformed(evt);
            }
        });

        btnSalirCancelarContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/salirmini.png"))); // NOI18N
        btnSalirCancelarContrato.setText("Salir");
        btnSalirCancelarContrato.setPreferredSize(new java.awt.Dimension(141, 23));
        btnSalirCancelarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirCancelarContratoActionPerformed(evt);
            }
        });

        tblTablaCancelarContrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empresa (Empleador)", "DNI Trabajador (Empleado)", "Trabajador", "Tipo de Contrato", "Fecha Inicio", "Fecha de Fin", "Estado Contrato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTablaCancelarContrato.setComponentPopupMenu(popupVerContrato);
        tblTablaCancelarContrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaCancelarContratoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTablaCancelarContrato);
        tblTablaCancelarContrato.setColumnControlVisible(true);

        jXLabel8.setText("Motivo de Cancelación:");

        cboMotivoCancelar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Solicitud de Personal", "Solicitud de Administración", "Otro" }));

        txtObservacionesCancelar.setColumns(20);
        txtObservacionesCancelar.setRows(5);
        jScrollPane3.setViewportView(txtObservacionesCancelar);

        jXLabel9.setText("Observaciones:");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                        .addComponent(jXLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarContratoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(jXLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                            .addComponent(cboMotivoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFinalizarContratoCancelarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalirCancelarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarContratoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jXLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMotivoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalirCancelarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFinalizarContratoCancelarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(558, Short.MAX_VALUE))
        );

        jXLabel17.getAccessibleContext().setAccessibleName("Escriba DNI del trabador para buscar el contrato");

        pnlGestionarContratos.addTab("Cancelar Contrato", jXPanel1);

        tbListaContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbListaContratos.setComponentPopupMenu(popupListaContratos);
        tbListaContratos.setColumnControlVisible(true);
        jScrollPane4.setViewportView(tbListaContratos);

        javax.swing.GroupLayout pnlListaContratosLayout = new javax.swing.GroupLayout(pnlListaContratos);
        pnlListaContratos.setLayout(pnlListaContratosLayout);
        pnlListaContratosLayout.setHorizontalGroup(
            pnlListaContratosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        pnlListaContratosLayout.setVerticalGroup(
            pnlListaContratosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaContratosLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(518, Short.MAX_VALUE))
        );

        pnlGestionarContratos.addTab("Lista Contratos", pnlListaContratos);

        getContentPane().add(pnlGestionarContratos, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarComboEmpresa() {
        cboEmpresaContrato.removeAllItems();
        Object objTitle = ".::Seleccione una Empresa::.";

        cboEmpresaContrato.addItem(objTitle);
        try {
            ListaEmpresa = PaqueteBusinessDelegate.getContratoService().listarEmpresa();
            Object item;
            for (Empresa empresa : ListaEmpresa) {
                item = empresa.getStr_razonSocial();
                cboEmpresaContrato.addItem(item);
            }
        } catch (SQLException ex) {
            log.error("Error al cargar empresas: " + ex.getMessage());
        }
    }

    private void cargarComboTipoContrato() {
        cboTipoContrato.removeAllItems();
        cboTipoContratoRenovarContrato.removeAllItems();
        Object objTitle = ".::Seleccione un Tipo::.";

        cboTipoContrato.addItem(objTitle);
        cboTipoContratoRenovarContrato.addItem(objTitle);
        try {
            ListaTipoContrato = PaqueteBusinessDelegate.getContratoService().listatipoContrato();
            Object item;
            for (TipoContrato tipo : ListaTipoContrato) {
                item = tipo.getStr_tipoContrato();
                cboTipoContrato.addItem(item);
                cboTipoContratoRenovarContrato.addItem(item);
            }
        } catch (SQLException ex) {
            log.error("Error al cargar empresas: " + ex.getMessage());
        }
    }

    //Accion de lo botones del panel Nuevo contrato
    //**************************************************************************
private void btnSalirNuevoContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirNuevoContratoActionPerformed

    try {
        this.setClosed(true);
    } catch (PropertyVetoException ex) {
        log.error("Error al Interntar Cerrar Ventana Contrato: "
                + ex.getMessage());
    }
}//GEN-LAST:event_btnSalirNuevoContratoActionPerformed

private void btnGuardarContratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarContratosActionPerformed
    //restringe el boton guardar contrato */KEDTO*/
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getGENERARCONTRATO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    if (combosSelecionados() == true) {
        if (fechaSeleccionada() == true) {
            if (validarDni() == true) {
                if (validarHorario() == true) {
                    if (validarSueldo() == true) {
                        if (validarFechas()) {

                            com.gestionmatriz.recursoshumanos.bean.Contrato objContrato =
                                    new com.gestionmatriz.recursoshumanos.bean.Contrato();

                            String sueldo = txtSueldoContrato.getText();

                            objContrato.setDbl_sueldo(com.gestionmatriz.util.Util.stringTOBigDecimal(sueldo));
                            objContrato.setDte_fechaInicial(
                                    com.gestionmatriz.util.Util.getFecha("yyyy-MM-dd", dtpFechaInicioContrato.getDate()));

                            objContrato.setDte_fechaFinal(
                                    com.gestionmatriz.util.Util.getFecha("yyyy-MM-dd", dtpFechaFinContrato.getDate()));

                            objContrato.setInt_idEmpresa(this.objempresa.getInt_idEmpresa());

                            String str_codigo = this.objPersonal.getStr_codigo();
                            int int_idPersona = Integer.parseInt(str_codigo.substring(1));
                            log.info("id_persona" + int_idPersona);
//                           objContrato.setInt_idPersona(this.objPersonal.getInt_idPersona());
                            objContrato.setInt_idPersona(int_idPersona);

                            objContrato.setInt_idTipoContrato(objTipoContrato.getInt_idTipoContrato());

                            objContrato.setStr_estado(com.gestionmatriz.util.Util.ACTIVO);

                            objContrato.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());

                            objContrato.setInt_local(listaLocales.get(cboLocal.getSelectedIndex() - 1).getInt_idLocal());

//                           objContrato.setStr_codigoPersona(objPersonal.getStr_codigo());

                            if (PaqueteBusinessDelegate.getContratoService().
                                    registrarContrato(objContrato, frmHorario.getListaHorarioJornada())) {
                                Mensaje.mensaje(this, "Se Registro con Éxito el Contrato para: "
                                        + objPersonal.getStr_nombres() + " " + objPersonal.getStr_apePaterno() + " " + objPersonal.getStr_apeMaterno(),
                                        Mensaje.TITULO_ME, Mensaje.INFORMACION);
                            } else {
                                Mensaje.mensaje(this, "No se pudo registrar el contrato",
                                        Mensaje.TITULO_ME, Mensaje.ERROR);
                            }

                            limpiarFrmContrato();
                        }

                    }
                }
            }
        }
    }


}//GEN-LAST:event_btnGuardarContratosActionPerformed

    private boolean validarFechas() {
        Date fechaInicio = dtpFechaInicioContrato.getDate();
        Date fechaFin = dtpFechaFinContrato.getDate();

        int diaInicial = com.gestionmatriz.util.Util.numeroDia(fechaInicio);
        int diaFinal = com.gestionmatriz.util.Util.numeroDia(fechaInicio);

        int mesInicial = com.gestionmatriz.util.Util.numeroMes(fechaInicio);
        int mesFinal = com.gestionmatriz.util.Util.numeroMes(fechaFin);

        int anioInicial = com.gestionmatriz.util.Util.numeroAnio(fechaInicio);
        int anioFinal = com.gestionmatriz.util.Util.numeroAnio(fechaFin);


        if (anioInicial > anioFinal) {
            Mensaje.mensaje(this, "Año inicial no puede ser mayor que año final",
                    Mensaje.TITULO_ME, Mensaje.ERROR);
            return false;
        }

//     if (com.gestionmatriz.util.Util.diaEntreFechas(fechaInicio, fechaFin)%30!=0){
//          Mensaje.mensaje(this, "La duración del contrato esta determinada en meses", 
//                 Mensaje.TITULO_ME,Mensaje.ERROR);
//         return false;
//     }

        return true;
    }

private void btnBuscarDniContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDniContratoActionPerformed
    // validar busqueda por dni */KEDTO*/

    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCONSULTARPERSONA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (validarDni() == true) {
        try {
            List<com.gestionmatriz.recursoshumanos.bean.Personal> lista =
                    //                    new ArrayList<com.gestionmatriz.recursoshumanos.bean.Personal>();

                    PaqueteBusinessDelegate.getPersonalService().
                    BuscarPersona("", "", "",
                    txtTrabajdorContrato.getText().trim());

//             System.out.println("--------"+lista.size());

            if (lista.size() == 1) {
                for (com.gestionmatriz.recursoshumanos.bean.Personal objp : lista) {
                    cargarDatosBusquedaPersona(objp);
                    this.objPersonal = objp;
                }
            }
        } catch (SQLException ex) {
           log.error("ERROR: "+ex.getMessage());
        }
    }
}//GEN-LAST:event_btnBuscarDniContratoActionPerformed

private void btnBuscarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHorarioActionPerformed
    cargarFrmHorario();
}//GEN-LAST:event_btnBuscarHorarioActionPerformed

    public void cargarFrmHorario() {
        //restringir busqueda de horario */KEDTO */ aaaayyyyyy oaky
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getGENERARHORARIO())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        Util.hiloProgressBar(1, gui);
        frmHorario = new Horario(gui, gui, this, 0, "");
        Util.hiloProgressBar(0, gui);
        frmHorario.setVisible(true);

//        gui.addFrm(frmHorario);
//      gui.enforcar(frmHorario);
//    }
    }

    public void setLblHorarioContrato(String cadena) {
        lblHorarioContrato.setText(cadena);
    }

private void btnCancelarNuevoContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarNuevoContratoActionPerformed

    limpiarFrmContrato();
}//GEN-LAST:event_btnCancelarNuevoContratoActionPerformed

private void btnBusquedaAvazadaContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaAvazadaContratoActionPerformed
// TODO add your handling code here:
    //restringir búsqueda avanzada  */KEDTO */
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getGENERARCONTRATO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
}//GEN-LAST:event_btnBusquedaAvazadaContratoActionPerformed

//Accion de lo botones del panel Renovar contrato
    //**************************************************************************
private void btnBuscarHorarioRenovarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHorarioRenovarContratoActionPerformed
    //restringir búsqueda de horario */KEDTO */
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getRENOVARCONTRATO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    Util.hiloProgressBar(1, gui);
    frmHorario = new Horario(gui, gui, this, 0, "");
    Util.hiloProgressBar(0, gui);
    frmHorario.setVisible(true);

    this.listobjHorarioJornada = null;
}//GEN-LAST:event_btnBuscarHorarioRenovarContratoActionPerformed

    public void mostrarOcultarJDialog(boolean b) {
        frmHorario.setVisible(b);
    }
private void btnVistaPreviaRenovarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVistaPreviaRenovarContratoActionPerformed
// TODO add your handling code here:
    //restringir vista previa de renovación de contrato  */KEDTO */
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getRENOVARCONTRATO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
}//GEN-LAST:event_btnVistaPreviaRenovarContratoActionPerformed

private void btnGuardarRenovarContratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRenovarContratosActionPerformed
    //restringir guardar renovación de contrato  */KEDTO */
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getRENOVARCONTRATO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    if (tablaRenovar() == true) {
        if (validarHorarioRenovar() == true) {
            if (tipoContratoRenovar() == true) {
                if (fechaRenovar() == true) {
                    if (sueldoRenovar() == true) {

                        if (listobjHorarioJornada == null) {
                            listobjHorarioJornada = frmHorario.getListaHorarioJornada();
                        }

                        if (listobjHorarioJornada.isEmpty()) {
                            Mensaje.mensaje(this, "El trabajador con tiene horario asignado", Mensaje.TITULO_ME,
                                    Mensaje.ERROR);
                            return;
                        }
                        renovarContrato();
                    }
                }
            }
        }
    }


}//GEN-LAST:event_btnGuardarRenovarContratosActionPerformed

    private void renovarContrato() {
        com.gestionmatriz.recursoshumanos.bean.Contrato objContrato =
                new com.gestionmatriz.recursoshumanos.bean.Contrato();

        String sueldo = txtSueldoRenovarContrato.getText();

        objContrato.setInt_idContrato(objHorarioJornadaContrato.getObjContrato().getInt_idContrato());
        objContrato.setDbl_sueldo(com.gestionmatriz.util.Util.stringTOBigDecimal(sueldo));
        objContrato.setDte_fechaInicial(
                com.gestionmatriz.util.Util.getFecha("yyyy-MM-dd", dtpFechaInicioRenovarContrato.getDate()));

        objContrato.setDte_fechaFinal(
                com.gestionmatriz.util.Util.getFecha("yyyy-MM-dd", dtpFechaFinRenovarContrato.getDate()));

        objContrato.setInt_idEmpresa(objHorarioJornadaContrato.getObjContrato().getObjEmpresa().getInt_idEmpresa());

        String str_codigo = objHorarioJornadaContrato.getObjContrato().getObjPersona().getStr_codigo();
        int int_idPersona = Integer.parseInt(str_codigo.substring(1));
        objContrato.setInt_idPersona(int_idPersona);

        setObjTipoContrato();
        objContrato.setInt_idTipoContrato(objTipoContratoRenovar.getInt_idTipoContrato());

        objContrato.setStr_estado(com.gestionmatriz.util.Util.ACTIVO);

        objContrato.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());

        if (PaqueteBusinessDelegate.getContratoService().
                renovarContrato(objContrato, listobjHorarioJornada)) {
            Mensaje.mensaje(this, "Se Registro con Éxito el Contrato para: "
                    + objHorarioJornadaContrato.getObjContrato().getObjPersona().getStr_nombres(),
                    Mensaje.TITULO_ME, Mensaje.INFORMACION);
        } else {
            Mensaje.mensaje(this, "No se pudo registrar el contrato",
                    Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }

private void btnCancelarRenovarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRenovarContratoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_btnCancelarRenovarContratoActionPerformed

private void btnSalirRenovarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirRenovarContratoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_btnSalirRenovarContratoActionPerformed

//Accion de lo botones del panel Renovar contrato
//**************************************************************************
private void btnFinalizarContratoCancelarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarContratoCancelarContratoActionPerformed
    //restringir tipo de contrato  */KEDTO */
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCANCELARCONTRATO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    //falta llamar a los otros metodos....probar metodo de tabla
    if (tablaCancelar() && objHorarioJornadaContrato != null) {
        com.gestionmatriz.recursoshumanos.bean.Contrato objContra = objHorarioJornadaContrato.getObjContrato();

        String motivo = cboMotivoCancelar.getSelectedItem().toString();
        String observacion = txtObservacionesCancelar.getText();

        objContra.setStr_observacion(motivo.concat(" - ".concat(observacion)));


        if (PaqueteBusinessDelegate.getContratoService().cancelarContrato(objContra)) {
            Mensaje.mensaje(this, "Se Cancelo el contrato de manera existosa",
                    Mensaje.TITULO_ME, Mensaje.INFORMACION);
        } else {
            Mensaje.mensaje(this, "No Se pudo Cancelar el contrato ",
                    Mensaje.TITULO_ME, Mensaje.INFORMACION);
        }
    }
}//GEN-LAST:event_btnFinalizarContratoCancelarContratoActionPerformed

private void btnCancelarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarContratoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_btnCancelarContratoActionPerformed

private void btnSalirCancelarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirCancelarContratoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_btnSalirCancelarContratoActionPerformed

private void txtTrabajdorContratoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTrabajdorContratoKeyTyped
    char c = evt.getKeyChar();
    if (!(Character.isDigit(c)
            || (c == KeyEvent.VK_BACK_SPACE)
            || (c == KeyEvent.VK_DELETE)) || txtTrabajdorContrato.getText().trim().length() == 8) {
        Mensaje.mensaje(this, "Error: \n"
                + "•\tNo puede ingresar letras.\n "
                + "•\tSolo puede ingresar 8 dígitos para el DNI.",
                Mensaje.TITULO_ME, Mensaje.ERROR);
        getToolkit().beep();
        evt.consume();
    }// TODO add your handling code here:
}//GEN-LAST:event_txtTrabajdorContratoKeyTyped

private void txtSueldoContratoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoContratoKeyTyped
    char c = evt.getKeyChar();
    if (!(Character.isDigit(c)
            || (c == KeyEvent.VK_BACK_SPACE)
            || (c == KeyEvent.VK_DELETE))) {
        Mensaje.mensaje(this, "Error: \n"
                + "•\tNo puede ingresar letras.\n "
                + "•\tSolo puede ingresar 8 dígitos para el DNI.",
                Mensaje.TITULO_ME, Mensaje.ERROR);
        getToolkit().beep();
        evt.consume();
    }
//    else
//    {
//        txtSueldoContrato.setText(
//                "S/."+txtSueldoContrato.getText().replaceAll("S/.", "")+c);
//    }
}//GEN-LAST:event_txtSueldoContratoKeyTyped

private void cboTipoContratoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTipoContratoItemStateChanged
    int indice = cboTipoContrato.getSelectedIndex();

    if (indice > 0) {
        objTipoContrato = ListaTipoContrato.get(indice - 1);
    }
}//GEN-LAST:event_cboTipoContratoItemStateChanged

private void txtBuscarContratoRenovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarContratoRenovarActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCONSULTARCONTRATO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        txtBuscarContratoRenovar.setText("");
        return;

    }
    String dni = txtBuscarContratoRenovar.getText();

    cargarTabla(PaqueteBusinessDelegate.getContratoService().consultaContrato(dni, MysqlContratoDAO.QUERYRENOVAR), tblTablaRenovarContrato);

}//GEN-LAST:event_txtBuscarContratoRenovarActionPerformed

private void txtBuscarContratoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarContratoCancelarActionPerformed
    //restringir búsqueda por DNI de contrato  */KEDTO */
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCONSULTARCONTRATO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        txtBuscarContratoCancelar.setText("");
        return;

    }
    String dni = txtBuscarContratoCancelar.getText();

    cargarTabla(PaqueteBusinessDelegate.getContratoService().consultaContrato(dni, MysqlContratoDAO.QUERYCONSULTA), tblTablaCancelarContrato);


}//GEN-LAST:event_txtBuscarContratoCancelarActionPerformed

private void tblTablaRenovarContratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaRenovarContratoMouseClicked

    if (!(tblTablaCancelarContrato.getRowCount() > 0)) {
        return;
    }
    int indice = tblTablaRenovarContrato.getSelectedRow();
    if (indice < 0) {
        return;
    }
    int idContrato = this.listaHorarioJornadaContrato.get(indice).getObjContrato().getInt_idContrato();

    com.gestionmatriz.recursoshumanos.bean.Contrato objContratoTempo = this.listaHorarioJornadaContrato.get(indice).getObjContrato();

    this.objHorarioJornadaContrato = PaqueteBusinessDelegate.getContratoService().consultaContrato(idContrato);

    this.listobjHorarioJornada = objHorarioJornadaContrato.getObjListHorarioJornada();

    cboTipoContratoRenovarContrato.setSelectedItem(objContratoTempo.getObjTipoContrato().getStr_tipoContrato());

    dtpFechaInicioRenovarContrato.setDate(com.gestionmatriz.util.Util.StringTODate(objContratoTempo.getDte_fechaInicial()));

    dtpFechaFinRenovarContrato.setDate(com.gestionmatriz.util.Util.StringTODate(objContratoTempo.getDte_fechaFinal()));

    txtSueldoRenovarContrato.setText(String.valueOf(
            objContratoTempo.getDbl_sueldo()));

    lblHorarioRenovarContrato.setText("Horario Cargago.......");


}//GEN-LAST:event_tblTablaRenovarContratoMouseClicked

private void cboTipoContratoRenovarContratoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTipoContratoRenovarContratoItemStateChanged

    setObjTipoContrato();
}//GEN-LAST:event_cboTipoContratoRenovarContratoItemStateChanged

private void tblTablaCancelarContratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaCancelarContratoMouseClicked

    if (tblTablaCancelarContrato.getRowCount() > 0) {
        int indice = tblTablaCancelarContrato.getSelectedRow();
        if (indice < 0) {
            return;
        }
        int idContrato = this.listaHorarioJornadaContrato.get(indice).getObjContrato().getInt_idContrato();

//    com.gestionmatriz.recursoshumanos.bean.Contrato
//            objContratoTempo=this.listaHorarioJornadaContrato.get(indice).getObjContrato();

        this.objHorarioJornadaContrato = PaqueteBusinessDelegate.getContratoService().consultaContrato(idContrato);

//    this.listobjHorarioJornada=objHorarioJornadaContrato.getObjListHorarioJornada();

//    cboTipoContratoRenovarContrato.setSelectedItem(objContratoTempo.getObjTipoContrato().getStr_tipoContrato());

//    dtpFechaInicioRenovarContrato.setDate(com.gestionmatriz.util.Util.
//                    StringTODate(objContratoTempo.getDte_fechaInicial()));

//    dtpFechaFinRenovarContrato.setDate(com.gestionmatriz.util.Util.
//                    StringTODate(objContratoTempo.getDte_fechaFinal()));

//    txtSueldoRenovarContrato.setText(String.valueOf(
//            objContratoTempo.getDbl_sueldo()));



        lblHorarioRenovarContrato.setText("Horario Cargago.......");

    }

}//GEN-LAST:event_tblTablaCancelarContratoMouseClicked

private void mnuListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarActionPerformed
//    String dni = txtBuscarContratoCancelar.getText();
    cargarTabla(PaqueteBusinessDelegate.getContratoService().consultaContrato("", MysqlContratoDAO.ALLCONTRATOS), tbListaContratos);
}//GEN-LAST:event_mnuListarActionPerformed

private void mnuVerContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVerContratoActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCONSULTARCONTRATO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        txtBuscarContratoCancelar.setText("");
        return;
    }

    int fila = tbListaContratos.getSelectedRow();
    //System.out.println("fila--:"+fila);
    int idContrato = 0;
    String nombreReporte = null;
    if (fila == -1) {
        Mensaje.mensaje(this, "Debe seleccionar un contrato de la lista", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else {
        for (HorarioJornadaContrato hjc : listaHorarioJornadaContrato) {
            if (hjc.getObjContrato().getObjPersona().getStr_dni()
                    == tbListaContratos.getModel().getValueAt(fila, 0)) {
                idContrato = hjc.getObjContrato().getInt_idContrato();
                nombreReporte = hjc.getObjContrato().getObjTipoContrato().getStr_nombreReporte();
            }
        }
        //System.out.println("idContrato--:"+idContrato);

        if (nombreReporte == null) {
            Mensaje.mensaje(this, "Error al Cargar Reporte", Mensaje.TITULO_ME, Mensaje.ERROR);
        }

        ireport.verContrato(idContrato, nombreReporte);
    }

}//GEN-LAST:event_mnuVerContratoActionPerformed

private void mnuVerContratoCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVerContratoCancelActionPerformed

    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCONSULTARCONTRATO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        txtBuscarContratoCancelar.setText("");
        return;

    }

    int fila = tblTablaCancelarContrato.getSelectedRow();
    System.out.println("fila--:" + fila);
    int idContrato = 0;
    String nombreReporte = null;
    if (fila == -1) {
        Mensaje.mensaje(this, "Debe buscar un contrato", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else {
        for (HorarioJornadaContrato hjc : listaHorarioJornadaContrato) {
            if (hjc.getObjContrato().getObjPersona().getStr_dni()
                    == tblTablaCancelarContrato.getModel().getValueAt(fila, 0)) {
                idContrato = hjc.getObjContrato().getInt_idContrato();
                nombreReporte = hjc.getObjContrato().getObjTipoContrato().getStr_nombreReporte();
            }
        }
        System.out.println("idContrato--:" + idContrato);
        ireport.verContrato(idContrato, nombreReporte);
    }
}//GEN-LAST:event_mnuVerContratoCancelActionPerformed

private void mnuVerContratoRenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVerContratoRenoActionPerformed

    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCONSULTARCONTRATO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        txtBuscarContratoCancelar.setText("");
        return;

    }

    int fila = tblTablaRenovarContrato.getSelectedRow();
    //System.out.println("fila--:"+fila);
    int idContrato = 0;
    String nombreReporte = null;
    if (fila == -1) {
        Mensaje.mensaje(this, "Debe buscar un contrato", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else {
        for (HorarioJornadaContrato hjc : listaHorarioJornadaContrato) {
            if (hjc.getObjContrato().getObjPersona().getStr_dni()
                    == tblTablaRenovarContrato.getModel().getValueAt(fila, 0)) {
                idContrato = hjc.getObjContrato().getInt_idContrato();
                nombreReporte = hjc.getObjContrato().getObjTipoContrato().getStr_nombreReporte();
            }
        }
        //System.out.println("idContrato--:"+idContrato);
        ireport.verContrato(idContrato, nombreReporte);
    }
}//GEN-LAST:event_mnuVerContratoRenoActionPerformed

private void cboTipoContratoRenovarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoContratoRenovarContratoActionPerformed
}//GEN-LAST:event_cboTipoContratoRenovarContratoActionPerformed

private void cboTipoContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoContratoActionPerformed
}//GEN-LAST:event_cboTipoContratoActionPerformed

private void txtTrabajdorContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrabajdorContratoActionPerformed

    //restringir búsqueda por DNI de contrato  */KEDTO */
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getGENERARCONTRATO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        txtTrabajdorContrato.setText("");
        return;

    }
}//GEN-LAST:event_txtTrabajdorContratoActionPerformed

private void cboEmpresaContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmpresaContratoActionPerformed
    if (cboEmpresaContrato.getSelectedIndex() > 0) {
        objempresa = new Empresa();

        objempresa = ListaEmpresa.get(cboEmpresaContrato.getSelectedIndex() - 1);
        lblRazonSocialContrato.setText(objempresa.getStr_razonSocial());
        lblRucEmpresaContrato.setText(objempresa.getStr_ruc());
        lblDireccionEmpresaContrato.setText(objempresa.getStr_domicilioEmpresa());
        lblRepresentanteEmpresaContrato.setText(objempresa.getStr_representanteLegal());
        lblDniRepresentanteContrato.setText(objempresa.getStr_dniRepresentante());

        cargarLocales(objempresa.getInt_idEmpresa());
    }

    cboLocal.requestFocus();
}//GEN-LAST:event_cboEmpresaContratoActionPerformed

private void mnuBuscarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBuscarContratoActionPerformed
    ConsultarContrato frmConsultarContrato = new ConsultarContrato(gui);
    frmConsultarContrato.setVisible(true);

    int empresa = frmConsultarContrato.indexEmpresa;
    String codigoPersona = frmConsultarContrato.indexPersona;
    String estado = frmConsultarContrato.indexEstado;

    cargarTabla(PaqueteBusinessDelegate.getContratoService().
            consultarContratoXPersona(empresa, codigoPersona, estado), tbListaContratos);
}//GEN-LAST:event_mnuBuscarContratoActionPerformed

private void mnuModificarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModificarHorarioActionPerformed
    cargarFrmHorarioModificar();
}//GEN-LAST:event_mnuModificarHorarioActionPerformed

private void mnuModificarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModificarLocalActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getGENERARCONTRATO())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    int indexFila = tbListaContratos.getSelectedRow();
    int idContrato = 0;
    int idEmpresa = 0;
    int idLocal = 0;
    String persona = "";
    String dni = "";

    if (indexFila == -1) {
        Mensaje.mensaje(this, "Debe seleccionar un contrato de la lista", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else if (tbListaContratos.getModel().getValueAt(indexFila, 10).equals(Util.ACTIVO)) {
        for (HorarioJornadaContrato hjc : listaHorarioJornadaContrato) {
            if (hjc.getObjContrato().getObjPersona().getStr_dni() == tbListaContratos.getModel().getValueAt(indexFila, 0)) {
                idContrato = hjc.getObjContrato().getInt_idContrato();
                idEmpresa = hjc.getObjContrato().getInt_idEmpresa();
                persona = hjc.getObjContrato().getObjPersona().getStr_nombres() + " "
                        + hjc.getObjContrato().getObjPersona().getStr_apePaterno() + " "
                        + hjc.getObjContrato().getObjPersona().getStr_apeMaterno();
                dni = hjc.getObjContrato().getObjPersona().getStr_dni();
            }
        }
        Util.hiloProgressBar(1, gui);
        frmModificarLocal = new ModificarLocal(gui, gui, idEmpresa, persona, dni);
        Util.hiloProgressBar(0, gui);
        frmModificarLocal.setVisible(true);

        idLocal = frmModificarLocal.indexLocal;

        if (frmModificarLocal.i == 1) {
            if (PaqueteBusinessDelegate.getContratoService().modificarLocalPersona(idContrato, idLocal)) {
                Mensaje.mensaje(this, "Modificación de local exitosa", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            } else {
                Mensaje.mensaje(this, "No se pudo modificar el local", Mensaje.TITULO_ME, Mensaje.ERROR);
            }
        }

//        if (PaqueteBusinessDelegate.getContratoService().modificarLocalPersona(idContrato, idLocal)) {
//            Mensaje.mensaje(this, "Modificación de local exitosa", Mensaje.TITULO_ME, Mensaje.INFORMACION);
//        } else {
//            Mensaje.mensaje(this, "No se pudo modificar el local", Mensaje.TITULO_ME, Mensaje.ERROR);
//        }
    }
}//GEN-LAST:event_mnuModificarLocalActionPerformed

    private void cargarFrmHorarioModificar() {
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getGENERARHORARIO())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }

        int indexFila = tbListaContratos.getSelectedRow();
        int idContrato = 0;
        String persona = "";

        if (indexFila == -1) {
            Mensaje.mensaje(this, "Debe seleccionar un contrato de la lista", Mensaje.TITULO_ME, Mensaje.ERROR);
        } else if (tbListaContratos.getModel().getValueAt(indexFila, 10).equals(Util.ACTIVO)) {
            for (HorarioJornadaContrato hjc : listaHorarioJornadaContrato) {
                if (hjc.getObjContrato().getObjPersona().getStr_dni() == tbListaContratos.getModel().getValueAt(indexFila, 0)) {
                    idContrato = hjc.getObjContrato().getInt_idContrato();
                    persona = hjc.getObjContrato().getObjPersona().getStr_nombres() + " "
                            + hjc.getObjContrato().getObjPersona().getStr_apePaterno() + " "
                            + hjc.getObjContrato().getObjPersona().getStr_apeMaterno();
                }
            }
            Util.hiloProgressBar(1, gui);
            frmHorario = new Horario(gui, gui, this, idContrato, persona);
            Util.hiloProgressBar(0, gui);
            frmHorario.setVisible(true);
        } else {
            Mensaje.mensaje(this, "Sólo se modifican horarios para Contratos ACTIVOS", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            return;
        }
    }

    private void setObjTipoContrato() {
        int indice = cboTipoContratoRenovarContrato.getSelectedIndex();

        if (indice > 0) {
            objTipoContratoRenovar = ListaTipoContrato.get(indice - 1);
        }

    }

    private void cargarTabla(List<HorarioJornadaContrato> lista, JXTable tabla) {
        String[] objTitulo = {"DNI", "NOMBRE", "A PATERNO", "A MATERNO", "EMPRESA", "TIPO CONTRATO", "SUELDO", "F. INICIAL", "F FIN", "CREADOR", "ESTADO"};
        String[][] objData = new String[lista.size()][11];

        int i = 0;
        for (HorarioJornadaContrato hjc : lista) {
            objData[i][0] = hjc.getObjContrato().getObjPersona().getStr_dni();
            objData[i][1] = hjc.getObjContrato().getObjPersona().getStr_nombres();
            objData[i][2] = hjc.getObjContrato().getObjPersona().getStr_apePaterno();
            objData[i][3] = hjc.getObjContrato().getObjPersona().getStr_apeMaterno();
            objData[i][4] = hjc.getObjContrato().getObjEmpresa().getStr_razonSocial();
            objData[i][5] = hjc.getObjContrato().getObjTipoContrato().getStr_tipoContrato();
            objData[i][6] = String.valueOf(hjc.getObjContrato().getDbl_sueldo());
            objData[i][7] = hjc.getObjContrato().getDte_fechaInicial();
            objData[i][8] = hjc.getObjContrato().getDte_fechaFinal();
            objData[i][9] = hjc.getObjContrato().getStr_usuarioCreador();
            objData[i][10] = hjc.getObjContrato().getStr_estado();
            i++;
        }

        DefaultTableModel modelo = new DefaultTableModel(objData, objTitulo);
        tabla.setModel(modelo);
        this.listaHorarioJornadaContrato = lista;
    }

    //Metodo que se ejecuta antes que se cierre la ventana
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

    //valida que los combos han sido seleccionados
    public boolean combosSelecionados() {
        boolean valor = true;

        JComboBox[] cbos = {
            cboEmpresaContrato,
            cboTipoContrato,
            cboLocal
        };

        if (ValidarCamposNulos.validarCombos(cbos) == false) {
            Mensaje.mensaje(this, "Debe seleccionar una opción en los campos resaltados",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }
    //valida que las fechas han sido seleccionados

    public boolean fechaSeleccionada() {
        boolean valor = true;

        JXDatePicker[] dtps = {
            dtpFechaInicioContrato,
            dtpFechaFinContrato};

        if (ValidarCamposNulos.validarDatePicker(dtps) == false) {
            Mensaje.mensaje(this, "Debe seleccionar un rango de Fechas",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }

    //valida que el txt tenga una cadena de 8 digitos
    public boolean validarDni() {
        boolean valor = true;
        if (ValidarCamposNulos.validarTxtNroCaracteres(txtTrabajdorContrato, 8) == false) {
            Mensaje.mensaje(this, "Debe Ingresar el DNI(8 dígitos)",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }

    //valida que se haya seleccionado un horario
    public boolean validarHorario() {
        boolean valor = true;
        JXLabel[] lbls = {lblHorarioContrato};
        if (ValidarCamposNulos.validarLabelSeteada(lbls) == false) {
            Mensaje.mensaje(this, "Debe seleccionar un horario",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }
    //valida que se haya seleccionado un horario

    public boolean validarSueldo() {
        boolean valor = true;
        JTextField[] txts = {txtSueldoContrato};
        if (ValidarCamposNulos.validar(txts) == false) {
            Mensaje.mensaje(this, "Debe Ingresar un sueldo",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }

    public boolean tipoContratoRenovar() {
        boolean valor = true;

        JComboBox[] cbos = {cboTipoContratoRenovarContrato};

        if (ValidarCamposNulos.validarCombos(cbos) == false) {
            Mensaje.mensaje(this, "Debe seleccionar una opción en los campos resaltados",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }

    public boolean validarHorarioRenovar() {
        boolean valor = true;
        JXLabel[] lbls = {lblHorarioRenovarContrato};
        if (ValidarCamposNulos.validarLabelSeteada(lbls) == false) {
            Mensaje.mensaje(this, "Debe seleccionar un horario",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }

    public boolean fechaRenovar() {
        boolean valor = true;

        JXDatePicker[] dtps = {
            dtpFechaInicioRenovarContrato,
            dtpFechaFinRenovarContrato};

        if (ValidarCamposNulos.validarDatePicker(dtps) == false) {
            Mensaje.mensaje(this, "Debe seleccionar un rango de Fechas",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }

    public boolean sueldoRenovar() {
        boolean valor = true;
        JTextField[] txts = {txtSueldoRenovarContrato};
        if (ValidarCamposNulos.validar(txts) == false) {
            Mensaje.mensaje(this, "Debe Ingresar un sueldo",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }

    public boolean tablaRenovar() {
        boolean valor = true;
        if (ValidarCamposNulos.validarTablaVacia(tblTablaRenovarContrato) == false) {
            Mensaje.mensaje(this, "Debe ingresar un nombre para cargar los resultados",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }

    public boolean tablaCancelar() {
        boolean valor = true;
        if (ValidarCamposNulos.validarTablaVacia(tblTablaCancelarContrato) == false) {
            Mensaje.mensaje(this, "Debe ingresar un nombre para cargar los resultados",
                    Mensaje.TITULO_ME, Mensaje.ERROR);
            valor = false;
        }
        if (tblTablaCancelarContrato.getSelectedRow() == -1) {
            Mensaje.mensaje(this, "Debe Selecionar una persona de la tabla",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }

    public boolean motivoCancelar() {
        boolean valor = true;

        JComboBox[] cbos = {cboMotivoCancelar};

        if (ValidarCamposNulos.validarCombos(cbos) == false) {
            Mensaje.mensaje(this, "Debe seleccionar una opción en los campos resaltados",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }

    public boolean validarObservaciones() {
        boolean valor = true;
        if (ValidarCamposNulos.validarTxtArea(txtObservacionesCancelar) == false) {
            Mensaje.mensaje(this, "Debe ingresar las observaciones sobre la cancelación del contrato",
                    Mensaje.TITULO_ME, Mensaje.ADVERTENCIA);
            valor = false;
        }
        return valor;
    }

    private void cargarDatosBusquedaPersona(com.gestionmatriz.recursoshumanos.bean.Personal Objpersonal) {
        lblNombreTrabajadorContrato.setText(Objpersonal.getStr_nombres() + " "
                + Objpersonal.getStr_apePaterno() + " " + Objpersonal.getStr_apeMaterno());
        lblDniTrabajadorContrato.setText(Objpersonal.getStr_dni());
        lblDomicilioTrabajadorContrato.setText(Objpersonal.getStr_direccion());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscarDniContrato;
    private org.jdesktop.swingx.JXButton btnBuscarHorario;
    private org.jdesktop.swingx.JXButton btnBuscarHorarioRenovarContrato;
    private org.jdesktop.swingx.JXButton btnBusquedaAvazadaContrato;
    private org.jdesktop.swingx.JXButton btnCancelarContrato;
    private org.jdesktop.swingx.JXButton btnCancelarNuevoContrato;
    private org.jdesktop.swingx.JXButton btnCancelarRenovarContrato;
    private org.jdesktop.swingx.JXButton btnFinalizarContratoCancelarContrato;
    private org.jdesktop.swingx.JXButton btnGuardarContratos;
    private org.jdesktop.swingx.JXButton btnGuardarRenovarContratos;
    private org.jdesktop.swingx.JXButton btnSalirCancelarContrato;
    private org.jdesktop.swingx.JXButton btnSalirNuevoContrato;
    private org.jdesktop.swingx.JXButton btnSalirRenovarContrato;
    private org.jdesktop.swingx.JXButton btnVistaPreviaRenovarContrato;
    private org.jdesktop.swingx.JXComboBox cboEmpresaContrato;
    private org.jdesktop.swingx.JXComboBox cboLocal;
    private org.jdesktop.swingx.JXComboBox cboMotivoCancelar;
    private org.jdesktop.swingx.JXComboBox cboTipoContrato;
    private org.jdesktop.swingx.JXComboBox cboTipoContratoRenovarContrato;
    private org.jdesktop.swingx.JXDatePicker dtpFechaFinContrato;
    private org.jdesktop.swingx.JXDatePicker dtpFechaFinRenovarContrato;
    private org.jdesktop.swingx.JXDatePicker dtpFechaInicioContrato;
    private org.jdesktop.swingx.JXDatePicker dtpFechaInicioRenovarContrato;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel10;
    private org.jdesktop.swingx.JXLabel jXLabel16;
    private org.jdesktop.swingx.JXLabel jXLabel17;
    private org.jdesktop.swingx.JXLabel jXLabel18;
    private org.jdesktop.swingx.JXLabel jXLabel19;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel20;
    private org.jdesktop.swingx.JXLabel jXLabel21;
    private org.jdesktop.swingx.JXLabel jXLabel22;
    private org.jdesktop.swingx.JXLabel jXLabel23;
    private org.jdesktop.swingx.JXLabel jXLabel24;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXLabel lblDireccionEmpresaContrato;
    private org.jdesktop.swingx.JXLabel lblDniRepresentanteContrato;
    private org.jdesktop.swingx.JXLabel lblDniTrabajadorContrato;
    private org.jdesktop.swingx.JXLabel lblDomicilioTrabajadorContrato;
    private org.jdesktop.swingx.JXLabel lblHorarioContrato;
    private org.jdesktop.swingx.JXLabel lblHorarioRenovarContrato;
    private org.jdesktop.swingx.JXLabel lblNombreTrabajadorContrato;
    private org.jdesktop.swingx.JXLabel lblRazonSocialContrato;
    private org.jdesktop.swingx.JXLabel lblRepresentanteEmpresaContrato;
    private org.jdesktop.swingx.JXLabel lblRucEmpresaContrato;
    private javax.swing.JMenuItem mnuBuscarContrato;
    private javax.swing.JMenuItem mnuListar;
    private javax.swing.JMenuItem mnuModificarHorario;
    private javax.swing.JMenuItem mnuModificarLocal;
    private javax.swing.JMenuItem mnuVerContrato;
    private javax.swing.JMenuItem mnuVerContratoCancel;
    private javax.swing.JMenuItem mnuVerContratoReno;
    private javax.swing.JTabbedPane pnlGestionarContratos;
    private org.jdesktop.swingx.JXPanel pnlListaContratos;
    private org.jdesktop.swingx.JXPanel pnlNuevoContrato;
    private javax.swing.JPanel pnlRenovarContrato;
    private javax.swing.JPopupMenu popupListaContratos;
    private javax.swing.JPopupMenu popupVerContrato;
    private javax.swing.JPopupMenu popupVerContratoRenov;
    private org.jdesktop.swingx.JXTable tbListaContratos;
    private org.jdesktop.swingx.JXTable tblTablaCancelarContrato;
    private org.jdesktop.swingx.JXTable tblTablaRenovarContrato;
    private org.jdesktop.swingx.JXTextField txtBuscarContratoCancelar;
    private org.jdesktop.swingx.JXTextField txtBuscarContratoRenovar;
    private org.jdesktop.swingx.JXTextArea txtObservacionesCancelar;
    private org.jdesktop.swingx.JXTextField txtSueldoContrato;
    private org.jdesktop.swingx.JXTextField txtSueldoRenovarContrato;
    private org.jdesktop.swingx.JXTextField txtTrabajdorContrato;
    // End of variables declaration//GEN-END:variables
    private Principal gui;
    private List<Empresa> ListaEmpresa;
    private List<TipoContrato> ListaTipoContrato = new ArrayList<>();
    private Horario frmHorario;
    private ModificarLocal frmModificarLocal;
    private Empresa objempresa;
    private com.gestionmatriz.recursoshumanos.bean.Personal objPersonal;
    private TipoContrato objTipoContrato;
    private Ireport ireport = new Ireport();

    /*Variabe para el Renovar/Cancelar Contrato*/
    List<HorarioJornadaContrato> listaHorarioJornadaContrato;
    HorarioJornadaContrato objHorarioJornadaContrato;
    List<HorarioJornada> listobjHorarioJornada;
    TipoContrato objTipoContratoRenovar;
    List<Local> listaLocales;

    /*Variabe para el Renovar Contrato*/
    private void limpiarFrmContrato() {

        cboEmpresaContrato.setSelectedIndex(0);
        cboLocal.removeAllItems();
        cboTipoContrato.setSelectedIndex(0);
        lblRazonSocialContrato.setText("");
        lblRucEmpresaContrato.setText("");
        lblDireccionEmpresaContrato.setText("");
        lblRepresentanteEmpresaContrato.setText("");
        lblDniRepresentanteContrato.setText("");
        lblNombreTrabajadorContrato.setText("");
        lblDniTrabajadorContrato.setText("");
        lblDomicilioTrabajadorContrato.setText("");
        txtSueldoContrato.setText("");
        lblHorarioContrato.setText("");
        dtpFechaInicioContrato.setDate(new Date());
        dtpFechaFinContrato.setDate(new Date());
        txtTrabajdorContrato.setText("");
        cboEmpresaContrato.requestFocus();

    }

    private void cargarLocales(int int_idEmpresa) {
        listaLocales = PaqueteBusinessDelegate.getContratoService().buscarLocal(int_idEmpresa);


        cboLocal.removeAllItems();
        Object objTitle = ".::Seleccione una Local::.";

        cboLocal.addItem(objTitle);
//        try {

        Object item;
        for (Local local : listaLocales) {
            item = local.getStr_direccion();
            cboLocal.addItem(item);
        }
//        } catch (SQLException ex) {
//            log.error("Error al cargar empresas: "+ ex.getMessage());
//        }
    }
}
