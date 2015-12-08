package com.iqfarma.sgfmf.util;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.activity.LoginActivity;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class Util {
	
	/**
	 * Metodo para consumir web service SOAP.
	 * @param metodo nombre del metodo del web service a consumir.
	 * @param parametros parametros del metodo del web service.
	 * @return resultado del web service en soapObject.
	 * */
	public static SoapObject consumirSOAP(String metodo, HashMap<String, Object> parametros){
		
		SoapObject respuesta = new SoapObject();
		
		try{
			
			SoapObject request = new SoapObject(Constantes.Soap.NAMESPACE, metodo);
			
			if(parametros != null){
				for(Entry<String, Object> parametro: parametros.entrySet()){
					request.addProperty(parametro.getKey(), parametro.getValue());
				}
			}
	
		    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		    envelope.dotNet = true;
		    envelope.setOutputSoapObject(request);
	
		    HttpTransportSE transporte = new HttpTransportSE(Constantes.Soap.URL);
	
		    transporte.call(Constantes.Soap.SOAP_ACTION + metodo, envelope);
		    
		    respuesta = (SoapObject)envelope.getResponse();
		    
		}
		catch(HttpResponseException e){
			Log.e(e.getClass().getSimpleName(), e.getMessage());
			respuesta.addProperty("exito", "false");
			respuesta.addProperty("mensaje", Constantes.Mensaje.ERROR_SERVIDOR_RESPONSE);
		}
		catch(SocketTimeoutException e){
			Log.e(e.getClass().getSimpleName(), e.getMessage());
			respuesta.addProperty("exito", "false");
			respuesta.addProperty("mensaje", Constantes.Mensaje.ERROR_SERVIDOR_TIMEOUT);
		}
		catch(IOException e){
			Log.e(e.getClass().getSimpleName(), e.getMessage());
			respuesta.addProperty("exito", "false");
			respuesta.addProperty("mensaje", "Error de conexion con el servidor 2");
		}
		catch(XmlPullParserException e){
			Log.e(e.getClass().getSimpleName(), e.getMessage());
			respuesta.addProperty("exito", "false");
			respuesta.addProperty("mensaje", Constantes.Mensaje.ERROR_SERVIDOR_PARSE);
		}
		catch(Exception e){
			Log.e(e.getClass().getSimpleName(), e.getMessage());
			respuesta.addProperty("exito", "false");
			respuesta.addProperty("mensaje", Constantes.Mensaje.ERROR_SERVIDOR_CONEXION);
		}
		
		return respuesta;
	}
	
	/**
	 * Metodo para convertir un objeto a json
	 * @param object objeto a convertir.
	 * @return json string.
	 * */
	public static <T> String toJson(T object){
   		Gson gson=new Gson();
		return gson.toJson(object);
	}
	
	/**
	 * Metodo para convertir un objeto a json
	 * @param object objeto a convertir.
	 * @param withNulls indicador para motrar campos nulos
	 * @return json string.
	 * */
	public static <T> String toJson(T object, boolean withNulls){
		Gson gson = null;
		if(withNulls)
			gson=new GsonBuilder().serializeNulls().create();
		else
			gson=new Gson();
		return gson.toJson(object);
	}

	/**
	 * Metodo para convertir json a objecto
	 * @param json string
	 * @param clazz class del objeto.
	 * @return objeto.
	 * */
	public static <T> T fromJson(String json, Class<T> clazz){
		Gson gson = new Gson();
 		return gson.fromJson(json, clazz);
 	}

	/**
	 * Metodo para verificar si se tiene conexion a la red.
	 * @param context
	 * @return indicador tru si existe, false si no existe conexion.
	 */
	public static boolean verificarConexion(Context context) {
	    
		boolean resultado = false;
	    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo[] redes = connectivityManager.getAllNetworkInfo();
	    
	    for (int i = 0; i < redes.length; i++) {
	    	Log.d("networks", redes[i].getTypeName());
	        if (redes[i].getState() == NetworkInfo.State.CONNECTED){
	        	resultado = true;
	        }
	    }
	    
	    return resultado;
	}
	
	public static boolean onCreateOptionsMenu(MenuInflater menuInflater, Menu menu){
		menuInflater.inflate(R.menu.menu, menu);
		return true;
	}
	
	public static boolean onOptionsItemSelected(Context context, MenuItem item){
		
		int id = item.getItemId();
		
		if (id == R.id.action_salir) {
			Log.d("logout", "salir");
			SesionUsuario.sesionActiva = false;
			
			Intent intent = new Intent(context,LoginActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("EXIT", true);
			context.startActivity(intent);
			((Activity)context).finish();
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Metodo para crear menú.
	 * @param context contexto.
	 * @param tipo principal.
	 * @return SimpleAdater adaptador para agregarlo al listView.
	 */
	public static SimpleAdapter crearMenuSimple(Context context, int tipo){
		String[] menuTexto = null;
		int[] menuImagen = null;
		switch (tipo) {
		case Constantes.Menu.PRINCIPAL:
			menuTexto = Constantes.Menu.PRINCIPAL_MENU_TEXTO;
			menuImagen = Constantes.Menu.PRINCIPAL_MENU_IMAGEN;
			break;
		case Constantes.Menu.SINCRONIZACION:
			menuTexto = Constantes.Menu.SINCRONIZACION_MENU_TEXTO;
			menuImagen = Constantes.Menu.SINCRONIZACION_MENU_IMAGEN;
			break;
		default:
			return null;
		}
		
		List<HashMap<String,String>> menus = new ArrayList<HashMap<String,String>>();        
        
        for( int i=0; i<menuTexto.length; i++ ){
        	HashMap<String, String> itemMenu = new HashMap<String,String>();
        	itemMenu.put("menuImagen", Integer.toString(menuImagen[i]) );
        	itemMenu.put("menuTexto", menuTexto[i]);
            menus.add(itemMenu);
        }

        String[] from = { "menuImagen","menuTexto"};

        int[] to = { R.id.iv_menu_imagen,R.id.lbl_menu_texto};        

        SimpleAdapter adapter = new SimpleAdapter(context, menus, R.layout.menu_layout, from, to);
        return adapter;
		
	}
	 
	/**
	 * Metodo para crear dialogo de confirmacion.
	 * @param context contexto.
	 * @param mesage mensaje.
	 * @param yesAction accion a realizar si es positivo.
	 * @return AlertDialog dialog.
	 */
	public static AlertDialog createConfirmationDialog(Context context, 
			                                            String message, 
			                                            DialogInterface.OnClickListener yesAction) {
		 
		 return new AlertDialog.Builder(context).setMessage(message)
				 .setPositiveButton("Si", yesAction)
	             .setNegativeButton("No", new DialogInterface.OnClickListener() {
	            	 @Override
	                 public void onClick(DialogInterface dialogInterface, int i) {
	            		 dialogInterface.cancel();
	            	 }
	             }).create();
	 }
	
	/**
	 * Metodo para crear dialogo de confirmacion con campo para ingregar valor.
	 * @param context contexto.
	 * @param mesage mensaje.
	 * @param input caja de texto.
	 * @param yesAction accion a realizar si es positivo.
	 * @return AlertDialog dialog.
	 */
	public static AlertDialog createConfirmationDialog(Context context, 
			                                            String message, 
			                                            EditText input,
			                                            DialogInterface.OnClickListener yesAction) {

		return new AlertDialog.Builder(context).setMessage(message).setView(input)
				.setPositiveButton("Aceptar", yesAction)
				.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
					dialogInterface.cancel();
					}
				}).create();
	}
	 
	public static TextView getTextViewCantidadToListViewProductoMalla(View view){
		LinearLayout linearLayout = (LinearLayout)view.getParent();
		LinearLayout linearLayout2 = (LinearLayout)linearLayout.getParent();
		TextView textView = (TextView)linearLayout2.getChildAt(1);
		return textView;
	}
	
	public static TextView getTextViewPositionToListViewProductoMalla(View view){
		return getTextViewSiblingOnListView(view, 0);
	}
	
	public static TextView getTextViewIdMotivoOfListViewMotivoNoVisita(View view){
		return getTextViewSiblingOnListView(view, 1);
	}
	
	/**
	 * Metodo que obtiene un textView hermano dentro de un listview indicandole el indice.
	 * @param view item del listView
	 * @param index indice del hermano a obtener
	 * @return TextView
	 * */
	public static TextView getTextViewSiblingOnListView(View view, int index){
		LinearLayout linearLayout = (LinearLayout)view.getParent();
		TextView textView = (TextView)linearLayout.getChildAt(index);
		return textView;
	}
	
	/**
	 * Metodo para obtener el valor entero del texto.
	 * @param context textView.
	 * @return int valor.
	 */
	public static int parseIntFromTextView(TextView textView){
		try{
			return Integer.parseInt(textView.getText().toString());	
		}catch(Exception e){
			return 0;
		}
	}
	
	/**
	 * Metodo para obtener el valor long del texto.
	 * @param context textView.
	 * @return int valor.
	 */
	public static long parseLongFromTextView(TextView textView){
		try{
			return Long.parseLong(textView.getText().toString());	
		}catch(Exception e){
			return 0;
		}
	}
	
	/**
	 * Metodo para agregar el contexto a la lista de contextos. 
	 * La lista de contextos es utilizada para poder finalizar todas las actividades que se tengan en el historial
	 * al momento de salir. 
	 * */
	public static void addContext(Context context){
		Log.d("contextos", "" + SesionUsuario.contextos.size());
		SesionUsuario.contextos.add(context);
		Log.d("contextos", "" + SesionUsuario.contextos.size());
	}
	
	/**
	 * Metodo para finalizar y limpiar todos los contextos.
	 * La lista de contextos es utilizada para poder finalizar todas las actividades que se tengan en el historial
	 * al momento de salir. 
	 * */
	public static void limpiarContextos(){
		Log.d("contextos", "" + SesionUsuario.contextos.size());
		
		for(Context constext : SesionUsuario.contextos){
			try{
				((Activity)constext).finish();
			}catch(Exception e){Log.e(e.getClass().getSimpleName(), e.getMessage());}
		}
		SesionUsuario.contextos.clear();
	}
	
	/**
	 * Metodo para obtener la fecha en cadena con el formato: 15 de Julio de 2014.
	 * @param date fecha.
	 * @return String fecha.
	 */
	public static String dateFormatLong(Date date){
		SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
		return formateador.format(date);
	}
	
	/**
	 * Metodo para obtener la fecha en cadena con el formato: 15/08/2014.
	 * @param date fecha.
	 * @return String fecha.
	 */
	public static String dateToString(Date date){
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy", new Locale("es_PE"));		
		return formateador.format(date);
	}
	
	/**
	 * Metodo para obtener la fecha en cadena.
	 * @param date fecha.
	 * @param template formato.
	 * @return String fecha.
	 */
	public static String dateToString(Date date, String template){
		SimpleDateFormat formateador = new SimpleDateFormat(template, new Locale("es_PE"));		
		return formateador.format(date);
	}
	
	/**
	 * Metodo para obtener la fecha en cadena con el formato: 15/08/2014.
	 * @return String fecha.
	 */
	public static String dateToString(){
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy", new Locale("es_PE"));		
		return formateador.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * Metodo para obtener la fecha en cadena.
	 * @param template formato.
	 * @return String fecha.
	 */
	public static String dateToString(String template){
		SimpleDateFormat formateador = new SimpleDateFormat(template, new Locale("es_PE"));		
		return formateador.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * Metodo para obtener la fecha Date.
	 * @param date fecha en cadena.
	 * @return Date fecha.
	 */
	public static Date stringToDate(String date){
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy", new Locale("es_PE"));		
		try {
			return formateador.parse(date);
		} catch (ParseException e) {
			Log.e(e.getClass().getSimpleName(), e.getMessage());
		}
		return null;
	}
	
	/**
	 * Metodo para obtener la fecha Date.
	 * @param date fecha en cadena.
	 * @param template formato.
	 * @return Date fecha.
	 */
	public static Date stringToDate(String date, String template){
		SimpleDateFormat formateador = new SimpleDateFormat(template, new Locale("es_PE"));		
		try {
			return formateador.parse(date);
		} catch (ParseException e) {
			Log.e(e.getClass().getSimpleName(), e.getMessage());
		}
		return null;
	}

}
