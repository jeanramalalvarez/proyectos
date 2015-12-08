package sgc.test;


import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import sgc.entity.Persona;
import sgc.entity.Usuario;
import sgc.service.PersonaService;
import sgc.service.UsuarioService;

public class Pruebas extends AbstractBaseUnitTest {

	@Autowired
	PersonaService personaService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Test
	public void login(){
		Usuario usuario = new Usuario();
		usuario.setUsuario("admin");
		usuario.setClave("admin");
		
		Usuario usuarioBean = usuarioService.buscarLogin(usuario);
		Assert.assertNotNull(usuarioBean);
	}

	//@Test
	public void test() throws Exception {

		Persona persona = new Persona();
		personaService.registrar(persona);
		Assert.assertNotNull(persona.getIdPersona());
		
		List<Persona> listar = personaService.listar();
		Assert.assertNotNull(listar);
		Assert.assertTrue(listar.size() > 0);
		
		
	}

}
