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

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.ConsultaStock;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;
import java.math.RoundingMode;

/**
 *
 * @author YESM
 */
public class PrecargaProducto extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(PrecargaProducto.class); 
    private Principal  gui;
    ConsultaStock objConsultaStock;
    private Venta guiVenta;
    
    public PrecargaProducto(Principal gui,Venta guiVenta) {
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
        txtCodigo = new org.jdesktop.swingx.JXTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtProducto = new org.jdesktop.swingx.JXTextField();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        txtFabricante = new org.jdesktop.swingx.JXTextField();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        txtCodProveedor = new org.jdesktop.swingx.JXTextField();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        txtProveedor = new org.jdesktop.swingx.JXTextField();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        txtCodUnidadMedida = new org.jdesktop.swingx.JXTextField();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        txtUnidadMendida = new org.jdesktop.swingx.JXTextField();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        txtPrecio = new org.jdesktop.swingx.JXTextField();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        txtStock = new org.jdesktop.swingx.JXTextField();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        txtCantidad = new org.jdesktop.swingx.JXTextField();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        cboDescuento = new org.jdesktop.swingx.JXComboBox();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        cboSI = new javax.swing.JRadioButton();
        cboNO = new javax.swing.JRadioButton();

        setType(java.awt.Window.Type.UTILITY);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Producto"));

        jXLabel1.setText("Codigo: ");
        jXLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtCodigo.setEditable(false);
        txtCodigo.setForeground(new java.awt.Color(255, 153, 0));
        txtCodigo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel2.setText("Descripción: ");
        jXLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtProducto.setEditable(false);
        txtProducto.setForeground(new java.awt.Color(255, 153, 0));
        txtProducto.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel3.setText("Fabricante: ");
        jXLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtFabricante.setEditable(false);
        txtFabricante.setForeground(new java.awt.Color(255, 153, 0));
        txtFabricante.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel4.setText("Cod. Proveedor: ");
        jXLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtCodProveedor.setEditable(false);
        txtCodProveedor.setForeground(new java.awt.Color(255, 153, 0));
        txtCodProveedor.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel5.setText("Nombre Proveedor: ");
        jXLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtProveedor.setEditable(false);
        txtProveedor.setForeground(new java.awt.Color(255, 153, 0));
        txtProveedor.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel6.setText("Cod. Unidad Medida: ");
        jXLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtCodUnidadMedida.setEditable(false);
        txtCodUnidadMedida.setForeground(new java.awt.Color(255, 153, 0));
        txtCodUnidadMedida.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel7.setText("Unidad Medida: ");
        jXLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtUnidadMendida.setEditable(false);
        txtUnidadMendida.setForeground(new java.awt.Color(255, 153, 0));
        txtUnidadMendida.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel8.setText("Precio: ");
        jXLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtPrecio.setEditable(false);
        txtPrecio.setForeground(new java.awt.Color(255, 153, 0));
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecio.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel9.setText("Stock: ");
        jXLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtStock.setEditable(false);
        txtStock.setForeground(new java.awt.Color(255, 153, 0));
        txtStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtStock.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXLabel10.setText("Cantidad Solicitada: ");
        jXLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        txtCantidad.setForeground(new java.awt.Color(255, 153, 0));
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCantidad.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jXLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel11.setText("[F9]=CARGAR PRODUCTO");

        jXLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel12.setText("[ESC]=REGRESAR");

        jXLabel13.setText("Descuento (%): ");
        jXLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("¿IGV Incluido?"));

        buttonGroup1.add(cboSI);
        cboSI.setSelected(true);
        cboSI.setText("SI");

        buttonGroup1.add(cboNO);
        cboNO.setText("NO");

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboNO)
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cboSI)
                .addComponent(cboNO))
        );

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXPanel1Layout.createSequentialGroup()
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUnidadMendida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodUnidadMedida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtFabricante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnidadMendida, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    evento(evt);
}//GEN-LAST:event_formKeyReleased

private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    evento(evt);
}//GEN-LAST:event_formKeyPressed

private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
    evento(evt);
}//GEN-LAST:event_txtCantidadKeyReleased

