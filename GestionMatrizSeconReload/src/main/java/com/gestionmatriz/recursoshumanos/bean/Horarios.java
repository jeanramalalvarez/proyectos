/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author zholo
 */
public class Horarios {
    private int int_idHorario;
    private String str_nombreHorario;
    private String str_estado;
    private String dte_fechaCreacion;
    private String str_usuarioCreador;
    private String dte_fechaModificacion;
    private String str_usuarioModifcador;

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

    public int getInt_idHorario() {
        return int_idHorario;
    }

    public void setInt_idHorario(int int_idHorario) {
        this.int_idHorario = int_idHorario;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_nombreHorario() {
        return str_nombreHorario;
    }

    public void setStr_nombreHorario(String str_nombreHorario) {
        this.str_nombreHorario = str_nombreHorario;
    }

    public String getStr_usuarioCreador() {
        return str_usuarioCreador;
    }

    public void setStr_usuarioCreador(String str_usuarioCreador) {
        this.str_usuarioCreador = str_usuarioCreador;
    }

    public String getStr_usuarioModifcador() {
        return str_usuarioModifcador;
    }

    public void setStr_usuarioModifcador(String str_usuarioModifcador) {
        this.str_usuarioModifcador = str_usuarioModifcador;
    }
}
