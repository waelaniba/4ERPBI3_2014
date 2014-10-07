package edu.esprit.product.mgm.ejb.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.product.mgm.ejb.domain.Administrator;
import edu.esprit.product.mgm.ejb.domain.Customer;
import edu.esprit.product.mgm.ejb.domain.User;

/**
 * Session Bean implementation class UserMgm
 */
@Stateless
public class UserMgm implements UserMgmRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UserMgm() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addAdmin(Administrator administrator) {
		
		em.persist(administrator);

	}

	@Override
	public void addCustomer(Customer customer) {
		em.persist(customer);
		
	}

	@Override
	public User authenticate(String email, String password) {
		
		User user = null;
		try {
			
			Query query = em.createQuery("select u from User u where u.email =:param1 and u.password=:param2");
			user = (User) query.setParameter("param1", email).setParameter("param2", password).getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return user;
		
	}

}
