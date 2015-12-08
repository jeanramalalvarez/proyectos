/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.reutilizable.dao;

import com.gestionmatriz.reutilizable.bean.Ubigeo;
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
public class MysqlUbigeoDAO extends ConexionSqlSpring implements UbigeoDAO{

    @Override
    public List<Ubigeo> listaDepartamentos() throws SQLException {
        
        List<Ubigeo> listaDepartamentos =new ArrayList<Ubigeo>();
        
        Connection cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
        
        
        String sql="CALL sp_listaDepartamentos";
        PreparedStatement ps=cnn.prepareStatement(sql);
        
        ResultSet rs=ps.executeQuery();
        
        Ubigeo objUbigeo;
        while(rs.next()){
            objUbigeo=new Ubigeo();
            
            objUbigeo.setStrDepartamento(rs.getString("codDpto"));
            objUbigeo.setStrProvincia(rs.getString("codProv"));
            objUbigeo.setStrDistrito(rs.getString("codDist"));            
            objUbigeo.setStrNombre(rs.getString("nombre"));
            
            
            
            listaDepartamentos.add(objUbigeo);
        }
        
        rs.close();
        ps.close();
        ConexionSql.cerrarConexion(cnn);
        return listaDepartamentos;
        
    }

    @Override
    public List<Ubigeo> listaProvincias(String depart) throws SQLException {
        
        
        List<Ubigeo> listaDepartamentos =new ArrayList<Ubigeo>();
        
        Connection cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
        
        
        String sql="CALL sp_listaProvincias(?)";
        PreparedStatement ps=cnn.prepareStatement(sql);
        ps.setString(1, depart);
        
        ResultSet rs=ps.executeQuery();
        
        Ubigeo objUbigeo;
        while(rs.next()){
            objUbigeo=new Ubigeo();
            
            objUbigeo.setStrDepartamento(rs.getString("codDpto"));
            objUbigeo.setStrProvincia(rs.getString("codProv"));
            objUbigeo.setStrDistrito(rs.getString("codDist"));            
            objUbigeo.setStrNombre(rs.getString("nombre"));
            
            
            
            listaDepartamentos.add(objUbigeo);
        }
        
        rs.close();
        ps.close();
        ConexionSql.cerrarConexion(cnn);
        return listaDepartamentos;
        
    }

    @Override
    public List<Ubigeo> listaDistritos(String depart, String provin) throws SQLException {
        
        
         List<Ubigeo> listaDepartamentos =new ArrayList<Ubigeo>();
        
        Connection cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
        
        
        String sql="CALL sp_listaDistritos(?,?)";
        PreparedStatement ps=cnn.prepareStatement(sql);
        ps.setString(1, depart);
        ps.setString(2, provin);
        
        ResultSet rs=ps.executeQuery();
        
        Ubigeo objUbigeo;
        while(rs.next()){
            objUbigeo=new Ubigeo();
            
            objUbigeo.setStrDepartamento(rs.getString("codDpto"));
            objUbigeo.setStrProvincia(rs.getString("codProv"));
            objUbigeo.setStrDistrito(rs.getString("codDist"));            
            objUbigeo.setStrNombre(rs.getString("nombre"));
            
            
            
            listaDepartamentos.add(objUbigeo);
        }
        
        rs.close();
        ps.close();
        ConexionSql.cerrarConexion(cnn);
        return listaDepartamentos;
        
    }


    
}
