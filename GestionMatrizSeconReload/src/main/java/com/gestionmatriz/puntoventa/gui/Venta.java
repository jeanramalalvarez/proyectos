/*
 * Venta.java
 *
 * Created on 20-ago-2012, 14:15:06
 */
package com.gestionmatriz.puntoventa.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.puntoventa.opciones.Opciones;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Tabla;
import com.gestionmatriz.util.Util;

/**
 *
 * @author YESM
 */
public class Venta extends javax.swing.JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal gui;
    private BusquedaStock jdBusquedaStock;
    private PreVenta jdPreVenta;
    private BuscaProformas jdBuscaProformas;
    private List<Object> listaVenta = new ArrayList<>();

    public List<Object> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(List<Object> listaVenta) {
        this.listaVenta = listaVenta;
    }

    public Venta(Principal gui) {
        this.gui = gui;
        initComponents();
        this.setTitle("" + gui.getTitle().concat(" - ").concat(" - [Modulo: Venta]"));
    }

    @Override
    public void dispose() {
        super.dispose();
        gui.getBarraEstado().cerraVentana();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalleVenta = new com.gestionmatriz.util.Tabla();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtSubTotal = new org.jdesktop.swingx.JXTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        txtDescuento = new org.jdesktop.swingx.JXTextField();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        txtIGV = new org.jdesktop.swingx.JXTextField();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        txtTotal = new org.jdesktop.swingx.JXTextField();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setNextFocusableComponent(tbDetalleVenta);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        tbDetalleVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "U M", "Stock", "Precio", "Cantidad", "Afecto", "Desc %", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.math.BigDecimal.class, java.math.BigDecimal.class, java.math.BigDecimal.class, java.lang.Boolean.class, java.math.BigDecimal.class, java.math.BigDecimal.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDetalleVenta.setFont(new java.awt.Font("SansSerif", 1, 13));
        tbDetalleVenta.setNextFocusableComponent(tbDetalleVenta);
        tbDetalleVenta.setRowHeight(30);
        tbDetalleVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetalleVentaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbDetalleVentaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbDetalleVentaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetalleVenta);
        tbDetalleVenta.getColumn(0).setPreferredWidth(1);
        tbDetalleVenta.getColumn(1).setPreferredWidth(200);
        tbDetalleVenta.getColumn(2).setPreferredWidth(10);
        tbDetalleVenta.getColumn(3).setPreferredWidth(10);
        tbDetalleVenta.getColumn(4).setPreferredWidth(10);
        tbDetalleVenta.getColumn(5).setPreferredWidth(10);
        tbDetalleVenta.getColumn(6).setPreferredWidth(10);
        tbDetalleVenta.getColumn(7).setPreferredWidth(10);

        jXLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jXLabel1.setText("SubTotal: ");

        txtSubTotal.setBackground(new java.awt.Color(0, 0, 0));
        txtSubTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        txtSubTotal.setEditable(false);
        txtSubTotal.setForeground(new java.awt.Color(255, 102, 0));
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubTotal.setFont(new java.awt.Font("Consolas", 1, 24));

        jXLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jXLabel2.setText("Descuento (-):");

        txtDescuento.setBackground(new java.awt.Color(0, 0, 0));
        txtDescuento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        txtDescuento.setEditable(false);
        txtDescuento.setForeground(new java.awt.Color(255, 102, 0));
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescuento.setFont(new java.awt.Font("Consolas", 1, 24));

        jXLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jXLabel3.setText("IGV (+): ");

        txtIGV.setBackground(new java.awt.Color(0, 0, 0));
        txtIGV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        txtIGV.setEditable(false);
        txtIGV.setForeground(new java.awt.Color(255, 102, 0));
        txtIGV.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIGV.setFont(new java.awt.Font("Consolas", 1, 24));

        jXLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jXLabel4.setText("Total");

        txtTotal.setBackground(new java.awt.Color(0, 0, 0));
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        txtTotal.setEditable(false);
        txtTotal.setForeground(new java.awt.Color(255, 102, 0));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setFont(new java.awt.Font("Consolas", 1, 24));

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Opciones"));

        jXLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel5.setText("F9=Buscar Producto");

        jXLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel6.setText("F6=Enviar Venta");

        jXLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel7.setText("SUPR=Quitar Producto");

        jXLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel8.setText("F12=SALIR");

        jXLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel9.setText("F11=Buscar Proforma");

        jXLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel10.setText("F10=Consulta Venta");

        jXLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel11.setText("F7=Consultar Mis Ventas");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jXLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                    .addComponent(txtIGV, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(89, Short.MAX_VALUE))
                    .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    evento(evt);
}//GEN-LAST:event_formKeyPressed

private void tbDetalleVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleVentaKeyPressed
    calcularDescuento();
    evento(evt);
}//GEN-LAST:event_tbDetalleVentaKeyPressed

private void tbDetalleVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleVentaKeyReleased
    evento(evt);
}//GEN-LAST:event_tbDetalleVentaKeyReleased

