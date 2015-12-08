/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.dao;

import com.gestionmatriz.puntoventa.bean.DetalleGuiaRemision;
import com.gestionmatriz.puntoventa.bean.GuiaRemision;
import com.gestionmatriz.puntoventa.bean.ImprimirGuia;
import java.util.List;

/**
 *
 * @author jarcon
 */
public interface GuiaRemisionDAO {

    public List<GuiaRemision> buscarGuias(String nroGuia,String LocalPartida,String estado);

    public boolean registrarGuiaRemision(GuiaRemision objGuiaRemision,List<DetalleGuiaRemision> objDetalleGuiaRemision);

    public boolean registrarDetalleGuiaRemision(DetalleGuiaRemision objDetalleGuiaRemision);

    public boolean updateEstadoGuia(int idGuia, String estado);

    public List<DetalleGuiaRemision> buscarDetalleGuiaXId(int idGuiaRemision);

    public List<ImprimirGuia> imprimirGuia(String nroGuia);
    
}
