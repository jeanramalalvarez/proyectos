/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.bean;

/**
 *
 * @author zholo
 */
public class logeo {
    private int int_idLogeo;
    private String str_usuario;
    private String dte_fecha;
    private String str_estado;

    public String getDte_fecha() {
        return dte_fecha;
    }

    public void setDte_fecha(String dte_fecha) {
        this.dte_fecha = dte_fecha;
    }

    public int getInt_idLogeo() {
        return int_idLogeo;
    }

    public void setInt_idLogeo(int int_idLogeo) {
        this.int_idLogeo = int_idLogeo;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_usuario() {
        return str_usuario;
    }

    public void setStr_usuario(String str_usuario) {
        this.str_usuario = str_usuario;
    }
}
