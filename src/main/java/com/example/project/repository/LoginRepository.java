package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.common.APIResponse;
import com.example.project.dto.LoginRequestDto;
import com.example.project.entity.UserLogin;

@Repository
public interface LoginRepository extends JpaRepository<UserLogin, Long> {

	UserLogin findOneByEmailIdIgnoreCaseAndPassword(String emailId, String password);

	

}
