/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.UnidadMedida;

import java.util.List;

/**
 *
 * @author zholo
 */
public interface UnidadMedidaDAO {

    public abstract List<UnidadMedida> listarUnidadMedida(String codigoUM, String nombre);
    
    public abstract boolean registrarUM(UnidadMedida objUM);

    public abstract boolean modificarUM(UnidadMedida objUM);
    
    public abstract String verificarNombre(String nombre);
}
