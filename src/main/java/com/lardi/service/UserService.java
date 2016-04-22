package com.lardi.service;

import com.lardi.domain.User;

public interface UserService {

	User findByLogin(String login);

}