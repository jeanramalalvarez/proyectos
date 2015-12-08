/*
 * BuscarPersona.java
 *
 * Created on 23-abr-2012, 18:04:51
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.almacen.bean.UnidadMedida;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;

import java.awt.Frame;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

/**
 *
 * @author YESM
 */
public class BuscarUnidadMedida extends JDialog {
    
	private static final Logger log=Logger.getLogger(BuscarUnidadMedida.class);
    private Frame gui;
    private List<UnidadMedida> listaUM;
    private GestionUnidadMedida frmUM;
    private int puntero = -1;

    public BuscarUnidadMedida(Frame gui, List<UnidadMedida> listaUM, GestionUnidadMedida frmUM) {
        super(gui, true);
        this.gui = gui;
        this.listaUM = listaUM;
        this.frmUM = frmUM;
        initComponents();
        tbListaUM.setSortable(false);
        this.setTitle(gui.getTitle() + " - Buscar Unidad de Medida");
        this.setSize(575, 350);
        setLocationRelativeTo(null);
    }

    public BuscarUnidadMedida(Frame gui, List<UnidadMedida> listaUM, GestionUnidadMedida frmUM, int puntero) {
        super(gui, true);
        this.gui = gui;
        this.listaUM = listaUM;
        this.frmUM = frmUM;
        this.puntero = puntero;
        initComponents();
        tbListaUM.setSortable(false);
        this.setTitle(gui.getTitle() + " - Buscar Unidad de Medida");
        this.setSize(575, 350);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFiltro = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtCodigo = new org.jdesktop.swingx.JXTextField();
        lblApellidos = new org.jdesktop.swingx.JXLabel();
        txtNombre = new org.jdesktop.swingx.JXTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaUM = new org.jdesktop.swingx.JXTable();
        btnSalir = new org.jdesktop.swingx.JXButton();
        btnBuscar = new org.jdesktop.swingx.JXButton();

        setResizable(false);
        getContentPane().setLayout(null);

        pnlFiltro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlFiltro.setLayout(null);

        jXLabel1.setText("Código :");
        pnlFiltro.add(jXLabel1);
        jXLabel1.setBounds(10, 10, 90, 26);

        txtCodigo.setBackground(new java.awt.Color(255, 255, 204));
        pnlFiltro.add(txtCodigo);
        txtCodigo.setBounds(70, 10, 100, 30);

        lblApellidos.setText("Nombre :");
        pnlFiltro.add(lblApellidos);
        lblApellidos.setBounds(180, 10, 80, 30);

        txtNombre.setBackground(new java.awt.Color(255, 255, 204));
        pnlFiltro.add(txtNombre);
        txtNombre.setBounds(257, 10, 280, 30);

        getContentPane().add(pnlFiltro);
        pnlFiltro.setBounds(10, 10, 550, 50);

        tbListaUM.setBackground(new java.awt.Color(255, 255, 204));
        tbListaUM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbListaUM.setColumnControlVisible(true);
        tbListaUM.setEditable(false);
        tbListaUM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListaUMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListaUM);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 110, 550, 180);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/salirmini.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(450, 300, 120, 23);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
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
        String codigo = "%" + txtCodigo.getText() + "%";
        String nombre = "%" + txtNombre.getText() + "%";

        listaUM = PaqueteBusinessDelegate.getUnidadMedidaService().listarUnidadMedida(codigo, nombre);
        cargarTabla(listaUM);
    } catch (Exception ex) {
        log.error("Error en Busqueda: " + ex.getMessage());
    }
}//GEN-LAST:event_btnBuscarActionPerformed

private void tbListaUMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListaUMMouseClicked
    if (puntero == -1) {
        frmUM.cargarDatosBusquedaUnidadMedida(unidadMedidaSeleccionada());
        this.setVisible(false);
    } else {
//    frmPersona.crearUsuario(personaSeleccionada());
        this.setVisible(false);
    }
}//GEN-LAST:event_tbListaUMMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscar;
    private org.jdesktop.swingx.JXButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel lblApellidos;
    private org.jdesktop.swingx.JXPanel pnlFiltro;
    private org.jdesktop.swingx.JXTable tbListaUM;
    private org.jdesktop.swingx.JXTextField txtCodigo;
    private org.jdesktop.swingx.JXTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }

    private void cargarTabla(List<UnidadMedida> listaUM) {
        String[] titulo = {"Código", "Nombre", "Descripción"};
        String[][] data = new String[listaUM.size()][3];
        int i = 0;

        for (UnidadMedida p : listaUM) {
            data[i][0] = p.getStr_codigoUM();
            data[i][1] = p.getStr_nombreUM();
            data[i][2] = p.getStr_descripcionUM();
            i++;
        }
        
        DefaultTableModel modelo = new DefaultTableModel(data, titulo);
        tbListaUM.setModel(modelo);

    }
    
    protected void cargarPanelBusquedaUM(List<UnidadMedida> listaUM) {
        cargarTabla(listaUM);
    }

    public UnidadMedida unidadMedidaSeleccionada() {
        int indice = tbListaUM.getSelectedRow();
        return listaUM.get(indice);
    }
}
