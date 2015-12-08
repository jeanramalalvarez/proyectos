
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.reportes;



import com.gestionmatriz.util.ReportUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author zholo
 */
public class Ireport {

  private final Logger log=Logger.getLogger(Ireport.class);  
    
    public Ireport() {
    }

    /**
     * Reporte de productos por proveedor
     * @param idProveedor id del proveedor
     */
    public void productoXProveedor(String idProveedor) {
        InputStream input=null;
        try {
            input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/ProveedorProducto.jasper");
            Map<String,Object> parametros=new HashMap<>();
            parametros.clear();
            parametros.put("idProveedor", idProveedor);
            ReportUtil.printView(parametros, input);
        } catch (Exception ex) {
            log.error(ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                log.error(ex);
            }
        }
    }

    /**
     * Reporte de guia
     * @param nroGuia numero de guia
     */
    public void imprimirGuia(String nroGuia) {
        InputStream input=null;
        try {
           input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/");
           Map<String, Object> parametros = new HashMap<>();
           parametros.clear();
           parametros.put("nroGuia", nroGuia);
           ReportUtil.printView(parametros, input);
        } catch (Exception ex) {
            log.error(ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                log.error(ex);
            }
        }
    }

    /**
     * Precio de un producto propiedad de una familia
     * @param idFamilia Codigo de la familia del producto
     */
    public void precioProductoFamilia(String idFamilia) {
        InputStream input=null;
        try {
            input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/PrecioProductoFamilia.jasper");
            Map<String, Object> parametros = new HashMap<>();
            parametros.clear();
            parametros.put("idFamilia", idFamilia);
            ReportUtil.printView(parametros, input);
        } catch (Exception ex) {
            log.error(ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                log.error(ex);
            }
        }
    }

    /**
     * Reporte de transpaso interno
     * @param nomLocal
     * @param fchInicial
     * @param fchFinal 
     */
    public void traspasoInterno(String nomLocal, String fchInicial, String fchFinal) {
        InputStream input=null;
        try {
            input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/TraspasoInternoLocal.jasper");
            Map<String, Object> parametros = new HashMap<>();
            parametros.clear();
            parametros.put("fchInicial", fchInicial);
            parametros.put("fchFinal", fchFinal);
            parametros.put("nomLocal", nomLocal);
            ReportUtil.printView(parametros, input);
        } catch (Exception ex) {
            log.error(ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                log.error(ex);
            }
        }
    }

    /**
     * Stock de un producto en un almacen
     * @param nomLocal nombre del local
     */
    public void stockProductoAlmacen(String nomLocal) {
        InputStream input=null;
        try {
            input=getClass()
                    .getResourceAsStream("/com/gestionmatriz/reporte/StockProductoAlmacen.jasper");
            Map<String, Object> parametros = new HashMap<>();
            parametros.clear();
            parametros.put("nomLocal", nomLocal);
            ReportUtil.printView(parametros, input);
        } catch (Exception ex) {
            log.error(ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                log.error(ex);
            }
        }
    }

    
    /**
     * Reporte del monto total en reintegros dentro de una fecha
     * @param fchInicial fecha inicial
     * @param fchFinal fecha final
     */
    public void totalReintegroFechas(String fchInicial, String fchFinal) {
        InputStream input=null;
        try {
            input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/");
            Map<String, Object> parametros = new HashMap<>();
            parametros.clear();
            parametros.put("fchInicial", fchInicial);
            parametros.put("fchFinal", fchFinal);

            ReportUtil.printView(parametros, input);
        
        } catch (Exception ex) {
            log.error(ex.getMessage(),ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                log.error(ex.getMessage(),ex);
            }
        }
    }

    /**
     * Reintegro tributario por fechas
     * @param fchInicial fecha inicial
     * @param fchFinal fecha final 
     */
    public void ReintegroFechas(String fchInicial, String fchFinal) {
        InputStream input=null;
        try {
            input=getClass()
                    .getResourceAsStream("/com/gestionmatriz/reporte/ReporteReintegro.jasper");
            Map<String, Object> parametros = new HashMap<>();
            parametros.clear();
            parametros.put("fchInicial", fchInicial);
            parametros.put("fchFinal", fchFinal);
            ReportUtil.printView(parametros, input);
        } catch (Exception ex) {
            log.error(ex.getMessage(),ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                log.error(ex.getMessage(),ex);
            }
        }
    }

    
    /**
     * Reporte de compras por fechas
     * @param fchInicial fecha incial
     * @param fchFinal fecha final
     */
    public void ComprasFechas(String fchInicial, String fchFinal) {
        InputStream input=null;

        try {

            input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/ComprasFechas.jasper");
            Map<String, Object> parametros = new HashMap<>();
            parametros.clear();
            parametros.put("fchInicial", fchInicial);
            parametros.put("fchFinal", fchFinal);

            ReportUtil.printView(parametros, input);
        
        } catch (Exception ex) {
            log.error(ex.getMessage(),ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                log.error(ex.getMessage(),ex);
            }
        }
    }

    /**
     * Reporte de todas la compra entre un rango de fechas
     * @param fchInicial fecha incial
     * @param fchFinal  fecha final
     */
    public void todasCompras(String fchInicial, String fchFinal) {
        InputStream input=null;
        try {
            input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/TodasCompras.jasper");
            Map<String, Object> parametros = new HashMap<>();
            parametros.clear();
            parametros.put("fchInicial", fchInicial);
            parametros.put("fchFinal", fchFinal);
            ReportUtil.printView(parametros, input);
        
        } catch (Exception ex) {
            log.error(ex.getMessage(),ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                 log.error(ex.getMessage(),ex);
            }
        }
    }

    /**
     * Reporte del producto mas comprado
     * @param fchInicial fecha inicial
     * @param fchFinal fecha final
     */
    public void ProductoMasComprado(String fchInicial, String fchFinal) {
        InputStream input=null;

        try {
            input=getClass()
                    .getResourceAsStream("/com/gestionmatriz/reporte/ProductoMasComprado.jasper");

            Map<String, Object> parametros = new HashMap<>();
            parametros.clear();
            parametros.put("fchInicial", fchInicial);
            parametros.put("fchFinal", fchFinal);

            ReportUtil.printView(parametros, input);
        
        } catch (Exception ex) {
            log.error(ex.getMessage(),ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                log.error(ex.getMessage(),ex);
            }
        }
    }

    /**
     * Imprime una GUIA
     * @param nroOC numero de GUIA
     */
    public void imprimirOrdenCompra(String nroOC) {
        InputStream input=null;

        try {
            input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/OrdenCompra.jasper");
            Map<String, Object> parametros = new HashMap<>();
            parametros.clear();
            parametros.put("nroOC", nroOC);
            ReportUtil.printView(parametros, input);
        } catch (Exception ex) {
            log.error(ex.getMessage(),ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                 log.error(ex.getMessage(),ex);
            }
        }
    }
}
