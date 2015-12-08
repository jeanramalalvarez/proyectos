/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.load;


import com.gestionmatriz.seguridad.gui.Logeo;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.Mensaje;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import org.apache.log4j.Logger;




/**
 *
 * @author YESMI
 */
public class Load {
    
    private static final Logger log=Logger.getLogger(Load.class);  
    
    private Logeo frmLogue;
    public Load() {
        
    	 Connection conn = null;
        try {
            log.info("Probando Conexion con el Servidor de BD............");
            log.info("");
            Globales.TIPO_CONEXION=Constantes.JDBC;
            conn=ConexionSql.getConexion();
            log.info("");
            log.info("Conexion Exitosa............");
        } catch (SQLException ex) {
           Mensaje.mensaje(frmLogue, "Error de Conexión con Servidor de BD", 
                   Mensaje.TITULO_ME, Mensaje.ERROR);
            log.error("Error: "+ex.getMessage());
            System.exit(0);
        }finally{
        	try {
				conn.close();
			} catch (SQLException e) {
				log.error(e.getMessage());
			}
        }
        
        
        log.info("Creando Interfaz Grafica............");        
        frmLogue=new Logeo();
        frmLogue.setTitle("Ingreso al Sistema");
        frmLogue.setVisible(true);
        frmLogue.setSize(350, 218);
        frmLogue.setLocationRelativeTo(null);
        frmLogue.setIconImage(new ImageIcon(getClass().getResource( "/com/gestionmatriz/icon/principal.png")).getImage());

        
        
        log.info("Interfaz Grafica Creada..............");
        
    }
    
    
    /**
     * Carga de la aplicacion
     * @param args 
     */
    public static void main(String args[]) {
       
        /* Mejora la Interface del Sistema*/
        try{ 
            UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel"); 
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
            
        
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                log.info(
                "-------------------------Iniciando Sistema Matriz-----------------------");
                new Load();
                log.info("Carga del sistema terminada..............");
                
            }
        });
    }
    
}
