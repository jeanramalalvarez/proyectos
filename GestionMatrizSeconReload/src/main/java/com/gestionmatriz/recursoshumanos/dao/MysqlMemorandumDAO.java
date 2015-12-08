/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.Memorandum;
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
public class MysqlMemorandumDAO extends ConexionSqlSpring implements MemorandumDAO{

	private static final Logger log=Logger.getLogger(MysqlMemorandumDAO.class); 
    @Override
    public boolean registrarMemorandum(Memorandum objMemorandum) {
        boolean respuesta=false;
        Connection cnn = null;
        
        try {
            
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            String sql;
            PreparedStatement ps;      
            
            ps=null;
            sql="CALL sp_insertMemorandum"
                    + PrepararSQL.get(8);
            ps=cnn.prepareStatement(sql);
            
            
            ps.setInt(1, objMemorandum.getInt_idPersona());
            ps.setString(2, objMemorandum.getStr_numero());
            ps.setString(3, objMemorandum.getStr_emisor());
            ps.setString(4, objMemorandum.getStr_receptor());
            ps.setString(5, objMemorandum.getStr_asunto());
            ps.setString(6, objMemorandum.getDte_fecha());
            ps.setString(7, objMemorandum.getStr_cuerpo());
            ps.setString(8, objMemorandum.getStr_usuarioCreador());            
            
            respuesta= ps.execute();
            cnn.commit();
            respuesta=true;          
            
        } catch (SQLException ex) {
            try {
                log.error("Error SQL: "+ex.getMessage());
                cnn.rollback();
                respuesta=false;
            } catch (SQLException ex1) {
                log.error("Error: "+ex1.getMessage());
            }
        }
        catch (Exception ex){
            try {
                log.error("Error: "+ex.getMessage());
                  cnn.rollback();
                respuesta=false;
            } catch (SQLException ex1) {
                 log.error("Error: "+ex1.getMessage());
            }
        }
        finally{
            try {
               
               ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                try {
                    cnn.rollback();
                    log.error("Error al Intentar Cerrar la BD: "+ex.getMessage());
                } catch (SQLException ex1) {
                     log.error("Error en el RollBack "+ex1.getMessage());
                }
            }
        }
        
        return respuesta;
    }

    @Override
    public List<Memorandum> listarMemorandum() {
        Connection cnn = null;
      
	List<Memorandum> lista =new ArrayList<>();
        
        try {
            
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
                        
            String sql="CALL sp_selectMemorandum"
                    + PrepararSQL.get(0);
            
            
            PreparedStatement ps=cnn.prepareStatement(sql);
                     
                         
            ResultSet rs=ps.executeQuery();
            
            Memorandum objMemorandum ;  
            
            while(rs.next()){
				
		objMemorandum=new Memorandum();
                
                objMemorandum.setInt_idMemorandum(rs.getInt(1));
                objMemorandum.setStr_numero(rs.getString(2));
                objMemorandum.setStr_emisor(rs.getString(3));
                objMemorandum.setStr_receptor(rs.getString(4));
                objMemorandum.setStr_asunto(rs.getString(5));
                objMemorandum.setDte_fecha(rs.getString(6));
                objMemorandum.setStr_cuerpo(rs.getString(7));
                objMemorandum.setStr_usuarioCreador(rs.getString(8));
                objMemorandum.setDte_fechaCreacion(rs.getString(9));
		objMemorandum.setInt_idPersona(rs.getInt(10));
		
                //agregamos al cliente al arreglo
		lista.add(objMemorandum);
            }
            
        } catch (SQLException ex) {
            log.error("Error SQL: "+ex.getMessage());
        }
        catch(Exception ex){
                log.error("Error SQL: "+ex.getMessage());
        }
        finally{
            try {               
               ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: "+ex.getMessage());
            }
        }    
    return lista;    
    }

    @Override
    public List<Memorandum> buscarMemorandum(String asunto, String fecchaInicial, String fechaFinal) {
        Connection cnn = null;
      
	List<Memorandum> lista =new ArrayList<>();
        
        try {
            
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
                        
            String sql="CALL sp_buscarMemorandum"
                    + PrepararSQL.get(3);
            
            
            PreparedStatement ps=cnn.prepareStatement(sql);
            
            ps.setString(1,asunto );
            ps.setString(2, fecchaInicial);
            ps.setString(3, fechaFinal);
                         
            ResultSet rs=ps.executeQuery();
            
            Memorandum objMemorandum ;  
            
            while(rs.next()){
				
		objMemorandum=new Memorandum();
                
                objMemorandum.setInt_idMemorandum(rs.getInt(1));
                objMemorandum.setStr_numero(rs.getString(2));
                objMemorandum.setStr_emisor(rs.getString(3));
                objMemorandum.setStr_receptor(rs.getString(4));
                objMemorandum.setStr_asunto(rs.getString(5));
                objMemorandum.setDte_fecha(rs.getString(6));
                objMemorandum.setStr_cuerpo(rs.getString(7));
                objMemorandum.setStr_usuarioCreador(rs.getString(8));
                objMemorandum.setDte_fechaCreacion(rs.getString(9));
		objMemorandum.setInt_idPersona(rs.getInt(10));
                objMemorandum.setStr_estado(rs.getString(11));
		
                //agregamos al cliente al arreglo
		lista.add(objMemorandum);
            }
            
        } catch (SQLException ex) {
            log.error("Error SQL: "+ex.getMessage());
        }
        catch(Exception ex){
                log.error("Error SQL: "+ex.getMessage());
        }
        finally{
            try {               
               ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: "+ex.getMessage());
            }
        }    
    return lista;  
    }

    @Override
    public boolean updateEstadoMemorandum(int idMemorandum) {
       boolean respuesta=false;
        Connection cnn = null;
        
        try {
            
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            String sql;
            PreparedStatement ps;      
            
            ps=null;
            sql="CALL sp_updateEstadoMemorandum"
                    + PrepararSQL.get(1);
            ps=cnn.prepareStatement(sql);
            
            
            ps.setInt(1, idMemorandum);
                      
            
            respuesta= ps.execute();
            cnn.commit();
            respuesta=true;          
            
        } catch (SQLException ex) {
            try {
                log.error("Error SQL: "+ex.getMessage());
                cnn.rollback();
                respuesta=false;
            } catch (SQLException ex1) {
                log.error("Error: "+ex1.getMessage());
            }
        }
        catch (Exception ex){
            try {
                log.error("Error: "+ex.getMessage());
                  cnn.rollback();
                respuesta=false;
            } catch (SQLException ex1) {
                 log.error("Error: "+ex1.getMessage());
            }
        }
        finally{
            try {
               
               ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                try {
                    cnn.rollback();
                    log.error("Error al Intentar Cerrar la BD: "+ex.getMessage());
                } catch (SQLException ex1) {
                     log.error("Error en el RollBack "+ex1.getMessage());
                }
            }
        }
        
        return respuesta;
    }
    
}
