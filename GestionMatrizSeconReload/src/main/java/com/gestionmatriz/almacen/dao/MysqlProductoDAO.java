/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.Familia;
import com.gestionmatriz.almacen.bean.MedidaRotacion;
import com.gestionmatriz.almacen.bean.Producto;
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
public class MysqlProductoDAO extends ConexionSqlSpring implements ProductoDAO {

	private static final Logger log=Logger.getLogger(MysqlProductoDAO.class);
    @Override
    public List<Producto> buscarProducto(String codigoInterno, String nombre, String familia, String reintegro, String rotacion) {
        Connection cnn = null;
        List<Producto> listaProductos = new ArrayList<>();
        Producto objProducto;
        Familia objFamilia;
        UnidadMedida objUnidadMedida;
        MedidaRotacion objMedidaRotacion;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_listarProducto".concat(PrepararSQL.get(5));
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, codigoInterno);
            ps.setString(2, nombre);
            ps.setString(3, familia);
            ps.setString(4, reintegro);
            ps.setString(5, rotacion);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objProducto = new Producto();
                objFamilia = new Familia();
                objUnidadMedida = new UnidadMedida();
                objMedidaRotacion = new MedidaRotacion();

                objProducto.setInt_idProducto(rs.getInt(1));
                objProducto.setStr_nombreProducto(rs.getString(2));
                objProducto.setStr_codigoInterno(rs.getString(3));
                objProducto.setStr_descripcion(rs.getString(4));
                objProducto.setStr_fabricante(rs.getString(5));
                objProducto.setStr_reintegroTributario(rs.getString(6));

                objFamilia.setInt_idFamilia(rs.getInt(11));
                objFamilia.setStr_nombre(rs.getString(12));
                objProducto.setObjFamilia(objFamilia);

                objUnidadMedida.setInt_idUnidadMedida(rs.getInt(13));
                objUnidadMedida.setStr_nombreUM(rs.getString(14));
                objProducto.setObjUnidadMedida(objUnidadMedida);

                objMedidaRotacion.setInt_idMedidaRotacion(rs.getInt(15));
                objMedidaRotacion.setStr_nombreMR(rs.getString(16));
                objProducto.setObjMedidaRotacion(objMedidaRotacion);

                listaProductos.add(objProducto);
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

        return listaProductos;
    }

    @Override
    public boolean registrarProducto(Producto objProducto) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql;
        PreparedStatement ps = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            if (!objProducto.getStr_codigoInterno().equals("")) {
                sql = "CALL sp_insertProductoCodigo".concat(PrepararSQL.get(10));
                ps = cnn.prepareStatement(sql);
                ps.setString(1, objProducto.getStr_codigoInterno());
                ps.setString(2, objProducto.getStr_nombreProducto());
                ps.setString(3, objProducto.getStr_descripcion());
                ps.setString(4, objProducto.getStr_fabricante());
                ps.setString(5, objProducto.getStr_reintegroTributario());
                ps.setInt(6, objProducto.getObjFamilia().getInt_idFamilia());
                ps.setInt(7, objProducto.getObjUnidadMedida().getInt_idUnidadMedida());
                ps.setInt(8, objProducto.getObjMedidaRotacion().getInt_idMedidaRotacion());
                ps.setString(9, objProducto.getStr_usuarioCreador());
                ps.setString(10, objProducto.getStr_estado());
            } else {
                sql = "CALL sp_insertProducto".concat(PrepararSQL.get(9));
                ps = cnn.prepareStatement(sql);
                ps.setString(1, objProducto.getStr_nombreProducto());
                ps.setString(2, objProducto.getStr_descripcion());
                ps.setString(3, objProducto.getStr_fabricante());
                ps.setString(4, objProducto.getStr_reintegroTributario());
                ps.setInt(5, objProducto.getObjFamilia().getInt_idFamilia());
                ps.setInt(6, objProducto.getObjUnidadMedida().getInt_idUnidadMedida());
                ps.setInt(7, objProducto.getObjMedidaRotacion().getInt_idMedidaRotacion());
                ps.setString(8, objProducto.getStr_usuarioCreador());
                ps.setString(9, objProducto.getStr_estado());
            }
            
            ps.execute();
            cnn.commit();
            respuesta = true;
        } catch (SQLException ex) {
            try {
                log.error("Error SQL: " + ex.getMessage());
                cnn.rollback();
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            try {
                log.error("Error: " + ex.getMessage());
                cnn.rollback();
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } finally {
            try {

                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                try {
                    cnn.rollback();
                    log.error("Error al intentar Cerrar la BD: " + ex.getMessage());
                } catch (SQLException ex1) {
                    log.error("Error en el RollBack " + ex1.getMessage());
                }
            }
        }
        return respuesta;
    }

    @Override
    public boolean modificarProducto(Producto objProducto) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "CALL sp_updateProducto".concat(PrepararSQL.get(9));
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, objProducto.getInt_idProducto());
            ps.setString(2, objProducto.getStr_codigoInterno());
            ps.setString(3, objProducto.getStr_nombreProducto());
            ps.setString(4, objProducto.getStr_descripcion());
            ps.setString(5, objProducto.getStr_fabricante());
            ps.setInt(6, objProducto.getObjFamilia().getInt_idFamilia());
            ps.setInt(7, objProducto.getObjUnidadMedida().getInt_idUnidadMedida());
            ps.setInt(8, objProducto.getObjMedidaRotacion().getInt_idMedidaRotacion());
            ps.setString(9, objProducto.getStr_usuarioModificador());
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

            String sql = "CALL sp_verificarNombreProducto" + PrepararSQL.get(1);
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

    @Override
    public Producto buscarProductoXId(int idProducto) {
        Connection cnn = null;
        Producto objProducto = null;
        Familia objFamilia;
        UnidadMedida objUnidadMedida;
        MedidaRotacion objMedidaRotacion;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_listarProductoXId" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objProducto = new Producto();
                objFamilia = new Familia();
                objUnidadMedida = new UnidadMedida();
                objMedidaRotacion = new MedidaRotacion();

                objProducto.setInt_idProducto(rs.getInt(1));
                objProducto.setStr_nombreProducto(rs.getString(2));
                objProducto.setStr_codigoInterno(rs.getString(3));
                objProducto.setStr_descripcion(rs.getString(4));
                objProducto.setStr_fabricante(rs.getString(5));
                objProducto.setStr_reintegroTributario(rs.getString(6));

                objFamilia.setInt_idFamilia(rs.getInt(11));
                objFamilia.setStr_nombre(rs.getString(12));
                objProducto.setObjFamilia(objFamilia);

                objUnidadMedida.setInt_idUnidadMedida(rs.getInt(13));
                objUnidadMedida.setStr_nombreUM(rs.getString(14));
                objProducto.setObjUnidadMedida(objUnidadMedida);

                objMedidaRotacion.setInt_idMedidaRotacion(rs.getInt(15));
                objMedidaRotacion.setStr_nombreMR(rs.getString(16));
                objProducto.setObjMedidaRotacion(objMedidaRotacion);
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
        return objProducto;
    }

    @Override
    public String verificarCodigo(String codigo) {
        Connection cnn = null;
        String respuesta = "";

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_verificarCodigoProducto".concat(PrepararSQL.get(1));
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, codigo);
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
