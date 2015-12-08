/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.servicio;

import com.gestionmatriz.dao.DAOFactory;
import com.gestionmatriz.seguridad.dao.UtilMysqlDAO;

/**
 *
 * @author YESM
 */
public class UtilMysqlService implements UtilMysqlService_I {

    DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    UtilMysqlDAO objUtilMysqlDAO = fabrica.getUtilMysqlDAO();

    @Override
    public String getFechaMysql() {
        return objUtilMysqlDAO.getFechaMysql();
    }
}
