/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author zholo
 */
public class Jornada {
    private int int_idJornada;
    private String tme_HoraInicio;
    private String tme_horaFin;
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

    public String getTme_HoraInicio() {
        return tme_HoraInicio;
    }

    public void setTme_HoraInicio(String tme_HoraInicio) {
        this.tme_HoraInicio = tme_HoraInicio;
    }

    public String getTme_horaFin() {
        return tme_horaFin;
    }

    public void setTme_horaFin(String tme_horaFin) {
        this.tme_horaFin = tme_horaFin;
    }
    
}
