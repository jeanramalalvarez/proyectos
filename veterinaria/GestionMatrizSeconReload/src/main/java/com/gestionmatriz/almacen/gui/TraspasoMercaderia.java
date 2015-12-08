/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TraspasoMercaderia.java
 *
 * Created on 05-jul-2012, 9:02:35
 */
package com.gestionmatriz.almacen.gui;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gestionmatriz.almacen.bean.Almacen;
import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.TipoMovimiento;
import com.gestionmatriz.almacen.opciones.Opciones;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.DetalleGuiaRemision;
import com.gestionmatriz.puntoventa.bean.GuiaRemision;
import com.gestionmatriz.puntoventa.gui.BuscarGuiaRemision;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

/**
 *
 * @author jarcon
 */
public class TraspasoMercaderia extends javax.swing.JInternalFrame {

    private Principal gui;
    private Personal objPersonaAutoriza;
    private com.gestionmatriz.almacen.bean.TraspasoMercaderia objTraspasoMercaderia, objTrapasoMercaderiaUpdate;
    private GuiaRemision objGuiaRemision;
    private ValidarUsuario frmValidarUsuario;

    public TraspasoMercaderia(Principal gui) {
        this.gui = gui;
        initComponents();
//        PaqueteBusinessDelegate.getOtrosService().getOtros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtdireccionSalida = new org.jdesktop.swingx.JXTextField();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        txtNroGuia = new org.jdesktop.swingx.JXTextField();
        btnBuscarGuia = new org.jdesktop.swingx.JXButton();
        txtResposableSalida = new org.jdesktop.swingx.JXTextField();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        btnAutorizarSalida = new org.jdesktop.swingx.JXButton();
        txtLocalSalida = new org.jdesktop.swingx.JXTextField();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        txtDireccioLlegada = new org.jdesktop.swingx.JXTextField();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        txtResponsableLlegada = new org.jdesktop.swingx.JXTextField();
        btnConfirmarLlegada = new org.jdesktop.swingx.JXButton();
        txtLocalLlegada = new org.jdesktop.swingx.JXTextField();
        btnGuiasPorConfirmar = new org.jdesktop.swingx.JXButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("TRASPASO DE MERCADERÍA");

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Traspaso de Mercadería", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Información de Salida"));

        jXLabel1.setText("Local de Salida :");

        jXLabel2.setText("Dirección :");

        txtdireccionSalida.setEditable(false);

        jXLabel3.setText("Guía de Remisión :");

        txtNroGuia.setEditable(false);

        btnBuscarGuia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscarGuia.setText("Buscar Guía");
        btnBuscarGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarGuiaActionPerformed(evt);
            }
        });

        txtResposableSalida.setEditable(false);

        jXLabel7.setText("Responsable :");

        btnAutorizarSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/credenciales.png"))); // NOI18N
        btnAutorizarSalida.setText("Autorizar Salida");
        btnAutorizarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorizarSalidaActionPerformed(evt);
            }
        });

        txtLocalSalida.setEditable(false);

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLocalSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNroGuia, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel2Layout.createSequentialGroup()
                                .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtdireccionSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnBuscarGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                        .addComponent(txtResposableSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAutorizarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdireccionSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocalSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAutorizarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResposableSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jXPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Información de Llegada"));

        jXLabel4.setText("Local de Llegada :");

        jXLabel5.setText("Dirección :");

        txtDireccioLlegada.setEditable(false);

        jXLabel6.setText("Responsable :");

        txtResponsableLlegada.setEditable(false);

        btnConfirmarLlegada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/aceptar.png"))); // NOI18N
        btnConfirmarLlegada.setText("Confirmar Llegada");
        btnConfirmarLlegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarLlegadaActionPerformed(evt);
            }
        });

        txtLocalLlegada.setEditable(false);

        btnGuiasPorConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/enviosolicitud.png"))); // NOI18N
        btnGuiasPorConfirmar.setText("Traspasos por Confirmar");
        btnGuiasPorConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiasPorConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jXPanel3Layout.createSequentialGroup()
                        .addComponent(txtLocalLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDireccioLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtResponsableLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuiasPorConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmarLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocalLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccioLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuiasPorConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmarLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResponsableLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnBuscarGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarGuiaActionPerformed

    List<GuiaRemision> listaGuias = PaqueteBusinessDelegate.
            getGuiaRemisionService().buscarGuias("%%", "%%", Util.ACTIVO);
//            System.out.println("btnBuscarGuia-----");
    Util.hiloProgressBar(1, gui);
    BuscarGuiaRemision frmBuscarGuiaRemision = new BuscarGuiaRemision(gui, listaGuias, this);
    Util.hiloProgressBar(0, gui);
    frmBuscarGuiaRemision.cargarPanelBusquedaFamilias(listaGuias);
    frmBuscarGuiaRemision.setVisible(true);

}//GEN-LAST:event_btnBuscarGuiaActionPerformed

