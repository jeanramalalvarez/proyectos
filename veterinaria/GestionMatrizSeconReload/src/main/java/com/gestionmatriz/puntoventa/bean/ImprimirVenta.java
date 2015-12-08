/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.bean;

import java.math.BigDecimal;

/**
 *
 * @author jarcon
 */
public class ImprimirVenta {
    
    private String str_codigo;
    private BigDecimal dbl_cantidad;
    private String str_unidadMedida;
    private String str_producto;
    private BigDecimal dbl_subTotal;
    private BigDecimal dbl_descuento;
    private BigDecimal dbl_total;
    private String str_vendedor;
    private String str_rasonSocial;
    private String str_ruc;
    private String str_direccion;
    private String fch_fecha;
    private BigDecimal dbl_precioUnit;
    private BigDecimal dbl_sumaSubTotal;
    private BigDecimal dbl_sumaDescuento;
    private BigDecimal dbl_sumaTotal;
    private BigDecimal dbl_sumaIGV;
    private BigDecimal dbl_efectivo;
    private BigDecimal dbl_vuelto;
    private String str_nombre;
    private String str_NumeroSerie;

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }
    
    

    public BigDecimal getDbl_cantidad() {
        return dbl_cantidad;
    }

    public void setDbl_cantidad(BigDecimal dbl_cantidad) {
        this.dbl_cantidad = dbl_cantidad;
    }

    public BigDecimal getDbl_descuento() {
        return dbl_descuento;
    }

    public void setDbl_descuento(BigDecimal dbl_descuento) {
        this.dbl_descuento = dbl_descuento;
    }

    public BigDecimal getDbl_precioUnit() {
        return dbl_precioUnit;
    }

    public void setDbl_precioUnit(BigDecimal dbl_precioUnit) {
        this.dbl_precioUnit = dbl_precioUnit;
    }

    public BigDecimal getDbl_subTotal() {
        return dbl_subTotal;
    }

    public void setDbl_subTotal(BigDecimal dbl_subTotal) {
        this.dbl_subTotal = dbl_subTotal;
    }

    public BigDecimal getDbl_sumaDescuento() {
        return dbl_sumaDescuento;
    }

    public void setDbl_sumaDescuento(BigDecimal dbl_sumaDescuento) {
        this.dbl_sumaDescuento = dbl_sumaDescuento;
    }

    public BigDecimal getDbl_sumaSubTotal() {
        return dbl_sumaSubTotal;
    }

    public void setDbl_sumaSubTotal(BigDecimal dbl_sumaSubTotal) {
        this.dbl_sumaSubTotal = dbl_sumaSubTotal;
    }

    public BigDecimal getDbl_sumaTotal() {
        return dbl_sumaTotal;
    }

    public void setDbl_sumaTotal(BigDecimal dbl_sumaTotal) {
        this.dbl_sumaTotal = dbl_sumaTotal;
    }

    public BigDecimal getDbl_total() {
        return dbl_total;
    }

    public void setDbl_total(BigDecimal dbl_total) {
        this.dbl_total = dbl_total;
    }

   
    public String getStr_unidadMedida() {
        return str_unidadMedida;
    }

    public void setStr_unidadMedida(String str_unidadMedida) {
        this.str_unidadMedida = str_unidadMedida;
    } 

    public String getFch_fecha() {
        return fch_fecha;
    }

    public void setFch_fecha(String fch_fecha) {
        this.fch_fecha = fch_fecha;
    }

    public String getStr_codigo() {
        return str_codigo;
    }

    public void setStr_codigo(String str_codigo) {
        this.str_codigo = str_codigo;
    }

    public String getStr_direccion() {
        return str_direccion;
    }

    public void setStr_direccion(String str_direccion) {
        this.str_direccion = str_direccion;
    }

    public String getStr_producto() {
        return str_producto;
    }

    public void setStr_producto(String str_producto) {
        this.str_producto = str_producto;
    }

    public String getStr_rasonSocial() {
        return str_rasonSocial;
    }

    public void setStr_rasonSocial(String str_rasonSocial) {
        this.str_rasonSocial = str_rasonSocial;
    }

    public String getStr_ruc() {
        return str_ruc;
    }

    public BigDecimal getDbl_sumaIGV() {
        return dbl_sumaIGV;
    }

    public void setDbl_sumaIGV(BigDecimal dbl_sumaIGV) {
        this.dbl_sumaIGV = dbl_sumaIGV;
    }

    public void setStr_ruc(String str_ruc) {
        this.str_ruc = str_ruc;
    }

    public String getStr_vendedor() {
        return str_vendedor;
    }

    public void setStr_vendedor(String str_vendedor) {
        this.str_vendedor = str_vendedor;
    }

    public BigDecimal getDbl_efectivo() {
        return dbl_efectivo;
    }

    public void setDbl_efectivo(BigDecimal dbl_efectivo) {
        this.dbl_efectivo = dbl_efectivo;
    }

    public BigDecimal getDbl_vuelto() {
        return dbl_vuelto;
    }

    public void setDbl_vuelto(BigDecimal dbl_vuelto) {
        this.dbl_vuelto = dbl_vuelto;
    }

    public String getStr_NumeroSerie() {
        return str_NumeroSerie;
    }

    public void setStr_NumeroSerie(String str_NumeroSerie) {
        this.str_NumeroSerie = str_NumeroSerie;
    }
    
    
    
}
