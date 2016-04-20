package com.lardi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.lardi.domain.Note;
import com.lardi.from.NoteForm;
import com.lardi.service.NoteService;

@Controller
@RequestMapping("/notes")
public class NoteController {
	@Autowired
	private NoteService noteService;

	@ModelAttribute("noteForm")
	public NoteForm noteForm() {
		return new NoteForm();
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newNote() {
		return "new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createNote(@ModelAttribute("noteForm") NoteForm noteForm) {
		noteService.addNote(noteForm);
		return "redirect:/notes";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editNote(@PathVariable("id") Long id, NoteForm noteForm) {
		Note note = noteService.findById(id);
		noteForm.setNote(note);
		noteForm.setAddress(note.getAddress());
		return "edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateNote(@ModelAttribute("noteForm") NoteForm noteForm) {
		noteService.updateNote(noteForm);
		return "redirect:/notes";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteNote(@PathVariable("id") Long id) {
		noteService.deleteNote(id);
		return "redirect:/notes";
	}
}
