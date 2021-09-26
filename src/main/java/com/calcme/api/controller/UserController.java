package com.calcme.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calcme.api.model.User;
import com.calcme.api.service.UserService;

@CrossOrigin("localhost:4200")
@RestController
@RequestMapping(value = "/api/usuario")
public class UserController  {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
		
	}
	
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable String id) {
		userService.delete(id);
	}
	
	@GetMapping
	public List<User> list(){
		 return userService.list();
	}	
	
	@PostMapping
	public  User save(@RequestBody User user){
	 return userService.save(user);
	}
	
	@GetMapping(value = "{id}")
	public User search(@PathVariable String id) {
		return userService.search(id);
	}
	
}
