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

import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.bean.ProveedorProductoUnidadMedida;
import com.gestionmatriz.almacen.bean.UnidadMedida;
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
public class MysqlProveedorProductoUnidadMedidaDAO extends ConexionSqlSpring implements ProveedorProductoUnidadMedidaDAO {

	 private static final Logger log=Logger.getLogger(MysqlProveedorProductoUnidadMedidaDAO.class);
    @Override
    public boolean registrarPPUM(ProveedorProductoUnidadMedida objPPUM) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        /*ProveedorProductoUnidadMedida objPPUMTemp = null;
        Proveedor objP = null;
        List<ProveedorProductoUnidadMedida> listaPPUM = new ArrayList<>();
        List<Proveedor> listaP = new ArrayList<>();*/
        
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            sql = "CALL sp_selectProveedorProducto".concat(PrepararSQL.get(4));
            ps = cnn.prepareStatement(sql);
            ps.setString(1, "%%");
            ps.setString(2, String.valueOf(objPPUM.getObjProducto().getInt_idProducto()));
            ps.setString(3, Util.ACTIVO);
            ps.setString(4, "");
            rs = ps.executeQuery();
            
            if (objPPUM.getDbl_precioOferta().compareTo(BigDecimal.ZERO)==0) {
                sql = "CALL sp_insertPPUM" + PrepararSQL.get(12);
                
                while (rs.next()) {
                    ps = cnn.prepareStatement(sql);
                    ps.setInt(1, rs.getInt(1));
                    ps.setInt(2, objPPUM.getObjProducto().getInt_idProducto());
                    ps.setInt(3, objPPUM.getObjUnidadMedidaVenta().getInt_idUnidadMedida());
                    ps.setString(4, objPPUM.getStr_UnidadMedidaCompra());
                    ps.setBigDecimal(5, objPPUM.getDbl_costoCompra());
                    ps.setBigDecimal(6, objPPUM.getDbl_unidadesContenidas());
                    ps.setBigDecimal(7, objPPUM.getDbl_precioUnidadContenida());
                    ps.setBigDecimal(8, objPPUM.getDbl_costoTraslado());
                    ps.setBigDecimal(9, objPPUM.getDbl_precioFinal());
                    ps.setBigDecimal(10, objPPUM.getDbl_precioOferta());
                    ps.setString(11, Util.ACTIVO);
                    ps.setString(12, objPPUM.getStr_usuarioCreador());
                    ps.execute();
                }
            } else if (objPPUM.getDbl_precioOferta().compareTo(BigDecimal.ZERO) != 0) {
                sql = "CALL sp_updatePPUMOferta" + PrepararSQL.get(4);
                
                while (rs.next()) {
                    ps = cnn.prepareStatement(sql);
                    ps.setInt(1, rs.getInt(1));
                    ps.setInt(2, objPPUM.getObjProducto().getInt_idProducto());
                    ps.setBigDecimal(3, objPPUM.getDbl_precioOferta());
                    ps.setString(4, objPPUM.getStr_usuarioModificador());
                    ps.execute();
                }
            }
            
            
            
//            sql = "CALL sp_buscarProveedoresParaPrecio".concat(PrepararSQL.get(2));
//            ps = cnn.prepareStatement(sql);
//            ps.setInt(1, objPPUM.getObjProducto().getInt_idProducto());
//            ps.setString(2, Util.ACTIVO);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                objP = new Proveedor();
//                objP.setInt_idProveedor(rs.getInt(1));
//                listaP.add(objP);
//            }
//            
//            for (Proveedor proveedor : listaP) {
//                sql = "CALL sp_selectProveedorProducto" + PrepararSQL.get(4);
//                ps = cnn.prepareStatement(sql);
//                ps.setString(1, String.valueOf(proveedor.getInt_idProveedor()));
//                ps.setString(2, String.valueOf(objPPUM.getObjProducto().getInt_idProducto()));
//                ps.setString(3, Util.ACTIVO);
//                ps.setString(4, "");
//                rs = ps.executeQuery();
//
//                while (rs.next()) {
//                    objPPUMTemp = new ProveedorProductoUnidadMedida();
//                    objPPUMTemp.setObjProveedor(proveedor);
//                    objPPUMTemp.setObjProducto(objPPUM.getObjProducto());
//                    objPPUMTemp.setObjUnidadMedidaVenta(objPPUM.getObjUnidadMedidaVenta());
//                    objPPUMTemp.setStr_UnidadMedidaCompra(objPPUM.getStr_UnidadMedidaCompra()); //deberia ser diferente
//                    objPPUMTemp.setDbl_costoCompra(objPPUM.getDbl_costoCompra()); //deberia ser diferente
//                    objPPUMTemp.setDbl_unidadesContenidas(objPPUM.getDbl_unidadesContenidas()); //deberia ser diferente
//                    objPPUMTemp.setDbl_precioUnidadContenida(objPPUM.getDbl_precioUnidadContenida()); //deberia ser diferente
//                    objPPUMTemp.setDbl_costoTraslado(objPPUM.getDbl_costoTraslado()); //deberia ser diferente
//                    objPPUMTemp.setDbl_precioFinal(objPPUM.getDbl_precioFinal()); //deberia ser diferente
//                    listaPPUM.add(objPPUMTemp);
//                }
//            }
//            
//            sql = "CALL sp_insertPPUM" + PrepararSQL.get(11);
//            for (ProveedorProductoUnidadMedida objPPUMFinal : listaPPUM) {
//                ps = cnn.prepareStatement(sql);
//                ps.setInt(1, objPPUMFinal.getObjProveedor().getInt_idProveedor());
//                ps.setInt(2, objPPUMFinal.getObjProducto().getInt_idProducto());
//                ps.setInt(3, objPPUMFinal.getObjUnidadMedidaVenta().getInt_idUnidadMedida());
//                ps.setString(4, objPPUMFinal.getStr_UnidadMedidaCompra());
//                ps.setBigDecimal(5, objPPUMFinal.getDbl_costoCompra());
//                ps.setBigDecimal(6, objPPUMFinal.getDbl_unidadesContenidas());
//                ps.setBigDecimal(7, objPPUMFinal.getDbl_precioUnidadContenida());
//                ps.setBigDecimal(8, objPPUMFinal.getDbl_costoTraslado());
//                ps.setBigDecimal(9, objPPUMFinal.getDbl_precioFinal());
//                ps.setString(10, Util.ACTIVO);
//                ps.setString(11, objPPUMFinal.getStr_usuarioCreador());
//                ps.execute();
//            }
            
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
    public List<ProveedorProductoUnidadMedida> listarPPUM() {
        Connection cnn = null;
        String sql = "";
        ResultSet rs;
        List<ProveedorProductoUnidadMedida> listaPPUM = new ArrayList<>();
        ProveedorProductoUnidadMedida objPPUM = null;
        Proveedor objProveedor = null;
        Producto objProducto = null;
        UnidadMedida objUnidadMedidaVenta = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            sql = "CALL sp_listarPPUM" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, Util.ACTIVO);
            rs = ps.executeQuery();

