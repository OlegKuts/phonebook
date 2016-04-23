package com.lardi.utils.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.lardi.repository.UserRepository;

public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void initialize(UniqueLogin annotation) {

	}

	@Override
	public boolean isValid(String login, ConstraintValidatorContext context) {
		/*
		 * for database population purposes
		 */
		if (userRepository == null) {
			return true;
		}
		return userRepository.findByLogin(login) == null;
	}

}
