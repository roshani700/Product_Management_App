package com.jspider.product_management_app.dto;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
	 private int id;
	 private String name;
	 private double price;
	 private String color;
	 private LocalDate mfd;
	 private LocalDate expd;
	public Product(int id, String name, double price, String color, LocalDate mfd, LocalDate expd) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.color=color;
		this.mfd = mfd;
		this.expd = expd;

	}
	public Product(String name, double price, String color, LocalDate mfd, LocalDate expd) {
		super();
		this.name = name;
		this.price = price;
		this.color=color;
		this.mfd = mfd;
		this.expd = expd;
	}
	public Product() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public LocalDate getMfd() {
		return mfd;
	}
	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}
	public LocalDate getExpd() {
		return expd;
	}
	public void setExpd(LocalDate expd) {
		this.expd = expd;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price +  ", color=" + color + ", mfd=" + mfd + ", expd=" + expd + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(color, expd, id, mfd, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(color, other.color) && Objects.equals(expd, other.expd) && id == other.id
				&& Objects.equals(mfd, other.mfd) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	
	 
	 
	 
	

}
