/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.reutilizable.services;

import com.gestionmatriz.reutilizable.bean.Ubigeo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author YESMI
 */
public interface UbigeoService_I {
    
     public abstract List<Ubigeo> listaDepartamentos() throws SQLException;
     public abstract List<Ubigeo> listaProvincias(String depart) throws SQLException;
     public abstract List<Ubigeo> listaDistritos (String depart, String provin) 
              throws SQLException;
      
}
