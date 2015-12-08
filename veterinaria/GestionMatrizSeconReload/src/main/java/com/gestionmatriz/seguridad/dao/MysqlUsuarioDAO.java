/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.dao;

import com.gestionmatriz.config.services.KeyService_I;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.seguridad.bean.Funciones;
import com.gestionmatriz.seguridad.bean.Usuario;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.EncriptionSource;
import com.gestionmatriz.util.FunctionByte;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;
import com.gestionmatriz.util.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

/**
 *
 * @author YESM
 */
public class MysqlUsuarioDAO extends ConexionSqlSpring implements UsuarioDAO {

	private static final Logger log=Logger.getLogger(MysqlUsuarioDAO.class);
	private KeyService_I objKey_I;

    @Override
    public Usuario validarUsuario(String str_usuario, String str_password)
            throws SQLException {
        //Creamos objeto para retornar datos de usuario
        Usuario objUsuario = new Usuario();
        Connection cnn = null;
        try {
            //Variable para Encriptar
            EncriptionSource objEncriptador = new EncriptionSource();

            //Atributos para la desencriptacion
            objKey_I = PaqueteBusinessDelegate.getKeyService();

            //Abrimos una conexiona 
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_validarUsuario(?,?)";

            PreparedStatement ps = cnn.prepareStatement(sql);

            byte[] llave = FunctionByte.hex2byte(objKey_I.getKey().getKey());
            String str_password_encryptado = FunctionByte.toHEX1(
                    objEncriptador.Encrypt(llave, str_password));

            ps.setString(1, str_usuario);

            ps.setString(2, str_password_encryptado);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                objUsuario.setInt_idUsuario(rs.getInt("int_idUsuario"));
                objUsuario.setInt_idPersona(rs.getInt("int_idPersona"));
                objUsuario.setStr_usuario(rs.getString("str_usuario"));
                objUsuario.setStr_contrasenia(rs.getString("str_contrasenia"));
                objUsuario.setStr_codigoPersona(rs.getString("str_codigoPersona"));
                ConexionSql.cerrarConexion(cnn);
                return objUsuario;
            }


        } catch (ParserConfigurationException ex) {
            log.error("Error en validarUsuario: " + ex.getMessage());
        } catch (SAXException ex) {
            log.error("Error en validarUsuario: " + ex.getMessage());
        } catch (IOException ex) {
            log.error("Error en validarUsuario: " + ex.getMessage());
        }finally{
        	try{
        		cnn.close();
        	}catch(Exception e){
        		log.error("ERROR: "+e.getMessage());
        	}
        }
        return null;
    }

    @Override
    public boolean registrarUsuario(Usuario objUsuario, List<Funciones> listaFunciones, int puntero, int usuario) {
        boolean respuesta = false;
        Connection cnn = null;
        ResultSet rs = null;
        try {

            //Variable para Encriptar
            EncriptionSource objEncriptador = new EncriptionSource();

            //Atributos para la desencriptacion
            objKey_I = PaqueteBusinessDelegate.getKeyService();

            byte[] keyb = FunctionByte.hex2byte(objKey_I.getKey().getKey());
            String claveEncruptada = FunctionByte.toHEX1(
                    objEncriptador.Encrypt(keyb, objUsuario.getStr_contrasenia()));
            objUsuario.setStr_contrasenia(claveEncruptada);
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            String sql;
            PreparedStatement ps = null;

            if (puntero == 0) {
                sql = "CALL sp_insertUsuario"
                        + PrepararSQL.get(8);


                ps = cnn.prepareStatement(sql);

                ps.setInt(1, objUsuario.getInt_idPersona());
                ps.setString(2, objUsuario.getStr_usuario());
                ps.setString(3, objUsuario.getStr_contrasenia());
                ps.setString(4, objUsuario.getStr_estado());
                ps.setString(5, objUsuario.getStr_usuarioCreador());
                ps.setString(6, objUsuario.getDte_fechaModificacion());
                ps.setString(7, objUsuario.getStr_usuarioModificador());
                ps.setString(8, objUsuario.getStr_codigoPersona());

                ps.execute();

//                int idUsuario=-1;
                rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
                usuario = -1;
                while (rs.next()) {
                    usuario = rs.getInt(1);
                }

                if (usuario == -1) {

                    respuesta = false;
                    throw new SQLException();
                }
            }





            /*Desactiva todas las funciones que pueda tener el usuario*/
            sql = "call sp_desactivaFunciones ".concat(PrepararSQL.get(2));

            ps = cnn.prepareStatement(sql);


            ps.setInt(1, usuario);
            ps.setString(2, Util.HISTORICO);

            ps.execute();

            ps = null;


            sql = "call sp_insertFuncionUsuario " + PrepararSQL.get(4);

            for (Funciones fu : listaFunciones) {
                ps = cnn.prepareStatement(sql);

                ps.setInt(1, fu.getInt_idFunciones());
                ps.setInt(2, usuario);
                ps.setString(3, objUsuario.getStr_usuarioCreador());
                ps.setString(4, com.gestionmatriz.util.Util.ACTIVO);

                ps.execute();
                ps = null;
            }
            cnn.commit();
            respuesta = true;


        } catch (SQLException ex) {
            try {
                log.error("Error SQL: " + ex.getMessage());
                cnn.rollback();
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            try {
                log.error("Error: " + ex.getMessage());
                cnn.rollback();
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } finally {
            try {

                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                try {
                    cnn.rollback();
                    log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
                } catch (SQLException ex1) {
                    log.error("Error en el RollBack " + ex1.getMessage());
                }
            }
        }

        return respuesta;
    }

    @Override
    public Usuario consultarUsuarioXPersona(String persona) {

        Connection cnn = null;
        PreparedStatement ps = null;
        Usuario objUsuario = null;
        ResultSet rs = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_consultaUsuarioPorPersona" + PrepararSQL.get(2);

            ps = cnn.prepareStatement(sql);

            ps.setString(1, persona);
            ps.setString(2, com.gestionmatriz.util.Util.ACTIVO);


            rs = ps.executeQuery();

            if (rs.next()) {
                objUsuario = new Usuario();

                objUsuario.setInt_idUsuario(rs.getInt(1));
                objUsuario.setInt_idPersona(rs.getInt(2));
                objUsuario.setStr_usuario(rs.getString(3));
                objUsuario.setStr_contrasenia(rs.getString(4));
                objUsuario.setStr_estado(rs.getString(5));
            }


        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error : " + ex.getMessage());
            }
        }
        return objUsuario;
    }

    @Override
    public boolean modificarcontrasenia(int idUsuario, String constrasenia) {

        boolean respuesta = true;
        Connection cnn = null;
        PreparedStatement ps = null;

        try {


            //Variable para Encriptar
            EncriptionSource objEncriptador = new EncriptionSource();

            //Atributos para la desencriptacion
            objKey_I = PaqueteBusinessDelegate.getKeyService();

            byte[] keyb = FunctionByte.hex2byte(objKey_I.getKey().getKey());
            String claveEncruptada = FunctionByte.toHEX1(
                    objEncriptador.Encrypt(keyb, constrasenia));
            constrasenia = claveEncruptada;

            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "call sp_modificarContrasenia ".concat(PrepararSQL.get(2));

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, idUsuario);
            ps.setString(2, constrasenia);

            ps.execute();

            cnn.commit();
            respuesta = true;
        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
            try {
                respuesta = false;
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
            try {
                respuesta = false;
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error : " + ex.getMessage());
            }
        }
        return respuesta;
    }

    @Override
    public int logeoInicial(String usuario) {
        int cont = -1;
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "call sp_selectLogeo ".concat(PrepararSQL.get(1));
            ps = cnn.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                cont = 1;
            }
        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error:" + ex.getMessage());
            }
        }

        return cont;
    }

    @Override
    public boolean insertLogoe(String usuario) {
        boolean respuesta = false;
        Connection cnn = null;
        PreparedStatement ps = null;
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "call sp_insertLogeo ".concat(PrepararSQL.get(2));

            ps = cnn.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, Util.ACTIVO);

            ps.execute();

            respuesta = true;
            ps = null;

        } catch (SQLException ex) {
            try {
                log.error("Error: " + ex.getMessage());
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            try {
                log.error("Error: " + ex.getMessage());
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

    @Override
    public Usuario consultarIdUsuario(String strUsuario) {
        Connection cnn = null;
        PreparedStatement ps = null;
        Usuario objUsuario = null;
        ResultSet rs = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_selectIdUsuario" + PrepararSQL.get(1);

            ps = cnn.prepareStatement(sql);

            ps.setString(1, strUsuario);



            rs = ps.executeQuery();

            if (rs.next()) {
                objUsuario = new Usuario();

                objUsuario.setInt_idUsuario(rs.getInt(1));
                objUsuario.setStr_contrasenia(rs.getString(2));
            }

        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error : " + ex.getMessage());
            }
        }
        return objUsuario;
    }
}
