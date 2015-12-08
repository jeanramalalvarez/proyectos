/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.servicios;

import com.gestionmatriz.contabilidad.bean.Elemento;
import com.gestionmatriz.contabilidad.dao.ElementoDAO;
import com.gestionmatriz.dao.DAOFactory;
import java.util.List;

/**
 *
 * @author zholo
 */
public class ElementoService implements ElementoService_I{
    
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    ElementoDAO objElementoDAO = fabrica.getElementoDAO();

    @Override
    public List<Elemento> listarElementos() {
        return objElementoDAO.listarElementos();
    }

    @Override
    public boolean registrarElemnto(Elemento objElemento) {
        return objElementoDAO.registrarElemento(objElemento);
    }

    @Override
    public boolean actualizarElemento(Elemento objElemento) {
        return objElementoDAO.actualizarElemento(objElemento);
    }
}
