package com.br.brazilpanels.controllers;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador
 * @proyecto: lotto-mobile
 *
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.brazilpanels.bean.ResultBean;
import com.br.brazilpanels.service.ResultBeanService;

@Controller
public class HomeController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	ResultBeanService resultBeanService;
	
	List<ResultBean> listResultBean;

	@RequestMapping(value="/home")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.info("home.");

        return new ModelAndView("home");
    }
	
	@RequestMapping("/home2")	
	public String home() throws Exception {
		
		logger.info("home2.");
		
		return "home";
	}
	
	@RequestMapping("/home3")	
	public String home(ModelMap model) throws Exception {
		
		logger.info("home3.");    
		//model.addAttribute("message", "Spring 3 MVC Hello World 6");
		
		return "home";
	}
	
	@RequestMapping("/list")	
	public String list(ModelMap model) throws Exception {
		logger.info("list.");

		listResultBean = resultBeanService.findAll();
		model.addAttribute("listResultBean", listResultBean);

		return "list";
	}
	
}