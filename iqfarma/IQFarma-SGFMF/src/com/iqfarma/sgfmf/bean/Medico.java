package com.iqfarma.sgfmf.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jean Ramal Alvarez
 * @since 04/09/2014
 * */
public class Medico implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String codigo;

	private String nombres;

	private String apePaterno;
	
	private String apeMaterno;

	private String cmp;

	private String direccion;

	private Date fechaNacimiento;

	private String correo;

	private String telefono;

	private String celular;

	public Medico() {
		// TODO Auto-generated constructor stub
	}

	public Medico(Long id, String codigo, String nombres, String apePaterno,
			String apeMaterno, String cmp, String direccion,
			Date fechaNacimiento, String correo, String telefono, String celular) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombres = nombres;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.cmp = cmp;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.telefono = telefono;
		this.celular = celular;
	}



	public Medico(String codigo, String nombres) {
		super();
		this.codigo = codigo;
		this.nombres = nombres;
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

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getCmp() {
		return cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
