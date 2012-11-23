package macrosoft.crexsa.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="unidad_medida_tipo_hilado")
public class UnidadMedidaTipoHilado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_unid_medi_tipo_hilado")
	private Integer idUnidMediTipoHilado;

    @ManyToOne
	@JoinColumn(name="id_unid_medi")
	private UnidadMedida unidadMedida;

    @ManyToOne
	@JoinColumn(name="id_tipo_hldo")
	private TipoHilado tipoHilado;

	public Integer getIdUnidMediTipoHilado() {
		return this.idUnidMediTipoHilado;
	}

	public void setIdUnidMediTipoHilado(Integer idUnidMediTipoHilado) {
		this.idUnidMediTipoHilado = idUnidMediTipoHilado;
	}

	public UnidadMedida getUnidadMedida() {
		return this.unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	public TipoHilado getTipoHilado() {
		return this.tipoHilado;
	}

	public void setTipoHilado(TipoHilado tipoHilado) {
		this.tipoHilado = tipoHilado;
	}
	
}