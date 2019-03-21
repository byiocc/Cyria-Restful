package com.kunteng.cyria.service;

import java.util.List;

import com.kunteng.cyria.domain.User;

public interface UserService {
	 List<User> getAllUser();
	 User getUserById(String id);
	 User addUser(User user);
	 void deleteUserById(String id);
	 User updateUser(String id, User user);
}
