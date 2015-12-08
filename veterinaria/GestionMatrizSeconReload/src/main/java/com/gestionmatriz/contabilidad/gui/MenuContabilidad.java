/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.contabilidad.gui;

//import com.gestionmatriz.principal.gui.Principal;
//import com.gestionmatriz.util.Util;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
import javax.swing.JMenu;

/**
 *
 * @author cesareo
 */
public class MenuContabilidad extends JMenu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//    
//    private Principal gui;
//    private javax.swing.JMenuItem mniPlanContable;
//    private GestionPlanContable frmGestionPlanContable;
//    
//    public MenuContabilidad(Principal gui) {
//        this.gui = gui;
//        this.setText("CONTABILIDAD");
//        this.setForeground(new Color(127, 11, 30));
//        this.setFont(new java.awt.Font("", 1, 13));
//        this.setVisible(true);
//        
//        mniPlanContable = new javax.swing.JMenuItem();
//        mniPlanContable.setText("Plan Contable");
//        mniPlanContable.setForeground(new Color(127, 11, 30));
//        mniPlanContable.setFont(new java.awt.Font("", 0, 13));
//        mniPlanContable.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                mniPlanContableActionPerformed(evt);
//            }
//        });
//        this.add(mniPlanContable);
//        
//        MenuImageIcon();
//    }
//    
//    private void MenuImageIcon() {
//        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/contabilidad.png")));
//        mniPlanContable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/generico.png")));
//    }
//    
//    private void mniPlanContableActionPerformed(ActionEvent evt) {
//        Util.hiloProgressBar(1, gui);
//        if (frmGestionPlanContable == null || frmGestionPlanContable.isClosed()) {
//            frmGestionPlanContable = new GestionPlanContable(gui);
//            frmGestionPlanContable.setVisible(true);
//            gui.addFrm(frmGestionPlanContable);
//            gui.enforcar(frmGestionPlanContable);
//            gui.getBarraEstado().nuevaVentanas();
//            Util.setCentrarJInternalFrame(frmGestionPlanContable);
//        }
//        Util.hiloProgressBar(0, gui);
//    }
}
