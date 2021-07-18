package com.example.demo.business.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.business.imp.UserBusinessImp;
import com.example.demo.repository.impl.UserRepositoryImpl;

@RunWith(SpringRunner.class)
public class UserBusinessImplTest01_02_InjectMocks_thenCallRealMethod {

	// Using Implement class
	@Mock
	UserRepositoryImpl userRepository;

	@InjectMocks
	UserBusinessImp userBusiness;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void getUsers_success() {
		// Arrange
		String usernameInput = "admin";
		String expect = "superuser: Administrator of Application";
		when(userRepository.getRoleFromDB(usernameInput)).thenCallRealMethod();
		when(userRepository.getFullNameFromDB(usernameInput)).thenCallRealMethod();

		// Action
		String actual = userBusiness.getBusinessName(usernameInput);

		// Assert
		assertEquals(expect, actual);
		verify(userRepository, Mockito.times(1)).getRoleFromDB(usernameInput);
		verify(userRepository, Mockito.times(1)).getFullNameFromDB(usernameInput);
	}
}
