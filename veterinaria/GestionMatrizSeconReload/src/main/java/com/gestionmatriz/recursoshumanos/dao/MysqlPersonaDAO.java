/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.ui.swing.DPFPVerificationEvent;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;
import com.gestionmatriz.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.SpinnerNumberModel;

import org.apache.log4j.Logger;

/**
 *
 * @author YESMI
 */
public class MysqlPersonaDAO extends  ConexionSqlSpring implements PersonaDAO {
	private static final Logger log=Logger.getLogger(MysqlPersonaDAO.class); 
	//    
//    private SpinnerNumberModel farRequested = 
//    	new SpinnerNumberModel(	DPFPVerification.MEDIUM_SECURITY_FAR, 1, DPFPVerification.PROBABILITY_ONE, 100);

    private SpinnerNumberModel farRequested =
            new SpinnerNumberModel(DPFPVerification.MEDIUM_SECURITY_FAR, 1, DPFPVerification.PROBABILITY_ONE, 100);

    @Override
    public boolean registrarDatosPersonales(Personal objPersonal) {
        boolean respuesta = false;
        Connection cnn = null;

        try {

           cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            String sql;
            PreparedStatement ps;
//            ResultSet rs=null;
//            
//            
//            
//            sql="call sp_listaHuellas ";
//            ps=cnn.prepareStatement(sql);
////            ps.setObject(1, objPersonal.getBin_huellaDigital_1().serialize());
//            
//            
//            rs=ps.executeQuery();
//
//            DPFPTemplate objAuxTemp;
//            Personal objPersonaTemp;
//            while(rs.next()){
//                objAuxTemp= DPFPGlobal.getTemplateFactory().createTemplate();
//                objAuxTemp.deserialize(rs.getBytes(2));
//                objPersonaTemp=new Personal();
//                
//                objPersonaTemp.setBin_huellaDigital_1(objAuxTemp);
//                objAuxTemp.deserialize(rs.getBytes(3));
//                objPersonaTemp.setBin_huellaDigital_2(objAuxTemp);
//                
//                final DPFPVerification verification = 
//					DPFPGlobal.getVerificationFactory().createVerification(MysqlPersonaDAO.this.farRequested.getNumber().intValue());
//                
//                
//                
////                if (objPersonaTemp.getBin_huellaDigital_1().equals(objPersonal.getBin_huellaDigital_1())){
////                    Mensaje.mensaje("Huella Digital ya Registrada", Mensaje.TITULO_ME,Mensaje.ERROR);
////                    throw  new SQLException("Error lanzado por Huella Digital ya registrada");
////                }
////                
////                if (objPersonaTemp.getBin_huellaDigital_2().equals(objPersonal.getBin_huellaDigital_2())){
////                    Mensaje.mensaje("Huella Digital ya Registrada", Mensaje.TITULO_ME,Mensaje.ERROR);
////                    throw  new SQLException("Error lanzado por Huella Digital ya registrada");
////                }
//            }
//            

            ps = null;
            sql = "CALL sp_insertPersonal"
                    + PrepararSQL.get(26);
            ps = cnn.prepareStatement(sql);


            ps.setString(1, objPersonal.getStr_apePaterno());
            ps.setString(2, objPersonal.getStr_apeMaterno());
            ps.setString(3, objPersonal.getStr_nombres());
            ps.setString(4, objPersonal.getStr_dni());
            ps.setString(5, objPersonal.getStr_carnetExtranjeria());
            ps.setString(6, objPersonal.getDte_fechaNacimiento());
            ps.setString(7, objPersonal.getStr_ciudadNacimiento());
            ps.setString(8, objPersonal.getStr_telefono());
            ps.setString(9, objPersonal.getStr_movil());
            ps.setString(10, objPersonal.getStr_sexo());
            ps.setString(11, objPersonal.getStr_ciudadNacimiento());
            ps.setString(12, objPersonal.getStr_correoElectronico());
            ps.setString(13, objPersonal.getStr_brevete());
            ps.setString(14, objPersonal.getStr_categoriaBrevete());
            ps.setString(15, objPersonal.getStr_estadoCivil());
            ps.setString(16, objPersonal.getStr_direccion());
            ps.setString(17, objPersonal.getStr_distrito());
            ps.setString(18, objPersonal.getStr_provincia());
            ps.setString(19, objPersonal.getStr_departamento());
            // ps.setByte(20, objPersonal.getBin_huellaDigital_1());
            //ps.setByte(21, objPersonal.getBin_huellaDigital_2());


            //ps.setObject(20, objPersonal.getBin_huellaDigital_1().serialize());
            ps.setObject(20, null);


            //ps.setObject(21, objPersonal.getBin_huellaDigital_2().serialize());
            ps.setObject(21, null);



            ps.setString(22, objPersonal.getStr_estado());
            ps.setString(23, objPersonal.getStr_usuarioCreador());
            ps.setString(24, objPersonal.getDte_ultimaModificacion());
            ps.setString(25, objPersonal.getStr_usuarioModificador());

            if (objPersonal.getImg_foto() != null) {
                ps.setBinaryStream(26, objPersonal.getImg_foto(),
                        (int) objPersonal.getFl_foto().length());
            } else {
                ps.setBinaryStream(26, null);
            }





            respuesta = ps.execute();
            cnn.commit();
            respuesta = true;
            //        System.out.println(sql);
            //        cnn.commit();
            //        
            //        ResultSet rs=ps.getGeneratedKeys();
            //        
            //        int int_key = -1;
            //        if (rs.next())
            //            int_key=rs.getInt(1);
            //        
            //        System.out.println("Key: "+int_key);
            //        sql="CALL sp_updateCodigoPersona(?,?)";
            //        
            //        String codigo=objPersonal.getStr_nombres().substring(0, 1)+String.valueOf(int_key);
            //        
            //        ps.setString(1, codigo);
            //        ps.setLong(2, int_key);
            //        
            //        ps.execute();
            //        
            //            if (int_key==-1)
            //            {
            //                System.out.println("Ingreso al RollBack");
            //                respuesta=false;
            //                cnn.rollback();
            //                cnn.setAutoCommit(true);
            //                ps.close();
            //                ConexionSql.cerrarConexion(cnn);
            //                return respuesta;
            //            }
            //        
            //        System.out.println("Antes del Commit");

            //        cnn.setAutoCommit(true);
            //        System.out.println("Despues del Commit");
            //        respuesta=true;



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
    public ArrayList<Personal> BuscarPersona(String apePaterno,
            String apeMaterno,
            String nombres,
            String dni) {
        Connection cnn = null;

        ArrayList<Personal> lista = new ArrayList<>();

        try {

           cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_buscarPersona"
                    + PrepararSQL.get(5);


            PreparedStatement ps = cnn.prepareStatement(sql);


            ps.setString(1, apePaterno);
            ps.setString(2, apeMaterno);
            ps.setString(3, nombres);
            ps.setString(4, dni);
            ps.setString(5, Util.ACTIVO);

            ResultSet rs = ps.executeQuery();

            Personal objPersona;

            DPFPTemplate objAuxTemp;
            while (rs.next()) {

                objPersona = new Personal();
                objPersona.setInt_idPersona(rs.getInt(1));
                objPersona.setStr_codigo(rs.getString(2));
                objPersona.setStr_apePaterno(rs.getString(3));
                objPersona.setStr_apeMaterno(rs.getString(4));
                objPersona.setStr_nombres(rs.getString(5));
                objPersona.setStr_dni(rs.getString(6));
                objPersona.setStr_carnetExtranjeria(rs.getString(7));
                objPersona.setDte_fechaNacimiento(rs.getString(8));
                objPersona.setStr_ciudadNacimiento(rs.getString(9));
                objPersona.setStr_telefono(rs.getString(10));
                objPersona.setStr_movil(rs.getString(11));
                objPersona.setStr_sexo(rs.getString(12));
                objPersona.setStr_nacionalidad(rs.getString(13));
                objPersona.setStr_correoElectronico(rs.getString(14));
                objPersona.setStr_brevete(rs.getString(15));
                objPersona.setStr_categoriaBrevete(rs.getString(16));
                objPersona.setStr_estadoCivil(rs.getString(17));
                objPersona.setStr_direccion(rs.getString(18));
                objPersona.setStr_distrito(rs.getString(19));
                objPersona.setStr_provincia(rs.getString(20));
                objPersona.setStr_departamento(rs.getString(21));

                //Object Template Temporal para Deserializar la Huella Digital------------------------------------------
                objAuxTemp = DPFPGlobal.getTemplateFactory().createTemplate();
                if (!(rs.getBytes(22) == (null))) {
                    objAuxTemp.deserialize(rs.getBytes(22));
                    objPersona.setBin_huellaDigital_1(objAuxTemp);
                }

                if (!(rs.getBytes(23) == (null))) {
                    objAuxTemp.deserialize(rs.getBytes(23));
                    objPersona.setBin_huellaDigital_2(objAuxTemp);
                }

                //Object Template Temporal para Deserializar la Huella Digital------------------------------------------

                objPersona.setStr_estado(rs.getString(24));
                objPersona.setDte_fechaCreacion(rs.getString(25));
                objPersona.setStr_usuarioCreador(rs.getString(26));
                objPersona.setDte_ultimaModificacion(rs.getString(27));
                objPersona.setStr_usuarioModificador(rs.getString(28));
                objPersona.setImgRead(rs.getBytes(29));
                //agregamos al cliente al arreglo
                lista.add(objPersona);
            }

        } catch (SQLException ex) {
            log.error("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error SQL: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
            }
        }
        return lista;
    }

    @Override
    public int exitePersona(String dni) {

        int respuesta = 0;
        Connection cnn = null;
        try {
           cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_exitePersona" + PrepararSQL.get(2);
            PreparedStatement ps = cnn.prepareStatement(sql);

            ps.setString(1, dni);
            ps.setString(2, Util.ACTIVO);

            ResultSet rs = ps.executeQuery();

            int resultado;
            if (rs.next()) {

                resultado = rs.getInt(1);
                if (resultado > 0) {
                    respuesta = 1;
                }
            }


            ConexionSql.cerrarConexion(cnn);
        } catch (SQLException ex) {

            log.error("Error: " + ex.getMessage());

        } catch (Exception ex) {


            log.error("Error: " + ex.getMessage());

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
    public boolean modificarPersona(Personal objPersonal) {
        boolean respuesta = false;
        Connection cnn = null;

        try {

           cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "CALL sp_updatePersonal"
                    + PrepararSQL.get(28);


            PreparedStatement ps = cnn.prepareStatement(sql);


            ps.setString(1, objPersonal.getStr_apePaterno());
            ps.setString(2, objPersonal.getStr_apeMaterno());
            ps.setString(3, objPersonal.getStr_nombres());
            ps.setString(4, objPersonal.getStr_dni());
            ps.setString(5, objPersonal.getStr_carnetExtranjeria());
            ps.setString(6, objPersonal.getDte_fechaNacimiento());
            ps.setString(7, objPersonal.getStr_ciudadNacimiento());
            ps.setString(8, objPersonal.getStr_telefono());
            ps.setString(9, objPersonal.getStr_movil());
            ps.setString(10, objPersonal.getStr_sexo());
            ps.setString(11, objPersonal.getStr_ciudadNacimiento());
            ps.setString(12, objPersonal.getStr_correoElectronico());
            ps.setString(13, objPersonal.getStr_brevete());
            ps.setString(14, objPersonal.getStr_categoriaBrevete());
            ps.setString(15, objPersonal.getStr_estadoCivil());
            ps.setString(16, objPersonal.getStr_direccion());
            ps.setString(17, objPersonal.getStr_distrito());
            ps.setString(18, objPersonal.getStr_provincia());
            ps.setString(19, objPersonal.getStr_departamento());
            // ps.setByte(20, objPersonal.getBin_huellaDigital_1());
            //ps.setByte(21, objPersonal.getBin_huellaDigital_2());


            //ps.setObject(20, objPersonal.getBin_huellaDigital_1().serialize());
            ps.setObject(20, null);


            //ps.setObject(21, objPersonal.getBin_huellaDigital_2().serialize());
            ps.setObject(21, null);



            ps.setString(22, objPersonal.getStr_estado());
            objPersonal.setStr_estado(com.gestionmatriz.util.Util.HISTORICO);
            ps.setString(23, objPersonal.getStr_usuarioCreador());
            ps.setString(24, objPersonal.getDte_ultimaModificacion());
            ps.setString(25, objPersonal.getStr_usuarioModificador());

//            if (objPersonal.getImg_foto()!=null){
//                ps.setBinaryStream(26, objPersonal.getImg_foto(),
//                    (int)objPersonal.getFl_foto().length());
//            }
//            else
            ps.setBinaryStream(26, null);


            ps.setString(27, objPersonal.getStr_estado());
            ps.setString(28, objPersonal.getStr_codigo());



            respuesta = ps.execute();



//            if (objPersonal.getImg_foto()!=null){
//                sql="call sp_updateFoto "+PrepararSQL.get(3);
//                
//                ps=cnn.prepareStatement(sql);
//                
////                 ps.setBinaryStream(26, objPersonal.getImg_foto(),
////                    (int)objPersonal.getFl_foto().length());
//                 
//                ps.setBinaryStream(1, objPersonal.getImg_foto(),
//                    (int)objPersonal.getFl_foto().length());
//                ps.setString(2, Util.ACTIVO);
//                ps.setString(3, objPersonal.getStr_codigo());
//                
//                ps.execute();
//                
//                
//            }
//            
            cnn.commit();
            respuesta = true;

            //        System.out.println(sql);
            //        cnn.commit();
            //        
            //        ResultSet rs=ps.getGeneratedKeys();
            //        
            //        int int_key = -1;
            //        if (rs.next())
            //            int_key=rs.getInt(1);
            //        
            //        System.out.println("Key: "+int_key);
            //        sql="CALL sp_updateCodigoPersona(?,?)";
            //        
            //        String codigo=objPersonal.getStr_nombres().substring(0, 1)+String.valueOf(int_key);
            //        
            //        ps.setString(1, codigo);
            //        ps.setLong(2, int_key);
            //        
            //        ps.execute();
            //        
            //            if (int_key==-1)
            //            {
            //                System.out.println("Ingreso al RollBack");
            //                respuesta=false;
            //                cnn.rollback();
            //                cnn.setAutoCommit(true);
            //                ps.close();
            //                ConexionSql.cerrarConexion(cnn);
            //                return respuesta;
            //            }
            //        
            //        System.out.println("Antes del Commit");

            //        cnn.setAutoCommit(true);
            //        System.out.println("Despues del Commit");
            //        respuesta=true;



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
                    respuesta = false;
                    cnn.rollback();
                    log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
                } catch (SQLException ex1) {
                    respuesta = false;
                    log.error("Error en el RollBack " + ex1.getMessage());
                }
            }
        }

        return respuesta;
    }

    @Override
    public boolean actualizarFoto(Personal objPersonal) {
        boolean respuesta = false;
        Connection cnn = null;

        try {

           cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "CALL sp_updateFoto"
                    + PrepararSQL.get(3);


            PreparedStatement ps = cnn.prepareStatement(sql);


            ps.setString(1, objPersonal.getStr_apePaterno());
            ps.setString(2, objPersonal.getStr_apeMaterno());
            ps.setString(3, objPersonal.getStr_nombres());
//            ps.setString(4, objPersonal.getStr_dni());
//            ps.setString(5, objPersonal.getStr_carnetExtranjeria());
//            ps.setString(6, objPersonal.getDte_fechaNacimiento());
//            ps.setString(7, objPersonal.getStr_ciudadNacimiento());
//            ps.setString(8,objPersonal.getStr_telefono());
//            ps.setString(9, objPersonal.getStr_movil());
//            ps.setString(10, objPersonal.getStr_sexo());
//            ps.setString(11, objPersonal.getStr_ciudadNacimiento());
//            ps.setString(12, objPersonal.getStr_correoElectronico());
//            ps.setString(13, objPersonal.getStr_brevete());
//            ps.setString(14, objPersonal.getStr_categoriaBrevete());
//            ps.setString(15, objPersonal.getStr_estadoCivil());
//            ps.setString(16, objPersonal.getStr_direccion());
//            ps.setString(17, objPersonal.getStr_distrito());
//            ps.setString(18, objPersonal.getStr_provincia());
//            ps.setString(19, objPersonal.getStr_departamento());
            // ps.setByte(20, objPersonal.getBin_huellaDigital_1());
            //ps.setByte(21, objPersonal.getBin_huellaDigital_2());


//	    ps.setObject(20, objPersonal.getBin_huellaDigital_1().serialize());
//            
//            
//            ps.setObject(21, objPersonal.getBin_huellaDigital_2().serialize());
//            


//            ps.setString(22, objPersonal.getStr_estado());
//            objPersonal.setStr_estado(com.gestionmatriz.util.Util.A);
//            ps.setString(23, objPersonal.getStr_usuarioCreador());
//            ps.setString(24, objPersonal.getDte_ultimaModificacion());
//            ps.setString(25, objPersonal.getStr_usuarioModificador());

//            if (objPersonal.getImg_foto()!=null){
            ps.setBinaryStream(1, objPersonal.getImg_foto(),
                    (int) objPersonal.getFl_foto().length());
//            }
//            else
//                ps.setBinaryStream(26, null);


            ps.setString(2, Util.ACTIVO);
            ps.setString(3, objPersonal.getStr_codigo());



            respuesta = ps.execute();



//            if (objPersonal.getImg_foto()!=null){
//                sql="call sp_updateFoto "+PrepararSQL.get(3);
//                
//                ps=cnn.prepareStatement(sql);
//                
////                 ps.setBinaryStream(26, objPersonal.getImg_foto(),
////                    (int)objPersonal.getFl_foto().length());
//                 
//                ps.setBinaryStream(1, objPersonal.getImg_foto(),
//                    (int)objPersonal.getFl_foto().length());
//                ps.setString(2, Util.ACTIVO);
//                ps.setString(3, objPersonal.getStr_codigo());
//                
//                ps.execute();
//                
//                
//            }
//            
            cnn.commit();
            respuesta = true;

            //        System.out.println(sql);
            //        cnn.commit();
            //        
            //        ResultSet rs=ps.getGeneratedKeys();
            //        
            //        int int_key = -1;
            //        if (rs.next())
            //            int_key=rs.getInt(1);
            //        
            //        System.out.println("Key: "+int_key);
            //        sql="CALL sp_updateCodigoPersona(?,?)";
            //        
            //        String codigo=objPersonal.getStr_nombres().substring(0, 1)+String.valueOf(int_key);
            //        
            //        ps.setString(1, codigo);
            //        ps.setLong(2, int_key);
            //        
            //        ps.execute();
            //        
            //            if (int_key==-1)
            //            {
            //                System.out.println("Ingreso al RollBack");
            //                respuesta=false;
            //                cnn.rollback();
            //                cnn.setAutoCommit(true);
            //                ps.close();
            //                ConexionSql.cerrarConexion(cnn);
            //                return respuesta;
            //            }
            //        
            //        System.out.println("Antes del Commit");

            //        cnn.setAutoCommit(true);
            //        System.out.println("Despues del Commit");
            //        respuesta=true;



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
                    respuesta = false;
                    cnn.rollback();
                    log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
                } catch (SQLException ex1) {
                    respuesta = false;
                    log.error("Error en el RollBack " + ex1.getMessage());
                }
            }
        }

        return respuesta;
    }

