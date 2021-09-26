package com.calcme.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcme.api.model.User;
import com.calcme.api.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void delete(String id) {
		userRepository.deleteById(id);
		
	}
	
	public List<User> list() {
		return userRepository.findAll();
	}
	
	public User search(String id) {
		return userRepository.findById(id).orElse(null);
		
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	
}
