/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.Proveedor;
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
 * @author jarcon
 */
public class MysqlProveedorDAO extends ConexionSqlSpring implements ProveedorDAO {

	private static final Logger log=Logger.getLogger(MysqlProveedorDAO.class);
    @Override
    public boolean registrarProveedor(Proveedor objProveedor) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "CALL sp_insertProveedor" + PrepararSQL.get(12);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, objProveedor.getStr_razonSocial());
            ps.setString(2, objProveedor.getStr_nombreComercial());
            ps.setString(3, objProveedor.getStr_ruc());
            ps.setString(4, objProveedor.getStr_direccion());
            ps.setString(5, objProveedor.getStr_email());
            ps.setString(6, objProveedor.getStr_telefono());
            ps.setString(7, objProveedor.getStr_fax());
            ps.setString(8, objProveedor.getStr_representanteLegal());
            ps.setString(9, objProveedor.getStr_banco());
            ps.setString(10, objProveedor.getStr_ctaPrincipal());
            ps.setString(11, objProveedor.getStr_ctaAlternativa());
            ps.setString(12, objProveedor.getStr_usuarioCreador());
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
    public List<Proveedor> buscarProveedor(String ruc, String razonSocial) {
        Connection cnn = null;
//        List<Horarios> listaHorarios = new ArrayList<Horarios>();
        List<Proveedor> listaProveedores = new ArrayList<>();
        Proveedor objProveedor = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            
            String sql = "CALL sp_selectProveedor" + PrepararSQL.get(2);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, ruc);
//            System.out.println("mysql---"+ruc);
            ps.setString(2, razonSocial);
//            System.out.println("mysql---"+razonSocial);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objProveedor = new Proveedor();
//                System.out.println("mysql---"+rs.getInt(1));
                objProveedor.setInt_idProveedor(rs.getInt(1));
                objProveedor.setStr_razonSocial(rs.getString(2));
                objProveedor.setStr_nombreComercial(rs.getString(3));
                objProveedor.setStr_ruc(rs.getString(4));
                objProveedor.setStr_direccion(rs.getString(5));
                objProveedor.setStr_email(rs.getString(6));
                objProveedor.setStr_telefono(rs.getString(7));
                objProveedor.setStr_fax(rs.getString(8));
                objProveedor.setStr_representanteLegal(rs.getString(9));
                objProveedor.setStr_banco(rs.getString(10));
                objProveedor.setStr_ctaPrincipal(rs.getString(11));
                objProveedor.setStr_ctaAlternativa(rs.getString(12));
                objProveedor.setStr_estado(rs.getString(13));
                objProveedor.setStr_usuarioCreador(rs.getString(14));
                objProveedor.setDte_fechaCreación(rs.getString(15));

                listaProveedores.add(objProveedor);
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

        return listaProveedores;
    }

    @Override
    public boolean modificarProveedor(Proveedor objProveedor) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "CALL sp_updateProveedor" + PrepararSQL.get(13);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, objProveedor.getStr_razonSocial());
            ps.setString(2, objProveedor.getStr_nombreComercial());
            ps.setString(3, objProveedor.getStr_ruc());
            ps.setString(4, objProveedor.getStr_direccion());
            ps.setString(5, objProveedor.getStr_email());
            ps.setString(6, objProveedor.getStr_telefono());
            ps.setString(7, objProveedor.getStr_fax());
            ps.setString(8, objProveedor.getStr_representanteLegal());
            ps.setString(9, objProveedor.getStr_banco());
            ps.setString(10, objProveedor.getStr_ctaPrincipal());
            ps.setString(11, objProveedor.getStr_ctaAlternativa());
            ps.setString(12, objProveedor.getStr_usuarioCreador());
            ps.setInt(13, objProveedor.getInt_idProveedor());
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
