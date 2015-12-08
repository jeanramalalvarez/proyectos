/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.Proveedor;
import java.util.List;

/**
 *
 * @author jarcon
 */
public interface ProveedorDAO {
    
    public boolean registrarProveedor(com.gestionmatriz.almacen.bean.Proveedor objProveedor);

    public List<Proveedor> buscarProveedor(String ruc,String razonSocial);
    
    public boolean modificarProveedor(com.gestionmatriz.almacen.bean.Proveedor objProveedor);
}
