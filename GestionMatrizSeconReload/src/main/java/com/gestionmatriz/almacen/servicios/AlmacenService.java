/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.Almacen;
import com.gestionmatriz.almacen.dao.AlmacenDAO;
import com.gestionmatriz.dao.DAOFactory;

import java.util.List;

/**
 *
 * @author zholo
 */
public class AlmacenService implements AlmacenService_I{
    
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    AlmacenDAO objAlmacenDAO = fabrica.getAlmacenDAO();
    
    @Override
    public boolean registrarAlmacen(List<Almacen> listaAlmacen) {
        return objAlmacenDAO.registrarAlmacen(listaAlmacen);
    }

    @Override
    public List<Almacen> listaProductosAlmacen(int idlocal) {
        return objAlmacenDAO.listaProductosAlmacen(idlocal);
    }

    @Override
    public boolean registrarAlmacenTraspaso(Almacen objAlmacen) {
        return objAlmacenDAO.registrarAlmacenTraspaso(objAlmacen);
    }
    
}
