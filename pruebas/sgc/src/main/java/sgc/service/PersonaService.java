package sgc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sgc.dao.PersonaDao;
import sgc.entity.Persona;

@Repository
public class PersonaService {
	
	@Autowired
	private PersonaDao personaDao;

	public void registrar(Persona persona) {
		personaDao.registrar(persona);
	}

	public void actualizar(Persona persona) {
		personaDao.actualizar(persona);
	}

	public Persona obtener(Long id) {
		return personaDao.obtener(id);
	}

	public void eliminar(Long id) {
		personaDao.eliminar(id);
	}

	public List<Persona> listar() {
		return personaDao.listar();
	}

}
