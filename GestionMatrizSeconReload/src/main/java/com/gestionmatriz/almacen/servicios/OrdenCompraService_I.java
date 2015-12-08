/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.gestionmatriz.almacen.bean.CronogramaPagos;
import com.gestionmatriz.almacen.bean.OrdenCompra;
import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompra;
import com.gestionmatriz.almacen.bean.TipoObligacion;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.Local;

/**
 *
 * @author zholo
 */
public interface OrdenCompraService_I {

    public abstract List<Empresa> listarEmpresa() throws SQLException;

    public abstract List<Local> buscarLocal(String idEmpresa);

    public abstract boolean registrarOC(OrdenCompra objOC,
            List<ProveedorProductoOrdenCompra> listaProveedorProductoOrdenCompra,
            BigDecimal precioTotal, List<CronogramaPagos> listaCronogramaPagos);

    public abstract String listarOCUltimoID();

    public abstract List<ProveedorProductoOrdenCompra> listarProveedorProducto(String idProveedor, String idProducto, String estado, String producto);

    public abstract List<OrdenCompra> buscarOrdenCompra(String NOC, String proveedor, String transportista, String viaTransporte, String condicionPago);
    
    public abstract List<ProveedorProductoOrdenCompra> listarPPOC(int idOrdenCompra);
    
    public abstract boolean modificarOC(OrdenCompra objOC, OrdenCompra objOCNuevo,
            List<ProveedorProductoOrdenCompra> listaProveedorProductoOrdenCompra,
            BigDecimal precioTotal, List<CronogramaPagos> listaCronogramaPagos);
    
    public abstract List<TipoObligacion> buscarTipoObligacion();
}
