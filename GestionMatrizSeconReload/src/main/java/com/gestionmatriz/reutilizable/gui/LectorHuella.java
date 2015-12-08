/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LectorHuella.java
 *
 * Created on 07-may-2012, 9:27:55
 */
package com.gestionmatriz.reutilizable.gui;

import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.ui.swing.DPFPVerificationControl;
import com.digitalpersona.onetouch.ui.swing.DPFPVerificationEvent;
import com.digitalpersona.onetouch.ui.swing.DPFPVerificationListener;
import com.digitalpersona.onetouch.ui.swing.DPFPVerificationVetoException;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;

import com.gestionmatriz.recursoshumanos.bean.Personal;
import javax.swing.JDialog;

/**
 *
 * @author YESM
 */
public class LectorHuella extends JDialog {
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//    private EnumMap<DPFPFingerIndex, DPFPTemplate> templates;
    private int farRequested;
    private int farAchieved;
    private DPFPVerificationControl verificationControl;
    private boolean matched;
    
    public static final String FAR_PROPERTY = "FAR";
    public static final String MATCHED_PROPERTY = "Matched";
    
    
    private Personal objPersona;
    private Principal gui;
//    private com.gestionmatriz.recursoshumanos.gui.Asistencia frmAsistenciaPermiso;
    /** Creates new form LectorHuella */
    public LectorHuella(Principal owner,int farRequested  ) {
        super(owner,true);
        
//        this.frmAsistenciaPermiso=frmAsistencia;
        
        this.gui=owner;
        initComponents();
        
        
        this.farRequested = farRequested;

		setTitle("Fingerprint Verification");
                setResizable(false);    	

		verificationControl = new DPFPVerificationControl();
		verificationControl.addVerificationListener(new DPFPVerificationListener()
		{
			public void captureCompleted(DPFPVerificationEvent e) throws DPFPVerificationVetoException
			{
                           DPFPFeatureSet fs=e.getFeatureSet();
//                            System.out.println("Paso dedo");
                            
//				final DPFPVerification verification = 
//					DPFPGlobal.getVerificationFactory().createVerification(Marcado.this.farRequested);
				e.setStopCapture(false);	// we want to continue capture until the dialog is closed
//				int bestFAR = DPFPVerification.PROBABILITY_ONE;
//				boolean hasMatch = false;
//				for (DPFPTemplate template : Marcado.this.templates.values()) {
//					final DPFPVerificationResult result = verification.verify(e.getFeatureSet(), template);
//					e.setMatched(result.isVerified());		// report matching status
//					bestFAR = Math.min(bestFAR, result.getFalseAcceptRate());
//					if (e.getMatched()) {
//						hasMatch = true;
//						break;
//					}
//				}
                                
//                                com.gestionmatriz.recursoshumanos.bean.Personal objPersonal=
//                                        PaqueteBusinessDelegate.getAsistenciaService().registrarAsistencia(e);
                               objPersona=PaqueteBusinessDelegate.getPersonalService().consultaPersonaPorHuella(e);
//                             frmAsistenciaPermiso.setObjPersona(objPersona);
                               gui.setObjPersonalHuella(objPersona);
                               if (objPersona!=null){
                                  gui.stopLectorHuella();
                               }
                               
                               
			}
		});
                pack();
       
                
        setLocationRelativeTo(null);      
        
    }

   
    
    public Personal getObjPersona() {
        return objPersona;
    }

    public void setObjPersona(Personal objPersona) {
        this.objPersona = objPersona;
    }
    
    
    
     public int getFAR() {
    	return farAchieved;
    }
    
    protected void setFAR(int far) {
		final int old = getFAR();
		farAchieved = far;
		firePropertyChange(FAR_PROPERTY, old, getFAR());
    }

    public boolean getMatched() {
    	return matched;
    }
    
    protected void setMatched(boolean matched) {
		final boolean old = getMatched();
		this.matched = matched;
   		firePropertyChange(MATCHED_PROPERTY, old, getMatched());
     }
    
    /**
     * Shows or hides this component depending on the value of parameter
     * <code>b</code>.
     *
     * @param b if <code>true</code>, shows this component;
     *          otherwise, hides this component
     * @see #isVisible
     * @since JDK1.1
     */
    public void setVisible(boolean b) {
        if (b) {
            matched = false;
            verificationControl.start();
        } else {
            if (!matched)
                verificationControl.stop();
        }
        super.setVisible(b);
    }
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblHuella = new org.jdesktop.swingx.JXLabel();

        setBackground(java.awt.Color.white);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblHuella.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lblHuella.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHuella.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestionmatriz/icon/gif_lectorHuella.gif"))); // NOI18N
        lblHuella.setToolTipText("Coloque su dedo en el lector para identificarlo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
        getContentPane().add(lblHuella, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel lblHuella;
    // End of variables declaration//GEN-END:variables



}
