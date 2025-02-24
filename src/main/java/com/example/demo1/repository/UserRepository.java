package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
