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

import com.gestionmatriz.puntoventa.bean.DetalleGuiaRemision;
import com.gestionmatriz.puntoventa.bean.GuiaRemision;
import com.gestionmatriz.puntoventa.bean.ImprimirGuia;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;
import com.gestionmatriz.util.Util;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author jarcon
 */
public class MysqlGuiaRemisionDAO extends ConexionSqlSpring implements GuiaRemisionDAO {

	private static final Logger log=Logger.getLogger(MysqlGuiaRemisionDAO.class);
    @Override
    public List<GuiaRemision> buscarGuias(String nroGuia, String LocalPartida, String estado) {
        Connection cnn = null;
        List<GuiaRemision> listaGuias = new ArrayList<>();
        GuiaRemision objGuia = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarGuias" + PrepararSQL.get(3);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, nroGuia);
            ps.setString(2, estado);
            ps.setString(3, LocalPartida);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objGuia = new GuiaRemision();
                objGuia.setInt_idGuiaRemision(rs.getInt(1));
                objGuia.setStr_nroGuia(rs.getString(2));
                objGuia.setDte_fechaEmision(rs.getString(3));
                objGuia.setDte_fechaTraslado(rs.getString(4));
                objGuia.setStr_motivoTraslado(rs.getString(5));
                objGuia.setStr_domicilioPartida(rs.getString(6));
                objGuia.setStr_domicilioLlegada(rs.getString(7));
                objGuia.setStr_placaMarcaVehiculo(rs.getString(8));
                objGuia.setStr_inscripcionVehiculo(rs.getString(9));
                objGuia.setStr_brevete(rs.getString(10));
                objGuia.setStr_destinatarioNombre(rs.getString(11));
                objGuia.setStr_destinatarioRuc(rs.getString(12));
                objGuia.setStr_destinatarioDireccion(rs.getString(13));
                objGuia.setStr_comprobante(rs.getString(14));
                objGuia.setStr_nroComprobante(rs.getString(15));
                objGuia.setStr_estado(rs.getString(16));
                objGuia.setStr_usuarioCreador(rs.getString(17));
                objGuia.setDte_fechaCreacion(rs.getString(18));
                objGuia.setStr_usuarioModificador(rs.getString(19));
                objGuia.setDte_fechaModificacion(rs.getString(20));
                objGuia.setStr_localPartida(rs.getString(21));

                listaGuias.add(objGuia);
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
        return listaGuias;
    }

    @Override
    public boolean registrarGuiaRemision(GuiaRemision objGuiaRemision,List<DetalleGuiaRemision> objDetalleGuiaRemision) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_insertGuiaRemision" + PrepararSQL.get(18);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, objGuiaRemision.getStr_nroGuia());
            ps.setString(2, objGuiaRemision.getDte_fechaTraslado());
            ps.setString(3, objGuiaRemision.getStr_motivoTraslado());
            ps.setString(4, objGuiaRemision.getStr_domicilioPartida());
            ps.setString(5, objGuiaRemision.getStr_domicilioLlegada());
            ps.setString(6, objGuiaRemision.getStr_placaMarcaVehiculo());
            ps.setString(7, objGuiaRemision.getStr_inscripcionVehiculo());
            ps.setString(8, objGuiaRemision.getStr_brevete());
            ps.setString(9, objGuiaRemision.getStr_destinatarioNombre());
            ps.setString(10, objGuiaRemision.getStr_destinatarioRuc());
            ps.setString(11, objGuiaRemision.getStr_destinatarioDireccion());
            ps.setString(12, objGuiaRemision.getStr_comprobante());
            ps.setString(13, objGuiaRemision.getStr_nroComprobante());
            ps.setString(14, objGuiaRemision.getStr_estado());
            ps.setString(15, objGuiaRemision.getStr_usuarioCreador());
            ps.setString(16, objGuiaRemision.getStr_localPartida());
            ps.setString(17, objGuiaRemision.getStr_rucTranportista());
            ps.setString(18, objGuiaRemision.getStr_nombreTransportista());
            ps.execute();

