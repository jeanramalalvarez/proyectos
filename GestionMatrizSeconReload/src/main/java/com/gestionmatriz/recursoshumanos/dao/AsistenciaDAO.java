/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.digitalpersona.onetouch.ui.swing.DPFPVerificationEvent;
import com.gestionmatriz.recursoshumanos.bean.Asistencia;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornadaContrato;

import com.gestionmatriz.recursoshumanos.bean.JustificacioneInasistencia;
import com.gestionmatriz.recursoshumanos.bean.PartTime;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import java.util.List;

/**
 *
 * @author YESM
 */
public interface AsistenciaDAO {

    public abstract HorarioJornadaContrato registrarAsistencia(DPFPVerificationEvent fe, boolean b);
    
    public abstract HorarioJornadaContrato registrarAsistencia(String usuario,String password,boolean b);
    
    public abstract List<Asistencia> consultarAsistencia(String fechaI, String fechaF, int empresa);

    public abstract List<Personal> personaConHorarioMarcar();

    public abstract List<Asistencia> consultarFaltas(String fechaI, String fechaF, int empresa, String persona);

    public abstract boolean registrarJustificacionEInasistencia(List<JustificacioneInasistencia> objJEI);
    
    public abstract boolean registroPartTime(int IdContrato,String strEstado,String strIniFin);

    public List<PartTime> consultaPartTime(int intAsistencia);

    public int idAsistencia(int idContrato);
}
