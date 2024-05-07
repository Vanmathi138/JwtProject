package com.example.project.dto;

import lombok.Data;

@Data
public class SignUpRequestDto {
	 	private String name;
	    private String emailId;
	    private String password;
	    private String phoneNumber;
	    private String gender;
}
