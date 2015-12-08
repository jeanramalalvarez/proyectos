/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import java.math.BigDecimal;
import java.util.List;

import com.gestionmatriz.almacen.bean.Kardex;

/**
 *
 * @author zholo
 */
public interface KardexDAO {

    public List<Kardex> listaKardex(String idProducto);

    public boolean registrarKardex(Kardex objKardex);

    public List<Kardex> listaKardexStock(String idProducto);

    public boolean updateKardex(int idKardex, BigDecimal stock);

    public List<Kardex> listaProductoAlmacen(String idProducto);

    public BigDecimal stock(int idAlmacen);
    
}
