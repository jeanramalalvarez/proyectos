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

import com.gestionmatriz.almacen.bean.CronogramaPagos;
import com.gestionmatriz.almacen.bean.Familia;
import com.gestionmatriz.almacen.bean.MedidaRotacion;
import com.gestionmatriz.almacen.bean.OrdenCompra;
import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.ProductoHistorial;
import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompra;
import com.gestionmatriz.almacen.bean.TipoObligacion;
import com.gestionmatriz.almacen.bean.UnidadMedida;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;
import com.gestionmatriz.util.Util;

/**
 *
 * @author zholo
 */
public class MysqlOrdenCompraDAO extends ConexionSqlSpring implements OrdenCompraDAO {

	private static final Logger log=Logger.getLogger(MysqlOrdenCompraDAO.class);
    @Override
    public List<Empresa> listarEmpresa() {
        Connection cnn = null;
        List<Empresa> listaEmpresa = new ArrayList<>();
        Empresa objEmpresa = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listaEmpresa" + PrepararSQL.get(0);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objEmpresa = new Empresa();

                objEmpresa.setInt_idEmpresa(rs.getInt(1));
                objEmpresa.setStr_razonSocial(rs.getString(2));
                objEmpresa.setStr_ruc(rs.getString(3));
                objEmpresa.setStr_domicilioEmpresa(rs.getString(4));
                objEmpresa.setStr_representanteLegal(rs.getString(5));
                objEmpresa.setStr_dniRepresentante(rs.getString(6));
                objEmpresa.setStr_estado(rs.getString(7));
                objEmpresa.setDte_fechaCreacion(rs.getString(8));
                objEmpresa.setStr_usuarioCreador(rs.getString(9));
                objEmpresa.setDte_fechaModificacion(rs.getString(10));
                objEmpresa.setStr_usuarioModificador(rs.getString(11));

                listaEmpresa.add(objEmpresa);
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
        return listaEmpresa;
    }

    @Override
    public List<Local> buscarLocal(String idEmpresa) {
        Connection cnn = null;
        List<Local> listaLocal = new ArrayList<>();
        Local objLocal = null;
        Empresa objEmpresa = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_consultaLocal" + PrepararSQL.get(2);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, idEmpresa);
            ps.setString(2, Util.ACTIVO);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objLocal = new Local();
                objEmpresa = new Empresa();
                objLocal.setInt_idLocal(rs.getInt(1));
                objLocal.setStr_nombre(rs.getString(2));
                objLocal.setStr_direccion(rs.getString(3));
                objLocal.setStr_estado(rs.getString(4));
                objLocal.setStr_telefono(rs.getString(5));

                objEmpresa.setInt_idEmpresa(rs.getInt(6));
                objEmpresa.setStr_razonSocial(rs.getString(7));
                objEmpresa.setStr_ruc(rs.getString(8));
                objLocal.setObjEmpresa(objEmpresa);
                listaLocal.add(objLocal);
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
        
        return listaLocal;
    }

