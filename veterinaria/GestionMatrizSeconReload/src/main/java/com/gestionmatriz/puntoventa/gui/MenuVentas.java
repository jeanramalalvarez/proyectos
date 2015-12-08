/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JMenu;

import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.util.Util;

/**
 *
 * @author zholo
 */
public class MenuVentas extends JMenu {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JMenuItem mniVender;
    private javax.swing.JMenuItem mniTipoCambio;
    private javax.swing.JMenuItem mniAperturaCaja;
    private javax.swing.JMenuItem mniCierreCaja;
    private javax.swing.JMenuItem mniAnularDocumento;
    private javax.swing.JMenuItem mniGestionCliente;
    private javax.swing.JMenuItem mniCajero;
    private javax.swing.JMenuItem mniReportes;
    private javax.swing.JMenuItem mniCorrelativo;
    private JMenu mnuGestionCaja;
    private JMenu mnuConfiguracion;
    private Venta frmVenta;
    private GestionTipoCambio frmTipoCambio;
    private AperturaCaja frmAperturaCaja;
    private CierreCaja frmCierreCaja;
    private AnularBolFac frmAnularBolFac;
    private GestionCliente frmGestionCliente;
    private Cajero frmCajero;
    private Correlativo frmCorrelativo;
    private Principal gui;
    private ReporteVentas frmReporteVentas;

