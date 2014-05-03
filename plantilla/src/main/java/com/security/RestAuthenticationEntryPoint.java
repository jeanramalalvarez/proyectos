package com.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.bean.Response;
import com.util.Constantes;
import com.util.Util;

/**
 * The Entry Point will not redirect to any sort of Login - it will return the
 * 401
 */
@Component
public final class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	private final Logger	logger	= LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	private Constantes constantes;

	@Override
	public void commence(final HttpServletRequest request,
						 final HttpServletResponse response,
						 final AuthenticationException authException) throws IOException {
		
		logger.info("commence");
		
		/*
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		System.out.println(authException.getMessage());
		System.out.println(request.getContentType());
		System.out.println("status: " + response.getStatus());
		response.sendRedirect(request.getContextPath() + "/pages/pagina/otro");
		if(request.getContentType().indexOf(Constantes.CONTENT_TYPE_REST_JSON) != -1){}
		*/
		
		Response beanResponse = new Response( this.constantes.MENSAJE_SEGURIDAD_AUTENTICACION, "Authentication" );
		response.setStatus(HttpStatus.UNAUTHORIZED.value());

		if(request.getContentType() != null && request.getContentType().indexOf(Constantes.CONTENT_TYPE_REST_XML) != -1){
			response.setContentType(Constantes.CONTENT_TYPE_REST_XML);
			Util.setObjectXmlInOutPutStream(beanResponse,response.getOutputStream());
		}else{
			response.setContentType(Constantes.CONTENT_TYPE_REST_JSON);
			Util.setObjectJsonInOutPutStream(beanResponse,response.getOutputStream());
		}
		
	}

}