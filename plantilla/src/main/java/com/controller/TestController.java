package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Response;
import com.bean.Test;
import com.bean.Test2;
import com.exception.RestSecurityException;
import com.listener.SessionListener;
import com.util.Constantes;
import com.util.Util;

@RestController
@RequestMapping( "api/test" )
//@Scope(value="prototype")
public class TestController{

	private final Logger	logger	= LoggerFactory.getLogger( this.getClass() );
	
	private String			idTransaccion	= ( new Date().getTime() + "" );

	private HttpHeaders		headers;
	
	@Autowired
	private HttpServletRequest request;
	
	//@Autowired
	//private SessionListener sessionListener;

	// @Autowired
	// Constantes constantes;

	List<String>			lista;

	public TestController(){
		logger.info( "TestController" );
		headers = new HttpHeaders();
		headers.add( "Content-Type", Constantes.CONTENT_TYPE_REST_JSON );
		lista = new ArrayList<String>();

		lista.add( "a" );
		lista.add( "b" );
		lista.add( "c" );

	}
	
	@RequestMapping( value = "token", method = RequestMethod.GET )
	public ResponseEntity<Object> getAllToken() throws RestSecurityException{
		logger.info( "getAllToken" );
		HttpStatus status = HttpStatus.OK;
		Response response = null;			
		response = new Response( "", "", true);
		status = HttpStatus.OK;
		return new ResponseEntity<Object>( response, headers, status );
	}

	@RequestMapping( method = RequestMethod.GET )
	public ResponseEntity<Object> getAll(){
		this.idTransaccion	= ( new Date().getTime() + "" );
		this.logger.info( this.idTransaccion + " *********** INICIO: [getAll] ***********" );
		this.logger.info( "getAll" );
		return new ResponseEntity<Object>( lista, headers, HttpStatus.OK );
	}
	
	@RequestMapping( value="login", method = RequestMethod.POST,produces= {"application/json","application/xml"}, 
	         headers = "Accept=application/json,application/xml" )
	public ResponseEntity<Object> login(){
		logger.info( "login" );
		Util.setToken( request.getSession() );
		return new ResponseEntity<Object>( lista, headers, HttpStatus.OK );
	}

	@RequestMapping( value = "{id}", method = RequestMethod.GET )
	public ResponseEntity<Object> get( @PathVariable String id ){
		this.idTransaccion	= ( new Date().getTime() + "" );
		this.logger.info( this.idTransaccion + " *********** INICIO: [get] ***********" );
		this.logger.info( "get" );
		for( String string: lista ){
			if( string.equals( id ) ){
				logger.info( string );
				break;
			}
		}
		return new ResponseEntity<Object>( id, headers, HttpStatus.OK );
	}

	@RequestMapping( method = RequestMethod.POST )
	public ResponseEntity<Object> post( @Valid Test test, BindingResult result ) throws Exception{
		this.idTransaccion	= ( new Date().getTime() + "" );
		logger.info( "post" );
		
		if(result.hasErrors()){
			logger.error("existen " + result.getErrorCount() + " error(es)");
			Response response = Util.getErroresValidacion( result );
			return new ResponseEntity<Object>( response, HttpStatus.BAD_REQUEST );			
		}else{
			throw new Exception("TestController.post - error");
			//return new ResponseEntity<Object>( listResponse, HttpStatus.OK );
		}
	}
	
	@RequestMapping( method = RequestMethod.PUT )
	public ResponseEntity<Object> put( @Valid Test test, BindingResult result ) throws Exception{
		this.idTransaccion	= ( new Date().getTime() + "" );
		logger.info( "put" );
		
		if(result.hasErrors()){
			logger.error("existen " + result.getErrorCount() + " error(es)");
			Response response = Util.getErroresValidacion( result );
			return new ResponseEntity<Object>( response, HttpStatus.BAD_REQUEST );			
		}else{
			throw new Exception("TestController.post - error");
			//return new ResponseEntity<Object>( listResponse, HttpStatus.OK );
		}
	}
	
	@RequestMapping( value = "{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Object> delete( @PathVariable String id ){
		this.idTransaccion	= ( new Date().getTime() + "" );
		logger.info( "delete" );
		for( String string: lista ){
			if( string.equals( id ) ){
				logger.info( string );
				break;
			}
		}
		return new ResponseEntity<Object>( id, headers, HttpStatus.OK );
	}
	
	
	@RequestMapping( value = "test2", 
			         method = RequestMethod.GET, 
			         produces= {"application/json","application/xml"}, 
			         headers = "Accept=application/json,application/xml" )
	public Test2 test2(){

		this.idTransaccion	= ( new Date().getTime() + "" );
		this.logger.info( this.idTransaccion + " *********** INICIO: [test2] ***********" );

		Test2 test2 = null;

		try{
			
			test2 = new Test2();
			test2.setSuccess(true);
			test2.setEdad( 10 );
			test2.setNombre( "jean" );

			this.logger.info( this.idTransaccion + " Busqueda: NOK..." );

		}
		catch( Exception e ){
			this.logger.error( this.idTransaccion + " ERROR [Exception], " + e );
		}
		finally{
			this.logger.info( this.idTransaccion + " *********** FIN: [test2] ***********" );
		}

		logger.info( "init" );
		return test2;
	}

}
