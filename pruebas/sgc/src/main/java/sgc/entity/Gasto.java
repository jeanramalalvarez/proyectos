package sgc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the gasto database table.
 * 
 */
@Entity
public class Gasto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_GASTO")
	private Long idGasto;

	private Integer anio;

	private Integer estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_ACTUALIZACION")
	private Date fecActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_REGISTRO")
	private Date fecRegistro;

	private Integer mes;

	//bi-directional many-to-one association to GastoDetalle
	@OneToMany(mappedBy="gasto")
	private List<GastoDetalle> gastoDetalles;

	//bi-directional many-to-one association to Recibo
	@OneToMany(mappedBy="gasto")
	private List<Recibo> recibos;

	public Gasto() {
	}

	public Long getIdGasto() {
		return this.idGasto;
	}

	public void setIdGasto(Long idGasto) {
		this.idGasto = idGasto;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
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

	public List<GastoDetalle> getGastoDetalles() {
		return this.gastoDetalles;
	}

	public void setGastoDetalles(List<GastoDetalle> gastoDetalles) {
		this.gastoDetalles = gastoDetalles;
	}

	
	public GastoDetalle addGastoDetalles(GastoDetalle gastoDetalles) {
		getGastoDetalles().add(gastoDetalles);
		gastoDetalles.setGasto(this);

		return gastoDetalles;
	}

	public GastoDetalle removeGastoDetalles(GastoDetalle gastoDetalles) {
		getGastoDetalles().remove(gastoDetalles);
		gastoDetalles.setGasto(null);

		return gastoDetalles;
	}
	public List<Recibo> getRecibos() {
		return this.recibos;
	}

	public void setRecibos(List<Recibo> recibos) {
		this.recibos = recibos;
	}

	
	public Recibo addRecibos(Recibo recibos) {
		getRecibos().add(recibos);
		recibos.setGasto(this);

		return recibos;
	}

	public Recibo removeRecibos(Recibo recibos) {
		getRecibos().remove(recibos);
		recibos.setGasto(null);

		return recibos;
	}
}