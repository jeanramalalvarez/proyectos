/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.util;

import com.gestionmatriz.puntoventa.bean.ImprimirVenta;
import com.gestionmatriz.recursoshumanos.bean.Empresa;
import com.gestionmatriz.recursoshumanos.bean.Local;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;


/**
 *
 * @author jarcon
 */
public class Impresora {
    
//    static PrintJob pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "Imprimir", null);
//    static Graphics pg;
//    
	private static final Logger log=Logger.getLogger(Impresora.class);
    private static  NumeroLetras numLetras= new NumeroLetras();
    
    public static void imprimirFactura(String []cabecera, String [][] prod, int sizeProd,String []totales){
        
        Properties props=new Properties();
        
        PrintJob pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "Imprimir",props);
        Graphics pg;
        
          
        try {
            pg = pj.getGraphics();
            
            pg.setFont(new Font (Font.SANS_SERIF,Font.PLAIN,9));
            
            int ypos=175;
            //señores---direccion---fecha---ruc---nroPedido---vendedor---guia---condiPago
            pg.drawString(cabecera[0], 90, 97);
            pg.drawString(cabecera[1], 90, 111);
            pg.drawString(cabecera[2], 295, 110);
            pg.drawString(cabecera[3], 90, 125);
            pg.drawString(cabecera[4], 300, 125);
            pg.drawString(cabecera[5], 90, 137);
            pg.drawString(cabecera[6], 290, 137);
            pg.drawString(cabecera[7], 410, 137);
            
           //codigo---cantidad---Descripcion---p. unit---total
            for (int i = 0; i < sizeProd; i++) {

                    pg.drawString(prod[i][0],45,ypos);//87
                    log.info(prod[i][0]);
                    pg.drawString(prod[i][1],108,ypos);//155
                    log.info(prod[i][1]);
                    pg.drawString(prod[i][2],160,ypos);//200
                    log.info(prod[i][2]);
                    pg.drawString(prod[i][3],480,ypos);//520
                        log.info(prod[i][3]);
                    pg.drawString(prod[i][4],560,ypos);//630                     
                        log.info(prod[i][4]);
                        log.info("--------------------------------------------");

                ypos+=10;
            } 
            
            //Precio en letras
            String total=totales[6];
            String Final=total.replace(".", ",");
            pg.drawString(numLetras.convertirLetrasFactura(Final), 100, 340);
            
            //Total bruto---descuento---redondeo_descuento---valorVenta---Exonerado---I.G.V.---Total
            pg.drawString(totales[0], 50, 370);
            pg.drawString(totales[1], 120, 370);
            pg.drawString(totales[2], 205, 370);
            pg.drawString(totales[3], 280, 370);
            pg.drawString(totales[4], 370, 370);
            pg.drawString(totales[5], 445, 370);
            pg.drawString(totales[6], 540, 370);
            
            pg.dispose();
            pj.end();
            
        } catch (Exception e) {
            log.info("LA IMPRESION HA SIDO CANCELADA...:"+e.getMessage()); 
        }
    }
    
    
    public static void imprimirBoleta(String [] Fila1, String [] Fila2,String [][] prod, int sizeProd,String [] totales){
        Properties props=new Properties();  
        
        PrintJob pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "Imprimir",props);
          
          Graphics pg;
        try {
            pg = pj.getGraphics();
            
            pg.setFont(new Font (Font.SANS_SERIF,Font.PLAIN,8));
            int ypos = 135;
              log.info("Imprimiendo...");     
            //Señores ---vendedor---fecha
            pg.drawString(Fila1[0],140,90);
            pg.drawString(Fila1[1],382,90);
            pg.drawString(Fila1[2],470,90);
            
            //direccion---dni
            pg.drawString(Fila2[0],140,104);
            pg.drawString(Fila2[1],382,104);           
            
            //codigo---cantidad---unidad---producto---total
            for (int i = 0; i < sizeProd; i++) {
//                for (int j = 0; j < 5; j++) {
                    pg.drawString(prod[i][0],87,ypos);
                        log.info(prod[i][0]);
                    pg.drawString(prod[i][1],130,ypos);
                        log.info(prod[i][1]);
                    pg.drawString(prod[i][2],175,ypos);
                        log.info(prod[i][2]);
                    pg.drawString(prod[i][3],225,ypos);
                        log.info(prod[i][3]);
                    pg.drawString(prod[i][4],475,ypos);                     
                        log.info(prod[i][4]);
                        log.info("--------------------------------------------");
//                }
                ypos+=10;
            }           
            
            
            //numero en letras
            String total=totales[2];
            String Final=total.replace(".", ",");
            pg.drawString(numLetras.convertirLetras(Final), 225, 235);
            
            //subtotal---descuento---igv--total
            pg.drawString(totales[0], 475, 249);
            pg.drawString(totales[1], 475, 261);
            pg.drawString(totales[2], 475, 274);          
            pg.drawString(totales[3], 475, 287); 
            
            
            pg.dispose();
            pj.end();
            
        } catch (Exception e) {
            log.info("LA IMPRESION HA SIDO CANCELADA...:"+e.getMessage()); 
        }
        
    }
    
    
    public void imprimirGuiaRemision(String []fechas,String []domicilioPartLlega,String []destinatario,
            String []vehiculo,String [][]prod,String []trasnportista,String []Comprobante,String motivo){
        
         Properties props=new Properties();  
        
            PrintJob pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "Imprimir",props);
          
          Graphics pg;
    
          
          try {
            pg = pj.getGraphics();
            
            pg.setFont(new Font (Font.SANS_SERIF,Font.PLAIN,8));
//            int ypos = 135;
              log.info("Imprimiendo...");     
            //Señores ---vendedor---fecha
//            pg.drawString(Fila1[0],140,90);
//            pg.drawString(Fila1[1],382,90);
//            pg.drawString(Fila1[2],470,90);
//            
//            //direccion---dni
//            pg.drawString(Fila2[0],140,104);
//            pg.drawString(Fila2[1],382,104);           
//            
//            //codigo---cantidad---unidad---producto---total
//            for (int i = 0; i < sizeProd; i++) {
////                for (int j = 0; j < 5; j++) {
//                    pg.drawString(prod[i][0],87,ypos);
//                        log.info(prod[i][0]);
//                    pg.drawString(prod[i][1],130,ypos);
//                        log.info(prod[i][1]);
//                    pg.drawString(prod[i][2],175,ypos);
//                        log.info(prod[i][2]);
//                    pg.drawString(prod[i][3],225,ypos);
//                        log.info(prod[i][3]);
//                    pg.drawString(prod[i][4],475,ypos);                     
//                        log.info(prod[i][4]);
//                        log.info("--------------------------------------------");
////                }
//                ypos+=10;
//            }           
//            
//            
//            //numero en letras
//            String total=totales[2];
//            String Final=total.replace(".", ",");
//            pg.drawString(numLetras.convertirLetras(Final), 225, 235);
//            
//            //subtotal---descuento---total
//            pg.drawString(totales[0], 475, 249);
//            pg.drawString(totales[1], 475, 261);
//            pg.drawString(totales[2], 475, 274);          
//            
//            
//            pg.dispose();
//            pj.end();
//            
        } catch (Exception e) {
            log.info("LA IMPRESION HA SIDO CANCELADA...:"+e.getMessage()); 
        }
        
    }
    
    /**
     * 
     */
    public  void imprimirBoletaTicket(ImprimirVenta imprimirVenta,List<ImprimirVenta> listaImprimir, String documento,Empresa empresa, Local local,String strPrint){
        strPrint = strPrint.replace("{{EMPRESA_NOMBRE}}", empresa.getStr_razonSocial());
        strPrint = strPrint.replace("{{NUMERO_RUC}}", empresa.getStr_ruc());
        strPrint = strPrint.replace("{{DIRECCION_SUNAT}}", empresa.getStr_domicilioEmpresa());
        strPrint = strPrint.replace("{{DIRECCION_LOCAL}}", local.getStr_direccion());
        strPrint = strPrint.replace("{{TIPO_COMPROBANTE}}", "BOLETA");
        strPrint = strPrint.replace("{{NUM_COMPROBANTE}}", documento);
        strPrint = strPrint.replace("{{FECHA_EMISION}}",listaImprimir.get(0).getFch_fecha());
        StringBuilder productos = new StringBuilder();
        for (ImprimirVenta iv:listaImprimir){
            productos.append( String.format("%-10s%-13s%-30s %-6s%-6s%-6s%8s", iv.getStr_codigo(),iv.getStr_unidadMedida(),
                    iv.getStr_producto().length()>30?iv.getStr_producto().substring(0,30):iv.getStr_producto(),
            iv.getDbl_cantidad(),iv.getDbl_precioUnit(),iv.getDbl_descuento(),iv.getDbl_subTotal()));
            if (!listaImprimir.get(listaImprimir.size()-1).equals(iv)){
                productos.append("\n");
            }
        }
        strPrint = strPrint.replace("{{ITEMS}}",productos);
        strPrint = strPrint.replace("{{TOTAL}}", String.format("%-25s%-4s%10s", "TOTAL A PAGAR:","S/.",(Util.redondeo(listaImprimir.get(0).getDbl_sumaTotal(), 2))))  ;
        strPrint = strPrint.replace("{{SUB_TOTAL}}",String.format("%-25s%-4s%10s","OP. GRAVADAS:","S/.",(Util.redondeo(listaImprimir.get(0).getDbl_sumaSubTotal(),2))));
        strPrint = strPrint.replace("{{DESC}}",String.format("%-25s%-4s%10s","DESC:","S/.",(Util.redondeo(listaImprimir.get(0).getDbl_sumaDescuento(),2))));
        strPrint = strPrint.replace("{{IGV}}",String.format("%-25s%-4s%10s","IGV-18%:","S/.",(Util.redondeo(listaImprimir.get(0).getDbl_sumaIGV(),2))));
        strPrint = strPrint.replace("{{MONTO_LETRAS}}",numLetras.convertirLetras((Util.redondeo(listaImprimir.get(0).getDbl_sumaTotal(),2)).replace(".", ",")));
        strPrint = strPrint.replace("{{EFECTIVO}}",String.format("%-25s%-4s%10s","EFECTIVO SOLES:","S/.",(Util.redondeo(imprimirVenta.getDbl_efectivo(),2))));
        strPrint = strPrint.replace("{{VUELTO}}",String.format("%-25s%-4s%10s","VUELTO:","S/.",(Util.redondeo(imprimirVenta.getDbl_vuelto(),2))));
         strPrint = strPrint.replace("{{FACTURA}}","");
        new Ticket(strPrint).print();
    }
    
    public  void imprimirFacturaTicket(ImprimirVenta imprimirVenta,List<ImprimirVenta> listaImprimir, String documento,Empresa empresa, Local local,String strPrint){
        strPrint = strPrint.replace("{{EMPRESA_NOMBRE}}", empresa.getStr_razonSocial());
        strPrint = strPrint.replace("{{NUMERO_RUC}}", empresa.getStr_ruc());
        strPrint = strPrint.replace("{{DIRECCION_SUNAT}}", empresa.getStr_domicilioEmpresa());
        strPrint = strPrint.replace("{{DIRECCION_LOCAL}}", local.getStr_direccion());
        strPrint = strPrint.replace("{{TIPO_COMPROBANTE}}", "FACTURA");
        strPrint = strPrint.replace("{{NUM_COMPROBANTE}}", documento);
        strPrint = strPrint.replace("{{FECHA_EMISION}}",listaImprimir.get(0).getFch_fecha());
        StringBuilder productos = new StringBuilder();
        for (ImprimirVenta iv:listaImprimir){
            productos.append( String.format("%-10s%-13s%-30s%-6s%-6s%-6s%8s", iv.getStr_codigo(),iv.getStr_unidadMedida(),
                    iv.getStr_producto().length()>30?iv.getStr_producto().substring(0,30):iv.getStr_producto(),
            iv.getDbl_cantidad(),iv.getDbl_precioUnit(),iv.getDbl_descuento(),iv.getDbl_subTotal()));
            if (!listaImprimir.get(listaImprimir.size()-1).equals(iv)){
                productos.append("\n");
            }
        }
          strPrint = strPrint.replace("{{ITEMS}}",productos);
        strPrint = strPrint.replace("{{TOTAL}}", String.format("%-25s%-4s%10s", "TOTAL A PAGAR:","S/.",(Util.redondeo(listaImprimir.get(0).getDbl_sumaTotal(), 2))))  ;
        strPrint = strPrint.replace("{{SUB_TOTAL}}",String.format("%-25s%-4s%10s","OP. GRAVADAS:","S/.",(Util.redondeo(listaImprimir.get(0).getDbl_sumaSubTotal(),2))));
        strPrint = strPrint.replace("{{DESC}}",String.format("%-25s%-4s%10s","DESC:","S/.",(Util.redondeo(listaImprimir.get(0).getDbl_sumaDescuento(),2))));
        strPrint = strPrint.replace("{{IGV}}",String.format("%-25s%-4s%10s","IGV-18%:","S/.",(Util.redondeo(listaImprimir.get(0).getDbl_sumaIGV(),2))));
        strPrint = strPrint.replace("{{MONTO_LETRAS}}",numLetras.convertirLetras((Util.redondeo(listaImprimir.get(0).getDbl_sumaTotal(),2)).replace(".", ",")));
        strPrint = strPrint.replace("{{EFECTIVO}}",String.format("%-25s%-4s%10s","EFECTIVO SOLES:","S/.",(Util.redondeo(imprimirVenta.getDbl_efectivo(),2))));
        strPrint = strPrint.replace("{{VUELTO}}",String.format("%-25s%-4s%10s","VUELTO:","S/.",(Util.redondeo(imprimirVenta.getDbl_vuelto(),2))));
        strPrint = strPrint.replace("{{FACTURA}}", "\n----------------------------------------".
                concat("\nEmpresa: "+listaImprimir.get(0).getStr_rasonSocial()).
                concat("\nRUC    : "+listaImprimir.get(0).getStr_ruc()).
                concat("\nDirecc. : "+listaImprimir.get(0).getStr_direccion()).
                concat("\n----------------------------------------"));
        new Ticket(strPrint).print();
    }
    
    public class Ticket{
         //Ticket attribute content
        private String contentTicket ;

        //El constructor que setea los valores a la instancia
        Ticket(String contentTicket) {
          this.contentTicket = contentTicket;
        }

        public void print() {
          //Especificamos el tipo de dato a imprimir
          //Tipo: bytes; Subtipo: autodetectado
          DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

          //Aca obtenemos el servicio de impresion por defatul
          //Si no quieres ver el dialogo de seleccionar impresora usa esto
//          PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();


          //Con esto mostramos el dialogo para seleccionar impresora
          //Si quieres ver el dialogo de seleccionar impresora usalo
          //Solo mostrara las impresoras que soporte arreglo de bits
          PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
          PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
          PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
          PrintService service = ServiceUI.printDialog(null, 700, 200, printService, defaultService, flavor, pras);

          //Creamos un arreglo de tipo byte
          byte[] bytes;

          //Aca convertimos el string(cuerpo del ticket) a bytes tal como
          //lo maneja la impresora(mas bien ticketera :p)
          bytes = this.contentTicket.getBytes();

          //Creamos un documento a imprimir, a el se le appendeara
          //el arreglo de bytes
          Doc doc = new SimpleDoc(bytes,flavor,null);

          //Creamos un trabajo de impresiÃ³n
          DocPrintJob job = service.createPrintJob();

          //Imprimimos dentro de un try de a huevo
          try {
            //El metodo print imprime
            job.print(doc, null);
          } catch (Exception er) {
            JOptionPane.showMessageDialog(null,"Error al imprimir: " + er.getMessage());
          }
        }
    }
}