package com.lardi.service;

import java.util.List;

import com.lardi.domain.Note;
import com.lardi.from.NoteForm;

public interface NoteService {

	List<Note> findAll();

	Note findById(Long id);

	void updateNote(NoteForm noteForm);

	void addNote(NoteForm noteForm);

	void deleteNote(Long id);

}