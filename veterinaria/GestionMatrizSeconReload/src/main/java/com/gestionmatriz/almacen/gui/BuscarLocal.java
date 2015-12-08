/*
 * BuscarPersona.java
 *
 * Created on 23-abr-2012, 18:04:51
 */
package com.gestionmatriz.almacen.gui;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.gui.GuiaRemision;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.util.Mensaje;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

import org.apache.log4j.Logger;

/**
 *
 * @author YESM
 */
public class BuscarLocal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(BuscarLocal.class);
    private Principal gui;
    private List<Empresa> listaEmpresa;
    private List<Local> listaLocal = new ArrayList<>();
    private Empresa objEmpresa;
    private GuiaRemision frmGuiaRemision;
    private Local objLocal;
    private int puntero = -1;

    public BuscarLocal(Principal gui, com.gestionmatriz.puntoventa.gui.GuiaRemision frmGuiaRemision, int puntero) {
        super(gui, true);
        this.gui = gui;
        this.puntero = puntero;
        this.frmGuiaRemision = frmGuiaRemision;
        initComponents();
        this.setTitle(gui.getTitle() + " - Buscar Local");
        this.setSize(515, 190);
        setLocationRelativeTo(null);
        CargarEmpresa();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFiltro = new org.jdesktop.swingx.JXPanel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        cboEmpresa = new org.jdesktop.swingx.JXComboBox();
        cboLocal = new org.jdesktop.swingx.JXComboBox();
        btnSalir = new org.jdesktop.swingx.JXButton();
        btnBuscar = new org.jdesktop.swingx.JXButton();

        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        pnlFiltro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlFiltro.setLayout(null);

        jXLabel3.setText("Empresa");
        pnlFiltro.add(jXLabel3);
        jXLabel3.setBounds(20, 20, 70, 14);

        jXLabel4.setText("Local");
        pnlFiltro.add(jXLabel4);
        jXLabel4.setBounds(20, 70, 60, 14);

        cboEmpresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboEmpresaItemStateChanged(evt);
            }
        });
        pnlFiltro.add(cboEmpresa);
        cboEmpresa.setBounds(110, 20, 190, 20);
        pnlFiltro.add(cboLocal);
        cboLocal.setBounds(110, 70, 190, 20);

        getContentPane().add(pnlFiltro);
        pnlFiltro.setBounds(10, 10, 330, 130);

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
        btnSalir.setBounds(360, 40, 120, 23);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/aceptar.png"))); // NOI18N
        btnBuscar.setText("Aceptar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(360, 10, 120, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    this.setVisible(false);
}//GEN-LAST:event_btnSalirActionPerformed

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    if (cboEmpresa.getSelectedIndex() <= 0) {
        Mensaje.mensaje(this, "Debe seleccionar una empresa", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    if (cboLocal.getSelectedIndex() <= 0) {
        Mensaje.mensaje(this, "Debe seleccionar un local", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    objLocal = listaLocal.get(cboLocal.getSelectedIndex() - 1);
    frmGuiaRemision.cargarLocalLlegada(objLocal);
    this.setVisible(false);
}//GEN-LAST:event_btnBuscarActionPerformed

private void cboEmpresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboEmpresaItemStateChanged
    if (cboEmpresa.getSelectedIndex() > 0) {
        objEmpresa = new Empresa();
        objEmpresa = listaEmpresa.get(cboEmpresa.getSelectedIndex() - 1);
        cargarComboLocal(objEmpresa.getInt_idEmpresa());
    }
}//GEN-LAST:event_cboEmpresaItemStateChanged
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnBuscar;
    private org.jdesktop.swingx.JXButton btnSalir;
    private org.jdesktop.swingx.JXComboBox cboEmpresa;
    private org.jdesktop.swingx.JXComboBox cboLocal;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXPanel pnlFiltro;
    // End of variables declaration//GEN-END:variables

    public void setVisible(boolean b) {
        super.setVisible(b);
    }

    private void CargarEmpresa() {
        cboEmpresa.removeAllItems();
        cboEmpresa.addItem(".::Seleccionar Empresa::.");
        listaEmpresa = new ArrayList<>();

        try {
            listaEmpresa = PaqueteBusinessDelegate.getContratoService().listarEmpresa();
            for (Empresa empresa : listaEmpresa) {
                if (puntero == 1) {
                    if (empresa.getInt_idEmpresa() == gui.getEmpresa().getInt_idEmpresa()) {
                        cboEmpresa.addItem(empresa.getStr_razonSocial());
                    }
                } else {
                    cboEmpresa.addItem(empresa.getStr_razonSocial());
                }

            }
        } catch (SQLException ex) {
            log.error("Error al cargar empresas: " + ex.getMessage());
        }
    }

    private void cargarComboLocal(int int_idEmpresa) {
        cboLocal.removeAllItems();
        cboLocal.addItem(".::Seleccionar Local::.");

//        listaLocal = new ArrayList<>();
        listaLocal = PaqueteBusinessDelegate.getContratoService().buscarLocal(int_idEmpresa);
        frmGuiaRemision.getObjLocal().getStr_nombre();
        for (int i = 0; i < listaLocal.size(); i++) {
            
            
            if(listaLocal.get(i).getInt_idLocal()==frmGuiaRemision.getObjLocal().getInt_idLocal()){
               
                 listaLocal.remove(i);
                
            }
        }
        
        for (Local local : listaLocal) {
            
            if (local.getInt_idLocal() != frmGuiaRemision.getObjLocal().getInt_idLocal()) {
                cboLocal.addItem(local.getStr_direccion());
//                listaLocal.remove(WIDTH)
            }
        }
    }
}