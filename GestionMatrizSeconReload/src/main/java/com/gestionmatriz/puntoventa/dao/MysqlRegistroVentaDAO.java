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

import com.gestionmatriz.puntoventa.bean.RegistroVenta;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;

/**
 *
 * @author zholo
 */
public class MysqlRegistroVentaDAO extends ConexionSqlSpring implements RegistroVentaDAO {

	private static final Logger log=Logger.getLogger(MysqlRegistroVentaDAO.class);
    @Override
    public List<RegistroVenta> listarRegistroVenta(String fechaInicial,String fechaFinal) {
        Connection cnn = null;
        List<RegistroVenta> listaRegistroVenta = new ArrayList<>();
        RegistroVenta objRegistroVenta = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_registroVentaSunat" + PrepararSQL.get(2);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, fechaInicial );
            ps.setString(2, fechaFinal); 
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objRegistroVenta = new RegistroVenta();                
                
                objRegistroVenta.setStr_idVenta(rs.getString(1));
                objRegistroVenta.setStr_importeTotalDoc(rs.getString(2));
                objRegistroVenta.setStr_igvIpm(rs.getString(3));
                objRegistroVenta.setStr_nroSerieDoc(rs.getString(4).substring(2, 5));
                objRegistroVenta.setStr_correlativoDoc(rs.getString(4).substring(6));
                objRegistroVenta.setStr_estadoDoc(rs.getString(5));
                objRegistroVenta.setStr_fechaEmision(rs.getString(6));
                objRegistroVenta.setStr_fechaPago(rs.getString(7));
                objRegistroVenta.setStr_razonSocial(rs.getString(9));
                objRegistroVenta.setStr_nroDocIdendidadCliente(rs.getString(10));
                objRegistroVenta.setStr_tipoComprobante(rs.getString(4));
                objRegistroVenta.setStr_baseImponibleOperacion(rs.getString(2));
                objRegistroVenta.setStr_importeTotalOpeInafecta(rs.getString(2));
                objRegistroVenta.setStr_importeTotalOpeExonerado(rs.getString(2));
                objRegistroVenta.setStr_sumaBoletas(rs.getString(13));
                objRegistroVenta.setStr_sumaFacturas(rs.getString(14));
                objRegistroVenta.setStr_sumaCreditos(rs.getString(15));
                objRegistroVenta.setStr_nombreCliente(rs.getString(11));
                objRegistroVenta.setStr_tipoVenta(rs.getString(12));
                
                
                
                
                
                listaRegistroVenta.add(objRegistroVenta);
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
        
        return listaRegistroVenta;
    }
    
}
