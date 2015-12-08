/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.bean;

import com.gestionmatriz.puntoventa.bean.GuiaRemision;

/**
 *
 * @author jarcon
 */
public class TraspasoMercaderia {
    
    private int int_idTraspasoInterno;
    private int int_idGuiaRemision;
    private String str_codigoAutoriza;
    private String str_codigoConfirma;
    private String dte_fechaAutoriza;
    private String dte_fechaConfirma;
    private String str_estado;
    private String str_usuarioCreador;
    private String dte_fechaCreacion;
    private String str_usuarioModificador;
    private String dte_fechaModificacion;
    
    private GuiaRemision objGuiaRemision;

    public GuiaRemision getObjGuiaRemision() {
        return objGuiaRemision;
    }

    public void setObjGuiaRemision(GuiaRemision objGuiaRemision) {
        this.objGuiaRemision = objGuiaRemision;
    }

    public String getDte_fechaAutoriza() {
        return dte_fechaAutoriza;
    }

    public void setDte_fechaAutoriza(String dte_fechaAutoriza) {
        this.dte_fechaAutoriza = dte_fechaAutoriza;
    }

    public String getDte_fechaConfirma() {
        return dte_fechaConfirma;
    }

    public void setDte_fechaConfirma(String dte_fechaConfirma) {
        this.dte_fechaConfirma = dte_fechaConfirma;
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

    public int getInt_idGuiaRemision() {
        return int_idGuiaRemision;
    }

    public void setInt_idGuiaRemision(int int_idGuiaRemision) {
        this.int_idGuiaRemision = int_idGuiaRemision;
    }

    public int getInt_idTraspasoInterno() {
        return int_idTraspasoInterno;
    }

    public void setInt_idTraspasoInterno(int int_idTraspasoInterno) {
        this.int_idTraspasoInterno = int_idTraspasoInterno;
    }

    public String getStr_codigoAutoriza() {
        return str_codigoAutoriza;
    }

    public void setStr_codigoAutoriza(String str_codigoAutoriza) {
        this.str_codigoAutoriza = str_codigoAutoriza;
    }

    public String getStr_codigoConfirma() {
        return str_codigoConfirma;
    }

    public void setStr_codigoConfirma(String str_codigoConfirma) {
        this.str_codigoConfirma = str_codigoConfirma;
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
