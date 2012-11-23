package macrosoft.crexsa.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import macrosoft.crexsa.bean.Busqueda;
import macrosoft.crexsa.domain.Marca;
import macrosoft.crexsa.service.MarcaService;

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
@Action(value="mntMarcaAction",
results = {
@Result(name = PedidoAction.BUSQUEDA, location = "mnt_marca_busqueda", type = "tiles"),
@Result(name = PedidoAction.LISTADO, location = "mnt_marca_listado",  type = "tiles"),
@Result(name = PedidoAction.INPUT,   location="mnt_marca_registro", type = "tiles"),
@Result(name = PedidoAction.REGISTRO,   location="mnt_marca_registro", type = "tiles"),
@Result(name = PedidoAction.JSON, type = "json")
})
public class MntMarcaAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = -5061860383512083420L;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	Map<String, Object> session;
	
	static final String BUSQUEDA = "1";
	static final String REGISTRO = "2";
	static final String LISTADO = "3";
	static final String JSON = "json";
	
	@Autowired
	MarcaService marcaService;
	
	Marca marca;
	
	Busqueda busqueda;
	
	List<Marca> listaMarcas;
	
	
	@Override
	@SkipValidation
	public String execute() {
		logger.debug("");
		return BUSQUEDA;
	}
	
	@SkipValidation
	public String cargarListaMarca() {
		logger.info("");
		listaMarcas = marcaService.buscarMarcas(null);
		session.put("listaMarcas", listaMarcas);
		logger.info("correcto");
		return LISTADO;
	}
	
	@SkipValidation
	public String paginar() {
		return LISTADO;
	}
	
	@SkipValidation
	public String buscarMarca() {
		logger.info("");		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(busqueda.getDeMrca() != null)
		parametros.put("de_mrca", busqueda.getDeMrca());		
		listaMarcas = marcaService.buscarMarcas(parametros);
		session.put("listaMarcas", listaMarcas);
		logger.info("correcto");
		return LISTADO;
	}
	
	@SkipValidation
	public String cargarRegistro() {
		logger.info("");
		return REGISTRO;		
	}
	
	@Validations(requiredStrings={
					@RequiredStringValidator(fieldName = "marca.deMrca", message = "Ingresar una descripcion", key = "i18n.key", shortCircuit = true, trim = true)
			        }
		 	    )
	public String registrar(){
		logger.info("");
		Integer id = marca.getIdMrca();
		marcaService.grabarOModificar(marca);
		if(id == null){
			addActionMessage("La marca fue registrada satisfactoriamente. " + marca.getIdMrca());
			logger.info(" marca registrada, codigo: " + marca.getIdMrca());
		}
		else{
			addActionMessage("La marca fue modificada satisfactoriamente.");
			logger.info(" marca modificada codigo: " + marca.getIdMrca());
	    }
		marca = null;
		logger.info("correcto");
        return BUSQUEDA;
	}
	
	@SkipValidation
	public String cargarMarca() {
		logger.info(" codigo: " + marca.getIdMrca());
		marca = marcaService.obtenerPorId(marca);
		logger.info("correcto");
		return REGISTRO;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void validate() {
		logger.debug("");
	}
	
	public Marca getMarca() {
		return marca;
	}
	
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public Busqueda getBusqueda() {
		return busqueda;
	}
	
	public void setBusqueda(Busqueda busqueda) {
		this.busqueda = busqueda;
	}

}
