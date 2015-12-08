/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.dao;

import com.gestionmatriz.contabilidad.bean.Elemento;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface ElementoDAO {
    
    public abstract List<Elemento> listarElementos();

    public boolean registrarElemento(Elemento objElemento);

    public boolean actualizarElemento(Elemento objElemento);
    
}
