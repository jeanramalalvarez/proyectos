/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.servicios;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.puntoventa.bean.RegistroVenta;
import com.gestionmatriz.puntoventa.dao.RegistroVentaDAO;
import java.util.List;

/**
 *
 * @author zholo
 */
public class RegistroVentaService implements RegistroVentaService_I {
    
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    RegistroVentaDAO objRegistroVentaDAO = fabrica.getRegistroVentaDAO();
    
    @Override
    public List<RegistroVenta> listarRegistroVenta(String fechaInicial,String fechaFinal) {
        return objRegistroVentaDAO.listarRegistroVenta(fechaInicial,fechaFinal);
    }
    
}
