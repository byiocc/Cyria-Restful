package com.kunteng.cyria.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kunteng.cyria.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
	User findByUsername(String username);
}