private void tbDetalleVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleVentaKeyTyped
    evento(evt);
}//GEN-LAST:event_tbDetalleVentaKeyTyped
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel10;
    private org.jdesktop.swingx.JXLabel jXLabel11;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private com.gestionmatriz.util.Tabla tbDetalleVenta;
    private org.jdesktop.swingx.JXTextField txtDescuento;
    private org.jdesktop.swingx.JXTextField txtIGV;
    private org.jdesktop.swingx.JXTextField txtSubTotal;
    private org.jdesktop.swingx.JXTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void evento(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F9) {
            abrirBusquedaStock();
            tbDetalleVenta.setFocusable(false);
        } else if (evt.getKeyCode() == KeyEvent.VK_F12 || evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            cerrarVentana();
        } else if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            quitarProducto();
        } else if (evt.getKeyCode() == KeyEvent.VK_F6) {
            abrirBusquedaCliente();
        } else if (evt.getKeyCode() == KeyEvent.VK_F11) {
            cargarBusquedaProformas();
        } else if (evt.getKeyCode() == KeyEvent.VK_F10) {
            consultaVentaXDocumento();
        } else if (evt.getKeyCode() == KeyEvent.VK_F7) {
            consultarMisVentas();
        }
    }

    private void abrirBusquedaStock() {
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getVENTA_BUSCAR_PRODUCTO())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        if (jdBusquedaStock == null) {
            jdBusquedaStock = new BusquedaStock(gui, this);
        }

        jdBusquedaStock.setVisible(true);
    }

    private void abrirBusquedaCliente() {
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getVENTA_ENVIAR_VENTA())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        if (listaVenta.isEmpty()) {
            Mensaje.mensaje(gui, "Lista no cuenta con pedidos", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }

        if (jdPreVenta == null) {
            jdPreVenta = new PreVenta(gui, this);
        }

        jdPreVenta.setVisible(true);
    }

    private void cerrarVentana() {
        Object objRespuesta = Mensaje.confirmar(gui, "Desea salir de ventas", Mensaje.TITULO_ME, Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);

        if (objRespuesta.equals(Mensaje.YES_OPTION)) {
            this.dispose();
        }
    }

    public Tabla getTbDetalleVenta() {
        return tbDetalleVenta;
    }

    public void setTbDetalleVenta(Tabla tbDetalleVenta) {
        this.tbDetalleVenta = tbDetalleVenta;
    }

    public void realizarCalculo() {
        BigDecimal dblSubTotal = BigDecimal.ZERO;
        BigDecimal dblIgv = BigDecimal.ZERO;
        BigDecimal dblDescuento = BigDecimal.ZERO;
        Ventas objVentas = null;

        for (Object object : listaVenta) {
            objVentas = (Ventas) object;
            dblSubTotal =dblSubTotal.add(objVentas.getDbSubtotal()) ;
            dblIgv = dblIgv.add(objVentas.getDbIGV()) ;
            dblDescuento =dblDescuento.add(objVentas.getDbdescuento()) ;
        }

        txtSubTotal.setText(Util.redondeo((dblSubTotal), 2));
        txtIGV.setText(Util.redondeo((dblIgv), 2));
        txtDescuento.setText(Util.redondeo((dblDescuento), 2));
        txtTotal.setText(Util.redondeo((dblSubTotal.add(dblIgv).subtract(dblDescuento)), 2));
    }

    private void quitarProducto() {
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getVENTA_QUITA_PRODUCTO())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        Object objRespuesta = Mensaje.confirmar(gui, "Desea quitar el producto de la lista de pedido", Mensaje.TITULO_ME, Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);
        int fila = tbDetalleVenta.getSelectedRow();

        if (fila == -1) {
            return;
        }

        if (objRespuesta.equals(Mensaje.YES_OPTION)) {
            listaVenta.remove(fila);
            tbDetalleVenta.listar(listaVenta);
            realizarCalculo();
        }
    }

    public void requestFocus() {
        tbDetalleVenta.setFocusable(true);
        tbDetalleVenta.requestFocus();
    }

    private void calcularDescuento() {
    }

    private void cargarBusquedaProformas() {
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getVENTA_BUSCAR_PROFORMA())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        if (jdBuscaProformas == null) {
            jdBuscaProformas = new BuscaProformas(gui);
        }

        jdBuscaProformas.setVisible(true);
    }

    private void consultaVentaXDocumento() {
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getVENTA_CONSULTAR_VENTA())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
        
        String documento = JOptionPane.showInputDialog(gui, "Ingresar al Numero de Documento a Buscar", "");

        if (documento == null) {
            return;
        }

        ConsultaVenta objConsultaVenta = new ConsultaVenta(gui, documento);
        objConsultaVenta.setVisible(true);
    }

    private void consultarMisVentas() {
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getVENTA_CONSULTAR_MISVENTAS())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            return;
        }
    }
}
