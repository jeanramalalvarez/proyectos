
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.reportes;



import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.util.ReportUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import jcifs.smb.SmbFileInputStream;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.log4j.Logger;
/**
 *
 * @author zholo
 */
public class Ireport {
   
   private final static Logger log=Logger.getLogger(Ireport.class);
    
   public Ireport(){}
    
   
    public void verContrato(int parametro, String nombreReprote){         
        InputStream input=null;
        Map <String,Object> parametros;
     try{
        input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/"+nombreReprote+".jasper");
        parametros = new HashMap<>();             
        parametros.clear();
        parametros.put( "idContrato", parametro );               
        ReportUtil.printView(parametros, input);
     }
    catch (Exception ex){
       log.error(ex);
    }
    finally{
         if (input!=null){
             try {
                 input.close();
             } catch (IOException ex) {
                 log.error(ex);
             }
         }
    }              
 }
    
    public void verAsistenciaXEmpresaFecha(int idEmpresa, String fechaIni,String fechaFin,String nombreReprote){         
        InputStream input=null;
        Map <String,Object> parametros;
     try{
        input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/"+nombreReprote+".jasper");  
        parametros = new HashMap<>();         
        parametros.clear();     
        parametros.put("idEmpresa", idEmpresa );
        parametros.put("fechaInicial", fechaIni );
        parametros.put("fechaFinal", fechaFin );
        ReportUtil.printView(parametros, input);
    }catch (Exception ex){
       log.error(ex);
    }
    finally{
         if (input!=null){
             try{
                 input.close();
             }catch(Exception e){
                 log.error(e);
             }
         }
    }              
 }
    
    public void verAsistenciaXTrabajadorFecha(String str_persona, String fechaIni,String fechaFin,String nombreReprote){         
       InputStream input=null;
       Map <String,Object> parametros;
     try{
        input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/"+nombreReprote+".jasper");
        parametros = new HashMap<>();             
        parametros.clear();     
        parametros.put( "str_idCodigoPersona", str_persona );    
        parametros.put( "str_fechaInicial", fechaIni );  
        parametros.put( "str_fechaFinal", fechaFin );  
        ReportUtil.printView(parametros, input);
    }catch (Exception ex){
        log.error(ex);
    }
    finally{
         if (input!=null){
             try{
                 input.close();
             }catch(Exception e){
                 log.error(e);
             }
         }
   }              
 }
    
