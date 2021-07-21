package com.example.demo.business.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.business.imp.UserBusinessImp;
import com.example.demo.repository.UserRepository;

@RunWith(SpringRunner.class)
public class UserBusinessImplTest01_03_InjectMocks_WithSpy {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserBusinessImp userBusiness;
	UserBusinessImp userBusinessSpy;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@BeforeClass
	public static void setupAll() {
		System.out.println("##### Before All #####");
	}

	@Before
	public void setup() {
		System.out.println("##### Before Each #####");
		userBusinessSpy = Mockito.spy(userBusiness);
	}

	@Test
	public void getUsers_success() {
		// Arrange
		String usernameInput = "admin";
		String expect = "MY-SUPER-ADMIN: ADMIN-NAME";
		when(userRepository.getRoleFromDB(usernameInput)).thenReturn("MY-SUPER-ADMIN");
		when(userRepository.getFullNameFromDB(usernameInput)).thenReturn("ADMIN-NAME");

		// Action
		String actual = userBusinessSpy.getBusinessName(usernameInput);

		// Assert
		assertEquals(expect, actual);
		verify(userBusinessSpy, Mockito.times(1)).getBusinessName(usernameInput);
		verify(userBusinessSpy, Mockito.times(1)).verifyInput(usernameInput);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getUsers_change_behavior() {
		// Arrange
		String usernameInput = "admin";
		when(userBusinessSpy.verifyInput(usernameInput)).thenReturn(false);

		// Action
		userBusinessSpy.getBusinessName(usernameInput);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void getUsers_throw_exception_at_internal_method() {
		// Arrange
		String usernameInput = "admin";

		doThrow(new ArrayIndexOutOfBoundsException("Error occurred")).when(userBusinessSpy).verifyInput(usernameInput);

		// Action
		userBusinessSpy.getBusinessName(usernameInput);
	}

	@Test(expected = NullPointerException.class)
	public void getUsers_exception_header_method() {
		// Arrange
		String usernameInput = "admin";

		// Action
		when(userRepository.getRoleFromDB(usernameInput)).thenThrow(NullPointerException.class);

		// Assert
		userBusinessSpy.getBusinessName(usernameInput);
	}

	@Test
	public void getUsers_exception_inner_method() {
		// Arrange
		String usernameInput = "admin";
		when(userRepository.getRoleFromDB(usernameInput)).thenThrow(ArgumentAccessException.class);

		// Assert
		expectedException.expect(ArgumentAccessException.class);

		// Action
		userBusinessSpy.getBusinessName(usernameInput);
	}

}
