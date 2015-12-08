package com.iqfarma.sgfmf.bean;

import java.io.Serializable;

/**
 * @author Jean Ramal Alvarez
 * @since 16/09/2014
 * */
public class Motivo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String motivo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	

}
