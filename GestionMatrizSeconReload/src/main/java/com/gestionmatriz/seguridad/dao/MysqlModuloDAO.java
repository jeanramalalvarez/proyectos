/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.seguridad.dao;

import com.gestionmatriz.seguridad.bean.Modulo;
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
public class MysqlModuloDAO extends ConexionSqlSpring implements ModuloDAO{

    @Override
    public List<Modulo> listaModulos() throws SQLException {
       
        List<Modulo> listaModulos =new ArrayList<Modulo>();
        
        Connection cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
        
        
        String sql="CALL sp_listaModulos";
        PreparedStatement ps=cnn.prepareStatement(sql);
        
        ResultSet rs=ps.executeQuery();
        
        Modulo objModulos;
        while(rs.next()){
            objModulos=new Modulo();
            
            objModulos.setInt_modulo(rs.getInt("int_modulo")); 
            objModulos.setStr_descripcion(rs.getString("str_descripcion"));
            
            listaModulos.add(objModulos);
        }
        
        rs.close();
        ps.close();
        ConexionSql.cerrarConexion(cnn);
        return listaModulos;
    }
    
}
