/*
 * Horario.java
 *
 * Created on 22-abr-2012, 17:14:18
 */
package com.gestionmatriz.recursoshumanos.gui;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornada;
import com.gestionmatriz.recursoshumanos.bean.Horarios;
import com.gestionmatriz.recursoshumanos.bean.Jornada;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import com.gestionmatriz.util.ToggleSelectionModel;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;

import org.apache.log4j.Logger;

/**
 *
 * @author zholo
 */
public class Horario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(Horario.class);
    private Principal gui;
    private Contrato frmContrato;
    private int idContrato;
    private String persona;

    public Horario() {
    }

    public Horario(Frame gui1, Principal gui, Contrato frmContrato, int idContrato, String persona) {
        super(gui1, true);
        this.frmContrato = frmContrato;
        this.gui = gui;
        this.idContrato = idContrato;
        this.persona = persona;
        initComponents();
        cargarComboDia();
//        cargarComboDJornada();
        inicializarModel();
//        setearHorarioJornada();
        setLocationRelativeTo(null);
//        lstLunes.setSelectionModel(new Togg);
        cargarPanelAsignarHorario();
    }

    private void cargarPanelAsignarHorario() {
        pnlCargarHorario = new PanelCargarHorario(gui, pnlCrearHorario, this, frmContrato, idContrato, persona);
        pnlCargarHorario.setVisible(true);
        pnlHorario.add(pnlCargarHorario);
        pnlCargarHorario.setBounds(0, 0, 638, 244);
        this.setSize(640, 270);
    }

    private void cargarComboDia() {
        cboDiaHorario.removeAllItems();
        Object title = ".::Seleccione un Día::.";

        cboDiaHorario.addItem(title);
        try {
            listaHorarios = PaqueteBusinessDelegate.getHorarioService().listarHorarios();
            Object item;
            for (Horarios horarios : listaHorarios) {
                item = horarios.getStr_nombreHorario();
                cboDiaHorario.addItem(item);
            }
        } catch (SQLException ex) {
            log.error("Error al cargar Dia: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error al cargar Dia: " + ex.getMessage());
        }
    }

    private void cargarComboDJornada(int dia) {
        cboJornadasGuardadas.removeAllItems();
        Object title = ".::Seleccione una Jornada::.";

        cboJornadasGuardadas.addItem(title);
        try {
            listaJornadas = PaqueteBusinessDelegate.getHorarioService().listarJornadasDisponibles(dia);
            Object item;
            for (Jornada jornada : listaJornadas) {
                item = jornada.getTme_HoraInicio() + "-" + jornada.getTme_horaFin();
                cboJornadasGuardadas.addItem(item);
            }
        } catch (SQLException ex) {
            log.error("Error al cargar Dia: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error al cargar Dia: " + ex.getMessage());
        }
    }

