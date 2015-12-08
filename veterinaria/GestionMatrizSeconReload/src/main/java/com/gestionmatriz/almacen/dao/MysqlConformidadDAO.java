/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.almacen.dao;

import com.gestionmatriz.almacen.bean.ProveedorProductoOrdenCompraFacturaCompra;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

/**
 *
 * @author jarcon
 */
public class MysqlConformidadDAO extends ConexionSqlSpring implements ConformidadDAO {

	private static final Logger log=Logger.getLogger(MysqlConformidadDAO.class);  
    @Override
    public boolean registrarConformidad(List<ProveedorProductoOrdenCompraFacturaCompra> listaPPOCFC) {
        boolean respuesta = false;
        Connection cnn = null;
        PreparedStatement ps;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "CALL sp_updatePPOCFCConformidad" + PrepararSQL.get(11);
            ps = cnn.prepareStatement(sql);
            for (ProveedorProductoOrdenCompraFacturaCompra objPPOCFC : listaPPOCFC) {
                ps.setInt(1, objPPOCFC.getObjProveedorProductoOrdenCompra().getObjProveedor().getInt_idProveedor());
                ps.setInt(2, objPPOCFC.getObjProveedorProductoOrdenCompra().getObjProducto().getInt_idProducto());
                ps.setInt(3, objPPOCFC.getObjProveedorProductoOrdenCompra().getInt_idOrdenCompra());
                ps.setString(4, objPPOCFC.getStr_numeroFactura());
                ps.setBigDecimal(5, objPPOCFC.getDbl_conformidadOK());
                ps.setBigDecimal(6, objPPOCFC.getDbl_conformidadFallaProveedor());
                ps.setBigDecimal(7, objPPOCFC.getDbl_conformidadFallaTransportista());
                ps.setBigDecimal(8, objPPOCFC.getDbl_conformidadFallaOtro());
                ps.setString(9, objPPOCFC.getStr_conformidadObservacion());
                ps.setString(10, objPPOCFC.getStr_conformidadEstado());
                ps.setString(11, objPPOCFC.getStr_usuarioModificador());
                ps.execute();
            }

            cnn.commit();
            respuesta = true;
        } catch (SQLException ex) {
            try {
                cnn.rollback();
                log.error("Error SQL: " + ex.getMessage());
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error -: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            try {
                cnn.rollback();
                log.error("Error --: " + ex.getMessage());
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error ---: " + ex1.getMessage());
            }
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
            }
        }

        return respuesta;
    }

}
