package com.kunteng.cyria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kunteng.cyria.domain.Users;

public interface UsersRepository extends MongoRepository<Users, String> {
	Users findByUsername(String username);
}
