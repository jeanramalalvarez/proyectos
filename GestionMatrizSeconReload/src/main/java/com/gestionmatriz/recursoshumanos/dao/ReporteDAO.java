/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.Personal;

import java.util.List;

/**
 *
 * @author zholo
 */
public interface ReporteDAO {

    public List<Personal> listaPersonaMemo();

    public List<Personal> listaPersonaFunciones();

    public List<Personal> listaPersonaPermisos();
    
}
