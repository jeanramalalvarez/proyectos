package macrosoft.crexsa.action;

import java.util.List;
import java.util.Map;

import macrosoft.crexsa.domain.TipoTransaccion;
import macrosoft.crexsa.service.TipoTransaccionService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "sistema")
@Action(value="tipoTransaccionAction",
results = {
@Result(name = TipoTransaccionAction.JSON, type = "json"),
})
public class TipoTransaccionAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	static final String JSON = "json";
	
	Map<String, Object> session;
	
	@Autowired
	TipoTransaccionService tipoTransaccionService;
	
	List<TipoTransaccion> listaTipoTransaccion;
	
	@SkipValidation
	public String execute() {
		logger.info("");
		return SUCCESS;		
	}
	
	public String cargarListaTransaccion(){
		listaTipoTransaccion = tipoTransaccionService.listarTipoTransaccionActivos();
		return JSON;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String, Object> getSession() {
		return this.session;
	}
	
	public List<TipoTransaccion> getListaTipoTransaccion() {
		return listaTipoTransaccion;
	}
	
	public void setTipoTransaccionService(TipoTransaccionService tipoTransaccionService) {
		this.tipoTransaccionService = tipoTransaccionService;
	}

}
