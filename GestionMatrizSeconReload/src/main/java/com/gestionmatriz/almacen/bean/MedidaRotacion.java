/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.bean;

import java.math.BigDecimal;

/**
 *
 * @author cesareo
 */
public class MedidaRotacion {
    
    private int int_idMedidaRotacion;
    private String str_codigoMR;
    private String str_nombreMR;
    private BigDecimal dbl_utilidad;
    private BigDecimal dbl_adicional;
    private String str_descripcionMR;
    private String str_estado;
    private String str_usuarioCreador;
    private String str_fechaCreacion;
    private String str_usuarioModificador;
    private String str_fechaModificacion;

    public BigDecimal getDbl_adicional() {
        return dbl_adicional;
    }

    public void setDbl_adicional(BigDecimal dbl_adicional) {
        this.dbl_adicional = dbl_adicional;
    }

    public BigDecimal getDbl_utilidad() {
        return dbl_utilidad;
    }

    public void setDbl_utilidad(BigDecimal dbl_utilidad) {
        this.dbl_utilidad = dbl_utilidad;
    }

    public int getInt_idMedidaRotacion() {
        return int_idMedidaRotacion;
    }

    public void setInt_idMedidaRotacion(int int_idMedidaRotacion) {
        this.int_idMedidaRotacion = int_idMedidaRotacion;
    }

    public String getStr_codigoMR() {
        return str_codigoMR;
    }

    public void setStr_codigoMR(String str_codigoMR) {
        this.str_codigoMR = str_codigoMR;
    }

    public String getStr_descripcionMR() {
        return str_descripcionMR;
    }

    public void setStr_descripcionMR(String str_descripcionMR) {
        this.str_descripcionMR = str_descripcionMR;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
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

    public String getStr_nombreMR() {
        return str_nombreMR;
    }

    public void setStr_nombreMR(String str_nombreMR) {
        this.str_nombreMR = str_nombreMR;
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
