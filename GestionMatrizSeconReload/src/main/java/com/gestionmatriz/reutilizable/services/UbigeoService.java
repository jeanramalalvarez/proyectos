/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.reutilizable.services;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.reutilizable.bean.Ubigeo;
import com.gestionmatriz.reutilizable.dao.UbigeoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author YESM
 */
public class UbigeoService implements UbigeoService_I {
    
     DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);		
     UbigeoDAO objUbigeoDAO =fabrica.getUbigeoDAO();
  
    @Override
    public List<Ubigeo> listaDepartamentos() throws SQLException {
        return objUbigeoDAO.listaDepartamentos();
    }

    @Override
    public List<Ubigeo> listaProvincias(String depart) throws SQLException {
        return objUbigeoDAO.listaProvincias(depart);
    }

    @Override
    public List<Ubigeo> listaDistritos(String depart, String provin) throws SQLException {
        return objUbigeoDAO.listaDistritos(depart, provin);
    }
    
}
