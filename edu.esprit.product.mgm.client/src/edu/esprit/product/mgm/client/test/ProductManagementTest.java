package edu.esprit.product.mgm.client.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.esprit.product.mgm.client.utils.BusinessDelegate;
import edu.esprit.product.mgm.client.utils.CategoryServiceBusinessDelegate;
import edu.esprit.product.mgm.client.utils.ProductServiceBusinessDelegate;
import edu.esprit.product.mgm.ejb.domain.Category;
import edu.esprit.product.mgm.ejb.domain.Product;

public class ProductManagementTest {

	ProductServiceBusinessDelegate productServiceBusinessDelegate;
	CategoryServiceBusinessDelegate categoryServiceBusinessDelegate;
	
	
	@Before
	public void setUp() throws Exception {
		
		productServiceBusinessDelegate = BusinessDelegate.getInstance().getProductServiceBusinessDelegate();
		categoryServiceBusinessDelegate = BusinessDelegate.getInstance().getCategoryServiceBusinessDelegate();
	}

	@Test
	public void test01_itShouldAddProduct() {
		
		Product product = new Product();
		product.setDesignation("Sony");
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
		
		Product product = productServiceBusinessDelegate.findProduct(1);
		product.setDesignation("HP");
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
		category.setDesignation("Laptop"); 
		categoryServiceBusinessDelegate.addCategory(category);
	}
	
	@Test
	public void test06_itShouldAddProductWithExistingCategory() {
		
		Category category = categoryServiceBusinessDelegate.findCategory(1);
		Product product = new Product();
		product.setDesignation("Sony");
		product.setSerialNumber("ASDF212154i");
		
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
		assertEquals(1, categories.size());
	}
	
	

}
