/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.dao;

import java.util.List;

import com.gestionmatriz.seguridad.bean.FuncionUsuario;



/**
 *
 * @author YESM
 */
public interface FuncionUsuarioDAO {
    
    public abstract List<FuncionUsuario>  listaFuncionesXUsuario(int usuario);
    public abstract boolean desactivarFuncionesUsuario(int usuario);
}
