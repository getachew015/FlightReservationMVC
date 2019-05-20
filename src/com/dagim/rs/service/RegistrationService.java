package com.dagim.rs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dagim.rs.entity.UserEntity;
import com.dagim.rs.exception.UserIdAlreadyPresentException;
import com.dagim.rs.model.User;
import com.dagim.rs.repository.UserRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void registerUser(User user) throws UserIdAlreadyPresentException{

		UserEntity ue = userRepository.findOne(user.getUserId());
		if(ue!=null)
			throw new UserIdAlreadyPresentException("RegistrationService.USERID_PRESENT");

		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(user.getUserId());
		userEntity.setName(user.getName());
		userEntity.setAddress(user.getAddress());
		userEntity.setEmail(user.getEmail());
		userEntity.setPhone(user.getPhone());
		userEntity.setPassword(user.getPassword());
		userRepository.saveAndFlush(userEntity);

	}
}
