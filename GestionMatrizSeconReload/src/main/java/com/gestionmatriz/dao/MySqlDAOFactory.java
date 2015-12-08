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
import com.gestionmatriz.almacen.dao.MysqlAlmacenDAO;
import com.gestionmatriz.almacen.dao.MysqlConformidadDAO;
import com.gestionmatriz.almacen.dao.MysqlFamiliaDAO;
import com.gestionmatriz.almacen.dao.MysqlKardexDAO;
import com.gestionmatriz.almacen.dao.MysqlMedidaRotacionDAO;
import com.gestionmatriz.almacen.dao.MysqlOrdenCompraDAO;
import com.gestionmatriz.almacen.dao.MysqlProductoDAO;
import com.gestionmatriz.almacen.dao.MysqlProveedorDAO;
import com.gestionmatriz.almacen.dao.MysqlProveedorProductoDAO;
import com.gestionmatriz.almacen.dao.MysqlProveedorProductoUnidadMedidaDAO;
import com.gestionmatriz.almacen.dao.MysqlRecepcionMercaderiaDAO;
import com.gestionmatriz.almacen.dao.MysqlTraspasoMercaderiaDAO;
import com.gestionmatriz.almacen.dao.MysqlUnidadMedidaDAO;
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
import com.gestionmatriz.contabilidad.dao.MysqlCuentasDAO;
import com.gestionmatriz.contabilidad.dao.MysqlElementoDAO;
import com.gestionmatriz.contabilidad.dao.MysqlSubCuentasDAO;
import com.gestionmatriz.contabilidad.dao.SubCuentasDAO;
import com.gestionmatriz.puntoventa.dao.ClienteDAO;
import com.gestionmatriz.puntoventa.dao.FlujoCajaDAO;
import com.gestionmatriz.puntoventa.dao.GuiaRemisionDAO;
import com.gestionmatriz.puntoventa.dao.ImpresoraDAO;
import com.gestionmatriz.puntoventa.dao.MysqlClienteDAO;
import com.gestionmatriz.puntoventa.dao.MysqlFlujoCajaDAO;
import com.gestionmatriz.puntoventa.dao.MysqlGuiaRemisionDAO;
import com.gestionmatriz.puntoventa.dao.MysqlImpresoraDAO;
import com.gestionmatriz.puntoventa.dao.MysqlRegistroVentaDAO;
import com.gestionmatriz.puntoventa.dao.MysqlTipoCambioDAO;
import com.gestionmatriz.puntoventa.dao.MysqlVentaDAO;
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
import com.gestionmatriz.recursoshumanos.dao.MysqlAsistenciaDAO;
import com.gestionmatriz.recursoshumanos.dao.MysqlBonificacionDAO;
import com.gestionmatriz.recursoshumanos.dao.MysqlContratoDAO;
import com.gestionmatriz.recursoshumanos.dao.MysqlDatosAcademicosDAO;
import com.gestionmatriz.recursoshumanos.dao.MysqlDatosFamiliaresDAO;
import com.gestionmatriz.recursoshumanos.dao.MysqlExperienciaLaboralDAO;
import com.gestionmatriz.recursoshumanos.dao.MysqlHorarioDAO;
import com.gestionmatriz.recursoshumanos.dao.MysqlMemorandumDAO;
import com.gestionmatriz.recursoshumanos.dao.MysqlOtrosEstudiosDAO;
import com.gestionmatriz.recursoshumanos.dao.MysqlPensionDAO;
import com.gestionmatriz.recursoshumanos.dao.MysqlPermisoDAO;
import com.gestionmatriz.recursoshumanos.dao.MysqlPersonaDAO;
import com.gestionmatriz.recursoshumanos.dao.MysqlReporteDAO;
import com.gestionmatriz.recursoshumanos.dao.OtrosEstudiosDAO;
import com.gestionmatriz.recursoshumanos.dao.PensionDAO;
import com.gestionmatriz.recursoshumanos.dao.PermisoDAO;
import com.gestionmatriz.recursoshumanos.dao.PersonaDAO;
import com.gestionmatriz.recursoshumanos.dao.ReporteDAO;
import com.gestionmatriz.reutilizable.dao.ConfigBDDAO;
import com.gestionmatriz.reutilizable.dao.MysqlConfigDAO;
import com.gestionmatriz.reutilizable.dao.MysqlUbigeoDAO;
import com.gestionmatriz.reutilizable.dao.UbigeoDAO;
import com.gestionmatriz.seguridad.dao.FuncionUsuarioDAO;
import com.gestionmatriz.seguridad.dao.FuncionesDAO;
import com.gestionmatriz.seguridad.dao.ModuloDAO;
import com.gestionmatriz.seguridad.dao.MysqlFuncionUsuarioDAO;
import com.gestionmatriz.seguridad.dao.MysqlFuncionesDAO;
import com.gestionmatriz.seguridad.dao.MysqlModuloDAO;
import com.gestionmatriz.seguridad.dao.MysqlUsuarioDAO;
import com.gestionmatriz.seguridad.dao.MysqlUtilDAO;
import com.gestionmatriz.seguridad.dao.UsuarioDAO;
import com.gestionmatriz.seguridad.dao.UtilMysqlDAO;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author YESMI
 */
class MySqlDAOFactory extends DAOFactory {

    public MySqlDAOFactory() {
    }

