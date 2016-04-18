package com.lardi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lardi.domain.Note;
import com.lardi.repository.NoteRepository;

@Service
public class NoteService {
	@Autowired
	private NoteRepository noteRepository;

	public List<Note> findAll() {
		return noteRepository.findAll();
	}
}
