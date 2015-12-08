/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

import java.math.BigDecimal;

/**
 *
 * @author zholo
 */
public class Contrato {
    private int int_idContrato;
    private int int_idPersona;
    private int int_idTipoContrato;
    private int int_idEmpresa;
    private String dte_fechaInicial;
    private String dte_fechaFinal;
    private BigDecimal dbl_sueldo;
    private String str_estado;


    private String dte_fechaCreacion;
    private String str_usuarioCreador;
    private String dte_ultimaModificacion;
    private String str_usuarioModificador;
    private String str_observacion;
    private int int_local;
    
    

    public int getInt_local() {
        return int_local;
    }

    public void setInt_local(int int_local) {
        this.int_local = int_local;
    }
    
    private Personal objPersona;
    private Empresa objEmpresa;
    private TipoContrato objTipoContrato;

    public String getStr_observacion() {
        return str_observacion;
    }

    public void setStr_observacion(String str_observacion) {
        this.str_observacion = str_observacion;
    }

    
    public TipoContrato getObjTipoContrato() {
        return objTipoContrato;
    }

    public void setObjTipoContrato(TipoContrato objTipoContrato) {
        this.objTipoContrato = objTipoContrato;
    }

    public Empresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(Empresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    
    public Personal getObjPersona() {
        return objPersona;
    }

    public void setObjPersona(Personal objPersona) {
        this.objPersona = objPersona;
    }
    
    public BigDecimal getDbl_sueldo() {
        return dbl_sueldo;
    }

    public void setDbl_sueldo(BigDecimal dbl_sueldo) {
        this.dbl_sueldo = dbl_sueldo;
    }

    public String getDte_fechaCreacion() {
        return dte_fechaCreacion;
    }

    public void setDte_fechaCreacion(String dte_fechaCreacion) {
        this.dte_fechaCreacion = dte_fechaCreacion;
    }

    public String getDte_fechaFinal() {
        return dte_fechaFinal;
    }

    public void setDte_fechaFinal(String dte_fechaFinal) {
        this.dte_fechaFinal = dte_fechaFinal;
    }

    public String getDte_fechaInicial() {
        return dte_fechaInicial;
    }

    public void setDte_fechaInicial(String dte_fechaInicial) {
        this.dte_fechaInicial = dte_fechaInicial;
    }

    public String getDte_ultimaModificacion() {
        return dte_ultimaModificacion;
    }

    public void setDte_ultimaModificacion(String dte_ultimaModificacion) {
        this.dte_ultimaModificacion = dte_ultimaModificacion;
    }

    public int getInt_idContrato() {
        return int_idContrato;
    }

    public void setInt_idContrato(int int_idContrato) {
        this.int_idContrato = int_idContrato;
    }

    public int getInt_idEmpresa() {
        return int_idEmpresa;
    }

    public void setInt_idEmpresa(int int_idEmpresa) {
        this.int_idEmpresa = int_idEmpresa;
    }

    public int getInt_idPersona() {
        return int_idPersona;
    }

    public void setInt_idPersona(int int_idPersona) {
        this.int_idPersona = int_idPersona;
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
