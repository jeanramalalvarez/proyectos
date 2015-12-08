/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.digitalpersona.onetouch.ui.swing.DPFPVerificationEvent;
import com.gestionmatriz.recursoshumanos.bean.Asistencia;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornadaContrato;
import com.gestionmatriz.recursoshumanos.bean.JustificacioneInasistencia;
import com.gestionmatriz.recursoshumanos.bean.PartTime;
import java.util.List;

/**
 *
 * @author YESM
 */
public interface Asistencia_I {

    public abstract HorarioJornadaContrato registrarAsistencia(DPFPVerificationEvent fe, boolean b);
    
    public abstract HorarioJornadaContrato registrarAsistencia(String usuario,String password,boolean b);

    public abstract List<Asistencia> consultarAsistencia(String fechaI, String fechaF, int empresa);

    public abstract List<Asistencia> consultarFaltas(String fechaI, String fechaF, int empresa, String persona);

    public abstract boolean registrarJustificacionEInasistencia(List<JustificacioneInasistencia> listaJEI);
    
    public abstract boolean registroPartTime(int IdContrato,String strEstado,String strIniFin);
    
    public abstract List<PartTime> consultaPartTime(int intAsistencia);
    
    public abstract int idAsistencia(int idContrato);
}
