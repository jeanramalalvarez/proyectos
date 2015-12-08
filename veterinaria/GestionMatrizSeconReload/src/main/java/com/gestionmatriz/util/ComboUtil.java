/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.util;

import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.recursoshumanos.bean.Local;
import java.util.List;
import javax.swing.JComboBox;
import org.jdesktop.swingx.JXComboBox;




/**
 *
 * @author YTORRES
 */
public class ComboUtil{
    
    public static JComboBox getListaLocales(JComboBox cboCombo, int idEmpresa){
        cboCombo.removeAllItems();
        cboCombo.addItem(".::Seleccionar Local::.");
        List<Local> listaLocal = PaqueteBusinessDelegate.getContratoService().buscarLocal(idEmpresa);
        if (listaLocal!=null && !listaLocal.isEmpty()){
            for (Local local : listaLocal) {
                cboCombo.addItem(local.getStr_direccion());
            }
        }
        return cboCombo;
    }
    
    public static JXComboBox getListaLocales(JXComboBox cboCombo, int idEmpresa){
        cboCombo.removeAllItems();
        cboCombo.addItem(".::Seleccionar Local::.");
        List<Local> listaLocal = PaqueteBusinessDelegate.getContratoService().buscarLocal(idEmpresa);
        if (listaLocal!=null && !listaLocal.isEmpty()){
            for (Local local : listaLocal) {
                cboCombo.addItem(local.getStr_direccion());
            }
        }
        return cboCombo;
    }
    
     public static JXComboBox getListaLocales(JXComboBox cboCombo,List<Local> listaLocal){
        cboCombo.removeAllItems();
        cboCombo.addItem(".::Seleccionar Local::.");
        if (listaLocal!=null && !listaLocal.isEmpty()){
            for (Local local : listaLocal) {
                cboCombo.addItem(local.getStr_direccion());
            }
        }
        return cboCombo;
    }
     
    public static JComboBox getListaImpresoras(JComboBox cboImpresora, List<com.gestionmatriz.puntoventa.bean.Impresora> listaImpresora){
        cboImpresora.removeAllItems();
        cboImpresora.addItem(".::Matricial::.");
        
        
        if (listaImpresora!=null && !listaImpresora.isEmpty()){
            for (com.gestionmatriz.puntoventa.bean.Impresora imp: listaImpresora){
                cboImpresora.addItem(imp.getStr_nombre());
            }
        }
        return cboImpresora;
    }
}
