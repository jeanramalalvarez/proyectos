/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.bean;

import java.math.BigDecimal;

import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.Local;

/**
 *
 * @author cesareo
 */
public class OrdenCompra {
    
    private int int_idOrdenCompra;
    private String str_numeroOC;
    private String str_viaTransporte;
    private BigDecimal dbl_precioBruto;
    private BigDecimal dbl_precioTotal;
    private BigDecimal dbl_descuentoTotal;
    private BigDecimal dbl_valorVenta;
    private BigDecimal dbl_igv;
    private BigDecimal dbl_igvRecuperado;
    private BigDecimal dbl_pesoTotal;
    private String str_fechaEntrega;
    private String str_fechaValidez;
    private String str_Operacion;
    private String str_estado;
    private String str_usuarioCreador;
    private String str_fechaCreacion;
    private String str_usuarioModificador;
    private String str_fechaModificacion;

    private Proveedor objProveedor;
    private Proveedor objTransportista;
    private Local objLocal;
    private Empresa objEmpresa;
    private TipoObligacion objTipoObligacion;

    public String getStr_Operacion() {
        return str_Operacion;
    }

    public void setStr_Operacion(String str_Operacion) {
        this.str_Operacion = str_Operacion;
    }

    public TipoObligacion getObjTipoObligacion() {
        return objTipoObligacion;
    }

    public void setObjTipoObligacion(TipoObligacion objTipoObligacion) {
        this.objTipoObligacion = objTipoObligacion;
    }

    public Empresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(Empresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public BigDecimal getDbl_descuentoTotal() {
        return dbl_descuentoTotal;
    }

    public void setDbl_descuentoTotal(BigDecimal dbl_descuentoTotal) {
        this.dbl_descuentoTotal = dbl_descuentoTotal;
    }

    public BigDecimal getDbl_igv() {
        return dbl_igv;
    }

    public void setDbl_igv(BigDecimal dbl_igv) {
        this.dbl_igv = dbl_igv;
    }

    public BigDecimal getDbl_igvRecuperado() {
        return dbl_igvRecuperado;
    }

    public void setDbl_igvRecuperado(BigDecimal dbl_igvRecuperado) {
        this.dbl_igvRecuperado = dbl_igvRecuperado;
    }

    public BigDecimal getDbl_pesoTotal() {
        return dbl_pesoTotal;
    }

    public void setDbl_pesoTotal(BigDecimal dbl_pesoTotal) {
        this.dbl_pesoTotal = dbl_pesoTotal;
    }

    public BigDecimal getDbl_precioBruto() {
        return dbl_precioBruto;
    }

    public void setDbl_precioBruto(BigDecimal dbl_precioBruto) {
        this.dbl_precioBruto = dbl_precioBruto;
    }

    public BigDecimal getDbl_precioTotal() {
        return dbl_precioTotal;
    }

    public void setDbl_precioTotal(BigDecimal dbl_precioTotal) {
        this.dbl_precioTotal = dbl_precioTotal;
    }

    public BigDecimal getDbl_valorVenta() {
        return dbl_valorVenta;
    }

    public void setDbl_valorVenta(BigDecimal dbl_valorVenta) {
        this.dbl_valorVenta = dbl_valorVenta;
    }

    public String getStr_fechaEntrega() {
        return str_fechaEntrega;
    }

    public void setStr_fechaEntrega(String str_fechaEntrega) {
        this.str_fechaEntrega = str_fechaEntrega;
    }

    public String getStr_fechaValidez() {
        return str_fechaValidez;
    }

    public void setStr_fechaValidez(String str_fechaValidez) {
        this.str_fechaValidez = str_fechaValidez;
    }

    public int getInt_idOrdenCompra() {
        return int_idOrdenCompra;
    }

    public void setInt_idOrdenCompra(int int_idOrdenCompra) {
        this.int_idOrdenCompra = int_idOrdenCompra;
    }

    public Local getObjLocal() {
        return objLocal;
    }

    public void setObjLocal(Local objLocal) {
        this.objLocal = objLocal;
    }

    public Proveedor getObjProveedor() {
        return objProveedor;
    }

    public void setObjProveedor(Proveedor objProveedor) {
        this.objProveedor = objProveedor;
    }
    
    public Proveedor getObjTransportista() {
        return objTransportista;
    }

    public void setObjTransportista(Proveedor objTransportista) {
        this.objTransportista = objTransportista;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_fechaCreacion() {
        return str_fechaCreacion;
    }

    public void setStr_fechaCreacion(String str_fechaCreacion) {
        this.str_fechaCreacion = str_fechaCreacion;
    }

    public String getStr_fechaModificacion() {
        return str_fechaModificacion;
    }

    public void setStr_fechaModificacion(String str_fechaModificacion) {
        this.str_fechaModificacion = str_fechaModificacion;
    }

    public String getStr_numeroOC() {
        return str_numeroOC;
    }

    public void setStr_numeroOC(String str_numeroOC) {
        this.str_numeroOC = str_numeroOC;
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

    public String getStr_viaTransporte() {
        return str_viaTransporte;
    }

    public void setStr_viaTransporte(String str_viaTransporte) {
        this.str_viaTransporte = str_viaTransporte;
    }
    
}