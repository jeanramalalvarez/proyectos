/*
 * ProgramarLetras.java
 *
 * Created on 14-jul-2012, 12:16:30
 */
package com.gestionmatriz.almacen.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.log4j.Logger;

import com.gestionmatriz.almacen.bean.CronogramaPagos;
import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.opciones.Opciones;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.util.FormatoFecha;
import com.gestionmatriz.util.Mensaje;

/**
 *
 * @author cesareo
 */
public class ProgramarLetras extends javax.swing.JDialog {

	private static final Logger log=Logger.getLogger(ProgramarLetras.class);
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Principal gui;
    private int numeroLetras;
    private BigDecimal precioTotal;
    private BigDecimal suma;
    private Proveedor objProveedor;
    private int usuario;
    protected static List<CronogramaPagos> listaCronogramaPagos = new ArrayList<>();
    private CronogramaPagos objCronogramaPagos = null;
    private boolean verificar = false;

    public ProgramarLetras(Principal gui, int numeroLetras, BigDecimal precioTotal,
            Proveedor objProveedor, int usuario) {
        super(gui, true);
        this.gui = gui;
        this.numeroLetras = numeroLetras;
        this.precioTotal = precioTotal;
        this.objProveedor = objProveedor;
        this.usuario = usuario;
        initComponents();
        cargarDatos();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtProveedorNombre = new org.jdesktop.swingx.JXTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLetras = new org.jdesktop.swingx.JXTable();
        lblNumeroFactura = new org.jdesktop.swingx.JXLabel();
        txtNumeroFactura = new org.jdesktop.swingx.JXTextField();
        btnCancelar = new org.jdesktop.swingx.JXButton();
        btnAceptar = new org.jdesktop.swingx.JXButton();
        txtPrecioTotal = new org.jdesktop.swingx.JXTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Programar Letras");

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jXLabel1.setText("Proveedor:");

        tblLetras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "N° Letras", "Fecha emisión", "Días calendario", "Fecha vencimiento", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.math.BigDecimal.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLetras.setColumnControlVisible(true);
        tblLetras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblLetrasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblLetras);

        lblNumeroFactura.setText("N° Factura:");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/eliminar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jXLabel2.setText("Precio Total:");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProveedorNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProveedorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    listaCronogramaPagos.clear();
    setVisible(false);
}//GEN-LAST:event_btnCancelarActionPerformed

private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
    if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getPROGRAMARLETRA())) {
        Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
        return;
    }
    
    verificarMonto();
    verificarDiasNulos();

    if (verificar || !verificarDiasCalendario()) {
        return;
    }
    
    listaCronogramaPagos.clear();

    for (int i = 0; i < tblLetras.getRowCount(); i++) {
        objCronogramaPagos = new CronogramaPagos();
        objCronogramaPagos.setInt_diasCalendario(Integer.parseInt(tblLetras.getValueAt(i, 3).toString()));
        objCronogramaPagos.setStr_fechaVencimiento(tblLetras.getValueAt(i, 4).toString());
        objCronogramaPagos.setDbl_monto(new BigDecimal(tblLetras.getValueAt(i, 5).toString()));

        listaCronogramaPagos.add(objCronogramaPagos);
    }

    setVisible(false);
}//GEN-LAST:event_btnAceptarActionPerformed

