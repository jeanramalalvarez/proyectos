/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.dao;

import com.gestionmatriz.almacen.gui.GestionPrecioOferta;
import com.gestionmatriz.contabilidad.bean.Elemento;
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
public class MysqlElementoDAO implements ElementoDAO{

	private static final Logger log=Logger.getLogger(GestionPrecioOferta.class);
    @Override
    public List<Elemento> listarElementos() {
         Connection cnn = null;
        List<Elemento> listaElementos= new ArrayList<>();
        Elemento objElemento = null;

        try {
            cnn = ConexionSql.getConexion();
            String sql = "CALL sp_listarElementos" + PrepararSQL.get(0);
            PreparedStatement ps = cnn.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objElemento = new Elemento();
                
                objElemento.setInt_idElemento(rs.getInt(1));
                objElemento.setStr_elemento(rs.getString(2));
                objElemento.setStr_descripcion(rs.getString(3));
                objElemento.setStr_estado(rs.getString(4));
                objElemento.setDte_fechaCreacion(rs.getString(5));
                objElemento.setStr_usuarioCreador(rs.getString(6));
                objElemento.setDte_fechaModificacion(rs.getString(7));
                objElemento.setStr_usuarioModificador(rs.getString(8));
                
                

                listaElementos.add(objElemento);
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
        
        return listaElementos;
    }

    @Override
    public boolean registrarElemento(Elemento objElemento) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = ConexionSql.getConexion();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_insertElemento" + PrepararSQL.get(4);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, objElemento.getStr_elemento());
            ps.setString(2, objElemento.getStr_descripcion());
            ps.setString(3, objElemento.getStr_estado());
            ps.setString(4, objElemento.getStr_usuarioCreador());

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
    public boolean actualizarElemento(Elemento objElemento) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = ConexionSql.getConexion();
            cnn.setAutoCommit(false);
            
            String sql = "CALL sp_updateElemento" + PrepararSQL.get(3);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, objElemento.getInt_idElemento());
            ps.setString(2, objElemento.getStr_estado());            
            ps.setString(3, objElemento.getStr_usuarioModificador());

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
    
}
