/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.servicio;

import java.util.List;

import com.gestionmatriz.seguridad.bean.FuncionUsuario;

/**
 *
 * @author YESM
 */
public interface FuncionesUsuarioService_I {
    
     public abstract List<FuncionUsuario>  listaFuncionesXUsuario(int usuario);
     public abstract boolean desactivarFuncionesUsuario(int usuario);
}
