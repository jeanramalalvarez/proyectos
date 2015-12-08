/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author zholo
 */
public class TipoMarcado {
    
    public static final char ASISTENCIA='A',SALIDA='S',JUSTIDICACION='J',FALTA='F';
            
    private String int_tipoMarcado;
    private String str_descripcion;

    public String getInt_tipoMarcado() {
        return int_tipoMarcado;
    }

    public void setInt_tipoMarcado(String int_tipoMarcado) {
        this.int_tipoMarcado = int_tipoMarcado;
    }

    public String getStr_descripcion() {
        return str_descripcion;
    }

    public void setStr_descripcion(String str_descripcion) {
        this.str_descripcion = str_descripcion;
    }
}
