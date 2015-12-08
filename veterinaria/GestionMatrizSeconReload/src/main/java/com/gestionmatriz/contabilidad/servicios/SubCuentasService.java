/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.servicios;

import com.gestionmatriz.contabilidad.bean.SubCuentas;
import com.gestionmatriz.contabilidad.dao.SubCuentasDAO;
import com.gestionmatriz.dao.DAOFactory;
import java.util.List;

/**
 *
 * @author zholo
 */
public class SubCuentasService implements SubCuentasService_I{
    
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    SubCuentasDAO objCuentasDAO = fabrica.getSubCuentasDAO();

    @Override
    public List<SubCuentas> listarSubCuentas(int idCuenta) {
        
        return objCuentasDAO.listarSubCuentas(idCuenta);
    }
}
