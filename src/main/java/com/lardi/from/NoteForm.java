package com.lardi.from;

import com.lardi.domain.Address;
import com.lardi.domain.Note;

public class NoteForm {
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
