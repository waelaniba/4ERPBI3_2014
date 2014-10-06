package edu.esprit.product.mgm.ejb.services;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.product.mgm.ejb.domain.Category;
import edu.esprit.product.mgm.ejb.domain.Product;

@Remote
public interface ProductMgmRemote {
	
	public void addProduct(Product p);
	public void updateProduct(Product p);
	public Product findProduct(int idProduct);
	public void deleteProduct(Product p);
	public List<Product> findAll();
	public void addProductWithCategory(Product p, Category c);
	public void addProductWithNewCategory(Product p, Category c);
	

}
