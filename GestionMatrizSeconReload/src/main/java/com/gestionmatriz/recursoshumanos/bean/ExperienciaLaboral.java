/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author YESM
 */
public class ExperienciaLaboral {
    private int int_idExperienciaLaboral;
    private int int_idPersona;
    private String str_empresa;
    private String str_rubro;
    private String str_cargo;
    private String str_funciones;
    private String dte_fechaInicio;
    private String dte_fechaFin;
    private String str_sueldo;
    private String str_jefeInmediato;
    private String str_telfEmpresa;
    private String str_motivoCese;
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

    public String getDte_fechaFin() {
        return dte_fechaFin;
    }

    public void setDte_fechaFin(String dte_fechaFin) {
        this.dte_fechaFin = dte_fechaFin;
    }

    public String getDte_fechaInicio() {
        return dte_fechaInicio;
    }

    public void setDte_fechaInicio(String dte_fechaInicio) {
        this.dte_fechaInicio = dte_fechaInicio;
    }

    public String getDte_fechaModificacion() {
        return dte_fechaModificacion;
    }

    public void setDte_fechaModificacion(String dte_fechaModificacion) {
        this.dte_fechaModificacion = dte_fechaModificacion;
    }

    public int getInt_idExperienciaLaboral() {
        return int_idExperienciaLaboral;
    }

    public void setInt_idExperienciaLaboral(int int_idExperienciaLaboral) {
        this.int_idExperienciaLaboral = int_idExperienciaLaboral;
    }

    public int getInt_idPersona() {
        return int_idPersona;
    }

    public void setInt_idPersona(int int_idPersona) {
        this.int_idPersona = int_idPersona;
    }

    public String getStr_cargo() {
        return str_cargo;
    }

    public void setStr_cargo(String str_cargo) {
        this.str_cargo = str_cargo;
    }

    public String getStr_empresa() {
        return str_empresa;
    }

    public void setStr_empresa(String str_empresa) {
        this.str_empresa = str_empresa;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_funciones() {
        return str_funciones;
    }

    public void setStr_funciones(String str_funciones) {
        this.str_funciones = str_funciones;
    }

    public String getStr_jefeInmediato() {
        return str_jefeInmediato;
    }

    public void setStr_jefeInmediato(String str_jefeInmediato) {
        this.str_jefeInmediato = str_jefeInmediato;
    }

    public String getStr_motivoCese() {
        return str_motivoCese;
    }

    public void setStr_motivoCese(String str_motivoCese) {
        this.str_motivoCese = str_motivoCese;
    }

    public String getStr_rubro() {
        return str_rubro;
    }

    public void setStr_rubro(String str_rubro) {
        this.str_rubro = str_rubro;
    }

    public String getStr_sueldo() {
        return str_sueldo;
    }

    public void setStr_sueldo(String str_sueldo) {
        this.str_sueldo = str_sueldo;
    }

    public String getStr_telfEmpresa() {
        return str_telfEmpresa;
    }

    public void setStr_telfEmpresa(String str_telfEmpresa) {
        this.str_telfEmpresa = str_telfEmpresa;
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
