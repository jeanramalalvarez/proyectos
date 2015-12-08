package com.iqfarma.sgfmf.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.bean.Motivo;
import com.iqfarma.sgfmf.util.Constantes;
import com.iqfarma.sgfmf.util.MotivoAdapter;
import com.iqfarma.sgfmf.util.Util;

/**
 * @author Jean Ramal Alvarez
 * @since 19/09/2014
 * */
@SuppressWarnings("unchecked")
public class NoPedidoActivity extends Activity implements OnClickListener {
	
private Button btnAceptar;
	
	private ListView listView;
	
	private MotivoAdapter motivoNoVisitaAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_no_pedido);
		init();
	}
	
	private void init() {

		List<Motivo> motivos = (ArrayList<Motivo>) getIntent().getSerializableExtra("motivos");
		//motivos.clear();
		if(motivos.size() > 0){
			
			btnAceptar = (Button) findViewById(R.id.btn_aceptar);
			btnAceptar.setOnClickListener(this);
	
			motivoNoVisitaAdapter = new MotivoAdapter(this, R.layout.no_visita_layout, motivos);
			listView = (ListView) findViewById(R.id.list);
			listView.setItemsCanFocus(false);
			listView.setAdapter(motivoNoVisitaAdapter);
			
			//createConfirmDialog();
			
		}else{
		
			irObservacion();
		
		}
	}
	
	@Override
	public void onClick(View view) {

		if(motivoNoVisitaAdapter.getIdMotivo() != null){
			irObservacion();
		}else{
			Toast.makeText(this, Constantes.Mensaje.TOAST_NO_VISITA_SELECIONAR_MOTIVO, Toast.LENGTH_LONG).show();
		}
		
	}
	
	private void irObservacion(){
		Util.addContext(this);
		Intent intent = new Intent(this, ObservacionActivity.class);
		intent.putExtra(Constantes.Extra.ACTIVIDAD_PREVIA, Constantes.Extra.NO_PEDIDO);
		
		intent.putExtra("farmacia", getIntent().getSerializableExtra("farmacia"));
		
		if(motivoNoVisitaAdapter.getIdMotivo() != null){
			intent.putExtra("idMotivo", motivoNoVisitaAdapter.getIdMotivo());
		}
		
		this.startActivity(intent);
	}

}
