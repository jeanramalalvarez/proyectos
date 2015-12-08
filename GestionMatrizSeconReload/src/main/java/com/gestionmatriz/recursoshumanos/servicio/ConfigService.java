/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.recursoshumanos.bean.Config;
import com.gestionmatriz.recursoshumanos.dao.ConfigDAO;
import java.util.List;

/**
 *
 * @author zholo
 */
public class ConfigService implements ConfigService_I{
    
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    ConfigDAO objConfigDAO = fabrica.getConfigDAO();

    @Override
    public List<Config> listaConfig() {
        return objConfigDAO.listaConfig();
    }

    @Override
    public boolean modificarConfig(Config objConfig) {
        return objConfigDAO.modificarConfig(objConfig);
    }
    
}
