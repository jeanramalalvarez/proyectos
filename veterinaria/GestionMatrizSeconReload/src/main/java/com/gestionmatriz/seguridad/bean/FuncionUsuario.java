/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.bean;

/**
 *
 * @author YESM
 */
public class FuncionUsuario {
    private int int_idFunciones;
    private int int_idUsuario;
    private String dte_fechaCreacion;
    private String str_usuarioCreador;
    private String dte_ultimaModificacion;
    private String str_usuarioModificador;

    //Atributos para consulta;
    private Funciones objFunciones;
    private Usuario objUsuario;
    

    public Usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }
    
    
    
    public Funciones getObjFunciones() {
        return objFunciones;
    }

    public void setObjFunciones(Funciones objFunciones) {
        this.objFunciones = objFunciones;
    }
    
    
    public String getDte_fechaCreacion() {
        return dte_fechaCreacion;
    }

    public void setDte_fechaCreacion(String dte_fechaCreacion) {
        this.dte_fechaCreacion = dte_fechaCreacion;
    }

    public String getDte_ultimaModificacion() {
        return dte_ultimaModificacion;
    }

    public void setDte_ultimaModificacion(String dte_ultimaModificacion) {
        this.dte_ultimaModificacion = dte_ultimaModificacion;
    }

    public int getInt_idFunciones() {
        return int_idFunciones;
    }

    public void setInt_idFunciones(int int_idFunciones) {
        this.int_idFunciones = int_idFunciones;
    }

    public int getInt_idUsuario() {
        return int_idUsuario;
    }

    public void setInt_idUsuario(int int_idUsuario) {
        this.int_idUsuario = int_idUsuario;
    }

    public String getStr_usuarioCreador() {
        return str_usuarioCreador;
    }

    public void setStr_usuarioCreador(String str_usuarioCreador) {
        this.str_usuarioCreador = str_usuarioCreador;
    }

    public String getStr_usuarioModificador() {
        return str_usuarioModificador;
    }

    public void setStr_usuarioModificador(String str_usuarioModificador) {
        this.str_usuarioModificador = str_usuarioModificador;
    }
   
}
