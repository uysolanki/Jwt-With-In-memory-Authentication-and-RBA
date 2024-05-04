package com.greatlearning.batch5Jwt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> adminrole = new ArrayList<>();	        
        adminrole.add(new SimpleGrantedAuthority("ADMIN")); 
        
        List<SimpleGrantedAuthority> userrole = new ArrayList<>();	        
        userrole.add(new SimpleGrantedAuthority("USER")); 
  
        
	if(username.equals("alice"))
	return new User("alice","alice123",adminrole);
	else
	return new User("ben","ben123", userrole);

	}

}
