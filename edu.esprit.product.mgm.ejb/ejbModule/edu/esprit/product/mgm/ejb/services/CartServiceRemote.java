package edu.esprit.product.mgm.ejb.services;

import javax.ejb.Remote;

import edu.esprit.product.mgm.ejb.domain.Customer;
import edu.esprit.product.mgm.ejb.domain.Product;

@Remote
public interface CartServiceRemote {
	
	public void addProductToCart(Product product, int quantity);
	public void clearCart();
	public void doPurchase(Customer customer);
	

}
