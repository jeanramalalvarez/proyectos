/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.Pension;
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
 * @author cesareots
 */
public class MysqlPensionDAO extends ConexionSqlSpring implements PensionDAO {

	private static final Logger log=Logger.getLogger(MysqlPensionDAO.class); 
    @Override
    public boolean registrarPension(Pension objPension) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            sql = "CALL sp_insertarPension".concat(PrepararSQL.get(7));
            ps = cnn.prepareStatement(sql);
            ps.setString(1, objPension.getStr_nombre());
            ps.setBigDecimal(2, objPension.getDbl_pension());
            ps.setBigDecimal(3, objPension.getDbl_seguro());
            ps.setBigDecimal(4, objPension.getDbl_comision());
            ps.setBigDecimal(5, objPension.getDbl_total());
            ps.setString(6, objPension.getStr_estado());
            ps.setString(7, objPension.getStr_usuarioCreador());
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
    public List<Pension> listaPension() {
        Connection cnn = null;
        List<Pension> listaPension = new ArrayList<>();
        Pension objPension = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarPension".concat(PrepararSQL.get(1));
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, Util.ACTIVO);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objPension = new Pension();
                objPension.setInt_idPension(rs.getInt(1));
                objPension.setStr_nombre(rs.getString(2));
                objPension.setDbl_pension(rs.getBigDecimal(3));
                objPension.setDbl_seguro(rs.getBigDecimal(4));
                objPension.setDbl_comision(rs.getBigDecimal(5));
                objPension.setDbl_total(rs.getBigDecimal(6));
                objPension.setStr_estado(rs.getString(7));

                listaPension.add(objPension);
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

        return listaPension;
    }

    @Override
    public boolean modificarPension(Pension objPension) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            sql = "CALL sp_modificarPension".concat(PrepararSQL.get(7));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objPension.getInt_idPension());
            ps.setString(2, objPension.getStr_nombre());
            ps.setBigDecimal(3, objPension.getDbl_pension());
            ps.setBigDecimal(4, objPension.getDbl_seguro());
            ps.setBigDecimal(5, objPension.getDbl_comision());
            ps.setBigDecimal(6, objPension.getDbl_total());
            ps.setString(7, objPension.getStr_usuarioModificador());
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
}
