package edu.esprit.product.mgm.client.utils;

import java.util.List;

import edu.esprit.product.mgm.ejb.domain.Category;
import edu.esprit.product.mgm.ejb.domain.Product;
import edu.esprit.product.mgm.ejb.services.CategoryMgmRemote;
import edu.esprit.product.mgm.ejb.services.ProductMgmRemote;

/**
 * ProductServiceBusinessDelegate
 * 
 * @author wael.aniba
 */

public class ProductServiceBusinessDelegate {

	public void addProduct(Product p) {

		ProductMgmRemote producmMgmRemote = (ProductMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/ProductMgm!edu.esprit.product.mgm.ejb.services.ProductMgmRemote");

		producmMgmRemote.addProduct(p);
	}

	public void addProductCategory(Product p, Category c) {

		ProductMgmRemote producmMgmRemote = (ProductMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/ProductMgm!edu.esprit.product.mgm.ejb.services.ProductMgmRemote");

		producmMgmRemote.addProductWithCategory(p, c);
	}

	public void addProductWithNewCategory(Product p, Category c) {

		ProductMgmRemote producmMgmRemote = (ProductMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/ProductMgm!edu.esprit.product.mgm.ejb.services.ProductMgmRemote");

		producmMgmRemote.addProductWithNewCategory(p, c);
	}

	public void updateProduct(Product p) {

		ProductMgmRemote producmMgmRemote = (ProductMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/ProductMgm!edu.esprit.product.mgm.ejb.services.ProductMgmRemote");

		producmMgmRemote.updateProduct(p);
	}

	public Product findProduct(int idProduct) {

		ProductMgmRemote producmMgmRemote = (ProductMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/ProductMgm!edu.esprit.product.mgm.ejb.services.ProductMgmRemote");

		return producmMgmRemote.findProduct(idProduct);
	}

	public void deleteProduct(Product p) {

		ProductMgmRemote producmMgmRemote = (ProductMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/ProductMgm!edu.esprit.product.mgm.ejb.services.ProductMgmRemote");

		producmMgmRemote.deleteProduct(p);
	}

	public List<Product> findAllProducts() {

		ProductMgmRemote producmMgmRemote = (ProductMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/ProductMgm!edu.esprit.product.mgm.ejb.services.ProductMgmRemote");

		return producmMgmRemote.findAll();
	}

	public List<Product> findProductOfCategory(Category c) {

		CategoryMgmRemote categoryMgmRemote = (CategoryMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/CategoryMgm!edu.esprit.product.mgm.ejb.services.CategoryMgmRemote");

		Category cat = categoryMgmRemote.findCategory(c.getIdCategory());
		List<Product> prods = cat.getProducts();

		return prods;
	}
	
	public Category getProductCategory(Product p) {

		ProductMgmRemote producmMgmRemote = (ProductMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/ProductMgm!edu.esprit.product.mgm.ejb.services.ProductMgmRemote");
		
		return producmMgmRemote.getProductCategory(p);
	}

	public List<Product> getCategoryProductsLazilly(Category c) {

		ProductMgmRemote producmMgmRemote = (ProductMgmRemote) ServiceLocator
				.getInstance()
				.lookupProxy(
						"/edu.esprit.product.mgm.ejb/ProductMgm!edu.esprit.product.mgm.ejb.services.ProductMgmRemote");
		
		return producmMgmRemote.findCategoryProductsLazilly(c);
	}

}
