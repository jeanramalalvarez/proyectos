/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.dao.ProductoDAO;
import com.gestionmatriz.dao.DAOFactory;
import java.util.List;

/**
 *
 * @author zholo
 */
public class ProductoService implements ProductoService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    ProductoDAO objProductoDAO = fabrica.getProductoDAO();

    @Override
    public List<Producto> buscarProducto(String codigoInterno, String nombre, String familia, String reintegro, String rotacion) {
        return objProductoDAO.buscarProducto(codigoInterno, nombre, familia, reintegro, rotacion);
    }

    @Override
    public boolean registrarProducto(Producto objProducto) {
        return objProductoDAO.registrarProducto(objProducto);
    }

    @Override
    public boolean modificarProducto(Producto objProducto) {
        return objProductoDAO.modificarProducto(objProducto);
    }

    @Override
    public String verificarNombre(String nombre) {
        return objProductoDAO.verificarNombre(nombre);
    }

    @Override
    public Producto buscarProductoXId(int idProducto) {
        return objProductoDAO.buscarProductoXId(idProducto);
    }

    @Override
    public String verificarCodigo(String codigo) {
        return objProductoDAO.verificarCodigo(codigo);
    }
}
