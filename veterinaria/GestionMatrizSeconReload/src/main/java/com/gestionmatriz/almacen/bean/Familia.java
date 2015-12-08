/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.bean;

/**
 *
 * @author zholo
 */
public class Familia {
    
    private int int_idFamilia;
    private String str_codigoFamilia;
    private String str_nombre;
    private String str_descripcion;
    private String str_estado;
    
    private String str_usuarioCreador;
    private String dte_fechaCreacion;
    private String str_usuarioModificador;
    private String dte_fechaModificacion;

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

    public int getInt_idFamilia() {
        return int_idFamilia;
    }

    public void setInt_idFamilia(int int_idFamilia) {
        this.int_idFamilia = int_idFamilia;
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

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
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
    
    public String getStr_codigoFamilia() {
        return str_codigoFamilia;
    }

    public void setStr_codigoFamilia(String str_codigoFamilia) {
        this.str_codigoFamilia = str_codigoFamilia;
    }
    
    
}
