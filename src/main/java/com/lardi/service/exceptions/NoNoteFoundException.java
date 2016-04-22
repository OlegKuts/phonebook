package com.lardi.service.exceptions;

public class NoNoteFoundException extends RuntimeException{
	public NoNoteFoundException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
