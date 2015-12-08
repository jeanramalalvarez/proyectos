/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.Config;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface ConfigDAO {

    public List<Config> listaConfig();

    public boolean modificarConfig(Config objConfig);
    
}
