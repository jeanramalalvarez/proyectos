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
public class Config {
    
    private int int_IdConfig;
    private int int_minutosAntes;
    private int int_minutosDespues;
    private BigDecimal dbl_igv;
    private BigDecimal dbl_uit;
    private String tipoImpresion;
    private String str_formatoTicket;
    
    public static final String TICKETERA = "T";
    public static final String MATRICIAL = "M";

    public BigDecimal getDbl_igv() {
        return dbl_igv;
    }

    public void setDbl_igv(BigDecimal dbl_igv) {
        this.dbl_igv = dbl_igv;
    }

    public BigDecimal getDbl_uit() {
        return dbl_uit;
    }

    public void setDbl_uit(BigDecimal dbl_uit) {
        this.dbl_uit = dbl_uit;
    }

    public int getInt_IdConfig() {
        return int_IdConfig;
    }

    public void setInt_IdConfig(int int_IdConfig) {
        this.int_IdConfig = int_IdConfig;
    }

    public int getInt_minutosAntes() {
        return int_minutosAntes;
    }

    public void setInt_minutosAntes(int int_minutosAntes) {
        this.int_minutosAntes = int_minutosAntes;
    }

    public String getStr_formatoTicket() {
		return str_formatoTicket;
	}

	public void setStr_formatoTicket(String str_formatoTicket) {
		this.str_formatoTicket = str_formatoTicket;
	}

	public int getInt_minutosDespues() {
        return int_minutosDespues;
    }

    public void setInt_minutosDespues(int int_minutosDespues) {
        this.int_minutosDespues = int_minutosDespues;
    }

    public String getTipoImpresion() {
        return tipoImpresion;
    }

    public void setTipoImpresion(String tipoImpresion) {
        this.tipoImpresion = tipoImpresion;
    }

    
   
}
