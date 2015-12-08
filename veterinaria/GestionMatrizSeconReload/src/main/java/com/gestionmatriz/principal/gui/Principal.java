/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Principal.java
 *
 * Created on 11-abr-2012, 8:49:08
 */
package com.gestionmatriz.principal.gui;

import java.awt.Component;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

import javax.swing.JInternalFrame;
import javax.swing.SpinnerNumberModel;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.gestionmatriz.almacen.gui.MenuAlmacen;
import com.gestionmatriz.config.services.KeyService_I;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.puntoventa.bean.TipoCambio;
import com.gestionmatriz.puntoventa.gui.GestionTipoCambio;
import com.gestionmatriz.puntoventa.gui.MenuVentas;
import com.gestionmatriz.recursoshumanos.bean.Config;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.recursoshumanos.gui.MenuRRHH;
import com.gestionmatriz.recursoshumanos.opciones.Opciones;
import com.gestionmatriz.reutilizable.gui.LectorHuella;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.seguridad.bean.FuncionUsuario;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.util.EncriptionSource;
import com.gestionmatriz.util.FunctionByte;
import com.gestionmatriz.util.Mensaje;
import com.gestionmatriz.util.Util;

/**
 *
 * @author zholo
 */
public class Principal extends javax.swing.JFrame {

	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private static final Logger log=Logger.getLogger(Principal.class);  
    private SpinnerNumberModel farRequested = new SpinnerNumberModel(DPFPVerification.MEDIUM_SECURITY_FAR, 1, DPFPVerification.PROBABILITY_ONE, 100);
    private LectorHuella frmLectoHuella;
    private Personal objPersonalHuella;
    private List<FuncionUsuario> lstFuncionesUsuario;
    private int codigoPersona;
    private Empresa objEmpresa;
    private Local objLocal;
    private GestionTipoCambio frmGestionTipoCambio;
    private TipoCambio objTC;
    private String strFormatoTicket;
    
    /*
    * Agregado para manejar objetos en sesion
    */
    private List<Local> listaLocal;
    private List<Config> listaConfig=PaqueteBusinessDelegate.getConfigService().listaConfig(); 

    public Principal(int usuario, Empresa objEmpresa, Local objLocal) {
        this.objEmpresa = objEmpresa;
        this.objLocal = objLocal;
        this.setLstFuncionesUsuario(PaqueteBusinessDelegate.getFuncionesUsuarioService().listaFuncionesXUsuario(usuario));
        this.getListaLocal();

        initComponents();
        ((Fondo) pnlEscritorio).setImagen("/com/gestionmatriz/icon/fondomatriz.png");
        mnuPrincipal.add(new MenuSistema(this));
        mnuPrincipal.add(new MenuRRHH(this));

        String fechaDia = PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql().substring(0, 10);
        objTC = PaqueteBusinessDelegate.getTipoCambioService().obtenerTipoCambio(fechaDia);

        if ((objTC != null) || ((objLocal!=null)&&(objLocal.getInt_idLocal() == Util.idLocalAG))) {
            mnuPrincipal.add(new MenuAlmacen(this));
            mnuPrincipal.add(new MenuVentas(this));
//          mnuPrincipal.add(new MenuContabilidad(this));
        } else {
            if (Filtro.opcionPermitida(this.getLstFuncionesUsuario(), com.gestionmatriz.puntoventa.opciones.Opciones.getINGRESA_TIPOCAMBIO())) {
                Object objConfirmacion = Mensaje.confirmar(this, "¿Desea ingresar Tipo de Cambio del día?",
                        "Mensaje Confirmación", Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);
                if (objConfirmacion.equals(Mensaje.YES_OPTION)) {
                    Util.hiloProgressBar(1, this);
                    if (frmGestionTipoCambio == null || frmGestionTipoCambio.isClosed()) {
                        frmGestionTipoCambio = new GestionTipoCambio(this);
                        frmGestionTipoCambio.setVisible(true);
                        this.addFrm(frmGestionTipoCambio);
                        this.enforcar(frmGestionTipoCambio);
                        this.getBarraEstado().nuevaVentanas();
                        Util.setCentrarJInternalFrame(frmGestionTipoCambio);
                    }
                    Util.hiloProgressBar(0, this);
                }
            }
//            
//            objTC = PaqueteBusinessDelegate.getTipoCambioService().obtenerTipoCambio(fechaDia);
//            
//            if (objTC != null) {
//                mnuPrincipal.add(new MenuAlmacen(this));
//                mnuPrincipal.add(new MenuVentas(this));
//            }
        }

//        boolean respuesta=false;
//        
//        for (FuncionUsuario funcionUsuario : lstFuncionesUsuario) {
//            if (funcionUsuario.getObjFunciones().getStr_key().equals(String.valueOf(Opciones.getACCESOSISTEMA()))){
//                respuesta=true;
//                
//                break;
//            }
//        }
        if (!Filtro.opcionPermitida(getLstFuncionesUsuario(), Opciones.getACCESOSISTEMA())) {
            Mensaje.mensaje(this, "Usted no esta autorizado para Ingresar al Sistema", Mensaje.TITULO_ME, Mensaje.ERROR);
            System.exit(0);
        }

        //redimencionarBarra();
        // Validamos el formato de impresion de documento a Imprimir
        if (this.listaConfig!=null || !this.listaConfig.isEmpty()){
            this.listaConfig=PaqueteBusinessDelegate.getConfigService().listaConfig(); 
        }
        if (listaConfig.get(0).getTipoImpresion().equals(Config.TICKETERA)){
            	String numeroSerie = PaqueteBusinessDelegate.getFlujoCajaService().getNumeroSerieImpresora(this.getLocal().getInt_idLocal());
                this.strFormatoTicket = /*Util.readFile(getClass().getResource("/com/gestionmatriz/files/formato_ticketera")
                        , StandardCharsets.UTF_8)*/ strFormatoBuild();
                if (numeroSerie!=null && !numeroSerie.isEmpty()){
                    this.strFormatoTicket = this.strFormatoTicket.replace("{{N/S}}", numeroSerie);
                }
        }
    }

//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraEstado1 = new com.gestionmatriz.principal.gui.BarraEstado();
        pnlEscritorio = new Fondo();
        mnuPrincipal = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Matriz");
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().add(barraEstado1, java.awt.BorderLayout.SOUTH);
        getContentPane().add(pnlEscritorio, java.awt.BorderLayout.CENTER);
        setJMenuBar(mnuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.gestionmatriz.principal.gui.BarraEstado barraEstado1;
    private javax.swing.JMenuBar mnuPrincipal;
    private javax.swing.JDesktopPane pnlEscritorio;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        Object obj = Mensaje.confirmar(this, "Desea Cerrar el Sistema", Mensaje.TITULO_OP, Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);
        if (obj.equals(Mensaje.YES_OPTION)) {
            try {
                ConexionSql.cerrarConexionAll(ConexionSql.getConexion());
//                super.dispose();
                System.exit(0);
            } catch (SQLException ex) {
            	log.error("Error: " + ex.getMessage());
                System.exit(0);
            }
        }
    }

