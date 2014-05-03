package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping( "pages/pagina" )
public class PaginaController{
	
	private final Logger	logger	= LoggerFactory.getLogger( this.getClass() );

	@RequestMapping( value = "otro",  method = RequestMethod.GET )
	public String otro(){
		logger.info( "otro" );
		return "otro";
	}
	
	@RequestMapping( value = "test",  method = RequestMethod.GET )
	public String test(){
		logger.info( "test" );
		return "test";
	}
	
	@RequestMapping( value = "test2/{nombre}")
	public String test2(@PathVariable String nombre, Model model){
		
		model.addAttribute("nombre", nombre);
		
		
		logger.info( "init" );
		return "test";
	}

}