//     @Override
//    public void dispose() {
////        try {
//            gui.getBarraEstado().cerraVentana();
////            setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
////            this.setClosed(true);
////        } catch (PropertyVetoException ex) {
////            log.error("Error al Intentar Cerrar Ventana Personal: "+ex.getMessage());
////        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        popapLunes = new javax.swing.JPopupMenu();
        mnuILunes = new javax.swing.JMenuItem();
        popapMartes = new javax.swing.JPopupMenu();
        mnuIMartes = new javax.swing.JMenuItem();
        popapMiercoles = new javax.swing.JPopupMenu();
        mnuIMiercoles = new javax.swing.JMenuItem();
        popapJueves = new javax.swing.JPopupMenu();
        mnuIJueves = new javax.swing.JMenuItem();
        popapViernes = new javax.swing.JPopupMenu();
        mnuIViernes = new javax.swing.JMenuItem();
        popapSabado = new javax.swing.JPopupMenu();
        mnuSabado = new javax.swing.JMenuItem();
        popapDomingo = new javax.swing.JPopupMenu();
        mnuIDomingo = new javax.swing.JMenuItem();
        pnlHorario = new org.jdesktop.swingx.JXPanel();
        pnlCrearHorario = new org.jdesktop.swingx.JXPanel();
        pnlCrearJornada = new org.jdesktop.swingx.JXPanel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        cboHoraFinJornada = new org.jdesktop.swingx.JXComboBox();
        cboMinutoInicioJornada = new org.jdesktop.swingx.JXComboBox();
        cboHoraInicioJornada = new org.jdesktop.swingx.JXComboBox();
        cboMinutoFinJornada = new org.jdesktop.swingx.JXComboBox();
        btnCrearJOrnada = new org.jdesktop.swingx.JXButton();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        cboDiaHorario = new org.jdesktop.swingx.JXComboBox();
        cboJornadasGuardadas = new org.jdesktop.swingx.JXComboBox();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstLunes = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstMartes = new org.jdesktop.swingx.JXList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstMiercoles = new org.jdesktop.swingx.JXList();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstJueves = new org.jdesktop.swingx.JXList();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstViernes = new org.jdesktop.swingx.JXList();
        jScrollPane6 = new javax.swing.JScrollPane();
        lstSabado = new org.jdesktop.swingx.JXList();
        jScrollPane7 = new javax.swing.JScrollPane();
        lstDomingo = new org.jdesktop.swingx.JXList();
        btnAgregarJornada = new org.jdesktop.swingx.JXButton();
        btnRegresar = new org.jdesktop.swingx.JXButton();

        mnuILunes.setText("Eliminar");
        mnuILunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuILunesActionPerformed(evt);
            }
        });
        popapLunes.add(mnuILunes);

        mnuIMartes.setText("Eliminar");
        mnuIMartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIMartesActionPerformed(evt);
            }
        });
        popapMartes.add(mnuIMartes);

        mnuIMiercoles.setText("Eliminar");
        mnuIMiercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIMiercolesActionPerformed(evt);
            }
        });
        popapMiercoles.add(mnuIMiercoles);

        mnuIJueves.setText("Eliminar");
        mnuIJueves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIJuevesActionPerformed(evt);
            }
        });
        popapJueves.add(mnuIJueves);

        mnuIViernes.setText("Eliminar");
        mnuIViernes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIViernesActionPerformed(evt);
            }
        });
        popapViernes.add(mnuIViernes);

        mnuSabado.setText("Eliminar");
        mnuSabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSabadoActionPerformed(evt);
            }
        });
        popapSabado.add(mnuSabado);

        mnuIDomingo.setText("Eliminar");
        mnuIDomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIDomingoActionPerformed(evt);
            }
        });
        popapDomingo.add(mnuIDomingo);

        setTitle("GESTIONAR HORARIO");
        setResizable(false);

        pnlHorario.setPreferredSize(new java.awt.Dimension(650, 375));
        pnlHorario.setLayout(null);

        pnlCrearHorario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCrearHorario.setLayout(null);

        pnlCrearJornada.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Crear Jornada de Trabajo"));
        pnlCrearJornada.setLayout(null);

        jXLabel2.setText("Hora Inicio :");
        pnlCrearJornada.add(jXLabel2);
        jXLabel2.setBounds(8, 20, 70, 20);

        jXLabel3.setText("Hora Fin :");
        pnlCrearJornada.add(jXLabel3);
        jXLabel3.setBounds(10, 50, 80, 20);

        cboHoraFinJornada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        cboHoraFinJornada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlCrearJornada.add(cboHoraFinJornada);
        cboHoraFinJornada.setBounds(80, 50, 43, 20);

        cboMinutoInicioJornada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cboMinutoInicioJornada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlCrearJornada.add(cboMinutoInicioJornada);
        cboMinutoInicioJornada.setBounds(130, 20, 43, 20);

        cboHoraInicioJornada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        cboHoraInicioJornada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlCrearJornada.add(cboHoraInicioJornada);
        cboHoraInicioJornada.setBounds(80, 20, 43, 20);

        cboMinutoFinJornada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cboMinutoFinJornada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlCrearJornada.add(cboMinutoFinJornada);
        cboMinutoFinJornada.setBounds(130, 50, 43, 20);

        btnCrearJOrnada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/crearhorarioh.png"))); // NOI18N
        btnCrearJOrnada.setText("Crear Jornada");
        btnCrearJOrnada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearJOrnada.setPreferredSize(new java.awt.Dimension(125, 23));
        btnCrearJOrnada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearJOrnadaActionPerformed(evt);
            }
        });
        pnlCrearJornada.add(btnCrearJOrnada);
        btnCrearJOrnada.setBounds(190, 50, 180, 23);

        pnlCrearHorario.add(pnlCrearJornada);
        pnlCrearJornada.setBounds(10, 10, 620, 90);

        jXLabel1.setText("Día :");
        pnlCrearHorario.add(jXLabel1);
        jXLabel1.setBounds(10, 110, 30, 20);

        cboDiaHorario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboDiaHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDiaHorarioActionPerformed(evt);
            }
        });
        pnlCrearHorario.add(cboDiaHorario);
        cboDiaHorario.setBounds(80, 110, 170, 20);

        cboJornadasGuardadas.setToolTipText("Debe seleccionar un día luego de elegir una jornada");
        cboJornadasGuardadas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboJornadasGuardadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboJornadasGuardadasActionPerformed(evt);
            }
        });
        pnlCrearHorario.add(cboJornadasGuardadas);
        cboJornadasGuardadas.setBounds(80, 140, 170, 20);

        jXLabel4.setText("Jornadas :");
        pnlCrearHorario.add(jXLabel4);
        jXLabel4.setBounds(10, 140, 60, 20);

        lstLunes.setBorder(javax.swing.BorderFactory.createTitledBorder("LUNES"));
        lstLunes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstLunes.setToolTipText("Lunes");
        lstLunes.setComponentPopupMenu(popapLunes);
        lstLunes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(lstLunes);
        lstLunes.setSelectionModel(new ToggleSelectionModel());

        pnlCrearHorario.add(jScrollPane1);
        jScrollPane1.setBounds(10, 170, 80, 170);

        lstMartes.setBorder(javax.swing.BorderFactory.createTitledBorder("MARTES"));
        lstMartes.setComponentPopupMenu(popapMartes);
        lstMartes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(lstMartes);
        lstMartes.setSelectionModel(new ToggleSelectionModel());

        pnlCrearHorario.add(jScrollPane2);
        jScrollPane2.setBounds(100, 170, 80, 170);

        lstMiercoles.setBorder(javax.swing.BorderFactory.createTitledBorder("MIERCOLES"));
        lstMiercoles.setComponentPopupMenu(popapMiercoles);
        lstMiercoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(lstMiercoles);
        lstMiercoles.setSelectionModel(new ToggleSelectionModel());

        pnlCrearHorario.add(jScrollPane3);
        jScrollPane3.setBounds(190, 170, 80, 170);

        lstJueves.setBorder(javax.swing.BorderFactory.createTitledBorder("JUEVES"));
        lstJueves.setComponentPopupMenu(popapJueves);
        lstJueves.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane4.setViewportView(lstJueves);
        lstJueves.setSelectionModel(new ToggleSelectionModel());

        pnlCrearHorario.add(jScrollPane4);
        jScrollPane4.setBounds(280, 170, 80, 170);

        lstViernes.setBorder(javax.swing.BorderFactory.createTitledBorder("VIERNES"));
        lstViernes.setComponentPopupMenu(popapViernes);
        lstViernes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane5.setViewportView(lstViernes);
        lstViernes.setSelectionModel(new ToggleSelectionModel());

        pnlCrearHorario.add(jScrollPane5);
        jScrollPane5.setBounds(370, 170, 80, 170);

        lstSabado.setBorder(javax.swing.BorderFactory.createTitledBorder("SABADOS"));
        lstSabado.setComponentPopupMenu(popapSabado);
        lstSabado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane6.setViewportView(lstSabado);
        lstSabado.setSelectionModel(new ToggleSelectionModel());

        pnlCrearHorario.add(jScrollPane6);
        jScrollPane6.setBounds(460, 170, 80, 170);

        lstDomingo.setBorder(javax.swing.BorderFactory.createTitledBorder("DOMINGO"));
        lstDomingo.setComponentPopupMenu(popapDomingo);
        lstDomingo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane7.setViewportView(lstDomingo);
        lstDomingo.setSelectionModel(new ToggleSelectionModel());

        pnlCrearHorario.add(jScrollPane7);
        jScrollPane7.setBounds(550, 170, 80, 170);

        btnAgregarJornada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/horasistema.png"))); // NOI18N
        btnAgregarJornada.setText("Guardar Horario");
        btnAgregarJornada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarJornada.setPreferredSize(new java.awt.Dimension(133, 23));
        btnAgregarJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarJornadaActionPerformed(evt);
            }
        });
        pnlCrearHorario.add(btnAgregarJornada);
        btnAgregarJornada.setBounds(430, 140, 195, 23);

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/regresar.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        pnlCrearHorario.add(btnRegresar);
        btnRegresar.setBounds(459, 350, 170, 23);

        pnlHorario.add(pnlCrearHorario);
        pnlCrearHorario.setBounds(0, 0, 650, 380);
        pnlCrearHorario.setVisible(false);

        getContentPane().add(pnlHorario, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cboDiaHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDiaHorarioActionPerformed


    if (cboDiaHorario.getSelectedIndex() != 0) {
//        if(cboDiaHorario.getSelectedIndex()==1){           
//            model[0].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            System.out.println("indice :"+ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1).getTme_HoraInicio());
//            ListaLunes.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstLunes.setModel(model[0]);          
//            cboDiaHorario.setSelectedIndex(0);
        //Retornamos el Id de Horario
        int int_dia =
                listaHorarios.get(cboDiaHorario.getSelectedIndex() - 1).getInt_idHorario();


        cargarComboDJornada(int_dia);





//            
//        }
//        if(cboDiaHorario.getSelectedIndex()==2){           
//            model[1].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            ListaMartes.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstMartes.setModel(model[1]);          
//            cboDiaHorario.setSelectedIndex(0);
//        }
//        if(cboDiaHorario.getSelectedIndex()==3){           
//            model[2].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            ListaMiercoles.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstMiercoles.setModel(model[2]);          
//            cboDiaHorario.setSelectedIndex(0);
//        }
//        if(cboDiaHorario.getSelectedIndex()==4){           
//            model[3].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            ListaJueves.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstJueves.setModel(model[3]);          
//            cboDiaHorario.setSelectedIndex(0);
//        }
//        if(cboDiaHorario.getSelectedIndex()==5){           
//            model[4].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            ListaViernes.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstViernes.setModel(model[4]);          
//            cboDiaHorario.setSelectedIndex(0);
//        }
//        if(cboDiaHorario.getSelectedIndex()==6){           
//            model[5].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            ListaSabado.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstSabado.setModel(model[5]);          
//            cboDiaHorario.setSelectedIndex(0);
//        }
//        if(cboDiaHorario.getSelectedIndex()==7){           
//            model[6].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            ListaDomingo.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstDomingo.setModel(model[6]);          
//            cboDiaHorario.setSelectedIndex(0);
//        }        
    }

}//GEN-LAST:event_cboDiaHorarioActionPerformed

    public void quitarJornadaDia() {
    }
