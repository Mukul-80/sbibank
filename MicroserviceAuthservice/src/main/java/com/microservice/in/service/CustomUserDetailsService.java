package com.microservice.in.service;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservice.in.entity.User;
import com.microservice.in.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userrepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		User user=(User) userrepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
		
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(user.getRole());
		
		return new org.springframework.security.core.userdetails.
				User(user.getUsername(),user.getPassword(),
						Collections.singletonList(authority));
	}
}
