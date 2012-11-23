package macrosoft.crexsa.action;

import java.util.Map;

import macrosoft.crexsa.bean.Opcion;
import macrosoft.crexsa.domain.Usuario;
import macrosoft.crexsa.service.UsuarioService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

@ParentPackage(value = "sistema")
@Action(value = "identificarAction",

results = {
@Result(location = "principal", name = IdentificarAction.SUCCESS, type = "tiles"),
@Result(location = "login", name = "login", type = "tiles"),
@Result(location = "login", name = "input", type = "tiles"),
@Result(location = "loginDirecto", name = "loginDirecto", type = "tiles")})
@Validations(
		requiredStrings = {
		@RequiredStringValidator(fieldName = "usuario.coUsua", message = "Ingresar nombre de usuario", key = "i18n.key", shortCircuit = true, trim = true),
		@RequiredStringValidator(fieldName = "usuario.dePassUsua", message = "Ingresar contraseña", key = "i18n.key", shortCircuit = true, trim = true) })
public class IdentificarAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -5061860383512083420L;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	Map<String, Object> session;

	String resultado = null;

	@Autowired
	UsuarioService usuarioService;

	Usuario usuario;
	
	@Override
	public String execute() throws Exception {
		logger.info("");
		addActionError("Se termino la sesion.");
		return "loginDirecto";
	}

	@SkipValidation
	public String logIn() throws Exception {
		
		logger.info("");
		
		try {
			
			usuario.setCoUsua(usuario.getCoUsua().trim());
			usuario.setDePassUsua(usuario.getDePassUsua().trim());			
			
			//usuario = usuarioService.buscarUsuarioLogin(usuario);
			
			if (usuario != null) {
				session.put("usuarioSesion", usuario);
				session.put("listaModulosSesion", Opcion.obtenerMenu());
				resultado = SUCCESS;
				//addActionMessage("Bienvenido " + usuario.getCoUsua());
				logger.info("Logueo correcto");
			} else {
				addFieldError("", "Usuario y/o Clave Incorrectos.");
				//addActionError("Usuario y/o Clave Incorrectos.");
				resultado = "login";
				logger.info("Usuario y/o Clave Incorrectos.");
			}
			
		} catch (Exception e) {
			logger.error("", e.getMessage());
			addActionError(e.getMessage());
			resultado = "login";
		}
		
		return resultado;

	}
	
	@SkipValidation
	public String logOut(){
		logger.debug("");
		this.limpiarSesion();
		resultado = "login";
		return resultado;
	}
	
	public void limpiarSesion(){
		logger.debug("");
		session.remove("usuarioSesion");
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void validate() {
		logger.debug("");
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