private void btnAgregarJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarJornadaActionPerformed

    setearDatosGuardarHorario();
    pnlCargarHorario.cargarHorarioJornada();

//            com.gestionmatriz.recursoshumanos.bean.HorarioJornada objHorarioJornada= new
//                    com.gestionmatriz.recursoshumanos.bean.HorarioJornada();
//             
//            listaHorarioJornadas=new ArrayList<HorarioJornada>();
//            
//            
//            if(listaLunes.isEmpty()==false){
//                for (int i = 0; i < listaLunes.size(); i++) {             
//                   int idJornada= listaLunes.get(i).getInt_idJornada();                        
//                   setearDatosGuardarHorario(1, idJornada, objHorarioJornada, listaLunes);                                   
//                } 
//            }
//            if(listaMartes.isEmpty()==false){
//                for (int i = 0; i < listaMartes.size(); i++) {                    
//                   int idJornada= listaMartes.get(i).getInt_idJornada();                
//                   setearDatosGuardarHorario(2, idJornada, objHorarioJornada, listaMartes);
//                } 
//            }
//            if(listaMiercoles.isEmpty()==false){
//                for (int i = 0; i < listaMiercoles.size(); i++) {                    
//                   int idJornada= listaMiercoles.get(i).getInt_idJornada();                
//                   setearDatosGuardarHorario(3, idJornada, objHorarioJornada, listaMiercoles);
//                } 
//            }
//            if(listaJueves.isEmpty()==false){
//                for (int i = 0; i < listaMiercoles.size(); i++) {                    
//                   int idJornada= listaMiercoles.get(i).getInt_idJornada();                
//                   setearDatosGuardarHorario(4, idJornada, objHorarioJornada, listaMiercoles);
//                } 
//            }
//            if(listaViernes.isEmpty()==false){
//                for (int i = 0; i < listaViernes.size(); i++) {                    
//                   int idJornada= listaViernes.get(i).getInt_idJornada();                
//                   setearDatosGuardarHorario(5, idJornada, objHorarioJornada, listaViernes);
//                } 
//            }
//            if(listaSabado.isEmpty()==false){
//                for (int i = 0; i < listaSabado.size(); i++) {                    
//                   int idJornada= listaSabado.get(i).getInt_idJornada();                
//                   setearDatosGuardarHorario(6, idJornada, objHorarioJornada, listaSabado);
//                } 
//            }
//            if(listaDomingo.isEmpty()==false){
//                for (int i = 0; i < listaDomingo.size(); i++) {                    
//                   int idJornada= listaDomingo.get(i).getInt_idJornada();                
//                   setearDatosGuardarHorario(7, idJornada, objHorarioJornada, listaDomingo);
//                } 
//            }

}//GEN-LAST:event_btnAgregarJornadaActionPerformed

