/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author zholo
 */
public class Mensaje {

    public static final String TITULO_ME = "<SISTEMA MATRIZ> MENSAJES";
    public static final String TITULO_OP = "<SISTEMA MATRIZ> CONFIRMACIONES";
    /*Atributos de mensajes */
    public static final int ERROR = 0;
    public static final int INFORMACION = 1;
    public static final int ADVERTENCIA = 2;
    public static final int PREGUNTA = 3;
    /*Atributs de Confirmacion*/
    public static final int DEFAULT_OPTION = -1;
    public static final int YES_NO_OPTION = 0;
    public static final int YES_NO_CANCEL_OPTION = 1;
    public static final int OK_CANCEL_OPTION = 2;
    /*Respuesta de Confirmacion*/
    public static final int YES_OPTION = 0;
    /** Return value from class method if NO is chosen. */
    public static final int NO_OPTION = 1;
    /** Return value from class method if CANCEL is chosen. */
    public static final int CANCEL_OPTION = 2;
    /** Return value form class method if OK is chosen. */
    public static final int OK_OPTION = 0;

    public static void mensaje(String mensaje, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipo);
    }

    public static void mensaje(Component c, String mensaje, String titulo, int tipo) {
        JOptionPane.showMessageDialog(c, mensaje, titulo, tipo);
    }

    public static int confirmar(Component c, String mensaje, String titulo, int opcion, int tipo) {
        int obj = JOptionPane.showConfirmDialog(c, mensaje, titulo, opcion, tipo);
        return obj;
    }

    public static String leerEntrada(Component c, String mensaje, String titulo, int tipo) {
        String respuesta = JOptionPane.showInputDialog(c, mensaje, titulo, tipo);
        return respuesta;
    }
}
