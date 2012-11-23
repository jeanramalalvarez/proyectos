package macrosoft.crexsa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tipo_hilado")
public class TipoHilado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_hldo")
	private Integer idTipoHldo;

	@Column(name="co_tipo_hldo")
	private String coTipoHldo;

	@Column(name="de_hldo")
	private String deHldo;

	@Column(name="de_titu_hldo")
	private String deTituHldo;

	@Column(name="in_regi_acti")
	private String inRegiActi;

	@Column(name="co_usua_crea")
	private String coUsuaCrea;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="fe_usua_crea")
	private Date feUsuaCrea;
	
	@Column(name="de_term_crea")
	private String deTermCreaCrea;

	@Column(name="co_usua_modi")
	private String coUsuaModi;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fe_usua_modi")
	private Date feUsuaModi;
    
	@Column(name="de_term_modi")
	private String deTermCreaModi;

	public Integer getIdTipoHldo() {
		return this.idTipoHldo;
	}

	public void setIdTipoHldo(Integer idTipoHldo) {
		this.idTipoHldo = idTipoHldo;
	}

	public String getCoTipoHldo() {
		return this.coTipoHldo;
	}

	public void setCoTipoHldo(String coTipoHldo) {
		this.coTipoHldo = coTipoHldo;
	}

	public String getDeHldo() {
		return this.deHldo;
	}

	public void setDeHldo(String deHldo) {
		this.deHldo = deHldo;
	}

	public String getDeTituHldo() {
		return this.deTituHldo;
	}

	public void setDeTituHldo(String deTituHldo) {
		this.deTituHldo = deTituHldo;
	}

	public String getInRegiActi() {
		return this.inRegiActi;
	}

	public void setInRegiActi(String inRegiActi) {
		this.inRegiActi = inRegiActi;
	}

	public String getCoUsuaCrea() {
		return coUsuaCrea;
	}

	public void setCoUsuaCrea(String coUsuaCrea) {
		this.coUsuaCrea = coUsuaCrea;
	}

	public Date getFeUsuaCrea() {
		return feUsuaCrea;
	}

	public void setFeUsuaCrea(Date feUsuaCrea) {
		this.feUsuaCrea = feUsuaCrea;
	}

	public String getDeTermCreaCrea() {
		return deTermCreaCrea;
	}

	public void setDeTermCreaCrea(String deTermCreaCrea) {
		this.deTermCreaCrea = deTermCreaCrea;
	}

	public String getCoUsuaModi() {
		return coUsuaModi;
	}

	public void setCoUsuaModi(String coUsuaModi) {
		this.coUsuaModi = coUsuaModi;
	}

	public Date getFeUsuaModi() {
		return feUsuaModi;
	}

	public void setFeUsuaModi(Date feUsuaModi) {
		this.feUsuaModi = feUsuaModi;
	}

	public String getDeTermCreaModi() {
		return deTermCreaModi;
	}

	public void setDeTermCreaModi(String deTermCreaModi) {
		this.deTermCreaModi = deTermCreaModi;
	}	

}
