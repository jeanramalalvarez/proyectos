package com.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.Error;
import com.bean.Errors;
import com.domain.Form;
import com.service.FormService;

@Controller
@RequestMapping("/coletor")
public class FormController {
	
	private final Logger logger = LoggerFactory.getLogger(FormController.class);
	@Autowired
	private FormService formService;
	private Errors errors;
	private List<Error> listError;
	private HttpHeaders headers;
	
	public FormController() {
		errors = new Errors();
		headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
	}
	
	@RequestMapping(value="templates", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getTemplates() {

		logger.info("");
		
		listError = new ArrayList<Error>();
		
		List<Form> list = formService.findAll();

		return new ResponseEntity<Object>(list, headers,HttpStatus.OK);

	}
	
	@RequestMapping(value="templates/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getTemplatesById(@PathVariable String id) {
			
		logger.info(" - id : " + id);
		
		listError = new ArrayList<Error>();

		Form form = formService.findById(id);
		return new ResponseEntity<Object>(form, headers, HttpStatus.OK);

	}
	
	@RequestMapping(value="templates", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> addTemplates(Form form) {
			
		logger.info(" - form data : " + form.toString());
		
		listError = new ArrayList<Error>();
		
		//validate(form);
		
		if(listError.size() > 0) {
			errors.setErrors(listError);		
			return new ResponseEntity<Object>(errors, headers, HttpStatus.BAD_REQUEST);
		}
		
		formService.insertOrUpdate(form);

		return new ResponseEntity<Object>(form, headers,HttpStatus.OK);

	}
	
	@RequestMapping(value="templates/{id}", method = RequestMethod.PUT)
	// same as above method, just showing different URL mapping
    //@RequestMapping(value="person", params="id") --> @RequestParam
	@ResponseBody
	public ResponseEntity<Object> setTemplatesById(@PathVariable String id, Form form) {

		form.setId(id);
		logger.info(" - form data : " + form.toString());
		
		listError = new ArrayList<Error>();
		
		if (form.getId() == null || form.getId().equals("")) {
			listError.add(new Error("<id>","Preencher o campo Id do Formulário"));
		}
		
		//validate(form);
		
		if (formService.findById(form.getId()) == null) {
			listError.add(new Error("<id>","O Formulário não existe"));
		}
		

		if(listError.size() > 0) {
			errors.setErrors(listError);		
			return new ResponseEntity<Object>(errors, headers, HttpStatus.BAD_REQUEST);
		}
		
		formService.insertOrUpdate(form);

		return new ResponseEntity<Object>(form, headers,HttpStatus.OK);

	}
	
	@RequestMapping(value="templates/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Object> removeTemplatesById(@PathVariable String id) {		
			
		logger.info(" - id : " + id);
		
		listError = new ArrayList<Error>();
		
		if (id == null || id.equals("")) {
			listError.add(new Error("<id>","Preencher o campo Id do Formulário"));
		}
		
		
		Form form = formService.findById(id);
		
		if (form == null) {
			listError.add(new Error("<id>","O Formulário não existe"));
		}
		
		if(listError.size() > 0) {
			errors.setErrors(listError);		
			return new ResponseEntity<Object>(errors, headers, HttpStatus.BAD_REQUEST);
		}
		
		
		formService.delete(form);

		return new ResponseEntity<Object>(headers,HttpStatus.OK);

	}

	/*
	@RequestMapping(value="template/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String get(@PathVariable String name, ModelMap model) {

		model.addAttribute("test", name);
		return "test";

	}
	*/
	/*
	private void validate (Form form) {
		
		if (form.getTitle() == null || form.getTitle().equals("")) {
			listError.add(new Error("<title>","Preencher o campo Título do Formulário"));
		}
		
		if (form.getFields() == null || form.getFields().size() == 0) {
			listError.add(new Error("<fields>","Deve conter ao menos um campo"));
		} else {
			for (Field field: form.getFields()) {
				if (field.getLabel() == null || field.getLabel().equals("")) {
					listError.add(new Error("<label>","O campo LABEL é obrigatório"));	
				}
				if (field.getType() == null || field.getType().equals("")) {
					listError.add(new Error("<type>","O campo TIPO é obrigatório"));
				} else {
					if (field.getType().equals("radio")) {
						if (field.getRadios() == null || field.getRadios().size() == 0) {
							listError.add(new Error("<radios>","O RADIOS deve conter ao menos um elemento"));
						} else {
							for (Radio radio: field.getRadios()) {
								if(radio.getLabel() == null || radio.getLabel().equals("")) {
									listError.add(new Error("<label>","O campo LABEL é obrigatório"));	
								}
								if(radio.getValue() == null || radio.getValue().equals("")) {
									listError.add(new Error("<value>","O campo VALUE é obrigatório"));	
								}
							}
						}
					}
				}
			}
		}
		
	}
	*/
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleAllException(ConstraintViolationException e) {
		listError = new ArrayList<Error>();
		Set<ConstraintViolation<?>> list = e.getConstraintViolations();
    	for (ConstraintViolation<?> constraintViolation : list) {
    		listError.add(new Error("<"+constraintViolation.getPropertyPath()+">",constraintViolation.getMessage()));
		}
		errors.setErrors(listError);		
		return new ResponseEntity<Object>(errors, headers,HttpStatus.BAD_REQUEST);
	}	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception e) {
		logger.error(e.getLocalizedMessage(), e);
		listError = new ArrayList<Error>();
		headers.add("ExceptionCause", e.getMessage());
		headers.add("ExceptionClass", e.getClass().getName());
		
		listError.add(new Error("Exception",e.getMessage()));
		errors.setErrors(listError);		
		return new ResponseEntity<Object>(errors, headers,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}