                sql = "CALL sp_insertDetalleGuia" + PrepararSQL.get(8);
                ps = cnn.prepareStatement(sql);
                for (DetalleGuiaRemision dg:objDetalleGuiaRemision){
                    ps.setInt(1, dg.getInt_idProducto());
                    ps.setBigDecimal(2, dg.getDbl_cantdadProducto());
                    ps.setString(3, dg.getStr_descripcionProducto());
                    ps.setBigDecimal(4, dg.getDbl_peso());
                    ps.setBigDecimal(5, dg.getDbl_costoTraspaso());
                    ps.setString(6, Util.ACTIVO);
                    ps.setString(7, dg.getStr_usuarioCreador());
                    ps.setString(8, dg.getInt_idProveedor());
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
    public boolean registrarDetalleGuiaRemision(DetalleGuiaRemision objDetalleGuiaRemision) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_insertDetalleGuia" + PrepararSQL.get(8);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, objDetalleGuiaRemision.getInt_idProducto());
//            System.out.println("int Producto--:" + objDetalleGuiaRemision.getInt_idProducto());
            ps.setBigDecimal(2, objDetalleGuiaRemision.getDbl_cantdadProducto());
            ps.setString(3, objDetalleGuiaRemision.getStr_descripcionProducto());
            ps.setBigDecimal(4, objDetalleGuiaRemision.getDbl_peso());
            ps.setBigDecimal(5, objDetalleGuiaRemision.getDbl_costoTraspaso());
            ps.setString(6, Util.ACTIVO);
            ps.setString(7, objDetalleGuiaRemision.getStr_usuarioCreador());
            ps.setString(8, objDetalleGuiaRemision.getInt_idProveedor());
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
    public boolean updateEstadoGuia(int idGuia, String estado) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_updateEstadoGuia" + PrepararSQL.get(2);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, idGuia);
            ps.setString(2, estado);
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
    public List<DetalleGuiaRemision> buscarDetalleGuiaXId(int idGuiaRemision) {
        Connection cnn = null;
        List<DetalleGuiaRemision> listaDetalleGuia = new ArrayList<>();
        DetalleGuiaRemision objDetalleGuiaRemision = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            
            String sql = "CALL sp_listarDetalleGuiaAlmacen" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, idGuiaRemision);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objDetalleGuiaRemision = new DetalleGuiaRemision();

                objDetalleGuiaRemision.setInt_idGuiaRemision(rs.getInt(1));
                objDetalleGuiaRemision.setInt_idProducto(rs.getInt(2));
                objDetalleGuiaRemision.setDbl_cantdadProducto(rs.getBigDecimal(3));
                objDetalleGuiaRemision.setStr_descripcionProducto(rs.getString(4));
                objDetalleGuiaRemision.setDbl_peso(rs.getBigDecimal(5));
                objDetalleGuiaRemision.setDbl_costoTraspaso(rs.getBigDecimal(6));
                objDetalleGuiaRemision.setStr_estado(rs.getString(7));
                objDetalleGuiaRemision.setStr_usuarioCreador(rs.getString(8));
                objDetalleGuiaRemision.setDte_fechaCreacion(rs.getString(9));
                objDetalleGuiaRemision.setStr_usuarioModificador(rs.getString(10));
                objDetalleGuiaRemision.setDte_fechaModificacion(rs.getString(11));
                objDetalleGuiaRemision.setInt_idProveedor(rs.getString(12));

                listaDetalleGuia.add(objDetalleGuiaRemision);
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
        return listaDetalleGuia;
    }

    @Override
    public List<ImprimirGuia> imprimirGuia(String nroGuia) {
        Connection cnn = null;
        List<ImprimirGuia> listaGuias = new ArrayList<>();
        ImprimirGuia objGuia = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_imprimirGuia" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, nroGuia);
//            ps.setString(2, estado);
//            ps.setString(3, localPartida);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objGuia = new ImprimirGuia();
                objGuia.setInt_idGuiaremision(rs.getInt(1));
                objGuia.setStr_numeroGuia(rs.getString(2));
                objGuia.setDte_fechaEmision(rs.getString(3));
                objGuia.setDte_fechaInicioTraslado(rs.getString(4));
                objGuia.setStr_motivoTraslado(rs.getString(5));
                objGuia.setStr_domicilioPartida(rs.getString(6));
                objGuia.setStr_domicilioLlegada(rs.getString(7));
                objGuia.setStr_placaMarcaVehiculo(rs.getString(8));
                objGuia.setStr_inscripcionVehiculo(rs.getString(9));
                objGuia.setStr_breveteConductor(rs.getString(10));
                objGuia.setStr_destinatarioNombre(rs.getString(11));
                objGuia.setStr_destinatarioRuc(rs.getString(12));
                objGuia.setStr_destinatarioDireccion(rs.getString(13));
                objGuia.setStr_comprobantePago(rs.getString(14));
                objGuia.setStr_nroComprobante(rs.getString(15));
                objGuia.setStr_estado(rs.getString(16));
                objGuia.setStr_localPartida(rs.getString(17));
                objGuia.setStr_rucTransportista(rs.getString(18));
                objGuia.setStr_nombreTransportista(rs.getString(19));
                
                objGuia.setInt_idProducto(rs.getInt(20));
                objGuia.setDbl_cantidadProducto(rs.getBigDecimal(21));
                objGuia.setStr_descripcionProducto(rs.getString(22));
                objGuia.setDbl_peso(rs.getBigDecimal(23));
                objGuia.setDbl_costoTraslado(rs.getBigDecimal(24));
                

                listaGuias.add(objGuia);
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
        return listaGuias;
    }
}
