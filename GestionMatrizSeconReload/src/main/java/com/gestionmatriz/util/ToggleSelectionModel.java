/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.util;

import javax.swing.DefaultListSelectionModel;

/**
 *
 * @author zholo
 */
public class ToggleSelectionModel extends  DefaultListSelectionModel{
            
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void setSelectionInterval(int index0,int index1){
            if (isSelectedIndex(index0)){
                super.removeSelectionInterval(index0, index1);
            }
            else{
                super.setSelectionInterval(index0, index1);
            }
        }
    }
