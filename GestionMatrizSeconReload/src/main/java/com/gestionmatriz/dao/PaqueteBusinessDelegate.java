/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.dao;

import com.gestionmatriz.almacen.servicios.AlmacenService;
import com.gestionmatriz.almacen.servicios.AlmacenService_I;
import com.gestionmatriz.almacen.servicios.FamiliaService;
import com.gestionmatriz.almacen.servicios.FamiliaService_I;
import com.gestionmatriz.almacen.servicios.OrdenCompraService;
import com.gestionmatriz.almacen.servicios.OrdenCompraService_I;
import com.gestionmatriz.almacen.servicios.ProductoService;
import com.gestionmatriz.almacen.servicios.ProductoService_I;
import com.gestionmatriz.almacen.servicios.ProveedorProductoService;
import com.gestionmatriz.almacen.servicios.ProveedorProductoService_I;
import com.gestionmatriz.almacen.servicios.ProveedorService;
import com.gestionmatriz.almacen.servicios.ProveedorService_I;
import com.gestionmatriz.almacen.servicios.RecepcionMercaderiaService;
import com.gestionmatriz.almacen.servicios.RecepcionMercaderiaService_I;
import com.gestionmatriz.almacen.servicios.ConformidadService;
import com.gestionmatriz.almacen.servicios.ConformidadService_I;
import com.gestionmatriz.almacen.servicios.KardexService;
import com.gestionmatriz.almacen.servicios.MedidaRotacionService;
import com.gestionmatriz.almacen.servicios.MedidaRotacionService_I;
import com.gestionmatriz.almacen.servicios.ProveedorProductoUnidadMedidaService;
import com.gestionmatriz.almacen.servicios.ProveedorProductoUnidadMedidaService_I;
import com.gestionmatriz.almacen.servicios.TraspasoMercaderiaService;
import com.gestionmatriz.almacen.servicios.TraspasoMercaderiaService_I;
import com.gestionmatriz.almacen.servicios.UnidadMedidaService;
import com.gestionmatriz.almacen.servicios.UnidadMedidaService_I;
import com.gestionmatriz.almacen.servicios.KardexService_I;
import com.gestionmatriz.config.services.BDConfigService;
import com.gestionmatriz.config.services.BDConfigService_I;
import com.gestionmatriz.config.services.KeyService;
import com.gestionmatriz.config.services.KeyService_I;
import com.gestionmatriz.config.services.OtrosService;
import com.gestionmatriz.config.services.OtrosService_I;
import com.gestionmatriz.contabilidad.servicios.CuentasService;
import com.gestionmatriz.contabilidad.servicios.CuentasService_I;
import com.gestionmatriz.contabilidad.servicios.ElementoService;
import com.gestionmatriz.contabilidad.servicios.ElementoService_I;
import com.gestionmatriz.contabilidad.servicios.SubCuentasService;
import com.gestionmatriz.contabilidad.servicios.SubCuentasService_I;
import com.gestionmatriz.puntoventa.servicios.ClienteService;
import com.gestionmatriz.puntoventa.servicios.ClienteService_I;
import com.gestionmatriz.puntoventa.servicios.FlujoCajaService;
import com.gestionmatriz.puntoventa.servicios.FlujoCajaService_I;
import com.gestionmatriz.puntoventa.servicios.GuiaRemisionService;
import com.gestionmatriz.puntoventa.servicios.GuiaRemisionService_I;
import com.gestionmatriz.puntoventa.servicios.ImpresoraService;
import com.gestionmatriz.puntoventa.servicios.ImpresoraService_I;
import com.gestionmatriz.puntoventa.servicios.RegistroVentaService;
import com.gestionmatriz.puntoventa.servicios.RegistroVentaService_I;
import com.gestionmatriz.puntoventa.servicios.TipoCambioService;
import com.gestionmatriz.puntoventa.servicios.TipoCambioService_I;
import com.gestionmatriz.puntoventa.servicios.VentaService;
import com.gestionmatriz.puntoventa.servicios.VentasService_I;
import com.gestionmatriz.recursoshumanos.servicio.AsistenciaService;
import com.gestionmatriz.recursoshumanos.servicio.Asistencia_I;
import com.gestionmatriz.recursoshumanos.servicio.BonificacionService;
import com.gestionmatriz.recursoshumanos.servicio.BonificacionService_I;
import com.gestionmatriz.recursoshumanos.servicio.ConfigService;
import com.gestionmatriz.recursoshumanos.servicio.ConfigService_I;
import com.gestionmatriz.recursoshumanos.servicio.ContratoService;
import com.gestionmatriz.recursoshumanos.servicio.ContratoService_I;
import com.gestionmatriz.recursoshumanos.servicio.HorarioService;
import com.gestionmatriz.recursoshumanos.servicio.HorarioService_I;
import com.gestionmatriz.recursoshumanos.servicio.MemorandumService;
import com.gestionmatriz.recursoshumanos.servicio.MemorandumService_I;
import com.gestionmatriz.recursoshumanos.servicio.PensionService;
import com.gestionmatriz.recursoshumanos.servicio.PensionService_I;
import com.gestionmatriz.recursoshumanos.servicio.PermisosService;
import com.gestionmatriz.recursoshumanos.servicio.PermisosService_I;
import com.gestionmatriz.recursoshumanos.servicio.PersonalService;
import com.gestionmatriz.recursoshumanos.servicio.PersonalService_I;
import com.gestionmatriz.recursoshumanos.servicio.ReporteService;
import com.gestionmatriz.recursoshumanos.servicio.ReporteService_I;
import com.gestionmatriz.reutilizable.services.ConfigBDService;
import com.gestionmatriz.reutilizable.services.ConfigBDService_I;
import com.gestionmatriz.reutilizable.services.UbigeoService;
import com.gestionmatriz.reutilizable.services.UbigeoService_I;
import com.gestionmatriz.seguridad.servicio.FuncionesService;
import com.gestionmatriz.seguridad.servicio.FuncionesService_I;
import com.gestionmatriz.seguridad.servicio.FuncionesUsuarioService;
import com.gestionmatriz.seguridad.servicio.FuncionesUsuarioService_I;
import com.gestionmatriz.seguridad.servicio.ModuloService;
import com.gestionmatriz.seguridad.servicio.ModulosService_I;
import com.gestionmatriz.seguridad.servicio.UsuarioService;
import com.gestionmatriz.seguridad.servicio.UsuarioService_I;
import com.gestionmatriz.seguridad.servicio.UtilMysqlService;
import com.gestionmatriz.seguridad.servicio.UtilMysqlService_I;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author YESM
 */
