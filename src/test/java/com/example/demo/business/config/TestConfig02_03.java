package com.example.demo.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.business.UserBusiness;
import com.example.demo.business.imp.UserBusinessImp;

@Configuration
public class TestConfig02_03 {

	@Bean
	UserBusiness userBusiness() {
		return new UserBusinessImp();
	}

}