/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.config.dao;

import com.gestionmatriz.almacen.gui.GestionPrecioOferta;
import com.gestionmatriz.config.bean.BDConfig;
import com.gestionmatriz.config.bean.Key;
import com.gestionmatriz.config.services.KeyService_I;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.config.util.Util;
import com.gestionmatriz.util.EncriptionSource;
import com.gestionmatriz.util.FunctionByte;

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

/**
 *
 * @author YESMI
 */
public class XMLBDConfigDAO implements BDConfigDAO {

	private static final Logger log=Logger.getLogger(GestionPrecioOferta.class);
    private DocumentBuilderFactory docBuilderFactory;
    private DocumentBuilder docBuilder;
    private Document doc;
    //Atributos para la desencriptacion
    private static Key objKey;
    private static KeyService_I objKey_I;

    public XMLBDConfigDAO(String archivo) {
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
            java.util.logging.Logger.getLogger(XMLBDConfigDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(XMLBDConfigDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            java.util.logging.Logger.getLogger(XMLBDConfigDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public BDConfig getBDConfig() {
        log.info("");
        log.info(".....................Leyendo Credenciales de BD en XML...................");

        NodeList nlBDConfig = doc.getElementsByTagName("BD");
        int numBDConfig = nlBDConfig.getLength();

        if (numBDConfig == 1) {
            Node nBDConfig = nlBDConfig.item(0);

            if (nBDConfig.getNodeType() == Node.ELEMENT_NODE) {
                Element BDConfig = (Element) nBDConfig;
                BDConfig objDBConfig = loadDBConfig(BDConfig);
                return objDBConfig;
            }
        }

        return null;
    }

    private BDConfig loadDBConfig(Element DBConfig) {
        BDConfig objBDConfig = new BDConfig();

        try {
            //Creamos la llave de desencryptacion
            objKey_I = PaqueteBusinessDelegate.getKeyService();
            objKey = objKey_I.getKey();
            //Creamos la llave de desencryptacion

            //Creamos el objDesencryptacion===============================
            EncriptionSource objEncrip = new EncriptionSource();
            //Creamos el objDesencryptacion===============================


            objBDConfig.setStrUsuario(objEncrip.Decrypt(FunctionByte.hex2byte(
                    objKey.getKey()),
                    FunctionByte.hex2byte(
                    Util.getTagValue(
                    "usuario-bd", DBConfig))));


            objBDConfig.setStrContrasenia(objEncrip.Decrypt(FunctionByte.hex2byte(
                    objKey.getKey()),
                    FunctionByte.hex2byte(
                    Util.getTagValue(
                    "pass-bd", DBConfig))));
            //objBDConfig.setStrContrasenia(Util.getTagValue("pass-bd", DBConfig));


            objBDConfig.setStrBaseDatos(objEncrip.Decrypt(FunctionByte.hex2byte(
                    objKey.getKey()),
                    FunctionByte.hex2byte(
                    Util.getTagValue(
                    "base-datos", DBConfig))));

            //objBDConfig.setStrBaseDatos(Util.getTagValue("base-datos", DBConfig));


            objBDConfig.setStrServidor(objEncrip.Decrypt(FunctionByte.hex2byte(
                    objKey.getKey()),
                    FunctionByte.hex2byte(
                    Util.getTagValue(
                    "host-bd", DBConfig))));
            //objBDConfig.setStrServidor(Util.getTagValue("host-bd", DBConfig));

//
//            System.out.println("usuario: "+objBDConfig.getStrUsuario());
//            System.out.println("Ps: "+objBDConfig.getStrContrasenia());
//            System.out.println("BD: "+objBDConfig.getStrBaseDatos());
//            System.out.println("Serv: "+objBDConfig.getStrServidor());


        } catch (ParserConfigurationException ex) {
            log.error("Error al leer credenciales de BD: " + ex.getMessage());
        } catch (SAXException ex) {
            log.error("Error al leer credenciales de BD: " + ex.getMessage());
        } catch (IOException ex) {
            log.error("Error al leer credenciales de BD: " + ex.getMessage());
        }
        return objBDConfig;
    }
}
