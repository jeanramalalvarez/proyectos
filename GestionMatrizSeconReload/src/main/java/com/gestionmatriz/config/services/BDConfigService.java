/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.config.services;

import com.gestionmatriz.config.bean.BDConfig;
import com.gestionmatriz.config.dao.BDConfigDAO;
import com.gestionmatriz.config.util.Util;
import com.gestionmatriz.dao.DAOFactory;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author YESM
 */
public class BDConfigService implements BDConfigService_I {

    DAOFactory fabrica;
    BDConfigDAO objBDConfigDAO;

    public BDConfigService() throws ParserConfigurationException, SAXException, IOException {
        fabrica = DAOFactory.getDAOFactory(DAOFactory.XML);
        objBDConfigDAO = fabrica.getBDConfigDAO(Util.CONFIG);
    }

    @Override
    public BDConfig getBDConfig() {
        return objBDConfigDAO.getBDConfig();
    }
}
