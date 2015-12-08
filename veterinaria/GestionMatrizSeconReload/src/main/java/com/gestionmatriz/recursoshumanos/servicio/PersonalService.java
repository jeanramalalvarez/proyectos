/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.digitalpersona.onetouch.ui.swing.DPFPVerificationEvent;
import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.recursoshumanos.dao.PersonaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author YESM
 */
public class PersonalService implements PersonalService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    PersonaDAO objPersonalDAO = fabrica.getPersonaDAO();

    @Override
    public boolean registrarDatosPersonales(Personal objPersonal) throws SQLException {
        return objPersonalDAO.registrarDatosPersonales(objPersonal);
    }

    @Override
    public ArrayList<Personal> BuscarPersona(String apePaterno, String apeMaterno, String nombres, String dni) throws SQLException {
        return objPersonalDAO.BuscarPersona(apePaterno, apeMaterno, nombres, dni);
    }

    @Override
    public int exitePersona(String dni) {
        return objPersonalDAO.exitePersona(dni);
    }

    @Override
    public boolean modificarPersona(Personal objPersonal) {
        return objPersonalDAO.modificarPersona(objPersonal);
    }

    @Override
    public boolean actualizarFoto(Personal objPersonal) {
        return objPersonalDAO.actualizarFoto(objPersonal);
    }

    @Override
    public Personal consultaPersonaPorHuella(DPFPVerificationEvent fe) {
        return objPersonalDAO.consultaPersonaPorHuella(fe);
    }

    @Override
    public ArrayList<Personal> BuscarPersonaXEmpresa(int idEmpresa) {
        return objPersonalDAO.BuscarPersonaXEmpresa(idEmpresa);
    }

    @Override
    public Personal BuscarPersonaXCodigo(String idPersona) throws SQLException {
        return objPersonalDAO.BuscarPersonaXCodigo(idPersona);
    }
}
