package com.jspider.product_management_app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jspider.product_management_app.connection.ProductConnection;
import com.jspider.product_management_app.dto.Admin;

public class AdminDao {
	Connection connection=ProductConnection.getProductconnection();
	PreparedStatement ps;
	private final String Insert_Admin_Query = "insert into admin(email,password) values (?,?)";
	private final String Display_AdminDetails_Query = "select * from admin";
	private final String Verify_Owner_Query = "update owner set verify = ? where email = ?";

	
	
	
	public Admin createAdminDao(Admin admin) {
		try {
			ps=connection.prepareStatement(Insert_Admin_Query);
			ps.setString(1, admin.getEmail());
			ps.setString(2, admin.getPassword());
			
			ps.execute();
			System.out.println("Admin Created......");
			return admin;
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return null;
			}
	}
	
	public boolean LogInAdminDao(String email,String password) {
	    	  try {
	  			ps=connection.prepareStatement(Display_AdminDetails_Query);
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
	
			public int verifyOwnerDao(String ownemail) {
				try {
						ps=connection.prepareStatement(Verify_Owner_Query);
						ps.setString(1, "yes");
						ps.setString(2, ownemail);
						return ps.executeUpdate();
					 }catch (SQLException e) {
		  			e.printStackTrace();
		  			return 0;
		  		} 
		 }
		
		
	


	

}
