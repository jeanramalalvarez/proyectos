package macrosoft.crexsa.action;

import java.util.Map;

import macrosoft.crexsa.domain.TipoTransaccion;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "sistema")
@Action(value="hiladoAction",
results = {
@Result(name = HiladoAction.SUCCESS, location = "hilado_ingreso", type = "tiles"),
@Result(name = HiladoAction.REGISTRO_IMPORTACION, location = "hilado_registro_importacion", type = "tiles"),
@Result(name = HiladoAction.REGISTRO_LOCAL, location = "hilado_registro_local", type = "tiles"),
@Result(name = HiladoAction.INPUT,   location="hilado_ingreso", type = "tiles")
})
public class HiladoAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	static final String REGISTRO_IMPORTACION = "importacion";
	static final String REGISTRO_LOCAL = "local";
	
	Map<String, Object> session;
	
	TipoTransaccion tipoTransaccion;
	
	@SkipValidation
	public String execute() {
		logger.info("");
		return SUCCESS;		
	}
	
	@SkipValidation
	public String mostrarPaginaRegistro() {
		logger.debug("");
		if(tipoTransaccion.getIdTipoTran() == 1)
			return REGISTRO_IMPORTACION;
		else
		    return REGISTRO_LOCAL;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String, Object> getSession() {
		return this.session;
	}
	
	public TipoTransaccion getTipoTransaccion() {
		return tipoTransaccion;
	}
	
	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

}
