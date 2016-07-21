package com.munvegi.springmvc.service;

import com.munvegi.springmvc.dao.UserDAO;
import com.munvegi.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;


	public List<User> findAllUsers() {
		return userDAO.findAll();
	}
	
	public User findById(int id) {
		return userDAO.findById(id);
	}
	
	public User findByName(String name) {
		return null;
	}
	
	public void saveUser(User user) {
		userDAO.save(user);
	}

	public void updateUser(User user) {
		userDAO.update(user);
	}

	public void deleteUserById(int id) {
		userDAO.deleteById(id);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	public void deleteAllUsers(){}
}
