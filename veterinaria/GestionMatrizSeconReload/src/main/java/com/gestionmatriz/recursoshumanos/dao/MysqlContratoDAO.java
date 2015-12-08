/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.Contrato;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornada;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornadaContrato;
import com.gestionmatriz.recursoshumanos.bean.Horarios;
import com.gestionmatriz.recursoshumanos.bean.Jornada;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.recursoshumanos.bean.TipoContrato;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.PrepararSQL;
import com.gestionmatriz.util.Util;

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
public class MysqlContratoDAO extends ConexionSqlSpring implements ContratoDAO {

	private static final Logger log=Logger.getLogger(MysqlContratoDAO.class); 
	public static final int QUERYRENOVAR = 1;
    public static final int QUERYCONSULTA = 2;
    public static final int ALLCONTRATOS = 3;

    @Override
    public Empresa buscarEmpresa(int idEmpresa) {
        Connection cnn = null;

        Empresa objEmpresa = new Empresa();

        try {

            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_buscarEmpresa"
                    + PrepararSQL.get(1);


            PreparedStatement ps = cnn.prepareStatement(sql);


            ps.setInt(1, idEmpresa);


            ResultSet rs = ps.executeQuery();



            objEmpresa.setInt_idEmpresa(rs.getInt(1));
            objEmpresa.setStr_razonSocial(rs.getString(2));
            objEmpresa.setStr_ruc(rs.getString(3));
            objEmpresa.setStr_representanteLegal(rs.getString(4));
            objEmpresa.setStr_dniRepresentante(rs.getString(5));
            objEmpresa.setStr_estado(rs.getString(6));
            objEmpresa.setDte_fechaCreacion(rs.getString(7));
            objEmpresa.setStr_usuarioCreador(rs.getString(8));
            objEmpresa.setDte_fechaModificacion(rs.getString(9));
            objEmpresa.setStr_usuarioModificador(rs.getString(10));

        } catch (SQLException ex) {
            log.error("Error SQL: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
            }
        }
        return objEmpresa;

    }

    @Override
    public List<Empresa> listarEmpresa() {
        Connection cnn = null;

        List<Empresa> listaEmpresa = new ArrayList<>();
        Empresa objEmpresa = null;
        try {

            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_listaEmpresa"
                    + PrepararSQL.get(0);


            PreparedStatement ps = cnn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                objEmpresa = new Empresa();

                objEmpresa.setInt_idEmpresa(rs.getInt(1));
                objEmpresa.setStr_razonSocial(rs.getString(2));
                objEmpresa.setStr_ruc(rs.getString(3));
                objEmpresa.setStr_domicilioEmpresa(rs.getString(4));
                objEmpresa.setStr_representanteLegal(rs.getString(5));
                objEmpresa.setStr_dniRepresentante(rs.getString(6));
                objEmpresa.setStr_estado(rs.getString(7));
                objEmpresa.setDte_fechaCreacion(rs.getString(8));
                objEmpresa.setStr_usuarioCreador(rs.getString(9));
                objEmpresa.setDte_fechaModificacion(rs.getString(10));
                objEmpresa.setStr_usuarioModificador(rs.getString(11));

                listaEmpresa.add(objEmpresa);

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
        return listaEmpresa;
    }

    @Override
    public List<TipoContrato> listatipoContrato() {
        Connection cnn = null;

        List<TipoContrato> listaTipoContrato = new ArrayList<>();
        TipoContrato objTipoContrato = null;
        try {

            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_listaTipoContrato"
                    + PrepararSQL.get(0);


            PreparedStatement ps = cnn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                objTipoContrato = new TipoContrato();

                objTipoContrato.setInt_idTipoContrato(rs.getInt(1));
                objTipoContrato.setStr_tipoContrato(rs.getString(2));
                objTipoContrato.setStr_nombreReporte(rs.getString(3));
                objTipoContrato.setStr_estado(rs.getString(4));
                objTipoContrato.setDte_fechaCreacion(rs.getString(5));
                objTipoContrato.setStr_usuarioCreador(rs.getString(6));
                objTipoContrato.setDte_fechaModificacion(rs.getString(7));
                objTipoContrato.setStr_usuarioModificador(rs.getString(8));

                listaTipoContrato.add(objTipoContrato);

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
        return listaTipoContrato;
    }

    @Override
    public boolean registrarContrato(Contrato objContrato, List<HorarioJornada> listaHorarioJornada) {
        boolean respuesta = false;

        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql;
            PreparedStatement ps;
            ResultSet rs;
            //Determinamos si existe contrato para la persona con estado Activo
            sql = "call sp_exiteContrato".concat(PrepararSQL.get(2));

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, objContrato.getInt_idPersona());
            ps.setString(2, Util.ACTIVO);

            rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getInt(1) > 0) {
                    Mensaje.mensaje("Persona ya cuenta con un contrato ACTIVO", Mensaje.TITULO_ME, Mensaje.ERROR);
                    throw new SQLException("Error Provocado por Validación");
                }
            }


