package edu.esprit.product.mgm.client.utils;

import edu.esprit.product.mgm.ejb.domain.Administrator;
import edu.esprit.product.mgm.ejb.domain.Customer;
import edu.esprit.product.mgm.ejb.domain.Product;
import edu.esprit.product.mgm.ejb.domain.User;
import edu.esprit.product.mgm.ejb.services.ProductMgmRemote;
import edu.esprit.product.mgm.ejb.services.UserMgmRemote;

public class UsersServiceBusinessDelegate {
	
	public void addAdmin(Administrator administrator) {

		UserMgmRemote userMgmRemote = (UserMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/UserMgm!edu.esprit.product.mgm.ejb.services.UserMgmRemote");

		userMgmRemote.addAdmin(administrator);
	}
	
	public void addCustomer(Customer customer) {

		UserMgmRemote userMgmRemote = (UserMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/UserMgm!edu.esprit.product.mgm.ejb.services.UserMgmRemote");

		userMgmRemote.addCustomer(customer);
	}
	
	public User authenticate(String email, String pwd) {

		UserMgmRemote userMgmRemote = (UserMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/UserMgm!edu.esprit.product.mgm.ejb.services.UserMgmRemote");

		return userMgmRemote.authenticate(email, pwd);
	}
	
	
	

}
