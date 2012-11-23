package macrosoft.crexsa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nu_pedi")
	private Integer nuPedi;

	@Column(name="id_bnco")
	private Integer idBnco;
	
	@Column(name="id_tipo_hldo")
	private Integer idTipoHldo;

	@Column(name="id_mrca")
	private String idMrca;

	@Column(name="id_unid_medi")
	private String idUnidMedi;

	@Column(name="de_obse_pedi")
	private String deObsePedi;

	@Column(name="de_prof_invo")
	private String deProfInvo;

    @Temporal( TemporalType.DATE)
	@Column(name="fe_pedi")
	private Date fePedi;

	@Column(name="in_regi_acti")
	private String inRegiActi;

	@Column(name="no_carg")
	private String noCarg;

	@Column(name="nu_adel_pedi")
	private BigDecimal nuAdelPedi;

	@Column(name="nu_cant_pedi")
	private BigDecimal nuCantPedi;

	@Column(name="nu_cost_cif")
	private BigDecimal nuCostCif;

	@Column(name="nu_cost_tota")
	private BigDecimal nuCostTota;

	@Column(name="nu_prec_vent")
	private BigDecimal nuPrecVent;

	@Column(name="nu_tota_pedi")
	private BigDecimal nuTotaPedi;
	
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

	@Transient
	private String deHldo;
	@Transient
	private String noBnco;

	/*
	@ManyToOne
	@JoinColumn(name = "co_hldo", insertable=false, updatable=false, nullable=true)
	private TipoHilado tipoHilado;
	
	@ManyToOne
	@JoinColumn(name = "co_bnco", insertable=false, updatable=false, nullable=true)
	private Banco banco;
	*/

	public Integer getNuPedi() {
		return this.nuPedi;
	}

	public void setNuPedi(Integer nuPedi) {
		this.nuPedi = nuPedi;
	}

	public Integer getIdBnco() {
		return this.idBnco;
	}

	public void setIdBnco(Integer idBnco) {
		this.idBnco = idBnco;
	}
	
	public Integer getIdTipoHldo() {
		return idTipoHldo;
	}
	
	public void setIdTipoHldo(Integer idTipoHldo) {
		this.idTipoHldo = idTipoHldo;
	}

	public String getIdMrca() {
		return idMrca;
	}

	public void setIdMrca(String idMrca) {
		this.idMrca = idMrca;
	}

	public String getIdUnidMedi() {
		return idUnidMedi;
	}

	public void setIdUnidMedi(String idUnidMedi) {
		this.idUnidMedi = idUnidMedi;
	}

	public String getDeObsePedi() {
		return this.deObsePedi;
	}

	public void setDeObsePedi(String deObsePedi) {
		this.deObsePedi = deObsePedi;
	}

	public String getDeProfInvo() {
		return this.deProfInvo;
	}

	public void setDeProfInvo(String deProfInvo) {
		this.deProfInvo = deProfInvo;
	}

	public Date getFePedi() {
		return this.fePedi;
	}

	public void setFePedi(Date fePedi) {
		this.fePedi = fePedi;
	}

	public String getInRegiActi() {
		return this.inRegiActi;
	}

	public void setInRegiActi(String inRegiActi) {
		this.inRegiActi = inRegiActi;
	}

	public String getNoCarg() {
		return this.noCarg;
	}

	public void setNoCarg(String noCarg) {
		this.noCarg = noCarg;
	}

	public BigDecimal getNuAdelPedi() {
		return this.nuAdelPedi;
	}

	public void setNuAdelPedi(BigDecimal nuAdelPedi) {
		this.nuAdelPedi = nuAdelPedi;
	}

	public BigDecimal getNuCantPedi() {
		return this.nuCantPedi;
	}

	public void setNuCantPedi(BigDecimal nuCantPedi) {
		this.nuCantPedi = nuCantPedi;
	}

	public BigDecimal getNuCostCif() {
		return this.nuCostCif;
	}

	public void setNuCostCif(BigDecimal nuCostCif) {
		this.nuCostCif = nuCostCif;
	}

	public BigDecimal getNuCostTota() {
		return this.nuCostTota;
	}

	public void setNuCostTota(BigDecimal nuCostTota) {
		this.nuCostTota = nuCostTota;
	}

	public BigDecimal getNuPrecVent() {
		return this.nuPrecVent;
	}

	public void setNuPrecVent(BigDecimal nuPrecVent) {
		this.nuPrecVent = nuPrecVent;
	}

	public BigDecimal getNuTotaPedi() {
		return this.nuTotaPedi;
	}

	public void setNuTotaPedi(BigDecimal nuTotaPedi) {
		this.nuTotaPedi = nuTotaPedi;
	}
	
	public String getDeHldo() {
		return deHldo;
	}
	
	public void setDeHldo(String deHldo) {
		this.deHldo = deHldo;
	}
	
	public String getNoBnco() {
		return noBnco;
	}
	
	public void setNoBnco(String noBnco) {
		this.noBnco = noBnco;
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