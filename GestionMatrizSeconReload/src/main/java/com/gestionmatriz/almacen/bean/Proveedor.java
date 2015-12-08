/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.bean;

/**
 *
 * @author zholo
 */
public class Proveedor {
   private int int_idProveedor;
   private String str_razonSocial;
   private String str_nombreComercial;
   private String str_ruc;
   private String str_direccion;
   private String str_email;
   private String str_telefono;
   private String str_fax;
   private String str_representanteLegal;
   private String  str_banco;
   private String str_ctaPrincipal;
   private String str_ctaAlternativa;
   private String str_estado;
   private String str_usuarioCreador;
   private String dte_fechaCreación;

    public String getDte_fechaCreación() {
        return dte_fechaCreación;
    }

    public void setDte_fechaCreación(String dte_fechaCreación) {
        this.dte_fechaCreación = dte_fechaCreación;
    }

    public int getInt_idProveedor() {
        return int_idProveedor;
    }

    public void setInt_idProveedor(int int_idProveedor) {
        this.int_idProveedor = int_idProveedor;
    }

    public String getStr_banco() {
        return str_banco;
    }

    public void setStr_banco(String str_banco) {
        this.str_banco = str_banco;
    }

    public String getStr_ctaAlternativa() {
        return str_ctaAlternativa;
    }

    public void setStr_ctaAlternativa(String str_ctaAlternativa) {
        this.str_ctaAlternativa = str_ctaAlternativa;
    }

    public String getStr_ctaPrincipal() {
        return str_ctaPrincipal;
    }

    public void setStr_ctaPrincipal(String str_ctaPrincipal) {
        this.str_ctaPrincipal = str_ctaPrincipal;
    }

    public String getStr_direccion() {
        return str_direccion;
    }

    public void setStr_direccion(String str_direccion) {
        this.str_direccion = str_direccion;
    }

    public String getStr_email() {
        return str_email;
    }

    public void setStr_email(String str_email) {
        this.str_email = str_email;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_fax() {
        return str_fax;
    }

    public void setStr_fax(String str_fax) {
        this.str_fax = str_fax;
    }

    public String getStr_nombreComercial() {
        return str_nombreComercial;
    }

    public void setStr_nombreComercial(String str_nombreComercial) {
        this.str_nombreComercial = str_nombreComercial;
    }

    public String getStr_razonSocial() {
        return str_razonSocial;
    }

    public void setStr_razonSocial(String str_razonSocial) {
        this.str_razonSocial = str_razonSocial;
    }

    public String getStr_representanteLegal() {
        return str_representanteLegal;
    }

    public void setStr_representanteLegal(String str_representanteLegal) {
        this.str_representanteLegal = str_representanteLegal;
    }

    public String getStr_ruc() {
        return str_ruc;
    }

    public void setStr_ruc(String str_ruc) {
        this.str_ruc = str_ruc;
    }

    public String getStr_telefono() {
        return str_telefono;
    }

    public void setStr_telefono(String str_telefono) {
        this.str_telefono = str_telefono;
    }

    public String getStr_usuarioCreador() {
        return str_usuarioCreador;
    }

    public void setStr_usuarioCreador(String str_usuarioCreador) {
        this.str_usuarioCreador = str_usuarioCreador;
    }
}
