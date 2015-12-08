/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.OrdenCompra;
import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompraFacturaCompra;
import com.gestionmatriz.almacen.bean.TipoMovimiento;
import com.gestionmatriz.almacen.dao.RecepcionMercaderiaDAO;
import com.gestionmatriz.dao.DAOFactory;
import java.util.List;

/**
 *
 * @author jarcon
 */
public class RecepcionMercaderiaService implements RecepcionMercaderiaService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    RecepcionMercaderiaDAO objRecepcionMercaderiaDAO = fabrica.getRecepcionMercaderiaDAO();

    @Override
    public boolean registrarRecepcionMercaderia(List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC, OrdenCompra objOC) {
        return objRecepcionMercaderiaDAO.registrarRecepcionMercaderia(listaPPOCFC, objOC);
    }
    
    @Override
    public List<ProveedorProductoOrdenCompraFacturaCompra> listarPPOCFC(int idOrdenCompra) {
        return objRecepcionMercaderiaDAO.listarPPOCFC(idOrdenCompra);
    }

    @Override
    public List<TipoMovimiento> listarTipoMovimiento() {
        return objRecepcionMercaderiaDAO.listarTipoMovimiento();
    }
}
