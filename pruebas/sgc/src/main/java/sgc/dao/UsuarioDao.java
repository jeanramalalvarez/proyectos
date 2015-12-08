package sgc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sgc.entity.Usuario;
import sgc.util.JPABaseDao;

@SuppressWarnings("unchecked")
@Repository
public class UsuarioDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	JPABaseDao jPABaseDao;

	public void registrar(Usuario usuario) {
		jPABaseDao.grabar(usuario);
	}

	public void actualizar(Usuario usuario) {
		jPABaseDao.modificar(usuario);
	}

	public Usuario obtener(Long id) {
		return (Usuario) entityManager.find(Usuario.class, id);
	}

	public void eliminar(Long id) {
		entityManager.remove(obtener(id));
	}

	public List<Usuario> listar() {
		return entityManager.createQuery("from Usuario").getResultList();
	}
	
	public Usuario buscar(String query, Object... parametros) {
		return jPABaseDao.buscar(query, parametros);
	}
	
	public List<Usuario> buscarLista(String query, Object... parametros) {
		return jPABaseDao.buscarLista(query, parametros);
	}

}
