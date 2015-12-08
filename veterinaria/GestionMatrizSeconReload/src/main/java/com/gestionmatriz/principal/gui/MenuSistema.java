/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.principal.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JMenu;

import org.apache.log4j.Logger;

import com.gestionmatriz.config.util.Util;
import com.gestionmatriz.puntoventa.gui.GestionTicketeras;
import com.gestionmatriz.recursoshumanos.gui.GestionConfig;
import com.gestionmatriz.reutilizable.util.Filtro;
import com.gestionmatriz.seguridad.gui.ModificarContrasenia;
import com.gestionmatriz.seguridad.opciones.Opciones;
import com.gestionmatriz.util.Mensaje;

/**
 *
 * @author zholo
 */
public class MenuSistema extends JMenu {

	 /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private static final Logger log=Logger.getLogger(MenuSistema.class);  
//    private javax.swing.JMenuBar mnuBSistema;
    //modificadop por kedwin
    private javax.swing.JMenuItem mnuICambioSesion;
    private javax.swing.JMenuItem mnuIModificarContrasenia;
    private javax.swing.JMenuItem mnuInformacion;
    private javax.swing.JMenuItem mnuISalirSistema;
    private javax.swing.JMenu mnuConfiIni; 
    private javax.swing.JMenuItem mniConfigIni;
    private javax.swing.JMenuItem mniGestionTicketeras;
    private Principal gui;
    private ModificarContrasenia frmModificarContrasenia;
    private GestionConfig frmGestionConfig;
    private GestionTicketeras frmGestionTicketeras;

//    private javax.swing.JMenu mnuSistema;
    public MenuSistema(Principal gui) {
        this.gui = gui;
        initComponents();
        setIconMenu();


    }

    private void initComponents() {

//        mnuBSistema = new javax.swing.JMenuBar();
//        mnuSistema = new javax.swing.JMenu();
        mnuIModificarContrasenia = new javax.swing.JMenuItem();
        mnuInformacion = new javax.swing.JMenuItem();
        mnuICambioSesion = new javax.swing.JMenuItem();
        mnuISalirSistema = new javax.swing.JMenuItem();
        
        mnuConfiIni=new javax.swing.JMenu();
        mniConfigIni= new javax.swing.JMenuItem();

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mnuConfiIni.setText("Configuración Inicial");
        mnuConfiIni.setForeground(new Color(127,11,30));
        mnuConfiIni.setFont(new java.awt.Font("",0,13));       
        mniConfigIni.setText("Gestión Inicial");
        mniConfigIni.setForeground(new Color(127,11,13));
        mniConfigIni.setFont(new java.awt.Font("",0,13));
        
        mniConfigIni.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniConfigIniActionPerformed(evt);
            }

           
        });
        
        mniGestionTicketeras = new javax.swing.JMenuItem();
        mniGestionTicketeras.setText("Gestión Ticketeras");
        mniGestionTicketeras.setForeground(new Color(127,11,13));
        mniGestionTicketeras.setFont(new java.awt.Font("",0,13));
        mniGestionTicketeras.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGestionTicketerasPerformed(evt);
            }           
        });
        mnuConfiIni.add(mniConfigIni);
        mnuConfiIni.add(mniGestionTicketeras);
        this.add(mnuConfiIni);      

        this.setText("Sistema");
        this.setForeground(new Color(127, 11, 30));
        this.setFont(new Font("", 1, 13));


        mnuIModificarContrasenia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        mnuIModificarContrasenia.setText("Modificar Contraseña");
        mnuIModificarContrasenia.setForeground(new Color(127, 11, 30));
        mnuIModificarContrasenia.setFont(new Font("", 0, 13));
        mnuIModificarContrasenia.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIModificarContraseñaActionPerformed(evt);
            }
        });
        this.add(mnuIModificarContrasenia);

        mnuICambioSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        mnuICambioSesion.setText("Cambio de Sesión");
        mnuICambioSesion.setForeground(new Color(127, 11, 30));
        mnuICambioSesion.setFont(new Font("", 0, 13));
        mnuICambioSesion.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuICambioSesionActionPerformed(evt);
            }
        });


        mnuInformacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mnuInformacion.setText("Información del Sistema");
        mnuInformacion.setForeground(new Color(127, 11, 30));
        mnuInformacion.setFont(new Font("", 0, 13));
        mnuInformacion.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInformacionActionPerformed(evt);
            }
        });
        this.add(mnuInformacion);


        this.add(mnuICambioSesion);

        mnuISalirSistema.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        mnuISalirSistema.setText("Salir");
        mnuISalirSistema.setForeground(new Color(127, 11, 30));
        mnuISalirSistema.setFont(new Font("", 0, 13));
        mnuISalirSistema.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuISalirSistemaActionPerformed(evt);
            }
        });
        this.add(mnuISalirSistema);

