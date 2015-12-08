/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.dao;

import com.gestionmatriz.almacen.gui.GestionPrecioOferta;
import com.gestionmatriz.contabilidad.bean.Cuentas;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.util.PrepararSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 *
 * @author zholo
 */
public class MysqlCuentasDAO implements CuentasDAO{

	private static final Logger log=Logger.getLogger(GestionPrecioOferta.class);
    @Override
    public List<Cuentas> listarCuentas(int idElemento) {
      
        Connection cnn = null;
        List<Cuentas> listaCuentas= new ArrayList<>();
        Cuentas objCuentas = null;

        try {
            cnn = ConexionSql.getConexion();
            String sql = "CALL sp_listarCuentas" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, idElemento);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objCuentas = new Cuentas();
                
                objCuentas.setInt_idCuentas(rs.getInt(1));
                objCuentas.setInt_idElemento(rs.getInt(2));
                objCuentas.setInt_nroCuenta(rs.getInt(3));
                objCuentas.setStr_descripcion(rs.getString(4));
                objCuentas.setStr_debe(rs.getString(5));
                objCuentas.setStr_haber(rs.getString(6));
                objCuentas.setStr_tipo(rs.getString(7));
                objCuentas.setStr_analisis(rs.getString(8));      
                objCuentas.setStr_estado(rs.getString(9));
                objCuentas.setDte_fechaCreacion(rs.getString(10));
                objCuentas.setStr_usuarioCreador(rs.getString(11));
                objCuentas.setDte_fechaModificacion(rs.getString(12));
                objCuentas.setStr_usuarioModificador(rs.getString(13));
                
                

                listaCuentas.add(objCuentas);
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
        
        return listaCuentas;
    
    }

    @Override
    public boolean registrarCuenta(Cuentas objCuenta) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = ConexionSql.getConexion();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_insertCuenta" + PrepararSQL.get(9);
            PreparedStatement ps = cnn.prepareStatement(sql);
            
            ps.setInt(1, objCuenta.getInt_idElemento());
            ps.setInt(2, objCuenta.getInt_nroCuenta());
            ps.setString(3, objCuenta.getStr_descripcion());
            ps.setString(4, objCuenta.getStr_debe());
            ps.setString(5, objCuenta.getStr_haber());
            ps.setString(6, objCuenta.getStr_tipo());
            ps.setString(7, objCuenta.getStr_analisis());
            ps.setString(8, objCuenta.getStr_estado());
            ps.setString(9, objCuenta.getStr_usuarioCreador());

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