    @Override
    public boolean registrarOC(OrdenCompra objOC, List<ProveedorProductoOrdenCompra> listaProveedorProductoOrdenCompra,
            BigDecimal precioTotal, List<CronogramaPagos> listaCronogramaPagos) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;
        
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            sql = "CALL sp_insertOrdenCompra" + PrepararSQL.get(18);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objOC.getObjProveedor().getInt_idProveedor());
            ps.setString(2, objOC.getStr_numeroOC());
            ps.setInt(3, objOC.getObjTransportista().getInt_idProveedor());
            ps.setInt(4, objOC.getObjLocal().getInt_idLocal());
            ps.setString(5, objOC.getStr_viaTransporte());
            ps.setInt(6, objOC.getObjTipoObligacion().getInt_idTipoObligacion());
            ps.setBigDecimal(7, objOC.getDbl_precioBruto());
            ps.setBigDecimal(8, objOC.getDbl_precioTotal());
            ps.setBigDecimal(9, objOC.getDbl_descuentoTotal());
            ps.setBigDecimal(10, objOC.getDbl_valorVenta());
            ps.setBigDecimal(11, objOC.getDbl_igv());
            ps.setBigDecimal(12, objOC.getDbl_igvRecuperado());
            ps.setBigDecimal(13, objOC.getDbl_pesoTotal());
            ps.setString(14, objOC.getStr_fechaEntrega());
            ps.setString(15, objOC.getStr_fechaValidez());
            ps.setString(16, objOC.getStr_Operacion());
            ps.setString(17, objOC.getStr_estado());
            ps.setString(18, objOC.getStr_usuarioCreador());
            ps.execute();

            //tb_proveedorProductoOrdenCompra
            ResultSet rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
            int idOrdenCompra = -1;

            while (rs.next()) {
                idOrdenCompra = rs.getInt(1);
            }

            if (idOrdenCompra == -1) {
                respuesta = false;
                throw new SQLException();
            }

            sql = "call sp_insertProveedorProductoOrdenCompra".concat(PrepararSQL.get(9));
            for (ProveedorProductoOrdenCompra objPPOC : listaProveedorProductoOrdenCompra) {
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, objPPOC.getObjProveedor().getInt_idProveedor());
                ps.setInt(2, objPPOC.getObjProducto().getInt_idProducto());
                ps.setInt(3, idOrdenCompra);
                ps.setBigDecimal(4, objPPOC.getDbl_cantidad());
                ps.setBigDecimal(5, objPPOC.getDbl_precio());
                ps.setBigDecimal(6, objPPOC.getDbl_descuento());
                ps.setBigDecimal(7, objPPOC.getDbl_peso());
                ps.setString(8, Util.ACTIVO);
                ps.setString(9, objOC.getStr_usuarioCreador());
                ps.execute();
//                ps.closed();
                ps.close();
            }

            //tb_productoHistorial
            sql = "CALL sp_listarProductoHistorial" + PrepararSQL.get(2);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objOC.getObjProveedor().getInt_idProveedor());
            ps.setString(2, Util.ACTIVO);
            ResultSet rs2a = ps.executeQuery();
            ProductoHistorial objProductoHistorial = null;
            List<ProductoHistorial> listaProductoHistorial = new ArrayList<>();

            while (rs2a.next()) {
                objProductoHistorial = new ProductoHistorial();

                objProductoHistorial.setInt_idProductoHistorial(rs2a.getInt(1));
                objProductoHistorial.setInt_idProveedor(rs2a.getInt(2));
                objProductoHistorial.setInt_idProducto(rs2a.getInt(3));
                objProductoHistorial.setDbl_precio(rs2a.getBigDecimal(4));
                objProductoHistorial.setDbl_descuento(rs2a.getBigDecimal(5));
                objProductoHistorial.setDbl_peso(rs2a.getBigDecimal(6));
                objProductoHistorial.setStr_estado(rs2a.getString(7));

                listaProductoHistorial.add(objProductoHistorial);
            }
            
            sql = "CALL sp_insertProductoHistorial" + PrepararSQL.get(7);
            for (ProductoHistorial objPH : listaProductoHistorial) {
                for (ProveedorProductoOrdenCompra objPPOC : listaProveedorProductoOrdenCompra) {
                    if (objPPOC.getObjProducto().getInt_idProducto() == objPH.getInt_idProducto()) {
                        if ((objPPOC.getDbl_precio() != objPH.getDbl_precio())
                                || objPPOC.getDbl_descuento() != objPH.getDbl_descuento()) {
                            ps = cnn.prepareStatement(sql);
                            ps.setInt(1, objPPOC.getObjProveedor().getInt_idProveedor());
                            ps.setInt(2, objPPOC.getObjProducto().getInt_idProducto());
                            ps.setBigDecimal(3, objPPOC.getDbl_precio());
                            ps.setBigDecimal(4, objPPOC.getDbl_descuento());
                            ps.setBigDecimal(5, objPPOC.getDbl_peso());
                            ps.setString(6, Util.ACTIVO);
                            ps.setString(7, objOC.getStr_usuarioCreador());
                            ps.execute();
//                            ps.closed();
                            ps.close();
                        }
                    }
                }
            }

            //tb_facturaCompra
            sql = "CALL sp_insertFacturaCompra" + PrepararSQL.get(4);
            ps = cnn.prepareStatement(sql);
            ps.setString(1, objOC.getStr_numeroOC());
            ps.setString(2, "");
            ps.setString(3, Util.ACTIVO);
            ps.setString(4, objOC.getStr_usuarioCreador());
            ps.execute();
            
            //tb_proveedorProductoOrdenCompraFacturaCompra
            ResultSet rs2 = ps.executeQuery("SELECT LAST_INSERT_ID()");
            int idFacturaCompra = -1;

            while (rs2.next()) {
                idFacturaCompra = rs2.getInt(1);
            }

            if (idFacturaCompra == -1) {
                respuesta = false;
                throw new SQLException();
            }
            
            sql = "CALL sp_insertPPOCFC" + PrepararSQL.get(7);
            for (ProveedorProductoOrdenCompra objPPOC : listaProveedorProductoOrdenCompra) {
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, objPPOC.getObjProveedor().getInt_idProveedor());
                ps.setInt(2, objPPOC.getObjProducto().getInt_idProducto());
                ps.setInt(3, idOrdenCompra);
                ps.setInt(4, idFacturaCompra);
                ps.setInt(5, objOC.getObjLocal().getInt_idLocal());
                ps.setString(6, Util.ACTIVO);
                ps.setString(7, objOC.getStr_usuarioCreador());
                ps.execute();
