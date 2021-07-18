package com.example.demo.business.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
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
import com.example.demo.repository.UserRepository;

@RunWith(SpringRunner.class)
public class UserBusinessImplTest01_01_InjectMocks_WithMock {

	@Mock
	UserRepository userRepository;

	// Using Implement class
	@InjectMocks
	UserBusinessImp userBusiness;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

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

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void getUsers_exception_header_method() {
		// Arrange
		String usernameInput = "admin";

		// Action
		when(userRepository.getRoleFromDB(usernameInput)).thenThrow(ArrayIndexOutOfBoundsException.class);

		// Assert
		userBusiness.getBusinessName(usernameInput);
	}

	@Test
	public void getUsers_exception_inner_method() {
		// Arrange
		String usernameInput = "admin";
		expectedException.expect(NullPointerException.class);

		// Action
		doThrow(NullPointerException.class).when(userRepository).doSomething();

		// Assert
		userBusiness.getBusinessName(usernameInput);
	}

}
