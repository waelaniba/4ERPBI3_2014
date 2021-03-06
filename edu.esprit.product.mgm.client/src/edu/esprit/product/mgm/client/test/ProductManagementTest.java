package edu.esprit.product.mgm.client.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.LazyInitializationException;
import org.junit.Before;
import org.junit.Test;

import edu.esprit.product.mgm.client.utils.BusinessDelegate;
import edu.esprit.product.mgm.client.utils.CartServiceBusinessDelegate;
import edu.esprit.product.mgm.client.utils.CategoryServiceBusinessDelegate;
import edu.esprit.product.mgm.client.utils.ProductServiceBusinessDelegate;
import edu.esprit.product.mgm.client.utils.UsersServiceBusinessDelegate;
import edu.esprit.product.mgm.ejb.domain.Administrator;
import edu.esprit.product.mgm.ejb.domain.Category;
import edu.esprit.product.mgm.ejb.domain.Customer;
import edu.esprit.product.mgm.ejb.domain.Department;
import edu.esprit.product.mgm.ejb.domain.Product;
import edu.esprit.product.mgm.ejb.domain.User;

public class ProductManagementTest {

	ProductServiceBusinessDelegate productServiceBusinessDelegate;
	CategoryServiceBusinessDelegate categoryServiceBusinessDelegate;
	UsersServiceBusinessDelegate usersServiceBusinessDelegate;
	CartServiceBusinessDelegate cartServiceBusinessDelegate;
	
	
	@Before
	public void setUp() throws Exception {
		
		productServiceBusinessDelegate = BusinessDelegate.getInstance().getProductServiceBusinessDelegate();
		categoryServiceBusinessDelegate = BusinessDelegate.getInstance().getCategoryServiceBusinessDelegate();
		usersServiceBusinessDelegate = BusinessDelegate.getInstance().getUsersServiceBusinessDelegate();
		cartServiceBusinessDelegate = BusinessDelegate.getInstance().getCartServiceBusinessDelegate();
	}

	@Test
	public void test01_itShouldAddProduct() {
		
		Product product = new Product();
		product.setDesignation("HP");
		product.setSerialNumber("ASDF212154i");
		productServiceBusinessDelegate.addProduct(product);
		
	}
	
	
	@Test
	public void test02_itShouldFindProduct() {
		
		Product product = productServiceBusinessDelegate.findProduct(1);
		assertEquals("Sony", product.getDesignation());
	}
	
	@Test
	public void test03_itShouldUpdtateProduct() {
		
		Product product = new Product();
		product.setIdProduct(1);
		product.setDesignation("AAA");
		product.setSerialNumber("4545765454");
		
		productServiceBusinessDelegate.updateProduct(product);
	}
	
	@Test
	public void test04_itShouldDeleteProduct() {
		
		Product product = new Product();
		product.setIdProduct(1);
		productServiceBusinessDelegate.deleteProduct(product);
	}
	
	@Test
	public void test05_itShouldAddCategory() {
		
		Category category = new Category();
		category.setDesignation("Screen"); 
		categoryServiceBusinessDelegate.addCategory(category);
	}
	
	@Test
	public void test06_itShouldAddProductWithExistingCategory() {
		
		Category category = categoryServiceBusinessDelegate.findCategory(1);
		Product product = new Product();
		product.setDesignation("HP");
		product.setSerialNumber("ASDF21");
		
		productServiceBusinessDelegate.addProductCategory(product, category);
	}
	
	@Test
	public void test07_itShouldAddProductWithNewCategory() {
		
		Category category = new Category();
		category.setDesignation("SmartPhone"); 
		
		Product product = new Product();
		product.setDesignation("LG");
		product.setSerialNumber("ASHGF25487");
		
		productServiceBusinessDelegate.addProductWithNewCategory(product, category);
	}
	
	
	@Test
	public void test08_itShouldFindProductsForAGivenCategory() {
		
		Category category = new Category();
		category.setIdCategory(1);
		List<Product> products = productServiceBusinessDelegate.findProductOfCategory(category);
		assertEquals(1, products.size());
		
	}
	
	
	@Test
	public void test09_itShouldDeleteCategoryWithAssociatedProducts() {
		
		Category category = new Category();
		category.setIdCategory(1);
		categoryServiceBusinessDelegate.deleteCategory(category);
	}
	
	
	@Test
	public void test10_itShouldFindAllCategories() {
		
		List<Category> categories = categoryServiceBusinessDelegate.findAll();
		assertEquals(6, categories.size());
	}
	
