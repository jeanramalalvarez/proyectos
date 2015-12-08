/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import java.math.BigDecimal;
import java.util.List;

import com.gestionmatriz.almacen.bean.Kardex;
import com.gestionmatriz.almacen.dao.KardexDAO;
import com.gestionmatriz.dao.DAOFactory;


/**
 *
 * @author zholo
 */
public class KardexService implements KardexService_I {
    
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    KardexDAO objKardexDAO = fabrica.getKardexDAO();

    @Override
    public List<Kardex> listaKardex(String idProducto) {
        return objKardexDAO.listaKardex(idProducto);
    }

    @Override
    public boolean registrarKardex(Kardex objKardex) {
        return objKardexDAO.registrarKardex(objKardex);
    }

    @Override
    public List<Kardex> listaKardexStock(String idProducto) {
         return objKardexDAO.listaKardexStock(idProducto);
    }

    @Override
    public boolean updateKardex(int idKardex, BigDecimal stock) {
        return objKardexDAO.updateKardex(idKardex,stock);
    }

    @Override
    public List<Kardex> listaProductoAlmacen(String idProducto) {
        return objKardexDAO.listaProductoAlmacen(idProducto);
    }

    @Override
    public BigDecimal stock(int idAlmacen) {
        return objKardexDAO.stock(idAlmacen);
    }
    
}
