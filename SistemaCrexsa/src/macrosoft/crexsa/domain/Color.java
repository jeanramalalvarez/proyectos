package macrosoft.crexsa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Color implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_colo")
	private Integer idColo;

	@Column(name="de_colo")
	private Integer deColo;

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

	public Integer getIdColo() {
		return this.idColo;
	}

	public void setIdColo(Integer idColo) {
		this.idColo = idColo;
	}

	public Integer getDeColo() {
		return this.deColo;
	}

	public void setDeColo(Integer deColo) {
		this.deColo = deColo;
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