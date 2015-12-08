/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

/**
 *
 * @author YESM
 */
public class Local {
    private int int_idLocal;
    private Empresa objEmpresa;
    private String str_nombre;
    private String str_direccion;
    private String str_estado;
    private String str_telefono;
    private String str_distrito;
    private String str_provincia;
    private String str_departamento;
    private String str_codLocalGuia;

    public Local(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public Local(int int_idLocal) {
        this.int_idLocal = int_idLocal;
    }
    
    

    public Local() {
    }

    
    
    
    public String getStr_codLocalGuia() {
        return str_codLocalGuia;
    }

    public void setStr_codLocalGuia(String str_codLocalGuia) {
        this.str_codLocalGuia = str_codLocalGuia;
    }

    public String getStr_departamento() {
        return str_departamento;
    }

    public void setStr_departamento(String str_departamento) {
        this.str_departamento = str_departamento;
    }

    public String getStr_distrito() {
        return str_distrito;
    }

    public void setStr_distrito(String str_distrito) {
        this.str_distrito = str_distrito;
    }

    public String getStr_provincia() {
        return str_provincia;
    }

    public void setStr_provincia(String str_provincia) {
        this.str_provincia = str_provincia;
    }

    public int getInt_idLocal() {
        return int_idLocal;
    }

    public void setInt_idLocal(int int_idLocal) {
        this.int_idLocal = int_idLocal;
    }

    public Empresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(Empresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public String getStr_direccion() {
        return str_direccion;
    }

    public void setStr_direccion(String str_direccion) {
        this.str_direccion = str_direccion;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }
    
    public String getStr_telefono() {
        return str_telefono;
    }

    public void setStr_telefono(String str_telefono) {
        this.str_telefono = str_telefono;
    }

}
