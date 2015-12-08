/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.TraspasoMercaderia;
import java.util.List;

/**
 *
 * @author jarcon
 */
public interface TraspasoMercaderiaDAO {

    public boolean registrarTraspaso(TraspasoMercaderia objTraspasoMercaderia);

    public boolean confirmarTraspaso(TraspasoMercaderia objTraspasoMercaderia);

    public List<TraspasoMercaderia> listarTraspasoMercaderia(String codAutoriza, String fchAutoriza, String estado, String local);
    
    
}
