package com.lardi.service;

import com.lardi.domain.Note;
import com.lardi.utils.form.NoteForm;

public interface NoteService {

	Note findById(Long id, String login);

	void updateNote(NoteForm noteForm);

	void addNote(NoteForm noteForm, String login);

	void deleteNote(Long id, String login);

}