//        mnuBSistema.add(mnuSistema);

//        setJMenuBar(mnuBSistema);

////        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
////        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 643, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 343, Short.MAX_VALUE)
//        );
//
//        pack();
    }// </editor-fold>

    private void setIconMenu() {
    	mnuConfiIni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/confini.png")));
        mniGestionTicketeras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/imprimir.png")));
        mniConfigIni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
        mnuIModificarContrasenia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/cambiocontrasenia.png")));
        mnuICambioSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/cambiosesion.png")));
        mnuInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/informacion.png")));
        mnuISalirSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/salirsistema.png")));
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/mnusistema.png")));

    }

    private void mnuISalirSistemaActionPerformed(ActionEvent evt) {
        gui.dispose();
    }

    private void mnuICambioSesionActionPerformed(ActionEvent evt) {
        int objRespuesta = Mensaje.confirmar(gui, "Desea Cambiar de Usuario o Reiniciar su Sesión ? ", Mensaje.TITULO_OP, Mensaje.YES_NO_OPTION, Mensaje.PREGUNTA);
        if (objRespuesta == Mensaje.YES_OPTION) {
            try {
                Process p = Runtime.getRuntime().exec(System.getProperty("user.dir") + File.separator + Util.getEXEWINDOWS());
            } catch (IOException ex) {
            	log.error("Error: " + ex.getMessage());
            }
            gui.dispose();
        }
    }

    private void mnuIModificarContraseñaActionPerformed(ActionEvent evt) {
        com.gestionmatriz.util.Util.hiloProgressBar(1, gui);

        frmModificarContrasenia = new ModificarContrasenia(gui, 1);
        frmModificarContrasenia.setLocationRelativeTo(null);
        frmModificarContrasenia.setSize(383, 211);
        frmModificarContrasenia.setVisible(true);

        com.gestionmatriz.util.Util.hiloProgressBar(0, gui);
    }

    private void mnuInformacionActionPerformed(ActionEvent evt) {
        com.gestionmatriz.util.Util.hiloProgressBar(1, gui);
        Informacion frmInformacion = new Informacion(gui);
        com.gestionmatriz.util.Util.hiloProgressBar(0, gui);
        frmInformacion.setVisible(true);
    }
    
    private void mniConfigIniActionPerformed(ActionEvent evt) {
        com.gestionmatriz.util.Util.hiloProgressBar(1, gui);
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getCONFIGURACIONINICIAL())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            com.gestionmatriz.util.Util.hiloProgressBar(0, gui);     
            return;
        }
        
       if (frmGestionConfig == null || frmGestionConfig.isClosed()) {
           frmGestionConfig = new GestionConfig(gui);
           frmGestionConfig.setVisible(true);
           gui.addFrm(frmGestionConfig);
           gui.enforcar(frmGestionConfig);
           gui.getBarraEstado().nuevaVentanas();
           com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmGestionConfig);
       }
       com.gestionmatriz.util.Util.hiloProgressBar(0, gui);     
    }
    
     private void mniGestionTicketerasPerformed(ActionEvent evt) {
        com.gestionmatriz.util.Util.hiloProgressBar(1, gui);
        if (!Filtro.opcionPermitida(gui.getLstFuncionesUsuario(), Opciones.getGESTIONIMPRESORAS())) {
            Mensaje.mensaje(this, "Opción no autorizada para su Usuario", Mensaje.TITULO_ME, Mensaje.ERROR);
            com.gestionmatriz.util.Util.hiloProgressBar(0, gui);     
            return;
        }  
        
        if (frmGestionTicketeras == null || frmGestionTicketeras.isClosed()){
           frmGestionTicketeras = new GestionTicketeras(gui);
           frmGestionTicketeras.setVisible(true);
           gui.addFrm(frmGestionTicketeras);
           gui.enforcar(frmGestionTicketeras);
           gui.getBarraEstado().nuevaVentanas();
           com.gestionmatriz.util.Util.setCentrarJInternalFrame(frmGestionTicketeras);
        }
        com.gestionmatriz.util.Util.hiloProgressBar(0, gui);     
    }
}
