package com.service;

import java.util.List;

import com.domain.Form;

public interface FormService {
	
	List<Form> findAll();
	
	Form findById(String id);
	
	void insertOrUpdate(Form form);
	
	void delete(Form form);

}
