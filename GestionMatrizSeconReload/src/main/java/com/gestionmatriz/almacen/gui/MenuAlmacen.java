/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.gui.GuiaRemision;
import com.gestionmatriz.util.Util;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author zholo
 */
public class MenuAlmacen extends JMenu {

    private javax.swing.JMenu mnuAlmacen;
    private javax.swing.JMenu mnuCompras;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenuItem mniRecepcionMercaderia;
    private javax.swing.JMenuItem mniSalidaProducto;
    private javax.swing.JMenuItem mniMantenimientoProducto;
    private javax.swing.JMenuItem mniMantenimientoFamilia;
    private javax.swing.JMenuItem mniMantenimientoUnidadMedida;
    private javax.swing.JMenuItem mniSolicitudCompra;
    private javax.swing.JMenuItem mniFacturaCompra;
    private javax.swing.JMenuItem mniConformidadCompra;
    private javax.swing.JMenuItem mniResumenCompra;
    private javax.swing.JMenuItem mniMantenimientoProveedor;
    private javax.swing.JMenuItem mniOrdenCompraPrevio;
    private javax.swing.JMenuItem mniPorcentajeUtilidad;
    private javax.swing.JMenuItem mniGestionPrecio;
    private javax.swing.JMenuItem mniReporteProductos;
    private javax.swing.JMenuItem mniReporteTraslados;
    private javax.swing.JMenuItem mniReporteReintegro;
    private javax.swing.JMenuItem mniReporteCompras;
    private javax.swing.JMenuItem mniReporteKardex;
    private javax.swing.JMenuItem mniGestionPrecioOferta;
    private Principal gui;
    private GestionProductos frmProducto;
    private GestionFamilias frmFamilia;
    private GestionUnidadMedida frmUnidadMedida;
    private GestionProveedor frmProveedor;
    private OrdenCompraPrevio frmOrdenCompraPrevio;
    private RecepcionMercaderia frmRecepcionMercaderia;
    private ConformidadCompra frmConformidadCompra;
    private GuiaRemision frmGuiaRemision;
    private PorcentajeUtilidad frmPorcentajeUtilidad;
    private GestionPrecio frmGestionPrecio;
    private ReporteProducto frmReporteProducto;
    private ReporteTraspasoGuia frmReporteTraspasoGuia;
    private ReporteReintegro frmReporteReintegro;
    private ReporteCompras frmReporteCompras;
    private GestionPrecioOferta frmGestionPrecioOferta;
    private ReporteKardex frmReporteKardex;
    
