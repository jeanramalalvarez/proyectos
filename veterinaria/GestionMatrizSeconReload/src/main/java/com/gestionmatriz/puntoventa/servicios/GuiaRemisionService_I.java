/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.servicios;

import com.gestionmatriz.puntoventa.bean.DetalleGuiaRemision;
import java.util.List;

/**
 *
 * @author jarcon
 */
public interface GuiaRemisionService_I {
    
    public List<com.gestionmatriz.puntoventa.bean.GuiaRemision> buscarGuias(String nroGuia,String LocalPartida,String estado);
    
    public boolean registrarGuiaRemision(com.gestionmatriz.puntoventa.bean.GuiaRemision objGuiaRemision,List<DetalleGuiaRemision> objDetalleGuiaRemision);
    
    public boolean registrarDetalleGuiaRemision(DetalleGuiaRemision objDetalleGuiaRemision);
    
    public boolean updateEstadoGuia(int idGuia,String estado);
    
    public List<com.gestionmatriz.puntoventa.bean.DetalleGuiaRemision>buscarDetalleGuiaXId(int idGuiaRemision);
    
    public List<com.gestionmatriz.puntoventa.bean.ImprimirGuia>imprimirGuia(String nroGuia);
    


}
