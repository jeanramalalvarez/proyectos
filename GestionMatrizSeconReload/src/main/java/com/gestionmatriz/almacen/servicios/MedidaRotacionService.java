/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.MedidaRotacion;
import com.gestionmatriz.almacen.dao.MedidaRotacionDAO;
import com.gestionmatriz.dao.DAOFactory;
import java.util.List;

/**
 *
 * @author jarcon
 */
public class MedidaRotacionService implements MedidaRotacionService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    MedidaRotacionDAO objMedidaRotacionDAO = fabrica.getMedidaRotacionDAO();

    @Override
    public List<MedidaRotacion> listarMR() {
        return objMedidaRotacionDAO.listarMR();
    }

    @Override
    public boolean modificarMR(MedidaRotacion objMR) {
        return objMedidaRotacionDAO.modificarMR(objMR);
    }

}
