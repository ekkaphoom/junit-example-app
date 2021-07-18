package com.example.demo.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.business.UserBusiness;
import com.example.demo.business.imp.UserBusinessImp;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.impl.UserRepositoryImpl;

@Configuration
public class TestConfig02_02 {

	@Bean
	UserRepository userRepository() {
		return new UserRepositoryImpl();
	}

	@Bean
	UserBusiness userBusiness() {
		return new UserBusinessImp();
	}
}
