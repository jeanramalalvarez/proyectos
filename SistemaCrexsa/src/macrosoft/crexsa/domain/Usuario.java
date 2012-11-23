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
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usua")
	private Integer idUsua;

	@Column(name="de_pass_usua")
	private String dePassUsua;

	@Column(name="co_usua")
	private String coUsua;

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

	public Integer getIdUsua() {
		return this.idUsua;
	}

	public void setIdUsua(Integer idUsua) {
		this.idUsua = idUsua;
	}

	public String getDePassUsua() {
		return this.dePassUsua;
	}

	public void setDePassUsua(String dePassUsua) {
		this.dePassUsua = dePassUsua;
	}

	public String getCoUsua() {
		return this.coUsua;
	}

	public void setCoUsua(String coUsua) {
		this.coUsua = coUsua;
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
