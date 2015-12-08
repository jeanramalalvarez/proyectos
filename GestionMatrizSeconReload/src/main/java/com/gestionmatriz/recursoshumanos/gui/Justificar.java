/*
 * Justificar.java
 *
 * Created on 23-may-2012, 13:44:52
 */
package com.gestionmatriz.recursoshumanos.gui;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import com.gestionmatriz.recursoshumanos.bean.Asistencia;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.recursoshumanos.opciones.Opciones;
import com.gestionmatriz.reutilizable.util.Filtro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author cesareo
 */
public class Justificar extends javax.swing.JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(Justificar.class);
	private Principal gui;
    private List<Empresa> listaEmpresa;
    private List<Personal> listaPersonal;
    private List<Asistencia> listaAsistencia;
    private JustificarPorEmpleado jdJustificarPorEmpleado;

    public Justificar(Principal gui) {
        this.gui = gui;
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dtpFechaInicial = new org.jdesktop.swingx.JXDatePicker();
        dtpFechaFinal = new org.jdesktop.swingx.JXDatePicker();
        lblEmpresa = new org.jdesktop.swingx.JXLabel();
        lblPersona = new org.jdesktop.swingx.JXLabel();
        lblFechaInicial = new org.jdesktop.swingx.JXLabel();
        lblFechaFinal = new org.jdesktop.swingx.JXLabel();
        cboEmpresas = new org.jdesktop.swingx.JXComboBox();
        cboPersonas = new org.jdesktop.swingx.JXComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInasistenciaXPersona = new org.jdesktop.swingx.JXTable();
        btnBuscar = new org.jdesktop.swingx.JXButton();
        btnJustificar = new org.jdesktop.swingx.JXButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("JUSTIFICAR INASISTENCIAS PERSONAL");
        setName(""); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblEmpresa.setText("Empresa");

        lblPersona.setText("Empleado");

        lblFechaInicial.setText("Fecha inicial");

        lblFechaFinal.setText("Fecha final");

        cboEmpresas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmpresasActionPerformed(evt);
            }
        });

        cboPersonas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboEmpresas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtpFechaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dtpFechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtpFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        tblInasistenciaXPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ape paterno", "Ape materno", "Nombre", "Local", "Horario", "Fecha", "Estado", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblInasistenciaXPersona.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tblInasistenciaXPersona);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setPreferredSize(new java.awt.Dimension(89, 23));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnJustificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/justificar.png"))); // NOI18N
        btnJustificar.setText("Justificar");
        btnJustificar.setName(""); // NOI18N
        btnJustificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJustificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJustificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnJustificar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnJustificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJustificarActionPerformed
    List<Asistencia> listaAsistenciaTemp = new ArrayList<>();
    boolean check = false;
    for (int i = 0; i <= tblInasistenciaXPersona.getRowCount() - 1; i++) {
        boolean b = Boolean.parseBoolean(tblInasistenciaXPersona.getValueAt(i, 7).toString());
        if (b == true) {
            listaAsistenciaTemp.add(this.listaAsistencia.get(i));
            check = true;
        }
    }

    if (this.listaAsistencia == null || this.listaAsistencia.isEmpty()) {
        Mensaje.mensaje(this, "No se Encontro Faltas", Mensaje.TITULO_ME, Mensaje.INFORMACION);
        return;
    }

//    if (listaAsistenciaTemp == null) {
    if (check == false) {
        Mensaje.mensaje(this, "Seleccionar personas a justificar", Mensaje.TITULO_ME, Mensaje.ERROR);
    } else {
        Util.hiloProgressBar(1, gui);
        jdJustificarPorEmpleado = new JustificarPorEmpleado(gui, listaAsistenciaTemp);
        Util.hiloProgressBar(0, gui);
        jdJustificarPorEmpleado.setVisible(true);
    }
}//GEN-LAST:event_btnJustificarActionPerformed

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getADMINISTRACIONFALTAS())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    cargarFaltas();
}//GEN-LAST:event_btnBuscarActionPerformed

