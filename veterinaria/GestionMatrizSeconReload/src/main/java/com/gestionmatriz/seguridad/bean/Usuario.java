/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.bean;

import com.gestionmatriz.recursoshumanos.bean.Personal;

/**
 *
 * @author YESMI
 */
public class Usuario {
    
    
    private int int_idUsuario;
    private int int_idPersona;
    private String str_codigoPersona;

 
    private String str_usuario;
    private String str_contrasenia;
    private String str_estado;   
    private String dte_fechaCreacion;
    private String str_usuarioCreador;
    private String dte_fechaModificacion;
    private String str_usuarioModificador;
    private Personal objPersona;

    
    
    public String getStr_codigoPersona() {
        return str_codigoPersona;
    }

    public void setStr_codigoPersona(String str_codigoPersona) {
        this.str_codigoPersona = str_codigoPersona;
    }
    
    public Personal getObjPersona() {
        return objPersona;
    }

    public void setObjPersona(Personal objPersona) {
        this.objPersona = objPersona;
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

    public int getInt_idPersona() {
        return int_idPersona;
    }

    public void setInt_idPersona(int int_idPersona) {
        this.int_idPersona = int_idPersona;
    }

    public int getInt_idUsuario() {
        return int_idUsuario;
    }

    public void setInt_idUsuario(int int_idUsuario) {
        this.int_idUsuario = int_idUsuario;
    }

    public String getStr_contrasenia() {
        return str_contrasenia;
    }

    public void setStr_contrasenia(String str_contrasenia) {
        this.str_contrasenia = str_contrasenia;
    }

    public String getStr_usuario() {
        return str_usuario;
    }

    public void setStr_usuario(String str_usuario) {
        this.str_usuario = str_usuario;
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
    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }
}
