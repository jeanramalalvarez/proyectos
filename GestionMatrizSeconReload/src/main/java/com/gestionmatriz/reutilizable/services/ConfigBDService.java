/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.reutilizable.services;

import java.math.BigDecimal;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.reutilizable.dao.ConfigBDDAO;

/**
 *
 * @author YESM
 */
public class ConfigBDService implements ConfigBDService_I{
    
     DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);		
     ConfigBDDAO objConfigDAO =fabrica.getConfigBDDAO();
  

    @Override
    public int[] getTiempoEspera() {
        return objConfigDAO.getTiempoEspera();
    }

    @Override
    public BigDecimal getIGV() {
        return objConfigDAO.getIGV();
    }
    
}