            while (rs.next()) {
                objPPUM = new ProveedorProductoUnidadMedida();
                objProveedor = new Proveedor();
                objProducto = new Producto();
                objUnidadMedidaVenta = new UnidadMedida();

                objProveedor.setInt_idProveedor(rs.getInt(1));
                objProveedor.setStr_razonSocial(rs.getString(12));
                objProveedor.setStr_nombreComercial(rs.getString(13));
                objProveedor.setStr_ruc(rs.getString(14));
                objProveedor.setStr_direccion(rs.getString(15));
                objProveedor.setStr_email(rs.getString(16));
                objProveedor.setStr_telefono(rs.getString(17));
                objProveedor.setStr_fax(rs.getString(18));
                objProveedor.setStr_representanteLegal(rs.getString(19));
                objProveedor.setStr_banco(rs.getString(20));
                objProveedor.setStr_ctaPrincipal(rs.getString(21));
                objProveedor.setStr_ctaAlternativa(rs.getString(22));
                objProveedor.setStr_estado(rs.getString(23));
                objPPUM.setObjProveedor(objProveedor);

                objProducto.setInt_idProducto(rs.getInt(2));
                objProducto.setStr_nombreProducto(rs.getString(25));
                objProducto.setStr_codigoInterno(rs.getString(26));
                objProducto.setStr_descripcion(rs.getString(27));
                objProducto.setStr_fabricante(rs.getString(28));
                objProducto.setStr_reintegroTributario(rs.getString(29));
                objProducto.setStr_estado(rs.getString(30));
                objPPUM.setObjProducto(objProducto);

                objUnidadMedidaVenta.setInt_idUnidadMedida(rs.getInt(3));
                objUnidadMedidaVenta.setStr_codigoUM(rs.getString(31));
                objUnidadMedidaVenta.setStr_nombreUM(rs.getString(32));
                objUnidadMedidaVenta.setStr_descripcionUM(rs.getString(33));
                objUnidadMedidaVenta.setStr_estado(rs.getString(34));
                objPPUM.setObjUnidadMedidaVenta(objUnidadMedidaVenta);

                objPPUM.setStr_UnidadMedidaCompra(rs.getString(4));
                objPPUM.setDbl_costoCompra(rs.getBigDecimal(5));
                objPPUM.setDbl_unidadesContenidas(rs.getBigDecimal(6));
                objPPUM.setDbl_precioUnidadContenida(rs.getBigDecimal(7));
                objPPUM.setDbl_costoTraslado(rs.getBigDecimal(8));
                objPPUM.setDbl_precioFinal(rs.getBigDecimal(9));
                objPPUM.setDbl_precioOferta(rs.getBigDecimal(35));
                objPPUM.setStr_estado(rs.getString(10));

                listaPPUM.add(objPPUM);
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

        return listaPPUM;
    }

