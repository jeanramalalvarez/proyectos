/*
 * BuscarPersona.java
 *
 * Created on 23-abr-2012, 18:04:51
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.puntoventa.gui.GuiaRemision;

import java.awt.Frame;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

/**
 *
 * @author YESM
 */
public class BuscarProveedor extends JDialog {

	private static final Logger log=Logger.getLogger(BuscarProveedor.class);
    private Frame gui;
    private List<Proveedor> listaProveedores;
    private GestionProveedor frmProveedor;
    private ProveedorProducto frmProveedorProducto;
    private OrdenCompra frmOrdenCompra;
    private GuiaRemision frmGuiaRemision;
    private GestionPrecio frmGestionPrecio;
    private int puntero = -1;
    private int i;
    
    public BuscarProveedor(Frame gui, List<Proveedor> listaProveedores, GestionProveedor frmProveedor) {
        super(gui, true);
        this.gui = gui;
        this.listaProveedores = listaProveedores;
        this.frmProveedor = frmProveedor;
        initComponents();
        tbListaPersonas.setSortable(false);
        this.setTitle(gui.getTitle() + " - Buscar Proveedor");
        this.setSize(805, 355);
        setLocationRelativeTo(null);
    }

    public BuscarProveedor(Frame gui, List<Proveedor> listaProveedores, ProveedorProducto frmProveedorProducto, int puntero) {
        super(gui, true);
        this.gui = gui;
        this.listaProveedores = listaProveedores;
        this.frmProveedorProducto = frmProveedorProducto;
        this.puntero = puntero;
        initComponents();
        tbListaPersonas.setSortable(false);
        this.setTitle(gui.getTitle() + " - Buscar Proveedor");
        this.setSize(805, 355);
        setLocationRelativeTo(null);
    }
    
    public BuscarProveedor(Frame gui, List<Proveedor> listaProveedores, OrdenCompra frmOrdenCompra, int puntero, int i) {
        super(gui, true);
        this.gui = gui;
        this.listaProveedores = listaProveedores;
        this.frmOrdenCompra = frmOrdenCompra;
        this.puntero = puntero;
        this.i = i;
        initComponents();
        tbListaPersonas.setSortable(false);
        this.setTitle(gui.getTitle() + " - Buscar Proveedor");
        this.setSize(805, 355);
        setLocationRelativeTo(null);
    }
    
    public BuscarProveedor(Frame gui, List<Proveedor> listaProveedores, GuiaRemision frmGuiaRemision, int puntero) {
        super(gui, true);
        this.gui = gui;
        this.listaProveedores = listaProveedores;
        this.frmGuiaRemision = frmGuiaRemision;
        this.puntero = puntero;
        initComponents();
        tbListaPersonas.setSortable(false);
        this.setTitle(gui.getTitle() + " - Buscar Proveedor");
        this.setSize(805, 355);
        setLocationRelativeTo(null);
    }
    
    public BuscarProveedor(Frame gui, List<Proveedor> listaProveedor, GestionPrecio frmGestionPrecio, int puntero) {
        super(gui, true);
        this.gui = gui;
        this.listaProveedores = listaProveedor;
        this.frmGestionPrecio = frmGestionPrecio;
        this.puntero = puntero;
        initComponents();
        tbListaPersonas.setSortable(false);
        this.setTitle(gui.getTitle() + " - Buscar Proveedor");
        this.setSize(805, 355);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
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

        jXLabel1.setText("R.U.C. :");
        pnlFiltro.add(jXLabel1);
        jXLabel1.setBounds(10, 10, 50, 26);

        txtNombre.setBackground(new java.awt.Color(255, 255, 204));
        pnlFiltro.add(txtNombre);
        txtNombre.setBounds(62, 10, 120, 30);

        lblApellidos.setText("Razón Social :");
        pnlFiltro.add(lblApellidos);
        lblApellidos.setBounds(390, 10, 80, 30);

        txtApellidPaternoPersona.setBackground(new java.awt.Color(255, 255, 204));
        pnlFiltro.add(txtApellidPaternoPersona);
        txtApellidPaternoPersona.setBounds(480, 10, 280, 30);

        getContentPane().add(pnlFiltro);
        pnlFiltro.setBounds(10, 10, 780, 50);

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
        jScrollPane1.setBounds(10, 110, 780, 180);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/salirmini.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setPreferredSize(new java.awt.Dimension(77, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(680, 300, 115, 23);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(670, 70, 120, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    this.setVisible(false);
}//GEN-LAST:event_btnSalirActionPerformed

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    try {
        String ruc = "%" + txtNombre.getText() + "%";
        String razonSocial = "%" + txtApellidPaternoPersona.getText() + "%";

        listaProveedores = PaqueteBusinessDelegate.getProveedorService().buscarProveedor(ruc, razonSocial);

        cargarTabla(listaProveedores);
    } catch (Exception ex) {
        log.error("Error en Busqueda: " + ex.getMessage());
    }
}//GEN-LAST:event_btnBuscarActionPerformed

private void tbListaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListaPersonasMouseClicked
    if (puntero == -1) {
        frmProveedor.cargarDatosBusquedaProveedor(proveedorSeleccionado());
        this.setVisible(false);
    } else if (puntero == 0) {
        frmProveedorProducto.cargarDatosBusquedaProveedor(proveedorSeleccionado());
        this.setVisible(false);
    } else if (puntero == 1) {
        frmOrdenCompra.cargarDatosBusquedaProveedor(proveedorSeleccionado(), i);
        this.setVisible(false);
    } else if (puntero == 2) {
        frmGuiaRemision.cargarDatosBusquedaProveedor(proveedorSeleccionado());
        this.setVisible(false);
    } else if (puntero == 3) {
        frmGestionPrecio.cargarDatosBusquedaProveedor(proveedorSeleccionado());
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

    private void cargarTabla(List<Proveedor> listaProveedores) {
        String[] titulo = {"R.U.C.", "Razon Social", "Nombre comercial", "Dirección", "Telf.", "E-mail"};
        String[][] data = new String[listaProveedores.size()][6];
        int i = 0;

        for (Proveedor p : listaProveedores) {
            data[i][0] = p.getStr_ruc();
            data[i][1] = p.getStr_razonSocial();
            data[i][2] = p.getStr_nombreComercial();
            data[i][3] = p.getStr_direccion();
            data[i][4] = p.getStr_telefono();
            data[i][5] = p.getStr_email();
            i++;
        }
        DefaultTableModel modelo = new DefaultTableModel(data, titulo);
        tbListaPersonas.setModel(modelo);
    }
    
    public void cargarPanelBusquedaProveedor(List<Proveedor> listaProveedores) {
        cargarTabla(listaProveedores);
    }

    public Proveedor proveedorSeleccionado() {
        int indice = tbListaPersonas.getSelectedRow();
        return listaProveedores.get(indice);
    }
}