            //Registramon el contrato
            ps = null;
            rs = null;
            sql = "call sp_insertContrato".concat(PrepararSQL.get(9));

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, objContrato.getInt_idPersona());
            ps.setInt(2, objContrato.getInt_idTipoContrato());
            ps.setInt(3, objContrato.getInt_idEmpresa());
            ps.setString(4, objContrato.getDte_fechaInicial());
            ps.setString(5, objContrato.getDte_fechaFinal());
            ps.setBigDecimal(6, objContrato.getDbl_sueldo());
            ps.setString(7, objContrato.getStr_estado());
            ps.setString(8, objContrato.getStr_usuarioCreador());
            ps.setInt(9, objContrato.getInt_local());
//            ps.setString(10, objContrato.getStr_codigoPersona());

            ps.execute();


            int idContrato = -1;
            rs = ps.executeQuery("SELECT LAST_INSERT_ID()");

            while (rs.next()) {
                idContrato = rs.getInt(1);
            }

            if (idContrato == -1) {

                respuesta = false;
                throw new SQLException();
            }


            sql = "call sp_insertHorarioJornadaContratol ".concat(PrepararSQL.get(5));

            for (HorarioJornada hj : listaHorarioJornada) {
                ps = cnn.prepareStatement(sql);

                ps.setInt(1, hj.getObjHorario().getInt_idHorario());
                ps.setInt(2, hj.getObjJornada().getInt_idJornada());
                ps.setInt(3, idContrato);
//                System.out.println(hj.getInt_idHorario()+"-"+hj.getInt_idJornada()+"-"+idContrato);
                ps.setString(4, Util.ACTIVO);
                ps.setString(5, objContrato.getStr_usuarioCreador());


                ps.execute();
                ps = null;
            }


            cnn.commit();
            respuesta = true;
        } catch (SQLException ex) {
            try {
                log.error("Error: " + ex.getMessage());
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
                log.error("Error: " + ex.getMessage());
            }
        }
        return respuesta;

    }

    @Override
    public List<HorarioJornadaContrato> consultaContrato(String dni, int query) {

        Connection cnn = null;
        List<HorarioJornadaContrato> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        HorarioJornadaContrato objHorarioJornadaContrato = null;
        Contrato objContrato = null;
        Personal objPersona = null;
        Empresa objEmpresa = null;
        TipoContrato objTipoContrato = null;
        try {

            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql;

            if (query == QUERYRENOVAR) {
                sql = "call sp_consultaContratoRenovar ".concat(PrepararSQL.get(2));
            } else if (query == QUERYCONSULTA) {
                sql = "call sp_consultaContrato ".concat(PrepararSQL.get(2));
            } else {
                sql = "call sp_listaTodosContratos".concat(PrepararSQL.get(2));
            }

            ps = cnn.prepareStatement(sql);

            ps.setString(1, dni);
            ps.setString(2, Util.ACTIVO);

            rs = ps.executeQuery();


            while (rs.next()) {
                objHorarioJornadaContrato = new HorarioJornadaContrato();

                objContrato = new Contrato();
                objContrato.setInt_idContrato(rs.getInt(8));
                objContrato.setInt_idPersona(rs.getInt(9));
                objContrato.setInt_idTipoContrato(rs.getInt(10));
                objContrato.setInt_idEmpresa(rs.getInt(11));
                objContrato.setDte_fechaInicial(rs.getString(12));
                objContrato.setDte_fechaFinal(rs.getString(13));
                objContrato.setDbl_sueldo(rs.getBigDecimal(14));
                objContrato.setStr_estado(rs.getString(15));
                objContrato.setStr_usuarioCreador(rs.getString(26));

                objPersona = new Personal();
                objPersona.setInt_idPersona(rs.getInt(1));
                objPersona.setStr_codigo(rs.getString(2));
                objPersona.setStr_apePaterno(rs.getString(3));
                objPersona.setStr_apeMaterno(rs.getString(4));
                objPersona.setStr_nombres(rs.getString(5));
                objPersona.setStr_dni(rs.getString(6));
                objPersona.setStr_estado(rs.getString(7));
                objContrato.setObjPersona(objPersona);

                objEmpresa = new Empresa();
                objEmpresa.setInt_idEmpresa(rs.getInt(20));
                objEmpresa.setStr_razonSocial(rs.getString(21));
                objEmpresa.setStr_ruc(rs.getString(22));
                objEmpresa.setStr_domicilioEmpresa(rs.getString(23));
                objEmpresa.setStr_representanteLegal(rs.getString(24));
                objEmpresa.setStr_dniRepresentante(rs.getString(25));
                objContrato.setObjEmpresa(objEmpresa);

                objTipoContrato = new TipoContrato();
                objTipoContrato.setInt_idTipoContrato(rs.getInt(16));
                objTipoContrato.setStr_tipoContrato(rs.getString(17));
                objTipoContrato.setStr_nombreReporte(rs.getString(18));
                objTipoContrato.setStr_estado(rs.getString(19));
                objContrato.setObjTipoContrato(objTipoContrato);

                objHorarioJornadaContrato.setObjContrato(objContrato);

                lista.add(objHorarioJornadaContrato);
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
        return lista;
    }

    @Override
    public HorarioJornadaContrato consultaContrato(int contrato) {


        Connection cnn = null;
//        List<HorarioJornadaContrato> lista=new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        HorarioJornadaContrato objHorarioJornadaContrato = null;
        Contrato objContrato = null;
        Personal objPersona = null;
        Empresa objEmpresa = null;
        HorarioJornada objHorarioJornada = null;
        Horarios objHorario = null;
        Jornada objJornada = null;

        try {

            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "call sp_consultaHorarioJornadaContrato ".concat(PrepararSQL.get(2));

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, contrato);
            ps.setString(2, Util.ACTIVO);

            rs = ps.executeQuery();

            int i = 0;
            List<HorarioJornada> listaHorarioJornada = new ArrayList<>();
            HorarioJornadaContrato objTemporal = new HorarioJornadaContrato();
            while (rs.next()) {
                objHorarioJornadaContrato = new HorarioJornadaContrato();

                if (i == 0) {
                    objContrato = new Contrato();
                    objContrato.setInt_idContrato(rs.getInt(6));
                    objContrato.setDte_fechaInicial(rs.getString(7));
                    objContrato.setDte_fechaFinal(rs.getString(8));
                    objPersona = new Personal();
                    objPersona.setInt_idPersona(rs.getInt(1));
                    objPersona.setStr_nombres(rs.getString(2));
                    objContrato.setObjPersona(objPersona);
                    objEmpresa = new Empresa();
                    objEmpresa.setInt_idEmpresa(rs.getInt(3));
                    objEmpresa.setStr_razonSocial(rs.getString(4));
                    objEmpresa.setStr_ruc(rs.getString(5));
                    objContrato.setObjEmpresa(objEmpresa);

                    objTemporal.setObjContrato(objContrato);
//                    lista.add(objTemporal);
                }
//                else
//                {
                objHorarioJornada = new HorarioJornada();
                objHorarioJornada.setInt_idHorario(rs.getInt(16));
                objHorarioJornada.setInt_idJornada(rs.getInt(17));
                objHorarioJornada.setStr_estado(rs.getString(18));
                objHorario = new Horarios();
                objHorario.setInt_idHorario(rs.getInt(9));
                objHorario.setStr_nombreHorario(rs.getString(10));
                objHorario.setStr_estado(rs.getString(11));
                objHorarioJornada.setObjHorario(objHorario);
                objJornada = new Jornada();
                objJornada.setInt_idJornada(rs.getInt(12));
                objJornada.setTme_HoraInicio(rs.getString(13));
                objJornada.setTme_horaFin(rs.getString(14));
                objJornada.setStr_estado(rs.getString(15));
                objHorarioJornada.setObjJornada(objJornada);

                listaHorarioJornada.add(objHorarioJornada);
//                   System.out.println("Dian: "+objHorario.getStr_nombreHorario());
//                }



                i++;
            }

            if (i > 0) {
                objHorarioJornadaContrato = objTemporal;
                objHorarioJornadaContrato.setObjListHorarioJornada(listaHorarioJornada);

//                lista.set(0, objHorarioJornadaContrato);
//                lista.add(objHorarioJornadaContrato);
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
        return objHorarioJornadaContrato;


    }

    @Override
    public boolean renovarContrato(Contrato objContrato, List<HorarioJornada> listaHorarioJornada) {


        boolean respuesta = false;

        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql;
            PreparedStatement ps;
            ResultSet rs;
            //Determinamos si existe contrato para la persona con estado Activo
//            sql="call sp_exiteContrato".concat(PrepararSQL.get(2)); 
//            
//            ps=cnn.prepareStatement(sql);
//            
//            ps.setInt(1, objContrato.getInt_idPersona());
//            ps.setString(2, Util.ACTIVO);
//            
//            rs=ps.executeQuery();
//            
//            if (rs.next()){
//                if (rs.getInt(1)>0)
//                {
//                    Mensaje.mensaje("Persona ya cuenta con un contrato ACTIVO",Mensaje.TITULO_ME,Mensaje.ERROR);
//                    throw  new SQLException("Error Provocado por Validación");
//                }
//            }


            //Registramon el contrato
            ps = null;
            rs = null;
            sql = "call sp_renovarContrato".concat(PrepararSQL.get(12));

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, objContrato.getInt_idContrato());
            ps.setInt(2, objContrato.getInt_idPersona());
            ps.setInt(3, objContrato.getInt_idTipoContrato());
            ps.setInt(4, objContrato.getInt_idEmpresa());
            ps.setString(5, objContrato.getDte_fechaInicial());
            ps.setString(6, objContrato.getDte_fechaFinal());
            ps.setBigDecimal(7, objContrato.getDbl_sueldo());
            ps.setString(8, objContrato.getStr_estado());
            ps.setString(9, objContrato.getStr_usuarioCreador());
            ps.setString(10, objContrato.getDte_fechaCreacion());
            ps.setString(11, objContrato.getStr_observacion());
            ps.setString(12, Util.HISTORICO);

            ps.execute();


            int idContrato = -1;
            rs = ps.executeQuery("SELECT LAST_INSERT_ID()");

            while (rs.next()) {
                idContrato = rs.getInt(1);
            }

            if (idContrato == -1) {

                respuesta = false;
                throw new SQLException();
            }


            sql = "call sp_insertHorarioJornadaContratol ".concat(PrepararSQL.get(5));

            for (HorarioJornada hj : listaHorarioJornada) {
                ps = cnn.prepareStatement(sql);

                ps.setInt(1, hj.getObjHorario().getInt_idHorario());
                ps.setInt(2, hj.getObjJornada().getInt_idJornada());
                ps.setInt(3, idContrato);
//                System.out.println(hj.getInt_idHorario()+"-"+hj.getInt_idJornada()+"-"+idContrato);
                ps.setString(4, Util.ACTIVO);
                ps.setString(5, objContrato.getStr_usuarioCreador());


                ps.execute();
                ps = null;
            }


            cnn.commit();
            respuesta = true;
        } catch (SQLException ex) {
            try {
                log.error("Error: " + ex.getMessage());
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
                log.error("Error: " + ex.getMessage());
            }
        }
        return respuesta;

    }

    @Override
    public boolean cancelarContrato(Contrato objContrato) {

        boolean respuesta = false;

        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql;
            PreparedStatement ps;
            ResultSet rs;
            //Determinamos si existe contrato para la persona con estado Activo
//            sql="call sp_updateContrato".concat(PrepararSQL.get(3)); 
//            
//            ps=cnn.prepareStatement(sql);
//            
//            ps.setInt(1, objContrato.getInt_idPersona());
//            ps.setString(2, Util.ACTIVO);
//            
//            rs=ps.executeQuery();
//            
//            if (rs.next()){
//                if (rs.getInt(1)>0)
//                {
//                    Mensaje.mensaje("Persona ya cuenta con un contrato ACTIVO",Mensaje.TITULO_ME,Mensaje.ERROR);
//                    throw  new SQLException("Error Provocado por Validación");
//                }
//            }


            //Registramon el contrato
            ps = null;
            rs = null;
            sql = "call sp_updateContrato".concat(PrepararSQL.get(3));

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, objContrato.getInt_idContrato());
            ps.setString(2, Util.INACTIVO);
            ps.setString(3, objContrato.getStr_observacion());

            ps.execute();


//            int idContrato=-1;
//            rs=ps.executeQuery("SELECT LAST_INSERT_ID()");
//            
//            while(rs.next()){
//                idContrato=rs.getInt(1);
//            }
//            
//            if (idContrato==-1){
//                
//               respuesta=false;
//               throw new  SQLException();
//            }
//            
//            
//            sql="call sp_insertHorarioJornadaContratol ".concat(PrepararSQL.get(5));
//            
//            for (HorarioJornada hj : listaHorarioJornada) {
//                ps=cnn.prepareStatement(sql);
//                
//                ps.setInt(1, hj.getObjHorario().getInt_idHorario());
//                ps.setInt(2, hj.getObjJornada().getInt_idJornada());
//                ps.setInt(3, idContrato);
////                System.out.println(hj.getInt_idHorario()+"-"+hj.getInt_idJornada()+"-"+idContrato);
//                ps.setString(4, Util.ACTIVO);
//                ps.setString(5, objContrato.getStr_usuarioCreador());
//                
//                
//                ps.execute();
//                ps=null;
//            }
//            

            cnn.commit();
            respuesta = true;
        } catch (SQLException ex) {
            try {
                log.error("Error: " + ex.getMessage());
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
                log.error("Error: " + ex.getMessage());
            }
        }
        return respuesta;

    }

    @Override
    public List<Local> buscarLocal(int idEmpresa) {
        Connection cnn = null;
        List<Local> listaLocal = new ArrayList<>();
        Local objLocal = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_consultaLocal" + PrepararSQL.get(2);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, idEmpresa);
            ps.setString(2, Util.ACTIVO);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objLocal = new Local();

                objLocal.setInt_idLocal(rs.getInt(1));
                objLocal.setStr_nombre(rs.getString(2));
                objLocal.setStr_direccion(rs.getString(3));
                objLocal.setStr_estado(rs.getString(4));
                objLocal.setStr_distrito(rs.getString(9));
                objLocal.setStr_provincia(rs.getString(10));
                objLocal.setStr_departamento(rs.getString(11));
                objLocal.setStr_codLocalGuia(rs.getString(12));

                listaLocal.add(objLocal);
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
        return listaLocal;

    }

    @Override
    public String buscarCargoXIDPersona(int idPersona) {

        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String str_cargo = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_buscarCargoXIDPersona ".concat(PrepararSQL.get(2));

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, idPersona);
            ps.setString(2, Util.ACTIVO);

            rs = ps.executeQuery();


            if (rs.next()) {
                str_cargo = rs.getString(1);
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


        return str_cargo;

    }

    @Override
    public List<Personal> listaPersonasXEmpresa(int empresa) {

        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Personal> lista = new ArrayList<>();

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_listaPersonasEmpresa ".concat(PrepararSQL.get(2));


            ps = cnn.prepareStatement(sql);

            ps.setInt(1, empresa);
            ps.setString(2, Util.ACTIVO);

            rs = ps.executeQuery();

            Personal objPer;
            while (rs.next()) {
                objPer = new Personal();

                objPer.setInt_idPersona(rs.getInt(1));
                objPer.setStr_codigo(rs.getString(2));
                objPer.setStr_apePaterno(rs.getString(3));
                objPer.setStr_apeMaterno(rs.getString(4));
                objPer.setStr_nombres(rs.getString(5));
                objPer.setStr_dni(rs.getString(6));
                objPer.setStr_estado(rs.getString(7));

                lista.add(objPer);
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
        return lista;
    }

    @Override
    public List<HorarioJornadaContrato> consultarContratoXPersona(int empresa, String codigoPersona, String estado) {
        Connection cnn = null;
        List<HorarioJornadaContrato> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        HorarioJornadaContrato objHorarioJornadaContrato = null;
        Contrato objContrato = null;
        Personal objPersona = null;
        Empresa objEmpresa = null;
        TipoContrato objTipoContrato = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "call sp_listarContratoXPersona".concat(PrepararSQL.get(3));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, empresa);
            ps.setString(2, codigoPersona);
            ps.setString(3, estado);

            rs = ps.executeQuery();

            while (rs.next()) {
                objHorarioJornadaContrato = new HorarioJornadaContrato();

                objContrato = new Contrato();
                objContrato.setInt_idContrato(rs.getInt(8));
                objContrato.setInt_idPersona(rs.getInt(9));
                objContrato.setInt_idTipoContrato(rs.getInt(10));
                objContrato.setInt_idEmpresa(rs.getInt(11));
                objContrato.setDte_fechaInicial(rs.getString(12));
                objContrato.setDte_fechaFinal(rs.getString(13));
                objContrato.setDbl_sueldo(rs.getBigDecimal(14));
                objContrato.setStr_estado(rs.getString(15));
                objContrato.setStr_usuarioCreador(rs.getString(26));

                objPersona = new Personal();
                objPersona.setInt_idPersona(rs.getInt(1));
                objPersona.setStr_codigo(rs.getString(2));
                objPersona.setStr_apePaterno(rs.getString(3));
                objPersona.setStr_apeMaterno(rs.getString(4));
                objPersona.setStr_nombres(rs.getString(5));
                objPersona.setStr_dni(rs.getString(6));
                objPersona.setStr_estado(rs.getString(7));
                objContrato.setObjPersona(objPersona);

                objEmpresa = new Empresa();
                objEmpresa.setInt_idEmpresa(rs.getInt(20));
                objEmpresa.setStr_razonSocial(rs.getString(21));
                objEmpresa.setStr_ruc(rs.getString(22));
                objEmpresa.setStr_domicilioEmpresa(rs.getString(23));
                objEmpresa.setStr_representanteLegal(rs.getString(24));
                objEmpresa.setStr_dniRepresentante(rs.getString(25));
                objContrato.setObjEmpresa(objEmpresa);

                objTipoContrato = new TipoContrato();
                objTipoContrato.setInt_idTipoContrato(rs.getInt(16));
                objTipoContrato.setStr_tipoContrato(rs.getString(17));
                objTipoContrato.setStr_nombreReporte(rs.getString(18));
                objTipoContrato.setStr_estado(rs.getString(19));
                objContrato.setObjTipoContrato(objTipoContrato);

                objHorarioJornadaContrato.setObjContrato(objContrato);

                lista.add(objHorarioJornadaContrato);
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
        return lista;
    }

    @Override
    public int consultarContratoXPersona(int idPersona) {
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int int_idContrato = -1;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_selectIdContrato".concat(PrepararSQL.get(1));

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, idPersona);

            rs = ps.executeQuery();

            if (rs.next()) {
                int_idContrato = rs.getInt(1);
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


        return int_idContrato;
    }

    @Override
    public boolean modificarHorarioPersona(int idContrato, List<HorarioJornada> listaHJ, String usuarioModificador) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            sql = "call sp_desactivarHorario".concat(PrepararSQL.get(1));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idContrato);
            ps.execute();
            ps = null;

            sql = "call sp_updateHorarioPersona".concat(PrepararSQL.get(5));
            
            for (HorarioJornada objHJ : listaHJ) {
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, objHJ.getObjHorario().getInt_idHorario());
                ps.setInt(2, objHJ.getObjJornada().getInt_idJornada());
                ps.setInt(3, idContrato);
                ps.setString(4, Util.INACTIVO);
                ps.setString(5, usuarioModificador);
                ps.execute();

