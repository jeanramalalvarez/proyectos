/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.dao;

import com.gestionmatriz.puntoventa.bean.Impresora;
import java.util.List;

/**
 *
 * @author pc
 */
public interface ImpresoraDAO {
    
    public abstract List<Impresora> listarImpresora(Impresora objImpresora);
    public abstract boolean registrarImpresora(Impresora objImpresora);
    public abstract boolean actualizarImpresora(Impresora objImpresora);
}
