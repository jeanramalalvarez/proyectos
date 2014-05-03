package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bean.Response;
import com.util.Constantes;

@ControllerAdvice
public class ErrorController{
	
	private final Logger	logger	= LoggerFactory.getLogger( this.getClass() );
	
	private HttpHeaders		headers;
	
	public ErrorController(){
		logger.info( "ErrorController" );
		headers = new HttpHeaders();
		headers.add( "Content-Type", Constantes.CONTENT_TYPE_REST_JSON );
	}

	@ExceptionHandler( Exception.class )
	public ResponseEntity<Object> handleAllException( Exception e ){
		//logger.error( e.getMessage());
		logger.error( e.getLocalizedMessage(), e );
		headers.add( "ExceptionCause", e.getMessage() );
		headers.add( "ExceptionClass", e.getClass().getName() );
		headers.add( "Content-Type", Constantes.CONTENT_TYPE_REST_JSON );
		
		Response response = null;
		
		response = new Response( e.getMessage(), "Exception" );
		/*
		if(e instanceof HttpMediaTypeNotAcceptableException ){
			headers.add("Accept", Constantes.CONTENT_TYPE_REST_JSON );
			headers.add( "Content-Type", Constantes.CONTENT_TYPE_REST_JSON );
			response = new Response( e.getMessage(), "HttpMediaTypeNotAcceptableException" );
		}
		else{
			response = new Response( e.getMessage(), "Exception" );
		}
		*/
		return new ResponseEntity<Object>( response, headers, HttpStatus.INTERNAL_SERVER_ERROR );
	}

}
