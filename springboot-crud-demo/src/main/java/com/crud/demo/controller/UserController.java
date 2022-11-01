package com.crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.entity.User;
import com.crud.demo.errorMsg.MessageResponse;
import com.crud.demo.service.UserService;

@RestController
public class UserController {
    
	@Autowired
	private UserService userService;
	
	// to add new User
	@PostMapping("/addUser")
	public ResponseEntity<?> createNewUser(@RequestBody User user){
     User creatUser = userService.saveUser(user);
     return new ResponseEntity<Object>(creatUser,HttpStatus.CREATED);	
	}
	
	//to get the element by id
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") int id){
		User getUser=userService.getUserById(id);
		if(getUser==null) {
			   MessageResponse messageResponse = new MessageResponse();
	            messageResponse.setMessage("User not found.");
	            return new ResponseEntity<Object>(messageResponse, HttpStatus.NOT_FOUND);
			
		}else {
			return new ResponseEntity<Object>(getUser,HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllUser(){
		List<User> userList=userService.getAllUser();
		return new ResponseEntity<Object>(userList,HttpStatus.OK);	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int userId){
		     userService.deleteById(userId);
		     MessageResponse messageResponse = new MessageResponse();
			 messageResponse.setMessage("User deleted Successfully.");
			 return new ResponseEntity<Object>(messageResponse,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int userId,@RequestBody User user){
		
		user.setUserId(userId);
		User updatedUser=userService.updateUser(user);
		 return new ResponseEntity<Object>(updatedUser,HttpStatus.OK);
	}
	
}
