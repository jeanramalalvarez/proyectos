package sgc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import sgc.entity.Persona;

@SuppressWarnings("unchecked")
@Repository
public class PersonaDao {
	
	@PersistenceContext
	EntityManager entityManager;

	public void registrar(Persona persona) {
		//Session session = entityManager.unwrap(Session.class); PARA UTILIZAR LA SESION DE HIBERNATE
		entityManager.persist(persona);
	}

	public void actualizar(Persona persona) {
		entityManager.merge(persona);
	}

	public Persona obtener(Long id) {
		return (Persona) entityManager.find(Persona.class, id);
	}

	public void eliminar(Long id) {
		entityManager.remove(obtener(id));
	}

	public List<Persona> listar() {
		return entityManager.createQuery("from Persona").getResultList();
	}

}
