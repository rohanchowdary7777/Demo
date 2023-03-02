package com.med.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.module.User;
import com.med.repo.UserRepo;
import com.med.service.UserService;

@Service
public class UserImplementation implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return userRepo.save(u);
	}

	@Override
	public Object login(String userNameOrEmail, String password) {
		// TODO Auto-generated method stub
		User u=userRepo.findByUserNameOrEmail(userNameOrEmail,password);
		System.out.println(u);
		if(password.equals(u.getPassword()+"")) {
			return u;
		}
		
		return null;
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> all=userRepo.findAll();
		return all;
	}

	
	
}