    @Override
    public boolean verificarProducto(ProveedorProductoUnidadMedida objPPUM) {
        Connection cnn = null;
        boolean respuesta = false;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_verificarPPUM" + PrepararSQL.get(4);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, objPPUM.getObjProveedor().getInt_idProveedor());
            ps.setInt(2, objPPUM.getObjProducto().getInt_idProducto());
            ps.setInt(3, objPPUM.getObjUnidadMedidaVenta().getInt_idUnidadMedida());
            ps.setString(4, objPPUM.getStr_UnidadMedidaCompra());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                respuesta = true;
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
    public boolean modificarPPUM(ProveedorProductoUnidadMedida objPPUM) {
        boolean respuesta = false;
        Connection cnn = null;
        PreparedStatement ps = null;
        String sql = "";
        ResultSet rs = null;
        
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            sql = "CALL sp_selectProveedorProducto".concat(PrepararSQL.get(4));
            ps = cnn.prepareStatement(sql);
            ps.setString(1, "%%");
            ps.setString(2, String.valueOf(objPPUM.getObjProducto().getInt_idProducto()));
            ps.setString(3, Util.ACTIVO);
            ps.setString(4, "");
            rs = ps.executeQuery();
            
            sql = "CALL sp_updatePPUM" + PrepararSQL.get(11);
            while (rs.next()) {
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, rs.getInt(1));
                ps.setInt(2, objPPUM.getObjProducto().getInt_idProducto());
                ps.setInt(3, objPPUM.getObjUnidadMedidaVenta().getInt_idUnidadMedida());
                ps.setString(4, objPPUM.getStr_UnidadMedidaCompra());
                ps.setBigDecimal(5, objPPUM.getDbl_costoCompra());
                ps.setBigDecimal(6, objPPUM.getDbl_unidadesContenidas());
                ps.setBigDecimal(7, objPPUM.getDbl_precioUnidadContenida());
                ps.setBigDecimal(8, objPPUM.getDbl_costoTraslado());
                ps.setBigDecimal(9, objPPUM.getDbl_precioFinal());
                ps.setBigDecimal(10, objPPUM.getDbl_precioOferta());
                ps.setString(11, objPPUM.getStr_usuarioCreador());
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
    public boolean quitarOferta(ProveedorProductoUnidadMedida objPPUM) {
        boolean respuesta = false;
        Connection cnn = null;
        PreparedStatement ps = null;
        String sql = "";
        ResultSet rs = null;
        
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            sql = "CALL sp_selectProveedorProducto".concat(PrepararSQL.get(4));
            ps = cnn.prepareStatement(sql);
            ps.setString(1, "%%");
            ps.setString(2, String.valueOf(objPPUM.getObjProducto().getInt_idProducto()));
            ps.setString(3, Util.ACTIVO);
            ps.setString(4, "");
            rs = ps.executeQuery();
            
            sql = "CALL sp_updatePPUMOferta" + PrepararSQL.get(4);
            while (rs.next()) {
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, rs.getInt(1));
                ps.setInt(2, objPPUM.getObjProducto().getInt_idProducto());
                ps.setBigDecimal(3, objPPUM.getDbl_precioOferta());
                ps.setString(4, objPPUM.getStr_usuarioModificador());
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
