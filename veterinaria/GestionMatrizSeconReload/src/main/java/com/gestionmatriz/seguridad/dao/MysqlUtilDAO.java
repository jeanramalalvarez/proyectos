/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.dao;

import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import org.apache.log4j.Logger;

/**
 *
 * @author YESM
 */
public class MysqlUtilDAO extends ConexionSqlSpring implements UtilMysqlDAO {

	private static final Logger log=Logger.getLogger(MysqlUtilDAO.class);
	@Override
    public String getFechaMysql() {
        Connection cnn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql;
        String str_fecha = "";

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            sql = "call sp_fechaHoraMysql";
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                str_fecha = rs.getString(1);
            }
            
            rs = null;
            ps = null;
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

        return str_fecha;
    }
}
