package com.med.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.med.module.User;
import com.med.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User u){
		User addingUser=userService.addUser(u);
		return new ResponseEntity<User>(addingUser,HttpStatus.CREATED);
	}
	

	@GetMapping("/login")
	
	public ResponseEntity<Object> login(@RequestHeader String userNameOrEmail,@RequestHeader String password){
		Object o=userService.login(userNameOrEmail,password);
		
		if(o instanceof User) {
			return ResponseEntity.status(200).body(userService.login(userNameOrEmail,password));
		}

		return ResponseEntity.status(400).body(userService.login(userNameOrEmail,password));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> all=userService.getAllUsers();
		return new ResponseEntity<List<User>>(all,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
