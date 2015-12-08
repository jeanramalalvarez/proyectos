/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.servicio;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.seguridad.bean.Modulo;
import com.gestionmatriz.seguridad.dao.ModuloDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author YESM
 */
public class ModuloService implements ModulosService_I {
    
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    ModuloDAO objModuloDAO=fabrica.getModuloDAO();
    
    @Override
    public List<Modulo> listaModulos() throws SQLException {
        return objModuloDAO.listaModulos();
    }

    
}
