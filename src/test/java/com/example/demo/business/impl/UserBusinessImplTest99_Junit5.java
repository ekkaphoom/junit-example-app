package com.example.demo.business.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.business.imp.UserBusinessImp;
import com.example.demo.repository.UserRepository;

// https://www.baeldung.com/junit-5-migration
// https://www.baeldung.com/junit-5
@ExtendWith(MockitoExtension.class)
@DisplayName("Demo Spring Boot with JUnit 5 + Mockito")
public class UserBusinessImplTest99_Junit5 {

	@Mock
	UserRepository userRepository;

	// Using Implement class
	@InjectMocks
	UserBusinessImp userBusiness;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@DisplayName("getUsers success")
	@Test
	public void getUsers_success() {
		// Arrange
		String usernameInput = "admin";
		String expect = "MY-SUPER-ADMIN: ADMIN-NAME";
		when(userRepository.getRoleFromDB(usernameInput)).thenReturn("MY-SUPER-ADMIN");
		when(userRepository.getFullNameFromDB(usernameInput)).thenReturn("ADMIN-NAME");

		// Action
		String actual = userBusiness.getBusinessName(usernameInput);

		// Assert
		assertEquals(expect, actual);
		verify(userRepository, Mockito.times(1)).getRoleFromDB(usernameInput);
		verify(userRepository, Mockito.times(1)).getFullNameFromDB(usernameInput);
	}
}
