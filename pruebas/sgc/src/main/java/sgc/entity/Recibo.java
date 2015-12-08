package sgc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the recibo database table.
 * 
 */
@Entity
public class Recibo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RECIBO")
	private Long idRecibo;

	private Integer anio;

	private Integer departamento;

	private Integer estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_ACTUALIZACION")
	private Date fecActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_REGISTRO")
	private Date fecRegistro;

	private Integer mes;

	private String propietario;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="ID_DEPARTAMENTO")
	private Departamento departamentoBean;

	//bi-directional many-to-one association to Gasto
	@ManyToOne
	@JoinColumn(name="ID_GASTO")
	private Gasto gasto;

	//bi-directional many-to-one association to ReciboDetalle
	@OneToMany(mappedBy="recibo")
	private List<ReciboDetalle> reciboDetalles;

	public Recibo() {
	}

	public Long getIdRecibo() {
		return this.idRecibo;
	}

	public void setIdRecibo(Long idRecibo) {
		this.idRecibo = idRecibo;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
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

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getPropietario() {
		return this.propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public Departamento getDepartamentoBean() {
		return this.departamentoBean;
	}

	public void setDepartamentoBean(Departamento departamentoBean) {
		this.departamentoBean = departamentoBean;
	}

	
	public Gasto getGasto() {
		return this.gasto;
	}

	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
	}

	
	public List<ReciboDetalle> getReciboDetalles() {
		return this.reciboDetalles;
	}

	public void setReciboDetalles(List<ReciboDetalle> reciboDetalles) {
		this.reciboDetalles = reciboDetalles;
	}

	
	public ReciboDetalle addReciboDetalles(ReciboDetalle reciboDetalles) {
		getReciboDetalles().add(reciboDetalles);
		reciboDetalles.setRecibo(this);

		return reciboDetalles;
	}

	public ReciboDetalle removeReciboDetalles(ReciboDetalle reciboDetalles) {
		getReciboDetalles().remove(reciboDetalles);
		reciboDetalles.setRecibo(null);

		return reciboDetalles;
	}
}