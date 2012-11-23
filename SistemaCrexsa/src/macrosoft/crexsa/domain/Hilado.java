package macrosoft.crexsa.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Hilado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_hldo")
	private Integer idHldo;

	@Column(name="co_esta_pedi")
	private String coEstaPedi;

	@Column(name="co_hldo")
	private String coHldo;

	@Column(name="co_unid_medi")
	private String coUnidMedi;

	@Column(name="de_bill_ladi")
	private String deBillLadi;

	@Column(name="de_come_invo")
	private String deComeInvo;

	@Column(name="de_doc_dhl")
	private String deDocDhl;

	@Column(name="de_obse")
	private String deObse;

    @Temporal( TemporalType.DATE)
	@Column(name="fe_rece")
	private Date feRece;

	@Column(name="id_marc")
	private Integer idMarc;

	@Column(name="no_nave")
	private String noNave;

	@Column(name="nu_cant_neto")
	private BigDecimal nuCantNeto;

	@Column(name="nu_cont")
	private String nuCont;
	
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

	/*
    @ManyToOne
	@JoinColumn(name="id_tipo_tran")
	private TipoTransaccion tipoTransaccion;

	@ManyToOne
	@JoinColumn(name="nu_pedi")
	private Pedido pedido;
    */

	public Integer getIdHldo() {
		return this.idHldo;
	}

	public void setIdHldo(Integer idHldo) {
		this.idHldo = idHldo;
	}

	public String getCoEstaPedi() {
		return this.coEstaPedi;
	}

	public void setCoEstaPedi(String coEstaPedi) {
		this.coEstaPedi = coEstaPedi;
	}

	public String getCoHldo() {
		return this.coHldo;
	}

	public void setCoHldo(String coHldo) {
		this.coHldo = coHldo;
	}

	public String getCoUnidMedi() {
		return this.coUnidMedi;
	}

	public void setCoUnidMedi(String coUnidMedi) {
		this.coUnidMedi = coUnidMedi;
	}

	public String getDeBillLadi() {
		return this.deBillLadi;
	}

	public void setDeBillLadi(String deBillLadi) {
		this.deBillLadi = deBillLadi;
	}

	public String getDeComeInvo() {
		return this.deComeInvo;
	}

	public void setDeComeInvo(String deComeInvo) {
		this.deComeInvo = deComeInvo;
	}

	public String getDeDocDhl() {
		return this.deDocDhl;
	}

	public void setDeDocDhl(String deDocDhl) {
		this.deDocDhl = deDocDhl;
	}

	public String getDeObse() {
		return this.deObse;
	}

	public void setDeObse(String deObse) {
		this.deObse = deObse;
	}

	public Date getFeRece() {
		return this.feRece;
	}

	public void setFeRece(Date feRece) {
		this.feRece = feRece;
	}

	public Integer getIdMarc() {
		return this.idMarc;
	}

	public void setIdMarc(Integer idMarc) {
		this.idMarc = idMarc;
	}

	public String getNoNave() {
		return this.noNave;
	}

	public void setNoNave(String noNave) {
		this.noNave = noNave;
	}

	public BigDecimal getNuCantNeto() {
		return this.nuCantNeto;
	}

	public void setNuCantNeto(BigDecimal nuCantNeto) {
		this.nuCantNeto = nuCantNeto;
	}

	public String getNuCont() {
		return this.nuCont;
	}

	public void setNuCont(String nuCont) {
		this.nuCont = nuCont;
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