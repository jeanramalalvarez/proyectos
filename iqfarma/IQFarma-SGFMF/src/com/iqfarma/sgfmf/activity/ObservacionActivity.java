package com.iqfarma.sgfmf.activity;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.bean.Farmacia;
import com.iqfarma.sgfmf.bean.Medico;
import com.iqfarma.sgfmf.bean.Producto;
import com.iqfarma.sgfmf.util.Constantes;
import com.iqfarma.sgfmf.util.MyAsyncTask;
import com.iqfarma.sgfmf.util.Util;

/**
 * @author Jean Ramal Alvarez
 * @since 10/09/2014
 * */
@SuppressWarnings("unchecked")
public class ObservacionActivity extends ActionBarActivity implements OnClickListener {
	
	private MyAsyncTask myAsyncTask;
	
	private Intent intent;
	
	private AlertDialog alertDialog;
	
	private Button btnAceptar;
	
	private EditText txtObservacion;
	
	private int actividadPrevia;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_observacion);		
		init();
	}
	
	private void init() {
		
		btnAceptar = (Button) findViewById(R.id.btn_aceptar);
		btnAceptar.setOnClickListener(this);
		
		txtObservacion = (EditText) findViewById(R.id.txt_observacion);
		
		actividadPrevia = getIntent().getIntExtra(Constantes.Extra.ACTIVIDAD_PREVIA, 0);
		
		createConfirmDialog();
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
		
		String mensaje = "";
		
		if(txtObservacion.getText().toString().equals("")){
			mensaje = Constantes.Mensaje.DIALOG_OBSERVACION_REQUERIDA;
		}
		
		if(actividadPrevia == Constantes.Extra.MAYA_PROMOCIONAL){
			mensaje += Constantes.Mensaje.DIALOG_OBSERVACION_REGISTRAR_VISITA;
		}else if(actividadPrevia == Constantes.Extra.NO_VISITA){
			mensaje += Constantes.Mensaje.DIALOG_OBSERVACION_REGISTRAR_NO_VISITA;
		}else if(actividadPrevia == Constantes.Extra.NO_PEDIDO){
			mensaje += Constantes.Mensaje.DIALOG_OBSERVACION_REGISTRAR_NO_PEDIDO;
		}
		
		alertDialog.setMessage(mensaje);
		alertDialog.show();
		
	}
	
	private void procesar(){
		
		switch (actividadPrevia) {
		case Constantes.Extra.MAYA_PROMOCIONAL:
			registrarVisita();
			break;
		case Constantes.Extra.NO_VISITA:
			registrarNoVisita();
			break;
		case Constantes.Extra.NO_PEDIDO:
			registrarNoPedido();
			break;
		default:
			break;
		}
	}
	
	private void registrarVisita(){
		ArrayList<Producto> productos = (ArrayList<Producto>) getIntent().getSerializableExtra("productos");
		intent = new Intent(this, MenuActivity.class);
		myAsyncTask = new MyAsyncTask(this, intent, false, true);
		myAsyncTask.observacion = txtObservacion.getText().toString();
		myAsyncTask.productos = productos;
		myAsyncTask.execute(Constantes.MyAsyncTask.MENU_MEDICOS_REGISTRAR_VISITA);
	}
	
	private void registrarNoVisita(){
		Long idMotivo = getIntent().getLongExtra("idMotivo", 0L);
		Medico medico = (Medico) getIntent().getSerializableExtra("medico");
		
		intent = new Intent(this, MenuActivity.class);
		myAsyncTask = new MyAsyncTask(this, intent, false, true);
		myAsyncTask.observacion = txtObservacion.getText().toString();
		myAsyncTask.idMotivo = idMotivo;
		myAsyncTask.medico = medico;
		myAsyncTask.execute(Constantes.MyAsyncTask.MENU_MEDICOS_REGISTRAR_NO_VISITA);
	}
	
	private void registrarNoPedido(){
		Long idMotivo = getIntent().getLongExtra("idMotivo", 0L);
		Farmacia farmacia = (Farmacia) getIntent().getSerializableExtra("farmacia");
		
		intent = new Intent(this, MenuActivity.class);
		myAsyncTask = new MyAsyncTask(this, intent, false, true);
		myAsyncTask.observacion = txtObservacion.getText().toString();
		myAsyncTask.idMotivo = idMotivo;
		myAsyncTask.farmacia = farmacia;
		myAsyncTask.execute(Constantes.MyAsyncTask.MENU_FARMACIAS_REGISTRAR_NO_PEDIDO);
	}

}
