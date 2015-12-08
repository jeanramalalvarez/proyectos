package com.sgv.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sgv.domain.CustomerDomain;
import com.sgv.domain.UserDetailDomain;

@Repository
public class UserDetailsDAO {

	public List<String> getRoles(final int id){
		List<String> lista = new ArrayList<String>();
		//lista.add("ROLE_ADMIN");
		lista.add("ROLE_MODERATOR");
		lista.add("ROLE_VIEWER");
		return lista;
	}

	public UserDetailDomain getUserDetail(final String username){
		UserDetailDomain userDetailDomain = new UserDetailDomain();
		userDetailDomain.setId(1);
		userDetailDomain.setUsername("admin");
		userDetailDomain.setPassword("admin");
		return userDetailDomain;
	}
	
	public List<CustomerDomain> getAllCustomers(){
		return null;
	}
	
	public void deleteCustomer(final Integer id){
		
	}

}
