/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

import com.gestionmatriz.puntoventa.bean.Cliente;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;
import com.gestionmatriz.util.Util;

/**
 *
 * @author cesareo
 */
public class MysqlClienteDAO extends ConexionSqlSpring implements ClienteDAO {

	private static final Logger log=Logger.getLogger(MysqlClienteDAO.class);
    @Override
    public boolean registrarCliente(Cliente objCliente) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;
        
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            sql = "CALL sp_insertCliente" + PrepararSQL.get(6);
            ps = cnn.prepareStatement(sql);
            ps.setString(1, objCliente.getStr_razonSocial());
            ps.setString(2, objCliente.getStr_rucdni());
            ps.setString(3, objCliente.getStr_direccion());
            ps.setString(4, objCliente.getStr_telefono());
            ps.setString(5, Util.ACTIVO);
            ps.setString(6, objCliente.getStr_usuarioCreador());
            ps.execute();

            cnn.commit();
            respuesta = true;
        } catch (SQLException ex) {
            try {
                cnn.rollback();
                log.error("Error SQL: " + ex.getMessage());
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error -: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            try {
                cnn.rollback();
                log.error("Error --: " + ex.getMessage());
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error ---: " + ex1.getMessage());
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
    public List<Cliente> listarCliente(String razonSocial, String rucdni, String direccion, String telefono) {
        Connection cnn = null;
        List<Cliente> listaCliente = new ArrayList<>();
        Cliente objCliente = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarCliente" + PrepararSQL.get(5);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, razonSocial);
            ps.setString(2, rucdni);
            ps.setString(3, direccion);
            ps.setString(4, telefono);
            ps.setString(5, Util.ACTIVO);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objCliente = new Cliente();
                
                objCliente.setInt_idCliente(rs.getInt(1));
                objCliente.setStr_razonSocial(rs.getString(2));
                objCliente.setStr_rucdni(rs.getString(3));
                objCliente.setStr_direccion(rs.getString(4));
                objCliente.setStr_telefono(rs.getString(5));
                objCliente.setStr_estado(rs.getString(6));
                
                listaCliente.add(objCliente);
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
        
        return listaCliente;
    }

    @Override
    public boolean modificarCliente(Cliente objCliente) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_updateCliente" + PrepararSQL.get(6);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, objCliente.getInt_idCliente());
            ps.setString(2, objCliente.getStr_razonSocial());
            ps.setString(3, objCliente.getStr_rucdni());
            ps.setString(4, objCliente.getStr_direccion());
            ps.setString(5, objCliente.getStr_telefono());
            ps.setString(6, objCliente.getStr_usuarioModificador());
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
    public boolean inactivarCliente(Cliente objCliente) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_updateClienteInactivar" + PrepararSQL.get(3);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, objCliente.getInt_idCliente());
            ps.setString(2, Util.INACTIVO);
            ps.setString(3, objCliente.getStr_usuarioModificador());
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
