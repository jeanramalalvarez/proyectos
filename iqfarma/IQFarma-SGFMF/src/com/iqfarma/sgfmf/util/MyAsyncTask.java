package com.iqfarma.sgfmf.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.iqfarma.sgfmf.bean.Farmacia;
import com.iqfarma.sgfmf.bean.Medico;
import com.iqfarma.sgfmf.bean.Motivo;
import com.iqfarma.sgfmf.bean.Producto;
import com.iqfarma.sgfmf.bean.Usuario;
import com.iqfarma.sgfmf.dao.FarmaciaDao;
import com.iqfarma.sgfmf.dao.MedicoDao;
import com.iqfarma.sgfmf.dao.MotivoDao;
import com.iqfarma.sgfmf.dao.ProductoDao;
import com.iqfarma.sgfmf.dao.UsuarioDao;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class MyAsyncTask extends AsyncTask<Integer, Integer, Boolean> {
	
	private Context context;
	
	private ProgressDialog progressDialog;
	
	private Intent intent;
	
	private MedicoDao medicoDao;
	
	private FarmaciaDao farmaciaDao;
	
	private UsuarioDao usuarioDao;
	
	private ProductoDao productoDao;
	
	private MotivoDao motivoDao;
	
	private boolean agregarContexto;
	
	private boolean finalizarActividad;
	
	private boolean exito;
	
	private String mensaje;
	
	public Usuario usuario;
	
	public Medico medico;
	
	public Farmacia farmacia;
	
	public List<Producto> productos;
	
	public String observacion;
	
	public Long idMotivo;
	
	public MyAsyncTask() {
	}
	
	public MyAsyncTask(Context context, Intent intent) {
		this.context = context;
		this.intent = intent;
	}
	
	public MyAsyncTask(Context context, Intent intent, boolean finalizarActividad) {
		this.context = context;
		this.intent = intent;
		this.finalizarActividad = finalizarActividad;
	}
	
	public MyAsyncTask(Context context, Intent intent, boolean finalizarActividad, boolean agregarContexto) {
		this.context = context;
		this.intent = intent;
		this.finalizarActividad = finalizarActividad;
		this.agregarContexto = agregarContexto;
	}
	
	@Override
    protected void onPreExecute(){
		progressDialog = ProgressDialog.show(context, "", Constantes.MyAsyncTask.CARGANDO);
    }

	@Override
	protected Boolean doInBackground(Integer... params) {
		if (params == null){return false;}
		try {
			
			switch (params[0]) {
			
			case Constantes.MyAsyncTask.LOGIN:
				irLogin();
				break;
			case Constantes.MyAsyncTask.MENU_MEDICOS:
				irMedicos();
				break;
			case Constantes.MyAsyncTask.MENU_MEDICOS_MALLA_PROMOCIONAL:
				irMallaPromocional();
				break;
			case Constantes.MyAsyncTask.MENU_MEDICOS_REGISTRAR_VISITA:
				registrarVisita();
				break;
			case Constantes.MyAsyncTask.MENU_MEDICOS_NO_VISITA:
				irNoVisita();
				break;
			case Constantes.MyAsyncTask.MENU_MEDICOS_REGISTRAR_NO_VISITA:
				registrarNoVisita();
				break;
			case Constantes.MyAsyncTask.MENU_MEDICOS_PRESCRIPCION:
				irPrescripcion();
				break;
			case Constantes.MyAsyncTask.MENU_MEDICOS_ACTUALIZAR:
				actualizarMedico();
				break;
			case Constantes.MyAsyncTask.MENU_FARMACIAS:
				irFarmacias();
				break;
			case Constantes.MyAsyncTask.MENU_FARMACIAS_PRODUCTOS:
				irProductos();
				break;
			case Constantes.MyAsyncTask.MENU_FARMACIAS_NO_PEDIDO:
				irNoPedido();
				break;
			case Constantes.MyAsyncTask.MENU_FARMACIAS_REGISTRAR_NO_PEDIDO:
				registrarNoPedido();
				break;
			case Constantes.MyAsyncTask.MENU_AVANCES:
				irAvances();
				break;
			}

		} catch (Exception e) {
			Log.e("error", " Se produjo un error " + e.getMessage() + " " + e.getCause());
			return false;
		}
		return true;
	}

	@Override
    protected void onPostExecute(Boolean result){
		progressDialog.dismiss();
		
		if(result){
			if(exito){
				if(agregarContexto){
					Util.addContext(context);
				}
				if (finalizarActividad) {
					((Activity)this.context).finish();
				}
				if(intent!=null) {
					if(mensaje != null){
						intent.putExtra("mensajeToad", mensaje);
					}
					context.startActivity(intent);
				}
			}else{
				if(mensaje != null){
					Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show();
				}
			}
		}else{
		   Toast.makeText(context, "Se produjo un error", Toast.LENGTH_SHORT).show();
		}

	}
	
	private void irLogin(){
		usuarioDao = new UsuarioDao();
		usuario = usuarioDao.login(usuario);
		
		if(usuario != null){
			mensaje = Constantes.Mensaje.TOAST_MENU_BIENVENIDO + " Christian Figueroa";
			exito = true;	
		}else{
			mensaje = Constantes.Mensaje.TOAST_LOGIN_USUARIO_CONTRASENA_INCORRECTOS;
		}
	}
	
	private void irMedicos(){
		medicoDao = new MedicoDao();
		ArrayList<Medico> medicos = (ArrayList<Medico>)medicoDao.listar();
		if(medicos != null && medicos.size()>0){
			intent.putExtra("medicos", medicos);
			exito = true;	
		}else{
			mensaje = Constantes.Mensaje.TOAST_MEDICO_NO_EXISTEN_MEDICOS;
		}
	}
	
	private void irMallaPromocional() {
		productoDao = new ProductoDao();
		ArrayList<Producto> productos = (ArrayList<Producto>)productoDao.obtenerProductosPorMedico(medico);
		if(productos != null && productos.size()>0){
			intent.putExtra("productos", productos);
			exito = true;
		}else{
			mensaje = Constantes.Mensaje.TOAST_MALLA_NO_EXISTE_MALLA;
		}
	}
	
	private void registrarVisita() {
		mensaje = Constantes.Mensaje.TOAST_VISITA_REGISTRO_CORRECTO;
		exito = true;
	}
	
	private void irNoVisita() {
		productoDao = new ProductoDao();
		motivoDao = new MotivoDao();
		ArrayList<Motivo> motivos = (ArrayList<Motivo>)motivoDao.listar();
		intent.putExtra("motivos", motivos);
		exito = true;
	}
	
	private void registrarNoVisita() {
		Log.d("medico", "" + medico);
		mensaje = Constantes.Mensaje.TOAST_NO_VISITA_REGISTRO_CORRECTO;;
		exito = true;
	}
	
	private void irFarmacias() {
		farmaciaDao = new FarmaciaDao();
		ArrayList<Farmacia> farmacias = (ArrayList<Farmacia>)farmaciaDao.listar();
		if(farmacias != null && farmacias.size()>0){
			intent.putExtra("farmacias", farmacias);
			exito = true;	
		}else{
			mensaje = Constantes.Mensaje.TOAST_MEDICO_NO_EXISTEN_FARMACIAS;
		}
	}
	
	private void irProductos() {
		productoDao = new ProductoDao();
		ArrayList<Producto> productos = (ArrayList<Producto>)productoDao.listar();
		if(productos != null && productos.size()>0){
			intent.putExtra("productos", productos);
			exito = true;	
		}else{
			mensaje = Constantes.Mensaje.TOAST_NO_EXISTEN_PRODUCTOS;
		}
	}

	private void irNoPedido() {
		motivoDao = new MotivoDao();
		ArrayList<Motivo> motivos = (ArrayList<Motivo>)motivoDao.listar();
		intent.putExtra("motivos", motivos);
		exito = true;
	}
	
	private void registrarNoPedido() {
		Log.d("farmacia", "" + farmacia);
		mensaje = Constantes.Mensaje.TOAST_NO_PEDIDO_REGISTRO_CORRECTO;;
		exito = true;
	}
	
	private void irAvances(){
		medicoDao = new MedicoDao();
		farmaciaDao = new FarmaciaDao();
		intent.putExtra("avancesMedicos", medicoDao.avances());
		intent.putExtra("avancesFarmacias", farmaciaDao.avances());
		exito = true;
	}
	
	private void irPrescripcion() {
		exito = true;
	}
	
	private void actualizarMedico() {
		medicoDao = new MedicoDao();
		medico = medicoDao.actualizar(medico);
		if(medico != null){
			intent.putExtra("medico", medico);
			mensaje = Constantes.Mensaje.TOAST_MEDICO_ACTUALIZACION_CORRECTA;
			exito = true;
		}else{
			mensaje = Constantes.Mensaje.TOAST_MEDICO_ACTUALIZACION_INCORRECTA;
		}
	}

}