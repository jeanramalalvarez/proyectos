/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.bean;

/**
 *
 * @author YESM
 */
public class Funciones {
    private int int_idFunciones;
    private String str_rol;
    private String dte_fechaCreacion;
    private String str_usuarioCreador;
    private String dte_ultimaModificacion;
    private String str_usuarioModificador;
    private int int_modulo;
    private String str_key;

    public String getDte_fechaCreacion() {
        return dte_fechaCreacion;
    }

    public void setDte_fechaCreacion(String dte_fechaCreacion) {
        this.dte_fechaCreacion = dte_fechaCreacion;
    }

    public String getDte_ultimaModificacion() {
        return dte_ultimaModificacion;
    }

    public void setDte_ultimaModificacion(String dte_ultimaModificacion) {
        this.dte_ultimaModificacion = dte_ultimaModificacion;
    }

    public int getInt_idFunciones() {
        return int_idFunciones;
    }

    public void setInt_idFunciones(int int_idFunciones) {
        this.int_idFunciones = int_idFunciones;
    }

    public int getInt_modulo() {
        return int_modulo;
    }

    public void setInt_modulo(int int_modulo) {
        this.int_modulo = int_modulo;
    }

    public String getStr_key() {
        return str_key;
    }

    public void setStr_key(String str_key) {
        this.str_key = str_key;
    }

    public String getStr_rol() {
        return str_rol;
    }

    public void setStr_rol(String str_rol) {
        this.str_rol = str_rol;
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
