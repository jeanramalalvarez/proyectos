/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.OrdenCompra;
import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompraFacturaCompra;
import com.gestionmatriz.almacen.bean.TipoMovimiento;

import java.util.List;

/**
 *
 * @author jarcon
 */
public interface RecepcionMercaderiaService_I {
    
    public boolean registrarRecepcionMercaderia(List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC, OrdenCompra objOC);
    
    public abstract List<ProveedorProductoOrdenCompraFacturaCompra> listarPPOCFC(int idOrdenCompra);
    
    public abstract List<TipoMovimiento> listarTipoMovimiento();
}
