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

import com.gestionmatriz.almacen.bean.Almacen;
import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.bean.TipoMovimiento;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;

/**
 *
 * @author zholo
 */
public class MysqlAlmacenDAO extends ConexionSqlSpring implements AlmacenDAO {

	private static final Logger log=Logger.getLogger(MysqlAlmacenDAO.class);  
    @Override
    public boolean registrarAlmacen(List<Almacen> listaAlmacen) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql;
        PreparedStatement ps;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?
                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            sql = "CALL sp_insertAlmacen" + PrepararSQL.get(13);
            ps = cnn.prepareStatement(sql);
            for (Almacen objAlmacen : listaAlmacen) {
                ps.setInt(1, objAlmacen.getObjProveedor().getInt_idProveedor());
                ps.setInt(2, objAlmacen.getObjProducto().getInt_idProducto());
                ps.setInt(3, objAlmacen.getObjLocal().getInt_idLocal());
                ps.setInt(4, objAlmacen.getObjTipoMovimiento().getInt_idTipoMovimiento());
                ps.setString(5, objAlmacen.getStr_documento());
                ps.setBigDecimal(6, objAlmacen.getDbl_cantidad());
                ps.setBigDecimal(7, objAlmacen.getDbl_precio());
                ps.setBigDecimal(8, objAlmacen.getDbl_igv());
                ps.setBigDecimal(9, objAlmacen.getDbl_subTotal());
                ps.setBigDecimal(10, objAlmacen.getDbl_descuento());
                ps.setString(11, objAlmacen.getStr_fechaDocumento());
                ps.setString(12, objAlmacen.getStr_estado());
                ps.setString(13, objAlmacen.getStr_usuarioCreador());
                ps.execute();
            }

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
    public List<Almacen> listaProductosAlmacen(int idlocal) {
        Connection cnn = null;
        List<Almacen> listaAlmacen = new ArrayList<>();
        Almacen objAlmacen = null;
        Producto objProducto;
        Proveedor objProveedor;
        TipoMovimiento objTipoMovimiento;
        Local objLocal;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarProductosAlmacen" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, idlocal);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objAlmacen = new Almacen();
                objProducto = new Producto();
                objProveedor = new Proveedor();
                objTipoMovimiento = new TipoMovimiento();
                objLocal = new Local();

                objAlmacen.setInt_idAlmacen(rs.getInt(1));
                objProveedor.setInt_idProveedor(rs.getInt(2));
                objProducto.setInt_idProducto(rs.getInt(3));
                objLocal.setInt_idLocal(rs.getInt(4));
                objTipoMovimiento.setInt_idTipoMovimiento(rs.getInt(5));
                objAlmacen.setStr_documento(rs.getString(6));
                objAlmacen.setDbl_cantidad(rs.getBigDecimal(7));
                objAlmacen.setDbl_precio(rs.getBigDecimal(8));
                objAlmacen.setDbl_igv(rs.getBigDecimal(9));
                objAlmacen.setDbl_subTotal(rs.getBigDecimal(10));
                objAlmacen.setStr_fechaCreacion(rs.getString(11));
                objAlmacen.setStr_estado(rs.getString(12));
                objAlmacen.setStr_usuarioCreador(rs.getString(13));
                objAlmacen.setStr_fechaCreacion(rs.getString(14));
                objAlmacen.setStr_usuarioModificador(rs.getString(15));
                objAlmacen.setStr_fechaModificacion(rs.getString(16));

                objAlmacen.setObjLocal(objLocal);
                objAlmacen.setObjProducto(objProducto);
                objAlmacen.setObjProveedor(objProveedor);
                objAlmacen.setObjTipoMovimiento(objTipoMovimiento);

                listaAlmacen.add(objAlmacen);
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

        return listaAlmacen;
    }

    @Override
    public boolean registrarAlmacenTraspaso(Almacen objAlmacen) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "CALL sp_insertAlmacenTraspaso" + PrepararSQL.get(13);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, objAlmacen.getObjProveedor().getInt_idProveedor());
            ps.setInt(2, objAlmacen.getObjProducto().getInt_idProducto());
            ps.setInt(3, objAlmacen.getObjLocal().getInt_idLocal());
            ps.setInt(4, objAlmacen.getObjTipoMovimiento().getInt_idTipoMovimiento());
            ps.setString(5, objAlmacen.getStr_documento());
            ps.setBigDecimal(6, objAlmacen.getDbl_cantidad());
            ps.setBigDecimal(7, objAlmacen.getDbl_precio());
            ps.setBigDecimal(8, objAlmacen.getDbl_igv());
            ps.setBigDecimal(9, objAlmacen.getDbl_subTotal());
            ps.setBigDecimal(10, objAlmacen.getDbl_descuento());
            ps.setString(11, objAlmacen.getStr_fechaDocumento());
            ps.setString(12, objAlmacen.getStr_estado());
            ps.setString(13, objAlmacen.getStr_usuarioCreador());
//            ps.setBigDecimal(7, objDetalleGuiaRemision.getStr_usuarioCreador());
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