//                while (rs.next()) {
//                    if (rs.getString(1).equals(Util.ACTIVO)) {
//                        listaHJactivos.add(objHJ);
////                        i = 1;
//                    } 
////                    else {
////                        i = 0;
////                        break;
////                    }
//                }
//
////                if (i == 1) {
////                    listaHJInactivos.add(objHJ);
////                }
            }

            sql = "call sp_filtradoHorarioJornada".concat(PrepararSQL.get(1));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idContrato);
            rs = ps.executeQuery();

            List<HorarioJornada> listaHorarioFiltrado = new ArrayList<>();
            HorarioJornada auxHoJo;
            
            while (rs.next()) {
                auxHoJo = new HorarioJornada();
                auxHoJo.setInt_idJornada(rs.getInt(1));
                auxHoJo.setInt_idHorario(rs.getInt(2));
                auxHoJo.setStr_estado(rs.getString(3));
                listaHorarioFiltrado.add(auxHoJo);
            }
            
            ps = null;

            //Filtramos 
            List<HorarioJornada> listaHJactivos = new ArrayList<>();

            HorarioJornada auxHJ;
            for (HorarioJornada hj : listaHJ) {
                if (listaHorarioFiltrado.size() < 1) {
                    listaHJactivos.add(hj);
                    continue;
                }

                auxHJ = filtroIngreso(listaHorarioFiltrado, hj);

                if (auxHJ == null) {
                    listaHJactivos.add(hj);
                }
            }

            sql = "call sp_insertHorarioJornadaContratol".concat(PrepararSQL.get(5));
