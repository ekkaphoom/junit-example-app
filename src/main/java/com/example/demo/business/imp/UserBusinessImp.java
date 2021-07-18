package com.example.demo.business.imp;

import org.slf4j.Logger;

//import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.business.UserBusiness;
import com.example.demo.repository.UserRepository;

@Component
public class UserBusinessImp implements UserBusiness {

	private final Logger logger = LoggerFactory.getLogger(UserBusinessImp.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public String getBusinessName(String username) {
		logger.info("Get Business Users");
		if (!verifyInput(username)) {
			throw new IllegalArgumentException("Input is not valid");
		}

		String role = userRepository.getRoleFromDB(username);
		String fullname = userRepository.getFullNameFromDB(username);
		userRepository.doSomething();

		return role + ": " + fullname;
	}

	@Override
	public boolean verifyInput(String username) {
		return username != "";
	}
}
