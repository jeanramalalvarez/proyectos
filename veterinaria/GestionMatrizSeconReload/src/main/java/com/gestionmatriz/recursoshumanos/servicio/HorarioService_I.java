/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.gestionmatriz.recursoshumanos.bean.HorarioJornada;
import com.gestionmatriz.recursoshumanos.bean.Horarios;
import com.gestionmatriz.recursoshumanos.bean.Jornada;

import java.util.List;

/**
 *
 * @author zholo
 */
public interface HorarioService_I {

    public List<Horarios> listarHorarios() throws Exception;

    public List<Jornada> listarJornadas() throws Exception;

    public List<Jornada> listarJornadasDisponibles(int idHorario) throws Exception;

    public List<HorarioJornada> listarHorarioJornada(String estado) throws Exception;

    public boolean registrarHorario(Jornada objJornada) throws Exception;

    public boolean registrarHorarioJornada(List<HorarioJornada> objHorarioJornada) throws Exception;
}
