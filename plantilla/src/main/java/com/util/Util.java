package com.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.bean.Response;
import com.exception.RestSecurityException;

public class Util{
	
	private static final Logger	logger	= LoggerFactory.getLogger( Util.class );   

	public static Response getErroresValidacion( BindingResult result ){

		Response response = new Response( "Error de Validación", "Validation", false );

		List<Response> listError = new ArrayList<Response>();

		List<FieldError> lista = result.getFieldErrors();
		for( FieldError fieldError: lista ){
			listError.add( new Response( "El campo " + fieldError.getField() + " " + fieldError.getDefaultMessage(), "Validation", fieldError.getField() ) );
		}

		response.setListResponse( listError );
		return response;
	}

	public static void setObjectXmlInOutPutStream(Object object, OutputStream os) {
		logger.info("ObjectXmlInOutPutStream()");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(object, os);
		} catch (JAXBException e) {
			logger.error(e.getMessage());
		}
	}

	public static void setObjectJsonInOutPutStream(Object object, OutputStream os) {
		logger.info("ObjectJsonInOutPutStream()");

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(os, object);
		} catch (JsonGenerationException e) {
			logger.error(e.getMessage());
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

	}

	public static String getToken(){
		return UUID.randomUUID().toString();
	}

	public static void setToken( HttpSession session ){
		String token = getToken();
		logger.info( Constantes.TOKEN + " = " + token );
		session.setAttribute( Constantes.TOKEN, token );
	}

	public static void validarToken( HttpServletRequest request, String token ) throws RestSecurityException {
		if( request.getSession().getAttribute( Constantes.TOKEN ) == null ){
			throw new RestSecurityException();
		}
		else if( !request.getSession().getAttribute( Constantes.TOKEN ).toString().equals( token ) ){
			throw new RestSecurityException();
		}
	}

}
