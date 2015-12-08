/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.bean;

/**
 *
 * @author zholo
 */
public class Producto {

    private int int_idProducto;
    private String str_nombreProducto;
    private String str_codigoInterno;
    private String str_descripcion;
    private String str_fabricante;
    private String str_reintegroTributario;
    private String str_estado;
    private String str_usuarioCreador;
    private String dte_fechaCreador;
    private String str_usuarioModificador;
    private String dte_fechaModificacion;
    
    private Familia objFamilia;
    private UnidadMedida objUnidadMedida;
    private MedidaRotacion objMedidaRotacion;

    public String getDte_fechaCreador() {
        return dte_fechaCreador;
    }

    public void setDte_fechaCreador(String dte_fechaCreador) {
        this.dte_fechaCreador = dte_fechaCreador;
    }

    public String getDte_fechaModificacion() {
        return dte_fechaModificacion;
    }

    public void setDte_fechaModificacion(String dte_fechaModificacion) {
        this.dte_fechaModificacion = dte_fechaModificacion;
    }

    public int getInt_idProducto() {
        return int_idProducto;
    }

    public void setInt_idProducto(int int_idProducto) {
        this.int_idProducto = int_idProducto;
    }

    public Familia getObjFamilia() {
        return objFamilia;
    }

    public void setObjFamilia(Familia objFamilia) {
        this.objFamilia = objFamilia;
    }

    public MedidaRotacion getObjMedidaRotacion() {
        return objMedidaRotacion;
    }

    public void setObjMedidaRotacion(MedidaRotacion objMedidaRotacion) {
        this.objMedidaRotacion = objMedidaRotacion;
    }

    public UnidadMedida getObjUnidadMedida() {
        return objUnidadMedida;
    }

    public void setObjUnidadMedida(UnidadMedida objUnidadMedida) {
        this.objUnidadMedida = objUnidadMedida;
    }

    public String getStr_codigoInterno() {
        return str_codigoInterno;
    }

    public void setStr_codigoInterno(String str_codigoInterno) {
        this.str_codigoInterno = str_codigoInterno;
    }

    public String getStr_descripcion() {
        return str_descripcion;
    }

    public void setStr_descripcion(String str_descripcion) {
        this.str_descripcion = str_descripcion;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_fabricante() {
        return str_fabricante;
    }

    public void setStr_fabricante(String str_fabricante) {
        this.str_fabricante = str_fabricante;
    }

    public String getStr_nombreProducto() {
        return str_nombreProducto;
    }

    public void setStr_nombreProducto(String str_nombreProducto) {
        this.str_nombreProducto = str_nombreProducto;
    }

    public String getStr_reintegroTributario() {
        return str_reintegroTributario;
    }

    public void setStr_reintegroTributario(String str_reintegroTributario) {
        this.str_reintegroTributario = str_reintegroTributario;
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