public class PaqueteBusinessDelegate {

    public static BDConfigService_I getBDConfigService()
            throws ParserConfigurationException, SAXException, IOException {
        return new BDConfigService();
    }

    public static KeyService_I getKeyService()
            throws ParserConfigurationException, SAXException, IOException {
        return new KeyService();
    }

    public static OtrosService_I getOtrosService() {
        return new OtrosService();
    }

    /**
     * ***************************Modulo de Seguridad*****************************
     */
    public static UsuarioService_I getUsuarioService() {
        return new UsuarioService();
    }

    public static FuncionesService_I getFuncionesService() {
        return new FuncionesService();
    }

    public static ModulosService_I getModuloService() {
        return new ModuloService();
    }

    public static UtilMysqlService_I getUtilMysqlServices() {
        return new UtilMysqlService();
    }

    public static FuncionesUsuarioService_I getFuncionesUsuarioService() {
        return new FuncionesUsuarioService();
    }
    /**
     * ***************************Modulo de Seguridad*****************************
     */
    
    /**
     * *************************MOdulo Reutilizable*******************************
     */
    public static UbigeoService_I getUbigeoService() {
        return new UbigeoService();
    }
    /**
     * *************************MOdulo Reutilizable*******************************
     */
    
    /**
     * *************************Modulo RRHH**************************************
     */
    public static PersonalService_I getPersonalService() {
        return new PersonalService();
    }

