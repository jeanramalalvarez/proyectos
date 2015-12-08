/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.servicio;

import com.gestionmatriz.seguridad.bean.Modulo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author YESM
 */
public interface ModulosService_I {
     public abstract List<Modulo> listaModulos() throws SQLException;
     
//     public abstract boolean modificarcontrasenia(int idUsuario,String constrasenia);
}
