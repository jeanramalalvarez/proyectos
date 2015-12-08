/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.bean;

import java.math.BigDecimal;

/**
 *
 * @author cesareo
 */
public class ProveedorProductoOrdenCompraFacturaCompra {
    
    private int int_idProveedor;
    private int int_idProducto;
    private int int_idOrdenCompra;
    private int int_idFacturaCompra;
    private BigDecimal dbl_cantidadRecibida;
    private String str_numeroFactura;
    private int int_idLocalRecibido;
    private String str_fechaDocumento;
    private String str_estado;
    private String str_usuarioCreador;
    private String str_fechaCreacion;
    private String str_usuarioModificador;
    private String str_fechaModificacion;
    private BigDecimal dbl_conformidadOK;
    private BigDecimal dbl_conformidadFallaProveedor;
    private BigDecimal dbl_conformidadFallaTransportista;
    private BigDecimal dbl_conformidadFallaOtro;
    private String str_conformidadObservacion;
    private String str_conformidadEstado;
    private Proveedor objProveedor;
    private Producto objProducto;
    private ProveedorProductoOrdenCompra objProveedorProductoOrdenCompra;

    public BigDecimal getDbl_conformidadOK() {
        return dbl_conformidadOK;
    }

    public void setDbl_conformidadOK(BigDecimal dbl_conformidadOK) {
        this.dbl_conformidadOK = dbl_conformidadOK;
    }

    public BigDecimal getDbl_conformidadFallaProveedor() {
        return dbl_conformidadFallaProveedor;
    }

    public void setDbl_conformidadFallaProveedor(BigDecimal dbl_conformidadFallaProveedor) {
        this.dbl_conformidadFallaProveedor = dbl_conformidadFallaProveedor;
    }

    public BigDecimal getDbl_conformidadFallaTransportista() {
        return dbl_conformidadFallaTransportista;
    }

    public void setDbl_conformidadFallaTransportista(BigDecimal dbl_conformidadFallaTransportista) {
        this.dbl_conformidadFallaTransportista = dbl_conformidadFallaTransportista;
    }

    public BigDecimal getDbl_conformidadFallaOtro() {
        return dbl_conformidadFallaOtro;
    }

    public void setDbl_conformidadFallaOtro(BigDecimal dbl_conformidadFallaOtro) {
        this.dbl_conformidadFallaOtro = dbl_conformidadFallaOtro;
    }

    public String getStr_conformidadEstado() {
        return str_conformidadEstado;
    }

    public void setStr_conformidadEstado(String str_conformidadEstado) {
        this.str_conformidadEstado = str_conformidadEstado;
    }

    public String getStr_conformidadObservacion() {
        return str_conformidadObservacion;
    }

    public void setStr_conformidadObservacion(String str_conformidadObservacion) {
        this.str_conformidadObservacion = str_conformidadObservacion;
    }

    public String getStr_fechaDocumento() {
        return str_fechaDocumento;
    }

    public void setStr_fechaDocumento(String str_fechaDocumento) {
        this.str_fechaDocumento = str_fechaDocumento;
    }

    public int getInt_idLocalRecibido() {
        return int_idLocalRecibido;
    }

    public void setInt_idLocalRecibido(int int_idLocalRecibido) {
        this.int_idLocalRecibido = int_idLocalRecibido;
    }

    public ProveedorProductoOrdenCompra getObjProveedorProductoOrdenCompra() {
        return objProveedorProductoOrdenCompra;
    }

    public void setObjProveedorProductoOrdenCompra(ProveedorProductoOrdenCompra objProveedorProductoOrdenCompra) {
        this.objProveedorProductoOrdenCompra = objProveedorProductoOrdenCompra;
    }

    public BigDecimal getDbl_cantidadRecibida() {
        return dbl_cantidadRecibida;
    }

    public void setDbl_cantidadRecibida(BigDecimal dbl_cantidadRecibida) {
        this.dbl_cantidadRecibida = dbl_cantidadRecibida;
    }

    public int getInt_idFacturaCompra() {
        return int_idFacturaCompra;
    }

    public void setInt_idFacturaCompra(int int_idFacturaCompra) {
        this.int_idFacturaCompra = int_idFacturaCompra;
    }

    public int getInt_idOrdenCompra() {
        return int_idOrdenCompra;
    }

    public void setInt_idOrdenCompra(int int_idOrdenCompra) {
        this.int_idOrdenCompra = int_idOrdenCompra;
    }

    public int getInt_idProducto() {
        return int_idProducto;
    }

    public void setInt_idProducto(int int_idProducto) {
        this.int_idProducto = int_idProducto;
    }

    public int getInt_idProveedor() {
        return int_idProveedor;
    }

    public void setInt_idProveedor(int int_idProveedor) {
        this.int_idProveedor = int_idProveedor;
    }

    public Producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(Producto objProducto) {
        this.objProducto = objProducto;
    }

    public Proveedor getObjProveedor() {
        return objProveedor;
    }

    public void setObjProveedor(Proveedor objProveedor) {
        this.objProveedor = objProveedor;
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

    public String getStr_numeroFactura() {
        return str_numeroFactura;
    }

    public void setStr_numeroFactura(String str_numeroFactura) {
        this.str_numeroFactura = str_numeroFactura;
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
