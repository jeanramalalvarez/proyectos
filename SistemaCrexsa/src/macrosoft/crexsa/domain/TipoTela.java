package macrosoft.crexsa.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="tipo_tela")
public class TipoTela implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_tela")
	private Integer idTipoTela;

	@Column(name="co_proc")
	private String coProc;

	@Column(name="de_tela")
	private String deTela;

	@Column(name="de_titu_tela")
	private String deTituTela;

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

	//bi-directional many-to-one association to Color
    @ManyToOne
	@JoinColumn(name="id_colo")
	private Color color;

	public Integer getIdTipoTela() {
		return this.idTipoTela;
	}

	public void setIdTipoTela(Integer idTipoTela) {
		this.idTipoTela = idTipoTela;
	}

	public String getCoProc() {
		return this.coProc;
	}

	public void setCoProc(String coProc) {
		this.coProc = coProc;
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

	public String getDeTela() {
		return this.deTela;
	}

	public void setDeTela(String deTela) {
		this.deTela = deTela;
	}

	public String getDeTituTela() {
		return this.deTituTela;
	}

	public void setDeTituTela(String deTituTela) {
		this.deTituTela = deTituTela;
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

	public String getDeTermCreaCrea() {
		return deTermCreaCrea;
	}

	public void setDeTermCreaCrea(String deTermCreaCrea) {
		this.deTermCreaCrea = deTermCreaCrea;
	}

	public String getDeTermCreaModi() {
		return deTermCreaModi;
	}

	public void setDeTermCreaModi(String deTermCreaModi) {
		this.deTermCreaModi = deTermCreaModi;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}