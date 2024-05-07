package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.project.common.APIResponse;
import com.example.project.dto.LoginRequestDto;
import com.example.project.dto.SignUpRequestDto;

import com.example.project.service.LoginService;
import com.example.project.util.JwtUtils;

import io.jsonwebtoken.Jwts;



@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@Autowired
	private JwtUtils jwt;
	
	@PostMapping("/signup")
	public ResponseEntity<APIResponse> signup(@RequestBody SignUpRequestDto signUpDto){
		
		APIResponse apiResponse = service.signup(signUpDto);
		
		return ResponseEntity
				.status(apiResponse.getStatus())
				.body(apiResponse);
	}
	
	@PostMapping("/login")
	public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDto loginDto){
		APIResponse api = service.login(loginDto);;
		
		return ResponseEntity
				.status(api.getStatus())
				.body(api);
	}
	
	@GetMapping("/privateApi")
	public ResponseEntity<APIResponse> privateApi(@RequestHeader(value= "authorization",defaultValue = "")String auth) throws Exception{
		APIResponse api = new APIResponse();
		
		jwt.verify(auth);
		api.setData("This is Private api");
		return ResponseEntity.status(api.getStatus()).body(api);
	}
	
	
}
