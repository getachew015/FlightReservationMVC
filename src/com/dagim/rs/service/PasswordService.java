package com.dagim.rs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dagim.rs.exception.UserNotFoundException;
import com.dagim.rs.repository.UserRepository;

@Service
public class PasswordService {
	
	@Autowired
	private UserRepository userRepository;
	
	public int updatePassword(String email, String phone, String passWord) throws UserNotFoundException{
		int rowCount;
		
		rowCount = userRepository.updatePassword(email, phone, passWord);
		
		if(rowCount!=1)
			throw new UserNotFoundException("PasswordService.USER_NOT_FOUND");
		
		return rowCount;
		
	}
	

}
