package com.iqfarma.sgfmf.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iqfarma.sgfmf.R;
import com.iqfarma.sgfmf.bean.Usuario;
import com.iqfarma.sgfmf.util.Constantes;
import com.iqfarma.sgfmf.util.MyAsyncTask;
import com.iqfarma.sgfmf.util.SesionUsuario;
import com.iqfarma.sgfmf.util.Util;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class LoginActivity extends ActionBarActivity implements OnClickListener {
	
	private EditText txtUsuario;
	
	private EditText txtContrasena;
	
	private Button btnLogin;
	
	private MyAsyncTask myAsyncTask;
	
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(SesionUsuario.sesionActiva){
			irMenu();
		}else{
			getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			setContentView(R.layout.activity_login);
			init();
		}
	}
	
	public void init(){
		
		Log.i("internet", "" + Util.verificarConexion(getBaseContext()));
		
		btnLogin = (Button)findViewById(R.id.btn_aceptar);
		btnLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		
		switch (view.getId()) {
		case R.id.btn_aceptar:
			login();
			break;
		default:
			break;
		}
	}
	
	public void login(){
		
		txtUsuario = (EditText)findViewById(R.id.txt_usuario);
		txtContrasena = (EditText)findViewById(R.id.txt_contrasena);
		
		if (txtUsuario.getText().toString().equals("") || txtContrasena.getText().toString().equals("")){
			Toast.makeText(getBaseContext(), Constantes.Mensaje.TOAST_LOGIN_USUARIO_CONTRASENA_REQUERIDOS, Toast.LENGTH_LONG).show();
		}
		else{
			Usuario usuario = new Usuario();
			usuario.setUsuario(txtUsuario.getText().toString());
			usuario.setContrasena(txtContrasena.getText().toString());
			
			intent = new Intent(this, MenuActivity.class);
			myAsyncTask = new MyAsyncTask(this, intent, true);
			myAsyncTask.usuario = usuario;
			myAsyncTask.execute(Constantes.MyAsyncTask.LOGIN);
		}

	}
	
	public void irMenu(){
		this.finish();
		intent = new Intent(this, MenuActivity.class);
		this.startActivity(intent);
	}
}
