
package macrosoft.crexsa.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import macrosoft.crexsa.bean.Busqueda;
import macrosoft.crexsa.domain.Banco;
import macrosoft.crexsa.domain.Marca;
import macrosoft.crexsa.domain.Pedido;
import macrosoft.crexsa.domain.TipoHilado;
import macrosoft.crexsa.domain.UnidadMedida;
import macrosoft.crexsa.service.BancoService;
import macrosoft.crexsa.service.MarcaService;
import macrosoft.crexsa.service.PedidoService;
import macrosoft.crexsa.service.TipoHiladoService;
import macrosoft.crexsa.service.UnidadMedidaService;
import macrosoft.crexsa.util.UtilFecha;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
 
@ParentPackage(value = "sistema")
@Action(value="pedidoAction",
results = {
@Result(name = PedidoAction.BUSQUEDA, location = "pedido_busqueda", type = "tiles"),
@Result(name = PedidoAction.LISTADO, location = "pedido_listado",  type = "tiles"),
@Result(name = PedidoAction.INPUT,   location="pedido_registro", type = "tiles"),
@Result(name = PedidoAction.REGISTRO,   location="pedido_registro", type = "tiles"),
@Result(name = PedidoAction.JSON, type = "json")
})
public class PedidoAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	static final String BUSQUEDA = "1";
	static final String REGISTRO = "2";
	static final String LISTADO = "3";
	static final String JSON = "json";
	
	Map<String, Object> session;
	
	@Autowired
	BancoService bancoService;
	
	@Autowired
	TipoHiladoService hiladoService;
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	MarcaService marcaService;
	
	@Autowired
	UnidadMedidaService unidadMedidaService;
	
	List<Banco> listaBancos;
	List<TipoHilado> listaTipoHilados;
	List<Pedido> listaPedido;
	List<Marca> listaMarcas;
	List<UnidadMedida> listaUnidadMedidas;
	
	Pedido pedido;
	
	Busqueda busqueda;
	
	@Override
	@SkipValidation
	public String execute() {
		logger.debug("");
		return BUSQUEDA;
	}
	
	public void cargarListas(){
		listaBancos = bancoService.listarBancos();
		listaTipoHilados = hiladoService.listarTipoHilados();
		listaMarcas = marcaService.listarMarcaPorInTipoProd("H");
		listaUnidadMedidas = unidadMedidaService.listarUnidadMedidaPorInTipoProd("H");
		session.put("listaBancos", listaBancos);
		session.put("listaTipoHilados", listaTipoHilados);
		session.put("listaMarcas", listaMarcas);
		session.put("listaUnidadMedidas", listaUnidadMedidas);
	}
	
	@SkipValidation
	public String cargarRegistro() {
		logger.info("");
		this.cargarListas();
		logger.info("correcto");
		return REGISTRO;		
	}

	@SkipValidation
	public String cargarListaPedido() {
		logger.info("");
		listaPedido = pedidoService.buscarPedidos(null);
		session.put("listaPedido", listaPedido);
		logger.info("correcto");
		return LISTADO;
	}
	
	@SkipValidation
	public String buscarPedido() {
		logger.info("");		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(busqueda.getNuPedi() != null)
		parametros.put("nu_pedi", busqueda.getNuPedi());		
		if(busqueda.getFecInicial() != null)
		parametros.put("fec_ini", UtilFecha.dateToStringFormat(busqueda.getFecInicial(), "yyyy-MM-dd"));
		if(busqueda.getFecFinal() != null)
		parametros.put("fec_fin", UtilFecha.dateToStringFormat(busqueda.getFecFinal(), "yyyy-MM-dd"));
		listaPedido = pedidoService.buscarPedidos(parametros);
		session.put("listaPedido", listaPedido);
		logger.info("correcto");
		return LISTADO;
	}
	
	@SkipValidation
	public String paginar() {
		return LISTADO;
	}
	
	@SkipValidation
	public String anularPedido() {
		logger.info(" codigo: " + pedido.getNuPedi());
		pedidoService.anularPedido(pedido);
		listaPedido = pedidoService.buscarPedidos(null);
		session.put("listaPedido", listaPedido);
		pedido = null;
		addActionMessage("El pedido fue anulado satisfactoriamente.");
		logger.info("correcto");
		return LISTADO;
	}
	
	@SkipValidation
	public String cargarPedido() {
		logger.info(" codigo: " + pedido.getNuPedi());
		pedido = pedidoService.obtenerPedidoPorId(pedido);
		this.cargarListas();
		logger.info("correcto");
		return REGISTRO;
	}

	@Validations(
		    /*regexFields = {@RegexFieldValidator(fieldName= "pedido.nuCostCif", expression="<![CDATA[\\d[0-9]]]>" , message = "Debe ingresar valores numéricos", key="i18n.key", shortCircuit = true)},*/
			requiredFields ={@RequiredFieldValidator(fieldName = "pedido.fePedi", message = "Ingresar fecha de pedido", key = "i18n.key", shortCircuit = false),
							@RequiredFieldValidator(fieldName = "pedido.nuCostCif", message = "Ingresar Costo Cif", key = "i18n.key", shortCircuit = true),
							@RequiredFieldValidator(fieldName = "pedido.nuCantPedi", message = "Ingresar Cantidad", key = "i18n.key", shortCircuit = true),
							@RequiredFieldValidator(fieldName = "pedido.idTipoHldo", message = "Ingresar hilado", key = "i18n.key", shortCircuit = true),
							@RequiredFieldValidator(fieldName = "pedido.idMrca", message = "Ingresar marca", key = "i18n.key", shortCircuit = true),
							@RequiredFieldValidator(fieldName = "pedido.idUnidMedi", message = "Ingresar unidad de medida", key = "i18n.key", shortCircuit = true),
							@RequiredFieldValidator(fieldName = "pedido.idBnco", message = "Ingresar banco", key = "i18n.key", shortCircuit = true)},
			
			requiredStrings={
					@RequiredStringValidator(fieldName = "pedido.deProfInvo", message = "Ingresar proforma Invoice", key = "i18n.key", shortCircuit = true, trim = true),
					@RequiredStringValidator(fieldName = "pedido.noCarg", message = "Ingresar cargador", key = "i18n.key", shortCircuit = true, trim = true)}
			)
	public String registrar(){
		logger.info("");
		pedido.setDeProfInvo(pedido.getDeProfInvo().toUpperCase());
		pedido.setNoCarg(pedido.getNoCarg().toUpperCase());
		Integer nuPedi = pedido.getNuPedi();
		pedidoService.grabarOModificarPedido(pedido);
		if(nuPedi == null){
			addActionMessage("El pedido fue registrado satisfactoriamente.");
		}
		else{
			logger.info(" codigo: " + pedido.getNuPedi());
			addActionMessage("El pedido fue modificado satisfactoriamente.");
	    }
		pedido = null;
		logger.info("correcto");
        return BUSQUEDA;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public void validate() {
		logger.debug("");
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

    public Busqueda getBusqueda() {
		return busqueda;
	}
    
    public void setBusqueda(Busqueda busqueda) {
		this.busqueda = busqueda;
	}

}