/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import java.util.List;

/**
 *
 * @author zholo
 */
public interface ConfigService_I {
    
    public List<com.gestionmatriz.recursoshumanos.bean.Config>listaConfig();
    
    public boolean modificarConfig(com.gestionmatriz.recursoshumanos.bean.Config objConfig);
    
}
