/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.util;

/**
 *
 * @author YESM
 */
public class PrepararSQL {
    
    public static String get(int parametros){
        
        String sql="(";
        
        for (int i=1;i<=parametros;i++){
                sql+="?";
                if (i!=parametros)
                    sql+=",";
        }
        
        sql+=")";
        
        return sql;
    }
}
