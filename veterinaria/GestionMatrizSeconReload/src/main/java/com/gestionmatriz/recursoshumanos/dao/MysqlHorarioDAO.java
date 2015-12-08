/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.HorarioJornada;
import com.gestionmatriz.recursoshumanos.bean.Horarios;
import com.gestionmatriz.recursoshumanos.bean.Jornada;
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
 * @author zholo
 */
public class MysqlHorarioDAO extends ConexionSqlSpring implements HorarioDAO {

	private static final Logger log=Logger.getLogger(MysqlHorarioDAO.class); 
    @Override
    public List<Horarios> listarHorarios() {
        Connection cnn = null;

//        List<Horarios> listaHorarios = new ArrayList<Horarios>();
        List<Horarios> listaHorarios = new ArrayList<>();

        Horarios objHorarios = null;
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listaHorario" + PrepararSQL.get(0);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objHorarios = new Horarios();

                objHorarios.setInt_idHorario(rs.getInt(1));
                objHorarios.setStr_nombreHorario(rs.getString(2));
                objHorarios.setStr_estado(rs.getString(3));
                objHorarios.setDte_fechaCreacion(rs.getString(4));
                objHorarios.setStr_usuarioCreador(rs.getString(5));
                objHorarios.setDte_fechaModificacion(rs.getString(6));
                objHorarios.setStr_usuarioModifcador(rs.getString(7));

                listaHorarios.add(objHorarios);
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
        return listaHorarios;
    }

    @Override
    public List<Jornada> listarJornadas() {
        Connection cnn = null;

        List<Jornada> listaJornada = new ArrayList<>();
        Jornada objJornada = null;
        try {

            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_listaJornadas"
                    + PrepararSQL.get(0);


            PreparedStatement ps = cnn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                objJornada = new Jornada();

                objJornada.setInt_idJornada(rs.getInt(1));
                objJornada.setTme_HoraInicio(rs.getString(2));
                objJornada.setTme_horaFin(rs.getString(3));
                objJornada.setStr_estado(rs.getString(4));
                objJornada.setDte_fechaCreacion(rs.getString(5));
                objJornada.setStr_usuarioCreador(rs.getString(6));
                objJornada.setDte_fechaModificacion(rs.getString(7));
                objJornada.setStr_usuarioModificador(rs.getString(8));

                listaJornada.add(objJornada);

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
        return listaJornada;
    }

    public boolean registrarHorario(Jornada objJornada) {
        boolean respuesta = false;
        Connection cnn = null;

        try {

            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "CALL sp_insertJornada"
                    + PrepararSQL.get(4);


            PreparedStatement ps = cnn.prepareStatement(sql);


            ps.setString(1, objJornada.getTme_HoraInicio());
            ps.setString(2, objJornada.getTme_horaFin());
            ps.setString(3, objJornada.getStr_estado());
            ps.setString(4, objJornada.getStr_usuarioCreador());


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
    public boolean registrarHorarioJornada(List<HorarioJornada> objHorarioJornada) {
        boolean respuesta = false;
        Connection cnn = null;

        try {

            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "CALL sp_insertHorarioJornada"
                    + PrepararSQL.get(5);


            PreparedStatement ps;

            for (HorarioJornada hj : objHorarioJornada) {
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, hj.getInt_idHorario());
                ps.setInt(2, hj.getInt_idJornada());
                ps.setString(3, hj.getStr_estado());
                ps.setString(4, hj.getStr_usuarioCreador());
                ps.setString(5, hj.getStr_usuarioModificador());
                respuesta = ps.execute();
            }




            cnn.commit();
            respuesta = true;


        } catch (SQLException ex) {
            try {
                cnn.rollback();
                log.error("Error SQL: " + ex.getMessage());
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error SQL: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            try {
                cnn.rollback();
                log.error("Error: " + ex.getMessage());
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error SQL: " + ex1.getMessage());
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
    public List<HorarioJornada> listarHorarioJornada(String estado) {
        Connection cnn = null;

//        List<HorarioJornada> listaHorarioJornada = new ArrayList<HorarioJornada>();
        List<HorarioJornada> listaHorarioJornada = new ArrayList<>();
        HorarioJornada objHorarioJornada = null;
 
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarHorarioJornada" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, estado);
            ResultSet rs = ps.executeQuery();
            Jornada objJornada;
            Horarios objHorario;

            while (rs.next()) {
                objHorarioJornada = new HorarioJornada();

                objHorarioJornada.setInt_idHorario(rs.getInt(1));
                objHorarioJornada.setInt_idJornada(rs.getInt(2));
                objHorarioJornada.setStr_estado(rs.getString(3));
                objHorarioJornada.setDte_fechaCreacion(rs.getString(4));
                objHorarioJornada.setStr_usuarioCreador(rs.getString(5));
                objHorarioJornada.setDte_fechaModificacion(rs.getString(6));
                objHorarioJornada.setStr_usuarioModificador(rs.getString(7));

                objHorario = new Horarios();
                objHorario.setInt_idHorario(rs.getInt(8));
                objHorario.setStr_nombreHorario(rs.getString(9));
                objHorarioJornada.setObjHorario(objHorario);

                objJornada = new Jornada();
                objJornada.setInt_idJornada(rs.getInt(10));
                objJornada.setTme_HoraInicio(rs.getString(11));
                objJornada.setTme_horaFin(rs.getString(12));
                objHorarioJornada.setObjJornada(objJornada);

                listaHorarioJornada.add(objHorarioJornada);
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
        return listaHorarioJornada;
    }

    @Override
    public List<Jornada> listarJornadasDisponibles(int idHorario) {
        Connection cnn = null;

//	List<Jornada>listaJornadaDisponible = new ArrayList<Jornada>();
        List<Jornada> listaJornadaDisponible = new ArrayList<>();
        Jornada objJornada = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listaJornadasDisponibles" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, idHorario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objJornada = new Jornada();

                objJornada.setInt_idJornada(rs.getInt(1));
                objJornada.setTme_HoraInicio(rs.getString(2));
                objJornada.setTme_horaFin(rs.getString(3));
                objJornada.setStr_estado(rs.getString(4));
                objJornada.setDte_fechaCreacion(rs.getString(5));
                objJornada.setStr_usuarioCreador(rs.getString(6));
                objJornada.setDte_fechaModificacion(rs.getString(7));
                objJornada.setStr_usuarioModificador(rs.getString(8));

                listaJornadaDisponible.add(objJornada);
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
        return listaJornadaDisponible;
    }
}
