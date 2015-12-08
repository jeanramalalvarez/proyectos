/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.TraspasoMercaderia;
import com.gestionmatriz.almacen.dao.TraspasoMercaderiaDAO;
import com.gestionmatriz.dao.DAOFactory;
import java.util.List;

/**
 *
 * @author jarcon
 */
public class TraspasoMercaderiaService implements TraspasoMercaderiaService_I{
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    TraspasoMercaderiaDAO objTraspasoMercaderiaDAO = fabrica.getTraspasoMercaderiaDAO();

    @Override
    public boolean registrarTraspaso(TraspasoMercaderia objTraspasoMercaderia) {
        return objTraspasoMercaderiaDAO.registrarTraspaso(objTraspasoMercaderia);
    }

    @Override
    public boolean confirmarTraspaso(TraspasoMercaderia objTraspasoMercaderia) {
        return objTraspasoMercaderiaDAO.confirmarTraspaso(objTraspasoMercaderia);
    }

    @Override
    public List<TraspasoMercaderia> listarTraspasoMercaderia(String codAutoriza, String fchAutoriza,  String estado ,String local) {
        return objTraspasoMercaderiaDAO.listarTraspasoMercaderia(codAutoriza,fchAutoriza,estado, local);
    }
    
    
}
