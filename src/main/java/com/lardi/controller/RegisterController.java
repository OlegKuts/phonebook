package com.lardi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lardi.domain.User;
import com.lardi.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	
	@ModelAttribute("userForm")
	public User noteForm() {
		return new User();
	}
	@RequestMapping("/register")
	public String showRegister() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("userForm") User user) {
		userService.registerUser(user);
		return "redirect:/login?successful";
	}
}
