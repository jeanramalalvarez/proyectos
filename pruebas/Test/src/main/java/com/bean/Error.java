package com.bean;

public class Error {
	
	private String message;
	private String category;
	
	public Error() {
		// TODO Auto-generated constructor stub
	}

	public Error(String message, String category) {
		super();
		this.message = message;
		this.category = category;
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

}
