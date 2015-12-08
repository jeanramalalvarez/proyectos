/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.HorarioJornada;
import com.gestionmatriz.recursoshumanos.bean.Horarios;
import com.gestionmatriz.recursoshumanos.bean.Jornada;

import java.util.List;

/**
 *
 * @author zholo
 */
public interface HorarioDAO {

    public List<Horarios> listarHorarios();

    public List<Jornada> listarJornadas();

    public List<Jornada> listarJornadasDisponibles(int idHorario);

    public boolean registrarHorario(Jornada objJornada);

    public boolean registrarHorarioJornada(List<HorarioJornada> objHorarioJornada);

    public List<HorarioJornada> listarHorarioJornada(String estado);
}
