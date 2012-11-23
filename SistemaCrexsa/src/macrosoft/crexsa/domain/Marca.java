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
public class Marca implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_mrca")
	private Integer idMrca;

	@Column(name="co_usua_crea")
	private String coUsuaCrea;

	@Column(name="co_usua_modi")
	private String coUsuaModi;

	@Column(name="de_mrca")
	private String deMrca;

	@Column(name="de_term_crea")
	private String deTermCrea;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="de_term_modi")
	private Date deTermModi;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fe_usua_crea")
	private Date feUsuaCrea;

	@Column(name="fe_usua_modi")
	private String feUsuaModi;

	@Column(name="in_regi_acti")
	private String inRegiActi;

	@Column(name="in_tipo_prod")
	private String inTipoProd;

	public Integer getIdMrca() {
		return this.idMrca;
	}

	public void setIdMrca(Integer idMrca) {
		this.idMrca = idMrca;
	}

	public String getCoUsuaCrea() {
		return this.coUsuaCrea;
	}

	public void setCoUsuaCrea(String coUsuaCrea) {
		this.coUsuaCrea = coUsuaCrea;
	}

	public String getCoUsuaModi() {
		return this.coUsuaModi;
	}

	public void setCoUsuaModi(String coUsuaModi) {
		this.coUsuaModi = coUsuaModi;
	}

	public String getDeMrca() {
		return this.deMrca;
	}

	public void setDeMrca(String deMrca) {
		this.deMrca = deMrca;
	}

	public String getDeTermCrea() {
		return this.deTermCrea;
	}

	public void setDeTermCrea(String deTermCrea) {
		this.deTermCrea = deTermCrea;
	}

	public Date getDeTermModi() {
		return this.deTermModi;
	}

	public void setDeTermModi(Date deTermModi) {
		this.deTermModi = deTermModi;
	}

	public Date getFeUsuaCrea() {
		return this.feUsuaCrea;
	}

	public void setFeUsuaCrea(Date feUsuaCrea) {
		this.feUsuaCrea = feUsuaCrea;
	}

	public String getFeUsuaModi() {
		return this.feUsuaModi;
	}

	public void setFeUsuaModi(String feUsuaModi) {
		this.feUsuaModi = feUsuaModi;
	}

	public String getInRegiActi() {
		return this.inRegiActi;
	}

	public void setInRegiActi(String inRegiActi) {
		this.inRegiActi = inRegiActi;
	}

	public String getInTipoProd() {
		return this.inTipoProd;
	}

	public void setInTipoProd(String inTipoProd) {
		this.inTipoProd = inTipoProd;
	}
	
}