    public List<FuncionUsuario> getLstFuncionesUsuario() {
        return lstFuncionesUsuario;
    }

    public void setLstFuncionesUsuario(List<FuncionUsuario> lstFuncionesUsuario) {
        this.lstFuncionesUsuario = lstFuncionesUsuario;
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public Personal getObjPersonalHuella() {
        return objPersonalHuella;
    }

    public void setObjPersonalHuella(Personal objPersonalHuella) {
        this.objPersonalHuella = objPersonalHuella;
    }

    public void loadLectorHuella() {
        Util.hiloProgressBar(1, this);
        frmLectoHuella = new LectorHuella(this, farRequested.getNumber().intValue());
        Util.hiloProgressBar(0, this);
        frmLectoHuella.setVisible(true);
    }

    public void stopLectorHuella() {
        frmLectoHuella.setVisible(false);
    }
//    private void redimencionarBarra() {
//        int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
//        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
//         
//        System.out.println("ancho: "+ancho);
//        
//        barraEstado1.setSize(ancho,20);
//        
//    }

    //Envia los datos pára cargar barra
    public void setBarra(String usuario, String bd) {
        barraEstado1.setUsuario(usuario);
        barraEstado1.setBD(bd);
        barraEstado1.ventanaInicial();
    }

    public void addFrm(Component frm) {
        pnlEscritorio.add(frm);
    }

    public void enforcar(JInternalFrame frm) {
        try {
            frm.setSelected(true);
        } catch (PropertyVetoException ex) {
            log.error("Error al dar foco: " + ex.getMessage());
        }
    }

    public BarraEstado getBarraEstado() {
        return barraEstado1;
    }

    public Empresa getEmpresa() {
        return objEmpresa;
    }

    public Local getLocal() {
        return objLocal;
    }

    public List<Local> getListaLocal() {
        if (getEmpresa()!=null && (this.listaLocal==null || this.listaLocal.isEmpty())){
           listaLocal = PaqueteBusinessDelegate.getContratoService().buscarLocal(getEmpresa().getInt_idEmpresa());
        }
        return listaLocal;
    }

    public List<Config> getListaConfig() {
        return listaConfig;
    }

    public String getStrFormatoTicket() {
        return strFormatoTicket;
    }

    public void setStrFormatoTicket(String strFormatoTicket) {
        this.strFormatoTicket = strFormatoTicket;
    }
    
    private String strFormatoBuild(){
         EncriptionSource objEncriptador = new EncriptionSource();
         KeyService_I objKey_I = null;
         try {
             //Atributos para la desencriptacion
             objKey_I = PaqueteBusinessDelegate.getKeyService();
         } catch (ParserConfigurationException ex) {
             ex.printStackTrace();
         } catch (SAXException ex) {
             ex.printStackTrace();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
         byte[] llave = FunctionByte.hex2byte(objKey_I.getKey().getKey());

         return  objEncriptador.Decrypt(llave, FunctionByte.hex2byte(this.listaConfig.get(0).getStr_formatoTicket()));
    }
    
}