//                ps.closed();
                ps.close();
            }
            
            //tb_obligacionesPago
            sql = "CALL sp_insertObligacionesPago" + PrepararSQL.get(5);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idFacturaCompra);
            ps.setInt(2, objOC.getObjTipoObligacion().getInt_idTipoObligacion());
            ps.setBigDecimal(3, precioTotal);
            ps.setString(4, Util.ACTIVO);
            ps.setString(5, objOC.getStr_usuarioCreador());
            ps.execute();
            
            //tb_cronogramaPagos
            ResultSet rs3 = ps.executeQuery("SELECT LAST_INSERT_ID()");
            int idObligacionesPago = -1;

            while (rs3.next()) {
                idObligacionesPago = rs3.getInt(1);
            }

            if (idObligacionesPago == -1) {
                respuesta = false;
                throw new SQLException();
            }
            
            sql = "CALL sp_insertCronogramaPagos" + PrepararSQL.get(8);
            if (!listaCronogramaPagos.isEmpty()) {
                //LETRAS
                for (CronogramaPagos objCP : listaCronogramaPagos) {
                    ps = cnn.prepareStatement(sql);
                    ps.setInt(1, idObligacionesPago);
                    ps.setString(2, objCP.getStr_numeroLetra());
                    ps.setString(3, objCP.getStr_fechaEmision());
                    ps.setInt(4, objCP.getInt_diasCalendario());
                    ps.setString(5, objCP.getStr_fechaVencimiento());
                    ps.setBigDecimal(6, objCP.getDbl_monto());
                    ps.setString(7, Util.ACTIVO);
                    ps.setString(8, objOC.getStr_usuarioCreador());
                    ps.execute();
//                    ps.closed();
                    ps.close();
                }
            } else {
                //EFECTIVO
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, idObligacionesPago);
                ps.setString(2, "");
                ps.setString(3, "");
                ps.setInt(4, 0);
                ps.setString(5, "");
                ps.setBigDecimal(6, precioTotal);
                ps.setString(7, Util.ACTIVO);
                ps.setString(8, objOC.getStr_usuarioCreador());
                ps.execute();
                ps.close();
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
            	ps.close();
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
            }
        }
        return respuesta;
    }

    @Override
    public String listarOCUltimoID() {
        Connection cnn = null;
        String respuesta = "";

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarOrdenCompraUltimoID" + PrepararSQL.get(0);
            PreparedStatement ps = cnn.prepareStatement(sql);
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
    public List<ProveedorProductoOrdenCompra> listarProveedorProducto(String idProveedor, String idProducto, String estado, String producto) {
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps;
        ResultSet rs;
        List<ProveedorProductoOrdenCompra> listaProveedorProductoOrdenCompra = new ArrayList<>();
        ProveedorProductoOrdenCompra objProveeProdOrdenCompra;
        Proveedor objProveedor;
        Producto objProducto;
        Familia objFamilia;
        UnidadMedida objUnidadMedida;
        MedidaRotacion objMedidaRotacion;
        
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            sql = "CALL sp_selectProveedorProducto".concat(PrepararSQL.get(4));
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idProveedor);
            ps.setString(2, idProducto);
            ps.setString(3, estado);
            ps.setString(4, producto);
            rs = ps.executeQuery();

            while (rs.next()) {
                objProveeProdOrdenCompra = new ProveedorProductoOrdenCompra();
                objProveedor = new Proveedor();
                objProducto = new Producto();
                objFamilia = new Familia();
                objUnidadMedida = new UnidadMedida();
                objMedidaRotacion = new MedidaRotacion();

                objProveedor.setInt_idProveedor(rs.getInt(1));

                objProducto.setInt_idProducto(rs.getInt(2));
                objProducto.setStr_nombreProducto(rs.getString(8));
                objProducto.setStr_codigoInterno(rs.getString(9));
                objProducto.setStr_descripcion(rs.getString(10));
                objProducto.setStr_fabricante(rs.getString(11));
                objProducto.setStr_reintegroTributario(rs.getString(12));

                objFamilia.setStr_nombre(rs.getString(14));

                objUnidadMedida.setInt_idUnidadMedida(rs.getInt(15));
                objUnidadMedida.setStr_nombreUM(rs.getString(16));

                objMedidaRotacion.setInt_idMedidaRotacion(rs.getInt(17));
                objMedidaRotacion.setStr_codigoMR(rs.getString(18));
                objMedidaRotacion.setStr_nombreMR(rs.getString(19));
                objMedidaRotacion.setDbl_utilidad(rs.getBigDecimal(20));
                objMedidaRotacion.setDbl_adicional(rs.getBigDecimal(21));
                objMedidaRotacion.setStr_estado(rs.getString(22));

                objProveeProdOrdenCompra.setObjProveedor(objProveedor);
                objProveeProdOrdenCompra.setObjProducto(objProducto);
                objProveeProdOrdenCompra.getObjProducto().setObjFamilia(objFamilia);
                objProveeProdOrdenCompra.getObjProducto().setObjUnidadMedida(objUnidadMedida);
                objProveeProdOrdenCompra.getObjProducto().setObjMedidaRotacion(objMedidaRotacion);
                objProveeProdOrdenCompra.setDbl_precio(BigDecimal.ZERO);
                objProveeProdOrdenCompra.setDbl_descuento(BigDecimal.ZERO);
                objProveeProdOrdenCompra.setDbl_peso(BigDecimal.ZERO);

                listaProveedorProductoOrdenCompra.add(objProveeProdOrdenCompra);
            }

            sql = "CALL sp_selectProductoHistorial" + PrepararSQL.get(3);
            int i = 0;

            for (ProveedorProductoOrdenCompra objPPOC : listaProveedorProductoOrdenCompra) {
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, objPPOC.getObjProveedor().getInt_idProveedor());
                ps.setInt(2, objPPOC.getObjProducto().getInt_idProducto());
                ps.setString(3, Util.ACTIVO);
                rs = ps.executeQuery();

                while (rs.next()) {
                    listaProveedorProductoOrdenCompra.get(i).setDbl_precio(rs.getBigDecimal(1));
                    listaProveedorProductoOrdenCompra.get(i).setDbl_descuento(rs.getBigDecimal(2));
                    listaProveedorProductoOrdenCompra.get(i).setDbl_peso(rs.getBigDecimal(3));
                }

                i++;
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
        
        return listaProveedorProductoOrdenCompra;
    }

    @Override
    public List<OrdenCompra> buscarOrdenCompra(String NOC, String proveedor,
            String transportista, String viaTransporte, String condicionPago) {
        Connection cnn = null;
        List<OrdenCompra> listaOrdenCompra = new ArrayList<>();
        OrdenCompra objOrdenCompra;
        Proveedor objProveedor;
        Proveedor objTransportista;
        Local objAlmacen;
        TipoObligacion objTipoObligacion;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "call sp_listarOrdenCompra" + PrepararSQL.get(5);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, NOC);
            ps.setString(2, proveedor);
            ps.setString(3, transportista);
            ps.setString(4, viaTransporte);
            ps.setString(5, condicionPago);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objOrdenCompra = new OrdenCompra();
                objProveedor = new Proveedor();
                objTransportista = new Proveedor();
                objAlmacen = new Local();
                objTipoObligacion = new TipoObligacion();

                objOrdenCompra.setInt_idOrdenCompra(rs.getInt(1));

                objProveedor.setInt_idProveedor(rs.getInt(2));
                objProveedor.setStr_razonSocial(rs.getString(19));
                objProveedor.setStr_ruc(rs.getString(20));
                objProveedor.setStr_direccion(rs.getString(21));
                objProveedor.setStr_telefono(rs.getString(22));
                objOrdenCompra.setObjProveedor(objProveedor);

                objOrdenCompra.setStr_numeroOC(rs.getString(3));

                objTransportista.setInt_idProveedor(rs.getInt(4));
                objTransportista.setStr_razonSocial(rs.getString(23));
                objTransportista.setStr_ruc(rs.getString(24));
                objTransportista.setStr_direccion(rs.getString(25));
                objTransportista.setStr_telefono(rs.getString(26));
                objOrdenCompra.setObjTransportista(objTransportista);

                objAlmacen.setInt_idLocal(rs.getInt(5));
                objAlmacen.setStr_nombre(rs.getString(27));
                objOrdenCompra.setObjLocal(objAlmacen);

                objOrdenCompra.setStr_viaTransporte(rs.getString(6));

                objTipoObligacion.setInt_idTipoObligacion(rs.getInt(7));
                objTipoObligacion.setStr_nombreTO(rs.getString(28));
                objOrdenCompra.setObjTipoObligacion(objTipoObligacion);

                objOrdenCompra.setDbl_precioBruto(rs.getBigDecimal(8));
                objOrdenCompra.setDbl_precioTotal(rs.getBigDecimal(9));
                objOrdenCompra.setDbl_descuentoTotal(rs.getBigDecimal(10));
                objOrdenCompra.setDbl_valorVenta(rs.getBigDecimal(11));
                objOrdenCompra.setDbl_igv(rs.getBigDecimal(12));
                objOrdenCompra.setDbl_igvRecuperado(rs.getBigDecimal(13));
                objOrdenCompra.setDbl_pesoTotal(rs.getBigDecimal(14));
                objOrdenCompra.setStr_fechaEntrega(rs.getString(15));
                objOrdenCompra.setStr_fechaValidez(rs.getString(16));
                objOrdenCompra.setStr_Operacion(rs.getString(17));
                objOrdenCompra.setStr_estado(rs.getString(18));

                listaOrdenCompra.add(objOrdenCompra);
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
        return listaOrdenCompra;
    }

    @Override
    public List<ProveedorProductoOrdenCompra> listarPPOC(int idOrdenCompra) {
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ProveedorProductoOrdenCompra> listaPPOC = new ArrayList<>();
        ProveedorProductoOrdenCompra objProveedorProductoOrdenCompra = null;
        Proveedor objProveedor = null;
        Producto objProducto = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            
            String sql = "CALL sp_listarPPOCTodos".concat(PrepararSQL.get(1));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idOrdenCompra);
            rs = ps.executeQuery();
            
            UnidadMedida objUnidadMedida;

            while (rs.next()) {
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
                objUnidadMedida=new UnidadMedida();
                    objUnidadMedida.setInt_idUnidadMedida(rs.getInt(13));
                    objUnidadMedida.setStr_nombreUM(rs.getString(14));
                 
                    objProducto.setObjUnidadMedida(objUnidadMedida);
                objProveedorProductoOrdenCompra.setObjProducto(objProducto);

                objProveedorProductoOrdenCompra.setInt_idOrdenCompra(rs.getInt(3));
                objProveedorProductoOrdenCompra.setDbl_cantidad(rs.getBigDecimal(4));
                objProveedorProductoOrdenCompra.setDbl_precio(rs.getBigDecimal(5));
                objProveedorProductoOrdenCompra.setDbl_descuento(rs.getBigDecimal(6));
                objProveedorProductoOrdenCompra.setDbl_peso(rs.getBigDecimal(7));
                objProveedorProductoOrdenCompra.setStr_estado(rs.getString(8));

                    
                
                    
                
                listaPPOC.add(objProveedorProductoOrdenCompra);
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
        return listaPPOC;
    }

    @Override
    public boolean modificarOC(OrdenCompra objOC, OrdenCompra objOCNuevo,
            List<ProveedorProductoOrdenCompra> listaProveedorProductoOrdenCompra,
            BigDecimal precioTotal, List<CronogramaPagos> listaCronogramaPagos) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql = "";

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            PreparedStatement ps;
            cnn.setAutoCommit(false);
            
            //tb_ordenCompra
            sql = "CALL sp_modificarOrdenCompra" + PrepararSQL.get(3);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objOC.getInt_idOrdenCompra());
            ps.setString(2, objOC.getStr_estado());
            ps.setString(3, objOC.getStr_usuarioModificador());
            ps.execute();
            ps.close();
            
            sql = "CALL sp_insertOrdenCompra" + PrepararSQL.get(18);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objOCNuevo.getObjProveedor().getInt_idProveedor());
            ps.setString(2, objOCNuevo.getStr_numeroOC());
            ps.setInt(3, objOCNuevo.getObjTransportista().getInt_idProveedor());
            ps.setInt(4, objOCNuevo.getObjLocal().getInt_idLocal());
            ps.setString(5, objOCNuevo.getStr_viaTransporte());
            ps.setInt(6, objOCNuevo.getObjTipoObligacion().getInt_idTipoObligacion());
            ps.setBigDecimal(7, objOCNuevo.getDbl_precioBruto());
            ps.setBigDecimal(8, objOCNuevo.getDbl_precioTotal());
            ps.setBigDecimal(9, objOCNuevo.getDbl_descuentoTotal());
            ps.setBigDecimal(10, objOCNuevo.getDbl_valorVenta());
            ps.setBigDecimal(11, objOCNuevo.getDbl_igv());
            ps.setBigDecimal(12, objOCNuevo.getDbl_igvRecuperado());
            ps.setBigDecimal(13, objOCNuevo.getDbl_pesoTotal());
            ps.setString(14, objOCNuevo.getStr_fechaEntrega());
            ps.setString(15, objOCNuevo.getStr_fechaValidez());
            ps.setString(16, objOCNuevo.getStr_Operacion());
            ps.setString(17, objOCNuevo.getStr_estado());
            ps.setString(18, objOCNuevo.getStr_usuarioCreador());
            ps.execute();
            
            // tb_proveedorProductoOrdenCompra
            ResultSet rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
            int idOrdenCompra = -1;

            while (rs.next()) {
                idOrdenCompra = rs.getInt(1);
            }

            if (idOrdenCompra == -1) {
                respuesta = false;
                throw new SQLException();
            }

            sql = "call sp_insertProveedorProductoOrdenCompra".concat(PrepararSQL.get(9));
            for (ProveedorProductoOrdenCompra objPPOC : listaProveedorProductoOrdenCompra) {
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, objPPOC.getObjProveedor().getInt_idProveedor());
                ps.setInt(2, objPPOC.getObjProducto().getInt_idProducto());
                ps.setInt(3, idOrdenCompra);
                ps.setBigDecimal(4, objPPOC.getDbl_cantidad());
                ps.setBigDecimal(5, objPPOC.getDbl_precio());
                ps.setBigDecimal(6, objPPOC.getDbl_descuento());
                ps.setBigDecimal(7, objPPOC.getDbl_peso());
                ps.setString(8, Util.ACTIVO);
                ps.setString(9, objOCNuevo.getStr_usuarioCreador());
                ps.execute();
                ps.close();
            }

            sql = "CALL sp_modificarProveedorProductoOrdenCompra".concat(PrepararSQL.get(3));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objOC.getInt_idOrdenCompra());
            ps.setString(2, Util.INACTIVO);
            ps.setString(3, objOC.getStr_usuarioModificador());
            ps.execute();
            ps.close();
            
            //tb_productoHistorial
            sql = "CALL sp_listarProductoHistorial" + PrepararSQL.get(2);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objOCNuevo.getObjProveedor().getInt_idProveedor());
            ps.setString(2, Util.ACTIVO);
            ResultSet rs2a = ps.executeQuery();
            ProductoHistorial objProductoHistorial = null;
            List<ProductoHistorial> listaProductoHistorial = new ArrayList<>();

            while (rs2a.next()) {
                objProductoHistorial = new ProductoHistorial();

                objProductoHistorial.setInt_idProductoHistorial(rs2a.getInt(1));
                objProductoHistorial.setInt_idProveedor(rs2a.getInt(2));
                objProductoHistorial.setInt_idProducto(rs2a.getInt(3));
                objProductoHistorial.setDbl_precio(rs2a.getBigDecimal(4));
                objProductoHistorial.setDbl_descuento(rs2a.getBigDecimal(5));
                objProductoHistorial.setDbl_peso(rs2a.getBigDecimal(6));
                objProductoHistorial.setStr_estado(rs2a.getString(7));

                listaProductoHistorial.add(objProductoHistorial);
            }
            
            sql = "CALL sp_insertProductoHistorial" + PrepararSQL.get(7);
            for (ProductoHistorial objPH : listaProductoHistorial) {
                for (ProveedorProductoOrdenCompra objPPOC : listaProveedorProductoOrdenCompra) {
                    if (objPPOC.getObjProducto().getInt_idProducto() == objPH.getInt_idProducto()) {
                        if ((objPPOC.getDbl_precio() != objPH.getDbl_precio())
                                || objPPOC.getDbl_descuento() != objPH.getDbl_descuento()) {
                            ps = cnn.prepareStatement(sql);
                            ps.setInt(1, objPPOC.getObjProveedor().getInt_idProveedor());
                            ps.setInt(2, objPPOC.getObjProducto().getInt_idProducto());
                            ps.setBigDecimal(3, objPPOC.getDbl_precio());
                            ps.setBigDecimal(4, objPPOC.getDbl_descuento());
                            ps.setBigDecimal(5, objPPOC.getDbl_peso());
                            ps.setString(6, Util.ACTIVO);
                            ps.setString(7, objOCNuevo.getStr_usuarioCreador());
                            ps.execute();
                            ps.close();
                        }
                    }
                }
            }
            
            //tb_facturaCompra
            int idFacturaCompraUpdate = -1;
            sql = "CALL sp_modificarFacturaCompra" + PrepararSQL.get(3);
            ps = cnn.prepareStatement(sql);
            ps.setString(1, objOC.getStr_numeroOC());
            ps.setString(2, Util.INACTIVO);
            ps.setString(3, objOC.getStr_usuarioCreador());
            ResultSet rs2 = ps.executeQuery();
            while (rs2.next()) {
                idFacturaCompraUpdate = rs2.getInt(1);
            }
            ps.close();
            
            sql = "CALL sp_insertFacturaCompra" + PrepararSQL.get(4);
            ps = cnn.prepareStatement(sql);
            ps.setString(1, objOCNuevo.getStr_numeroOC());
            ps.setString(2, "");
            ps.setString(3, Util.ACTIVO);
            ps.setString(4, objOCNuevo.getStr_usuarioCreador());
            ps.execute();
            
            //tb_proveedorProductoOrdenCompraFacturaCompra
            ResultSet rs3 = ps.executeQuery("SELECT LAST_INSERT_ID()");
            int idFacturaCompra = -1;

            while (rs3.next()) {
                idFacturaCompra = rs3.getInt(1);
            }

            if (idFacturaCompra == -1) {
                respuesta = false;
                throw new SQLException();
            }
            
            sql = "CALL sp_insertPPOCFC" + PrepararSQL.get(7);
            for (ProveedorProductoOrdenCompra objPPOC : listaProveedorProductoOrdenCompra) {
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, objPPOC.getObjProveedor().getInt_idProveedor());
                ps.setInt(2, objPPOC.getObjProducto().getInt_idProducto());
                ps.setInt(3, idOrdenCompra);
                ps.setInt(4, idFacturaCompra);
                ps.setInt(5, objOCNuevo.getObjLocal().getInt_idLocal());
                ps.setString(6, Util.ACTIVO);
                ps.setString(7, objOCNuevo.getStr_usuarioCreador());
                ps.execute();
                ps.close();
            }
            
            sql = "CALL sp_modificarPPOCFC" + PrepararSQL.get(3);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idFacturaCompraUpdate);
            ps.setString(2, Util.INACTIVO);
            ps.setString(3, objOC.getStr_usuarioModificador());
            ps.execute();
            ps.close();
            
            //tb_obligacionesPago
            int idObligacionesPagoUpdate = -1;
            sql = "CALL sp_modificarObligacionesPago" + PrepararSQL.get(3);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idFacturaCompraUpdate);
            ps.setString(2, Util.INACTIVO);
            ps.setString(3, objOC.getStr_usuarioModificador());
            ResultSet rs4 = ps.executeQuery();
            while (rs4.next()) {
                idObligacionesPagoUpdate = rs4.getInt(1);
            }
