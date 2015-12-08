/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.bean;

/**
 *
 * @author zholo
 */
public class Cuentas {

    private int int_idCuentas;
    private int int_idElemento;
    private int int_nroCuenta;
    private String str_descripcion;
    private String str_debe;
    private String str_haber;
    private String str_tipo;
    private String str_analisis;
    private String str_estado;
    private String dte_fechaCreacion;
    private String str_usuarioCreador;
    private String dte_fechaModificacion;
    private String str_usuarioModificador;

    public String getStr_analisis() {
        return str_analisis;
    }

    public void setStr_analisis(String str_analisis) {
        this.str_analisis = str_analisis;
    }

    public String getStr_debe() {
        return str_debe;
    }

    public void setStr_debe(String str_debe) {
        this.str_debe = str_debe;
    }

    public String getStr_haber() {
        return str_haber;
    }

    public void setStr_haber(String str_haber) {
        this.str_haber = str_haber;
    }

    public String getStr_tipo() {
        return str_tipo;
    }

    public void setStr_tipo(String str_tipo) {
        this.str_tipo = str_tipo;
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

    public int getInt_idCuentas() {
        return int_idCuentas;
    }

    public void setInt_idCuentas(int int_idCuentas) {
        this.int_idCuentas = int_idCuentas;
    }

    public int getInt_idElemento() {
        return int_idElemento;
    }

    public void setInt_idElemento(int int_idElemento) {
        this.int_idElemento = int_idElemento;
    }

    public int getInt_nroCuenta() {
        return int_nroCuenta;
    }

    public void setInt_nroCuenta(int int_nroCuenta) {
        this.int_nroCuenta = int_nroCuenta;
    }

    public String getStr_descripcion() {
        return str_descripcion;
    }

    public void setStr_descripcion(String str_descripcion) {
        this.str_descripcion = str_descripcion;
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
