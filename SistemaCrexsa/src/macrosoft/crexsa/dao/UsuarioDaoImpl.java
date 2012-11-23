package macrosoft.crexsa.dao;

import java.util.List;

import macrosoft.crexsa.domain.Usuario;
import macrosoft.crexsa.util.hibernate.HibernateBaseDaoImpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository 
@Scope("prototype")
public class UsuarioDaoImpl extends HibernateBaseDaoImpl implements UsuarioDao {
	
	@Override
	public void grabarUsuario(Usuario usuario) {
		super.grabar(usuario);
	}
	
	@Override
	public void modificarUsuario(Usuario usuario) {
		super.modificar(usuario);
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		super.eliminar(usuario);
	}
	
	@Override
	public void eliminarPorIdUsuario(String id) {
		super.eliminarPorId(Usuario.class, id);
	}

	@Override
	public Usuario buscarPorId(String id) {
		return super.buscarPorId(Usuario.class, id);
	}
	
	@Override
	public List<Usuario> buscarUsuarios(String consulta){
		return super.buscar(consulta);
	}
	
	@Override
	public List<Usuario> buscarTodosUsuario() {
		return super.buscarTodos(Usuario.class);
	}


	@Override
	public Usuario buscarUsuarioLogin(Usuario usuario) {
		String sql = "from Usuario u where u.coUsua = ? and u.dePassUsua = ? and u.inRegiActi = '1'";
		Object[] params = new Object[2];
		params[0] = usuario.getCoUsua();
		params[1] = usuario.getDePassUsua();
		List<Usuario> lista = super.buscar(sql, params);
		if(!lista.isEmpty()){
		   return lista.get(0); 
		}else{
		   return null;
		}
	}


}
