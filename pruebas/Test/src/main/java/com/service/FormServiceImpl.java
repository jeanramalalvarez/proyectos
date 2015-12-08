package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.FormDao;
import com.domain.Form;

@Service
public class FormServiceImpl implements FormService {
	
	@Autowired
	private FormDao formDao;
	
	public List<Form> findAll(){
		return formDao.findAll();
	}
	
	public Form findById(String id){
		return formDao.findById(id);
	}
	
	public void insertOrUpdate(Form form){
		formDao.insertOrUpdate(form);
	}
	
	public void delete(Form form){
		formDao.delete(form);	
	}

}
