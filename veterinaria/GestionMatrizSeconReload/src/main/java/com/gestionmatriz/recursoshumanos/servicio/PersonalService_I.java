/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import java.sql.SQLException;
import java.util.ArrayList;

import com.digitalpersona.onetouch.ui.swing.DPFPVerificationEvent;
import com.gestionmatriz.recursoshumanos.bean.Personal;

/**
 *
 * @author YESM
 */
public interface PersonalService_I {

    public abstract boolean registrarDatosPersonales(Personal objPersonal) throws SQLException;

    public abstract ArrayList<Personal> BuscarPersona(String apePaterno, String apeMaterno, String nombres, String dni) throws SQLException;

    public abstract int exitePersona(String dni);

    public abstract boolean modificarPersona(Personal objPersonal);

    public abstract boolean actualizarFoto(Personal objPersonal);

    public abstract Personal consultaPersonaPorHuella(DPFPVerificationEvent fe);

    public abstract ArrayList<Personal> BuscarPersonaXEmpresa(int idEmpresa);

    public Personal BuscarPersonaXCodigo(String idPersona) throws SQLException;
}
