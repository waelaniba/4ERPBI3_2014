package edu.esprit.product.mgm.ejb.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tab_admin")
@DiscriminatorValue(value = "ADMIN_TYPE")
public class Administrator extends User implements Serializable {
	
	@Temporal(TemporalType.DATE)
	@Column(name = "REC_DATE")
	private Date recruitementDate;

	public Date getRecruitementDate() {
		return recruitementDate;
	}

	public void setRecruitementDate(Date recruitementDate) {
		this.recruitementDate = recruitementDate;
	}
	
}
