package com.sc.rpg.services;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sc.rpg.helper.DatabaseConnector;
import com.sc.rpg.model.Customer;

public class CustomerServiceDBImpl implements CustomerService{
	
	DatabaseConnector db=new DatabaseConnector();

	@Override
	public void addCustomer(Customer c) {

		
		try {
			String query="Insert into customer(name,email,contact,account_type,account_creation_date) values (?,?,?,?,?)";
			
			PreparedStatement pstmt=db.getPreparedStatement(query);
			
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getEmail());
			pstmt.setLong(3, c.getContact());
			pstmt.setString(4, c.getAccountType());
			pstmt.setObject(5, c.getAccountCreationDate());
			
//			Execution of the query
			
			int rowInserted=pstmt.executeUpdate();
			System.out.println("Customer addedd successfully!!");
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> customers=new ArrayList<>();
		

		
		try {
			
			String query="Select id,name,email,contact,account_type,account_creation_date from customer";
			
			PreparedStatement pstmt=db.getPreparedStatement(query);
			
//			Execution of the query
			
			ResultSet rs=pstmt.executeQuery();
			
			while( rs.next() ) {
				
				Customer c=new Customer();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setContact(rs.getLong("contact"));
				c.setAccountType(rs.getString("account_type"));
				c.setAccountCreationDate(LocalDate.parse(rs.getString("account_creation_date")));
				
				customers.add(c);
				
				c=null;
				
			}
				
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		return customers;
	}

	@Override
	public Customer getCustomerByID(int id) {
		Customer c=null;
		
		try {
			String query="Select id,name,email,contact,account_type,account_creation_date from customer where id=?";
			PreparedStatement pstmt=db.getPreparedStatement(query);
			
			pstmt.setInt(1, id);
			
			ResultSet rs=pstmt.executeQuery();
			
	if( rs.next() ) {
				
				c=new Customer();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setContact(rs.getLong("contact"));
				c.setAccountType(rs.getString("account_type"));
				c.setAccountCreationDate(LocalDate.parse(rs.getString("account_creation_date")));
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			db.closeConnection();
		}
		
		return c;
	}

	@Override
	public String deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
