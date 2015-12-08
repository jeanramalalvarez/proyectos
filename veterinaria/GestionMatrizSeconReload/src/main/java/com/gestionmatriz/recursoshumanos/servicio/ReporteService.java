/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.recursoshumanos.dao.ReporteDAO;

import java.util.List;

/**
 *
 * @author zholo
 */
public class ReporteService implements ReporteService_I{
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);		
    ReporteDAO objReporteDAO =fabrica.getReporteDAO();

    @Override
    public List<Personal> listaPersonaMemo() {
        return objReporteDAO.listaPersonaMemo(); 
    }

    @Override
    public List<Personal> listaPersonalFunciones() {
        return objReporteDAO.listaPersonaFunciones();
    }

    @Override
    public List<Personal> listaPersonalPermisos() {
        return objReporteDAO.listaPersonaPermisos();
    }
    
    
}
