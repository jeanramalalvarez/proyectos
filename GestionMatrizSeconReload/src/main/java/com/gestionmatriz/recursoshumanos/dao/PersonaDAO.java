/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.digitalpersona.onetouch.ui.swing.DPFPVerificationEvent;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import java.util.ArrayList;

/**
 *
 * @author YESMI
 */
public interface PersonaDAO {

    public abstract boolean registrarDatosPersonales(Personal objPersonal);

    public abstract ArrayList<Personal> BuscarPersona(String apePaterno, String apeMaterno, String nombres, String dni);

    public abstract int exitePersona(String dni);

    public abstract boolean modificarPersona(Personal objPersonal);

    public abstract boolean actualizarFoto(Personal objPersonal);

    public abstract ArrayList<Personal> BuscarPersonaXEmpresa(int idEmpresa);

    public abstract Personal consultaPersonaPorHuella(DPFPVerificationEvent fe);

    public Personal BuscarPersonaXCodigo(String idPersona);
}
