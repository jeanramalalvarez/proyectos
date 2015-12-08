/*
 * BuscarPersona.java
 *
 * Created on 23-abr-2012, 18:04:51
 */
package com.gestionmatriz.almacen.gui;

import java.awt.Frame;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import com.gestionmatriz.almacen.bean.Familia;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;

/**
 *
 * @author YESM
 */
public class BuscarFamilia extends JDialog {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(BuscarFamilia.class);
    private Frame gui;
    private List<Familia> listaFamilia;
    private GestionFamilias frmFamilias;
    private int puntero = -1;
    
    public BuscarFamilia(Frame gui, List<Familia> listaFamilia, GestionFamilias frmFamilias) {
        super(gui, true);
        this.gui = gui;
        this.listaFamilia = listaFamilia;
        this.frmFamilias = frmFamilias;
        initComponents();
        tbListaPersonas.setSortable(false);
        this.setTitle(gui.getTitle() + " - Buscar Familia");
        this.setSize(575, 350);
        setLocationRelativeTo(null);
    }

    public BuscarFamilia(Frame gui, List<Familia> listaFamilia, GestionFamilias frmFamilias, int puntero) {
        super(gui, true);
        this.gui = gui;
        this.listaFamilia = listaFamilia;
        this.frmFamilias = frmFamilias;
        this.puntero = puntero;
        initComponents();
        tbListaPersonas.setSortable(false);
        this.setTitle(gui.getTitle() + " - Buscar Familia");
        this.setSize(575, 350);
        setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        getContentPane().setLayout(null);

        pnlFiltro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlFiltro.setLayout(null);

        jXLabel1.setText("Código :");
        pnlFiltro.add(jXLabel1);
        jXLabel1.setBounds(10, 10, 50, 26);

        txtNombre.setBackground(new java.awt.Color(255, 255, 204));
        pnlFiltro.add(txtNombre);
        txtNombre.setBounds(62, 10, 100, 30);

        lblApellidos.setText("Nombre:");
        pnlFiltro.add(lblApellidos);
        lblApellidos.setBounds(170, 10, 80, 30);

        txtApellidPaternoPersona.setBackground(new java.awt.Color(255, 255, 204));
        pnlFiltro.add(txtApellidPaternoPersona);
        txtApellidPaternoPersona.setBounds(257, 10, 280, 30);

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
        tbListaPersonas.setColumnControlVisible(true);
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
        btnSalir.setPreferredSize(new java.awt.Dimension(77, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(440, 300, 115, 23);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(440, 70, 115, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    this.setVisible(false);
}//GEN-LAST:event_btnSalirActionPerformed

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    try {
        String codigo = "%" + txtNombre.getText() + "%";
        String nombre = "%" + txtApellidPaternoPersona.getText() + "%";

        listaFamilia = PaqueteBusinessDelegate.getFamiliaService().listarFamilia(codigo, nombre);

        cargarTabla(listaFamilia);
    } catch (Exception ex) {
        log.error("Error en Busqueda: " + ex.getMessage());
    }
}//GEN-LAST:event_btnBuscarActionPerformed

private void tbListaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListaPersonasMouseClicked
// System.out.println("puntero :"+ puntero);
    if (puntero == -1) {
        frmFamilias.cargarDatosBusquedaFamilia(familiaSeleccionada());
        this.setVisible(false);
    } else {
//    frmPersona.crearUsuario(personaSeleccionada());
        this.setVisible(false);
    }
}//GEN-LAST:event_tbListaPersonasMouseClicked
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

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }

    private void cargarTabla(List<Familia> listaFamilias) {
        String[] titulo = {"Código", "Nombre", "Descripción"};
        String[][] data = new String[listaFamilias.size()][3];
        int i = 0;

        for (Familia p : listaFamilias) {
            data[i][0] = p.getStr_codigoFamilia();
            data[i][1] = p.getStr_nombre();
            data[i][2] = p.getStr_descripcion();
            i++;
        }
        
        DefaultTableModel modelo = new DefaultTableModel(data, titulo);
        tbListaPersonas.setModel(modelo);

    }
    
    protected void cargarPanelBusquedaFamilias(List<Familia> listaFamilias) {
        cargarTabla(listaFamilias);
    }

    public Familia familiaSeleccionada() {
        int indice = tbListaPersonas.getSelectedRow();
        return listaFamilia.get(indice);
    }
}
