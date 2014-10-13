package edu.esprit.product.mgm.ejb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "CUSTOMER_TYPE")
@Table(name = "tab_customer")
public class Customer extends User implements Serializable {
	
	@Column(name = "RIB")
	private String rib;
	@OneToMany(mappedBy = "customer")
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