private void cboJornadasGuardadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboJornadasGuardadasActionPerformed
    if (cboJornadasGuardadas.isFocusable()) {
        JList objLista[] = {lstLunes, lstMartes, lstMiercoles, lstJueves, lstViernes, lstSabado, lstDomingo};
        List[] objListaDias = {listaLunes, listaMartes, listaMiercoles, listaJueves, listaViernes, listaSabado, listaDomingo};
        int dia = cboDiaHorario.getSelectedIndex();

        if (cboJornadasGuardadas.getSelectedIndex() <= 0) {
            return;
        }

        if (!validarExisteJornadaDia(objListaDias, dia) && cboJornadasGuardadas.getSelectedIndex() > 0) {
            Mensaje.mensaje(this, "Usted ya cuenta con una jornada igual para el dia seleccionado",
                    Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        cargarJornadaListaDia(dia, objLista, objListaDias);
//    cboDiaHorario.requestFocus();
    }



}//GEN-LAST:event_cboJornadasGuardadasActionPerformed

//Evento Eliminar del Popap
private void mnuILunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuILunesActionPerformed

    eliminarJornada(lstLunes, 0, listaLunes);

}//GEN-LAST:event_mnuILunesActionPerformed

private void mnuIMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIMartesActionPerformed
    // TODO add your handling code here:
    eliminarJornada(lstMartes, 1, listaMartes);
}//GEN-LAST:event_mnuIMartesActionPerformed

