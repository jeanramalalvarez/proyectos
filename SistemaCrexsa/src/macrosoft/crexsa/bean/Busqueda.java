package macrosoft.crexsa.bean;

import java.util.Date;

public class Busqueda {
	
	private Date fecInicial;
	private Date fecFinal;
	private Integer nuPedi;
	private String deMrca;
	
	public Date getFecInicial() {
		return fecInicial;
	}
	public void setFecInicial(Date fecInicial) {
		this.fecInicial = fecInicial;
	}
	public Date getFecFinal() {
		return fecFinal;
	}
	public void setFecFinal(Date fecFinal) {
		this.fecFinal = fecFinal;
	}
	public Integer getNuPedi() {
		return nuPedi;
	}
	public void setNuPedi(Integer nuPedi) {
		this.nuPedi = nuPedi;
	}
	public String getDeMrca() {
		return deMrca;
	}
	public void setDeMrca(String deMrca) {
		this.deMrca = deMrca;
	}

}
