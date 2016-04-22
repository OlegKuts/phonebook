package com.lardi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lardi.domain.User;
import com.lardi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}

}
