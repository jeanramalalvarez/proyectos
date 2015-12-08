/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

import com.gestionmatriz.recursoshumanos.bean.Config;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;

/**
 *
 * @author zholo
 */
public class MysqlConfigDAO extends ConexionSqlSpring implements ConfigDAO{

	private static final Logger log=Logger.getLogger(MysqlConfigDAO.class); 
    @Override
    public List<Config> listaConfig() {
        
        Connection cnn = null;
        List<Config> listaConfig = new ArrayList<>();
        Config objConfig = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarConfig" + PrepararSQL.get(0);
            PreparedStatement ps = cnn.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objConfig = new Config();
                
                objConfig.setInt_IdConfig(rs.getInt(1));
                objConfig.setInt_minutosAntes(rs.getInt(2));
                objConfig.setInt_minutosDespues(rs.getInt(3));
                objConfig.setDbl_igv(rs.getBigDecimal(4));
                objConfig.setDbl_uit(new BigDecimal(rs.getInt(5)) );
                objConfig.setTipoImpresion(rs.getString(6));
                objConfig.setStr_formatoTicket(rs.getString(7));
               

                listaConfig.add(objConfig);
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
        
        return listaConfig;
        
    }

    @Override
    public boolean modificarConfig(Config objConfig) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_updateConfig" + PrepararSQL.get(6);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, objConfig.getInt_IdConfig());
            ps.setInt(2, objConfig.getInt_minutosAntes());
            ps.setInt(3, objConfig.getInt_minutosDespues());
            ps.setBigDecimal(4, objConfig.getDbl_igv());
            ps.setBigDecimal(5, objConfig.getDbl_uit());
            ps.setString(6, objConfig.getTipoImpresion());
//            System.out.println("mysql---"+objConfig.getDbl_uit());
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
