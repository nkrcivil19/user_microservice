package com.microservice.userservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.userservice.entity.User;
import com.microservice.userservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	private UserService userservice;

	public UserController(UserService userservice) {
		this.userservice = userservice;
	}

	// create
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User users = userservice.saveUser(user);
		log.info("This is an info log message");
		return ResponseEntity.status(HttpStatus.CREATED).body(users);

	}

	// get single user

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id) {
		User singleuser = userservice.getUser(id);
		return ResponseEntity.ok(singleuser);

	}

	// get all user
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> alluser = userservice.getAllUser();

		return ResponseEntity.ok(alluser);
	}

	// delete user
	@DeleteMapping
	public ResponseEntity<Void> deleteUser(@RequestParam String id) {
		boolean delete = userservice.deleteUser(id);
		if (delete) {

			return ResponseEntity.ok().build();
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// update user

	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User updateuser = userservice.updateUser(user);
		return updateuser != null ? ResponseEntity.status(HttpStatus.OK).body(updateuser)
				: ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(updateuser);
	}

	// update user

	public ResponseEntity<User> update(@RequestBody User user, String id) {
		User updateuser = userservice.update(user, id);
		return updateuser != null ? ResponseEntity.status(HttpStatus.OK).body(updateuser)
				: ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(updateuser);
	}

}
