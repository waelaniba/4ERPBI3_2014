package edu.esprit.product.mgm.ejb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.esprit.product.mgm.ejb.domain.Category;

/**
 * Session Bean implementation class CategoryMgm
 */
@Stateless

public class CategoryMgm implements CategoryMgmRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CategoryMgm() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCategory(Category c) {
		
		em.persist(c);
	}

	@Override
	public void updateCategory(Category c) {
		
		em.merge(c);
	}

	@Override
	public Category findCategory(int idCategory) {
		
		return em.find(Category.class, idCategory);
	}

	@Override
	public void deleteCategory(Category c) {
		
		em.remove(em.merge(c));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		
		TypedQuery<Category> typedQuery = em.createQuery("select c from CetegoryTAB c", Category.class);		
		return  (List<Category>) typedQuery.getResultList();
	}

}
