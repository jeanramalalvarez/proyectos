/*
 * ConsultaVenta.java
 *
 * Created on 08-oct-2012, 1:30:43
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.List;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

/**
 *
 * @author YESM
 */
public class ConsultaVenta extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal gui;
    private String documento;

    public ConsultaVenta(Principal gui, String documento) {
        super(gui, true);
        this.gui = gui;
        this.documento = documento;
        initComponents();
        this.setTitle("" + gui.getTitle().concat(" - ").concat(" - [Modulo: Venta-Consulta Venta]"));
        cargarData();
    }

   
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtSalida = new org.jdesktop.swingx.JXTextArea();

        txtSalida.setColumns(20);
        txtSalida.setEditable(false);
        txtSalida.setRows(5);
        txtSalida.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSalidaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtSalida);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

private void txtSalidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalidaKeyPressed
    evento(evt);
}//GEN-LAST:event_txtSalidaKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTextArea txtSalida;
    // End of variables declaration//GEN-END:variables

    private void cargarData() {
        List<Object> listaConsulta = PaqueteBusinessDelegate.getVentasService().
                consultaVentaXDocumento(documento, gui.getLocal().getInt_idLocal());
        Ventas objVentas = null;

        if (listaConsulta.size() > 0) {
            objVentas = (Ventas) listaConsulta.get(0);
            imprimir();

            for (int i = 0; i < 68; i++) {
                imprimir("=");
            }

            imprimir("\n");
            imprimir("Cliente: \t" + objVentas.getObjCliente().getStr_razonSocial() + "\n");
            imprimir("Ruc/DNI: \t" + objVentas.getObjCliente().getStr_rucdni() + "\n");
            imprimir("Dirección: \t" + objVentas.getObjCliente().getStr_direccion() + "\n");
            imprimir("N° Documento: \t" + objVentas.getStr_numeroDocumento() + "\n");
            imprimir("Fecha: \t\t" + objVentas.getStr_fechaRegistro() + "\n");
            imprimir("Vendedor: \t" + objVentas.getStr_usuario() + "\n");


            for (int i = 0; i < 68; i++) {
                imprimir("=");
            }

            imprimir("\n");

            for (int i = 0; i < 68; i++) {
                imprimir("_");
            }

            imprimir("\n");
            imprimir("Codigo\t\tProducto\t\t\tCant.\tPrecio\tTotal\n");

            for (int i = 0; i < 68; i++) {
                imprimir("-");
            }

            imprimir("\n");
            BigDecimal subTotal = BigDecimal.ZERO;
            BigDecimal descuento = BigDecimal.ZERO;
            BigDecimal igv = BigDecimal.ZERO;
            for (Object object : listaConsulta) {
                objVentas = (Ventas) object;
                imprimir(objVentas.getObjProducto().getStr_codigoInterno() + "\t" + Util.arreglarCadena(
                        objVentas.getObjProducto().getStr_nombreProducto()) + "\t"
                        + objVentas.getDbCantidad() + "\t" + objVentas.getDbPrecio() + "\t"
                        + objVentas.getDbSubtotal() + "\n");
                subTotal = subTotal.add(objVentas.getDbSubtotal());
                descuento = descuento.add(objVentas.getDbdescuento()) ;
                igv = igv.add(objVentas.getDbIGV());
            }

            for (int i = 0; i < 68; i++) {
                imprimir("_");
            }

            imprimir("\n");
            imprimir("\t\t\t\t\t\tSub total: " + Util.redondeo(subTotal, 2) + "\n");
            imprimir("\t\t\t\t\t\tDescuento: " + Util.redondeo(descuento, 2) + "\n");
            imprimir("\t\t\t\t\t\tIGV: " + Util.redondeo(igv, 2) + "\n");
            imprimir("\t\t\t\t\t\t___________________\n");
            imprimir("\t\t\t\t\t\tTotal:     " + Util.redondeo((subTotal.subtract(descuento).add(igv)), 2));
        }
    }

    private void imprimir() {
        txtSalida.setText("");
    }

    private void imprimir(String s) {
        txtSalida.append(s);
    }

    private void evento(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F8) {
            enviarImprimir();
        }
    }

    private void enviarImprimir() {
        int objMensaje = Mensaje.confirmar(gui, "Desea Imprimir la Venta", Mensaje.TITULO_ME, Mensaje.YES_NO_OPTION, Mensaje.INFORMACION);

        if (objMensaje == Mensaje.YES_OPTION) {
            Util.imprimirTxtArea(gui, txtSalida);
        }
    }
}
