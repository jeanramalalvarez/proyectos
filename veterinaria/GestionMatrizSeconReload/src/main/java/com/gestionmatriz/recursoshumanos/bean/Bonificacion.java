/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

import java.math.BigDecimal;

/**
 *
 * @author zholo
 */
public class Bonificacion {
    
    private int int_idBonificacion;
    private String str_descripcion;
    private BigDecimal dbl_monto;
    private String str_estado;
    private String str_usuarioCreador;
    private String dte_fechaCreacion;

    public String getDte_fechaCreacion() {
        return dte_fechaCreacion;
    }

    public void setDte_fechaCreacion(String dte_fechaCreacion) {
        this.dte_fechaCreacion = dte_fechaCreacion;
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
    

    public BigDecimal getDbl_monto() {
        return dbl_monto;
    }

    public void setDbl_monto(BigDecimal dbl_monto) {
        this.dbl_monto = dbl_monto;
    }

    public int getInt_idBonificacion() {
        return int_idBonificacion;
    }

    public void setInt_idBonificacion(int int_idBonificacion) {
        this.int_idBonificacion = int_idBonificacion;
    }

    public String getStr_descripcion() {
        return str_descripcion;
    }

    public void setStr_descripcion(String str_descripcion) {
        this.str_descripcion = str_descripcion;
    }
    
    
}
