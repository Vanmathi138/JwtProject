package com.example.project.entity;

import javax.persistence.Entity ;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Table(name="userInfo")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	
	private String email;

	private String mobileNo;
	
	private String psw;
	private String gender;
	
	private int age;
	
	private String role;
	
}
