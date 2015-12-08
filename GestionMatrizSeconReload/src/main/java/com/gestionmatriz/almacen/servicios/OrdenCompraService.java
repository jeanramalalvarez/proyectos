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
import com.gestionmatriz.almacen.dao.OrdenCompraDAO;
import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.Local;

/**
 *
 * @author zholo
 */
public class OrdenCompraService implements OrdenCompraService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    OrdenCompraDAO objOrdenCompraDAO = fabrica.getOrdenCompraDAO();

    @Override
    public List<Empresa> listarEmpresa() throws SQLException {
        return objOrdenCompraDAO.listarEmpresa();
    }

    @Override
    public List<Local> buscarLocal(String idEmpresa) {
        return objOrdenCompraDAO.buscarLocal(idEmpresa);
    }

    @Override
    public boolean registrarOC(OrdenCompra objOC,
            List<ProveedorProductoOrdenCompra> listaProveedorProductoOrdenCompra,
            BigDecimal precioTotal, List<CronogramaPagos> listaCronogramaPagos) {
        return objOrdenCompraDAO.registrarOC(objOC,
                listaProveedorProductoOrdenCompra, precioTotal, listaCronogramaPagos);
    }

    @Override
    public String listarOCUltimoID() {
        return objOrdenCompraDAO.listarOCUltimoID();
    }

    @Override
    public List<ProveedorProductoOrdenCompra> listarProveedorProducto(String idProveedor, String idProducto, String estado, String producto) {
        return objOrdenCompraDAO.listarProveedorProducto(idProveedor, idProducto, estado, producto);
    }

    @Override
    public List<OrdenCompra> buscarOrdenCompra(String NOC, String proveedor, String transportista, String viaTransporte, String condicionPago) {
        return objOrdenCompraDAO.buscarOrdenCompra(NOC, proveedor, transportista, viaTransporte, condicionPago);
    }

    @Override
    public List<ProveedorProductoOrdenCompra> listarPPOC(int idOrdenCompra) {
        return objOrdenCompraDAO.listarPPOC(idOrdenCompra);
    }

    @Override
    public boolean modificarOC(OrdenCompra objOC, OrdenCompra objOCNuevo,
            List<ProveedorProductoOrdenCompra> listaProveedorProductoOrdenCompra,
            BigDecimal precioTotal, List<CronogramaPagos> listaCronogramaPagos) {
        return objOrdenCompraDAO.modificarOC(objOC, objOCNuevo, listaProveedorProductoOrdenCompra,
                precioTotal, listaCronogramaPagos);
    }

    @Override
    public List<TipoObligacion> buscarTipoObligacion() {
        return objOrdenCompraDAO.buscarTipoObligacion();
    }
}
