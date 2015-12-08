/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.servicios;

import com.gestionmatriz.almacen.bean.Almacen;
import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.puntoventa.bean.FlujoCaja;
import com.gestionmatriz.puntoventa.bean.ImprimirVenta;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.puntoventa.dao.VentaDAO;
import com.gestionmatriz.recursoshumanos.bean.Personal;

import java.util.List;

/**
 *
 * @author jarcon
 */
public class VentaService implements VentasService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    VentaDAO objVentaDAO = fabrica.getVentaDAO();

    @Override
    public List<Object> buscarStock(int local, String producto) {
        return objVentaDAO.buscarStock(local, producto);
    }

    @Override
    public boolean registrarVenta(List<Object> listaVenta, int tipoVentaProforma, String tituloProforma) {
        return objVentaDAO.registrarVenta(listaVenta, tipoVentaProforma,tituloProforma);
    }

    @Override
    public List<Personal> listarVendedores(String idEmpresa) {
        return objVentaDAO.listarVendedores(idEmpresa);
    }

    @Override
    public String consultaUltimoTemporal(int local) {
        return objVentaDAO.consultaUltimoTemporal(local);
    }

    @Override
    public String consultaSiguinteCorrelativo(int local, String tipoDocumento) {
        return objVentaDAO.consultaSiguinteCorrelativo(local, tipoDocumento);
    }

    @Override
    public List<Object> listaProformasXCliente(int local, String cliente, String numeroSerie) {
        return objVentaDAO.listaProformasXCliente(local, cliente,numeroSerie);
    }

    @Override
    public List<Object> listaDetalleProforma(int local, String documento) {
        return objVentaDAO.listaDetalleProforma(local, documento);
    }

    @Override
    public List<ImprimirVenta> listaVenta(String nroDocumento) {
        return objVentaDAO.listaVenta(nroDocumento);
    }

    @Override
    public boolean enviarProformaVentas(String documento, int local) {
        return objVentaDAO.enviarProformaVentas(documento, local);
    }

    @Override
    public boolean eliminarVenta(Ventas objV) {
        return objVentaDAO.eliminarVenta(objV);
    }

    @Override
    public List<Object> consultaVentaXDocumento(String documento, int local) {
        return objVentaDAO.consultaVentaXDocumento(documento, local);
    }

    @Override
    public boolean anularDocVenta(Ventas objV, FlujoCaja objFlujoCaja, List<Almacen> listaA) {
        return objVentaDAO.anularDocVenta(objV, objFlujoCaja, listaA);
    }

	@Override
	public String prefijoXlocalxTipoDocumento(int local, int tipoDocumento) {
		return objVentaDAO.prefijoXlocalxTipoDocumento(local, tipoDocumento);
	}
}
