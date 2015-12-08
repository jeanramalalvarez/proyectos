/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.Permisos;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.PrepararSQL;
import com.gestionmatriz.util.Util;

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
public class MysqlPermisoDAO extends ConexionSqlSpring implements PermisoDAO {

	private static final Logger log=Logger.getLogger(MysqlPermisoDAO.class); 
    @Override
    public boolean registrarPermiso(Permisos objPermiso) {
       Connection cnn=null;
       boolean respuesta=false;
       PreparedStatement ps=null;
       ResultSet rs=null;
        try {
            
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            String sql;
                    
            sql="call sp_exitePermiso ".concat(PrepararSQL.get(5));
            
            ps=cnn.prepareStatement(sql);
            
            ps.setInt(1, objPermiso.getInt_idPersona());
            ps.setString(2,objPermiso.getDte_fecha());
            ps.setString(3, objPermiso.getTm_horaSalida());
            ps.setString(4, objPermiso.getTm_horaLlegada());
            ps.setString(5, Util.ACTIVO);
            
            rs=ps.executeQuery();
            
            if (rs.next()){
                respuesta=false;
                Mensaje.mensaje("Usted Cuenta ya con una solicitud de permiso, detalle : \n"
                        + " F: Permiso: "+rs.getString(2)+"\n H. Salida: "+ rs.getString(4) +"\n H. Llegada: "+rs.getString(5),
                        Mensaje.TITULO_ME, Mensaje.ERROR);
                throw  new SQLException("Error Creador por el Usuario: Persona Cuenta con persmiso");
            }
            
            rs=null;
            ps=null;
            sql="call sp_insertarPermiso".concat(PrepararSQL.get(7));
            
            ps=cnn.prepareStatement(sql);
            
            ps.setString(1, objPermiso.getDte_fecha());
            ps.setString(2, objPermiso.getStr_motivo());
            ps.setString(3, objPermiso.getTm_horaSalida());
            ps.setString(4, objPermiso.getTm_horaLlegada());
            ps.setString(5, objPermiso.getStr_observacion());
            ps.setString(6, Util.ACTIVO);
            ps.setInt(7, objPermiso.getInt_idPersona());
            
            ps.execute();
            
            cnn.commit();
            respuesta=true;
            
        } catch (SQLException ex) {
            
            log.error("Error: "+ex.getMessage());
            try {
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: "+ex1.getMessage());
            }
        }
        catch (Exception ex){
            log.error("Error: "+ex.getMessage());
            try {
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: "+ex1.getMessage());
            }
        }
        finally{
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error: "+ex.getMessage());
            }
        }
       
       
       return respuesta;
    }

    @Override
    public List<Permisos> listaPermisos(String fi,String ff) {
        List<Permisos> listaPermisos=new ArrayList<>();
        
        Connection cnn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Permisos objPermisos;
            Personal objPersona;
        
        try{
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            
            String sql="call sp_listaPermisos".concat(PrepararSQL.get(2));
            
            
            ps=cnn.prepareStatement(sql);
            
            ps.setString(1, fi);
            ps.setString(2, ff);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                objPermisos=new Permisos();
                    objPersona=new Personal();
                    objPersona.setInt_idPersona(rs.getInt(1));
                    objPersona.setStr_codigo(rs.getString(2));
                    objPersona.setStr_apePaterno(rs.getString(3));
                    objPersona.setStr_apeMaterno(rs.getString(4));
                    objPersona.setStr_nombres(rs.getString(5));
                    objPersona.setStr_dni(rs.getString(6));
                    objPersona.setStr_estado(rs.getString(7));
                    
                objPermisos.setObjPersona(objPersona);    
                objPermisos.setInt_idPermisos(rs.getInt(8));
                objPermisos.setDte_fecha(rs.getString(9));
                objPermisos.setStr_motivo(rs.getString(10));
                objPermisos.setTm_horaSalida(rs.getString(11));
                objPermisos.setTm_horaLlegada(rs.getString(12));
                objPermisos.setStr_observacion(rs.getString(13));
                objPermisos.setStr_estado(rs.getString(14));
                objPermisos.setTm_horaMarcadoSalida(rs.getString(15));
                objPermisos.setTm_horaMarcadoLlegada(rs.getString(16));
                objPermisos.setDte_fechaRegistro(rs.getString(17));
                
                listaPermisos.add(objPermisos);
            }
            
            
        }
        catch(SQLException ex){
            log.error("Error: "+ex.getMessage());
        }
        catch (Exception ex){
            
        }
        finally{
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error: "+ex.getMessage());
            }
        }
                
        
        return listaPermisos;
    }

    @Override
    public boolean actualizarEstadoPermiso(int idPermiso, String estado,String usuario) {
        Connection cnn=null;
       boolean respuesta=false;
       PreparedStatement ps=null;
       
        try {
            
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            String sql;
                    
            sql="call sp_updateEstadoPermiso ".concat(PrepararSQL.get(3));
            
            ps=cnn.prepareStatement(sql);
            
            ps.setInt(1, idPermiso);
            ps.setString(2,estado);
            ps.setString(3, usuario);
            
            
            
            ps.execute();
            
            cnn.commit();
            respuesta=true;
            
        } catch (SQLException ex) {
            
            log.error("Error: "+ex.getMessage());
            try {
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: "+ex1.getMessage());
            }
        }
        catch (Exception ex){
            log.error("Error: "+ex.getMessage());
            try {
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: "+ex1.getMessage());
            }
        }
        finally{
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error: "+ex.getMessage());
            }
        }
       
       
       return respuesta;
       
    }

    @Override
    public List<Permisos> listaPermisosXPersona(int persona) {
        List<Permisos> listaPermisos=new ArrayList<>();
        
        Connection cnn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Permisos objPermisos;
            Personal objPersona;
        
        try{
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            
            String sql="call sp_listaPermisosXPersona ".concat(PrepararSQL.get(1));
            
            ps=cnn.prepareStatement(sql);
            
            ps.setInt(1, persona);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                objPermisos=new Permisos();
                    objPersona=new Personal();
                    objPersona.setInt_idPersona(rs.getInt(1));
                    objPersona.setStr_codigo(rs.getString(2));
                    objPersona.setStr_apePaterno(rs.getString(3));
                    objPersona.setStr_apeMaterno(rs.getString(4));
                    objPersona.setStr_nombres(rs.getString(5));
                    objPersona.setStr_dni(rs.getString(6));
                    objPersona.setStr_estado(rs.getString(7));
                    
                objPermisos.setObjPersona(objPersona);    
                objPermisos.setInt_idPermisos(rs.getInt(8));
                objPermisos.setDte_fecha(rs.getString(9));
                objPermisos.setStr_motivo(rs.getString(10));
                objPermisos.setTm_horaSalida(rs.getString(11));
                objPermisos.setTm_horaLlegada(rs.getString(12));
                objPermisos.setStr_observacion(rs.getString(13));
                objPermisos.setStr_estado(rs.getString(14));
                objPermisos.setTm_horaMarcadoSalida(rs.getString(15));
                objPermisos.setTm_horaMarcadoLlegada(rs.getString(16));
                objPermisos.setDte_fechaRegistro(rs.getString(17));
                
                listaPermisos.add(objPermisos);
            }
            
            
        }
        catch(SQLException ex){
            log.error("Error: "+ex.getMessage());
        }
        catch (Exception ex){
            
        }
        finally{
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error: "+ex.getMessage());
            }
        }
                
        
        return listaPermisos;
    }
    
    
}
