package edu.esprit.product.mgm.ejb.services;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.product.mgm.ejb.domain.Category;

@Remote
public interface CategoryMgmRemote {
	
	public void addCategory(Category c);
	public void updateCategory(Category c);
	public Category findCategory (int idCategory);
	public void deleteCategory(Category c);
	public List<Category> findAll();
}
