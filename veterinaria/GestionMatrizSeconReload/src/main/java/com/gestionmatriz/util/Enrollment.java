package com.gestionmatriz.util;

import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.ui.swing.*;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Enrollment control test 
 */
public class Enrollment
	extends JDialog
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EnumMap<DPFPFingerIndex, DPFPTemplate> templates;
    
    
    
    //private int farAchieved;
//    private DPFPVerificationControl verificationControl;
//    private boolean matched;
    
//    static final String FAR_PROPERTY = "FAR";
//    static final String MATCHED_PROPERTY = "Matched";
    
    public Enrollment(Frame owner, int maxCount, EnumMap<DPFPFingerIndex, DPFPTemplate> templates) {
        super (owner, true);
        this.templates = templates;

        setTitle("Fingerprint Enrollment");

        DPFPEnrollmentControl enrollmentControl = new DPFPEnrollmentControl();

        EnumSet<DPFPFingerIndex> fingers = EnumSet.noneOf(DPFPFingerIndex.class);
        fingers.addAll(templates.keySet());
        enrollmentControl.setEnrolledFingers(fingers);
        enrollmentControl.setMaxEnrollFingerCount(maxCount);

        enrollmentControl.addEnrollmentListener(new DPFPEnrollmentListener()
        {
            public void fingerDeleted(DPFPEnrollmentEvent e) throws DPFPEnrollmentVetoException {
               
                    Enrollment.this.templates.remove(e.getFingerIndex());
               
            }

            public void fingerEnrolled(DPFPEnrollmentEvent e) throws DPFPEnrollmentVetoException {
               
                    Enrollment.this.templates.put(e.getFingerIndex(), e.getTemplate());
            }
        });

		getContentPane().setLayout(new BorderLayout());

		JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);                //End Dialog
            }
        });

		JPanel bottom = new JPanel();
		bottom.add(closeButton);
		add(enrollmentControl, BorderLayout.CENTER);
		add(bottom, BorderLayout.PAGE_END);

		pack();
        setLocationRelativeTo(null);             
   }
    
    

    public EnumMap<DPFPFingerIndex, DPFPTemplate> getTemplates(){
        return this.templates;
    }
    
    
    
}