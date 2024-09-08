package com.jspider.product_management_app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.product_management_app.connection.ProductConnection;
import com.jspider.product_management_app.dto.Customer;

public class CustomerDao {
	
	Connection connection=ProductConnection.getProductconnection();
	PreparedStatement ps;
	private final String Insert_Customer_Query = "insert into customer(name,email,password) values (?,?,?)";
	private final String Display_Allcustomer_Query="select * from customer";
	
	
		public Customer CustomerRegistrationDao(Customer customer) {
			try {
				ps=connection.prepareStatement(Insert_Customer_Query);
				ps.setString(1, customer.getName());
				ps.setString(2, customer.getEmail());
				ps.setString(3, customer.getPassword());
				ps.execute();
				System.out.println("Customer Registerd Successfully......");
			return customer;
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.err.println("Error : Something Missing... ");
			return null;
		}
	}
		
		public boolean LogCustomerDao(String email,String password) {
	    	  try {
	  			ps=connection.prepareStatement(Display_Allcustomer_Query);
	  			ResultSet rs=ps.executeQuery();
	  			int i=0;
	  			while(rs.next()) {
	  			String oldemail=rs.getString("email");
	  			String pass= rs.getString("password");
	  			if((oldemail.compareTo(email)==0) && (pass.compareTo(password)==0)) 
	  						return true;
	  			i++;
	  		}
	  		return false;	
	    	  }catch (SQLException e) {
	  			
	  			e.printStackTrace();
	  			return false;
	  		} 
	    }
		
		public List<Customer> DisplayAllCustomerDao() {
			
				try {
					ps=connection.prepareStatement(Display_Allcustomer_Query);
					ResultSet resultSet=ps.executeQuery();
					List<Customer> customers = new ArrayList<Customer>();
					int i=0;
					while(resultSet.next()) {
						int id=resultSet.getInt("id");
						String name = resultSet.getString("name");
						String email = resultSet.getString("email");
						String password = resultSet.getString("password");
						
						Customer customer=new Customer(id, name, email, password);
					
					
					customers.add(customer);
				}
				return customers;
			} catch (SQLException e) {
				
				e.printStackTrace();
				return null;
			}
		}

		
}