private void mnuIMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIMiercolesActionPerformed

    eliminarJornada(lstMiercoles, 2, listaMiercoles);
}//GEN-LAST:event_mnuIMiercolesActionPerformed

private void mnuIJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIJuevesActionPerformed
// TODO add your handling code here:
    eliminarJornada(lstJueves, 3, listaJueves);
}//GEN-LAST:event_mnuIJuevesActionPerformed

private void mnuIViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIViernesActionPerformed
// TODO add your handling code here:
    eliminarJornada(lstViernes, 4, listaViernes);
}//GEN-LAST:event_mnuIViernesActionPerformed

private void mnuSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSabadoActionPerformed
// TODO add your handling code here:
    eliminarJornada(lstSabado, 5, listaSabado);
}//GEN-LAST:event_mnuSabadoActionPerformed

private void mnuIDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIDomingoActionPerformed
// TODO add your handling code here:
    eliminarJornada(lstDomingo, 6, listaDomingo);
}//GEN-LAST:event_mnuIDomingoActionPerformed

private void btnCrearJOrnadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearJOrnadaActionPerformed
    try {
        int horaInicio = Util.stringTOint(
                cboHoraInicioJornada.getSelectedItem().toString());
        int horaFin = Util.stringTOint(cboHoraFinJornada.getSelectedItem().toString());

        if (horaInicio > horaFin) {
            Mensaje.mensaje(this, "Hora Inicio no puede ser mayor a la Hora Final",
                    Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }

        int minutoInicio = Util.stringTOint(cboMinutoInicioJornada.getSelectedItem().toString());
        int minutoFin = Util.stringTOint(cboMinutoFinJornada.getSelectedItem().toString());

        if (horaInicio == horaFin) {
            if (minutoInicio > minutoFin) {
                Mensaje.mensaje(this, "Corrija los minutos ingresados",
                        Mensaje.TITULO_ME, Mensaje.ERROR);
                return;
            }
        }

        com.gestionmatriz.recursoshumanos.bean.Jornada objJornada = new com.gestionmatriz.recursoshumanos.bean.Jornada();


        objJornada.setTme_HoraInicio(cboHoraInicioJornada.getSelectedItem().toString() + ":"
                + cboMinutoInicioJornada.getSelectedItem().toString());
        objJornada.setTme_horaFin(cboHoraFinJornada.getSelectedItem().toString() + ":"
                + cboMinutoFinJornada.getSelectedItem().toString());
        objJornada.setStr_estado(Util.ACTIVO);
        objJornada.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());


        if (PaqueteBusinessDelegate.getHorarioService().
                registrarHorario(objJornada)) {
            Mensaje.mensaje(this, "Se Registro la jornada Exitosamente",
                    Mensaje.TITULO_ME, Mensaje.INFORMACION);
//               cargarComboDJornada();
        } else {
            Mensaje.mensaje(this, "No se Pudo Registrar la jornada",
                    Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    } catch (Exception ex) {
        log.error("ERROR: "+ex.getMessage());
    }

}//GEN-LAST:event_btnCrearJOrnadaActionPerformed

private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed


    pnlCrearHorario.setVisible(false);
    pnlCargarHorario.setVisiblePanel(true);

    this.setSize(640, 270);
    frmContrato.mostrarOcultarJDialog(false);
    frmContrato.cargarFrmHorario();
}//GEN-LAST:event_btnRegresarActionPerformed

    public void eliminarJornada(JList objLista, int indiceModel, List<Jornada> diaLista) {


        Jornada objJornada = diaLista.remove(objLista.getSelectedIndex());
        model[indiceModel].remove(objLista.getSelectedIndex());
        int horario = listaHorarios.get(indiceModel).getInt_idHorario();

        for (HorarioJornada hj : listaHorarioJornadas) {
            if (hj.getInt_idHorario() == horario
                    && hj.getInt_idJornada() == objJornada.getInt_idJornada()) {
                listaHorarioJornadas.remove(hj);
                if (listaHorarioJornadas.isEmpty()) {
                    break;
                }
            }
        }
    }

    private boolean validarExisteJornadaDia(List[] objListaDias, int dia) {

        Jornada jor;
        for (Jornada j : (List<Jornada>) objListaDias[dia - 1]) {
            jor = listaJornadas.get(cboJornadasGuardadas.getSelectedIndex() - 1);
            if (j.getInt_idJornada() == jor.getInt_idJornada()) {
                return false;
            }
        }
        return true;
    }

    private void cargarJornadaListaDia(int dia, JList[] objLista, List[] objListaDias) {

        if (cboDiaHorario.getSelectedIndex() != 0 && cboJornadasGuardadas.getSelectedIndex() > 0) {
            model[dia - 1].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//          System.out.println("indice :"+ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1).getTme_HoraInicio());
            objListaDias[dia - 1].add(listaJornadas.get(cboJornadasGuardadas.getSelectedIndex() - 1));
            objLista[dia - 1].setModel(model[dia - 1]);


            HorarioJornada objHorarioJornada = new HorarioJornada();
            objHorarioJornada.setInt_idHorario(listaHorarios.get(dia - 1).getInt_idHorario());
//          System.out.println("Dia: "+listaHorarios.get(dia-1).getInt_idHorario());

            objHorarioJornada.setInt_idJornada(listaJornadas.get(cboJornadasGuardadas.getSelectedIndex() - 1).getInt_idJornada());
//          System.out.println("Jornada: "+objHorarioJornada.getInt_idJornada());

            listaHorarioJornadas.add(objHorarioJornada);
            cboJornadasGuardadas.removeAllItems();
//          cboDiaHorario.setSelectedIndex(0);

//        if(cboDiaHorario.getSelectedIndex()==1){           
//            model[0].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            System.out.println("indice :"+ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1).getTme_HoraInicio());
//            ListaLunes.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstLunes.setModel(model[0]);          
//            cboDiaHorario.setSelectedIndex(0);
//   
//   
//            
//        }
//        if(cboDiaHorario.getSelectedIndex()==2){           
//            model[1].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            ListaMartes.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstMartes.setModel(model[1]);          
//            cboDiaHorario.setSelectedIndex(0);
//        }
//        if(cboDiaHorario.getSelectedIndex()==3){           
//            model[2].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            ListaMiercoles.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstMiercoles.setModel(model[2]);          
//            cboDiaHorario.setSelectedIndex(0);
//        }
//        if(cboDiaHorario.getSelectedIndex()==4){           
//            model[3].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            ListaJueves.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstJueves.setModel(model[3]);          
//            cboDiaHorario.setSelectedIndex(0);
//        }
//        if(cboDiaHorario.getSelectedIndex()==5){           
//            model[4].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            ListaViernes.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstViernes.setModel(model[4]);          
//            cboDiaHorario.setSelectedIndex(0);
//        }
//        if(cboDiaHorario.getSelectedIndex()==6){           
//            model[5].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            ListaSabado.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstSabado.setModel(model[5]);          
//            cboDiaHorario.setSelectedIndex(0);
//        }
//        if(cboDiaHorario.getSelectedIndex()==7){           
//            model[6].addElement(cboJornadasGuardadas.getSelectedItem().toString());
//            ListaDomingo.add(ListaJornadas.get(cboJornadasGuardadas.getSelectedIndex()-1));
//            lstDomingo.setModel(model[6]);          
//            cboDiaHorario.setSelectedIndex(0);
//        }        
        }
    }

    private void setearDatosGuardarHorario(/*int idHorario,int idJornada,HorarioJornada objHorarioJornada,List lst*/) {
//                for (int i = 0; i < lst.size(); i++) {
//                    objHorarioJornada.setInt_idHorario(idHorario);
//                    objHorarioJornada.setInt_idJornada(idJornada);
//                    objHorarioJornada.setStr_estado(Util.ACTIVO);
//                    objHorarioJornada.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());
//                    objHorarioJornada.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());
//                    
//                    inserthorarioJornada(objHorarioJornada);
//                } 
        for (HorarioJornada hj : listaHorarioJornadas) {

////                    objHorarioJornada.setInt_idJornada(idJornada);
            hj.setStr_estado(Util.ACTIVO);
            hj.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());
//                        hj.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());
        }
        inserthorarioJornada();
    }

    private void inserthorarioJornada() {
        try {
            if (PaqueteBusinessDelegate.getHorarioService().
                    registrarHorarioJornada(listaHorarioJornadas)) {
                Mensaje.mensaje(this, "Se Registro el horario Exitosamente",
                        Mensaje.TITULO_ME, Mensaje.INFORMACION);
            } else {
                Mensaje.mensaje(this, "No se Pudo Registrar el horario",
                        Mensaje.TITULO_ME, Mensaje.ERROR);
            }
        } catch (Exception ex) {
        	log.error("ERROR: "+ex.getMessage());
        }


    }
