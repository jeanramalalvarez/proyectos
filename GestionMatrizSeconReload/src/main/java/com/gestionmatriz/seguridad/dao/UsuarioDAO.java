/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.dao;

import com.gestionmatriz.seguridad.bean.Funciones;
import com.gestionmatriz.seguridad.bean.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author YESM
 */
public interface UsuarioDAO {
    
    
    /*Valida las credenciales del Usuario*/
    public abstract Usuario validarUsuario(String str_usuario, String str_password) 
            throws SQLException;
    public abstract boolean registrarUsuario(Usuario objUsuario,List<Funciones> listaFunciones, int puntero, int usuario);
    
    public abstract Usuario consultarUsuarioXPersona(String persona);
    
    public abstract boolean modificarcontrasenia(int idUsuario,String constrasenia);
    
     public int logeoInicial(String usuario);
     
     public boolean insertLogoe(String usuario);

    public Usuario consultarIdUsuario(String strUsuario);
}
