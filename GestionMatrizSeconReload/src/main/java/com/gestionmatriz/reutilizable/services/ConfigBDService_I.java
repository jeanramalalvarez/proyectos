/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.reutilizable.services;

import java.math.BigDecimal;

/**
 *
 * @author YESM
 */
public interface ConfigBDService_I {
    
    public abstract int[] getTiempoEspera();
    
     public BigDecimal getIGV() ;
}
