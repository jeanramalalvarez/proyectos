package macrosoft.crexsa.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="marca_tipo_hilado")
public class MarcaTipoHilado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_mrca_tipo_hilado")
	private Integer idMrcaTipoHilado;

    @ManyToOne
	@JoinColumn(name="id_mrca")
	private Marca marca;

    @ManyToOne
	@JoinColumn(name="id_tipo_hldo")
	private TipoHilado tipoHilado;

	public Integer getIdMrcaTipoHilado() {
		return this.idMrcaTipoHilado;
	}

	public void setIdMrcaTipoHilado(Integer idMrcaTipoHilado) {
		this.idMrcaTipoHilado = idMrcaTipoHilado;
	}

	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public TipoHilado getTipoHilado() {
		return this.tipoHilado;
	}

	public void setTipoHilado(TipoHilado tipoHilado) {
		this.tipoHilado = tipoHilado;
	}
	
}