package com.example.demo.business.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.business.UserBusiness;
import com.example.demo.business.imp.UserBusinessImp;
import com.example.demo.repository.UserRepository;

@Configuration
public class TestConfig02_01 {

	@Bean
	UserRepository userRepository() {
		return Mockito.mock(UserRepository.class);
	}

	@Bean
	UserBusiness userBusiness() {
		return new UserBusinessImp();
	}
}