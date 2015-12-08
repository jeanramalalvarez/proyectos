/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.MedidaRotacion;
import java.util.List;

/**
 *
 * @author cesareo
 */
public interface MedidaRotacionDAO {

    public abstract List<MedidaRotacion> listarMR();
    
    public abstract boolean modificarMR(MedidaRotacion objMR);

}
