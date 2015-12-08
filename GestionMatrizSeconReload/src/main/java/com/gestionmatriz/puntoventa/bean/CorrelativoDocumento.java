/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.bean;

/**
 *
 * @author YESM
 */
public class CorrelativoDocumento {

    private String str_NombreCorto;
    private String str_serie;
    private int int_correlativo;
    private int int_codigoCorrelativo;

    public int getInt_codigoCorrelativo() {
        return int_codigoCorrelativo;
    }

    public void setInt_codigoCorrelativo(int int_codigoCorrelativo) {
        this.int_codigoCorrelativo = int_codigoCorrelativo;
    }

    public int getInt_correlativo() {
        return int_correlativo;
    }

    public void setInt_correlativo(int int_correlativo) {
        this.int_correlativo = int_correlativo;
    }

    public String getStr_NombreCorto() {
        return str_NombreCorto;
    }

    public void setStr_NombreCorto(String str_NombreCorto) {
        this.str_NombreCorto = str_NombreCorto;
    }

    public String getStr_serie() {
        return str_serie;
    }

    public void setStr_serie(String str_serie) {
        this.str_serie = str_serie;
    }
}
