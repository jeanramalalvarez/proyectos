package com.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Test{

	@NotEmpty
	private String	nombre;

	@Range( min = 18, max = 90 )
	private int		edad;
	
	@NotEmpty
	@Email(message = "no es una dirección de correo válida")
	private String email;

	public String getNombre(){
		return nombre;
	}

	public void setNombre( String nombre ){
		this.nombre = nombre;
	}

	public int getEdad(){
		return edad;
	}

	public void setEdad( int edad ){
		this.edad = edad;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail( String email ){
		this.email = email;
	}

}
