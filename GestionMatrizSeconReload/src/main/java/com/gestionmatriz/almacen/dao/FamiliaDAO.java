/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.Familia;

import java.util.List;

/**
 *
 * @author zholo
 */
public interface FamiliaDAO {

    public abstract List<Familia> listarFamilia(String codigoFamilia, String nombre);

    public boolean registrarFamilia(Familia objFamilia);

    public boolean modificarFamilia(Familia objFamilia);
    
    public String verificarNombre(String nombre);
}
