package edu.esprit.product.mgm.ejb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_department")
public class Department implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPT_ID")
	private int idDepartment;
	@Column(name = "DEPT_NAME")
	private String name;
	@OneToMany(mappedBy = "department")
	private List<Administrator> administrators = new ArrayList<Administrator>(); 
	
	public int getIdDepartment() {
		return idDepartment;
	}
	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Administrator> getAdministrators() {
		return administrators;
	}
	public void setAdministrators(List<Administrator> administrators) {
		this.administrators = administrators;
	}
}
