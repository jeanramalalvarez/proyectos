package com.iqfarma.sgfmf.bean;

import java.io.Serializable;

/**
 * @author Jean Ramal Alvarez
 * @since 15/09/2014
 * */
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nombre;
	
	private int cantidad;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
