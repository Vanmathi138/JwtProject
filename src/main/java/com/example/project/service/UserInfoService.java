package com.example.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.project.common.APIResponse;
import com.example.project.dto.UserInfoDto;
import com.example.project.entity.UserInfo;
import com.example.project.exception.UserNotFoundException;
import com.example.project.repository.UserInfoRepository;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoRepository repo;
	
	public UserInfo create(UserInfoDto dto) {
		UserInfo user=UserInfo.build(0, dto.getName(), dto.getEmail(),dto.getMobileNo(),
						dto.getPsw(),dto.getGender(),dto.getAge(),dto.getRole());
		return repo.save(user);
	}

	public List<UserInfo> getAll() {
		return repo.findAll();
	}

	public Optional<UserInfo> getById(int id) throws UserNotFoundException {
		Optional<UserInfo> user = repo.findById(id);
		if(user!=null) {
			return user;
		}else {
			throw new UserNotFoundException("User not in found "+id);
		}
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
	
}
