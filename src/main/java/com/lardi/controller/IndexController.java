package com.lardi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lardi.service.NoteService;

@Controller
public class IndexController {
	@Autowired
	private NoteService noteService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("notes",noteService.findAll());
		return "main";
	}
}