private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
    evento(evt);
}//GEN-LAST:event_txtCantidadKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXComboBox cboDescuento;
    private javax.swing.JRadioButton cboNO;
    private javax.swing.JRadioButton cboSI;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel10;
    private org.jdesktop.swingx.JXLabel jXLabel11;
    private org.jdesktop.swingx.JXLabel jXLabel12;
    private org.jdesktop.swingx.JXLabel jXLabel13;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXTextField txtCantidad;
    private org.jdesktop.swingx.JXTextField txtCodProveedor;
    private org.jdesktop.swingx.JXTextField txtCodUnidadMedida;
    private org.jdesktop.swingx.JXTextField txtCodigo;
    private org.jdesktop.swingx.JXTextField txtFabricante;
    private org.jdesktop.swingx.JXTextField txtPrecio;
    private org.jdesktop.swingx.JXTextField txtProducto;
    private org.jdesktop.swingx.JXTextField txtProveedor;
    private org.jdesktop.swingx.JXTextField txtStock;
    private org.jdesktop.swingx.JXTextField txtUnidadMendida;
    // End of variables declaration//GEN-END:variables

    public void cargarData(ConsultaStock objConsultaStock) {
        this.objConsultaStock=objConsultaStock;
        
        txtCodigo.setText(String.valueOf(objConsultaStock.getObjProducto().getInt_idProducto()));
        txtProducto.setText(objConsultaStock.getObjProducto().getStr_nombreProducto());
        txtFabricante.setText(objConsultaStock.getObjProducto().getStr_fabricante());
        txtCodProveedor.setText(String.valueOf(objConsultaStock.getObjProveedor().getInt_idProveedor()));
        txtProveedor.setText(objConsultaStock.getObjProveedor().getStr_razonSocial());
        txtCodUnidadMedida.setText(String.valueOf(objConsultaStock.getObjUnidadMedida().getInt_idUnidadMedida()));
        txtUnidadMendida.setText(objConsultaStock.getObjUnidadMedida().getStr_nombreUM());
        txtPrecio.setText(String.valueOf( objConsultaStock.getDbl_precio()));
        txtStock.setText(Util.redondeo((objConsultaStock.getDbl_stock()),2));
        
        txtCantidad.requestFocus();
        txtCantidad.setText("1");
        
        cboDescuento.removeAllItems();
        
        for (BigDecimal i=BigDecimal.ZERO;i.compareTo(objConsultaStock.getDbl_DescuentoPermitido())<=0;i=i.add(BigDecimal.ONE)){
            cboDescuento.addItem(i);
        }
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
            
            try{
                Util.stringTOBigDecimal(txtCantidad.getText());
            }
            catch(NumberFormatException ex){
                log.error("Error: "+ex.getMessage());
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
            txtCantidad.setText("");
            guiVenta.requestFocus();
            this.setVisible(false);
            
            return;
        }
        
        Ventas objVentas=new Ventas();
        
        BigDecimal dbCantidad=Util.stringTOBigDecimal(txtCantidad.getText());
        
        if (dbCantidad.compareTo(this.objConsultaStock.getDbl_stock())==1   || dbCantidad.compareTo(BigDecimal.ZERO)==0){
            Mensaje.mensaje(gui, "Cantidad Solicitada es superior al Stock", Mensaje.TITULO_ME, Mensaje.ERROR);
            txtCantidad.setText("");
            guiVenta.requestFocus();
            this.setVisible(false);
            return;
        }
            
        objVentas.setObjProveedor(this.objConsultaStock.getObjProveedor());
        objVentas.setObjProducto(this.objConsultaStock.getObjProducto());
        objVentas.setDbCantidad(Util.stringTOBigDecimal(txtCantidad.getText()));
        objVentas.setDbPrecio(this.objConsultaStock.getDbl_precio());
        objVentas.setDbStock(this.objConsultaStock.getDbl_stock());
        objVentas.setObjUnidadMedida(this.objConsultaStock.getObjUnidadMedida());
        objVentas.setDbUnidadesContenidas(this.objConsultaStock.getDlb_stockXCompra());
        
        
        
        if (objVentas.getObjProducto().getStr_reintegroTributario().equals("NO")){
            if (cboSI.isSelected()){
                objVentas.setDbSubtotal(Util.stringTOBigDecimal(Util.redondeo(objVentas.getDbPrecio().multiply(objVentas.getDbCantidad())
                        .divide(porIGV.add(BigDecimal.ONE),4,RoundingMode.HALF_UP), 2)) );
                objVentas.setDbIGV(new BigDecimal( Util.redondeo(objVentas.getDbSubtotal().multiply(porIGV), 2)));   
            }else{
                objVentas.setDbSubtotal(Util.stringTOBigDecimal(Util.redondeo(objVentas.getDbPrecio().multiply(objVentas.getDbCantidad()), 2)) );
                objVentas.setDbIGV(new BigDecimal( Util.redondeo(objVentas.getDbSubtotal().multiply(porIGV),2)));   
            }
        } else{
            objVentas.setDbIGV(BigDecimal.ZERO);
        }
        
        
        objVentas.setDbdescuento(Util.stringTOBigDecimal(
                Util.redondeo(objVentas.getDbSubtotal().multiply(Util.stringTOBigDecimal(cboDescuento.getSelectedItem().toString())).divide(new BigDecimal(100)),1))
                );
        
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
}