//            ps.closed();
            ps.close();
            
            sql = "CALL sp_insertObligacionesPago" + PrepararSQL.get(5);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idFacturaCompra);
            ps.setInt(2, objOCNuevo.getObjTipoObligacion().getInt_idTipoObligacion());
            ps.setBigDecimal(3, precioTotal);
            ps.setString(4, Util.ACTIVO);
            ps.setString(5, objOCNuevo.getStr_usuarioCreador());
            ps.execute();

            //tb_cronogramaPagos
            ResultSet rs5 = ps.executeQuery("SELECT LAST_INSERT_ID()");
            int idObligacionesPago = -1;

            while (rs5.next()) {
                idObligacionesPago = rs5.getInt(1);
            }

            if (idObligacionesPago == -1) {
                respuesta = false;
                throw new SQLException();
            }
            
            sql = "CALL sp_insertCronogramaPagos" + PrepararSQL.get(8);
            if (!listaCronogramaPagos.isEmpty()) {
                //LETRAS
                for (CronogramaPagos objCP : listaCronogramaPagos) {
                    ps = cnn.prepareStatement(sql);
                    ps.setInt(1, idObligacionesPago);
                    ps.setString(2, objCP.getStr_numeroLetra());
                    ps.setString(3, objCP.getStr_fechaEmision());
                    ps.setInt(4, objCP.getInt_diasCalendario());
                    ps.setString(5, objCP.getStr_fechaVencimiento());
                    ps.setBigDecimal(6, objCP.getDbl_monto());
                    ps.setString(7, Util.ACTIVO);
                    ps.setString(8, objOCNuevo.getStr_usuarioCreador());
                    ps.execute();
//                    ps.closed();
                    ps.close();
                }
            } else {
                //EFECTIVO
            	ps.close();
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, idObligacionesPago);
                ps.setString(2, "");
                ps.setString(3, "");
                ps.setInt(4, 0);
                ps.setString(5, "");
                ps.setBigDecimal(6, precioTotal);
                ps.setString(7, Util.ACTIVO);
                ps.setString(8, objOCNuevo.getStr_usuarioCreador());
                ps.execute();
