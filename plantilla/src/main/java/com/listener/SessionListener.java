package com.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.util.Constantes;

//@Component
public class SessionListener implements HttpSessionListener{

	private final Logger	logger	= LoggerFactory.getLogger( this.getClass() );

	private static int		totalActiveSessions;
	
	public SessionListener() {
		logger.info("SessionListener" + totalActiveSessions);
	}

	public static int getTotalActiveSession(){
		return totalActiveSessions;
	}

	@Override
	public void sessionCreated( HttpSessionEvent arg0 ){
		logger.info( "sessionCreated con token: " + arg0.getSession().getAttribute( Constantes.TOKEN ) );
		totalActiveSessions++;
	}

	@Override
	public void sessionDestroyed( HttpSessionEvent arg0 ){
		logger.info( "sessionDestroyed con token: " + arg0.getSession().getAttribute( Constantes.TOKEN ) );
		totalActiveSessions--;
	}

}
