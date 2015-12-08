/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.recursoshumanos.bean.Contrato;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornada;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornadaContrato;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.recursoshumanos.bean.TipoContrato;
import com.gestionmatriz.recursoshumanos.dao.ContratoDAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author zholo
 */
public class ContratoService implements ContratoService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    ContratoDAO objContratoDAO = fabrica.getContratoDAO();

    @Override
    public Empresa buscarContrato(int idEmpresa) throws SQLException {
        return objContratoDAO.buscarEmpresa(idEmpresa);
    }

    @Override
    public List<Empresa> listarEmpresa() throws SQLException {
        return objContratoDAO.listarEmpresa();
    }

    @Override
    public List<TipoContrato> listatipoContrato() throws SQLException {
        return objContratoDAO.listatipoContrato();
    }

    @Override
    public boolean registrarContrato(Contrato objContrato, List<HorarioJornada> listaHorarioJornada) {
        return objContratoDAO.registrarContrato(objContrato, listaHorarioJornada);
    }

    @Override
    public List<HorarioJornadaContrato> consultaContrato(String dni, int query) {
        return objContratoDAO.consultaContrato(dni, query);
    }

    @Override
    public HorarioJornadaContrato consultaContrato(int contrato) {
        return objContratoDAO.consultaContrato(contrato);
    }

    @Override
    public boolean renovarContrato(Contrato objContrato, List<HorarioJornada> listaHorarioJornada) {
        return objContratoDAO.renovarContrato(objContrato, listaHorarioJornada);
    }

    @Override
    public boolean cancelarContrato(Contrato objContrato) {
        return objContratoDAO.cancelarContrato(objContrato);
    }

    @Override
    public List<Local> buscarLocal(int idEmpresa) {
        return objContratoDAO.buscarLocal(idEmpresa);
    }

    @Override
    public String buscarCargoXIDPersona(int idPersona) {
        return objContratoDAO.buscarCargoXIDPersona(idPersona);
    }

    @Override
    public List<Personal> listaPersonasXEmpresa(int empresa) {
        return objContratoDAO.listaPersonasXEmpresa(empresa);
    }

    @Override
    public List<HorarioJornadaContrato> consultarContratoXPersona(int empresa, String codigoPersona, String estado) {
        return objContratoDAO.consultarContratoXPersona(empresa, codigoPersona, estado);
    }

    @Override
    public int idContrato(int idPersona) {
        return objContratoDAO.consultarContratoXPersona(idPersona);
    }

    @Override
    public boolean modificarHorarioPersona(int idContrato, List<HorarioJornada> listaHJ, String usuarioModificador) {
        return objContratoDAO.modificarHorarioPersona(idContrato, listaHJ, usuarioModificador);
    }

    @Override
    public boolean modificarLocalPersona(int idContrato, int idLocal) {
        return objContratoDAO.modificarLocalPersona(idContrato, idLocal);
    }

    @Override
    public Local buscarLocalNombre(int idEmpresa, String nombre) {
        return objContratoDAO.buscarLocalNombre(idEmpresa,nombre);
    }
}
