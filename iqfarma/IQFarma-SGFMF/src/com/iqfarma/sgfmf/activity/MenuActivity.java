package com.iqfarma.sgfmf.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.util.Constantes;
import com.iqfarma.sgfmf.util.MyAsyncTask;
import com.iqfarma.sgfmf.util.SesionUsuario;
import com.iqfarma.sgfmf.util.Util;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class MenuActivity extends ActionBarActivity implements OnItemClickListener {

	private MyAsyncTask myAsyncTask;
	
	private Intent intent;
	
	private AlertDialog alertDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		init();
	}
	
	private void init() {
		
		Log.i("internet", "" + Util.verificarConexion(getBaseContext()));

        SimpleAdapter adapter = Util.crearMenuSimple(getBaseContext(), Constantes.Menu.PRINCIPAL); 
        
        ListView listView = ( ListView ) findViewById(R.id.list_menu);

        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(this);
        
        String mensajeToad = this.getIntent().getStringExtra("mensajeToad");
        if(mensajeToad != null){
        	Toast.makeText(getBaseContext(), mensajeToad, Toast.LENGTH_LONG).show();
        }
        
        createConfirmDialog();

	}
	
	private void createConfirmDialog(){
		 alertDialog = Util.createConfirmationDialog(this, "", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					salir();
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return Util.onCreateOptionsMenu(super.getMenuInflater(), menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return Util.onOptionsItemSelected(this, item);
	}
	
	@Override
	public void onBackPressed() {
		alertDialog.setMessage(Constantes.Mensaje.TOAST_MENU_SALIR);
		alertDialog.show();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
		switch (position+1) {
		case Constantes.Menu.PRINCIPAL_MEDICOS_ID:
			intent = new Intent(this,MedicoActivity.class);
			myAsyncTask = new MyAsyncTask(this, intent, false, true);
			myAsyncTask.execute(Constantes.MyAsyncTask.MENU_MEDICOS);
			break;
		case Constantes.Menu.PRINCIPAL_FARMACIAS_ID:
			intent = new Intent(this,FarmaciaActivity.class);
			myAsyncTask = new MyAsyncTask(this, intent, false, true);
			myAsyncTask.execute(Constantes.MyAsyncTask.MENU_FARMACIAS);
			break;
		case Constantes.Menu.PRINCIPAL_AVANCE_ID:
			intent = new Intent(this,AvanceActivity.class);
			myAsyncTask = new MyAsyncTask(this, intent);
			myAsyncTask.execute(Constantes.MyAsyncTask.MENU_AVANCES);
			break;
		case Constantes.Menu.PRINCIPAL_SINCRONIZACION_ID:
			intent = new Intent(this,SincronizacionActivity.class);
			this.startActivity(intent);
			break;
		}

	}
	
	private void salir(){
		Util.limpiarContextos();
		MenuActivity.this.finish();
		SesionUsuario.sesionActiva = false;
		MenuActivity.super.onBackPressed();
	}
}
