package com.sc.rpg.helper;

import java.sql.*;

public class DatabaseConnector {
	
	Connection con=null;
	
	public Connection getConnection() {
		String url="jdbc:postgresql://localhost:5432/scb-rpg-2022";
		String username="postgres";
		String password="admin";

		
		try {
			
			Class.forName("org.postgresql.Driver"); //Step 2
			System.out.println("Driver Loaded Successfully!!");
			
			con=DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Successfully");	
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public PreparedStatement getPreparedStatement(String query) {
		PreparedStatement pstmt=null;
		
		try {
			
			Connection con=getConnection();
			
			pstmt=con.prepareStatement(query);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pstmt;
		
	}
	
	public void closeConnection() {
		try {
			if(con!=null) {
				con.close();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
