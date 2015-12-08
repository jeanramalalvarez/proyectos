/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompraFacturaCompra;
import com.gestionmatriz.almacen.dao.ConformidadDAO;
import com.gestionmatriz.dao.DAOFactory;

import java.util.List;

/**
 *
 * @author jarcon
 */
public class ConformidadService implements ConformidadService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    ConformidadDAO objConformidadDAO = fabrica.getConformidadDAO();

    @Override
    public boolean registrarConformidad(List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC) {
        return objConformidadDAO.registrarConformidad(listaPPOCFC);
    }

}
