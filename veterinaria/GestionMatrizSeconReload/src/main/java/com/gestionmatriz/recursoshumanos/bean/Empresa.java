/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author zholo
 */
public class Empresa {
    private int int_idEmpresa;
    private String str_razonSocial;
    private String str_ruc;
    private String str_domicilioEmpresa;
    private String str_representanteLegal;
    private String str_dniRepresentante;
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

    public int getInt_idEmpresa() {
        return int_idEmpresa;
    }

    public void setInt_idEmpresa(int int_idEmpresa) {
        this.int_idEmpresa = int_idEmpresa;
    }

    public String getStr_dniRepresentante() {
        return str_dniRepresentante;
    }

    public void setStr_dniRepresentante(String str_dniRepresentante) {
        this.str_dniRepresentante = str_dniRepresentante;
    }

    public String getStr_domicilioEmpresa() {
        return str_domicilioEmpresa;
    }

    public void setStr_domicilioEmpresa(String str_domicilioEmpresa) {
        this.str_domicilioEmpresa = str_domicilioEmpresa;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_razonSocial() {
        return str_razonSocial;
    }

    public void setStr_razonSocial(String str_razonSocial) {
        this.str_razonSocial = str_razonSocial;
    }

    public String getStr_representanteLegal() {
        return str_representanteLegal;
    }

    public void setStr_representanteLegal(String str_representanteLegal) {
        this.str_representanteLegal = str_representanteLegal;
    }

    public String getStr_ruc() {
        return str_ruc;
    }

    public void setStr_ruc(String str_ruc) {
        this.str_ruc = str_ruc;
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
