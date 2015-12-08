/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.reutilizable.dao;

import java.math.BigDecimal;

/**
 *
 * @author YESM
 */
public interface ConfigBDDAO {
    
    public abstract int[] getTiempoEspera();
    
    public abstract BigDecimal getIGV();
}
