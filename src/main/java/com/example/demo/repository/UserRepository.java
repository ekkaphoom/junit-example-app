package com.example.demo.repository;

public interface UserRepository {
	public String getRoleFromDB(String username);

	public String getFullNameFromDB(String username);

	public void doSomething();
}
