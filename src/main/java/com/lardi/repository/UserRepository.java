package com.lardi.repository;

import org.springframework.data.repository.CrudRepository;
import com.lardi.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findByLogin(String login);
}