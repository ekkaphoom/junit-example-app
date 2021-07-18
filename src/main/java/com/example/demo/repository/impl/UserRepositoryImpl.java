package com.example.demo.repository.impl;

import org.springframework.stereotype.Component;

import com.example.demo.repository.UserRepository;

@Component
public class UserRepositoryImpl implements UserRepository {

	@Override
	public String getRoleFromDB(String username) {
		switch (username) {
		case "admin":
			return "superuser";
		case "user":
			return "enduser";
		default:
			throw new NullPointerException("No role found");
		}
	}

	@Override
	public String getFullNameFromDB(String username) {
		switch (username) {
		case "admin":
			return "Administrator of Application";
		case "user":
			return "Operator of Application";
		default:
			throw new NullPointerException("No fullname found");
		}
	}

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("do Something");
	}
}
