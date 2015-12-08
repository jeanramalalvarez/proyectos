package com.iqfarma.sgfmf.activity;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.bean.Medico;
import com.iqfarma.sgfmf.util.Constantes;
import com.iqfarma.sgfmf.util.MyAsyncTask;
import com.iqfarma.sgfmf.util.Util;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class MedicoActualizacionActivity extends Activity implements OnClickListener {

	private Intent intent;

	private Medico medico;

	private MyAsyncTask myAsyncTask;

	private EditText txtMedicoFecNac;
	
	private EditText txtMedicoCorreo;
	
	private EditText txtMedicoTelefono;
	
	private EditText txtMedicoCelular;

	private DatePickerDialog dpdFecNac;
	
	private Button btnActualizar;
	
	private AlertDialog alertDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medico_actualizacion);
		init();
	}

	private void init() {
		medico = (Medico) getIntent().getSerializableExtra("medico");
		
		txtMedicoFecNac = (EditText) findViewById(R.id.txt_medico_fec_nac);
		txtMedicoFecNac.setInputType(0);
		txtMedicoFecNac.setOnClickListener(this);
		
		txtMedicoCorreo = (EditText) findViewById(R.id.txt_medico_correo);
		txtMedicoCorreo.setText(medico.getCorreo());
		
		txtMedicoTelefono = (EditText) findViewById(R.id.txt_medico_telefono);
		txtMedicoTelefono.setText(medico.getTelefono());
		
		txtMedicoCelular = (EditText) findViewById(R.id.txt_medico_celular);
		txtMedicoCelular.setText(medico.getCelular());
		
		btnActualizar = (Button) findViewById(R.id.btn_actualizar);
		btnActualizar.setOnClickListener(this);
		
		createDatePickerDialog();
		
		createConfirmDialog();
	}
	
	private void createDatePickerDialog(){
		Calendar newCalendar = Calendar.getInstance();
		if(medico.getFechaNacimiento() != null){
			newCalendar.setTime(medico.getFechaNacimiento());
			txtMedicoFecNac.setText(Util.dateToString(medico.getFechaNacimiento()));
		}
		dpdFecNac = new DatePickerDialog(this, new OnDateSetListener() {
	        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
	            Calendar newDate = Calendar.getInstance();
	            newDate.set(year, monthOfYear, dayOfMonth);
	            txtMedicoFecNac.setText(Util.dateToString(newDate.getTime()));
	        }
	    },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
	}
	
	private void createConfirmDialog(){
		alertDialog = Util.createConfirmationDialog(this, "", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				procesar();
			}
		});
	}

	@Override
	public void onClick(View view) {
		if(view == txtMedicoFecNac) {
			dpdFecNac.show();
		}else if(view == btnActualizar){
			alertDialog.setMessage(Constantes.Mensaje.DIALOG_MEDICO_ACTUALIZAR_MEDICO);
			alertDialog.show();
		}

	}
	
	private void procesar(){
		
		medico.setFechaNacimiento(Util.stringToDate(txtMedicoFecNac.getText().toString()));
		medico.setCorreo(txtMedicoCorreo.getText().toString());
		medico.setTelefono(txtMedicoTelefono.getText().toString());
		medico.setCelular(txtMedicoCelular.getText().toString());
		
		intent = new Intent(this, MenuActivity.class);
		myAsyncTask = new MyAsyncTask(this, intent, true, true);
		myAsyncTask.medico = medico;
		myAsyncTask.execute(Constantes.MyAsyncTask.MENU_MEDICOS_ACTUALIZAR);
	}

}
