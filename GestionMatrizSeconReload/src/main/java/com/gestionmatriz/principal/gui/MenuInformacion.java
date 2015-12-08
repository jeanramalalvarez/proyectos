/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.principal.gui;

import com.gestionmatriz.recursoshumanos.gui.*;
import com.gestionmatriz.util.Util;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;

/**
 *
 * @author zholo
 */
public class MenuInformacion extends JMenu {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JMenuItem mniGestionAsistencia;
    private javax.swing.JMenuItem mniGestionFaltas;
    private javax.swing.JMenuItem mniGestionContrato;
    private javax.swing.JMenuItem mniGestionPersonal;    
    private javax.swing.JMenuItem mniGestionMemorandum;
    private javax.swing.JMenuItem mniReportesPersonas;
    private javax.swing.JMenuItem mniReportesFechas;    
    private javax.swing.JMenu mnuAsistencia;
    private javax.swing.JMenu mnuContratos;
    private javax.swing.JMenu mnuPersonal;    
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenu mnuMemorandum;
    //Atributos para el trabajo con la GUI Principal
    private Principal gui;
    private Personal frmPersonal;
    private Contrato frmContrato;
    private Asistencia frmAsistencia;
    private Memorandum frmMemorandum;
    private ReportePersona frmReportePersona;
    private ReporteFechas frmReporteFechas;
    private Justificar frmJustificar;
    //Atributos para el trabajo con la GUI Principal
    //Manejo de Hilos
    Thread objThr;
    
    public MenuInformacion(Principal gui) {
        
        this.gui = gui;
        
        this.setText("Recursos Humanos");
        this.setForeground(new Color(127, 11, 30));
        this.setFont(new java.awt.Font("", 1, 13));        
        
        
        mniGestionAsistencia = new javax.swing.JMenuItem();
        mnuPersonal = new javax.swing.JMenu();
        mniGestionPersonal = new javax.swing.JMenuItem();        
        mnuContratos = new javax.swing.JMenu();
        mniGestionContrato = new javax.swing.JMenuItem();        
        mnuAsistencia = new javax.swing.JMenu();        
        mnuReportes = new javax.swing.JMenu();
        mnuMemorandum = new javax.swing.JMenu();
        mniGestionMemorandum = new javax.swing.JMenuItem();
        mniReportesPersonas = new javax.swing.JMenuItem();
        mniReportesFechas = new javax.swing.JMenuItem();
        mniGestionFaltas = new javax.swing.JMenuItem();
        
        mnuPersonal.setText("Personal");
        mnuPersonal.setForeground(new Color(127, 11, 30));
        mnuPersonal.setFont(new java.awt.Font("", 0, 13));        
        
        
        mniGestionPersonal.setText("Gestionar Personal");
        mniGestionPersonal.setForeground(new Color(127, 11, 30));
        mniGestionPersonal.setFont(new java.awt.Font("", 0, 13));        
        mniGestionPersonal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));        
        mniGestionPersonal.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGestionPersonalActionPerformed(evt);
            }            
        });
        mnuPersonal.add(mniGestionPersonal);
        
        this.add(mnuPersonal);
        
        mnuContratos.setText("Contratos");
        mnuContratos.setForeground(new Color(127, 11, 30));
        mnuContratos.setFont(new java.awt.Font("", 0, 13));
        
        mniGestionContrato.setText("Gestionar Contratos");
        mniGestionContrato.setForeground(new Color(127, 11, 30));
        mniGestionContrato.setFont(new java.awt.Font("", 0, 13));
        mniGestionContrato.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));        
        mniGestionContrato.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGestionContratoActionPerformed(evt);
            }            
        });
        mnuContratos.add(mniGestionContrato);
        
        this.add(mnuContratos);
        
        mnuAsistencia.setText("Asistencia");
        mnuAsistencia.setForeground(new Color(127, 11, 30));
        mnuAsistencia.setFont(new java.awt.Font("", 0, 13));
        
        mniGestionAsistencia.setText("Gestionar Asistencia");
        mniGestionAsistencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mniGestionAsistencia.setForeground(new Color(127, 11, 30));
        mniGestionAsistencia.setFont(new java.awt.Font("", 0, 13));        
        mniGestionAsistencia.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGestionAsistenciaActionPerformed(evt);
            }            
        });
        
        mnuAsistencia.add(mniGestionAsistencia);        
        
        
        mniGestionFaltas.setText("Gestión Faltas");
        mniGestionFaltas.setForeground(new Color(127, 11, 30));
        mniGestionFaltas.setFont(new java.awt.Font("", 0, 13));        
        
        mniGestionFaltas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mniGestionFaltas.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGestionFaltasActionPerformed(evt);
            }
        });
        
        mnuAsistencia.add(mniGestionFaltas);
        
        this.add(mnuAsistencia);
        
        
        mnuMemorandum.setText("Memorandum");
        mnuMemorandum.setForeground(new Color(127, 11, 30));
        mnuMemorandum.setFont(new java.awt.Font("", 0, 13));        
        
        
        mniGestionMemorandum.setText("Gestionar Memorandum");
        mniGestionMemorandum.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        mniGestionMemorandum.setForeground(new Color(127, 11, 30));
        mniGestionMemorandum.setFont(new java.awt.Font("", 0, 13));        
        mniGestionMemorandum.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGestionMemorandumActionPerformed(evt);
            }
        });
        mnuMemorandum.add(mniGestionMemorandum);
        
        this.add(mnuMemorandum);
        
        
        
        mnuReportes.setText("Reportes");
        //mnuReportes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mnuReportes.setForeground(new Color(127, 11, 30));
        mnuReportes.setFont(new java.awt.Font("", 0, 13));        
        
        mniReportesPersonas.setText("Reporte Personal");
        mniReportesPersonas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mniReportesPersonas.setForeground(new Color(127, 11, 30));
        mniReportesPersonas.setFont(new java.awt.Font("", 0, 13));        
        mniReportesPersonas.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniReportesPersonasActionPerformed(evt);
            }            
        });
        mnuReportes.add(mniReportesPersonas);
        
        mniReportesFechas.setText("Reporte por Fechas");
        mniReportesFechas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mniReportesFechas.setForeground(new Color(127, 11, 30));
        mniReportesFechas.setFont(new java.awt.Font("", 0, 13));        
        mniReportesFechas.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniReportesFechasActionPerformed(evt);
            }            
        });
        
        mnuReportes.add(mniReportesFechas);
        this.add(mnuReportes);
        
        
        setIconMenu();
    }
    
    private void mniGestionPersonalActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmPersonal == null || frmPersonal.isClosed()) {
            frmPersonal = new Personal(gui);
            frmPersonal.setVisible(true);
            gui.addFrm(frmPersonal);
            gui.enforcar(frmPersonal);
            gui.getBarraEstado().nuevaVentanas();
            com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmPersonal);
        }
        Util.maximizarInternal(frmPersonal);
        Util.hiloProgressBar(0, gui);
    }
    
    private void mniGestionContratoActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmContrato == null || frmContrato.isClosed()) {
            frmContrato = new Contrato(gui);
            frmContrato.setVisible(true);
            gui.addFrm(frmContrato);
            gui.enforcar(frmContrato);
            gui.getBarraEstado().nuevaVentanas();
            com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmContrato);
            
        }
        Util.maximizarInternal(frmContrato);
        Util.hiloProgressBar(0, gui);
    }
    
    private void mniGestionAsistenciaActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmAsistencia == null || frmAsistencia.isClosed()) {
            frmAsistencia = new Asistencia(gui);
            frmAsistencia.setVisible(true);
            gui.addFrm(frmAsistencia);
            gui.enforcar(frmAsistencia);
            gui.getBarraEstado().nuevaVentanas();
            com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmAsistencia);
