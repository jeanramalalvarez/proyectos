/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.Permisos;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface PermisoDAO {
    public abstract boolean registrarPermiso(Permisos objPermiso);
    public abstract List<Permisos> listaPermisos(String fi,String ff);
    public abstract boolean actualizarEstadoPermiso(int idPermiso, String estado,String usuario);
    public abstract List<Permisos> listaPermisosXPersona(int persona);
}
