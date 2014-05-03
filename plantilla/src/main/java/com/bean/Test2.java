package com.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@XmlRootElement( name="test2" )
@XmlAccessorType( XmlAccessType.NONE )
public class Test2 extends Response {

	@NotEmpty
	@XmlElement( name="nombre" )
	private String	nombre;

	@Range( min = 18, max = 90 )
	@XmlElement( name="edad" )
	private int		edad;
	
	@NotEmpty
	@Email(message = "no es una dirección de correo válida")
	@XmlElement( name="email" )
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
