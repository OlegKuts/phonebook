package com.lardi.service;

import java.security.Principal;

import com.lardi.domain.Note;
import com.lardi.utils.form.NoteForm;

public interface NoteService {

	void updateNote(NoteForm noteForm);

	void addNote(NoteForm noteForm, Principal principal);

	void deleteNote(Long id, Principal principal);

	Note findById(Long id, Principal principal);

}