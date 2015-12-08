/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.servicios;

import com.gestionmatriz.contabilidad.bean.Cuentas;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface CuentasService_I {
    
    public abstract List<Cuentas> listarCuentas(int idElemento);
    
    public abstract boolean registrarCuenta(Cuentas objCuenta);
    
}
