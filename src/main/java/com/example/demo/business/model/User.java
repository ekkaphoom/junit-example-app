package com.example.demo.business.model;

import java.time.OffsetDateTime;

public class User {

	private String name;
	private String phonenumber;
	private OffsetDateTime birthdate;
	private Integer balance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public OffsetDateTime getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(OffsetDateTime birthdate) {
		this.birthdate = birthdate;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name:").append(name).append("\n");
		sb.append("phonenumber:").append(phonenumber).append("\n");
		sb.append("birthdate:").append(birthdate).append("\n");
		sb.append("balance:").append(balance).append("\n");
		return sb.toString();
	}
}
