/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionmatriz.util;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.gestionmatriz.principal.gui.Principal;

/**
 *
 * @author YESMI
 */
public class FileChooser {
    
    private Principal gui;
    private JFileChooser jchosse;

    public FileChooser(Principal gui) {
        this.gui=gui;
        jchosse=new JFileChooser();
    }
    
    
    
    public String saveFile(){
        int indicador;
        this.jchosse.addChoosableFileFilter(
                new FileNameExtensionFilter("todos los archivos *.PDF", "pdf","PDF"));
        indicador=this.jchosse.showSaveDialog(this.gui);
        if (indicador==JFileChooser.APPROVE_OPTION){
            String guarda =jchosse.getSelectedFile().getAbsolutePath();
        if (guarda!=null){
            return guarda;
        }
        }
        
        return null;
    }
}
