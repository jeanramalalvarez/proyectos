package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.domain.Field;
import com.domain.Form;
import com.domain.Radio;
import com.service.FormService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/resources/application-context.xml" })
public class IntegrationTest {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	MongoOperations mongoOperations;
	
	@Autowired
	FormService formService;
	
	@Test
	public void findAllForm() {
		List<Form> forms = formService.findAll();
		assertNotNull(forms);
		//assertEquals(5, forms.size());
	}
	
	//@Test
	public void findFormById() {
		Form form = formService.findById("5257094fb60074a1bdf946e3");
		assertNotNull(form);
	}
	
	//@Test
	public void findFormById2() {
		BasicQuery query = new BasicQuery("{ id : '5257094fb60074a1bdf946e3' }");
		Form form = mongoOperations.findOne(query, Form.class);
		assertNotNull(form);
	}
	
	//@Test
	public void findFormById3() {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is("52570962b600b8e597544ddb").and("title").is("titutlo del formulario 3"));
		Form form = mongoTemplate.findOne(query, Form.class);
		assertNotNull(form);
	}
	
	//@Test
	public void insertForm() {

		Form form = new Form();
		form.setTitle("titutlo del formulario 3");
		
		Field field = new Field();
		field.setLabel("label");
		field.setValue("value");
		
		List<Radio> radios = new ArrayList<Radio>();
		Radio radio = new Radio();
		radio.setLabel("radio label");
		radio.setValue("value");
		radios.add(radio);
		field.setRadios(radios);
		
		
		List<Field> fields = new ArrayList<Field>();
		fields.add(field);
		form.setFields(fields);
		formService.insertOrUpdate(form);

	}
	
	//@Test
	public void updateFormBy() {
		Form form = formService.findById("5257094fb60074a1bdf946e3");
		assertNotNull(form);
		form.setTitle("titulo modificado");
		formService.insertOrUpdate(form);
		
		Query query = new Query();
		query.addCriteria(Criteria.where("title").is("titulo modificado"));
		Form form2 = mongoTemplate.findOne(query, Form.class);
		assertNotNull(form2);
	}
	
	@Test
	public void deleteFormById() {
		Form form = new Form();
		form.setId("52570924b60087e6e260fe67");
		formService.delete(form);
		assertNotNull(form);
	}
	
	@Test
	public void getLastError(){
		assertEquals(null, mongoTemplate.getDb().getLastError().getErrorMessage());
	}
	
	@Test
    public void shouldThrowValidationException() {
		Form form = new Form();
		form.setTitle("titulo");
		
		List<Field> fields = new ArrayList<>();
		
		Field field = new Field();
		field.setType("sss");
		field.setLabel("ddd");
		field.setValue("sss");
		
		List<Radio> radios = new ArrayList<Radio>();
		
		Radio radio = new Radio();
		radio.setLabel("ddd");
		radio.setValue("sss");
		radios.add(radio);
		field.setRadios(radios);
		fields.add(field);
		form.setFields(fields);
		
		
        try {
        	formService.insertOrUpdate(form);
            //fail();
        } catch (ConstraintViolationException e) {
        	/*
        	
        	ConstraintViolationImpl{
        		interpolatedMessage='não pode ser nulo', 
        		propertyPath=title, 
        		rootBeanClass=class com.domain.Form, 
        		messageTemplate='{javax.validation.constraints.NotNull.message}'}, 
        		ConstraintViolationImpl{interpolatedMessage='não pode estar vazio', propertyPath=fields, rootBeanClass=class com.domain.Form, messageTemplate='{org.hibernate.validator.constraints.NotEmpty.message}'}, ConstraintViolationImpl{interpolatedMessage='não pode estar vazio', propertyPath=title, rootBeanClass=class com.domain.Form, messageTemplate='{org.hibernate.validator.constraints.NotEmpty.message}'}, ConstraintViolationImpl{interpolatedMessage='não pode ser nulo', propertyPath=fields, rootBeanClass=class com.domain.Form, messageTemplate='{javax.validation.constraints.NotNull.message}'}]
        	*/        						
        	//System.out.println(e.getConstraintViolations());
        	Set<ConstraintViolation<?>> list = e.getConstraintViolations();
        	for (ConstraintViolation<?> constraintViolation : list) {
        		System.out.println(constraintViolation.getRootBeanClass()+ " " + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
			}
        	
        	//assertNotNull(e);
            //assertThat(e.getViolations()).hasSize(2);
        }
    }
	

}
