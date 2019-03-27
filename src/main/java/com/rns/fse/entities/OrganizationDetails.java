package com.rns.fse.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organization_details", schema = "rns")
public class OrganizationDetails {
	
	@Id
	@Column(name = "organization_id")
	private String id;
	
	@Column(name = "organization_name")
	private String organizationName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "hr_email")
	private String hrEmail;

	@Column(name = "hr_ph_number")
	private String hrPhNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHrEmail() {
		return hrEmail;
	}

	public void setHrEmail(String hrEmail) {
		this.hrEmail = hrEmail;
	}

	public String getHrPhNumber() {
		return hrPhNumber;
	}

	public void setHrPhNumber(String hrPhNumber) {
		this.hrPhNumber = hrPhNumber;
	}


}
