/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author YESM
 */
public class DatosAcademicos {
    private int int_idDatosAcademicos;
    private int int_idPersona;
    private String str_nivel;
    private String str_institucionEducativa;
    private String dte_inicio;
    private String dte_termino;
    private String str_observacion;
    private String str_gradoTitulo;
    private String dte_fechaCreacion;
    private String str_usuarioCreador;
    private String dte_ultimaModificacion;
    private String str_usuarioModificador;

    public String getDte_fechaCreacion() {
        return dte_fechaCreacion;
    }

    public void setDte_fechaCreacion(String dte_fechaCreacion) {
        this.dte_fechaCreacion = dte_fechaCreacion;
    }

    public String getDte_inicio() {
        return dte_inicio;
    }

    public void setDte_inicio(String dte_inicio) {
        this.dte_inicio = dte_inicio;
    }

    public String getDte_termino() {
        return dte_termino;
    }

    public void setDte_termino(String dte_termino) {
        this.dte_termino = dte_termino;
    }

    public String getDte_ultimaModificacion() {
        return dte_ultimaModificacion;
    }

    public void setDte_ultimaModificacion(String dte_ultimaModificacion) {
        this.dte_ultimaModificacion = dte_ultimaModificacion;
    }

    public int getInt_idDatosAcademicos() {
        return int_idDatosAcademicos;
    }

    public void setInt_idDatosAcademicos(int int_idDatosAcademicos) {
        this.int_idDatosAcademicos = int_idDatosAcademicos;
    }

    public int getInt_idPersona() {
        return int_idPersona;
    }

    public void setInt_idPersona(int int_idPersona) {
        this.int_idPersona = int_idPersona;
    }

    public String getStr_gradoTitulo() {
        return str_gradoTitulo;
    }

    public void setStr_gradoTitulo(String str_gradoTitulo) {
        this.str_gradoTitulo = str_gradoTitulo;
    }

    public String getStr_institucionEducativa() {
        return str_institucionEducativa;
    }

    public void setStr_institucionEducativa(String str_institucionEducativa) {
        this.str_institucionEducativa = str_institucionEducativa;
    }

    public String getStr_nivel() {
        return str_nivel;
    }

    public void setStr_nivel(String str_nivel) {
        this.str_nivel = str_nivel;
    }

    public String getStr_observacion() {
        return str_observacion;
    }

    public void setStr_observacion(String str_observacion) {
        this.str_observacion = str_observacion;
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
