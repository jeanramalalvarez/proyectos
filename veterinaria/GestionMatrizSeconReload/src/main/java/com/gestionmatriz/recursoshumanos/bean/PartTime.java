/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author jarcon
 */
public class PartTime {
    

  private int int_idMedioTiempo;
  private int int_asistencia;
  private String dte_marcacion;
  private String str_estado;
  private String str_iniFin;

    public String getStr_iniFin() {
        return str_iniFin;
    }

    public void setStr_iniFin(String str_iniFin) {
        this.str_iniFin = str_iniFin;
    }

    public String getDte_marcacion() {
        return dte_marcacion;
    }

    public void setDte_marcacion(String dte_marcacion) {
        this.dte_marcacion = dte_marcacion;
    }

    public int getInt_asistencia() {
        return int_asistencia;
    }

    public void setInt_asistencia(int int_asistencia) {
        this.int_asistencia = int_asistencia;
    }

    public int getInt_idMedioTiempo() {
        return int_idMedioTiempo;
    }

    public void setInt_idMedioTiempo(int int_idMedioTiempo) {
        this.int_idMedioTiempo = int_idMedioTiempo;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }


    
}
