/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.bean;

/**
 *
 * @author zholo
 */
public class Elemento {
    
    private int int_idElemento;
    private String str_elemento;
    private String str_descripcion;
    private String str_estado;
    private String dte_fechaCreacion;
    private String str_usuarioCreador;
    private String dte_fechaModificacion;
    private String str_usuarioModificador;

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

    public int getInt_idElemento() {
        return int_idElemento;
    }

    public void setInt_idElemento(int int_idElemento) {
        this.int_idElemento = int_idElemento;
    }

    public String getStr_descripcion() {
        return str_descripcion;
    }

    public void setStr_descripcion(String str_descripcion) {
        this.str_descripcion = str_descripcion;
    }

    public String getStr_elemento() {
        return str_elemento;
    }

    public void setStr_elemento(String str_elemento) {
        this.str_elemento = str_elemento;
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
