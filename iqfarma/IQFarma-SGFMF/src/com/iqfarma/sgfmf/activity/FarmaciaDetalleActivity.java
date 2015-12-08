package com.iqfarma.sgfmf.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.bean.Farmacia;
import com.iqfarma.sgfmf.util.Constantes;
import com.iqfarma.sgfmf.util.MyAsyncTask;

/**
 * @author Jean Ramal Alvarez
 * @since 19/09/2014
 * */
public class FarmaciaDetalleActivity extends Activity implements OnClickListener {

	private Intent intent;

	private MyAsyncTask myAsyncTask;
	
	private Farmacia farmacia;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_farmacia_detalle);
		init();
	}

	private void init() {
		
		farmacia = (Farmacia) getIntent().getSerializableExtra("farmacia");
		
		((Button)findViewById(R.id.btn_pedido)).setOnClickListener(this);
		
		((Button)findViewById(R.id.btn_no_pedido)).setOnClickListener(this);
		
		((TextView)findViewById(R.id.lbl_farmacia_razon_social)).setText(farmacia.getRazonSocial());

		((TextView)findViewById(R.id.lbl_farmacia_ruc)).setText(farmacia.getRuc());
		
		((TextView)findViewById(R.id.lbl_farmacia_direccion)).setText(farmacia.getDireccion());
		
		((TextView)findViewById(R.id.lbl_farmacia_telefono)).setText(farmacia.getTelefono());
		

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_pedido:
			intent = new Intent(this, ProductoActivity.class);
			intent.putExtra("farmacia", farmacia);
			myAsyncTask = new MyAsyncTask(this, intent, false, true);
			myAsyncTask.execute(Constantes.MyAsyncTask.MENU_FARMACIAS_PRODUCTOS);
			break;
		case R.id.btn_no_pedido:
			intent = new Intent(this, NoPedidoActivity.class);
			intent.putExtra("farmacia", farmacia);
			myAsyncTask = new MyAsyncTask(this, intent, false, true);
			myAsyncTask.execute(Constantes.MyAsyncTask.MENU_FARMACIAS_NO_PEDIDO);
			break;
		default:
			Log.d("onClick", "no se tiene configurado su accion");
			break;
		}
		
	}

}
