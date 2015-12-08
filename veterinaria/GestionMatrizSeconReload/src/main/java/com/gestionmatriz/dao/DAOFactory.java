/*
 * Created on 01/10/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
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

public abstract class DAOFactory {

    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;

    // Existir� un m�todo por cada DAO que pueda ser creado.
    //Modulo RRHH...............................................................
    public abstract PersonaDAO getPersonaDAO();

    public abstract DatosAcademicosDAO getDatosAcademicosDAO();

    public abstract ExperienciaLaboralDAO getExperienciaLaboralDAO();

    public abstract OtrosEstudiosDAO getOtrosEstudios();

    public abstract DatosFamiliaresDAO getDatosFamiliares();

    public abstract AsistenciaDAO getAsistenciaDAO();

    public abstract PermisoDAO getPermisoDAO();

    public abstract MemorandumDAO getMemorandumDAO();

    public abstract ReporteDAO getReporteDAO();

    public abstract ContratoDAO getContratoDAO();

    public abstract HorarioDAO getHorarioDAO();
    
    public abstract PensionDAO getPensionDAO();
    
    public abstract ConfigDAO getConfigDAO();
    
    public abstract BonificacionDAO getBonificacionDAO();
    //Modulo RRHH...............................................................

    //Modulo Logistica
    public abstract ProductoDAO getProductoDAO();

    public abstract ProveedorDAO getProveedorDAO();

    public abstract FamiliaDAO getFamiliaDAO();

    public abstract UnidadMedidaDAO getUnidadMedidaDAO();

    public abstract OrdenCompraDAO getOrdenCompraDAO();

    public abstract ProveedorProductoDAO getProveedorProductoDAO();

    public abstract RecepcionMercaderiaDAO getRecepcionMercaderiaDAO();

    public abstract ConformidadDAO getConformidadDAO();

    public abstract TraspasoMercaderiaDAO getTraspasoMercaderiaDAO();

    public abstract AlmacenDAO getAlmacenDAO();

    public abstract MedidaRotacionDAO getMedidaRotacionDAO();

    public abstract ProveedorProductoUnidadMedidaDAO getProveedorProductoUnidadMedidaDAO();
    
    public abstract KardexDAO getKardexDAO();
    //Modulo Logistica

    //Módulo Punto de Venta.....................................................
    public abstract GuiaRemisionDAO getGuiaRemisionDAO();

    public abstract TipoCambioDAO getTipoCambioDAO();

    public abstract VentaDAO getVentaDAO();

    public abstract FlujoCajaDAO getFlujoCajaDAO();

    public abstract ClienteDAO getClienteDAO();
    
    public abstract RegistroVentaDAO getRegistroVentaDAO();
    
    public abstract ImpresoraDAO getImpresoraDAO();
    
    //Módulo Punto de Venta.....................................................

    //Modulo Seguridad..........................................................
    public abstract UsuarioDAO getUsuarioDAO();

    public abstract FuncionesDAO getFuncionesDAO();

    public abstract FuncionUsuarioDAO getFuncionUsuarioDAO();

    public abstract ModuloDAO getModuloDAO();

    public abstract UtilMysqlDAO getUtilMysqlDAO();
    //Modulo Seguridad..........................................................

    //Modulo contabilidad.......................................................
    public abstract CuentasDAO getCuentasDAO();

    public abstract ElementoDAO getElementoDAO();

    public abstract SubCuentasDAO getSubCuentasDAO();
    //Modulo contabilidad.......................................................
    
    //Modulo de Configuracion...................................................
    public abstract BDConfigDAO getBDConfigDAO(String archivo) throws
            ParserConfigurationException, SAXException, IOException;

    public abstract KeyDAO getKeyDAO(String archivo) throws
            ParserConfigurationException, SAXException, IOException;

    public abstract OtrosDAO getOtrosDAO(String archivo);
    //Modulo de Configuracion...................................................

    //MOdulo Reutilizable.......................................................
    public abstract UbigeoDAO getUbigeoDAO();

    public abstract ConfigBDDAO getConfigBDDAO();
    //MOdulo Reutilizable.......................................................
    
    public static DAOFactory getDAOFactory(int whichFactory) {

        switch (whichFactory) {
            case MYSQL:
                return new MySqlDAOFactory();
            case XML:
                return new XmlDAOFactory();
            case ORACLE:
                return new OracleDAOFactory();
            case SQLSERVER:
                return new SqlServerDAOFactory();
            /*case DB2:
             return new Db2DAOFactory();
             case SQLSERVER:
             return new SqlServerDAOFactory();
             case XML:
             return new XmlDAOFactory();*/
            default:
                return null;
        }
    }
}
