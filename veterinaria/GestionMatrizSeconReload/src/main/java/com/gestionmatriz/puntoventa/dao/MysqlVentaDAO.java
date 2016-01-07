/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.puntoventa.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

import com.gestionmatriz.almacen.bean.Almacen;
import com.gestionmatriz.almacen.bean.Familia;
import com.gestionmatriz.almacen.bean.Producto;
import com.gestionmatriz.almacen.bean.Proveedor;
import com.gestionmatriz.almacen.bean.TipoMovimiento;
import com.gestionmatriz.almacen.bean.UnidadMedida;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.puntoventa.bean.Cliente;
import com.gestionmatriz.puntoventa.bean.ConsultaStock;
import com.gestionmatriz.puntoventa.bean.CorrelativoDocumento;
import com.gestionmatriz.puntoventa.bean.FlujoCaja;
import com.gestionmatriz.puntoventa.bean.ImprimirVenta;
import com.gestionmatriz.puntoventa.bean.Proforma;
import com.gestionmatriz.puntoventa.bean.Ventas;
import com.gestionmatriz.puntoventa.bean.VentasProforma;
import com.gestionmatriz.puntoventa.reportes.Ireport;
import com.gestionmatriz.recursoshumanos.bean.Local;
import com.gestionmatriz.recursoshumanos.bean.Personal;
import com.gestionmatriz.sql.ConexionSql;
import com.gestionmatriz.sql.ConexionSqlSpring;
import com.gestionmatriz.util.Constantes;
import com.gestionmatriz.util.Globales;
import com.gestionmatriz.util.PrepararSQL;
import com.gestionmatriz.util.Util;

/**
 *
 * @author jarcon
 */
public class MysqlVentaDAO extends ConexionSqlSpring implements VentaDAO {

	private static final Logger log=Logger.getLogger(MysqlVentaDAO.class);
    @Override
    public List<Object> buscarStock(int local, String producto) {
        List<Object> lista = new ArrayList<>();
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConsultaStock objConsultaStock;
        Producto objProducto;
        Proveedor objProveedor;
        UnidadMedida objUnidadMedida;
        //Inicio JRAMAL
        Familia objFamilia;
        //Fin JRAMAL

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_consultaStock".concat(PrepararSQL.get(3));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, local);
            String[] arrProducto = producto.split(" ");


            ps.setString(2, arrProducto[0]);
            if (arrProducto.length > 1) {
                ps.setString(3, arrProducto[1]);
            } else {
                ps.setString(3, "");
            }
            rs = ps.executeQuery();

            while (rs.next()) {
                objConsultaStock = new ConsultaStock();

                objProducto = new Producto();
                objProducto.setInt_idProducto(rs.getInt(1));
                objProducto.setStr_nombreProducto(rs.getString(2));
                objProducto.setStr_fabricante(rs.getString(3));
                objProducto.setStr_reintegroTributario(rs.getString(11));
                objProducto.setStr_codigoInterno(rs.getString(14));
                
                //Inicio JRAMAL
                objFamilia = new Familia();
                objFamilia.setInt_idFamilia(rs.getInt(15));
                objProducto.setObjFamilia(objFamilia);
                //Fin JRAMAL
                
                objConsultaStock.setObjProducto(objProducto);
                
                
                //if(objFamilia.getInt_idFamilia() != Constantes.FAMI_SERV){
                objProveedor = new Proveedor();
                objProveedor.setInt_idProveedor(rs.getInt(4));
                objProveedor.setStr_razonSocial(rs.getString(5));
                objConsultaStock.setObjProveedor(objProveedor);
                //}
                //Fin JRAMAL

                objUnidadMedida = new UnidadMedida();
                objUnidadMedida.setInt_idUnidadMedida(rs.getInt(6));
                objUnidadMedida.setStr_descripcionUM(rs.getString(7));
                objConsultaStock.setObjUnidadMedida(objUnidadMedida);

                objConsultaStock.setDbl_precio(rs.getBigDecimal(8));
                objConsultaStock.setDbl_stock(rs.getBigDecimal(9));
                objConsultaStock.setDlb_stockXCompra(rs.getBigDecimal(10));
                objConsultaStock.setDbl_DescuentoPermitido(rs.getBigDecimal(12));
                objConsultaStock.setDbl_precioOferta(rs.getBigDecimal(13));

                lista.add(objConsultaStock);
            }
        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        }finally{
        	try {
				cnn.close();
			} catch (SQLException e) {
				log.error("ERROR: "+e.getMessage());
			}
        }

