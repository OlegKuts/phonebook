package com.lardi.utils.form;

import javax.validation.Valid;

import com.lardi.domain.Address;
import com.lardi.domain.Note;

public class NoteForm {
	@Valid
	private Note note;
	private Address address;

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
