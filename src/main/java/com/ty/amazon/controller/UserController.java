package com.ty.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ty.amazon.dao.UserDao;
import com.ty.amazon.dto.User;
import com.ty.amazon.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("user")
	public ModelAndView saveUser() {
		ModelAndView view = new ModelAndView();
		view.addObject("user", new User());
		view.setViewName("createuser.jsp");
		return view;
	}
	@RequestMapping("save")
	public User saveUser( @ModelAttribute User user) {
		return userService.saveUser(user);
		
	}
	@RequestMapping("loginuser")
	public ModelAndView loginUser() {
		ModelAndView view = new ModelAndView();
		view.addObject("user", new User());
		view.setViewName("login.jsp");
		return view;
	}
	@RequestMapping("login")
	public ModelAndView loginUser(@ModelAttribute User user) {
		ModelAndView view1 = new ModelAndView();
		ModelAndView view2 = new ModelAndView();
		User user1 = userService.loginUser(user);
		
		if(user1.getRole().equalsIgnoreCase("Admin")) {
			view1.addObject("user", user1);
			view1.setViewName("admin.jsp");
			return view1;
		}else {
			view2.addObject("user", user1);
			view2.setViewName("customer.jsp");
			return view2;
		}
		
		
		
	}
	@RequestMapping("updateuser")
	public ModelAndView updateuser() {
		ModelAndView view = new ModelAndView();
		view.addObject("user", new User());
		view.setViewName("updateuser.jsp");
		return view;
	}

}
