/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.ProveedorProducto;
import java.util.List;

/**
 *
 * @author jarcon
 */
public interface ProveedorProductoDAO {

    public boolean registrarProveedorProducto(List<ProveedorProducto> listaProveedorProducto,String usuarioCreador);
   

    public List<ProveedorProducto> listarProveeProd(String idProveedor, String idProducto, String Producto);

    public boolean modificarProveedorProducto(int idProveedor, int idProducto, String userModifica, String estado);
    
}
