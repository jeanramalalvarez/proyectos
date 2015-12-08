/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.Pension;
import java.util.List;

/**
 *
 * @author cesareots
 */
public interface PensionDAO {
    
    public abstract boolean registrarPension(Pension objPension);
    
    public abstract List<Pension> listaPension();
    
    public abstract boolean modificarPension(Pension objPension);
}
