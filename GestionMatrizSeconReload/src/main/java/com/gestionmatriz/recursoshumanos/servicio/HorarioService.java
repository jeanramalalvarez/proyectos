/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornada;
import com.gestionmatriz.recursoshumanos.bean.Horarios;
import com.gestionmatriz.recursoshumanos.bean.Jornada;
import com.gestionmatriz.recursoshumanos.dao.HorarioDAO;

import java.util.List;

/**
 *
 * @author zholo
 */
public class HorarioService implements HorarioService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    HorarioDAO objHorarioDAO = fabrica.getHorarioDAO();

    @Override
    public List<Horarios> listarHorarios() throws Exception {
        return objHorarioDAO.listarHorarios();
    }

    @Override
    public List<Jornada> listarJornadas() throws Exception {
        return objHorarioDAO.listarJornadas();
    }

    public boolean registrarHorario(Jornada objJornada) throws Exception {
        return objHorarioDAO.registrarHorario(objJornada);
    }

    @Override
    public boolean registrarHorarioJornada(List<HorarioJornada> objHorarioJornada) throws Exception {
        return objHorarioDAO.registrarHorarioJornada(objHorarioJornada);
    }

    @Override
    public List<HorarioJornada> listarHorarioJornada(String estado) throws Exception {
        return objHorarioDAO.listarHorarioJornada(estado);
    }

    @Override
    public List<Jornada> listarJornadasDisponibles(int idHorario) throws Exception {
        return objHorarioDAO.listarJornadasDisponibles(idHorario);
    }
}
