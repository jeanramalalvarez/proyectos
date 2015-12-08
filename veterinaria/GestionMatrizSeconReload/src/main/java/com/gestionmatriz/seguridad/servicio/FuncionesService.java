/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.servicio;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.seguridad.bean.Funciones;
import com.gestionmatriz.seguridad.dao.FuncionesDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author YESM
 */
public class FuncionesService implements FuncionesService_I{
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    FuncionesDAO objFuncionesDAO=fabrica.getFuncionesDAO();
    @Override
    public List<Funciones> listaFunciones() throws SQLException {
        return objFuncionesDAO.listaFunciones();
    }

    @Override
    public List<Funciones> listaFuncionesXModulo(int modulo) throws SQLException {
        return objFuncionesDAO.listaFuncionesXModulo(modulo);
    }
    
}
