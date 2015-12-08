package com.iqfarma.sgfmf.activity;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.serialization.SoapObject;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.bean.Persona;
import com.iqfarma.sgfmf.util.Util;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class PrincipalActivity extends ActionBarActivity implements
		LocationListener {

	LocationManager handle; // Gestor del servicio de localización
	private boolean servicioActivo;

	private Button botonActivar;
	private TextView longitud;
	private TextView latitud;
	private TextView proveedor;
	private String provider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);

		botonActivar = (Button) findViewById(R.id.BotonActivar);
		latitud = (TextView) findViewById(R.id.lbl_latitud);
		longitud = (TextView) findViewById(R.id.lbl_longitud);
		proveedor = (TextView) findViewById(R.id.lbl_proveedor);

		servicioActivo = false;
		// El botón activar permitirá activar y desactivar el servicio.
		botonActivar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				if (servicioActivo) {
					try {
						pararServicio();
					} catch (Exception e) {
						Toast.makeText(getBaseContext(), "pararServicio() - " + e.getClass().getSimpleName() + " - " + e.getMessage(), Toast.LENGTH_SHORT).show();
					}

				} else {
					try {
						iniciarServicio();
					} catch (Exception e) {
						Toast.makeText(getBaseContext(), "iniciarServicio() - " + e.getClass().getSimpleName() + " - " + e.getMessage(), Toast.LENGTH_SHORT).show();
					}
				}
			}
		});

	}

	public void pararServicio() {
		servicioActivo = false;
		botonActivar.setText("activar");
		handle.removeUpdates(this);
	}

	public void iniciarServicio() {
		servicioActivo = true;
		botonActivar.setText("desactivar");

		handle = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		Criteria criteria = new Criteria();
		criteria.setCostAllowed(false);
	    criteria.setAltitudeRequired(false);
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		
		// obtiene el mejor proveedor en función del criterio asignado
		// (la mejor precisión posible)
		provider = handle.getBestProvider(criteria, true);
		
		List<String> proveedores = handle.getAllProviders();
		String s = "";
		for (String string : proveedores) {
			s += string + " - ";
		}

		if(provider==null){
			provider = LocationManager.NETWORK_PROVIDER;
		}
		proveedor.setText(provider);
		
		int power = handle.getProvider(provider).getPowerRequirement();
		
		Toast.makeText(getBaseContext(), s.substring(0, s.length()) + " / power: " + power, Toast.LENGTH_LONG).show();
		
		// Se activan las notificaciones de localización con los parámetros:
		// proveedor, tiempo mínimo de actualización, distancia mínima,
		// Locationlistener
		handle.requestLocationUpdates(provider, 10000, 1, this);
		
		// Obtenemos la última posición conocida dada por el proveedor
		Location loc = handle.getLastKnownLocation(provider);
		muestraPosicionActual(loc);
	}

	public void muestraPosicionActual(Location loc) {
		if (loc == null) {
			latitud.setText("Desconocida");
			longitud.setText("Desconocida");
		} else {
			Toast.makeText(getBaseContext(), "getAccuracy: " + loc.getAccuracy(), Toast.LENGTH_LONG).show();
			latitud.setText(String.valueOf(loc.getLatitude()));
			longitud.setText(String.valueOf(loc.getLongitude()));
		}
	}

	public void connect() {
		try {
			SoapObject soapObject = Util.consumirSOAP("Sincronizar", null);

			boolean exito = Boolean.parseBoolean(soapObject
					.getProperty("exito").toString());

			if (exito) {

				List<Persona> personas = new ArrayList<Persona>();

				SoapObject soapObject2 = (SoapObject) soapObject
						.getProperty("personas");

				for (int i = 0; i < soapObject2.getPropertyCount(); i++) {

					SoapObject soapObject3 = (SoapObject) soapObject2
							.getProperty(i);

					Persona persona = new Persona();
					persona.setId(Long.parseLong(soapObject3.getProperty("Id")
							.toString()));
					persona.setNombres(soapObject3.getProperty("nombres")
							.toString());
					persona.setApellidos(soapObject3.getProperty("apellidos")
							.toString());
					persona.setEdad(Integer.parseInt(soapObject3.getProperty(
							"edad").toString()));

					personas.add(persona);
				}

				Log.i("personas", "" + personas.toArray());

			} else {
				String mensaje = soapObject.getProperty("mensaje").toString();
				Log.i("mensaje", mensaje);
			}

		} catch (Exception e) {
			Log.e("error", e.getMessage());
		}

		/*
		 * boolean exito = (boolean) soapObject.getProperty("exito"); String
		 * mensaje = (String)soapObject.getProperty("mensaje"); List<Persona>
		 * personas = (List<Persona>)soapObject.getProperty("personas");
		 */
		// Log.i("respuesta", respuesta.toString());

		/*
		 * String url =
		 * "http://10.200.69.51:8082/Presentacion-Spring-MVC-Rest/rest1/personas"
		 * ; HashMap<String, String> parameters = new HashMap<String, String>();
		 * String result = ""; try{ result = Util.getResponseBody(url,
		 * MediaType.TEXT_PLAIN, HttpMethod.GET, null); Log.d("result", result);
		 * }catch(Exception e){ Log.e("error", e.getMessage()); }
		 * 
		 * Type type = new TypeToken<Respuesta>(){}.getType(); Respuesta
		 * respuesta = (Respuesta)Util.toGenericObject(result, type);
		 * Log.d("respuesta", respuesta.toString());
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onLocationChanged(Location location) {
		muestraPosicionActual(location);
	}

	@Override
	public void onProviderDisabled(String arg0) {
		//Toast.makeText(getBaseContext(), arg0, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onProviderEnabled(String arg0) {
		//Toast.makeText(getBaseContext(), arg0, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		//Toast.makeText(getBaseContext(), arg0 + " - " + arg1, Toast.LENGTH_SHORT).show();
	}
}
