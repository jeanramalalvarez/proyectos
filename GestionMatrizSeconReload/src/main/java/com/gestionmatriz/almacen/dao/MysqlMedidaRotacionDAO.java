/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.MedidaRotacion;
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
 * @author cesareo
 */
public class MysqlMedidaRotacionDAO extends ConexionSqlSpring implements MedidaRotacionDAO {

	private static final Logger log=Logger.getLogger(MysqlMedidaRotacionDAO.class);
    @Override
    public List<MedidaRotacion> listarMR() {
        Connection cnn = null;
        List<MedidaRotacion> listaMR = new ArrayList<>();
        MedidaRotacion objMR = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarMedidaRotacion" + PrepararSQL.get(1);
            ps = cnn.prepareStatement(sql);
            ps.setString(1, Util.ACTIVO);
            rs = ps.executeQuery();

            while (rs.next()) {
                objMR = new MedidaRotacion();
                
                objMR.setInt_idMedidaRotacion(rs.getInt(1));
                objMR.setStr_codigoMR(rs.getString(2));
                objMR.setStr_nombreMR(rs.getString(3));
                objMR.setDbl_utilidad(rs.getBigDecimal(4));
                objMR.setDbl_adicional(rs.getBigDecimal(5));
                objMR.setStr_descripcionMR(rs.getString(6));
                objMR.setStr_estado(rs.getString(7));

                listaMR.add(objMR);
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
        
        return listaMR;
    }

    @Override
    public boolean modificarMR(MedidaRotacion objMR) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_updateMedidaRotacion" + PrepararSQL.get(6);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, objMR.getInt_idMedidaRotacion());
            ps.setString(2, objMR.getStr_codigoMR());
            ps.setBigDecimal(3, objMR.getDbl_utilidad());
            ps.setBigDecimal(4, objMR.getDbl_adicional());
            ps.setString(5, objMR.getStr_descripcionMR());
            ps.setString(6, objMR.getStr_usuarioModificador());

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
