package com.example.project.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.common.APIResponse;
import com.example.project.dto.UserInfoDto;
import com.example.project.entity.UserInfo;
import com.example.project.exception.UserNotFoundException;
import com.example.project.service.UserInfoService;

@RestController
@RequestMapping("/api/userInfo")
public class UserInfoController {
	@Autowired
	private UserInfoService service;
	
	@PostMapping("/userDetails")
	public ResponseEntity<UserInfo> create(@RequestBody @Valid UserInfoDto dto){
		return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<UserInfo>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Optional<UserInfo>> getById(@PathVariable int id) throws UserNotFoundException{
		return ResponseEntity.ok(service.getById(id));
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}
}
