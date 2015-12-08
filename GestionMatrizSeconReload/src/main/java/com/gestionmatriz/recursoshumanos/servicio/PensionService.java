/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.recursoshumanos.bean.Pension;
import com.gestionmatriz.recursoshumanos.dao.PensionDAO;
import java.util.List;

/**
 *
 * @author cesareots
 */
public class PensionService implements PensionService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    PensionDAO objPensionDAO = fabrica.getPensionDAO();

    @Override
    public List<Pension> listaPension() {
        return objPensionDAO.listaPension();
    }

    @Override
    public boolean registrarPension(Pension objPension) {
        return objPensionDAO.registrarPension(objPension);
    }

    @Override
    public boolean modificarPension(Pension objPension) {
        return objPensionDAO.modificarPension(objPension);
    }
}
