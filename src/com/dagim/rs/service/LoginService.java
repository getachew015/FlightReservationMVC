package com.dagim.rs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dagim.rs.entity.UserEntity;
import com.dagim.rs.exception.InvalidCredentialException;
import com.dagim.rs.model.Login;
import com.dagim.rs.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity authenticateLogin(Login userLogin) throws InvalidCredentialException{
		
		UserEntity user = userRepository.findOne(userLogin.getUserName());
		if(user==null)
			throw new InvalidCredentialException("LoginService.INVALID_CREDENTIALS");
		else if(!user.getPassword().equals(userLogin.getPassword()))
			throw new InvalidCredentialException("LoginService.INVALID_CREDENTIALS");			
		return user;
	}
}
