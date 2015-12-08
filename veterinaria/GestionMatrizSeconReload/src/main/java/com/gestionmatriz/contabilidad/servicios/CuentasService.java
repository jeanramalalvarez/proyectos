/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.servicios;

import com.gestionmatriz.contabilidad.bean.Cuentas;
import com.gestionmatriz.contabilidad.dao.CuentasDAO;
import com.gestionmatriz.dao.DAOFactory;
import java.util.List;

/**
 *
 * @author zholo
 */
public class CuentasService implements CuentasService_I{
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    CuentasDAO objCuentasDAO = fabrica.getCuentasDAO();

    

    @Override
    public List<Cuentas> listarCuentas(int idElemento) {
        return objCuentasDAO.listarCuentas(idElemento);
    }

    @Override
    public boolean registrarCuenta(Cuentas objCuenta) {
        return objCuentasDAO.registrarCuenta(objCuenta);
    }
    
}
