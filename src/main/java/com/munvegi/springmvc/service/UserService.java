package com.munvegi.springmvc.service;

import java.util.List;

import com.munvegi.springmvc.model.User;



public interface UserService {
	
	User findById(int id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(int id);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
}
