package com.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.dao.UserRepository;
import com.crud.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(int id) {
		
		Optional<User> useroptional=userRepository.findById(id);
		if(useroptional.isPresent()){
			return useroptional.get();
		}
		return null;
	}

	@Override
	public List<User> getAllUser() {
	    return userRepository.findAll();
		
	}

	@Override
	public void deleteById(int userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public User updateUser(User user) {
		
		return userRepository.save(user);
	}

}
