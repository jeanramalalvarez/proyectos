package macrosoft.crexsa.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Opcion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idOpcion;
	
	private String noOpci;

	private String deOpci;

	private String esOpci;

	private Integer idOpciPadr;

	Opcion modulo;

	List<Opcion> listaOpcion;

	private int orden;

	private String url;

	public Integer getIdOpcion() {
		return this.idOpcion;
	}

	public void setIdOpcion(Integer idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getNoOpci() {
		return noOpci;
	}

	public void setNoOpci(String noOpci) {
		this.noOpci = noOpci;
	}

	public String getDeOpci() {
		return this.deOpci;
	}

	public void setDeOpci(String deOpci) {
		this.deOpci = deOpci;
	}

	public String getEsOpci() {
		return this.esOpci;
	}

	public void setEsOpci(String esOpci) {
		this.esOpci = esOpci;
	}

	public Integer getIdOpciPadr() {
		return this.idOpciPadr;
	}

	public void setIdOpciPadr(Integer idOpciPadr) {
		this.idOpciPadr = idOpciPadr;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Opcion> getListaOpcion() {
		if(listaOpcion == null){
			listaOpcion = new ArrayList<Opcion>();
		}
		return listaOpcion;
	}

	public void setListaOpcion(List<Opcion> listaOpcion) {
		this.listaOpcion = listaOpcion;
	}

	public Opcion getModulo() {
		return modulo;
	}

	public void setModulo(Opcion modulo) {
		this.modulo = modulo;
	}
	
	public static List<Opcion> obtenerMenu(){
		
		List<Opcion> listaModulos = new ArrayList<Opcion>();
		List<Opcion> listaOpciones;
		Opcion modulo;
		Opcion opcion;
		
		{		
		modulo = new Opcion();
		modulo.setNoOpci("INICIO");
		
		  listaOpciones = new ArrayList<Opcion>();
		  opcion = new Opcion();
		  opcion.setNoOpci("Registro de Pedidos");
		  opcion.setUrl("pedidoAction");
		  listaOpciones.add(opcion);
		
		modulo.setListaOpcion(listaOpciones);
		
		listaModulos.add(modulo);
		}
		
		
		{
		modulo = new Opcion();
		modulo.setNoOpci("HILADO");
		
		  listaOpciones = new ArrayList<Opcion>();
		  opcion = new Opcion();
		  opcion.setNoOpci("Ingreso de Hilado");
		  opcion.setUrl("hiladoAction");
		  listaOpciones.add(opcion);
		  
		  opcion = new Opcion();
		  opcion.setNoOpci("Salida de Hilado");
		  //opcion.setUrl("#");
		  listaOpciones.add(opcion);
		
		modulo.setListaOpcion(listaOpciones);
		
		listaModulos.add(modulo);
		}		
		
		
		{
		modulo = new Opcion();
		modulo.setNoOpci("TEJEDURIA");
		
		  listaOpciones = new ArrayList<Opcion>();
		  opcion = new Opcion();
		  opcion.setNoOpci("Ingreso de Tela");
		  //opcion.setUrl("#");
		  listaOpciones.add(opcion);
		  
		  opcion = new Opcion();
		  opcion.setNoOpci("Salida de Tela");
		  //opcion.setUrl("#");
		  listaOpciones.add(opcion);
		
		modulo.setListaOpcion(listaOpciones);
		
		listaModulos.add(modulo);
		}
		
		
		
		{
		modulo = new Opcion();
		modulo.setNoOpci("TINTORERIA");
		
		  listaOpciones = new ArrayList<Opcion>();
		  opcion = new Opcion();
		  opcion.setNoOpci("Ingreso de Tela");
		  //opcion.setUrl("#");
		  listaOpciones.add(opcion);
		  
		  opcion = new Opcion();
		  opcion.setNoOpci("Salida de Tela");
		  //opcion.setUrl("#");
		  listaOpciones.add(opcion);
		
		modulo.setListaOpcion(listaOpciones);
		
		listaModulos.add(modulo);
		}
		
		
		{
		modulo = new Opcion();
		modulo.setNoOpci("MANTENIMIENTO");
		
		  listaOpciones = new ArrayList<Opcion>();
		  opcion = new Opcion();
		  opcion.setNoOpci("Marca");
		  opcion.setUrl("mntMarcaAction");
		  listaOpciones.add(opcion);
		
		modulo.setListaOpcion(listaOpciones);
		
		listaModulos.add(modulo);
		}
		
		return listaModulos;
	}
	
	
}