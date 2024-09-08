package com.jspider.product_management_app.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductConnection {
	
	public static Connection getProductconnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/product-project","root","Roshani700");
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
			
			return null;
		}
	}

}
