/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.config.dao;

import com.gestionmatriz.config.bean.Otros;
import com.gestionmatriz.config.util.Util;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author YESMI
 */
public class XMLOtrosDAO implements OtrosDAO {

    private DocumentBuilderFactory docBuilderFactory;
    private DocumentBuilder docBuilder;
    private Document doc;
    //Atributos para la desencriptacion

    public XMLOtrosDAO(String archivo) {
        try {
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docBuilderFactory.newDocumentBuilder();
            
            //Comentar cuando se ejecuta el Jar fuen del IDE
            /*doc = docBuilder.parse (new File("src/com/hiper/bachHiperScripting/"
            + "xmlBean/"+archivo+".xml"));*/

            //Descomentar cuando se ejecuta el Jar fuen del IDE
//            System.out.println(new File(Util.getRutaXML()+archivo+".xml"));
            doc = docBuilder.parse(new File(Util.getRutaXMLConfig() + archivo + ".xml"));
            doc.getDocumentElement().normalize();

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
            java.util.logging.Logger.getLogger(XMLOtrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(XMLOtrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            java.util.logging.Logger.getLogger(XMLOtrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Otros getOtros() {
        NodeList nlOtros = doc.getElementsByTagName("OTROS");
        int numOtros = nlOtros.getLength();

        if (numOtros == 1) {
            Node nOtros = nlOtros.item(0);

            if (nOtros.getNodeType() == Node.ELEMENT_NODE) {
                Element Otros = (Element) nOtros;
                Otros objOtros = loadOtros(Otros);
                return objOtros;
            }
        }

        return null;
    }

    private Otros loadOtros(Element Otros) {
        Otros objOtros = new Otros();
        objOtros.setStr_IGV(Util.getTagValue("valor-igv", Otros));
        objOtros.setStr_rutaReportes(Util.getTagValue("ruta-reportes", Otros));
//        System.out.println("ruta--:"+objOtros.getStr_rutaReportes());
        return objOtros;
    }
}
