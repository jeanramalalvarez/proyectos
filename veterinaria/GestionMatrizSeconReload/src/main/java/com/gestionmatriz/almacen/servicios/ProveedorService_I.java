/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.Proveedor;

import java.util.List;

/**
 *
 * @author jarcon
 */
public interface ProveedorService_I {

    public abstract boolean registrarProveedor(Proveedor objProveedor);

    public abstract List<Proveedor> buscarProveedor(String ruc, String razonSocial);

    public abstract boolean modificarProveedor(Proveedor objProveedor);
}
