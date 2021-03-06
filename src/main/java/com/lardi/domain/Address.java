package com.lardi.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {
	private String city;
	private String street;

	@OneToOne
	@JoinColumn(name = "note_id")
	@JsonBackReference
	private Note note;

	public Address() {
		super();
	}

	public Address(String city, String street) {
		super();
		this.city = city;
		this.street = street;
	}

	public Address(String city, String street, Note note) {
		super();
		this.city = city;
		this.street = street;
		this.note = note;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", note=" + note + ", id=" + id + "]";
	}

}
