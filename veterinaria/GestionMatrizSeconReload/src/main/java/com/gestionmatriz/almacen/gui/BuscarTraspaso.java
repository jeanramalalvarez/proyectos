/*
 * BuscarPersona.java
 *
 * Created on 23-abr-2012, 18:04:51
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.almacen.bean.TraspasoMercaderia;
import java.awt.Frame;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YESM
 */
public class BuscarTraspaso extends JDialog {

    private Frame gui;
    private List<TraspasoMercaderia> listaTraspaso;
    private com.gestionmatriz.almacen.gui.TraspasoMercaderia frmTraspasoMercaderia;
    private int puntero = -1;
    
    public BuscarTraspaso(Frame gui, List<TraspasoMercaderia> listaTraspaso, com.gestionmatriz.almacen.gui.TraspasoMercaderia frmTraspasoMercaderia) {
        super(gui, true);
        this.gui = gui;
        this.listaTraspaso = listaTraspaso;
        this.frmTraspasoMercaderia = frmTraspasoMercaderia;
        initComponents();
        tbListaPersonas.setSortable(false);
        this.setTitle(gui.getTitle() + " - Buscar Traspaso");
        this.setSize(575, 350);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaPersonas = new org.jdesktop.swingx.JXTable();
        btnSalir = new org.jdesktop.swingx.JXButton();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();

        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

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
        jScrollPane1.setBounds(10, 60, 550, 230);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/salirmini.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setPreferredSize(new java.awt.Dimension(77, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(450, 300, 110, 23);

        jXLabel1.setText("Lista Traspasos pendientes de confirmar :");
        getContentPane().add(jXLabel1);
        jXLabel1.setBounds(10, 20, 550, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    this.setVisible(false);
}//GEN-LAST:event_btnSalirActionPerformed

private void tbListaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListaPersonasMouseClicked
// System.out.println("puntero :"+ puntero);
    if (puntero == -1) {
        frmTraspasoMercaderia.cargarDatosBusquedaFamilia(traspasoSeleccionada());
        this.setVisible(false);
    } else {
//    frmPersona.crearUsuario(personaSeleccionada());
        this.setVisible(false);
    }
}//GEN-LAST:event_tbListaPersonasMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXTable tbListaPersonas;
    // End of variables declaration//GEN-END:variables

    public void setVisible(boolean b) {
        super.setVisible(b);
    }

    private void cargarTabla(List<com.gestionmatriz.almacen.bean.TraspasoMercaderia> listaTraspaso) {
        String[] titulo = {"Código Autoriza", "Fecha Autorización", "Estado"};
        String[][] data = new String[listaTraspaso.size()][3];
        int i = 0;

        for (com.gestionmatriz.almacen.bean.TraspasoMercaderia p : listaTraspaso) {
            data[i][0] = p.getStr_codigoAutoriza();
            data[i][1] = p.getDte_fechaAutoriza();
            data[i][2] = p.getStr_estado();
            i++;
        }
        
        DefaultTableModel modelo = new DefaultTableModel(data, titulo);
        tbListaPersonas.setModel(modelo);

    }
    
    public void cargarPanelBusquedaFamilias(List<TraspasoMercaderia> listaTraspaso) {
        cargarTabla(listaTraspaso);
    }

    public TraspasoMercaderia traspasoSeleccionada() {
        int indice = tbListaPersonas.getSelectedRow();
        return listaTraspaso.get(indice);
    }
}
