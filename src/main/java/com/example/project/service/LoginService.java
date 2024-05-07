package com.example.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.project.common.APIResponse;
import com.example.project.dto.LoginRequestDto;
import com.example.project.dto.SignUpRequestDto;

import com.example.project.entity.UserLogin;
import com.example.project.repository.LoginRepository;
import com.example.project.util.JwtUtils;
@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;
	
	@Autowired
	private JwtUtils jwt;

	public APIResponse signup(SignUpRequestDto signUpDto) {
		APIResponse apiResponse = new APIResponse();
		
		UserLogin user=new UserLogin();
		user.setName(signUpDto.getName());
		user.setEmailId(signUpDto.getEmailId());
		user.setPassword(signUpDto.getPassword());
		user.setPhoneNumber(signUpDto.getPhoneNumber());
		user.setGender(signUpDto.getGender());
		user.setIsActive(Boolean.TRUE);
		
		user = repo.save(user);
		apiResponse.setData(user);
		
		//generate jwt Token
		String token = jwt.generatJwt(user);
		
		Map<String , Object> data = new HashMap<String, Object>();
		data.put("accessToken", token);
		
		apiResponse.setData(data);

		return apiResponse;
	}

	public APIResponse login(LoginRequestDto loginDto) {
		APIResponse api = new APIResponse();
		
		//verify user with existing email and password
		UserLogin user = repo.findOneByEmailIdIgnoreCaseAndPassword(loginDto.getEmailId(), loginDto.getPassword());
		
		//response
		if(user == null) {
			api.setData(("User login Failed"));
			return api;
		}
		
		String token = jwt.generatJwt(user);
		
		Map<String , Object> data = new HashMap<String, Object>();
		data.put("accessToken", token);
		
		api.setData(data);
		return api;
	}

	 

}