private void cboEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmpresasActionPerformed
    int indice = cboEmpresas.getSelectedIndex();
    if (indice >= 1) {
        listaPersonal = PaqueteBusinessDelegate.getContratoService().
                listaPersonasXEmpresa(listaEmpresa.get(indice - 1).getInt_idEmpresa());

        cboPersonas.removeAllItems();
        cboPersonas.addItem(".::Seleccione Empleado::.");
        for (Personal personal : listaPersonal) {
            cboPersonas.addItem(personal.getStr_nombres().concat(" ").concat(personal.getStr_apePaterno()).concat(" ").concat(personal.getStr_apeMaterno()));
        }
        cboPersonas.requestFocus();
    }
}//GEN-LAST:event_cboEmpresasActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscar;
    private org.jdesktop.swingx.JXButton btnJustificar;
    private org.jdesktop.swingx.JXComboBox cboEmpresas;
    private org.jdesktop.swingx.JXComboBox cboPersonas;
    private org.jdesktop.swingx.JXDatePicker dtpFechaFinal;
    private org.jdesktop.swingx.JXDatePicker dtpFechaInicial;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel lblEmpresa;
    private org.jdesktop.swingx.JXLabel lblFechaFinal;
    private org.jdesktop.swingx.JXLabel lblFechaInicial;
    private org.jdesktop.swingx.JXLabel lblPersona;
    private org.jdesktop.swingx.JXTable tblInasistenciaXPersona;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
    }

    private void cargarDatos() {
        tblInasistenciaXPersona.setSortable(false);
        cargarEmpresa();
        dtpFechaInicial.setDate(new Date());
        dtpFechaFinal.setDate(new Date());
        //cboEmpresas.setEditable(false);
        AutoCompleteDecorator.decorate(cboEmpresas);
        AutoCompleteDecorator.decorate(cboPersonas);
    }

    private void cargarEmpresa() {
        try {
            listaEmpresa = PaqueteBusinessDelegate.getContratoService().listarEmpresa();

            cboEmpresas.removeAllItems();
            cboEmpresas.addItem(".::Seleccione una Empresa::.");
            for (Empresa empresa : listaEmpresa) {
                cboEmpresas.addItem(empresa.getStr_razonSocial());
            }

        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        }
    }

    private void cargarFaltas() {
        int indexEmpresa = cboEmpresas.getSelectedIndex();
        int indexPersona = cboPersonas.getSelectedIndex();
        String fechaInicial = Util.getFecha("yyyy-MM-dd", dtpFechaInicial.getDate());
        String fechaFinal = Util.getFecha("yyyy-MM-dd", dtpFechaFinal.getDate());

        if (indexEmpresa <= 0) {
            Mensaje.mensaje(this, "Seleccionar Empresa", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        if (indexPersona <= 0) {
            Mensaje.mensaje(this, "Seleccionar Empleado", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }

        int idEmpresa = listaEmpresa.get(cboEmpresas.getSelectedIndex() - 1).getInt_idEmpresa();
        String idPersona = listaPersonal.get(cboPersonas.getSelectedIndex() - 1).getStr_codigo();

        cargarTabla(tblInasistenciaXPersona, PaqueteBusinessDelegate.getAsistenciaService().
                consultarFaltas(fechaInicial, fechaFinal, idEmpresa, idPersona));
    }

    private void cargarTabla(JXTable tabla, List lista) {
        Object[] filaTabla = new Object[8];
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        int i = 0;
        for (Object a : lista) {
            if (a instanceof Asistencia) {
                filaTabla[0] = ((Asistencia) a).getObjContrato().getObjPersona().getStr_apePaterno();
                filaTabla[1] = ((Asistencia) a).getObjContrato().getObjPersona().getStr_apeMaterno();
                filaTabla[2] = ((Asistencia) a).getObjContrato().getObjPersona().getStr_nombres();
                filaTabla[3] = ((Asistencia) a).getStr_direccion();
                filaTabla[4] = ((Asistencia) a).getStr_horario();
                filaTabla[5] = ((Asistencia) a).getStr_fechaMarcado();
                filaTabla[6] = ((Asistencia) a).getStr_estadoMarcado();
                filaTabla[7] = new Boolean(false);
                modelo.addRow(filaTabla);
            }
            i++;
        }

        tabla.setModel(modelo);
        this.listaAsistencia = lista;
    }
}
