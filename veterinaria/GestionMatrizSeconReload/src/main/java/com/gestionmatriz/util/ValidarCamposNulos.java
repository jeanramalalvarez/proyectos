/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.util;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author zholo
 */
public class ValidarCamposNulos {

    public static boolean validar(JTextField[] txts) {
        boolean valor = true;
        for (JTextField jTextField : txts) {

            if (jTextField.getText().trim().length() <= 0) {
                jTextField.setBackground(Color.pink);
                valor = false;
            } else {
                jTextField.setBackground(Color.white);
            }
        }
        return valor;
    }

    public static boolean validarCombos(JComboBox[] cbos) {
        boolean valor = true;
        for (JComboBox jComboBox : cbos) {
            if (jComboBox.getSelectedIndex() <= 0) {
                jComboBox.setBackground(Color.pink);
                valor = false;
            } else {
                jComboBox.setBackground(Color.white);
            }
        }
        return valor;
    }

    public static boolean validarTxtNroCaracteres(JTextField txt, int nroCaracteres) {
        boolean valor = true;
        if (txt.getText().trim().length() != nroCaracteres) {
            txt.setBackground(Color.pink);
            valor = false;
        } else {
            txt.setBackground(Color.white);
        }
        return valor;
    }

    public static boolean validarDatePicker(JXDatePicker[] dtps) {
        boolean valor = true;

        for (JXDatePicker jXDatePicker : dtps) {
            if (jXDatePicker.getDate() == null) {
                jXDatePicker.setBackground(Color.pink);
                valor = false;
            } else {
                jXDatePicker.setBackground(Color.white);
            }
        }
        return valor;
    }
    
    public static boolean validarDosFechas(JXDatePicker dtps1, JXDatePicker dtps2) {
        boolean valor = true;
        
        if (dtps2.getDate().before(dtps1.getDate())) {
            valor = false;
        }
        
        return valor;
    }

    public static boolean validarLabelSeteada(JXLabel[] lbls) {
        boolean valor = true;

        for (JXLabel jXLabel : lbls) {
            if (jXLabel.getText().trim().length() <= 0) {
                jXLabel.setBackground(Color.pink);
                valor = false;
            } else {
                jXLabel.setBackground(Color.white);
            }
        }
        return valor;
    }

    public static boolean validarTablaVacia(JXTable tbl) {
        boolean valor = true;
        if (tbl.getRowCount() <= 0) {
            tbl.setBackground(Color.pink);
            valor = false;
        } else {
            tbl.setBackground(Color.white);
        }

        return valor;
    }

    public static boolean validarListas(JList lst) {
        boolean valor = true;
        if (lst.getLastVisibleIndex() == -1) {
            lst.setBackground(Color.pink);
            valor = false;
        } else {
            lst.setBackground(Color.white);
        }

        return valor;
    }

    public static boolean validarTxtArea(JTextArea txta) {
        boolean valor = true;
        {

            if (txta.getText().trim().length() <= 0) {
                txta.setBackground(Color.pink);
                valor = false;
            } else {
                txta.setBackground(Color.white);
            }
        }
        return valor;
    }
}
