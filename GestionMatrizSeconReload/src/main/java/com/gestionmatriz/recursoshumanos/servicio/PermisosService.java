/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.recursoshumanos.bean.Permisos;
import com.gestionmatriz.recursoshumanos.dao.PermisoDAO;
import java.util.List;

/**
 *
 * @author zholo
 */
public class PermisosService implements  PermisosService_I{
    
    DAOFactory factoria= DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    PermisoDAO objPermisoDAO=factoria.getPermisoDAO();
    
    @Override
    public boolean registrarPermiso(Permisos objPermiso) {
        return objPermisoDAO.registrarPermiso(objPermiso);
    }

    @Override
    public List<Permisos> listaPermisos(String fi,String ff) {
        return objPermisoDAO.listaPermisos(fi,ff);
    }

    @Override
    public boolean actualizarEstadoPermiso(int idPermiso, String estado,String usuario) {
        return objPermisoDAO.actualizarEstadoPermiso(idPermiso, estado,usuario);
    }

    @Override
    public List<Permisos> listaPermisosXPersona(int persona) {
        return objPermisoDAO.listaPermisosXPersona(persona);
    }
    
    
}
