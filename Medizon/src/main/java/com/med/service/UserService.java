package com.med.service;

import java.util.List;

import com.med.module.User;

public interface UserService {

	public User addUser(User u);

	public Object login(String userNameOrEmail, String password);

	public List<User> getAllUsers();

}
