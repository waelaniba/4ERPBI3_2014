package edu.esprit.product.mgm.ejb.services;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import edu.esprit.product.mgm.ejb.domain.Category;
import edu.esprit.product.mgm.ejb.domain.Product;
import edu.esprit.product.mgm.ejb.interceptors.LoggingInterceptor;
import edu.esprit.product.mgm.ejb.interceptors.TransactionInterceptor;

/**
 * Session Bean implementation class ProductMgm
 */
@Stateless
@Interceptors({LoggingInterceptor.class, TransactionInterceptor.class})
@TransactionManagement(TransactionManagementType.BEAN)
public class ProductMgm implements ProductMgmRemote {

	@PersistenceContext
	EntityManager em;

	@Resource 
	public UserTransaction tx;
	
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
		
		p.setDesignation("BBB");
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

	@Override
	public Category getProductCategory(Product p) {

		Category category = null;

		try {
			Query query = em
					.createQuery("select p.category from ProductTAB p where p.idProduct =:param");
			query.setParameter("param", p.getIdProduct());

			category = (Category) query.getSingleResult();

		} catch (Exception e) {
		}

		return category;
	}

	@Override
	public List<Product> findCategoryProductsLazilly(Category category) {
		
		TypedQuery<Product> tQuery = em.
				createQuery("select p from ProductTAB p where p.category.idCategory like?1", Product.class);
		tQuery.setParameter(1, category.getIdCategory());
		
		return tQuery.getResultList();
	}
	


}
