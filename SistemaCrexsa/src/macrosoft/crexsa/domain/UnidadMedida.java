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
@Table(name="unidad_medida")
public class UnidadMedida implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_unid_medi")
	private Integer idUnidMedi;

	@Column(name="co_unid_medi")
	private String coUnidMedi;
	
	@Column(name="in_tipo_prod")
	private String inTipoProd;

	@Column(name="co_usua_crea")
	private String coUsuaCrea;

	@Column(name="co_usua_modi")
	private String coUsuaModi;

	@Column(name="de_term_crea")
	private String deTermCrea;

	@Column(name="de_term_modi")
	private String deTermModi;

	@Column(name="de_unid_medi")
	private String deUnidMedi;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fe_usua_crea")
	private Date feUsuaCrea;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fe_usua_modi")
	private Date feUsuaModi;

	@Column(name="in_regi_acti")
	private String inRegiActi;

	public Integer getIdUnidMedi() {
		return this.idUnidMedi;
	}

	public void setIdUnidMedi(Integer idUnidMedi) {
		this.idUnidMedi = idUnidMedi;
	}

	public String getCoUnidMedi() {
		return this.coUnidMedi;
	}

	public void setCoUnidMedi(String coUnidMedi) {
		this.coUnidMedi = coUnidMedi;
	}
	
	public String getInTipoProd() {
		return inTipoProd;
	}
	
	public void setInTipoProd(String inTipoProd) {
		this.inTipoProd = inTipoProd;
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

	public String getDeTermCrea() {
		return this.deTermCrea;
	}

	public void setDeTermCrea(String deTermCrea) {
		this.deTermCrea = deTermCrea;
	}

	public String getDeTermModi() {
		return this.deTermModi;
	}

	public void setDeTermModi(String deTermModi) {
		this.deTermModi = deTermModi;
	}

	public String getDeUnidMedi() {
		return this.deUnidMedi;
	}

	public void setDeUnidMedi(String deUnidMedi) {
		this.deUnidMedi = deUnidMedi;
	}

	public Date getFeUsuaCrea() {
		return this.feUsuaCrea;
	}

	public void setFeUsuaCrea(Date feUsuaCrea) {
		this.feUsuaCrea = feUsuaCrea;
	}

	public Date getFeUsuaModi() {
		return this.feUsuaModi;
	}

	public void setFeUsuaModi(Date feUsuaModi) {
		this.feUsuaModi = feUsuaModi;
	}

	public String getInRegiActi() {
		return this.inRegiActi;
	}

	public void setInRegiActi(String inRegiActi) {
		this.inRegiActi = inRegiActi;
	}
	
}