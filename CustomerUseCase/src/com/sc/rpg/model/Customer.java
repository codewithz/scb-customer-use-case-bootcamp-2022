package com.sc.rpg.model;

import java.time.LocalDate;

public class Customer {
	
	private int id;
	private String name,email,accountType;
	private long contact;
	private LocalDate accountCreationDate;
	
	
	public LocalDate getAccountCreationDate() {
		return accountCreationDate;
	}


	public void setAccountCreationDate(LocalDate accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}


	public Customer(String name, String email, String accountType, long contact, LocalDate accountCreationDate) {
		super();
		this.name = name;
		this.email = email;
		this.accountType = accountType;
		this.contact = contact;
		this.accountCreationDate = accountCreationDate;
	}


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(String name, String email, String accountType, long contact) {
		super();
		this.name = name;
		this.email = email;
		this.accountType = accountType;
		this.contact = contact;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public long getContact() {
		return contact;
	}


	public void setContact(long contact) {
		this.contact = contact;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", accountType=" + accountType
				+ ", contact=" + contact + ", accountCreationDate=" + accountCreationDate + "]";
	}
	
	
	
	
	
	

}
