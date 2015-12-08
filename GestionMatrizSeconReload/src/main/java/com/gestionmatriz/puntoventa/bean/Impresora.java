/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.bean;

import com.gestionmatriz.recursoshumanos.bean.Local;
import java.util.Date;

/**
 *
 * @author pc
 */

public class Impresora {
    
    private int int_impresora;
    private Local objLocal;
    private String str_marca;
    private String str_modelo;
    private String str_NumeroSerie;
    private Date dt_fechaCreacion;
    private Date dt_fechaModificacion;
    private String str_usuarioCreador;
    private String str_usuarioModificador;
    private String str_estado;
    private String str_nombre;

    public Impresora() {
    }
    
    public Impresora(String str_estado) {
        this.str_estado = str_estado;
    }

    public int getInt_impresora() {
        return int_impresora;
    }

    public void setInt_impresora(int int_impresora) {
        this.int_impresora = int_impresora;
    }



    public String getStr_marca() {
        return str_marca;
    }

    public void setStr_marca(String str_marca) {
        this.str_marca = str_marca;
    }

    public String getStr_modelo() {
        return str_modelo;
    }

    public void setStr_modelo(String str_modelo) {
        this.str_modelo = str_modelo;
    }

    public String getStr_NumeroSerie() {
        return str_NumeroSerie;
    }

    public void setStrNumeroSerie(String strNumeroSerie) {
        this.str_NumeroSerie = strNumeroSerie;
    }

    public Local getObjLocal() {
        return objLocal;
    }

    public void setObjLocal(Local objLocal) {
        this.objLocal = objLocal;
    }

    public Date getDt_fechaCreacion() {
        return dt_fechaCreacion;
    }

    public void setDt_fechaCreacion(Date dt_fechaCreacion) {
        this.dt_fechaCreacion = dt_fechaCreacion;
    }

    public Date getDt_fechaModificacion() {
        return dt_fechaModificacion;
    }

    public void setDt_fechaModificacion(Date dt_fechaModificacion) {
        this.dt_fechaModificacion = dt_fechaModificacion;
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

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }
    
    
    
}
