package com.kunteng.cyria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kunteng.cyria.domain.User;
import com.kunteng.cyria.dto.CommonResult;
import com.kunteng.cyria.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	@ResponseBody
	public Object getAllUser() {
		List<User> list = userService.getAllUser();
		return new CommonResult().success(list);
	}
	
	@GetMapping("/user/{id}")
	@ResponseBody
	public Object getUserById(@PathVariable("id") String id) {
		User user = userService.getUserById(id);
		if (user == null) {
			return new CommonResult().failed();
		}
		return new CommonResult().success(user);
	}
	
	
	@PostMapping("/user")
	@ResponseBody
	public Object createUser(@Valid @RequestBody User user) {
		User newUser = userService.addUser(user);
		return new CommonResult().success(newUser);
	}
	
	@PutMapping("/user/{id}")
	@ResponseBody
	public Object updateUser(@PathVariable("id") String id, @Valid @RequestBody User user) {
		User modifiedUser = userService.updateUser(id, user);
		if (modifiedUser != null)
			return new CommonResult().success(modifiedUser);
		else
			return new CommonResult().failed();
	}
	
	@DeleteMapping("/user/{id}")
	@ResponseBody
	public Object deleteUserById(@PathVariable("id") String id) {
		userService.deleteUserById(id);
		return  new CommonResult().success(null);
	}
}
