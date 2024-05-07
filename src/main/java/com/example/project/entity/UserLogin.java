package com.example.project.entity;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.example.project.common.Constant;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="UserLogin")
public class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String name;
	    private String emailId;
	    private String password;
	    private String phoneNumber;
	    private String gender;
	    private String userType = Constant.USER_TYPE.NORMAL;
	    private Boolean isActive = true;
	    private Integer loginCount = 0;
	    private String ssoType;

}

