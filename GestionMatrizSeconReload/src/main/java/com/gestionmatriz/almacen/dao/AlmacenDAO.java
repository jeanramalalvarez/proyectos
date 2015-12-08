/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.Almacen;

import java.util.List;

/**
 *
 * @author zholo
 */
public interface AlmacenDAO {
    
    public abstract boolean registrarAlmacen(List<Almacen> listaAlmacen);

    public abstract List<Almacen> listaProductosAlmacen(int idlocal);

    public abstract boolean registrarAlmacenTraspaso(Almacen objAlmacen);
    
}
