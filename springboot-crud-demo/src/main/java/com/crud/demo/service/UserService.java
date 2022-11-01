package com.crud.demo.service;

import java.util.List;

import com.crud.demo.entity.User;

public interface UserService {

	public User saveUser(User user);

	public User getUserById(int id);

	public List<User> getAllUser();

	public void deleteById(int userId);

	public User updateUser(User user);
	
	
}
