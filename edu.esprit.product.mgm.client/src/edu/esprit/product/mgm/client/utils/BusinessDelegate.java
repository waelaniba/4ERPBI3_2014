package edu.esprit.product.mgm.client.utils;

public class BusinessDelegate {

	private static BusinessDelegate myInstance;
	private ProductServiceBusinessDelegate productServiceBusinessDelegate;
	private CategoryServiceBusinessDelegate categoryServiceBusinessDelegate;

	private BusinessDelegate() {

		productServiceBusinessDelegate = new ProductServiceBusinessDelegate();
		categoryServiceBusinessDelegate = new CategoryServiceBusinessDelegate();
	}

	public static BusinessDelegate getInstance() {

		if (null == myInstance)
			myInstance = new BusinessDelegate();

		return myInstance;
	}

	public ProductServiceBusinessDelegate getProductServiceBusinessDelegate() {
		return productServiceBusinessDelegate;
	}

	public CategoryServiceBusinessDelegate getCategoryServiceBusinessDelegate() {
		return categoryServiceBusinessDelegate;
	}
	
}
