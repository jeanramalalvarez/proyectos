/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.reutilizable.util;

import com.gestionmatriz.seguridad.bean.FuncionUsuario;
import java.util.List;

/**
 *
 * @author YESM
 */
public class Filtro {

    public static boolean opcionPermitida(List<FuncionUsuario> lista, int opcion) {
        boolean respuesta = false;
        
        for (FuncionUsuario funcionUsuario : lista) {
            if (funcionUsuario.getObjFunciones().getStr_key().equals(String.valueOf(opcion))) {
                respuesta = true;
                break;
            }
        }
        
        return respuesta;
    }
}
