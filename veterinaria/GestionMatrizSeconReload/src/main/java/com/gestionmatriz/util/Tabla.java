/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.util;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXTable;

import com.gestionmatriz.puntoventa.bean.ConsultaStock;
import com.gestionmatriz.puntoventa.bean.Proforma;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.puntoventa.bean.VentasProforma;

/**
 *
 * @author YTORRES
 */
public class Tabla extends JXTable{
     
	private static final Logger log=Logger.getLogger(Tabla.class);
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> codigo=new ArrayList<>();

    public List<Integer> getCodigo() {
        return codigo;
    }

    public void setCodigo(List<Integer> codigo) {
        this.codigo = codigo;
    }

    public Tabla() {
        super();
        codigo.clear();
    }
    
    
    public void listar(List<Object> lista){
            DefaultTableModel modelo=(DefaultTableModel)this.getModel();
            Util.limpiarTablas(modelo);
            if (lista==null)
                return;
            ConsultaStock objConsultaStock;
            Ventas objVentas;
            Proforma objProforma;
            VentasProforma objVentasProforma;
            
        for (Object object : lista) {
            
//            if (object instanceof Proveedor){
//                Proveedor objProveedor=(Proveedor) object;
//                
//                
//                modelo=cargaProveedor(modelo, objProveedor);
//                codigo.add(objProveedor.getInt_idProveedor());
//            }
//            else if (object instanceof Cliente){
//                Cliente objCliente=(Cliente)object;
//                
//                modelo=cargaCliente(modelo, objCliente);
//                codigo.add(objCliente.getInt_id());
//            }
            
            if (object instanceof ConsultaStock){
                objConsultaStock=(ConsultaStock) object;
                modelo=cargarConsultaStock(modelo,objConsultaStock);
                codigo.add(objConsultaStock.getObjProducto().getInt_idProducto());
            }
            else if (object instanceof Ventas ){
                objVentas=(Ventas) object;
                modelo=cargarVenta(modelo,objVentas);
                codigo.add(objVentas.getObjProducto().getInt_idProducto());
            }
            else if (object instanceof Proforma){
                objProforma=(Proforma)object;
                modelo=cargarProforma(modelo,objProforma);
                
                
            }
            else if (object instanceof VentasProforma){
                objVentasProforma=(VentasProforma) object;
                modelo=cargarVentaProforma(modelo,objVentasProforma);
                codigo.add(objVentasProforma.getObjProducto().getInt_idProducto());
            }
        }
        this.setModel(dataModel);
    }
    
    
//    private DefaultTableModel cargaProveedor(DefaultTableModel modelo,Proveedor objProveedor){
//        Object [] filaTabla=new Object[9];
//        
//        filaTabla[0]=objProveedor.getInt_idProveedor();
//        filaTabla[1]=objProveedor.getStr_ruc();
//        filaTabla[2]=objProveedor.getStr_razonSocial();
//        filaTabla[3]=objProveedor.getStr_direccion();
//        filaTabla[4]=objProveedor.getStr_correo();
//        filaTabla[5]=objProveedor.getStr_telefono();
//        filaTabla[6]=objProveedor.getStr_fax();
//        filaTabla[7]=objProveedor.getStr_representante();
//        filaTabla[8]=objProveedor.getStr_estado();
//        
//        modelo.addRow(filaTabla);
//        return modelo;
//    }
//    
    public int getCodigo(int indice){
    	log.info("Indice: "+indice);
        return this.codigo.get(indice);
    }

//    private DefaultTableModel cargaCliente(DefaultTableModel modelo, Cliente objCliente) {
//       Object [] filaTabla=new Object[5];
//       
//       filaTabla[0]=objCliente.getInt_id();
//       filaTabla[1]=objCliente.getStr_ruc_dni();
//       filaTabla[2]=objCliente.getStr_razonSocial();
//       filaTabla[3]=objCliente.getStr_Direccion();
//       filaTabla[4]=objCliente.getStr_estado();
//       modelo.addRow(filaTabla);
//       return modelo;
//    }
//    

