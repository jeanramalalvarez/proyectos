/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.dao;

import com.gestionmatriz.contabilidad.bean.Cuentas;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface CuentasDAO {

    public List<Cuentas> listarCuentas(int idElemento);

    public boolean registrarCuenta(Cuentas objCuenta);
    
}
