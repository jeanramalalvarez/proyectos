/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.dao;

import com.gestionmatriz.seguridad.bean.Funciones;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author YESMI
 */
public interface FuncionesDAO {
    
    public abstract List<Funciones> listaFunciones()throws SQLException;
    public abstract List<Funciones> listaFuncionesXModulo(int modulo) throws SQLException;
    
    
}
