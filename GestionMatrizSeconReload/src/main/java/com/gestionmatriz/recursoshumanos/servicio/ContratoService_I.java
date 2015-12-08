/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.gestionmatriz.recursoshumanos.bean.Contrato;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornada;
import com.gestionmatriz.recursoshumanos.bean.HorarioJornadaContrato;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.recursoshumanos.bean.TipoContrato;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface ContratoService_I {

    public abstract Empresa buscarContrato(int idEmpresa) throws SQLException;

    public abstract List<Empresa> listarEmpresa() throws SQLException;

    public List<TipoContrato> listatipoContrato() throws SQLException;

    public abstract boolean registrarContrato(Contrato objContrato,
            List<HorarioJornada> listaHorarioJornada);

    public List<HorarioJornadaContrato> consultaContrato(String dni, int query);
    
    public List<HorarioJornadaContrato> consultarContratoXPersona(int empresa, String codigoPersona, String estado);

    public HorarioJornadaContrato consultaContrato(int contrato);

    public abstract boolean renovarContrato(Contrato objContrato,
            List<HorarioJornada> listaHorarioJornada);

    public abstract boolean cancelarContrato(Contrato objContrato);

    public abstract List<Local> buscarLocal(int idEmpresa);

    public abstract String buscarCargoXIDPersona(int idPersona);

    public List<Personal> listaPersonasXEmpresa(int empresa);
    
    public abstract int idContrato(int idPersona); 
    
    public abstract boolean modificarHorarioPersona(int idContrato, List<HorarioJornada> listaHJ, String usuarioModificador);
    
    public boolean modificarLocalPersona(int idContrato, int idLocal);
    
    public Local buscarLocalNombre(int idEmpresa, String nombre);
}
