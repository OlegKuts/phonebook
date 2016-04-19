package com.lardi.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.lardi.from.NoteForm;

@ControllerAdvice
public class ControllerAdvicor {
	@ModelAttribute("newNote")
	public NoteForm getNoteForm() {
		return new NoteForm();
	}
}
