/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

import com.gestionmatriz.almacen.bean.Kardex;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;

/**
 *
 * @author zholo
 */
public class MysqlKardexDAO extends ConexionSqlSpring implements KardexDAO{

	private static final Logger log=Logger.getLogger(MysqlKardexDAO.class);
    @Override
    public List<Kardex> listaKardex(String idProducto) {
        
        Connection cnn = null;
        List<Kardex> listaKardex = new ArrayList<>();
        Kardex objKardex = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarKardex" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, idProducto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objKardex = new Kardex();
                
                //objKardex.setInt_idKardex(rs.getInt(1));
                objKardex.setInt_idAlmacen(rs.getInt(1));
                objKardex.setInt_idProducto(rs.getInt(2));
                objKardex.setDbl_cantidad(rs.getBigDecimal(3));
                //objKardex.setDbl_stock(rs.getBigDecimal(5));

                listaKardex.add(objKardex);
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
        
        return listaKardex;
    }

    @Override
    public boolean registrarKardex(Kardex objKardex) {
       boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_insertKardex" + PrepararSQL.get(4);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, objKardex.getInt_idAlmacen());
            ps.setInt(2, objKardex.getInt_idProducto());
            ps.setBigDecimal(3, objKardex.getDbl_cantidad());
            ps.setBigDecimal(4, objKardex.getDbl_stock());

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
    public List<Kardex> listaKardexStock(String idProducto) {
        Connection cnn = null;
        List<Kardex> listaKardex = new ArrayList<>();
        Kardex objKardex = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarKardexStock" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, idProducto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objKardex = new Kardex();
                
                objKardex.setInt_idKardex(rs.getInt(1));
                objKardex.setInt_idAlmacen(rs.getInt(1));
                objKardex.setInt_idProducto(rs.getInt(2));
                objKardex.setDbl_cantidad(rs.getBigDecimal(3));
                objKardex.setDbl_stock(rs.getBigDecimal(5));

                listaKardex.add(objKardex);
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
        
        return listaKardex;
    }

    @Override
    public boolean updateKardex(int idKardex, BigDecimal stock) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_updateKardex" + PrepararSQL.get(2);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, idKardex);
            ps.setBigDecimal(2, stock);
            

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
    public List<Kardex> listaProductoAlmacen(String idProducto) {
        Connection cnn = null;
        List<Kardex> listaKardex = new ArrayList<>();
        Kardex objKardex = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarProductoAlmacen" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, idProducto);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objKardex = new Kardex();
                
                //objKardex.setInt_idKardex(rs.getInt(1));
                //objKardex.setInt_idAlmacen(rs.getInt(1));
                objKardex.setInt_idProducto(rs.getInt(1));
                //objKardex.setDbl_cantidad(rs.getBigDecimal(3));
                //objKardex.setDbl_stock(rs.getBigDecimal(5));

                listaKardex.add(objKardex);
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
        
        return listaKardex;
    }

    @Override
    public BigDecimal stock(int idAlmacen ) {
        Connection cnn = null;
        BigDecimal stock=BigDecimal.ZERO;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_stock" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, idAlmacen);
            ResultSet rs = ps.executeQuery();
            
                 
            while (rs.next()) {
               stock=rs.getBigDecimal(1); 
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
        
        return stock;
    }
    
}
