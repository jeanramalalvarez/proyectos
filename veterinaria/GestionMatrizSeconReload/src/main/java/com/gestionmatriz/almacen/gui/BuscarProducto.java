/*
 * BuscarPersona.java
 *
 * Created on 23-abr-2012, 18:04:51
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.almacen.bean.Almacen;
import com.gestionmatriz.almacen.bean.Familia;
import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.ProveedorProductoUnidadMedida;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.puntoventa.gui.GuiaRemision;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

/**
 *
 * @author YESM
 */
public class BuscarProducto extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(BuscarProducto.class);
    private Frame gui;
    private int puntero = -1;
    private List<Producto> listaProductos = new ArrayList<>();
    private List<Familia> listaFamilia = new ArrayList<>();
    private List<Producto> listaProd = new ArrayList<>();
    private List<ProveedorProductoUnidadMedida> listaPPUM = new ArrayList<>();
    private GestionProductos frmProductos;
    private ProveedorProducto frmProveedorProducto;
    private GuiaRemision frmGuiaRemision;
    private GestionPrecioOferta frmGestionPrecioOferta;
    List<com.gestionmatriz.almacen.bean.ProveedorProducto> listaProveeProduc = new ArrayList<>();

    public BuscarProducto(Frame gui, List<Producto> listaProductos, GestionProductos frmProductos) {
        super(gui, true);
        this.gui = gui;
        this.listaProductos = listaProductos;
        this.frmProductos = frmProductos;
        initComponents();
        tblProducto.setSortable(false);
        cargarComboFamilia();
        this.setTitle(gui.getTitle() + " - Buscar Producto");
        this.setLocationRelativeTo(null);
    }

    public BuscarProducto(Frame gui, List<Producto> listaProductos, ProveedorProducto frmProveedorProducto, int puntero) {
        super(gui, true);
        this.gui = gui;
        this.listaProductos = listaProductos;
        this.frmProveedorProducto = frmProveedorProducto;
        this.puntero = puntero;
        initComponents();
        tblProducto.setSortable(false);
        cargarComboFamilia();
        this.setTitle(gui.getTitle() + " - Buscar Producto");
        this.setLocationRelativeTo(null);
    }

    public BuscarProducto(Frame gui, List<Producto> listaProductos, GuiaRemision frmGuiaRemision, int puntero) {
        super(gui, true);
        this.gui = gui;
        this.listaProductos = listaProductos;
        this.frmGuiaRemision = frmGuiaRemision;
        this.puntero = puntero;
        initComponents();
        tblProducto.setSortable(false);
        cargarComboFamilia();
        this.setTitle(gui.getTitle() + " - Buscar Producto");
        this.setLocationRelativeTo(null);
        txtNombreProducto.setEnabled(false);
        cboFamilia.setEnabled(false);
        cboRotacion.setEnabled(false);
        ckbReintegro.setEnabled(false);
    }
    
    public BuscarProducto(Frame gui, List<ProveedorProductoUnidadMedida> listaPPUM, GestionPrecioOferta frmGestionPrecioOferta, int puntero) {
        super(gui, true);
        this.gui = gui;
        this.listaPPUM = listaPPUM;
        this.frmGestionPrecioOferta = frmGestionPrecioOferta;
        this.puntero = puntero;
        initComponents();
        cargarComboFamilia();
        tblProducto.setSortable(false);
        this.setTitle(gui.getTitle() + " - Buscar Producto");
        this.setLocationRelativeTo(null);
        txtCodigoProducto.setEditable(true);
        txtNombreProducto.setEditable(false);
        cboFamilia.setEnabled(false);
        cboRotacion.setEnabled(false);
        ckbReintegro.setEnabled(false);
        btnBuscar.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFiltro = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        lblApellidos = new org.jdesktop.swingx.JXLabel();
        cboFamilia = new org.jdesktop.swingx.JXComboBox();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        ckbReintegro = new javax.swing.JCheckBox();
        cboRotacion = new org.jdesktop.swingx.JXComboBox();
        txtCodigoProducto = new javax.swing.JTextField();
        txtNombreProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        btnSalir = new org.jdesktop.swingx.JXButton();
        btnBuscar = new org.jdesktop.swingx.JXButton();

        setResizable(false);

        pnlFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jXLabel1.setText("Código Interno:");

        lblApellidos.setText("Nombre :");

        jXLabel2.setText("Familia :");

        jXLabel3.setText("Rotación :");

        jXLabel4.setText("Reintegro :");

        ckbReintegro.setText("Con Reintegro Tributario");

        cboRotacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".::Seleccione una Opción::.", "Menor", "Media", "Mayor" }));

        javax.swing.GroupLayout pnlFiltroLayout = new javax.swing.GroupLayout(pnlFiltro);
        pnlFiltro.setLayout(pnlFiltroLayout);
        pnlFiltroLayout.setHorizontalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFiltroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 153, Short.MAX_VALUE))
                    .addGroup(pnlFiltroLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboRotacion, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFiltroLayout.createSequentialGroup()
                        .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ckbReintegro)))
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlFiltroLayout.setVerticalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboRotacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbReintegro)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProducto.setColumnControlVisible(true);
        tblProducto.setEditable(false);
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducto);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/salirmini.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setPreferredSize(new java.awt.Dimension(77, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    this.setVisible(false);
}//GEN-LAST:event_btnSalirActionPerformed

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    try {
        String codigo = txtCodigoProducto.getText();
        String nombre = txtNombreProducto.getText();
        int indiceFamilia = cboFamilia.getSelectedIndex() - 1;
        String familia = "";
        if (indiceFamilia == -1) {
            familia = "%%";
        } else {
            familia = "" + listaFamilia.get(indiceFamilia).getInt_idFamilia();
        }

        String reintegro = (ckbReintegro.isSelected()) ? "Si" : "No";
        String rotacion = (cboRotacion.getSelectedItem().toString().startsWith("--")) ? "%%"
                : (cboRotacion.getSelectedItem().toString().equals("Menor")) ? "" + 1
                : (cboRotacion.getSelectedItem().toString().equals("Media")) ? "" + 2
                : "" + 3;

        if (puntero == 1) {
            listaProductos = new ArrayList<>();
            for (Producto p : listaProd) {
                if (txtCodigoProducto.getText().equals("")) {
                    listaProductos = listaProd;
                } else if (p.getStr_codigoInterno().equalsIgnoreCase(txtCodigoProducto.getText().toUpperCase())
                        || p.getStr_codigoInterno().startsWith(txtCodigoProducto.getText().toUpperCase())) {
                    listaProductos.add(p);
                }
            }

            cargarTabla(listaProductos, null, 1);
            return;
        } else {
            listaProductos = PaqueteBusinessDelegate.getProductoService().buscarProducto(codigo, nombre, familia, reintegro, rotacion);
        }

        cargarTabla(listaProductos, null, 1);
    } catch (Exception ex) {
        log.error("Error en Busqueda: " + ex.getMessage());
    }
}//GEN-LAST:event_btnBuscarActionPerformed

