package com.example.project.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.project.util.JwtUtils;


@Component
public class JwtInterceptor implements HandlerInterceptor {
	@Autowired
	private JwtUtils jwt;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
						
		String auth = request.getHeader("authorization");
		
		if(!(request.getRequestURI().contains("login"))) {
			jwt.verify(auth);
		}		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
