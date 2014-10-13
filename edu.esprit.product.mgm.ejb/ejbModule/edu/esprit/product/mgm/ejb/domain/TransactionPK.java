package edu.esprit.product.mgm.ejb.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class TransactionPK implements Serializable {
	
	@Column(name = "ID_CUSTOMER")
	private int idCustomer;
	@Column(name = "ID_PRODUCT")
	private int idProduct;
	@Column(name = "TRANSACTION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCustomer;
		result = prime * result + idProduct;
		result = prime * result
				+ ((transactionDate == null) ? 0 : transactionDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionPK other = (TransactionPK) obj;
		if (idCustomer != other.idCustomer)
			return false;
		if (idProduct != other.idProduct)
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		return true;
	}
	
	public TransactionPK() {
	}
	
	public TransactionPK(int idCustomer, int idProduct, Date transactionDate) {
		super();
		this.idCustomer = idCustomer;
		this.idProduct = idProduct;
		this.transactionDate = transactionDate;
	}
	
	

}
