/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.config.util;


import java.io.File;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



/**
 *
 * @author ytorres
 */
public class Util {
   
   private final static String EXEWINDOWS="run.bat";
   public final static String CONFIG="config";
   public final static String MATRIZ="matriz";
   public final static  String DEPARTAMENTO="15";
   public final static String PROVINCIA="01";
   //static Logger log=Logger.getLogger(Util.class);
    
   
    //private final static String rutaXML="config\\";
    private final static String rutaXML=System.getProperty("user.dir") + File.separator + "config" + File.separator ;
    private final static String rutaAutentificate=System.getProperty("user.dir") + File.separator + "config" + File.separator +"autentificate.bat";

    public static String getEXEWINDOWS() {
        return EXEWINDOWS;
    }

    public static String getRutaAutentificate() {
        return rutaAutentificate;
    }
    
    public static String getRutaXMLConfig() {
        
        return rutaXML;
    }
    
   
    public static  String getTagValue(String tag, Element elemento) {

        NodeList lista = elemento.getElementsByTagName(tag).item(0).getChildNodes();

        Node valor = (Node) lista.item(0);
        
        String strValor= valor.getNodeValue();
        
        if (strValor.length()>1){
            return strValor.trim();
        }
        return strValor;
    }
    
}
