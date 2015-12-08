/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.bean;

import java.math.BigDecimal;

/**
 *
 * @author cesareo
 */
public class ProveedorProductoUnidadMedida {
    
    private int int_idProveedor;
    private int int_idProducto;
    private int int_idUnidadMedidaVenta;
    private String str_UnidadMedidaCompra;
    private BigDecimal dbl_costoCompra;
    private BigDecimal dbl_unidadesContenidas;
    private BigDecimal dbl_precioUnidadContenida;
    private BigDecimal dbl_costoTraslado;
    private BigDecimal dbl_precioFinal;
    private BigDecimal dbl_precioOferta;
    private String str_estado;
    private String str_usuarioCreador;
    private String str_fechaCreacion;
    private String str_usuarioModificador;
    private String str_fechaModificacion;
    private Proveedor objProveedor;
    private Producto objProducto;
    private UnidadMedida objUnidadMedidaVenta;

    public BigDecimal getDbl_precioOferta() {
        return dbl_precioOferta;
    }

    public void setDbl_precioOferta(BigDecimal dbl_precioOferta) {
        this.dbl_precioOferta = dbl_precioOferta;
    }

    public String getStr_UnidadMedidaCompra() {
        return str_UnidadMedidaCompra;
    }

    public void setStr_UnidadMedidaCompra(String str_UnidadMedidaCompra) {
        this.str_UnidadMedidaCompra = str_UnidadMedidaCompra;
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

    public UnidadMedida getObjUnidadMedidaVenta() {
        return objUnidadMedidaVenta;
    }

    public void setObjUnidadMedidaVenta(UnidadMedida objUnidadMedidaVenta) {
        this.objUnidadMedidaVenta = objUnidadMedidaVenta;
    }

    public BigDecimal getDbl_costoCompra() {
        return dbl_costoCompra;
    }

    public void setDbl_costoCompra(BigDecimal dbl_costoCompra) {
        this.dbl_costoCompra = dbl_costoCompra;
    }

    public BigDecimal getDbl_costoTraslado() {
        return dbl_costoTraslado;
    }

    public void setDbl_costoTraslado(BigDecimal dbl_costoTraslado) {
        this.dbl_costoTraslado = dbl_costoTraslado;
    }

    public BigDecimal getDbl_precioFinal() {
        return dbl_precioFinal;
    }

    public void setDbl_precioFinal(BigDecimal dbl_precioFinal) {
        this.dbl_precioFinal = dbl_precioFinal;
    }

    public BigDecimal getDbl_precioUnidadContenida() {
        return dbl_precioUnidadContenida;
    }

    public void setDbl_precioUnidadContenida(BigDecimal dbl_precioUnidadContenida) {
        this.dbl_precioUnidadContenida = dbl_precioUnidadContenida;
    }

    public BigDecimal getDbl_unidadesContenidas() {
        return dbl_unidadesContenidas;
    }

    public void setDbl_unidadesContenidas(BigDecimal dbl_unidadesContenidas) {
        this.dbl_unidadesContenidas = dbl_unidadesContenidas;
    }

    public int getInt_idProducto() {
        return int_idProducto;
    }

    public void setInt_idProducto(int int_idProducto) {
        this.int_idProducto = int_idProducto;
    }

    public int getInt_idProveedor() {
        return int_idProveedor;
    }

    public void setInt_idProveedor(int int_idProveedor) {
        this.int_idProveedor = int_idProveedor;
    }

    public int getInt_idUnidadMedidaVenta() {
        return int_idUnidadMedidaVenta;
    }

    public void setInt_idUnidadMedidaVenta(int int_idUnidadMedidaVenta) {
        this.int_idUnidadMedidaVenta = int_idUnidadMedidaVenta;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_fechaCreacion() {
        return str_fechaCreacion;
    }

    public void setStr_fechaCreacion(String str_fechaCreacion) {
        this.str_fechaCreacion = str_fechaCreacion;
    }

    public String getStr_fechaModificacion() {
        return str_fechaModificacion;
    }

    public void setStr_fechaModificacion(String str_fechaModificacion) {
        this.str_fechaModificacion = str_fechaModificacion;
    }

    public String getStr_usuarioCreador() {
        return str_usuarioCreador;
    }

    public void setStr_usuarioCreador(String str_usuarioCreador) {
        this.str_usuarioCreador = str_usuarioCreador;
    }

    public String getStr_usuarioModificador() {
        return str_usuarioModificador;
    }

    public void setStr_usuarioModificador(String str_usuarioModificador) {
        this.str_usuarioModificador = str_usuarioModificador;
    }
    
}
