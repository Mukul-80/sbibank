package com.microservice.in.security;

import java.io.IOException;

import javax.naming.AuthenticationException;

import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

		    public void commence(HttpServletRequest request,HttpServletResponse response, AuthenticationException ex) throws IOException {

		        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
		                "Unauthorized Access");
		    }

			@Override
			public void commence(HttpServletRequest request, HttpServletResponse response,
					org.springframework.security.core.AuthenticationException authException)
					throws IOException, ServletException {
				// TODO Auto-generated method stub
				
			}
}
