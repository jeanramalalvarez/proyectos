/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.ProveedorProductoUnidadMedida;
import com.gestionmatriz.almacen.dao.ProveedorProductoUnidadMedidaDAO;
import com.gestionmatriz.dao.DAOFactory;
import java.util.List;

/**
 *
 * @author cesareo
 */
public class ProveedorProductoUnidadMedidaService implements ProveedorProductoUnidadMedidaService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);		
    ProveedorProductoUnidadMedidaDAO objPPUMDAO = fabrica.getProveedorProductoUnidadMedidaDAO();
    
    @Override
    public boolean registrarPPUM(ProveedorProductoUnidadMedida objPPUM) {
        return objPPUMDAO.registrarPPUM(objPPUM);
    }

    @Override
    public List<ProveedorProductoUnidadMedida> listarPPUM() {
        return objPPUMDAO.listarPPUM();
    }

    @Override
    public boolean verificarProducto(ProveedorProductoUnidadMedida objPPUM) {
        return objPPUMDAO.verificarProducto(objPPUM);
    }

    @Override
    public boolean modificarPPUM(ProveedorProductoUnidadMedida objPPUM) {
        return objPPUMDAO.modificarPPUM(objPPUM);
    }

    @Override
    public boolean quitarOferta(ProveedorProductoUnidadMedida objPPUM) {
        return objPPUMDAO.quitarOferta(objPPUM);
    }
}
