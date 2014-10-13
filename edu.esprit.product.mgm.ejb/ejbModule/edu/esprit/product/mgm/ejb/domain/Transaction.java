package edu.esprit.product.mgm.ejb.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_transaction")
public class Transaction implements Serializable {
	
	@EmbeddedId
	private TransactionPK transactionPK;
	@ManyToOne
	@JoinColumn(name="ID_CUSTOMER", referencedColumnName="ID_USER", insertable=false, updatable=false )
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="ID_PRODUCT", referencedColumnName="ID_PRODUCT", insertable=false, updatable=false)
	private Product product;
	@Column(name = "QUANTITY")
	private int quantity;
	
	
	public TransactionPK getTransactionPK() {
		return transactionPK;
	}
	public void setTransactionPK(TransactionPK transactionPK) {
		this.transactionPK = transactionPK;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Transaction() {
	}
	
	public Transaction(Customer customer, Product product, int quantity) {
		
		super();
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
		this.transactionPK = new TransactionPK(customer.getIdUser(), product.getIdProduct(), new Date());
	}
	
}
