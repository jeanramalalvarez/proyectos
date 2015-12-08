/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.reutilizable.bean;

import java.math.BigDecimal;

/**
 *
 * @author YESM
 */
public class ConfigBD {
    
    private int int_id;
    private int int_minutosEspera;
    private BigDecimal dblIGV;

    public BigDecimal getDblIGV() {
        return dblIGV;
    }

    public void setDblIGV(BigDecimal dblIGV) {
        this.dblIGV = dblIGV;
    }
    
    
    

    public int getInt_id() {
        return int_id;
    }

    public void setInt_id(int int_id) {
        this.int_id = int_id;
    }

    public int getInt_minutosEspera() {
        return int_minutosEspera;
    }

    public void setInt_minutosEspera(int int_minutosEspera) {
        this.int_minutosEspera = int_minutosEspera;
    }
    
    
    
}