//        frmAsistencia.setSize(678, 436);
        }
        Util.hiloProgressBar(0, gui);
    }
    
    private void mniGestionMemorandumActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmMemorandum == null || frmMemorandum.isClosed()) {
            frmMemorandum = new Memorandum(gui);
            frmMemorandum.setVisible(true);
            gui.addFrm(frmMemorandum);
            gui.enforcar(frmMemorandum);
            gui.getBarraEstado().nuevaVentanas();
            com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmMemorandum);
//            frmMemorandum.setLocation(frmMemorandum.getWidth(), frmMemorandum.getHeight()+10);
//        frmAsistencia.setSize(678, 436);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniReportesPersonasActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmReportePersona == null || frmReportePersona.isClosed()) {
            frmReportePersona = new ReportePersona(gui);
            frmReportePersona.setVisible(true);
            gui.addFrm(frmReportePersona);
            gui.enforcar(frmReportePersona);
            gui.getBarraEstado().nuevaVentanas();
            com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmReportePersona);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniReportesFechasActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmReporteFechas == null || frmReporteFechas.isClosed()) {
            frmReporteFechas = new ReporteFechas(gui);
            frmReporteFechas.setVisible(true);
            gui.addFrm(frmReporteFechas);
            gui.enforcar(frmReporteFechas);
            gui.getBarraEstado().nuevaVentanas();
            com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmReporteFechas);
        }
        Util.hiloProgressBar(0, gui);
    }
    
    private void mniGestionFaltasActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmJustificar == null || frmJustificar.isClosed()) {
            frmJustificar = new Justificar(gui);
            frmJustificar.setVisible(true);
            gui.addFrm(frmJustificar);
            gui.enforcar(frmJustificar);
            gui.getBarraEstado().nuevaVentanas();
            com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmJustificar);
        }
        Util.maximizarInternal(frmJustificar);
        Util.hiloProgressBar(0, gui);
    }
    
    private void setIconMenu() {
        mnuPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/personal.png")));
        mniGestionPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mnuContratos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/contratos.png")));
        mniGestionContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));        
        mnuAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/asistencia.png")));
        mniGestionAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniGestionFaltas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mnuMemorandum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/memorandum.png")));        
        mniGestionMemorandum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mnuReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/reportes.png")));
        mniReportesPersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniReportesFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/recurhumanos.png")));
    }
}