//            for (HorarioJornada objHJ : listaHorarioFiltrado) {
            for (HorarioJornada objHJ : listaHJactivos) {

                ps = cnn.prepareStatement(sql);
                ps.setInt(1, objHJ.getObjHorario().getInt_idHorario());
                ps.setInt(2, objHJ.getObjJornada().getInt_idJornada());
//                     ps.setInt(1, objHJ.getInt_idHorario());
//                     ps.setInt(2, objHJ.getInt_idJornada());
                ps.setInt(3, idContrato);
                ps.setString(4, Util.ACTIVO);
                ps.setString(5, usuarioModificador);
                ps.execute();
                ps = null;
            }
            cnn.commit();
            respuesta = true;
        } catch (SQLException ex) {
            try {
                log.error("Error: " + ex.getMessage());
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
                log.error("Error: " + ex.getMessage());
            }
        }
        return respuesta;
    }

    private HorarioJornada filtroIngreso(List<HorarioJornada> listaHorarioFiltrado, HorarioJornada hj) {
        for (HorarioJornada hj1 : listaHorarioFiltrado) {

            if (hj.getObjHorario().getInt_idHorario() == hj1.getInt_idHorario()
                    && hj.getObjJornada().getInt_idJornada() == hj1.getInt_idJornada()) {
//                              listaHorarioFiltrado.remove(hj);
                return hj;
            }

        }

        return null;
    }

    @Override
    public boolean modificarLocalPersona(int idContrato, int idLocal) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            String sql;
            PreparedStatement ps = null;
            sql = "call sp_updateLocalPersona".concat(PrepararSQL.get(2));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, idContrato);
            ps.setInt(2, idLocal);
            ps.execute();
            ps = null;
            cnn.commit();
            respuesta = true;
        } catch (SQLException ex) {
            try {
                log.error("Error: " + ex.getMessage());
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
                log.error("Error: " + ex.getMessage());
            }
        }
        return respuesta;
    }

    public Local buscarLocalNombre(int idEmpresa, String nombre) {
        Connection cnn = null;
//        List<Local> listaLocal = new ArrayList<>();
        Local objLocal = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = "CALL sp_listarLocalesAlmacen" + PrepararSQL.get(3);
            PreparedStatement ps = cnn.prepareStatement(sql);
            log.info("empresa--:" + idEmpresa + "   local--:" + nombre);
            ps.setInt(1, idEmpresa);
            ps.setString(2, nombre);
            ps.setString(3, Util.ACTIVO);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objLocal = new Local();

                objLocal.setInt_idLocal(rs.getInt(1));
                objLocal.setStr_nombre(rs.getString(2));
                objLocal.setStr_direccion(rs.getString(3));
                objLocal.setStr_estado(rs.getString(4));
                objLocal.setStr_distrito(rs.getString(9));
                objLocal.setStr_provincia(rs.getString(10));
                objLocal.setStr_departamento(rs.getString(11));
                objLocal.setStr_codLocalGuia(rs.getString(12));

//                listaLocal.add(objLocal);
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
        log.info("------" + objLocal.getInt_idLocal());
        return objLocal;

    }
}
