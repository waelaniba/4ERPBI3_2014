package edu.esprit.product.mgm.ejb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //DEFAULT
@DiscriminatorColumn(name = "USER_DESCRIMINATOR", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value = "USER_TYPE")
//@MappedSuperclass
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Must use Table with table per class inheritance strategy
	@Column(name = "ID_USER")
	private int idUser;
	@Column(name = "FN_USER")
	private String firstName;
	@Column(name = "LN_USER")
	private String lastName;
	@Column(name = "EMAIL_USER")
	private String email;
	@Column(name = "PWD_USER")
	private String password;
	@Column(name = "PHONE_USER")
	private String phoneNumber;
	@OneToOne
	@JoinColumn(name = "ADDRESS_FK")
	private Address address;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

}
