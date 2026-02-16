package com.microservice.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.in.dto.Authrequest;
import com.microservice.in.dto.Authresponse;
import com.microservice.in.dto.RegisterRequest;
import com.microservice.in.entity.User;
import com.microservice.in.service.AuthService;

@RestController
@RequestMapping("/auth")
public class RegistrationandLogin {
	
	@Autowired
	private AuthService authservice;
	
	@PostMapping("/register")
	public ResponseEntity<?>register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(authservice.register(request));
	}
	
	@PostMapping("/login")
	public Authresponse login(@RequestBody Authrequest request) {
		return authservice.login(request);
	}
}
