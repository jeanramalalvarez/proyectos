/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.ui.swing.DPFPVerificationEvent;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import com.gestionmatriz.config.services.KeyService_I;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.recursoshumanos.bean.Asistencia;
import com.gestionmatriz.recursoshumanos.bean.Contrato;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornada;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornadaContrato;
import com.gestionmatriz.recursoshumanos.bean.JustificacioneInasistencia;
import com.gestionmatriz.recursoshumanos.bean.PartTime;
import com.gestionmatriz.recursoshumanos.bean.Permisos;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.recursoshumanos.bean.TipoMarcado;
import com.gestionmatriz.seguridad.dao.MysqlUtilDAO;
import com.gestionmatriz.seguridad.dao.UtilMysqlDAO;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.EncriptionSource;
import com.gestionmatriz.util.FunctionByte;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.PrepararSQL;
import com.gestionmatriz.util.Util;

/**
 *
 * @author YESM
 */
public class MysqlAsistenciaDAO extends ConexionSqlSpring implements AsistenciaDAO {

	private static final Logger log=Logger.getLogger(MysqlAsistenciaDAO.class); 
    private SpinnerNumberModel farRequested =
            new SpinnerNumberModel(DPFPVerification.MEDIUM_SECURITY_FAR, 1, DPFPVerification.PROBABILITY_ONE, 100);
    public static int puntero = -1;
    private KeyService_I objKey_I;

    @Override
    public HorarioJornadaContrato registrarAsistencia(DPFPVerificationEvent fe, boolean b) {


        HorarioJornadaContrato objHorarioJornadaContrato = new HorarioJornadaContrato();
        Contrato objContrato = new Contrato();
        HorarioJornada objHorarioJornada = new HorarioJornada();


        Personal objPersona = null;
        Connection cnn = null;
        try {
            if (!b) {
                cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
                cnn.setAutoCommit(false);
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
                        createVerification(MysqlAsistenciaDAO.this.farRequested.getNumber().intValue());

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

                objContrato.setObjPersona(objPersona);

                //Objeto llamado para una consulta
                ContratoDAO objContratoDAO = new MysqlContratoDAO();
                List<HorarioJornadaContrato> lstObjContrato =
                        objContratoDAO.consultaContrato(objPersona.getStr_dni(), MysqlContratoDAO.QUERYCONSULTA);

                if (lstObjContrato.size() != 1) {
                    return null;
                }

                lstObjContrato.get(0).getObjContrato().setObjPersona(objPersona);
                objHorarioJornadaContrato.setObjContrato(lstObjContrato.get(0).getObjContrato());

                HorarioJornadaContrato objAuxHJC = objContratoDAO.consultaContrato(objHorarioJornadaContrato.getObjContrato().getInt_idContrato());

                objHorarioJornadaContrato.setObjListHorarioJornada(objAuxHJC.getObjListHorarioJornada());

                //            System.out.println("Size: "+objHorarioJornadaContrato.getObjListHorarioJornada().size());

                UtilMysqlDAO objUtilMysql = new MysqlUtilDAO();

                String fechaSistema = objUtilMysql.getFechaMysql();
                String nombreDia = Util.getNombreDia(Util.diaSemana(Util.StringTODate(fechaSistema)) - 1);

                //Filtramos el dia 
                //            for (HorarioJornada hj:objHorarioJornadaContrato.getObjListHorarioJornada()){
                //                
                //                if (!(nombreDia.equalsIgnoreCase(hj.getObjHorario().getStr_nombreHorario()))){
                //                   objHorarioJornadaContrato.getObjListHorarioJornada().remove(hj);
                //                    
                //                }
                //            }

                //Filtra el dia de Marcado
                for (int i = 0; i < objHorarioJornadaContrato.getObjListHorarioJornada().size(); i++) {
                    objHorarioJornada = objHorarioJornadaContrato.getObjListHorarioJornada().get(i);

                    if (!objHorarioJornada.getObjHorario().
                            getStr_nombreHorario().equalsIgnoreCase(nombreDia)) {

                        objHorarioJornadaContrato.getObjListHorarioJornada().remove(objHorarioJornada);
                        i--;
                    }
                }
                //            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); 
                //            String hora,horaAdd,horaRe;
                long lhoraAdd, lhoraRe, lhoraAddSalida, lhoraReSalida;
                String strhoraSistema = (Util.StringTODateTime(Util.StringTODateLong(fechaSistema)));
                long lhoraSistema = (Util.StringToDateTimeAddLong(Util.StringTODateTime(strhoraSistema), 0));

                //            System.out.println("Hora del Sistema: "+strhoraSistema);
                List<HorarioJornada> lstAuxHorarioJornada = new ArrayList<>();

                //Filtra y determina si es ingreso o salida
                //            int tiempo[];
                long minutoTarde = 0;
                for (HorarioJornada hj : objHorarioJornadaContrato.getObjListHorarioJornada()) {
                    //                System.out.println(PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[0]);
                    //                tiempo=PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera();
                    //                System.out.println("Paso");
                    lhoraAdd = (Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_HoraInicio()), PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[1]));
                    lhoraAddSalida = (Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_horaFin()), PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[1]));

