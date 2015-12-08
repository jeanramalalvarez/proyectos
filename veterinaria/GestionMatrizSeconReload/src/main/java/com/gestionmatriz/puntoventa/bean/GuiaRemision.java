/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.bean;

import com.gestionmatriz.almacen.bean.ProveedorProducto;
import java.util.List;

/**
 *
 * @author jarcon
 */
public class GuiaRemision {
    private int int_idGuiaRemision;
    private String str_nroGuia;    
    private String dte_fechaEmision;
    private String dte_fechaTraslado;
    private String str_motivoTraslado;
    private String str_domicilioPartida;
    private String str_domicilioLlegada;
    private String str_placaMarcaVehiculo;
    private String str_inscripcionVehiculo;
    private String str_brevete;
    private String str_destinatarioNombre;
    private String str_destinatarioRuc;
    private String str_destinatarioDireccion;
    private String str_comprobante;
    private String str_nroComprobante;
    private String str_estado;
    private String str_usuarioCreador;
    private String dte_fechaCreacion;
    private String str_usuarioModificador;
    private String dte_fechaModificacion;
    private String str_localPartida;
    private String str_localLlegada;
    private String str_rucTranportista;
    private String str_nombreTransportista;

    public String getStr_nombreTransportista() {
        return str_nombreTransportista;
    }

    public void setStr_nombreTransportista(String str_nombreTransportista) {
        this.str_nombreTransportista = str_nombreTransportista;
    }

    public String getStr_rucTranportista() {
        return str_rucTranportista;
    }

    public void setStr_rucTranportista(String str_rucTranportista) {
        this.str_rucTranportista = str_rucTranportista;
    }

    public String getStr_localLlegada() {
        return str_localLlegada;
    }

    public void setStr_localLlegada(String str_localLlegada) {
        this.str_localLlegada = str_localLlegada;
    }
    
    private ProveedorProducto objProveedorProducto;

    public ProveedorProducto getObjProveedorProducto() {
        return objProveedorProducto;
    }

    public void setObjProveedorProducto(ProveedorProducto objProveedorProducto) {
        this.objProveedorProducto = objProveedorProducto;
    }

    public String getStr_localPartida() {
        return str_localPartida;
    }

    public void setStr_localPartida(String str_localPartida) {
        this.str_localPartida = str_localPartida;
    }
    
    private List<com.gestionmatriz.puntoventa.bean.DetalleGuiaRemision>listadetalle;
    private com.gestionmatriz.puntoventa.bean.DetalleGuiaRemision objDetalleGuia;

    public DetalleGuiaRemision getObjDetalleGuia() {
        return objDetalleGuia;
    }

    public void setObjDetalleGuia(DetalleGuiaRemision objDetalleGuia) {
        this.objDetalleGuia = objDetalleGuia;
    }
    public List<DetalleGuiaRemision> getListadetalle() {
        return listadetalle;
    }

    public void setListadetalle(List<DetalleGuiaRemision> listadetalle) {
        this.listadetalle = listadetalle;
    }

    public String getDte_fechaCreacion() {
        return dte_fechaCreacion;
    }

    public void setDte_fechaCreacion(String dte_fechaCreacion) {
        this.dte_fechaCreacion = dte_fechaCreacion;
    }

    public String getDte_fechaEmision() {
        return dte_fechaEmision;
    }

    public void setDte_fechaEmision(String dte_fechaEmision) {
        this.dte_fechaEmision = dte_fechaEmision;
    }

    public String getDte_fechaModificacion() {
        return dte_fechaModificacion;
    }

    public void setDte_fechaModificacion(String dte_fechaModificacion) {
        this.dte_fechaModificacion = dte_fechaModificacion;
    }

    public String getDte_fechaTraslado() {
        return dte_fechaTraslado;
    }

    public void setDte_fechaTraslado(String dte_fechaTraslado) {
        this.dte_fechaTraslado = dte_fechaTraslado;
    }

    public int getInt_idGuiaRemision() {
        return int_idGuiaRemision;
    }

    public void setInt_idGuiaRemision(int int_idGuiaRemision) {
        this.int_idGuiaRemision = int_idGuiaRemision;
    }

    public String getStr_brevete() {
        return str_brevete;
    }

    public void setStr_brevete(String str_brevete) {
        this.str_brevete = str_brevete;
    }

    public String getStr_comprobante() {
        return str_comprobante;
    }

    public void setStr_comprobante(String str_comprobante) {
        this.str_comprobante = str_comprobante;
    }

    public String getStr_destinatarioDireccion() {
        return str_destinatarioDireccion;
    }

    public void setStr_destinatarioDireccion(String str_destinatarioDireccion) {
        this.str_destinatarioDireccion = str_destinatarioDireccion;
    }

    public String getStr_destinatarioNombre() {
        return str_destinatarioNombre;
    }

    public void setStr_destinatarioNombre(String str_destinatarioNombre) {
        this.str_destinatarioNombre = str_destinatarioNombre;
    }

    public String getStr_destinatarioRuc() {
        return str_destinatarioRuc;
    }

    public void setStr_destinatarioRuc(String str_destinatarioRuc) {
        this.str_destinatarioRuc = str_destinatarioRuc;
    }

    public String getStr_domicilioLlegada() {
        return str_domicilioLlegada;
    }

    public void setStr_domicilioLlegada(String str_domicilioLlegada) {
        this.str_domicilioLlegada = str_domicilioLlegada;
    }

    public String getStr_domicilioPartida() {
        return str_domicilioPartida;
    }

    public void setStr_domicilioPartida(String str_domicilioPartida) {
        this.str_domicilioPartida = str_domicilioPartida;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_inscripcionVehiculo() {
        return str_inscripcionVehiculo;
    }

    public void setStr_inscripcionVehiculo(String str_inscripcionVehiculo) {
        this.str_inscripcionVehiculo = str_inscripcionVehiculo;
    }

    public String getStr_motivoTraslado() {
        return str_motivoTraslado;
    }

    public void setStr_motivoTraslado(String str_motivoTraslado) {
        this.str_motivoTraslado = str_motivoTraslado;
    }

    public String getStr_nroComprobante() {
        return str_nroComprobante;
    }

    public void setStr_nroComprobante(String str_nroComprobante) {
        this.str_nroComprobante = str_nroComprobante;
    }

    public String getStr_placaMarcaVehiculo() {
        return str_placaMarcaVehiculo;
    }

    public void setStr_placaMarcaVehiculo(String str_placaMarcaVehiculo) {
        this.str_placaMarcaVehiculo = str_placaMarcaVehiculo;
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
    public String getStr_nroGuia() {
        return str_nroGuia;
    }

    public void setStr_nroGuia(String str_nroGuia) {
        this.str_nroGuia = str_nroGuia;
    }
}
