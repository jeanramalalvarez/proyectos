/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.dao;

import com.gestionmatriz.seguridad.bean.Funciones;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author YESM
 */
public class MysqlFuncionesDAO extends ConexionSqlSpring implements FuncionesDAO{

    @Override
    public List<Funciones> listaFunciones() throws SQLException {
        List<Funciones> listaFunciones =new ArrayList<Funciones>();
        
        Connection cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
        
        
        String sql="CALL sp_listaFunciones";
        PreparedStatement ps=cnn.prepareStatement(sql);
        
        ResultSet rs=ps.executeQuery();
        
        Funciones objFunciones;
        while(rs.next()){
            objFunciones=new Funciones();
            
            
            objFunciones.setInt_idFunciones(rs.getInt("int_idFunciones"));
            objFunciones.setStr_rol(rs.getString("str_rol"));
            objFunciones.setStr_key(rs.getString("str_key"));
            
            
            
            listaFunciones.add(objFunciones);
        }
        
        rs.close();
        ps.close();
        ConexionSql.cerrarConexion(cnn);
        return listaFunciones;
        
        
    }

    @Override
    public List<Funciones> listaFuncionesXModulo(int modulo) throws SQLException {
           List<Funciones> listaFunciones =new ArrayList<Funciones>();
        
        Connection cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
        
        
        String sql="CALL sp_listaFuncionesXModulo(?)";
        PreparedStatement ps=cnn.prepareStatement(sql);
        
        ps.setInt(1, modulo);
        
        ResultSet rs=ps.executeQuery();
        
        Funciones objFunciones;
        while(rs.next()){
            objFunciones=new Funciones();
            
            
            objFunciones.setInt_idFunciones(rs.getInt("int_idFunciones"));
            objFunciones.setStr_rol(rs.getString("str_rol"));
            objFunciones.setStr_key(rs.getString("str_key"));
            
            
            
            listaFunciones.add(objFunciones);
        }
        
        rs.close();
        ps.close();
        ConexionSql.cerrarConexion(cnn);
        return listaFunciones;
        
    }
    
}