    @Override
    public Personal consultaPersonaPorHuella(DPFPVerificationEvent fe) {


        Personal objPersona = null;
        Connection cnn = null;
        try {
           cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();


            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql;

            sql = "call sp_listaHuellas".concat(PrepararSQL.get(1));

            ps = cnn.prepareStatement(sql);

            ps.setString(1, Util.ACTIVO);

            rs = ps.executeQuery();

            List<Personal> listaPersona = new ArrayList<>();

            DPFPTemplate objAuxTemp;
            while (rs.next()) {
                objPersona = new Personal();

                objPersona.setInt_idPersona(rs.getInt(1));
                objPersona.setStr_nombres(rs.getString(2));

                objAuxTemp = DPFPGlobal.getTemplateFactory().createTemplate();
                objAuxTemp.deserialize(rs.getBytes(3));
                objPersona.setBin_huellaDigital_1(objAuxTemp);

                objAuxTemp = DPFPGlobal.getTemplateFactory().createTemplate();
                objAuxTemp.deserialize(rs.getBytes(4));
                objPersona.setBin_huellaDigital_2(objAuxTemp);
                objPersona.setStr_codigo(rs.getString(5));

                listaPersona.add(objPersona);

            }
            final DPFPVerification verification =
                    DPFPGlobal.getVerificationFactory().
                    createVerification(MysqlPersonaDAO.this.farRequested.getNumber().intValue());

            for (Personal personal : listaPersona) {
                final DPFPVerificationResult result1 = verification.verify(fe.getFeatureSet(), personal.getBin_huellaDigital_1());
                final DPFPVerificationResult result2 = verification.verify(fe.getFeatureSet(), personal.getBin_huellaDigital_2());
                fe.setMatched(result1.isVerified());

                if (fe.getMatched()) {
                    objPersona = personal;
                    break;
                }
                fe.setMatched(result2.isVerified());

                if (fe.getMatched()) {
                    objPersona = personal;
                    break;
                }

                if (!fe.getMatched()) {
                    objPersona = null;
                }

            }

            rs = null;
            ps = null;
            listaPersona = null;

            if (objPersona == null) {
                return null;
            }

            sql = "call sp_buscarPersonaXID" + PrepararSQL.get(2);

            ps = cnn.prepareStatement(sql);

            ps.setString(1, objPersona.getStr_codigo());
            ps.setString(2, Util.ACTIVO);

            rs = ps.executeQuery();

            if (rs.next()) {
                objPersona = new Personal();

                objPersona.setInt_idPersona(rs.getInt(1));
                objPersona.setStr_codigo(rs.getString(2));
                objPersona.setStr_apePaterno(rs.getString(3));
                objPersona.setStr_apeMaterno(rs.getString(4));
                objPersona.setStr_nombres(rs.getString(5));
                objPersona.setStr_dni(rs.getString(6));
                objPersona.setStr_carnetExtranjeria(rs.getString(7));
                objPersona.setDte_fechaNacimiento(rs.getString(8));
                objPersona.setStr_ciudadNacimiento(rs.getString(9));
                objPersona.setStr_telefono(rs.getString(10));
                objPersona.setStr_movil(rs.getString(11));
                objPersona.setStr_sexo(rs.getString(12));
                objPersona.setStr_nacionalidad(rs.getString(13));
                objPersona.setStr_correoElectronico(rs.getString(14));
                objPersona.setStr_brevete(rs.getString(15));
                objPersona.setStr_categoriaBrevete(rs.getString(16));
                objPersona.setStr_estadoCivil(rs.getString(17));
                objPersona.setStr_direccion(rs.getString(18));
                objPersona.setStr_distrito(rs.getString(19));
                objPersona.setStr_provincia(rs.getString(20));
                objPersona.setStr_departamento(rs.getString(21));

                //Object Template Temporal para Deserializar la Huella Digital------------------------------------------
                objAuxTemp = DPFPGlobal.getTemplateFactory().createTemplate();
                if (!(rs.getBytes(22) == (null))) {
                    objAuxTemp.deserialize(rs.getBytes(22));
                    objPersona.setBin_huellaDigital_1(objAuxTemp);
                }

                if (!(rs.getBytes(23) == (null))) {
                    objAuxTemp.deserialize(rs.getBytes(23));
                    objPersona.setBin_huellaDigital_2(objAuxTemp);
                }

                //Object Template Temporal para Deserializar la Huella Digital------------------------------------------

                objPersona.setStr_estado(rs.getString(24));
                objPersona.setDte_fechaCreacion(rs.getString(25));
                objPersona.setStr_usuarioCreador(rs.getString(26));
                objPersona.setDte_ultimaModificacion(rs.getString(27));
                objPersona.setStr_usuarioModificador(rs.getString(28));
                objPersona.setImgRead(rs.getBytes(29));

            }


        } catch (SQLException ex) {
            try {
                log.error("Error: " + ex.getMessage());
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error: " + ex.getMessage());
            }
        }
        return objPersona;
    }

