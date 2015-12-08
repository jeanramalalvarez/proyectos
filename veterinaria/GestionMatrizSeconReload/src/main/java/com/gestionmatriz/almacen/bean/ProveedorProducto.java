/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.bean;

/**
 *
 * @author jarcon
 */
public class ProveedorProducto {
    private int int_idProveedorProducto;
    private int int_idProveedor;
    private int int_idProducto;
    private String str_usuarioCreador;
    private String str_fechaCreacion;
    private String str_usuarioModificador;
    private String str_fechaModificacion;
    private String str_estado;
    
    private Producto objProducto;
    private Proveedor objProveedor;

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

    public int getInt_idProveedorProducto() {
        return int_idProveedorProducto;
    }

    public void setInt_idProveedorProducto(int int_idProveedorProducto) {
        this.int_idProveedorProducto = int_idProveedorProducto;
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
