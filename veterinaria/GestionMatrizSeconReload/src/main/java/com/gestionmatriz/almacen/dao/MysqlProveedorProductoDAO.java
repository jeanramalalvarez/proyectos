/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

import com.gestionmatriz.almacen.bean.Familia;
import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.ProveedorProducto;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;
import com.gestionmatriz.util.Util;

/**
 *
 * @author jarcon
 */
public class MysqlProveedorProductoDAO extends ConexionSqlSpring implements ProveedorProductoDAO {

    /*private Principal gui;*/
    private static final Logger log=Logger.getLogger(MysqlProveedorProductoDAO.class);

    @Override
    public boolean registrarProveedorProducto(List<ProveedorProducto> listaProveedorProducto, String usuarioCreador) {
        boolean respuesta = false;
        Connection cnn = null;
        List<ProveedorProducto> listaProvProd = new ArrayList<>();

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "CALL sp_insertProveedorProducto".concat(PrepararSQL.get(4));
            PreparedStatement ps = cnn.prepareStatement(sql);

            for (ProveedorProducto proveedorProducto : listaProveedorProducto) {
                listaProvProd = listarProveeProd("" + proveedorProducto.getObjProveedor().
                        getInt_idProveedor(), "" + proveedorProducto.getObjProducto().
                        getInt_idProducto(), Util.INACTIVO);
//                System.out.println("arreglo----:"+listaProvProd);
                if (listaProvProd.isEmpty() == true) {
                    ps.setInt(1, proveedorProducto.getObjProveedor().getInt_idProveedor());
                    ps.setInt(2, proveedorProducto.getObjProducto().getInt_idProducto());
                    ps.setString(3, usuarioCreador);
                    ps.setString(4, Util.ACTIVO);
//                    System.out.println("dentro del registra");
                    ps.execute();
                    
                    cnn.commit();
                    respuesta = true;
                } else {
                    modificarProveedorProducto(proveedorProducto.getObjProveedor().getInt_idProveedor(),
                            proveedorProducto.getObjProducto().getInt_idProducto(), usuarioCreador, Util.ACTIVO);
//                    System.out.println("dentro del modificar");
                    respuesta = true;
                }
            }
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
    public List<ProveedorProducto> listarProveeProd(String idPrveedor, String producto, String estado) {
        Connection cnn = null;
//        List<Horarios> listaHorarios = new ArrayList<Horarios>();
        List<ProveedorProducto> listaProveedorProducto = new ArrayList<>();
        ProveedorProducto objProveeProd = null;
        com.gestionmatriz.almacen.bean.Producto objProducto = null;
        com.gestionmatriz.almacen.bean.Familia objFamilia = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_selectProveedorProducto" + PrepararSQL.get(4);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, idPrveedor);
//            System.out.println("mysql---"+ruc);
            ps.setString(2, producto);
            ps.setString(3, estado);
            ps.setString(4, "");
//            System.out.println("mysql---"+razonSocial);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objProveeProd = new ProveedorProducto();
                objProducto = new Producto();
                objFamilia = new Familia();
//                System.out.println("mysql---"+rs.getInt(1));
                objProveeProd.setInt_idProveedor(rs.getInt(1));
                objProveeProd.setInt_idProducto(rs.getInt(2));
                objProducto.setStr_codigoInterno(rs.getString(9));
                objProducto.setStr_nombreProducto(rs.getString(8));
                objFamilia.setStr_nombre(rs.getString(14));
                objProveeProd.setObjProducto(objProducto);
                objProveeProd.getObjProducto().setObjFamilia(objFamilia);

                listaProveedorProducto.add(objProveeProd);
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
        return listaProveedorProducto;
    }

    @Override
    public boolean modificarProveedorProducto(int idProveedor, int idProducto, String userModifica, String estado) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "CALL sp_updateProveedorProducto".concat(PrepararSQL.get(4));
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, idProveedor);
            ps.setInt(2, idProducto);
            ps.setString(3, userModifica);
            ps.setString(4, estado);
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
}
