package edu.esprit.product.mgm.ejb.services;

import javax.ejb.Remote;

import edu.esprit.product.mgm.ejb.domain.Administrator;
import edu.esprit.product.mgm.ejb.domain.Customer;
import edu.esprit.product.mgm.ejb.domain.User;

@Remote
public interface UserMgmRemote {
	
	public void addAdmin(Administrator administrator);
	public void addCustomer(Customer customer);
	public User authenticate(String email, String password);

}
