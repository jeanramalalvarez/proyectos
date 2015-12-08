/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.servicios;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.puntoventa.bean.TipoCambio;
import com.gestionmatriz.puntoventa.dao.TipoCambioDAO;
import java.util.List;

/**
 *
 * @author cesareo
 */
public class TipoCambioService implements TipoCambioService_I {
    
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    TipoCambioDAO objTipoCambioDAO = fabrica.getTipoCambioDAO();

    @Override
    public boolean registrarTipoCambio(TipoCambio objTipoCambio) {
        return objTipoCambioDAO.registrarTipoCambio(objTipoCambio);
    }

    @Override
    public boolean verificarTipoCambio(String fechaDia) {
        return objTipoCambioDAO.verificarTipoCambio(fechaDia);
    }

    @Override
    public TipoCambio obtenerTipoCambio(String fechaDia) {
        return objTipoCambioDAO.obtenerTipoCambio(fechaDia);
    }

    @Override
    public List<TipoCambio> listarTipoCambio() {
        return objTipoCambioDAO.listarTipoCambio();
    }

}
