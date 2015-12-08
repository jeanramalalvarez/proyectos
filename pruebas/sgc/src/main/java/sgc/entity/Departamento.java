package sgc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DEPARTAMENTO")
	private Long idDepartamento;

	private Integer estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_ACTUALIZACION")
	private Date fecActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_REGISTRO")
	private Date fecRegistro;

	private Integer numero;

	private Integer ocupacion;

	private Integer piso;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="departamento")
	private List<Persona> personas;

	//bi-directional many-to-one association to Recibo
	@OneToMany(mappedBy="departamentoBean")
	private List<Recibo> recibos;

	public Departamento() {
	}

	public Long getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFecActualizacion() {
		return this.fecActualizacion;
	}

	public void setFecActualizacion(Date fecActualizacion) {
		this.fecActualizacion = fecActualizacion;
	}

	public Date getFecRegistro() {
		return this.fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(Integer ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Integer getPiso() {
		return this.piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	
	public Persona addPersonas(Persona personas) {
		getPersonas().add(personas);
		personas.setDepartamento(this);

		return personas;
	}

	public Persona removePersonas(Persona personas) {
		getPersonas().remove(personas);
		personas.setDepartamento(null);

		return personas;
	}
	public List<Recibo> getRecibos() {
		return this.recibos;
	}

	public void setRecibos(List<Recibo> recibos) {
		this.recibos = recibos;
	}

	
	public Recibo addRecibos(Recibo recibos) {
		getRecibos().add(recibos);
		recibos.setDepartamentoBean(this);

		return recibos;
	}

	public Recibo removeRecibos(Recibo recibos) {
		getRecibos().remove(recibos);
		recibos.setDepartamentoBean(null);

		return recibos;
	}
}