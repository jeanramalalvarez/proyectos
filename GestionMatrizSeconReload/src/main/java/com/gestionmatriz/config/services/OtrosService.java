/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.config.services;

import com.gestionmatriz.config.bean.Otros;
import com.gestionmatriz.config.dao.OtrosDAO;
import com.gestionmatriz.config.util.Util;
import com.gestionmatriz.dao.DAOFactory;

/**
 *
 * @author YESM
 */
public class OtrosService implements OtrosService_I {

    DAOFactory fabrica;
    OtrosDAO objOtrosDAO;

    public OtrosService() {
        fabrica = DAOFactory.getDAOFactory(DAOFactory.XML);
        objOtrosDAO = fabrica.getOtrosDAO(Util.CONFIG);
    }

    @Override
    public Otros getOtros() {
        return objOtrosDAO.getOtros();
    }
}
