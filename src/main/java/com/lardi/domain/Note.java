package com.lardi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Note extends BaseEntity {

	private String name;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "cell_number")
	private String cellNumber;
	@Column(name = "phone_number")
	private String phoneNumber;
	@OneToOne(mappedBy = "note", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address address;
	private String email;

	public Note() {
		
	}

	public Note(String name) {
		super();
		this.name = name;
	}

	public Note(String name, String lastName, String middleName, String cellNumber, String phoneNumber, Address address,
			String email) {
		this.name = name;
		this.lastName = lastName;
		this.middleName = middleName;
		this.cellNumber = cellNumber;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
