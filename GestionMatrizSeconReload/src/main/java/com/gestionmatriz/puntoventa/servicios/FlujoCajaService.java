/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.servicios;

import java.math.BigDecimal;
import java.util.List;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.puntoventa.bean.Caja;
import com.gestionmatriz.puntoventa.bean.FlujoCaja;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.puntoventa.dao.FlujoCajaDAO;

/**
 *
 * @author cesareo
 */
public class FlujoCajaService implements FlujoCajaService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    FlujoCajaDAO objFlujoCajaDAO = fabrica.getFlujoCajaDAO();
    
    @Override
    public String[] registrarFlujoCaja(FlujoCaja objFlujoCaja, String nroDocumentoTemp, String nroDocumento,String tipoVenta,String comprobante) {
        return objFlujoCajaDAO.registrarFlujoCaja(objFlujoCaja, nroDocumentoTemp, nroDocumento,tipoVenta, comprobante);
    }

    @Override
    public List<Ventas> listarVenta(String idLocal, String estado, String numeroDocumento, int puntero) {
        return objFlujoCajaDAO.listarVenta(idLocal, estado, numeroDocumento, puntero);
    }

    @Override
    public List<Caja> listarCaja(int idLocal) {
        return objFlujoCajaDAO.listarCaja(idLocal);
    }
    
    @Override
    public List<Caja> getCaja(int idLocal, String usuario) {
        return objFlujoCajaDAO.getCaja(idLocal, usuario);
    }
    
    @Override
    public BigDecimal cantidadXLocalYCaja(FlujoCaja objFlujoCaja) {
        return objFlujoCajaDAO.cantidadXLocalYCaja(objFlujoCaja);
    }

    @Override
    public boolean cerrarCaja(FlujoCaja objFlujoCaja) {
        return objFlujoCajaDAO.cerrarCaja(objFlujoCaja);
    }

    @Override
    public List<Ventas> listarVentaAnular(String documento) {
        return objFlujoCajaDAO.listarVentaAnular(documento);
    }

    @Override
    public String getNumeroSerieImpresora(int idLocal) {
        return objFlujoCajaDAO.getNumeroSerieImpresora(idLocal);
    }
}
