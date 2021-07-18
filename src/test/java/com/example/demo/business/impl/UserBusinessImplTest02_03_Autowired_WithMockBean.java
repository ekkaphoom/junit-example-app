package com.example.demo.business.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.business.UserBusiness;
import com.example.demo.business.config.TestConfig02_03;
import com.example.demo.repository.UserRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestConfig02_03.class }, initializers = ConfigFileApplicationContextInitializer.class)
public class UserBusinessImplTest02_03_Autowired_WithMockBean {

	@MockBean
	UserRepository userRepository;

	@Autowired
	UserBusiness userBusiness;

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
		verify(userRepository, times(1)).getRoleFromDB(usernameInput);
		verify(userRepository, times(1)).getFullNameFromDB(usernameInput);
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
		when(userRepository.getRoleFromDB(usernameInput)).thenThrow(RuntimeException.class);

		// Assert
		expectedException.expect(RuntimeException.class);

		// Action
		userBusiness.getBusinessName(usernameInput);
	}

}
