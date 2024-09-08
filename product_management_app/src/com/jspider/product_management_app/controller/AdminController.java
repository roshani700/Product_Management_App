package com.jspider.product_management_app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jspider.product_management_app.dao.AdminDao;
import com.jspider.product_management_app.dao.CustomerDao;
import com.jspider.product_management_app.dao.OwnerDao;
import com.jspider.product_management_app.dao.ProductDao;
import com.jspider.product_management_app.dto.Admin;
import com.jspider.product_management_app.dto.Customer;
import com.jspider.product_management_app.dto.Product;
import com.jspider.product_management_app.dto.ProductOwner;

public class AdminController {
	
	public static void main(String[] args) {
		char userchoice;
		AdminDao adminDao = new AdminDao();
		CustomerDao customerDao = new CustomerDao();
		OwnerDao ownerDao = new OwnerDao();
		ProductDao productDao=new ProductDao();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1.Admin \n2.Product Owner\n3.Customer\n4.Exit");
			System.out.println("================");
			System.out.println("Enter Your choice");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("1.Add Admin\n2.Admin Login\n3.Exit ");
				System.out.println("Enter Your Chice..");
				int ch = scanner.nextInt();
				switch(ch) {
				case 1:{
					System.out.println("Enter Email: ");
					String email = scanner.next();
					System.out.println("Enter Password: ");
					String password = scanner.next();
					Admin admin = new Admin(email,password);
					adminDao.createAdminDao(admin);
				}break;
					
				case 2:{
					System.out.println("Enter Email: ");
					String email = scanner.next();
					System.out.println("Enter Password: ");
					String password = scanner.next();
					if(adminDao.LogInAdminDao(email, password)) {
					
						System.out.println("you Logged in.....");
						System.out.println("a. Verify Product Owner");
						System.out.println("b. Display all Product");
						System.out.println("c. Display all Product Owner");
						System.out.println("d. Display all Customer");
						System.out.println("e. Back from here");
						System.out.println("Enter Your Choice");
						char ch1 = scanner.next().charAt(0);
						switch(ch1) {
						case 'a' :{
							System.out.println("Enter Email of Product Owner");
							String ownemail = scanner.next();
							int a=adminDao.verifyOwnerDao(ownemail);
							if(a==1)
								System.out.println("Verify Owner");
							else
								System.out.println("Email not Found!!");
							
						}break;
						
						case 'b':{
							List<Product> products = new ArrayList<Product>();
							products = productDao.DisplayAllProductDao();
							System.out.println("================All Products are Below===============");
							for (Product product : products) {
								if(product!=null)
									System.out.println(product);
							}
						}break;
						
						case 'c' :{
							List<ProductOwner> productOwners = new ArrayList<ProductOwner>();
							productOwners=ownerDao.DisplayAllProducOwnertDao();
							System.out.println("============All Customers are Below===========");
							for (ProductOwner productOwner : productOwners) {
								if(productOwner!=null)
									System.out.println(productOwner);
							}
							
						}break;
						
						case 'd' :{
								List<Customer> customers = new ArrayList<Customer>();
								customers=customerDao.DisplayAllCustomerDao();
								for (Customer customer : customers) {
									if(customer!=null)
										System.out.println(customer);
								}
							}break;
						case 'e' :{
							System.exit(1);	
						}break;
						default :
							System.out.println("Invalid choice");
						}
					}else
						System.out.println("plz! Enter correct email and password and verified owner");
				}break;
				
				case 3:{
					System.exit(1);
				}break;
				default :
					System.out.println("Invalid choice!!!");
				}	
				
			}break;
			
