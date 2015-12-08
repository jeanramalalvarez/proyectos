/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.servicios;

import com.gestionmatriz.contabilidad.bean.Elemento;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface ElementoService_I {
    
    
    public abstract List<Elemento> listarElementos();
    public abstract boolean registrarElemnto(Elemento objElemento);
    public abstract boolean actualizarElemento(Elemento objElemento);
}
