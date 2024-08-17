package com.microservice.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