private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
    if (puntero == -1) {
        frmProductos.cargarDatosBusquedaProducto(productoSeleccionado());
        this.setVisible(false);
    } else if (puntero == 0) {
        frmProveedorProducto.cargarDatosBusquedaProducto(productoSeleccionado());
        this.setVisible(false);
    } else if (puntero == 1) {
        frmGuiaRemision.cargarDatosBusquedaProducto(productoSeleccionado());
        frmGuiaRemision.recibirProveedorProducto(proveeProd());
        this.setVisible(false);
    } else if (puntero == 2) {
        frmGestionPrecioOferta.cargarDatosBusquedaProducto(PPUMSeleccionado());
        this.setVisible(false);
    }
}//GEN-LAST:event_tblProductoMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscar;
    private org.jdesktop.swingx.JXButton btnSalir;
    private org.jdesktop.swingx.JXComboBox cboFamilia;
    private org.jdesktop.swingx.JXComboBox cboRotacion;
    private javax.swing.JCheckBox ckbReintegro;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel lblApellidos;
    private org.jdesktop.swingx.JXPanel pnlFiltro;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }

    private void cargarTabla(List<Producto> listaProductos, List<ProveedorProductoUnidadMedida> listaPPUM, int d) {
        String[] titulo = {"Código", "Nombre", "Descripción", "Fabricante"};
        String[][] data = new String[0][0];
        int i = 0;
            
        if (d == 1) {
            data = new String[listaProductos.size()][4];
            
            for (Producto p : listaProductos) {
                data[i][0] = p.getStr_codigoInterno();
                data[i][1] = p.getStr_nombreProducto();
                data[i][2] = p.getStr_descripcion();
                data[i][3] = p.getStr_fabricante();
                i++;
            }
        } else if (d == 2) {
            data = new String[listaPPUM.size()][4];
            
            for (ProveedorProductoUnidadMedida p : listaPPUM) {
                data[i][0] = p.getObjProducto().getStr_codigoInterno();
                data[i][1] = p.getObjProducto().getStr_nombreProducto();
                data[i][2] = p.getObjProducto().getStr_descripcion();
                data[i][3] = p.getObjProducto().getStr_fabricante();
                i++;
            }
        }
        
        DefaultTableModel modelo = new DefaultTableModel(data, titulo);
        tblProducto.setModel(modelo);
    }
    
    protected ProveedorProductoUnidadMedida PPUMSeleccionado() {
        int indice = tblProducto.getSelectedRow();
        String codigo = tblProducto.getValueAt(0, indice).toString();
        for (ProveedorProductoUnidadMedida proveedorProductoUnidadMedida : listaPPUM) {
            if (proveedorProductoUnidadMedida.getObjProducto().getStr_codigoInterno().equalsIgnoreCase(codigo)) {
                return proveedorProductoUnidadMedida;
            }
        }
        return null;
    }

    public Producto productoSeleccionado() {
        int indice = tblProducto.getSelectedRow();
        
        if (puntero == 1) {
            listaProductos=listaProd;
            return listaProd.get(indice);
        }
        return listaProductos.get(indice);
    }

    public List<com.gestionmatriz.almacen.bean.ProveedorProducto> proveeProd() {
        return listaProveeProduc;
    }

    public void cargarPanelBusquedaProducto(List<Producto> listaProductos) {
        if (puntero == 1) {
            int idLocal = frmGuiaRemision.getObjLocal().getInt_idLocal();

            List<com.gestionmatriz.almacen.bean.Almacen> listaAlmacen = PaqueteBusinessDelegate.getAlmacenService().listaProductosAlmacen(idLocal);
            Producto objProducto = null;
            listaProd = new ArrayList<>();
            com.gestionmatriz.almacen.bean.ProveedorProducto objProveedorProducto; 
            for (Almacen a : listaAlmacen) {
                
                objProveedorProducto= new com.gestionmatriz.almacen.bean.ProveedorProducto();
                if (PaqueteBusinessDelegate.getProductoService().buscarProductoXId(a.getObjProducto().getInt_idProducto()) != null) {
                    objProducto = PaqueteBusinessDelegate.getProductoService().buscarProductoXId(a.getObjProducto().getInt_idProducto());
                    objProveedorProducto.setInt_idProducto(a.getObjProducto().getInt_idProducto());
                    objProveedorProducto.setInt_idProveedor(a.getObjProveedor().getInt_idProveedor());
//                    System.out.println("proveedor---:"+a.getObjProveedor().getInt_idProveedor());
                }
                listaProveeProduc.add(objProveedorProducto);
                listaProd.add(objProducto);
            }

            cargarTabla(listaProd, null, 1);
        } else {
            cargarTabla(listaProductos, null, 1);
        }
    }
    
    protected void cargarPanelBusquedaPPUM(List<ProveedorProductoUnidadMedida> listaPPUM) {
        cargarTabla(null, listaPPUM, 2);
    }

    public void cargarComboFamilia() {
        listaFamilia = new ArrayList<>();
        cboFamilia.removeAllItems();
        cboFamilia.addItem(".::Seleccionar una familia::.");

        try {
            listaFamilia = PaqueteBusinessDelegate.getFamiliaService().listarFamilia("%%", "%%");
            for (Familia objF : listaFamilia) {
                cboFamilia.addItem(objF.getStr_nombre());
            }
        } catch (SQLException ex) {
            log.error("Error al cargar familia: " + ex.getMessage());
        }
    }
}
