/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.config.bean;

/**
 *
 * @author ytorres
 */
public class BDConfig {
    
    private String strUsuario;
    private String strContrasenia;
    private String strBaseDatos;
    private String strServidor;

    public String getStrServidor() {
        return strServidor;
    }

    public void setStrServidor(String strServidor) {
        this.strServidor = strServidor;
    }
    
    
    public String getStrBaseDatos() {
        return strBaseDatos;
    }

    public void setStrBaseDatos(String strBaseDatos) {
        this.strBaseDatos = strBaseDatos;
    }

    public String getStrContrasenia() {
        return strContrasenia;
    }

    public void setStrContrasenia(String strContrasenia) {
        this.strContrasenia = strContrasenia;
    }

    public String getStrUsuario() {
        return strUsuario;
    }

    public void setStrUsuario(String strUsuario) {
        this.strUsuario = strUsuario;
    }
        
}
