/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PrecargaProducto.java
 *
 * Created on 23-ago-2012, 17:13:20
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.Cliente;
import com.gestionmatriz.puntoventa.bean.ConsultaStock;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;

/**
 *
 * @author YESM
 */
public class PrecargaCliente extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(PrecargaCliente.class); 
    private Principal  gui;
    ConsultaStock objConsultaStock;
    private Venta guiVenta;
    private Cliente objCliente = null;
    
    public PrecargaCliente(Principal gui,Venta guiVenta) {
        super(gui);
        this.gui=gui;
        this.guiVenta=guiVenta;
        initComponents();
        this.setTitle(""+gui.getTitle().concat(" - ").concat(" - [Modulo: Precarga Producto]"));
        setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtCliente = new org.jdesktop.swingx.JXTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtRucDNI = new org.jdesktop.swingx.JXTextField();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        txtClienteResponsable = new org.jdesktop.swingx.JXTextField();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        btnBuscar = new javax.swing.JButton();

        setType(java.awt.Window.Type.UTILITY);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));

        jXLabel1.setText("Cliente: ");
        jXLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtCliente.setEditable(false);
        txtCliente.setForeground(new java.awt.Color(255, 153, 0));
        txtCliente.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel2.setText("RUC / DNI: ");
        jXLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtRucDNI.setEditable(false);
        txtRucDNI.setForeground(new java.awt.Color(255, 153, 0));
        txtRucDNI.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel3.setText("Cliente: ");
        jXLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtClienteResponsable.setEditable(false);
        txtClienteResponsable.setForeground(new java.awt.Color(255, 153, 0));
        txtClienteResponsable.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel11.setText("[F9]=CARGAR CLIENTE");
        jXLabel11.setToolTipText("");

        jXLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel12.setText("[ESC]=REGRESAR");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/minibuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar (F4)");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarrbnBoletaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtClienteResponsable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRucDNI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRucDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClienteResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jXPanel1.getAccessibleContext().setAccessibleName("Datos Clientes");

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    evento(evt);
}//GEN-LAST:event_formKeyReleased

private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    evento(evt);
}//GEN-LAST:event_formKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        cargarBusquedaCliente();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarrbnBoletaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarrbnBoletaKeyPressed
        evento(evt);
    }//GEN-LAST:event_btnBuscarrbnBoletaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel11;
    private org.jdesktop.swingx.JXLabel jXLabel12;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXTextField txtCliente;
    private org.jdesktop.swingx.JXTextField txtClienteResponsable;
    private org.jdesktop.swingx.JXTextField txtRucDNI;
    // End of variables declaration//GEN-END:variables

    public void cargarData(ConsultaStock objConsultaStock) {
        this.objConsultaStock=objConsultaStock;
        
        txtCliente.setText(String.valueOf(objConsultaStock.getObjProducto().getInt_idProducto()));
        txtRucDNI.setText(objConsultaStock.getObjProducto().getStr_nombreProducto());
        txtClienteResponsable.setText(objConsultaStock.getObjProducto().getStr_fabricante());

    }

    private void evento(KeyEvent evt) {
        
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            salirPrecargaProducto();
        }
        else if (evt.getKeyCode()==KeyEvent.VK_F9){
            if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCARGAR_PRODUCTO())) {
                Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
                return;
            }
            
            cargarProductoVenta();
        }
    }

    private void salirPrecargaProducto() {
        
       this.setVisible(false);
        guiVenta.getTbDetalleVenta().setFocusable(true);
        guiVenta.requestFocus();
    }
    
    
    public void setVisible(boolean b){
        super.setVisible(b);
//        if (!b)
//            guiVenta.requestFocus();
//        
//        txtCantidad.requestFocus();
    }

    private void cargarProductoVenta() {
        BigDecimal porIGV = PaqueteBusinessDelegate.getConfigBDService().getIGV();
        if (validarDuplicado()){
            
            Mensaje.mensaje
                    (gui, "Producto ya se encuentra agregado a la lista de pedido", Mensaje.TITULO_ME, Mensaje.ERROR);
            guiVenta.requestFocus();
            this.setVisible(false);
            
            return;
        }
        
        Ventas objVentas=new Ventas();
            
        objVentas.setObjProveedor(this.objConsultaStock.getObjProveedor());
        objVentas.setObjProducto(this.objConsultaStock.getObjProducto());
        objVentas.setDbPrecio(this.objConsultaStock.getDbl_precio());
        objVentas.setDbStock(this.objConsultaStock.getDbl_stock());
        objVentas.setObjUnidadMedida(this.objConsultaStock.getObjUnidadMedida());
        objVentas.setDbUnidadesContenidas(this.objConsultaStock.getDlb_stockXCompra());
        
        guiVenta.getListaVenta().add(objVentas);
        guiVenta.getTbDetalleVenta().listar(guiVenta.getListaVenta());
        guiVenta.realizarCalculo();
        this.setVisible(false);
        guiVenta.requestFocus();
    }
    
    private boolean validarDuplicado(){
        Ventas objVentas;

        for (Object obj:guiVenta.getListaVenta()){
            objVentas=(Ventas) obj;
            if (objConsultaStock.getObjProducto().getInt_idProducto()==
                    objVentas.getObjProducto().getInt_idProducto())
                return true;
        }
        
        return false;
    }
    
    protected void cargarDatosBusquedaCliente(Cliente objC) {
        txtCliente.setText(objC.getStr_razonSocial());
        txtRucDNI.setText(objC.getStr_rucdni());
        txtClienteResponsable.setText(objC.getStr_razonSocial());
        this.objCliente = objC;
    }
    
    private void cargarBusquedaCliente() {
        try {
            List<Cliente> listaCliente = PaqueteBusinessDelegate.getClienteService().listarCliente("", "", "", "");

            if (listaCliente.isEmpty()) {
                Mensaje.mensaje(this, "No existen Clientes", Mensaje.TITULO_ME, Mensaje.INFORMACION);
            } else if (listaCliente.size() == 1) {
                cargarDatosBusquedaCliente(listaCliente.get(0));
            } else if (listaCliente.size() > 1) {
//                Util.hiloProgressBar(1, gui);
                BuscarCliente frmBuscarCliente = new BuscarCliente(gui, listaCliente, this);
//                Util.hiloProgressBar(0, gui);
                frmBuscarCliente.cargarPanelBusquedaCliente(listaCliente);
                frmBuscarCliente.setVisible(true);
            }
        } catch (Exception ex) {
        	log.error("Error: "+ex.getMessage());
        }
    }
}
