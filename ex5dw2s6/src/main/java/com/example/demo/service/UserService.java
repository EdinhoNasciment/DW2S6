package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.example.demo.domain.model.User;
import com.example.demo.repository.UserRepository;

public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User update(Long id, User user) {
		User userSaved = userRepository.findById(id).orElseThrow(
				()->new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(user, userSaved,"id");
		return userRepository.save(userSaved);
	}
	
	public User findUserById(Long id) {
		User userSaved = userRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return userSaved;
	}
	
}
