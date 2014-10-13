package edu.esprit.product.mgm.ejb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;

/**
 * Entity implementation class for Entity: Category
 * 
 */
@Entity(name = "CetegoryTAB")// Used for querying entity from JPQL
@Table(name = "tab_category")
@NamedQuery(name = "findAllCategories", query = "select c from CetegoryTAB c")
public class Category implements Serializable {

	@Id
	@Column(name = "ID_CATEGORY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategory;
	@Column(name = "DESIG_CATEGORY")
	private String designation;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "category", orphanRemoval = true, fetch = FetchType.LAZY)//Doesn't work with Cascade.REMOVE!
	private List<Product> products = new ArrayList<Product>();

	public Category() {
		super();
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
