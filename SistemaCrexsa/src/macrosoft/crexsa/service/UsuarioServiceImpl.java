package macrosoft.crexsa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import macrosoft.crexsa.dao.UsuarioDao;
import macrosoft.crexsa.domain.Usuario;

@Service
@Scope("singleton")
public class UsuarioServiceImpl implements UsuarioService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	UsuarioDao usuarioDao;

	@Override
	public Usuario buscarUsuarioLogin(Usuario usuario) {
		logger.info("");
		return usuarioDao.buscarUsuarioLogin(usuario);
	}

	@Override
	public void grabarUsuario(Usuario usuario) {
		usuarioDao.grabarUsuario(usuario);
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		usuarioDao.modificarUsuario(usuario);
		
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		usuarioDao.eliminarUsuario(usuario);
		
	}

	@Override
	public void eliminarPorIdUsuario(String id) {
		usuarioDao.eliminarPorIdUsuario(id);
		
	}

	@Override
	public Usuario buscarPorId(String id) {
		return usuarioDao.buscarPorId(id);
	}

	@Override
	public List<Usuario> buscarUsuarios(String consulta) {
		return usuarioDao.buscarUsuarios(consulta);
	}

	@Override
	public List<Usuario> buscarTodosUsuario() {
		return usuarioDao.buscarTodosUsuario();
	}

}
