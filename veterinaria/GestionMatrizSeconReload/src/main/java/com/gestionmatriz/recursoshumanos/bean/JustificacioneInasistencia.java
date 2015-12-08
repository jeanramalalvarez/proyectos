/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author zholo
 */
public class JustificacioneInasistencia {
    private int int_idJustificacioneInasistencia;
    private int int_idHorario;

    public int getInt_idAsistencia() {
        return int_idAsistencia;
    }

    public void setInt_idAsistencia(int int_idAsistencia) {
        this.int_idAsistencia = int_idAsistencia;
    }

    public String getStr_observacion() {
        return str_observacion;
    }

    public void setStr_observacion(String str_observacion) {
        this.str_observacion = str_observacion;
    }
    private int int_idJornada;
    private int int_idContrato;
    
    private String str_estado;
    private String str_UsuarioCreador;
    private String dte_fechaCreadio;
    private String str_UsuarioModificador;
    private String dte_fechaModificacion;
    
      private int int_idAsistencia;
    private String str_observacion;

    public String getDte_fechaCreadio() {
        return dte_fechaCreadio;
    }

    public void setDte_fechaCreadio(String dte_fechaCreadio) {
        this.dte_fechaCreadio = dte_fechaCreadio;
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

    public int getInt_idJustificacioneInasistencia() {
        return int_idJustificacioneInasistencia;
    }

    public void setInt_idJustificacioneInasistencia(int int_idJustificacioneInasistencia) {
        this.int_idJustificacioneInasistencia = int_idJustificacioneInasistencia;
    }

    public String getStr_UsuarioCreador() {
        return str_UsuarioCreador;
    }

    public void setStr_UsuarioCreador(String str_UsuarioCreador) {
        this.str_UsuarioCreador = str_UsuarioCreador;
    }

    public String getStr_UsuarioModificador() {
        return str_UsuarioModificador;
    }

    public void setStr_UsuarioModificador(String str_UsuarioModificador) {
        this.str_UsuarioModificador = str_UsuarioModificador;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }
}
