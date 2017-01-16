package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.database.UserRepository;
import com.test.model.User;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@RequestMapping(value="/save" , method = RequestMethod.POST)
	public String saveUser(@RequestBody User user){
		System.out.println("User request body is "+user.getName()+" - "+user.getNickname());

		repository.save(user);
		return "Success";
	}
	
	@RequestMapping(value="/retreive" , method = RequestMethod.GET)
	public List<User> saveUser(@RequestParam(value="name") String name){
		System.out.println("request param is "+name);
		
		List<User> users = repository.findByName(name);
		return users;
	}
	
}
