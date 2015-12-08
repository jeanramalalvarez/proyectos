/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.dao.ProveedorDAO;
import com.gestionmatriz.dao.DAOFactory;

import java.util.List;

/**
 *
 * @author jarcon
 */
public class ProveedorService implements ProveedorService_I{

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);		
    ProveedorDAO objProveedorDAO = fabrica.getProveedorDAO();
    
    @Override
    public boolean registrarProveedor(Proveedor objProveedor) {
       return objProveedorDAO.registrarProveedor(objProveedor);
    }

    @Override
    public List<Proveedor> buscarProveedor(String ruc,String razonSocial) {
        return objProveedorDAO.buscarProveedor(ruc,razonSocial);
    }

    @Override
    public boolean modificarProveedor(Proveedor objProveedor) {
        return objProveedorDAO.modificarProveedor(objProveedor);
    }
    
}
