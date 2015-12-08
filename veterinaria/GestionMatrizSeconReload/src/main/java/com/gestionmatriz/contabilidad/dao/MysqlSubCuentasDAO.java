/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.dao;

import com.gestionmatriz.almacen.gui.GestionPrecioOferta;
import com.gestionmatriz.contabilidad.bean.SubCuentas;
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
public class MysqlSubCuentasDAO implements SubCuentasDAO{

	private static final Logger log=Logger.getLogger(GestionPrecioOferta.class);
    @Override
    public List<SubCuentas> listarSubCuentas(int idCuenta) {
        Connection cnn = null;
        List<SubCuentas> listaSubCuentas= new ArrayList<>();
        SubCuentas objSubCuentas = null;
      
        try {
            cnn = ConexionSql.getConexion();
            String sql = "CALL sp_listarSubCuentas" + PrepararSQL.get(1);
            
            PreparedStatement ps = cnn.prepareStatement(sql);
            
            ps.setInt(1, idCuenta);
            
            ResultSet rs = ps.executeQuery();
            

            while (rs.next()) {
                objSubCuentas = new SubCuentas();
                
                objSubCuentas.setInt_idSubcuentas(rs.getInt(1));
                objSubCuentas.setInt_idCuentas(rs.getInt(2));
                objSubCuentas.setInt_nroSubcuentas(rs.getInt(3));
                objSubCuentas.setStr_descripcion(rs.getString(4));
                objSubCuentas.setStr_debe(rs.getString(5));
                objSubCuentas.setStr_haber(rs.getString(6));
                objSubCuentas.setStr_tipo(rs.getString(7));
                objSubCuentas.setStr_analisis(rs.getString(8));      
                objSubCuentas.setStr_estado(rs.getString(9));
                objSubCuentas.setDte_fechaCreacion(rs.getString(10));
                objSubCuentas.setStr_usuarioCreador(rs.getString(11));
                objSubCuentas.setDte_fechaModificacion(rs.getString(12));
                objSubCuentas.setStr_usuarioModificador(rs.getString(13));
                
                

                listaSubCuentas.add(objSubCuentas);
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
        
        return listaSubCuentas;
    }
    
}
