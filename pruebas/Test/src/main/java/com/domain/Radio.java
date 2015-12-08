package com.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class Radio {
	
	@NotEmpty
	private String label;
	
	@NotEmpty
	private String value;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
