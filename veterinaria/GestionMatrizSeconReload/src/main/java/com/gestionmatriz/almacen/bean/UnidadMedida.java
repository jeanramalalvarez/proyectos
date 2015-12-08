/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.bean;

/**
 *
 * @author cesareo
 */
public class UnidadMedida {
    
    private int int_idUnidadMedida;
    private String str_codigoUM;
    private String str_nombreUM;
    private String str_descripcionUM;
    private String str_estado;
    
    private String str_usuarioCreador;
    private String str_fechaCreacion;
    private String str_usuarioModificador;
    private String str_fechaModificacion;

    public int getInt_idUnidadMedida() {
        return int_idUnidadMedida;
    }

    public void setInt_idUnidadMedida(int int_idUnidadMedida) {
        this.int_idUnidadMedida = int_idUnidadMedida;
    }

    public String getStr_descripcionUM() {
        return str_descripcionUM;
    }

    public void setStr_descripcionUM(String str_descripcionUM) {
        this.str_descripcionUM = str_descripcionUM;
    }

    public String getStr_fechaCreacion() {
        return str_fechaCreacion;
    }

    public void setStr_fechaCreacion(String str_fechaCreacion) {
        this.str_fechaCreacion = str_fechaCreacion;
    }

    public String getStr_fechaModificacion() {
        return str_fechaModificacion;
    }

    public void setStr_fechaModificacion(String str_fechaModificacion) {
        this.str_fechaModificacion = str_fechaModificacion;
    }

    public String getStr_nombreUM() {
        return str_nombreUM;
    }

    public void setStr_nombreUM(String str_nombreUM) {
        this.str_nombreUM = str_nombreUM;
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
    
    public String getStr_codigoUM() {
        return str_codigoUM;
    }

    public void setStr_codigoUM(String str_codigoUM) {
        this.str_codigoUM = str_codigoUM;
    }
    
    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }
    
}
