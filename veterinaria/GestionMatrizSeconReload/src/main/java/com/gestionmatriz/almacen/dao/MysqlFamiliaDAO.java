/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.Familia;
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
public class MysqlFamiliaDAO extends ConexionSqlSpring implements FamiliaDAO {

	private static final Logger log=Logger.getLogger(MysqlFamiliaDAO.class);  
    @Override
    public List<Familia> listarFamilia(String codigoFamilia, String nombre) {
        Connection cnn = null;
        List<Familia> listaFamilia = new ArrayList<>();
        Familia objFamilia = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarFamilia" + PrepararSQL.get(2);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, codigoFamilia);
            ps.setString(2, nombre);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objFamilia = new Familia();
                
                objFamilia.setInt_idFamilia(rs.getInt(1));
                objFamilia.setStr_codigoFamilia(rs.getString(2));
                objFamilia.setStr_nombre(rs.getString(3));
                objFamilia.setStr_descripcion(rs.getString(4));
                objFamilia.setStr_estado(rs.getString(5));

                listaFamilia.add(objFamilia);
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
        
        return listaFamilia;
    }

    @Override
    public boolean registrarFamilia(Familia objFamilia) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_insertFamilia" + PrepararSQL.get(4);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, objFamilia.getStr_nombre());
            ps.setString(2, objFamilia.getStr_descripcion());
            ps.setString(3, objFamilia.getStr_usuarioCreador());
            ps.setString(4, objFamilia.getStr_estado());

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
    public boolean modificarFamilia(Familia objFamilia) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_updateFamilia" + PrepararSQL.get(4);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, objFamilia.getInt_idFamilia());
            ps.setString(2, objFamilia.getStr_nombre());
            ps.setString(3, objFamilia.getStr_descripcion());
            ps.setString(4, objFamilia.getStr_usuarioModificador());

            respuesta = ps.execute();
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
            
            String sql = "CALL sp_verificarNombreFamilia" + PrepararSQL.get(1);
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
