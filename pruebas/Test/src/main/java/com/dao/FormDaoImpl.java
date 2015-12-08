package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Form;

@Repository
@Scope("prototype")
public class FormDaoImpl implements FormDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Form> findAll(){
		return mongoTemplate.findAll(Form.class);
	}
	
	public Form findById(String id){
		return mongoTemplate.findById(id, Form.class);
	}
	
	public void insertOrUpdate(Form form){
		mongoTemplate.save(form);
	}
	
	public void delete(Form form){
		mongoTemplate.remove(form);	
	}

}
