package com.jspider.product_management_app.dto;

import java.util.Objects;

public class ProductOwner {
	private int id;
	private String name;
	private String email;
	private String password;
	private String verify;
	
	
	public ProductOwner(int id, String name, String email, String password, String verify) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.verify = verify;
	}


	public ProductOwner(String name, String email, String password, String verify) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.verify = verify;
	}

	

	public ProductOwner(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}


	public ProductOwner() {
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getVerify() {
		return verify;
	}


	public void setVerify(String verify) {
		this.verify = verify;
	}


	@Override
	public String toString() {
		return "ProductOwner [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", verify="
				+ verify + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password, verify);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductOwner other = (ProductOwner) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(verify, other.verify);
	}


	

    
    	

	
	
	
	
}