			case 2:{
				System.out.println("1.Register Owner\n2.Log in Owner\n3.Exit");
				System.out.println("Enter Your Chice..");
				int ch = scanner.nextInt();
				switch(ch) {
					case 1:{
						System.out.println("Enter Name: ");
						String name = scanner.next();
						System.out.println("Enter Email: ");
						String email = scanner.next();
						System.out.println("Enter Password: ");
						String password = scanner.next();
						ProductOwner po = new ProductOwner(name, email, password);
						ownerDao.OwnerRegistrationDao(po);
					}break;
			
					case 2:{
						System.out.println("Enter Email: ");
						String email = scanner.next();
						System.out.println("Enter Password: ");
						String password = scanner.next();
						if(ownerDao.LogInOwnerDao(email, password)) {
							System.out.println("you Logged in.....");
							System.out.println("a. Add Product");
							System.out.println("b. Display Product");
							System.out.println("c. Update Product");
							System.out.println("d. Delete Product");
							System.out.println("e. Back from here");
							System.out.println("Enter Your Choice");
							char ch1 = scanner.next().charAt(0);
							switch(ch1) {
							case 'a' :{
								System.out.println("Enter Product Details:");
								 System.out.println("Enter Name ");
								 String name=scanner.next();
								 System.out.println("Enter Price ");
								 Double price=scanner.nextDouble();
								 System.out.println("Enter Color ");
								 String color=scanner.next();
								 System.out.println("Enter Manufacturing Date ");
								 String mfd=scanner.next();
								 System.out.println("Enter expaire Date ");
								 String expd=scanner.next();
								 Product product = new Product(name, price, color,LocalDate.parse(mfd),LocalDate.parse(expd));
								 Product product2=productDao.addProductDao(product);
								 if(product2!=null)
										System.out.println("Product Added...........");
									else
										System.out.println("Data Not Stored.......please Check Your Product Details");
								}break;
							
							case 'b':{
								List<Product> products = new ArrayList<Product>();
								products = productDao.DisplayAllProductDao();
								for (Product product : products) {
									if(product!=null)
										System.out.println(product);
								}
							}break;
							case 'c' :{
								System.out.println("Enter id to update");
								int id=scanner.nextInt();
								System.out.println("Enter new Price");
								double price = scanner.nextDouble();
								int val = productDao.updateProductPriceById(id, price);
								if(val==1)
									System.out.println("Price Updated Successfully....");
								else
									System.out.println("Record not found!!");
								
								}break;
							case 'd' :{
								System.out.println("Enter id to delete");
								int id=scanner.nextInt();
								int val = productDao.deleteProductById(id);
								if(val==1)
									System.out.println("Product Deleted...");
								else
									System.out.println("Record not found!!");
								
								}break;
							case 'e' :{
								System.exit(1);
							}break;
							default :
								System.out.println("Invalid choice");
							}
						}
						else
							System.out.println("plz! Enter correct email and password");
					}break;
					case 3:{
						System.exit(1);
					}break;
					default: 
						System.err.println("Invalid Option");
				}
			
			
			}break;
			case 3:{
				System.out.println("1.Register Customer\n2.Log in Customer\n3.Exit");
				System.out.println("Enter Your Chice..");
				int ch = scanner.nextInt();
				switch(ch) {
					case 1:{
						System.out.println("Enter Name: ");
						String name = scanner.next();
						System.out.println("Enter Email: ");
						String email = scanner.next();
						System.out.println("Enter Password: ");
						String password = scanner.next();
						Customer c1 = new Customer(name, email, password);
						customerDao.CustomerRegistrationDao(c1);
					}break;
			
					case 2:{
						System.out.println("Enter Email: ");
						String email = scanner.next();
						System.out.println("Enter Password: ");
						String password = scanner.next();
						if(customerDao.LogCustomerDao(email, password)) {
							System.out.println("you Logged in.....");
							System.out.println("a.Display Product");
							System.out.println("b.Exit");
							System.out.println("Choose Option");
							char ch1=scanner.next().charAt(0);
							switch(ch1) {
							case 'a':{
								List<Product> products = new ArrayList<Product>();
								products = productDao.DisplayAllProductDao();
								for (Product product : products) {
									if(product!=null)
										System.out.println(product);
									}
							}break;
							case 'b':{
								System.exit(1);
							}break;
						}
					}
					else
						System.out.println("Email or Password is wrong!!");
				}break;
					case 3:{
						System.exit(1);
					}break;
					default: 
						System.err.println("Invalid Option");
					}
				}break;
			case 4:{
				System.exit(1);
				}break;
			default:
				System.out.println("Invalid Choice!!");
				}
			System.out.println("Enter Y/y to continue...Otherwise Press any key");
			userchoice=scanner.next().charAt(0);
			}while(userchoice=='y' || userchoice=='Y');
		System.out.println("Application closed..");
		}
}
