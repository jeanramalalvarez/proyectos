/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.dao;

import com.gestionmatriz.recursoshumanos.bean.Memorandum;
import java.util.List;

/**
 *
 * @author zholo
 */
public interface MemorandumDAO {

    public boolean registrarMemorandum(Memorandum objMemorandum);

    public List<Memorandum> listarMemorandum();

    public List<Memorandum> buscarMemorandum(String asunto, String fecchaInicial, String fechaFinal);

    public boolean updateEstadoMemorandum(int idMemorandum);
    
}
