/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.Contrato;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornada;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornadaContrato;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.recursoshumanos.bean.TipoContrato;

import java.util.List;

/**
 *
 * @author zholo
 */
public interface ContratoDAO {

    public abstract Empresa buscarEmpresa(int idEmpresa);

    public abstract List<Local> buscarLocal(int idEmpresa);

    public List<Empresa> listarEmpresa();

    public List<Personal> listaPersonasXEmpresa(int empresa);

    public abstract List<TipoContrato> listatipoContrato();

    public abstract boolean registrarContrato(Contrato objContrato,
            List<HorarioJornada> listaHorarioJornada);

    public List<HorarioJornadaContrato> consultaContrato(String dni, int query);
    
    public List<HorarioJornadaContrato> consultarContratoXPersona(int empresa, String codigoPersona, String estado);

    public HorarioJornadaContrato consultaContrato(int contrato);

    public abstract boolean renovarContrato(Contrato objContrato,
            List<HorarioJornada> listaHorarioJornada);

    public abstract boolean cancelarContrato(Contrato objContrato);

    public abstract String buscarCargoXIDPersona(int idPersona);

    public int consultarContratoXPersona(int idPersona);
    
    public boolean modificarHorarioPersona(int idContrato, List<HorarioJornada> listaHJ, String usuarioModificador);
    
    public boolean modificarLocalPersona(int idContrato, int idLocal);

    public Local buscarLocalNombre(int idEmpresa, String nombre);
}
