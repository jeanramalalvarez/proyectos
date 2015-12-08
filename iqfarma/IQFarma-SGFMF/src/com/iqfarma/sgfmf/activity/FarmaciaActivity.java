package com.iqfarma.sgfmf.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.bean.Farmacia;
import com.iqfarma.sgfmf.util.Util;

/**
 * @author Jean Ramal Alvarez
 * @since 19/09/2014
 * */
@SuppressWarnings("unchecked")
public class FarmaciaActivity extends ActionBarActivity implements OnItemClickListener {
	
	SimpleAdapter adapter;
	
	List<Farmacia> farmacias;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_farmacia);
		init();
	}
	
	private void init() {
		
		farmacias = (ArrayList<Farmacia>) getIntent().getSerializableExtra("farmacias");
	  
		List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();        

		for (Farmacia farmacia : farmacias) {		
			HashMap<String, String> hm = new HashMap<String,String>();
			hm.put("tvfarmaciaCodigo", farmacia.getCodigo());
			hm.put("tvfarmacia", farmacia.getRazonSocial());
			aList.add(hm);
		}
	  
		String[] from = {"tvfarmacia", "tvfarmaciaCodigo"};
		int[] to = { R.id.lbl_texto, R.id.lbl_codigo};

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

	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
		Util.addContext(this);
		Intent intent = new Intent(this, FarmaciaDetalleActivity.class);
		intent.putExtra("farmacia", farmacias.get(position));
		this.startActivity(intent);
	}
}
