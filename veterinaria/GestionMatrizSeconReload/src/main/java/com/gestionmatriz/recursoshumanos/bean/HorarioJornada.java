/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author zholo
 */
public class HorarioJornada {
    private int int_idHorario;
    private int int_idJornada;
    private String str_estado;
    private String dte_fechaCreacion;
    private String str_usuarioCreador;
    private String dte_fechaModificacion;
    private String str_usuarioModificador;
    
    private Jornada objJornada;
    private Horarios objHorario;
    
    public Horarios getObjHorario() {
        return objHorario;
    }

    public void setObjHorario(Horarios objHorario) {
        this.objHorario = objHorario;
    }

    public Jornada getObjJornada() {
        return objJornada;
    }

    public void setObjJornada(Jornada objJornada) {
        this.objJornada = objJornada;
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

    public int getInt_idHorario() {
        return int_idHorario;
    }

    public void setInt_idHorario(int int_idHorario) {
        this.int_idHorario = int_idHorario;
    }

    public int getInt_idJornada() {
        return int_idJornada;
    }

    public void setInt_idJornada(int int_idJornada) {
        this.int_idJornada = int_idJornada;
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
