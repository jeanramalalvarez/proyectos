/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.bean;

import java.math.BigDecimal;

import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.bean.UnidadMedida;

/**
 *
 * @author jarcon
 */
public class ConsultaStock {
    
    private Producto objProducto;
    private Proveedor objProveedor;
    private UnidadMedida objUnidadMedida;
    private BigDecimal dbl_precio;
    private BigDecimal dbl_stock;
    private BigDecimal dlb_stockXCompra;
    private BigDecimal dbl_DescuentoPermitido;
    private BigDecimal dbl_precioOferta;

    public BigDecimal getDbl_precioOferta() {
        return dbl_precioOferta;
    }

    public void setDbl_precioOferta(BigDecimal dbl_precioOferta) {
        this.dbl_precioOferta = dbl_precioOferta;
    }

    public BigDecimal getDbl_DescuentoPermitido() {
        return dbl_DescuentoPermitido;
    }

    public void setDbl_DescuentoPermitido(BigDecimal dbl_DescuentoPermitido) {
        this.dbl_DescuentoPermitido = dbl_DescuentoPermitido;
    }
    
    
    

    public BigDecimal getDlb_stockXCompra() {
        return dlb_stockXCompra;
    }

    public void setDlb_stockXCompra(BigDecimal dlb_stockXCompra) {
        this.dlb_stockXCompra = dlb_stockXCompra;
    }
    
    
    

    public BigDecimal getDbl_precio() {
        return dbl_precio;
    }

    public void setDbl_precio(BigDecimal dbl_precio) {
        this.dbl_precio = dbl_precio;
    }

    public BigDecimal getDbl_stock() {
        return dbl_stock;
    }

    public void setDbl_stock(BigDecimal dbl_stock) {
        this.dbl_stock = dbl_stock;
    }

    public Producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(Producto objProducto) {
        this.objProducto = objProducto;
    }

    public Proveedor getObjProveedor() {
        return objProveedor;
    }

    public void setObjProveedor(Proveedor objProveedor) {
        this.objProveedor = objProveedor;
    }

    public UnidadMedida getObjUnidadMedida() {
        return objUnidadMedida;
    }

    public void setObjUnidadMedida(UnidadMedida objUnidadMedida) {
        this.objUnidadMedida = objUnidadMedida;
    }
    
    
}
