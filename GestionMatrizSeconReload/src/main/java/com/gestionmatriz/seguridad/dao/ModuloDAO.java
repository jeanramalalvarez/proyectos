/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.dao;

import com.gestionmatriz.seguridad.bean.Modulo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author YESM
 */
public interface ModuloDAO {
    
    public abstract List<Modulo> listaModulos() throws SQLException;
    
}
