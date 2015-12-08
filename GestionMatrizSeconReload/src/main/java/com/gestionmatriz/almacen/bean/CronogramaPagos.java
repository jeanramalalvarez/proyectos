/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.bean;

import java.math.BigDecimal;

/**
 *
 * @author jarcon
 */
public class CronogramaPagos {
    
    private int int_idCronogramaPagos;
    private int int_obligacionesPago;
    private String str_numeroLetra;
    private String str_fechaEmision;
    private int int_diasCalendario;
    private String str_fechaVencimiento;
    private BigDecimal dbl_monto;
    private String str_estado;
    private String str_usuarioCreador;
    private String str_fechaCreacion;
    private String str_usuarioModificador;
    private String str_fechaModificacion;

    public BigDecimal getDbl_monto() {
        return dbl_monto;
    }

    public void setDbl_monto(BigDecimal dbl_monto) {
        this.dbl_monto = dbl_monto;
    }

    public int getInt_diasCalendario() {
        return int_diasCalendario;
    }

    public void setInt_diasCalendario(int int_diasCalendario) {
        this.int_diasCalendario = int_diasCalendario;
    }

    public int getInt_idCronogramaPagos() {
        return int_idCronogramaPagos;
    }

    public void setInt_idCronogramaPagos(int int_idCronogramaPagos) {
        this.int_idCronogramaPagos = int_idCronogramaPagos;
    }

    public int getInt_obligacionesPago() {
        return int_obligacionesPago;
    }

    public void setInt_obligacionesPago(int int_obligacionesPago) {
        this.int_obligacionesPago = int_obligacionesPago;
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

    public String getStr_fechaEmision() {
        return str_fechaEmision;
    }

    public void setStr_fechaEmision(String str_fechaEmision) {
        this.str_fechaEmision = str_fechaEmision;
    }

    public String getStr_fechaModificacion() {
        return str_fechaModificacion;
    }

    public void setStr_fechaModificacion(String str_fechaModificacion) {
        this.str_fechaModificacion = str_fechaModificacion;
    }

    public String getStr_fechaVencimiento() {
        return str_fechaVencimiento;
    }

    public void setStr_fechaVencimiento(String str_fechaVencimiento) {
        this.str_fechaVencimiento = str_fechaVencimiento;
    }

    public String getStr_numeroLetra() {
        return str_numeroLetra;
    }

    public void setStr_numeroLetra(String str_numeroLetra) {
        this.str_numeroLetra = str_numeroLetra;
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
