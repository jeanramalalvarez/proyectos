/*
 * JustificarPorEmpleado.java
 *
 * Created on 23-may-2012, 14:32:54
 */
package com.gestionmatriz.recursoshumanos.gui;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.Asistencia;
import com.gestionmatriz.recursoshumanos.bean.JustificacioneInasistencia;
import com.gestionmatriz.recursoshumanos.opciones.Opciones;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author cesareo
 */
public class JustificarPorEmpleado extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Asistencia> listaAsistencia;
    private List<JustificacioneInasistencia> listaJustificacionEInasistencia;
    private JustificacioneInasistencia objJustificacionEInasistencia;
    private Principal gui;

    public JustificarPorEmpleado(Principal gui, List<Asistencia> listaAJustificar) {
        super(gui, true);
        this.gui = gui;
        this.listaAsistencia = listaAJustificar;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        lblNombre = new org.jdesktop.swingx.JXLabel();
        lblDNI = new org.jdesktop.swingx.JXLabel();
        txtNombre = new org.jdesktop.swingx.JXTextField();
        txtDNI = new org.jdesktop.swingx.JXTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaObservacion = new org.jdesktop.swingx.JXTextArea();
        btnAceptar = new org.jdesktop.swingx.JXButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDiasJustificar = new org.jdesktop.swingx.JXTable();

        setTitle("JUSTIFICAR POR EMPLEADO");

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblNombre.setText("Nombre:");

        lblDNI.setText("DNI:");

        txtNombre.setEditable(false);

        txtDNI.setEditable(false);

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtareaObservacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));
        txtareaObservacion.setColumns(20);
        txtareaObservacion.setRows(5);
        jScrollPane1.setViewportView(txtareaObservacion);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/aceptar.png"))); // NOI18N
        btnAceptar.setLabel("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        tblDiasJustificar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblDiasJustificar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getADMINISTRACIONFALTAS())){
        Mensaje.mensaje(this,"Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    String observacion = txtareaObservacion.getText();
    listaJustificacionEInasistencia = new ArrayList<>();

    for (int i = 0; i < listaAsistencia.size(); i++) {
        objJustificacionEInasistencia = new JustificacioneInasistencia();
        objJustificacionEInasistencia.setStr_estado(Util.ACTIVO);
        objJustificacionEInasistencia.setStr_UsuarioCreador(gui.getBarraEstado().getUsuario());
        objJustificacionEInasistencia.setInt_idAsistencia(listaAsistencia.get(i).getInt_asistencia());
        objJustificacionEInasistencia.setStr_observacion(observacion);

        listaJustificacionEInasistencia.add(objJustificacionEInasistencia);
    }

    if (PaqueteBusinessDelegate.getAsistenciaService().registrarJustificacionEInasistencia(listaJustificacionEInasistencia)) {
        Mensaje.mensaje(this, "Se registraron con éxito las justificaciones para: "
                + listaAsistencia.get(0).getObjContrato().getObjPersona().getStr_nombres() + " "
                + listaAsistencia.get(0).getObjContrato().getObjPersona().getStr_apePaterno() + " "
                + listaAsistencia.get(0).getObjContrato().getObjPersona().getStr_apeMaterno(),
                Mensaje.TITULO_ME, Mensaje.INFORMACION);
    } else {
        Mensaje.mensaje(this, "No se pudo registrar la justificación",
                Mensaje.TITULO_ME, Mensaje.ERROR);
    }
    listaAsistencia = null;
    objJustificacionEInasistencia = null;
    listaJustificacionEInasistencia = null;
    this.setVisible(false);
}//GEN-LAST:event_btnAceptarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAceptar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXLabel lblDNI;
    private org.jdesktop.swingx.JXLabel lblNombre;
    private org.jdesktop.swingx.JXTable tblDiasJustificar;
    private org.jdesktop.swingx.JXTextField txtDNI;
    private org.jdesktop.swingx.JXTextField txtNombre;
    private org.jdesktop.swingx.JXTextArea txtareaObservacion;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
        tblDiasJustificar.setSortable(false);
        
        if (listaAsistencia != null && !listaAsistencia.isEmpty()) {
            txtNombre.setText(listaAsistencia.get(0).getObjContrato().getObjPersona().getStr_nombres() + " "
                    + listaAsistencia.get(0).getObjContrato().getObjPersona().getStr_apePaterno() + " "
                    + listaAsistencia.get(0).getObjContrato().getObjPersona().getStr_apeMaterno());
            txtDNI.setText(listaAsistencia.get(0).getObjContrato().getObjPersona().getStr_dni());
        }
        
        cargarTabla(tblDiasJustificar, listaAsistencia);
        setLocationRelativeTo(null);
    }

    private void cargarTabla(JXTable tabla, List<Asistencia> lista) {
        String[] arrCabecera = {"Ape Paterno", "Ape Materno", "Nombre", "Local", "Horario", "Fecha"};
        String[][] arrData = new String[lista.size()][arrCabecera.length];

        for (int i = 0; i < lista.size(); i++) {
            arrData[i][0] = lista.get(i).getObjContrato().getObjPersona().getStr_apePaterno();
            arrData[i][1] = lista.get(i).getObjContrato().getObjPersona().getStr_apeMaterno();
            arrData[i][2] = lista.get(i).getObjContrato().getObjPersona().getStr_nombres();
            arrData[i][3] = lista.get(i).getStr_direccion();
            arrData[i][4] = lista.get(i).getStr_horario();
            arrData[i][5] = lista.get(i).getStr_fechaMarcado();
        }
        
        DefaultTableModel modelo = new DefaultTableModel(arrData, arrCabecera);
        tabla.setModel(modelo);
    }
}
