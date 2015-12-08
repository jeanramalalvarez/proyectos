/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.servicios;

import com.gestionmatriz.contabilidad.bean.SubCuentas;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface SubCuentasService_I {
    
    public abstract List<SubCuentas> listarSubCuentas(int idCuenta);
}