    public boolean verFuncionesXUsuario(String str_codigoPersona, String FuncionesUsuario){         
     StringBuilder objConcat=new StringBuilder();
     InputStream input=null;
     try{
          objConcat.append("/com/gestionmatriz/reporte/").append(FuncionesUsuario).append(".jasper");
          input=getClass().getResourceAsStream(objConcat.toString().trim());
          //Se crea un objeto HashMap
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          parametros.put( "str_codigoPersona", str_codigoPersona );            
          ReportUtil.printView(parametros, input);
          //return ReportUtil.exportPDF(parametros, FuncionesUsuario, input,nameExport);
          return true;
     }catch (Exception ex){
         log.error(ex);
     }
     finally{
         if (input!=null){
             try {
                 input.close();
             } catch (IOException ex) {
                 log.error(ex);
             }
         }
     } 
     return false;
 }
    public void verUsuarioXFunciones(int int_idFunciones, String UsuariosFunciones){         
     JasperReport reporte;
     JasperPrint reporte_view; 
     
      Connection con=null;
     
     try{
          con=ConexionSql.getConexion();  
//           Process p = Runtime.getRuntime().exec (Util.getRutaAutentificate());
//          URL  in = (new URL(com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes()+UsuariosFunciones+".jasper"));
//          System.out.println("ruta jasper--"+in);
          
          String url=com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes().concat(UsuariosFunciones.concat(".jasper"));
            
            SmbFileInputStream input=new SmbFileInputStream(url);
          reporte = (JasperReport) JRLoader.loadObject( input );     
          //Se crea un objeto HashMap
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          //el nombre que se dio al parametro en JasperReport fue "p1", y se debe llamar desde Java con
          //ese mismo nombre, a su lado se pasa el valor del parametro
          parametros.put( "int_idFunciones", int_idFunciones );            
          //-----------------------------------
          reporte_view= JasperFillManager.fillReport(reporte, parametros, con);
          JasperViewer.viewReport(reporte_view,false ); //se agrega false para que no cierre toda la aplicacion
          
         
   }    catch (MalformedURLException ex ) {
            log.error("Error: Error al Crear Reporte "+ ex.getMessage());
   }
     catch ( JRException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (SQLException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (Exception ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     finally{
     try {
          ConexionSql.cerrarConexion(con);
     } catch (SQLException ex) {
           log.error("Error :"+ex.getMessage());
     }
   }              
 }
    public void verPermisoPersona(int int_idPersona, String PermisoPersona){         
     JasperReport reporte;
     JasperPrint reporte_view; 
     
      Connection con=null;
     
     try{
          con=ConexionSql.getConexion();  
//           Process p = Runtime.getRuntime().exec (Util.getRutaAutentificate());
//          URL  in = (new URL(com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes()+PermisoPersona+".jasper"));
//          System.out.println("ruta jasper--"+in);
          String url=com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes().concat(PermisoPersona.concat(".jasper"));
            
            SmbFileInputStream input=new SmbFileInputStream(url);
          reporte = (JasperReport) JRLoader.loadObject( input);     
          //Se crea un objeto HashMap
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          //el nombre que se dio al parametro en JasperReport fue "p1", y se debe llamar desde Java con
          //ese mismo nombre, a su lado se pasa el valor del parametro
          parametros.put( "int_idPersona", int_idPersona );            
          //-----------------------------------
          reporte_view= JasperFillManager.fillReport(reporte, parametros, con);
          JasperViewer.viewReport(reporte_view,false ); //se agrega false para que no cierre toda la aplicacion
          
         
   }    catch (MalformedURLException ex ) {
            log.error("Error: Error al Crear Reporte "+ ex.getMessage());
   }
     catch ( JRException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (SQLException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (Exception ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     finally{
     try {
          ConexionSql.cerrarConexion(con);
     } catch (SQLException ex) {
           log.error("Error :"+ex.getMessage());
     }
   }              
 }
    
   public void verPermisoFechas(String fechaInicial,String fechaFinal, String PermisoFechas){         
     JasperReport reporte;
     JasperPrint reporte_view; 
     
      Connection con=null;
     
     try{
          con=ConexionSql.getConexion();  
//           Process p = Runtime.getRuntime().exec (Util.getRutaAutentificate());
//          URL  in = (new URL(com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes()+PermisoFechas+".jasper"));
//          System.out.println("ruta jasper--"+in);
          String url=com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes().concat(PermisoFechas.concat(".jasper"));
            
            SmbFileInputStream input=new SmbFileInputStream(url);
          reporte = (JasperReport) JRLoader.loadObject( input );     
          //Se crea un objeto HashMap
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          //el nombre que se dio al parametro en JasperReport fue "p1", y se debe llamar desde Java con
          //ese mismo nombre, a su lado se pasa el valor del parametro
          parametros.put( "fechaInicial", fechaInicial );    
          parametros.put( "fechaFinal", fechaFinal );
          //-----------------------------------
          reporte_view= JasperFillManager.fillReport(reporte, parametros, con);
          JasperViewer.viewReport(reporte_view,false ); //se agrega false para que no cierre toda la aplicacion
          
         
   }    catch (MalformedURLException ex ) {
            log.error("Error: Error al Crear Reporte "+ ex.getMessage());
   }
     catch ( JRException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (SQLException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (Exception ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     finally{
     try {
          ConexionSql.cerrarConexion(con);
     } catch (SQLException ex) {
           log.error("Error :"+ex.getMessage());
     }
   }              
 } 
   
   public void verMemorandumPersona(int int_idPersona, String MemorandumPersona){         
     JasperReport reporte;
     JasperPrint reporte_view; 
     
      Connection con=null;
     
     try{
          con=ConexionSql.getConexion();  
//           Process p = Runtime.getRuntime().exec (Util.getRutaAutentificate());
//          URL  in = (new URL(com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes()+MemorandumPersona+".jasper"));
//          System.out.println("ruta jasper--"+in);
          String url=com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes().concat(MemorandumPersona.concat(".jasper"));
            
            SmbFileInputStream input=new SmbFileInputStream(url);
          reporte = (JasperReport) JRLoader.loadObject( input );     
          //Se crea un objeto HashMap
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          //el nombre que se dio al parametro en JasperReport fue "p1", y se debe llamar desde Java con
          //ese mismo nombre, a su lado se pasa el valor del parametro
          parametros.put( "int_idPersona", int_idPersona );   
        
          //-----------------------------------
          reporte_view= JasperFillManager.fillReport(reporte, parametros, con);
          JasperViewer.viewReport(reporte_view,false ); //se agrega false para que no cierre toda la aplicacion
          
         
   }    catch (MalformedURLException ex ) {
            log.error("Error: Error al Crear Reporte "+ ex.getMessage());
   }
     catch ( JRException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (SQLException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (Exception ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     finally{
     try {
          ConexionSql.cerrarConexion(con);
     } catch (SQLException ex) {
          log.error("Error :"+ex.getMessage());
     }
   }              
 } 
   
   public void verMMemorandumFecha(String fechaInicial,String fechaFinal,
           String str_asunto , String MemorandumFecha){         
     JasperReport reporte;
     JasperPrint reporte_view; 
     
      Connection con=null;
     
     try{
          con=ConexionSql.getConexion();  
//           Process p = Runtime.getRuntime().exec (Util.getRutaAutentificate());
//          URL  in = (new URL(com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes()+MemorandumFecha+".jasper"));
//          System.out.println("ruta jasper--"+in);
          String url=com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes().concat(MemorandumFecha.concat(".jasper"));
            
            SmbFileInputStream input=new SmbFileInputStream(url);
          reporte = (JasperReport) JRLoader.loadObject( input );     
          //Se crea un objeto HashMap
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          //el nombre que se dio al parametro en JasperReport fue "p1", y se debe llamar desde Java con
          //ese mismo nombre, a su lado se pasa el valor del parametro
          parametros.put( "fechaInicial", fechaInicial );   
          parametros.put( "fechaFinal", fechaFinal );
          parametros.put( "str_asunto", str_asunto );
        
          //-----------------------------------
          reporte_view= JasperFillManager.fillReport(reporte, parametros, con);
          JasperViewer.viewReport(reporte_view,false ); //se agrega false para que no cierre toda la aplicacion
          
         
   }catch (MalformedURLException ex ) {
            log.error("Error: Error al Crear Reporte "+ ex.getMessage());
   }
     catch ( JRException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (SQLException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (Exception ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     finally{
     try {
          ConexionSql.cerrarConexion(con);
     } catch (SQLException ex) {
           log.error("Error :"+ex.getMessage());
     }
   }              
 }
   
   public void verAsistenciaLocales(int idEmpresa, String fechaIni,String fechaFin,String ReproteLocales){         
     JasperReport reporte;
     JasperPrint reporte_view; 
     
      Connection con=null;
     
     try{
          con=ConexionSql.getConexion(); 
          
//         Process p = Runtime.getRuntime().exec (Util.getRutaAutentificate());
//          
//         
//          URL  in = (new URL(com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes()+ReproteLocales+".jasper"));
//          System.out.println("ruta jasper--"+in);
          
          String url=com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes().concat(ReproteLocales.concat(".jasper"));
            
            SmbFileInputStream input=new SmbFileInputStream(url);
          reporte = (JasperReport) JRLoader.loadObject( input );     
          //Se crea un objeto HashMap
          Map <String,Object> parametros = new HashMap<>();         
          parametros.clear();     
          //el nombre que se dio al parametro en JasperReport fue "p1", y se debe llamar desde Java con
          //ese mismo nombre, a su lado se pasa el valor del parametro
          parametros.put("int_idEmpresa", idEmpresa );
          parametros.put("fechaInicial", fechaIni );
          parametros.put("fechaFinal", fechaFin );
          //-----------------------------------
          reporte_view= JasperFillManager.fillReport(reporte, parametros, con);
          JasperViewer.viewReport(reporte_view,false ); //se agrega false para que no cierre toda la aplicacion
          
         
   }    catch (MalformedURLException ex ) {
            log.error("Error: Error al Crear Reporte "+ ex.getMessage());
   }
     catch ( JRException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (SQLException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (Exception ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     finally{
     try {
          ConexionSql.cerrarConexion(con);
     } catch (SQLException ex) {
          log.error("Error :"+ex.getMessage());
     }
   }              
 }
   public void verDescansoXTrabajadorFecha(int int_idPersona, String fechaInicial,String fechaFinal,String DescansoTrabajador){         
     JasperReport reporte;
     JasperPrint reporte_view; 
     
      Connection con=null;
     
     try{
          con=ConexionSql.getConexion();  
//           Process p = Runtime.getRuntime().exec (Util.getRutaAutentificate());
//          URL  in = (new URL(com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes()+DescansoTrabajador+".jasper"));
//          System.out.println("ruta jasper--"+in);
          String url=com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes().concat(DescansoTrabajador.concat(".jasper"));
            
            SmbFileInputStream input=new SmbFileInputStream(url);
          reporte = (JasperReport) JRLoader.loadObject( input );     
          //Se crea un objeto HashMap
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          //el nombre que se dio al parametro en JasperReport fue "p1", y se debe llamar desde Java con
          //ese mismo nombre, a su lado se pasa el valor del parametro
          parametros.put( "int_idCodigo", int_idPersona );    
          parametros.put( "fechaInicial", fechaInicial );  
          parametros.put( "fechaFinal", fechaFinal ); 
          //-----------------------------------
          reporte_view= JasperFillManager.fillReport(reporte, parametros, con);
          JasperViewer.viewReport(reporte_view,false ); //se agrega false para que no cierre toda la aplicacion
          
         
   }    catch (MalformedURLException ex ) {
            log.error("Error: Error al Crear Reporte "+ ex.getMessage());
   }
     catch ( JRException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (SQLException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (Exception ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     finally{
     try {
          ConexionSql.cerrarConexion(con);
     } catch (SQLException ex) {
          log.error("Error :"+ex.getMessage());
     }
   }              
 }
   
   
 public void verReportePartTime(int int_idContrato, String fechaInicial,String fechaFinal,String PartTime){         
     JasperReport reporte;
     JasperPrint reporte_view; 
     
      Connection con=null;
     
     try{
          con=ConexionSql.getConexion();  
//           Process p = Runtime.getRuntime().exec (Util.getRutaAutentificate());
//          URL  in = (new URL(com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes()+PartTime+".jasper"));
//          System.out.println("ruta jasper--"+in);
          String url=com.gestionmatriz.util.Util.objOtros.getStr_rutaReportes().concat(PartTime.concat(".jasper"));
            
            SmbFileInputStream input=new SmbFileInputStream(url);
          reporte = (JasperReport) JRLoader.loadObject( input );     
          //Se crea un objeto HashMap
          Map <String,Object> parametros = new HashMap<>();             
          parametros.clear();     
          //el nombre que se dio al parametro en JasperReport fue "p1", y se debe llamar desde Java con
          //ese mismo nombre, a su lado se pasa el valor del parametro
          parametros.put( "idContrato", int_idContrato );    
          parametros.put( "fechaIni", fechaInicial );  
          parametros.put( "fechaFin", fechaFinal ); 
          //-----------------------------------
          reporte_view= JasperFillManager.fillReport(reporte, parametros, con);
          JasperViewer.viewReport(reporte_view,false ); //se agrega false para que no cierre toda la aplicacion
          
         
   }    catch (MalformedURLException ex ) {
            log.error("Error: Error al Crear Reporte "+ ex.getMessage());
   }
     catch ( JRException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (SQLException ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     catch (Exception ex){
          log.error("Error: Error al Crear Reporte "+ ex.getMessage());
     }
     finally{
     try {
          ConexionSql.cerrarConexion(con);
     } catch (SQLException ex) {
           log.error("Error :"+ex.getMessage());
     }
   }              
 }
//    public static void main(String args[]) {
//         new Ireport().verFuncionesXUsuario("j66","FuncionesUsuario");
//    }
}

