package com.lardi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lardi.from.NoteForm;
import com.lardi.service.NoteService;

@Controller
public class NoteController {
	@Autowired
	private NoteService noteService;

	@RequestMapping(value = "/addnote", method = RequestMethod.GET)
	public String newNote(Model model) {
		return "new-note";
	}

	@RequestMapping(value = "/addnote", method = RequestMethod.POST)
	public String addNote(@ModelAttribute("newNote") NoteForm noteForm) {
		noteService.addNewNote(noteForm);
		return "redirect:/";
	}
}
