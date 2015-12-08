/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.recursoshumanos.bean.Bonificacion;
import com.gestionmatriz.recursoshumanos.dao.BonificacionDAO;
import java.util.List;

/**
 *
 * @author zholo
 */
public class BonificacionService implements BonificacionService_I{

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);		
    BonificacionDAO objBonificacionDAO =fabrica.getBonificacionDAO();
    
    @Override
    public boolean registrarBonifiacion(Bonificacion objBonificacion) {
        return objBonificacionDAO.registrarBonifiacion(objBonificacion);
    }

    @Override
    public List<Bonificacion> listaBonificacion() {
        return objBonificacionDAO.listarBonificacion();
    }

    @Override
    public boolean modificarBonifiacion(Bonificacion objBonificacion) {
        return objBonificacionDAO.modificarBonifiacion(objBonificacion);
    }
    
}