private void btnAutorizarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorizarSalidaActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getTRASPASO_AUTORIZAR())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    //    gui.loadLectorHuella();
    //
    //    if (gui.getObjPersonalHuella() == null) {
    //        System.out.println("huella nula");
    //        return;
    //    }
    if(txtResposableSalida.getText().equals("")){
        Mensaje.mensaje(this, "Debe buscar una guía de remisión", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    frmValidarUsuario = new ValidarUsuario(gui);
    frmValidarUsuario.setVisible(true);

    if (gui.getObjPersonalHuella() == null) {
        Mensaje.mensaje(this, "No se encontro persona", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    if (objPersonaAutoriza.getStr_codigo().equalsIgnoreCase(gui.getObjPersonalHuella().getStr_codigo())) {

        if (PaqueteBusinessDelegate.getTraspasoMercaderiaService().registrarTraspaso(objTraspasoMercaderia) == true) {
            if (PaqueteBusinessDelegate.getGuiaRemisionService().updateEstadoGuia(objGuiaRemision.getInt_idGuiaRemision(), Util.AUTORIZADO)) {
                actualizarAlmacen(0);
                Mensaje.mensaje(this, "Sr(a). " + txtResposableSalida.getText() + ", \nusted ha autorizado la salida de los "
                        + "productos detallados en la Guía de Remisión N°:" + txtNroGuia.getText(),
                        Mensaje.TITULO_ME, Mensaje.INFORMACION);
                limpiar();
            } else {
                Mensaje.mensaje(this, "Usted no tiene los permisos para autorizar el traspaso",
                        Mensaje.TITULO_ME, Mensaje.INFORMACION);
            }
        } else {
            Mensaje.mensaje(this, "Error al registrar el traspaso",
                    Mensaje.TITULO_ME, Mensaje.INFORMACION);
            return;
        }

    } else {
        Mensaje.mensaje(this, "Usted no tiene los permisos para autorizar el traspaso",
                Mensaje.TITULO_ME, Mensaje.INFORMACION);
    }
}//GEN-LAST:event_btnAutorizarSalidaActionPerformed

private void btnConfirmarLlegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarLlegadaActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getTRASPASO_CONFIRMARLLEGADA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

//    gui.loadLectorHuella();
//
//    if (gui.getObjPersonalHuella() == null) {
//        System.out.println("huella nula");
//        return;
//    }
    
    if(txtResposableSalida.getText().equals("")){
        Mensaje.mensaje(this, "Debe buscar una guía de remisión", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    frmValidarUsuario = new ValidarUsuario(gui);
    frmValidarUsuario.setVisible(true);

    if (gui.getObjPersonalHuella() == null) {
        Mensaje.mensaje(this, "No se encontro persona", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }

    objTrapasoMercaderiaUpdate.setStr_codigoConfirma(gui.getObjPersonalHuella().getStr_codigo());
    objTrapasoMercaderiaUpdate.setStr_usuarioModificador(gui.getBarraEstado().getUsuario());
    objTrapasoMercaderiaUpdate.setStr_estado(Util.CONFIRMADO);

    if (PaqueteBusinessDelegate.getTraspasoMercaderiaService().confirmarTraspaso(objTrapasoMercaderiaUpdate)) {
        if (PaqueteBusinessDelegate.getGuiaRemisionService().updateEstadoGuia(objTrapasoMercaderiaUpdate.getInt_idGuiaRemision(), Util.CONFIRMADO)) {
            actualizarAlmacen(1);

            Mensaje.mensaje(this, "Sr(a). " + gui.getObjPersonalHuella().getStr_apePaterno() + " "
                    + gui.getObjPersonalHuella().getStr_apeMaterno() + " "
                    + gui.getObjPersonalHuella().getStr_nombres()
                    + ", \nusted ha Confirmado el ingreso de los "
                    + "productos detallados en la Guía de Remisión N°:" + txtNroGuia.getText() + " al Local " + txtLocalLlegada.getText(),
                    Mensaje.TITULO_ME, Mensaje.INFORMACION);
            limpiar();
        } else {
            Mensaje.mensaje(this, "Usted no tiene los permisos para Confirmar el traspaso",
                    Mensaje.TITULO_ME, Mensaje.INFORMACION);
        }
    } else {
        Mensaje.mensaje(this, "Usted no tiene los permisos para Confirmar el traspaso",
                Mensaje.TITULO_ME, Mensaje.INFORMACION);
    }
}//GEN-LAST:event_btnConfirmarLlegadaActionPerformed

private void btnGuiasPorConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiasPorConfirmarActionPerformed
//        System.out.println("local llegada---:"+gui.getLocal().getStr_nombre());
    List<com.gestionmatriz.almacen.bean.TraspasoMercaderia> listaTraspaso = PaqueteBusinessDelegate.
            getTraspasoMercaderiaService().
            listarTraspasoMercaderia("%%", "%%", Util.AUTORIZADO, gui.getLocal().getStr_nombre());

//            System.out.println("btnBuscarGuia-----");
    Util.hiloProgressBar(1, gui);
    BuscarTraspaso frmBuscarTraspaso = new BuscarTraspaso(gui, listaTraspaso, this);
    Util.hiloProgressBar(0, gui);
    frmBuscarTraspaso.cargarPanelBusquedaFamilias(listaTraspaso);
    frmBuscarTraspaso.setVisible(true);

//            PaqueteBusinessDelegate.getGuiaRemisionService().buscarDetalleGuiaXId()

}//GEN-LAST:event_btnGuiasPorConfirmarActionPerformed

    private void actualizarAlmacen(int puntero) {
        Almacen objAlmacen = new Almacen();
        Producto objProducto = new Producto();
        com.gestionmatriz.almacen.bean.Proveedor objProveedor = new com.gestionmatriz.almacen.bean.Proveedor();
        Local objLocal = new Local();
        TipoMovimiento objTipoMovimiento = new TipoMovimiento();
        List<DetalleGuiaRemision> listaDetalleGuia = new ArrayList<>();

        if (puntero == 1) {
            listaDetalleGuia = PaqueteBusinessDelegate.getGuiaRemisionService().
                    buscarDetalleGuiaXId(objTrapasoMercaderiaUpdate.getInt_idGuiaRemision());
        } else {
            listaDetalleGuia = PaqueteBusinessDelegate.getGuiaRemisionService().
                    buscarDetalleGuiaXId(objGuiaRemision.getInt_idGuiaRemision());
        }


        String arr[] = objGuiaRemision.getStr_domicilioLlegada().split("-.-");


        Local objLocalLlegada = PaqueteBusinessDelegate.getContratoService().
                buscarLocalNombre(gui.getEmpresa().getInt_idEmpresa(), arr[1].trim());
//    if(objLocalLlegada==null){
//        System.out.println("Empresa ="+gui.getEmpresa().getInt_idEmpresa());
//        System.out.println("arr[1] ="+arr[1]);
//        System.out.println("objLocalLlegada ="+null);
//    }

        for (DetalleGuiaRemision dg : listaDetalleGuia) {
            objProducto.setInt_idProducto(dg.getInt_idProducto());
            objProveedor.setInt_idProveedor(Integer.parseInt(dg.getInt_idProveedor()));
            if (puntero == 1) {
                objLocal.setInt_idLocal(objLocalLlegada.getInt_idLocal());
//            System.out.println("objLocalLlegada--id--:"+objLocalLlegada.getInt_idLocal());
            } else {
                objLocal.setInt_idLocal(gui.getLocal().getInt_idLocal());
            }


            if (puntero == 1) {
                objTipoMovimiento.setInt_idTipoMovimiento(3);
            } else {
                objTipoMovimiento.setInt_idTipoMovimiento(4);//dato estatico Salida Traspaso
            }


            objAlmacen.setObjProducto(objProducto);
            objAlmacen.setObjProveedor(objProveedor);
            objAlmacen.setObjLocal(objLocal);
            objAlmacen.setObjTipoMovimiento(objTipoMovimiento);
//        System.out.println("objLocal--id--:"+objLocal.getInt_idLocal());

            objAlmacen.setStr_documento(objGuiaRemision.getStr_nroGuia());
            if (puntero == 1) {
                objAlmacen.setDbl_cantidad((dg.getDbl_cantdadProducto()));
            } else {
                objAlmacen.setDbl_cantidad((dg.getDbl_cantdadProducto().multiply(BigDecimal.ONE.negate())));
            }


            objAlmacen.setStr_fechaDocumento(objGuiaRemision.getDte_fechaCreacion());
            objAlmacen.setStr_estado(Util.ACTIVO);
            objAlmacen.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());

//        listaAlmacen.add(objAlmacen);

            if (PaqueteBusinessDelegate.getAlmacenService().registrarAlmacenTraspaso(objAlmacen) == true) {
                System.out.println("ingresado en almacen...=" + objAlmacen.getDbl_cantidad());
//            Mensaje.mensaje(this, "Se actulaizó la salida de productos en el almacen", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            } else {
                Mensaje.mensaje(this, "Error en el traspaso de productos", Mensaje.TITULO_ME, Mensaje.ERROR);
            }
        }
//    PaqueteBusinessDelegate.getAlmacenService().registrarAlmacenTraspaso(objAlmacen)
    }

    private void limpiar() {
        txtNroGuia.setText("");
        txtDireccioLlegada.setText("");
        txtLocalLlegada.setText("");
        txtLocalSalida.setText("");
        txtResponsableLlegada.setText("");
        txtResposableSalida.setText("");
        txtdireccionSalida.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAutorizarSalida;
    private org.jdesktop.swingx.JXButton btnBuscarGuia;
    private org.jdesktop.swingx.JXButton btnConfirmarLlegada;
    private org.jdesktop.swingx.JXButton btnGuiasPorConfirmar;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXTextField txtDireccioLlegada;
    private org.jdesktop.swingx.JXTextField txtLocalLlegada;
    private org.jdesktop.swingx.JXTextField txtLocalSalida;
    private org.jdesktop.swingx.JXTextField txtNroGuia;
    private org.jdesktop.swingx.JXTextField txtResponsableLlegada;
    private org.jdesktop.swingx.JXTextField txtResposableSalida;
    private org.jdesktop.swingx.JXTextField txtdireccionSalida;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        gui.getBarraEstado().cerraVentana();
    }

    public void cargarDatosBusquedaFamilia(GuiaRemision guiaSeleccionada) {
        try {
            //        System.out.println("----"+guiaSeleccionada.getStr_domicilioPartida());
            String arr[] = guiaSeleccionada.getStr_domicilioPartida().split("-.-");
            String arr1[] = guiaSeleccionada.getStr_domicilioLlegada().split("-.-");
            String direccion = arr[0], direccionLlegada = arr1[0], localLlegada = arr1[1];
            String local = guiaSeleccionada.getStr_localPartida();//arr[1];
            String codigo = gui.getBarraEstado().getUsuario().substring(0, 1) + gui.getCodigoPersona();

            objTraspasoMercaderia = new com.gestionmatriz.almacen.bean.TraspasoMercaderia();

            Personal objPersonal = PaqueteBusinessDelegate.getPersonalService().BuscarPersonaXCodigo(codigo);

            txtNroGuia.setText(guiaSeleccionada.getStr_nroGuia());
            txtLocalSalida.setText(local);
            txtdireccionSalida.setText(direccion);
            txtResposableSalida.setText(objPersonal.getStr_apePaterno() + " "
                    + objPersonal.getStr_apeMaterno() + " "
                    + objPersonal.getStr_nombres());

            txtDireccioLlegada.setText(direccionLlegada);
            txtLocalLlegada.setText(localLlegada);

            objPersonaAutoriza = objPersonal;

            objTraspasoMercaderia.setInt_idGuiaRemision(guiaSeleccionada.getInt_idGuiaRemision());
            objTraspasoMercaderia.setStr_codigoAutoriza(objPersonaAutoriza.getStr_codigo());
            objTraspasoMercaderia.setStr_estado(Util.AUTORIZADO);
            objTraspasoMercaderia.setStr_usuarioCreador(gui.getBarraEstado().getUsuario());

            objGuiaRemision = guiaSeleccionada;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void cargarDatosBusquedaFamilia(com.gestionmatriz.almacen.bean.TraspasoMercaderia traspasoSeleccionada) {
        objTrapasoMercaderiaUpdate = traspasoSeleccionada;

        List<GuiaRemision> listaGuias = PaqueteBusinessDelegate.getGuiaRemisionService().buscarGuias("%%", "%%", "%%");
        GuiaRemision objGuiaRemision = null;
        for (GuiaRemision gR : listaGuias) {
            if (gR.getInt_idGuiaRemision() == objTrapasoMercaderiaUpdate.getInt_idGuiaRemision()) {
                objGuiaRemision = gR;
            }
        }

        String arr[] = objGuiaRemision.getStr_domicilioPartida().split("-.-");
        String arr1[] = objGuiaRemision.getStr_domicilioLlegada().split("-.-");
        String direccion = arr[0], direccionLlegada = arr1[0], localLlegada = arr1[1];
        String codigo = gui.getBarraEstado().getUsuario().substring(0, 1) + gui.getCodigoPersona();
        String local = objGuiaRemision.getStr_localPartida();
        objTraspasoMercaderia = new com.gestionmatriz.almacen.bean.TraspasoMercaderia();

        Personal objPersonal = null;
        this.objGuiaRemision = objGuiaRemision;
        try {
            objPersonal = PaqueteBusinessDelegate.getPersonalService().
                    BuscarPersonaXCodigo(codigo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        txtNroGuia.setText(objGuiaRemision.getStr_nroGuia());
        txtLocalSalida.setText(local);
        txtdireccionSalida.setText(direccion);
        txtResposableSalida.setText(objPersonal.getStr_apePaterno() + " "
                + objPersonal.getStr_apeMaterno() + " "
                + objPersonal.getStr_nombres());

        txtDireccioLlegada.setText(direccionLlegada);
        txtLocalLlegada.setText(localLlegada);
    }
}
