/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.dao;

import com.gestionmatriz.almacen.bean.Almacen;
import com.gestionmatriz.puntoventa.bean.FlujoCaja;
import com.gestionmatriz.puntoventa.bean.ImprimirVenta;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import java.util.List;

/**
 *
 * @author jarcon
 */
public interface VentaDAO {

    public abstract List<Object> buscarStock(int local, String producto);

    public abstract boolean registrarVenta(List<Object> listaVenta, int tipoVentaProforma, String tituloProforma);

    public abstract List<Personal> listarVendedores(String idEmpresa);

    public abstract String consultaUltimoTemporal(int local);

    public abstract String consultaSiguinteCorrelativo(int local, String tipoDocumento);

    public abstract String consultaUltimaProforma(int local);

    public abstract List<Object> listaProformasXCliente(int local, String cliente, String numeroDocumento);

    public abstract List<Object> listaDetalleProforma(int local, String documento);

    public abstract List<ImprimirVenta> listaVenta(String nroDocumento);

    public abstract boolean enviarProformaVentas(String documento, int local);
    
    public abstract boolean eliminarVenta(Ventas objV);
    
    public abstract List<Object> consultaVentaXDocumento(String documento, int local);
    
    public abstract List<Object> consultaVentasXVendedor(int local, String vendedor);
    
    public abstract boolean anularDocVenta(Ventas objV, FlujoCaja objFlujoCaja, List<Almacen> listaA);
    
    public abstract String prefijoXlocalxTipoDocumento(int local,int tipoDocumento);
}
