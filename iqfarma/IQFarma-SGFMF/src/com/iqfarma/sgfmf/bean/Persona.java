package com.iqfarma.sgfmf.bean;

import java.io.Serializable;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String apellidos;

	private Integer edad;

	private String nombres;

	public Persona() {
	}

	public Persona(String nombres, String apellidos, Integer edad) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	public Persona(Long id, String nombres, String apellidos, Integer edad) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@Override
	public String toString() {
		return "Persona [nombres=" + nombres + ", apellidos=" + apellidos
				+ ", edad=" + edad + ", id=" + id + "]";
	}

}