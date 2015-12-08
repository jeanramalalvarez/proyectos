/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.bean;

import java.math.BigDecimal;

import com.gestionmatriz.almacen.bean.Producto;

/**
 *
 * @author jarcon
 */
public class DetalleGuiaRemision {
    
    private int int_idGuiaRemision;
    private int int_idProducto;
    private BigDecimal dbl_cantdadProducto;
    private String str_descripcionProducto;
    private BigDecimal dbl_peso;
    private BigDecimal dbl_costoTraspaso;
    private String str_estado;
    private String str_usuarioCreador;
    private String dte_fechaCreacion;
    private String str_usuarioModificador;
    private String dte_fechaModificacion;
    private String int_idProveedor;
    private ConsultaStock objConsultaStock;

    public ConsultaStock getObjConsultaStock() {
        return objConsultaStock;
    }

    public void setObjConsultaStock(ConsultaStock objConsultaStock) {
        this.objConsultaStock = objConsultaStock;
    }

    public String getInt_idProveedor() {
        return int_idProveedor;
    }

    public void setInt_idProveedor(String int_idProveedor) {
        this.int_idProveedor = int_idProveedor;
    }
    
    private Producto objProducto;

    public Producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(Producto objProducto) {
        this.objProducto = objProducto;
    }

    public BigDecimal getDbl_cantdadProducto() {
        return dbl_cantdadProducto;
    }

    public void setDbl_cantdadProducto(BigDecimal dbl_cantdadProducto) {
        this.dbl_cantdadProducto = dbl_cantdadProducto;
    }

    public BigDecimal getDbl_costoTraspaso() {
        return dbl_costoTraspaso;
    }

    public void setDbl_costoTraspaso(BigDecimal dbl_costoTraspaso) {
        this.dbl_costoTraspaso = dbl_costoTraspaso;
    }

    public BigDecimal getDbl_peso() {
        return dbl_peso;
    }

    public void setDbl_peso(BigDecimal dbl_peso) {
        this.dbl_peso = dbl_peso;
    }

    public String getDte_fechaCreacion() {
        return dte_fechaCreacion;
    }

    public void setDte_fechaCreacion(String dte_fechaCreacion) {
        this.dte_fechaCreacion = dte_fechaCreacion;
    }

    public String getDte_fechaModificacion() {
        return dte_fechaModificacion;
    }

    public void setDte_fechaModificacion(String dte_fechaModificacion) {
        this.dte_fechaModificacion = dte_fechaModificacion;
    }

    public int getInt_idGuiaRemision() {
        return int_idGuiaRemision;
    }

    public void setInt_idGuiaRemision(int int_idGuiaRemision) {
        this.int_idGuiaRemision = int_idGuiaRemision;
    }

    public int getInt_idProducto() {
        return int_idProducto;
    }

    public void setInt_idProducto(int int_idProducto) {
        this.int_idProducto = int_idProducto;
    }

    public String getStr_descripcionProducto() {
        return str_descripcionProducto;
    }

    public void setStr_descripcionProducto(String str_descripcionProducto) {
        this.str_descripcionProducto = str_descripcionProducto;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
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
