package com.lardi.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.lardi.domain.Note;
import com.lardi.service.NoteService;
import com.lardi.utils.form.NoteForm;

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
	public String createNote(@ModelAttribute("noteForm") @Valid NoteForm noteForm, BindingResult bindingResult,
			Principal principal) {
		if (bindingResult.hasErrors()) {
			return "new";
		}
		noteService.addNote(noteForm, principal.getName());
		return "redirect:/notes";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editNote(@PathVariable("id") Long id, NoteForm noteForm, Principal principal) {
		Note note = noteService.findById(id, principal.getName());
		noteForm.setNote(note);
		noteForm.setAddress(note.getAddress());
		return "edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateNote(@ModelAttribute("noteForm") @Valid NoteForm noteForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		noteService.updateNote(noteForm);
		return "redirect:/notes";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteNote(@PathVariable("id") Long id, Principal principal) {
		noteService.deleteNote(id, principal.getName());
		return "redirect:/notes";
	}
}
