/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author YESM
 */
public class OtrosEstudios {
    private int int_idOtrosEstudios;
    private int int_idPersona;
    private String str_estudio;
    private String str_nivelEstudio;
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

    public String getDte_ultimaModificacion() {
        return dte_ultimaModificacion;
    }

    public void setDte_ultimaModificacion(String dte_ultimaModificacion) {
        this.dte_ultimaModificacion = dte_ultimaModificacion;
    }

    public int getInt_idOtrosEstudios() {
        return int_idOtrosEstudios;
    }

    public void setInt_idOtrosEstudios(int int_idOtrosEstudios) {
        this.int_idOtrosEstudios = int_idOtrosEstudios;
    }

    public int getInt_idPersona() {
        return int_idPersona;
    }

    public void setInt_idPersona(int int_idPersona) {
        this.int_idPersona = int_idPersona;
    }

    public String getStr_estudio() {
        return str_estudio;
    }

    public void setStr_estudio(String str_estudio) {
        this.str_estudio = str_estudio;
    }

    public String getStr_nivelEstudio() {
        return str_nivelEstudio;
    }

    public void setStr_nivelEstudio(String str_nivelEstudio) {
        this.str_nivelEstudio = str_nivelEstudio;
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
