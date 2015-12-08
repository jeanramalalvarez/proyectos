/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.dao;

import com.gestionmatriz.puntoventa.bean.Impresora;
import com.gestionmatriz.recursoshumanos.bean.Local;
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
 * @author pc
 */
public class MysqlImpresoraDAO extends ConexionSqlSpring implements ImpresoraDAO{

    private static final Logger log=Logger.getLogger(MysqlImpresoraDAO.class);
    @Override
    public List<Impresora> listarImpresora(Impresora objImpresora) {
         Connection cnn = null;
         List<Impresora> listaImpresoras = new ArrayList<>();
         Impresora impresora ;
          try {
               cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?ConexionSql.getConexion():this.getDataSource().getConnection();
               String sql = "CALL sp_buscarImpresora" + PrepararSQL.get(5);
               PreparedStatement ps = cnn.prepareStatement(sql);
               ps.setString(1, objImpresora.getObjLocal()==null?"":(""+objImpresora.getObjLocal().getInt_idLocal()).trim());
               ps.setString(2, objImpresora.getStr_marca());
               ps.setString(3, objImpresora.getStr_modelo());
               ps.setString(4, objImpresora.getStr_NumeroSerie());
               ps.setString(5, objImpresora.getStr_estado());
               ResultSet rs = ps.executeQuery();
               while (rs.next()) {
                   impresora = new Impresora();
                   impresora.setInt_impresora(rs.getInt(1));
                   impresora.setStr_nombre(rs.getString(2));
                   impresora.setObjLocal(new Local(rs.getString(3)));
                   impresora.setStr_marca(rs.getString(4));
                   impresora.setStr_modelo(rs.getString(5));
                   impresora.setStrNumeroSerie(rs.getString(6));
                   impresora.setStr_estado(rs.getString(7));
                   listaImpresoras.add(impresora);
               }
          }catch (SQLException ex) {
            log.error("Error SQL: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
            }
        }
         return listaImpresoras;
    }

    @Override
    public boolean registrarImpresora(Impresora objImpresora) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;
         try {
             cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            
            sql = "CALL sp_nuevaImpresora" + PrepararSQL.get(7);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objImpresora.getObjLocal().getInt_idLocal());
            ps.setString(2, objImpresora.getStr_marca());
            ps.setString(3, objImpresora.getStr_modelo());
            ps.setString(4, objImpresora.getStr_NumeroSerie());
            ps.setString(5, objImpresora.getStr_usuarioCreador());
            ps.setString(6, objImpresora.getStr_estado());
            ps.setString(7, objImpresora.getStr_nombre());
            ps.execute();
            cnn.commit();
            ResultSet rs = ps.getResultSet();
            if (rs.next()){
                if (rs.getString(1).equals(Constantes.RESULTSET_OK)){
                    respuesta = true;
                }else{
                    respuesta = false;
                }
            }
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
    public boolean actualizarImpresora(Impresora objImpresora) {
        boolean respuesta = true;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;
        
        try{
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            sql = "CALL sp_actualizarImpresora" + PrepararSQL.get(7);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objImpresora.getInt_impresora());
            ps.setString(2, objImpresora.getStr_nombre());
            ps.setString(3, objImpresora.getStr_marca());
            ps.setString(4, objImpresora.getStr_modelo());
            ps.setString(5, objImpresora.getStr_NumeroSerie());
            ps.setString(6, objImpresora.getStr_usuarioCreador());
            ps.setString(7, objImpresora.getStr_estado());
            if (ps.executeUpdate()>0){
                respuesta = true;
            }else{
                respuesta = false;
            }
            cnn.commit();
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
