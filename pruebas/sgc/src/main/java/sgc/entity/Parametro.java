package sgc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PARAMETRO")
	private Long idParametro;

	private Integer codigo;

	private String descripcion;

	@Column(name="ID_PARAMETRO_PADRE")
	private Long idParametroPadre;

	private String nombre;

	private String valor;

	public Parametro() {
	}

	public Long getIdParametro() {
		return this.idParametro;
	}

	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdParametroPadre() {
		return this.idParametroPadre;
	}

	public void setIdParametroPadre(Long idParametroPadre) {
		this.idParametroPadre = idParametroPadre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}