    public MenuVentas(Principal gui) {
        this.gui = gui;

        this.setText("Ventas");
        this.setForeground(new Color(127, 11, 30));
        this.setFont(new java.awt.Font("", 1, 13));
        this.setVisible(true);

        mnuGestionCaja = new JMenu("Gestion Caja");
        mnuGestionCaja.setForeground(new Color(127, 11, 30));
        mnuGestionCaja.setFont(new Font("", 0, 13));
        mnuGestionCaja.setVisible(true);
        this.add(mnuGestionCaja);

        mniAperturaCaja = new javax.swing.JMenuItem();
        mniAperturaCaja.setText("Apertura Caja");
        mniAperturaCaja.setForeground(new Color(127, 11, 30));
        mniAperturaCaja.setFont(new java.awt.Font("", 0, 13));
        mniAperturaCaja.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAperturaCajaActionPerformed(evt);
            }
        });
        mnuGestionCaja.add(mniAperturaCaja);

        mniCajero = new javax.swing.JMenuItem();
        mniCajero.setText("Cobrar Ventas");
        mniCajero.setForeground(new Color(127, 11, 30));
        mniCajero.setFont(new java.awt.Font("", 0, 13));
        mniCajero.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCajeroActionPerformed(evt);
            }
        });
        mnuGestionCaja.add(mniCajero);


        mniTipoCambio = new javax.swing.JMenuItem();
        mniTipoCambio.setText("Gestión Tipo de Cambio");
        mniTipoCambio.setForeground(new Color(127, 11, 30));
        mniTipoCambio.setFont(new java.awt.Font("", 0, 13));
        mniTipoCambio.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTipoCambioActionPerformed(evt);
            }
        });
        mnuGestionCaja.add(mniTipoCambio);

        mniCierreCaja = new javax.swing.JMenuItem();
        mniCierreCaja.setText("Cierre Caja");
        mniCierreCaja.setForeground(new Color(127, 11, 30));
        mniCierreCaja.setFont(new java.awt.Font("", 0, 13));
        mniCierreCaja.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCierreCajaActionPerformed(evt);
            }
        });
        mnuGestionCaja.add(mniCierreCaja);

        mniAnularDocumento = new javax.swing.JMenuItem();
        mniAnularDocumento.setText("Anular Documentos");
        mniAnularDocumento.setForeground(new Color(127, 11, 30));
        mniAnularDocumento.setFont(new java.awt.Font("", 0, 13));
        mniAnularDocumento.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAnularDocumentoActionPerformed(evt);
            }
        });
        mnuGestionCaja.add(mniAnularDocumento);

        mniVender = new javax.swing.JMenuItem();
        mniVender.setText("Realizar Venta (Factura / Boleta)");
        mniVender.setForeground(new Color(127, 11, 30));
        mniVender.setFont(new java.awt.Font("", 0, 13));
        mniVender.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        mniVender.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniVenderActionPerformed(evt);
            }
        });
        this.add(mniVender);

        mniGestionCliente = new javax.swing.JMenuItem();
        mniGestionCliente.setText("Gestión Cliente");
        mniGestionCliente.setForeground(new Color(127, 11, 30));
        mniGestionCliente.setFont(new java.awt.Font("", 0, 13));
        mniGestionCliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGestionClienteActionPerformed(evt);
            }
        });
        this.add(mniGestionCliente);

        mniReportes = new javax.swing.JMenuItem();
        mniReportes.setText("Reporte Ventas");
        mniReportes.setForeground(new Color(127, 11, 30));
        mniReportes.setFont(new java.awt.Font("", 0, 13));
        mniReportes.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniReportesActionPerformed(evt);
            }
        });
        this.add(mniReportes);

        mnuConfiguracion = new JMenu("Configuraciones");
        mnuConfiguracion.setForeground(new Color(127, 11, 30));
        mnuConfiguracion.setFont(new Font("", 0, 13));
        mnuConfiguracion.setVisible(true);
        this.add(mnuConfiguracion);

        mniCorrelativo = new javax.swing.JMenuItem();
        mniCorrelativo.setText("Correlativos");
        mniCorrelativo.setForeground(new Color(127, 11, 30));
        mniCorrelativo.setFont(new java.awt.Font("", 0, 13));
        mniCorrelativo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCorrelativoActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(mniCorrelativo);

        MenuImageIcon();
    }

    private void MenuImageIcon() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/ventas.png")));
        mnuGestionCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/caja.png")));
        mnuConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/conf.png")));
        mniCorrelativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mniAperturaCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/apercaja.png")));
        mniCajero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/cajero.png")));
        mniTipoCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/tipocambio.png")));
        mniCierreCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/cierrecaja.png")));
        mniAnularDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/anular.png")));
        mniVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/realizarventa.png")));
        mniGestionCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/cliente.png")));
        mniReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/reportes.png")));
    }

    private void mniAperturaCajaActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmAperturaCaja == null || frmAperturaCaja.isClosed()) {
            frmAperturaCaja = new AperturaCaja(gui);
            frmAperturaCaja.setVisible(true);
            gui.addFrm(frmAperturaCaja);
            gui.enforcar(frmAperturaCaja);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmAperturaCaja);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniCajeroActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmCajero == null || frmCajero.isClosed()) {
            frmCajero = new Cajero(gui);
            frmCajero.setVisible(true);
            gui.addFrm(frmCajero);
            gui.enforcar(frmCajero);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmCajero);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniTipoCambioActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmTipoCambio == null || frmTipoCambio.isClosed()) {
            frmTipoCambio = new GestionTipoCambio(gui);
            frmTipoCambio.setVisible(true);
            gui.addFrm(frmTipoCambio);
            gui.enforcar(frmTipoCambio);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmTipoCambio);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniCierreCajaActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmCierreCaja == null || frmCierreCaja.isClosed()) {
            frmCierreCaja = new CierreCaja(gui);
            frmCierreCaja.setVisible(true);
            gui.addFrm(frmCierreCaja);
            gui.enforcar(frmCierreCaja);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmCierreCaja);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniAnularDocumentoActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmAnularBolFac == null || frmAnularBolFac.isClosed()) {
            frmAnularBolFac = new AnularBolFac(gui);
            frmAnularBolFac.setVisible(true);
            gui.addFrm(frmAnularBolFac);
            gui.enforcar(frmAnularBolFac);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmAnularBolFac);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniVenderActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmVenta == null || frmVenta.isClosed()) {
            frmVenta = new Venta(gui);
            frmVenta.setVisible(true);
            gui.addFrm(frmVenta);
            gui.enforcar(frmVenta);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmVenta);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniGestionClienteActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmGestionCliente == null || frmGestionCliente.isClosed()) {
            frmGestionCliente = new GestionCliente(gui);
            frmGestionCliente.setVisible(true);
            gui.addFrm(frmGestionCliente);
            gui.enforcar(frmGestionCliente);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmGestionCliente);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniReportesActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmReporteVentas == null || frmReporteVentas.isClosed()) {
            frmReporteVentas = new ReporteVentas(gui);
            frmReporteVentas.setVisible(true);
            gui.addFrm(frmReporteVentas);
            gui.enforcar(frmReporteVentas);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmReporteVentas);
        }
        Util.hiloProgressBar(0, gui);
    }

    private void mniCorrelativoActionPerformed(ActionEvent evt) {
        Util.hiloProgressBar(1, gui);
        if (frmCorrelativo == null || frmCorrelativo.isClosed()) {
            frmCorrelativo = new Correlativo(gui);
            frmCorrelativo.setVisible(true);
            gui.addFrm(frmCorrelativo);
            gui.enforcar(frmCorrelativo);
            gui.getBarraEstado().nuevaVentanas();
            Util.setCentrarJInternalFrame(frmCorrelativo);
        }
        Util.hiloProgressBar(0, gui);
    }
}
