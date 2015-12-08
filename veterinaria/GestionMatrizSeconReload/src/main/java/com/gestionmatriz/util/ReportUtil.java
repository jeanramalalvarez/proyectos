/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionmatriz.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

import org.apache.log4j.Logger;

import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;

/**
 *
 * @author YESMI
 */
public class ReportUtil extends ConexionSqlSpring {
    
    private static final Logger log=Logger.getLogger(ReportUtil.class);
    
    public static void printView(Map <String,Object> parametros,InputStream input){
        log.info("printView[");
        JasperReport reporte;
        JasperPrint reporte_view; 
        Connection cnn=null;
        try{
        	cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?
                    ConexionSql.getConexion():ConexionSqlSpring. getDataSource().getConnection();  
            reporte = (JasperReport) JRLoader.loadObject( input ); 
            reporte_view= JasperFillManager.fillReport(reporte, parametros, cnn);
            JasperViewer.viewReport(reporte_view,false ); 
        }catch(Exception ex){
            log.error(ex);
        }finally{
            try {
          ConexionSql.cerrarConexion(cnn);
        } catch (SQLException ex) {
            log.error(ex);
        }
        }
        log.info("printView]");
    }
    
    public static boolean exportPDF(Map <String,Object> parametros, String 
            nameReport,InputStream input,String nameExport){
        log.info("exportPDF[");
        JasperReport reporte;
        JasperPrint reportePrint; 
        JRPdfExporter exportar=null;
        OutputStream out=null;
        Connection con=null;
        try{
            con = ConexionSql.getConexion();  
            reporte = (JasperReport) JRLoader.loadObject( input ); 
            reportePrint= JasperFillManager.fillReport(reporte, parametros, con);
            exportar=new JRPdfExporter();
            //out=new FileOutputStream(nameExport);
            /*exportar.setParameter(JRExporterParameter.JASPER_PRINT, reportePrint);
            exportar.setParameter(JRExporterParameter.OUTPUT_STREAM, out);*/
            exportar.setExporterInput(new SimpleExporterInput(reportePrint));
            exportar.setExporterOutput(new SimpleOutputStreamExporterOutput(nameExport));
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exportar.setConfiguration(configuration);
            exportar.exportReport();
            return true;
        }catch(Exception ex){
            log.error(ex);
        }finally{
            try {
                out.close();
                 ConexionSql.cerrarConexion(con);
            } catch (SQLException ex) {
                log.error(ex);
            } catch (IOException ex) {
                log.error(ex);
            }
        }
        log.info("exportPDF]");
        return false;
    }
}
