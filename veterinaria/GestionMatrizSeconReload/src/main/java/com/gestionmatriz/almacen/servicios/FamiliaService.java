/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.Familia;
import com.gestionmatriz.almacen.dao.FamiliaDAO;
import com.gestionmatriz.dao.DAOFactory;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author zholo
 */
public class FamiliaService implements FamiliaService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    FamiliaDAO objFamiliaDAO = fabrica.getFamiliaDAO();

    @Override
    public List<Familia> listarFamilia(String codigoFamilia, String nombre) throws SQLException {
        return objFamiliaDAO.listarFamilia(codigoFamilia, nombre);
    }

    @Override
    public boolean registrarFamilia(Familia objFamilia) {
        return objFamiliaDAO.registrarFamilia(objFamilia);
    }

    @Override
    public boolean modificarFamilia(Familia objFamilia) {
        return objFamiliaDAO.modificarFamilia(objFamilia);
    }

    @Override
    public String verificarNombre(String nombre) {
        return objFamiliaDAO.verificarNombre(nombre);
    }
}