	@Test
	public void test11_itShouldAddAdmin(){
		
		Administrator administrator = new Administrator();
		administrator.setFirstName("adminFN");
		administrator.setLastName("adminLN");
		administrator.setEmail("admin@admin.com");
		administrator.setPassword("adminpwd");
		administrator.setPhoneNumber("22 854 700");
		administrator.setRecruitementDate(new Date(110, 11, 11));
		
		usersServiceBusinessDelegate.addAdmin(administrator);
	}
	
	
	@Test
	public void test12_itShouldAddCustomer(){
		
		Customer customer = new Customer();
		customer.setFirstName("customerFN");
		customer.setLastName("customerLN");
		customer.setEmail("customer@customer.com");
		customer.setPassword("customerpwd");
		customer.setPhoneNumber("99 854 700");
		customer.setRib("5487986521548700");
		
		usersServiceBusinessDelegate.addCustomer(customer);
	}
	
	@Test
	public void test13_itShouldLogInAsAdmin(){
		
		User user = usersServiceBusinessDelegate.authenticate("admin@admin.com", "adminpwd");
		
		if(user  instanceof Administrator){
			
			System.out.println("Logged in as administrator");
			
		}else if(user instanceof Customer){
			
			System.out.println("Logged in as customer");
		}else{
			
			System.out.println("Bad credentials");
			
		}
		

	}
	
	@Test
	public void test14_itShouldLogInAsACustomer(){
		
		User user = usersServiceBusinessDelegate.authenticate("customer@customer.com", "customerpwd");
		
		if(user  instanceof Administrator){
			
			System.out.println("Logged in as administrator");
			
		}else if(user instanceof Customer){
			
			System.out.println("Logged in as customer");
		}else{
			
			System.out.println("Bad credentials");
			
		}
		

	}
	
	@Test
	public void test15_itShouldNotLogIn(){
		
		User user = usersServiceBusinessDelegate.authenticate("none@none.com", "nonepwd");
		
		if(user  instanceof Administrator){
			
			System.out.println("Logged in as administrator");
			
		}else if(user instanceof Customer){
			
			System.out.println("Logged in as customer");
		}else{
			
			System.out.println("Bad credentials");
			
		}
		
	}
		
		
		@Test
		public void test16_itShouldgetCategory(){
			
			Product p =new Product();
			p.setIdProduct(1);
			assertEquals("SmartPhone", productServiceBusinessDelegate.getProductCategory(p).getDesignation() );
				
			}
		

		@Test
		public void test17_itShouldFindProductsForAGivenCategoryLazilly() {
			
			Category category = new Category();
			category.setIdCategory(1);
			List<Product> products = productServiceBusinessDelegate.getCategoryProductsLazilly(category);
			
			assertEquals(1, products.size());
			
		}
		
		@Test
		public void test18_itShouldFindAllDepartmentAddresses() {
			
			Department dept = new Department();
			dept.setName("Informatique");
			
			assertEquals(3, usersServiceBusinessDelegate.getDepartmentAddresses(dept).size() );
			
		}
		
		
		@Test
		public void test19_itShouldAddNewTransaction() {

			Customer customer = (Customer) usersServiceBusinessDelegate.findUser(1);
			
			Product p1 = productServiceBusinessDelegate.findProduct(1);
			Product p2 = productServiceBusinessDelegate.findProduct(2);
			
			cartServiceBusinessDelegate.addProductToCart(p1, 5);
			cartServiceBusinessDelegate.addProductToCart(p2, 7);
			
			cartServiceBusinessDelegate.doPurchase(customer);
			
			
		}
		
		@Test
		public void test20_itShouldfindRangeOfCategories() {



			List<Category> categories = categoryServiceBusinessDelegate.findRangeOfCategories(3, 3);
			
			for(Category cat : categories){
				
				
				System.out.println("Category : " + cat.getDesignation());
				
			}
			
			
		}
		
		
	

}
