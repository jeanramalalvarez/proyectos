package com.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

//@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
	
	private String accessDeniedUrl = "otro";

	public MyAccessDeniedHandler() {
	}

	public MyAccessDeniedHandler(String accessDeniedUrl) {
		this.accessDeniedUrl = accessDeniedUrl;
	}

	@Override
	public void handle(HttpServletRequest request,
			           HttpServletResponse response,
			           AccessDeniedException accessDeniedException) throws IOException, ServletException {

		System.out.println("handle");
		response.sendRedirect(accessDeniedUrl);
		request.getSession().setAttribute("message", "You do not have permission to access this page!");

	}

	public String getAccessDeniedUrl() {
		return accessDeniedUrl;
	}

	public void setAccessDeniedUrl(String accessDeniedUrl) {
		this.accessDeniedUrl = accessDeniedUrl;
	}
}