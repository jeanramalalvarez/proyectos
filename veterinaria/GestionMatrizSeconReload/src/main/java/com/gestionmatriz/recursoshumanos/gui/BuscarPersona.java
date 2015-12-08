/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuscarPersona.java
 *
 * Created on 23-abr-2012, 18:04:51
 */
package com.gestionmatriz.recursoshumanos.gui;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

/**
 *
 * @author YESM
 */
public class BuscarPersona extends JDialog {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(BuscarPersona.class); 
	private Frame gui;
    private List<com.gestionmatriz.recursoshumanos.bean.Personal> listaPersonas;
    private Personal frmPersona;
    private int puntero = -1;

    public BuscarPersona(Frame gui, List<com.gestionmatriz.recursoshumanos.bean.Personal> listaPersonas, Personal frmPersona) {
        super(gui, true);
        this.gui = gui;
        this.listaPersonas = listaPersonas;
        this.frmPersona = frmPersona;
        initComponents();

        this.setTitle(gui.getTitle() + " - Buscar Personal");
        this.setSize(575, 350);
        setLocationRelativeTo(null);
    }

    public BuscarPersona(Frame gui,
            List<com.gestionmatriz.recursoshumanos.bean.Personal> listaPersonas,
            Personal frmPersona, int puntero) {

        super(gui, true);
        this.gui = gui;
        this.listaPersonas = listaPersonas;
        this.frmPersona = frmPersona;
        this.puntero = puntero;
        initComponents();
//        cargarPanelBusquedaPersonas( listaPersonas);
        this.setTitle(gui.getTitle() + " - Crear Usuario");
        this.setSize(575, 350);
        setLocationRelativeTo(null);
    }

    public void cargarPanelBusquedaPersonas(List<com.gestionmatriz.recursoshumanos.bean.Personal> listaPersonas) {
        cargarTabla(listaPersonas);
    }

    public com.gestionmatriz.recursoshumanos.bean.Personal personaSeleccionada() {
        int indice = tbListaPersonas.getSelectedRow();
        return listaPersonas.get(indice);
    }

    private void initComponents() {

        pnlFiltro = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtNombre = new org.jdesktop.swingx.JXTextField();
        lblApellidos = new org.jdesktop.swingx.JXLabel();
        txtApellidPaternoPersona = new org.jdesktop.swingx.JXTextField();
        txtApellidoMaternoPersona = new org.jdesktop.swingx.JXTextField();
        txtDniPerson = new org.jdesktop.swingx.JXTextField();
        lblDNI = new org.jdesktop.swingx.JXLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaPersonas = new org.jdesktop.swingx.JXTable();
        btnSalir = new org.jdesktop.swingx.JXButton();
        btnBuscar = new org.jdesktop.swingx.JXButton();

        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        pnlFiltro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlFiltro.setLayout(null);

        jXLabel1.setText("Nombre: ");
        pnlFiltro.add(jXLabel1);
        jXLabel1.setBounds(10, 10, 60, 26);

        txtNombre.setBackground(new java.awt.Color(255, 255, 204));
        pnlFiltro.add(txtNombre);
        txtNombre.setBounds(60, 10, 102, 30);

        lblApellidos.setText("Apellidos: ");
        pnlFiltro.add(lblApellidos);
        lblApellidos.setBounds(170, 10, 70, 30);

        txtApellidPaternoPersona.setBackground(new java.awt.Color(255, 255, 204));
        pnlFiltro.add(txtApellidPaternoPersona);
        txtApellidPaternoPersona.setBounds(220, 10, 97, 30);

        txtApellidoMaternoPersona.setBackground(new java.awt.Color(255, 255, 204));
        pnlFiltro.add(txtApellidoMaternoPersona);
        txtApellidoMaternoPersona.setBounds(320, 10, 110, 30);

        txtDniPerson.setBackground(new java.awt.Color(255, 255, 204));
        pnlFiltro.add(txtDniPerson);
        txtDniPerson.setBounds(470, 10, 66, 30);

        lblDNI.setText("DNI: ");
        pnlFiltro.add(lblDNI);
        lblDNI.setBounds(440, 10, 40, 30);

        getContentPane().add(pnlFiltro);
        pnlFiltro.setBounds(10, 10, 550, 50);

        tbListaPersonas.setBackground(new java.awt.Color(255, 255, 204));
        tbListaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbListaPersonas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbListaPersonas.setEditable(false);
        tbListaPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListaPersonasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListaPersonas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 110, 550, 180);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/eliminar.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setPreferredSize(new java.awt.Dimension(77, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(450, 300, 110, 30);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setMaximumSize(new java.awt.Dimension(89, 23));
        btnBuscar.setMinimumSize(new java.awt.Dimension(89, 23));
        btnBuscar.setPreferredSize(new java.awt.Dimension(89, 23));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(450, 70, 110, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    this.setVisible(false);
}//GEN-LAST:event_btnSalirActionPerformed

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    try {
        String nombre = txtNombre.getText();
        String apelliP = txtApellidPaternoPersona.getText();
        String apelliM = txtApellidoMaternoPersona.getText();
        String dni = txtDniPerson.getText();

        listaPersonas = PaqueteBusinessDelegate.getPersonalService().BuscarPersona(apelliP, apelliM, nombre, dni);

        cargarTabla(listaPersonas);
    } catch (SQLException ex) {
        log.error("Error en Busqueda: " + ex.getMessage());
    }


}//GEN-LAST:event_btnBuscarActionPerformed

private void tbListaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListaPersonasMouseClicked

    if (puntero != -1) {
        frmPersona.crearUsuario(personaSeleccionada());
        this.setVisible(false);
    } else {
        frmPersona.cargarDatosBusquedaPersona(personaSeleccionada());
        this.setVisible(false);
    }
}//GEN-LAST:event_tbListaPersonasMouseClicked
    public void setVisible(boolean b) {
        super.setVisible(b);
    }

    private void cargarTabla(List<com.gestionmatriz.recursoshumanos.bean.Personal> lista) {
        String[] titulo = {"Codigo", "Nombre", "Apellidos", "DNI"};
        String[][] data = new String[listaPersonas.size()][4];

        int i = 0;
        for (com.gestionmatriz.recursoshumanos.bean.Personal p : listaPersonas) {
            data[i][0] = p.getStr_codigo();
            data[i][1] = p.getStr_nombres();
            data[i][2] = p.getStr_apePaterno().concat(" ").concat(p.getStr_apeMaterno());
            data[i][3] = p.getStr_dni();
            i++;
        }
        
        DefaultTableModel modelo = new DefaultTableModel(data, titulo);
        tbListaPersonas.setModel(modelo);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscar;
    private org.jdesktop.swingx.JXButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel lblApellidos;
    private org.jdesktop.swingx.JXLabel lblDNI;
    private org.jdesktop.swingx.JXPanel pnlFiltro;
    private org.jdesktop.swingx.JXTable tbListaPersonas;
    private org.jdesktop.swingx.JXTextField txtApellidPaternoPersona;
    private org.jdesktop.swingx.JXTextField txtApellidoMaternoPersona;
    private org.jdesktop.swingx.JXTextField txtDniPerson;
    private org.jdesktop.swingx.JXTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
