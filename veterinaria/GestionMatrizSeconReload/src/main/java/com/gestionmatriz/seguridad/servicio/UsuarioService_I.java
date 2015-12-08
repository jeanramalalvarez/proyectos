/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.servicio;

import java.sql.SQLException;
import java.util.List;

import com.gestionmatriz.seguridad.bean.Funciones;
import com.gestionmatriz.seguridad.bean.Usuario;

/**
 *
 * @author YESM
 */
public interface UsuarioService_I {
   
      public abstract Usuario validarUsuario(String str_usuario, String str_password) 
            throws SQLException;
      
     public boolean registrarUsuario(Usuario objUsuario,List<Funciones> listaFunciones, int puntero, int usuario) 
             ;
     
      public abstract Usuario consultarUsuarioXPersona(String persona);
      
      public abstract boolean modificarcontrasenia(int idUsuario,String constrasenia);
      
       public int logeoInicial(String usuario);
       
       public boolean insertLogeo(String usuario);
     public abstract Usuario consultarIdUsuario(String strUsuario);
       
}
