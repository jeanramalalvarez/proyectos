package sgc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the recibo_detalle database table.
 * 
 */
@Entity
@Table(name="recibo_detalle")
public class ReciboDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RECIBO_DETALLE")
	private Long idReciboDetalle;

	private Integer concepto;

	private Integer estado;

	private BigDecimal importe;

	private Integer tipo;

	//bi-directional many-to-one association to Recibo
	@ManyToOne
	@JoinColumn(name="ID_RECIBO")
	private Recibo recibo;

	public ReciboDetalle() {
	}

	public Long getIdReciboDetalle() {
		return this.idReciboDetalle;
	}

	public void setIdReciboDetalle(Long idReciboDetalle) {
		this.idReciboDetalle = idReciboDetalle;
	}

	public Integer getConcepto() {
		return this.concepto;
	}

	public void setConcepto(Integer concepto) {
		this.concepto = concepto;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Recibo getRecibo() {
		return this.recibo;
	}

	public void setRecibo(Recibo recibo) {
		this.recibo = recibo;
	}

	
}