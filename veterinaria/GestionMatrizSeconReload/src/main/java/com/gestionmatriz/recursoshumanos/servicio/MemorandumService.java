/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.recursoshumanos.bean.Memorandum;
import com.gestionmatriz.recursoshumanos.dao.MemorandumDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author zholo
 */
public class MemorandumService implements MemorandumService_I{

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);		
    MemorandumDAO objMemorandumDAO =fabrica.getMemorandumDAO();
    
    @Override
    public boolean registrarMemorandum(Memorandum objMemorandum) throws SQLException {
        return objMemorandumDAO.registrarMemorandum(objMemorandum);
    }

    @Override
    public List<Memorandum> listarMemorandum() throws SQLException {
        return objMemorandumDAO.listarMemorandum();
    }

    @Override
    public List<Memorandum> buscarMemorandum(String asunto, String fecchaInicial, String fechaFinal) throws SQLException {
        return objMemorandumDAO.buscarMemorandum(asunto,fecchaInicial, fechaFinal);
    }

    @Override
    public boolean updateEstadoMemorandum(int idMemorandum) throws SQLException {
        return objMemorandumDAO.updateEstadoMemorandum(idMemorandum);
    }
    
}
