/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompraFacturaCompra;

import java.util.List;

/**
 *
 * @author jarcon
 */
public interface ConformidadService_I {

    public abstract boolean registrarConformidad(List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC);

}
