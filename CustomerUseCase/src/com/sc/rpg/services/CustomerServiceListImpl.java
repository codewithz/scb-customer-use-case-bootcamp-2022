package com.sc.rpg.services;

import java.util.ArrayList;
import java.util.List;

import com.sc.rpg.model.Customer;

public class CustomerServiceListImpl implements CustomerService{
	
	List<Customer> dataList=new ArrayList<>();
	

	@Override
	public void addCustomer(Customer c) {
		
		int nextId=getNextId();
		c.setId(nextId);
		dataList.add(c);
		
		System.out.println("Customer added successfully with ID: "+nextId);
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return dataList;
	}

	@Override
	public Customer getCustomerByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getNextId() {
		return dataList.size()+1;
	}

}
