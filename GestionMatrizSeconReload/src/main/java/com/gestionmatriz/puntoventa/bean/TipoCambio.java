/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.bean;

import java.math.BigDecimal;

/**
 *
 * @author cesareo
 */
public class TipoCambio {
    
    private int int_idTipoCambio;
    private BigDecimal dbl_precioCompraDolar;
    private BigDecimal dbl_precioVentaDolar;
    private String str_fechaDia;
    private String str_estado;
    private String str_usuarioCreador;
    private String str_fechaCreacion;
    private String str_usuarioModificador;
    private String str_fechaModificacion;

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public BigDecimal getDbl_precioCompraDolar() {
        return dbl_precioCompraDolar;
    }

    public void setDbl_precioCompraDolar(BigDecimal dbl_precioCompraDolar) {
        this.dbl_precioCompraDolar = dbl_precioCompraDolar;
    }

    public BigDecimal getDbl_precioVentaDolar() {
        return dbl_precioVentaDolar;
    }

    public void setDbl_precioVentaDolar(BigDecimal dbl_precioVentaDolar) {
        this.dbl_precioVentaDolar = dbl_precioVentaDolar;
    }

    public int getInt_idTipoCambio() {
        return int_idTipoCambio;
    }

    public void setInt_idTipoCambio(int int_idTipoCambio) {
        this.int_idTipoCambio = int_idTipoCambio;
    }

    public String getStr_fechaDia() {
        return str_fechaDia;
    }

    public void setStr_fechaDia(String str_fechaDia) {
        this.str_fechaDia = str_fechaDia;
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
