package com.jspider.product_management_app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jspider.product_management_app.connection.ProductConnection;
import com.jspider.product_management_app.dto.Product;

public class ProductDao {
	Connection connection=ProductConnection.getProductconnection();
	PreparedStatement ps;
	private final String insert_product_Query = "insert into product(name,price,color,mfd,expd) values(?,?,?,?,?)";
	private final String Display_AllProduct_Query="select * from product";
	private final String Update_productById_Query="update product set price= ? where id=?";
	private final String Delete_Product_Query="delete from product where id =?";
	public Product addProductDao(Product product) {
		try {
			ps=connection.prepareStatement(insert_product_Query);
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setString(3, product.getColor());
			ps.setObject(4, product.getMfd());
			ps.setObject(5, product.getExpd());
			
			ps.execute();
			System.out.println("Product Added......");
			return product;
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return null;
			}
		}
	
		public List<Product> DisplayAllProductDao() {
		
		try {
			ps=connection.prepareStatement(Display_AllProduct_Query);
			ResultSet resultSet=ps.executeQuery();
			List<Product> products = new ArrayList<Product>();
			int i=0;
			while(resultSet.next()) {
				int id=resultSet.getInt("id");
				String name = resultSet.getString("name");
				double price = resultSet.getDouble("price");
				String color=resultSet.getString("color");
				LocalDate mfd=resultSet.getDate("mfd").toLocalDate();
				LocalDate expd = resultSet.getDate("expd").toLocalDate();
				
				Product product = new Product(id, name, price, color, mfd, expd);
				products.add(product);
			}
			return products;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
		
		public int updateProductPriceById(int id, double price) {
			try {
				ps=connection.prepareStatement(Update_productById_Query);
				ps.setDouble(1, price);
				ps.setInt(2,id);
			
				return ps.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
				return 0;
			}
		}
		
		public int deleteProductById(int id) {
			try {
				ps=connection.prepareStatement(Delete_Product_Query);
				ps.setInt(1, id);
				return ps.executeUpdate();
			} catch (SQLException e) {
			
				e.printStackTrace();
				return 0;
			}
		}
		
}
