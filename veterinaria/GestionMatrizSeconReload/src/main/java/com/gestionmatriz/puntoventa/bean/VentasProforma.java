/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.bean;

import java.math.BigDecimal;

import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.bean.UnidadMedida;
import com.gestionmatriz.recursoshumanos.bean.Local;

/**
 *
 * @author YESM
 */
public class VentasProforma {

    private int int_idVenta;
    private Proveedor objProveedor;
    private Producto objProducto;
    private Cliente objCliente;
    private BigDecimal dbCantidad;
    private BigDecimal dbPrecio;
    private BigDecimal dbSubtotal;
    private BigDecimal dbdescuento;
    private BigDecimal dbIGV;
    private BigDecimal dbTotal;
    private BigDecimal dbStock;
    private DocumentoSalida objDocumentoSalida;
    private String str_numeroDocumento;
    private UnidadMedida objUnidadMedida;
    private String str_usuario;
    private BigDecimal dbUnidadesContenidas;
    private String str_clienteResponsable;
    private Local objLocal;
    private String str_estado;
    private String str_fechaRegistro;
    private String str_fechaModificacion;
    private BigDecimal dbl_precio2;

    public BigDecimal getDbl_precio2() {
        return dbl_precio2;
    }

    public void setDbl_precio2(BigDecimal dbl_precio2) {
        this.dbl_precio2 = dbl_precio2;
    }
    
    

    public String getStr_fechaModificacion() {
        return str_fechaModificacion;
    }

    public void setStr_fechaModificacion(String str_fechaModificacion) {
        this.str_fechaModificacion = str_fechaModificacion;
    }

    public String getStr_fechaRegistro() {
        return str_fechaRegistro;
    }

    public void setStr_fechaRegistro(String str_fechaRegistro) {
        this.str_fechaRegistro = str_fechaRegistro;
    }
    
    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public Local getObjLocal() {
        return objLocal;
    }

    public void setObjLocal(Local objLocal) {
        this.objLocal = objLocal;
    }

    public String getStr_clienteResponsable() {
        return str_clienteResponsable;
    }

    public void setStr_clienteResponsable(String str_clienteResponsable) {
        this.str_clienteResponsable = str_clienteResponsable;
    }

    public BigDecimal getDbUnidadesContenidas() {
        return dbUnidadesContenidas;
    }

    public void setDbUnidadesContenidas(BigDecimal dbUnidadesContenidas) {
        this.dbUnidadesContenidas = dbUnidadesContenidas;
    }

    public String getStr_usuario() {
        return str_usuario;
    }

    public void setStr_usuario(String str_usuario) {
        this.str_usuario = str_usuario;
    }

    public BigDecimal getDbStock() {
        return dbStock;
    }

    public void setDbStock(BigDecimal dbStock) {
        this.dbStock = dbStock;
    }

    public UnidadMedida getObjUnidadMedida() {
        return objUnidadMedida;
    }

    public void setObjUnidadMedida(UnidadMedida objUnidadMedida) {
        this.objUnidadMedida = objUnidadMedida;
    }

    public BigDecimal getDbCantidad() {
        return dbCantidad;
    }

    public void setDbCantidad(BigDecimal dbCantidad) {
        this.dbCantidad = dbCantidad;
    }

    public BigDecimal getDbIGV() {
        return dbIGV;
    }

    public void setDbIGV(BigDecimal dbIGV) {
        this.dbIGV = dbIGV;
    }

    public BigDecimal getDbPrecio() {
        return dbPrecio;
    }

    public void setDbPrecio(BigDecimal dbPrecio) {
        this.dbPrecio = dbPrecio;
    }

    public BigDecimal getDbSubtotal() {
        return dbSubtotal;
    }

    public void setDbSubtotal(BigDecimal dbSubtotal) {
        this.dbSubtotal = dbSubtotal;
    }

    public BigDecimal getDbTotal() {
        return dbTotal;
    }

    public void setDbTotal(BigDecimal dbTotal) {
        this.dbTotal = dbTotal;
    }

    public BigDecimal getDbdescuento() {
        return dbdescuento;
    }

    public void setDbdescuento(BigDecimal dbdescuento) {
        this.dbdescuento = dbdescuento;
    }

    public int getInt_idVenta() {
        return int_idVenta;
    }

    public void setInt_idVenta(int int_idVenta) {
        this.int_idVenta = int_idVenta;
    }

    public Cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
    }

    public DocumentoSalida getObjDocumentoSalida() {
        return objDocumentoSalida;
    }

    public void setObjDocumentoSalida(DocumentoSalida objDocumentoSalida) {
        this.objDocumentoSalida = objDocumentoSalida;
    }

    public Producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(Producto objProducto) {
        this.objProducto = objProducto;
    }

    public Proveedor getObjProveedor() {
        return objProveedor;
    }

    public void setObjProveedor(Proveedor objProveedor) {
        this.objProveedor = objProveedor;
    }

    public String getStr_numeroDocumento() {
        return str_numeroDocumento;
    }

    public void setStr_numeroDocumento(String str_numeroDocumento) {
        this.str_numeroDocumento = str_numeroDocumento;
    }
}
