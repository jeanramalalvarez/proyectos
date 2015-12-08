/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.gestionmatriz.recursoshumanos.bean.Personal;

import java.util.List;

/**
 *
 * @author zholo
 */
public interface ReporteService_I {
    
    public abstract List<Personal>listaPersonaMemo();
    public abstract List<Personal>listaPersonalFunciones();
    public abstract List<Personal>listaPersonalPermisos();
}
