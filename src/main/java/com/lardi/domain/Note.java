package com.lardi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "notes")
public class Note extends BaseEntity {
	@Size(min = 4, message = "Name should be no less than {min} symbols")
	private String name;
	@Column(name = "last_name")
	@Size(min = 4, message = "Last name should be no less than {min} symbols")
	private String lastName;
	@Column(name = "middle_name")
	@Size(min = 4, message = "Middle name should be no less than {min} symbols")
	private String middleName;
	@Column(name = "cell_number")
	@NotEmpty(message = "Cell number cannot be empty")
	@Pattern(regexp = "\\+380\\(\\d{2}\\)\\d{7}", message = "Enter valid cell number like +380(00)1234567")
	private String cellNumber;
	@Column(name = "phone_number")
	@Pattern(regexp = "\\d*\\(?\\d*\\)?\\d*", message = "Phone number must consist of digits")
	private String phoneNumber;
	@Email
	private String email;

	@OneToOne(mappedBy = "note", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Address address;
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;

	public Note() {

	}

	public Note(String name, String lastName, String middleName, String cellNumber, String phoneNumber, String email,
			Address address, User user) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.middleName = middleName;
		this.cellNumber = cellNumber;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Note [name=" + name + ", lastName=" + lastName + ", middleName=" + middleName + ", cellNumber="
				+ cellNumber + ", phoneNumber=" + phoneNumber + ", address=" + address + ", email=" + email + ", user="
				+ user + ", id=" + id + "]";
	}

}
