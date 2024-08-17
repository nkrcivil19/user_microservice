package com.microservice.userservice.service;

import java.util.List;

import com.microservice.userservice.entity.User;


public interface UserService {

	//create
	User saveUser(User user);
	
	// get all user	
	List<User> getAllUser();
	
	// get single user
	User getUser(String id);
	
	
	//delete user
	boolean deleteUser(String id);
	
	//update user
	User updateUser(User user);
	// update user
	User update(User user, String id);
	
}
