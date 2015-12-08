/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.servicios;

import com.gestionmatriz.almacen.bean.MedidaRotacion;
import java.util.List;

/**
 *
 * @author jarcon
 */
public interface MedidaRotacionService_I {

    public abstract List<MedidaRotacion> listarMR();
    
    public abstract boolean modificarMR(MedidaRotacion objMR);

}
