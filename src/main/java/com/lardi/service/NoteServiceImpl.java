package com.lardi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lardi.domain.Address;
import com.lardi.domain.Note;
import com.lardi.from.NoteForm;
import com.lardi.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {
	@Autowired
	private NoteRepository noteRepository;

	@Override
	public List<Note> findAll() {
		return noteRepository.findAll();
	}

	@Override
	public void addNote(NoteForm noteForm) {
		Note note = new Note();
		note.setName(noteForm.getNote().getName());
		Address address = new Address(noteForm.getAddress().getState());
		address.setNote(note);
		note.setAddress(address);
		noteRepository.save(note);
	}

	@Override
	public Note findById(Long id) {
		return noteRepository.findOne(id);
	}

	@Override
	public void updateNote(NoteForm noteForm) {
		Note note = noteRepository.findOne(noteForm.getNote().getId());
		Address address = note.getAddress();
		note.setName(noteForm.getNote().getName());
		address.setState(noteForm.getAddress().getState());
		address.setNote(note);
		noteRepository.save(note);
	}

	@Override
	public void deleteNote(Long id) {
		noteRepository.delete(id);
	}

}
