/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.dao;

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
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.puntoventa.bean.Caja;
import com.gestionmatriz.puntoventa.bean.Cliente;
import com.gestionmatriz.puntoventa.bean.FlujoCaja;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.recursoshumanos.bean.Config;
import com.gestionmatriz.recursoshumanos.bean.Local;
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
public class MysqlFlujoCajaDAO extends ConexionSqlSpring implements FlujoCajaDAO {

	private static final Logger log=Logger.getLogger(MysqlFlujoCajaDAO.class);
    @Override
    public String[] registrarFlujoCaja(FlujoCaja objFlujoCaja, String nroDocumentoTemp, String nroDocumento,String tipoVenta, String comprobante) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String[] arrDocumentos = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            sql = "CALL sp_insertFlujoCaja" + PrepararSQL.get(10);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objFlujoCaja.getObjLocal().getInt_idLocal());
            ps.setInt(2, objFlujoCaja.getObjCaja().getInt_idCaja());
            ps.setBigDecimal(3, objFlujoCaja.getDbl_cantidadSoles());
            ps.setBigDecimal(4, objFlujoCaja.getDbl_cantidadDolares());
            ps.setBigDecimal(5, objFlujoCaja.getDbl_cantidadTotalSoles());
            ps.setString(6, objFlujoCaja.getStr_motivo());
            ps.setString(7, Util.ACTIVO);
            ps.setString(8, objFlujoCaja.getStr_usuarioCreador());
            ps.setString(9, nroDocumento);
            ps.setString(10,objFlujoCaja.getStr_numeroSerie());
            ps.execute();

            if (objFlujoCaja.getStr_motivo().equals(Util.VENTACAJA)) {
                //Agregado por Yesmi Torres Para Actualizar los Documentos================
                List<Integer> listaCodigoVenta = new ArrayList<>();
                List<Integer> listaCodigoAlamacen = new ArrayList<>();
                
                sql = "call sp_consultaIdVenta".concat(PrepararSQL.get(2));
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, objFlujoCaja.getObjLocal().getInt_idLocal());
                ps.setString(2, nroDocumentoTemp);
                rs = ps.executeQuery();

                while (rs.next()) {
                    listaCodigoVenta.add(rs.getInt(1));
                }

                sql = "call sp_consultaIdAlmacen".concat(PrepararSQL.get(2));
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, objFlujoCaja.getObjLocal().getInt_idLocal());
                ps.setString(2, nroDocumentoTemp);
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    listaCodigoAlamacen.add(rs.getInt(1));
                }
                //Agregado por Yesmi Torres Para Actualizar los Documentos================
                
                int indiceDocumento = 0, contTem = 0, cont = 0;
                 List<Config> listaConfig = PaqueteBusinessDelegate.getConfigService().listaConfig(); 
                for (int i = 0; i < listaCodigoVenta.size(); i++) {
                    contTem++;
                    cont++;

                    sql = "CALL sp_updateVentaYAlmacen".concat(PrepararSQL.get(9));
                    ps = cnn.prepareStatement(sql);
                    ps.setInt(1, objFlujoCaja.getObjLocal().getInt_idLocal());
                    ps.setString(2, nroDocumentoTemp);
                    //ps.setString(3, nroDocumento.split("/")[0]);
                    ps.setString(3, nroDocumento.split(";")[indiceDocumento].split("/")[0]);
                    ps.setString(4, Util.PAGADO);
                    ps.setString(5, objFlujoCaja.getStr_usuarioCreador());
                    ps.setInt(6, listaCodigoVenta.get(i));
                    ps.setInt(7, listaCodigoAlamacen.get(i));
                    ps.setString(8, tipoVenta);
                    ps.setString(9, comprobante);
                    ps.execute();

                    if (listaConfig.get(0).getTipoImpresion().equals(Config.MATRICIAL)){
                        if (contTem == 10 || cont == listaCodigoAlamacen.size()) {
                            contTem = 0;
                            indiceDocumento++;
                        }
                    }
                    

                }

                arrDocumentos = nroDocumento.split(";");

                for (String string : arrDocumentos) {
                    sql = "call sp_insertarDocumentoVenta".concat(PrepararSQL.get(3));
                    ps = cnn.prepareStatement(sql);
                    ps.setInt(1, Util.stringTOint(string.split("-")[2].split("/")[0]));
                    ps.setInt(2, Util.stringTOint(string.split("/")[1]));
                    ps.setBigDecimal(3, objFlujoCaja.getDbl_cantidadTotalSoles());
                    ps.execute();
                }


            }else{
                arrDocumentos = new String [1];
                arrDocumentos [0] = "true";
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

        return arrDocumentos;
    }

    @Override
    public List<Ventas> listarVenta(String idLocal, String estado, String numeroDocumento, int puntero) {
        Connection cnn = null;
        ResultSet rs = null;
        List<Ventas> listaVenta = new ArrayList<>();
        Ventas objVentas = null;
        Proveedor objProveedor = null;
        Producto objProducto = null;
        Cliente objCliente = null;
        Local objLocal = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            if (puntero == 1) {
                String sql = "CALL sp_listarVenta".concat(PrepararSQL.get(2));
                PreparedStatement ps = cnn.prepareStatement(sql);
                ps.setString(1, idLocal);
                ps.setString(2, estado);
                rs = ps.executeQuery();
            } else if (puntero == 2) {
                String sql = "CALL sp_listarVentaDetalle".concat(PrepararSQL.get(3));
                PreparedStatement ps = cnn.prepareStatement(sql);
                ps.setString(1, idLocal);
                ps.setString(2, estado);
                ps.setString(3, numeroDocumento);
                rs = ps.executeQuery();
            }

            while (rs.next()) {
                objVentas = new Ventas();
                objProveedor = new Proveedor();
                objProducto = new Producto();
                objCliente = new Cliente();
                objLocal = new Local();

                objVentas.setInt_idVenta(rs.getInt(1));
                objVentas.setDbCantidad(rs.getBigDecimal(5));
                objVentas.setDbPrecio(rs.getBigDecimal(6));
                objVentas.setDbSubtotal(rs.getBigDecimal(7));
                objVentas.setDbdescuento(rs.getBigDecimal(8));
                objVentas.setDbIGV(rs.getBigDecimal(9));
                objVentas.setDbTotal(rs.getBigDecimal(10));
                objVentas.setStr_numeroDocumento(rs.getString(11));
                objVentas.setStr_usuario(rs.getString(12));
                objVentas.setStr_estado(rs.getString(13));
                objVentas.setStr_clienteResponsable(rs.getString(14));
                objVentas.setDbUnidadesContenidas(rs.getBigDecimal(47));

                objProveedor.setInt_idProveedor(rs.getInt(2));
                objProveedor.setStr_razonSocial(rs.getString(16));
                objProveedor.setStr_nombreComercial(rs.getString(17));
                objProveedor.setStr_ruc(rs.getString(18));
                objProveedor.setStr_direccion(rs.getString(19));
                objProveedor.setStr_email(rs.getString(20));
                objProveedor.setStr_telefono(rs.getString(21));
                objProveedor.setStr_fax(rs.getString(22));
                objProveedor.setStr_representanteLegal(rs.getString(23));
                objProveedor.setStr_banco(rs.getString(24));
                objProveedor.setStr_ctaPrincipal(rs.getString(25));
                objProveedor.setStr_ctaAlternativa(rs.getString(26));
                objProveedor.setStr_estado(rs.getString(27));
                objVentas.setObjProveedor(objProveedor);

                objProducto.setInt_idProducto(rs.getInt(3));
                objProducto.setStr_nombreProducto(rs.getString(28));
                objProducto.setStr_codigoInterno(rs.getString(29));
                objProducto.setStr_descripcion(rs.getString(30));
                objProducto.setStr_fabricante(rs.getString(31));
                objProducto.setStr_reintegroTributario(rs.getString(32));
                objProducto.setStr_estado(rs.getString(33));
                objVentas.setObjProducto(objProducto);

                objCliente.setInt_idCliente(rs.getInt(4));
                objCliente.setStr_razonSocial(rs.getString(34));
                objCliente.setStr_rucdni(rs.getString(35));
                objCliente.setStr_direccion(rs.getString(36));
                objCliente.setStr_telefono(rs.getString(37));
                objCliente.setStr_estado(rs.getString(38));
                objVentas.setObjCliente(objCliente);

                objLocal.setInt_idLocal(rs.getInt(15));
                objLocal.setStr_nombre(rs.getString(39));
                objLocal.setStr_direccion(rs.getString(40));
                objLocal.setStr_estado(rs.getString(41));
                objLocal.setStr_telefono(rs.getString(42));
                objLocal.setStr_distrito(rs.getString(43));
                objLocal.setStr_provincia(rs.getString(44));
                objLocal.setStr_departamento(rs.getString(45));
                objLocal.setStr_codLocalGuia(rs.getString(46));
                objVentas.setObjLocal(objLocal);

                listaVenta.add(objVentas);
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

        return listaVenta;
    }

    @Override
    public List<Caja> listarCaja(int idLocal) {
        Connection cnn = null;
        List<Caja> listaCaja = new ArrayList<>();
        Caja objCaja = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_listarCajasDisponibles".concat(PrepararSQL.get(3));
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, idLocal);
            ps.setString(2, Util.APERTURACAJA);
            ps.setString(3, Util.CIERRECAJA);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objCaja = new Caja();

                objCaja.setInt_idCaja(rs.getInt(1));
                objCaja.setStr_nombre(rs.getString(2));
                objCaja.setStr_descripcion(rs.getString(3));
                objCaja.setStr_estado(rs.getString(4));

                listaCaja.add(objCaja);
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

        return listaCaja;
    }

    @Override
    public List<Caja> getCaja(int idLocal, String usuario) {
        List<Caja> listaCaja = new ArrayList<>();
        Caja objCaja = null;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            sql = "CALL sp_verificarAperturaCaja".concat(PrepararSQL.get(4));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idLocal);
            ps.setString(2, Util.APERTURACAJA);
            ps.setString(3, Util.CIERRECAJA);
            ps.setString(4, usuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objCaja = new Caja();

                objCaja.setInt_idCaja(rs.getInt(1));
                objCaja.setStr_nombre(rs.getString(2));
                objCaja.setStr_numeroSerieImpresora(rs.getString(3));

                listaCaja.add(objCaja);
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

        return listaCaja;
    }

    @Override
    public BigDecimal cantidadXLocalYCaja(FlujoCaja objFlujoCaja) {
        BigDecimal respuesta = BigDecimal.ZERO;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            sql = "CALL sp_cantidadXLocalXCaja" + PrepararSQL.get(5);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objFlujoCaja.getObjLocal().getInt_idLocal());
            ps.setInt(2, objFlujoCaja.getObjCaja().getInt_idCaja());
            ps.setString(3, Util.APERTURACAJA);
            ps.setString(4, Util.VENTACAJA);
            ps.setString(5, Util.CIERRECAJA);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                respuesta = rs.getBigDecimal(1);
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
    public boolean cerrarCaja(FlujoCaja objFlujoCaja) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            sql = "CALL sp_insertFlujoCajaCierre" + PrepararSQL.get(9);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objFlujoCaja.getObjLocal().getInt_idLocal());
            ps.setInt(2, objFlujoCaja.getObjCaja().getInt_idCaja());
            ps.setBigDecimal(3, objFlujoCaja.getDbl_cantidadSoles());
            ps.setBigDecimal(4, objFlujoCaja.getDbl_cantidadDolares());
            ps.setBigDecimal(5, objFlujoCaja.getDbl_cantidadTotalSoles());
            ps.setBigDecimal(6, objFlujoCaja.getDbl_cantidadDiferencia());
            ps.setString(7, objFlujoCaja.getStr_motivo());
            ps.setString(8, Util.ACTIVO);
            ps.setString(9, objFlujoCaja.getStr_usuarioCreador());
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
    public List<Ventas> listarVentaAnular(String documento) {
        Connection cnn = null;
        ResultSet rs = null;
        List<Ventas> listaVenta = new ArrayList<>();
        Ventas objVentas = null;
        Proveedor objProveedor = null;
        Producto objProducto = null;
        Cliente objCliente = null;
        Local objLocal = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            
            String sql = "CALL sp_listarVentaAnular".concat(PrepararSQL.get(1));
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, documento);
            rs = ps.executeQuery();

            while (rs.next()) {
                objVentas = new Ventas();
                objProveedor = new Proveedor();
                objProducto = new Producto();
                objCliente = new Cliente();
                objLocal = new Local();

                objVentas.setInt_idVenta(rs.getInt(1));
                objVentas.setDbCantidad(rs.getBigDecimal(5));
                objVentas.setDbPrecio(rs.getBigDecimal(6));
                objVentas.setDbSubtotal(rs.getBigDecimal(7));
                objVentas.setDbdescuento(rs.getBigDecimal(8));
                objVentas.setDbIGV(rs.getBigDecimal(9));
                objVentas.setDbTotal(rs.getBigDecimal(10));
                objVentas.setStr_numeroDocumento(rs.getString(11));
                objVentas.setStr_usuario(rs.getString(12));
                objVentas.setStr_estado(rs.getString(13));
                objVentas.setStr_clienteResponsable(rs.getString(14));
                objVentas.setDbUnidadesContenidas(rs.getBigDecimal(47));

                objProveedor.setInt_idProveedor(rs.getInt(2));
                objProveedor.setStr_razonSocial(rs.getString(16));
                objProveedor.setStr_nombreComercial(rs.getString(17));
                objProveedor.setStr_ruc(rs.getString(18));
                objProveedor.setStr_direccion(rs.getString(19));
                objProveedor.setStr_email(rs.getString(20));
                objProveedor.setStr_telefono(rs.getString(21));
                objProveedor.setStr_fax(rs.getString(22));
                objProveedor.setStr_representanteLegal(rs.getString(23));
                objProveedor.setStr_banco(rs.getString(24));
                objProveedor.setStr_ctaPrincipal(rs.getString(25));
                objProveedor.setStr_ctaAlternativa(rs.getString(26));
                objProveedor.setStr_estado(rs.getString(27));
                objVentas.setObjProveedor(objProveedor);

                objProducto.setInt_idProducto(rs.getInt(3));
                objProducto.setStr_nombreProducto(rs.getString(28));
                objProducto.setStr_codigoInterno(rs.getString(29));
                objProducto.setStr_descripcion(rs.getString(30));
                objProducto.setStr_fabricante(rs.getString(31));
                objProducto.setStr_reintegroTributario(rs.getString(32));
                objProducto.setStr_estado(rs.getString(33));
                objVentas.setObjProducto(objProducto);

                objCliente.setInt_idCliente(rs.getInt(4));
                objCliente.setStr_razonSocial(rs.getString(34));
                objCliente.setStr_rucdni(rs.getString(35));
                objCliente.setStr_direccion(rs.getString(36));
                objCliente.setStr_telefono(rs.getString(37));
                objCliente.setStr_estado(rs.getString(38));
                objVentas.setObjCliente(objCliente);

                objLocal.setInt_idLocal(rs.getInt(15));
                objLocal.setStr_nombre(rs.getString(39));
                objLocal.setStr_direccion(rs.getString(40));
                objLocal.setStr_estado(rs.getString(41));
                objLocal.setStr_telefono(rs.getString(42));
                objLocal.setStr_distrito(rs.getString(43));
                objLocal.setStr_provincia(rs.getString(44));
                objLocal.setStr_departamento(rs.getString(45));
                objLocal.setStr_codLocalGuia(rs.getString(46));
                objVentas.setObjLocal(objLocal);

                listaVenta.add(objVentas);
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

        return listaVenta;
    }

    @Override
    public String getNumeroSerieImpresora(int local) {
        Connection cnn = null;
        String numeroSerie = "";
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_buscarNumeroSeriePrint".concat(PrepararSQL.get(1));
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, local);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                numeroSerie = rs.getString(1);
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
        return numeroSerie;
    }
}
