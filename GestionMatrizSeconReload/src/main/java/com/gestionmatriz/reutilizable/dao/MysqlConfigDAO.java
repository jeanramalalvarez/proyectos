/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.reutilizable.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import org.apache.log4j.Logger;

import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;

/**
 *
 * @author YESM
 */
public class MysqlConfigDAO extends ConexionSqlSpring implements ConfigBDDAO {

	private static final Logger log=Logger.getLogger(MysqlConfigDAO.class);
	@Override
    public int[] getTiempoEspera() {
        
        int tiempo[]=new int[2];
        Connection cnn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        
        try{
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            
            String sql="call sp_minutosProrroga";
            
            ps=cnn.prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                tiempo[0]=rs.getInt(1);
                tiempo[1]=rs.getInt(2);
            }
        }
        catch(SQLException ex){
            log.error("Error: "+ex.getMessage());
        }
        catch (Exception ex){
            log.error("Error: "+ex.getMessage());
        }
        finally{
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error: "+ex.getMessage());
            }
        }
        
        return tiempo;
    }

    @Override
    public BigDecimal getIGV() {
        BigDecimal dbRespuesta=BigDecimal.ZERO;
        Connection cnn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try{
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?ConexionSql.getConexion():this.getDataSource().getConnection();
            
            String sql="call sp_consultaIGV".concat(PrepararSQL.get(0));
            
            ps=cnn.prepareStatement(sql);
            
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                dbRespuesta=(rs.getBigDecimal(1).divide(new BigDecimal(100)));
            }
            
            
        }
        catch (SQLException ex){
            log.error("Error: "+ex.getMessage());
        }
        catch (Exception ex){
            log.error("Error: "+ex.getMessage());
        }finally{
        	try {
				cnn.close();
			} catch (SQLException e) {
				log.error("Error: "+e.getMessage());
			}
        }
        
        return dbRespuesta;
    }
    
    
}
