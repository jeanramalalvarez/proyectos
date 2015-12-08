/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.util;

import java.util.EnumMap;

import org.apache.log4j.Logger;

import com.digitalpersona.onetouch.DPFPFingerIndex;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.gestionmatriz.principal.gui.Principal;


/**
 *
 * @author YESM
 */
public class AdministradorHuellas {
    
	private static final Logger log=Logger.getLogger(AdministradorHuellas.class);
	private Principal gui;
    public final static int MAXHUELLAS=2;
    
    private EnumMap<DPFPFingerIndex, DPFPTemplate> templates = 
            new EnumMap<DPFPFingerIndex, DPFPTemplate>(DPFPFingerIndex.class);
      
    
    private static final DPFPTemplate fakeTemplate;
    
    
     static {
        fakeTemplate = DPFPGlobal.getTemplateFactory().createTemplate();
        try {
            fakeTemplate.deserialize(new byte[0]);
        } catch (IllegalArgumentException e) {
            log.error("Error en AdministradorHuellas: "+e.getMessage());
        }
    }

    public AdministradorHuellas(Principal gui) {
        this.gui=gui;
    }
     
     
     
     public void enroll(){
         new Enrollment(gui,MAXHUELLAS,templates).setVisible(true);
     }
    
    public EnumMap<DPFPFingerIndex, DPFPTemplate> getTemplates(){
        return this.templates;
    }
    
}
