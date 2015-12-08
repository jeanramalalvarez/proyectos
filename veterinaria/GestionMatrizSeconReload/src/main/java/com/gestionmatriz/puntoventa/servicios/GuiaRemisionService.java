/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.servicios;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.puntoventa.bean.DetalleGuiaRemision;
import com.gestionmatriz.puntoventa.bean.GuiaRemision;
import com.gestionmatriz.puntoventa.bean.ImprimirGuia;
import com.gestionmatriz.puntoventa.dao.GuiaRemisionDAO;
import java.util.List;

/**
 *
 * @author jarcon
 */
public class GuiaRemisionService implements GuiaRemisionService_I{
    
    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    GuiaRemisionDAO objGuiaRemisionDAO = fabrica.getGuiaRemisionDAO();

    @Override
    public List<GuiaRemision> buscarGuias(String nroGuia,String LocalPartida,String estado) {
        return objGuiaRemisionDAO.buscarGuias(nroGuia,LocalPartida,estado);
    }

    @Override
    public boolean registrarGuiaRemision(GuiaRemision objGuiaRemision,List<DetalleGuiaRemision> objDetalleGuiaRemision) {
        return objGuiaRemisionDAO.registrarGuiaRemision(objGuiaRemision,objDetalleGuiaRemision);
    }

    @Override
    public boolean registrarDetalleGuiaRemision(DetalleGuiaRemision objDetalleGuiaRemision) {
        return objGuiaRemisionDAO.registrarDetalleGuiaRemision(objDetalleGuiaRemision);
    }

    @Override
    public boolean updateEstadoGuia(int idGuia, String estado) {
        return objGuiaRemisionDAO.updateEstadoGuia(idGuia,estado);
    }

    @Override
    public List<DetalleGuiaRemision> buscarDetalleGuiaXId(int idGuiaRemision) {
        return objGuiaRemisionDAO.buscarDetalleGuiaXId(idGuiaRemision);
    }

    @Override
    public List<ImprimirGuia> imprimirGuia(String nroGuia) {
        return objGuiaRemisionDAO.imprimirGuia(nroGuia);
        
    }
    
}