//private void setearHorarioJornada(){
//    try {
//            listaHorarioJornadas=PaqueteBusinessDelegate.
//                    getHorarioService().listarHorarioJornada();
//            for (HorarioJornada horarioJornada : listaHorarioJornadas) {
//               if(horarioJornada.getInt_idHorario()==1){
//                    for (int i = 0; i < listaJornadas.size(); i++) {                       
//                        if(horarioJornada.getInt_idJornada()==listaJornadas.get(i).getInt_idJornada()){
//                            model[0].addElement(listaJornadas.get(i).getTme_HoraInicio()+
//                                    "-"+listaJornadas.get(i).getTme_horaFin());                           
//                        }               
//                    }lstLunes.setModel(model[0]);
//                }
//               if(horarioJornada.getInt_idHorario()==2){
//                    for (int i = 0; i < listaJornadas.size(); i++) {                       
//                        if(horarioJornada.getInt_idJornada()==listaJornadas.get(i).getInt_idJornada()){
//                            model[1].addElement(listaJornadas.get(i).getTme_HoraInicio()+
//                                    "-"+listaJornadas.get(i).getTme_horaFin());                           
//                        }               
//                    }lstMartes.setModel(model[1]);
//                }
//               if(horarioJornada.getInt_idHorario()==3){
//                    for (int i = 0; i < listaJornadas.size(); i++) {                       
//                        if(horarioJornada.getInt_idJornada()==listaJornadas.get(i).getInt_idJornada()){
//                            model[2].addElement(listaJornadas.get(i).getTme_HoraInicio()+
//                                    "-"+listaJornadas.get(i).getTme_horaFin());                           
//                        }               
//                    }lstMiercoles.setModel(model[2]);
//                }
//               if(horarioJornada.getInt_idHorario()==4){
//                    for (int i = 0; i < listaJornadas.size(); i++) {                       
//                        if(horarioJornada.getInt_idJornada()==listaJornadas.get(i).getInt_idJornada()){
//                            model[3].addElement(listaJornadas.get(i).getTme_HoraInicio()+
//                                    "-"+listaJornadas.get(i).getTme_horaFin());                           
//                        }               
//                    }lstJueves.setModel(model[3]);
//                }
//               if(horarioJornada.getInt_idHorario()==5){
//                    for (int i = 0; i < listaJornadas.size(); i++) {                       
//                        if(horarioJornada.getInt_idJornada()==listaJornadas.get(i).getInt_idJornada()){
//                            model[4].addElement(listaJornadas.get(i).getTme_HoraInicio()+
//                                    "-"+listaJornadas.get(i).getTme_horaFin());                           
//                        }               
//                    }lstViernes.setModel(model[4]);
//                }
//               if(horarioJornada.getInt_idHorario()==6){
//                    for (int i = 0; i < listaJornadas.size(); i++) {                       
//                        if(horarioJornada.getInt_idJornada()==listaJornadas.get(i).getInt_idJornada()){
//                            model[5].addElement(listaJornadas.get(i).getTme_HoraInicio()+
//                                    "-"+listaJornadas.get(i).getTme_horaFin());                           
//                        }               
//                    }lstSabado.setModel(model[5]);
//                }
//               if(horarioJornada.getInt_idHorario()==7){
//                    for (int i = 0; i < listaJornadas.size(); i++) {                       
//                        if(horarioJornada.getInt_idJornada()==listaJornadas.get(i).getInt_idJornada()){
//                            model[6].addElement(listaJornadas.get(i).getTme_HoraInicio()+
//                                    "-"+listaJornadas.get(i).getTme_horaFin());                           
//                        }               
//                    }lstDomingo.setModel(model[6]);
//                }
//            }            
//        } catch (SQLException ex) {
//            log.error("Error al cargar Dia: "+ ex.getMessage());
//        }
//        catch(Exception ex) {
//            log.error("Error al cargar Dia: "+ ex.getMessage());
//        }
//
//    
//}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAgregarJornada;
    private org.jdesktop.swingx.JXButton btnCrearJOrnada;
    private org.jdesktop.swingx.JXButton btnRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private org.jdesktop.swingx.JXComboBox cboDiaHorario;
    private org.jdesktop.swingx.JXComboBox cboHoraFinJornada;
    private org.jdesktop.swingx.JXComboBox cboHoraInicioJornada;
    private org.jdesktop.swingx.JXComboBox cboJornadasGuardadas;
    private org.jdesktop.swingx.JXComboBox cboMinutoFinJornada;
    private org.jdesktop.swingx.JXComboBox cboMinutoInicioJornada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXList lstDomingo;
    private org.jdesktop.swingx.JXList lstJueves;
    private javax.swing.JList lstLunes;
    private org.jdesktop.swingx.JXList lstMartes;
    private org.jdesktop.swingx.JXList lstMiercoles;
    private org.jdesktop.swingx.JXList lstSabado;
    private org.jdesktop.swingx.JXList lstViernes;
    private javax.swing.JMenuItem mnuIDomingo;
    private javax.swing.JMenuItem mnuIJueves;
    private javax.swing.JMenuItem mnuILunes;
    private javax.swing.JMenuItem mnuIMartes;
    private javax.swing.JMenuItem mnuIMiercoles;
    private javax.swing.JMenuItem mnuIViernes;
    private javax.swing.JMenuItem mnuSabado;
    private org.jdesktop.swingx.JXPanel pnlCrearHorario;
    private org.jdesktop.swingx.JXPanel pnlCrearJornada;
    private org.jdesktop.swingx.JXPanel pnlHorario;
    private javax.swing.JPopupMenu popapDomingo;
    private javax.swing.JPopupMenu popapJueves;
    private javax.swing.JPopupMenu popapLunes;
    private javax.swing.JPopupMenu popapMartes;
    private javax.swing.JPopupMenu popapMiercoles;
    private javax.swing.JPopupMenu popapSabado;
    private javax.swing.JPopupMenu popapViernes;
    // End of variables declaration//GEN-END:variables
    private List<Horarios> listaHorarios;
    private List<Jornada> listaJornadas;
    private List<HorarioJornada> listaHorarioJornadas = new ArrayList<>();
    private List<HorarioJornada> listaHorarioJornadasCargar = new ArrayList<>();
    private DefaultListModel[] model = new DefaultListModel[7];
    private List<Jornada> listaLunes = new ArrayList<>();
    private List<Jornada> listaMartes = new ArrayList<>();
    private List<Jornada> listaMiercoles = new ArrayList<>();
    private List<Jornada> listaJueves = new ArrayList<>();
    private List<Jornada> listaViernes = new ArrayList<>();
    private List<Jornada> listaSabado = new ArrayList<>();
    private List<Jornada> listaDomingo = new ArrayList<>();
    private PanelCargarHorario pnlCargarHorario;

//private static int punteroComboJornada=0;
    private void inicializarModel() {
        for (int i = 0; i < 7; i++) {
            model[i] = new DefaultListModel();
        }
    }

    public List<HorarioJornada> getListaHorarioJornada() {
//    System.out.println("Tamaño: "+this.listaHorarioJornadasCargar.size());
        return this.listaHorarioJornadasCargar;
    }

    public void setListaHorarioJOrnada(List<HorarioJornada> listaHJ) {
        this.listaHorarioJornadasCargar = listaHJ;
    }
}
