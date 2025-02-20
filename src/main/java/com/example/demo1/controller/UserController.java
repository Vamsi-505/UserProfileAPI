package com.example.demo1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.models.User;
import com.example.demo1.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
	
	@GetMapping("/allUser")
	public List<User> getAllUsers() {
		return userService.allUser();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User>getUserById(@PathVariable Integer id) {
		Optional<User> user = userService.UserById(id);
		return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @Validated @RequestBody User updatedUser) {
	    return userService.UserById(id)
	            .map(existingUser -> {
	                existingUser.setName(updatedUser.getName());
	                existingUser.setEmail(updatedUser.getEmail());
	                existingUser.setPhone(updatedUser.getPhone());
	                User savedUser = userService.updateUser(existingUser);
	                return ResponseEntity.ok(savedUser);
	            })
	            .orElseGet(() -> ResponseEntity.notFound().build());
	}
    
	
}
