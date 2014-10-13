package edu.esprit.product.mgm.client.utils;

public class BusinessDelegate {

	private static BusinessDelegate myInstance;
	private ProductServiceBusinessDelegate productServiceBusinessDelegate;
	private CategoryServiceBusinessDelegate categoryServiceBusinessDelegate;
	private UsersServiceBusinessDelegate usersServiceBusinessDelegate;
	private CartServiceBusinessDelegate cartServiceBusinessDelegate;

	private BusinessDelegate() {

		productServiceBusinessDelegate = new ProductServiceBusinessDelegate();
		categoryServiceBusinessDelegate = new CategoryServiceBusinessDelegate();
		usersServiceBusinessDelegate = new UsersServiceBusinessDelegate();
		cartServiceBusinessDelegate = new CartServiceBusinessDelegate();
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

	public UsersServiceBusinessDelegate getUsersServiceBusinessDelegate() {
		return usersServiceBusinessDelegate;
	}

	public CartServiceBusinessDelegate getCartServiceBusinessDelegate() {
		return cartServiceBusinessDelegate;
	}
	
}
