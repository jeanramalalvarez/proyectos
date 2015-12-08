/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author zholo
 */
public class TipoContrato {
    private int int_idTipoContrato;
    private String str_tipoContrato;
    private String str_nombreReporte;
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

    public int getInt_idTipoContrato() {
        return int_idTipoContrato;
    }

    public void setInt_idTipoContrato(int int_idTipoContrato) {
        this.int_idTipoContrato = int_idTipoContrato;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_nombreReporte() {
        return str_nombreReporte;
    }

    public void setStr_nombreReporte(String str_nombreReporte) {
        this.str_nombreReporte = str_nombreReporte;
    }

    public String getStr_tipoContrato() {
        return str_tipoContrato;
    }

    public void setStr_tipoContrato(String str_tipoContrato) {
        this.str_tipoContrato = str_tipoContrato;
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
