/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.ProveedorProducto;
import com.gestionmatriz.almacen.dao.ProveedorProductoDAO;
import com.gestionmatriz.dao.DAOFactory;
import java.util.List;

/**
 *
 * @author jarcon
 */
public class ProveedorProductoService implements ProveedorProductoService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    ProveedorProductoDAO objProeveeProd = fabrica.getProveedorProductoDAO();

    @Override
    public boolean registrarProveedorProducto(List<ProveedorProducto> listaProveedorProducto, String usuarioCreador) {
        return objProeveeProd.registrarProveedorProducto(listaProveedorProducto, usuarioCreador);
    }

    @Override
    public List<ProveedorProducto> listarProveeProd(String idProveedor, String idProducto, String estado) {
        return objProeveeProd.listarProveeProd(idProveedor, idProducto, estado);
    }

    @Override
    public boolean modificarProveedorProducto(int idProveedor, int idProducto, String userModifica, String estado) {
        return objProeveeProd.modificarProveedorProducto(idProveedor, idProducto, userModifica, estado);
    }
}
