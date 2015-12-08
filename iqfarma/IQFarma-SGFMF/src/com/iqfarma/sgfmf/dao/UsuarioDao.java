package com.iqfarma.sgfmf.dao;

import com.iqfarma.sgfmf.bean.Usuario;
import com.iqfarma.sgfmf.util.SesionUsuario;

public class UsuarioDao {
	
	public Usuario login(Usuario usuario){
		if (usuario.getUsuario().equals("admin") && usuario.getContrasena().equals("admin")){
			SesionUsuario.sesionActiva = true;
			return usuario;
		}
		else{
			return null;
		}
	}

}
