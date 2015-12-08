/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.OrdenCompra;
import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompraFacturaCompra;
import com.gestionmatriz.almacen.bean.TipoMovimiento;

import java.util.List;

/**
 *
 * @author jarcon
 */
public interface RecepcionMercaderiaDAO {

    public boolean registrarRecepcionMercaderia(List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC, OrdenCompra objOC);
    
    public abstract List<ProveedorProductoOrdenCompraFacturaCompra> listarPPOCFC(int idOrdenCompra);
    
    public abstract List<TipoMovimiento> listarTipoMovimiento();
    
}
