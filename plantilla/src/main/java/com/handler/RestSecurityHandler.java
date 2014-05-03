package com.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.util.Constantes;
import com.util.Util;

//@Component
public class RestSecurityHandler extends HandlerInterceptorAdapter{
	
	private final Logger	logger	= LoggerFactory.getLogger( this.getClass() );

	@Override
	public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception{
		logger.info( "preHandle" );
		
		String token = request.getHeader( Constantes.TOKEN );
		logger.info( "getHeader " + token );
		
		Util.validarToken( request, token );
		
		return super.preHandle( request, response, handler );
	}
	
	@Override
	public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView ) throws Exception{
		logger.info( "postHandle");
		super.postHandle( request, response, handler, modelAndView );
	}
	
	@Override
	public void afterCompletion( HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex ) throws Exception{
		logger.info( "afterCompletion");
		super.afterCompletion( request, response, handler, ex );
	}
	
	@Override
	public void afterConcurrentHandlingStarted( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception{
		logger.info( "afterConcurrentHandlingStarted");
		super.afterConcurrentHandlingStarted( request, response, handler );
	}
	
	
}
