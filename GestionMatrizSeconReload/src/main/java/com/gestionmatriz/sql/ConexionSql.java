/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.sql;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.gestionmatriz.config.bean.BDConfig;
import com.gestionmatriz.config.services.BDConfigService_I;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;


/**
 *
 * @author ytorres
 */


public class ConexionSql {

//   static final Logger log=Logger.getLogger(ConexionSql.class);
   
	private static final Logger log=Logger.getLogger(ConexionSql.class);
	private static BDConfig objBDConfig;
   private static BDConfigService_I objBDConfig_I;
   private static Connection con;
static     
    {
        try {
            //ProcessXML objXML=new ProcessXML(Util.CONFIG); 
            objBDConfig_I=PaqueteBusinessDelegate.getBDConfigService();
            
            objBDConfig=objBDConfig_I.getBDConfig();
            
         
             Class.forName("com.mysql.jdbc.Driver"); // Mysql
             
        } catch (ClassNotFoundException ex) {
            log.error("Error : " + ex.getMessage());
        } catch (ParserConfigurationException ex) {
            log.error("Error : " + ex.getMessage());
        } catch (SAXException ex) {
            log.error("Error : " + ex.getMessage());
        } catch (IOException ex) {
            log.error("Error : " + ex.getMessage());
        }
       
                        
       
    }
       
       public static Connection getConexion() throws SQLException {
      
       if (con==null || con.isClosed()){
                con = DriverManager.getConnection
            ("jdbc:mysql:"
                    +objBDConfig.getStrServidor()+"/"
                    +objBDConfig.getStrBaseDatos(),
                     objBDConfig.getStrUsuario(),
                     objBDConfig.getStrContrasenia());

//            Connection con = DriverManager.getConnection
//            ("jdbc:mysql:"
//                    +"//localhost:3306"+"/"
//                    +"matriz",
//                     "agente",
//                     "admin");
                log.info("Servidor: "+objBDConfig.getStrServidor());

       }
       
        
        return con;
       }
       
       public static void cerrarConexion(Connection cnn) throws  SQLException{
//           cnn.close();
       }
       
       public static void cerrarConexionAll(Connection cnn) throws  SQLException{
           cnn.close();
           log.info("Conexion Cerrada con Exito");
       }
}
