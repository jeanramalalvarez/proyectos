/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import java.util.List;
import com.gestionmatriz.recursoshumanos.bean.Bonificacion;


/**
 *
 * @author zholo
 */
public interface BonificacionService_I {
    
    
    public boolean registrarBonifiacion(Bonificacion  objBonificacion);
    
    public boolean modificarBonifiacion(Bonificacion objBonificacion);
    
    public List<Bonificacion>listaBonificacion();
}
