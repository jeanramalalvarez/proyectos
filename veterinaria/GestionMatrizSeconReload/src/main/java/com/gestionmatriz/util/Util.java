/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import com.gestionmatriz.config.bean.Otros;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.principal.gui.Principal;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author YESM
 */
public class Util {

	private static final Logger log=Logger.getLogger(Util.class);
    public final static String ACTIVO = "ACTIVO";
    public final static String INACTIVO = "INACTIVO";
    public final static String HISTORICO = "HISTORICO";
    public final static String APROBADO = "APROBADO";
    public final static String DESAPROBADO = "DESAPROBADO";
    public final static String CUMPLIDOS = "CUMPLIDO";
    public final static String ELIMINADO    = "ELIMINADO";
    public final static String ASIGNADO     = "ASIGNADO";
    public final static String LUNES = "LUNES";
    public final static String MARTES = "MARTES";
    public final static String MIERCOLES = "MIERCOLES";
    public final static String JUEVES = "JUEVES";
    public final static String VIERNES = "VIERNES";
    public final static String SABADO = "SABADO";
    public final static String DOMINGO = "DOMINGO";
    public final static String LETRAS = "LETRAS";
    public final static String SOLES = "SOLES";
    public final static String DOLARES = "DOLARES";
    public final static String PENDIENTE = "PENDIENTE";
    public final static String CERRADO = "CERRADO";
    public final static String AUTORIZADO = "AUTORIZADO";
    public final static String CONFIRMADO = "CONFIRMADO";
    public final static String MENOR = "MENOR";
    public final static String MEDIA = "MEDIA";
    public final static String MAYOR = "MAYOR";
    public final static String SINPAGO = "SINPAGO";
    public final static String PAGADO = "PAGADO";
    public final static String ANULADO = "ANULADO";
    public final static String APERTURACAJA = "APERTURACAJA";
    public final static String VENTACAJA = "VENTACAJA";
    public final static String CIERRECAJA = "CIERRECAJA";
    public final static String TEMP = "TEMP-";
    public final static String PROFO = "PROFO-";
    public final static String BOLETA = "B";
    public final static String FACTURA = "F";
    public final static String AFP = "AFP";
    public final static String ONP = "ONP";
    public final static int INGRESOXCOMPRA = 1;
    public final static int SALIDAXVENTA = 2;
    public final static int INGRESOXTRASLADO = 3;
    public final static int SALIDAXTRASLADO = 4;
    public final static int INGRESOXDEVOLUCION = 5;
    public final static int idLocalAG = 4;
    public final static int CODIGO_FACTURA = 2;
    public final static int CODIGO_BOLETA = 1;
    public static Runnable ra;
    public static Thread th;
    public static Otros objOtros = PaqueteBusinessDelegate.getOtrosService().getOtros();

    public static void hiloProgressBar(int i, Principal gui) {
        ra = gui.getBarraEstado();
        th = new Thread(ra);

        if (i == 1) {
            th.start();
            gui.getBarraEstado().setPunteroBarra(-1);
        } else if (i == 0) {
            gui.getBarraEstado().setPunteroBarra(1);
            th.interrupt();
        }
    }

    public static Date StringTODate(String fecha) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dFecha = sdf.parse(fecha);
            return dFecha;
        } catch (ParseException ex) {
            log.error("Error: " + ex.getMessage());
        }
        return null;
    }

    public static Date StringTODateEspecial(String fecha) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date dFecha = sdf.parse(fecha);
            return dFecha;
        } catch (ParseException ex) {
            log.error("Error: " + ex.getMessage());
        }
        return null;
    }

    public static Date StringTODateLong(String fecha) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date dFecha = sdf.parse(fecha);
            return dFecha;
        } catch (ParseException ex) {
            log.error("Error: " + ex.getMessage());
        }
        return null;
    }

    public static Date StringTODateTime(String fecha) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            java.util.Date dFecha = sdf.parse(fecha);
            return dFecha;
        } catch (ParseException ex) {
            log.error("Error: " + ex.getMessage());
        }
        return null;
    }

    public static String StringTODateTime(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        return sdf.format(fecha);
    }

    public static String StringToDateTimeAdd(Date fecha, int minutos) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//        System.out.println(sdf.format(gc.getTime()));  

        gc.add(Calendar.MINUTE, minutos);
//        System.out.println(sdf.format(gc.getTime()));  
        return sdf.format(gc.getTime());
    }

    public static long StringToDateTimeAddLong(Date fecha, int minutos) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);

