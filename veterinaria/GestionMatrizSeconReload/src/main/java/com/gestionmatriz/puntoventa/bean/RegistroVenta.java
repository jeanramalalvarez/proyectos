/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.bean;

/**
 *
 * @author zholo
 */
public class RegistroVenta {
    
    private String str_periodo;
    private String str_idVenta;
    private String str_fechaEmision;
    private String str_fechaPago;
    private String str_tipoComprobante;
    private String str_nroSerieDoc;
    private String str_correlativoDoc;
    private String str_sumaTotalPorDoc;
    private String str_tipoDocIdentidadCliente;    
    private String str_nroDocIdendidadCliente;
    private String str_razonSocial;
    private String str_valorExportacion;//0.00
    private String str_baseImponibleOperacion; // valor de la venta
    private String str_importeTotalOpeExonerado; // valor de la venta 
    private String str_importeTotalOpeInafecta; // neto sin igv
    private String str_isc; // 0.00
    private String str_igvIpm;// 0.00
    private String str_baseImponibleOpeGrabIvap;// 0.00
    private String str_ivap; // 0.00
    private String str_OtrosTributos;// 0.00
    private String str_importeTotalDoc;
    private String str_tipoCambio; // 0.000
    private String str_fechaDocModifica;
    private String str_nroDocModifica;
    private String str_tipoDocModifica;
    private String str_serieDocModifica;
    private String str_correlativoDocModifica;
    private String str_estadoDoc;
    private String str_sumaBoletas;
    private String str_sumaFacturas;
    private String str_sumaCreditos;
    private String str_nombreCliente;
    private String str_tipoVenta;

    public String getStr_tipoVenta() {
        return str_tipoVenta;
    }

    public void setStr_tipoVenta(String str_tipoVenta) {
        this.str_tipoVenta = str_tipoVenta;
    }

    public String getStr_nombreCliente() {
        return str_nombreCliente;
    }

    public void setStr_nombreCliente(String str_nombreCliente) {
        this.str_nombreCliente = str_nombreCliente;
    }

    public String getStr_sumaBoletas() {
        return str_sumaBoletas;
    }

    public void setStr_sumaBoletas(String str_sumaBoletas) {
        this.str_sumaBoletas = str_sumaBoletas;
    }

    public String getStr_sumaCreditos() {
        return str_sumaCreditos;
    }

    public void setStr_sumaCreditos(String str_sumaCreditos) {
        this.str_sumaCreditos = str_sumaCreditos;
    }

    public String getStr_sumaFacturas() {
        return str_sumaFacturas;
    }

    public void setStr_sumaFacturas(String str_sumaFacturas) {
        this.str_sumaFacturas = str_sumaFacturas;
    }

    

    public String getStr_OtrosTributos() {
        return str_OtrosTributos;
    }

    public void setStr_OtrosTributos(String str_OtrosTributos) {
        this.str_OtrosTributos = str_OtrosTributos;
    }

    public String getStr_baseImponibleOpeGrabIvap() {
        return str_baseImponibleOpeGrabIvap;
    }

    public void setStr_baseImponibleOpeGrabIvap(String str_baseImponibleOpeGrabIvap) {
        this.str_baseImponibleOpeGrabIvap = str_baseImponibleOpeGrabIvap;
    }

    public String getStr_baseImponibleOperacion() {
        return str_baseImponibleOperacion;
    }

    public void setStr_baseImponibleOperacion(String str_baseImponibleOperacion) {
        this.str_baseImponibleOperacion = str_baseImponibleOperacion;
    }

    public String getStr_correlativoDoc() {
        return str_correlativoDoc;
    }

    public void setStr_correlativoDoc(String str_correlativoDoc) {
        this.str_correlativoDoc = str_correlativoDoc;
    }

    public String getStr_correlativoDocModifica() {
        return str_correlativoDocModifica;
    }

    public void setStr_correlativoDocModifica(String str_correlativoDocModifica) {
        this.str_correlativoDocModifica = str_correlativoDocModifica;
    }

    public String getStr_estadoDoc() {
        return str_estadoDoc;
    }

    public void setStr_estadoDoc(String str_estadoDoc) {
        this.str_estadoDoc = str_estadoDoc;
    }

    public String getStr_fechaDocModifica() {
        return str_fechaDocModifica;
    }

    public void setStr_fechaDocModifica(String str_fechaDocModifica) {
        this.str_fechaDocModifica = str_fechaDocModifica;
    }

    public String getStr_fechaEmision() {
        return str_fechaEmision;
    }

