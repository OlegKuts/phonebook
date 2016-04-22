package com.lardi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lardi.service.UserService;

@Controller
@RequestMapping(value = { "/notes", "/" })
public class IndexController {
	@Autowired
	private UserService userService;

	@RequestMapping("")
	public String index(Model model, Principal principal) {
		model.addAttribute("notes", userService.findByLogin(principal.getName()).getNotes());
		return "main";
	}
}