    public MenuAlmacen(Principal gui) {
        this.gui = gui;
        this.setText("Logística");
        this.setForeground(new Color(127, 11, 30));
        this.setFont(new java.awt.Font("", 1, 13));
        this.setVisible(true);

        mnuAlmacen = new javax.swing.JMenu();
        mnuCompras = new javax.swing.JMenu();
        mnuReportes = new javax.swing.JMenu();

        mniRecepcionMercaderia = new javax.swing.JMenuItem();
        mniSalidaProducto = new javax.swing.JMenuItem();
        mniMantenimientoProveedor = new javax.swing.JMenuItem();
        mniMantenimientoProducto = new javax.swing.JMenuItem();
        mniMantenimientoFamilia = new javax.swing.JMenuItem();
        mniMantenimientoUnidadMedida = new javax.swing.JMenuItem();

        mniSolicitudCompra = new javax.swing.JMenuItem();
        mniFacturaCompra = new javax.swing.JMenuItem();
        mniConformidadCompra = new javax.swing.JMenuItem();
        mniResumenCompra = new javax.swing.JMenuItem();
        mniOrdenCompraPrevio = new javax.swing.JMenuItem();
        mniPorcentajeUtilidad = new JMenuItem();
        mniGestionPrecio = new JMenuItem();
        mniGestionPrecioOferta = new JMenuItem();

        mniReporteProductos = new javax.swing.JMenuItem();
        mniReporteTraslados = new javax.swing.JMenuItem();
        mniReporteReintegro = new javax.swing.JMenuItem();
        mniReporteCompras = new javax.swing.JMenuItem();
        mniReporteKardex= new javax.swing.JMenuItem();

        mnuAlmacen.setText("Almacén");
        mnuAlmacen.setForeground(new Color(127, 11, 30));
        mnuAlmacen.setFont(new java.awt.Font("", 0, 13));
        this.add(mnuAlmacen);

        mnuCompras.setText("Compras");
        mnuCompras.setForeground(new Color(127, 11, 30));
        mnuCompras.setFont(new java.awt.Font("", 0, 13));
        this.add(mnuCompras);

        mnuReportes.setText("Reportes");
        mnuReportes.setForeground(new Color(127, 11, 30));
        mnuReportes.setFont(new java.awt.Font("", 0, 13));
        this.add(mnuReportes);

//        mniSolicitudCompra.setText("Solicitud Compra");
//        mniSolicitudCompra.setForeground(new Color(127, 11, 30));
//        mniSolicitudCompra.setFont(new java.awt.Font("", 0, 13));
//        mniSolicitudCompra.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                mniSolicitudCompraActionPerformed(evt);
//            }
//        });
//        mnuCompras.add(mniSolicitudCompra);
        this.add(mnuCompras);

        mniOrdenCompraPrevio.setText("Orden de Compra");
        mniOrdenCompraPrevio.setForeground(new Color(127, 11, 30));
        mniOrdenCompraPrevio.setFont(new java.awt.Font("", 0, 13));
        mniOrdenCompraPrevio.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniOrdenCompraPrevioActionPerformed(evt);
            }
        });
        mnuCompras.add(mniOrdenCompraPrevio);
        this.add(mnuCompras);

//        mniFacturaCompra.setText("Factura de Compra");
//        mniFacturaCompra.setForeground(new Color(127, 11, 30));
//        mniFacturaCompra.setFont(new java.awt.Font("", 0, 13));
//        mniFacturaCompra.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                mniFacturaCompraActionPerformed(evt);
//            }
////        });
//        mnuCompras.add(mniFacturaCompra);
        this.add(mnuCompras);

        mniConformidadCompra.setText("Conformidad de Compra");
        mniConformidadCompra.setForeground(new Color(127, 11, 30));
        mniConformidadCompra.setFont(new java.awt.Font("", 0, 13));
        mniConformidadCompra.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniConformidadCompraActionPerformed(evt);
            }
        });
        mnuCompras.add(mniConformidadCompra);
        this.add(mnuCompras);