private void tblLetrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblLetrasKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        verificarDiasNulos();
        verificarDiasCorrelativos();
        calcularDiasCalendario();
        verificarMonto();
    }
}//GEN-LAST:event_tblLetrasKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAceptar;
    private org.jdesktop.swingx.JXButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXLabel lblNumeroFactura;
    private org.jdesktop.swingx.JXTable tblLetras;
    private org.jdesktop.swingx.JXTextField txtNumeroFactura;
    private org.jdesktop.swingx.JXTextField txtPrecioTotal;
    private org.jdesktop.swingx.JXTextField txtProveedorNombre;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
        txtProveedorNombre.setText(objProveedor.getStr_razonSocial());
        txtProveedorNombre.setEditable(false);
        txtPrecioTotal.setText(String.valueOf(precioTotal));
        txtPrecioTotal.setEditable(false);
        tblLetras.setSortable(false);
        
        if (usuario == 1) {
            lblNumeroFactura.setVisible(false);
            txtNumeroFactura.setVisible(false);
            cargarTablaLogistica();
        } else if (usuario == 2) {
            cargarTablaLetras();
        }
    }

    private void cargarFecha() {
        try {
            TableColumn estadoColumna = tblLetras.getColumnModel().getColumn(2);
            JFormattedTextField textField = new JFormattedTextField(new FormatoFecha());
            textField.setValue(new Date());
            estadoColumna.setCellEditor(new DefaultCellEditor(textField));

            TableColumn estadoColumna2 = tblLetras.getColumnModel().getColumn(4);
            JFormattedTextField textField2 = new JFormattedTextField(new FormatoFecha());
            textField2.setValue(new Date());
            estadoColumna2.setCellEditor(new DefaultCellEditor(textField2));
        } catch (ParseException ex) {
            log.error("ERROR: "+ex.getMessage());
        }
    }

    private void cargarTablaLogistica() {
        Object[] filaTabla = new Object[6];
        DefaultTableModel modelo = (DefaultTableModel) tblLetras.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (int i = 0; i < numeroLetras; i++) {
            filaTabla[0] = i + 1; //int
            filaTabla[1] = 0; //int
            filaTabla[2] = null; //Object
            filaTabla[3] = 0; //int
            filaTabla[4] = null; //Object
            filaTabla[5] = 0; //BigDecimal
            modelo.addRow(filaTabla);
        }

        calcularMonto();

        tblLetras.setModel(modelo);

        tblLetras.getColumnModel().getColumn(1).setMaxWidth(0);
        tblLetras.getColumnModel().getColumn(1).setMinWidth(0);
        tblLetras.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tblLetras.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);

        tblLetras.getColumnModel().getColumn(2).setMaxWidth(0);
        tblLetras.getColumnModel().getColumn(2).setMinWidth(0);
        tblLetras.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        tblLetras.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
    }

    private void cargarTablaLetras() {
    }

    private void calcularMonto() {
        String[] arrPrecio;
        String precioGuion = String.valueOf(precioTotal .divide(new BigDecimal( numeroLetras) )).replace(".", "-");
        arrPrecio = precioGuion.split("-");

        for (int i = 0; i < tblLetras.getRowCount(); i++) {
            if (i < (numeroLetras - 1)) {
                tblLetras.setValueAt(new BigDecimal(arrPrecio[0]), i, 5);
            } else if (i == (numeroLetras - 1)) {
                tblLetras.setValueAt(precioTotal.subtract(new BigDecimal(Integer.parseInt(arrPrecio[0]) * (numeroLetras - 1))), i, 5);
            }
        }
    }

    private void verificarMonto() {
        suma = BigDecimal.ZERO;

        for (int i = 0; i < tblLetras.getRowCount(); i++) {
            suma= suma.add(new BigDecimal(tblLetras.getValueAt(i, 5).toString()));
        }

        if (suma != precioTotal) {
            Object obj1 = Mensaje.confirmar(this, "Montos ingresados suman distinto al Precio Total... ¿Desea Recalcular?",
                    Mensaje.TITULO_ME, Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);
            if (!obj1.equals(Mensaje.YES_OPTION)) {
                verificar = true;
                return;
            } else {
                verificar = false;
                calcularMonto();
            }
        }
    }

    private void verificarDiasCorrelativos() {
        int numeroFilas = tblLetras.getRowCount();
        
        if (numeroFilas > 1) {
            for (int i = 0; i < numeroFilas; i++) {
                if (i > 0) {
                    if (Integer.parseInt(tblLetras.getValueAt(i, 3).toString()) < Integer.parseInt(tblLetras.getValueAt(i - 1, 3).toString())) {
//                        Mensaje.mensaje(this, "Ingresar cantidad mayor a la anterior", Mensaje.TITULO_ME, Mensaje.ERROR);
                        tblLetras.setValueAt(Integer.parseInt(tblLetras.getValueAt(i - 1, 3).toString()) + 5, i, 3);
                    }
                }
            }
        }
    }
    
    private void verificarDiasNulos() {
        for (int i = 0; i < tblLetras.getRowCount(); i++) {
            if (tblLetras.getValueAt(i, 3) == null) {
                tblLetras.setValueAt(0, i, 3);
            }
        }
    }
    
    private void calcularDiasCalendario() {
        for (int i = 0; i < tblLetras.getRowCount(); i++) {
            String fechaServidor = (PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql()).substring(0, 10);
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = null;

            try {
                fecha = formatoDelTexto.parse(fechaServidor);
            } catch (ParseException ex) {
                log.error("Excepcion: " + ex.getMessage());
            }

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c1 = Calendar.getInstance();
            c1.setTime(fecha);

            if (tblLetras.getValueAt(i, 3) != null) {
                int dias = Integer.parseInt(tblLetras.getValueAt(i, 3).toString());
                c1.add(Calendar.DATE, dias);
                tblLetras.setValueAt(formato.format(c1.getTime()), i, 4);
            }
        }
    }

    private boolean verificarDiasCalendario() {
        for (int i = 0; i < tblLetras.getRowCount(); i++) {
            if ((tblLetras.getValueAt(i, 3) == null) || (Integer.parseInt(tblLetras.getValueAt(i, 3).toString()) == 0)) {
                Mensaje.mensaje(this, "Falta llenar datos en Dias Calendario", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                return false;
            }
        }

        return true;
    }
    
}
