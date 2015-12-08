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

import com.gestionmatriz.puntoventa.bean.TipoCambio;
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
public class MysqlTipoCambioDAO extends ConexionSqlSpring implements TipoCambioDAO {

	private static final Logger log=Logger.getLogger(MysqlTipoCambioDAO.class);
    @Override
    public boolean registrarTipoCambio(TipoCambio objTipoCambio) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;
        
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            sql = "CALL sp_insertTipoCambio" + PrepararSQL.get(5);
            ps = cnn.prepareStatement(sql);
            ps.setBigDecimal(1, objTipoCambio.getDbl_precioCompraDolar());
            ps.setBigDecimal(2, objTipoCambio.getDbl_precioVentaDolar());
            ps.setString(3, objTipoCambio.getStr_fechaDia());
            ps.setString(4, Util.ACTIVO);
            ps.setString(5, objTipoCambio.getStr_usuarioCreador());
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
    public boolean verificarTipoCambio(String fechaDia) {
        Connection cnn = null;
        boolean respuesta = false;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            
            String sql = "CALL sp_verificarTipoCambio" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, fechaDia);
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
    public TipoCambio obtenerTipoCambio(String fechaDia) {
        TipoCambio objTC = null;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_selectTipoCambio" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, fechaDia);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                objTC = new TipoCambio();
                
                objTC.setInt_idTipoCambio(rs.getInt(1));
                objTC.setDbl_precioCompraDolar(rs.getBigDecimal(2));
                objTC.setDbl_precioVentaDolar(rs.getBigDecimal(3));
                objTC.setStr_fechaDia(rs.getString(4));
                objTC.setStr_estado(rs.getString(5));
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
        
        return objTC;
    }

    @Override
    public List<TipoCambio> listarTipoCambio() {
        Connection cnn = null;
        List<TipoCambio> listaTipoCambio = new ArrayList<>();
        TipoCambio objTipoCambio = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarTipoCambio" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, Util.ACTIVO);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objTipoCambio = new TipoCambio();
                
                objTipoCambio.setInt_idTipoCambio(rs.getInt(1));
                objTipoCambio.setDbl_precioCompraDolar(rs.getBigDecimal(2));
                objTipoCambio.setDbl_precioVentaDolar(rs.getBigDecimal(3));
                objTipoCambio.setStr_fechaDia(rs.getString(4));
                objTipoCambio.setStr_estado(rs.getString(5));

                listaTipoCambio.add(objTipoCambio);
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
        
        return listaTipoCambio;
    }

}
