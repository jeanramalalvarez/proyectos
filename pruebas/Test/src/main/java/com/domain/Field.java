package com.domain;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



public class Field {

	@NotEmpty
	private String label;

	@NotEmpty
	private String type;
	
	private boolean required;
	
	private boolean readOnly;
	
	@NotEmpty
	private String value;
	
	private Integer maxLength;
	
	private String placeholder;
	
	@NotEmpty
	@Valid
	List<Radio> radios;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public List<Radio> getRadios() {
		return radios;
	}

	public void setRadios(List<Radio> radios) {
		this.radios = radios;
	}

}
