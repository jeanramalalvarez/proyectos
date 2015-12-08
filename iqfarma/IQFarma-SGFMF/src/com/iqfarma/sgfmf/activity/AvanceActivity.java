package com.iqfarma.sgfmf.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.iqfarma.sgfmf.R;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class AvanceActivity extends ActionBarActivity {
	
	private TextView lblAvancesMedicos;
	private TextView lblAvancesFarmacias;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_avance);
		init();
	}
	
	public void init(){
		
		lblAvancesMedicos = (TextView) findViewById(R.id.lbl_avances_medicos);
		lblAvancesFarmacias = (TextView) findViewById(R.id.lbl_avances_farmacias);
		
		lblAvancesMedicos.setText(this.getIntent().getStringExtra("avancesMedicos"));
		lblAvancesFarmacias.setText(this.getIntent().getStringExtra("avancesFarmacias"));
		
	}

}
