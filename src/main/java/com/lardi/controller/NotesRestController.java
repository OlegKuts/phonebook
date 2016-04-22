package com.lardi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lardi.domain.Note;
import com.lardi.service.UserService;

@RestController
@RequestMapping("/api")
public class NotesRestController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/notes", method=RequestMethod.GET )
	@ResponseBody
	public List<Note> index(Principal principal) {
		return userService.findByLogin(principal.getName()).getNotes();
	}
}
