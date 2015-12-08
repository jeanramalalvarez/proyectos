/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

import java.util.List;

/**
 *
 * @author zholo
 */
public class HorarioJornadaContrato {
    private int int_idHorario;
    private int int_idJornada;
    private int int_idContrato;
    private String str_estado;
    private String dte_fechaCreacion;
    private String str_usuarioCreador;
    private String dte_fechaModificacion;
    private String str_usuarioModificador;
    private Contrato objContrato;
    private HorarioJornada objHorarioJorada;
    
    private List<HorarioJornada> objListHorarioJornada;

    
    public Contrato getObjContrato() {
        return objContrato;
    }

    public List<HorarioJornada> getObjListHorarioJornada() {
        return objListHorarioJornada;
    }

    public void setObjListHorarioJornada(List<HorarioJornada> objListHorarioJornada) {
        this.objListHorarioJornada = objListHorarioJornada;
    }

    public void setObjContrato(Contrato objContrato) {
        this.objContrato = objContrato;
    }

    public HorarioJornada getObjHorarioJorada() {
        return objHorarioJorada;
    }

    public void setObjHorarioJorada(HorarioJornada objHorarioJorada) {
        this.objHorarioJorada = objHorarioJorada;
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
