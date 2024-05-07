package com.example.project.advice;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.project.exception.UserNotFoundException;
@RestControllerAdvice
public class UserExceptionHandler {
		
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public Map<String,String> handleInvalidException(MethodArgumentNotValidException ex){
			Map<String,String> errorMap = new HashMap<>();
			ex.getBindingResult().getFieldErrors().forEach(error->{
				errorMap.put(error.getField(), error.getDefaultMessage());
			});	
			return errorMap;
		}

		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(UserNotFoundException.class)
		public Map<String,String> handleException(UserNotFoundException exception){
			Map<String,String> errorMsg = new HashMap<>();
			errorMsg.put("errorMessage", exception.getMessage());
			return errorMsg;
	}
}




