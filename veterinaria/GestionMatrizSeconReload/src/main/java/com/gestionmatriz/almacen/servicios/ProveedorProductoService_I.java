/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import java.util.List;

/**
 *
 * @author jarcon
 */
public interface ProveedorProductoService_I {
    
    public boolean registrarProveedorProducto(List<com.gestionmatriz.almacen.bean.ProveedorProducto> listaProveedorProducto,String usuarioCreador);
    
    public List<com.gestionmatriz.almacen.bean.ProveedorProducto> listarProveeProd(String idProveedor,String idProducto, String estado);

    public boolean modificarProveedorProducto(int idProveedor, int idProducto,String userModifica,String estado);
}
