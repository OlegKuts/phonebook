package com.lardi.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lardi.domain.User;
import com.lardi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByLogin(Principal principal) {
		return userRepository.findByLogin(principal.getName());
	}

	@Override
	public void registerUser(User user) {
		user.setEnabled(true);
		userRepository.save(user);

	}

}
