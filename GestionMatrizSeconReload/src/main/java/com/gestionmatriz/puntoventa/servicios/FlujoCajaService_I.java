/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.servicios;

import java.math.BigDecimal;
import java.util.List;

import com.gestionmatriz.puntoventa.bean.Caja;
import com.gestionmatriz.puntoventa.bean.FlujoCaja;
import com.gestionmatriz.puntoventa.bean.Ventas;

/**
 *
 * @author cesareo
 */
public interface FlujoCajaService_I {
    
    public abstract String[] registrarFlujoCaja(FlujoCaja objFlujoCaja, 
            String nroDocumentoTemp, String nroDocumento, String tipoVenta,String tcomprobante);
    
    public abstract List<Ventas> listarVenta(String idLocal, String estado, String numeroDocumento, int puntero);
    
    public abstract List<Caja> listarCaja(int idLocal);
    
    public abstract List<Caja> getCaja(int idLocal, String usuario);
    
    public abstract BigDecimal cantidadXLocalYCaja(FlujoCaja objFlujoCaja);
    
    public abstract boolean cerrarCaja(FlujoCaja objFlujoCaja);
    
    public abstract List<Ventas> listarVentaAnular(String documento);
    
    public abstract String getNumeroSerieImpresora(int idLocal);
}
