/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

import com.gestionmatriz.seguridad.bean.FuncionUsuario;
import com.gestionmatriz.seguridad.bean.Funciones;
import com.gestionmatriz.seguridad.bean.Usuario;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;
import com.gestionmatriz.util.Util;

/**
 *
 * @author YESM
 */
public class MysqlFuncionUsuarioDAO extends ConexionSqlSpring implements FuncionUsuarioDAO {

	private static final Logger log=Logger.getLogger(MysqlFuncionUsuarioDAO.class);
    @Override
    public List<FuncionUsuario> listaFuncionesXUsuario(int usuario) {
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FuncionUsuario> listaFuncionesUsuario = new ArrayList<>();
        FuncionUsuario objFuncionesUsuario = null;
        Funciones objFunciones = null;
        Usuario objUsuario = null;
//        Personal objPersona = null;
        
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_listarFuncionesXUsuario " + PrepararSQL.get(2);
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, usuario);
            ps.setString(2, Util.ACTIVO);
            rs = ps.executeQuery();

            while (rs.next()) {
                objFuncionesUsuario = new FuncionUsuario();
                objUsuario = new Usuario();
                objFunciones = new Funciones();
                
                objUsuario.setInt_idUsuario(rs.getInt(1));
                objUsuario.setInt_idPersona(rs.getInt(2));
                objUsuario.setStr_usuario(rs.getString(3));
                objFuncionesUsuario.setObjUsuario(objUsuario);
                
                objFunciones.setInt_idFunciones(rs.getInt(4));
                objFunciones.setStr_rol(rs.getString(5));
                objFunciones.setInt_modulo(rs.getInt(6));
                objFunciones.setStr_key(rs.getString(7));
                objFuncionesUsuario.setObjFunciones(objFunciones);
                
                listaFuncionesUsuario.add(objFuncionesUsuario);
            }
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
        
        return listaFuncionesUsuario;
    }

    @Override
    public boolean desactivarFuncionesUsuario(int usuario) {
        boolean respuesta = true;
        Connection cnn = null;
        PreparedStatement ps = null;
        
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "sp_desactivaFunciones ".concat(PrepararSQL.get(2));
//            for (Funciones funciones : listaFunciones) {
            ps = cnn.prepareStatement(sql);
//                  ps.setInt(1, funciones.getInt_idFunciones());
            ps.setInt(1, usuario);
            ps.setString(2, Util.HISTORICO);
            ps.execute();
//                  ps=null;
//            }
            cnn.commit();
            respuesta = true;
        } catch (SQLException ex) {
            try {
                log.error("Error: " + ex.getMessage());
                respuesta = false;
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } catch (Exception ex) {

            try {
                log.error("Error: " + ex.getMessage());
                respuesta = false;
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }

        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error: " + ex.getMessage());
            }
        }

        return respuesta;
    }
    
}
