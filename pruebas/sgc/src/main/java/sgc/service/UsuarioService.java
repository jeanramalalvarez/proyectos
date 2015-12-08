package sgc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgc.dao.UsuarioDao;
import sgc.entity.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	public Usuario buscarLogin(Usuario usuario) {
		return usuarioDao.buscar(
				"from Usuario u where u.usuario = ? and u.clave = ?",
				usuario.getUsuario(), usuario.getClave());
	}

}
