/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

import java.math.BigDecimal;

/**
 *
 * @author cesareots
 */
public class Pension {

    private int int_idPension;
    private String str_nombre;
    private BigDecimal dbl_pension;
    private BigDecimal dbl_seguro;
    private BigDecimal dbl_comision;
    private BigDecimal dbl_total;
    private String str_estado;
    private String str_usuarioCreador;
    private String str_fechaCreacion;
    private String str_usuarioModificador;
    private String str_fechaModificacion;

    public int getInt_idPension() {
        return int_idPension;
    }

    public void setInt_idPension(int int_idPension) {
        this.int_idPension = int_idPension;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public BigDecimal getDbl_pension() {
        return dbl_pension;
    }

    public void setDbl_pension(BigDecimal dbl_pension) {
        this.dbl_pension = dbl_pension;
    }

    public BigDecimal getDbl_seguro() {
        return dbl_seguro;
    }

    public void setDbl_seguro(BigDecimal dbl_seguro) {
        this.dbl_seguro = dbl_seguro;
    }

    public BigDecimal getDbl_comision() {
        return dbl_comision;
    }

    public void setDbl_comision(BigDecimal dbl_comision) {
        this.dbl_comision = dbl_comision;
    }

    public BigDecimal getDbl_total() {
        return dbl_total;
    }

    public void setDbl_total(BigDecimal dbl_total) {
        this.dbl_total = dbl_total;
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

    public String getStr_fechaCreacion() {
        return str_fechaCreacion;
    }

    public void setStr_fechaCreacion(String str_fechaCreacion) {
        this.str_fechaCreacion = str_fechaCreacion;
    }

    public String getStr_usuarioModificador() {
        return str_usuarioModificador;
    }

    public void setStr_usuarioModificador(String str_usuarioModificador) {
        this.str_usuarioModificador = str_usuarioModificador;
    }

    public String getStr_fechaModificacion() {
        return str_fechaModificacion;
    }

    public void setStr_fechaModificacion(String str_fechaModificacion) {
        this.str_fechaModificacion = str_fechaModificacion;
    }
}