    public static ContratoService_I getContratoService() {
        return new ContratoService();
    }

    public static HorarioService_I getHorarioService() {
        return new HorarioService();
    }

    public static Asistencia_I getAsistenciaService() {
        return new AsistenciaService();
    }

    public static ConfigBDService_I getConfigBDService() {
        return new ConfigBDService();
    }

    public static PermisosService_I getPermisosService() {
        return new PermisosService();
    }

    public static MemorandumService_I getMemorandumService() {
        return new MemorandumService();
    }

    public static ReporteService_I getRporteService() {
        return new ReporteService();
    }
    
    public static PensionService_I getPensionService() {
        return new PensionService();
    }
    
    public static ConfigService_I getConfigService(){
        return new ConfigService();
    }
    
    public static BonificacionService_I getBonificacionService(){
        return new BonificacionService();
    }
    /**
     * *************************Modulo RRHH**************************************
     */
    
    /**
     * *************************Modulo Logistica**************************************
     */
    public static ProductoService_I getProductoService() {
        return new ProductoService();
    }

    public static ProveedorService_I getProveedorService() {
        return new ProveedorService();
    }

    public static FamiliaService_I getFamiliaService() {
        return new FamiliaService();
    }

    public static UnidadMedidaService_I getUnidadMedidaService() {
        return new UnidadMedidaService();
    }

    public static OrdenCompraService_I getOrdenCompraService() {
        return new OrdenCompraService();
    }

    public static ProveedorProductoService_I getProveedorProductoService() {
        return new ProveedorProductoService();
    }

    public static RecepcionMercaderiaService_I getRecepcionMercaderiaService() {
        return new RecepcionMercaderiaService();
    }

    public static ConformidadService_I getConformidadService() {
        return new ConformidadService();
    }

    public static TraspasoMercaderiaService_I getTraspasoMercaderiaService() {
        return new TraspasoMercaderiaService();
    }

    public static AlmacenService_I getAlmacenService() {
        return new AlmacenService();
    }

    public static MedidaRotacionService_I getMedidaRotacionService() {
        return new MedidaRotacionService();
    }

    public static ProveedorProductoUnidadMedidaService_I getProveedorProductoUnidadMedidaService() {
        return new ProveedorProductoUnidadMedidaService();
    }
    
    public static KardexService_I getKardexService(){
        return new KardexService();
    }
    /**
     * *************************Modulo Logistica**************************************
     */
    
    /**
     * *************************Modulo Venta******************************************
     */
    public static GuiaRemisionService_I getGuiaRemisionService() {
        return new GuiaRemisionService();
    }

    public static VentasService_I getVentasService() {
        return new VentaService();
    }

    public static TipoCambioService_I getTipoCambioService() {
        return new TipoCambioService();
    }

    public static FlujoCajaService_I getFlujoCajaService() {
        return new FlujoCajaService();
    }

    public static ClienteService_I getClienteService() {
        return new ClienteService();
    }
    
    public static RegistroVentaService_I getRegistroVentaService() {
        return new RegistroVentaService();
    }
    
    
    public static ImpresoraService_I getImpresoraService(){
        return new ImpresoraService();
    }
    /**
     * *************************Modulo Venta******************************************
     */
    
    /**
     * *************************Modulo Contabilidad******************************************
     */
    public static CuentasService_I getCuentasService() {
        return new CuentasService();
    }

    public static ElementoService_I getElementoService() {
        return new ElementoService();
    }

    public static SubCuentasService_I getSubCuentasService() {
        return new SubCuentasService();
    }
    /**
     * *************************Modulo Contabilidad******************************************
     */
}
