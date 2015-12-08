/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author zholo
 */
public class Permisos {
    private int int_idPermisos;
    private String dte_fecha;
    private String str_motivo;
    private String tm_horaSalida;
    private String tm_horaLlegada;
    private String str_observacion;
    private String str_estado;
    private int int_idPersona;
    private String tm_horaMarcadoSalida;
    private String tm_horaMarcadoLlegada;
    private String dte_fechaRegistro;

    public String getDte_fechaRegistro() {
        return dte_fechaRegistro;
    }

    public void setDte_fechaRegistro(String dte_fechaRegistro) {
        this.dte_fechaRegistro = dte_fechaRegistro;
    }
    
    
    
    private Personal objPersona;

    
    
    public Personal getObjPersona() {
        return objPersona;
    }

    public void setObjPersona(Personal objPersona) {
        this.objPersona = objPersona;
    }
    

    
    public String getDte_fecha() {
        return dte_fecha;
    }

    public void setDte_fecha(String dte_fecha) {
        this.dte_fecha = dte_fecha;
    }

    public int getInt_idPermisos() {
        return int_idPermisos;
    }

    public void setInt_idPermisos(int int_idPermisos) {
        this.int_idPermisos = int_idPermisos;
    }

    public int getInt_idPersona() {
        return int_idPersona;
    }

    public void setInt_idPersona(int int_idPersona) {
        this.int_idPersona = int_idPersona;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_motivo() {
        return str_motivo;
    }

    public void setStr_motivo(String str_motivo) {
        this.str_motivo = str_motivo;
    }

    public String getStr_observacion() {
        return str_observacion;
    }

    public void setStr_observacion(String str_observacion) {
        this.str_observacion = str_observacion;
    }

    public String getTm_horaLlegada() {
        return tm_horaLlegada;
    }

    public void setTm_horaLlegada(String tm_horaLlegada) {
        this.tm_horaLlegada = tm_horaLlegada;
    }

    public String getTm_horaMarcadoLlegada() {
        return tm_horaMarcadoLlegada;
    }

    public void setTm_horaMarcadoLlegada(String tm_horaMarcadoLlegada) {
        this.tm_horaMarcadoLlegada = tm_horaMarcadoLlegada;
    }

    public String getTm_horaMarcadoSalida() {
        return tm_horaMarcadoSalida;
    }

    public void setTm_horaMarcadoSalida(String tm_horaMarcadoSalida) {
        this.tm_horaMarcadoSalida = tm_horaMarcadoSalida;
    }

    public String getTm_horaSalida() {
        return tm_horaSalida;
    }

    public void setTm_horaSalida(String tm_horaSalida) {
        this.tm_horaSalida = tm_horaSalida;
    }
    
    
    
}
