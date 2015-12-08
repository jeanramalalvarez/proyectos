/*
 * PanelCargarHorario.java
 *
 * Created on 25-abr-2012, 21:47:54
 */
package com.gestionmatriz.recursoshumanos.gui;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornada;
import com.gestionmatriz.recursoshumanos.bean.Horarios;
import com.gestionmatriz.recursoshumanos.bean.Jornada;
import com.gestionmatriz.recursoshumanos.opciones.Opciones;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.ToggleSelectionModel;
import com.gestionmatriz.util.Util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author zholo
 */
public class PanelCargarHorario extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(PanelCargarHorario.class);
	private Contrato frmContrato;
    private int idContrato;
    private String persona;

    public PanelCargarHorario(Principal gui, JXPanel pnlCrearHorario, Horario jdVentanilla, Contrato frmContrato, int idContrato, String persona) {
        this.gui = gui;
        this.pnlCrearHorario = pnlCrearHorario;
        this.jdVentanilla = jdVentanilla;
        this.frmContrato = frmContrato;
        this.idContrato = idContrato;
        this.persona = persona;
        initComponents();
        inicializarModel();
        cargarHorarioJornada();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        btnCargarHorario = new org.jdesktop.swingx.JXButton();
        btnCrearHorario = new org.jdesktop.swingx.JXButton();
        btnSalir = new org.jdesktop.swingx.JXButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Cargar Horario"));
        setLayout(null);

        lstLunes.setBorder(javax.swing.BorderFactory.createTitledBorder("LUNES"));
        lstLunes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstLunes.setToolTipText("Lunes");
        lstLunes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(lstLunes);
        lstLunes.setSelectionModel(new ToggleSelectionModel());

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 30, 80, 170);

        lstMartes.setBorder(javax.swing.BorderFactory.createTitledBorder("MARTES"));
        lstMartes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(lstMartes);
        lstMartes.setSelectionModel(new ToggleSelectionModel());

        add(jScrollPane2);
        jScrollPane2.setBounds(100, 30, 80, 170);

        lstMiercoles.setBorder(javax.swing.BorderFactory.createTitledBorder("MIERCOLES"));
        lstMiercoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(lstMiercoles);
        lstMiercoles.setSelectionModel(new ToggleSelectionModel());

        add(jScrollPane3);
        jScrollPane3.setBounds(190, 30, 80, 170);

        lstJueves.setBorder(javax.swing.BorderFactory.createTitledBorder("JUEVES"));
        lstJueves.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane4.setViewportView(lstJueves);
        lstJueves.setSelectionModel(new ToggleSelectionModel());

        add(jScrollPane4);
        jScrollPane4.setBounds(280, 30, 80, 170);

        lstViernes.setBorder(javax.swing.BorderFactory.createTitledBorder("VIERNES"));
        lstViernes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane5.setViewportView(lstViernes);
        lstViernes.setSelectionModel(new ToggleSelectionModel());

        add(jScrollPane5);
        jScrollPane5.setBounds(370, 30, 80, 170);

        lstSabado.setBorder(javax.swing.BorderFactory.createTitledBorder("SABADOS"));
        lstSabado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane6.setViewportView(lstSabado);
        lstSabado.setSelectionModel(new ToggleSelectionModel());

        add(jScrollPane6);
        jScrollPane6.setBounds(460, 30, 80, 170);

        lstDomingo.setBorder(javax.swing.BorderFactory.createTitledBorder("DOMINGO"));
        lstDomingo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane7.setViewportView(lstDomingo);
        lstDomingo.setSelectionModel(new ToggleSelectionModel());

        add(jScrollPane7);
        jScrollPane7.setBounds(550, 30, 80, 170);

        btnCargarHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/horasistema.png"))); // NOI18N
        btnCargarHorario.setText("Asignar Horario");
        btnCargarHorario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCargarHorario.setPreferredSize(new java.awt.Dimension(131, 23));
        btnCargarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarHorarioActionPerformed(evt);
            }
        });
        add(btnCargarHorario);
        btnCargarHorario.setBounds(160, 210, 150, 23);

        btnCrearHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/crearhorarioh.png"))); // NOI18N
        btnCrearHorario.setText("Crear Horario");
        btnCrearHorario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearHorario.setMaximumSize(new java.awt.Dimension(121, 23));
        btnCrearHorario.setPreferredSize(new java.awt.Dimension(121, 23));
        btnCrearHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearHorarioActionPerformed(evt);
            }
        });
        add(btnCrearHorario);
        btnCrearHorario.setBounds(320, 210, 150, 23);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/salirmini.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setPreferredSize(new java.awt.Dimension(77, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        add(btnSalir);
        btnSalir.setBounds(480, 210, 150, 23);
    }// </editor-fold>//GEN-END:initComponents

private void btnCargarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarHorarioActionPerformed
    if (lstLunes.isSelectionEmpty() && lstMartes.isSelectionEmpty() && lstMiercoles.isSelectionEmpty()
            && lstJueves.isSelectionEmpty() && lstViernes.isSelectionEmpty() && lstSabado.isSelectionEmpty()
            && lstDomingo.isSelectionEmpty()) {
        Mensaje.mensaje(this, "Debe Seleccionar al Menos un Horario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    if (idContrato == 0) {
        cargarHorario();
        frmContrato.setLblHorarioContrato("Horario Pre Cargado.....");
    } else {
        btnCargarHorario.setText("Modificar Horario");
        cargarHorario();

        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getGENERARCONTRATO())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }

        String usuarioModificador = gui.getBarraEstado().getUsuario();

        if (PaqueteBusinessDelegate.getContratoService().modificarHorarioPersona(idContrato, listaHorarioJornada, usuarioModificador)) {
            Mensaje.mensaje(this, "Se registro con éxito el contrato para: " + persona, Mensaje.TITULO_ME, Mensaje.INFORMACION);
        } else {
            Mensaje.mensaje(this, "No se pudo modificar el horario",Mensaje.TITULO_ME, Mensaje.ERROR);
        }
    }

    jdVentanilla.setVisible(false);
}//GEN-LAST:event_btnCargarHorarioActionPerformed