//        mniResumenCompra.setText("Resumen de Compra");
//        mniResumenCompra. setForeground(new Color(127, 11, 30));
//        mniResumenCompra.setFont(new java.awt.Font("", 0, 13));
//        mniResumenCompra.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                mniResumenCompraActionPerformed(evt);
//            }
//        });
//        mnuCompras.add(mniResumenCompra);
        this.add(mnuCompras);

        mniRecepcionMercaderia.setText("Recepción de Mercadería");
        mniRecepcionMercaderia.setForeground(new Color(127, 11, 30));
        mniRecepcionMercaderia.setFont(new java.awt.Font("", 0, 13));
        mniRecepcionMercaderia.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRecepcionMercaderiaActionPerformed(evt);
            }
        });
        mnuAlmacen.add(mniRecepcionMercaderia);
        this.add(mnuAlmacen);

        mniMantenimientoProveedor.setText("Gestión Proveedor");
        mniMantenimientoProveedor.setForeground(new Color(127, 11, 30));
        mniMantenimientoProveedor.setFont(new java.awt.Font("", 0, 13));
        mniMantenimientoProveedor.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniMantenimientoProveedorActionPerformed(evt);
            }
        });
        mnuAlmacen.add(mniMantenimientoProveedor);
        this.add(mnuAlmacen);




        mniSalidaProducto.setText("Traspaso Mercadería");
        mniSalidaProducto.setForeground(new Color(127, 11, 30));
        mniSalidaProducto.setFont(new java.awt.Font("", 0, 13));
        mniSalidaProducto.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSalidaProductoActionPerformed(evt);
            }
        });
        mnuAlmacen.add(mniSalidaProducto);
        this.add(mnuAlmacen);

        mniMantenimientoProducto.setText("Gestion Productos");
        mniMantenimientoProducto.setForeground(new Color(127, 11, 30));
        mniMantenimientoProducto.setFont(new java.awt.Font("", 0, 13));
        mniMantenimientoProducto.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniMantenimientoProductoActionPerformed(evt);
            }
        });
        mnuAlmacen.add(mniMantenimientoProducto);
        this.add(mnuAlmacen);

        mniMantenimientoFamilia.setText("Gestion Familias");
        mniMantenimientoFamilia.setForeground(new Color(127, 11, 30));
        mniMantenimientoFamilia.setFont(new java.awt.Font("", 0, 13));
        mniMantenimientoFamilia.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniMantenimientoFamiliaActionPerformed(evt);
            }
        });
        mnuAlmacen.add(mniMantenimientoFamilia);
        this.add(mnuAlmacen);

        mniMantenimientoUnidadMedida.setText("Gestion Unidad de Medida");
        mniMantenimientoUnidadMedida.setForeground(new Color(127, 11, 30));
        mniMantenimientoUnidadMedida.setFont(new java.awt.Font("", 0, 13));
        mniMantenimientoUnidadMedida.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniMantenimientoUnidadMedidaActionPerformed(evt);
            }
        });
        mnuAlmacen.add(mniMantenimientoUnidadMedida);
        this.add(mnuAlmacen);

        mniPorcentajeUtilidad.setText("Gestión Medida Rotación");
        mniPorcentajeUtilidad.setForeground(new Color(127, 11, 30));
        mniPorcentajeUtilidad.setFont(new java.awt.Font("", 0, 13));
        mniPorcentajeUtilidad.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPorcentajeUtilidadActionPerformed(evt);
            }
        });
        mnuAlmacen.add(mniPorcentajeUtilidad);
        this.add(mnuAlmacen);

        mniGestionPrecio.setText("Gestión Precio");
        mniGestionPrecio.setForeground(new Color(127, 11, 30));
        mniGestionPrecio.setFont(new java.awt.Font("", 0, 13));
        mniGestionPrecio.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGestionPrecioActionPerformed(evt);
            }
        });
        mnuAlmacen.add(mniGestionPrecio);
        this.add(mnuAlmacen);

        mniGestionPrecioOferta.setText("Gestión Oferta de precios");
        mniGestionPrecioOferta.setForeground(new Color(127, 11, 30));
        mniGestionPrecioOferta.setFont(new java.awt.Font("", 0, 13));
        mniGestionPrecioOferta.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGestionPrecioOfertaActionPerformed(evt);
            }
        });
        mnuAlmacen.add(mniGestionPrecioOferta);
        this.add(mnuAlmacen);

        mniReporteProductos.setText("Reporte de Productos");
        mniReporteProductos.setForeground(new Color(127, 11, 30));
        mniReporteProductos.setFont(new java.awt.Font("", 0, 13));
        mniReporteProductos.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniReporteProductosActionPerformed(evt);
            }
        });
        mnuReportes.add(mniReporteProductos);
        this.add(mnuReportes);

        mniReporteTraslados.setText("Reporte de Traspasos");
        mniReporteTraslados.setForeground(new Color(127, 11, 30));
        mniReporteTraslados.setFont(new java.awt.Font("", 0, 13));
        mniReporteTraslados.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniReporteTrasladosActionPerformed(evt);
            }
        });
        mnuReportes.add(mniReporteTraslados);
        this.add(mnuReportes);

        mniReporteReintegro.setText("Reporte de Reintegro");
        mniReporteReintegro.setForeground(new Color(127, 11, 30));
        mniReporteReintegro.setFont(new java.awt.Font("", 0, 13));
        mniReporteReintegro.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniReporteReintegroActionPerformed(evt);
            }
        });
        mnuReportes.add(mniReporteReintegro);
        this.add(mnuReportes);

        mniReporteCompras.setText("Reporte de Compras");
        mniReporteCompras.setForeground(new Color(127, 11, 30));
        mniReporteCompras.setFont(new java.awt.Font("", 0, 13));
        mniReporteCompras.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniReporteComprasActionPerformed(evt);
            }
        });
        mnuReportes.add(mniReporteCompras);
        this.add(mnuReportes);
        
        mniReporteKardex.setText("Kardex");
        mniReporteKardex.setForeground(new Color(127, 11, 30));
        mniReporteKardex.setFont(new java.awt.Font("", 0, 13));
        mniReporteKardex.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniReporteKardexActionPerformed(evt);
            }

            
        });
