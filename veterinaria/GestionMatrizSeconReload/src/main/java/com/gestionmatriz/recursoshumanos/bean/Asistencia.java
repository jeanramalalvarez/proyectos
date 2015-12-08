/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author zholo
 */
public class Asistencia {
    
    private int int_asistencia;
    private int int_idHorario;
    private int int_idJornada;
    private int int_idContrato;
    private String dte_fecha;
    private String tm_hora;
    private int int_tipoMarcado;    
    private String str_estadoMarcado;
    
    /*Atributos Creador para Reporte*/
    private String str_direccion;
    private String str_horario;
    private String str_fechaMarcado;
    private String str_horaIngreso;
    private String str_tipoMarcado;
    private Contrato objContrato;
    private HorarioJornada objHorarioJornada;
    
    public String getStr_direccion() {
        return str_direccion;
    }

    public void setStr_direccionMarco(String str_direccion) {
        this.str_direccion = str_direccion;
    }

    public String getStr_fechaMarcado() {
        return str_fechaMarcado;
    }

    public void setStr_fechaMarcado(String str_fechaMarcado) {
        this.str_fechaMarcado = str_fechaMarcado;
    }

    public String getStr_horaIngreso() {
        return str_horaIngreso;
    }

    public void setStr_horaIngreso(String str_horaIngreso) {
        this.str_horaIngreso = str_horaIngreso;
    }

    public String getStr_horario() {
        return str_horario;
    }

    public void setStr_horario(String str_horario) {
        this.str_horario = str_horario;
    }

    public String getStr_tipoMarcado() {
        return str_tipoMarcado;
    }

    public void setStr_tipoMarcado(String str_tipoMarcado) {
        this.str_tipoMarcado = str_tipoMarcado;
    }
    
    
    


    public Contrato getObjContrato() {
        return objContrato;
    }

    public void setObjContrato(Contrato objContrato) {
        this.objContrato = objContrato;
    }

    public HorarioJornada getObjHorarioJornada() {
        return objHorarioJornada;
    }

    public void setObjHorarioJornada(HorarioJornada objHorarioJornada) {
        this.objHorarioJornada = objHorarioJornada;
    }
    
    public String getDte_fecha() {
        return dte_fecha;
    }

    public void setDte_fecha(String dte_fecha) {
        this.dte_fecha = dte_fecha;
    }

    public int getInt_asistencia() {
        return int_asistencia;
    }

    public void setInt_asistencia(int int_asistencia) {
        this.int_asistencia = int_asistencia;
    }

    public int getInt_idContrato() {
        return int_idContrato;
    }

    public void setInt_idContrato(int int_idContrato) {
        this.int_idContrato = int_idContrato;
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

    public int getInt_tipoMarcado() {
        return int_tipoMarcado;
    }

    public void setInt_tipoMarcado(int int_tipoMarcado) {
        this.int_tipoMarcado = int_tipoMarcado;
    }

    public String getStr_estadoMarcado() {
        return str_estadoMarcado;
    }

    public void setStr_estadoMarcado(String str_estadoMarcado) {
        this.str_estadoMarcado = str_estadoMarcado;
    }

    public String getTm_hora() {
        return tm_hora;
    }

    public void setTm_hora(String tm_hora) {
        this.tm_hora = tm_hora;
    }

    
}
