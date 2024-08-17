package com.microservice.userservice.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.microservice.userservice.entity.User;
import com.microservice.userservice.exception.ResourceNotFoundException;
import com.microservice.userservice.repository.UserRepository;

@Service
//@Component
public class UserServiceImpl implements UserService {
	/**
	 * field injection example
	 * 
	 * @Autowired 
	 * UserRepository userRepo;
	 *
	 */

	
	//constructor injection
	private UserRepository userRepo;
	
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo =userRepo;
	}
	
	@Override
	public User saveUser(User user) {
		String id = UUID.randomUUID().toString();
		user.setUserId(id);
		return userRepo.save(user);
		
	}
 
	@Override
	public List<User> getAllUser() {
		List<User> list = userRepo.findAll();
		if(!list.isEmpty()) {
			return list.stream().map(u -> {
				User user = new User();
				BeanUtils.copyProperties(u, user);
				return user;
			}).toList();
		}
		return Collections.emptyList();
		
	}
	

	@Override
	public User getUser(String id) {
		/**
		 * Optional<User> cc = userRepo.findById(id); 
		 * if(cc.isPresent()) { 
		 * return cc.get(); 
		 * } 
		 * return null;
		 */
		 return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user with given id not found"+id));

	}

	@Override
	public boolean deleteUser(String id) {
		Optional<User> cc = userRepo.findById(id);
		if(cc.isPresent()) {
			userRepo.deleteById(cc.get().getUserId());
			return true;
		}
           return false;
	}

	@Override
	public User updateUser(User user) {
		
		Optional<User> update = userRepo.findById(user.getUserId());
		if(update.isPresent()) {
			BeanUtils.copyProperties(user, update.get());
			return userRepo.save(update.get());
		}
		return null;
	}

	
	@Override
	public User update(User user ,String id) {
		
		Optional<User> update = userRepo.findById(id);
		if(update.isPresent()) {
			update.get().setName(user.getName());
			update.get().setEmail(user.getEmail());
			return userRepo.save(update.get());
		}
		return null;
	}
}
