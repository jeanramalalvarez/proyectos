package sgc.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class JPABaseDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public <T> void grabar(T entity) {
		this.entityManager.persist(entity);
	}
	
	public <T> void modificar(T entity) {
		this.entityManager.merge(entity);
	}
	
	public <T> T buscarPorId(Class entity, Object id) {
		return (T) this.entityManager.find(entity, id);
	}
	
	public <T> void eliminar(T entity) {
		this.entityManager.remove(entity);
	}
	
	public <T> void eliminarPorId(Class entity, Object id) {
		this.eliminar(this.buscarPorId(entity, id));
	}

	public <T> List<T> buscarLista(String queryString, Object... parametros) {
		Query query = entityManager.createQuery(queryString);
		for (int i = 0; i < parametros.length; i++) {query.setParameter(i+1, parametros[i]);}			
		return query.getResultList();
	}

	public <T> T buscar(String queryString, Object... parametros) {
		List<T> list = buscarLista(queryString, parametros);
		if(list.isEmpty()) return null;
		else if (list.size() == 1)return (T) list.get(0);
		throw new NonUniqueResultException();
		/*
		Query query = entityManager.createQuery(queryString);
		for (int i = 0; i < parametros.length; i++) {query.setParameter(i+1, parametros[i]);}
		Object object = query.getSingleResult();
		return (T) object;
		*/
	}

}
