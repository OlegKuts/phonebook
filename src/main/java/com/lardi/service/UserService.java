package com.lardi.service;

import java.security.Principal;

import com.lardi.domain.User;

public interface UserService {

	void registerUser(User user);

	User findByLogin(Principal principal);

}