private void btnCrearHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearHorarioActionPerformed
    setVisiblePanel(false);
    pnlCrearHorario.setVisible(true);
    jdVentanilla.setSize(652, 420);
}//GEN-LAST:event_btnCrearHorarioActionPerformed

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    jdVentanilla.setVisible(false);
}//GEN-LAST:event_btnSalirActionPerformed

    public void setVisiblePanel(boolean b) {
        this.setVisible(b);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnCargarHorario;
    private org.jdesktop.swingx.JXButton btnCrearHorario;
    private org.jdesktop.swingx.JXButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private org.jdesktop.swingx.JXList lstDomingo;
    private org.jdesktop.swingx.JXList lstJueves;
    private javax.swing.JList lstLunes;
    private org.jdesktop.swingx.JXList lstMartes;
    private org.jdesktop.swingx.JXList lstMiercoles;
    private org.jdesktop.swingx.JXList lstSabado;
    private org.jdesktop.swingx.JXList lstViernes;
    // End of variables declaration//GEN-END:variables
    private Principal gui;
    private JXPanel pnlCrearHorario;
    private Horario jdVentanilla;
    private List<HorarioJornada> listaHorarioJornada;
    private DefaultListModel[] model = new DefaultListModel[7];
    private List<Horarios> listaHorarioLunes = new ArrayList<>();
    private List<Horarios> listaHorarioMartes = new ArrayList<>();
    private List<Horarios> listaHorarioMiercoles = new ArrayList<>();
    private List<Horarios> listaHorarioJueves = new ArrayList<>();
    private List<Horarios> listaHorarioViernes = new ArrayList<>();
    private List<Horarios> listaHorarioSabado = new ArrayList<>();
    private List<Horarios> listaHorarioDomingo = new ArrayList<>();
    private List<Jornada> listaJornadaLunes = new ArrayList<>();
    private List<Jornada> listaJornadaMartes = new ArrayList<>();
    private List<Jornada> listaJornadaMiercoles = new ArrayList<>();
    private List<Jornada> listaJornadaJueves = new ArrayList<>();
    private List<Jornada> listaJornadaViernes = new ArrayList<>();
    private List<Jornada> listaJornadaSabado = new ArrayList<>();
    private List<Jornada> listaJornadaDomingo = new ArrayList<>();

    private void inicializarModel() {
        for (int i = 0; i < 7; i++) {
            model[i] = new DefaultListModel();
        }
    }

    public void cargarHorarioJornada() {
        try {
            listaHorarioJornada = PaqueteBusinessDelegate.getHorarioService().
                    listarHorarioJornada(Util.ACTIVO);

            JList[] listaList = {
                lstLunes,
                lstMartes,
                lstMiercoles,
                lstJueves,
                lstViernes,
                lstSabado,
                lstDomingo};
            cargarListas(listaList, listaHorarioJornada);
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        }
    }

    private void cargarListas(JList[] listaList, List<HorarioJornada> listaHorarioJornada) {
        inicializarModel();
        for (HorarioJornada hj : listaHorarioJornada) {
            if (hj.getObjHorario().getStr_nombreHorario().equalsIgnoreCase(Util.LUNES)) {
                cargarDatosList(listaList[0], hj.getObjJornada(), 0);
                listaHorarioLunes.add(hj.getObjHorario());
                listaJornadaLunes.add(hj.getObjJornada());
            } else if (hj.getObjHorario().getStr_nombreHorario().equalsIgnoreCase(Util.MARTES)) {
                cargarDatosList(listaList[1], hj.getObjJornada(), 1);
                listaHorarioMartes.add(hj.getObjHorario());
                listaJornadaMartes.add(hj.getObjJornada());
            } else if (hj.getObjHorario().getStr_nombreHorario().equalsIgnoreCase(Util.MIERCOLES)) {
                cargarDatosList(listaList[2], hj.getObjJornada(), 2);
                listaHorarioMiercoles.add(hj.getObjHorario());
                listaJornadaMiercoles.add(hj.getObjJornada());
            } else if (hj.getObjHorario().getStr_nombreHorario().equalsIgnoreCase(Util.JUEVES)) {
                cargarDatosList(listaList[3], hj.getObjJornada(), 3);
                listaHorarioJueves.add(hj.getObjHorario());
                listaJornadaJueves.add(hj.getObjJornada());
            } else if (hj.getObjHorario().getStr_nombreHorario().equalsIgnoreCase(Util.VIERNES)) {
                cargarDatosList(listaList[4], hj.getObjJornada(), 4);
                listaHorarioViernes.add(hj.getObjHorario());
                listaJornadaViernes.add(hj.getObjJornada());
            } else if (hj.getObjHorario().getStr_nombreHorario().equalsIgnoreCase(Util.SABADO)) {
                cargarDatosList(listaList[5], hj.getObjJornada(), 5);
                listaHorarioSabado.add(hj.getObjHorario());
                listaJornadaSabado.add(hj.getObjJornada());
            } else if (hj.getObjHorario().getStr_nombreHorario().equalsIgnoreCase(Util.DOMINGO)) {
                cargarDatosList(listaList[6], hj.getObjJornada(), 6);
                listaHorarioDomingo.add(hj.getObjHorario());
                listaJornadaDomingo.add(hj.getObjJornada());
            }
        }
    }

    private void cargarDatosList(JList lst, Jornada j, int indiceModel) {
        model[indiceModel].addElement(j.getTme_HoraInicio()
                + "-" + j.getTme_horaFin());
        lst.setModel(model[indiceModel]);
    }

    private void cargarHorario() {
        listaHorarioJornada = new ArrayList<>();
        HorarioJornada objHJ;

        //Dia Lunes
        if (!listaHorarioLunes.isEmpty()) {
            for (int i = 0; i < lstLunes.getModel().getSize(); i++) {
                objHJ = new HorarioJornada();
                if (lstLunes.isSelectedIndex(i)) {
                    objHJ.setObjJornada(listaJornadaLunes.get(i));
                    objHJ.setObjHorario(listaHorarioLunes.get(i));
                    listaHorarioJornada.add(objHJ);
                }
            }
        }

        //Dia Martes
        if (!listaHorarioMartes.isEmpty()) {
            for (int i = 0; i < lstMartes.getModel().getSize(); i++) {
                objHJ = new HorarioJornada();
                if (lstMartes.isSelectedIndex(i)) {
                    objHJ.setObjJornada(listaJornadaMartes.get(i));
                    objHJ.setObjHorario(listaHorarioMartes.get(i));
                    listaHorarioJornada.add(objHJ);
                }
            }
        }

        //Dia MIercoles
        if (!listaHorarioMartes.isEmpty()) {
            for (int i = 0; i < lstMiercoles.getModel().getSize(); i++) {
                objHJ = new HorarioJornada();
                if (lstMiercoles.isSelectedIndex(i)) {
                    objHJ.setObjJornada(listaJornadaMiercoles.get(i));
                    objHJ.setObjHorario(listaHorarioMiercoles.get(i));
                    listaHorarioJornada.add(objHJ);
                }
            }
        }

        //Dia Jueves
        if (!listaHorarioJueves.isEmpty()) {
            for (int i = 0; i < lstJueves.getModel().getSize(); i++) {
                objHJ = new HorarioJornada();
                if (lstJueves.isSelectedIndex(i)) {
                    objHJ.setObjJornada(listaJornadaJueves.get(i));
                    objHJ.setObjHorario(listaHorarioJueves.get(i));
                    listaHorarioJornada.add(objHJ);
                }
            }
        }

        //Dia Viernes
        if (!listaHorarioViernes.isEmpty()) {
            for (int i = 0; i < lstViernes.getModel().getSize(); i++) {
                objHJ = new HorarioJornada();
                if (lstViernes.isSelectedIndex(i)) {
                    objHJ.setObjJornada(listaJornadaViernes.get(i));
                    objHJ.setObjHorario(listaHorarioViernes.get(i));
                    listaHorarioJornada.add(objHJ);
                }
            }
        }

        //Dia Sabado
        if (!listaHorarioSabado.isEmpty()) {
            for (int i = 0; i < lstSabado.getModel().getSize(); i++) {
                objHJ = new HorarioJornada();
                if (lstSabado.isSelectedIndex(i)) {
                    objHJ.setObjJornada(listaJornadaSabado.get(i));
                    objHJ.setObjHorario(listaHorarioSabado.get(i));
                    listaHorarioJornada.add(objHJ);
                }
            }
        }

        //Dia Domingo
        if (!listaHorarioDomingo.isEmpty()) {
            for (int i = 0; i < lstDomingo.getModel().getSize(); i++) {
                objHJ = new HorarioJornada();
                if (lstDomingo.isSelectedIndex(i)) {
                    objHJ.setObjJornada(listaJornadaDomingo.get(i));
                    objHJ.setObjHorario(listaHorarioDomingo.get(i));
                    listaHorarioJornada.add(objHJ);
                }
            }
        }

//        return listaHorarioJornada;
//        for (HorarioJornada horarioJornada : listaHorarioJornada) {
//
//            System.out.println("Horario: "+horarioJornada.getObjHorario().getInt_idHorario());
//            System.out.println("Jornada: "+horarioJornada.getObjJornada().getInt_idJornada());
//            System.out.println("=================================================");
//        }
        jdVentanilla.setListaHorarioJOrnada(listaHorarioJornada);
    }

    public List<HorarioJornada> getListaHorarioJornada() {
        return listaHorarioJornada;
    }
}
