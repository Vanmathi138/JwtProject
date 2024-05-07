package com.example.project.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserInfoDto {

	private int id;
	
	@NotNull(message = "UserName shouldn't be null")
	private String name;
	
	@Email(message = "Invalid Email address")
	private String email;
	
	@Pattern(regexp = "^\\d{10}$",message = "Invalid mobile number")
	private String mobileNo;
	
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}",message = "Password must meet complexity requirements" )
	private String psw;
	
	private String gender;
	
	private int age;
	
	@NotBlank
	private String role;
}
