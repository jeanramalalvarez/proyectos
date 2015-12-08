/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.bean;

import java.math.BigDecimal;

/**
 *
 * @author YESM
 */
public class Proforma {

    private String numeroDocumento;
    private String rucdni;
    private String razonSocial;
    private BigDecimal subTotal;
    private BigDecimal igv;
    private BigDecimal descuento;
    private BigDecimal total;
    private String fechaRegistro;

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    
    public String getRucdni() {
        return rucdni;
    }

    
    public void setRucdni(String rucdni) {
        this.rucdni = rucdni;
    }

    
    public String getRazonSocial() {
        return razonSocial;
    }

    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    
    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    
    public BigDecimal getIgv() {
        return igv;
    }

    
    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    
    public BigDecimal getDescuento() {
        return descuento;
    }

    
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    
    public BigDecimal getTotal() {
        return total;
    }

    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
}
