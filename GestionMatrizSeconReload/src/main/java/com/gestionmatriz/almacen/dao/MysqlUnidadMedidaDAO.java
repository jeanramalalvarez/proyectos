/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.UnidadMedida;
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
public class MysqlUnidadMedidaDAO extends ConexionSqlSpring implements UnidadMedidaDAO {

	private static final Logger log=Logger.getLogger(MysqlUnidadMedidaDAO.class);
    @Override
    public List<UnidadMedida> listarUnidadMedida(String codigoUM, String nombre) {
        Connection cnn = null;
        List<UnidadMedida> listaUM = new ArrayList<>();
        UnidadMedida objUM = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarUnidadMedida" + PrepararSQL.get(2);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, codigoUM);
            ps.setString(2, nombre);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objUM = new UnidadMedida();
                
                objUM.setInt_idUnidadMedida(rs.getInt(1));
                objUM.setStr_codigoUM(rs.getString(2));
                objUM.setStr_nombreUM(rs.getString(3));
                objUM.setStr_descripcionUM(rs.getString(4));
                objUM.setStr_estado(rs.getString(5));

                listaUM.add(objUM);
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
        
        return listaUM;
    }

    @Override
    public boolean registrarUM(UnidadMedida objUM) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_insertUnidadMedida" + PrepararSQL.get(4);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, objUM.getStr_nombreUM());
            ps.setString(2, objUM.getStr_descripcionUM());
            ps.setString(3, objUM.getStr_usuarioCreador());
            ps.setString(4, objUM.getStr_estado());

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
    public boolean modificarUM(UnidadMedida objUM) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_updateUnidadMedida" + PrepararSQL.get(4);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, objUM.getInt_idUnidadMedida());
            ps.setString(2, objUM.getStr_nombreUM());
            ps.setString(3, objUM.getStr_descripcionUM());
            ps.setString(4, objUM.getStr_usuarioModificador());

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
    public String verificarNombre(String nombre) {
        Connection cnn = null;
        String respuesta = "";

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            
            String sql = "CALL sp_verificarNombreUM" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                respuesta = rs.getString(1);
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
        
        return respuesta;
    }
    
}
