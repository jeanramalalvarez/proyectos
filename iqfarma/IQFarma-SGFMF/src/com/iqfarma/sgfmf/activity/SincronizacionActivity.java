package com.iqfarma.sgfmf.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.util.Constantes;
import com.iqfarma.sgfmf.util.Util;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class SincronizacionActivity extends ActionBarActivity implements OnItemClickListener {
	
	//private MyAsyncTask myAsyncTask;
	
	//private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sincronizacion);
		init();
	}
	
	private void init() {
		
		Log.i("internet", "" + Util.verificarConexion(getBaseContext()));

		SimpleAdapter adapter = Util.crearMenuSimple(getBaseContext(), Constantes.Menu.SINCRONIZACION); 

        ListView listView = ( ListView ) findViewById(R.id.list_menu);

        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
		switch (position+1) {
		case Constantes.Menu.SINCRONIZACION_MAESTRO_ID:
			//intent = new Intent(this,MedicoActivity.class);
			//myAsyncTask = new MyAsyncTask(this, intent);
			//myAsyncTask.execute(Constantes.MyAsyncTask.MENU_MEDICOS);
			break;
		}
	}
}
