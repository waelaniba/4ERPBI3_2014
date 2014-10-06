package edu.esprit.product.mgm.ejb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.product.mgm.ejb.domain.Category;
import edu.esprit.product.mgm.ejb.domain.Product;

/**
 * Session Bean implementation class ProductMgm
 */
@Stateless
public class ProductMgm implements ProductMgmRemote {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public ProductMgm() {
	}

	@Override
	public void addProduct(Product p) {
		
		em.persist(p);
	}

	@Override
	public void updateProduct(Product p) {
		
		em.merge(p);
	}

	@Override
	public Product findProduct(int idProduct) {
		
		return em.find(Product.class, idProduct);
	}

	@Override
	public void deleteProduct(Product p) {
		
		em.remove(em.merge(p));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {

		return em.createNamedQuery("findAllProduts").getResultList();
	}

	@Override
	public void addProductWithCategory(Product p, Category c) {

		Category category = em.find(Category.class, c.getIdCategory());
		p.associateCategoryToProduct(category);
		em.persist(p);
	}

	@Override
	public void addProductWithNewCategory(Product p, Category c) {
		
		p.associateCategoryToProduct(c);
		em.persist(p);

	}

}
