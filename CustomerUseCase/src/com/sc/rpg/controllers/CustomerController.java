package com.sc.rpg.controllers;

import java.time.LocalDate;
import java.util.*;

import com.sc.rpg.model.Customer;
import com.sc.rpg.services.CustomerService;
import com.sc.rpg.services.CustomerServiceDBImpl;
import com.sc.rpg.services.CustomerServiceListImpl;

public class CustomerController {
	
	Scanner sc=new Scanner(System.in);
	
	CustomerService service=new CustomerServiceDBImpl();
	
	public void addCustomer() {
		
		System.out.println("-- Please enter customer details --");
		
		String name,email,accountType;
		long contact;
		
		System.out.print("Enter Name:");
		name=sc.next();
		
		System.out.print("Enter Email:");
		email=sc.next();
		
		System.out.print("Enter Contact:");
		contact=sc.nextLong();
		
		System.out.print("Enter Type [Savings, Current]:");
		accountType=sc.next();
		
		Customer c=new Customer(name, email, accountType, contact,LocalDate.now());
		System.out.println(c);
		
		service.addCustomer(c);
		
		
		
	}
	
	public void displayCustomers() {
		
		List<Customer> customers=service.getAllCustomers();
		
		for(Customer c:customers) {
			System.out.println(c);
		}
		
	}
	
	public void searchCustomer() {
		
		System.out.print("Please enter the ID of Customer:");
		int id=sc.nextInt();
		
		Customer c=service.getCustomerByID(id);
		
		if(c!=null) {
			System.out.println("Name : "+c.getName()+" | Email : "+c.getEmail()+" | Contact: "+c.getContact()+" | Acc Type: "+c.getAccountType()+" | Creation Date: "+c.getAccountCreationDate());
		}
		else {
			System.out.println("Customer with requested ID not found!!");
		}
		
	}
	
	public void deleteCustomer() {
		
		System.out.print("Please enter the ID of Customer you want to Delete:");
		int id=sc.nextInt();
		
	}

}
