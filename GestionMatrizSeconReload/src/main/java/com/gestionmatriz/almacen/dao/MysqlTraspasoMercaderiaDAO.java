/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.TraspasoMercaderia;
import com.gestionmatriz.puntoventa.bean.GuiaRemision;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;

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
 * @author jarcon
 */
public class MysqlTraspasoMercaderiaDAO extends ConexionSqlSpring implements TraspasoMercaderiaDAO{

	private static final Logger log=Logger.getLogger(MysqlTraspasoMercaderiaDAO.class);
    @Override
    public boolean registrarTraspaso(TraspasoMercaderia objTraspasoMercaderia) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_insertTraspasoMercaderia" + PrepararSQL.get(4);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, objTraspasoMercaderia.getInt_idGuiaRemision());
            ps.setString(2, objTraspasoMercaderia.getStr_codigoAutoriza());
//            ps.setString(3, objTraspasoMercaderia.getStr_codigoConfirma());
//            ps.setString(4, objTraspasoMercaderia.getDte_fechaAutoriza());
//            ps.setString(5, objTraspasoMercaderia.getDte_fechaConfirma());
            ps.setString(3, objTraspasoMercaderia.getStr_estado());
            ps.setString(4, objTraspasoMercaderia.getStr_usuarioCreador());
//            ps.setString(8, objTraspasoMercaderia.getDte_fechaCreacion());
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
    public boolean confirmarTraspaso(TraspasoMercaderia objTraspasoMercaderia) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            String sql = "CALL sp_updateTraspasoMercaderia" + PrepararSQL.get(4);
            PreparedStatement ps = cnn.prepareStatement(sql);
            
            ps.setInt(1, objTraspasoMercaderia.getInt_idTraspasoInterno());
            ps.setString(2, objTraspasoMercaderia.getStr_codigoConfirma());
            ps.setString(3, objTraspasoMercaderia.getStr_estado());
            ps.setString(4, objTraspasoMercaderia.getStr_usuarioModificador());
//            ps.setString(8, objTraspasoMercaderia.getDte_fechaCreacion());

            respuesta = ps.execute();
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
    public List<TraspasoMercaderia> listarTraspasoMercaderia(String codAutoriza, 
                                                String fchAutoriza, String estado,String local) {
        Connection cnn = null;

        List<TraspasoMercaderia> listaTraspaso = new ArrayList<>();
        TraspasoMercaderia objTraspasoMercaderia = null;
        GuiaRemision objGuiaRemision =null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            
            String sql = "CALL sp_listarTraspasos" + PrepararSQL.get(4);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, codAutoriza);
            //ps.setString(2, codConfirma);
            ps.setString(2, fchAutoriza);
            //ps.setString(4, fchConfirma);
            ps.setString(3, estado);
            ps.setString(4, local);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objTraspasoMercaderia = new TraspasoMercaderia();
                objGuiaRemision=new GuiaRemision();
                
                objTraspasoMercaderia.setInt_idTraspasoInterno(rs.getInt(1));
                objTraspasoMercaderia.setInt_idGuiaRemision(rs.getInt(2));
                objTraspasoMercaderia.setStr_codigoAutoriza(rs.getString(3));
                objTraspasoMercaderia.setStr_codigoConfirma(rs.getString(4));
                objTraspasoMercaderia.setDte_fechaAutoriza(rs.getString(5));
                objTraspasoMercaderia.setDte_fechaConfirma(rs.getString(6));
                objTraspasoMercaderia.setStr_estado(rs.getString(7));
                objTraspasoMercaderia.setStr_usuarioCreador(rs.getString(8));
                objTraspasoMercaderia.setDte_fechaCreacion(rs.getString(9));
                objTraspasoMercaderia.setStr_usuarioModificador(rs.getString(10));
                objTraspasoMercaderia.setDte_fechaModificacion(rs.getString(11));
                objGuiaRemision.setStr_localLlegada(rs.getString(12));
                
                objTraspasoMercaderia.setObjGuiaRemision(objGuiaRemision);
                
                listaTraspaso.add(objTraspasoMercaderia);
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
        return listaTraspaso;
    }
    
}
