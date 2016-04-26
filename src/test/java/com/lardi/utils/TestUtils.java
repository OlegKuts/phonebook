package com.lardi.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

import com.lardi.domain.Address;
import com.lardi.domain.Note;
import com.lardi.domain.User;

public class TestUtils {
	
	public static Note getValidTestNote() {
		return new Note("Taras","Petrivskiy", "Volodymyrovych","+380(00)1234567","12345","oleg@gmail.com",null,null);
	}
	public static Note getInvalidTestNote() {
		return new Note("Oleg","Kuts", "Vol","+380(500)1234567","ddd","oleg",null,null);
	}
	public static Address getTestAddress() {
		return new Address("Kyiv","Khreshatyk");
	}
	
	public static MultiValueMap<String, String> getValidNoteParams(){
		Note note = getValidTestNote();
		MultiValueMap<String, String> params = new HttpHeaders();
		params.add("note.name", note.getName());
		params.add("note.lastName", note.getLastName());
		params.add("note.middleName", note.getMiddleName());
		params.add("note.cellNumber", note.getCellNumber());
		return params;	
	}
	
	public static User getValidTestUser() {
		return new User("Login","Password","Taras","Petrivskiy", "Volodymyrovych");
	}
	
	public static User getInvalidTestUser() {
		return new User("111","Pass","Oleg","Kuts", "Vol");
	}
	
	public static MultiValueMap<String, String> getValidUserParams(){
		User user = getValidTestUser();
		MultiValueMap<String, String> params = new HttpHeaders();
		params.add("login", user.getLogin());
		params.add("password", user.getPassword());
		params.add("name", user.getName());
		params.add("lastName", user.getLastName());
		params.add("middleName", user.getMiddleName());
		return params;	
	}

}
