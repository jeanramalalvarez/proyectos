/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.OrdenCompra;
import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompra;
import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompraFacturaCompra;
import com.gestionmatriz.almacen.bean.TipoMovimiento;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;
import com.gestionmatriz.util.Util;

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
public class MysqlRecepcionMercaderiaDAO extends ConexionSqlSpring implements RecepcionMercaderiaDAO {
    
	private static final Logger log=Logger.getLogger(MysqlRecepcionMercaderiaDAO.class);
    private boolean verificarNF(String numeroFactura, String objNumeroFactura) {
        String[] arrNF = numeroFactura.split(";");
        for (int i = 0; i < arrNF.length; i++) {
            if (arrNF[i].equals(objNumeroFactura)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean registrarRecepcionMercaderia(List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC, OrdenCompra objOC) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql;
        PreparedStatement ps;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String NF = listaPPOCFC.get(0).getStr_numeroFactura();
            String numeroFactura = NF;
            for (ProveedorProductoOrdenCompraFacturaCompra objPPOCFC : listaPPOCFC) {
                /*if (listaPPOCFC.size() == 1) {
                    numeroFactura = NF;
                } else */if ((!NF.equals(objPPOCFC.getStr_numeroFactura()))
                        && (!objPPOCFC.getStr_numeroFactura().equals(""))
                        && (!verificarNF(numeroFactura, objPPOCFC.getStr_numeroFactura()))) {
                    numeroFactura += (";" + objPPOCFC.getStr_numeroFactura());
                }
            }

            sql = "CALL sp_updateFacturaCompraNumero" + PrepararSQL.get(3);
            ps = cnn.prepareStatement(sql);
            ps.setString(1, numeroFactura);
            ps.setInt(2, objOC.getInt_idOrdenCompra());
            ps.setString(3, objOC.getStr_usuarioModificador());
            ResultSet rs = ps.executeQuery();
            int idFacturaCompra = -1;

            while (rs.next()) {
                idFacturaCompra = rs.getInt(1);
            }

            if (idFacturaCompra == -1) {
                respuesta = false;
                throw new SQLException();
            }

            sql = "CALL sp_updatePPOCFC" + PrepararSQL.get(10);
            ps = cnn.prepareStatement(sql);
            for (ProveedorProductoOrdenCompraFacturaCompra objPPOCFC : listaPPOCFC) {
                ps.setInt(1, objPPOCFC.getObjProveedorProductoOrdenCompra().getObjProveedor().getInt_idProveedor());
                ps.setInt(2, objPPOCFC.getObjProveedorProductoOrdenCompra().getObjProducto().getInt_idProducto());
                ps.setInt(3, objPPOCFC.getObjProveedorProductoOrdenCompra().getInt_idOrdenCompra());
                ps.setInt(4, idFacturaCompra);
                ps.setBigDecimal(5, objPPOCFC.getDbl_cantidadRecibida());
                ps.setString(6, objPPOCFC.getStr_numeroFactura());
                ps.setInt(7, objPPOCFC.getInt_idLocalRecibido());
                ps.setString(8, objPPOCFC.getStr_fechaDocumento());
                ps.setString(9, objPPOCFC.getStr_estado());
                ps.setString(10, objPPOCFC.getStr_usuarioModificador());
                ps.execute();
            }

            sql = "CALL sp_updateOC" + PrepararSQL.get(3);
            ps = cnn.prepareStatement(sql);
            int estadoOC = 0;
            for (ProveedorProductoOrdenCompraFacturaCompra objPPOCFC : listaPPOCFC) {
                if ((objPPOCFC.getStr_estado().equals(Util.PENDIENTE))
                        || (objPPOCFC.getStr_estado().equals(Util.ACTIVO))) {
                    ps.setInt(1, objPPOCFC.getObjProveedorProductoOrdenCompra().getInt_idOrdenCompra());
                    ps.setString(2, Util.PENDIENTE);
                    ps.setString(3, objPPOCFC.getStr_usuarioModificador());
                    ps.execute();
                    estadoOC = 1;
                } else if ((objPPOCFC.getStr_estado().equals(Util.CERRADO)) && (estadoOC == 0)) {
                    ps.setInt(1, objPPOCFC.getObjProveedorProductoOrdenCompra().getInt_idOrdenCompra());
                    ps.setString(2, Util.CERRADO);
                    ps.setString(3, objPPOCFC.getStr_usuarioModificador());
                    ps.execute();
                }
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
    public List<ProveedorProductoOrdenCompraFacturaCompra> listarPPOCFC(int idOrdenCompra) {
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC = new ArrayList<>();
        ProveedorProductoOrdenCompra objProveedorProductoOrdenCompra = null;
        ProveedorProductoOrdenCompraFacturaCompra objProveedorProductoOrdenCompraFacturaCompra = null;
        Proveedor objProveedor = null;
        Producto objProducto = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarPPOCFCTodos".concat(PrepararSQL.get(1));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idOrdenCompra);
            rs = ps.executeQuery();

            while (rs.next()) {
                objProveedorProductoOrdenCompraFacturaCompra = new ProveedorProductoOrdenCompraFacturaCompra();
                objProveedorProductoOrdenCompra = new ProveedorProductoOrdenCompra();
                objProveedor = new Proveedor();
                objProducto = new Producto();

                objProveedor.setInt_idProveedor(rs.getInt(1));
                objProveedorProductoOrdenCompra.setObjProveedor(objProveedor);

                objProducto.setInt_idProducto(rs.getInt(2));
                objProducto.setStr_codigoInterno(rs.getString(9));
                objProducto.setStr_nombreProducto(rs.getString(10));
                objProducto.setStr_fabricante(rs.getString(11));
                objProducto.setStr_reintegroTributario(rs.getString(12));
                objProveedorProductoOrdenCompra.setObjProducto(objProducto);

                objProveedorProductoOrdenCompra.setInt_idOrdenCompra(rs.getInt(3));
                objProveedorProductoOrdenCompra.setDbl_cantidad(rs.getBigDecimal(4));
                objProveedorProductoOrdenCompra.setDbl_precio(rs.getBigDecimal(5));
                objProveedorProductoOrdenCompra.setDbl_descuento(rs.getBigDecimal(6));
                objProveedorProductoOrdenCompra.setDbl_peso(rs.getBigDecimal(7));
                objProveedorProductoOrdenCompra.setStr_estado(rs.getString(8));

                objProveedorProductoOrdenCompraFacturaCompra.setObjProveedorProductoOrdenCompra(objProveedorProductoOrdenCompra);
                objProveedorProductoOrdenCompraFacturaCompra.setInt_idFacturaCompra(rs.getInt(13));
                objProveedorProductoOrdenCompraFacturaCompra.setDbl_cantidadRecibida(rs.getBigDecimal(14));
                objProveedorProductoOrdenCompraFacturaCompra.setStr_numeroFactura(rs.getString(15));
                objProveedorProductoOrdenCompraFacturaCompra.setInt_idLocalRecibido(rs.getInt(16));
                objProveedorProductoOrdenCompraFacturaCompra.setStr_fechaDocumento(rs.getString(17));
                objProveedorProductoOrdenCompraFacturaCompra.setStr_estado(rs.getString(18));
                objProveedorProductoOrdenCompraFacturaCompra.setDbl_conformidadOK(rs.getBigDecimal(19));
                objProveedorProductoOrdenCompraFacturaCompra.setDbl_conformidadFallaProveedor(rs.getBigDecimal(20));
                objProveedorProductoOrdenCompraFacturaCompra.setDbl_conformidadFallaTransportista(rs.getBigDecimal(21));
                objProveedorProductoOrdenCompraFacturaCompra.setDbl_conformidadFallaOtro(rs.getBigDecimal(22));
                objProveedorProductoOrdenCompraFacturaCompra.setStr_conformidadObservacion(rs.getString(23));
                objProveedorProductoOrdenCompraFacturaCompra.setStr_conformidadEstado(rs.getString(24));

                listaPPOCFC.add(objProveedorProductoOrdenCompraFacturaCompra);
            }
        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error: " + ex.getMessage());
            }
        }

        return listaPPOCFC;
    }

    @Override
    public List<TipoMovimiento> listarTipoMovimiento() {
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TipoMovimiento> listaTipoMovimiento = new ArrayList<>();
        TipoMovimiento objTipoMovimiento = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarTipoMovimiento".concat(PrepararSQL.get(0));
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                objTipoMovimiento = new TipoMovimiento();

                objTipoMovimiento.setInt_idTipoMovimiento(rs.getInt(1));
                objTipoMovimiento.setStr_descripcion(rs.getString(2));

                listaTipoMovimiento.add(objTipoMovimiento);
            }
        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error: " + ex.getMessage());
            }
        }

        return listaTipoMovimiento;
    }
}
