/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.reportes;

import com.gestionmatriz.util.ReportUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author jarcon
 */
public class Ireport {
    
    private final Logger log=Logger.getLogger(Ireport.class);  
    
    /**
     * ventas por usuario
     * @param usuario usuario
     * @param fchInicial fecha Inicial
     * @param fchFinal fecha final
     */
    public void ventasUsuario(String usuario,String fchInicial,String fchFinal){         
        InputStream input=null;
     
     try{
          input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/VentasUsuario.jasper");
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          parametros.put( "fchInicial", fchInicial );      
          parametros.put( "fchFinal", fchFinal );
          parametros.put( "usuario", usuario );
          ReportUtil.printView(parametros, input);
     }
     catch (Exception ex){
         log.error(ex.getMessage(),ex);
     }
   finally{
    try {
          input.close();
     } catch (IOException ex) {
          log.error(ex.getMessage(),ex);
     }
   }              
 }
    /**
     * Ventas realizadas por tienda
     * @param local local
     * @param fchInicial fecha inicial
     * @param fchFinal fecha final
     * @param doc  numero de documento
     */
    public void ventasTienda(String local,String fchInicial,String fchFinal, String doc){         
     InputStream input=null;
     
     try{
         
          input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/VentasTienda.jasper");
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          parametros.put( "fchInicial", fchInicial );      
          parametros.put( "fchFinal", fchFinal );
          parametros.put( "local", local );
          parametros.put( "doc", doc );
          ReportUtil.printView(parametros, input);
     }catch (Exception ex){
          log.error(ex.getMessage(),ex);
     }
   finally{
    try {
          input.close();
     } catch (IOException ex) {
          log.error(ex.getMessage(),ex);
     }
   }              
 }
 
/**
 * Reporte grafico de ventas por tienda diaria
 * @param fchInicial fecha inicial
 * @param fchFinal fecha final
 */    
 public void GraficoVentaTiendaDia(String fchInicial,String fchFinal){         
     InputStream input=null;
     
     try{
          input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/GraficoVentaTiendaDia.jasper");
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          parametros.put( "fchInicial", fchInicial );      
          parametros.put( "fchFinal", fchFinal );
          ReportUtil.printView(parametros, input);
     }
     catch (Exception ex){
          log.error(ex.getMessage(),ex);
     }
   finally{
    try {
         input.close();
     } catch (IOException ex) {
          log.error(ex.getMessage(),ex);
     }
   }              
 }   
   
 
 /**
  * Reporte de ventas por linea entre fechas
  * @param fchInicial fecha inicial
  * @param fchFinal fecha final
  */
 public void VentaFechasLineas(String fchInicial,String fchFinal){         
     InputStream input=null;
     try{
         
          input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/VentaFechasLineas.jasper");
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          parametros.put( "fchInicial", fchInicial );      
          parametros.put( "fchFinal", fchFinal );
          ReportUtil.printView(parametros, input);
     }catch (Exception ex){
         log.error(ex.getMessage(),ex);
     }
   finally{
    try {
          input.close();
     } catch (IOException ex) {
         log.error(ex.getMessage(),ex);
     }
   }              
 }
 
 /**
  * Imprime una proforma
  * @param nroProforma nombre de proforma
  * @param empresa nombre de empresa
  */
 public void Proforma(String nroProforma,String empresa){         
     InputStream input=null;
     try{
         input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/Proforma.jasper");
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          parametros.put( "nroProforma", nroProforma );      
          parametros.put( "empresa", empresa );
          ReportUtil.printView(parametros, input);
   
     }catch (Exception ex){
          log.error(ex.getMessage(),ex);
     }
   finally{
    try {
          input.close();
     } catch (IOException ex) {
          log.error(ex.getMessage(),ex);
     }
   }              
 }
 
 /**
  * Imprime Guia
  * @param nroGuia  numero de guia
  */
 public void imprmirGuia(String nroGuia) {
        InputStream input=null;

        try {
            input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/GuiaRemision.jasper");
            Map<String, Object> parametros = new HashMap<>();
            parametros.clear();
            
            parametros.put("nroGuia", nroGuia);
            ReportUtil.printView(parametros, input);
        } catch (Exception ex) {
            log.error(ex.getMessage(),ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
               log.error(ex.getMessage(),ex);
            }
        }
    }
 
 /**
  * Reporte de ventas diarias
  * @param fchInicial fecha inicial
  * @param fchFinal fecha final
  * @param idLocal local
  */
 public void TotalesDia(String fchInicial,String fchFinal,int idLocal){         
     InputStream input=null;
     
     try{
         input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/TotalVentadia.jasper");
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          parametros.put( "fchInicial", fchInicial );      
          parametros.put( "fchFinal", fchFinal ); 
          parametros.put("idLocal",idLocal);
          //-----------------------------------
          ReportUtil.printView(parametros, input);

     }catch (Exception ex){
          log.error(ex.getMessage(),ex);
     }
   finally{
    try {
          input.close();
     } catch (IOException ex) {
          log.error(ex.getMessage(),ex);
     }
   }              
 }
 
 /**
  * Registro de ventas 
  * @param fchInicial fecha inicial
  * @param fchFinal fecha final
  * @param tienda tienda
  * @param idLocal local
  * @param mes  mes
  */
public void RegistroVentas(String fchInicial,String fchFinal, 
		String mesInicial ,String mesFinal, String numRuc){         
    
    InputStream input=null;
     
     try{
         
          input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/RegistroVenta.jasper");
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          parametros.put( "fchInicial", fchInicial );      
          parametros.put( "fchFinal", fchFinal );
          parametros.put( "mesFinal", mesFinal );
          parametros.put( "mesInicial", mesInicial );
          parametros.put("numRuc", numRuc);
          ReportUtil.printView(parametros, input);
     }catch (Exception ex){
        log.error(ex.getMessage(),ex);
     }
   finally{
    try {
          input.close();
     } catch (IOException ex) {
          log.error(ex.getMessage(),ex);
     }
   }              
 }

/**
 * Registro de ventas 
 * @param fchInicial fecha inicial
 * @param fchFinal fecha final
 * @param tienda tienda
 * @param idLocal local
 */
public void RegistroVentasTienda(String fchInicial,String fchFinal,String tienda, 
		int idLocal,String mesInicial ,String mesFinal, String numRuc){         
   
   InputStream input=null;
    
    try{
        
         input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/RegistroVentaTienda.jasper");
         Map <String,Object> parametros = new HashMap<>();             
         parametros.clear();     
         parametros.put( "fchInicial", fchInicial );      
         parametros.put( "fchFinal", fchFinal );
         parametros.put( "tienda", tienda );
         parametros.put( "idLocal", idLocal );
         parametros.put( "mesFinal", mesFinal );
         parametros.put( "mesInicial", mesInicial );
         parametros.put("numRuc", numRuc);
         ReportUtil.printView(parametros, input);
    }catch (Exception ex){
       log.error(ex.getMessage(),ex);
    }
  finally{
   try {
         input.close();
    } catch (IOException ex) {
         log.error(ex.getMessage(),ex);
    }
  }              
}

}
