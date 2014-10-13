package edu.esprit.product.mgm.ejb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity(name = "ProductTAB")//Used for querying entity from JPQL
@Table(name = "tab_product")
@NamedQuery(name ="findAllProduts", query ="select p from ProductTAB p")
public class Product implements Serializable{
	
	@Id
	@Column(name = "ID_PRODUCT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;
	@Column(name = "DESIG_PRODUCT")
	private String designation;
	@Column(name = "SERIAL_PRODUCT")
	private String serialNumber;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CATEGORY_FK")
	private Category category;
	@OneToMany(mappedBy = "product")
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	/** serialVersionUID */
	private static final long serialVersionUID = 5634736912185698142L;
	
	public Product() {
	}
	
	//*********************
	// Getters and Setters
	//*********************
	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	/**
	 * management of both parts of the association
	 * between Product and Category 
	 * 
	 * @param Category: a category to be associated to this product
	 */
	public void associateCategoryToProduct(Category c)
	{
		this.setCategory(c);
		c.getProducts().add(this);
	}

}
