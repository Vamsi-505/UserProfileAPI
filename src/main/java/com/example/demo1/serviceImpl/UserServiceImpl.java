package com.example.demo1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.models.User;
import com.example.demo1.repository.UserRepository;
import com.example.demo1.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
        return userRepository.save(user);
    }
	
	@Override
	public List<User> allUser(){
		return userRepository.findAll();
	}
	
	@Override
	public Optional<User> UserById(Integer id){
		return userRepository.findById(id);
	}
	
	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
}
