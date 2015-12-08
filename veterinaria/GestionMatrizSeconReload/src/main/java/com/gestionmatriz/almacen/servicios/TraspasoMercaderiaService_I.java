/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import java.util.List;

/**
 *
 * @author jarcon
 */
public interface TraspasoMercaderiaService_I {
    
    
    public boolean registrarTraspaso(com.gestionmatriz.almacen.bean.TraspasoMercaderia objTraspasoMercaderia);
    public boolean confirmarTraspaso(com.gestionmatriz.almacen.bean.TraspasoMercaderia objTraspasoMercaderia);
    public List<com.gestionmatriz.almacen.bean.TraspasoMercaderia>listarTraspasoMercaderia(
            String codAutoriza,String fchAutoriza,String estado,String local);
}
