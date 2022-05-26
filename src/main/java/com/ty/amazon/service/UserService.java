package com.ty.amazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ty.amazon.dao.UserDao;
import com.ty.amazon.dto.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
	
	public User loginUser(User user) {
		User user1 = userDao.loginUser(user.getEmail(),user.getPassword());
		
		return user1;
	}
	

}