    private DefaultTableModel cargarConsultaStock(DefaultTableModel modelo, ConsultaStock objConsultaStock) {
         
        
        
        Object [] filaTabla=new Object[13];
        
        filaTabla[0]=objConsultaStock.getObjProducto().getInt_idProducto();
        filaTabla[1]=objConsultaStock.getObjProducto().getStr_nombreProducto();
        filaTabla[2]=objConsultaStock.getObjProducto().getStr_fabricante();
        filaTabla[3]=objConsultaStock.getObjProveedor().getInt_idProveedor();
        filaTabla[4]=objConsultaStock.getObjProveedor().getStr_razonSocial();
        filaTabla[5]=objConsultaStock.getObjUnidadMedida().getInt_idUnidadMedida();
        filaTabla[6]=objConsultaStock.getObjUnidadMedida().getStr_descripcionUM();
        if (objConsultaStock.getDbl_precioOferta().compareTo(BigDecimal.ZERO)==1) {
            filaTabla[7] = objConsultaStock.getDbl_precioOferta();
        } else {
            filaTabla[7]=objConsultaStock.getDbl_precio();
        }
        filaTabla[8]=objConsultaStock.getDbl_stock();
        
        filaTabla[9]=objConsultaStock.getDlb_stockXCompra();
        
        
        //En Iquitos todo es sin IGV=======================================================
            if (objConsultaStock.getObjProducto().getStr_reintegroTributario().equals("SI"))
                filaTabla[10]=true;
            else 
                filaTabla[10]=false;
        //En Iquitos todo es sin IGV=======================================================
        
            
        filaTabla[11]=objConsultaStock.getDbl_DescuentoPermitido();
        filaTabla[12]=objConsultaStock.getObjProducto().getStr_codigoInterno();
        
        
        modelo.addRow(filaTabla);
        
        
        
        
        return modelo;
    }

    private DefaultTableModel cargarVenta(DefaultTableModel modelo, Ventas objVentas) {
        
        Object [] filaTabla=new Object[9];
        
        filaTabla[0]=objVentas.getObjProducto().getInt_idProducto();
        filaTabla[1]=objVentas.getObjProducto().getStr_nombreProducto();
        filaTabla[2]=objVentas.getObjUnidadMedida().getStr_nombreUM();
        filaTabla[3]=objVentas.getDbStock();
        filaTabla[4]=objVentas.getDbPrecio();
        filaTabla[5]=objVentas.getDbCantidad();
        if (objVentas.getObjProducto().getStr_reintegroTributario().equals("SI"))
            filaTabla[6]=false;
        else
            filaTabla[6]=false;
        filaTabla[7]=objVentas.getDbdescuento();
        filaTabla[8]=objVentas.getDbSubtotal();
        
        modelo.addRow(filaTabla);
        return modelo;
    }

    private DefaultTableModel cargarProforma(DefaultTableModel modelo, Proforma objProforma) {
        Object [] filaTabla=new Object[8];
        
        filaTabla[0]=objProforma.getNumeroDocumento();
        filaTabla[1]=objProforma.getRucdni();
        filaTabla[2]=objProforma.getRazonSocial();
        filaTabla[3]=objProforma.getSubTotal();
        filaTabla[4]=objProforma.getIgv();
        filaTabla[5]=objProforma.getDescuento();
        filaTabla[6]=objProforma.getTotal();
        filaTabla[7]=objProforma.getFechaRegistro();
        
        modelo.addRow(filaTabla);
        
        return modelo;
    }

    private DefaultTableModel cargarVentaProforma(DefaultTableModel modelo, VentasProforma objVentasProforma) {
        Object [] filaTabla=new Object[9];
      
         
          String ini="";
           String dato="";
            String fin="";
        if ((objVentasProforma.getDbCantidad().multiply(objVentasProforma.getDbUnidadesContenidas())).compareTo(objVentasProforma.getDbStock())==1
             || objVentasProforma.getDbPrecio().compareTo(objVentasProforma.getDbl_precio2())!=0){
            
             ini="<html>" + "<font color=\"#FF0000\">" + "<b>"    ;
             
            fin="</b>" + "</font>" + "</html>";
        }
        else
        {
             ini="<html>" + "<font color=\"#188E5B\">" + "<b>"    ;
             
            fin="</b>" + "</font>" + "</html>";
                    
        }
        
        
            dato=ini.concat(String.valueOf(objVentasProforma.getObjProducto().getInt_idProducto())).concat(fin);
            filaTabla[0]=dato;
            dato=ini.concat(String.valueOf(objVentasProforma.getObjProducto().getStr_nombreProducto())).concat(fin);
            filaTabla[1]=dato;
            dato=ini.concat(String.valueOf(objVentasProforma.getObjUnidadMedida().getStr_nombreUM())).concat(fin);
            filaTabla[2]=dato;
            dato=ini.concat(String.valueOf(objVentasProforma.getDbStock())).concat(fin);
            filaTabla[3]=dato;
            dato=ini.concat(String.valueOf(objVentasProforma.getDbPrecio())).concat(fin);
            filaTabla[4]=dato;
            dato=ini.concat(String.valueOf(objVentasProforma.getDbCantidad().compareTo(objVentasProforma.getDbUnidadesContenidas()))).concat(fin);
            filaTabla[5]=dato;
            
            filaTabla[6]=false;
            
            dato=ini.concat(String.valueOf(objVentasProforma.getDbdescuento())).concat(fin);
            filaTabla[7]=dato;
            
            dato=ini.concat(String.valueOf(objVentasProforma.getDbSubtotal())).concat(fin);
            filaTabla[8]=dato;
            
            modelo.addRow(filaTabla);
        return modelo;
    }
    
    
    
    
    
    
}
