package com.sgv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.sgv.dao.UserDetailsDAO;
import com.sgv.domain.CustomerDomain;

@Service
public class CustomerService {

	@Autowired
	private UserDetailsDAO userDetailDAO;

	//@Transactional(readOnly = true)
	public List<CustomerDomain> getAllCustomers() {
		return userDetailDAO.getAllCustomers();
	}

	@PreAuthorize(value = "hasRole('ADMIN')")
	public void deleteCustomer(Integer id) {
		userDetailDAO.deleteCustomer(id);

	}

}
