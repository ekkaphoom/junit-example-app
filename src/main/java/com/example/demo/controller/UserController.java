package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.UserBusiness;
import com.example.demo.business.api.UserApi;
import com.example.demo.business.imp.UserBusinessImp;

@RestController
public class UserController implements UserApi {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserBusiness userBusiness;
	
	@Override
	public @ResponseBody String getRole(@RequestParam("username") String username) {
		logger.info("Get Controller Users");
		String result = userBusiness.getBusinessName(username);
			
		return result;
	}
}
