/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.servicios;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.puntoventa.bean.Impresora;
import com.gestionmatriz.puntoventa.dao.ImpresoraDAO;

import java.util.List;

/**
 *
 * @author pc
 */
public class ImpresoraService implements ImpresoraService_I{

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    ImpresoraDAO objImpresoraDAO = fabrica.getImpresoraDAO();
    
    @Override
    public List<Impresora> listarImpresora(Impresora objImpresora) {
        return objImpresoraDAO.listarImpresora(objImpresora);
    }

    @Override
    public boolean registrarImpresora(Impresora objImpresora) {
        return objImpresoraDAO.registrarImpresora(objImpresora);
    }

    @Override
    public boolean actualizarImpresora(Impresora objImpresora) {
        return objImpresoraDAO.actualizarImpresora(objImpresora) ;
    }
    
}
