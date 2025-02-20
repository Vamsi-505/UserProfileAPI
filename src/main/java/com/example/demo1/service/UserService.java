package com.example.demo1.service;

import java.util.List;
import java.util.Optional;

import com.example.demo1.models.User;

public interface UserService {
	
	User addUser(User user);
	
	List<User> allUser();
	
	Optional<User> UserById(Integer id);
	
	void deleteUser(Integer id);
	
	User updateUser(User user);
}
