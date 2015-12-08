/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.servicio;

import com.gestionmatriz.recursoshumanos.bean.Memorandum;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface MemorandumService_I {
    
    public abstract boolean registrarMemorandum(Memorandum objMemorandum) throws SQLException;
    
    public abstract List<Memorandum> listarMemorandum() throws SQLException;
    
    public abstract List<Memorandum> buscarMemorandum(String asunto, String fecchaInicial, String fechaFinal) throws SQLException;
    
    public abstract boolean updateEstadoMemorandum(int idMemorandum) throws SQLException;
}
