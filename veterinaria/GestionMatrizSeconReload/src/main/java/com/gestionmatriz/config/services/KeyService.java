/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.config.services;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.gestionmatriz.config.bean.Key;
import com.gestionmatriz.config.dao.KeyDAO;
import com.gestionmatriz.config.util.Util;
import com.gestionmatriz.dao.DAOFactory;

/**
 *
 * @author YESM
 */
public class KeyService implements KeyService_I {
    
    
    DAOFactory fabrica ;		
    KeyDAO objKeyDAO;
    
    public KeyService() throws ParserConfigurationException, SAXException, IOException {
        fabrica=DAOFactory.getDAOFactory(DAOFactory.XML);
        objKeyDAO=fabrica.getKeyDAO(Util.MATRIZ);
    }

    @Override
    public Key getKey() {
        return objKeyDAO.getKey();
    }

  
    
   
    
}
