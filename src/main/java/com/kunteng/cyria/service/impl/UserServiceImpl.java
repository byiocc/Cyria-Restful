package com.kunteng.cyria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kunteng.cyria.domain.User;
import com.kunteng.cyria.repository.UserRepository;
import com.kunteng.cyria.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		User oldUser = userRepository.findByUsername(user.getUsername());
		if (oldUser != null)
			return null;
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.insert(user);
	}

	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(String id, User user) {
		// TODO Auto-generated method stub
		User oldUser = userRepository.findById(id).orElse(null);
		if (oldUser == null) {
			return null;
		}
		user.setId(id);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

}
