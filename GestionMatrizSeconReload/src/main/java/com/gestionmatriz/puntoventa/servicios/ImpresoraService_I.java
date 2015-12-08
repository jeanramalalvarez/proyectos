/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.servicios;

import com.gestionmatriz.puntoventa.bean.Impresora;
import java.util.List;



/**
 *
 * @author pc
 */
public interface ImpresoraService_I {
    
    public abstract List<Impresora> listarImpresora(Impresora objImpresora);
     public abstract boolean registrarImpresora(Impresora objImpresora);
    public abstract boolean actualizarImpresora(Impresora objImpresora);
}
