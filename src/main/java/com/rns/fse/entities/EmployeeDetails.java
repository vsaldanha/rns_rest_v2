package com.rns.fse.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details", schema = "rns")
public class EmployeeDetails {
	
	@Id
	@Column(name = "employee_id")
	private int id;
	
	@Column(name = "organization_id")
	private int organizationId;
	
	@Column(name = "employee_name")
	private String employeeName;
	

	@Column(name = "email")
	private String email;

	@Column(name = "ph_number")
	private String phNumber;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "organization_id", insertable = false, updatable = false)
	private OrganizationDetails organizationDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}

	public OrganizationDetails getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationDetails organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

}