//        mnuReportes.add(mniReporteKardex);
//        this.add(mnuReportes);

        this.add(mnuReportes);
        MenuImageIcon();
    }

    private void MenuImageIcon() {
        mnuAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/almacen.png")));
        mnuCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/compras.png")));
        mnuReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/reportes.png")));
        mniRecepcionMercaderia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniSalidaProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniMantenimientoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniMantenimientoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniMantenimientoFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniMantenimientoUnidadMedida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
//        mniSolicitudCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniOrdenCompraPrevio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
//        mniFacturaCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniConformidadCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
//        mniResumenCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniPorcentajeUtilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniGestionPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniGestionPrecioOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniReporteProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniReporteTraslados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniReporteReintegro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniReporteCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/logistica.png")));
    }

    private void mniRecepcionMercaderiaActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmRecepcionMercaderia == null || frmRecepcionMercaderia.isClosed()) {
            frmRecepcionMercaderia = new RecepcionMercaderia(gui);
            frmRecepcionMercaderia.setVisible(true);
            gui.addFrm(frmRecepcionMercaderia);
            gui.enforcar(frmRecepcionMercaderia);
            gui.getBarraEstado().nuevaVentanas();
            com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmRecepcionMercaderia);

            this.setLocation(this.getParent().getWidth(),
                    this.getParent().getHeight() + 10);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniConformidadCompraActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmConformidadCompra == null || frmConformidadCompra.isClosed()) {
            frmConformidadCompra = new ConformidadCompra(gui);
            frmConformidadCompra.setVisible(true);
            gui.addFrm(frmConformidadCompra);
            gui.enforcar(frmConformidadCompra);
            gui.getBarraEstado().nuevaVentanas();
//            com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmConformidadCompra);
//            frmConformidadCompra.setLocation(frmConformidadCompra.getWidth(), frmConformidadCompra.getHeight()+1);
            frmConformidadCompra.setLocation(frmConformidadCompra.getParent().getWidth() / 2 - frmConformidadCompra.getWidth() / 2,
                    frmConformidadCompra.getParent().getHeight() / 2 - frmConformidadCompra.getHeight() / 2 - 5);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniSalidaProductoActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmGuiaRemision == null || frmGuiaRemision.isClosed()) {
            frmGuiaRemision = new GuiaRemision(gui);
            frmGuiaRemision.setVisible(true);
            gui.addFrm(frmGuiaRemision);
            gui.enforcar(frmGuiaRemision);
            gui.getBarraEstado().nuevaVentanas();
            com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmGuiaRemision);
