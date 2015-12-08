package com.domain;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "form")
public class Form {
	
	@Id
	private String id;
	
	@NotEmpty
	private String title;

	@NotEmpty
	@Valid
	List<Field> fields;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Field> getFields() {
		return fields;
	}
	
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
	@Override
	public String toString() {
		int size = 0;
		if(fields!=null) size = fields.size();
		return "id: " + id + ", title: " + title + ", fields.size: " + size;
	}

}
