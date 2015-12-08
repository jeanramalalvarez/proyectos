package com.sgv.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sgv.domain.CustomerDomain;
import com.sgv.service.CustomerService;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(LoginMB.class);

	private String username;
	private String password;

	private List<CustomerDomain> customerList;

	@ManagedProperty(value = "#{authenticationManager}")
	private AuthenticationManager authenticationManager;

	@ManagedProperty(value = "#{customerService}")
	private CustomerService customerService;

	@PostConstruct
	public void init() {
		customerList = customerService.getAllCustomers();
	}

	public void delete(ActionEvent e) {
		customerService.deleteCustomer(1);
	}

	public String login() {
		LOG.info("Starting to login");
		try {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
			Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authenticate);
			return "index";
		} catch (final Exception e) {
			LOG.error("Error log in " + e);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login invalido", "Credenciales incorrectos. Intenta nuevamente"));
		}

		return null;
	}
	
	public void login2() {
		LOG.info("Starting to login");
		try {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
			Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authenticate);
			//return "index";
		} catch (final Exception e) {
			LOG.error("Error log in " + e);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login invalido", "Credenciales incorrectos. Intenta nuevamente"));
		}

		//return null;
	}

	public String logout() {
		SecurityContextHolder.clearContext();
		return "login";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}
	
	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public List<CustomerDomain> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerDomain> customerList) {
		this.customerList = customerList;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