//            frmGuiaRemision.setLocation(frmGuiaRemision.getWidth(), frmGuiaRemision.getHeight()+2);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniMantenimientoProductoActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmProducto == null || frmProducto.isClosed()) {
            frmProducto = new GestionProductos(gui);
            frmProducto.setVisible(true);
            gui.addFrm(frmProducto);
            gui.enforcar(frmProducto);
            gui.getBarraEstado().nuevaVentanas();
            com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmProducto);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniMantenimientoFamiliaActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmFamilia == null || frmFamilia.isClosed()) {
            frmFamilia = new GestionFamilias(gui);
            frmFamilia.setVisible(true);
            gui.addFrm(frmFamilia);
            gui.enforcar(frmFamilia);
            gui.getBarraEstado().nuevaVentanas();
            com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmFamilia);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniMantenimientoUnidadMedidaActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmUnidadMedida == null || frmUnidadMedida.isClosed()) {
            frmUnidadMedida = new GestionUnidadMedida(gui);
            frmUnidadMedida.setVisible(true);
            gui.addFrm(frmUnidadMedida);
            gui.enforcar(frmUnidadMedida);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmUnidadMedida);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniPorcentajeUtilidadActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmPorcentajeUtilidad == null || frmPorcentajeUtilidad.isClosed()) {
            frmPorcentajeUtilidad = new PorcentajeUtilidad(gui);
            frmPorcentajeUtilidad.setVisible(true);
            gui.addFrm(frmPorcentajeUtilidad);
            gui.enforcar(frmPorcentajeUtilidad);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmPorcentajeUtilidad);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniGestionPrecioActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmGestionPrecio == null || frmGestionPrecio.isClosed()) {
            frmGestionPrecio = new GestionPrecio(gui);
            frmGestionPrecio.setVisible(true);
            gui.addFrm(frmGestionPrecio);
            gui.enforcar(frmGestionPrecio);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmGestionPrecio);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniGestionPrecioOfertaActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmGestionPrecioOferta == null || frmGestionPrecioOferta.isClosed()) {
            frmGestionPrecioOferta = new GestionPrecioOferta(gui);
            frmGestionPrecioOferta.setVisible(true);
            gui.addFrm(frmGestionPrecioOferta);
            gui.enforcar(frmGestionPrecioOferta);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmGestionPrecioOferta);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniMantenimientoProveedorActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmProveedor == null || frmProveedor.isClosed()) {
            frmProveedor = new GestionProveedor(gui);
            frmProveedor.setVisible(true);
            gui.addFrm(frmProveedor);
            gui.enforcar(frmProveedor);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmProveedor);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniSolicitudCompraActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void mniOrdenCompraPrevioActionPerformed(ActionEvent evt) {
        frmOrdenCompraPrevio = new OrdenCompraPrevio(gui);
        frmOrdenCompraPrevio.setVisible(true);
    }

    private void mniFacturaCompraActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void mniResumenCompraActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void mniReporteProductosActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmReporteProducto == null || frmReporteProducto.isClosed()) {
            frmReporteProducto = new ReporteProducto(gui);
            frmReporteProducto.setVisible(true);
            gui.addFrm(frmReporteProducto);
            gui.enforcar(frmReporteProducto);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmReporteProducto);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniReporteTrasladosActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmReporteTraspasoGuia == null || frmReporteTraspasoGuia.isClosed()) {
            frmReporteTraspasoGuia = new ReporteTraspasoGuia(gui);
            frmReporteTraspasoGuia.setVisible(true);
            gui.addFrm(frmReporteTraspasoGuia);
            gui.enforcar(frmReporteTraspasoGuia);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmReporteTraspasoGuia);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniReporteReintegroActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmReporteReintegro == null || frmReporteReintegro.isClosed()) {
            frmReporteReintegro = new ReporteReintegro(gui);
            frmReporteReintegro.setVisible(true);
            gui.addFrm(frmReporteReintegro);
            gui.enforcar(frmReporteReintegro);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmReporteReintegro);
        }
        
        Util.hiloProgressBar(0, gui);
    }

    private void mniReporteComprasActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmReporteCompras == null || frmReporteCompras.isClosed()) {
            frmReporteCompras = new ReporteCompras(gui);
            frmReporteCompras.setVisible(true);
            gui.addFrm(frmReporteCompras);
            gui.enforcar(frmReporteCompras);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmReporteCompras);
        }
        Util.hiloProgressBar(0, gui);
    }
    
    private void mniReporteKardexActionPerformed(ActionEvent evt) {
        
        Util.hiloProgressBar(1, gui);
        if (frmReporteKardex == null || frmReporteKardex.isClosed()) {
            frmReporteKardex = new ReporteKardex(gui);
            frmReporteKardex.setVisible(true);
            gui.addFrm(frmReporteKardex);
            gui.enforcar(frmReporteKardex);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmReporteKardex);
        }
        Util.hiloProgressBar(0, gui);
    }
}
