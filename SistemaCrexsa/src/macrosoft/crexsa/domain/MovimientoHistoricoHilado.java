package macrosoft.crexsa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="movimiento_historico_hilado")
public class MovimientoHistoricoHilado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_movi_hist")
	private Integer idMoviHist;
	
	@Column(name="id_tipo_tran")
	private Integer idTipoTran;
	
	@Column(name="id_hldo")
	private Integer idHldo;
	
	@Column(name="co_unid_medi")
	private String coUnidMedi;
	
	@Column(name="co_enti_orig")
	private String coEntiOrig;

	@Column(name="co_enti_dest")
	private String coEntiDest;

	@Column(name="nu_sald")
	private BigDecimal nuSald;
	
	@Column(name="nu_cant")
	private BigDecimal nuCant;
	
    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fe_movi")
	private Date feMovi;

	public Integer getIdMoviHist() {
		return idMoviHist;
	}

	public void setIdMoviHist(Integer idMoviHist) {
		this.idMoviHist = idMoviHist;
	}

	public Integer getIdTipoTran() {
		return idTipoTran;
	}

	public void setIdTipoTran(Integer idTipoTran) {
		this.idTipoTran = idTipoTran;
	}

	public Integer getIdHldo() {
		return idHldo;
	}

	public void setIdHldo(Integer idHldo) {
		this.idHldo = idHldo;
	}

	public String getCoUnidMedi() {
		return coUnidMedi;
	}

	public void setCoUnidMedi(String coUnidMedi) {
		this.coUnidMedi = coUnidMedi;
	}

	public String getCoEntiOrig() {
		return coEntiOrig;
	}

	public void setCoEntiOrig(String coEntiOrig) {
		this.coEntiOrig = coEntiOrig;
	}

	public String getCoEntiDest() {
		return coEntiDest;
	}

	public void setCoEntiDest(String coEntiDest) {
		this.coEntiDest = coEntiDest;
	}

	public BigDecimal getNuSald() {
		return nuSald;
	}

	public void setNuSald(BigDecimal nuSald) {
		this.nuSald = nuSald;
	}

	public BigDecimal getNuCant() {
		return nuCant;
	}

	public void setNuCant(BigDecimal nuCant) {
		this.nuCant = nuCant;
	}
	
	public Date getFeMovi() {
		return feMovi;
	}
	
	public void setFeMovi(Date feMovi) {
		this.feMovi = feMovi;
	}

}