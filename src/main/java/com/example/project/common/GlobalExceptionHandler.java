package com.example.project.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity handleAccessDeniedException(AccessDeniedException ex) {
		APIResponse api = new APIResponse();
		api.setStatus(HttpStatus.UNAUTHORIZED.value());
		
		return ResponseEntity.status(api.getStatus()).body(api);
	
		
	}
}
