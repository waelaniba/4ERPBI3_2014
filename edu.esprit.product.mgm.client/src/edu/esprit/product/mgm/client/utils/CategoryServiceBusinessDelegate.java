package edu.esprit.product.mgm.client.utils;

import java.util.List;

import edu.esprit.product.mgm.ejb.domain.Category;
import edu.esprit.product.mgm.ejb.services.CategoryMgmRemote;

/**
 * CategoryServiceBusinessDelegate
 * 
 * @author wael.aniba
 */

public class CategoryServiceBusinessDelegate {

	public void addCategory(Category c) {

		CategoryMgmRemote categoryMgmRemote = (CategoryMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/CategoryMgm!edu.esprit.product.mgm.ejb.services.CategoryMgmRemote");

		categoryMgmRemote.addCategory(c);
	}

	public void deleteCategory(Category c) {

		CategoryMgmRemote categoryMgmRemote = (CategoryMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/CategoryMgm!edu.esprit.product.mgm.ejb.services.CategoryMgmRemote");

		categoryMgmRemote.deleteCategory(c);
	}

	public Category findCategory(int i) {
		CategoryMgmRemote categoryMgmRemote = (CategoryMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/CategoryMgm!edu.esprit.product.mgm.ejb.services.CategoryMgmRemote");

		return categoryMgmRemote.findCategory(i);

	}

	public List<Category> findAll() {
		CategoryMgmRemote categoryMgmRemote = (CategoryMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/CategoryMgm!edu.esprit.product.mgm.ejb.services.CategoryMgmRemote");

		return categoryMgmRemote.findAll();
	}
}