    public void setStr_fechaEmision(String str_fechaEmision) {
        this.str_fechaEmision = str_fechaEmision;
    }

    public String getStr_fechaPago() {
        return str_fechaPago;
    }

    public void setStr_fechaPago(String str_fechaPago) {
        this.str_fechaPago = str_fechaPago;
    }

    public String getStr_idVenta() {
        return str_idVenta;
    }

    public void setStr_idVenta(String str_idVenta) {
        this.str_idVenta = str_idVenta;
    }

   

    public String getStr_igvIpm() {
        return str_igvIpm;
    }

    public void setStr_igvIpm(String str_igvIpm) {
        this.str_igvIpm = str_igvIpm;
    }

    public String getStr_importeTotalDoc() {
        return str_importeTotalDoc;
    }

    public void setStr_importeTotalDoc(String str_importeTotalDoc) {
        this.str_importeTotalDoc = str_importeTotalDoc;
    }

    public String getStr_importeTotalOpeInafecta() {
        return str_importeTotalOpeInafecta;
    }

    public void setStr_importeTotalOpeInafecta(String str_importeTotalOpeInafecta) {
        this.str_importeTotalOpeInafecta = str_importeTotalOpeInafecta;
    }

    public String getStr_isc() {
        return str_isc;
    }

    public void setStr_isc(String str_isc) {
        this.str_isc = str_isc;
    }

    public String getStr_ivap() {
        return str_ivap;
    }

    public void setStr_ivap(String str_ivap) {
        this.str_ivap = str_ivap;
    }

    public String getStr_nroDocIdendidadCliente() {
        return str_nroDocIdendidadCliente;
    }

    public void setStr_nroDocIdendidadCliente(String str_nroDocIdendidadCliente) {
        this.str_nroDocIdendidadCliente = str_nroDocIdendidadCliente;
    }

    public String getStr_nroDocModifica() {
        return str_nroDocModifica;
    }

    public void setStr_nroDocModifica(String str_nroDocModifica) {
        this.str_nroDocModifica = str_nroDocModifica;
    }

    public String getStr_nroSerieDoc() {
        return str_nroSerieDoc;
    }

    public void setStr_nroSerieDoc(String str_nroSerieDoc) {
        this.str_nroSerieDoc = str_nroSerieDoc;
    }

    public String getStr_periodo() {
        return str_periodo;
    }

    public void setStr_periodo(String str_periodo) {
        this.str_periodo = str_periodo;
    }

    public String getStr_razonSocial() {
        return str_razonSocial;
    }

    public void setStr_razonSocial(String str_razonSocial) {
        this.str_razonSocial = str_razonSocial;
    }

    public String getStr_serieDocModifica() {
        return str_serieDocModifica;
    }

    public void setStr_serieDocModifica(String str_serieDocModifica) {
        this.str_serieDocModifica = str_serieDocModifica;
    }

    public String getStr_sumaTotalPorDoc() {
        return str_sumaTotalPorDoc;
    }

    public void setStr_sumaTotalPorDoc(String str_sumaTotalPorDoc) {
        this.str_sumaTotalPorDoc = str_sumaTotalPorDoc;
    }

    public String getStr_tipoCambio() {
        return str_tipoCambio;
    }

    public void setStr_tipoCambio(String str_tipoCambio) {
        this.str_tipoCambio = str_tipoCambio;
    }

    public String getStr_tipoComprobante() {
        return str_tipoComprobante;
    }

    public void setStr_tipoComprobante(String str_tipoComprobante) {
        this.str_tipoComprobante = str_tipoComprobante;
    }

    public String getStr_tipoDocModifica() {
        return str_tipoDocModifica;
    }

    public void setStr_tipoDocModifica(String str_tipoDocModifica) {
        this.str_tipoDocModifica = str_tipoDocModifica;
    }

    public String getStr_valorExportacion() {
        return str_valorExportacion;
    }

    public void setStr_valorExportacion(String str_valorExportacion) {
        this.str_valorExportacion = str_valorExportacion;
    }
    public String getStr_importeTotalOpeExonerado() {
        return str_importeTotalOpeExonerado;
    }

    public void setStr_importeTotalOpeExonerado(String str_importeTotalOpeExonerado) {
        this.str_importeTotalOpeExonerado = str_importeTotalOpeExonerado;
    }

    public String getStr_tipoDocIdentidadCliente() {
        return str_tipoDocIdentidadCliente;
    }

    public void setStr_tipoDocIdentidadCliente(String str_tipoDocIdentidadCliente) {
        this.str_tipoDocIdentidadCliente = str_tipoDocIdentidadCliente;
    }
    
}
