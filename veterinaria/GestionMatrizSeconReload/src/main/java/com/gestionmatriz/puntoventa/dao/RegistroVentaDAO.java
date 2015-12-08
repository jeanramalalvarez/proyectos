/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.dao;

import com.gestionmatriz.puntoventa.bean.RegistroVenta;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface RegistroVentaDAO {

    public List<RegistroVenta> listarRegistroVenta(String fechaInicial,String fechaFinal);
    
}
