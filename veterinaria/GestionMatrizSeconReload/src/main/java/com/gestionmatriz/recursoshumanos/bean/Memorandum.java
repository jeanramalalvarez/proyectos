/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author zholo
 */
public class Memorandum {
    private int int_idMemorandum;
    private String str_numero;
    private String str_emisor;
    private String str_receptor;
    private String str_asunto;
    private String dte_fecha;
    private String str_cuerpo;
    private String str_usuarioCreador;
    private String dte_fechaCreacion;
    private String str_usuarioModificador;
    private String dte_fechaModificacion;
    private int int_idPersona;
    private String str_estado;

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getDte_fecha() {
        return dte_fecha;
    }

    public void setDte_fecha(String dte_fecha) {
        this.dte_fecha = dte_fecha;
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

    public int getInt_idMemorandum() {
        return int_idMemorandum;
    }

    public void setInt_idMemorandum(int int_idMemorandum) {
        this.int_idMemorandum = int_idMemorandum;
    }

    public int getInt_idPersona() {
        return int_idPersona;
    }

    public void setInt_idPersona(int int_idPersona) {
        this.int_idPersona = int_idPersona;
    }

    public String getStr_asunto() {
        return str_asunto;
    }

    public void setStr_asunto(String str_asunto) {
        this.str_asunto = str_asunto;
    }

    public String getStr_cuerpo() {
        return str_cuerpo;
    }

    public void setStr_cuerpo(String str_cuerpo) {
        this.str_cuerpo = str_cuerpo;
    }

    public String getStr_emisor() {
        return str_emisor;
    }

    public void setStr_emisor(String str_emisor) {
        this.str_emisor = str_emisor;
    }

    public String getStr_numero() {
        return str_numero;
    }

    public void setStr_numero(String str_numero) {
        this.str_numero = str_numero;
    }

    public String getStr_receptor() {
        return str_receptor;
    }

    public void setStr_receptor(String str_receptor) {
        this.str_receptor = str_receptor;
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
