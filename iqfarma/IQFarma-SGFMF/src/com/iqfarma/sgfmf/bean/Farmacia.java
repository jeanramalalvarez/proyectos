package com.iqfarma.sgfmf.bean;

import java.io.Serializable;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class Farmacia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String codigo;
	
	private String razonSocial;
	
	private String ruc;
	
	private String direccion;
	
	private String telefono;

	public Farmacia(Long id, String codigo, String razonSocial, String ruc,
			String direccion, String telefono) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.razonSocial = razonSocial;
		this.ruc = ruc;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
