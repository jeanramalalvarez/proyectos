package com.gestionmatriz.principal.gui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class Fondo extends JDesktopPane {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// private Image imagen;
//
//public void Fondo(String nombreImagen){
//   
//        imagen= new ImageIcon(getClass().getResource(nombreImagen)).getImage();    
//  
//}
//public void setImage(String nombreImagen){
////   if (nombreImagen !=null){
//       imagen=new ImageIcon(getClass().getResource(nombreImagen)).getImage();
////   }else{
////       imagen=null;
////   }
////   repaint();
//}
//    @Override
// public void paint(Graphics g){
// if(imagen !=null){
//     g.drawImage(imagen, 0, 0,getWidth(),getHeight(), this);
//     setOpaque(false);
// }else {
//     setOpaque(false);
// }
// super.paint(g);
// }
 private Image imagen;

    public Fondo() {
    }

//    public Fondo(String nombreImagen) {
//        if (nombreImagen != null) {
//            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
//        }
//    }
//
//    public Fondo(Image imagenInicial) {
//        if (imagenInicial != null) {
//            imagen = imagenInicial;
//        }
//    }

    public void setImagen(String nombreImagen) {
        if (nombreImagen != null) {
            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
        } else {
            imagen = null;
        }

        repaint();
    }

    public void setImagen(Image nuevaImagen) {
        imagen = nuevaImagen;

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
        } else{
            setOpaque(true);
        }

        super.paint(g);
    }
}