    @Override
    public ArrayList<Personal> BuscarPersonaXEmpresa(int idEmpresa) {
        Connection cnn = null;

        ArrayList<Personal> lista = new ArrayList<>();

        try {

           cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_buscarPersonaXEmpresa"
                    + PrepararSQL.get(1);


            PreparedStatement ps = cnn.prepareStatement(sql);


            ps.setInt(1, idEmpresa);


            ResultSet rs = ps.executeQuery();

            Personal objPersona;

            while (rs.next()) {

                objPersona = new Personal();

                objPersona.setInt_idPersona(rs.getInt(1));
                objPersona.setStr_codigo(rs.getString(2));
                objPersona.setStr_apePaterno(rs.getString(3));
                objPersona.setStr_apeMaterno(rs.getString(4));
                objPersona.setStr_nombres(rs.getString(5));


                //agregamos al cliente al arreglo
                lista.add(objPersona);
            }

        } catch (SQLException ex) {
            log.error("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error SQL: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
            }
        }
        return lista;
    }

    @Override
    public Personal BuscarPersonaXCodigo(String idPersona) {
        Connection cnn = null;

//	ArrayList<Personal> lista =new ArrayList<>();
        Personal objPersona = null;
        try {

           cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_buscarPersonaXID"
                    + PrepararSQL.get(2);


            PreparedStatement ps = cnn.prepareStatement(sql);


            ps.setString(1, idPersona);
            ps.setString(2, Util.ACTIVO);

            ResultSet rs = ps.executeQuery();



            DPFPTemplate objAuxTemp;
            while (rs.next()) {

                objPersona = new Personal();
                objPersona.setInt_idPersona(rs.getInt(1));
                objPersona.setStr_codigo(rs.getString(2));
                objPersona.setStr_apePaterno(rs.getString(3));
                objPersona.setStr_apeMaterno(rs.getString(4));
                objPersona.setStr_nombres(rs.getString(5));
                objPersona.setStr_dni(rs.getString(6));
                objPersona.setStr_carnetExtranjeria(rs.getString(7));
                objPersona.setDte_fechaNacimiento(rs.getString(8));
                objPersona.setStr_ciudadNacimiento(rs.getString(9));
                objPersona.setStr_telefono(rs.getString(10));
                objPersona.setStr_movil(rs.getString(11));
                objPersona.setStr_sexo(rs.getString(12));
                objPersona.setStr_nacionalidad(rs.getString(13));
                objPersona.setStr_correoElectronico(rs.getString(14));
                objPersona.setStr_brevete(rs.getString(15));
                objPersona.setStr_categoriaBrevete(rs.getString(16));
                objPersona.setStr_estadoCivil(rs.getString(17));
                objPersona.setStr_direccion(rs.getString(18));
                objPersona.setStr_distrito(rs.getString(19));
                objPersona.setStr_provincia(rs.getString(20));
                objPersona.setStr_departamento(rs.getString(21));

                //Object Template Temporal para Deserializar la Huella Digital------------------------------------------
                objAuxTemp = DPFPGlobal.getTemplateFactory().createTemplate();
                if (!(rs.getBytes(22) == (null))) {
                    objAuxTemp.deserialize(rs.getBytes(22));
                    objPersona.setBin_huellaDigital_1(objAuxTemp);
                }

                if (!(rs.getBytes(23) == (null))) {
                    objAuxTemp.deserialize(rs.getBytes(23));
                    objPersona.setBin_huellaDigital_2(objAuxTemp);
                }

                //Object Template Temporal para Deserializar la Huella Digital------------------------------------------

                objPersona.setStr_estado(rs.getString(24));
                objPersona.setDte_fechaCreacion(rs.getString(25));
                objPersona.setStr_usuarioCreador(rs.getString(26));
                objPersona.setDte_ultimaModificacion(rs.getString(27));
                objPersona.setStr_usuarioModificador(rs.getString(28));
                objPersona.setImgRead(rs.getBytes(29));
                //agregamos al cliente al arreglo

            }

        } catch (SQLException ex) {
            log.error("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error SQL: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
            }
        }
        return objPersona;
    }
}