//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
        //        System.out.println(sdf.format(gc.getTime()));  

        gc.add(Calendar.MINUTE, minutos);
        //        System.out.println(sdf.format(gc.getTime()));  
        //        return sdf.format(gc.getTime());
        return gc.getTimeInMillis();
    }

    public static String getFecha(String formato, Date fecha) {
        String str_fecha = "";
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        //Calendar cal = Calendar.getInstance(); // hoy
        str_fecha = sdf.format(fecha.getTime());

        return str_fecha;
    }

    public static Date fechaString(String fecha) {
        Date f = new Date();
        return f;
    }

    public static Icon reducirFoto(ImageIcon foto, int width, int height) {
        Icon fotoIcono = new ImageIcon(foto.getImage().getScaledInstance(width,
                height,
                Image.SCALE_DEFAULT));

        return fotoIcono;
    }

    public static Image ConvertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);
    }

    public static int stringTOint(String numero) {
        return Integer.parseInt(numero);
    }

    public static BigDecimal stringTOBigDecimal(String numero) {
        return new BigDecimal(numero);
    }

    public static void setCentrarJInternalFrame(JInternalFrame jifrm) {
        jifrm.setLocation(jifrm.getParent().getWidth() / 2 - jifrm.getWidth() / 2,
                jifrm.getParent().getHeight() / 2 - jifrm.getHeight() / 2 - 20);
    }

    public static void maximizarInternal(JInternalFrame jif) {
        try {
            jif.setMaximum(true);
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
    }

    public static int numeroDia(Date fecha) {
        Calendar objCalendario = new GregorianCalendar();
        objCalendario.setTime(fecha);

        return objCalendario.get(Calendar.DATE);
    }

    public static int diaSemana(Date fecha) {
        Calendar objCalendario = new GregorianCalendar();
        objCalendario.setTime(fecha);

        return objCalendario.get(Calendar.DAY_OF_WEEK);
    }

    public static int numeroMes(Date fecha) {

        Calendar objCalendario = new GregorianCalendar();
        objCalendario.setTime(fecha);

        return objCalendario.get(Calendar.MONTH);
    }

    public static int numeroAnio(Date fecha) {
        Calendar objCalendario = new GregorianCalendar();
        objCalendario.setTime(fecha);

        return objCalendario.get(Calendar.YEAR);
    }

    public static long diaEntreFechas(Date fecha1, Date fecha2) {
        Calendar objCalendario1 = new GregorianCalendar();
        objCalendario1.setTime(fecha1);

        Calendar objCalendario2 = new GregorianCalendar();
        objCalendario2.setTime(fecha2);
        long milldias = objCalendario2.getTimeInMillis() - objCalendario1.getTimeInMillis();

        long dias = milldias / (1000 * 60 * 60 * 24);

        return dias;
    }

    public static String getNombreDia(int dia) {
//         System.out.println("Dia: "+dia);
        switch (dia) {
            case 1:
                return LUNES;
            case 2:
                return MARTES;
            case 3:
                return MIERCOLES;
            case 4:
                return JUEVES;
            case 5:
                return VIERNES;
            case 6:
                return SABADO;
            case 7:
                return DOMINGO;
        }
        return null;
    }

    public static void focusText(java.awt.event.KeyEvent evt,
            Component objCom) {
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_ENTER || c == KeyEvent.VK_TAB || c == KeyEvent.VK_KP_DOWN) {
            objCom.requestFocus();
        }
    }

    public static void setColorSeleccion(JComponent obj) {
        obj.setBackground(new Color(255, 252, 211));
    }

    public static void limpiarTablas(DefaultTableModel modelo) {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public static String redondeo(BigDecimal valor, int numeroDecimales) {
        String val = valor + "";
        BigDecimal big = new BigDecimal(val);
        big = big.setScale(numeroDecimales, RoundingMode.HALF_UP);
        return String.valueOf(big);
    }

    public static void imprimirTxtArea(Principal gui, JTextArea txtS) {
        Properties defaultProps = new Properties();

        PrintJob print = Toolkit.getDefaultToolkit().getPrintJob(gui, "Venta", defaultProps);
        Graphics g = print.getGraphics();

        if (g != null) {
            g.translate(15, 50);
            txtS.printAll(g); // AreaPrograma es JTextArea
        }
        g.dispose();
        print.end();
    }

    public static String arreglarCadena(String cadena) {
        if (cadena.length() <= 31) {
            return cadena;
        } else {
            return cadena.substring(0, 31);
        }
    }
    
    public static String readFile(URL url, Charset encoding)throws IOException, URISyntaxException {
        byte[] encoded = Files.readAllBytes(Paths.get(url.toURI()));
        return new String(encoded, encoding);
    }
    
}
