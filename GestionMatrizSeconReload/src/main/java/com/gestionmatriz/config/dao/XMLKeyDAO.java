/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.config.dao;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gestionmatriz.config.bean.Key;
import com.gestionmatriz.config.util.Util;

/**
 *
 * @author YESM
 */
public class XMLKeyDAO implements KeyDAO {

	private static final Logger log=Logger.getLogger(XMLKeyDAO.class);
    private DocumentBuilderFactory docBuilderFactory ;

    private DocumentBuilder docBuilder ;

    private Document doc ;
    
    
    
    
    public XMLKeyDAO(String archivo) {
        try {
            docBuilderFactory = DocumentBuilderFactory.newInstance();

            docBuilder = docBuilderFactory.newDocumentBuilder();
            
            
            //Comentar cuando se ejecuta el Jar fuen del IDE
            /*doc = docBuilder.parse (new File("src/com/hiper/bachHiperScripting/"
                    + "xmlBean/"+archivo+".xml"));*/
            
            //Descomentar cuando se ejecuta el Jar fuen del IDE
//            System.out.println(new File(Util.getRutaXML()+archivo+".xml"));
            doc = docBuilder.parse (new File(Util.getRutaXMLConfig()+archivo+".xml"));
            
            
            
                doc.getDocumentElement ().normalize ();

//                System.out.println ("Procesando Elemento: " +
//
//                doc.getDocumentElement().getNodeName());
                
                //getComercioXML();
               // getPerfilComercioXML();
                //getCadenaComercioXML();
                //getPerfilCargaXML();
                //getVersionXML();
                /*List<AplicativoBean> lista=getAplicaciones();
                
                for (AplicativoBean a: lista){
                    System.out.println(a.getStrIdAplicativo());
                    System.out.println(a.getStrNombreAplicativo());
                }*/
        } catch (SAXException ex) {
            java.util.logging.Logger.getLogger(XMLKeyDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(XMLKeyDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            java.util.logging.Logger.getLogger(XMLKeyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public Key getKey() {
        
        
       log.info("");
       log.info
       (".....................Leyendo Key de Credenciales de BD en XML...................");
         
          NodeList nlBDConfig = doc.getElementsByTagName
                  ("security");
         
           int numBDConfig = nlBDConfig.getLength();
           
           if (numBDConfig==1){
               
               Node nBDConfig=nlBDConfig.item(0);
               
               if (nBDConfig.getNodeType()==Node.ELEMENT_NODE){
                   
                   Element key=(Element) nBDConfig;
                   com.gestionmatriz.config.bean.Key objKey=
                           loadKey(key);
                   
                   return objKey;
               }
           }
           
        
        return null;
    }
    
    private com.gestionmatriz.config.bean.Key loadKey(Element key){
        
         com.gestionmatriz.config.bean.Key objKey=
                new com.gestionmatriz.config.bean.Key();
        
        objKey.setKey(Util.getTagValue("key", key));
        
        
        
        return objKey;
    }
    
   
}
