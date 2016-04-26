package com.lardi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lardi.domain.User;
import com.lardi.service.UserService;

@Controller
public class RegistrationController {
	@Autowired
	private UserService userService;
	
	@ModelAttribute("userForm")
	public User noteForm() {
		return new User();
	}
	@RequestMapping("/registration")
	public String showRegistration() {
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("userForm") @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		userService.registerUser(user);
		return "redirect:/login?successful";
	}
}
