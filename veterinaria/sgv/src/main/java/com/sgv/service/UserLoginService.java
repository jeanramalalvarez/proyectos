package com.sgv.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sgv.dao.UserDetailsDAO;
import com.sgv.domain.UserDetailDomain;

@Service
public class UserLoginService implements UserDetailsService {

	@Autowired
	private UserDetailsDAO userDetailsDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDetailDomain userDetail = userDetailsDAO.getUserDetail(username);

		if (userDetail == null) {
			throw new UsernameNotFoundException("User " + username + " not found");
		}

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<String> roles = userDetailsDAO.getRoles(userDetail.getId());
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}

		return new User(username, userDetail.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

}
