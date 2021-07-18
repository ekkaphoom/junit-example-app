package com.example.demo.business.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.business.UserBusiness;
import com.example.demo.business.config.TestConfig02_02;
import com.example.demo.repository.UserRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestConfig02_02.class }, initializers = ConfigFileApplicationContextInitializer.class)
public class UserBusinessImplTest02_02_Autowired_WithRealInstance {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserBusiness userBusiness;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void getUsers_admin() {
		// Arrange
		String usernameInput = "admin";
		String expect = "superuser: Administrator of Application";

		// Action
		String actual = userBusiness.getBusinessName(usernameInput);

		// Assert
		assertEquals(expect, actual);

	}

	@Test
	public void getUsers_user() {
		// Arrange
		String usernameInput = "user";
		String expect = "enduser: Operator of Application";

		// Action
		String actual = userBusiness.getBusinessName(usernameInput);

		// Assert
		assertEquals(expect, actual);

	}

}
