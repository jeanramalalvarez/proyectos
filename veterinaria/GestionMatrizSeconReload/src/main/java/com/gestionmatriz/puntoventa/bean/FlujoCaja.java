/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.bean;

import java.math.BigDecimal;

import com.gestionmatriz.recursoshumanos.bean.Local;

/**
 *
 * @author cesareo
 */
public class FlujoCaja {
    
    private int int_idFlujoCaja;
    private int int_idLocal;
    private int int_idCaja;
    private BigDecimal dbl_cantidadSoles;
    private BigDecimal dbl_cantidadDolares;
    private BigDecimal dbl_cantidadTotalSoles;
    private BigDecimal dbl_cantidadDiferencia;
    private String str_motivo;
    private String str_estado;
    private String str_usuarioCreador;
    private String str_fechaCreacion;
    private String str_usuarioModificador;
    private String str_fechaModificacion;
    private Local objLocal;
    private Caja objCaja;
    private String str_nroDocumento;
    private String str_numeroSerie;

    public String getStr_nroDocumento() {
        return str_nroDocumento;
    }

    public void setStr_nroDocumento(String str_nroDocumento) {
        this.str_nroDocumento = str_nroDocumento;
    }

    public BigDecimal getDbl_cantidadDiferencia() {
        return dbl_cantidadDiferencia;
    }

    public void setDbl_cantidadDiferencia(BigDecimal dbl_cantidadDiferencia) {
        this.dbl_cantidadDiferencia = dbl_cantidadDiferencia;
    }

    public String getStr_motivo() {
        return str_motivo;
    }

    public void setStr_motivo(String str_motivo) {
        this.str_motivo = str_motivo;
    }

    public int getInt_idFlujoCaja() {
        return int_idFlujoCaja;
    }

    public void setInt_idFlujoCaja(int int_idFlujoCaja) {
        this.int_idFlujoCaja = int_idFlujoCaja;
    }

    public int getInt_idLocal() {
        return int_idLocal;
    }

    public void setInt_idLocal(int int_idLocal) {
        this.int_idLocal = int_idLocal;
    }

    public int getInt_idCaja() {
        return int_idCaja;
    }

    public void setInt_idCaja(int int_idCaja) {
        this.int_idCaja = int_idCaja;
    }

    public BigDecimal getDbl_cantidadSoles() {
        return dbl_cantidadSoles;
    }

    public void setDbl_cantidadSoles(BigDecimal dbl_cantidadSoles) {
        this.dbl_cantidadSoles = dbl_cantidadSoles;
    }

    public BigDecimal getDbl_cantidadDolares() {
        return dbl_cantidadDolares;
    }

    public void setDbl_cantidadDolares(BigDecimal dbl_cantidadDolares) {
        this.dbl_cantidadDolares = dbl_cantidadDolares;
    }

    public BigDecimal getDbl_cantidadTotalSoles() {
        return dbl_cantidadTotalSoles;
    }

    public void setDbl_cantidadTotalSoles(BigDecimal dbl_cantidadTotalSoles) {
        this.dbl_cantidadTotalSoles = dbl_cantidadTotalSoles;
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

    public Local getObjLocal() {
        return objLocal;
    }

    public void setObjLocal(Local objLocal) {
        this.objLocal = objLocal;
    }

    public Caja getObjCaja() {
        return objCaja;
    }

    public void setObjCaja(Caja objCaja) {
        this.objCaja = objCaja;
    }

    public String getStr_numeroSerie() {
        return str_numeroSerie;
    }

    public void setStr_numeroSerie(String str_numeroSerie) {
        this.str_numeroSerie = str_numeroSerie;
    }
    
}
