/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.sql;

import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import java.util.Objects;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author yesmi
 */
public class ConexionSqlSpring {

   
    private static ApplicationContext context = Objects.equals(Globales.TIPO_CONEXION, Constantes.SPRING)?
    		new ClassPathXmlApplicationContext("Spring-Module.xml"):null;
    
    private static ConexionBean springConexionLoad= Objects.equals(Globales.TIPO_CONEXION, Constantes.SPRING)?
            (ConexionBean)context.getBean("conexionSqlSpring"):null;

    /*public ConexionSqlSpring() {
        springConexionLoad=Objects.equals(Globales.TIPO_CONEXION, Constantes.SPRING)?
                (ConexionBean)context.getBean("conexionSqlSpring"):null;
    }*/

    public ApplicationContext getContext() {
        return context;
    }

    /*public void setContext(ApplicationContext context) {
        this.context = context;
    }*/

    public static ConexionBean getSpringConexionLoad() {
        return springConexionLoad;
    }

    /*public void setSpringConexionLoad(ConexionBean springConexionLoad) {
        this.springConexionLoad = springConexionLoad;
    }*/

    public static DataSource getDataSource() {
        return springConexionLoad.getDataSource();
    }

   

}
