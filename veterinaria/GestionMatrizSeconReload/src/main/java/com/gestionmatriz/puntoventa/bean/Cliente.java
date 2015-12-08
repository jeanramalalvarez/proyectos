/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.bean;

/**
 *
 * @author YESM
 */
public class Cliente {

    private int int_idCliente;
    private String str_razonSocial;
    private String str_rucdni;
    private String str_direccion;
    private String str_telefono;
    private String str_estado;
    private String str_usuarioCreador;
    private String str_fechaCreacion;
    private String str_usuarioModificador;
    private String str_fechaModificacion;

    public String getStr_rucdni() {
        return str_rucdni;
    }

    public void setStr_rucdni(String str_rucdni) {
        this.str_rucdni = str_rucdni;
    }

    public int getInt_idCliente() {
        return int_idCliente;
    }

    public void setInt_idCliente(int int_idCliente) {
        this.int_idCliente = int_idCliente;
    }

    public String getStr_razonSocial() {
        return str_razonSocial;
    }

    public void setStr_razonSocial(String str_razonSocial) {
        this.str_razonSocial = str_razonSocial;
    }

    public String getStr_direccion() {
        return str_direccion;
    }

    public void setStr_direccion(String str_direccion) {
        this.str_direccion = str_direccion;
    }

    public String getStr_telefono() {
        return str_telefono;
    }

    public void setStr_telefono(String str_telefono) {
        this.str_telefono = str_telefono;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_usuarioCreador() {
        return str_usuarioCreador;
    }

    public void setStr_usuarioCreador(String str_usuarioCreador) {
        this.str_usuarioCreador = str_usuarioCreador;
    }

    public String getStr_fechaCreacion() {
        return str_fechaCreacion;
    }

    public void setStr_fechaCreacion(String str_fechaCreacion) {
        this.str_fechaCreacion = str_fechaCreacion;
    }

    public String getStr_usuarioModificador() {
        return str_usuarioModificador;
    }

    public void setStr_usuarioModificador(String str_usuarioModificador) {
        this.str_usuarioModificador = str_usuarioModificador;
    }

    public String getStr_fechaModificacion() {
        return str_fechaModificacion;
    }

    public void setStr_fechaModificacion(String str_fechaModificacion) {
        this.str_fechaModificacion = str_fechaModificacion;
    }
}