                    lhoraRe = (Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_HoraInicio()),
                            PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[0]));
                    lhoraReSalida = (Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_horaFin()),
                            PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[0]));


                    rs = null;
                    ps = null;

                    sql = "call sp_consultaMarco ".concat(PrepararSQL.get(3));

                    int idAsistencia = -1;

                    ps = cnn.prepareStatement(sql);
                    int puntero = 0;


                    if (lhoraSistema >= lhoraRe && lhoraSistema <= lhoraAdd) {
                        lstAuxHorarioJornada.add(hj);
                        log.info("Marco Entrada");
                        long minutosHoraMarcado = Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_HoraInicio()), 0);

                        if (minutosHoraMarcado >= lhoraSistema) {
                            minutoTarde = 0;
                        } else {
                            minutoTarde = lhoraSistema - minutosHoraMarcado;
                        }

                        for (int i = 0; i < objHorarioJornadaContrato.getObjListHorarioJornada().size(); i++) {
                            //hp=obj.get(i);
                            ps.setInt(1, objHorarioJornadaContrato.getObjContrato().getInt_idContrato()); //Contrato
                            ps.setInt(2, objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idHorario()); //Horario
                            ps.setInt(3, objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idJornada()); //Jornada

                            rs = ps.executeQuery();

                            puntero = 0;

                            while (rs.next()) {
                                puntero++;

                            }
                        }

                        if (puntero >= 1) {

                            Mensaje.mensaje("Usted ya Marco su Ingreso", Mensaje.TITULO_ME, Mensaje.ERROR);
                            return null;
                        }
                    } else if (lhoraSistema >= lhoraReSalida && lhoraSistema <= lhoraAddSalida) {



                        lstAuxHorarioJornada.add(hj);
                        log.info("Marco Salida");
                        minutoTarde = -1;


                        for (int i = 0; i < objHorarioJornadaContrato.getObjListHorarioJornada().size(); i++) {
                            //hp=obj.get(i);
                            ps.setInt(1, objHorarioJornadaContrato.getObjContrato().getInt_idContrato()); //Contrato
                            ps.setInt(2, objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idHorario()); //Horario
                            ps.setInt(3, objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idJornada()); //Jornada

                            rs = ps.executeQuery();

                            puntero = 0;


                            while (rs.next()) {
                                puntero++;
                                idAsistencia = rs.getInt(1);
                            }
                        }

                        if (puntero >= 2) {
                            Mensaje.mensaje("Usted ya Marco su Salida", Mensaje.TITULO_ME, Mensaje.ERROR);
                            return null;
                        } else {
                            //valida si regreso del refrigerio======================
                            rs = null;
                            ps = null;

                            sql = "call sp_salioRefrigerio ".concat(PrepararSQL.get(2));

                            ps = cnn.prepareStatement(sql);

                            ps.setInt(1, idAsistencia);
                            ps.setString(2, Util.ACTIVO);



                            rs = ps.executeQuery();

                            if (rs.next()) {
                                Mensaje.mensaje("Usted no Marco su Ingreso del Refrigerio, No Puede Marcar Su Salida", Mensaje.TITULO_ME, Mensaje.ERROR);
                                return null;
                            }

                            //valida si regreso del refrigerio======================

                        }



                    }

                }

                objHorarioJornadaContrato.setObjListHorarioJornada(lstAuxHorarioJornada);

                //Retorna Null si despues del filtro no cuent con horarios
                if (objHorarioJornadaContrato.getObjListHorarioJornada().size() < 1) {
                    rs = null;
                    ps = null;

                    sql = "call sp_permisosXPersona ".concat(PrepararSQL.get(2));

                    ps = cnn.prepareStatement(sql);

                    //                System.out.println(Util.stringTOint( objPersona.getStr_codigo().substring(1)));
                    ps.setInt(1, Util.stringTOint(objPersona.getStr_codigo().substring(1)));
                    ps.setString(2, Util.APROBADO);

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        String horaServidor;

                        Permisos objPermisos = new Permisos();
                        objPermisos.setInt_idPermisos(rs.getInt(1));
                        objPermisos.setDte_fecha(rs.getString(2));
                        objPermisos.setStr_motivo(rs.getString(3));
                        objPermisos.setTm_horaSalida(rs.getString(4));
                        objPermisos.setTm_horaLlegada(rs.getString(5));
                        objPermisos.setStr_observacion(rs.getString(6));
                        objPermisos.setStr_estado(rs.getString(7));
                        objPermisos.setTm_horaMarcadoSalida(rs.getString(8));
                        objPermisos.setTm_horaMarcadoLlegada(rs.getString(9));
                        objPermisos.setDte_fechaRegistro(rs.getString(10));
                        objPermisos.setInt_idPersona(rs.getInt(11));
                        horaServidor = rs.getString(12);

                        String tipoMarcado;
                        if (objPermisos.getTm_horaMarcadoSalida() == null) {
                            objPermisos.setTm_horaMarcadoSalida(horaServidor);
                            //                       objPermisos.setTm_horaMarcadoLlegada("00:00:00");
                            tipoMarcado = "Marco Salida Por Permiso";
                        } else {
                            objPermisos.setTm_horaMarcadoLlegada(horaServidor);
                            objPermisos.setStr_estado(Util.CUMPLIDOS);
                            tipoMarcado = "Marco Entrada Por Permiso";
                        }

                        rs = null;
                        ps = null;

                        sql = "call sp_registrarMarcadoPorPermiso ".concat(PrepararSQL.get(4));
                        ps = cnn.prepareStatement(sql);

                        ps.setInt(1, objPermisos.getInt_idPermisos());
                        ps.setString(2, objPermisos.getTm_horaMarcadoSalida());
                        ps.setString(3, objPermisos.getTm_horaMarcadoLlegada());
                        ps.setString(4, objPermisos.getStr_estado());

                        ps.execute();



                        JPanel pnlFoto = new JPanel();
                        pnlFoto.setLayout(new BorderLayout());
                        pnlFoto.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
                        //                   pnlDetalle.setBounds(0, 0, 500, 500);

                        JPanel pnlDetalle = new JPanel();
                        pnlDetalle.setLayout(null);
                        //                   pnlDetalle.setBounds(100,0,300,200);
                        //                   pnlDetalle.setSize(300,200);
                        pnlDetalle.setPreferredSize(new Dimension(230, 150));
                        pnlDetalle.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

                        JPanel pnlAll = new JPanel();
                        pnlAll.setLayout(new GridLayout());

                        pnlAll.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Marcado de Permiso", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));


                        pnlAll.add(pnlFoto);
                        pnlAll.add(pnlDetalle);


                        JLabel lblFoto = new JLabel();
                        lblFoto.setSize(230, 150);
                        pnlFoto.add(new JLabel(), BorderLayout.NORTH);
                        pnlFoto.add(new JLabel(), BorderLayout.SOUTH);
                        pnlFoto.add(new JLabel(), BorderLayout.EAST);
                        pnlFoto.add(new JLabel(), BorderLayout.WEST);
                        pnlFoto.add(lblFoto, BorderLayout.CENTER);

                        try {
                            if (objHorarioJornadaContrato.getObjContrato().getObjPersona().getImgRead() != null) {
                                Image foto = com.gestionmatriz.util.Util.ConvertirImagen(
                                        objHorarioJornadaContrato.getObjContrato().getObjPersona().getImgRead());

                                ImageIcon iconofoto = new ImageIcon(foto);

                                Icon fotoIncono = com.gestionmatriz.util.Util.reducirFoto(
                                        iconofoto, lblFoto.getWidth(), lblFoto.getHeight());

                                lblFoto.setIcon(fotoIncono);

                            }
                        } catch (IOException ex) {
                            log.error("Error: " + ex.getMessage());
                        }




                        //                   lblUsuario.setBounds(50,0,50,20);



                        JLabel lblUsuario = new JLabel(objPersona.getStr_nombres() + " "
                                + objPersona.getStr_apePaterno() + " "
                                + objPersona.getStr_apeMaterno());
                        pnlDetalle.add(lblUsuario);

                        JLabel lblHoraSalida = new JLabel("Hora. Salida: " + objPermisos.getTm_horaSalida());
                        lblHoraSalida.setBounds(0, 15, 230, 20);
                        pnlDetalle.add(lblHoraSalida);
                        lblHoraSalida.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

                        JLabel lblHoraLlegada = new JLabel("Hora. Llegada: " + objPermisos.getTm_horaLlegada());
                        lblHoraLlegada.setBounds(0, 40, 230, 20);
                        pnlDetalle.add(lblHoraLlegada);
                        lblHoraLlegada.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

                        JLabel lblHoraMarcado = new JLabel("Hora. Marcado: " + horaServidor);
                        lblHoraMarcado.setBounds(0, 65, 230, 20);
                        pnlDetalle.add(lblHoraMarcado);
                        lblHoraMarcado.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

                        JLabel lblEstado = new JLabel("T. Marcado: " + tipoMarcado);
                        lblEstado.setBounds(0, 90, 230, 20);
                        pnlDetalle.add(lblEstado);
                        lblEstado.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
                        lblEstado.setFont(new Font("command", Font.BOLD, 12));



                        //                   Mensaje.mensaje(null, pnlDetalle, Mensaje.INFORMACION);

                        JOptionPane.showMessageDialog(null, pnlAll, Mensaje.TITULO_ME, JOptionPane.INFORMATION_MESSAGE);
                        //                   JDialog objMensaje =new JDialog(this);
                        //                   objMensaje.add(pnlDetalle);
                        //                   objMensaje.setVisible(true);

                        cnn.commit();
                    }

                    return null;


                }

                //            for (HorarioJornada hj: objHorarioJornadaContrato.getObjListHorarioJornada()){
                //                System.out.println("Dia : "+hj.getObjHorario().getStr_nombreHorario());
                //                System.out.println("Hora: "+hj.getObjJornada().getTme_HoraInicio());
                //            }




                ps = null;
                sql = "call sp_registrarAsistencia " + PrepararSQL.get(5);

                ps = cnn.prepareStatement(sql);

                ps.setInt(1, objHorarioJornadaContrato.getObjListHorarioJornada().get(0).getObjHorario().getInt_idHorario());
                ps.setInt(2, objHorarioJornadaContrato.getObjListHorarioJornada().get(0).getObjJornada().getInt_idJornada());
                ps.setInt(3, objHorarioJornadaContrato.getObjContrato().getInt_idContrato());
                ps.setString(4, String.valueOf(TipoMarcado.ASISTENCIA));
                ps.setString(5, Util.ACTIVO);

                ps.execute();

                cnn.commit();
                return objHorarioJornadaContrato;

            } else {


                cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
                cnn.setAutoCommit(false);
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
                        createVerification(MysqlAsistenciaDAO.this.farRequested.getNumber().intValue());

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

                objContrato.setObjPersona(objPersona);

                //Objeto llamado para una consulta
                ContratoDAO objContratoDAO = new MysqlContratoDAO();
                List<HorarioJornadaContrato> lstObjContrato =
                        objContratoDAO.consultaContrato(objPersona.getStr_dni(), MysqlContratoDAO.QUERYCONSULTA);

                if (lstObjContrato.size() != 1) {
                    return null;
                }

                lstObjContrato.get(0).getObjContrato().setObjPersona(objPersona);
                objHorarioJornadaContrato.setObjContrato(lstObjContrato.get(0).getObjContrato());

                HorarioJornadaContrato objAuxHJC = objContratoDAO.consultaContrato(objHorarioJornadaContrato.getObjContrato().getInt_idContrato());

                objHorarioJornadaContrato.setObjListHorarioJornada(objAuxHJC.getObjListHorarioJornada());

                //            System.out.println("Size: "+objHorarioJornadaContrato.getObjListHorarioJornada().size());

                UtilMysqlDAO objUtilMysql = new MysqlUtilDAO();

                String fechaSistema = objUtilMysql.getFechaMysql();
                String nombreDia = Util.getNombreDia(Util.diaSemana(Util.StringTODate(fechaSistema)) - 1);

                //Filtramos el dia 
                //            for (HorarioJornada hj:objHorarioJornadaContrato.getObjListHorarioJornada()){
                //                
                //                if (!(nombreDia.equalsIgnoreCase(hj.getObjHorario().getStr_nombreHorario()))){
                //                   objHorarioJornadaContrato.getObjListHorarioJornada().remove(hj);
                //                    
                //                }
                //            }

                //Filtra el dia de Marcado
                for (int i = 0; i < objHorarioJornadaContrato.getObjListHorarioJornada().size(); i++) {
                    objHorarioJornada = objHorarioJornadaContrato.getObjListHorarioJornada().get(i);

                    if (!objHorarioJornada.getObjHorario().
                            getStr_nombreHorario().equalsIgnoreCase(nombreDia)) {

                        objHorarioJornadaContrato.getObjListHorarioJornada().remove(objHorarioJornada);
                        i--;
                    }
                }
                //            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); 
                //            String hora,horaAdd,horaRe;
                long lhoraIngreso, lhoraSalida;
                String strhoraSistema = (Util.StringTODateTime(Util.StringTODateLong(fechaSistema)));
                long lhoraSistema = (Util.StringToDateTimeAddLong(Util.StringTODateTime(strhoraSistema), 0));

                //            System.out.println("Hora del Sistema: "+strhoraSistema);
                List<HorarioJornada> lstAuxHorarioJornada = new ArrayList<>();

                //Filtra y determina si es ingreso o salida
                //            int tiempo[];
                //            long minutoTarde=0;
                for (HorarioJornada hj : objHorarioJornadaContrato.getObjListHorarioJornada()) {
                    ////                System.out.println(PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[0]);
                    ////                tiempo=PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera();
                    ////                System.out.println("Paso");
                    lhoraIngreso = (Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_HoraInicio()), 0));
                    lhoraSalida = (Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_horaFin()), 0));
                    //                        
                    //                lhoraRe=(Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_HoraInicio()),
                    //                        PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[0]));
                    //                lhoraReSalida=(Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_horaFin()),
                    //                        PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[0]));


                    rs = null;
                    ps = null;

                    sql = "call sp_consultaMarco ".concat(PrepararSQL.get(3));

                    ps = cnn.prepareStatement(sql);
                    int puntero = 0;
                    int idAsistencia = -1;

                    if (lhoraSistema >= lhoraIngreso && lhoraSistema <= lhoraSalida) {
                        lstAuxHorarioJornada.add(hj);
                        //                    System.out.println("Marco Salida Refrigerio");
                        //                    long minutosHoraMarcado=Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_HoraInicio())
                        //                        ,0);

                        //                    if (minutosHoraMarcado>=lhoraSistema)
                        //                        minutoTarde=0;
                        //                    else
                        //                        minutoTarde=lhoraSistema-minutosHoraMarcado;

                        for (int i = 0; i < objHorarioJornadaContrato.getObjListHorarioJornada().size(); i++) {
                            //hp=obj.get(i);
                            ps.setInt(1, objHorarioJornadaContrato.getObjContrato().getInt_idContrato()); //Contrato
                            ps.setInt(2, objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idHorario()); //Horario
                            ps.setInt(3, objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idJornada()); //Jornada

                            rs = ps.executeQuery();

                            puntero = 0;
                            while (rs.next()) {
                                if (rs.getString(7).trim().equalsIgnoreCase(String.valueOf(TipoMarcado.ASISTENCIA))) {
                                    puntero++;
                                    idAsistencia = rs.getInt(1);
                                }



                            }
                        }

                        if (puntero == 1) {
                            rs = null;
                            ps = null;

                            sql = "call sp_salioRefrigerio ".concat(PrepararSQL.get(2));

                            ps = cnn.prepareStatement(sql);

                            ps.setInt(1, idAsistencia);
                            ps.setString(2, Util.ACTIVO);



                            rs = ps.executeQuery();

                            int punteroRefrigerio = 0;
                            String horaSalidaRefrigerio = "";
                            int idRefrigerio = -1;
                            while (rs.next()) {
                                punteroRefrigerio++;
                                horaSalidaRefrigerio = Util.StringTODateTime(Util.StringTODateLong(rs.getString(2)));
                                idRefrigerio = rs.getInt(1);
                            }


                            if (punteroRefrigerio < 1) {
                                if (this.puntero != -1) {
                                    return null;
                                }

                                this.puntero = 1;
                                Object objRespuesta = Mensaje.confirmar(null, "Desea Marcar su Salida a Refrigerio a la " + strhoraSistema + " ?",
                                        Mensaje.TITULO_OP,
                                        Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);


                                if (objRespuesta.equals(Mensaje.YES_OPTION)) {
                                    rs = null;
                                    ps = null;

                                    sql = "call sp_salioRefrigerio ".concat(PrepararSQL.get(2));

                                    ps = cnn.prepareStatement(sql);

                                    ps.setInt(1, idAsistencia);
                                    ps.setString(2, Util.CUMPLIDOS);



                                    rs = ps.executeQuery();

                                    if (rs.next()) {
                                        Mensaje.mensaje("Usted ya Tomo su Refrigerio", Mensaje.TITULO_ME, Mensaje.ERROR);
                                        return null;
                                    }

                                    rs = null;
                                    ps = null;

                                    sql = "call sp_insertRefrigerio ".concat(PrepararSQL.get(2));
                                    ps = cnn.prepareStatement(sql);

                                    ps.setString(1, Util.ACTIVO);
                                    ps.setInt(2, idAsistencia);

                                    ps.execute();

                                    String horaRefrigerio = Util.StringTODateTime(Util.StringTODateLong(objUtilMysql.getFechaMysql()));
                                    Mensaje.mensaje("•\tSu Refrigerio se Inicio a las: "
                                            + horaRefrigerio
                                            + "\n•\tLa Hora de Regreso es: " + Util.StringToDateTimeAdd(
                                            Util.StringTODateLong(objUtilMysql.getFechaMysql()), 120), Mensaje.TITULO_ME, Mensaje.INFORMACION);
                                    cnn.commit();
                                }
//                              Mensaje.mensaje("Usted ya Marco su Ingreso", Mensaje.TITULO_ME,Mensaje.ERROR);
                                this.puntero = -1;
                                return null;
                            } else if (punteroRefrigerio == 1) {
                                rs = null;
                                ps = null;


                                sql = "call sp_updateRefrigerio ".concat(PrepararSQL.get(2));
                                long lHoraSalidaRefrigerio = (Util.StringToDateTimeAddLong(Util.StringTODateTime(horaSalidaRefrigerio), 125));
                                String horaRefrigerio = Util.StringTODateTime(Util.StringTODateLong(objUtilMysql.getFechaMysql()));


                                long lhoraSistemaRefrigerio = (Util.StringToDateTimeAddLong(Util.StringTODateTime(horaRefrigerio), 0));

                                if (lhoraSistemaRefrigerio <= lHoraSalidaRefrigerio) {
                                    ps = cnn.prepareStatement(sql);
                                    ps.setInt(1, idRefrigerio);
                                    ps.setString(2, Util.CUMPLIDOS);

                                    ps.execute();

                                    Mensaje.mensaje("Se Registró su Ingreso del Refrigerio con Éxito", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                                    cnn.commit();

                                } else {
                                    Mensaje.mensaje("Fuera del Rango de Regreso del Refrigerio", Mensaje.TITULO_ME, Mensaje.ERROR);
                                }

                            }


                        }
                    }
                    //                else if (lhoraSistema>=lhoraReSalida && lhoraSistema<=lhoraAddSalida){
                    //                     lstAuxHorarioJornada.add(hj);
                    //                     System.out.println("Marco Regreso Refrigerio");
                    ////                     minutoTarde=-1;
                    //                     
                    //                     
                    //                      for (int i=0;i<objHorarioJornadaContrato.getObjListHorarioJornada().size();i++){
                    //                         //hp=obj.get(i);
                    //                         ps.setInt(1, objHorarioJornadaContrato.getObjContrato().getInt_idContrato()); //Contrato
                    //                         ps.setInt(2,objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idHorario()); //Horario
                    //                         ps.setInt(3,objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idJornada()); //Jornada
                    //
                    //                         rs=ps.executeQuery();
                    //
                    //                         puntero=0;
                    //                         while (rs.next()){
                    //                             puntero++;
                    //                         }
                    //                     }

                    //                    if (puntero>=2)
                    //                    {
                    //                        Mensaje.mensaje("Usted ya Marco su Salida", Mensaje.TITULO_ME,Mensaje.ERROR);
                    //                        return null;
                    //                    }

                    //                }

                }

