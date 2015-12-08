package com.iqfarma.sgfmf.activity;

import java.util.ArrayList;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.R.layout;
import com.iqfarma.sgfmf.bean.Producto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

@SuppressWarnings("unchecked")
public class PedidoActivity extends Activity {

	private SimpleAdapter adapter;

	private ArrayList<Producto> productos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pedido);
		init();
	}

	private void init() {

		productos = (ArrayList<Producto>) getIntent().getSerializableExtra("productos");
	}

}
