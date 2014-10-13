package edu.esprit.product.mgm.ejb.services;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.product.mgm.ejb.domain.Customer;
import edu.esprit.product.mgm.ejb.domain.Product;
import edu.esprit.product.mgm.ejb.domain.Transaction;

/**
 * Session Bean implementation class CartService
 */
@Stateful
public class CartService implements CartServiceRemote {

	
	private Map<Product, Integer> products = new HashMap<Product, Integer>();
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public CartService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addProductToCart(Product product, int quantity) {
		
		products.put(product, quantity);
		
	}

	@Override
	public void clearCart() {
		
		products.clear();
	}

	@Override
	public void doPurchase(Customer customer) {
		
		for(Map.Entry<Product, Integer> entry : products.entrySet()){
			
			em.persist(new Transaction(customer, entry.getKey(), entry.getValue()));
		}
		
	}

}
