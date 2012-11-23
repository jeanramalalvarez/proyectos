package macrosoft.crexsa.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;
 
@ParentPackage(value = "sistema")
@Action(value="welcomeAction")
@Result(name = WelcomeAction.SUCCESS, location = "logueo", type="tiles")
public class WelcomeAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@SkipValidation
	public String execute() {
		logger.debug("");
		return SUCCESS;		
	}

}