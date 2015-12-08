/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.Bonificacion;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface BonificacionDAO {

    public boolean registrarBonifiacion(Bonificacion objBonificacion);

    public List<Bonificacion> listarBonificacion();
 
    public boolean modificarBonifiacion(Bonificacion objBonificacion);
    
}
