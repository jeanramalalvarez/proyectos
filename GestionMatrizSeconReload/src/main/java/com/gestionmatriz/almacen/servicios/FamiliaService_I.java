/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.Familia;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface FamiliaService_I {

    public abstract List<Familia> listarFamilia(String codigoFamilia, String nombre) throws SQLException;

    public boolean registrarFamilia(Familia objFamilia);
    
    public boolean modificarFamilia(Familia objFamilia);
    
    public String verificarNombre(String nombre);
}
