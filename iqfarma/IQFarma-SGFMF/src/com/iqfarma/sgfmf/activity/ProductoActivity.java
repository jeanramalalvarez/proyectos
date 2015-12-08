package com.iqfarma.sgfmf.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.bean.Producto;
import com.iqfarma.sgfmf.util.Constantes;
import com.iqfarma.sgfmf.util.Util;

/**
 * @author Jean Ramal Alvarez
 * @since 19/09/2014
 * */
@SuppressWarnings("unchecked")
public class ProductoActivity extends ActionBarActivity implements OnItemClickListener {

	private SimpleAdapter adapter;

	private ArrayList<Producto> productos;
	
	private AlertDialog alertDialog;
	
	private EditText inputAlertDialog;
	
	private Producto producto;
	
	private Menu menu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_producto);
		init();
	}
	
	private void init() {
		
		productos = (ArrayList<Producto>) getIntent().getSerializableExtra("productos");
		  
		List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();        

		for (Producto producto : productos) {		
			HashMap<String, String> hm = new HashMap<String,String>();
			hm.put("tvProducto", producto.getNombre());
			aList.add(hm);
		}
	  
		String[] from = {"tvProducto"};
		int[] to = { R.id.lbl_texto};

		adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.list_layout, from, to);

		ListView listView = (ListView) findViewById(R.id.list);
		listView.setAdapter(adapter);
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(this);

		EditText myFilter = (EditText) findViewById(R.id.txt_filtro);
	  
		myFilter.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				adapter.getFilter().filter(s.toString());
			}
		  
			@Override
			public void afterTextChanged(Editable arg0) {}
		  
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,int arg3) {}
	  
		});
		
		createConfirmDialog();
		
	}
	
	private void createEditText(){
		inputAlertDialog = new EditText(this);
		inputAlertDialog.setHint(R.string.hint_cantidad);
		inputAlertDialog.setInputType(InputType.TYPE_CLASS_NUMBER);
		InputFilter[] filters = new InputFilter[1];
		filters[0] = new InputFilter.LengthFilter(Constantes.Varios.TAMANO_MAXIMO_CANTIDAD_PRODUCTO);
		inputAlertDialog.setFilters(filters);
	}
	
	private void createConfirmDialog(){
		createEditText();
		alertDialog = Util.createConfirmationDialog(this, "", inputAlertDialog, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				agregarProducto();
			}
		});
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.producto, menu);
	    this.menu = menu;
	    return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Util.addContext(this);
		Intent intent = new Intent(this, PedidoActivity.class);
		intent.putExtra("productos", productos);
		this.startActivity(intent);
		/*
		for (Producto producto : productos) {
			if(producto.getCantidad() > 0){
				Log.i("producto", "nombre: " + producto.getNombre() + ", cantidad: " + producto.getCantidad());
			}
		}
		*/
		return true;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
		inputAlertDialog.setText("");
		producto = productos.get(position);
		alertDialog.setMessage(producto.getNombre());
		alertDialog.show();
	}
	
	private void agregarProducto(){
		if(inputAlertDialog.getText().toString().equals("") ){
			Toast.makeText(this, "Debe ingresar una cantidad correcta", Toast.LENGTH_SHORT).show();
			return;
		}
		int cantidad = Integer.parseInt(inputAlertDialog.getText().toString());
		if(cantidad == 0){
			Toast.makeText(this, "Debe ingresar una cantidad correcta", Toast.LENGTH_SHORT).show();
			return;
		}
		producto.setCantidad(cantidad);
		menu.getItem(0).setVisible(true);
		Log.d("cantidad", "" + cantidad);
		Log.d("producto", "" + producto.getNombre());
	}

	
}
