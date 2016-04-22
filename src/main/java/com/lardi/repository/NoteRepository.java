package com.lardi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lardi.domain.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {
	public List<Note> findAll();
}