//                objHorarioJornadaContrato.setObjListHorarioJornada(lstAuxHorarioJornada);

                return null;
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
        return null;

    }

    @Override
    public List<Personal> personaConHorarioMarcar() {

        Personal objPersona = null;
        Connection cnn = null;
        List<Personal> listaPersona = new ArrayList<>();
        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql;

            sql = "call sp_listaHuellas".concat(PrepararSQL.get(1));



            ps = cnn.prepareStatement(sql);

            ps.setString(1, Util.ACTIVO);

            rs = ps.executeQuery();

            listaPersona = new ArrayList<>();

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

                listaPersona.add(objPersona);

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

        return listaPersona;
    }

    @Override
    public List<Asistencia> consultarAsistencia(String fechaI, String fechaF, int empresa) {

        List<Asistencia> listaAsistencia = new ArrayList<>();
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Asistencia objAsistencia;
        Contrato objContrato;
        Personal objPersonal;
        Empresa objEmpresa;
        try {

            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = " call sp_consultaAsistencia ".concat(PrepararSQL.get(3));

            ps = cnn.prepareStatement(sql);

            ps.setString(1, fechaI);
            ps.setString(2, fechaF);
            ps.setInt(3, empresa);

            rs = ps.executeQuery();

            while (rs.next()) {
                objAsistencia = new Asistencia();

                objContrato = new Contrato();
                objPersonal = new Personal();
                objPersonal.setInt_idPersona(rs.getInt(1));
                objPersonal.setStr_apePaterno(rs.getString(2));
                objPersonal.setStr_apeMaterno(rs.getString(3));
                objPersonal.setStr_nombres(rs.getString(4));

                objContrato.setObjPersona(objPersonal);

                objEmpresa = new Empresa();
                objEmpresa.setInt_idEmpresa(rs.getInt(5));

                objContrato.setObjEmpresa(objEmpresa);
                objAsistencia.setObjContrato(objContrato);
                objAsistencia.setStr_direccionMarco(rs.getString(6));
                objAsistencia.setStr_horario(rs.getString(7));
                objAsistencia.setStr_fechaMarcado(rs.getString(8));
                objAsistencia.setStr_horaIngreso(rs.getString(9));
                objAsistencia.setStr_estadoMarcado(rs.getString(10));

                listaAsistencia.add(objAsistencia);


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
        return listaAsistencia;
    }

    @Override
    //cts
    public List<Asistencia> consultarFaltas(String fechaI, String fechaF, int empresa, String persona) {
        List<Asistencia> listaFaltas = new ArrayList<>();
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Asistencia objAsistencia;
        Contrato objContrato;
        Personal objPersonal;
        Empresa objEmpresa;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            String sql = " call sp_consultaFaltas ".concat(PrepararSQL.get(4));
            ps = cnn.prepareStatement(sql);
            ps.setString(1, fechaI);
            ps.setString(2, fechaF);
            ps.setInt(3, empresa);
            ps.setString(4, persona);
            rs = ps.executeQuery();

            while (rs.next()) {
                objPersonal = new Personal();
                objContrato = new Contrato();
                objEmpresa = new Empresa();
                objAsistencia = new Asistencia();

                objPersonal.setInt_idPersona(rs.getInt(1));
                objPersonal.setStr_apePaterno(rs.getString(2));
                objPersonal.setStr_apeMaterno(rs.getString(3));
                objPersonal.setStr_nombres(rs.getString(4));
                objPersonal.setStr_dni(rs.getString(5));

                objContrato.setObjPersona(objPersonal);

                objEmpresa.setInt_idEmpresa(rs.getInt(6));

                objContrato.setObjEmpresa(objEmpresa);

                objAsistencia.setObjContrato(objContrato);
                objAsistencia.setStr_direccionMarco(rs.getString(7));
                objAsistencia.setStr_horario(rs.getString(8));
                objAsistencia.setInt_asistencia(rs.getInt(9));
                objAsistencia.setStr_fechaMarcado(rs.getString(10));
                objAsistencia.setStr_estadoMarcado(rs.getString(11));

                listaFaltas.add(objAsistencia);
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
        return listaFaltas;
    }

    @Override
    public boolean registrarJustificacionEInasistencia(List<JustificacioneInasistencia> listaJEI) {
        boolean respuesta = false;
        Connection cnn = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            String sql = "";
            PreparedStatement ps = null;

            sql = "CALL sp_insertJustificacionEInasistencia" + PrepararSQL.get(4);

            for (JustificacioneInasistencia listaJEITemp : listaJEI) {
                ps = cnn.prepareStatement(sql);

                ps.setString(1, listaJEITemp.getStr_estado());
                ps.setString(2, listaJEITemp.getStr_UsuarioCreador());
                ps.setInt(3, listaJEITemp.getInt_idAsistencia());
                ps.setString(4, listaJEITemp.getStr_observacion());

                respuesta = ps.execute();
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
                    log.error("Error al intentar cerrar la BD: " + ex.getMessage());
                } catch (SQLException ex1) {
                    log.error("Error en el RollBack " + ex1.getMessage());
                }
            }
        }

        return respuesta;
    }

    @Override
    public boolean registroPartTime(int IdContrato, String strEstado, String strIniFin) {
        boolean respuesta = false;
        Connection cnn = null;


        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);
            String sql = "";
            PreparedStatement ps = null;

            sql = "CALL sp_insertarPartTime" + PrepararSQL.get(3);

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, IdContrato);

            ps.setString(2, strEstado);
            ps.setString(3, strIniFin);

            respuesta = ps.execute();


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
                    log.error("Error al intentar cerrar la BD: " + ex.getMessage());
                } catch (SQLException ex1) {
                    log.error("Error en el RollBack " + ex1.getMessage());
                }
            }
        }

        return respuesta;
    }

    @Override
    public List<PartTime> consultaPartTime(int intAsistencia) {
        List<PartTime> listaPartTime = new ArrayList<>();
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PartTime objPartTime;

//        Asistencia objAsistencia;
//            Contrato objContrato;
//                Personal objPersonal;
//                Empresa objEmpresa;
        try {

            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = " call sp_selectPartTime".concat(PrepararSQL.get(1));

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, intAsistencia);

            rs = ps.executeQuery();

            while (rs.next()) {
                objPartTime = new PartTime();

                objPartTime.setInt_idMedioTiempo(rs.getInt(1));
                objPartTime.setInt_asistencia(rs.getInt(2));
                objPartTime.setDte_marcacion(rs.getString(3));
                objPartTime.setStr_estado(rs.getString(4));
                objPartTime.setStr_iniFin(rs.getString(5));

                listaPartTime.add(objPartTime);


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
        return listaPartTime;
    }

    @Override
    public int idAsistencia(int idContrato) {
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idAsistencia = -1;

        try {

            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = " call sp_selectIdAsistencia".concat(PrepararSQL.get(1));

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, idContrato);

            rs = ps.executeQuery();
            while (rs.next()) {
                idAsistencia = rs.getInt(1);
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
        return idAsistencia;
    }

    @Override
    public HorarioJornadaContrato registrarAsistencia(String usuario, String password, boolean b) {
        
        
        

        HorarioJornadaContrato objHorarioJornadaContrato = new HorarioJornadaContrato();
        Contrato objContrato = new Contrato();
        HorarioJornada objHorarioJornada = new HorarioJornada();


        Personal objPersona = null;
        Connection cnn = null;
        
        
         //Variable para Encriptar
                EncriptionSource objEncriptador = new EncriptionSource();
                byte[] llave;
                String str_password_encryptado;
        try {
            //Atributos para la desencriptacion
            objKey_I = PaqueteBusinessDelegate.getKeyService();
            llave = FunctionByte.hex2byte(objKey_I.getKey().getKey());
                str_password_encryptado = FunctionByte.toHEX1(
                    objEncriptador.Encrypt(llave, password));
                
        } catch (ParserConfigurationException ex) {
            log.error("Error: "+ex.getMessage());
            return null;
        } catch (SAXException ex) {
            log.error("Error: "+ex.getMessage());
            return null;
        } catch (IOException ex) {
            log.error("Error: "+ex.getMessage());
            return null;
        }
                
        try {
            if (!b) {
                cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
                cnn.setAutoCommit(false);
                PreparedStatement ps = null;
                ResultSet rs = null;

                String sql;

                sql = "call sp_validaUsuarioRegistrarAsistencia".concat(PrepararSQL.get(3));

                
                ps = cnn.prepareStatement(sql);

                ps.setString(1, Util.ACTIVO);
                ps.setString(2, usuario);
                
                
            
                ps.setString(3, str_password_encryptado);

                rs = ps.executeQuery();

//                List<Personal> listaPersona = new ArrayList<>();

//                DPFPTemplate objAuxTemp;
                if (rs.next()) {
                    objPersona = new Personal();

                    objPersona.setInt_idPersona(rs.getInt(1));
                    objPersona.setStr_nombres(rs.getString(2));

//                    objAuxTemp = DPFPGlobal.getTemplateFactory().createTemplate();
//                    objAuxTemp.deserialize(rs.getBytes(3));
//                    objPersona.setBin_huellaDigital_1(objAuxTemp);
//
//                    objAuxTemp = DPFPGlobal.getTemplateFactory().createTemplate();
//                    objAuxTemp.deserialize(rs.getBytes(4));
//                    objPersona.setBin_huellaDigital_2(objAuxTemp);
                    objPersona.setStr_codigo(rs.getString(3));

//                    listaPersona.add(objPersona);

                }
//                final DPFPVerification verification =
//                        DPFPGlobal.getVerificationFactory().
//                        createVerification(MysqlAsistenciaDAO.this.farRequested.getNumber().intValue());

//                for (Personal personal : listaPersona) {
//                    final DPFPVerificationResult result1 = verification.verify(fe.getFeatureSet(), personal.getBin_huellaDigital_1());
//                    final DPFPVerificationResult result2 = verification.verify(fe.getFeatureSet(), personal.getBin_huellaDigital_2());
//                    fe.setMatched(result1.isVerified());
//
//                    if (fe.getMatched()) {
//                        objPersona = personal;
//                        break;
//                    }
//                    fe.setMatched(result2.isVerified());
//
//                    if (fe.getMatched()) {
//                        objPersona = personal;
//                        break;
//                    }
//
//                    if (!fe.getMatched()) {
//                        objPersona = null;
//                    }
//
//                }

                rs = null;
                ps = null;
//                listaPersona = null;

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
//                    objAuxTemp = DPFPGlobal.getTemplateFactory().createTemplate();
//                    if (!(rs.getBytes(22) == (null))) {
//                        objAuxTemp.deserialize(rs.getBytes(22));
//                        objPersona.setBin_huellaDigital_1(objAuxTemp);
//                    }
//
//                    if (!(rs.getBytes(23) == (null))) {
//                        objAuxTemp.deserialize(rs.getBytes(23));
//                        objPersona.setBin_huellaDigital_2(objAuxTemp);
//                    }

                    //Object Template Temporal para Deserializar la Huella Digital------------------------------------------

                    objPersona.setStr_estado(rs.getString(24));
                    objPersona.setDte_fechaCreacion(rs.getString(25));
                    objPersona.setStr_usuarioCreador(rs.getString(26));
                    objPersona.setDte_ultimaModificacion(rs.getString(27));
                    objPersona.setStr_usuarioModificador(rs.getString(28));
                    objPersona.setImgRead(rs.getBytes(29));

                }

                objContrato.setObjPersona(objPersona);

                //Objeto llamado para una consulta
                ContratoDAO objContratoDAO = new MysqlContratoDAO();
                List<HorarioJornadaContrato> lstObjContrato =
                        objContratoDAO.consultaContrato(objPersona.getStr_dni(), MysqlContratoDAO.QUERYCONSULTA);

                if (lstObjContrato.size() != 1) {
                    return null;
                }

                lstObjContrato.get(0).getObjContrato().setObjPersona(objPersona);
                objHorarioJornadaContrato.setObjContrato(lstObjContrato.get(0).getObjContrato());

                HorarioJornadaContrato objAuxHJC = objContratoDAO.consultaContrato(objHorarioJornadaContrato.getObjContrato().getInt_idContrato());

                objHorarioJornadaContrato.setObjListHorarioJornada(objAuxHJC.getObjListHorarioJornada());

                //            System.out.println("Size: "+objHorarioJornadaContrato.getObjListHorarioJornada().size());

                UtilMysqlDAO objUtilMysql = new MysqlUtilDAO();

                String fechaSistema = objUtilMysql.getFechaMysql();
                String nombreDia = Util.getNombreDia(Util.diaSemana(Util.StringTODate(fechaSistema)) - 1);

                //Filtramos el dia 
                //            for (HorarioJornada hj:objHorarioJornadaContrato.getObjListHorarioJornada()){
                //                
                //                if (!(nombreDia.equalsIgnoreCase(hj.getObjHorario().getStr_nombreHorario()))){
                //                   objHorarioJornadaContrato.getObjListHorarioJornada().remove(hj);
                //                    
                //                }
                //            }

                //Filtra el dia de Marcado
                for (int i = 0; i < objHorarioJornadaContrato.getObjListHorarioJornada().size(); i++) {
                    objHorarioJornada = objHorarioJornadaContrato.getObjListHorarioJornada().get(i);

                    if (!objHorarioJornada.getObjHorario().
                            getStr_nombreHorario().equalsIgnoreCase(nombreDia)) {

                        objHorarioJornadaContrato.getObjListHorarioJornada().remove(objHorarioJornada);
                        i--;
                    }
                }
                //            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); 
                //            String hora,horaAdd,horaRe;
                long lhoraAdd, lhoraRe, lhoraAddSalida, lhoraReSalida;
                String strhoraSistema = (Util.StringTODateTime(Util.StringTODateLong(fechaSistema)));
                long lhoraSistema = (Util.StringToDateTimeAddLong(Util.StringTODateTime(strhoraSistema), 0));

                //            System.out.println("Hora del Sistema: "+strhoraSistema);
                List<HorarioJornada> lstAuxHorarioJornada = new ArrayList<>();

                //Filtra y determina si es ingreso o salida
                //            int tiempo[];
                long minutoTarde = 0;
                for (HorarioJornada hj : objHorarioJornadaContrato.getObjListHorarioJornada()) {
                    //                System.out.println(PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[0]);
                    //                tiempo=PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera();
                    //                System.out.println("Paso");
                    lhoraAdd = (Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_HoraInicio()), PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[1]));
                    lhoraAddSalida = (Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_horaFin()), PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[1]));

                    lhoraRe = (Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_HoraInicio()),
                            PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[0]));
                    lhoraReSalida = (Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_horaFin()),
                            PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[0]));


                    rs = null;
                    ps = null;

                    sql = "call sp_consultaMarco ".concat(PrepararSQL.get(3));

                    int idAsistencia = -1;

                    ps = cnn.prepareStatement(sql);
                    int puntero = 0;


                    if (lhoraSistema >= lhoraRe && lhoraSistema <= lhoraAdd) {
                        lstAuxHorarioJornada.add(hj);
                        log.info("Marco Entrada");
                        long minutosHoraMarcado = Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_HoraInicio()), 0);

                        if (minutosHoraMarcado >= lhoraSistema) {
                            minutoTarde = 0;
                        } else {
                            minutoTarde = lhoraSistema - minutosHoraMarcado;
                        }

                        for (int i = 0; i < objHorarioJornadaContrato.getObjListHorarioJornada().size(); i++) {
                            //hp=obj.get(i);
                            ps.setInt(1, objHorarioJornadaContrato.getObjContrato().getInt_idContrato()); //Contrato
                            ps.setInt(2, objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idHorario()); //Horario
                            ps.setInt(3, objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idJornada()); //Jornada

                            rs = ps.executeQuery();

                            puntero = 0;

                            while (rs.next()) {
                                puntero++;

                            }
                        }

                        if (puntero >= 1) {

                            Mensaje.mensaje("Usted ya Marco su Ingreso", Mensaje.TITULO_ME, Mensaje.ERROR);
                            return null;
                        }
                    } else if (lhoraSistema >= lhoraReSalida && lhoraSistema <= lhoraAddSalida) {



                        lstAuxHorarioJornada.add(hj);
                        log.info("Marco Salida");
                        minutoTarde = -1;


                        for (int i = 0; i < objHorarioJornadaContrato.getObjListHorarioJornada().size(); i++) {
                            //hp=obj.get(i);
                            ps.setInt(1, objHorarioJornadaContrato.getObjContrato().getInt_idContrato()); //Contrato
                            ps.setInt(2, objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idHorario()); //Horario
                            ps.setInt(3, objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idJornada()); //Jornada

                            rs = ps.executeQuery();

                            puntero = 0;


                            while (rs.next()) {
                                puntero++;
                                idAsistencia = rs.getInt(1);
                            }
                        }

                        if (puntero >= 2) {
                            Mensaje.mensaje("Usted ya Marco su Salida", Mensaje.TITULO_ME, Mensaje.ERROR);
                            return null;
                        } else {
                            //valida si regreso del refrigerio======================
                            rs = null;
                            ps = null;

                            sql = "call sp_salioRefrigerio ".concat(PrepararSQL.get(2));

                            ps = cnn.prepareStatement(sql);

                            ps.setInt(1, idAsistencia);
                            ps.setString(2, Util.ACTIVO);



                            rs = ps.executeQuery();

                            if (rs.next()) {
                                Mensaje.mensaje("Usted no Marco su Ingreso del Refrigerio, No Puede Marcar Su Salida", Mensaje.TITULO_ME, Mensaje.ERROR);
                                return null;
                            }

                            //valida si regreso del refrigerio======================

                        }



                    }

                }

                objHorarioJornadaContrato.setObjListHorarioJornada(lstAuxHorarioJornada);

                //Retorna Null si despues del filtro no cuent con horarios
                if (objHorarioJornadaContrato.getObjListHorarioJornada().size() < 1) {
                    rs = null;
                    ps = null;

                    sql = "call sp_permisosXPersona ".concat(PrepararSQL.get(2));

                    ps = cnn.prepareStatement(sql);

                    //                System.out.println(Util.stringTOint( objPersona.getStr_codigo().substring(1)));
                    ps.setInt(1, Util.stringTOint(objPersona.getStr_codigo().substring(1)));
                    ps.setString(2, Util.APROBADO);

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        String horaServidor;

                        Permisos objPermisos = new Permisos();
                        objPermisos.setInt_idPermisos(rs.getInt(1));
                        objPermisos.setDte_fecha(rs.getString(2));
                        objPermisos.setStr_motivo(rs.getString(3));
                        objPermisos.setTm_horaSalida(rs.getString(4));
                        objPermisos.setTm_horaLlegada(rs.getString(5));
                        objPermisos.setStr_observacion(rs.getString(6));
                        objPermisos.setStr_estado(rs.getString(7));
                        objPermisos.setTm_horaMarcadoSalida(rs.getString(8));
                        objPermisos.setTm_horaMarcadoLlegada(rs.getString(9));
                        objPermisos.setDte_fechaRegistro(rs.getString(10));
                        objPermisos.setInt_idPersona(rs.getInt(11));
                        horaServidor = rs.getString(12);

                        String tipoMarcado;
                        if (objPermisos.getTm_horaMarcadoSalida() == null) {
                            objPermisos.setTm_horaMarcadoSalida(horaServidor);
                            //                       objPermisos.setTm_horaMarcadoLlegada("00:00:00");
                            tipoMarcado = "Marco Salida Por Permiso";
                        } else {
                            objPermisos.setTm_horaMarcadoLlegada(horaServidor);
                            objPermisos.setStr_estado(Util.CUMPLIDOS);
                            tipoMarcado = "Marco Entrada Por Permiso";
                        }

                        rs = null;
                        ps = null;

                        sql = "call sp_registrarMarcadoPorPermiso ".concat(PrepararSQL.get(4));
                        ps = cnn.prepareStatement(sql);

                        ps.setInt(1, objPermisos.getInt_idPermisos());
                        ps.setString(2, objPermisos.getTm_horaMarcadoSalida());
                        ps.setString(3, objPermisos.getTm_horaMarcadoLlegada());
                        ps.setString(4, objPermisos.getStr_estado());

                        ps.execute();



                        JPanel pnlFoto = new JPanel();
                        pnlFoto.setLayout(new BorderLayout());
                        pnlFoto.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
                        //                   pnlDetalle.setBounds(0, 0, 500, 500);

                        JPanel pnlDetalle = new JPanel();
                        pnlDetalle.setLayout(null);
                        //                   pnlDetalle.setBounds(100,0,300,200);
                        //                   pnlDetalle.setSize(300,200);
                        pnlDetalle.setPreferredSize(new Dimension(230, 150));
                        pnlDetalle.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

                        JPanel pnlAll = new JPanel();
                        pnlAll.setLayout(new GridLayout());

                        pnlAll.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Marcado de Permiso", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));


                        pnlAll.add(pnlFoto);
                        pnlAll.add(pnlDetalle);


                        JLabel lblFoto = new JLabel();
                        lblFoto.setSize(230, 150);
                        pnlFoto.add(new JLabel(), BorderLayout.NORTH);
                        pnlFoto.add(new JLabel(), BorderLayout.SOUTH);
                        pnlFoto.add(new JLabel(), BorderLayout.EAST);
                        pnlFoto.add(new JLabel(), BorderLayout.WEST);
                        pnlFoto.add(lblFoto, BorderLayout.CENTER);

                        try {
                            if (objHorarioJornadaContrato.getObjContrato().getObjPersona().getImgRead() != null) {
                                Image foto = com.gestionmatriz.util.Util.ConvertirImagen(
                                        objHorarioJornadaContrato.getObjContrato().getObjPersona().getImgRead());

                                ImageIcon iconofoto = new ImageIcon(foto);

                                Icon fotoIncono = com.gestionmatriz.util.Util.reducirFoto(
                                        iconofoto, lblFoto.getWidth(), lblFoto.getHeight());

                                lblFoto.setIcon(fotoIncono);

                            }
                        } catch (IOException ex) {
                            log.error("Error: " + ex.getMessage());
                        }




                        //                   lblUsuario.setBounds(50,0,50,20);



                        JLabel lblUsuario = new JLabel(objPersona.getStr_nombres() + " "
                                + objPersona.getStr_apePaterno() + " "
                                + objPersona.getStr_apeMaterno());
                        pnlDetalle.add(lblUsuario);

                        JLabel lblHoraSalida = new JLabel("Hora. Salida: " + objPermisos.getTm_horaSalida());
                        lblHoraSalida.setBounds(0, 15, 230, 20);
                        pnlDetalle.add(lblHoraSalida);
                        lblHoraSalida.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

                        JLabel lblHoraLlegada = new JLabel("Hora. Llegada: " + objPermisos.getTm_horaLlegada());
                        lblHoraLlegada.setBounds(0, 40, 230, 20);
                        pnlDetalle.add(lblHoraLlegada);
                        lblHoraLlegada.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

                        JLabel lblHoraMarcado = new JLabel("Hora. Marcado: " + horaServidor);
                        lblHoraMarcado.setBounds(0, 65, 230, 20);
                        pnlDetalle.add(lblHoraMarcado);
                        lblHoraMarcado.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

                        JLabel lblEstado = new JLabel("T. Marcado: " + tipoMarcado);
                        lblEstado.setBounds(0, 90, 230, 20);
                        pnlDetalle.add(lblEstado);
                        lblEstado.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
                        lblEstado.setFont(new Font("command", Font.BOLD, 12));



                        //                   Mensaje.mensaje(null, pnlDetalle, Mensaje.INFORMACION);

                        JOptionPane.showMessageDialog(null, pnlAll, Mensaje.TITULO_ME, JOptionPane.INFORMATION_MESSAGE);
                        //                   JDialog objMensaje =new JDialog(this);
                        //                   objMensaje.add(pnlDetalle);
                        //                   objMensaje.setVisible(true);

                        cnn.commit();
                    }

                    return null;


                }

                //            for (HorarioJornada hj: objHorarioJornadaContrato.getObjListHorarioJornada()){
                //                System.out.println("Dia : "+hj.getObjHorario().getStr_nombreHorario());
                //                System.out.println("Hora: "+hj.getObjJornada().getTme_HoraInicio());
                //            }




                ps = null;
                sql = "call sp_registrarAsistencia " + PrepararSQL.get(5);

                ps = cnn.prepareStatement(sql);

                ps.setInt(1, objHorarioJornadaContrato.getObjListHorarioJornada().get(0).getObjHorario().getInt_idHorario());
                ps.setInt(2, objHorarioJornadaContrato.getObjListHorarioJornada().get(0).getObjJornada().getInt_idJornada());
                ps.setInt(3, objHorarioJornadaContrato.getObjContrato().getInt_idContrato());
                ps.setString(4, String.valueOf(TipoMarcado.ASISTENCIA));
                ps.setString(5, Util.ACTIVO);

                ps.execute();

                cnn.commit();
                return objHorarioJornadaContrato;

            } else {


                cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
                cnn.setAutoCommit(false);
                PreparedStatement ps = null;
                ResultSet rs = null;

                String sql;

//                sql = "call sp_listaHuellas".concat(PrepararSQL.get(1));

                sql = "call sp_validaUsuarioRegistrarAsistencia".concat(PrepararSQL.get(3));



                ps = cnn.prepareStatement(sql);

                ps.setString(1, Util.ACTIVO);
                ps.setString(2, usuario);
                ps.setString(3, str_password_encryptado);
                

//                ps = cnn.prepareStatement(sql);
//
//                ps.setString(1, Util.ACTIVO);

                rs = ps.executeQuery();

//                List<Personal> listaPersona = new ArrayList<>();

//                DPFPTemplate objAuxTemp;
                if (rs.next()) {
                    objPersona = new Personal();

                    objPersona.setInt_idPersona(rs.getInt(1));
                    objPersona.setStr_nombres(rs.getString(2));

//                    objAuxTemp = DPFPGlobal.getTemplateFactory().createTemplate();
//                    objAuxTemp.deserialize(rs.getBytes(3));
//                    objPersona.setBin_huellaDigital_1(objAuxTemp);
//
//                    objAuxTemp = DPFPGlobal.getTemplateFactory().createTemplate();
//                    objAuxTemp.deserialize(rs.getBytes(4));
//                    objPersona.setBin_huellaDigital_2(objAuxTemp);
                    objPersona.setStr_codigo(rs.getString(3));

//                    listaPersona.add(objPersona);

                }
//                final DPFPVerification verification =
//                        DPFPGlobal.getVerificationFactory().
//                        createVerification(MysqlAsistenciaDAO.this.farRequested.getNumber().intValue());
//
//                for (Personal personal : listaPersona) {
//                    final DPFPVerificationResult result1 = verification.verify(fe.getFeatureSet(), personal.getBin_huellaDigital_1());
//                    final DPFPVerificationResult result2 = verification.verify(fe.getFeatureSet(), personal.getBin_huellaDigital_2());
//                    fe.setMatched(result1.isVerified());
//
//                    if (fe.getMatched()) {
//                        objPersona = personal;
//                        break;
//                    }
//                    fe.setMatched(result2.isVerified());
//
//                    if (fe.getMatched()) {
//                        objPersona = personal;
//                        break;
//                    }
//
//                    if (!fe.getMatched()) {
//                        objPersona = null;
//                    }
//
//                }

                rs = null;
                ps = null;
//                listaPersona = null;

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
//                    objAuxTemp = DPFPGlobal.getTemplateFactory().createTemplate();
//                    if (!(rs.getBytes(22) == (null))) {
//                        objAuxTemp.deserialize(rs.getBytes(22));
//                        objPersona.setBin_huellaDigital_1(objAuxTemp);
//                    }
//
//                    if (!(rs.getBytes(23) == (null))) {
//                        objAuxTemp.deserialize(rs.getBytes(23));
//                        objPersona.setBin_huellaDigital_2(objAuxTemp);
//                    }

                    //Object Template Temporal para Deserializar la Huella Digital------------------------------------------

                    objPersona.setStr_estado(rs.getString(24));
                    objPersona.setDte_fechaCreacion(rs.getString(25));
                    objPersona.setStr_usuarioCreador(rs.getString(26));
                    objPersona.setDte_ultimaModificacion(rs.getString(27));
                    objPersona.setStr_usuarioModificador(rs.getString(28));
                    objPersona.setImgRead(rs.getBytes(29));

                }

                objContrato.setObjPersona(objPersona);

                //Objeto llamado para una consulta
                ContratoDAO objContratoDAO = new MysqlContratoDAO();
                List<HorarioJornadaContrato> lstObjContrato =
                        objContratoDAO.consultaContrato(objPersona.getStr_dni(), MysqlContratoDAO.QUERYCONSULTA);

                if (lstObjContrato.size() != 1) {
                    return null;
                }

                lstObjContrato.get(0).getObjContrato().setObjPersona(objPersona);
                objHorarioJornadaContrato.setObjContrato(lstObjContrato.get(0).getObjContrato());

                HorarioJornadaContrato objAuxHJC = objContratoDAO.consultaContrato(objHorarioJornadaContrato.getObjContrato().getInt_idContrato());

                objHorarioJornadaContrato.setObjListHorarioJornada(objAuxHJC.getObjListHorarioJornada());

                //            System.out.println("Size: "+objHorarioJornadaContrato.getObjListHorarioJornada().size());

                UtilMysqlDAO objUtilMysql = new MysqlUtilDAO();

                String fechaSistema = objUtilMysql.getFechaMysql();
                String nombreDia = Util.getNombreDia(Util.diaSemana(Util.StringTODate(fechaSistema)) - 1);

                //Filtramos el dia 
                //            for (HorarioJornada hj:objHorarioJornadaContrato.getObjListHorarioJornada()){
                //                
                //                if (!(nombreDia.equalsIgnoreCase(hj.getObjHorario().getStr_nombreHorario()))){
                //                   objHorarioJornadaContrato.getObjListHorarioJornada().remove(hj);
                //                    
                //                }
                //            }

                //Filtra el dia de Marcado
                for (int i = 0; i < objHorarioJornadaContrato.getObjListHorarioJornada().size(); i++) {
                    objHorarioJornada = objHorarioJornadaContrato.getObjListHorarioJornada().get(i);

                    if (!objHorarioJornada.getObjHorario().
                            getStr_nombreHorario().equalsIgnoreCase(nombreDia)) {

                        objHorarioJornadaContrato.getObjListHorarioJornada().remove(objHorarioJornada);
                        i--;
                    }
                }
                //            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); 
                //            String hora,horaAdd,horaRe;
                long lhoraIngreso, lhoraSalida;
                String strhoraSistema = (Util.StringTODateTime(Util.StringTODateLong(fechaSistema)));
                long lhoraSistema = (Util.StringToDateTimeAddLong(Util.StringTODateTime(strhoraSistema), 0));

                //            System.out.println("Hora del Sistema: "+strhoraSistema);
                List<HorarioJornada> lstAuxHorarioJornada = new ArrayList<>();

                //Filtra y determina si es ingreso o salida
                //            int tiempo[];
                //            long minutoTarde=0;
                for (HorarioJornada hj : objHorarioJornadaContrato.getObjListHorarioJornada()) {
                    ////                System.out.println(PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[0]);
                    ////                tiempo=PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera();
                    ////                System.out.println("Paso");
                    lhoraIngreso = (Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_HoraInicio()), 0));
                    lhoraSalida = (Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_horaFin()), 0));
                    //                        
                    //                lhoraRe=(Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_HoraInicio()),
                    //                        PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[0]));
                    //                lhoraReSalida=(Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_horaFin()),
                    //                        PaqueteBusinessDelegate.getConfigBDService().getTiempoEspera()[0]));


                    rs = null;
                    ps = null;

                    sql = "call sp_consultaMarco ".concat(PrepararSQL.get(3));

                    ps = cnn.prepareStatement(sql);
                    int puntero = 0;
                    int idAsistencia = -1;

                    if (lhoraSistema >= lhoraIngreso && lhoraSistema <= lhoraSalida) {
                        lstAuxHorarioJornada.add(hj);
                        //                    System.out.println("Marco Salida Refrigerio");
                        //                    long minutosHoraMarcado=Util.StringToDateTimeAddLong(Util.StringTODateTime(hj.getObjJornada().getTme_HoraInicio())
                        //                        ,0);

                        //                    if (minutosHoraMarcado>=lhoraSistema)
                        //                        minutoTarde=0;
                        //                    else
                        //                        minutoTarde=lhoraSistema-minutosHoraMarcado;

                        for (int i = 0; i < objHorarioJornadaContrato.getObjListHorarioJornada().size(); i++) {
                            //hp=obj.get(i);
                            ps.setInt(1, objHorarioJornadaContrato.getObjContrato().getInt_idContrato()); //Contrato
                            ps.setInt(2, objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idHorario()); //Horario
                            ps.setInt(3, objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idJornada()); //Jornada

                            rs = ps.executeQuery();

                            puntero = 0;
                            while (rs.next()) {
                                if (rs.getString(7).trim().equalsIgnoreCase(String.valueOf(TipoMarcado.ASISTENCIA))) {
                                    puntero++;
                                    idAsistencia = rs.getInt(1);
                                }



                            }
                        }

                        if (puntero == 1) {
                            rs = null;
                            ps = null;

                            sql = "call sp_salioRefrigerio ".concat(PrepararSQL.get(2));

                            ps = cnn.prepareStatement(sql);

                            ps.setInt(1, idAsistencia);
                            ps.setString(2, Util.ACTIVO);



                            rs = ps.executeQuery();

                            int punteroRefrigerio = 0;
                            String horaSalidaRefrigerio = "";
                            int idRefrigerio = -1;
                            while (rs.next()) {
                                punteroRefrigerio++;
                                horaSalidaRefrigerio = Util.StringTODateTime(Util.StringTODateLong(rs.getString(2)));
                                idRefrigerio = rs.getInt(1);
                            }


                            if (punteroRefrigerio < 1) {
                                if (this.puntero != -1) {
                                    return null;
                                }

                                this.puntero = 1;
                                Object objRespuesta = Mensaje.confirmar(null, "Desea Marcar su Salida a Refrigerio a la " + strhoraSistema + " ?",
                                        Mensaje.TITULO_OP,
                                        Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);


                                if (objRespuesta.equals(Mensaje.YES_OPTION)) {
                                    rs = null;
                                    ps = null;

                                    sql = "call sp_salioRefrigerio ".concat(PrepararSQL.get(2));

                                    ps = cnn.prepareStatement(sql);

                                    ps.setInt(1, idAsistencia);
                                    ps.setString(2, Util.CUMPLIDOS);



                                    rs = ps.executeQuery();

                                    if (rs.next()) {
                                        Mensaje.mensaje("Usted ya Tomo su Refrigerio", Mensaje.TITULO_ME, Mensaje.ERROR);
                                        return null;
                                    }

                                    rs = null;
                                    ps = null;

                                    sql = "call sp_insertRefrigerio ".concat(PrepararSQL.get(2));
                                    ps = cnn.prepareStatement(sql);

                                    ps.setString(1, Util.ACTIVO);
                                    ps.setInt(2, idAsistencia);

                                    ps.execute();

                                    String horaRefrigerio = Util.StringTODateTime(Util.StringTODateLong(objUtilMysql.getFechaMysql()));
                                    Mensaje.mensaje("•\tSu Refrigerio se Inicio a las: "
                                            + horaRefrigerio
                                            + "\n•\tLa Hora de Regreso es: " + Util.StringToDateTimeAdd(
                                            Util.StringTODateLong(objUtilMysql.getFechaMysql()), 120), Mensaje.TITULO_ME, Mensaje.INFORMACION);
                                    cnn.commit();
                                }
//                              Mensaje.mensaje("Usted ya Marco su Ingreso", Mensaje.TITULO_ME,Mensaje.ERROR);
                                this.puntero = -1;
                                return null;
                            } else if (punteroRefrigerio == 1) {
                                rs = null;
                                ps = null;


                                sql = "call sp_updateRefrigerio ".concat(PrepararSQL.get(2));
                                long lHoraSalidaRefrigerio = (Util.StringToDateTimeAddLong(Util.StringTODateTime(horaSalidaRefrigerio), 125));
                                String horaRefrigerio = Util.StringTODateTime(Util.StringTODateLong(objUtilMysql.getFechaMysql()));


                                long lhoraSistemaRefrigerio = (Util.StringToDateTimeAddLong(Util.StringTODateTime(horaRefrigerio), 0));

                                if (lhoraSistemaRefrigerio <= lHoraSalidaRefrigerio) {
                                    ps = cnn.prepareStatement(sql);
                                    ps.setInt(1, idRefrigerio);
                                    ps.setString(2, Util.CUMPLIDOS);

                                    ps.execute();

                                    Mensaje.mensaje("Se Registró su Ingreso del Refrigerio con Éxito", Mensaje.TITULO_ME, Mensaje.INFORMACION);
                                    cnn.commit();

                                } else {
                                    Mensaje.mensaje("Fuera del Rango de Regreso del Refrigerio", Mensaje.TITULO_ME, Mensaje.ERROR);
                                }

                            }


                        }
                    }
                    //                else if (lhoraSistema>=lhoraReSalida && lhoraSistema<=lhoraAddSalida){
                    //                     lstAuxHorarioJornada.add(hj);
                    //                     System.out.println("Marco Regreso Refrigerio");
                    ////                     minutoTarde=-1;
                    //                     
                    //                     
                    //                      for (int i=0;i<objHorarioJornadaContrato.getObjListHorarioJornada().size();i++){
                    //                         //hp=obj.get(i);
                    //                         ps.setInt(1, objHorarioJornadaContrato.getObjContrato().getInt_idContrato()); //Contrato
                    //                         ps.setInt(2,objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idHorario()); //Horario
                    //                         ps.setInt(3,objHorarioJornadaContrato.getObjListHorarioJornada().get(i).getInt_idJornada()); //Jornada
                    //
                    //                         rs=ps.executeQuery();
                    //
                    //                         puntero=0;
                    //                         while (rs.next()){
                    //                             puntero++;
                    //                         }
                    //                     }

                    //                    if (puntero>=2)
                    //                    {
                    //                        Mensaje.mensaje("Usted ya Marco su Salida", Mensaje.TITULO_ME,Mensaje.ERROR);
                    //                        return null;
                    //                    }

                    //                }

                }

//                objHorarioJornadaContrato.setObjListHorarioJornada(lstAuxHorarioJornada);

                return null;
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
        return null;

        
    }
}
