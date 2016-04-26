package com.lardi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lardi.utils.validator.UniqueLogin;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	// @Pattern(regexp="[A-Za-z]{3,}", message="Login must consist of english
	// characters only and be no less than 3 symbols")
	@Size(min = 3, message = "Login should be no less than {min} symbols")
	@Pattern(regexp = "[A-Za-z]*", message = "Login must consist of english characters only")
	@UniqueLogin(message = "Login must be unique")
	private String login;
	@Size(min = 5, message = "Password should be no less than {min} symbols")
	private String password;
	private boolean enabled;
	@Size(min = 5, message = "Name should be no less than {min} symbols")
	private String name;
	@Column(name = "last_name")
	@Size(min = 5, message = "Last name should be no less than {min} symbols")
	private String lastName;
	@Column(name = "middle_name")
	@Size(min = 5, message = "Middle name should be no less than {min} symbols")
	private String middleName;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Note> notes;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String login, String password, String name, String lastName, String middleName) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.middleName = middleName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public List<Note> getNotes() {
		if (notes == null) {
			return new ArrayList<Note>();
		}
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

}
