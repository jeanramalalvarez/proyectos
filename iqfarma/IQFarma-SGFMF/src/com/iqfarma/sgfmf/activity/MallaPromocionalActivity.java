package com.iqfarma.sgfmf.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.bean.Producto;
import com.iqfarma.sgfmf.util.Constantes;
import com.iqfarma.sgfmf.util.ProductoMallaAdapter;
import com.iqfarma.sgfmf.util.Util;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
@SuppressWarnings("unchecked")
public class MallaPromocionalActivity extends ActionBarActivity implements OnClickListener {
	
	private Button btnAceptar;
	
	private ListView listView;
	
	private ProductoMallaAdapter productoMallaAdapter;
	
	//private AlertDialog alertDialog;
	
	ArrayList<Producto> productos = new ArrayList<Producto>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_malla_promocional);
		init();
	}

	private void init() {
		
		btnAceptar = (Button) findViewById(R.id.btn_aceptar);
		btnAceptar.setOnClickListener(this);

		List<Producto> productos = (ArrayList<Producto>)getIntent().getSerializableExtra("productos");
		
		productoMallaAdapter = new ProductoMallaAdapter(this, R.layout.malla_promocional_layout, productos);
		listView = (ListView) findViewById(R.id.list);
		listView.setItemsCanFocus(false);
		listView.setAdapter(productoMallaAdapter);
		
		//createConfirmDialog();

	}
	/*
	private void createConfirmDialog(){
		alertDialog = Util.createConfirmationDialog(this, "", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				irObservacion();
			}
		});
	}
	*/	

	@Override
	public void onClick(View view) {
		
		productos.clear();
		
		//String mensaje = "Detalle: \n";
		boolean agregados = false;
		
		for (int i=0; i < productoMallaAdapter.getCount(); i++) {
			Producto producto = productoMallaAdapter.getItem(i);
			if(producto.getCantidad() > 0){
				agregados = true;
				//mensaje +=  producto.getNombre() + " [" + producto.getCantidad() + "] \n";
				productos.add(producto);
			}
		}
		
		if(agregados){
//			mensaje += "Desea continuar?";
//			alertDialog.setMessage(mensaje);
//			alertDialog.show();
			irObservacion();
		}else{
			Toast.makeText(this, Constantes.Mensaje.TOAST_MALLA_AGREGAR_PRODUCTO, Toast.LENGTH_LONG).show();
		}

	}
	
	private void irObservacion(){
		Util.addContext(this);
		Intent intent = new Intent(this, ObservacionActivity.class);
		intent.putExtra(Constantes.Extra.ACTIVIDAD_PREVIA, Constantes.Extra.MAYA_PROMOCIONAL);
		intent.putExtra("productos", productos);
		this.startActivity(intent);
	}
}
