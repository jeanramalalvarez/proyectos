package sgc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sgc.entity.Usuario;
import sgc.service.ServiceFactory;
import sgc.util.Constantes;
import sgc.util.FacesUtils;

@Controller
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private ServiceFactory serviceFactory;
	
	private Usuario usuario = new Usuario();
	
	private String paginaResultado;
	
	public String login() {
		logger.debug("");
		
		Usuario usuarioBean = serviceFactory.getUsuarioService().buscarLogin(usuario);
		
		if (usuarioBean == null) {
			FacesUtils.addMessageErrorBundle("validacion.login.incorrecto");
			paginaResultado = "login";
		} else {
			FacesUtils.getSession(true).setAttribute("usuarioSesion", usuarioBean);
			FacesUtils.addMessageInfoBundle("validacion.login.correcto");
			//FacesUtils.keepMessages();
			if (usuarioBean.getRol() == Constantes.ROL.ADMINISTRADOR){
				paginaResultado = "/paginas/modulos/principal/principal" + Constantes.REDIRECT_JSF;	
        	}else{
        		paginaResultado = "/paginas/modulos/portal/principal" + Constantes.REDIRECT_JSF;
        	}
			
		}

		return paginaResultado;
	}
	
	public String logout() {
		logger.debug("");
		FacesUtils.getSession(false).invalidate();
		paginaResultado = "/paginas/modulos/seguridad/login" + Constantes.REDIRECT_JSF;
		return paginaResultado;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
