/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.servicio;

import com.gestionmatriz.seguridad.bean.Funciones;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author YESM
 */
public interface FuncionesService_I {
     public abstract List<Funciones> listaFunciones()throws SQLException;
     
     public abstract List<Funciones> listaFuncionesXModulo(int modulo) throws SQLException;
}