//                ps.closed();
                ps.close();
            }
            
            sql = "CALL sp_modificarCronogramaPagos" + PrepararSQL.get(3);
            if (!listaCronogramaPagos.isEmpty()) {
                //LETRAS
//                for (CronogramaPagos objCP : listaCronogramaPagos) {
            	for (int i = 0; i<listaCronogramaPagos.size();i++) {
                    ps = cnn.prepareStatement(sql);
                    ps.setInt(1, idObligacionesPagoUpdate);
                    ps.setString(2, Util.INACTIVO);
                    ps.setString(3, objOC.getStr_usuarioModificador());
                    ps.execute();
                    ps.close();
                }
            } else {
                //EFECTIVO
            	ps.close();
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, idObligacionesPagoUpdate);
                ps.setString(7, Util.INACTIVO);
                ps.setString(8, objOC.getStr_usuarioModificador());
                ps.execute();
                ps.close();
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
    public List<TipoObligacion> buscarTipoObligacion() {
        Connection cnn = null;
        List<TipoObligacion> listaTipoObligacion = new ArrayList<>();
        TipoObligacion objTipoObligacion = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarTipoObligacion" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, Util.ACTIVO);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objTipoObligacion = new TipoObligacion();

                objTipoObligacion.setInt_idTipoObligacion(rs.getInt(1));
                objTipoObligacion.setStr_nombreTO(rs.getString(2));
                objTipoObligacion.setStr_estado(rs.getString(3));

                listaTipoObligacion.add(objTipoObligacion);
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
        return listaTipoObligacion;
    }
}