    @Override
    public PersonaDAO getPersonaDAO() {
        return new MysqlPersonaDAO();
    }

    @Override
    public DatosAcademicosDAO getDatosAcademicosDAO() {
       return new MysqlDatosAcademicosDAO();
    }

    @Override
    public ExperienciaLaboralDAO getExperienciaLaboralDAO() {
        return new MysqlExperienciaLaboralDAO();
    }

    @Override
    public OtrosEstudiosDAO getOtrosEstudios() {
        return new MysqlOtrosEstudiosDAO();
    }

    @Override
    public DatosFamiliaresDAO getDatosFamiliares() {
        return new MysqlDatosFamiliaresDAO();
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new MysqlUsuarioDAO();
    }

    @Override
    public FuncionesDAO getFuncionesDAO() {
       return new MysqlFuncionesDAO();
    }

    @Override
    public FuncionUsuarioDAO getFuncionUsuarioDAO() {
        return new MysqlFuncionUsuarioDAO();
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
        return new MysqlUbigeoDAO();
    }

    @Override
    public ModuloDAO getModuloDAO() {
        return new MysqlModuloDAO();
    }

    @Override
    public ContratoDAO getContratoDAO() {
        return new MysqlContratoDAO();
    }

    @Override
    public HorarioDAO getHorarioDAO() {
        return new MysqlHorarioDAO();
    }

    @Override
    public AsistenciaDAO getAsistenciaDAO() {
        return new MysqlAsistenciaDAO();
    }

    @Override
    public UtilMysqlDAO getUtilMysqlDAO() {
        return new MysqlUtilDAO();
    }

    @Override
    public ConfigBDDAO getConfigBDDAO() {
        return new MysqlConfigDAO();
    }

    @Override
    public PermisoDAO getPermisoDAO() {
       return new MysqlPermisoDAO();
    }

    @Override
    public MemorandumDAO getMemorandumDAO() {
         return new MysqlMemorandumDAO();
    }

    @Override
    public ReporteDAO getReporteDAO() {
        return new MysqlReporteDAO();
    }

    @Override
    public ProductoDAO getProductoDAO() {
         return new MysqlProductoDAO();
    }

    @Override
    public ProveedorDAO getProveedorDAO() {
        return new MysqlProveedorDAO();
    }

    @Override
    public FamiliaDAO getFamiliaDAO() {
        return new MysqlFamiliaDAO();
    }

    @Override
    public UnidadMedidaDAO getUnidadMedidaDAO() {
        return new MysqlUnidadMedidaDAO();
    }

    @Override
    public OrdenCompraDAO getOrdenCompraDAO() {
        return new MysqlOrdenCompraDAO();
    }

    @Override
    public ProveedorProductoDAO getProveedorProductoDAO() {
        return new MysqlProveedorProductoDAO();
    }

    @Override
    public RecepcionMercaderiaDAO getRecepcionMercaderiaDAO() {
        return new MysqlRecepcionMercaderiaDAO();
    }

    @Override
    public ConformidadDAO getConformidadDAO() {
        return new MysqlConformidadDAO();
    }

    @Override
    public GuiaRemisionDAO getGuiaRemisionDAO() {
        return new MysqlGuiaRemisionDAO();
    }

    @Override
    public TraspasoMercaderiaDAO getTraspasoMercaderiaDAO() {
        return new MysqlTraspasoMercaderiaDAO();
    }

    @Override
    public AlmacenDAO getAlmacenDAO() {
        return new MysqlAlmacenDAO();
    }

    @Override
    public MedidaRotacionDAO getMedidaRotacionDAO() {
        return new MysqlMedidaRotacionDAO();
    }

    @Override
    public ProveedorProductoUnidadMedidaDAO getProveedorProductoUnidadMedidaDAO() {
        return new MysqlProveedorProductoUnidadMedidaDAO();
    }

    @Override
    public TipoCambioDAO getTipoCambioDAO() {
        return new MysqlTipoCambioDAO();
    }

    @Override
    public VentaDAO getVentaDAO() {
       return new MysqlVentaDAO();
    }

    @Override
    public FlujoCajaDAO getFlujoCajaDAO() {
        return new MysqlFlujoCajaDAO();
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return new MysqlClienteDAO();
    }

    @Override
    public CuentasDAO getCuentasDAO() {
        return new MysqlCuentasDAO();
    }

    @Override
    public ElementoDAO getElementoDAO() {
        return new MysqlElementoDAO();
    }

    @Override
    public SubCuentasDAO getSubCuentasDAO() {
        return new MysqlSubCuentasDAO();
    }

    @Override
    public PensionDAO getPensionDAO() {
        return new MysqlPensionDAO();
    }

    @Override
    public ConfigDAO getConfigDAO() {
       return new com.gestionmatriz.recursoshumanos.dao.MysqlConfigDAO();
    }

    @Override
    public BonificacionDAO getBonificacionDAO() {
        return new MysqlBonificacionDAO();
    }

    @Override
    public KardexDAO getKardexDAO() {
       return new MysqlKardexDAO();
    }

    @Override
    public RegistroVentaDAO getRegistroVentaDAO() {
        return new MysqlRegistroVentaDAO();
    }

    @Override
    public ImpresoraDAO getImpresoraDAO() {
        return new MysqlImpresoraDAO();
    }
}
