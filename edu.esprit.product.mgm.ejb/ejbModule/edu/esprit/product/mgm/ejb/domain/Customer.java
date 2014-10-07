package edu.esprit.product.mgm.ejb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "CUSTOMER_TYPE")
@Table(name = "tab_customer")
public class Customer extends User implements Serializable {
	
	@Column(name = "RIB")
	private String rib;

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}
	
}
