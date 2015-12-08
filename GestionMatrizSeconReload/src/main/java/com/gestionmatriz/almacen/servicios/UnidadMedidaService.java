/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.UnidadMedida;
import com.gestionmatriz.almacen.dao.UnidadMedidaDAO;
import com.gestionmatriz.dao.DAOFactory;

import java.util.List;

/**
 *
 * @author zholo
 */
public class UnidadMedidaService implements UnidadMedidaService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    UnidadMedidaDAO objUnidadMedidaDAO = fabrica.getUnidadMedidaDAO();

    @Override
    public List<UnidadMedida> listarUnidadMedida(String codigoUM, String nombre) {
        return objUnidadMedidaDAO.listarUnidadMedida(codigoUM, nombre);
    }

    @Override
    public boolean registrarUM(UnidadMedida objUM) {
        return objUnidadMedidaDAO.registrarUM(objUM);
    }

    @Override
    public boolean modificarUM(UnidadMedida objUM) {
        return objUnidadMedidaDAO.modificarUM(objUM);
    }

    @Override
    public String verificarNombre(String nombre) {
        return objUnidadMedidaDAO.verificarNombre(nombre);
    }
}
