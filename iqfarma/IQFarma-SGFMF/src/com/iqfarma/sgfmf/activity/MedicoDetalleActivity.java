package com.iqfarma.sgfmf.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.bean.Medico;
import com.iqfarma.sgfmf.util.Constantes;
import com.iqfarma.sgfmf.util.MyAsyncTask;
import com.iqfarma.sgfmf.util.Util;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class MedicoDetalleActivity extends ActionBarActivity implements OnClickListener {
	
	private Intent intent;
	
	private MyAsyncTask myAsyncTask;
	
	private Medico medico;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medico_detalle);
		init();
	}
	
	private void init(){
		
		medico = (Medico) getIntent().getSerializableExtra("medico");
		
		((Button)findViewById(R.id.btn_visita)).setOnClickListener(this);
		
		((Button)findViewById(R.id.btn_no_visita)).setOnClickListener(this);
		
		((Button)findViewById(R.id.btn_actualizar)).setOnClickListener(this);
		
		((Button)findViewById(R.id.btn_prescripcion_medica)).setOnClickListener(this);
		
		
		((TextView)findViewById(R.id.lbl_medico_nombre)).setText(medico.getNombres() + " " + medico.getApePaterno() + " " + medico.getApeMaterno());

		((TextView)findViewById(R.id.lbl_medico_cmp)).setText(medico.getCmp());
		
		((TextView)findViewById(R.id.lbl_medico_direccion)).setText(medico.getDireccion());
		
		((TextView)findViewById(R.id.lbl_medico_fec_nac)).setText(Util.dateToString(medico.getFechaNacimiento()));
		
		((TextView)findViewById(R.id.lbl_medico_correo)).setText(medico.getCorreo());
		
		((TextView)findViewById(R.id.lbl_medico_telefono)).setText(medico.getTelefono());
		
		((TextView)findViewById(R.id.lbl_medico_celular)).setText(medico.getCelular());

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_visita:
			intent = new Intent(this, MallaPromocionalActivity.class);
			myAsyncTask = new MyAsyncTask(this, intent, false, true);
			myAsyncTask.medico = medico;
			myAsyncTask.execute(Constantes.MyAsyncTask.MENU_MEDICOS_MALLA_PROMOCIONAL);
			break;
		case R.id.btn_no_visita:
			intent = new Intent(this, NoVisitaActivity.class);
			intent.putExtra("medico", medico);
			myAsyncTask = new MyAsyncTask(this, intent, false, true);
			myAsyncTask.execute(Constantes.MyAsyncTask.MENU_MEDICOS_NO_VISITA);
			break;
		case R.id.btn_prescripcion_medica:
			intent = new Intent(this, PrescripcionMedicaActivity.class);
			myAsyncTask = new MyAsyncTask(this, intent);
			myAsyncTask.execute(Constantes.MyAsyncTask.MENU_MEDICOS_PRESCRIPCION);
			break;
		case R.id.btn_actualizar:
			Util.addContext(this);
			intent = new Intent(this, MedicoActualizacionActivity.class);
			intent.putExtra("medico", medico);
			this.startActivity(intent);
			break;
		default:
			Log.d("onClick", "no se tiene configurado su accion");
			break;
		}
	}

}
