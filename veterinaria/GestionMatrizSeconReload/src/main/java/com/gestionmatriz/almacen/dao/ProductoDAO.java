/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.Producto;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface ProductoDAO {

    public abstract List<Producto> buscarProducto(String codigoInterno, String nombre, String familia, String reintegro, String rotacion);

    public abstract Producto buscarProductoXId(int idProducto);

    public abstract boolean registrarProducto(Producto objProducto);

    public abstract boolean modificarProducto(Producto objProducto);

    public abstract String verificarNombre(String nombre);
    
    public abstract String verificarCodigo(String codigo);
}