        return lista;
    }

    @Override
    public boolean registrarVenta(List<Object> listaVenta, int tipoVentaProforma, String tituloProforma) {
        Connection cnn = null;
        PreparedStatement ps = null;
        boolean respuesta = false;
        Ventas objVenta;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)? ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "call sp_insertVenta".concat(PrepararSQL.get(15));
            ps = cnn.prepareStatement(sql);

            objVenta = new Ventas();
            String temp = null;

            if (listaVenta.size() > 0) {
                objVenta = (Ventas) listaVenta.get(0);
                if (tipoVentaProforma == 1) {
                    temp = consultaUltimoTemporal(objVenta.getObjLocal().getInt_idLocal());
                } else {
                    temp = consultaUltimaProforma(objVenta.getObjLocal().getInt_idLocal());
                }
            }

            for (Object object : listaVenta) {
                objVenta = (Ventas) object;

                if (objVenta.getStr_numeroDocumento().equals(Util.BOLETA)) {
                    objVenta.setStr_numeroDocumento(temp.concat("-".concat(Util.BOLETA)));

                } else {
                    objVenta.setStr_numeroDocumento(temp.concat("-".concat(Util.FACTURA)));
                }

                ps.setInt(1, objVenta.getObjProveedor().getInt_idProveedor());
                ps.setInt(2, objVenta.getObjProducto().getInt_idProducto());
                ps.setInt(3, objVenta.getObjCliente().getInt_idCliente());
                ps.setBigDecimal(4, objVenta.getDbCantidad());
                ps.setBigDecimal(5, objVenta.getDbPrecio());
                ps.setBigDecimal(6, objVenta.getDbSubtotal());
                ps.setBigDecimal(7, objVenta.getDbdescuento());
                ps.setBigDecimal(8, objVenta.getDbIGV());
                ps.setBigDecimal(9, objVenta.getDbTotal());
                ps.setString(10, objVenta.getStr_numeroDocumento());
                ps.setString(11, objVenta.getStr_usuario());
                ps.setString(12, com.gestionmatriz.util.Util.SINPAGO);
                ps.setString(13, objVenta.getStr_clienteResponsable());
                ps.setInt(14, objVenta.getObjLocal().getInt_idLocal());
                ps.setBigDecimal(15, objVenta.getDbUnidadesContenidas());
                //ps.setString(15,temp);
                ps.execute();
            }

            cnn.commit();
            respuesta = true;
            log.info("Evento: Se Registro la venta");

            if (tipoVentaProforma == 0) {

                Ireport ireport = new Ireport();
                log.info("documento---:" + objVenta.getStr_numeroDocumento());
                ireport.Proforma(objVenta.getStr_numeroDocumento(), tituloProforma);
                return respuesta;
            }
            // Aqui Transpaso de almacenes
            Almacen objAlmacen = null;
            List<Almacen> listaAlmacen = new ArrayList<>();
            TipoMovimiento objTipoMovimiento;

            for (Object object : listaVenta) {
                objVenta = (Ventas) object;
                objAlmacen = new Almacen();

                objAlmacen.setObjProveedor(objVenta.getObjProveedor());
                objAlmacen.setObjProducto(objVenta.getObjProducto());
                objAlmacen.setObjLocal(objVenta.getObjLocal());

                objTipoMovimiento = new TipoMovimiento();
                objTipoMovimiento.setInt_idTipoMovimiento(Util.SALIDAXVENTA);
                objAlmacen.setObjTipoMovimiento(objTipoMovimiento);
                objAlmacen.setStr_documento(objVenta.getStr_numeroDocumento());
                objAlmacen.setDbl_cantidad(objVenta.getDbCantidad().multiply(new BigDecimal(-1)));
                objAlmacen.setDbl_precio(objVenta.getDbPrecio());
                objAlmacen.setDbl_igv(objVenta.getDbIGV());
                objAlmacen.setDbl_descuento(objVenta.getDbdescuento());
                log.info("documento en el dao---" + objVenta.getDbdescuento());
                objAlmacen.setDbl_subTotal(objVenta.getDbSubtotal());
                objAlmacen.setStr_fechaDocumento(PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql());
                objAlmacen.setStr_estado(Util.ACTIVO);
                objAlmacen.setStr_usuarioCreador(objVenta.getStr_usuario());

                listaAlmacen.add(objAlmacen);
            }

            PaqueteBusinessDelegate.getAlmacenService().registrarAlmacen(listaAlmacen);


        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
            try {
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
            try {
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } finally{
        	try {
				cnn.close();
			} catch (SQLException e) {
				log.error("Error: " + e.getMessage());
			}
        }

        return respuesta;
    }

    @Override
    public List<Personal> listarVendedores(String idEmpresa) {
        Connection cnn = null;
        ArrayList<Personal> lista = new ArrayList<>();

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_listarVendedores" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, idEmpresa);
            ResultSet rs = ps.executeQuery();

            Personal objPersona;

            while (rs.next()) {
                objPersona = new Personal();

                //objPersona.setInt_idPersona(rs.getInt(1));
                objPersona.setStr_codigo(rs.getString(1));
                objPersona.setStr_apePaterno(rs.getString(2));
                objPersona.setStr_apeMaterno(rs.getString(3));
                objPersona.setStr_nombres(rs.getString(4));

                //agregamos al cliente al arreglo
                lista.add(objPersona);
            }
        } catch (SQLException ex) {
            log.error("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error SQL: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
            }
        }
        return lista;
    }

    @Override
    public String consultaUltimoTemporal(int local) {
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String respuesta = "";

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_consultaDocumentoVenta".concat(PrepararSQL.get(1));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, local);
            rs = ps.executeQuery();

            if (rs.next()) {
                respuesta = construirTemp(rs.getString(1));
            } else {
                respuesta = Util.TEMP.concat("1");
            }
        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        }finally{
        	try {
				cnn.close();
			} catch (SQLException e) {
				log.error("Error: " + e.getMessage());
			}
        }

        return respuesta;
    }

    @Override
    public String consultaUltimaProforma(int local) {
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String respuesta = "";

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_consultaDocumentoProforma".concat(PrepararSQL.get(1));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, local);
            rs = ps.executeQuery();

            if (rs.next()) {
                respuesta = construirProfo(rs.getString(1));
            } else {
                respuesta = Util.PROFO.concat("1");
            }
        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        }finally{
        	try {
				cnn.close();
			} catch (SQLException e) {
				log.error("Error: " + e.getMessage());
			}
        }

        return respuesta;
    }

    private String construirTemp(String s) {
        String arr = s;
        String res;
        int intCorrelativo;
        if (s == null) {
            intCorrelativo = 1;
        } else {
            intCorrelativo = Util.stringTOint(arr);
        }

        res = String.valueOf(intCorrelativo + 1);
        res = Util.TEMP.concat(res);

        return res;
    }

    private String construirProfo(String s) {
        String arr = s;
        String res;

        int intCorrelativo;

        if (s == null) {
            intCorrelativo = 1;
        } else {
            intCorrelativo = Util.stringTOint(arr);
        }

        res = String.valueOf(intCorrelativo + 1);
        res = Util.PROFO.concat(res);

        return res;
    }

    @Override
    public String consultaSiguinteCorrelativo(int local, String tipoDocumento) {
        String respuesta = "";
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CorrelativoDocumento objCorrelativoDocumento;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_consultaCorrelativoDocumento".concat(PrepararSQL.get(2));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, local);
            ps.setString(2, tipoDocumento);
            rs = ps.executeQuery();

            if (rs.next()) {
                objCorrelativoDocumento = new CorrelativoDocumento();
                objCorrelativoDocumento.setStr_NombreCorto(rs.getString(1));
                objCorrelativoDocumento.setStr_serie(rs.getString(2));
                objCorrelativoDocumento.setInt_correlativo(rs.getInt(3));
                objCorrelativoDocumento.setInt_codigoCorrelativo(rs.getInt(4));

                respuesta = objCorrelativoDocumento.getStr_NombreCorto().concat("-")
                        .concat(objCorrelativoDocumento.getStr_serie()).concat("-").concat(String.valueOf(
                        (objCorrelativoDocumento.getInt_correlativo() + 1)).concat("/").
                        concat(String.valueOf(objCorrelativoDocumento.getInt_codigoCorrelativo())));
            }

        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        }finally{
        	try {
				cnn.close();
			} catch (SQLException e) {
				log.error("Error: " + e.getMessage());
			}
        }

        return respuesta;
    }

    @Override
    public List<Object> listaProformasXCliente(int local, String cliente,String numeroDocumento) {

        List<Object> listaProformas = new ArrayList<>();

        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Proforma objProforma = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_consultaProformaXClienteXLocal".concat(PrepararSQL.get(3));

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, local);
            ps.setString(2, cliente);
            ps.setString(3, numeroDocumento);

            rs = ps.executeQuery();


            while (rs.next()) {
                objProforma = new Proforma();

                objProforma.setNumeroDocumento(rs.getString(1));
                objProforma.setRucdni(rs.getString(2));
                objProforma.setRazonSocial(rs.getString(3));
                objProforma.setSubTotal(rs.getBigDecimal(4));
                objProforma.setIgv(rs.getBigDecimal(5));
                objProforma.setDescuento(rs.getBigDecimal(6));
                objProforma.setTotal(rs.getBigDecimal(7));
                objProforma.setFechaRegistro(rs.getString(8));

                listaProformas.add(objProforma);
            }



        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        }finally{
        	try {
				cnn.close();
			} catch (SQLException e) {
				log.error("Error: " + e.getMessage());
			}
        }


        return listaProformas;
    }

    @Override
    public List<Object> listaDetalleProforma(int local, String documento) {

        List<Object> listaDetalleProformas = new ArrayList<>();

        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_consultaProformasXLocal".concat(PrepararSQL.get(2));

            ps = cnn.prepareStatement(sql);

            ps.setInt(1, local);
            ps.setString(2, documento);

            rs = ps.executeQuery();
            VentasProforma objVentas;
            Producto objProducto;
            Proveedor objProveedor;
            Cliente objCliente;
            Local objLocal;
            UnidadMedida objUnidadMedida;

            while (rs.next()) {

                objVentas = new VentasProforma();

                objProducto = new Producto();
                objProducto.setInt_idProducto(rs.getInt(1));
                objProducto.setStr_nombreProducto(rs.getString(2));
                objProducto.setStr_fabricante(rs.getString(3));
                objVentas.setObjProducto(objProducto);
                objVentas.setInt_idVenta(rs.getInt(4));

                objProveedor = new Proveedor();
                objProveedor.setInt_idProveedor(rs.getInt(5));
                objVentas.setObjProveedor(objProveedor);

                objCliente = new Cliente();
                objCliente.setInt_idCliente(rs.getInt(7));
                objVentas.setObjCliente(objCliente);

                objVentas.setDbCantidad(rs.getBigDecimal(8));
                objVentas.setDbPrecio(rs.getBigDecimal(9));
                objVentas.setDbSubtotal(rs.getBigDecimal(10));
                objVentas.setDbdescuento(rs.getBigDecimal(11));
                objVentas.setDbIGV(rs.getBigDecimal(12));
                objVentas.setDbTotal(rs.getBigDecimal(13));
                objVentas.setStr_numeroDocumento(rs.getString(14));
                objVentas.setStr_usuario(rs.getString(15));
                objVentas.setStr_estado(rs.getString(16));
                objVentas.setStr_clienteResponsable(rs.getString(17));

                objLocal = new Local();
                objLocal.setInt_idLocal(rs.getInt(18));
                objVentas.setObjLocal(objLocal);

                objVentas.setStr_fechaRegistro(rs.getString(19));
                // objVentas.setStr_fechaModificacion(rs.getString(20));
                objVentas.setDbUnidadesContenidas(rs.getBigDecimal(20));

                objVentas.setDbl_precio2(rs.getBigDecimal(21));
                objVentas.setDbStock(rs.getBigDecimal(22));


                objUnidadMedida = new UnidadMedida();
                objUnidadMedida.setInt_idUnidadMedida(rs.getInt(26));
                objUnidadMedida.setStr_nombreUM(rs.getString(27));
                objVentas.setObjUnidadMedida(objUnidadMedida);
                listaDetalleProformas.add(objVentas);

            }

        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        }finally{
        	try {
				cnn.close();
			} catch (SQLException e) {
				log.error("Error: " + e.getMessage());
			}
        }

        return listaDetalleProformas;

    }

    @Override
    public List<ImprimirVenta> listaVenta(String nroDocumento) {
        Connection cnn = null;
        ArrayList<ImprimirVenta> lista = new ArrayList<>();

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "CALL sp_imprimirVenta" + PrepararSQL.get(1);
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, nroDocumento);
            ResultSet rs = ps.executeQuery();

            ImprimirVenta objImprimir;

            while (rs.next()) {
                objImprimir = new ImprimirVenta();

                objImprimir.setStr_codigo(rs.getString(1));
                objImprimir.setDbl_cantidad(rs.getBigDecimal(2));
                objImprimir.setStr_unidadMedida(rs.getString(3));
                objImprimir.setStr_producto(rs.getString(4));
                objImprimir.setDbl_subTotal(rs.getBigDecimal(5));
                objImprimir.setDbl_descuento(rs.getBigDecimal(6));
                objImprimir.setDbl_total(rs.getBigDecimal(7));
                objImprimir.setStr_vendedor(rs.getString(8));
                objImprimir.setStr_rasonSocial(rs.getString(9));
                objImprimir.setStr_ruc(rs.getString(10));
                objImprimir.setStr_direccion(rs.getString(11));
                objImprimir.setFch_fecha(rs.getString(12));
                objImprimir.setDbl_precioUnit(rs.getBigDecimal(13));
                objImprimir.setDbl_sumaSubTotal(rs.getBigDecimal(14));
                objImprimir.setDbl_sumaDescuento(rs.getBigDecimal(15));
                objImprimir.setDbl_sumaTotal(rs.getBigDecimal(16));
                objImprimir.setDbl_sumaIGV(rs.getBigDecimal(17));
                objImprimir.setStr_nombre(rs.getString(18));


                //agregamos al cliente al arreglo
                lista.add(objImprimir);
            }
        } catch (SQLException ex) {
            log.error("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error SQL: " + ex.getMessage());
        } finally {
            try {
                ConexionSql.cerrarConexion(cnn);
            } catch (SQLException ex) {
                log.error("Error al Intentar Cerrar la BD: " + ex.getMessage());
            }
        }
        return lista;
    }

    @Override
    public boolean enviarProformaVentas(String documento, int local) {

        boolean respuesta = false;

        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            String sql = "call sp_proformaToVenta".concat(PrepararSQL.get(3));

            ps = cnn.prepareStatement(sql);

            ps.setString(1, documento);

            String numDocumento = consultaUltimoTemporal(local);

            if (documento.split("-")[2].equals(Util.BOLETA)) {
                numDocumento += "-" + (Util.BOLETA);
            } else {
                numDocumento += "-" + (Util.FACTURA);
            }

            ps.setString(2, numDocumento);
            ps.setInt(3, local);

            rs = ps.executeQuery();

            List<Object> lista = new ArrayList<>();
            Ventas objVentas = null;
            Producto objProducto;
            Proveedor objProveedor;
            Cliente objCliente;
            Local objLocal;


            while (rs.next()) {
                objVentas = new Ventas();

                objVentas.setInt_idVenta(rs.getInt(1));

                objProveedor = new Proveedor();
                objProveedor.setInt_idProveedor(rs.getInt(2));
                objVentas.setObjProveedor(objProveedor);

                objProducto = new Producto();
                objProducto.setInt_idProducto(rs.getInt(3));
                objVentas.setObjProducto(objProducto);

                objCliente = new Cliente();
                objCliente.setInt_idCliente(rs.getInt(4));
                objVentas.setObjCliente(objCliente);

                objVentas.setDbCantidad(rs.getBigDecimal(5));
                objVentas.setDbPrecio(rs.getBigDecimal(6));
                objVentas.setDbSubtotal(rs.getBigDecimal(7));
                objVentas.setDbdescuento(rs.getBigDecimal(8));
                objVentas.setDbIGV(rs.getBigDecimal(9));
                objVentas.setDbTotal(rs.getBigDecimal(10));
                objVentas.setStr_numeroDocumento(rs.getString(11));
                objVentas.setStr_usuario(rs.getString(12));
                objVentas.setStr_estado(rs.getString(13));
                objVentas.setStr_clienteResponsable(rs.getString(14));

                objLocal = new Local();
                objLocal.setInt_idLocal(rs.getInt(15));
                objVentas.setObjLocal(objLocal);

                objVentas.setStr_fechaRegistro(rs.getString(16));
                objVentas.setStr_fechaModificacion(rs.getString(17));
                objVentas.setDbUnidadesContenidas(rs.getBigDecimal(18));

                lista.add(objVentas);

            }


            cnn.commit();
            respuesta = true;
            Almacen objAlmacen;
            List<Almacen> listaAlmacen = new ArrayList<>();
            TipoMovimiento objTipoMovimiento;


            for (Object object : lista) {

                objVentas = (Ventas) object;
                objAlmacen = new Almacen();

                objAlmacen.setObjProveedor(objVentas.getObjProveedor());
                objAlmacen.setObjProducto(objVentas.getObjProducto());
                objAlmacen.setObjLocal(objVentas.getObjLocal());

                objTipoMovimiento = new TipoMovimiento();
                objTipoMovimiento.setInt_idTipoMovimiento(Util.SALIDAXVENTA);
                objAlmacen.setObjTipoMovimiento(objTipoMovimiento);
                objAlmacen.setStr_documento(objVentas.getStr_numeroDocumento());
                objAlmacen.setDbl_cantidad(objVentas.getDbCantidad().multiply(new BigDecimal(-1)));
                objAlmacen.setDbl_precio(objVentas.getDbPrecio());
                objAlmacen.setDbl_igv(objVentas.getDbIGV());
                objAlmacen.setDbl_descuento(objVentas.getDbdescuento());
                objAlmacen.setDbl_subTotal(objVentas.getDbSubtotal());
                objAlmacen.setStr_fechaDocumento(PaqueteBusinessDelegate.getUtilMysqlServices().getFechaMysql());
                objAlmacen.setStr_estado(Util.ACTIVO);
                objAlmacen.setStr_usuarioCreador(objVentas.getStr_usuario());

                listaAlmacen.add(objAlmacen);
            }

            PaqueteBusinessDelegate.getAlmacenService().registrarAlmacen(listaAlmacen);


        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
            try {
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
            try {
                cnn.rollback();
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        }finally{
        	try {
				cnn.close();
			} catch (SQLException e) {
				log.error("Error: " + e.getMessage());
			}
        }

        return respuesta;
    }

    @Override
    public boolean eliminarVenta(Ventas objV) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            sql = "CALL sp_anularVenta".concat(PrepararSQL.get(3));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objV.getInt_idVenta());
            ps.setString(2, Util.ANULADO);
            ps.setString(3, Util.INACTIVO);
            ps.execute();

            cnn.commit();
            respuesta = true;
        } catch (SQLException ex) {
            try {
                cnn.rollback();
                log.error("Error SQL: " + ex.getMessage());
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            try {
                cnn.rollback();
                log.error("Error: " + ex.getMessage());
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error: " + ex1.getMessage());
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

    @Override
    public List<Object> consultaVentaXDocumento(String documento, int local) {
        Connection cnn = null;
        List<Object> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

            String sql = "call sp_consultaVentaXDocumento".concat(PrepararSQL.get(2));
            ps = cnn.prepareStatement(sql);
            ps.setString(1, documento);
            ps.setInt(2, local);
            rs = ps.executeQuery();

            Ventas objVentas;
            Producto objProducto;
            Cliente objCliente;

            while (rs.next()) {
                objVentas = new Ventas();
                objCliente = new Cliente();
                objProducto = new Producto();

                objCliente.setStr_rucdni(rs.getString(1));
                objCliente.setStr_razonSocial(rs.getString(2));
                objCliente.setStr_direccion(rs.getString(3));

                objVentas.setObjCliente(objCliente);
                objVentas.setStr_numeroDocumento(rs.getString(4));
                objVentas.setStr_fechaRegistro(rs.getString(5));
                objVentas.setStr_usuario(rs.getString(6));

                objProducto.setStr_codigoInterno(rs.getString(7));
                objProducto.setStr_nombreProducto(rs.getString(8));

                objVentas.setObjProducto(objProducto);
                objVentas.setDbCantidad(rs.getBigDecimal(9));
                objVentas.setDbPrecio(rs.getBigDecimal(10));
                objVentas.setDbSubtotal(rs.getBigDecimal(11));
                objVentas.setDbdescuento(rs.getBigDecimal(12));
                objVentas.setDbIGV(rs.getBigDecimal(13));

                lista.add(objVentas);
            }

        } catch (SQLException ex) {
            log.error("Error: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Error: " + ex.getMessage());
        }finally{
        	try {
				cnn.close();
			} catch (SQLException e) {
				log.error("Error: " + e.getMessage());
			}
        }

        return lista;
    }

    @Override
    public List<Object> consultaVentasXVendedor(int local, String vendedor) {
        List<Object> lista = new ArrayList<>();
        return lista;
    }

    @Override
    public boolean anularDocVenta(Ventas objV, FlujoCaja objFlujoCaja, List<Almacen> listaA) {
        boolean respuesta = false;
        Connection cnn = null;
        String sql = "";
        PreparedStatement ps = null;

        try {
            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();
            cnn.setAutoCommit(false);

            sql = "CALL sp_anularDocumentoVenta".concat(PrepararSQL.get(2));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objV.getInt_idVenta());
            ps.setString(2, Util.ANULADO);
            ps.execute();

            sql = "CALL sp_insertFlujoCaja".concat(PrepararSQL.get(10));
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, objFlujoCaja.getObjLocal().getInt_idLocal());
            ps.setInt(2, objFlujoCaja.getObjCaja().getInt_idCaja());
            ps.setBigDecimal(3, objFlujoCaja.getDbl_cantidadSoles());
            ps.setBigDecimal(4, objFlujoCaja.getDbl_cantidadDolares());
            ps.setBigDecimal(5, objFlujoCaja.getDbl_cantidadTotalSoles());
            ps.setString(6, objFlujoCaja.getStr_motivo());
            ps.setString(7, Util.ACTIVO);
            ps.setString(8, objFlujoCaja.getStr_usuarioCreador());
            ps.setString(9, objFlujoCaja.getStr_nroDocumento());
            ps.setString(10, objFlujoCaja.getStr_numeroSerie());
            ps.execute();

            sql = "CALL sp_insertAlmacenDocAnulado".concat(PrepararSQL.get(12));
            for (Almacen objAlmacen : listaA) {
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, objAlmacen.getObjProveedor().getInt_idProveedor());
                ps.setInt(2, objAlmacen.getObjProducto().getInt_idProducto());
                ps.setInt(3, objAlmacen.getObjLocal().getInt_idLocal());
                ps.setInt(4, objAlmacen.getObjTipoMovimiento().getInt_idTipoMovimiento());
                ps.setString(5, objAlmacen.getStr_documento());
                ps.setBigDecimal(6, objAlmacen.getDbl_cantidad());
                ps.setBigDecimal(7, objAlmacen.getDbl_precio());
                ps.setBigDecimal(8, objAlmacen.getDbl_igv());
                ps.setBigDecimal(9, objAlmacen.getDbl_subTotal());
                ps.setBigDecimal(10, objAlmacen.getDbl_descuento());
//                ps.setString(11, objAlmacen.getStr_fechaDocumento());
                ps.setString(11, objAlmacen.getStr_estado());
                ps.setString(12, objAlmacen.getStr_usuarioCreador());
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
                log.error("Error-: " + ex1.getMessage());
            }
        } catch (Exception ex) {
            try {
                cnn.rollback();
                log.error("Error--: " + ex.getMessage());
                respuesta = false;
            } catch (SQLException ex1) {
                log.error("Error---: " + ex1.getMessage());
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

	@Override
	public String prefijoXlocalxTipoDocumento(int local, int tipoDocumento) {
		 	Connection cnn = null;
	        String prefijo = "";
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	            cnn = Objects.equals(Globales.TIPO_CONEXION, Constantes.JDBC)?                    ConexionSql.getConexion():this.getDataSource().getConnection();

	            String sql = "call sp_consultaPrefijoDocumentoXLocalXtipoDocumneto".concat(PrepararSQL.get(2));
	            ps = cnn.prepareStatement(sql);
	            ps.setInt(1, local);
	            ps.setInt(2, tipoDocumento);
	            rs = ps.executeQuery();

	            

	            while (rs.next()) {
	            	prefijo = rs.getString(1);
	            }

	        } catch (SQLException ex) {
	            log.error("Error: " + ex.getMessage());
	        } catch (Exception ex) {
	            log.error("Error: " + ex.getMessage());
	        }finally{
	        	try {
					cnn.close();
				} catch (SQLException e) {
					log.error("Error: " + e.getMessage());
				}
	        }

	        return prefijo;
	}
    
}
