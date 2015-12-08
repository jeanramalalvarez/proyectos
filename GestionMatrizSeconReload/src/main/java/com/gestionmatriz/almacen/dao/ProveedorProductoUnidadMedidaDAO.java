/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.ProveedorProductoUnidadMedida;
import java.util.List;

/**
 *
 * @author cesareo
 */
public interface ProveedorProductoUnidadMedidaDAO {
    
    public abstract boolean registrarPPUM(ProveedorProductoUnidadMedida objPPUM);
    
    public abstract List<ProveedorProductoUnidadMedida> listarPPUM();
    
    public abstract boolean verificarProducto(ProveedorProductoUnidadMedida objPPUM);
    
    public abstract boolean modificarPPUM(ProveedorProductoUnidadMedida objPPUM);
    
    public abstract boolean quitarOferta(ProveedorProductoUnidadMedida objPPUM);
}
