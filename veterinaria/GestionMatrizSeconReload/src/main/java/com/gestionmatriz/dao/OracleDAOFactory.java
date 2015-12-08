/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.dao;

import com.gestionmatriz.almacen.dao.AlmacenDAO;
import com.gestionmatriz.almacen.dao.ConformidadDAO;
import com.gestionmatriz.almacen.dao.FamiliaDAO;
import com.gestionmatriz.almacen.dao.KardexDAO;
import com.gestionmatriz.almacen.dao.MedidaRotacionDAO;
import com.gestionmatriz.almacen.dao.OrdenCompraDAO;
import com.gestionmatriz.almacen.dao.ProductoDAO;
import com.gestionmatriz.almacen.dao.ProveedorDAO;
import com.gestionmatriz.almacen.dao.ProveedorProductoDAO;
import com.gestionmatriz.almacen.dao.ProveedorProductoUnidadMedidaDAO;
import com.gestionmatriz.almacen.dao.RecepcionMercaderiaDAO;
import com.gestionmatriz.almacen.dao.TraspasoMercaderiaDAO;
import com.gestionmatriz.almacen.dao.UnidadMedidaDAO;
import com.gestionmatriz.config.dao.BDConfigDAO;
import com.gestionmatriz.config.dao.KeyDAO;
import com.gestionmatriz.config.dao.OtrosDAO;
import com.gestionmatriz.contabilidad.dao.CuentasDAO;
import com.gestionmatriz.contabilidad.dao.ElementoDAO;
import com.gestionmatriz.contabilidad.dao.SubCuentasDAO;
import com.gestionmatriz.puntoventa.dao.ClienteDAO;
import com.gestionmatriz.puntoventa.dao.FlujoCajaDAO;
import com.gestionmatriz.puntoventa.dao.GuiaRemisionDAO;
import com.gestionmatriz.puntoventa.dao.ImpresoraDAO;
import com.gestionmatriz.puntoventa.dao.RegistroVentaDAO;
import com.gestionmatriz.puntoventa.dao.TipoCambioDAO;
import com.gestionmatriz.puntoventa.dao.VentaDAO;
import com.gestionmatriz.recursoshumanos.dao.AsistenciaDAO;
import com.gestionmatriz.recursoshumanos.dao.BonificacionDAO;
import com.gestionmatriz.recursoshumanos.dao.ConfigDAO;
import com.gestionmatriz.recursoshumanos.dao.ContratoDAO;
import com.gestionmatriz.recursoshumanos.dao.DatosAcademicosDAO;
import com.gestionmatriz.recursoshumanos.dao.DatosFamiliaresDAO;
import com.gestionmatriz.recursoshumanos.dao.ExperienciaLaboralDAO;
import com.gestionmatriz.recursoshumanos.dao.HorarioDAO;
import com.gestionmatriz.recursoshumanos.dao.MemorandumDAO;
import com.gestionmatriz.recursoshumanos.dao.OtrosEstudiosDAO;
import com.gestionmatriz.recursoshumanos.dao.PensionDAO;
import com.gestionmatriz.recursoshumanos.dao.PermisoDAO;
import com.gestionmatriz.recursoshumanos.dao.PersonaDAO;
import com.gestionmatriz.recursoshumanos.dao.ReporteDAO;
import com.gestionmatriz.reutilizable.dao.ConfigBDDAO;
import com.gestionmatriz.reutilizable.dao.UbigeoDAO;
import com.gestionmatriz.seguridad.dao.FuncionUsuarioDAO;
import com.gestionmatriz.seguridad.dao.FuncionesDAO;
import com.gestionmatriz.seguridad.dao.ModuloDAO;
import com.gestionmatriz.seguridad.dao.UsuarioDAO;
import com.gestionmatriz.seguridad.dao.UtilMysqlDAO;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author YESMI
 */
class OracleDAOFactory extends DAOFactory {

    public OracleDAOFactory() {
    }

    @Override
    public PersonaDAO getPersonaDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DatosAcademicosDAO getDatosAcademicosDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ExperienciaLaboralDAO getExperienciaLaboralDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OtrosEstudiosDAO getOtrosEstudios() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DatosFamiliaresDAO getDatosFamiliares() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FuncionesDAO getFuncionesDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FuncionUsuarioDAO getFuncionUsuarioDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BDConfigDAO getBDConfigDAO(String archivo) throws ParserConfigurationException, SAXException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public KeyDAO getKeyDAO(String archivo) throws ParserConfigurationException, SAXException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OtrosDAO getOtrosDAO(String archivo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UbigeoDAO getUbigeoDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ModuloDAO getModuloDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ContratoDAO getContratoDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HorarioDAO getHorarioDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AsistenciaDAO getAsistenciaDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UtilMysqlDAO getUtilMysqlDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ConfigBDDAO getConfigBDDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PermisoDAO getPermisoDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MemorandumDAO getMemorandumDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ReporteDAO getReporteDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProductoDAO getProductoDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProveedorDAO getProveedorDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FamiliaDAO getFamiliaDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UnidadMedidaDAO getUnidadMedidaDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OrdenCompraDAO getOrdenCompraDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProveedorProductoDAO getProveedorProductoDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RecepcionMercaderiaDAO getRecepcionMercaderiaDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ConformidadDAO getConformidadDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public GuiaRemisionDAO getGuiaRemisionDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TraspasoMercaderiaDAO getTraspasoMercaderiaDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AlmacenDAO getAlmacenDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MedidaRotacionDAO getMedidaRotacionDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProveedorProductoUnidadMedidaDAO getProveedorProductoUnidadMedidaDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TipoCambioDAO getTipoCambioDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public VentaDAO getVentaDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlujoCajaDAO getFlujoCajaDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ClienteDAO getClienteDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CuentasDAO getCuentasDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ElementoDAO getElementoDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SubCuentasDAO getSubCuentasDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PensionDAO getPensionDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ConfigDAO getConfigDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BonificacionDAO getBonificacionDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public KardexDAO getKardexDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RegistroVentaDAO getRegistroVentaDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ImpresoraDAO getImpresoraDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
