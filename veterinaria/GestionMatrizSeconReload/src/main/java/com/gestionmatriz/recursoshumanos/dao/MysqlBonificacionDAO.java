/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.Bonificacion;
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
public class MysqlBonificacionDAO extends ConexionSqlSpring implements BonificacionDAO{

	private static final Logger log=Logger.getLogger(MysqlBonificacionDAO.class); 
    @Override
    public boolean registrarBonifiacion(Bonificacion objBonificacion) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_insertBonificacion" + PrepararSQL.get(3);
            PreparedStatement ps = cnn.prepareStatement(sql);
            
            ps.setString(1, objBonificacion.getStr_descripcion());           
            ps.setBigDecimal(2, objBonificacion.getDbl_monto());
            ps.setString(3, objBonificacion.getStr_usuarioCreador());
//            System.out.println("mysql---"+objConfig.getDbl_uit());
            ps.execute();
            cnn.commit();
            respuesta = true;
        } catch (SQLException ex) {
            try {
                cnn.rollback();
                log.error("Error SQL: " + ex.getMessage());
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            try {
                cnn.rollback();
                log.error("Error: " + ex.getMessage());
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
            }
        }
        
        return respuesta;
    }

    @Override
    public List<Bonificacion> listarBonificacion() {
       Connection cnn = null;
        List<Bonificacion> listaBonificacion = new ArrayList<>();
        Bonificacion objBonificacion = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarBonificacion" + PrepararSQL.get(0);
            PreparedStatement ps = cnn.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objBonificacion = new Bonificacion();
                
                objBonificacion.setInt_idBonificacion(rs.getInt(1));
                objBonificacion.setStr_descripcion(rs.getString(2));
                objBonificacion.setDbl_monto(rs.getBigDecimal(3));
                objBonificacion.setStr_estado(rs.getString(4));
                objBonificacion.setStr_usuarioCreador(rs.getString(5));
                objBonificacion.setDte_fechaCreacion(rs.getString(6));
               

                listaBonificacion.add(objBonificacion);
            }
        } catch (SQLException ex) {
            log.error("Error SQL: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
            }
        }
        
        return listaBonificacion;
    }

    @Override
    public boolean modificarBonifiacion(Bonificacion objBonificacion) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_updateBonificacion" + PrepararSQL.get(5);
            PreparedStatement ps = cnn.prepareStatement(sql);
            
            ps.setInt(1, objBonificacion.getInt_idBonificacion());
            ps.setString(2, objBonificacion.getStr_descripcion());           
            ps.setBigDecimal(3, objBonificacion.getDbl_monto());
            ps.setString(4, objBonificacion.getStr_estado());
            ps.setString(5, objBonificacion.getStr_usuarioCreador());
//            System.out.println("mysql---"+objConfig.getDbl_uit());
            ps.execute();
            cnn.commit();
            respuesta = true;
        } catch (SQLException ex) {
            try {
                cnn.rollback();
                log.error("Error SQL: " + ex.getMessage());
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            try {
                cnn.rollback();
                log.error("Error: " + ex.getMessage());
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
            }
        }
        
        return respuesta;
    }
    
}
