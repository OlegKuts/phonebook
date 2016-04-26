package com.lardi.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lardi.domain.Address;
import com.lardi.domain.Note;
import com.lardi.domain.User;
import com.lardi.repository.NoteRepository;
import com.lardi.repository.UserRepository;
import com.lardi.service.exceptions.NoNoteFoundException;
import com.lardi.utils.form.NoteForm;

@Service
public class NoteServiceImpl implements NoteService {
	@Autowired
	private NoteRepository noteRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void addNote(NoteForm noteForm, Principal principal) {
		User user = userRepository.findByLogin(principal.getName());
		Note note = noteForm.getNote();
		Address address = noteForm.getAddress();
		note.setAddress(address);
		address.setNote(note);
		user.getNotes().add(note);
		note.setUser(user);
		userRepository.save(user);
	}

	@Override
	public Note findById(Long id, Principal principal) {
		Note note = noteRepository.findOne(id);
		User user = userRepository.findByLogin(principal.getName());
		if (!user.getNotes().contains(note)) {
			throw new NoNoteFoundException("No note was found");
		}
		return note;
	}

	@Override
	public void updateNote(NoteForm noteForm) {
		Note note = noteForm.getNote();
		Address address = noteForm.getAddress();
		address.setNote(note);
		note.setAddress(address);
		noteRepository.save(note);
	}

	@Override
	public void deleteNote(Long id, Principal principal) {
		User user = userRepository.findByLogin(principal.getName());
		Note note = noteRepository.findOne(id);
		user.getNotes().remove(note);
		userRepository.save(user);
	}

}
