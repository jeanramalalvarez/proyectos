/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.servicios;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.puntoventa.bean.Cliente;
import com.gestionmatriz.puntoventa.dao.ClienteDAO;
import java.util.List;

/**
 *
 * @author cesareo
 */
public class ClienteService implements ClienteService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    ClienteDAO objClienteDAO = fabrica.getClienteDAO();
    
    @Override
    public boolean registrarCliente(Cliente objCliente) {
        return objClienteDAO.registrarCliente(objCliente);
    }

    @Override
    public List<Cliente> listarCliente(String razonSocial, String rucdni, String direccion, String telefono) {
        return objClienteDAO.listarCliente(razonSocial, rucdni, direccion, telefono);
    }

    @Override
    public boolean modificarCliente(Cliente objCliente) {
        return objClienteDAO.modificarCliente(objCliente);
    }

    @Override
    public boolean inactivarCliente(Cliente objCliente) {
        return objClienteDAO.inactivarCliente(objCliente);
    }

    
    
}
