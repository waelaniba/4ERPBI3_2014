package edu.esprit.product.mgm.client.utils;

import java.util.List;

import edu.esprit.product.mgm.ejb.domain.Category;
import edu.esprit.product.mgm.ejb.domain.Customer;
import edu.esprit.product.mgm.ejb.domain.Product;
import edu.esprit.product.mgm.ejb.services.CartServiceRemote;
import edu.esprit.product.mgm.ejb.services.CategoryMgmRemote;

/**
 * CategoryServiceBusinessDelegate
 * 
 * @author wael.aniba
 */

public class CartServiceBusinessDelegate {

	
	
	public void addProductToCart(Product product, int quantity) {

		CartServiceRemote cartServiceRemote = (CartServiceRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/CartService!edu.esprit.product.mgm.ejb.services.CartServiceRemote");

		
		cartServiceRemote.addProductToCart(product, quantity);
	}
	
	public void clearCart() {

		CartServiceRemote cartServiceRemote = (CartServiceRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/CartService!edu.esprit.product.mgm.ejb.services.CartServiceRemote");

		
		cartServiceRemote.clearCart();
	}
	
	public void doPurchase(Customer customer) {

		CartServiceRemote cartServiceRemote = (CartServiceRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/CartService!edu.esprit.product.mgm.ejb.services.CartServiceRemote");

		
		cartServiceRemote.doPurchase(customer);
	}
	
}
