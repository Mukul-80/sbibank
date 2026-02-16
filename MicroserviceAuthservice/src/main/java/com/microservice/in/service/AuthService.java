package com.microservice.in.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.in.dto.Authrequest;
import com.microservice.in.dto.Authresponse;
import com.microservice.in.dto.RegisterRequest;
import com.microservice.in.entity.User;
import com.microservice.in.repository.UserRepository;
import com.microservice.in.security.JwtUtil;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JwtUtil jwtUtil;
	
	public String register(RegisterRequest request) {
		User user=new User();
		user.setUsername(request.getUsername());
		user.setPassword(encoder.encode(request.getPassword()));
		user.setRole(request.getRole());
		
		userrepository.save(user);
		return "User Registered Successfully";
	}
	
	public Authresponse login(Authrequest request) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
		
		String token=jwtUtil.generateToken(request.getUsername());
		 return new Authresponse(token);
	}
	
	

}
