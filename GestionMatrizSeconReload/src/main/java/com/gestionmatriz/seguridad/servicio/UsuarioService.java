/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.servicio;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.seguridad.bean.Funciones;
import com.gestionmatriz.seguridad.bean.Usuario;
import com.gestionmatriz.seguridad.dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author YESM
 */
public class UsuarioService implements UsuarioService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    UsuarioDAO objUsuarioDAO = fabrica.getUsuarioDAO();

    @Override
    public Usuario validarUsuario(String str_usuario, String str_password) throws SQLException {
        return objUsuarioDAO.validarUsuario(str_usuario, str_password);
    }

    @Override
    public boolean registrarUsuario(Usuario objUsuario, List<Funciones> listaFunciones, int puntero, int usuario) {
        return objUsuarioDAO.registrarUsuario(objUsuario, listaFunciones, puntero, usuario);
    }

    @Override
    public Usuario consultarUsuarioXPersona(String persona) {
        return objUsuarioDAO.consultarUsuarioXPersona(persona);
    }

    @Override
    public boolean modificarcontrasenia(int idUsuario, String constrasenia) {
        return objUsuarioDAO.modificarcontrasenia(idUsuario, constrasenia);
    }

    @Override
    public int logeoInicial(String usuario) {
        return objUsuarioDAO.logeoInicial(usuario);
    }

    @Override
    public boolean insertLogeo(String usuario) {
        return objUsuarioDAO.insertLogoe(usuario);
    }

    @Override
    public Usuario consultarIdUsuario(String strUsuario) {
        return objUsuarioDAO.consultarIdUsuario(strUsuario);
    }
}
