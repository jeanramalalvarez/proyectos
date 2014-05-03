package com.bean;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name="response" )
@XmlAccessorType( XmlAccessType.NONE )
public class Response {
	
	@XmlElement( name="message" )
	private String message;
	
	@XmlElement( name="category" )
	private String category;
	
	@XmlElement( name="field" )
	private String field;
	
	@XmlElement( name="success" )
	private boolean success;
	
	@XmlElement( name="listResponse" )
	List<Response> listResponse;
	
	public Response() {
	}
	
	public Response(String message, String category, String field, boolean success) {
		super();
		this.message = message;
		this.category = category;
		this.field = field;
		this.success = success;
	}
	
	public Response(String message, String category, String field) {
		super();
		this.message = message;
		this.category = category;
		this.field = field;
	}

	public Response(String message, String category, boolean success) {
		super();
		this.message = message;
		this.category = category;
	}
	
	public Response(String message, String category) {
		super();
		this.message = message;
		this.category = category;
	}
	
	public Response(String message, boolean success) {
		super();
		this.message = message;
	}
	
	public Response(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getField(){
		return field;
	}
	
	public void setField( String field ){
		this.field = field;
	}
	
	public boolean getSuccess(){
		return success;
	}
	
	public void setSuccess( boolean success ){
		this.success = success;
	}
	
	public List<Response> getListResponse(){
		return listResponse;
	}
	
	public void setListResponse( List<Response> listResponse ){
		this.listResponse = listResponse;
	}

}
