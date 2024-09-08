package com.jspider.product_management_app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.product_management_app.connection.ProductConnection;
import com.jspider.product_management_app.dto.ProductOwner;

public class OwnerDao {
	Connection connection=ProductConnection.getProductconnection();
	PreparedStatement ps;
	
	private final String Insert_Owner_Query = "insert into owner(name,email,password) values (?,?,?)";
	private final String Display_OwnerDetails_query = "select * from owner";
	
	
		public ProductOwner OwnerRegistrationDao(ProductOwner owner) {
			try {
				ps=connection.prepareStatement(Insert_Owner_Query);
				ps.setString(1, owner.getName());
				ps.setString(2, owner.getEmail());
				ps.setString(3, owner.getPassword());
				
			
				ps.execute();
				System.out.println("Owner Registerd Successfully......");
			return owner;
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.err.println("Error : Something Missing... ");
			return null;
		}
	}
		
		public boolean LogInOwnerDao(String email,String password) {
	    	  try {
	  			ps=connection.prepareStatement(Display_OwnerDetails_query);
	  			ResultSet rs=ps.executeQuery();
	  			int i=0;
	  			while(rs.next()) {
	  			String oldemail=rs.getString("email");
	  			String pass= rs.getString("password");
	  			if((oldemail.compareTo(email)==0) && (pass.compareTo(password)==0)) {
	  				if(rs.getString("verify").compareToIgnoreCase("yes")==0)
	  						return true;
	  				else {
	  					System.out.println("Not Verified by Owner....");
	  					return false;
	  				}
	  					
	  			}
	  				
	  			  i++;
	  		}
	  		return false;	
	    	  }catch (SQLException e) {
	  			
	  			e.printStackTrace();
	  			return false;
	  		} 
	    }
		
		public List<ProductOwner> DisplayAllProducOwnertDao() {
			
			try {
				ps=connection.prepareStatement(Display_OwnerDetails_query);
				ResultSet resultSet=ps.executeQuery();
				List<ProductOwner> productOwners = new ArrayList<ProductOwner>();
				int i=0;
				while(resultSet.next()) {
					int id=resultSet.getInt("id");
					String name = resultSet.getString("name");
					String email = resultSet.getString("email");
					String password = resultSet.getString("password");
					String verify = resultSet.getString("verify");
					ProductOwner productOwner = new ProductOwner(id, name, email, password, verify);
					
					
					productOwners.add(productOwner);
				}
				return productOwners;
			} catch (SQLException e) {
				
				e.printStackTrace();
				return null;
			}
		}

}
