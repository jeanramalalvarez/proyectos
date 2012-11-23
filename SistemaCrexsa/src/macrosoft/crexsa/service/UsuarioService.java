package macrosoft.crexsa.service;

import java.util.List;

import macrosoft.crexsa.domain.Usuario;

public interface UsuarioService {
	
	void grabarUsuario(Usuario usuario);
	void modificarUsuario(Usuario usuario);
	void eliminarUsuario(Usuario usuario);
	void eliminarPorIdUsuario(String id);
	Usuario buscarPorId(String id);
	List<Usuario> buscarUsuarios(String consulta);
	List<Usuario> buscarTodosUsuario();
	Usuario buscarUsuarioLogin(Usuario usuario);

}
