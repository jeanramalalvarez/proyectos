package macrosoft.crexsa.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "sistema")
@Action(value="errorAction")
@Result(location = "error", name = "success", type = "tiles")
public class ErrorAction extends ActionSupport {

	private static final long serialVersionUID = -7913776839586037318L;
	private final static Logger logger = LoggerFactory.getLogger(ErrorAction.class);
	private Exception exception;
	private String mensaje;

	public String execute(){
		
		if (exception != null) {
			logger.error("Error en el Sistema: ",exception);
			mensaje = exception.getMessage();
        } else {
            logger.error("Error en el Sistema.");
        }
		//addActionError(exception.getMessage());
		return SUCCESS;
	}
	
	/**
     * @param exception the exception to set
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }

	public Exception getException() {
		return exception;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
