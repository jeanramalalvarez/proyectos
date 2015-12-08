/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.bean;

import com.gestionmatriz.recursoshumanos.bean.Local;

/**
 *
 * @author YESM
 */
public class DocumentoSalida {
    
    private int int_idDocumento;
    private Local objLocal;
    private TipoDocumento objTipoDocumento;
    private int int_correlativo;
    private String str_estado;

    public int getInt_correlativo() {
        return int_correlativo;
    }

    public void setInt_correlativo(int int_correlativo) {
        this.int_correlativo = int_correlativo;
    }

    public int getInt_idDocumento() {
        return int_idDocumento;
    }

    public void setInt_idDocumento(int int_idDocumento) {
        this.int_idDocumento = int_idDocumento;
    }

    public Local getObjLocal() {
        return objLocal;
    }

    public void setObjLocal(Local objLocal) {
        this.objLocal = objLocal;
    }

    public TipoDocumento getObjTipoDocumento() {
        return objTipoDocumento;
    }

    public void setObjTipoDocumento(TipoDocumento objTipoDocumento) {
        this.objTipoDocumento = objTipoDocumento;
    }

    public String getStr_estado() {
        return str_estado;
    }

    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }
    
    
    
}
