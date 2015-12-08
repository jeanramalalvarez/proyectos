/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

/**
 *
 * @author zholo
 */
public class MysqlReporteDAO extends ConexionSqlSpring implements ReporteDAO{

	private static final Logger log=Logger.getLogger(MysqlReporteDAO.class); 
    @Override
    public List<Personal> listaPersonaMemo() {
       Connection cnn = null;
      
	List<Personal>listaPersonaMemo = new ArrayList<>();
        Personal objPersona=null;
        try {
            
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
                        
            String sql="CALL sp_selecPersonaMemorandum"
                    + PrepararSQL.get(0);
            
            
            PreparedStatement ps=cnn.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
                
            while(rs.next()) {
                
                objPersona=new Personal();
                
                objPersona.setInt_idPersona(rs.getInt(3));
                objPersona.setStr_codigo(rs.getString(4));
                objPersona.setStr_apePaterno(rs.getString(5));
                objPersona.setStr_apeMaterno(rs.getString(6));
                objPersona.setStr_nombres(rs.getString(7));                
                
                listaPersonaMemo.add(objPersona);
                
            }
                
            
        } catch (SQLException ex) {
            log.error("Error SQL: "+ex.getMessage());
        }
        finally{
            try {               
               ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: "+ex.getMessage());
            }
        }    
    return  listaPersonaMemo;
    }

    @Override
    public List<Personal> listaPersonaFunciones() {
        Connection cnn = null;
      
	List<Personal>listaPersonaFunciones = new ArrayList<>();
        Personal objPersona=null;
        try {
            
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
                        
            String sql="CALL sp_selecPersonaFunciones"
                    + PrepararSQL.get(0);
            
            
            PreparedStatement ps=cnn.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
                
            while(rs.next()) {
                
                objPersona=new Personal();
                
                objPersona.setInt_idPersona(rs.getInt(1));
                objPersona.setStr_codigo(rs.getString(2));
                objPersona.setStr_apePaterno(rs.getString(3));
                objPersona.setStr_apeMaterno(rs.getString(4));
                objPersona.setStr_nombres(rs.getString(5));                
                
                listaPersonaFunciones.add(objPersona);
                
            }
                
            
        } catch (SQLException ex) {
            log.error("Error SQL: "+ex.getMessage());
        }
        finally{
            try {               
               ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: "+ex.getMessage());
            }
        }    
    return  listaPersonaFunciones;
    }

    @Override
    public List<Personal> listaPersonaPermisos() {
        Connection cnn = null;
      
	List<Personal>listaPersonaPermisos = new ArrayList<>();
        Personal objPersona=null;
        try {
            
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
                        
            String sql="CALL sp_selecPersonaPermisos"
                    + PrepararSQL.get(0);
            
            
            PreparedStatement ps=cnn.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
                
            while(rs.next()) {
                
                objPersona=new Personal();
                
                objPersona.setInt_idPersona(rs.getInt(1));
                objPersona.setStr_codigo(rs.getString(2));
                objPersona.setStr_apePaterno(rs.getString(3));
                objPersona.setStr_apeMaterno(rs.getString(4));
                objPersona.setStr_nombres(rs.getString(5));  
                objPersona.setStr_dni(rs.getString(6));
                
                listaPersonaPermisos.add(objPersona);
                
            }
                
            
        } catch (SQLException ex) {
            log.error("Error SQL: "+ex.getMessage());
        }
        finally{
            try {               
               ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: "+ex.getMessage());
            }
        }    
    return  listaPersonaPermisos;
    }
    
}
