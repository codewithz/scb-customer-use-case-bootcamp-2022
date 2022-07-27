package com.sc.rpg.services;

import java.util.List;

import com.sc.rpg.model.Customer;

public interface CustomerService {
	
	public void addCustomer(Customer c);
	public List<Customer> getAllCustomers();
	public Customer getCustomerByID(int id);
	public String deleteCustomer(int id);
	

}
