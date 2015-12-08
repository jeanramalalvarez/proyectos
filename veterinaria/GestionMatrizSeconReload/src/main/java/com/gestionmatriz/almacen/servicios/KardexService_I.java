/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import java.math.BigDecimal;
import java.util.List;

import com.gestionmatriz.almacen.bean.Kardex;

/**
 *
 * @author zholo
 */
public interface KardexService_I {
    
    public abstract List<Kardex>listaKardex(String idProducto);
    
    public abstract List<Kardex>listaProductoAlmacen(String idProducto);
    
    public BigDecimal stock(int idAlmacen);
    
    public abstract List<Kardex>listaKardexStock(String idProducto);
    
    public boolean registrarKardex(Kardex objKardex); 
    
    public boolean updateKardex(int idKardex, BigDecimal stock);
    
// public abstract 
    
}
