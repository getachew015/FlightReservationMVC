package com.dagim.rs.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import com.dagim.rs.entity.UserEntity;
import com.dagim.rs.exception.UserIdAlreadyPresentException;
import com.dagim.rs.model.User;
import com.dagim.rs.repository.UserRepository;
import com.dagim.rs.service.RegistrationService;

@ContextConfiguration
public class RegistrationServiceTest 
{
	@Mock
	private UserRepository userRepository;
	@InjectMocks
	private RegistrationService registrationService;
	@Rule
	public ExpectedException e = ExpectedException.none();
	User user = new User();
	UserEntity userEntity = new UserEntity();
	public void inititalizeUserAndUserEntity()
	{
		
		user.setAddress("Chennai");
		user.setEmail("punithamalar@infygo.com");
		user.setName("punithamalar");
		user.setPassword("punithamalar_b");
		user.setPhone("1234567890");
		user.setUserId("punithamalar_b");
		userEntity.setAddress("Chennai");
		userEntity.setEmail("punithamalar@infygo.com");
		userEntity.setName("punithamalar");
		userEntity.setPassword("punithamalar_b");
		userEntity.setPhone("1234567890");
		userEntity.setUserId("punithamalar_b");
	}
	@Before
	public void initialWork()
	{
		MockitoAnnotations.initMocks(this);
		inititalizeUserAndUserEntity();
	}
	@Test
	public void testRegisterUserPositive() 
	{
		Mockito.when(userRepository.findOne(user.getName())).thenReturn(null);
		Mockito.when(userRepository.saveAndFlush(userEntity)).thenReturn(userEntity);
		try
		{
			registrationService.registerUser(user);
		}
		catch(Exception e){}
	}
	@Test
	public void testRegisterUserNegative() throws UserIdAlreadyPresentException
	{
		e.expect(UserIdAlreadyPresentException.class);
		e.expectMessage("RegistrationService.USERID_PRESENT");
		Mockito.when(userRepository.findOne(Mockito.anyString())).thenReturn(userEntity);
		registrationService.registerUser(user);
	}
}
