/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.bean;

import java.math.BigDecimal;

/**
 *
 * @author zholo
 */
public class Kardex {
    
    private int int_idKardex;
    private int int_idAlmacen;
    private int int_idProducto;
    private BigDecimal dbl_cantidad;
    private BigDecimal dbl_stock;

    public BigDecimal getDbl_cantidad() {
        return dbl_cantidad;
    }

    public void setDbl_cantidad(BigDecimal dbl_cantidad) {
        this.dbl_cantidad = dbl_cantidad;
    }

    public BigDecimal getDbl_stock() {
        return dbl_stock;
    }

    public void setDbl_stock(BigDecimal dbl_stock) {
        this.dbl_stock = dbl_stock;
    }

    public int getInt_idAlmacen() {
        return int_idAlmacen;
    }

    public void setInt_idAlmacen(int int_idAlmacen) {
        this.int_idAlmacen = int_idAlmacen;
    }

    public int getInt_idKardex() {
        return int_idKardex;
    }

    public void setInt_idKardex(int int_idKardex) {
        this.int_idKardex = int_idKardex;
    }

    public int getInt_idProducto() {
        return int_idProducto;
    }

    public void setInt_idProducto(int int_idProducto) {
        this.int_idProducto = int_idProducto;
    }
    
}
