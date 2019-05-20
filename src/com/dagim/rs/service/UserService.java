package com.dagim.rs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dagim.rs.entity.UserEntity;
import com.dagim.rs.exception.UserNotFoundException;
import com.dagim.rs.model.User;
import com.dagim.rs.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUserDetails(String userId) throws UserNotFoundException{
		
		UserEntity userEntity = userRepository.getOne(userId);
		
		if(userEntity==null){
			throw new UserNotFoundException("UserService.USER_NOT_FOUND");
		}
		User user = new User();
		user.setName(userEntity.getName());
		user.setUserId(userEntity.getUserId());
		user.setAddress(userEntity.getAddress());
		user.setEmail(userEntity.getEmail());
		user.setPhone(userEntity.getPhone());
		user.setPassword(userEntity.getPassword());
		
		return user;
	}
	

}
