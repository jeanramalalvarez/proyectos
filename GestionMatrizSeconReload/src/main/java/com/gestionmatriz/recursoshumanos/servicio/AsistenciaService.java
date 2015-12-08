/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.digitalpersona.onetouch.ui.swing.DPFPVerificationEvent;
import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.recursoshumanos.bean.Asistencia;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornadaContrato;
import com.gestionmatriz.recursoshumanos.bean.JustificacioneInasistencia;
import com.gestionmatriz.recursoshumanos.bean.PartTime;
import com.gestionmatriz.recursoshumanos.dao.AsistenciaDAO;
import java.util.List;

/**
 *
 * @author YESM
 */
public class AsistenciaService implements Asistencia_I{
     DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);		
    AsistenciaDAO objAsistenciaDAO =fabrica.getAsistenciaDAO();
    
    @Override
    public HorarioJornadaContrato registrarAsistencia(DPFPVerificationEvent fe,boolean b) {
        return objAsistenciaDAO.registrarAsistencia(fe,b);
    }

    @Override
    public List<Asistencia> consultarAsistencia(String fechaI, String fechaF, int empresa) {
        return objAsistenciaDAO.consultarAsistencia(fechaI, fechaF, empresa);
    }
    
     @Override
    public List<Asistencia> consultarFaltas(String fechaI, String fechaF, int empresa, String persona) {
        return objAsistenciaDAO.consultarFaltas(fechaI, fechaF, empresa, persona);
    }

    @Override
    public boolean registrarJustificacionEInasistencia(List<JustificacioneInasistencia> objJEI) {
        return objAsistenciaDAO.registrarJustificacionEInasistencia(objJEI);
    }

    @Override
    public boolean registroPartTime(int IdContrato, String strEstado, String strIniFin) {
        return objAsistenciaDAO.registroPartTime(IdContrato, strEstado, strIniFin);
    }

    @Override
    public List<PartTime> consultaPartTime(int intAsistencia) {
        return objAsistenciaDAO.consultaPartTime(intAsistencia);
    }

    @Override
    public int idAsistencia(int idContrato) {
        return objAsistenciaDAO.idAsistencia(idContrato);
    }

    @Override
    public HorarioJornadaContrato registrarAsistencia(String usuario, String password, boolean b) {
        return objAsistenciaDAO.registrarAsistencia(usuario, password, b);
    }
    
    
    
}
