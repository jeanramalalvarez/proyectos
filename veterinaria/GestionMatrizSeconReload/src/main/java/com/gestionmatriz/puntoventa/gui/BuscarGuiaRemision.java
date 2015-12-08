/*
 * BuscarPersona.java
 *
 * Created on 23-abr-2012, 18:04:51
 */
package com.gestionmatriz.puntoventa.gui;

import com.gestionmatriz.almacen.gui.*;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.util.Util;

import java.awt.Frame;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

/**
 *
 * @author YESM
 */
public class BuscarGuiaRemision extends JDialog {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(BuscarGuiaRemision.class);  
    public BuscarGuiaRemision(Frame gui, 
            List<com.gestionmatriz.puntoventa.bean.GuiaRemision> listaGuias, 
            TraspasoMercaderia frmTraspasoMercaderia) {
        super(gui, true);
        this.gui = gui;
        this.listaGuias = listaGuias;
        this.frmTraspasoMercaderia = frmTraspasoMercaderia;
        initComponents();
        this.setTitle(gui.getTitle() + " - Buscar Guias Remision");
        this.setSize(575, 350);
        setLocationRelativeTo(null);
    }

    

    public void cargarPanelBusquedaFamilias(List<com.gestionmatriz.puntoventa.bean.GuiaRemision> listaGuias) {
        cargarTabla(listaGuias);
    }

    public com.gestionmatriz.puntoventa.bean.GuiaRemision guiaSeleccionada() {
        int indice = tbListaPersonas.getSelectedRow();
        return listaGuias.get(indice);
    }

    
    private void initComponents() {

        pnlFiltro = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtNombre = new org.jdesktop.swingx.JXTextField();
        lblApellidos = new org.jdesktop.swingx.JXLabel();
        txtApellidPaternoPersona = new org.jdesktop.swingx.JXTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaPersonas = new org.jdesktop.swingx.JXTable();
        btnSalir = new org.jdesktop.swingx.JXButton();
        btnBuscar = new org.jdesktop.swingx.JXButton();

        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        pnlFiltro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlFiltro.setLayout(null);

        jXLabel1.setText("N° Guia de Remisión :");
        pnlFiltro.add(jXLabel1);
        jXLabel1.setBounds(10, 10, 140, 26);

        txtNombre.setBackground(new java.awt.Color(255, 255, 204));
        pnlFiltro.add(txtNombre);
        txtNombre.setBounds(160, 10, 100, 30);

        lblApellidos.setText("Local de Salida :");
        pnlFiltro.add(lblApellidos);
        lblApellidos.setBounds(270, 10, 110, 30);

        txtApellidPaternoPersona.setBackground(new java.awt.Color(255, 255, 204));
        pnlFiltro.add(txtApellidPaternoPersona);
        txtApellidPaternoPersona.setBounds(387, 10, 150, 30);

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

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/salirmini.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setPreferredSize(new java.awt.Dimension(77, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(450, 300, 110, 23);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(440, 70, 120, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    this.setVisible(false);
}//GEN-LAST:event_btnSalirActionPerformed

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    try {
        String NroGuia = "%" + txtNombre.getText() + "%";
        String LocalSalida = "%" + txtApellidPaternoPersona.getText() + "%";

        listaGuias = PaqueteBusinessDelegate.getGuiaRemisionService().buscarGuias(NroGuia, LocalSalida,Util.ACTIVO);

        cargarTabla(listaGuias);
    } catch (Exception ex) {
        log.error("Error en Busqueda: " + ex.getMessage());
    }
}//GEN-LAST:event_btnBuscarActionPerformed

private void tbListaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListaPersonasMouseClicked
// System.out.println("puntero :"+ puntero);
    if (puntero == -1) {
        frmTraspasoMercaderia.cargarDatosBusquedaFamilia(guiaSeleccionada());
        this.setVisible(false);
    } else {
//    frmPersona.crearUsuario(personaSeleccionada());
        this.setVisible(false);
    }
}//GEN-LAST:event_tbListaPersonasMouseClicked
    public void setVisible(boolean b) {
        super.setVisible(b);
    }

    private void cargarTabla(List<com.gestionmatriz.puntoventa.bean.GuiaRemision> listaGuias) {
        String[] titulo = {"Nro Guía","Salida","Llegada", "Emisión", "Fecha Traslado","Estado"};
        String[][] data = new String[listaGuias.size()][6];
        int i = 0;
//        System.out.println("llenando la tabla-----");
        for (com.gestionmatriz.puntoventa.bean.GuiaRemision p : listaGuias) {
            data[i][0] = p.getStr_nroGuia();
            data[i][1] = p.getStr_localPartida();
            data[i][2] = p.getStr_domicilioLlegada();
            data[i][3] = ""+p.getDte_fechaEmision();
            data[i][4] = ""+p.getDte_fechaTraslado();
            data[i][5] = p.getStr_estado();
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
    private org.jdesktop.swingx.JXPanel pnlFiltro;
    private org.jdesktop.swingx.JXTable tbListaPersonas;
    private org.jdesktop.swingx.JXTextField txtApellidPaternoPersona;
    private org.jdesktop.swingx.JXTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private Frame gui;
    List<com.gestionmatriz.puntoventa.bean.GuiaRemision> listaGuias;
    TraspasoMercaderia frmTraspasoMercaderia;
    private int puntero = -1;
}
