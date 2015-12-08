/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.servicio;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.seguridad.bean.FuncionUsuario;
import com.gestionmatriz.seguridad.dao.FuncionUsuarioDAO;
import java.util.List;

/**
 *
 * @author YESM
 */
public class FuncionesUsuarioService implements FuncionesUsuarioService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    FuncionUsuarioDAO objFuncionesUsuarioDAO = fabrica.getFuncionUsuarioDAO();

    @Override
    public List<FuncionUsuario> listaFuncionesXUsuario(int usuario) {
        return objFuncionesUsuarioDAO.listaFuncionesXUsuario(usuario);
    }

    @Override
    public boolean desactivarFuncionesUsuario(int usuario) {
        return objFuncionesUsuarioDAO.desactivarFuncionesUsuario(usuario);
    }
}
