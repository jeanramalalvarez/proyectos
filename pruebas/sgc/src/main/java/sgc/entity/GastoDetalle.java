package sgc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the gasto_detalle database table.
 * 
 */
@Entity
@Table(name="gasto_detalle")
public class GastoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_GASTO_DETALLE")
	private Long idGastoDetalle;

	private Integer concepto;

	private BigDecimal importe;

	//bi-directional many-to-one association to Gasto
	@ManyToOne
	@JoinColumn(name="ID_GASTO")
	private Gasto gasto;

	public GastoDetalle() {
	}

	public Long getIdGastoDetalle() {
		return this.idGastoDetalle;
	}

	public void setIdGastoDetalle(Long idGastoDetalle) {
		this.idGastoDetalle = idGastoDetalle;
	}

	public Integer getConcepto() {
		return this.concepto;
	}

	public void setConcepto(Integer concepto) {
		this.concepto = concepto;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public Gasto getGasto() {
		return this.gasto;
	}

	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
	}

	
}