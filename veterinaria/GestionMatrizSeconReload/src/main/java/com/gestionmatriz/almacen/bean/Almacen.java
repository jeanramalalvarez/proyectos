/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.bean;

import java.math.BigDecimal;

import com.gestionmatriz.recursoshumanos.bean.Local;

/**
 *
 * @author zholo
 */
public class Almacen {
    
    private int int_idAlmacen;
    private Proveedor objProveedor;
    private Producto objProducto;
    private Local objLocal;
    private TipoMovimiento objTipoMovimiento;
    private String str_documento;
    private BigDecimal dbl_cantidad;
    private BigDecimal dbl_precio;
    private BigDecimal dbl_igv;
    private BigDecimal dbl_subTotal;
    private BigDecimal dbl_descuento;
    private String str_fechaDocumento;
    private String str_estado;
    private String str_usuarioCreador;
    private String str_fechaCreacion;
    private String str_usuarioModificador;
    private String str_fechaModificacion;

    public BigDecimal getDbl_cantidad() {
        return dbl_cantidad;
    }

    public void setDbl_cantidad(BigDecimal dbl_cantidad) {
        this.dbl_cantidad = dbl_cantidad;
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

    public BigDecimal getDbl_descuento() {
        return dbl_descuento;
    }

    public void setDbl_descuento(BigDecimal dbl_descuento) {
        this.dbl_descuento = dbl_descuento;
    }

    public BigDecimal getDbl_igv() {
        return dbl_igv;
    }

    public void setDbl_igv(BigDecimal dbl_igv) {
        this.dbl_igv = dbl_igv;
    }

    public BigDecimal getDbl_precio() {
        return dbl_precio;
    }

    public void setDbl_precio(BigDecimal dbl_precio) {
        this.dbl_precio = dbl_precio;
    }

    public BigDecimal getDbl_subTotal() {
        return dbl_subTotal;
    }

    public void setDbl_subTotal(BigDecimal dbl_subTotal) {
        this.dbl_subTotal = dbl_subTotal;
    }

    public int getInt_idAlmacen() {
        return int_idAlmacen;
    }

    public void setInt_idAlmacen(int int_idAlmacen) {
        this.int_idAlmacen = int_idAlmacen;
    }

    public Local getObjLocal() {
        return objLocal;
    }

    public void setObjLocal(Local objLocal) {
        this.objLocal = objLocal;
    }

    public TipoMovimiento getObjTipoMovimiento() {
        return objTipoMovimiento;
    }

    public void setObjTipoMovimiento(TipoMovimiento objTipoMovimiento) {
        this.objTipoMovimiento = objTipoMovimiento;
    }

    public String getStr_documento() {
        return str_documento;
    }

    public void setStr_documento(String str_documento) {
        this.str_documento = str_documento;
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

    public String getStr_fechaDocumento() {
        return str_fechaDocumento;
    }

    public void setStr_fechaDocumento(String str_fechaDocumento) {
        this.str_fechaDocumento = str_fechaDocumento;
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
